/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.apiregistry.v1;

import static com.google.cloud.apiregistry.v1.CloudApiRegistryClient.ListLocationsPagedResponse;
import static com.google.cloud.apiregistry.v1.CloudApiRegistryClient.ListMcpServersPagedResponse;
import static com.google.cloud.apiregistry.v1.CloudApiRegistryClient.ListMcpToolsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.apiregistry.v1.stub.CloudApiRegistryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudApiRegistryClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudapiregistry.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMcpServer:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudApiRegistrySettings.Builder cloudApiRegistrySettingsBuilder =
 *     CloudApiRegistrySettings.newBuilder();
 * cloudApiRegistrySettingsBuilder
 *     .getMcpServerSettings()
 *     .setRetrySettings(
 *         cloudApiRegistrySettingsBuilder
 *             .getMcpServerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * CloudApiRegistrySettings cloudApiRegistrySettings = cloudApiRegistrySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@Generated("by gapic-generator-java")
public class CloudApiRegistrySettings extends ClientSettings<CloudApiRegistrySettings> {

  /** Returns the object with the settings used for calls to getMcpServer. */
  public UnaryCallSettings<GetMcpServerRequest, McpServer> getMcpServerSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).getMcpServerSettings();
  }

  /** Returns the object with the settings used for calls to listMcpServers. */
  public PagedCallSettings<
          ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
      listMcpServersSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).listMcpServersSettings();
  }

  /** Returns the object with the settings used for calls to getMcpTool. */
  public UnaryCallSettings<GetMcpToolRequest, McpTool> getMcpToolSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).getMcpToolSettings();
  }

  /** Returns the object with the settings used for calls to listMcpTools. */
  public PagedCallSettings<ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
      listMcpToolsSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).listMcpToolsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CloudApiRegistryStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CloudApiRegistrySettings create(CloudApiRegistryStubSettings stub)
      throws IOException {
    return new CloudApiRegistrySettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudApiRegistryStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudApiRegistryStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudApiRegistryStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudApiRegistryStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CloudApiRegistrySettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudApiRegistrySettings. */
  public static class Builder extends ClientSettings.Builder<CloudApiRegistrySettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudApiRegistryStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudApiRegistrySettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudApiRegistryStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudApiRegistryStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CloudApiRegistryStubSettings.newHttpJsonBuilder());
    }

    public CloudApiRegistryStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudApiRegistryStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getMcpServer. */
    public UnaryCallSettings.Builder<GetMcpServerRequest, McpServer> getMcpServerSettings() {
      return getStubSettingsBuilder().getMcpServerSettings();
    }

    /** Returns the builder for the settings used for calls to listMcpServers. */
    public PagedCallSettings.Builder<
            ListMcpServersRequest, ListMcpServersResponse, ListMcpServersPagedResponse>
        listMcpServersSettings() {
      return getStubSettingsBuilder().listMcpServersSettings();
    }

    /** Returns the builder for the settings used for calls to getMcpTool. */
    public UnaryCallSettings.Builder<GetMcpToolRequest, McpTool> getMcpToolSettings() {
      return getStubSettingsBuilder().getMcpToolSettings();
    }

    /** Returns the builder for the settings used for calls to listMcpTools. */
    public PagedCallSettings.Builder<
            ListMcpToolsRequest, ListMcpToolsResponse, ListMcpToolsPagedResponse>
        listMcpToolsSettings() {
      return getStubSettingsBuilder().listMcpToolsSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public CloudApiRegistrySettings build() throws IOException {
      return new CloudApiRegistrySettings(this);
    }
  }
}
