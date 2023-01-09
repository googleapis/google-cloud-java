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

package com.google.cloud.compute.v1;

import static com.google.cloud.compute.v1.NetworkEdgeSecurityServicesClient.AggregatedListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.NetworkEdgeSecurityServicesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkEdgeSecurityServicesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (compute.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkEdgeSecurityServicesSettings.Builder networkEdgeSecurityServicesSettingsBuilder =
 *     NetworkEdgeSecurityServicesSettings.newBuilder();
 * networkEdgeSecurityServicesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         networkEdgeSecurityServicesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkEdgeSecurityServicesSettings networkEdgeSecurityServicesSettings =
 *     networkEdgeSecurityServicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkEdgeSecurityServicesSettings
    extends ClientSettings<NetworkEdgeSecurityServicesSettings> {

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListNetworkEdgeSecurityServicesRequest,
          NetworkEdgeSecurityServiceAggregatedList,
          AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteNetworkEdgeSecurityServiceRequest, Operation> deleteSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
      getSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertNetworkEdgeSecurityServiceRequest, Operation> insertSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
      insertOperationSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public UnaryCallSettings<PatchNetworkEdgeSecurityServiceRequest, Operation> patchSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).patchSettings();
  }

  /** Returns the object with the settings used for calls to patch. */
  public OperationCallSettings<PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
      patchOperationSettings() {
    return ((NetworkEdgeSecurityServicesStubSettings) getStubSettings()).patchOperationSettings();
  }

  public static final NetworkEdgeSecurityServicesSettings create(
      NetworkEdgeSecurityServicesStubSettings stub) throws IOException {
    return new NetworkEdgeSecurityServicesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkEdgeSecurityServicesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkEdgeSecurityServicesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkEdgeSecurityServicesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkEdgeSecurityServicesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkEdgeSecurityServicesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkEdgeSecurityServicesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkEdgeSecurityServicesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkEdgeSecurityServicesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkEdgeSecurityServicesSettings. */
  public static class Builder
      extends ClientSettings.Builder<NetworkEdgeSecurityServicesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkEdgeSecurityServicesStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkEdgeSecurityServicesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkEdgeSecurityServicesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkEdgeSecurityServicesStubSettings.newBuilder());
    }

    public NetworkEdgeSecurityServicesStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkEdgeSecurityServicesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListNetworkEdgeSecurityServicesRequest,
            NetworkEdgeSecurityServiceAggregatedList,
            AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteNetworkEdgeSecurityServiceRequest, Operation>
        deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<
            DeleteNetworkEdgeSecurityServiceRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<
            GetNetworkEdgeSecurityServiceRequest, NetworkEdgeSecurityService>
        getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertNetworkEdgeSecurityServiceRequest, Operation>
        insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<
            InsertNetworkEdgeSecurityServiceRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public UnaryCallSettings.Builder<PatchNetworkEdgeSecurityServiceRequest, Operation>
        patchSettings() {
      return getStubSettingsBuilder().patchSettings();
    }

    /** Returns the builder for the settings used for calls to patch. */
    public OperationCallSettings.Builder<
            PatchNetworkEdgeSecurityServiceRequest, Operation, Operation>
        patchOperationSettings() {
      return getStubSettingsBuilder().patchOperationSettings();
    }

    @Override
    public NetworkEdgeSecurityServicesSettings build() throws IOException {
      return new NetworkEdgeSecurityServicesSettings(this);
    }
  }
}
