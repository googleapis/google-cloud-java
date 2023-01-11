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
import com.google.api.gax.httpjson.ProtoOperationTransformers;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
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
import com.google.cloud.compute.v1.ResumeInstanceRequest;
import com.google.cloud.compute.v1.Screenshot;
import com.google.cloud.compute.v1.SendDiagnosticInterruptInstanceRequest;
import com.google.cloud.compute.v1.SendDiagnosticInterruptInstanceResponse;
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
import com.google.cloud.compute.v1.SuspendInstanceRequest;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
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
 * <p>For example, to set the total timeout of get to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * InstancesStubSettings.Builder instancesSettingsBuilder = InstancesStubSettings.newBuilder();
 * instancesSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         instancesSettingsBuilder
 *             .getSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * InstancesStubSettings instancesSettings = instancesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class InstancesStubSettings extends StubSettings<InstancesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddAccessConfigInstanceRequest, Operation>
      addAccessConfigSettings;
  private final OperationCallSettings<AddAccessConfigInstanceRequest, Operation, Operation>
      addAccessConfigOperationSettings;
  private final UnaryCallSettings<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesSettings;
  private final OperationCallSettings<AddResourcePoliciesInstanceRequest, Operation, Operation>
      addResourcePoliciesOperationSettings;
  private final PagedCallSettings<
          AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<AttachDiskInstanceRequest, Operation> attachDiskSettings;
  private final OperationCallSettings<AttachDiskInstanceRequest, Operation, Operation>
      attachDiskOperationSettings;
  private final UnaryCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertSettings;
  private final OperationCallSettings<BulkInsertInstanceRequest, Operation, Operation>
      bulkInsertOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteInstanceRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigSettings;
  private final OperationCallSettings<DeleteAccessConfigInstanceRequest, Operation, Operation>
      deleteAccessConfigOperationSettings;
  private final UnaryCallSettings<DetachDiskInstanceRequest, Operation> detachDiskSettings;
  private final OperationCallSettings<DetachDiskInstanceRequest, Operation, Operation>
      detachDiskOperationSettings;
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
  private final OperationCallSettings<InsertInstanceRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListInstancesRequest, InstanceList, ListPagedResponse>
      listSettings;
  private final PagedCallSettings<
          ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
      listReferrersSettings;
  private final UnaryCallSettings<RemoveResourcePoliciesInstanceRequest, Operation>
      removeResourcePoliciesSettings;
  private final OperationCallSettings<RemoveResourcePoliciesInstanceRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetSettings;
  private final OperationCallSettings<ResetInstanceRequest, Operation, Operation>
      resetOperationSettings;
  private final UnaryCallSettings<ResumeInstanceRequest, Operation> resumeSettings;
  private final OperationCallSettings<ResumeInstanceRequest, Operation, Operation>
      resumeOperationSettings;
  private final UnaryCallSettings<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptSettings;
  private final UnaryCallSettings<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionSettings;
  private final OperationCallSettings<SetDeletionProtectionInstanceRequest, Operation, Operation>
      setDeletionProtectionOperationSettings;
  private final UnaryCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteSettings;
  private final OperationCallSettings<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
      setDiskAutoDeleteOperationSettings;
  private final UnaryCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetLabelsInstanceRequest, Operation> setLabelsSettings;
  private final OperationCallSettings<SetLabelsInstanceRequest, Operation, Operation>
      setLabelsOperationSettings;
  private final UnaryCallSettings<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesSettings;
  private final OperationCallSettings<SetMachineResourcesInstanceRequest, Operation, Operation>
      setMachineResourcesOperationSettings;
  private final UnaryCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeSettings;
  private final OperationCallSettings<SetMachineTypeInstanceRequest, Operation, Operation>
      setMachineTypeOperationSettings;
  private final UnaryCallSettings<SetMetadataInstanceRequest, Operation> setMetadataSettings;
  private final OperationCallSettings<SetMetadataInstanceRequest, Operation, Operation>
      setMetadataOperationSettings;
  private final UnaryCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformSettings;
  private final OperationCallSettings<SetMinCpuPlatformInstanceRequest, Operation, Operation>
      setMinCpuPlatformOperationSettings;
  private final UnaryCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingSettings;
  private final OperationCallSettings<SetSchedulingInstanceRequest, Operation, Operation>
      setSchedulingOperationSettings;
  private final UnaryCallSettings<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountSettings;
  private final OperationCallSettings<SetServiceAccountInstanceRequest, Operation, Operation>
      setServiceAccountOperationSettings;
  private final UnaryCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicySettings;
  private final OperationCallSettings<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
      setShieldedInstanceIntegrityPolicyOperationSettings;
  private final UnaryCallSettings<SetTagsInstanceRequest, Operation> setTagsSettings;
  private final OperationCallSettings<SetTagsInstanceRequest, Operation, Operation>
      setTagsOperationSettings;
  private final UnaryCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventSettings;
  private final OperationCallSettings<SimulateMaintenanceEventInstanceRequest, Operation, Operation>
      simulateMaintenanceEventOperationSettings;
  private final UnaryCallSettings<StartInstanceRequest, Operation> startSettings;
  private final OperationCallSettings<StartInstanceRequest, Operation, Operation>
      startOperationSettings;
  private final UnaryCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeySettings;
  private final OperationCallSettings<StartWithEncryptionKeyInstanceRequest, Operation, Operation>
      startWithEncryptionKeyOperationSettings;
  private final UnaryCallSettings<StopInstanceRequest, Operation> stopSettings;
  private final OperationCallSettings<StopInstanceRequest, Operation, Operation>
      stopOperationSettings;
  private final UnaryCallSettings<SuspendInstanceRequest, Operation> suspendSettings;
  private final OperationCallSettings<SuspendInstanceRequest, Operation, Operation>
      suspendOperationSettings;
  private final UnaryCallSettings<TestIamPermissionsInstanceRequest, TestPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Operation, Operation>
      updateOperationSettings;
  private final UnaryCallSettings<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigSettings;
  private final OperationCallSettings<UpdateAccessConfigInstanceRequest, Operation, Operation>
      updateAccessConfigOperationSettings;
  private final UnaryCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceSettings;
  private final OperationCallSettings<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
      updateDisplayDeviceOperationSettings;
  private final UnaryCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceSettings;
  private final OperationCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
      updateNetworkInterfaceOperationSettings;
  private final UnaryCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigSettings;
  private final OperationCallSettings<
          UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
      updateShieldedInstanceConfigOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListInstancesRequest,
          InstanceAggregatedList,
          Map.Entry<String, InstancesScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListInstancesRequest,
              InstanceAggregatedList,
              Map.Entry<String, InstancesScopedList>>() {
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
            public Iterable<Map.Entry<String, InstancesScopedList>> extractResources(
                InstanceAggregatedList payload) {
              return payload.getItemsMap() == null
                  ? Collections.<Map.Entry<String, InstancesScopedList>>emptySet()
                  : payload.getItemsMap().entrySet();
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
              return payload.getItemsList() == null
                  ? ImmutableList.<Instance>of()
                  : payload.getItemsList();
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
              return payload.getItemsList() == null
                  ? ImmutableList.<Reference>of()
                  : payload.getItemsList();
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
                      Map.Entry<String, InstancesScopedList>>
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

  /** Returns the object with the settings used for calls to addAccessConfig. */
  public UnaryCallSettings<AddAccessConfigInstanceRequest, Operation> addAccessConfigSettings() {
    return addAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to addAccessConfig. */
  public OperationCallSettings<AddAccessConfigInstanceRequest, Operation, Operation>
      addAccessConfigOperationSettings() {
    return addAccessConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesInstanceRequest, Operation>
      addResourcePoliciesSettings() {
    return addResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public OperationCallSettings<AddResourcePoliciesInstanceRequest, Operation, Operation>
      addResourcePoliciesOperationSettings() {
    return addResourcePoliciesOperationSettings;
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

  /** Returns the object with the settings used for calls to attachDisk. */
  public OperationCallSettings<AttachDiskInstanceRequest, Operation, Operation>
      attachDiskOperationSettings() {
    return attachDiskOperationSettings;
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public UnaryCallSettings<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
    return bulkInsertSettings;
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public OperationCallSettings<BulkInsertInstanceRequest, Operation, Operation>
      bulkInsertOperationSettings() {
    return bulkInsertOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteInstanceRequest, Operation, Operation>
      deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessConfig. */
  public UnaryCallSettings<DeleteAccessConfigInstanceRequest, Operation>
      deleteAccessConfigSettings() {
    return deleteAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to deleteAccessConfig. */
  public OperationCallSettings<DeleteAccessConfigInstanceRequest, Operation, Operation>
      deleteAccessConfigOperationSettings() {
    return deleteAccessConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachDisk. */
  public UnaryCallSettings<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
    return detachDiskSettings;
  }

  /** Returns the object with the settings used for calls to detachDisk. */
  public OperationCallSettings<DetachDiskInstanceRequest, Operation, Operation>
      detachDiskOperationSettings() {
    return detachDiskOperationSettings;
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

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertInstanceRequest, Operation, Operation>
      insertOperationSettings() {
    return insertOperationSettings;
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

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public OperationCallSettings<RemoveResourcePoliciesInstanceRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings() {
    return removeResourcePoliciesOperationSettings;
  }

  /** Returns the object with the settings used for calls to reset. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetSettings() {
    return resetSettings;
  }

  /** Returns the object with the settings used for calls to reset. */
  public OperationCallSettings<ResetInstanceRequest, Operation, Operation>
      resetOperationSettings() {
    return resetOperationSettings;
  }

  /** Returns the object with the settings used for calls to resume. */
  public UnaryCallSettings<ResumeInstanceRequest, Operation> resumeSettings() {
    return resumeSettings;
  }

  /** Returns the object with the settings used for calls to resume. */
  public OperationCallSettings<ResumeInstanceRequest, Operation, Operation>
      resumeOperationSettings() {
    return resumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to sendDiagnosticInterrupt. */
  public UnaryCallSettings<
          SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
      sendDiagnosticInterruptSettings() {
    return sendDiagnosticInterruptSettings;
  }

  /** Returns the object with the settings used for calls to setDeletionProtection. */
  public UnaryCallSettings<SetDeletionProtectionInstanceRequest, Operation>
      setDeletionProtectionSettings() {
    return setDeletionProtectionSettings;
  }

  /** Returns the object with the settings used for calls to setDeletionProtection. */
  public OperationCallSettings<SetDeletionProtectionInstanceRequest, Operation, Operation>
      setDeletionProtectionOperationSettings() {
    return setDeletionProtectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to setDiskAutoDelete. */
  public UnaryCallSettings<SetDiskAutoDeleteInstanceRequest, Operation>
      setDiskAutoDeleteSettings() {
    return setDiskAutoDeleteSettings;
  }

  /** Returns the object with the settings used for calls to setDiskAutoDelete. */
  public OperationCallSettings<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
      setDiskAutoDeleteOperationSettings() {
    return setDiskAutoDeleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsInstanceRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return setLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to setMachineResources. */
  public UnaryCallSettings<SetMachineResourcesInstanceRequest, Operation>
      setMachineResourcesSettings() {
    return setMachineResourcesSettings;
  }

  /** Returns the object with the settings used for calls to setMachineResources. */
  public OperationCallSettings<SetMachineResourcesInstanceRequest, Operation, Operation>
      setMachineResourcesOperationSettings() {
    return setMachineResourcesOperationSettings;
  }

  /** Returns the object with the settings used for calls to setMachineType. */
  public UnaryCallSettings<SetMachineTypeInstanceRequest, Operation> setMachineTypeSettings() {
    return setMachineTypeSettings;
  }

  /** Returns the object with the settings used for calls to setMachineType. */
  public OperationCallSettings<SetMachineTypeInstanceRequest, Operation, Operation>
      setMachineTypeOperationSettings() {
    return setMachineTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to setMetadata. */
  public UnaryCallSettings<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
    return setMetadataSettings;
  }

  /** Returns the object with the settings used for calls to setMetadata. */
  public OperationCallSettings<SetMetadataInstanceRequest, Operation, Operation>
      setMetadataOperationSettings() {
    return setMetadataOperationSettings;
  }

  /** Returns the object with the settings used for calls to setMinCpuPlatform. */
  public UnaryCallSettings<SetMinCpuPlatformInstanceRequest, Operation>
      setMinCpuPlatformSettings() {
    return setMinCpuPlatformSettings;
  }

  /** Returns the object with the settings used for calls to setMinCpuPlatform. */
  public OperationCallSettings<SetMinCpuPlatformInstanceRequest, Operation, Operation>
      setMinCpuPlatformOperationSettings() {
    return setMinCpuPlatformOperationSettings;
  }

  /** Returns the object with the settings used for calls to setScheduling. */
  public UnaryCallSettings<SetSchedulingInstanceRequest, Operation> setSchedulingSettings() {
    return setSchedulingSettings;
  }

  /** Returns the object with the settings used for calls to setScheduling. */
  public OperationCallSettings<SetSchedulingInstanceRequest, Operation, Operation>
      setSchedulingOperationSettings() {
    return setSchedulingOperationSettings;
  }

  /** Returns the object with the settings used for calls to setServiceAccount. */
  public UnaryCallSettings<SetServiceAccountInstanceRequest, Operation>
      setServiceAccountSettings() {
    return setServiceAccountSettings;
  }

  /** Returns the object with the settings used for calls to setServiceAccount. */
  public OperationCallSettings<SetServiceAccountInstanceRequest, Operation, Operation>
      setServiceAccountOperationSettings() {
    return setServiceAccountOperationSettings;
  }

  /** Returns the object with the settings used for calls to setShieldedInstanceIntegrityPolicy. */
  public UnaryCallSettings<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
      setShieldedInstanceIntegrityPolicySettings() {
    return setShieldedInstanceIntegrityPolicySettings;
  }

  /** Returns the object with the settings used for calls to setShieldedInstanceIntegrityPolicy. */
  public OperationCallSettings<
          SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
      setShieldedInstanceIntegrityPolicyOperationSettings() {
    return setShieldedInstanceIntegrityPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to setTags. */
  public UnaryCallSettings<SetTagsInstanceRequest, Operation> setTagsSettings() {
    return setTagsSettings;
  }

  /** Returns the object with the settings used for calls to setTags. */
  public OperationCallSettings<SetTagsInstanceRequest, Operation, Operation>
      setTagsOperationSettings() {
    return setTagsOperationSettings;
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public UnaryCallSettings<SimulateMaintenanceEventInstanceRequest, Operation>
      simulateMaintenanceEventSettings() {
    return simulateMaintenanceEventSettings;
  }

  /** Returns the object with the settings used for calls to simulateMaintenanceEvent. */
  public OperationCallSettings<SimulateMaintenanceEventInstanceRequest, Operation, Operation>
      simulateMaintenanceEventOperationSettings() {
    return simulateMaintenanceEventOperationSettings;
  }

  /** Returns the object with the settings used for calls to start. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startSettings() {
    return startSettings;
  }

  /** Returns the object with the settings used for calls to start. */
  public OperationCallSettings<StartInstanceRequest, Operation, Operation>
      startOperationSettings() {
    return startOperationSettings;
  }

  /** Returns the object with the settings used for calls to startWithEncryptionKey. */
  public UnaryCallSettings<StartWithEncryptionKeyInstanceRequest, Operation>
      startWithEncryptionKeySettings() {
    return startWithEncryptionKeySettings;
  }

  /** Returns the object with the settings used for calls to startWithEncryptionKey. */
  public OperationCallSettings<StartWithEncryptionKeyInstanceRequest, Operation, Operation>
      startWithEncryptionKeyOperationSettings() {
    return startWithEncryptionKeyOperationSettings;
  }

  /** Returns the object with the settings used for calls to stop. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopSettings() {
    return stopSettings;
  }

  /** Returns the object with the settings used for calls to stop. */
  public OperationCallSettings<StopInstanceRequest, Operation, Operation> stopOperationSettings() {
    return stopOperationSettings;
  }

  /** Returns the object with the settings used for calls to suspend. */
  public UnaryCallSettings<SuspendInstanceRequest, Operation> suspendSettings() {
    return suspendSettings;
  }

  /** Returns the object with the settings used for calls to suspend. */
  public OperationCallSettings<SuspendInstanceRequest, Operation, Operation>
      suspendOperationSettings() {
    return suspendOperationSettings;
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

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateInstanceRequest, Operation, Operation>
      updateOperationSettings() {
    return updateOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessConfig. */
  public UnaryCallSettings<UpdateAccessConfigInstanceRequest, Operation>
      updateAccessConfigSettings() {
    return updateAccessConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateAccessConfig. */
  public OperationCallSettings<UpdateAccessConfigInstanceRequest, Operation, Operation>
      updateAccessConfigOperationSettings() {
    return updateAccessConfigOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDisplayDevice. */
  public UnaryCallSettings<UpdateDisplayDeviceInstanceRequest, Operation>
      updateDisplayDeviceSettings() {
    return updateDisplayDeviceSettings;
  }

  /** Returns the object with the settings used for calls to updateDisplayDevice. */
  public OperationCallSettings<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
      updateDisplayDeviceOperationSettings() {
    return updateDisplayDeviceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkInterface. */
  public UnaryCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation>
      updateNetworkInterfaceSettings() {
    return updateNetworkInterfaceSettings;
  }

  /** Returns the object with the settings used for calls to updateNetworkInterface. */
  public OperationCallSettings<UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
      updateNetworkInterfaceOperationSettings() {
    return updateNetworkInterfaceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public UnaryCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation>
      updateShieldedInstanceConfigSettings() {
    return updateShieldedInstanceConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateShieldedInstanceConfig. */
  public OperationCallSettings<UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
      updateShieldedInstanceConfigOperationSettings() {
    return updateShieldedInstanceConfigOperationSettings;
  }

  public InstancesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonInstancesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "compute.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "compute.mtls.googleapis.com:443";
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
    addAccessConfigOperationSettings = settingsBuilder.addAccessConfigOperationSettings().build();
    addResourcePoliciesSettings = settingsBuilder.addResourcePoliciesSettings().build();
    addResourcePoliciesOperationSettings =
        settingsBuilder.addResourcePoliciesOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    attachDiskSettings = settingsBuilder.attachDiskSettings().build();
    attachDiskOperationSettings = settingsBuilder.attachDiskOperationSettings().build();
    bulkInsertSettings = settingsBuilder.bulkInsertSettings().build();
    bulkInsertOperationSettings = settingsBuilder.bulkInsertOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    deleteAccessConfigSettings = settingsBuilder.deleteAccessConfigSettings().build();
    deleteAccessConfigOperationSettings =
        settingsBuilder.deleteAccessConfigOperationSettings().build();
    detachDiskSettings = settingsBuilder.detachDiskSettings().build();
    detachDiskOperationSettings = settingsBuilder.detachDiskOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getEffectiveFirewallsSettings = settingsBuilder.getEffectiveFirewallsSettings().build();
    getGuestAttributesSettings = settingsBuilder.getGuestAttributesSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    getScreenshotSettings = settingsBuilder.getScreenshotSettings().build();
    getSerialPortOutputSettings = settingsBuilder.getSerialPortOutputSettings().build();
    getShieldedInstanceIdentitySettings =
        settingsBuilder.getShieldedInstanceIdentitySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    listReferrersSettings = settingsBuilder.listReferrersSettings().build();
    removeResourcePoliciesSettings = settingsBuilder.removeResourcePoliciesSettings().build();
    removeResourcePoliciesOperationSettings =
        settingsBuilder.removeResourcePoliciesOperationSettings().build();
    resetSettings = settingsBuilder.resetSettings().build();
    resetOperationSettings = settingsBuilder.resetOperationSettings().build();
    resumeSettings = settingsBuilder.resumeSettings().build();
    resumeOperationSettings = settingsBuilder.resumeOperationSettings().build();
    sendDiagnosticInterruptSettings = settingsBuilder.sendDiagnosticInterruptSettings().build();
    setDeletionProtectionSettings = settingsBuilder.setDeletionProtectionSettings().build();
    setDeletionProtectionOperationSettings =
        settingsBuilder.setDeletionProtectionOperationSettings().build();
    setDiskAutoDeleteSettings = settingsBuilder.setDiskAutoDeleteSettings().build();
    setDiskAutoDeleteOperationSettings =
        settingsBuilder.setDiskAutoDeleteOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setLabelsOperationSettings = settingsBuilder.setLabelsOperationSettings().build();
    setMachineResourcesSettings = settingsBuilder.setMachineResourcesSettings().build();
    setMachineResourcesOperationSettings =
        settingsBuilder.setMachineResourcesOperationSettings().build();
    setMachineTypeSettings = settingsBuilder.setMachineTypeSettings().build();
    setMachineTypeOperationSettings = settingsBuilder.setMachineTypeOperationSettings().build();
    setMetadataSettings = settingsBuilder.setMetadataSettings().build();
    setMetadataOperationSettings = settingsBuilder.setMetadataOperationSettings().build();
    setMinCpuPlatformSettings = settingsBuilder.setMinCpuPlatformSettings().build();
    setMinCpuPlatformOperationSettings =
        settingsBuilder.setMinCpuPlatformOperationSettings().build();
    setSchedulingSettings = settingsBuilder.setSchedulingSettings().build();
    setSchedulingOperationSettings = settingsBuilder.setSchedulingOperationSettings().build();
    setServiceAccountSettings = settingsBuilder.setServiceAccountSettings().build();
    setServiceAccountOperationSettings =
        settingsBuilder.setServiceAccountOperationSettings().build();
    setShieldedInstanceIntegrityPolicySettings =
        settingsBuilder.setShieldedInstanceIntegrityPolicySettings().build();
    setShieldedInstanceIntegrityPolicyOperationSettings =
        settingsBuilder.setShieldedInstanceIntegrityPolicyOperationSettings().build();
    setTagsSettings = settingsBuilder.setTagsSettings().build();
    setTagsOperationSettings = settingsBuilder.setTagsOperationSettings().build();
    simulateMaintenanceEventSettings = settingsBuilder.simulateMaintenanceEventSettings().build();
    simulateMaintenanceEventOperationSettings =
        settingsBuilder.simulateMaintenanceEventOperationSettings().build();
    startSettings = settingsBuilder.startSettings().build();
    startOperationSettings = settingsBuilder.startOperationSettings().build();
    startWithEncryptionKeySettings = settingsBuilder.startWithEncryptionKeySettings().build();
    startWithEncryptionKeyOperationSettings =
        settingsBuilder.startWithEncryptionKeyOperationSettings().build();
    stopSettings = settingsBuilder.stopSettings().build();
    stopOperationSettings = settingsBuilder.stopOperationSettings().build();
    suspendSettings = settingsBuilder.suspendSettings().build();
    suspendOperationSettings = settingsBuilder.suspendOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
    updateAccessConfigSettings = settingsBuilder.updateAccessConfigSettings().build();
    updateAccessConfigOperationSettings =
        settingsBuilder.updateAccessConfigOperationSettings().build();
    updateDisplayDeviceSettings = settingsBuilder.updateDisplayDeviceSettings().build();
    updateDisplayDeviceOperationSettings =
        settingsBuilder.updateDisplayDeviceOperationSettings().build();
    updateNetworkInterfaceSettings = settingsBuilder.updateNetworkInterfaceSettings().build();
    updateNetworkInterfaceOperationSettings =
        settingsBuilder.updateNetworkInterfaceOperationSettings().build();
    updateShieldedInstanceConfigSettings =
        settingsBuilder.updateShieldedInstanceConfigSettings().build();
    updateShieldedInstanceConfigOperationSettings =
        settingsBuilder.updateShieldedInstanceConfigOperationSettings().build();
  }

  /** Builder for InstancesStubSettings. */
  public static class Builder extends StubSettings.Builder<InstancesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigSettings;
    private final OperationCallSettings.Builder<
            AddAccessConfigInstanceRequest, Operation, Operation>
        addAccessConfigOperationSettings;
    private final UnaryCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesSettings;
    private final OperationCallSettings.Builder<
            AddResourcePoliciesInstanceRequest, Operation, Operation>
        addResourcePoliciesOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListInstancesRequest, InstanceAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<AttachDiskInstanceRequest, Operation>
        attachDiskSettings;
    private final OperationCallSettings.Builder<AttachDiskInstanceRequest, Operation, Operation>
        attachDiskOperationSettings;
    private final UnaryCallSettings.Builder<BulkInsertInstanceRequest, Operation>
        bulkInsertSettings;
    private final OperationCallSettings.Builder<BulkInsertInstanceRequest, Operation, Operation>
        bulkInsertOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteInstanceRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigSettings;
    private final OperationCallSettings.Builder<
            DeleteAccessConfigInstanceRequest, Operation, Operation>
        deleteAccessConfigOperationSettings;
    private final UnaryCallSettings.Builder<DetachDiskInstanceRequest, Operation>
        detachDiskSettings;
    private final OperationCallSettings.Builder<DetachDiskInstanceRequest, Operation, Operation>
        detachDiskOperationSettings;
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
    private final OperationCallSettings.Builder<InsertInstanceRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListInstancesRequest, InstanceList, ListPagedResponse>
        listSettings;
    private final PagedCallSettings.Builder<
            ListReferrersInstancesRequest, InstanceListReferrers, ListReferrersPagedResponse>
        listReferrersSettings;
    private final UnaryCallSettings.Builder<RemoveResourcePoliciesInstanceRequest, Operation>
        removeResourcePoliciesSettings;
    private final OperationCallSettings.Builder<
            RemoveResourcePoliciesInstanceRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetSettings;
    private final OperationCallSettings.Builder<ResetInstanceRequest, Operation, Operation>
        resetOperationSettings;
    private final UnaryCallSettings.Builder<ResumeInstanceRequest, Operation> resumeSettings;
    private final OperationCallSettings.Builder<ResumeInstanceRequest, Operation, Operation>
        resumeOperationSettings;
    private final UnaryCallSettings.Builder<
            SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
        sendDiagnosticInterruptSettings;
    private final UnaryCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionSettings;
    private final OperationCallSettings.Builder<
            SetDeletionProtectionInstanceRequest, Operation, Operation>
        setDeletionProtectionOperationSettings;
    private final UnaryCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteSettings;
    private final OperationCallSettings.Builder<
            SetDiskAutoDeleteInstanceRequest, Operation, Operation>
        setDiskAutoDeleteOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyInstanceRequest, Policy>
        setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetLabelsInstanceRequest, Operation> setLabelsSettings;
    private final OperationCallSettings.Builder<SetLabelsInstanceRequest, Operation, Operation>
        setLabelsOperationSettings;
    private final UnaryCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesSettings;
    private final OperationCallSettings.Builder<
            SetMachineResourcesInstanceRequest, Operation, Operation>
        setMachineResourcesOperationSettings;
    private final UnaryCallSettings.Builder<SetMachineTypeInstanceRequest, Operation>
        setMachineTypeSettings;
    private final OperationCallSettings.Builder<SetMachineTypeInstanceRequest, Operation, Operation>
        setMachineTypeOperationSettings;
    private final UnaryCallSettings.Builder<SetMetadataInstanceRequest, Operation>
        setMetadataSettings;
    private final OperationCallSettings.Builder<SetMetadataInstanceRequest, Operation, Operation>
        setMetadataOperationSettings;
    private final UnaryCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformSettings;
    private final OperationCallSettings.Builder<
            SetMinCpuPlatformInstanceRequest, Operation, Operation>
        setMinCpuPlatformOperationSettings;
    private final UnaryCallSettings.Builder<SetSchedulingInstanceRequest, Operation>
        setSchedulingSettings;
    private final OperationCallSettings.Builder<SetSchedulingInstanceRequest, Operation, Operation>
        setSchedulingOperationSettings;
    private final UnaryCallSettings.Builder<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountSettings;
    private final OperationCallSettings.Builder<
            SetServiceAccountInstanceRequest, Operation, Operation>
        setServiceAccountOperationSettings;
    private final UnaryCallSettings.Builder<
            SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicySettings;
    private final OperationCallSettings.Builder<
            SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
        setShieldedInstanceIntegrityPolicyOperationSettings;
    private final UnaryCallSettings.Builder<SetTagsInstanceRequest, Operation> setTagsSettings;
    private final OperationCallSettings.Builder<SetTagsInstanceRequest, Operation, Operation>
        setTagsOperationSettings;
    private final UnaryCallSettings.Builder<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventSettings;
    private final OperationCallSettings.Builder<
            SimulateMaintenanceEventInstanceRequest, Operation, Operation>
        simulateMaintenanceEventOperationSettings;
    private final UnaryCallSettings.Builder<StartInstanceRequest, Operation> startSettings;
    private final OperationCallSettings.Builder<StartInstanceRequest, Operation, Operation>
        startOperationSettings;
    private final UnaryCallSettings.Builder<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeySettings;
    private final OperationCallSettings.Builder<
            StartWithEncryptionKeyInstanceRequest, Operation, Operation>
        startWithEncryptionKeyOperationSettings;
    private final UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopSettings;
    private final OperationCallSettings.Builder<StopInstanceRequest, Operation, Operation>
        stopOperationSettings;
    private final UnaryCallSettings.Builder<SuspendInstanceRequest, Operation> suspendSettings;
    private final OperationCallSettings.Builder<SuspendInstanceRequest, Operation, Operation>
        suspendOperationSettings;
    private final UnaryCallSettings.Builder<
            TestIamPermissionsInstanceRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateInstanceRequest, Operation, Operation>
        updateOperationSettings;
    private final UnaryCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateAccessConfigInstanceRequest, Operation, Operation>
        updateAccessConfigOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceSettings;
    private final OperationCallSettings.Builder<
            UpdateDisplayDeviceInstanceRequest, Operation, Operation>
        updateDisplayDeviceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceSettings;
    private final OperationCallSettings.Builder<
            UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
        updateNetworkInterfaceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigSettings;
    private final OperationCallSettings.Builder<
            UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
        updateShieldedInstanceConfigOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(600000L))
              .setTotalTimeout(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addAccessConfigOperationSettings = OperationCallSettings.newBuilder();
      addResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addResourcePoliciesOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      attachDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      attachDiskOperationSettings = OperationCallSettings.newBuilder();
      bulkInsertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkInsertOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      deleteAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteAccessConfigOperationSettings = OperationCallSettings.newBuilder();
      detachDiskSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachDiskOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getEffectiveFirewallsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getGuestAttributesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getScreenshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSerialPortOutputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getShieldedInstanceIdentitySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      listReferrersSettings = PagedCallSettings.newBuilder(LIST_REFERRERS_PAGE_STR_FACT);
      removeResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeResourcePoliciesOperationSettings = OperationCallSettings.newBuilder();
      resetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetOperationSettings = OperationCallSettings.newBuilder();
      resumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resumeOperationSettings = OperationCallSettings.newBuilder();
      sendDiagnosticInterruptSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDeletionProtectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDeletionProtectionOperationSettings = OperationCallSettings.newBuilder();
      setDiskAutoDeleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setDiskAutoDeleteOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsOperationSettings = OperationCallSettings.newBuilder();
      setMachineResourcesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setMachineResourcesOperationSettings = OperationCallSettings.newBuilder();
      setMachineTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setMachineTypeOperationSettings = OperationCallSettings.newBuilder();
      setMetadataSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setMetadataOperationSettings = OperationCallSettings.newBuilder();
      setMinCpuPlatformSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setMinCpuPlatformOperationSettings = OperationCallSettings.newBuilder();
      setSchedulingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setSchedulingOperationSettings = OperationCallSettings.newBuilder();
      setServiceAccountSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setServiceAccountOperationSettings = OperationCallSettings.newBuilder();
      setShieldedInstanceIntegrityPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setShieldedInstanceIntegrityPolicyOperationSettings = OperationCallSettings.newBuilder();
      setTagsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setTagsOperationSettings = OperationCallSettings.newBuilder();
      simulateMaintenanceEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      simulateMaintenanceEventOperationSettings = OperationCallSettings.newBuilder();
      startSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startOperationSettings = OperationCallSettings.newBuilder();
      startWithEncryptionKeySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startWithEncryptionKeyOperationSettings = OperationCallSettings.newBuilder();
      stopSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopOperationSettings = OperationCallSettings.newBuilder();
      suspendSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      suspendOperationSettings = OperationCallSettings.newBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();
      updateAccessConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAccessConfigOperationSettings = OperationCallSettings.newBuilder();
      updateDisplayDeviceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDisplayDeviceOperationSettings = OperationCallSettings.newBuilder();
      updateNetworkInterfaceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkInterfaceOperationSettings = OperationCallSettings.newBuilder();
      updateShieldedInstanceConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateShieldedInstanceConfigOperationSettings = OperationCallSettings.newBuilder();

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
              resumeSettings,
              sendDiagnosticInterruptSettings,
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
              suspendSettings,
              testIamPermissionsSettings,
              updateSettings,
              updateAccessConfigSettings,
              updateDisplayDeviceSettings,
              updateNetworkInterfaceSettings,
              updateShieldedInstanceConfigSettings);
      initDefaults(this);
    }

    protected Builder(InstancesStubSettings settings) {
      super(settings);

      addAccessConfigSettings = settings.addAccessConfigSettings.toBuilder();
      addAccessConfigOperationSettings = settings.addAccessConfigOperationSettings.toBuilder();
      addResourcePoliciesSettings = settings.addResourcePoliciesSettings.toBuilder();
      addResourcePoliciesOperationSettings =
          settings.addResourcePoliciesOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      attachDiskSettings = settings.attachDiskSettings.toBuilder();
      attachDiskOperationSettings = settings.attachDiskOperationSettings.toBuilder();
      bulkInsertSettings = settings.bulkInsertSettings.toBuilder();
      bulkInsertOperationSettings = settings.bulkInsertOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      deleteAccessConfigSettings = settings.deleteAccessConfigSettings.toBuilder();
      deleteAccessConfigOperationSettings =
          settings.deleteAccessConfigOperationSettings.toBuilder();
      detachDiskSettings = settings.detachDiskSettings.toBuilder();
      detachDiskOperationSettings = settings.detachDiskOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getEffectiveFirewallsSettings = settings.getEffectiveFirewallsSettings.toBuilder();
      getGuestAttributesSettings = settings.getGuestAttributesSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      getScreenshotSettings = settings.getScreenshotSettings.toBuilder();
      getSerialPortOutputSettings = settings.getSerialPortOutputSettings.toBuilder();
      getShieldedInstanceIdentitySettings =
          settings.getShieldedInstanceIdentitySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      listReferrersSettings = settings.listReferrersSettings.toBuilder();
      removeResourcePoliciesSettings = settings.removeResourcePoliciesSettings.toBuilder();
      removeResourcePoliciesOperationSettings =
          settings.removeResourcePoliciesOperationSettings.toBuilder();
      resetSettings = settings.resetSettings.toBuilder();
      resetOperationSettings = settings.resetOperationSettings.toBuilder();
      resumeSettings = settings.resumeSettings.toBuilder();
      resumeOperationSettings = settings.resumeOperationSettings.toBuilder();
      sendDiagnosticInterruptSettings = settings.sendDiagnosticInterruptSettings.toBuilder();
      setDeletionProtectionSettings = settings.setDeletionProtectionSettings.toBuilder();
      setDeletionProtectionOperationSettings =
          settings.setDeletionProtectionOperationSettings.toBuilder();
      setDiskAutoDeleteSettings = settings.setDiskAutoDeleteSettings.toBuilder();
      setDiskAutoDeleteOperationSettings = settings.setDiskAutoDeleteOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setLabelsOperationSettings = settings.setLabelsOperationSettings.toBuilder();
      setMachineResourcesSettings = settings.setMachineResourcesSettings.toBuilder();
      setMachineResourcesOperationSettings =
          settings.setMachineResourcesOperationSettings.toBuilder();
      setMachineTypeSettings = settings.setMachineTypeSettings.toBuilder();
      setMachineTypeOperationSettings = settings.setMachineTypeOperationSettings.toBuilder();
      setMetadataSettings = settings.setMetadataSettings.toBuilder();
      setMetadataOperationSettings = settings.setMetadataOperationSettings.toBuilder();
      setMinCpuPlatformSettings = settings.setMinCpuPlatformSettings.toBuilder();
      setMinCpuPlatformOperationSettings = settings.setMinCpuPlatformOperationSettings.toBuilder();
      setSchedulingSettings = settings.setSchedulingSettings.toBuilder();
      setSchedulingOperationSettings = settings.setSchedulingOperationSettings.toBuilder();
      setServiceAccountSettings = settings.setServiceAccountSettings.toBuilder();
      setServiceAccountOperationSettings = settings.setServiceAccountOperationSettings.toBuilder();
      setShieldedInstanceIntegrityPolicySettings =
          settings.setShieldedInstanceIntegrityPolicySettings.toBuilder();
      setShieldedInstanceIntegrityPolicyOperationSettings =
          settings.setShieldedInstanceIntegrityPolicyOperationSettings.toBuilder();
      setTagsSettings = settings.setTagsSettings.toBuilder();
      setTagsOperationSettings = settings.setTagsOperationSettings.toBuilder();
      simulateMaintenanceEventSettings = settings.simulateMaintenanceEventSettings.toBuilder();
      simulateMaintenanceEventOperationSettings =
          settings.simulateMaintenanceEventOperationSettings.toBuilder();
      startSettings = settings.startSettings.toBuilder();
      startOperationSettings = settings.startOperationSettings.toBuilder();
      startWithEncryptionKeySettings = settings.startWithEncryptionKeySettings.toBuilder();
      startWithEncryptionKeyOperationSettings =
          settings.startWithEncryptionKeyOperationSettings.toBuilder();
      stopSettings = settings.stopSettings.toBuilder();
      stopOperationSettings = settings.stopOperationSettings.toBuilder();
      suspendSettings = settings.suspendSettings.toBuilder();
      suspendOperationSettings = settings.suspendOperationSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();
      updateAccessConfigSettings = settings.updateAccessConfigSettings.toBuilder();
      updateAccessConfigOperationSettings =
          settings.updateAccessConfigOperationSettings.toBuilder();
      updateDisplayDeviceSettings = settings.updateDisplayDeviceSettings.toBuilder();
      updateDisplayDeviceOperationSettings =
          settings.updateDisplayDeviceOperationSettings.toBuilder();
      updateNetworkInterfaceSettings = settings.updateNetworkInterfaceSettings.toBuilder();
      updateNetworkInterfaceOperationSettings =
          settings.updateNetworkInterfaceOperationSettings.toBuilder();
      updateShieldedInstanceConfigSettings =
          settings.updateShieldedInstanceConfigSettings.toBuilder();
      updateShieldedInstanceConfigOperationSettings =
          settings.updateShieldedInstanceConfigOperationSettings.toBuilder();

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
              resumeSettings,
              sendDiagnosticInterruptSettings,
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
              suspendSettings,
              testIamPermissionsSettings,
              updateSettings,
              updateAccessConfigSettings,
              updateDisplayDeviceSettings,
              updateNetworkInterfaceSettings,
              updateShieldedInstanceConfigSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .addAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .attachDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .bulkInsertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .detachDiskSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEffectiveFirewallsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getGuestAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getScreenshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSerialPortOutputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getShieldedInstanceIdentitySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listReferrersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .removeResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .sendDiagnosticInterruptSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setDeletionProtectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setDiskAutoDeleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setMachineResourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setMachineTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setMetadataSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setMinCpuPlatformSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setSchedulingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setServiceAccountSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setShieldedInstanceIntegrityPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .setTagsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .simulateMaintenanceEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startWithEncryptionKeySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .suspendSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateAccessConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateDisplayDeviceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateNetworkInterfaceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateShieldedInstanceConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .addAccessConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddAccessConfigInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .addResourcePoliciesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddResourcePoliciesInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .attachDiskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AttachDiskInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .bulkInsertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkInsertInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteAccessConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteAccessConfigInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .detachDiskOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DetachDiskInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<InsertInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removeResourcePoliciesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveResourcePoliciesInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .resetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .resumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResumeInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setDeletionProtectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetDeletionProtectionInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setDiskAutoDeleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetDiskAutoDeleteInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetLabelsInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setMachineResourcesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetMachineResourcesInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setMachineTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetMachineTypeInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setMetadataOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetMetadataInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setMinCpuPlatformOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetMinCpuPlatformInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setSchedulingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetSchedulingInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setServiceAccountOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetServiceAccountInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setShieldedInstanceIntegrityPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetShieldedInstanceIntegrityPolicyInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setTagsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetTagsInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .simulateMaintenanceEventOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SimulateMaintenanceEventInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .startOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .startWithEncryptionKeyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartWithEncryptionKeyInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .stopOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .suspendOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SuspendInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateAccessConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAccessConfigInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateDisplayDeviceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDisplayDeviceInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateNetworkInterfaceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkInterfaceInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateShieldedInstanceConfigOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateShieldedInstanceConfigInstanceRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Operation.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(Operation.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(20000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(600000L))
                      .build()));

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

    /** Returns the builder for the settings used for calls to addAccessConfig. */
    public UnaryCallSettings.Builder<AddAccessConfigInstanceRequest, Operation>
        addAccessConfigSettings() {
      return addAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to addAccessConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddAccessConfigInstanceRequest, Operation, Operation>
        addAccessConfigOperationSettings() {
      return addAccessConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation>
        addResourcePoliciesSettings() {
      return addResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AddResourcePoliciesInstanceRequest, Operation, Operation>
        addResourcePoliciesOperationSettings() {
      return addResourcePoliciesOperationSettings;
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

    /** Returns the builder for the settings used for calls to attachDisk. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<AttachDiskInstanceRequest, Operation, Operation>
        attachDiskOperationSettings() {
      return attachDiskOperationSettings;
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public UnaryCallSettings.Builder<BulkInsertInstanceRequest, Operation> bulkInsertSettings() {
      return bulkInsertSettings;
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<BulkInsertInstanceRequest, Operation, Operation>
        bulkInsertOperationSettings() {
      return bulkInsertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteInstanceRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessConfig. */
    public UnaryCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation>
        deleteAccessConfigSettings() {
      return deleteAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAccessConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteAccessConfigInstanceRequest, Operation, Operation>
        deleteAccessConfigOperationSettings() {
      return deleteAccessConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachDisk. */
    public UnaryCallSettings.Builder<DetachDiskInstanceRequest, Operation> detachDiskSettings() {
      return detachDiskSettings;
    }

    /** Returns the builder for the settings used for calls to detachDisk. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DetachDiskInstanceRequest, Operation, Operation>
        detachDiskOperationSettings() {
      return detachDiskOperationSettings;
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

    /** Returns the builder for the settings used for calls to insert. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<InsertInstanceRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
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

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            RemoveResourcePoliciesInstanceRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings() {
      return removeResourcePoliciesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to reset. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetSettings() {
      return resetSettings;
    }

    /** Returns the builder for the settings used for calls to reset. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ResetInstanceRequest, Operation, Operation>
        resetOperationSettings() {
      return resetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resume. */
    public UnaryCallSettings.Builder<ResumeInstanceRequest, Operation> resumeSettings() {
      return resumeSettings;
    }

    /** Returns the builder for the settings used for calls to resume. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ResumeInstanceRequest, Operation, Operation>
        resumeOperationSettings() {
      return resumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to sendDiagnosticInterrupt. */
    public UnaryCallSettings.Builder<
            SendDiagnosticInterruptInstanceRequest, SendDiagnosticInterruptInstanceResponse>
        sendDiagnosticInterruptSettings() {
      return sendDiagnosticInterruptSettings;
    }

    /** Returns the builder for the settings used for calls to setDeletionProtection. */
    public UnaryCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation>
        setDeletionProtectionSettings() {
      return setDeletionProtectionSettings;
    }

    /** Returns the builder for the settings used for calls to setDeletionProtection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetDeletionProtectionInstanceRequest, Operation, Operation>
        setDeletionProtectionOperationSettings() {
      return setDeletionProtectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setDiskAutoDelete. */
    public UnaryCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation>
        setDiskAutoDeleteSettings() {
      return setDiskAutoDeleteSettings;
    }

    /** Returns the builder for the settings used for calls to setDiskAutoDelete. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetDiskAutoDeleteInstanceRequest, Operation, Operation>
        setDiskAutoDeleteOperationSettings() {
      return setDiskAutoDeleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyInstanceRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsInstanceRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetLabelsInstanceRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return setLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineResources. */
    public UnaryCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation>
        setMachineResourcesSettings() {
      return setMachineResourcesSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineResources. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetMachineResourcesInstanceRequest, Operation, Operation>
        setMachineResourcesOperationSettings() {
      return setMachineResourcesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineType. */
    public UnaryCallSettings.Builder<SetMachineTypeInstanceRequest, Operation>
        setMachineTypeSettings() {
      return setMachineTypeSettings;
    }

    /** Returns the builder for the settings used for calls to setMachineType. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetMachineTypeInstanceRequest, Operation, Operation>
        setMachineTypeOperationSettings() {
      return setMachineTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setMetadata. */
    public UnaryCallSettings.Builder<SetMetadataInstanceRequest, Operation> setMetadataSettings() {
      return setMetadataSettings;
    }

    /** Returns the builder for the settings used for calls to setMetadata. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetMetadataInstanceRequest, Operation, Operation>
        setMetadataOperationSettings() {
      return setMetadataOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setMinCpuPlatform. */
    public UnaryCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation>
        setMinCpuPlatformSettings() {
      return setMinCpuPlatformSettings;
    }

    /** Returns the builder for the settings used for calls to setMinCpuPlatform. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetMinCpuPlatformInstanceRequest, Operation, Operation>
        setMinCpuPlatformOperationSettings() {
      return setMinCpuPlatformOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setScheduling. */
    public UnaryCallSettings.Builder<SetSchedulingInstanceRequest, Operation>
        setSchedulingSettings() {
      return setSchedulingSettings;
    }

    /** Returns the builder for the settings used for calls to setScheduling. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetSchedulingInstanceRequest, Operation, Operation>
        setSchedulingOperationSettings() {
      return setSchedulingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setServiceAccount. */
    public UnaryCallSettings.Builder<SetServiceAccountInstanceRequest, Operation>
        setServiceAccountSettings() {
      return setServiceAccountSettings;
    }

    /** Returns the builder for the settings used for calls to setServiceAccount. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetServiceAccountInstanceRequest, Operation, Operation>
        setServiceAccountOperationSettings() {
      return setServiceAccountOperationSettings;
    }

    /**
     * Returns the builder for the settings used for calls to setShieldedInstanceIntegrityPolicy.
     */
    public UnaryCallSettings.Builder<SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation>
        setShieldedInstanceIntegrityPolicySettings() {
      return setShieldedInstanceIntegrityPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to setShieldedInstanceIntegrityPolicy.
     */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SetShieldedInstanceIntegrityPolicyInstanceRequest, Operation, Operation>
        setShieldedInstanceIntegrityPolicyOperationSettings() {
      return setShieldedInstanceIntegrityPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setTags. */
    public UnaryCallSettings.Builder<SetTagsInstanceRequest, Operation> setTagsSettings() {
      return setTagsSettings;
    }

    /** Returns the builder for the settings used for calls to setTags. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SetTagsInstanceRequest, Operation, Operation>
        setTagsOperationSettings() {
      return setTagsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    public UnaryCallSettings.Builder<SimulateMaintenanceEventInstanceRequest, Operation>
        simulateMaintenanceEventSettings() {
      return simulateMaintenanceEventSettings;
    }

    /** Returns the builder for the settings used for calls to simulateMaintenanceEvent. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            SimulateMaintenanceEventInstanceRequest, Operation, Operation>
        simulateMaintenanceEventOperationSettings() {
      return simulateMaintenanceEventOperationSettings;
    }

    /** Returns the builder for the settings used for calls to start. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startSettings() {
      return startSettings;
    }

    /** Returns the builder for the settings used for calls to start. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StartInstanceRequest, Operation, Operation>
        startOperationSettings() {
      return startOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startWithEncryptionKey. */
    public UnaryCallSettings.Builder<StartWithEncryptionKeyInstanceRequest, Operation>
        startWithEncryptionKeySettings() {
      return startWithEncryptionKeySettings;
    }

    /** Returns the builder for the settings used for calls to startWithEncryptionKey. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            StartWithEncryptionKeyInstanceRequest, Operation, Operation>
        startWithEncryptionKeyOperationSettings() {
      return startWithEncryptionKeyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stop. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopSettings() {
      return stopSettings;
    }

    /** Returns the builder for the settings used for calls to stop. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<StopInstanceRequest, Operation, Operation>
        stopOperationSettings() {
      return stopOperationSettings;
    }

    /** Returns the builder for the settings used for calls to suspend. */
    public UnaryCallSettings.Builder<SuspendInstanceRequest, Operation> suspendSettings() {
      return suspendSettings;
    }

    /** Returns the builder for the settings used for calls to suspend. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<SuspendInstanceRequest, Operation, Operation>
        suspendOperationSettings() {
      return suspendOperationSettings;
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

    /** Returns the builder for the settings used for calls to update. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateInstanceRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessConfig. */
    public UnaryCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation>
        updateAccessConfigSettings() {
      return updateAccessConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateAccessConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateAccessConfigInstanceRequest, Operation, Operation>
        updateAccessConfigOperationSettings() {
      return updateAccessConfigOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDisplayDevice. */
    public UnaryCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation>
        updateDisplayDeviceSettings() {
      return updateDisplayDeviceSettings;
    }

    /** Returns the builder for the settings used for calls to updateDisplayDevice. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateDisplayDeviceInstanceRequest, Operation, Operation>
        updateDisplayDeviceOperationSettings() {
      return updateDisplayDeviceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkInterface. */
    public UnaryCallSettings.Builder<UpdateNetworkInterfaceInstanceRequest, Operation>
        updateNetworkInterfaceSettings() {
      return updateNetworkInterfaceSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetworkInterface. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateNetworkInterfaceInstanceRequest, Operation, Operation>
        updateNetworkInterfaceOperationSettings() {
      return updateNetworkInterfaceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    public UnaryCallSettings.Builder<UpdateShieldedInstanceConfigInstanceRequest, Operation>
        updateShieldedInstanceConfigSettings() {
      return updateShieldedInstanceConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateShieldedInstanceConfig. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateShieldedInstanceConfigInstanceRequest, Operation, Operation>
        updateShieldedInstanceConfigOperationSettings() {
      return updateShieldedInstanceConfigOperationSettings;
    }

    @Override
    public InstancesStubSettings build() throws IOException {
      return new InstancesStubSettings(this);
    }
  }
}
