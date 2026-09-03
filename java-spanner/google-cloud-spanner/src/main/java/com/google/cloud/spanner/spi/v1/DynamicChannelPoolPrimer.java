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
import io.grpc.Status;
import io.grpc.stub.ClientCalls;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * Primes channels that the grpc-gcp dynamic channel pool adds during scale-up by executing {@code
 * SELECT 1} on the new channel with a multiplexed session, so the transport, TLS session, and
 * server-side connection are established before the channel serves live traffic. Mirrors the
 * priming that the Go Spanner client performs for its dynamic channel pool.
 *
 * <p>The channel pool is shared by all database clients of a {@link Spanner} instance, while
 * multiplexed sessions are created per database. The primer therefore keeps a small registry of
 * prime sessions keyed by database name. {@link GapicSpannerRpc} registers every multiplexed
 * session that it successfully creates, which replaces the previous entry of that database, and the
 * registry hands out the entry with the highest creation generation, that is the most recently
 * created multiplexed session. A multiplexed {@code CreateSession} is always the first RPC of a
 * database client before any data RPC is possible, and the periodic refresh of a multiplexed
 * session goes through the same path, so the most recently created multiplexed session is normally
 * a valid session to prime with. {@code SELECT 1} against any database is sufficient to prime a
 * channel.
 *
 * <p>A registered session can nevertheless become invalid, for example when its database is
 * dropped. The registry is therefore maintained on rare paths only: the entries of a database are
 * removed when its database client is invalidated or closed, and a priming attempt that fails for a
 * reason that is specific to the session it used, such as the session not being found, the session
 * or its database role being invalid, or permission being denied, evicts exactly the entry that it
 * used, so the pool's next attempt falls back to the next most recent session. Nothing is written
 * from any data RPC, and the scale-up path performs a single volatile read to select the session.
 *
 * <p>A {@code CreateSession} that is still in flight when its database client is retired must not
 * register its session after the client has been retired. Every database client that creates
 * multiplexed sessions therefore registers itself as the owner of its database through {@link
 * #registerPrimeOwner(String, long)} with a unique owner ticket before its first {@code
 * CreateSession}, includes that ticket in every {@code CreateSession} it issues, and unregisters
 * itself through {@link #unregisterPrimeOwner(String, long)} when it is invalidated or closed. A
 * session is registered only when the ticket of its {@code CreateSession} is the current owner
 * ticket of its database, so a late response of a retired client finds no owner, or the ticket of
 * the replacement client, and is dropped. The owner map holds one entry per live database client
 * and nothing for retired ones, so it is bounded by the number of live clients. This mirrors the Go
 * client, which installs a newly created multiplexed session only while its creation is still the
 * current one and the session manager is still valid.
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

  private static final Metadata.Key<String> ROUTE_TO_LEADER_KEY =
      Metadata.Key.of("x-goog-spanner-route-to-leader", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> REQUEST_PARAMS_KEY =
      Metadata.Key.of("x-goog-request-params", Metadata.ASCII_STRING_MARSHALLER);

  /** Matches failure messages about the database role of the session, such as an invalid role. */
  private static final Pattern ROLE_PATTERN = Pattern.compile("\\brole\\b");

  /**
   * Channel number of the request id of a priming RPC. The channel that is being primed is not part
   * of the pool yet, so it has no pool channel id and the request id uses 0 (unknown).
   */
  static final int REQUEST_ID_CHANNEL = 0;

  private final SpannerMetadataProvider metadataProvider;
  private final String projectName;
  private final RequestIdCreator requestIdCreator;
  @Nullable private final CallCredentials defaultCallCredentials;
  @Nullable private final CallCredentialsProvider callCredentialsProvider;
  private final boolean routeToLeader;
  private final Duration rpcDeadline;

  /** Source of the creation generations of {@link PrimeSession} entries. */
  private final AtomicLong generations = new AtomicLong();

  /**
   * The registered prime sessions, at most one per database, sorted by descending generation. The
   * list is replaced as a whole on every write, so a read is a single volatile read.
   */
  private volatile ImmutableList<PrimeSession> primeSessions = ImmutableList.of();

  /**
   * The owner ticket of the live database client of each database. Guarded by {@link #writeLock}.
   * An entry is put by {@link #registerPrimeOwner(String, long)} and removed by {@link
   * #unregisterPrimeOwner(String, long)}, so the map holds exactly one entry per live database
   * client that creates multiplexed sessions and nothing for retired clients.
   */
  private final Map<String, Long> primeOwners = new HashMap<>();

  /** Guards the writers of {@link #primeSessions}; all of them run on rare paths only. */
  private final Object writeLock = new Object();

  /** A multiplexed session that is registered for priming. */
  static final class PrimeSession {
    private final String databaseName;
    private final String sessionName;
    private final long ownerTicket;
    private final long generation;

    private PrimeSession(
        String databaseName, String sessionName, long ownerTicket, long generation) {
      this.databaseName = databaseName;
      this.sessionName = sessionName;
      this.ownerTicket = ownerTicket;
      this.generation = generation;
    }

    String getDatabaseName() {
      return databaseName;
    }

    String getSessionName() {
      return sessionName;
    }

    /** The owner ticket of the database client that created the session. */
    long getOwnerTicket() {
      return ownerTicket;
    }

    /** The creation generation; a higher generation means a more recently created session. */
    long getGeneration() {
      return generation;
    }

    @Override
    public boolean equals(Object other) {
      if (!(other instanceof PrimeSession)) {
        return false;
      }
      PrimeSession that = (PrimeSession) other;
      return generation == that.generation
          && ownerTicket == that.ownerTicket
          && databaseName.equals(that.databaseName)
          && sessionName.equals(that.sessionName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(databaseName, sessionName, ownerTicket, generation);
    }

    @Override
    public String toString() {
      return sessionName + "#" + generation;
    }
  }

  /**
   * @param metadataProvider provides the fixed headers and the resource-prefix header of a normal
   *     Spanner call
   * @param projectName the project resource name that serves as the default resource-prefix value
   * @param requestIdCreator the request id creator of the owning rpc, so priming RPCs carry a
   *     request id with the same client id as every other call of the rpc
   * @param defaultCallCredentials the credentials that GAX attaches to normal calls, or {@code
   *     null} when the client runs without credentials
   * @param callCredentialsProvider the optional user-supplied provider that takes precedence over
   *     {@code defaultCallCredentials} for each call, exactly like for normal Spanner calls
   * @param routeToLeader whether normal Spanner calls carry the route-to-leader header
   * @param rpcDeadline the deadline of a single priming RPC
   */
  DynamicChannelPoolPrimer(
      SpannerMetadataProvider metadataProvider,
      String projectName,
      RequestIdCreator requestIdCreator,
      @Nullable CallCredentials defaultCallCredentials,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      boolean routeToLeader,
      Duration rpcDeadline) {
    this.metadataProvider = Preconditions.checkNotNull(metadataProvider);
    this.projectName = Preconditions.checkNotNull(projectName);
    this.requestIdCreator = Preconditions.checkNotNull(requestIdCreator);
    this.defaultCallCredentials = defaultCallCredentials;
    this.callCredentialsProvider = callCredentialsProvider;
    this.routeToLeader = routeToLeader;
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

  /**
   * Registers the database client with the given owner ticket as the current owner of the given
   * database. Must be called before the client issues its first {@code CreateSession}, so every
   * session that the client creates can be attributed to it through {@link
   * #registerPrimeSession(String, String, long)}. A previous owner of the database, if any, is
   * replaced and its registered session, if any, is removed, because the previous client has been
   * or is being retired.
   *
   * @param ownerTicket a ticket that is unique among all database clients of the process
   */
  void registerPrimeOwner(String databaseName, long ownerTicket) {
    checkDatabaseName(databaseName);
    synchronized (writeLock) {
      Long previous = primeOwners.put(databaseName, ownerTicket);
      if (previous != null && previous != ownerTicket) {
        removeEntries(databaseName, previous);
      }
    }
  }

  /**
   * Unregisters the database client with the given owner ticket as the owner of the given database,
   * and removes the session that it registered, if any. Called when the client is invalidated or
   * closed, because its multiplexed session is then no longer maintained. A late {@code
   * CreateSession} response of the client is dropped afterwards, because its ticket is no longer
   * the current owner ticket of the database. If the database has already been taken over by a
   * replacement client, the replacement and its session are left untouched.
   */
  void unregisterPrimeOwner(String databaseName, long ownerTicket) {
    checkDatabaseName(databaseName);
    synchronized (writeLock) {
      Long current = primeOwners.get(databaseName);
      if (current != null && current == ownerTicket) {
        primeOwners.remove(databaseName);
      }
      removeEntries(databaseName, ownerTicket);
    }
  }

  /**
   * Registers a multiplexed session that was just created successfully for the given database as a
   * prime session. The entry replaces any previous entry of the same database, for example when a
   * database client refreshes its multiplexed session, and receives the highest generation, so it
   * becomes the session that the next priming attempt uses.
   *
   * <p>The registration is dropped unless the given owner ticket, which the {@code CreateSession}
   * request carried, is the current owner ticket of the database: the session then belongs to a
   * database client that has been invalidated or closed while its {@code CreateSession} was in
   * flight, and must not replace the session of the client that succeeded it.
   *
   * @param ownerTicket the owner ticket that the {@code CreateSession} request carried
   * @return whether the session was registered
   */
  boolean registerPrimeSession(String databaseName, String sessionName, long ownerTicket) {
    checkDatabaseName(databaseName);
    Preconditions.checkArgument(
        sessionName != null && !sessionName.isEmpty(), "sessionName must not be empty");
    synchronized (writeLock) {
      Long current = primeOwners.get(databaseName);
      if (current == null || current != ownerTicket) {
        return false;
      }
      PrimeSession entry =
          new PrimeSession(databaseName, sessionName, ownerTicket, generations.incrementAndGet());
      ImmutableList.Builder<PrimeSession> builder = ImmutableList.builder();
      // The new entry has the highest generation, so it goes first to keep the descending order.
      builder.add(entry);
      for (PrimeSession existing : primeSessions) {
        if (!existing.databaseName.equals(databaseName)) {
          builder.add(existing);
        }
      }
      primeSessions = builder.build();
      return true;
    }
  }

  /** Removes the entries of the given database that were registered with the given ticket. */
  private void removeEntries(String databaseName, long ownerTicket) {
    ImmutableList.Builder<PrimeSession> builder = ImmutableList.builder();
    boolean removed = false;
    for (PrimeSession existing : primeSessions) {
      if (existing.databaseName.equals(databaseName) && existing.ownerTicket == ownerTicket) {
        removed = true;
      } else {
        builder.add(existing);
      }
    }
    if (removed) {
      primeSessions = builder.build();
    }
  }

  private static void checkDatabaseName(String databaseName) {
    Preconditions.checkArgument(
        databaseName != null && !databaseName.isEmpty(), "databaseName must not be empty");
  }

  /**
   * Removes exactly the given entry, and returns whether it was still registered. An entry that has
   * already been replaced by a newer session of the same database, or that has already been
   * removed, is left alone, so an eviction never clobbers a newer registration.
   */
  @VisibleForTesting
  boolean evictPrimeSession(PrimeSession entry) {
    synchronized (writeLock) {
      if (!primeSessions.contains(entry)) {
        return false;
      }
      ImmutableList.Builder<PrimeSession> builder = ImmutableList.builder();
      for (PrimeSession existing : primeSessions) {
        if (!existing.equals(entry)) {
          builder.add(existing);
        }
      }
      primeSessions = builder.build();
      return true;
    }
  }

  /**
   * Returns the entry with the highest generation, that is the most recently created registered
   * multiplexed session, or {@code null} if none is registered.
   */
  @VisibleForTesting
  @Nullable
  PrimeSession getPrimeSession() {
    ImmutableList<PrimeSession> current = primeSessions;
    return current.isEmpty() ? null : current.get(0);
  }

  /** Returns the name of the session that the next priming attempt uses, or {@code null}. */
  @VisibleForTesting
  @Nullable
  String getPrimeSessionName() {
    PrimeSession entry = getPrimeSession();
    return entry == null ? null : entry.sessionName;
  }

  /** Returns all registered entries in descending generation order. */
  @VisibleForTesting
  ImmutableList<PrimeSession> getPrimeSessions() {
    return primeSessions;
  }

  /** Returns a copy of the current owner ticket of every database with a live database client. */
  @VisibleForTesting
  Map<String, Long> getPrimeOwners() {
    synchronized (writeLock) {
      return new HashMap<>(primeOwners);
    }
  }

  @Override
  public ListenableFuture<Void> prime(ManagedChannel channel) {
    PrimeSession entry = getPrimeSession();
    if (entry == null) {
      // The Go client refuses to scale up at all before a multiplexed session exists. The Java
      // primer cannot gate the pool's scale-up decision, so the attempt fails fast instead and the
      // pool's retry with backoff and its close-on-failure behaviour handle it. The wasted dial
      // and the prime-failure metrics of such an attempt are the known divergence from Go.
      return Futures.immediateFailedFuture(
          SpannerExceptionFactory.newSpannerException(
              ErrorCode.FAILED_PRECONDITION,
              "Cannot prime a dynamic channel pool channel before a multiplexed session is"
                  + " available"));
    }
    return executePrimeStatement(channel, entry);
  }

  private ListenableFuture<Void> executePrimeStatement(ManagedChannel channel, PrimeSession entry) {
    String sessionName = entry.sessionName;
    ExecuteSqlRequest request =
        ExecuteSqlRequest.newBuilder().setSession(sessionName).setSql(PRIME_SQL).build();
    // The priming query always uses the unary ExecuteSql method with an explicit short deadline,
    // as the Go client does. ExecuteStreamingSql must never be used here: its configured default
    // deadline is one hour, which would let a hung priming call outlive the pool's prime timeout
    // by far.
    CallOptions callOptions =
        CallOptions.DEFAULT.withDeadlineAfter(rpcDeadline.toNanos(), TimeUnit.NANOSECONDS);
    CallCredentials callCredentials = resolveCallCredentials();
    if (callCredentials != null) {
      callOptions = callOptions.withCallCredentials(callCredentials);
    }
    Channel channelWithHeaders =
        ClientInterceptors.intercept(
            channel, new AttachHeadersInterceptor(newHeaders(sessionName)));
    ClientCall<ExecuteSqlRequest, ResultSet> call =
        channelWithHeaders.newCall(SpannerGrpc.getExecuteSqlMethod(), callOptions);
    // Cancelling the future returned by futureUnaryCall cancels the underlying ClientCall, and
    // cancelling the derived futures cancels their input. A channel that is shut down under the
    // running call fails the call with UNAVAILABLE or CANCELLED, which fails this future.
    ListenableFuture<Void> result =
        Futures.transform(
            ClientCalls.futureUnaryCall(call, request),
            resultSet -> null,
            MoreExecutors.directExecutor());
    return Futures.catchingAsync(
        result,
        Throwable.class,
        failure -> {
          if (isCandidateSpecificFailure(failure)) {
            // The failure is specific to the session that was used, for example because its
            // database was dropped or the caller lost access to it. Evict exactly the entry that
            // was used, so the pool's next attempt falls back to the next most recent session. A
            // newer session of the same database that was registered in the meantime is never
            // clobbered.
            evictPrimeSession(entry);
          }
          return Futures.immediateFailedFuture(failure);
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Returns whether a priming failure is terminal for the session that was used, so priming should
   * rotate to the next candidate: the session or its database is not found, permission to use it is
   * denied, or its session or database role is reported as invalid. Only such failures evict the
   * session; transient failures such as UNAVAILABLE or DEADLINE_EXCEEDED say nothing about the
   * session and keep it registered.
   */
  @VisibleForTesting
  static boolean isCandidateSpecificFailure(Throwable failure) {
    Status status = Status.fromThrowable(failure);
    switch (status.getCode()) {
      case NOT_FOUND:
      case PERMISSION_DENIED:
        return true;
      case FAILED_PRECONDITION:
      case INVALID_ARGUMENT:
        break;
      default:
        return false;
    }
    String description = status.getDescription();
    if (description == null) {
      return false;
    }
    String message = description.toLowerCase(Locale.ENGLISH);
    if (ROLE_PATTERN.matcher(message).find()) {
      return true;
    }
    return message.contains("session")
        && (message.contains("not found")
            || message.contains("invalid")
            || message.contains("does not exist"));
  }

  @Nullable
  private CallCredentials resolveCallCredentials() {
    if (callCredentialsProvider != null) {
      CallCredentials callCredentials = callCredentialsProvider.getCallCredentials();
      if (callCredentials != null) {
        return callCredentials;
      }
    }
    return defaultCallCredentials;
  }

  /**
   * Returns the per-call headers of a priming RPC. The delegate channel that the pool hands to the
   * primer is built by the same channel provider as every other channel of the pool, so it already
   * carries the fixed headers of the client (x-goog-api-client, the user agent, and any custom
   * headers) through the GAX header interceptor. Only the headers that a normal call adds per call
   * are attached here: the resource-prefix header, x-goog-request-params, the route-to-leader
   * header when leader-aware routing is enabled, and x-goog-spanner-request-id.
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
    headers.put(REQUEST_PARAMS_KEY, "session=" + urlEncode(sessionName));
    if (routeToLeader) {
      headers.put(ROUTE_TO_LEADER_KEY, "true");
    }
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
