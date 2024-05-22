/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.visionai.v1.stub;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.visionai.v1.AcquireLeaseRequest;
import com.google.cloud.visionai.v1.Lease;
import com.google.cloud.visionai.v1.ReceiveEventsRequest;
import com.google.cloud.visionai.v1.ReceiveEventsResponse;
import com.google.cloud.visionai.v1.ReceivePacketsRequest;
import com.google.cloud.visionai.v1.ReceivePacketsResponse;
import com.google.cloud.visionai.v1.ReleaseLeaseRequest;
import com.google.cloud.visionai.v1.ReleaseLeaseResponse;
import com.google.cloud.visionai.v1.RenewLeaseRequest;
import com.google.cloud.visionai.v1.SendPacketsRequest;
import com.google.cloud.visionai.v1.SendPacketsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StreamingServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (visionai.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of acquireLease to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * StreamingServiceStubSettings.Builder streamingServiceSettingsBuilder =
 *     StreamingServiceStubSettings.newBuilder();
 * streamingServiceSettingsBuilder
 *     .acquireLeaseSettings()
 *     .setRetrySettings(
 *         streamingServiceSettingsBuilder
 *             .acquireLeaseSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StreamingServiceStubSettings streamingServiceSettings = streamingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StreamingServiceStubSettings extends StubSettings<StreamingServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final StreamingCallSettings<SendPacketsRequest, SendPacketsResponse> sendPacketsSettings;
  private final StreamingCallSettings<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsSettings;
  private final StreamingCallSettings<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsSettings;
  private final UnaryCallSettings<AcquireLeaseRequest, Lease> acquireLeaseSettings;
  private final UnaryCallSettings<RenewLeaseRequest, Lease> renewLeaseSettings;
  private final UnaryCallSettings<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseSettings;

  /** Returns the object with the settings used for calls to sendPackets. */
  public StreamingCallSettings<SendPacketsRequest, SendPacketsResponse> sendPacketsSettings() {
    return sendPacketsSettings;
  }

  /** Returns the object with the settings used for calls to receivePackets. */
  public StreamingCallSettings<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsSettings() {
    return receivePacketsSettings;
  }

  /** Returns the object with the settings used for calls to receiveEvents. */
  public StreamingCallSettings<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsSettings() {
    return receiveEventsSettings;
  }

  /** Returns the object with the settings used for calls to acquireLease. */
  public UnaryCallSettings<AcquireLeaseRequest, Lease> acquireLeaseSettings() {
    return acquireLeaseSettings;
  }

  /** Returns the object with the settings used for calls to renewLease. */
  public UnaryCallSettings<RenewLeaseRequest, Lease> renewLeaseSettings() {
    return renewLeaseSettings;
  }

  /** Returns the object with the settings used for calls to releaseLease. */
  public UnaryCallSettings<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseSettings() {
    return releaseLeaseSettings;
  }

  public StreamingServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcStreamingServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonStreamingServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "visionai";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "visionai.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "visionai.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StreamingServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(StreamingServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StreamingServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected StreamingServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    sendPacketsSettings = settingsBuilder.sendPacketsSettings().build();
    receivePacketsSettings = settingsBuilder.receivePacketsSettings().build();
    receiveEventsSettings = settingsBuilder.receiveEventsSettings().build();
    acquireLeaseSettings = settingsBuilder.acquireLeaseSettings().build();
    renewLeaseSettings = settingsBuilder.renewLeaseSettings().build();
    releaseLeaseSettings = settingsBuilder.releaseLeaseSettings().build();
  }

  /** Builder for StreamingServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<StreamingServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final StreamingCallSettings.Builder<SendPacketsRequest, SendPacketsResponse>
        sendPacketsSettings;
    private final StreamingCallSettings.Builder<ReceivePacketsRequest, ReceivePacketsResponse>
        receivePacketsSettings;
    private final StreamingCallSettings.Builder<ReceiveEventsRequest, ReceiveEventsResponse>
        receiveEventsSettings;
    private final UnaryCallSettings.Builder<AcquireLeaseRequest, Lease> acquireLeaseSettings;
    private final UnaryCallSettings.Builder<RenewLeaseRequest, Lease> renewLeaseSettings;
    private final UnaryCallSettings.Builder<ReleaseLeaseRequest, ReleaseLeaseResponse>
        releaseLeaseSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      sendPacketsSettings = StreamingCallSettings.newBuilder();
      receivePacketsSettings = StreamingCallSettings.newBuilder();
      receiveEventsSettings = StreamingCallSettings.newBuilder();
      acquireLeaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      renewLeaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      releaseLeaseSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              acquireLeaseSettings, renewLeaseSettings, releaseLeaseSettings);
      initDefaults(this);
    }

    protected Builder(StreamingServiceStubSettings settings) {
      super(settings);

      sendPacketsSettings = settings.sendPacketsSettings.toBuilder();
      receivePacketsSettings = settings.receivePacketsSettings.toBuilder();
      receiveEventsSettings = settings.receiveEventsSettings.toBuilder();
      acquireLeaseSettings = settings.acquireLeaseSettings.toBuilder();
      renewLeaseSettings = settings.renewLeaseSettings.toBuilder();
      releaseLeaseSettings = settings.releaseLeaseSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              acquireLeaseSettings, renewLeaseSettings, releaseLeaseSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .acquireLeaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .renewLeaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .releaseLeaseSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to sendPackets. */
    public StreamingCallSettings.Builder<SendPacketsRequest, SendPacketsResponse>
        sendPacketsSettings() {
      return sendPacketsSettings;
    }

    /** Returns the builder for the settings used for calls to receivePackets. */
    public StreamingCallSettings.Builder<ReceivePacketsRequest, ReceivePacketsResponse>
        receivePacketsSettings() {
      return receivePacketsSettings;
    }

    /** Returns the builder for the settings used for calls to receiveEvents. */
    public StreamingCallSettings.Builder<ReceiveEventsRequest, ReceiveEventsResponse>
        receiveEventsSettings() {
      return receiveEventsSettings;
    }

    /** Returns the builder for the settings used for calls to acquireLease. */
    public UnaryCallSettings.Builder<AcquireLeaseRequest, Lease> acquireLeaseSettings() {
      return acquireLeaseSettings;
    }

    /** Returns the builder for the settings used for calls to renewLease. */
    public UnaryCallSettings.Builder<RenewLeaseRequest, Lease> renewLeaseSettings() {
      return renewLeaseSettings;
    }

    /** Returns the builder for the settings used for calls to releaseLease. */
    public UnaryCallSettings.Builder<ReleaseLeaseRequest, ReleaseLeaseResponse>
        releaseLeaseSettings() {
      return releaseLeaseSettings;
    }

    @Override
    public StreamingServiceStubSettings build() throws IOException {
      return new StreamingServiceStubSettings(this);
    }
  }
}
