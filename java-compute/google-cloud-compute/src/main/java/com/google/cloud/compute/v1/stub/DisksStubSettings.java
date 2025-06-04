/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.compute.v1.DisksClient.AggregatedListPagedResponse;
import static com.google.cloud.compute.v1.DisksClient.ListPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
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
import com.google.cloud.compute.v1.AddResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.AggregatedListDisksRequest;
import com.google.cloud.compute.v1.BulkInsertDiskRequest;
import com.google.cloud.compute.v1.BulkSetLabelsDiskRequest;
import com.google.cloud.compute.v1.CreateSnapshotDiskRequest;
import com.google.cloud.compute.v1.DeleteDiskRequest;
import com.google.cloud.compute.v1.Disk;
import com.google.cloud.compute.v1.DiskAggregatedList;
import com.google.cloud.compute.v1.DiskList;
import com.google.cloud.compute.v1.DisksScopedList;
import com.google.cloud.compute.v1.GetDiskRequest;
import com.google.cloud.compute.v1.GetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.InsertDiskRequest;
import com.google.cloud.compute.v1.ListDisksRequest;
import com.google.cloud.compute.v1.Operation;
import com.google.cloud.compute.v1.Policy;
import com.google.cloud.compute.v1.RemoveResourcePoliciesDiskRequest;
import com.google.cloud.compute.v1.ResizeDiskRequest;
import com.google.cloud.compute.v1.SetIamPolicyDiskRequest;
import com.google.cloud.compute.v1.SetLabelsDiskRequest;
import com.google.cloud.compute.v1.StartAsyncReplicationDiskRequest;
import com.google.cloud.compute.v1.StopAsyncReplicationDiskRequest;
import com.google.cloud.compute.v1.StopGroupAsyncReplicationDiskRequest;
import com.google.cloud.compute.v1.TestIamPermissionsDiskRequest;
import com.google.cloud.compute.v1.TestPermissionsResponse;
import com.google.cloud.compute.v1.UpdateDiskRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link DisksStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of get:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DisksStubSettings.Builder disksSettingsBuilder = DisksStubSettings.newBuilder();
 * disksSettingsBuilder
 *     .getSettings()
 *     .setRetrySettings(
 *         disksSettingsBuilder
 *             .getSettings()
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
 * DisksStubSettings disksSettings = disksSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for addResourcePolicies:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DisksStubSettings.Builder disksSettingsBuilder = DisksStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * disksSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DisksStubSettings extends StubSettings<DisksStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/compute")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final UnaryCallSettings<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesSettings;
  private final OperationCallSettings<AddResourcePoliciesDiskRequest, Operation, Operation>
      addResourcePoliciesOperationSettings;
  private final PagedCallSettings<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings;
  private final UnaryCallSettings<BulkInsertDiskRequest, Operation> bulkInsertSettings;
  private final OperationCallSettings<BulkInsertDiskRequest, Operation, Operation>
      bulkInsertOperationSettings;
  private final UnaryCallSettings<BulkSetLabelsDiskRequest, Operation> bulkSetLabelsSettings;
  private final OperationCallSettings<BulkSetLabelsDiskRequest, Operation, Operation>
      bulkSetLabelsOperationSettings;
  private final UnaryCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotSettings;
  private final OperationCallSettings<CreateSnapshotDiskRequest, Operation, Operation>
      createSnapshotOperationSettings;
  private final UnaryCallSettings<DeleteDiskRequest, Operation> deleteSettings;
  private final OperationCallSettings<DeleteDiskRequest, Operation, Operation>
      deleteOperationSettings;
  private final UnaryCallSettings<GetDiskRequest, Disk> getSettings;
  private final UnaryCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<InsertDiskRequest, Operation> insertSettings;
  private final OperationCallSettings<InsertDiskRequest, Operation, Operation>
      insertOperationSettings;
  private final PagedCallSettings<ListDisksRequest, DiskList, ListPagedResponse> listSettings;
  private final UnaryCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesSettings;
  private final OperationCallSettings<RemoveResourcePoliciesDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings;
  private final UnaryCallSettings<ResizeDiskRequest, Operation> resizeSettings;
  private final OperationCallSettings<ResizeDiskRequest, Operation, Operation>
      resizeOperationSettings;
  private final UnaryCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<SetLabelsDiskRequest, Operation> setLabelsSettings;
  private final OperationCallSettings<SetLabelsDiskRequest, Operation, Operation>
      setLabelsOperationSettings;
  private final UnaryCallSettings<StartAsyncReplicationDiskRequest, Operation>
      startAsyncReplicationSettings;
  private final OperationCallSettings<StartAsyncReplicationDiskRequest, Operation, Operation>
      startAsyncReplicationOperationSettings;
  private final UnaryCallSettings<StopAsyncReplicationDiskRequest, Operation>
      stopAsyncReplicationSettings;
  private final OperationCallSettings<StopAsyncReplicationDiskRequest, Operation, Operation>
      stopAsyncReplicationOperationSettings;
  private final UnaryCallSettings<StopGroupAsyncReplicationDiskRequest, Operation>
      stopGroupAsyncReplicationSettings;
  private final OperationCallSettings<StopGroupAsyncReplicationDiskRequest, Operation, Operation>
      stopGroupAsyncReplicationOperationSettings;
  private final UnaryCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings;
  private final UnaryCallSettings<UpdateDiskRequest, Operation> updateSettings;
  private final OperationCallSettings<UpdateDiskRequest, Operation, Operation>
      updateOperationSettings;

  private static final PagedListDescriptor<
          AggregatedListDisksRequest, DiskAggregatedList, Map.Entry<String, DisksScopedList>>
      AGGREGATED_LIST_PAGE_STR_DESC =
          new PagedListDescriptor<
              AggregatedListDisksRequest,
              DiskAggregatedList,
              Map.Entry<String, DisksScopedList>>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public AggregatedListDisksRequest injectToken(
                AggregatedListDisksRequest payload, String token) {
              return AggregatedListDisksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public AggregatedListDisksRequest injectPageSize(
                AggregatedListDisksRequest payload, int pageSize) {
              return AggregatedListDisksRequest.newBuilder(payload).setMaxResults(pageSize).build();
            }

            @Override
            public Integer extractPageSize(AggregatedListDisksRequest payload) {
              return payload.getMaxResults();
            }

            @Override
            public String extractNextToken(DiskAggregatedList payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Map.Entry<String, DisksScopedList>> extractResources(
                DiskAggregatedList payload) {
              return payload.getItemsMap().entrySet();
            }
          };

  private static final PagedListDescriptor<ListDisksRequest, DiskList, Disk> LIST_PAGE_STR_DESC =
      new PagedListDescriptor<ListDisksRequest, DiskList, Disk>() {
        @Override
        public String emptyToken() {
          return "";
        }

        @Override
        public ListDisksRequest injectToken(ListDisksRequest payload, String token) {
          return ListDisksRequest.newBuilder(payload).setPageToken(token).build();
        }

        @Override
        public ListDisksRequest injectPageSize(ListDisksRequest payload, int pageSize) {
          return ListDisksRequest.newBuilder(payload).setMaxResults(pageSize).build();
        }

        @Override
        public Integer extractPageSize(ListDisksRequest payload) {
          return payload.getMaxResults();
        }

        @Override
        public String extractNextToken(DiskList payload) {
          return payload.getNextPageToken();
        }

        @Override
        public Iterable<Disk> extractResources(DiskList payload) {
          return payload.getItemsList();
        }
      };

  private static final PagedListResponseFactory<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      AGGREGATED_LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<
              AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>() {
            @Override
            public ApiFuture<AggregatedListPagedResponse> getFuturePagedResponse(
                UnaryCallable<AggregatedListDisksRequest, DiskAggregatedList> callable,
                AggregatedListDisksRequest request,
                ApiCallContext context,
                ApiFuture<DiskAggregatedList> futureResponse) {
              PageContext<
                      AggregatedListDisksRequest,
                      DiskAggregatedList,
                      Map.Entry<String, DisksScopedList>>
                  pageContext =
                      PageContext.create(callable, AGGREGATED_LIST_PAGE_STR_DESC, request, context);
              return AggregatedListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<ListDisksRequest, DiskList, ListPagedResponse>
      LIST_PAGE_STR_FACT =
          new PagedListResponseFactory<ListDisksRequest, DiskList, ListPagedResponse>() {
            @Override
            public ApiFuture<ListPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDisksRequest, DiskList> callable,
                ListDisksRequest request,
                ApiCallContext context,
                ApiFuture<DiskList> futureResponse) {
              PageContext<ListDisksRequest, DiskList, Disk> pageContext =
                  PageContext.create(callable, LIST_PAGE_STR_DESC, request, context);
              return ListPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public UnaryCallSettings<AddResourcePoliciesDiskRequest, Operation>
      addResourcePoliciesSettings() {
    return addResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to addResourcePolicies. */
  public OperationCallSettings<AddResourcePoliciesDiskRequest, Operation, Operation>
      addResourcePoliciesOperationSettings() {
    return addResourcePoliciesOperationSettings;
  }

  /** Returns the object with the settings used for calls to aggregatedList. */
  public PagedCallSettings<
          AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
      aggregatedListSettings() {
    return aggregatedListSettings;
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public UnaryCallSettings<BulkInsertDiskRequest, Operation> bulkInsertSettings() {
    return bulkInsertSettings;
  }

  /** Returns the object with the settings used for calls to bulkInsert. */
  public OperationCallSettings<BulkInsertDiskRequest, Operation, Operation>
      bulkInsertOperationSettings() {
    return bulkInsertOperationSettings;
  }

  /** Returns the object with the settings used for calls to bulkSetLabels. */
  public UnaryCallSettings<BulkSetLabelsDiskRequest, Operation> bulkSetLabelsSettings() {
    return bulkSetLabelsSettings;
  }

  /** Returns the object with the settings used for calls to bulkSetLabels. */
  public OperationCallSettings<BulkSetLabelsDiskRequest, Operation, Operation>
      bulkSetLabelsOperationSettings() {
    return bulkSetLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public UnaryCallSettings<CreateSnapshotDiskRequest, Operation> createSnapshotSettings() {
    return createSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to createSnapshot. */
  public OperationCallSettings<CreateSnapshotDiskRequest, Operation, Operation>
      createSnapshotOperationSettings() {
    return createSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteDiskRequest, Operation> deleteSettings() {
    return deleteSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public OperationCallSettings<DeleteDiskRequest, Operation, Operation> deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetDiskRequest, Disk> getSettings() {
    return getSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public UnaryCallSettings<InsertDiskRequest, Operation> insertSettings() {
    return insertSettings;
  }

  /** Returns the object with the settings used for calls to insert. */
  public OperationCallSettings<InsertDiskRequest, Operation, Operation> insertOperationSettings() {
    return insertOperationSettings;
  }

  /** Returns the object with the settings used for calls to list. */
  public PagedCallSettings<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
    return listSettings;
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public UnaryCallSettings<RemoveResourcePoliciesDiskRequest, Operation>
      removeResourcePoliciesSettings() {
    return removeResourcePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to removeResourcePolicies. */
  public OperationCallSettings<RemoveResourcePoliciesDiskRequest, Operation, Operation>
      removeResourcePoliciesOperationSettings() {
    return removeResourcePoliciesOperationSettings;
  }

  /** Returns the object with the settings used for calls to resize. */
  public UnaryCallSettings<ResizeDiskRequest, Operation> resizeSettings() {
    return resizeSettings;
  }

  /** Returns the object with the settings used for calls to resize. */
  public OperationCallSettings<ResizeDiskRequest, Operation, Operation> resizeOperationSettings() {
    return resizeOperationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public UnaryCallSettings<SetLabelsDiskRequest, Operation> setLabelsSettings() {
    return setLabelsSettings;
  }

  /** Returns the object with the settings used for calls to setLabels. */
  public OperationCallSettings<SetLabelsDiskRequest, Operation, Operation>
      setLabelsOperationSettings() {
    return setLabelsOperationSettings;
  }

  /** Returns the object with the settings used for calls to startAsyncReplication. */
  public UnaryCallSettings<StartAsyncReplicationDiskRequest, Operation>
      startAsyncReplicationSettings() {
    return startAsyncReplicationSettings;
  }

  /** Returns the object with the settings used for calls to startAsyncReplication. */
  public OperationCallSettings<StartAsyncReplicationDiskRequest, Operation, Operation>
      startAsyncReplicationOperationSettings() {
    return startAsyncReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopAsyncReplication. */
  public UnaryCallSettings<StopAsyncReplicationDiskRequest, Operation>
      stopAsyncReplicationSettings() {
    return stopAsyncReplicationSettings;
  }

  /** Returns the object with the settings used for calls to stopAsyncReplication. */
  public OperationCallSettings<StopAsyncReplicationDiskRequest, Operation, Operation>
      stopAsyncReplicationOperationSettings() {
    return stopAsyncReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopGroupAsyncReplication. */
  public UnaryCallSettings<StopGroupAsyncReplicationDiskRequest, Operation>
      stopGroupAsyncReplicationSettings() {
    return stopGroupAsyncReplicationSettings;
  }

  /** Returns the object with the settings used for calls to stopGroupAsyncReplication. */
  public OperationCallSettings<StopGroupAsyncReplicationDiskRequest, Operation, Operation>
      stopGroupAsyncReplicationOperationSettings() {
    return stopGroupAsyncReplicationOperationSettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsDiskRequest, TestPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public UnaryCallSettings<UpdateDiskRequest, Operation> updateSettings() {
    return updateSettings;
  }

  /** Returns the object with the settings used for calls to update. */
  public OperationCallSettings<UpdateDiskRequest, Operation, Operation> updateOperationSettings() {
    return updateOperationSettings;
  }

  public DisksStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDisksStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "compute";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(DisksStubSettings.class))
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

  protected DisksStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    addResourcePoliciesSettings = settingsBuilder.addResourcePoliciesSettings().build();
    addResourcePoliciesOperationSettings =
        settingsBuilder.addResourcePoliciesOperationSettings().build();
    aggregatedListSettings = settingsBuilder.aggregatedListSettings().build();
    bulkInsertSettings = settingsBuilder.bulkInsertSettings().build();
    bulkInsertOperationSettings = settingsBuilder.bulkInsertOperationSettings().build();
    bulkSetLabelsSettings = settingsBuilder.bulkSetLabelsSettings().build();
    bulkSetLabelsOperationSettings = settingsBuilder.bulkSetLabelsOperationSettings().build();
    createSnapshotSettings = settingsBuilder.createSnapshotSettings().build();
    createSnapshotOperationSettings = settingsBuilder.createSnapshotOperationSettings().build();
    deleteSettings = settingsBuilder.deleteSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    getSettings = settingsBuilder.getSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    insertSettings = settingsBuilder.insertSettings().build();
    insertOperationSettings = settingsBuilder.insertOperationSettings().build();
    listSettings = settingsBuilder.listSettings().build();
    removeResourcePoliciesSettings = settingsBuilder.removeResourcePoliciesSettings().build();
    removeResourcePoliciesOperationSettings =
        settingsBuilder.removeResourcePoliciesOperationSettings().build();
    resizeSettings = settingsBuilder.resizeSettings().build();
    resizeOperationSettings = settingsBuilder.resizeOperationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    setLabelsSettings = settingsBuilder.setLabelsSettings().build();
    setLabelsOperationSettings = settingsBuilder.setLabelsOperationSettings().build();
    startAsyncReplicationSettings = settingsBuilder.startAsyncReplicationSettings().build();
    startAsyncReplicationOperationSettings =
        settingsBuilder.startAsyncReplicationOperationSettings().build();
    stopAsyncReplicationSettings = settingsBuilder.stopAsyncReplicationSettings().build();
    stopAsyncReplicationOperationSettings =
        settingsBuilder.stopAsyncReplicationOperationSettings().build();
    stopGroupAsyncReplicationSettings = settingsBuilder.stopGroupAsyncReplicationSettings().build();
    stopGroupAsyncReplicationOperationSettings =
        settingsBuilder.stopGroupAsyncReplicationOperationSettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    updateSettings = settingsBuilder.updateSettings().build();
    updateOperationSettings = settingsBuilder.updateOperationSettings().build();
  }

  /** Builder for DisksStubSettings. */
  public static class Builder extends StubSettings.Builder<DisksStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesSettings;
    private final OperationCallSettings.Builder<
            AddResourcePoliciesDiskRequest, Operation, Operation>
        addResourcePoliciesOperationSettings;
    private final PagedCallSettings.Builder<
            AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings;
    private final UnaryCallSettings.Builder<BulkInsertDiskRequest, Operation> bulkInsertSettings;
    private final OperationCallSettings.Builder<BulkInsertDiskRequest, Operation, Operation>
        bulkInsertOperationSettings;
    private final UnaryCallSettings.Builder<BulkSetLabelsDiskRequest, Operation>
        bulkSetLabelsSettings;
    private final OperationCallSettings.Builder<BulkSetLabelsDiskRequest, Operation, Operation>
        bulkSetLabelsOperationSettings;
    private final UnaryCallSettings.Builder<CreateSnapshotDiskRequest, Operation>
        createSnapshotSettings;
    private final OperationCallSettings.Builder<CreateSnapshotDiskRequest, Operation, Operation>
        createSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDiskRequest, Operation> deleteSettings;
    private final OperationCallSettings.Builder<DeleteDiskRequest, Operation, Operation>
        deleteOperationSettings;
    private final UnaryCallSettings.Builder<GetDiskRequest, Disk> getSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyDiskRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<InsertDiskRequest, Operation> insertSettings;
    private final OperationCallSettings.Builder<InsertDiskRequest, Operation, Operation>
        insertOperationSettings;
    private final PagedCallSettings.Builder<ListDisksRequest, DiskList, ListPagedResponse>
        listSettings;
    private final UnaryCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesSettings;
    private final OperationCallSettings.Builder<
            RemoveResourcePoliciesDiskRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings;
    private final UnaryCallSettings.Builder<ResizeDiskRequest, Operation> resizeSettings;
    private final OperationCallSettings.Builder<ResizeDiskRequest, Operation, Operation>
        resizeOperationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyDiskRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<SetLabelsDiskRequest, Operation> setLabelsSettings;
    private final OperationCallSettings.Builder<SetLabelsDiskRequest, Operation, Operation>
        setLabelsOperationSettings;
    private final UnaryCallSettings.Builder<StartAsyncReplicationDiskRequest, Operation>
        startAsyncReplicationSettings;
    private final OperationCallSettings.Builder<
            StartAsyncReplicationDiskRequest, Operation, Operation>
        startAsyncReplicationOperationSettings;
    private final UnaryCallSettings.Builder<StopAsyncReplicationDiskRequest, Operation>
        stopAsyncReplicationSettings;
    private final OperationCallSettings.Builder<
            StopAsyncReplicationDiskRequest, Operation, Operation>
        stopAsyncReplicationOperationSettings;
    private final UnaryCallSettings.Builder<StopGroupAsyncReplicationDiskRequest, Operation>
        stopGroupAsyncReplicationSettings;
    private final OperationCallSettings.Builder<
            StopGroupAsyncReplicationDiskRequest, Operation, Operation>
        stopGroupAsyncReplicationOperationSettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsDiskRequest, TestPermissionsResponse>
        testIamPermissionsSettings;
    private final UnaryCallSettings.Builder<UpdateDiskRequest, Operation> updateSettings;
    private final OperationCallSettings.Builder<UpdateDiskRequest, Operation, Operation>
        updateOperationSettings;
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
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(600000L))
              .setTotalTimeoutDuration(Duration.ofMillis(600000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      addResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      addResourcePoliciesOperationSettings = OperationCallSettings.newBuilder();
      aggregatedListSettings = PagedCallSettings.newBuilder(AGGREGATED_LIST_PAGE_STR_FACT);
      bulkInsertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkInsertOperationSettings = OperationCallSettings.newBuilder();
      bulkSetLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      bulkSetLabelsOperationSettings = OperationCallSettings.newBuilder();
      createSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSnapshotOperationSettings = OperationCallSettings.newBuilder();
      deleteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = OperationCallSettings.newBuilder();
      getSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      insertOperationSettings = OperationCallSettings.newBuilder();
      listSettings = PagedCallSettings.newBuilder(LIST_PAGE_STR_FACT);
      removeResourcePoliciesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeResourcePoliciesOperationSettings = OperationCallSettings.newBuilder();
      resizeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resizeOperationSettings = OperationCallSettings.newBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setLabelsOperationSettings = OperationCallSettings.newBuilder();
      startAsyncReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startAsyncReplicationOperationSettings = OperationCallSettings.newBuilder();
      stopAsyncReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopAsyncReplicationOperationSettings = OperationCallSettings.newBuilder();
      stopGroupAsyncReplicationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopGroupAsyncReplicationOperationSettings = OperationCallSettings.newBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesSettings,
              aggregatedListSettings,
              bulkInsertSettings,
              bulkSetLabelsSettings,
              createSnapshotSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              removeResourcePoliciesSettings,
              resizeSettings,
              setIamPolicySettings,
              setLabelsSettings,
              startAsyncReplicationSettings,
              stopAsyncReplicationSettings,
              stopGroupAsyncReplicationSettings,
              testIamPermissionsSettings,
              updateSettings);
      initDefaults(this);
    }

    protected Builder(DisksStubSettings settings) {
      super(settings);

      addResourcePoliciesSettings = settings.addResourcePoliciesSettings.toBuilder();
      addResourcePoliciesOperationSettings =
          settings.addResourcePoliciesOperationSettings.toBuilder();
      aggregatedListSettings = settings.aggregatedListSettings.toBuilder();
      bulkInsertSettings = settings.bulkInsertSettings.toBuilder();
      bulkInsertOperationSettings = settings.bulkInsertOperationSettings.toBuilder();
      bulkSetLabelsSettings = settings.bulkSetLabelsSettings.toBuilder();
      bulkSetLabelsOperationSettings = settings.bulkSetLabelsOperationSettings.toBuilder();
      createSnapshotSettings = settings.createSnapshotSettings.toBuilder();
      createSnapshotOperationSettings = settings.createSnapshotOperationSettings.toBuilder();
      deleteSettings = settings.deleteSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      getSettings = settings.getSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      insertSettings = settings.insertSettings.toBuilder();
      insertOperationSettings = settings.insertOperationSettings.toBuilder();
      listSettings = settings.listSettings.toBuilder();
      removeResourcePoliciesSettings = settings.removeResourcePoliciesSettings.toBuilder();
      removeResourcePoliciesOperationSettings =
          settings.removeResourcePoliciesOperationSettings.toBuilder();
      resizeSettings = settings.resizeSettings.toBuilder();
      resizeOperationSettings = settings.resizeOperationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      setLabelsSettings = settings.setLabelsSettings.toBuilder();
      setLabelsOperationSettings = settings.setLabelsOperationSettings.toBuilder();
      startAsyncReplicationSettings = settings.startAsyncReplicationSettings.toBuilder();
      startAsyncReplicationOperationSettings =
          settings.startAsyncReplicationOperationSettings.toBuilder();
      stopAsyncReplicationSettings = settings.stopAsyncReplicationSettings.toBuilder();
      stopAsyncReplicationOperationSettings =
          settings.stopAsyncReplicationOperationSettings.toBuilder();
      stopGroupAsyncReplicationSettings = settings.stopGroupAsyncReplicationSettings.toBuilder();
      stopGroupAsyncReplicationOperationSettings =
          settings.stopGroupAsyncReplicationOperationSettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      updateSettings = settings.updateSettings.toBuilder();
      updateOperationSettings = settings.updateOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              addResourcePoliciesSettings,
              aggregatedListSettings,
              bulkInsertSettings,
              bulkSetLabelsSettings,
              createSnapshotSettings,
              deleteSettings,
              getSettings,
              getIamPolicySettings,
              insertSettings,
              listSettings,
              removeResourcePoliciesSettings,
              resizeSettings,
              setIamPolicySettings,
              setLabelsSettings,
              startAsyncReplicationSettings,
              stopAsyncReplicationSettings,
              stopGroupAsyncReplicationSettings,
              testIamPermissionsSettings,
              updateSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .addResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .aggregatedListSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .bulkInsertSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .bulkSetLabelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
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
          .removeResourcePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .resizeSettings()
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
          .startAsyncReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopAsyncReplicationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopGroupAsyncReplicationSettings()
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
          .addResourcePoliciesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<AddResourcePoliciesDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .bulkInsertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkInsertDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .bulkSetLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BulkSetLabelsDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .createSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateSnapshotDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .insertOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<InsertDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .removeResourcePoliciesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RemoveResourcePoliciesDiskRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .resizeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<ResizeDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .setLabelsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SetLabelsDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .startAsyncReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartAsyncReplicationDiskRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .stopAsyncReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopAsyncReplicationDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .stopGroupAsyncReplicationOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopGroupAsyncReplicationDiskRequest, OperationSnapshot>
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateDiskRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(20000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
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

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public UnaryCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation>
        addResourcePoliciesSettings() {
      return addResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to addResourcePolicies. */
    public OperationCallSettings.Builder<AddResourcePoliciesDiskRequest, Operation, Operation>
        addResourcePoliciesOperationSettings() {
      return addResourcePoliciesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to aggregatedList. */
    public PagedCallSettings.Builder<
            AggregatedListDisksRequest, DiskAggregatedList, AggregatedListPagedResponse>
        aggregatedListSettings() {
      return aggregatedListSettings;
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public UnaryCallSettings.Builder<BulkInsertDiskRequest, Operation> bulkInsertSettings() {
      return bulkInsertSettings;
    }

    /** Returns the builder for the settings used for calls to bulkInsert. */
    public OperationCallSettings.Builder<BulkInsertDiskRequest, Operation, Operation>
        bulkInsertOperationSettings() {
      return bulkInsertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to bulkSetLabels. */
    public UnaryCallSettings.Builder<BulkSetLabelsDiskRequest, Operation> bulkSetLabelsSettings() {
      return bulkSetLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to bulkSetLabels. */
    public OperationCallSettings.Builder<BulkSetLabelsDiskRequest, Operation, Operation>
        bulkSetLabelsOperationSettings() {
      return bulkSetLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public UnaryCallSettings.Builder<CreateSnapshotDiskRequest, Operation>
        createSnapshotSettings() {
      return createSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshot. */
    public OperationCallSettings.Builder<CreateSnapshotDiskRequest, Operation, Operation>
        createSnapshotOperationSettings() {
      return createSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteDiskRequest, Operation> deleteSettings() {
      return deleteSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public OperationCallSettings.Builder<DeleteDiskRequest, Operation, Operation>
        deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetDiskRequest, Disk> getSettings() {
      return getSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyDiskRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public UnaryCallSettings.Builder<InsertDiskRequest, Operation> insertSettings() {
      return insertSettings;
    }

    /** Returns the builder for the settings used for calls to insert. */
    public OperationCallSettings.Builder<InsertDiskRequest, Operation, Operation>
        insertOperationSettings() {
      return insertOperationSettings;
    }

    /** Returns the builder for the settings used for calls to list. */
    public PagedCallSettings.Builder<ListDisksRequest, DiskList, ListPagedResponse> listSettings() {
      return listSettings;
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public UnaryCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation>
        removeResourcePoliciesSettings() {
      return removeResourcePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to removeResourcePolicies. */
    public OperationCallSettings.Builder<RemoveResourcePoliciesDiskRequest, Operation, Operation>
        removeResourcePoliciesOperationSettings() {
      return removeResourcePoliciesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to resize. */
    public UnaryCallSettings.Builder<ResizeDiskRequest, Operation> resizeSettings() {
      return resizeSettings;
    }

    /** Returns the builder for the settings used for calls to resize. */
    public OperationCallSettings.Builder<ResizeDiskRequest, Operation, Operation>
        resizeOperationSettings() {
      return resizeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyDiskRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public UnaryCallSettings.Builder<SetLabelsDiskRequest, Operation> setLabelsSettings() {
      return setLabelsSettings;
    }

    /** Returns the builder for the settings used for calls to setLabels. */
    public OperationCallSettings.Builder<SetLabelsDiskRequest, Operation, Operation>
        setLabelsOperationSettings() {
      return setLabelsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startAsyncReplication. */
    public UnaryCallSettings.Builder<StartAsyncReplicationDiskRequest, Operation>
        startAsyncReplicationSettings() {
      return startAsyncReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to startAsyncReplication. */
    public OperationCallSettings.Builder<StartAsyncReplicationDiskRequest, Operation, Operation>
        startAsyncReplicationOperationSettings() {
      return startAsyncReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopAsyncReplication. */
    public UnaryCallSettings.Builder<StopAsyncReplicationDiskRequest, Operation>
        stopAsyncReplicationSettings() {
      return stopAsyncReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to stopAsyncReplication. */
    public OperationCallSettings.Builder<StopAsyncReplicationDiskRequest, Operation, Operation>
        stopAsyncReplicationOperationSettings() {
      return stopAsyncReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopGroupAsyncReplication. */
    public UnaryCallSettings.Builder<StopGroupAsyncReplicationDiskRequest, Operation>
        stopGroupAsyncReplicationSettings() {
      return stopGroupAsyncReplicationSettings;
    }

    /** Returns the builder for the settings used for calls to stopGroupAsyncReplication. */
    public OperationCallSettings.Builder<StopGroupAsyncReplicationDiskRequest, Operation, Operation>
        stopGroupAsyncReplicationOperationSettings() {
      return stopGroupAsyncReplicationOperationSettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsDiskRequest, TestPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public UnaryCallSettings.Builder<UpdateDiskRequest, Operation> updateSettings() {
      return updateSettings;
    }

    /** Returns the builder for the settings used for calls to update. */
    public OperationCallSettings.Builder<UpdateDiskRequest, Operation, Operation>
        updateOperationSettings() {
      return updateOperationSettings;
    }

    @Override
    public DisksStubSettings build() throws IOException {
      return new DisksStubSettings(this);
    }
  }
}
