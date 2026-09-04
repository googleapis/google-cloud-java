/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ticker;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.collect.ImmutableSet;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.Durations;
import com.google.rpc.RetryInfo;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteBatchDmlRequest;
import com.google.spanner.v1.ExecuteBatchDmlResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.RollbackRequest;
import com.google.spanner.v1.Transaction;
import com.google.spanner.v1.TransactionSelector;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener.SimpleForwardingClientCallListener;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.protobuf.StatusProto;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.time.Duration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * ManagedChannel that routes eligible Spanner requests using location-aware routing hints and
 * transaction affinity.
 *
 * <p>Routing hints are applied to streaming read/query, unary Read, and unary ExecuteSql.
 * Mutation-based BeginTransaction and Commit requests also carry routing hints when recipes are
 * available. Other eligible methods use transaction affinity when their request contains a {@code
 * TransactionSelector} or {@code transaction_id}. PartitionQuery, PartitionRead, BatchWrite,
 * FetchCacheUpdate, CreateSession, BatchCreateSessions, GetSession, ListSessions, and DeleteSession
 * always use the default channel.
 */
@InternalApi
final class KeyAwareChannel extends ManagedChannel {

  private static final Logger logger = Logger.getLogger(KeyAwareChannel.class.getName());

  private static final long MAX_TRACKED_TRANSACTION_AFFINITIES = 100_000L;
  private static final long TRANSACTION_AFFINITY_TTL_MINUTES = 10L;
  private static final int CHANNEL_FINDER_CLEANUP_INTERVAL = 1024;
  private static final String SPANNER_METHOD_PREFIX = "google.spanner.v1.Spanner/";
  private static final Set<String> DEFAULT_CHANNEL_METHODS =
      ImmutableSet.of(
          SPANNER_METHOD_PREFIX + "PartitionQuery",
          SPANNER_METHOD_PREFIX + "PartitionRead",
          SPANNER_METHOD_PREFIX + "BatchWrite",
          SPANNER_METHOD_PREFIX + "FetchCacheUpdate",
          SPANNER_METHOD_PREFIX + "CreateSession",
          SPANNER_METHOD_PREFIX + "BatchCreateSessions",
          SPANNER_METHOD_PREFIX + "GetSession",
          SPANNER_METHOD_PREFIX + "ListSessions",
          SPANNER_METHOD_PREFIX + "DeleteSession");
  private static final Metadata.Key<RetryInfo> RETRY_INFO_KEY =
      ProtoUtils.keyForProto(RetryInfo.getDefaultInstance());
  private static final Map<Descriptor, ReflectionFields> REFLECTION_FIELDS =
      new ConcurrentHashMap<>();

  private final ManagedChannel defaultChannel;
  private final ChannelEndpointCache endpointCache;
  @Nullable private final EndpointLifecycleManager lifecycleManager;
  private final String authority;
  private final String defaultEndpointAddress;
  private final ReferenceQueue<ChannelFinder> channelFinderReferenceQueue = new ReferenceQueue<>();
  private final Map<String, ChannelFinderReference> channelFinders = new ConcurrentHashMap<>();
  private final Set<String> learnedDefaultChannelMethods = ConcurrentHashMap.newKeySet();
  private final AtomicInteger channelFinderCleanupCounter = new AtomicInteger();
  // Maps read-write transaction IDs to their last routed endpoint.
  // Bound and age out entries in case application code abandons a transaction
  // without sending Commit/Rollback or otherwise clearing affinity.
  private final Cache<ByteString, String> transactionAffinities;
  private final EndpointOverloadCooldownTracker endpointOverloadCooldowns;

  private KeyAwareChannel(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory,
      @Nullable GrpcGcpEndpointChannelConfigurator endpointChannelConfigurator)
      throws IOException {
    this(
        channelProvider,
        endpointCacheFactory,
        endpointChannelConfigurator,
        new EndpointOverloadCooldownTracker(),
        Ticker.systemTicker());
  }

