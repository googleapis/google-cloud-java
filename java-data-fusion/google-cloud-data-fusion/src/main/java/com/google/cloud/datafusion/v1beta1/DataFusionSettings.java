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

package com.google.cloud.datafusion.v1beta1;

import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListDnsPeeringsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListInstancesPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListNamespacesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datafusion.v1beta1.stub.DataFusionStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DataFusionClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datafusion.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getInstance to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataFusionSettings.Builder dataFusionSettingsBuilder = DataFusionSettings.newBuilder();
 * dataFusionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         dataFusionSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataFusionSettings dataFusionSettings = dataFusionSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataFusionSettings extends ClientSettings<DataFusionSettings> {

  /** Returns the object with the settings used for calls to listAvailableVersions. */
  public PagedCallSettings<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          ListAvailableVersionsPagedResponse>
      listAvailableVersionsSettings() {
    return ((DataFusionStubSettings) getStubSettings()).listAvailableVersionsSettings();
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((DataFusionStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((DataFusionStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((DataFusionStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((DataFusionStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to restartInstance. */
  public UnaryCallSettings<RestartInstanceRequest, Operation> restartInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).restartInstanceSettings();
  }

  /** Returns the object with the settings used for calls to restartInstance. */
  public OperationCallSettings<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationSettings() {
    return ((DataFusionStubSettings) getStubSettings()).restartInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return ((DataFusionStubSettings) getStubSettings()).upgradeInstanceSettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings() {
    return ((DataFusionStubSettings) getStubSettings()).upgradeInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to removeIamPolicy. */
  public UnaryCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicySettings() {
    return ((DataFusionStubSettings) getStubSettings()).removeIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to listNamespaces. */
  public PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings() {
    return ((DataFusionStubSettings) getStubSettings()).listNamespacesSettings();
  }

  /** Returns the object with the settings used for calls to addDnsPeering. */
  public UnaryCallSettings<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringSettings() {
    return ((DataFusionStubSettings) getStubSettings()).addDnsPeeringSettings();
  }

  /** Returns the object with the settings used for calls to removeDnsPeering. */
  public UnaryCallSettings<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringSettings() {
    return ((DataFusionStubSettings) getStubSettings()).removeDnsPeeringSettings();
  }

  /** Returns the object with the settings used for calls to listDnsPeerings. */
  public PagedCallSettings<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
      listDnsPeeringsSettings() {
    return ((DataFusionStubSettings) getStubSettings()).listDnsPeeringsSettings();
  }

  public static final DataFusionSettings create(DataFusionStubSettings stub) throws IOException {
    return new DataFusionSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataFusionStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataFusionStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataFusionStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataFusionStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataFusionStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return DataFusionStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataFusionStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataFusionStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected DataFusionSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataFusionSettings. */
  public static class Builder extends ClientSettings.Builder<DataFusionSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataFusionStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataFusionSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataFusionStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataFusionStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(DataFusionStubSettings.newHttpJsonBuilder());
    }

    public DataFusionStubSettings.Builder getStubSettingsBuilder() {
      return ((DataFusionStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listAvailableVersions. */
    public PagedCallSettings.Builder<
            ListAvailableVersionsRequest,
            ListAvailableVersionsResponse,
            ListAvailableVersionsPagedResponse>
        listAvailableVersionsSettings() {
      return getStubSettingsBuilder().listAvailableVersionsSettings();
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return getStubSettingsBuilder().listInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getStubSettingsBuilder().getInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return getStubSettingsBuilder().createInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return getStubSettingsBuilder().createInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return getStubSettingsBuilder().deleteInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return getStubSettingsBuilder().deleteInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to restartInstance. */
    public UnaryCallSettings.Builder<RestartInstanceRequest, Operation> restartInstanceSettings() {
      return getStubSettingsBuilder().restartInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to restartInstance. */
    public OperationCallSettings.Builder<RestartInstanceRequest, Instance, OperationMetadata>
        restartInstanceOperationSettings() {
      return getStubSettingsBuilder().restartInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
      return getStubSettingsBuilder().upgradeInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings() {
      return getStubSettingsBuilder().upgradeInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to removeIamPolicy. */
    public UnaryCallSettings.Builder<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicySettings() {
      return getStubSettingsBuilder().removeIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to listNamespaces. */
    public PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings() {
      return getStubSettingsBuilder().listNamespacesSettings();
    }

    /** Returns the builder for the settings used for calls to addDnsPeering. */
    public UnaryCallSettings.Builder<AddDnsPeeringRequest, AddDnsPeeringResponse>
        addDnsPeeringSettings() {
      return getStubSettingsBuilder().addDnsPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to removeDnsPeering. */
    public UnaryCallSettings.Builder<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
        removeDnsPeeringSettings() {
      return getStubSettingsBuilder().removeDnsPeeringSettings();
    }

    /** Returns the builder for the settings used for calls to listDnsPeerings. */
    public PagedCallSettings.Builder<
            ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
        listDnsPeeringsSettings() {
      return getStubSettingsBuilder().listDnsPeeringsSettings();
    }

    @Override
    public DataFusionSettings build() throws IOException {
      return new DataFusionSettings(this);
    }
  }
}
