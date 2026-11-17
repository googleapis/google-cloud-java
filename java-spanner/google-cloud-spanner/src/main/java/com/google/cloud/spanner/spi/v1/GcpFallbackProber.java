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
import com.google.common.base.Preconditions;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptors;
import io.grpc.Grpc;
import io.grpc.Metadata;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.MetadataUtils;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import javax.annotation.Nullable;

/**
 * Probes a primary channel during DirectPath fallback recovery using {@code GetSession} and
 * verifies that the transport is DirectPath ALTS ({@link Grpc#TRANSPORT_ATTR_SSL_SESSION} is {@code
 * null}).
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
  private final Duration rpcDeadline;

  GcpFallbackProber(
      SessionSourceRegistry sessionRegistry,
      SpannerMetadataProvider metadataProvider,
      String projectName,
      RequestIdCreator requestIdCreator,
      @Nullable CallCredentialsProvider callCredentialsProvider,
      Duration rpcDeadline) {
    this.sessionRegistry = Preconditions.checkNotNull(sessionRegistry);
    this.metadataProvider = Preconditions.checkNotNull(metadataProvider);
    this.projectName = Preconditions.checkNotNull(projectName);
    this.requestIdCreator = Preconditions.checkNotNull(requestIdCreator);
    this.callCredentialsProvider = callCredentialsProvider;
    this.rpcDeadline = Preconditions.checkNotNull(rpcDeadline);
  }

  @Override
  public String apply(Channel channel) {
    String sessionName = sessionRegistry.nextSessionName();
    if (sessionName == null) {
      return RESULT_WAITING_FOR_SESSION;
    }

    Metadata headers =
        DynamicChannelPoolPrimer.newCallHeaders(
            metadataProvider, projectName, requestIdCreator, sessionName, "name=");
    CallOptions callOptions =
        CallOptions.DEFAULT.withDeadlineAfter(rpcDeadline.toNanos(), TimeUnit.NANOSECONDS);
    if (callCredentialsProvider != null) {
      CallCredentials callCredentials = callCredentialsProvider.getCallCredentials();
      if (callCredentials != null) {
        callOptions = callOptions.withCallCredentials(callCredentials);
      }
    }
    ClientCall<GetSessionRequest, Session> call =
        ClientInterceptors.intercept(channel, MetadataUtils.newAttachHeadersInterceptor(headers))
            .newCall(SpannerGrpc.getGetSessionMethod(), callOptions);
    try {
      ClientCalls.blockingUnaryCall(
          call, GetSessionRequest.newBuilder().setName(sessionName).build());
    } catch (StatusRuntimeException e) {
      return e.getStatus().getCode().name();
    }
    Attributes attributes = call.getAttributes();
    return attributes != null && attributes.get(Grpc.TRANSPORT_ATTR_SSL_SESSION) != null
        ? RESULT_NOT_DIRECTPATH
        : RESULT_SUCCESS;
  }
}
