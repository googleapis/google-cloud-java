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

package com.google.cloud.visionai.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.visionai.v1.stub.StreamingServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link StreamingServiceClient}.
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
 * StreamingServiceSettings.Builder streamingServiceSettingsBuilder =
 *     StreamingServiceSettings.newBuilder();
 * streamingServiceSettingsBuilder
 *     .acquireLeaseSettings()
 *     .setRetrySettings(
 *         streamingServiceSettingsBuilder
 *             .acquireLeaseSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * StreamingServiceSettings streamingServiceSettings = streamingServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class StreamingServiceSettings extends ClientSettings<StreamingServiceSettings> {

  /** Returns the object with the settings used for calls to sendPackets. */
  public StreamingCallSettings<SendPacketsRequest, SendPacketsResponse> sendPacketsSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).sendPacketsSettings();
  }

  /** Returns the object with the settings used for calls to receivePackets. */
  public StreamingCallSettings<ReceivePacketsRequest, ReceivePacketsResponse>
      receivePacketsSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).receivePacketsSettings();
  }

  /** Returns the object with the settings used for calls to receiveEvents. */
  public StreamingCallSettings<ReceiveEventsRequest, ReceiveEventsResponse>
      receiveEventsSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).receiveEventsSettings();
  }

  /** Returns the object with the settings used for calls to acquireLease. */
  public UnaryCallSettings<AcquireLeaseRequest, Lease> acquireLeaseSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).acquireLeaseSettings();
  }

  /** Returns the object with the settings used for calls to renewLease. */
  public UnaryCallSettings<RenewLeaseRequest, Lease> renewLeaseSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).renewLeaseSettings();
  }

  /** Returns the object with the settings used for calls to releaseLease. */
  public UnaryCallSettings<ReleaseLeaseRequest, ReleaseLeaseResponse> releaseLeaseSettings() {
    return ((StreamingServiceStubSettings) getStubSettings()).releaseLeaseSettings();
  }

  public static final StreamingServiceSettings create(StreamingServiceStubSettings stub)
      throws IOException {
    return new StreamingServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return StreamingServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return StreamingServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return StreamingServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return StreamingServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return StreamingServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return StreamingServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return StreamingServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return StreamingServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected StreamingServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for StreamingServiceSettings. */
  public static class Builder extends ClientSettings.Builder<StreamingServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(StreamingServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(StreamingServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(StreamingServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(StreamingServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(StreamingServiceStubSettings.newHttpJsonBuilder());
    }

    public StreamingServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((StreamingServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to sendPackets. */
    public StreamingCallSettings.Builder<SendPacketsRequest, SendPacketsResponse>
        sendPacketsSettings() {
      return getStubSettingsBuilder().sendPacketsSettings();
    }

    /** Returns the builder for the settings used for calls to receivePackets. */
    public StreamingCallSettings.Builder<ReceivePacketsRequest, ReceivePacketsResponse>
        receivePacketsSettings() {
      return getStubSettingsBuilder().receivePacketsSettings();
    }

    /** Returns the builder for the settings used for calls to receiveEvents. */
    public StreamingCallSettings.Builder<ReceiveEventsRequest, ReceiveEventsResponse>
        receiveEventsSettings() {
      return getStubSettingsBuilder().receiveEventsSettings();
    }

    /** Returns the builder for the settings used for calls to acquireLease. */
    public UnaryCallSettings.Builder<AcquireLeaseRequest, Lease> acquireLeaseSettings() {
      return getStubSettingsBuilder().acquireLeaseSettings();
    }

    /** Returns the builder for the settings used for calls to renewLease. */
    public UnaryCallSettings.Builder<RenewLeaseRequest, Lease> renewLeaseSettings() {
      return getStubSettingsBuilder().renewLeaseSettings();
    }

    /** Returns the builder for the settings used for calls to releaseLease. */
    public UnaryCallSettings.Builder<ReleaseLeaseRequest, ReleaseLeaseResponse>
        releaseLeaseSettings() {
      return getStubSettingsBuilder().releaseLeaseSettings();
    }

    @Override
    public StreamingServiceSettings build() throws IOException {
      return new StreamingServiceSettings(this);
    }
  }
}
