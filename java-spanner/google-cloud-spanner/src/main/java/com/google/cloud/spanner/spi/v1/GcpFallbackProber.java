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

import com.google.cloud.spanner.SpannerOptions.CallCredentialsProvider;
import com.google.cloud.spanner.XGoogSpannerRequestId.RequestIdCreator;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Attributes;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.alts.AltsContextUtil;
import io.grpc.stub.ClientCalls;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nullable;

/**
 * Probes a primary channel during DirectPath fallback recovery using {@code GetSession} and
 * verifies fail-closed that the transport is DirectPath ALTS ({@link
 * AltsContextUtil#check(Attributes)}, matching {@link HeaderInterceptor}).
 *
 * <p>DirectPath-over-Interconnect negotiates TLS rather than ALTS, so probes intentionally fail
 * closed with {@link #RESULT_NOT_DIRECTPATH} and keep traffic on CloudPath after fallback.
 */
final class GcpFallbackProber implements Function<Channel, String> {
  static final Duration DEFAULT_PROBE_DEADLINE = Duration.ofSeconds(5);

  static final String RESULT_SUCCESS = "";
  static final String RESULT_WAITING_FOR_SESSION = "WAITING_FOR_REAL_SESSION";
  static final String RESULT_NOT_DIRECTPATH = "NOT_DIRECTPATH";

  private final SessionSourceRegistry sessionRegistry;
  private final SpannerMetadataProvider metadataProvider;
  private final String projectName;
  private final RequestIdCreator requestIdCreator;
  @Nullable private final CallCredentialsProvider callCredentialsProvider;
  private final boolean leaderAwareRoutingEnabled;
  private final Duration rpcDeadline;
  private final Predicate<Attributes> isDirectPathPredicate;

  GcpFallbackProber(
      SessionSourceRegistry sessionRegistry,
      SpannerMetadataProvider metadataProvider,
      String projectName,
      RequestIdCreator requestIdCreator,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      boolean leaderAwareRoutingEnabled,
      Duration rpcDeadline) {
    this(
        sessionRegistry,
        metadataProvider,
        projectName,
        requestIdCreator,
        callCredentialsProvider,
        leaderAwareRoutingEnabled,
        rpcDeadline,
        GcpFallbackProber::isDirectPathAlts);
  }

  private GcpFallbackProber(
      SessionSourceRegistry sessionRegistry,
      SpannerMetadataProvider metadataProvider,
      String projectName,
      RequestIdCreator requestIdCreator,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      boolean leaderAwareRoutingEnabled,
      Duration rpcDeadline,
      Predicate<Attributes> isDirectPathPredicate) {
    this.sessionRegistry = Preconditions.checkNotNull(sessionRegistry);
    this.metadataProvider = Preconditions.checkNotNull(metadataProvider);
    this.projectName = Preconditions.checkNotNull(projectName);
    this.requestIdCreator = Preconditions.checkNotNull(requestIdCreator);
    this.callCredentialsProvider = callCredentialsProvider;
    this.leaderAwareRoutingEnabled = leaderAwareRoutingEnabled;
    this.rpcDeadline = Preconditions.checkNotNull(rpcDeadline);
    Preconditions.checkArgument(
        !rpcDeadline.isZero() && !rpcDeadline.isNegative(), "rpcDeadline must be positive");
    this.isDirectPathPredicate = Preconditions.checkNotNull(isDirectPathPredicate);
  }

  private static boolean isDirectPathAlts(@Nullable Attributes attributes) {
    return attributes != null && AltsContextUtil.check(attributes);
  }

  @VisibleForTesting
  GcpFallbackProber withDirectPathPredicate(Predicate<Attributes> predicate) {
    return new GcpFallbackProber(
        sessionRegistry,
        metadataProvider,
        projectName,
        requestIdCreator,
        callCredentialsProvider,
        leaderAwareRoutingEnabled,
        rpcDeadline,
        predicate);
  }

  @Override
  public String apply(Channel channel) {
    Preconditions.checkNotNull(channel);
    List<String> sessionNames = sessionRegistry.nextSessionNames();
    if (sessionNames.isEmpty()) {
      return RESULT_WAITING_FOR_SESSION;
    }

    Deadline deadline = Deadline.after(rpcDeadline.toNanos(), TimeUnit.NANOSECONDS);
    String lastFailure = RESULT_WAITING_FOR_SESSION;
    for (String sessionName : sessionNames) {
      Metadata headers =
          DynamicChannelPoolPrimer.newCallHeaders(
              metadataProvider, projectName, requestIdCreator, sessionName, "name=");
      if (leaderAwareRoutingEnabled) {
        // Send the same routing header as session creation and read-write traffic, so the probe
        // takes the leader route rather than only the route of read-only traffic.
        metadataProvider
            .newRouteToLeaderHeader()
            .forEach(
                (name, values) ->
                    values.forEach(
                        value ->
                            headers.put(
                                Metadata.Key.of(name, Metadata.ASCII_STRING_MARSHALLER), value)));
      }
      ClientCall<GetSessionRequest, Session> call;
      try {
        // Default DirectPath channels embed client credentials at the channel level (and GAX strips
        // default CallCredentials on DirectPath), so only forward caller-configured per-call
        // credentials here, matching GapicSpannerRpc.newCallContext.
        call =
            DynamicChannelPoolPrimer.newClientCall(
                channel,
                SpannerGrpc.getGetSessionMethod(),
                headers,
                deadline,
                callCredentialsProvider);
        ClientCalls.blockingUnaryCall(
            call, GetSessionRequest.newBuilder().setName(sessionName).build());
      } catch (StatusRuntimeException e) {
        Status.Code code = e.getStatus().getCode();
        lastFailure = code.name();
        if (code == Status.Code.PERMISSION_DENIED || code == Status.Code.NOT_FOUND) {
          // Database- or session-specific rejection; try remaining registered sources so a single
          // misconfigured or stale database does not block recovery for healthy databases.
          continue;
        }
        return lastFailure;
      } catch (RuntimeException e) {
        return e.getClass().getSimpleName();
      }
      return isDirectPathPredicate.test(call.getAttributes())
          ? RESULT_SUCCESS
          : RESULT_NOT_DIRECTPATH;
    }
    return lastFailure;
  }
}
