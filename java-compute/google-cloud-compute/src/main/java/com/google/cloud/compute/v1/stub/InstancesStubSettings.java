/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1.stub;

import static com.google.cloud.compute.v1.InstancesClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListPagedResponse;
import static com.google.cloud.compute.v1.InstancesClient.ListReferrersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.AddAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.AddResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.AggregatedListInstancesRequest;
import com.google.cloud.compute.v1.AttachDiskInstanceRequest;
import com.google.cloud.compute.v1.BulkInsertInstanceRequest;
import com.google.cloud.compute.v1.DeleteAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.DeleteInstanceRequest;
import com.google.cloud.compute.v1.DetachDiskInstanceRequest;
import com.google.cloud.compute.v1.GetEffectiveFirewallsInstanceRequest;
import com.google.cloud.compute.v1.GetGuestAttributesInstanceRequest;
import com.google.cloud.compute.v1.GetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.GetInstanceRequest;
import com.google.cloud.compute.v1.GetScreenshotInstanceRequest;
import com.google.cloud.compute.v1.GetSerialPortOutputInstanceRequest;
import com.google.cloud.compute.v1.GetShieldedInstanceIdentityInstanceRequest;
import com.google.cloud.compute.v1.GuestAttributes;
import com.google.cloud.compute.v1.InsertInstanceRequest;
import com.google.cloud.compute.v1.Instance;
import com.google.cloud.compute.v1.InstanceAggregatedList;
import com.google.cloud.compute.v1.InstanceList;
import com.google.cloud.compute.v1.InstanceListReferrers;
import com.google.cloud.compute.v1.InstancesGetEffectiveFirewallsResponse;
import com.google.cloud.compute.v1.InstancesScopedList;
import com.google.cloud.compute.v1.ListInstancesRequest;
import com.google.cloud.compute.v1.ListReferrersInstancesRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.Reference;
import com.google.cloud.compute.v1.RemoveResourcePoliciesInstanceRequest;
import com.google.cloud.compute.v1.ResetInstanceRequest;
import com.google.cloud.compute.v1.Screenshot;
import com.google.cloud.compute.v1.SerialPortOutput;
import com.google.cloud.compute.v1.SetDeletionProtectionInstanceRequest;
import com.google.cloud.compute.v1.SetDiskAutoDeleteInstanceRequest;
import com.google.cloud.compute.v1.SetIamPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetLabelsInstanceRequest;
import com.google.cloud.compute.v1.SetMachineResourcesInstanceRequest;
import com.google.cloud.compute.v1.SetMachineTypeInstanceRequest;
import com.google.cloud.compute.v1.SetMetadataInstanceRequest;
import com.google.cloud.compute.v1.SetMinCpuPlatformInstanceRequest;
import com.google.cloud.compute.v1.SetSchedulingInstanceRequest;
import com.google.cloud.compute.v1.SetServiceAccountInstanceRequest;
import com.google.cloud.compute.v1.SetShieldedInstanceIntegrityPolicyInstanceRequest;
import com.google.cloud.compute.v1.SetTagsInstanceRequest;
import com.google.cloud.compute.v1.ShieldedInstanceIdentity;
import com.google.cloud.compute.v1.SimulateMaintenanceEventInstanceRequest;
import com.google.cloud.compute.v1.StartInstanceRequest;
import com.google.cloud.compute.v1.StartWithEncryptionKeyInstanceRequest;
import com.google.cloud.compute.v1.StopInstanceRequest;
import com.google.cloud.compute.v1.TestIamPermissionsInstanceRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateAccessConfigInstanceRequest;
import com.google.cloud.compute.v1.UpdateDisplayDeviceInstanceRequest;
import com.google.cloud.compute.v1.UpdateInstanceRequest;
import com.google.cloud.compute.v1.UpdateNetworkInterfaceInstanceRequest;
import com.google.cloud.compute.v1.UpdateShieldedInstanceConfigInstanceRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link InstancesStub}.
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
 * <p>For example, to set the total timeout of addAccessConfig to 30 seconds:
 *
 * <pre>
 * <code>
 * InstancesStubSettings.Builder instancesSettingsBuilder =
 *     InstancesStubSettings.newBuilder();
 * instancesSettingsBuilder
 *     .addAccessConfigSettings()
 *     .setRetrySettings(
 *         instancesSettingsBuilder.addAccessConfigSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstancesStubSettings instancesSettings = instancesSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class InstancesStubSettings extends StubSettings<InstancesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/compute.readonly")
          .build();

  private final UnaryCallSettings<AddAccessConfigInstanceRequest, Operation>
      addAccessConfigSettings;
  private final UnaryCallSettings<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesSettings;
  private final PagedCallSettings<
          AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<AttachDiskInstanceRequest, Operation> attachDiskSettings;
  private final UnaryCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteSettings;
  private final UnaryCallSettings<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigSettings;
  private final UnaryCallSettings<DetachDiskInstanceRequest, Operation> detachDiskSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getSettings;
  private final UnaryCallSettings<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings;
  private final UnaryCallSettings<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesSettings;
  private final UnaryCallSettings<GetIamPolicyInstanceRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<GetScreenshotInstanceRequest, Screenshot> getScreenshotSettings;
  private final UnaryCallSettings<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputSettings;
  private final UnaryCallSettings<
          GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentitySettings;
  private final UnaryCallSettings<InsertInstanceRequest, Operation> insertSettings;
  private final PagedCallSettings<ListInstancesRequest, InstanceList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
      listReferrersSettings;
  private final UnaryCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetSettings;
  private final UnaryCallSettings<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionSettings;
  private final UnaryCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteSettings;
  private final UnaryCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetLabelsInstanceRequest, Operation> setLabelsSettings;
  private final UnaryCallSettings<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesSettings;
  private final UnaryCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeSettings;
  private final UnaryCallSettings<SetMetadataInstanceRequest, Operation> setMetadataSettings;
  private final UnaryCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformSettings;
  private final UnaryCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingSettings;
  private final UnaryCallSettings<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountSettings;
  private final UnaryCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicySettings;
  private final UnaryCallSettings<SetTagsInstanceRequest, Operation> setTagsSettings;
  private final UnaryCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventSettings;
  private final UnaryCallSettings<StartInstanceRequest, Operation> startSettings;
  private final UnaryCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeySettings;
  private final UnaryCallSettings<StopInstanceRequest, Operation> stopSettings;
  private final UnaryCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateSettings;
  private final UnaryCallSettings<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigSettings;
  private final UnaryCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceSettings;
  private final UnaryCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceSettings;
  private final UnaryCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigSettings;

  /** Returns the object with the settings used for calls to addAccessConfig. */
  public UnaryCallSettings<AddAccessConfigInstanceRequest, Operation> addAccessConfigSettings() {
    return addAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesSettings() {
    return addResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to attachDisk. */
  public UnaryCallSettings<AttachDiskInstanceRequest, Operation> attachDiskSettings() {
    return attachDiskSettings;
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public UnaryCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
    return bulkInsertSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessConfig. */
  public UnaryCallSettings<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigSettings() {
    return deleteAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to detachDisk. */
  public UnaryCallSettings<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
    return detachDiskSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getEffectiveFirewalls. */
  public UnaryCallSettings<
          GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
      getEffectiveFirewallsSettings() {
    return getEffectiveFirewallsSettings;
  }

  /** Returns the object with the settings used for calls to getGuestAttributes. */
  public UnaryCallSettings<GetGuestAttributesInstanceRequest, GuestAttributes>
      getGuestAttributesSettings() {
    return getGuestAttributesSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyInstanceRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getScreenshot. */
  public UnaryCallSettings<GetScreenshotInstanceRequest, Screenshot> getScreenshotSettings() {
    return getScreenshotSettings;
  }

  /** Returns the object with the settings used for calls to getSerialPortOutput. */
  public UnaryCallSettings<GetSerialPortOutputInstanceRequest, SerialPortOutput>
      getSerialPortOutputSettings() {
    return getSerialPortOutputSettings;
  }

  /** Returns the object with the settings used for calls to getShieldedInstanceIdentity. */
  public UnaryCallSettings<GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
      getShieldedInstanceIdentitySettings() {
    return getShieldedInstanceIdentitySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertInstanceRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListInstancesRequest, InstanceList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to listReferrers. */
  public PagedCallSettings<
          ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
      listReferrersSettings() {
    return listReferrersSettings;
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesSettings() {
    return removeResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to reset. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetSettings() {
    return resetSettings;
  }

  /** Returns the object with the settings used for calls to setDeletionProtection. */
  public UnaryCallSettings<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionSettings() {
    return setDeletionProtectionSettings;
  }

  /** Returns the object with the settings used for calls to setDiskAutoDelete. */
  public UnaryCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteSettings() {
    return setDiskAutoDeleteSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setMachineResources. */
  public UnaryCallSettings<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesSettings() {
    return setMachineResourcesSettings;
  }

  /** Returns the object with the settings used for calls to setMachineType. */
  public UnaryCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeSettings() {
    return setMachineTypeSettings;
  }

  /** Returns the object with the settings used for calls to setMetadata. */
  public UnaryCallSettings<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
    return setMetadataSettings;
  }

  /** Returns the object with the settings used for calls to setMinCpuPlatform. */
  public UnaryCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformSettings() {
    return setMinCpuPlatformSettings;
  }

  /** Returns the object with the settings used for calls to setScheduling. */
  public UnaryCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingSettings() {
    return setSchedulingSettings;
  }

  /** Returns the object with the settings used for calls to setServiceAccount. */
  public UnaryCallSettings<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountSettings() {
    return setServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to setShieldedInstanceIntegrityPolicy. */
  public UnaryCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicySettings() {
    return setShieldedInstanceIntegrityPolicySettings;
  }

  /** Returns the object with the settings used for calls to setTags. */
  public UnaryCallSettings<SetTagsInstanceRequest, Operation> setTagsSettings() {
    return setTagsSettings;
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public UnaryCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventSettings() {
    return simulateMaintenanceEventSettings;
  }

  /** Returns the object with the settings used for calls to start. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startSettings() {
    return startSettings;
  }

  /** Returns the object with the settings used for calls to startWithEncryptionKey. */
  public UnaryCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeySettings() {
    return startWithEncryptionKeySettings;
  }

  /** Returns the object with the settings used for calls to stop. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopSettings() {
    return stopSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessConfig. */
  public UnaryCallSettings<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigSettings() {
    return updateAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateDisplayDevice. */
  public UnaryCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceSettings() {
    return updateDisplayDeviceSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkInterface. */
  public UnaryCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceSettings() {
    return updateNetworkInterfaceSettings;
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public UnaryCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigSettings() {
    return updateShieldedInstanceConfigSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public InstancesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstancesStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com";
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return 443;
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(InstancesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected InstancesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addAccessConfigSettings = settingsBuilder.addAccessConfigSettings().build();
    addResourcePoliciesSettings = settingsBuilder.addResourcePoliciesSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    attachDiskSettings = settingsBuilder.attachDiskSettings().build();
    bulkInsertSettings = settingsBuilder.bulkInsertSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteAccessConfigSettings = settingsBuilder.deleteAccessConfigSettings().build();
    detachDiskSettings = settingsBuilder.detachDiskSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getEffectiveFirewallsSettings = settingsBuilder.getEffectiveFirewallsSettings().build();
    getGuestAttributesSettings = settingsBuilder.getGuestAttributesSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getScreenshotSettings = settingsBuilder.getScreenshotSettings().build();
    getSerialPortOutputSettings = settingsBuilder.getSerialPortOutputSettings().build();
    getShieldedInstanceIdentitySettings =
        settingsBuilder.getShieldedInstanceIdentitySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listReferrersSettings = settingsBuilder.listReferrersSettings().build();
    removeResourcePoliciesSettings = settingsBuilder.removeResourcePoliciesSettings().build();
    resetSettings = settingsBuilder.resetSettings().build();
    setDeletionProtectionSettings = settingsBuilder.setDeletionProtectionSettings().build();
    setDiskAutoDeleteSettings = settingsBuilder.setDiskAutoDeleteSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setMachineResourcesSettings = settingsBuilder.setMachineResourcesSettings().build();
    setMachineTypeSettings = settingsBuilder.setMachineTypeSettings().build();
    setMetadataSettings = settingsBuilder.setMetadataSettings().build();
    setMinCpuPlatformSettings = settingsBuilder.setMinCpuPlatformSettings().build();
    setSchedulingSettings = settingsBuilder.setSchedulingSettings().build();
    setServiceAccountSettings = settingsBuilder.setServiceAccountSettings().build();
    setShieldedInstanceIntegrityPolicySettings =
        settingsBuilder.setShieldedInstanceIntegrityPolicySettings().build();
    setTagsSettings = settingsBuilder.setTagsSettings().build();
    simulateMaintenanceEventSettings = settingsBuilder.simulateMaintenanceEventSettings().build();
    startSettings = settingsBuilder.startSettings().build();
    startWithEncryptionKeySettings = settingsBuilder.startWithEncryptionKeySettings().build();
    stopSettings = settingsBuilder.stopSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateAccessConfigSettings = settingsBuilder.updateAccessConfigSettings().build();
    updateDisplayDeviceSettings = settingsBuilder.updateDisplayDeviceSettings().build();
    updateNetworkInterfaceSettings = settingsBuilder.updateNetworkInterfaceSettings().build();
    updateShieldedInstanceConfigSettings =
        settingsBuilder.updateShieldedInstanceConfigSettings().build();
  }

  private static final PagedListDescriptor<
          AggregatedListInstancesRequest,
          InstanceAggregatedList,
          Entry<String, InstancesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListInstancesRequest,
              InstanceAggregatedList,
              Entry<String, InstancesScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListInstancesRequest injectToken(
                AggregatedListInstancesRequest payload, String token) {
              return AggregatedListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListInstancesRequest injectPageSize(
                AggregatedListInstancesRequest payload, int pageSize) {
              return AggregatedListInstancesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(AggregatedListInstancesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Entry<String, InstancesScopedList>> extractResources(
                InstanceAggregatedList payload) {
              return payload.getItemsMap() != null
                  ? payload.getItemsMap().entrySet()
                  : ImmutableList.<Entry<String, InstancesScopedList>>of();
            }
          };

  private static final PagedListDescriptor<ListInstancesRequest, InstanceList, Instance>
      LIST_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, InstanceList, Instance>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInstancesRequest injectToken(ListInstancesRequest payload, String token) {
              return ListInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInstancesRequest injectPageSize(ListInstancesRequest payload, int pageSize) {
              return ListInstancesRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(InstanceList payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Instance>of();
            }
          };

  private static final PagedListDescriptor<
          ListReferrersInstancesRequest, InstanceListReferrers, Reference>
      LIST_REFERRERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListReferrersInstancesRequest, InstanceListReferrers, Reference>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListReferrersInstancesRequest injectToken(
                ListReferrersInstancesRequest payload, String token) {
              return ListReferrersInstancesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListReferrersInstancesRequest injectPageSize(
                ListReferrersInstancesRequest payload, int pageSize) {
              return ListReferrersInstancesRequest.newBuilder(payload)
                  .setMaxResults(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListReferrersInstancesRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(InstanceListReferrers payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Reference> extractResources(InstanceListReferrers payload) {
              return payload.getItemsList() != null
                  ? payload.getItemsList()
                  : ImmutableList.<Reference>of();
            }
          };

  private static final PagedListResponseFactory<
          AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListInstancesRequest,
              InstanceAggregatedList,
              AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListInstancesRequest, InstanceAggregatedList> callable,
                AggregatedListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<InstanceAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListInstancesRequest,
                      InstanceAggregatedList,
                      Entry<String, InstancesScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRequest, InstanceList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListInstancesRequest, InstanceList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, InstanceList> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<InstanceList> futureResponse) {
              PageContext<ListInstancesRequest, InstanceList, Instance> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
      LIST_REFERRERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>() {
            @Override
            public ApiFuture<ListReferrersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListReferrersInstancesRequest, InstanceListReferrers> callable,
                ListReferrersInstancesRequest request,
                ApiCallContext context,
                ApiFuture<InstanceListReferrers> futureResponse) {
              PageContext<ListReferrersInstancesRequest, InstanceListReferrers, Reference>
                  pageContext =
                      PageContext.create(callable, LIST_REFERRERS_PAGE_STR_DESC, request, context);
              return ListReferrersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for InstancesStubSettings. */
  public static class Builder extends StubSettings.Builder<InstancesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigSettings;
    private final UnaryCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesSettings;
    private final PagedCallSettings.Builder<
            AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<AttachDiskInstanceRequest, Operation>
        attachDiskSettings;
    private final UnaryCallSettings.Builder<BulkInsertInstanceRequest, Operation>
        bulkInsertSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteSettings;
    private final UnaryCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigSettings;
    private final UnaryCallSettings.Builder<DetachDiskInstanceRequest, Operation>
        detachDiskSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getSettings;
    private final UnaryCallSettings.Builder<
            GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings;
    private final UnaryCallSettings.Builder<GetGuestAttributesInstanceRequest, GuestAttributes>
        getGuestAttributesSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyInstanceRequest, Policy>
        getIamPolicySettings;
    private final UnaryCallSettings.Builder<GetScreenshotInstanceRequest, Screenshot>
        getScreenshotSettings;
    private final UnaryCallSettings.Builder<GetSerialPortOutputInstanceRequest, SerialPortOutput>
        getSerialPortOutputSettings;
    private final UnaryCallSettings.Builder<
            GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
        getShieldedInstanceIdentitySettings;
    private final UnaryCallSettings.Builder<InsertInstanceRequest, Operation> insertSettings;
    private final PagedCallSettings.Builder<ListInstancesRequest, InstanceList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
        listReferrersSettings;
    private final UnaryCallSettings.Builder<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetSettings;
    private final UnaryCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionSettings;
    private final UnaryCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyInstanceRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetLabelsInstanceRequest, Operation> setLabelsSettings;
    private final UnaryCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesSettings;
    private final UnaryCallSettings.Builder<SetMachineTypeInstanceRequest, Operation>
        setMachineTypeSettings;
    private final UnaryCallSettings.Builder<SetMetadataInstanceRequest, Operation>
        setMetadataSettings;
    private final UnaryCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformSettings;
    private final UnaryCallSettings.Builder<SetSchedulingInstanceRequest, Operation>
        setSchedulingSettings;
    private final UnaryCallSettings.Builder<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountSettings;
    private final UnaryCallSettings.Builder<
            SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicySettings;
    private final UnaryCallSettings.Builder<SetTagsInstanceRequest, Operation> setTagsSettings;
    private final UnaryCallSettings.Builder<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventSettings;
    private final UnaryCallSettings.Builder<StartInstanceRequest, Operation> startSettings;
    private final UnaryCallSettings.Builder<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeySettings;
    private final UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateSettings;
    private final UnaryCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigSettings;
    private final UnaryCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceSettings;
    private final UnaryCallSettings.Builder<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(20000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(20000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      addResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);

      attachDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      bulkInsertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      detachDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getEffectiveFirewallsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getGuestAttributesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getScreenshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getSerialPortOutputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      getShieldedInstanceIdentitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);

      listReferrersSettings = PagedCallSettings.newBuilder(LIST_REFERRERS_PAGE_STR_FACT);

      removeResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      resetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setDeletionProtectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setDiskAutoDeleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMachineResourcesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMachineTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setMinCpuPlatformSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setSchedulingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setShieldedInstanceIntegrityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      setTagsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      simulateMaintenanceEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      startSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      startWithEncryptionKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      stopSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateDisplayDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateNetworkInterfaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateShieldedInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addAccessConfigSettings,
              addResourcePoliciesSettings,
              aggregatedListSettings,
              attachDiskSettings,
              bulkInsertSettings,
              deleteSettings,
              deleteAccessConfigSettings,
              detachDiskSettings,
              getSettings,
              getEffectiveFirewallsSettings,
              getGuestAttributesSettings,
              getIamPolicySettings,
              getScreenshotSettings,
              getSerialPortOutputSettings,
              getShieldedInstanceIdentitySettings,
              insertSettings,
              listSettings,
              listReferrersSettings,
              removeResourcePoliciesSettings,
              resetSettings,
              setDeletionProtectionSettings,
              setDiskAutoDeleteSettings,
              setIamPolicySettings,
              setLabelsSettings,
              setMachineResourcesSettings,
              setMachineTypeSettings,
              setMetadataSettings,
              setMinCpuPlatformSettings,
              setSchedulingSettings,
              setServiceAccountSettings,
              setShieldedInstanceIntegrityPolicySettings,
              setTagsSettings,
              simulateMaintenanceEventSettings,
              startSettings,
              startWithEncryptionKeySettings,
              stopSettings,
              testIamPermissionsSettings,
              updateSettings,
              updateAccessConfigSettings,
              updateDisplayDeviceSettings,
              updateNetworkInterfaceSettings,
              updateShieldedInstanceConfigSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .addAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .addResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .attachDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .bulkInsertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .detachDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getEffectiveFirewallsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getGuestAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getScreenshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSerialPortOutputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getShieldedInstanceIdentitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listReferrersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .removeResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .resetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setDeletionProtectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setDiskAutoDeleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMachineResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMachineTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setMinCpuPlatformSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setSchedulingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setShieldedInstanceIntegrityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .simulateMaintenanceEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .startSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .startWithEncryptionKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .stopSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateDisplayDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateNetworkInterfaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateShieldedInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(InstancesStubSettings settings) {
      super(settings);

      addAccessConfigSettings = settings.addAccessConfigSettings.toBuilder();
      addResourcePoliciesSettings = settings.addResourcePoliciesSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      attachDiskSettings = settings.attachDiskSettings.toBuilder();
      bulkInsertSettings = settings.bulkInsertSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteAccessConfigSettings = settings.deleteAccessConfigSettings.toBuilder();
      detachDiskSettings = settings.detachDiskSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getEffectiveFirewallsSettings = settings.getEffectiveFirewallsSettings.toBuilder();
      getGuestAttributesSettings = settings.getGuestAttributesSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getScreenshotSettings = settings.getScreenshotSettings.toBuilder();
      getSerialPortOutputSettings = settings.getSerialPortOutputSettings.toBuilder();
      getShieldedInstanceIdentitySettings =
          settings.getShieldedInstanceIdentitySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listReferrersSettings = settings.listReferrersSettings.toBuilder();
      removeResourcePoliciesSettings = settings.removeResourcePoliciesSettings.toBuilder();
      resetSettings = settings.resetSettings.toBuilder();
      setDeletionProtectionSettings = settings.setDeletionProtectionSettings.toBuilder();
      setDiskAutoDeleteSettings = settings.setDiskAutoDeleteSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setMachineResourcesSettings = settings.setMachineResourcesSettings.toBuilder();
      setMachineTypeSettings = settings.setMachineTypeSettings.toBuilder();
      setMetadataSettings = settings.setMetadataSettings.toBuilder();
      setMinCpuPlatformSettings = settings.setMinCpuPlatformSettings.toBuilder();
      setSchedulingSettings = settings.setSchedulingSettings.toBuilder();
      setServiceAccountSettings = settings.setServiceAccountSettings.toBuilder();
      setShieldedInstanceIntegrityPolicySettings =
          settings.setShieldedInstanceIntegrityPolicySettings.toBuilder();
      setTagsSettings = settings.setTagsSettings.toBuilder();
      simulateMaintenanceEventSettings = settings.simulateMaintenanceEventSettings.toBuilder();
      startSettings = settings.startSettings.toBuilder();
      startWithEncryptionKeySettings = settings.startWithEncryptionKeySettings.toBuilder();
      stopSettings = settings.stopSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateAccessConfigSettings = settings.updateAccessConfigSettings.toBuilder();
      updateDisplayDeviceSettings = settings.updateDisplayDeviceSettings.toBuilder();
      updateNetworkInterfaceSettings = settings.updateNetworkInterfaceSettings.toBuilder();
      updateShieldedInstanceConfigSettings =
          settings.updateShieldedInstanceConfigSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addAccessConfigSettings,
              addResourcePoliciesSettings,
              aggregatedListSettings,
              attachDiskSettings,
              bulkInsertSettings,
              deleteSettings,
              deleteAccessConfigSettings,
              detachDiskSettings,
              getSettings,
              getEffectiveFirewallsSettings,
              getGuestAttributesSettings,
              getIamPolicySettings,
              getScreenshotSettings,
              getSerialPortOutputSettings,
              getShieldedInstanceIdentitySettings,
              insertSettings,
              listSettings,
              listReferrersSettings,
              removeResourcePoliciesSettings,
              resetSettings,
              setDeletionProtectionSettings,
              setDiskAutoDeleteSettings,
              setIamPolicySettings,
              setLabelsSettings,
              setMachineResourcesSettings,
              setMachineTypeSettings,
              setMetadataSettings,
              setMinCpuPlatformSettings,
              setSchedulingSettings,
              setServiceAccountSettings,
              setShieldedInstanceIntegrityPolicySettings,
              setTagsSettings,
              simulateMaintenanceEventSettings,
              startSettings,
              startWithEncryptionKeySettings,
              stopSettings,
              testIamPermissionsSettings,
              updateSettings,
              updateAccessConfigSettings,
              updateDisplayDeviceSettings,
              updateNetworkInterfaceSettings,
              updateShieldedInstanceConfigSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to addAccessConfig. */
    public UnaryCallSettings.Builder<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigSettings() {
      return addAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesSettings() {
      return addResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to attachDisk. */
    public UnaryCallSettings.Builder<AttachDiskInstanceRequest, Operation> attachDiskSettings() {
      return attachDiskSettings;
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public UnaryCallSettings.Builder<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
      return bulkInsertSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessConfig. */
    public UnaryCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigSettings() {
      return deleteAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to detachDisk. */
    public UnaryCallSettings.Builder<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
      return detachDiskSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getEffectiveFirewalls. */
    public UnaryCallSettings.Builder<
            GetEffectiveFirewallsInstanceRequest, InstancesGetEffectiveFirewallsResponse>
        getEffectiveFirewallsSettings() {
      return getEffectiveFirewallsSettings;
    }

    /** Returns the builder for the settings used for calls to getGuestAttributes. */
    public UnaryCallSettings.Builder<GetGuestAttributesInstanceRequest, GuestAttributes>
        getGuestAttributesSettings() {
      return getGuestAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyInstanceRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getScreenshot. */
    public UnaryCallSettings.Builder<GetScreenshotInstanceRequest, Screenshot>
        getScreenshotSettings() {
      return getScreenshotSettings;
    }

    /** Returns the builder for the settings used for calls to getSerialPortOutput. */
    public UnaryCallSettings.Builder<GetSerialPortOutputInstanceRequest, SerialPortOutput>
        getSerialPortOutputSettings() {
      return getSerialPortOutputSettings;
    }

    /** Returns the builder for the settings used for calls to getShieldedInstanceIdentity. */
    public UnaryCallSettings.Builder<
            GetShieldedInstanceIdentityInstanceRequest, ShieldedInstanceIdentity>
        getShieldedInstanceIdentitySettings() {
      return getShieldedInstanceIdentitySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertInstanceRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListInstancesRequest, InstanceList, ListPagedResponse>
        listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to listReferrers. */
    public PagedCallSettings.Builder<
            ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
        listReferrersSettings() {
      return listReferrersSettings;
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesSettings() {
      return removeResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to reset. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetSettings() {
      return resetSettings;
    }

    /** Returns the builder for the settings used for calls to setDeletionProtection. */
    public UnaryCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionSettings() {
      return setDeletionProtectionSettings;
    }

    /** Returns the builder for the settings used for calls to setDiskAutoDelete. */
    public UnaryCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteSettings() {
      return setDiskAutoDeleteSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineResources. */
    public UnaryCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesSettings() {
      return setMachineResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineType. */
    public UnaryCallSettings.Builder<SetMachineTypeInstanceRequest, Operation>
        setMachineTypeSettings() {
      return setMachineTypeSettings;
    }

    /** Returns the builder for the settings used for calls to setMetadata. */
    public UnaryCallSettings.Builder<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
      return setMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to setMinCpuPlatform. */
    public UnaryCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformSettings() {
      return setMinCpuPlatformSettings;
    }

    /** Returns the builder for the settings used for calls to setScheduling. */
    public UnaryCallSettings.Builder<SetSchedulingInstanceRequest, Operation>
        setSchedulingSettings() {
      return setSchedulingSettings;
    }

    /** Returns the builder for the settings used for calls to setServiceAccount. */
    public UnaryCallSettings.Builder<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountSettings() {
      return setServiceAccountSettings;
    }

    /**
     * Returns the builder for the settings used for calls to setShieldedInstanceIntegrityPolicy.
     */
    public UnaryCallSettings.Builder<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicySettings() {
      return setShieldedInstanceIntegrityPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setTags. */
    public UnaryCallSettings.Builder<SetTagsInstanceRequest, Operation> setTagsSettings() {
      return setTagsSettings;
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    public UnaryCallSettings.Builder<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventSettings() {
      return simulateMaintenanceEventSettings;
    }

    /** Returns the builder for the settings used for calls to start. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startSettings() {
      return startSettings;
    }

    /** Returns the builder for the settings used for calls to startWithEncryptionKey. */
    public UnaryCallSettings.Builder<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeySettings() {
      return startWithEncryptionKeySettings;
    }

    /** Returns the builder for the settings used for calls to stop. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopSettings() {
      return stopSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessConfig. */
    public UnaryCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigSettings() {
      return updateAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateDisplayDevice. */
    public UnaryCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceSettings() {
      return updateDisplayDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkInterface. */
    public UnaryCallSettings.Builder<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceSettings() {
      return updateNetworkInterfaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigSettings() {
      return updateShieldedInstanceConfigSettings;
    }

    @Override
    public InstancesStubSettings build() throws IOException {
      return new InstancesStubSettings(this);
    }
  }
}