  private KeyAwareChannel(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory,
      @Nullable GrpcGcpEndpointChannelConfigurator endpointChannelConfigurator,
      EndpointOverloadCooldownTracker endpointOverloadCooldowns,
      Ticker transactionAffinityTicker)
      throws IOException {
    if (endpointCacheFactory == null) {
      this.endpointCache =
          new GrpcChannelEndpointCache(channelProvider, endpointChannelConfigurator);
    } else {
      this.endpointCache = endpointCacheFactory.create(channelProvider);
    }
    this.defaultChannel = endpointCache.defaultChannel().getChannel();
    this.defaultEndpointAddress = endpointCache.defaultChannel().getAddress();
    this.authority = this.defaultChannel.authority();
    // Only create lifecycle manager for production (non-factory) path.
    // Factory path is used by tests with custom caches where background probing
    // would interfere with test assertions.
    this.lifecycleManager =
        (endpointCacheFactory == null) ? new EndpointLifecycleManager(endpointCache) : null;
    this.endpointOverloadCooldowns = endpointOverloadCooldowns;
    this.transactionAffinities = newTransactionAffinities(transactionAffinityTicker);
  }

  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory)
      throws IOException {
    return new KeyAwareChannel(channelProvider, endpointCacheFactory, null);
  }

  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory,
      @Nullable GrpcGcpEndpointChannelConfigurator endpointChannelConfigurator)
      throws IOException {
    return new KeyAwareChannel(channelProvider, endpointCacheFactory, endpointChannelConfigurator);
  }

  @VisibleForTesting
  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory,
      EndpointOverloadCooldownTracker endpointOverloadCooldowns)
      throws IOException {
    return create(
        channelProvider, endpointCacheFactory, endpointOverloadCooldowns, Ticker.systemTicker());
  }

  @VisibleForTesting
  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory,
      EndpointOverloadCooldownTracker endpointOverloadCooldowns,
      Ticker transactionAffinityTicker)
      throws IOException {
    return new KeyAwareChannel(
        channelProvider,
        endpointCacheFactory,
        null,
        endpointOverloadCooldowns,
        transactionAffinityTicker);
  }

  private static Cache<ByteString, String> newTransactionAffinities(Ticker ticker) {
    return CacheBuilder.newBuilder()
        .maximumSize(MAX_TRACKED_TRANSACTION_AFFINITIES)
        .expireAfterAccess(TRANSACTION_AFFINITY_TTL_MINUTES, TimeUnit.MINUTES)
        .ticker(ticker)
        .build();
  }

  private static final class ChannelFinderReference extends SoftReference<ChannelFinder> {
    final String databaseId;

    ChannelFinderReference(
        String databaseId,
        ChannelFinder referent,
        ReferenceQueue<? super ChannelFinder> referenceQueue) {
      super(referent, referenceQueue);
      this.databaseId = databaseId;
    }
  }

  private String extractDatabaseIdFromSession(String session) {
    if (session == null || session.isEmpty()) {
      return null;
    }
    int sessionsIndex = session.indexOf("/sessions/");
    if (sessionsIndex == -1) {
      return null;
    }
    return session.substring(0, sessionsIndex);
  }

  private void cleanupStaleChannelFinders() {
    ChannelFinderReference reference;
    while ((reference = (ChannelFinderReference) channelFinderReferenceQueue.poll()) != null) {
      if (channelFinders.remove(reference.databaseId, reference) && lifecycleManager != null) {
        lifecycleManager.unregisterFinder(reference.databaseId);
      }
    }
  }

  private void maybeCleanupStaleChannelFinders() {
    if ((channelFinderCleanupCounter.incrementAndGet() & (CHANNEL_FINDER_CLEANUP_INTERVAL - 1))
        == 0) {
      cleanupStaleChannelFinders();
    }
  }

  private ChannelFinder getOrCreateChannelFinder(String databaseId) {
    maybeCleanupStaleChannelFinders();
    ChannelFinderReference ref = channelFinders.get(databaseId);
    ChannelFinder finder = (ref != null) ? ref.get() : null;
    if (finder == null) {
      synchronized (channelFinders) {
        ref = channelFinders.get(databaseId);
        finder = (ref != null) ? ref.get() : null;
        if (finder == null) {
          finder = new ChannelFinder(endpointCache, lifecycleManager, databaseId);
          channelFinders.put(
              databaseId,
              new ChannelFinderReference(databaseId, finder, channelFinderReferenceQueue));
        }
      }
    }
    return finder;
  }

  @com.google.common.annotations.VisibleForTesting
  void awaitPendingCacheUpdates() throws InterruptedException {
    for (ChannelFinderReference ref : channelFinders.values()) {
      ChannelFinder finder = ref.get();
      if (finder != null) {
        finder.awaitPendingUpdates();
      }
    }
  }

  /** Records real traffic to the selected endpoint for idle eviction tracking. */
  private void onRequestRouted(@Nullable ChannelEndpoint selectedEndpoint) {
    if (lifecycleManager == null) {
      return;
    }
    if (selectedEndpoint != null && !defaultEndpointAddress.equals(selectedEndpoint.getAddress())) {
      lifecycleManager.recordRealTraffic(selectedEndpoint.getAddress());
    }
  }

  @Override
  public ManagedChannel shutdown() {
    cleanupStaleChannelFinders();
    if (lifecycleManager != null) {
      lifecycleManager.shutdown();
    }
    endpointCache.shutdown();
    return this;
  }

  @Override
  public ManagedChannel shutdownNow() {
    cleanupStaleChannelFinders();
    if (lifecycleManager != null) {
      lifecycleManager.shutdown();
    }
    endpointCache.shutdown();
    return this;
  }

  @Override
  public boolean isTerminated() {
    return defaultChannel.isTerminated();
  }

  @Override
  public boolean isShutdown() {
    return defaultChannel.isShutdown();
  }

  @Override
  public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
    return defaultChannel.awaitTermination(timeout, unit);
  }

  @Override
  public String authority() {
    return authority;
  }

  @Override
  public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
      MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
    if (isKeyAware(methodDescriptor)) {
      return new KeyAwareClientCall<>(this, methodDescriptor, callOptions);
    }
    return defaultChannel.newCall(methodDescriptor, callOptions);
  }

  private static boolean isKeyAware(MethodDescriptor<?, ?> methodDescriptor) {
    String method = methodDescriptor.getFullMethodName();
    return method.startsWith(SPANNER_METHOD_PREFIX) && !DEFAULT_CHANNEL_METHODS.contains(method);
  }

  @VisibleForTesting
  static Set<String> defaultChannelMethods() {
    return DEFAULT_CHANNEL_METHODS;
  }

  private boolean isLearnedDefaultChannelMethod(String method) {
    return learnedDefaultChannelMethods.contains(method);
  }

  private void learnDefaultChannelMethod(String method) {
    if (learnedDefaultChannelMethods.add(method)) {
      logger.log(
          Level.INFO,
          "Method {0} is not implemented on a location-aware endpoint; using the default channel",
          method);
    }
  }

  @Nullable
  private ChannelEndpoint affinityEndpoint(
      ByteString transactionId, Predicate<String> excludedEndpoints) {
    if (transactionId == null || transactionId.isEmpty()) {
      return null;
    }
    String address = transactionAffinities.getIfPresent(transactionId);
    if (address == null || excludedEndpoints.test(address)) {
      return null;
    }
    // Use non-creating lookup and require READY state for location-aware routing.
    ChannelEndpoint endpoint = endpointCache.getIfPresent(address);
    if (endpoint == null) {
      logger.log(
          Level.FINE,
          "Affinity endpoint for address {0} not present in cache, falling back to default",
          address);
      return null;
    }
    if (!endpoint.isHealthy()) {
      logger.log(
          Level.FINE,
          "Affinity endpoint for address {0} not READY, falling back to default",
          address);
      return null;
    }
    return endpoint;
  }

  private void clearAffinity(ByteString transactionId) {
    if (transactionId == null || transactionId.isEmpty()) {
      return;
    }
    transactionAffinities.invalidate(transactionId);
  }

  private void recordEndpointCooldown(
      @Nullable ChannelEndpoint endpoint,
      io.grpc.Status.Code statusCode,
      @Nullable Metadata trailers) {
    if (endpoint == null) {
      return;
    }
    String address = endpoint.getAddress();
    if (defaultEndpointAddress.equals(address)) {
      return;
    }
    endpointOverloadCooldowns.recordFailure(address, statusCode, retryDelay(statusCode, trailers));
  }

  private void recordEndpointSuccess(@Nullable ChannelEndpoint endpoint) {
    if (endpoint == null) {
      return;
    }
    String address = endpoint.getAddress();
    if (!defaultEndpointAddress.equals(address)) {
      endpointOverloadCooldowns.recordSuccess(address);
    }
  }

  @Nullable
  @VisibleForTesting
  static Duration retryDelay(io.grpc.Status.Code statusCode, @Nullable Metadata trailers) {
    if (trailers == null) {
      return null;
    }
    Duration retryDelay = null;
    try {
      retryDelay = retryDelay(trailers.get(RETRY_INFO_KEY));
    } catch (IllegalArgumentException ignored) {
      // Treat malformed direct details as absent.
    }
    try {
      com.google.rpc.Status richStatus =
          StatusProto.fromStatusAndTrailers(io.grpc.Status.fromCode(statusCode), trailers);
      if (richStatus != null) {
        for (Any detail : richStatus.getDetailsList()) {
          if (!detail.is(RetryInfo.class)) {
            continue;
          }
          try {
            Duration candidate = retryDelay(detail.unpack(RetryInfo.class));
            if (candidate != null && (retryDelay == null || candidate.compareTo(retryDelay) > 0)) {
              retryDelay = candidate;
            }
          } catch (InvalidProtocolBufferException ignored) {
            // Skip malformed details without hiding later valid RetryInfo details.
          }
        }
      }
    } catch (IllegalArgumentException ignored) {
      // Malformed rich status metadata must not interfere with transport close handling.
    }
    return retryDelay;
  }

  @Nullable
  private static Duration retryDelay(@Nullable RetryInfo retryInfo) {
    if (retryInfo == null
        || !retryInfo.hasRetryDelay()
        || !Durations.isValid(retryInfo.getRetryDelay())
        || Durations.isNegative(retryInfo.getRetryDelay())) {
      return null;
    }
    return Duration.ofSeconds(
        retryInfo.getRetryDelay().getSeconds(), retryInfo.getRetryDelay().getNanos());
  }

  private void maybeRecordErrorPenalty(
      @Nullable String databaseScope,
      @Nullable ChannelEndpoint endpoint,
      io.grpc.Status.Code statusCode,
      long operationUid,
      boolean preferLeader) {
    if (!shouldExcludeEndpointOnRetry(statusCode) || endpoint == null || operationUid <= 0L) {
      return;
    }
    String address = endpoint.getAddress();
    if (defaultEndpointAddress.equals(address)) {
      return;
    }
    EndpointLatencyRegistry.recordError(databaseScope, operationUid, preferLeader, address);
  }

  private static boolean shouldExcludeEndpointOnRetry(io.grpc.Status.Code statusCode) {
    return statusCode == io.grpc.Status.Code.RESOURCE_EXHAUSTED
        || statusCode == io.grpc.Status.Code.UNAVAILABLE;
  }

  @VisibleForTesting
  boolean isCoolingDown(String address) {
    return endpointOverloadCooldowns.isCoolingDown(address);
  }

  private void recordAffinity(
      ByteString transactionId, @Nullable ChannelEndpoint endpoint, boolean allowDefault) {
    if (transactionId == null || transactionId.isEmpty() || endpoint == null) {
      return;
    }
    String address = endpoint.getAddress();
    if (!allowDefault && defaultEndpointAddress.equals(address)) {
      return;
    }
    transactionAffinities.put(transactionId, address);
  }

  private static ByteString transactionIdFromSelector(TransactionSelector selector) {
    if (selector.getSelectorCase() == TransactionSelector.SelectorCase.ID) {
      return selector.getId();
    }
    return ByteString.EMPTY;
  }

  /**
   * Reflection helpers resolve and cache relevant fields once per protobuf descriptor. Typed RPC
   * paths do not call these helpers; generic requests and responses reuse cached descriptors and
   * never enumerate populated fields per message.
   */
  private static ReflectionFields reflectionFields(Message message) {
    Descriptor descriptor = message.getDescriptorForType();
    ReflectionFields fields = REFLECTION_FIELDS.get(descriptor);
    if (fields != null) {
      return fields;
    }
    ReflectionFields created = new ReflectionFields(descriptor);
    ReflectionFields existing = REFLECTION_FIELDS.putIfAbsent(descriptor, created);
    return existing == null ? created : existing;
  }

  @Nullable
  private static TransactionSelector transactionSelectorFromGenericRequest(Object request) {
    if (!(request instanceof Message)) {
      return null;
    }
    Message message = (Message) request;
    FieldDescriptor field = reflectionFields(message).transactionSelectorField;
    if (field == null || !message.hasField(field)) {
      return null;
    }
    Object value = message.getField(field);
    if (value instanceof TransactionSelector) {
      return (TransactionSelector) value;
    }
    if (value instanceof Message) {
      Message selector = (Message) value;
      try {
        if (selector.getDescriptorForType() == TransactionSelector.getDescriptor()) {
          return TransactionSelector.newBuilder().mergeFrom(selector).build();
        }
        return TransactionSelector.parseFrom(selector.toByteString());
      } catch (InvalidProtocolBufferException e) {
        return null;
      }
    }
    return null;
  }

  private static ByteString transactionIdFieldFromGenericRequest(Object request) {
    if (!(request instanceof Message)) {
      return ByteString.EMPTY;
    }
    Message message = (Message) request;
    FieldDescriptor field = reflectionFields(message).transactionIdField;
    if (field == null) {
      return ByteString.EMPTY;
    }
    Object value = message.getField(field);
    return value instanceof ByteString ? (ByteString) value : ByteString.EMPTY;
  }

  @Nullable
  private static ByteString transactionIdFromGenericResponse(Object response) {
    if (!(response instanceof Message)) {
      return null;
    }
    Message message = (Message) response;
    ReflectionFields fields = reflectionFields(message);
    ByteString transactionId =
        transactionIdFromReflectedTransactionField(message, fields.transactionField);
    if (transactionId != null) {
      return transactionId;
    }
    FieldDescriptor metadataField = fields.metadataField;
    if (metadataField == null || !message.hasField(metadataField)) {
      return null;
    }
    Object metadata = message.getField(metadataField);
    if (!(metadata instanceof Message)) {
      return null;
    }
    Message metadataMessage = (Message) metadata;
    return transactionIdFromReflectedTransactionField(
        metadataMessage, reflectionFields(metadataMessage).transactionField);
  }

  @Nullable
  private static ByteString transactionIdFromReflectedTransactionField(
      Message message, @Nullable FieldDescriptor field) {
    if (field == null || !message.hasField(field)) {
      return null;
    }
    return transactionIdFromReflectedTransaction(message.getField(field));
  }

  @Nullable
  private static ByteString transactionIdFromReflectedTransaction(Object value) {
    if (value instanceof Transaction) {
      return transactionIdFromTransaction((Transaction) value);
    }
    if (!(value instanceof Message)) {
      return null;
    }
    Message transaction = (Message) value;
    FieldDescriptor idField = reflectionFields(transaction).transactionMessageIdField;
    if (idField == null) {
      return null;
    }
    Object id = transaction.getField(idField);
    return id instanceof ByteString && !((ByteString) id).isEmpty() ? (ByteString) id : null;
  }

  private static boolean isMessageFieldOfType(@Nullable FieldDescriptor field, String messageType) {
    return field != null
        && !field.isRepeated()
        && field.getJavaType() == FieldDescriptor.JavaType.MESSAGE
        && field.getMessageType().getFullName().equals(messageType);
  }

  private static final class ReflectionFields {
    @Nullable private final FieldDescriptor transactionSelectorField;
    @Nullable private final FieldDescriptor transactionIdField;
    @Nullable private final FieldDescriptor transactionField;
    @Nullable private final FieldDescriptor metadataField;
    @Nullable private final FieldDescriptor transactionMessageIdField;

    private ReflectionFields(Descriptor descriptor) {
      FieldDescriptor transaction = descriptor.findFieldByName("transaction");
      this.transactionSelectorField =
          isMessageFieldOfType(transaction, TransactionSelector.getDescriptor().getFullName())
              ? transaction
              : null;
      this.transactionField =
          isMessageFieldOfType(transaction, Transaction.getDescriptor().getFullName())
              ? transaction
              : null;
      FieldDescriptor transactionId = descriptor.findFieldByName("transaction_id");
      this.transactionIdField =
          transactionId != null
                  && !transactionId.isRepeated()
                  && transactionId.getJavaType() == FieldDescriptor.JavaType.BYTE_STRING
              ? transactionId
              : null;
      FieldDescriptor metadata = descriptor.findFieldByName("metadata");
      this.metadataField =
          isMessageFieldOfType(metadata, ResultSetMetadata.getDescriptor().getFullName())
              ? metadata
              : null;
      FieldDescriptor id = descriptor.findFieldByName("id");
      this.transactionMessageIdField =
          id != null && !id.isRepeated() && id.getJavaType() == FieldDescriptor.JavaType.BYTE_STRING
              ? id
              : null;
    }
  }

  @Nullable
  private static ByteString transactionIdFromMetadata(PartialResultSet result) {
    if (result.hasMetadata()) {
      return transactionIdFromTransaction(result.getMetadata().getTransaction());
    }
    return null;
  }

  @Nullable
  private static ByteString transactionIdFromMetadata(ResultSet result) {
    if (result.hasMetadata()) {
      return transactionIdFromTransaction(result.getMetadata().getTransaction());
    }
    return null;
  }

  @Nullable
  private static ByteString transactionIdFromTransaction(Transaction transaction) {
    if (transaction != null && !transaction.getId().isEmpty()) {
      return transaction.getId();
    }
    return null;
  }

  private static void recordRouteSelectionTrace(
      MethodDescriptor<?, ?> methodDescriptor,
      String target,
      boolean usedDefaultEndpoint,
      boolean hasChannelFinder) {
    Span span = Span.current();
    if (!span.getSpanContext().isValid()) {
      return;
    }
    span.setAttribute("spanner.target", target);
    span.setAttribute("spanner.route.used_default_endpoint", usedDefaultEndpoint);
    span.setAttribute("spanner.route.has_channel_finder", hasChannelFinder);
    span.setAttribute("spanner.route.method", methodDescriptor.getFullMethodName());
    span.addEvent(
        "spanner.route.selected",
        Attributes.builder()
            .put("spanner.target", target)
            .put("spanner.route.used_default_endpoint", usedDefaultEndpoint)
            .put("spanner.route.has_channel_finder", hasChannelFinder)
            .put("spanner.route.method", methodDescriptor.getFullMethodName())
            .build());
  }

  static final class KeyAwareClientCall<RequestT, ResponseT>
      extends ForwardingClientCall<RequestT, ResponseT> {
    private final KeyAwareChannel parentChannel;
    private final MethodDescriptor<RequestT, ResponseT> methodDescriptor;
    private final CallOptions callOptions;
    @Nullable private final String logicalRequestKey;
    private Listener<ResponseT> responseListener;
    private Metadata headers;
    @Nullable private ClientCall<RequestT, ResponseT> delegate;
    private ChannelFinder channelFinder;
    @Nullable private Predicate<String> excludedEndpoints;
    @Nullable private ChannelEndpoint selectedEndpoint;
    @Nullable private String selectedTargetEndpoint;
    @Nullable private String selectedDatabaseScope;
    private long selectedOperationUid;
    private boolean selectedPreferLeader;
    @Nullable private ByteString transactionIdToClear;
    private boolean allowDefaultAffinity;
    private long pendingRequests;
    private long outstandingRequests;
    private boolean pendingHalfClose;
    private boolean halfClosed;
    @Nullable private Boolean messageCompression;
    @Nullable private io.grpc.Status cancelledStatus;
    @Nullable private Metadata cancelledTrailers;
    private boolean shouldRecordTransactionAffinity;
    private boolean genericRequest;
    private boolean reroutedToDefault;
    private boolean responseMessageReceived;
    @Nullable private RequestT genericRequestMessage;
    private final Object lock = new Object();

    KeyAwareClientCall(
        KeyAwareChannel parentChannel,
        MethodDescriptor<RequestT, ResponseT> methodDescriptor,
        CallOptions callOptions) {
      this.parentChannel = parentChannel;
      this.methodDescriptor = methodDescriptor;
      this.callOptions = callOptions;
      XGoogSpannerRequestId requestId = callOptions.getOption(REQUEST_ID_CALL_OPTIONS_KEY);
      this.logicalRequestKey = requestId == null ? null : requestId.getLogicalRequestKey();
    }

    @Override
    protected ClientCall<RequestT, ResponseT> delegate() {
      synchronized (lock) {
        if (delegate == null) {
          throw new IllegalStateException(
              "Delegate call not initialized before use. sendMessage was likely not called.");
        }
        return delegate;
      }
    }

    @Override
    public void start(Listener<ResponseT> responseListener, Metadata headers) {
      Listener<ResponseT> listenerToClose = null;
      io.grpc.Status statusToClose = null;
      Metadata trailersToClose = null;
      synchronized (lock) {
        this.responseListener = new KeyAwareClientCallListener<>(responseListener, this);
        this.headers = headers;
        if (this.cancelledStatus != null) {
          listenerToClose = this.responseListener;
          statusToClose = this.cancelledStatus;
          trailersToClose =
              this.cancelledTrailers == null ? new Metadata() : this.cancelledTrailers;
        }
      }
      if (listenerToClose != null) {
        listenerToClose.onClose(statusToClose, trailersToClose);
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void sendMessage(RequestT message) {
      synchronized (lock) {
        if (this.cancelledStatus != null) {
          return;
        }
        if (responseListener == null || headers == null) {
          throw new IllegalStateException("start must be called before sendMessage");
        }
        Predicate<String> excludedEndpoints = excludedEndpoints();
        ChannelEndpoint endpoint = null;
        ChannelFinder finder = null;
        String databaseScope = null;
        long operationUid = 0L;
        boolean preferLeader = false;

        if (message instanceof ReadRequest) {
          ReadRequest.Builder reqBuilder = ((ReadRequest) message).toBuilder();
          maybeTrackReadWriteBegin(reqBuilder.getTransaction());
          RoutingDecision routing = routeFromRequest(reqBuilder);
          finder = routing.finder;
          endpoint = routing.endpoint;
          databaseScope = routing.databaseScope;
          operationUid = routing.operationUid;
          preferLeader = routing.preferLeader;
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof ExecuteSqlRequest) {
          ExecuteSqlRequest.Builder reqBuilder = ((ExecuteSqlRequest) message).toBuilder();
          maybeTrackReadWriteBegin(reqBuilder.getTransaction());
          RoutingDecision routing = routeFromRequest(reqBuilder);
          finder = routing.finder;
          endpoint = routing.endpoint;
          databaseScope = routing.databaseScope;
          operationUid = routing.operationUid;
          preferLeader = routing.preferLeader;
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof BeginTransactionRequest) {
          BeginTransactionRequest.Builder reqBuilder =
              ((BeginTransactionRequest) message).toBuilder();
          String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
          if (databaseId != null) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
            databaseScope = databaseId;
          }
          if (finder != null && reqBuilder.hasMutationKey()) {
            endpoint = finder.findServer(reqBuilder, excludedEndpoints);
          }
          if (reqBuilder.hasOptions() && reqBuilder.getOptions().hasReadOnly()) {
            shouldRecordTransactionAffinity = false;
          } else {
            shouldRecordTransactionAffinity = true;
            allowDefaultAffinity = true;
          }
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof CommitRequest) {
          CommitRequest request = (CommitRequest) message;
          String databaseId = parentChannel.extractDatabaseIdFromSession(request.getSession());
          if (databaseId != null) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
            databaseScope = databaseId;
          }
          CommitRequest.Builder reqBuilder = null;
          if (finder != null && request.getMutationsCount() > 0) {
            reqBuilder = request.toBuilder();
            endpoint = finder.fillRoutingHint(reqBuilder, excludedEndpoints);
            request = reqBuilder.build();
          }
          if (!request.getTransactionId().isEmpty()) {
            ChannelEndpoint affinityEndpoint =
                parentChannel.affinityEndpoint(request.getTransactionId(), excludedEndpoints);
            if (affinityEndpoint != null) {
              endpoint = affinityEndpoint;
            }
            transactionIdToClear = request.getTransactionId();
          }
          if (reqBuilder != null) {
            message = (RequestT) request;
          }
        } else if (message instanceof RollbackRequest) {
          RollbackRequest request = (RollbackRequest) message;
          if (!request.getTransactionId().isEmpty()) {
            endpoint =
                parentChannel.affinityEndpoint(request.getTransactionId(), excludedEndpoints);
            transactionIdToClear = request.getTransactionId();
          }
        } else if (message instanceof ExecuteBatchDmlRequest) {
          ExecuteBatchDmlRequest request = (ExecuteBatchDmlRequest) message;
          String databaseId = parentChannel.extractDatabaseIdFromSession(request.getSession());
          if (databaseId != null) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
            databaseScope = databaseId;
          }
          maybeTrackReadWriteBegin(request.getTransaction());
          endpoint = routeFromRequest(request);
        } else {
          genericRequest = true;
          genericRequestMessage = message;
          boolean useDefault =
              parentChannel.isLearnedDefaultChannelMethod(methodDescriptor.getFullMethodName());
          TransactionSelector selector = transactionSelectorFromGenericRequest(message);
          if (selector != null) {
            maybeTrackReadWriteBegin(selector);
            if (!useDefault) {
              endpoint =
                  parentChannel.affinityEndpoint(
                      transactionIdFromSelector(selector), excludedEndpoints);
            }
          } else if (!useDefault) {
            endpoint =
                parentChannel.affinityEndpoint(
                    transactionIdFieldFromGenericRequest(message), excludedEndpoints);
          }
        }

        if (endpoint == null) {
          endpoint = parentChannel.endpointCache.defaultChannel();
        }
        if (endpoint == null) {
          throw new IllegalStateException("No default endpoint available for key-aware call");
        }
        selectedEndpoint = endpoint;
        selectedTargetEndpoint = endpoint.getAddress();
        selectedDatabaseScope = databaseScope != null ? databaseScope : routingScope(finder);
        selectedOperationUid = operationUid;
        selectedPreferLeader = preferLeader;
        this.channelFinder = finder;
        selectedEndpoint.incrementActiveRequests();
        XGoogSpannerRequestId requestId = callOptions.getOption(REQUEST_ID_CALL_OPTIONS_KEY);
        if (requestId != null) {
          RequestIdTargetTracker.record(
              requestId.getHeaderValue(),
              selectedDatabaseScope,
              selectedTargetEndpoint,
              operationUid,
              selectedPreferLeader);
        }

        // Record real traffic for idle eviction tracking.
        parentChannel.onRequestRouted(endpoint);

        recordRouteSelectionTrace(
            methodDescriptor,
            endpoint.getAddress(),
            parentChannel.defaultEndpointAddress.equals(endpoint.getAddress()),
            finder != null);
        delegate = endpoint.getChannel().newCall(methodDescriptor, callOptions);
        if (messageCompression != null) {
          delegate.setMessageCompression(messageCompression);
        }
        delegate.start(responseListener, headers);
        drainPendingRequests();
        delegate.sendMessage(message);
        if (pendingHalfClose) {
          delegate.halfClose();
        }
      }
    }

    @Override
    public void halfClose() {
      ClientCall<RequestT, ResponseT> currentDelegate;
      synchronized (lock) {
        if (this.cancelledStatus != null) {
          return;
        }
        halfClosed = true;
        if (delegate == null) {
          pendingHalfClose = true;
          return;
        }
        currentDelegate = delegate;
      }
      currentDelegate.halfClose();
    }

    @Override
    public void cancel(@Nullable String message, @Nullable Throwable cause) {
      ClientCall<RequestT, ResponseT> currentDelegate;
      Listener<ResponseT> listenerToClose = null;
      io.grpc.Status statusToClose = null;
      Metadata trailersToClose = null;
      synchronized (lock) {
        currentDelegate = delegate;
        if (currentDelegate == null) {
          cancelledStatus = io.grpc.Status.CANCELLED.withDescription(message).withCause(cause);
          Metadata trailers =
              cause == null ? new Metadata() : io.grpc.Status.trailersFromThrowable(cause);
          cancelledTrailers = trailers == null ? new Metadata() : trailers;
          if (responseListener != null) {
            listenerToClose = responseListener;
            statusToClose = cancelledStatus;
            trailersToClose = cancelledTrailers;
          }
        }
      }
      if (currentDelegate != null) {
        currentDelegate.cancel(message, cause);
      } else if (listenerToClose != null) {
        listenerToClose.onClose(statusToClose, trailersToClose);
      }
    }

    @Override
    public void request(int numMessages) {
      ClientCall<RequestT, ResponseT> currentDelegate;
      synchronized (lock) {
        if (cancelledStatus != null) {
          return;
        }
        if (numMessages > 0) {
          outstandingRequests = saturatedAdd(outstandingRequests, numMessages);
        }
        if (delegate != null) {
          currentDelegate = delegate;
        } else {
          if (numMessages <= 0) {
            return;
          }
          long updated = pendingRequests + numMessages;
          if (updated < 0L) {
            updated = Long.MAX_VALUE;
          }
          pendingRequests = updated;
          return;
        }
      }
      currentDelegate.request(numMessages);
    }

    @Override
    public boolean isReady() {
      ClientCall<RequestT, ResponseT> currentDelegate;
      synchronized (lock) {
        currentDelegate = delegate;
      }
      if (currentDelegate == null) {
        return false;
      }
      return currentDelegate.isReady();
    }

    @Override
    public void setMessageCompression(boolean enabled) {
      ClientCall<RequestT, ResponseT> currentDelegate;
      synchronized (lock) {
        if (cancelledStatus != null) {
          return;
        }
        messageCompression = enabled;
        if (delegate != null) {
          currentDelegate = delegate;
        } else {
          return;
        }
      }
      currentDelegate.setMessageCompression(enabled);
    }

    private void drainPendingRequests() {
      ClientCall<RequestT, ResponseT> currentDelegate = delegate;
      if (currentDelegate == null) {
        return;
      }
      long requests = pendingRequests;
      pendingRequests = 0L;
      requestMessages(currentDelegate, requests);
    }

    private static void requestMessages(ClientCall<?, ?> currentDelegate, long requests) {
      while (requests > 0) {
        int batch = requests > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) requests;
        currentDelegate.request(batch);
        requests -= batch;
      }
    }

    private static long saturatedAdd(long current, int increment) {
      long updated = current + increment;
      return updated < 0L ? Long.MAX_VALUE : updated;
    }

    void onResponseMessage() {
      synchronized (lock) {
        responseMessageReceived = true;
        if (outstandingRequests > 0L) {
          outstandingRequests--;
        }
      }
    }

    boolean maybeRerouteUnimplementedGenericCall(io.grpc.Status status) {
      if (status.getCode() != io.grpc.Status.Code.UNIMPLEMENTED) {
        return false;
      }
      synchronized (lock) {
        if (!genericRequest
            || reroutedToDefault
            || responseMessageReceived
            || selectedEndpoint == null
            || parentChannel.defaultEndpointAddress.equals(selectedEndpoint.getAddress())
            || genericRequestMessage == null
            || cancelledStatus != null) {
          return false;
        }
        ChannelEndpoint defaultEndpoint = parentChannel.endpointCache.defaultChannel();
        if (defaultEndpoint == null) {
          return false;
        }

        selectedEndpoint.decrementActiveRequests();
        parentChannel.learnDefaultChannelMethod(methodDescriptor.getFullMethodName());
        reroutedToDefault = true;
        selectedEndpoint = defaultEndpoint;
        selectedTargetEndpoint = defaultEndpoint.getAddress();
        selectedDatabaseScope = null;
        selectedOperationUid = 0L;
        selectedPreferLeader = false;
        channelFinder = null;
        selectedEndpoint.incrementActiveRequests();
        XGoogSpannerRequestId requestId = callOptions.getOption(REQUEST_ID_CALL_OPTIONS_KEY);
        if (requestId != null) {
          RequestIdTargetTracker.record(
              requestId.getHeaderValue(), null, selectedTargetEndpoint, 0L, false);
        }
        parentChannel.onRequestRouted(defaultEndpoint);
        recordRouteSelectionTrace(methodDescriptor, defaultEndpoint.getAddress(), true, false);

        ClientCall<RequestT, ResponseT> fallback =
            defaultEndpoint.getChannel().newCall(methodDescriptor, callOptions);
        delegate = fallback;
        if (messageCompression != null) {
          fallback.setMessageCompression(messageCompression);
        }
        Metadata fallbackHeaders = new Metadata();
        fallbackHeaders.merge(headers);
        fallback.start(responseListener, fallbackHeaders);
        requestMessages(fallback, outstandingRequests);
        fallback.sendMessage(genericRequestMessage);
        if (halfClosed) {
          fallback.halfClose();
        }
        return true;
      }
    }

    void maybeRecordAffinity(ByteString transactionId) {
      parentChannel.recordAffinity(transactionId, selectedEndpoint, allowDefaultAffinity);
    }

    void maybeClearAffinity() {
      parentChannel.clearAffinity(transactionIdToClear);
    }

    private void maybeTrackReadWriteBegin(TransactionSelector selector) {
      if (selector.getSelectorCase() == TransactionSelector.SelectorCase.BEGIN
          && !selector.getBegin().hasReadOnly()) {
        shouldRecordTransactionAffinity = true;
        allowDefaultAffinity = true;
      }
    }

    private Predicate<String> excludedEndpoints() {
      if (excludedEndpoints == null) {
        excludedEndpoints = parentChannel.endpointOverloadCooldowns;
      }
      return excludedEndpoints;
    }

    private RoutingDecision routeFromRequest(ReadRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      Predicate<String> excludedEndpoints = excludedEndpoints();
      ChannelEndpoint endpoint = parentChannel.affinityEndpoint(transactionId, excludedEndpoints);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      boolean preferLeader = preferLeader(reqBuilder.getTransaction());
      if (databaseId != null && endpoint == null) {
        // Transaction IDs only pin routing when a read-write affinity entry exists. Otherwise route
        // by this request's routing hint without leader bias, as read-only transaction IDs can run
        // on any suitable replica.
        boolean routePreferLeader = transactionId.isEmpty() && preferLeader;
        endpoint = finder.findServer(reqBuilder, routePreferLeader, excludedEndpoints);
        preferLeader = routePreferLeader;
      }
      return new RoutingDecision(
          finder, endpoint, databaseId, operationUid(reqBuilder.getRoutingHint()), preferLeader);
    }

    private RoutingDecision routeFromRequest(ExecuteSqlRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      Predicate<String> excludedEndpoints = excludedEndpoints();
      ChannelEndpoint endpoint = parentChannel.affinityEndpoint(transactionId, excludedEndpoints);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      boolean preferLeader = preferLeader(reqBuilder.getTransaction());
      if (databaseId != null && endpoint == null) {
        // Transaction IDs only pin routing when a read-write affinity entry exists. Otherwise route
        // by this request's routing hint without leader bias, as read-only transaction IDs can run
        // on any suitable replica.
        boolean routePreferLeader = transactionId.isEmpty() && preferLeader;
        endpoint = finder.findServer(reqBuilder, routePreferLeader, excludedEndpoints);
        preferLeader = routePreferLeader;
      }
      return new RoutingDecision(
          finder, endpoint, databaseId, operationUid(reqBuilder.getRoutingHint()), preferLeader);
    }

    @Nullable
    private ChannelEndpoint routeFromRequest(ExecuteBatchDmlRequest request) {
      return parentChannel.affinityEndpoint(
          transactionIdFromSelector(request.getTransaction()), excludedEndpoints());
    }
  }

  private static final class RoutingDecision {
    @Nullable private final ChannelFinder finder;
    @Nullable private final ChannelEndpoint endpoint;
    @Nullable private final String databaseScope;
    private final long operationUid;
    private final boolean preferLeader;

    private RoutingDecision(
        @Nullable ChannelFinder finder,
        @Nullable ChannelEndpoint endpoint,
        @Nullable String databaseScope,
        long operationUid,
        boolean preferLeader) {
      this.finder = finder;
      this.endpoint = endpoint;
      this.databaseScope = databaseScope;
      this.operationUid = operationUid;
      this.preferLeader = preferLeader;
    }
  }

  @Nullable
  private static String routingScope(@Nullable ChannelFinder finder) {
    return finder == null ? null : finder.finderKey();
  }

  private static long operationUid(com.google.spanner.v1.RoutingHint routingHint) {
    return routingHint == null ? 0L : routingHint.getOperationUid();
  }

  private static boolean preferLeader(TransactionSelector selector) {
    switch (selector.getSelectorCase()) {
      case BEGIN:
        return !selector.getBegin().hasReadOnly() || selector.getBegin().getReadOnly().getStrong();
      case SINGLE_USE:
        if (!selector.getSingleUse().hasReadOnly()) {
          return true;
        }
        return selector.getSingleUse().getReadOnly().getStrong();
      case ID:
      case SELECTOR_NOT_SET:
      default:
        return true;
    }
  }

  static final class KeyAwareClientCallListener<ResponseT>
      extends SimpleForwardingClientCallListener<ResponseT> {
    private final KeyAwareClientCall<?, ResponseT> call;

    KeyAwareClientCallListener(
        ClientCall.Listener<ResponseT> responseListener, KeyAwareClientCall<?, ResponseT> call) {
      super(responseListener);
      this.call = call;
    }

    @Override
    public void onMessage(ResponseT message) {
      call.onResponseMessage();
      ByteString transactionId = null;
      if (message instanceof PartialResultSet) {
        PartialResultSet response = (PartialResultSet) message;
        if (response.hasCacheUpdate() && call.channelFinder != null) {
          call.channelFinder.updateAsync(response.getCacheUpdate());
        }
        transactionId = transactionIdFromMetadata(response);
      } else if (message instanceof ResultSet) {
        ResultSet response = (ResultSet) message;
        if (response.hasCacheUpdate() && call.channelFinder != null) {
          call.channelFinder.updateAsync(response.getCacheUpdate());
        }
        transactionId = transactionIdFromMetadata(response);
      } else if (message instanceof Transaction) {
        Transaction response = (Transaction) message;
        if (response.hasCacheUpdate() && call.channelFinder != null) {
          call.channelFinder.updateAsync(response.getCacheUpdate());
        }
        transactionId = transactionIdFromTransaction(response);
      } else if (message instanceof CommitResponse) {
        CommitResponse response = (CommitResponse) message;
        if (response.hasCacheUpdate() && call.channelFinder != null) {
          call.channelFinder.updateAsync(response.getCacheUpdate());
        }
      } else if (message instanceof ExecuteBatchDmlResponse) {
        ExecuteBatchDmlResponse response = (ExecuteBatchDmlResponse) message;
        if (response.getResultSetsCount() > 0) {
          ResultSet first = response.getResultSets(0);
          if (first.hasCacheUpdate() && call.channelFinder != null) {
            call.channelFinder.updateAsync(first.getCacheUpdate());
          }
          transactionId = transactionIdFromMetadata(first);
        }
      } else {
        transactionId = transactionIdFromGenericResponse(message);
      }
      if (transactionId != null && call.shouldRecordTransactionAffinity) {
        call.maybeRecordAffinity(transactionId);
      }
      super.onMessage(message);
    }

    @Override
    public void onClose(io.grpc.Status status, Metadata trailers) {
      if (call.maybeRerouteUnimplementedGenericCall(status)) {
        return;
      }
      if (status.isOk()) {
        call.parentChannel.recordEndpointSuccess(call.selectedEndpoint);
      } else if (shouldExcludeEndpointOnRetry(status.getCode())) {
        call.parentChannel.maybeRecordErrorPenalty(
            call.selectedDatabaseScope,
            call.selectedEndpoint,
            status.getCode(),
            call.selectedOperationUid,
            call.selectedPreferLeader);
        call.parentChannel.recordEndpointCooldown(
            call.selectedEndpoint, status.getCode(), trailers);
      }
      if (call.selectedEndpoint != null) {
        call.selectedEndpoint.decrementActiveRequests();
      }
      RequestIdTargetTracker.remove(call.logicalRequestKey);
      call.maybeClearAffinity();
      super.onClose(status, trailers);
    }
  }
}
