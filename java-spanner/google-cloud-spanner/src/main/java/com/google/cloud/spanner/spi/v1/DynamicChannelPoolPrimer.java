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

import com.google.cloud.grpc.GcpChannelPrimer;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions.CallCredentialsProvider;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.XGoogSpannerRequestId.RequestIdCreator;
import com.google.cloud.spanner.spi.v1.SpannerRpc.ChannelPrimeSessionSource;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ForwardingClientCall.SimpleForwardingClientCall;
import io.grpc.ManagedChannel;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.stub.ClientCalls;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

/**
 * Primes channels that the grpc-gcp dynamic channel pool adds during scale-up by executing {@code
 * SELECT 1} on the new channel with a multiplexed session, so the transport, TLS session, and
 * server-side connection are established before the channel serves live traffic.
 *
 * <p>The channel pool is shared by all database clients of a {@link Spanner} instance, while
 * multiplexed sessions are created per database. Each live multiplexed-session database client
 * registers itself as a session source. Consecutive priming attempts rotate across those sources,
 * and unavailable sources are skipped. A source exposes its current session only after creation
 * completes successfully, so selecting a session never blocks the channel-pool scale-up path.
 * Priming with any database's session establishes the transport, TLS session, and server-side
 * connection for the whole channel, which benefits every database that later uses it. It does not
 * warm database-specific server-side state, so a request served by a freshly scaled-up channel for
 * a database other than the one used to prime it can still see slightly higher latency than on a
 * channel that database has already used. This trade-off is accepted.
 *
 * <p>A database client unregisters itself when invalidated or closed. The primer therefore never
 * retains a retired client's session name, and a {@code CreateSession} that completes after its
 * client was retired cannot become available for priming. Registry writes happen only when a client
 * is created or closed; session selection iterates an immutable snapshot.
 */
final class DynamicChannelPoolPrimer implements GcpChannelPrimer {
  /** The statement executed on every scaled-up channel. */
  static final String PRIME_SQL = "SELECT 1";

  /**
   * Upper bound of the deadline of a single priming RPC. Deliberately well below the pool's default
   * prime timeout of 10 seconds so an unresponsive backend never leaves the call lingering on the
   * server after the pool has given up on the attempt. See {@link #rpcDeadlineFor(Duration)}.
   */
  static final Duration MAX_RPC_DEADLINE = Duration.ofSeconds(5);

  /**
   * Safety margin that the RPC deadline keeps below the pool's prime timeout, so the RPC fails with
   * DEADLINE_EXCEEDED and is cleaned up before the pool times out the attempt.
   */
  static final Duration RPC_DEADLINE_MARGIN = Duration.ofSeconds(1);

  /**
   * Lower bound of the deadline of a single priming RPC. A prime timeout of at most twice this
   * value yields this deadline, which may then reach or exceed the prime timeout itself; the pool's
   * prime timeout cancels the attempt, and with it the RPC, in that case.
   */
  static final Duration MIN_RPC_DEADLINE = Duration.ofMillis(1);

  /**
   * Channel number of the request id of a priming RPC. The channel that is being primed is not part
   * of the pool yet, so it has no pool channel id and the request id uses 0 (unknown).
   */
  static final int REQUEST_ID_CHANNEL = 0;

  private final SpannerMetadataProvider metadataProvider;
  private final String projectName;
  private final RequestIdCreator requestIdCreator;
  @Nullable private final CallCredentialsProvider callCredentialsProvider;
  private final Duration rpcDeadline;

  /**
   * Registered sources. Reference identity keeps overlapping client instances independent, and
   * writers synchronize because the identity scan and mutation must be atomic.
   */
  private final CopyOnWriteArrayList<ChannelPrimeSessionSource> primeSessionSources =
      new CopyOnWriteArrayList<>();

  /** Index from which the next priming attempt starts searching for an available source. */
  private final AtomicInteger nextSourceIndex = new AtomicInteger();

  /**
   * @param metadataProvider provides the fixed headers and the resource-prefix header of a normal
   *     Spanner call
   * @param projectName the project resource name that serves as the default resource-prefix value
   * @param requestIdCreator the request id creator of the owning rpc, so priming RPCs carry a
   *     request id with the same client id as every other call of the rpc
   * @param callCredentialsProvider provides the credentials of a normal Spanner call, or {@code
   *     null} when the client runs without credentials
   * @param rpcDeadline the deadline of a single priming RPC
   */
  DynamicChannelPoolPrimer(
      SpannerMetadataProvider metadataProvider,
      String projectName,
      RequestIdCreator requestIdCreator,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      Duration rpcDeadline) {
    this.metadataProvider = Preconditions.checkNotNull(metadataProvider);
    this.projectName = Preconditions.checkNotNull(projectName);
    this.requestIdCreator = Preconditions.checkNotNull(requestIdCreator);
    this.callCredentialsProvider = callCredentialsProvider;
    Preconditions.checkArgument(
        rpcDeadline != null && !rpcDeadline.isZero() && !rpcDeadline.isNegative(),
        "rpcDeadline must be positive");
    this.rpcDeadline = rpcDeadline;
  }

