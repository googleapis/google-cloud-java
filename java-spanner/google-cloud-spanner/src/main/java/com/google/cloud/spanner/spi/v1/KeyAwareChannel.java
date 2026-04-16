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
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CommitResponse;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSet;
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
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/**
 * ManagedChannel that routes eligible requests using location-aware routing hints.
 *
 * <p>Routing hints are applied to streaming read/query and unary ExecuteSql. Mutation-based
 * BeginTransaction and Commit requests also carry routing hints when recipes are available.
 * Commit/Rollback use transaction affinity when available. BeginTransaction is routed only when a
 * mutation key is provided.
 */
@InternalApi
final class KeyAwareChannel extends ManagedChannel {

  private static final Logger logger = Logger.getLogger(KeyAwareChannel.class.getName());

  private static final long MAX_TRACKED_READ_ONLY_TRANSACTIONS = 100_000L;
  private static final long MAX_TRACKED_EXCLUDED_LOGICAL_REQUESTS = 100_000L;
  private static final long EXCLUDED_LOGICAL_REQUEST_TTL_MINUTES = 10L;
  private static final String STREAMING_READ_METHOD = "google.spanner.v1.Spanner/StreamingRead";
  private static final String STREAMING_SQL_METHOD =
      "google.spanner.v1.Spanner/ExecuteStreamingSql";
  private static final String UNARY_SQL_METHOD = "google.spanner.v1.Spanner/ExecuteSql";
  private static final String BEGIN_TRANSACTION_METHOD =
      "google.spanner.v1.Spanner/BeginTransaction";
  private static final String COMMIT_METHOD = "google.spanner.v1.Spanner/Commit";
  private static final String ROLLBACK_METHOD = "google.spanner.v1.Spanner/Rollback";

  private final ManagedChannel defaultChannel;
  private final ChannelEndpointCache endpointCache;
  @Nullable private final EndpointLifecycleManager lifecycleManager;
  private final String authority;
  private final String defaultEndpointAddress;
  private final ReferenceQueue<ChannelFinder> channelFinderReferenceQueue = new ReferenceQueue<>();
  private final Map<String, ChannelFinderReference> channelFinders = new ConcurrentHashMap<>();
  private final Map<ByteString, String> transactionAffinities = new ConcurrentHashMap<>();
  // Maps read-only transaction IDs to their preferLeader value.
  // Strong reads → true (prefer leader), Stale reads → false (any replica).
  // Bounded to prevent unbounded growth if application code does not close read-only transactions.
  private final Cache<ByteString, Boolean> readOnlyTxPreferLeader =
      CacheBuilder.newBuilder().maximumSize(MAX_TRACKED_READ_ONLY_TRANSACTIONS).build();
  // If a routed endpoint returns RESOURCE_EXHAUSTED, the next retry attempt of that same logical
  // request should avoid that endpoint once so other requests are unaffected. Bound and age out
  // entries in case a caller gives up and never issues a retry.
  private final Cache<String, Set<String>> excludedEndpointsForLogicalRequest =
      CacheBuilder.newBuilder()
          .maximumSize(MAX_TRACKED_EXCLUDED_LOGICAL_REQUESTS)
          .expireAfterWrite(EXCLUDED_LOGICAL_REQUEST_TTL_MINUTES, TimeUnit.MINUTES)
          .build();

