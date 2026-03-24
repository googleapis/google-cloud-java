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

import com.google.api.core.InternalApi;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.protobuf.ByteString;
import com.google.spanner.v1.BeginTransactionRequest;
import com.google.spanner.v1.CommitRequest;
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
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/**
 * ManagedChannel that routes eligible requests using location-aware routing hints.
 *
 * <p>Routing hints are applied to streaming read/query and unary ExecuteSql. Commit/Rollback use
 * transaction affinity when available. BeginTransaction is routed only when a mutation key is
 * provided.
 */
@InternalApi
final class KeyAwareChannel extends ManagedChannel {
  private static final long MAX_TRACKED_READ_ONLY_TRANSACTIONS = 100_000L;
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
  private final String authority;
  private final String defaultEndpointAddress;
  private final Map<String, SoftReference<ChannelFinder>> channelFinders =
      new ConcurrentHashMap<>();
  private final Map<ByteString, String> transactionAffinities = new ConcurrentHashMap<>();
  // Maps read-only transaction IDs to their preferLeader value.
  // Strong reads → true (prefer leader), Stale reads → false (any replica).
  // Bounded to prevent unbounded growth if application code does not close read-only transactions.
  private final Cache<ByteString, Boolean> readOnlyTxPreferLeader =
      CacheBuilder.newBuilder().maximumSize(MAX_TRACKED_READ_ONLY_TRANSACTIONS).build();

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
  }

  static KeyAwareChannel create(
      InstantiatingGrpcChannelProvider channelProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory)
      throws IOException {
    return new KeyAwareChannel(channelProvider, endpointCacheFactory);
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

  private ChannelFinder getOrCreateChannelFinder(String databaseId) {
    SoftReference<ChannelFinder> ref = channelFinders.get(databaseId);
    ChannelFinder finder = (ref != null) ? ref.get() : null;
    if (finder == null) {
      synchronized (channelFinders) {
        ref = channelFinders.get(databaseId);
        finder = (ref != null) ? ref.get() : null;
        if (finder == null) {
          finder = new ChannelFinder(endpointCache);
          channelFinders.put(databaseId, new SoftReference<>(finder));
        }
      }
    }
    return finder;
  }

  @Override
  public ManagedChannel shutdown() {
    endpointCache.shutdown();
    return this;
  }

  @Override
  public ManagedChannel shutdownNow() {
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
  private ChannelEndpoint affinityEndpoint(ByteString transactionId) {
    if (transactionId == null || transactionId.isEmpty()) {
      return null;
    }
    String address = transactionAffinities.get(transactionId);
    if (address == null) {
      return null;
    }
    return endpointCache.get(address);
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

  static final class KeyAwareClientCall<RequestT, ResponseT>
      extends ForwardingClientCall<RequestT, ResponseT> {
    private final KeyAwareChannel parentChannel;
    private final MethodDescriptor<RequestT, ResponseT> methodDescriptor;
    private final CallOptions callOptions;
    private Listener<ResponseT> responseListener;
    private Metadata headers;
    @Nullable private ClientCall<RequestT, ResponseT> delegate;
    private ChannelFinder channelFinder;
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
          if (databaseId != null && reqBuilder.hasMutationKey()) {
            finder = parentChannel.getOrCreateChannelFinder(databaseId);
            endpoint = finder.findServer(reqBuilder);
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
          if (!request.getTransactionId().isEmpty()) {
            endpoint = parentChannel.affinityEndpoint(request.getTransactionId());
            transactionIdToClear = request.getTransactionId();
          }
        } else if (message instanceof RollbackRequest) {
          RollbackRequest request = (RollbackRequest) message;
          if (!request.getTransactionId().isEmpty()) {
            endpoint = parentChannel.affinityEndpoint(request.getTransactionId());
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
        selectedEndpoint = endpoint;
        this.channelFinder = finder;

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

    private RoutingDecision routeFromRequest(ReadRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      // Skip affinity for read-only transactions so each read routes independently.
      boolean isReadOnly = parentChannel.isReadOnlyTransaction(transactionId);
      ChannelEndpoint endpoint = isReadOnly ? null : parentChannel.affinityEndpoint(transactionId);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      if (databaseId != null && endpoint == null) {
        Boolean preferLeaderOverride = parentChannel.readOnlyPreferLeader(transactionId);
        ChannelEndpoint routed =
            preferLeaderOverride != null
                ? finder.findServer(reqBuilder, preferLeaderOverride)
                : finder.findServer(reqBuilder);
        endpoint = routed;
      }
      return new RoutingDecision(finder, endpoint);
    }

    private RoutingDecision routeFromRequest(ExecuteSqlRequest.Builder reqBuilder) {
      String databaseId = parentChannel.extractDatabaseIdFromSession(reqBuilder.getSession());
      ByteString transactionId = transactionIdFromSelector(reqBuilder.getTransaction());
      // Skip affinity for read-only transactions so each query routes independently.
      boolean isReadOnly = parentChannel.isReadOnlyTransaction(transactionId);
      ChannelEndpoint endpoint = isReadOnly ? null : parentChannel.affinityEndpoint(transactionId);
      ChannelFinder finder = null;
      if (databaseId != null) {
        finder = parentChannel.getOrCreateChannelFinder(databaseId);
      }
      if (databaseId != null && endpoint == null) {
        Boolean preferLeaderOverride = parentChannel.readOnlyPreferLeader(transactionId);
        ChannelEndpoint routed =
            preferLeaderOverride != null
                ? finder.findServer(reqBuilder, preferLeaderOverride)
                : finder.findServer(reqBuilder);
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
          call.channelFinder.update(response.getCacheUpdate());
        }
        transactionId = transactionIdFromMetadata(response);
      } else if (message instanceof ResultSet) {
        ResultSet response = (ResultSet) message;
        if (response.hasCacheUpdate() && call.channelFinder != null) {
          call.channelFinder.update(response.getCacheUpdate());
        }
        transactionId = transactionIdFromMetadata(response);
      } else if (message instanceof Transaction) {
        Transaction response = (Transaction) message;
        transactionId = transactionIdFromTransaction(response);
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
      call.maybeClearAffinity();
      super.onClose(status, trailers);
    }
  }
}
