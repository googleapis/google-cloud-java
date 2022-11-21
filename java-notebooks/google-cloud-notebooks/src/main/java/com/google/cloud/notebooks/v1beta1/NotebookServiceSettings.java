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

package com.google.cloud.notebooks.v1beta1;

import static com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListInstancesPagedResponse;
import static com.google.cloud.notebooks.v1beta1.NotebookServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.notebooks.v1beta1.stub.NotebookServiceStubSettings;
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
 *         notebookServiceSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NotebookServiceSettings notebookServiceSettings = notebookServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
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

  /** Returns the object with the settings used for calls to registerInstance. */
  public UnaryCallSettings<RegisterInstanceRequest, Operation> registerInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).registerInstanceSettings();
  }

  /** Returns the object with the settings used for calls to registerInstance. */
  public OperationCallSettings<RegisterInstanceRequest, Instance, OperationMetadata>
      registerInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).registerInstanceOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceAccelerator. */
  public UnaryCallSettings<SetInstanceAcceleratorRequest, Operation>
      setInstanceAcceleratorSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setInstanceAcceleratorSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceAccelerator. */
  public OperationCallSettings<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
      setInstanceAcceleratorOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .setInstanceAcceleratorOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceMachineType. */
  public UnaryCallSettings<SetInstanceMachineTypeRequest, Operation>
      setInstanceMachineTypeSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setInstanceMachineTypeSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceMachineType. */
  public OperationCallSettings<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
      setInstanceMachineTypeOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .setInstanceMachineTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceLabels. */
  public UnaryCallSettings<SetInstanceLabelsRequest, Operation> setInstanceLabelsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setInstanceLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setInstanceLabels. */
  public OperationCallSettings<SetInstanceLabelsRequest, Instance, OperationMetadata>
      setInstanceLabelsOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).setInstanceLabelsOperationSettings();
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

  /** Returns the object with the settings used for calls to reportInstanceInfo. */
  public UnaryCallSettings<ReportInstanceInfoRequest, Operation> reportInstanceInfoSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).reportInstanceInfoSettings();
  }

  /** Returns the object with the settings used for calls to reportInstanceInfo. */
  public OperationCallSettings<ReportInstanceInfoRequest, Instance, OperationMetadata>
      reportInstanceInfoOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).reportInstanceInfoOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to isInstanceUpgradeable.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
      isInstanceUpgradeableSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).isInstanceUpgradeableSettings();
  }

  /**
   * Returns the object with the settings used for calls to upgradeInstance.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeInstanceSettings();
  }

  /**
   * Returns the object with the settings used for calls to upgradeInstance.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeInstanceOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to upgradeInstanceInternal.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public UnaryCallSettings<UpgradeInstanceInternalRequest, Operation>
      upgradeInstanceInternalSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).upgradeInstanceInternalSettings();
  }

  /**
   * Returns the object with the settings used for calls to upgradeInstanceInternal.
   *
   * @deprecated This method is deprecated and will be removed in the next major version update.
   */
  @Deprecated
  public OperationCallSettings<UpgradeInstanceInternalRequest, Instance, OperationMetadata>
      upgradeInstanceInternalOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings())
        .upgradeInstanceInternalOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEnvironments. */
  public PagedCallSettings<
          ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
      listEnvironmentsSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).listEnvironmentsSettings();
  }

  /** Returns the object with the settings used for calls to getEnvironment. */
  public UnaryCallSettings<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).getEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public UnaryCallSettings<CreateEnvironmentRequest, Operation> createEnvironmentSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).createEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to createEnvironment. */
  public OperationCallSettings<CreateEnvironmentRequest, Environment, OperationMetadata>
      createEnvironmentOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).createEnvironmentOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public UnaryCallSettings<DeleteEnvironmentRequest, Operation> deleteEnvironmentSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).deleteEnvironmentSettings();
  }

  /** Returns the object with the settings used for calls to deleteEnvironment. */
  public OperationCallSettings<DeleteEnvironmentRequest, Empty, OperationMetadata>
      deleteEnvironmentOperationSettings() {
    return ((NotebookServiceStubSettings) getStubSettings()).deleteEnvironmentOperationSettings();
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

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NotebookServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NotebookServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NotebookServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

    /** Returns the builder for the settings used for calls to registerInstance. */
    public UnaryCallSettings.Builder<RegisterInstanceRequest, Operation>
        registerInstanceSettings() {
      return getStubSettingsBuilder().registerInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to registerInstance. */
    public OperationCallSettings.Builder<RegisterInstanceRequest, Instance, OperationMetadata>
        registerInstanceOperationSettings() {
      return getStubSettingsBuilder().registerInstanceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceAccelerator. */
    public UnaryCallSettings.Builder<SetInstanceAcceleratorRequest, Operation>
        setInstanceAcceleratorSettings() {
      return getStubSettingsBuilder().setInstanceAcceleratorSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceAccelerator. */
    public OperationCallSettings.Builder<SetInstanceAcceleratorRequest, Instance, OperationMetadata>
        setInstanceAcceleratorOperationSettings() {
      return getStubSettingsBuilder().setInstanceAcceleratorOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceMachineType. */
    public UnaryCallSettings.Builder<SetInstanceMachineTypeRequest, Operation>
        setInstanceMachineTypeSettings() {
      return getStubSettingsBuilder().setInstanceMachineTypeSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceMachineType. */
    public OperationCallSettings.Builder<SetInstanceMachineTypeRequest, Instance, OperationMetadata>
        setInstanceMachineTypeOperationSettings() {
      return getStubSettingsBuilder().setInstanceMachineTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceLabels. */
    public UnaryCallSettings.Builder<SetInstanceLabelsRequest, Operation>
        setInstanceLabelsSettings() {
      return getStubSettingsBuilder().setInstanceLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setInstanceLabels. */
    public OperationCallSettings.Builder<SetInstanceLabelsRequest, Instance, OperationMetadata>
        setInstanceLabelsOperationSettings() {
      return getStubSettingsBuilder().setInstanceLabelsOperationSettings();
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

    /** Returns the builder for the settings used for calls to reportInstanceInfo. */
    public UnaryCallSettings.Builder<ReportInstanceInfoRequest, Operation>
        reportInstanceInfoSettings() {
      return getStubSettingsBuilder().reportInstanceInfoSettings();
    }

    /** Returns the builder for the settings used for calls to reportInstanceInfo. */
    public OperationCallSettings.Builder<ReportInstanceInfoRequest, Instance, OperationMetadata>
        reportInstanceInfoOperationSettings() {
      return getStubSettingsBuilder().reportInstanceInfoOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to isInstanceUpgradeable.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<IsInstanceUpgradeableRequest, IsInstanceUpgradeableResponse>
        isInstanceUpgradeableSettings() {
      return getStubSettingsBuilder().isInstanceUpgradeableSettings();
    }

    /**
     * Returns the builder for the settings used for calls to upgradeInstance.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
      return getStubSettingsBuilder().upgradeInstanceSettings();
    }

    /**
     * Returns the builder for the settings used for calls to upgradeInstance.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings() {
      return getStubSettingsBuilder().upgradeInstanceOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to upgradeInstanceInternal.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public UnaryCallSettings.Builder<UpgradeInstanceInternalRequest, Operation>
        upgradeInstanceInternalSettings() {
      return getStubSettingsBuilder().upgradeInstanceInternalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to upgradeInstanceInternal.
     *
     * @deprecated This method is deprecated and will be removed in the next major version update.
     */
    @Deprecated
    public OperationCallSettings.Builder<
            UpgradeInstanceInternalRequest, Instance, OperationMetadata>
        upgradeInstanceInternalOperationSettings() {
      return getStubSettingsBuilder().upgradeInstanceInternalOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEnvironments. */
    public PagedCallSettings.Builder<
            ListEnvironmentsRequest, ListEnvironmentsResponse, ListEnvironmentsPagedResponse>
        listEnvironmentsSettings() {
      return getStubSettingsBuilder().listEnvironmentsSettings();
    }

    /** Returns the builder for the settings used for calls to getEnvironment. */
    public UnaryCallSettings.Builder<GetEnvironmentRequest, Environment> getEnvironmentSettings() {
      return getStubSettingsBuilder().getEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public UnaryCallSettings.Builder<CreateEnvironmentRequest, Operation>
        createEnvironmentSettings() {
      return getStubSettingsBuilder().createEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to createEnvironment. */
    public OperationCallSettings.Builder<CreateEnvironmentRequest, Environment, OperationMetadata>
        createEnvironmentOperationSettings() {
      return getStubSettingsBuilder().createEnvironmentOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public UnaryCallSettings.Builder<DeleteEnvironmentRequest, Operation>
        deleteEnvironmentSettings() {
      return getStubSettingsBuilder().deleteEnvironmentSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEnvironment. */
    public OperationCallSettings.Builder<DeleteEnvironmentRequest, Empty, OperationMetadata>
        deleteEnvironmentOperationSettings() {
      return getStubSettingsBuilder().deleteEnvironmentOperationSettings();
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
