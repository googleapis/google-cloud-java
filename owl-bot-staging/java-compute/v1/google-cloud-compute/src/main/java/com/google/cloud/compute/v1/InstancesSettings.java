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

import static com.google.cloud.compute.v1.InstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListReferrersPagedResponse;

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
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.compute.v1.stub.InstancesStubSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link InstancesClient}.
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
 * InstancesSettings.Builder instancesSettingsBuilder = InstancesSettings.newBuilder();
 * instancesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instancesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstancesSettings instancesSettings = instancesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstancesSettings extends ClientSettings<InstancesSettings> {

  /** Returns the object with the settings used for calls to addAccessConfig. */
  public UnaryCallSettings<AddAccessConfigInstanceRequest, Operation> addAccessConfigSettings() {
    return ((InstancesStubSettings) getStubSettings()).addAccessConfigSettings();
  }

  /** Returns the object with the settings used for calls to addAccessConfig. */
  public OperationCallSettings<AddAccessConfigInstanceRequest, Operation, Operation>
      addAccessConfigOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).addAccessConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesSettings() {
    return ((InstancesStubSettings) getStubSettings()).addResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public OperationCallSettings<AddResourcePoliciesInstanceRequest, Operation, Operation>
      addResourcePoliciesOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).addResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return ((InstancesStubSettings) getStubSettings()).aggregatedListSettings();
  }

  /** Returns the object with the settings used for calls to attachDisk. */
  public UnaryCallSettings<AttachDiskInstanceRequest, Operation> attachDiskSettings() {
    return ((InstancesStubSettings) getStubSettings()).attachDiskSettings();
  }

  /** Returns the object with the settings used for calls to attachDisk. */
  public OperationCallSettings<AttachDiskInstanceRequest, Operation, Operation>
      attachDiskOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).attachDiskOperationSettings();
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public UnaryCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
    return ((InstancesStubSettings) getStubSettings()).bulkInsertSettings();
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public OperationCallSettings<BulkInsertInstanceRequest, Operation, Operation>
      bulkInsertOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).bulkInsertOperationSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteSettings();
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceRequest, Operation, Operation>
      deleteOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessConfig. */
  public UnaryCallSettings<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteAccessConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteAccessConfig. */
  public OperationCallSettings<DeleteAccessConfigInstanceRequest, Operation, Operation>
      deleteAccessConfigOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).deleteAccessConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to detachDisk. */
  public UnaryCallSettings<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
    return ((InstancesStubSettings) getStubSettings()).detachDiskSettings();
  }

  /** Returns the object with the settings used for calls to detachDisk. */
  public OperationCallSettings<DetachDiskInstanceRequest, Operation, Operation>
      detachDiskOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).detachDiskOperationSettings();
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getSettings() {
    return ((InstancesStubSettings) getStubSettings()).getSettings();
  }

  /** Returns the object with the settings used for calls to getEffectiveFirewalls. */
  public UnaryCallSettings<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings() {
    return ((InstancesStubSettings) getStubSettings()).getEffectiveFirewallsSettings();
  }

  /** Returns the object with the settings used for calls to getGuestAttributes. */
  public UnaryCallSettings<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesSettings() {
    return ((InstancesStubSettings) getStubSettings()).getGuestAttributesSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyInstanceRequest, Policy> getIamPolicySettings() {
    return ((InstancesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getScreenshot. */
  public UnaryCallSettings<GetScreenshotInstanceRequest, Screenshot> getScreenshotSettings() {
    return ((InstancesStubSettings) getStubSettings()).getScreenshotSettings();
  }

  /** Returns the object with the settings used for calls to getSerialPortOutput. */
  public UnaryCallSettings<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputSettings() {
    return ((InstancesStubSettings) getStubSettings()).getSerialPortOutputSettings();
  }

  /** Returns the object with the settings used for calls to getShieldedInstanceIdentity. */
  public UnaryCallSettings<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentitySettings() {
    return ((InstancesStubSettings) getStubSettings()).getShieldedInstanceIdentitySettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceRequest, Operation> insertSettings() {
    return ((InstancesStubSettings) getStubSettings()).insertSettings();
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceRequest, Operation, Operation>
      insertOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).insertOperationSettings();
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListInstancesRequest, InstanceList, ListPagedResponse> listSettings() {
    return ((InstancesStubSettings) getStubSettings()).listSettings();
  }

  /** Returns the object with the settings used for calls to listReferrers. */
  public PagedCallSettings<
          ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
      listReferrersSettings() {
    return ((InstancesStubSettings) getStubSettings()).listReferrersSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesSettings() {
    return ((InstancesStubSettings) getStubSettings()).removeResourcePoliciesSettings();
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public OperationCallSettings<RemoveResourcePoliciesInstanceRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).removeResourcePoliciesOperationSettings();
  }

  /** Returns the object with the settings used for calls to reset. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetSettings() {
    return ((InstancesStubSettings) getStubSettings()).resetSettings();
  }

  /** Returns the object with the settings used for calls to reset. */
  public OperationCallSettings<ResetInstanceRequest, Operation, Operation>
      resetOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).resetOperationSettings();
  }

  /** Returns the object with the settings used for calls to resume. */
  public UnaryCallSettings<ResumeInstanceRequest, Operation> resumeSettings() {
    return ((InstancesStubSettings) getStubSettings()).resumeSettings();
  }

  /** Returns the object with the settings used for calls to resume. */
  public OperationCallSettings<ResumeInstanceRequest, Operation, Operation>
      resumeOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).resumeOperationSettings();
  }

  /** Returns the object with the settings used for calls to sendDiagnosticInterrupt. */
  public UnaryCallSettings<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptSettings() {
    return ((InstancesStubSettings) getStubSettings()).sendDiagnosticInterruptSettings();
  }

  /** Returns the object with the settings used for calls to setDeletionProtection. */
  public UnaryCallSettings<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionSettings() {
    return ((InstancesStubSettings) getStubSettings()).setDeletionProtectionSettings();
  }

  /** Returns the object with the settings used for calls to setDeletionProtection. */
  public OperationCallSettings<SetDeletionProtectionInstanceRequest, Operation, Operation>
      setDeletionProtectionOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setDeletionProtectionOperationSettings();
  }

  /** Returns the object with the settings used for calls to setDiskAutoDelete. */
  public UnaryCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteSettings() {
    return ((InstancesStubSettings) getStubSettings()).setDiskAutoDeleteSettings();
  }

  /** Returns the object with the settings used for calls to setDiskAutoDelete. */
  public OperationCallSettings<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
      setDiskAutoDeleteOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setDiskAutoDeleteOperationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
    return ((InstancesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
    return ((InstancesStubSettings) getStubSettings()).setLabelsSettings();
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsInstanceRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setLabelsOperationSettings();
  }

  /** Returns the object with the settings used for calls to setMachineResources. */
  public UnaryCallSettings<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMachineResourcesSettings();
  }

  /** Returns the object with the settings used for calls to setMachineResources. */
  public OperationCallSettings<SetMachineResourcesInstanceRequest, Operation, Operation>
      setMachineResourcesOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMachineResourcesOperationSettings();
  }

  /** Returns the object with the settings used for calls to setMachineType. */
  public UnaryCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMachineTypeSettings();
  }

  /** Returns the object with the settings used for calls to setMachineType. */
  public OperationCallSettings<SetMachineTypeInstanceRequest, Operation, Operation>
      setMachineTypeOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMachineTypeOperationSettings();
  }

  /** Returns the object with the settings used for calls to setMetadata. */
  public UnaryCallSettings<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMetadataSettings();
  }

  /** Returns the object with the settings used for calls to setMetadata. */
  public OperationCallSettings<SetMetadataInstanceRequest, Operation, Operation>
      setMetadataOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMetadataOperationSettings();
  }

  /** Returns the object with the settings used for calls to setMinCpuPlatform. */
  public UnaryCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMinCpuPlatformSettings();
  }

  /** Returns the object with the settings used for calls to setMinCpuPlatform. */
  public OperationCallSettings<SetMinCpuPlatformInstanceRequest, Operation, Operation>
      setMinCpuPlatformOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setMinCpuPlatformOperationSettings();
  }

  /** Returns the object with the settings used for calls to setScheduling. */
  public UnaryCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingSettings() {
    return ((InstancesStubSettings) getStubSettings()).setSchedulingSettings();
  }

  /** Returns the object with the settings used for calls to setScheduling. */
  public OperationCallSettings<SetSchedulingInstanceRequest, Operation, Operation>
      setSchedulingOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setSchedulingOperationSettings();
  }

  /** Returns the object with the settings used for calls to setServiceAccount. */
  public UnaryCallSettings<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountSettings() {
    return ((InstancesStubSettings) getStubSettings()).setServiceAccountSettings();
  }

  /** Returns the object with the settings used for calls to setServiceAccount. */
  public OperationCallSettings<SetServiceAccountInstanceRequest, Operation, Operation>
      setServiceAccountOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setServiceAccountOperationSettings();
  }

  /** Returns the object with the settings used for calls to setShieldedInstanceIntegrityPolicy. */
  public UnaryCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicySettings() {
    return ((InstancesStubSettings) getStubSettings()).setShieldedInstanceIntegrityPolicySettings();
  }

  /** Returns the object with the settings used for calls to setShieldedInstanceIntegrityPolicy. */
  public OperationCallSettings<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
      setShieldedInstanceIntegrityPolicyOperationSettings() {
    return ((InstancesStubSettings) getStubSettings())
        .setShieldedInstanceIntegrityPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to setTags. */
  public UnaryCallSettings<SetTagsInstanceRequest, Operation> setTagsSettings() {
    return ((InstancesStubSettings) getStubSettings()).setTagsSettings();
  }

  /** Returns the object with the settings used for calls to setTags. */
  public OperationCallSettings<SetTagsInstanceRequest, Operation, Operation>
      setTagsOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).setTagsOperationSettings();
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public UnaryCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventSettings() {
    return ((InstancesStubSettings) getStubSettings()).simulateMaintenanceEventSettings();
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public OperationCallSettings<SimulateMaintenanceEventInstanceRequest, Operation, Operation>
      simulateMaintenanceEventOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).simulateMaintenanceEventOperationSettings();
  }

  /** Returns the object with the settings used for calls to start. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startSettings() {
    return ((InstancesStubSettings) getStubSettings()).startSettings();
  }

  /** Returns the object with the settings used for calls to start. */
  public OperationCallSettings<StartInstanceRequest, Operation, Operation>
      startOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).startOperationSettings();
  }

  /** Returns the object with the settings used for calls to startWithEncryptionKey. */
  public UnaryCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeySettings() {
    return ((InstancesStubSettings) getStubSettings()).startWithEncryptionKeySettings();
  }

  /** Returns the object with the settings used for calls to startWithEncryptionKey. */
  public OperationCallSettings<StartWithEncryptionKeyInstanceRequest, Operation, Operation>
      startWithEncryptionKeyOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).startWithEncryptionKeyOperationSettings();
  }

  /** Returns the object with the settings used for calls to stop. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopSettings() {
    return ((InstancesStubSettings) getStubSettings()).stopSettings();
  }

  /** Returns the object with the settings used for calls to stop. */
  public OperationCallSettings<StopInstanceRequest, Operation, Operation> stopOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).stopOperationSettings();
  }

  /** Returns the object with the settings used for calls to suspend. */
  public UnaryCallSettings<SuspendInstanceRequest, Operation> suspendSettings() {
    return ((InstancesStubSettings) getStubSettings()).suspendSettings();
  }

  /** Returns the object with the settings used for calls to suspend. */
  public OperationCallSettings<SuspendInstanceRequest, Operation, Operation>
      suspendOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).suspendOperationSettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return ((InstancesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateSettings();
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateInstanceRequest, Operation, Operation>
      updateOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessConfig. */
  public UnaryCallSettings<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateAccessConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateAccessConfig. */
  public OperationCallSettings<UpdateAccessConfigInstanceRequest, Operation, Operation>
      updateAccessConfigOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateAccessConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDisplayDevice. */
  public UnaryCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateDisplayDeviceSettings();
  }

  /** Returns the object with the settings used for calls to updateDisplayDevice. */
  public OperationCallSettings<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
      updateDisplayDeviceOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateDisplayDeviceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkInterface. */
  public UnaryCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateNetworkInterfaceSettings();
  }

  /** Returns the object with the settings used for calls to updateNetworkInterface. */
  public OperationCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
      updateNetworkInterfaceOperationSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateNetworkInterfaceOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public UnaryCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigSettings() {
    return ((InstancesStubSettings) getStubSettings()).updateShieldedInstanceConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public OperationCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
      updateShieldedInstanceConfigOperationSettings() {
    return ((InstancesStubSettings) getStubSettings())
        .updateShieldedInstanceConfigOperationSettings();
  }

  public static final InstancesSettings create(InstancesStubSettings stub) throws IOException {
    return new InstancesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstancesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return InstancesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return InstancesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return InstancesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstancesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return InstancesStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return InstancesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected InstancesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for InstancesSettings. */
  public static class Builder extends ClientSettings.Builder<InstancesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(InstancesStubSettings.newBuilder(clientContext));
    }

    protected Builder(InstancesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(InstancesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(InstancesStubSettings.newBuilder());
    }

    public InstancesStubSettings.Builder getStubSettingsBuilder() {
      return ((InstancesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to addAccessConfig. */
    public UnaryCallSettings.Builder<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigSettings() {
      return getStubSettingsBuilder().addAccessConfigSettings();
    }

    /** Returns the builder for the settings used for calls to addAccessConfig. */
    public OperationCallSettings.Builder<AddAccessConfigInstanceRequest, Operation, Operation>
        addAccessConfigOperationSettings() {
      return getStubSettingsBuilder().addAccessConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesSettings() {
      return getStubSettingsBuilder().addResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public OperationCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation, Operation>
        addResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().addResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return getStubSettingsBuilder().aggregatedListSettings();
    }

    /** Returns the builder for the settings used for calls to attachDisk. */
    public UnaryCallSettings.Builder<AttachDiskInstanceRequest, Operation> attachDiskSettings() {
      return getStubSettingsBuilder().attachDiskSettings();
    }

    /** Returns the builder for the settings used for calls to attachDisk. */
    public OperationCallSettings.Builder<AttachDiskInstanceRequest, Operation, Operation>
        attachDiskOperationSettings() {
      return getStubSettingsBuilder().attachDiskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public UnaryCallSettings.Builder<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
      return getStubSettingsBuilder().bulkInsertSettings();
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public OperationCallSettings.Builder<BulkInsertInstanceRequest, Operation, Operation>
        bulkInsertOperationSettings() {
      return getStubSettingsBuilder().bulkInsertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteSettings() {
      return getStubSettingsBuilder().deleteSettings();
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteInstanceRequest, Operation, Operation>
        deleteOperationSettings() {
      return getStubSettingsBuilder().deleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessConfig. */
    public UnaryCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigSettings() {
      return getStubSettingsBuilder().deleteAccessConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteAccessConfig. */
    public OperationCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation, Operation>
        deleteAccessConfigOperationSettings() {
      return getStubSettingsBuilder().deleteAccessConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to detachDisk. */
    public UnaryCallSettings.Builder<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
      return getStubSettingsBuilder().detachDiskSettings();
    }

    /** Returns the builder for the settings used for calls to detachDisk. */
    public OperationCallSettings.Builder<DetachDiskInstanceRequest, Operation, Operation>
        detachDiskOperationSettings() {
      return getStubSettingsBuilder().detachDiskOperationSettings();
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getSettings() {
      return getStubSettingsBuilder().getSettings();
    }

    /** Returns the builder for the settings used for calls to getEffectiveFirewalls. */
    public UnaryCallSettings.Builder<
            GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings() {
      return getStubSettingsBuilder().getEffectiveFirewallsSettings();
    }

    /** Returns the builder for the settings used for calls to getGuestAttributes. */
    public UnaryCallSettings.Builder<GetGuestAttributesInstanceRequest, GuestAttributes>
        getGuestAttributesSettings() {
      return getStubSettingsBuilder().getGuestAttributesSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyInstanceRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getScreenshot. */
    public UnaryCallSettings.Builder<GetScreenshotInstanceRequest, Screenshot>
        getScreenshotSettings() {
      return getStubSettingsBuilder().getScreenshotSettings();
    }

    /** Returns the builder for the settings used for calls to getSerialPortOutput. */
    public UnaryCallSettings.Builder<GetSerialPortOutputInstanceRequest, SerialPortOutput>
        getSerialPortOutputSettings() {
      return getStubSettingsBuilder().getSerialPortOutputSettings();
    }

    /** Returns the builder for the settings used for calls to getShieldedInstanceIdentity. */
    public UnaryCallSettings.Builder<
            GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
        getShieldedInstanceIdentitySettings() {
      return getStubSettingsBuilder().getShieldedInstanceIdentitySettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceRequest, Operation> insertSettings() {
      return getStubSettingsBuilder().insertSettings();
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertInstanceRequest, Operation, Operation>
        insertOperationSettings() {
      return getStubSettingsBuilder().insertOperationSettings();
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListInstancesRequest, InstanceList, ListPagedResponse>
        listSettings() {
      return getStubSettingsBuilder().listSettings();
    }

    /** Returns the builder for the settings used for calls to listReferrers. */
    public PagedCallSettings.Builder<
            ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
        listReferrersSettings() {
      return getStubSettingsBuilder().listReferrersSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public OperationCallSettings.Builder<
            RemoveResourcePoliciesInstanceRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings() {
      return getStubSettingsBuilder().removeResourcePoliciesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to reset. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetSettings() {
      return getStubSettingsBuilder().resetSettings();
    }

    /** Returns the builder for the settings used for calls to reset. */
    public OperationCallSettings.Builder<ResetInstanceRequest, Operation, Operation>
        resetOperationSettings() {
      return getStubSettingsBuilder().resetOperationSettings();
    }

    /** Returns the builder for the settings used for calls to resume. */
    public UnaryCallSettings.Builder<ResumeInstanceRequest, Operation> resumeSettings() {
      return getStubSettingsBuilder().resumeSettings();
    }

    /** Returns the builder for the settings used for calls to resume. */
    public OperationCallSettings.Builder<ResumeInstanceRequest, Operation, Operation>
        resumeOperationSettings() {
      return getStubSettingsBuilder().resumeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to sendDiagnosticInterrupt. */
    public UnaryCallSettings.Builder<
            SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
        sendDiagnosticInterruptSettings() {
      return getStubSettingsBuilder().sendDiagnosticInterruptSettings();
    }

    /** Returns the builder for the settings used for calls to setDeletionProtection. */
    public UnaryCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionSettings() {
      return getStubSettingsBuilder().setDeletionProtectionSettings();
    }

    /** Returns the builder for the settings used for calls to setDeletionProtection. */
    public OperationCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation, Operation>
        setDeletionProtectionOperationSettings() {
      return getStubSettingsBuilder().setDeletionProtectionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setDiskAutoDelete. */
    public UnaryCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteSettings() {
      return getStubSettingsBuilder().setDiskAutoDeleteSettings();
    }

    /** Returns the builder for the settings used for calls to setDiskAutoDelete. */
    public OperationCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
        setDiskAutoDeleteOperationSettings() {
      return getStubSettingsBuilder().setDiskAutoDeleteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
      return getStubSettingsBuilder().setLabelsSettings();
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public OperationCallSettings.Builder<SetLabelsInstanceRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return getStubSettingsBuilder().setLabelsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setMachineResources. */
    public UnaryCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesSettings() {
      return getStubSettingsBuilder().setMachineResourcesSettings();
    }

    /** Returns the builder for the settings used for calls to setMachineResources. */
    public OperationCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation, Operation>
        setMachineResourcesOperationSettings() {
      return getStubSettingsBuilder().setMachineResourcesOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setMachineType. */
    public UnaryCallSettings.Builder<SetMachineTypeInstanceRequest, Operation>
        setMachineTypeSettings() {
      return getStubSettingsBuilder().setMachineTypeSettings();
    }

    /** Returns the builder for the settings used for calls to setMachineType. */
    public OperationCallSettings.Builder<SetMachineTypeInstanceRequest, Operation, Operation>
        setMachineTypeOperationSettings() {
      return getStubSettingsBuilder().setMachineTypeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setMetadata. */
    public UnaryCallSettings.Builder<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
      return getStubSettingsBuilder().setMetadataSettings();
    }

    /** Returns the builder for the settings used for calls to setMetadata. */
    public OperationCallSettings.Builder<SetMetadataInstanceRequest, Operation, Operation>
        setMetadataOperationSettings() {
      return getStubSettingsBuilder().setMetadataOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setMinCpuPlatform. */
    public UnaryCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformSettings() {
      return getStubSettingsBuilder().setMinCpuPlatformSettings();
    }

    /** Returns the builder for the settings used for calls to setMinCpuPlatform. */
    public OperationCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation, Operation>
        setMinCpuPlatformOperationSettings() {
      return getStubSettingsBuilder().setMinCpuPlatformOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setScheduling. */
    public UnaryCallSettings.Builder<SetSchedulingInstanceRequest, Operation>
        setSchedulingSettings() {
      return getStubSettingsBuilder().setSchedulingSettings();
    }

    /** Returns the builder for the settings used for calls to setScheduling. */
    public OperationCallSettings.Builder<SetSchedulingInstanceRequest, Operation, Operation>
        setSchedulingOperationSettings() {
      return getStubSettingsBuilder().setSchedulingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setServiceAccount. */
    public UnaryCallSettings.Builder<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountSettings() {
      return getStubSettingsBuilder().setServiceAccountSettings();
    }

    /** Returns the builder for the settings used for calls to setServiceAccount. */
    public OperationCallSettings.Builder<SetServiceAccountInstanceRequest, Operation, Operation>
        setServiceAccountOperationSettings() {
      return getStubSettingsBuilder().setServiceAccountOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to setShieldedInstanceIntegrityPolicy.
     */
    public UnaryCallSettings.Builder<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicySettings() {
      return getStubSettingsBuilder().setShieldedInstanceIntegrityPolicySettings();
    }

    /**
     * Returns the builder for the settings used for calls to setShieldedInstanceIntegrityPolicy.
     */
    public OperationCallSettings.Builder<
            SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
        setShieldedInstanceIntegrityPolicyOperationSettings() {
      return getStubSettingsBuilder().setShieldedInstanceIntegrityPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to setTags. */
    public UnaryCallSettings.Builder<SetTagsInstanceRequest, Operation> setTagsSettings() {
      return getStubSettingsBuilder().setTagsSettings();
    }

    /** Returns the builder for the settings used for calls to setTags. */
    public OperationCallSettings.Builder<SetTagsInstanceRequest, Operation, Operation>
        setTagsOperationSettings() {
      return getStubSettingsBuilder().setTagsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    public UnaryCallSettings.Builder<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventSettings() {
      return getStubSettingsBuilder().simulateMaintenanceEventSettings();
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    public OperationCallSettings.Builder<
            SimulateMaintenanceEventInstanceRequest, Operation, Operation>
        simulateMaintenanceEventOperationSettings() {
      return getStubSettingsBuilder().simulateMaintenanceEventOperationSettings();
    }

    /** Returns the builder for the settings used for calls to start. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startSettings() {
      return getStubSettingsBuilder().startSettings();
    }

    /** Returns the builder for the settings used for calls to start. */
    public OperationCallSettings.Builder<StartInstanceRequest, Operation, Operation>
        startOperationSettings() {
      return getStubSettingsBuilder().startOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startWithEncryptionKey. */
    public UnaryCallSettings.Builder<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeySettings() {
      return getStubSettingsBuilder().startWithEncryptionKeySettings();
    }

    /** Returns the builder for the settings used for calls to startWithEncryptionKey. */
    public OperationCallSettings.Builder<
            StartWithEncryptionKeyInstanceRequest, Operation, Operation>
        startWithEncryptionKeyOperationSettings() {
      return getStubSettingsBuilder().startWithEncryptionKeyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to stop. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopSettings() {
      return getStubSettingsBuilder().stopSettings();
    }

    /** Returns the builder for the settings used for calls to stop. */
    public OperationCallSettings.Builder<StopInstanceRequest, Operation, Operation>
        stopOperationSettings() {
      return getStubSettingsBuilder().stopOperationSettings();
    }

    /** Returns the builder for the settings used for calls to suspend. */
    public UnaryCallSettings.Builder<SuspendInstanceRequest, Operation> suspendSettings() {
      return getStubSettingsBuilder().suspendSettings();
    }

    /** Returns the builder for the settings used for calls to suspend. */
    public OperationCallSettings.Builder<SuspendInstanceRequest, Operation, Operation>
        suspendOperationSettings() {
      return getStubSettingsBuilder().suspendOperationSettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateSettings() {
      return getStubSettingsBuilder().updateSettings();
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateInstanceRequest, Operation, Operation>
        updateOperationSettings() {
      return getStubSettingsBuilder().updateOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessConfig. */
    public UnaryCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigSettings() {
      return getStubSettingsBuilder().updateAccessConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateAccessConfig. */
    public OperationCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation, Operation>
        updateAccessConfigOperationSettings() {
      return getStubSettingsBuilder().updateAccessConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDisplayDevice. */
    public UnaryCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceSettings() {
      return getStubSettingsBuilder().updateDisplayDeviceSettings();
    }

    /** Returns the builder for the settings used for calls to updateDisplayDevice. */
    public OperationCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
        updateDisplayDeviceOperationSettings() {
      return getStubSettingsBuilder().updateDisplayDeviceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkInterface. */
    public UnaryCallSettings.Builder<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceSettings() {
      return getStubSettingsBuilder().updateNetworkInterfaceSettings();
    }

    /** Returns the builder for the settings used for calls to updateNetworkInterface. */
    public OperationCallSettings.Builder<
            UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
        updateNetworkInterfaceOperationSettings() {
      return getStubSettingsBuilder().updateNetworkInterfaceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigSettings() {
      return getStubSettingsBuilder().updateShieldedInstanceConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    public OperationCallSettings.Builder<
            UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
        updateShieldedInstanceConfigOperationSettings() {
      return getStubSettingsBuilder().updateShieldedInstanceConfigOperationSettings();
    }

    @Override
    public InstancesSettings build() throws IOException {
      return new InstancesSettings(this);
    }
  }
}
