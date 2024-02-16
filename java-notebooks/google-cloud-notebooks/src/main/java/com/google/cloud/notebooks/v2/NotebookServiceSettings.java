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

package com.google.cloud.notebooks.v2;

import static com.google.cloud.notebooks.v2.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v2.NotebookServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.notebooks.v2.stub.NotebookServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NotebookServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (notebooks.googleapis.com) and default port (443) are used.
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
 * NotebookServiceSettings.Builder notebookServiceSettingsBuilder =
 *     NotebookServiceSettings.newBuilder();
 * notebookServiceSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         notebookServiceSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotebookServiceSettings notebookServiceSettings = notebookServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NotebookServiceSettings extends ClientSettings<NotebookServiceSettings> {

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).createInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).createInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).updateInstanceSettings();
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).updateInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).deleteInstanceSettings();
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).deleteInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).startInstanceSettings();
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public OperationCallSettings<StartInstanceRequest, Instance, OperationMetadata>
      startInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).startInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).stopInstanceSettings();
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public OperationCallSettings<StopInstanceRequest, Instance, OperationMetadata>
      stopInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).stopInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).resetInstanceSettings();
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, Instance, OperationMetadata>
      resetInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).resetInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to checkInstanceUpgradability. */
  public UnaryCallSettings<CheckInstanceUpgradabilityRequest, CheckInstanceUpgradabilityResponse>
      checkInstanceUpgradabilitySettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).checkInstanceUpgradabilitySettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeInstanceSettings();
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to rollbackInstance. */
  public UnaryCallSettings<RollbackInstanceRequest, Operation> rollbackInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).rollbackInstanceSettings();
  }

  /** Returns the object with the settings used for calls to rollbackInstance. */
  public OperationCallSettings<RollbackInstanceRequest, Instance, OperationMetadata>
      rollbackInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).rollbackInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to diagnoseInstance. */
  public UnaryCallSettings<DiagnoseInstanceRequest, Operation> diagnoseInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).diagnoseInstanceSettings();
  }

  /** Returns the object with the settings used for calls to diagnoseInstance. */
  public OperationCallSettings<DiagnoseInstanceRequest, Instance, OperationMetadata>
      diagnoseInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).diagnoseInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NotebookServiceSettings create(NotebookServiceStubSettings stub)
      throws IOException {
    return new NotebookServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NotebookServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NotebookServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NotebookServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NotebookServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NotebookServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NotebookServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NotebookServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NotebookServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NotebookServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NotebookServiceSettings. */
  public static class Builder extends ClientSettings.Builder<NotebookServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NotebookServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(NotebookServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NotebookServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NotebookServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(NotebookServiceStubSettings.newHttpJsonBuilder());
    }

    public NotebookServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((NotebookServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return getStubSettingsBuilder().updateInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return getStubSettingsBuilder().updateInstanceOperationSettings();
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

    /** Returns the builder for the settings used for calls to startInstance. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings() {
      return getStubSettingsBuilder().startInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    public OperationCallSettings.Builder<StartInstanceRequest, Instance, OperationMetadata>
        startInstanceOperationSettings() {
      return getStubSettingsBuilder().startInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings() {
      return getStubSettingsBuilder().stopInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public OperationCallSettings.Builder<StopInstanceRequest, Instance, OperationMetadata>
        stopInstanceOperationSettings() {
      return getStubSettingsBuilder().stopInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings() {
      return getStubSettingsBuilder().resetInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public OperationCallSettings.Builder<ResetInstanceRequest, Instance, OperationMetadata>
        resetInstanceOperationSettings() {
      return getStubSettingsBuilder().resetInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to checkInstanceUpgradability. */
    public UnaryCallSettings.Builder<
            CheckInstanceUpgradabilityRequest, CheckInstanceUpgradabilityResponse>
        checkInstanceUpgradabilitySettings() {
      return getStubSettingsBuilder().checkInstanceUpgradabilitySettings();
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

    /** Returns the builder for the settings used for calls to rollbackInstance. */
    public UnaryCallSettings.Builder<RollbackInstanceRequest, Operation>
        rollbackInstanceSettings() {
      return getStubSettingsBuilder().rollbackInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to rollbackInstance. */
    public OperationCallSettings.Builder<RollbackInstanceRequest, Instance, OperationMetadata>
        rollbackInstanceOperationSettings() {
      return getStubSettingsBuilder().rollbackInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to diagnoseInstance. */
    public UnaryCallSettings.Builder<DiagnoseInstanceRequest, Operation>
        diagnoseInstanceSettings() {
      return getStubSettingsBuilder().diagnoseInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to diagnoseInstance. */
    public OperationCallSettings.Builder<DiagnoseInstanceRequest, Instance, OperationMetadata>
        diagnoseInstanceOperationSettings() {
      return getStubSettingsBuilder().diagnoseInstanceOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public NotebookServiceSettings build() throws IOException {
      return new NotebookServiceSettings(this);
    }
  }
}