  /**
   * Returns the deadline of a single priming RPC for a pool whose prime timeout is {@code
   * primeTimeout}: at most {@link #MAX_RPC_DEADLINE}, at least {@link #MIN_RPC_DEADLINE}, and
   * otherwise below the prime timeout. The RPC deadline keeps {@link #RPC_DEADLINE_MARGIN} below
   * the prime timeout, but never drops below half of the prime timeout so short prime timeouts
   * still leave the RPC a usable deadline. Prime timeouts of at most twice {@link
   * #MIN_RPC_DEADLINE} yield the minimum deadline, which may reach or exceed the prime timeout; the
   * pool's prime timeout then cancels the attempt and the RPC.
   *
   * @param primeTimeout the (positive) prime timeout of the pool
   */
  static Duration rpcDeadlineFor(Duration primeTimeout) {
    Preconditions.checkArgument(
        primeTimeout != null && !primeTimeout.isZero() && !primeTimeout.isNegative(),
        "primeTimeout must be positive");
    Duration withMargin = primeTimeout.minus(RPC_DEADLINE_MARGIN);
    Duration half = primeTimeout.dividedBy(2);
    Duration deadline = withMargin.compareTo(half) > 0 ? withMargin : half;
    if (deadline.compareTo(MAX_RPC_DEADLINE) > 0) {
      return MAX_RPC_DEADLINE;
    }
    return deadline.compareTo(MIN_RPC_DEADLINE) < 0 ? MIN_RPC_DEADLINE : deadline;
  }

  /** Returns the deadline of a single priming RPC. */
  @VisibleForTesting
  Duration getRpcDeadline() {
    return rpcDeadline;
  }

  /** Registers a session source by reference identity. Repeated registration is a no-op. */
  void registerPrimeSessionSource(ChannelPrimeSessionSource source) {
    Preconditions.checkNotNull(source);
    synchronized (primeSessionSources) {
      for (ChannelPrimeSessionSource existing : primeSessionSources) {
        if (existing == source) {
          return;
        }
      }
      primeSessionSources.add(source);
    }
  }

  /** Deregisters a session source. Repeated deregistration is a no-op. */
  void unregisterPrimeSessionSource(ChannelPrimeSessionSource source) {
    Preconditions.checkNotNull(source);
    synchronized (primeSessionSources) {
      for (int i = 0; i < primeSessionSources.size(); i++) {
        if (primeSessionSources.get(i) == source) {
          primeSessionSources.remove(i);
          return;
        }
      }
    }
  }

  /** Returns a snapshot of registered sources in registration order. */
  @VisibleForTesting
  List<ChannelPrimeSessionSource> getPrimeSessionSources() {
    return ImmutableList.copyOf(primeSessionSources);
  }

  /** Returns a currently available session name without blocking, rotating the starting source. */
  @VisibleForTesting
  @Nullable
  String getPrimeSessionName() {
    // The primer neither classifies failures nor evicts sessions. A dead session remains until its
    // owner observes it and isValid() stops offering it. Client traffic normally reaches
    // MultiplexedSessionTransaction.onError quickly; periodic refresh backs up an idle client.
    // Attempts may thus use a dead session, and the shared cursor cannot ensure consecutive
    // concurrent attempts on one channel use different sources. Deciding whether a session is still
    // usable deliberately stays with the owning client, which already tracks it for its own
    // traffic.
    List<ChannelPrimeSessionSource> sources = ImmutableList.copyOf(primeSessionSources);
    int size = sources.size();
    if (size == 0) {
      return null;
    }
    int start = Math.floorMod(nextSourceIndex.getAndIncrement(), size);
    for (int offset = 0; offset < size; offset++) {
      ChannelPrimeSessionSource source = sources.get((start + offset) % size);
      String sessionName = source.getChannelPrimeSessionName();
      if (sessionName != null) {
        return sessionName;
      }
    }
    return null;
  }

