/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.gkeconnect.gateway.v1beta1;

import com.google.api.HttpBody;
import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.gkeconnect.gateway.v1beta1.stub.GatewayServiceStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link GatewayServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (connectgateway.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getResource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GatewayServiceSettings.Builder gatewayServiceSettingsBuilder =
 *     GatewayServiceSettings.newBuilder();
 * gatewayServiceSettingsBuilder
 *     .getResourceSettings()
 *     .setRetrySettings(
 *         gatewayServiceSettingsBuilder
 *             .getResourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * GatewayServiceSettings gatewayServiceSettings = gatewayServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GatewayServiceSettings extends ClientSettings<GatewayServiceSettings> {

  /** Returns the object with the settings used for calls to getResource. */
  public UnaryCallSettings<HttpBody, HttpBody> getResourceSettings() {
    return ((GatewayServiceStubSettings) getStubSettings()).getResourceSettings();
  }

  /** Returns the object with the settings used for calls to postResource. */
  public UnaryCallSettings<HttpBody, HttpBody> postResourceSettings() {
    return ((GatewayServiceStubSettings) getStubSettings()).postResourceSettings();
  }

  /** Returns the object with the settings used for calls to deleteResource. */
  public UnaryCallSettings<HttpBody, HttpBody> deleteResourceSettings() {
    return ((GatewayServiceStubSettings) getStubSettings()).deleteResourceSettings();
  }

  /** Returns the object with the settings used for calls to putResource. */
  public UnaryCallSettings<HttpBody, HttpBody> putResourceSettings() {
    return ((GatewayServiceStubSettings) getStubSettings()).putResourceSettings();
  }

  /** Returns the object with the settings used for calls to patchResource. */
  public UnaryCallSettings<HttpBody, HttpBody> patchResourceSettings() {
    return ((GatewayServiceStubSettings) getStubSettings()).patchResourceSettings();
  }

  public static final GatewayServiceSettings create(GatewayServiceStubSettings stub)
      throws IOException {
    return new GatewayServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return GatewayServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return GatewayServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return GatewayServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GatewayServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return GatewayServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return GatewayServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return GatewayServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected GatewayServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for GatewayServiceSettings. */
  public static class Builder extends ClientSettings.Builder<GatewayServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(GatewayServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(GatewayServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(GatewayServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(GatewayServiceStubSettings.newBuilder());
    }

    public GatewayServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((GatewayServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getResource. */
    public UnaryCallSettings.Builder<HttpBody, HttpBody> getResourceSettings() {
      return getStubSettingsBuilder().getResourceSettings();
    }

    /** Returns the builder for the settings used for calls to postResource. */
    public UnaryCallSettings.Builder<HttpBody, HttpBody> postResourceSettings() {
      return getStubSettingsBuilder().postResourceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteResource. */
    public UnaryCallSettings.Builder<HttpBody, HttpBody> deleteResourceSettings() {
      return getStubSettingsBuilder().deleteResourceSettings();
    }

    /** Returns the builder for the settings used for calls to putResource. */
    public UnaryCallSettings.Builder<HttpBody, HttpBody> putResourceSettings() {
      return getStubSettingsBuilder().putResourceSettings();
    }

    /** Returns the builder for the settings used for calls to patchResource. */
    public UnaryCallSettings.Builder<HttpBody, HttpBody> patchResourceSettings() {
      return getStubSettingsBuilder().patchResourceSettings();
    }

    @Override
    public GatewayServiceSettings build() throws IOException {
      return new GatewayServiceSettings(this);
    }
  }
}