  private KeyAwareChannel(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory)
      throws IOException {
    if (endpointCacheFactory == null) {
      this.endpointCache = new GrpcChannelEndpointCache(channelProvider);
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
  }

  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory)
      throws IOException {
    return new KeyAwareChannel(channelProvider, endpointCacheFactory);
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

  private ChannelFinder getOrCreateChannelFinder(String databaseId) {
    cleanupStaleChannelFinders();
    ChannelFinderReference ref = channelFinders.get(databaseId);
    ChannelFinder finder = (ref != null) ? ref.get() : null;
    if (finder == null) {
      synchronized (channelFinders) {
        cleanupStaleChannelFinders();
        ref = channelFinders.get(databaseId);
        finder = (ref != null) ? ref.get() : null;
        if (finder == null) {
          finder =
              lifecycleManager != null
                  ? new ChannelFinder(endpointCache, lifecycleManager, databaseId)
                  : new ChannelFinder(endpointCache);
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
    return STREAMING_READ_METHOD.equals(method)
        || STREAMING_SQL_METHOD.equals(method)
        || UNARY_SQL_METHOD.equals(method)
        || BEGIN_TRANSACTION_METHOD.equals(method)
        || COMMIT_METHOD.equals(method)
        || ROLLBACK_METHOD.equals(method);
  }

  @Nullable
  private ChannelEndpoint affinityEndpoint(
      ByteString transactionId, Predicate<String> excludedEndpoints) {
    if (transactionId == null || transactionId.isEmpty()) {
      return null;
    }
    String address = transactionAffinities.get(transactionId);
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
    transactionAffinities.remove(transactionId);
    readOnlyTxPreferLeader.invalidate(transactionId);
  }

  void clearTransactionAffinity(ByteString transactionId) {
    clearAffinity(transactionId);
  }

  void clearTransactionAndChannelAffinity(ByteString transactionId, @Nullable Long channelHint) {
    String address = transactionAffinities.remove(transactionId);
    readOnlyTxPreferLeader.invalidate(transactionId);
    if (channelHint != null) {
      ManagedChannel channel = defaultChannel;
      if (address != null) {
        ChannelEndpoint endpoint = endpointCache.getIfPresent(address);
        if (endpoint != null) {
          channel = endpoint.getChannel();
        }
      }
      GrpcGcpAffinityUtil.clearChannelHintAffinity(channel, channelHint);
    }
  }

  private void maybeExcludeEndpointOnNextCall(
      @Nullable ChannelEndpoint endpoint, @Nullable String logicalRequestKey) {
    if (endpoint == null || logicalRequestKey == null) {
      return;
    }
    String address = endpoint.getAddress();
    if (!defaultEndpointAddress.equals(address)) {
      excludedEndpointsForLogicalRequest
          .asMap()
          .compute(
              logicalRequestKey,
              (ignored, excludedEndpoints) -> {
                Set<String> updated =
                    excludedEndpoints == null ? ConcurrentHashMap.newKeySet() : excludedEndpoints;
                updated.add(address);
                return updated;
              });
    }
  }

  private Predicate<String> consumeExcludedEndpointsForCurrentCall(
      @Nullable String logicalRequestKey) {
    if (logicalRequestKey == null) {
      return address -> false;
    }
    Set<String> excludedEndpoints =
        excludedEndpointsForLogicalRequest.asMap().remove(logicalRequestKey);
    if (excludedEndpoints == null || excludedEndpoints.isEmpty()) {
      return address -> false;
    }
    excludedEndpoints = new HashSet<>(excludedEndpoints);
    return excludedEndpoints::contains;
  }

  private boolean isReadOnlyTransaction(ByteString transactionId) {
    return transactionId != null
        && !transactionId.isEmpty()
        && readOnlyTxPreferLeader.getIfPresent(transactionId) != null;
  }

  @Nullable
  private Boolean readOnlyPreferLeader(ByteString transactionId) {
    if (transactionId == null || transactionId.isEmpty()) {
      return null;
    }
    return readOnlyTxPreferLeader.getIfPresent(transactionId);
  }

  private void trackReadOnlyTransaction(ByteString transactionId, boolean preferLeader) {
    if (transactionId == null || transactionId.isEmpty()) {
      return;
    }
    readOnlyTxPreferLeader.put(transactionId, preferLeader);
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
    @Nullable private ByteString transactionIdToClear;
    private boolean allowDefaultAffinity;
    private long pendingRequests;
    private boolean pendingHalfClose;
    @Nullable private Boolean pendingMessageCompression;
    @Nullable private io.grpc.Status cancelledStatus;
    @Nullable private Metadata cancelledTrailers;
    private boolean isReadOnlyBegin;
    private boolean readOnlyIsStrong;
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

        if (message instanceof ReadRequest) {
          ReadRequest.Builder reqBuilder = ((ReadRequest) message).toBuilder();
          maybeTrackReadOnlyBegin(reqBuilder.getTransaction());
          RoutingDecision routing = routeFromRequest(reqBuilder);
          finder = routing.finder;
          endpoint = routing.endpoint;
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof ExecuteSqlRequest) {
          ExecuteSqlRequest.Builder reqBuilder = ((ExecuteSqlRequest) message).toBuilder();
          maybeTrackReadOnlyBegin(reqBuilder.getTransaction());
          RoutingDecision routing = routeFromRequest(reqBuilder);
          finder = routing.finder;
          endpoint = routing.endpoint;
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof BeginTransactionRequest) {
          BeginTransactionRequest.Builder reqBuilder =
              ((BeginTransactionRequest) message).toBuilder();
          String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
          if (databaseId != null) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
          }
          if (finder != null && reqBuilder.hasMutationKey()) {
            endpoint = finder.findServer(reqBuilder, excludedEndpoints);
          }
          if (reqBuilder.hasOptions() && reqBuilder.getOptions().hasReadOnly()) {
            isReadOnlyBegin = true;
            readOnlyIsStrong = reqBuilder.getOptions().getReadOnly().getStrong();
          } else {
            allowDefaultAffinity = true;
          }
          message = (RequestT) reqBuilder.build();
        } else if (message instanceof CommitRequest) {
          CommitRequest request = (CommitRequest) message;
          String databaseId = parentChannel.extractDatabaseIdFromSession(request.getSession());
          if (databaseId != null) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
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
        } else {
          throw new IllegalStateException(
              "Only read, query, begin transaction, commit, and rollback requests are supported for"
                  + " key-aware calls.");
        }

        if (endpoint == null) {
          endpoint = parentChannel.endpointCache.defaultChannel();
        }
        if (endpoint == null) {
          throw new IllegalStateException("No default endpoint available for key-aware call");
        }
        selectedEndpoint = endpoint;
        this.channelFinder = finder;

        // Record real traffic for idle eviction tracking.
        parentChannel.onRequestRouted(endpoint);

        recordRouteSelectionTrace(
            methodDescriptor,
            endpoint.getAddress(),
            parentChannel.defaultEndpointAddress.equals(endpoint.getAddress()),
            finder != null);
        delegate = endpoint.getChannel().newCall(methodDescriptor, callOptions);
        if (pendingMessageCompression != null) {
          delegate.setMessageCompression(pendingMessageCompression);
          pendingMessageCompression = null;
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
        if (delegate != null) {
          currentDelegate = delegate;
        } else {
          pendingMessageCompression = enabled;
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
      while (requests > 0) {
        int batch = requests > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) requests;
        currentDelegate.request(batch);
        requests -= batch;
      }
    }

    void maybeRecordAffinity(ByteString transactionId) {
      parentChannel.recordAffinity(transactionId, selectedEndpoint, allowDefaultAffinity);
    }

    void maybeClearAffinity() {
      parentChannel.clearAffinity(transactionIdToClear);
    }

    private void maybeTrackReadOnlyBegin(TransactionSelector selector) {
      if (selector.getSelectorCase() == TransactionSelector.SelectorCase.BEGIN
          && selector.getBegin().hasReadOnly()) {
        isReadOnlyBegin = true;
        readOnlyIsStrong = selector.getBegin().getReadOnly().getStrong();
      }
    }

    private Predicate<String> excludedEndpoints() {
      if (excludedEndpoints == null) {
        excludedEndpoints = parentChannel.consumeExcludedEndpointsForCurrentCall(logicalRequestKey);
      }
      return excludedEndpoints;
    }

    private RoutingDecision routeFromRequest(ReadRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      // Skip affinity for read-only transactions so each read routes independently.
      boolean isReadOnly = parentChannel.isReadOnlyTransaction(transactionId);
      Predicate<String> excludedEndpoints = excludedEndpoints();
      ChannelEndpoint endpoint =
          isReadOnly ? null : parentChannel.affinityEndpoint(transactionId, excludedEndpoints);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      if (databaseId != null && endpoint == null) {
        Boolean preferLeaderOverride = parentChannel.readOnlyPreferLeader(transactionId);
        ChannelEndpoint routed =
            preferLeaderOverride != null
                ? finder.findServer(reqBuilder, preferLeaderOverride, excludedEndpoints)
                : finder.findServer(reqBuilder, excludedEndpoints);
        endpoint = routed;
      }
      return new RoutingDecision(finder, endpoint);
    }

    private RoutingDecision routeFromRequest(ExecuteSqlRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      // Skip affinity for read-only transactions so each query routes independently.
      boolean isReadOnly = parentChannel.isReadOnlyTransaction(transactionId);
      Predicate<String> excludedEndpoints = excludedEndpoints();
      ChannelEndpoint endpoint =
          isReadOnly ? null : parentChannel.affinityEndpoint(transactionId, excludedEndpoints);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      if (databaseId != null && endpoint == null) {
        Boolean preferLeaderOverride = parentChannel.readOnlyPreferLeader(transactionId);
        ChannelEndpoint routed =
            preferLeaderOverride != null
                ? finder.findServer(reqBuilder, preferLeaderOverride, excludedEndpoints)
                : finder.findServer(reqBuilder, excludedEndpoints);
        endpoint = routed;
      }
      return new RoutingDecision(finder, endpoint);
    }
  }

  private static final class RoutingDecision {
    @Nullable private final ChannelFinder finder;
    @Nullable private final ChannelEndpoint endpoint;

    private RoutingDecision(@Nullable ChannelFinder finder, @Nullable ChannelEndpoint endpoint) {
      this.finder = finder;
      this.endpoint = endpoint;
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
      }
      if (transactionId != null) {
        if (call.isReadOnlyBegin) {
          // Track the read-only transaction so subsequent reads skip affinity
          // and route independently based on key-based routing.
          call.parentChannel.trackReadOnlyTransaction(transactionId, call.readOnlyIsStrong);
        } else if (!call.parentChannel.isReadOnlyTransaction(transactionId)) {
          call.maybeRecordAffinity(transactionId);
        }
      }
      super.onMessage(message);
    }

    @Override
    public void onClose(io.grpc.Status status, Metadata trailers) {
      if (status.getCode() == io.grpc.Status.Code.RESOURCE_EXHAUSTED) {
        call.parentChannel.maybeExcludeEndpointOnNextCall(
            call.selectedEndpoint, call.logicalRequestKey);
      }
      call.maybeClearAffinity();
      super.onClose(status, trailers);
    }
  }
}