  /**
   * Always returns a future and never throws, so every failure reaches the pool as a failed future.
   */
  @Override
  public ListenableFuture<Void> prime(ManagedChannel channel) {
    try {
      String sessionName = getPrimeSessionName();
      if (sessionName == null) {
        // The primer cannot gate the pool's scale-up decision, so the attempt fails fast. The
        // pool's retry with backoff and its close-on-failure behaviour handle the unavailable
        // session.
        return Futures.immediateFailedFuture(
            SpannerExceptionFactory.newSpannerException(
                ErrorCode.FAILED_PRECONDITION,
                "Cannot prime a dynamic channel pool channel before a multiplexed session is"
                    + " available"));
      }
      return executePrimeStatement(channel, sessionName);
    } catch (Throwable t) {
      return Futures.immediateFailedFuture(t);
    }
  }

  private ListenableFuture<Void> executePrimeStatement(ManagedChannel channel, String sessionName) {
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder().setSession(sessionName).setSql(PRIME_SQL).build();
    // ExecuteStreamingSql must never be used here: its configured default deadline is one hour,
    // which would let a hung priming call outlive the pool's prime timeout by far. The unary
    // ExecuteSql method therefore uses an explicit short deadline.
    CallOptions callOptions =
        CallOptions.DEFAULT.withDeadlineAfter(rpcDeadline.toNanos(), TimeUnit.NANOSECONDS);
    if (callCredentialsProvider != null) {
      CallCredentials callCredentials = callCredentialsProvider.getCallCredentials();
      if (callCredentials != null) {
        callOptions = callOptions.withCallCredentials(callCredentials);
      }
    }
    Channel channelWithHeaders =
        ClientInterceptors.intercept(
            channel, new AttachHeadersInterceptor(newHeaders(sessionName)));
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        channelWithHeaders.newCall(SpannerGrpc.getExecuteSqlMethod(), callOptions);
    // Cancelling the future returned by futureUnaryCall cancels the underlying ClientCall, and
    // cancelling the derived future cancels its input. A channel that is shut down under the
    // running call fails the call with UNAVAILABLE or CANCELLED, which fails this future.
    return Futures.transform(
        ClientCalls.futureUnaryCall(call, request),
        resultSet -> null,
        MoreExecutors.directExecutor());
  }

  /**
   * Returns the per-call headers of a priming RPC. The delegate channel that the pool hands to the
   * primer is built by the same channel provider as every other channel of the pool, so it already
   * carries the fixed headers of the client (x-goog-api-client, the user agent, and any custom
   * headers) through the GAX header interceptor. Only the headers that a normal single-use
   * read-only query adds per call are attached here: the resource-prefix header,
   * x-goog-request-params, and x-goog-spanner-request-id.
   */
  @VisibleForTesting
  Metadata newHeaders(String sessionName) {
    Metadata headers = new Metadata();
    // The session name starts with the database name, which the metadata provider extracts as the
    // value of the resource-prefix header, exactly as for normal calls that pass the session name
    // as the resource.
    for (Map.Entry<String, List<String>> header :
        metadataProvider.newExtraHeaders(sessionName, projectName).entrySet()) {
      Metadata.Key<String> key = Metadata.Key.of(header.getKey(), Metadata.ASCII_STRING_MARSHALLER);
      for (String value : header.getValue()) {
        headers.put(key, value);
      }
    }
    headers.put(
        SpannerMetadataProvider.REQUEST_PARAMS_HEADER_KEY, "session=" + urlEncode(sessionName));
    // The pool invokes prime() once per attempt, so every attempt gets a fresh request id with
    // attempt number 1. The header is written directly and the request id is deliberately not set
    // as a call option: the RequestIdInterceptor on the delegate channel only acts on the call
    // option, so this never produces a duplicate header.
    XGoogSpannerRequestId requestId = requestIdCreator.nextRequestId(REQUEST_ID_CHANNEL);
    requestId.incrementAttempt();
    headers.put(XGoogSpannerRequestId.REQUEST_ID_HEADER_KEY, requestId.getHeaderValue());
    return headers;
  }

  private static String urlEncode(String value) {
    try {
      return URLEncoder.encode(value, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new IllegalStateException("UTF-8 is not supported", e);
    }
  }

  /** Merges the per-call headers of a priming RPC into the request headers of every call. */
  private static final class AttachHeadersInterceptor implements ClientInterceptor {
    private final Metadata headers;

    private AttachHeadersInterceptor(Metadata headers) {
      this.headers = headers;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return new SimpleForwardingClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {
        @Override
        public void start(Listener<RespT> responseListener, Metadata requestHeaders) {
          requestHeaders.merge(headers);
          super.start(responseListener, requestHeaders);
        }
      };
    }
  }
}
