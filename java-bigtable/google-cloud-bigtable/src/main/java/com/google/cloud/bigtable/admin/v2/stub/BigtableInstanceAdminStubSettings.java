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

package com.google.cloud.bigtable.admin.v2.stub;

import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListAppProfilesPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListHotTabletsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListLogicalViewsPagedResponse;
import static com.google.cloud.bigtable.admin.v2.BaseBigtableInstanceAdminClient.ListMaterializedViewsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
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
import com.google.bigtable.admin.v2.AppProfile;
import com.google.bigtable.admin.v2.Cluster;
import com.google.bigtable.admin.v2.CreateAppProfileRequest;
import com.google.bigtable.admin.v2.CreateClusterMetadata;
import com.google.bigtable.admin.v2.CreateClusterRequest;
import com.google.bigtable.admin.v2.CreateInstanceMetadata;
import com.google.bigtable.admin.v2.CreateInstanceRequest;
import com.google.bigtable.admin.v2.CreateLogicalViewMetadata;
import com.google.bigtable.admin.v2.CreateLogicalViewRequest;
import com.google.bigtable.admin.v2.CreateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.CreateMaterializedViewRequest;
import com.google.bigtable.admin.v2.DeleteAppProfileRequest;
import com.google.bigtable.admin.v2.DeleteClusterRequest;
import com.google.bigtable.admin.v2.DeleteInstanceRequest;
import com.google.bigtable.admin.v2.DeleteLogicalViewRequest;
import com.google.bigtable.admin.v2.DeleteMaterializedViewRequest;
import com.google.bigtable.admin.v2.GetAppProfileRequest;
import com.google.bigtable.admin.v2.GetClusterRequest;
import com.google.bigtable.admin.v2.GetInstanceRequest;
import com.google.bigtable.admin.v2.GetLogicalViewRequest;
import com.google.bigtable.admin.v2.GetMaterializedViewRequest;
import com.google.bigtable.admin.v2.HotTablet;
import com.google.bigtable.admin.v2.Instance;
import com.google.bigtable.admin.v2.ListAppProfilesRequest;
import com.google.bigtable.admin.v2.ListAppProfilesResponse;
import com.google.bigtable.admin.v2.ListClustersRequest;
import com.google.bigtable.admin.v2.ListClustersResponse;
import com.google.bigtable.admin.v2.ListHotTabletsRequest;
import com.google.bigtable.admin.v2.ListHotTabletsResponse;
import com.google.bigtable.admin.v2.ListInstancesRequest;
import com.google.bigtable.admin.v2.ListInstancesResponse;
import com.google.bigtable.admin.v2.ListLogicalViewsRequest;
import com.google.bigtable.admin.v2.ListLogicalViewsResponse;
import com.google.bigtable.admin.v2.ListMaterializedViewsRequest;
import com.google.bigtable.admin.v2.ListMaterializedViewsResponse;
import com.google.bigtable.admin.v2.LogicalView;
import com.google.bigtable.admin.v2.MaterializedView;
import com.google.bigtable.admin.v2.PartialUpdateClusterMetadata;
import com.google.bigtable.admin.v2.PartialUpdateClusterRequest;
import com.google.bigtable.admin.v2.PartialUpdateInstanceRequest;
import com.google.bigtable.admin.v2.UpdateAppProfileMetadata;
import com.google.bigtable.admin.v2.UpdateAppProfileRequest;
import com.google.bigtable.admin.v2.UpdateClusterMetadata;
import com.google.bigtable.admin.v2.UpdateInstanceMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewMetadata;
import com.google.bigtable.admin.v2.UpdateLogicalViewRequest;
import com.google.bigtable.admin.v2.UpdateMaterializedViewMetadata;
import com.google.bigtable.admin.v2.UpdateMaterializedViewRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BigtableInstanceAdminStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (bigtableadmin.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BigtableInstanceAdminStubSettings.Builder baseBigtableInstanceAdminSettingsBuilder =
 *     BigtableInstanceAdminStubSettings.newBuilder();
 * baseBigtableInstanceAdminSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         baseBigtableInstanceAdminSettingsBuilder
 *             .getInstanceSettings()
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
 * BigtableInstanceAdminStubSettings baseBigtableInstanceAdminSettings =
 *     baseBigtableInstanceAdminSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BigtableInstanceAdminStubSettings.Builder baseBigtableInstanceAdminSettingsBuilder =
 *     BigtableInstanceAdminStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * baseBigtableInstanceAdminSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BigtableInstanceAdminStubSettings
    extends StubSettings<BigtableInstanceAdminStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigtable.admin")
          .add("https://www.googleapis.com/auth/bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/bigtable.admin.instance")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin")
          .add("https://www.googleapis.com/auth/cloud-bigtable.admin.cluster")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .build();

  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<ListInstancesRequest, ListInstancesResponse>
      listInstancesSettings;
  private final UnaryCallSettings<Instance, Instance> updateInstanceSettings;
  private final UnaryCallSettings<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceSettings;
  private final OperationCallSettings<
          PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings;
  private final UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings;
  private final OperationCallSettings<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationSettings;
  private final UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings;
  private final UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings;
  private final UnaryCallSettings<Cluster, Operation> updateClusterSettings;
  private final OperationCallSettings<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationSettings;
  private final UnaryCallSettings<PartialUpdateClusterRequest, Operation>
      partialUpdateClusterSettings;
  private final OperationCallSettings<
          PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
      partialUpdateClusterOperationSettings;
  private final UnaryCallSettings<DeleteClusterRequest, Empty> deleteClusterSettings;
  private final UnaryCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileSettings;
  private final UnaryCallSettings<GetAppProfileRequest, AppProfile> getAppProfileSettings;
  private final PagedCallSettings<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      listAppProfilesSettings;
  private final UnaryCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileSettings;
  private final OperationCallSettings<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationSettings;
  private final UnaryCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final PagedCallSettings<
          ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>
      listHotTabletsSettings;
  private final UnaryCallSettings<CreateLogicalViewRequest, Operation> createLogicalViewSettings;
  private final OperationCallSettings<
          CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
      createLogicalViewOperationSettings;
  private final UnaryCallSettings<GetLogicalViewRequest, LogicalView> getLogicalViewSettings;
  private final PagedCallSettings<
          ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>
      listLogicalViewsSettings;
  private final UnaryCallSettings<UpdateLogicalViewRequest, Operation> updateLogicalViewSettings;
  private final OperationCallSettings<
          UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
      updateLogicalViewOperationSettings;
  private final UnaryCallSettings<DeleteLogicalViewRequest, Empty> deleteLogicalViewSettings;
  private final UnaryCallSettings<CreateMaterializedViewRequest, Operation>
      createMaterializedViewSettings;
  private final OperationCallSettings<
          CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewOperationSettings;
  private final UnaryCallSettings<GetMaterializedViewRequest, MaterializedView>
      getMaterializedViewSettings;
  private final PagedCallSettings<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          ListMaterializedViewsPagedResponse>
      listMaterializedViewsSettings;
  private final UnaryCallSettings<UpdateMaterializedViewRequest, Operation>
      updateMaterializedViewSettings;
  private final OperationCallSettings<
          UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewOperationSettings;
  private final UnaryCallSettings<DeleteMaterializedViewRequest, Empty>
      deleteMaterializedViewSettings;

  private static final PagedListDescriptor<
          ListAppProfilesRequest, ListAppProfilesResponse, AppProfile>
      LIST_APP_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAppProfilesRequest injectToken(
                ListAppProfilesRequest payload, String token) {
              return ListAppProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAppProfilesRequest injectPageSize(
                ListAppProfilesRequest payload, int pageSize) {
              return ListAppProfilesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAppProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAppProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<AppProfile> extractResources(ListAppProfilesResponse payload) {
              return payload.getAppProfilesList();
            }
          };

  private static final PagedListDescriptor<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet>
      LIST_HOT_TABLETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHotTabletsRequest injectToken(ListHotTabletsRequest payload, String token) {
              return ListHotTabletsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHotTabletsRequest injectPageSize(
                ListHotTabletsRequest payload, int pageSize) {
              return ListHotTabletsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHotTabletsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHotTabletsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HotTablet> extractResources(ListHotTabletsResponse payload) {
              return payload.getHotTabletsList();
            }
          };

  private static final PagedListDescriptor<
          ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView>
      LIST_LOGICAL_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogicalViewsRequest injectToken(
                ListLogicalViewsRequest payload, String token) {
              return ListLogicalViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLogicalViewsRequest injectPageSize(
                ListLogicalViewsRequest payload, int pageSize) {
              return ListLogicalViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogicalViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogicalViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogicalView> extractResources(ListLogicalViewsResponse payload) {
              return payload.getLogicalViewsList();
            }
          };

  private static final PagedListDescriptor<
          ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
      LIST_MATERIALIZED_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMaterializedViewsRequest injectToken(
                ListMaterializedViewsRequest payload, String token) {
              return ListMaterializedViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMaterializedViewsRequest injectPageSize(
                ListMaterializedViewsRequest payload, int pageSize) {
              return ListMaterializedViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMaterializedViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMaterializedViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MaterializedView> extractResources(
                ListMaterializedViewsResponse payload) {
              return payload.getMaterializedViewsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      LIST_APP_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListAppProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAppProfilesRequest, ListAppProfilesResponse> callable,
                ListAppProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListAppProfilesResponse> futureResponse) {
              PageContext<ListAppProfilesRequest, ListAppProfilesResponse, AppProfile> pageContext =
                  PageContext.create(callable, LIST_APP_PROFILES_PAGE_STR_DESC, request, context);
              return ListAppProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>
      LIST_HOT_TABLETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>() {
            @Override
            public ApiFuture<ListHotTabletsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHotTabletsRequest, ListHotTabletsResponse> callable,
                ListHotTabletsRequest request,
                ApiCallContext context,
                ApiFuture<ListHotTabletsResponse> futureResponse) {
              PageContext<ListHotTabletsRequest, ListHotTabletsResponse, HotTablet> pageContext =
                  PageContext.create(callable, LIST_HOT_TABLETS_PAGE_STR_DESC, request, context);
              return ListHotTabletsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>
      LIST_LOGICAL_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>() {
            @Override
            public ApiFuture<ListLogicalViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogicalViewsRequest, ListLogicalViewsResponse> callable,
                ListLogicalViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListLogicalViewsResponse> futureResponse) {
              PageContext<ListLogicalViewsRequest, ListLogicalViewsResponse, LogicalView>
                  pageContext =
                      PageContext.create(
                          callable, LIST_LOGICAL_VIEWS_PAGE_STR_DESC, request, context);
              return ListLogicalViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          ListMaterializedViewsPagedResponse>
      LIST_MATERIALIZED_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMaterializedViewsRequest,
              ListMaterializedViewsResponse,
              ListMaterializedViewsPagedResponse>() {
            @Override
            public ApiFuture<ListMaterializedViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMaterializedViewsRequest, ListMaterializedViewsResponse> callable,
                ListMaterializedViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListMaterializedViewsResponse> futureResponse) {
              PageContext<
                      ListMaterializedViewsRequest, ListMaterializedViewsResponse, MaterializedView>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MATERIALIZED_VIEWS_PAGE_STR_DESC, request, context);
              return ListMaterializedViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, CreateInstanceMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public UnaryCallSettings<ListInstancesRequest, ListInstancesResponse> listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<Instance, Instance> updateInstanceSettings() {
    return updateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  public UnaryCallSettings<PartialUpdateInstanceRequest, Operation>
      partialUpdateInstanceSettings() {
    return partialUpdateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateInstance. */
  public OperationCallSettings<PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
      partialUpdateInstanceOperationSettings() {
    return partialUpdateInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public UnaryCallSettings<CreateClusterRequest, Operation> createClusterSettings() {
    return createClusterSettings;
  }

  /** Returns the object with the settings used for calls to createCluster. */
  public OperationCallSettings<CreateClusterRequest, Cluster, CreateClusterMetadata>
      createClusterOperationSettings() {
    return createClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to getCluster. */
  public UnaryCallSettings<GetClusterRequest, Cluster> getClusterSettings() {
    return getClusterSettings;
  }

  /** Returns the object with the settings used for calls to listClusters. */
  public UnaryCallSettings<ListClustersRequest, ListClustersResponse> listClustersSettings() {
    return listClustersSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public UnaryCallSettings<Cluster, Operation> updateClusterSettings() {
    return updateClusterSettings;
  }

  /** Returns the object with the settings used for calls to updateCluster. */
  public OperationCallSettings<Cluster, Cluster, UpdateClusterMetadata>
      updateClusterOperationSettings() {
    return updateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateCluster. */
  public UnaryCallSettings<PartialUpdateClusterRequest, Operation> partialUpdateClusterSettings() {
    return partialUpdateClusterSettings;
  }

  /** Returns the object with the settings used for calls to partialUpdateCluster. */
  public OperationCallSettings<PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
      partialUpdateClusterOperationSettings() {
    return partialUpdateClusterOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteCluster. */
  public UnaryCallSettings<DeleteClusterRequest, Empty> deleteClusterSettings() {
    return deleteClusterSettings;
  }

  /** Returns the object with the settings used for calls to createAppProfile. */
  public UnaryCallSettings<CreateAppProfileRequest, AppProfile> createAppProfileSettings() {
    return createAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to getAppProfile. */
  public UnaryCallSettings<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
    return getAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to listAppProfiles. */
  public PagedCallSettings<
          ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
      listAppProfilesSettings() {
    return listAppProfilesSettings;
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  public UnaryCallSettings<UpdateAppProfileRequest, Operation> updateAppProfileSettings() {
    return updateAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateAppProfile. */
  public OperationCallSettings<UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
      updateAppProfileOperationSettings() {
    return updateAppProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteAppProfile. */
  public UnaryCallSettings<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
    return deleteAppProfileSettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns the object with the settings used for calls to listHotTablets. */
  public PagedCallSettings<
          ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>
      listHotTabletsSettings() {
    return listHotTabletsSettings;
  }

  /** Returns the object with the settings used for calls to createLogicalView. */
  public UnaryCallSettings<CreateLogicalViewRequest, Operation> createLogicalViewSettings() {
    return createLogicalViewSettings;
  }

  /** Returns the object with the settings used for calls to createLogicalView. */
  public OperationCallSettings<CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
      createLogicalViewOperationSettings() {
    return createLogicalViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to getLogicalView. */
  public UnaryCallSettings<GetLogicalViewRequest, LogicalView> getLogicalViewSettings() {
    return getLogicalViewSettings;
  }

  /** Returns the object with the settings used for calls to listLogicalViews. */
  public PagedCallSettings<
          ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>
      listLogicalViewsSettings() {
    return listLogicalViewsSettings;
  }

  /** Returns the object with the settings used for calls to updateLogicalView. */
  public UnaryCallSettings<UpdateLogicalViewRequest, Operation> updateLogicalViewSettings() {
    return updateLogicalViewSettings;
  }

  /** Returns the object with the settings used for calls to updateLogicalView. */
  public OperationCallSettings<UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
      updateLogicalViewOperationSettings() {
    return updateLogicalViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLogicalView. */
  public UnaryCallSettings<DeleteLogicalViewRequest, Empty> deleteLogicalViewSettings() {
    return deleteLogicalViewSettings;
  }

  /** Returns the object with the settings used for calls to createMaterializedView. */
  public UnaryCallSettings<CreateMaterializedViewRequest, Operation>
      createMaterializedViewSettings() {
    return createMaterializedViewSettings;
  }

  /** Returns the object with the settings used for calls to createMaterializedView. */
  public OperationCallSettings<
          CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
      createMaterializedViewOperationSettings() {
    return createMaterializedViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to getMaterializedView. */
  public UnaryCallSettings<GetMaterializedViewRequest, MaterializedView>
      getMaterializedViewSettings() {
    return getMaterializedViewSettings;
  }

  /** Returns the object with the settings used for calls to listMaterializedViews. */
  public PagedCallSettings<
          ListMaterializedViewsRequest,
          ListMaterializedViewsResponse,
          ListMaterializedViewsPagedResponse>
      listMaterializedViewsSettings() {
    return listMaterializedViewsSettings;
  }

  /** Returns the object with the settings used for calls to updateMaterializedView. */
  public UnaryCallSettings<UpdateMaterializedViewRequest, Operation>
      updateMaterializedViewSettings() {
    return updateMaterializedViewSettings;
  }

  /** Returns the object with the settings used for calls to updateMaterializedView. */
  public OperationCallSettings<
          UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
      updateMaterializedViewOperationSettings() {
    return updateMaterializedViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMaterializedView. */
  public UnaryCallSettings<DeleteMaterializedViewRequest, Empty> deleteMaterializedViewSettings() {
    return deleteMaterializedViewSettings;
  }

  public BigtableInstanceAdminStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBigtableInstanceAdminStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "bigtableadmin";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "bigtableadmin.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "bigtableadmin.mtls.googleapis.com:443";
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
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BigtableInstanceAdminStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
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

  protected BigtableInstanceAdminStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    partialUpdateInstanceSettings = settingsBuilder.partialUpdateInstanceSettings().build();
    partialUpdateInstanceOperationSettings =
        settingsBuilder.partialUpdateInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    createClusterSettings = settingsBuilder.createClusterSettings().build();
    createClusterOperationSettings = settingsBuilder.createClusterOperationSettings().build();
    getClusterSettings = settingsBuilder.getClusterSettings().build();
    listClustersSettings = settingsBuilder.listClustersSettings().build();
    updateClusterSettings = settingsBuilder.updateClusterSettings().build();
    updateClusterOperationSettings = settingsBuilder.updateClusterOperationSettings().build();
    partialUpdateClusterSettings = settingsBuilder.partialUpdateClusterSettings().build();
    partialUpdateClusterOperationSettings =
        settingsBuilder.partialUpdateClusterOperationSettings().build();
    deleteClusterSettings = settingsBuilder.deleteClusterSettings().build();
    createAppProfileSettings = settingsBuilder.createAppProfileSettings().build();
    getAppProfileSettings = settingsBuilder.getAppProfileSettings().build();
    listAppProfilesSettings = settingsBuilder.listAppProfilesSettings().build();
    updateAppProfileSettings = settingsBuilder.updateAppProfileSettings().build();
    updateAppProfileOperationSettings = settingsBuilder.updateAppProfileOperationSettings().build();
    deleteAppProfileSettings = settingsBuilder.deleteAppProfileSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    listHotTabletsSettings = settingsBuilder.listHotTabletsSettings().build();
    createLogicalViewSettings = settingsBuilder.createLogicalViewSettings().build();
    createLogicalViewOperationSettings =
        settingsBuilder.createLogicalViewOperationSettings().build();
    getLogicalViewSettings = settingsBuilder.getLogicalViewSettings().build();
    listLogicalViewsSettings = settingsBuilder.listLogicalViewsSettings().build();
    updateLogicalViewSettings = settingsBuilder.updateLogicalViewSettings().build();
    updateLogicalViewOperationSettings =
        settingsBuilder.updateLogicalViewOperationSettings().build();
    deleteLogicalViewSettings = settingsBuilder.deleteLogicalViewSettings().build();
    createMaterializedViewSettings = settingsBuilder.createMaterializedViewSettings().build();
    createMaterializedViewOperationSettings =
        settingsBuilder.createMaterializedViewOperationSettings().build();
    getMaterializedViewSettings = settingsBuilder.getMaterializedViewSettings().build();
    listMaterializedViewsSettings = settingsBuilder.listMaterializedViewsSettings().build();
    updateMaterializedViewSettings = settingsBuilder.updateMaterializedViewSettings().build();
    updateMaterializedViewOperationSettings =
        settingsBuilder.updateMaterializedViewOperationSettings().build();
    deleteMaterializedViewSettings = settingsBuilder.deleteMaterializedViewSettings().build();
  }

  /** Builder for BigtableInstanceAdminStubSettings. */
  public static class Builder
      extends StubSettings.Builder<BigtableInstanceAdminStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<
            CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<ListInstancesRequest, ListInstancesResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<Instance, Instance> updateInstanceSettings;
    private final UnaryCallSettings.Builder<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceSettings;
    private final OperationCallSettings.Builder<
            PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        partialUpdateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings;
    private final UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings;
    private final OperationCallSettings.Builder<
            CreateClusterRequest, Cluster, CreateClusterMetadata>
        createClusterOperationSettings;
    private final UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings;
    private final UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings;
    private final UnaryCallSettings.Builder<Cluster, Operation> updateClusterSettings;
    private final OperationCallSettings.Builder<Cluster, Cluster, UpdateClusterMetadata>
        updateClusterOperationSettings;
    private final UnaryCallSettings.Builder<PartialUpdateClusterRequest, Operation>
        partialUpdateClusterSettings;
    private final OperationCallSettings.Builder<
            PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
        partialUpdateClusterOperationSettings;
    private final UnaryCallSettings.Builder<DeleteClusterRequest, Empty> deleteClusterSettings;
    private final UnaryCallSettings.Builder<CreateAppProfileRequest, AppProfile>
        createAppProfileSettings;
    private final UnaryCallSettings.Builder<GetAppProfileRequest, AppProfile> getAppProfileSettings;
    private final PagedCallSettings.Builder<
            ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
        listAppProfilesSettings;
    private final UnaryCallSettings.Builder<UpdateAppProfileRequest, Operation>
        updateAppProfileSettings;
    private final OperationCallSettings.Builder<
            UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
        updateAppProfileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteAppProfileRequest, Empty>
        deleteAppProfileSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private final PagedCallSettings.Builder<
            ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>
        listHotTabletsSettings;
    private final UnaryCallSettings.Builder<CreateLogicalViewRequest, Operation>
        createLogicalViewSettings;
    private final OperationCallSettings.Builder<
            CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
        createLogicalViewOperationSettings;
    private final UnaryCallSettings.Builder<GetLogicalViewRequest, LogicalView>
        getLogicalViewSettings;
    private final PagedCallSettings.Builder<
            ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>
        listLogicalViewsSettings;
    private final UnaryCallSettings.Builder<UpdateLogicalViewRequest, Operation>
        updateLogicalViewSettings;
    private final OperationCallSettings.Builder<
            UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
        updateLogicalViewOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLogicalViewRequest, Empty>
        deleteLogicalViewSettings;
    private final UnaryCallSettings.Builder<CreateMaterializedViewRequest, Operation>
        createMaterializedViewSettings;
    private final OperationCallSettings.Builder<
            CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
        createMaterializedViewOperationSettings;
    private final UnaryCallSettings.Builder<GetMaterializedViewRequest, MaterializedView>
        getMaterializedViewSettings;
    private final PagedCallSettings.Builder<
            ListMaterializedViewsRequest,
            ListMaterializedViewsResponse,
            ListMaterializedViewsPagedResponse>
        listMaterializedViewsSettings;
    private final UnaryCallSettings.Builder<UpdateMaterializedViewRequest, Operation>
        updateMaterializedViewSettings;
    private final OperationCallSettings.Builder<
            UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
        updateMaterializedViewOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMaterializedViewRequest, Empty>
        deleteMaterializedViewSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_5_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_6_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "no_retry_7_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(300000L))
              .setTotalTimeoutDuration(Duration.ofMillis(300000L))
              .build();
      definitions.put("no_retry_5_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_6_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_7_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listInstancesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      partialUpdateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      partialUpdateInstanceOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createClusterOperationSettings = OperationCallSettings.newBuilder();
      getClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listClustersSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateClusterOperationSettings = OperationCallSettings.newBuilder();
      partialUpdateClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      partialUpdateClusterOperationSettings = OperationCallSettings.newBuilder();
      deleteClusterSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listAppProfilesSettings = PagedCallSettings.newBuilder(LIST_APP_PROFILES_PAGE_STR_FACT);
      updateAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateAppProfileOperationSettings = OperationCallSettings.newBuilder();
      deleteAppProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listHotTabletsSettings = PagedCallSettings.newBuilder(LIST_HOT_TABLETS_PAGE_STR_FACT);
      createLogicalViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLogicalViewOperationSettings = OperationCallSettings.newBuilder();
      getLogicalViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLogicalViewsSettings = PagedCallSettings.newBuilder(LIST_LOGICAL_VIEWS_PAGE_STR_FACT);
      updateLogicalViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLogicalViewOperationSettings = OperationCallSettings.newBuilder();
      deleteLogicalViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMaterializedViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMaterializedViewOperationSettings = OperationCallSettings.newBuilder();
      getMaterializedViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMaterializedViewsSettings =
          PagedCallSettings.newBuilder(LIST_MATERIALIZED_VIEWS_PAGE_STR_FACT);
      updateMaterializedViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMaterializedViewOperationSettings = OperationCallSettings.newBuilder();
      deleteMaterializedViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createInstanceSettings,
              getInstanceSettings,
              listInstancesSettings,
              updateInstanceSettings,
              partialUpdateInstanceSettings,
              deleteInstanceSettings,
              createClusterSettings,
              getClusterSettings,
              listClustersSettings,
              updateClusterSettings,
              partialUpdateClusterSettings,
              deleteClusterSettings,
              createAppProfileSettings,
              getAppProfileSettings,
              listAppProfilesSettings,
              updateAppProfileSettings,
              deleteAppProfileSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              listHotTabletsSettings,
              createLogicalViewSettings,
              getLogicalViewSettings,
              listLogicalViewsSettings,
              updateLogicalViewSettings,
              deleteLogicalViewSettings,
              createMaterializedViewSettings,
              getMaterializedViewSettings,
              listMaterializedViewsSettings,
              updateMaterializedViewSettings,
              deleteMaterializedViewSettings);
      initDefaults(this);
    }

    protected Builder(BigtableInstanceAdminStubSettings settings) {
      super(settings);

      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      partialUpdateInstanceSettings = settings.partialUpdateInstanceSettings.toBuilder();
      partialUpdateInstanceOperationSettings =
          settings.partialUpdateInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      createClusterSettings = settings.createClusterSettings.toBuilder();
      createClusterOperationSettings = settings.createClusterOperationSettings.toBuilder();
      getClusterSettings = settings.getClusterSettings.toBuilder();
      listClustersSettings = settings.listClustersSettings.toBuilder();
      updateClusterSettings = settings.updateClusterSettings.toBuilder();
      updateClusterOperationSettings = settings.updateClusterOperationSettings.toBuilder();
      partialUpdateClusterSettings = settings.partialUpdateClusterSettings.toBuilder();
      partialUpdateClusterOperationSettings =
          settings.partialUpdateClusterOperationSettings.toBuilder();
      deleteClusterSettings = settings.deleteClusterSettings.toBuilder();
      createAppProfileSettings = settings.createAppProfileSettings.toBuilder();
      getAppProfileSettings = settings.getAppProfileSettings.toBuilder();
      listAppProfilesSettings = settings.listAppProfilesSettings.toBuilder();
      updateAppProfileSettings = settings.updateAppProfileSettings.toBuilder();
      updateAppProfileOperationSettings = settings.updateAppProfileOperationSettings.toBuilder();
      deleteAppProfileSettings = settings.deleteAppProfileSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      listHotTabletsSettings = settings.listHotTabletsSettings.toBuilder();
      createLogicalViewSettings = settings.createLogicalViewSettings.toBuilder();
      createLogicalViewOperationSettings = settings.createLogicalViewOperationSettings.toBuilder();
      getLogicalViewSettings = settings.getLogicalViewSettings.toBuilder();
      listLogicalViewsSettings = settings.listLogicalViewsSettings.toBuilder();
      updateLogicalViewSettings = settings.updateLogicalViewSettings.toBuilder();
      updateLogicalViewOperationSettings = settings.updateLogicalViewOperationSettings.toBuilder();
      deleteLogicalViewSettings = settings.deleteLogicalViewSettings.toBuilder();
      createMaterializedViewSettings = settings.createMaterializedViewSettings.toBuilder();
      createMaterializedViewOperationSettings =
          settings.createMaterializedViewOperationSettings.toBuilder();
      getMaterializedViewSettings = settings.getMaterializedViewSettings.toBuilder();
      listMaterializedViewsSettings = settings.listMaterializedViewsSettings.toBuilder();
      updateMaterializedViewSettings = settings.updateMaterializedViewSettings.toBuilder();
      updateMaterializedViewOperationSettings =
          settings.updateMaterializedViewOperationSettings.toBuilder();
      deleteMaterializedViewSettings = settings.deleteMaterializedViewSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createInstanceSettings,
              getInstanceSettings,
              listInstancesSettings,
              updateInstanceSettings,
              partialUpdateInstanceSettings,
              deleteInstanceSettings,
              createClusterSettings,
              getClusterSettings,
              listClustersSettings,
              updateClusterSettings,
              partialUpdateClusterSettings,
              deleteClusterSettings,
              createAppProfileSettings,
              getAppProfileSettings,
              listAppProfilesSettings,
              updateAppProfileSettings,
              deleteAppProfileSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              listHotTabletsSettings,
              createLogicalViewSettings,
              getLogicalViewSettings,
              listLogicalViewsSettings,
              updateLogicalViewSettings,
              deleteLogicalViewSettings,
              createMaterializedViewSettings,
              getMaterializedViewSettings,
              listMaterializedViewsSettings,
              updateMaterializedViewSettings,
              deleteMaterializedViewSettings);
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
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .partialUpdateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .createClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .listClustersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .updateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .partialUpdateClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteClusterSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .createAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .listAppProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .updateAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .deleteAppProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .listHotTabletsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"));

      builder
          .createLogicalViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLogicalViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLogicalViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateLogicalViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteLogicalViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createMaterializedViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getMaterializedViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listMaterializedViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateMaterializedViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteMaterializedViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_5_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_5_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .partialUpdateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PartialUpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateInstanceMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .createClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_7_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_7_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(CreateClusterMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(21600000L))
                      .build()));

      builder
          .updateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<Cluster, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateClusterMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .partialUpdateClusterOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<PartialUpdateClusterRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Cluster.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  PartialUpdateClusterMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateAppProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateAppProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_6_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_6_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(AppProfile.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(UpdateAppProfileMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(500L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(5000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .createLogicalViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateLogicalViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LogicalView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateLogicalViewMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateLogicalViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateLogicalViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(LogicalView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateLogicalViewMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMaterializedViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMaterializedViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MaterializedView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateMaterializedViewMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMaterializedViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMaterializedViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MaterializedView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateMaterializedViewMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, CreateInstanceMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to listInstances. */
    public UnaryCallSettings.Builder<ListInstancesRequest, ListInstancesResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<Instance, Instance> updateInstanceSettings() {
      return updateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    public UnaryCallSettings.Builder<PartialUpdateInstanceRequest, Operation>
        partialUpdateInstanceSettings() {
      return partialUpdateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateInstance. */
    public OperationCallSettings.Builder<
            PartialUpdateInstanceRequest, Instance, UpdateInstanceMetadata>
        partialUpdateInstanceOperationSettings() {
      return partialUpdateInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Empty> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public UnaryCallSettings.Builder<CreateClusterRequest, Operation> createClusterSettings() {
      return createClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createCluster. */
    public OperationCallSettings.Builder<CreateClusterRequest, Cluster, CreateClusterMetadata>
        createClusterOperationSettings() {
      return createClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getCluster. */
    public UnaryCallSettings.Builder<GetClusterRequest, Cluster> getClusterSettings() {
      return getClusterSettings;
    }

    /** Returns the builder for the settings used for calls to listClusters. */
    public UnaryCallSettings.Builder<ListClustersRequest, ListClustersResponse>
        listClustersSettings() {
      return listClustersSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public UnaryCallSettings.Builder<Cluster, Operation> updateClusterSettings() {
      return updateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to updateCluster. */
    public OperationCallSettings.Builder<Cluster, Cluster, UpdateClusterMetadata>
        updateClusterOperationSettings() {
      return updateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateCluster. */
    public UnaryCallSettings.Builder<PartialUpdateClusterRequest, Operation>
        partialUpdateClusterSettings() {
      return partialUpdateClusterSettings;
    }

    /** Returns the builder for the settings used for calls to partialUpdateCluster. */
    public OperationCallSettings.Builder<
            PartialUpdateClusterRequest, Cluster, PartialUpdateClusterMetadata>
        partialUpdateClusterOperationSettings() {
      return partialUpdateClusterOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteCluster. */
    public UnaryCallSettings.Builder<DeleteClusterRequest, Empty> deleteClusterSettings() {
      return deleteClusterSettings;
    }

    /** Returns the builder for the settings used for calls to createAppProfile. */
    public UnaryCallSettings.Builder<CreateAppProfileRequest, AppProfile>
        createAppProfileSettings() {
      return createAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getAppProfile. */
    public UnaryCallSettings.Builder<GetAppProfileRequest, AppProfile> getAppProfileSettings() {
      return getAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to listAppProfiles. */
    public PagedCallSettings.Builder<
            ListAppProfilesRequest, ListAppProfilesResponse, ListAppProfilesPagedResponse>
        listAppProfilesSettings() {
      return listAppProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    public UnaryCallSettings.Builder<UpdateAppProfileRequest, Operation>
        updateAppProfileSettings() {
      return updateAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateAppProfile. */
    public OperationCallSettings.Builder<
            UpdateAppProfileRequest, AppProfile, UpdateAppProfileMetadata>
        updateAppProfileOperationSettings() {
      return updateAppProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteAppProfile. */
    public UnaryCallSettings.Builder<DeleteAppProfileRequest, Empty> deleteAppProfileSettings() {
      return deleteAppProfileSettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    /** Returns the builder for the settings used for calls to listHotTablets. */
    public PagedCallSettings.Builder<
            ListHotTabletsRequest, ListHotTabletsResponse, ListHotTabletsPagedResponse>
        listHotTabletsSettings() {
      return listHotTabletsSettings;
    }

    /** Returns the builder for the settings used for calls to createLogicalView. */
    public UnaryCallSettings.Builder<CreateLogicalViewRequest, Operation>
        createLogicalViewSettings() {
      return createLogicalViewSettings;
    }

    /** Returns the builder for the settings used for calls to createLogicalView. */
    public OperationCallSettings.Builder<
            CreateLogicalViewRequest, LogicalView, CreateLogicalViewMetadata>
        createLogicalViewOperationSettings() {
      return createLogicalViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getLogicalView. */
    public UnaryCallSettings.Builder<GetLogicalViewRequest, LogicalView> getLogicalViewSettings() {
      return getLogicalViewSettings;
    }

    /** Returns the builder for the settings used for calls to listLogicalViews. */
    public PagedCallSettings.Builder<
            ListLogicalViewsRequest, ListLogicalViewsResponse, ListLogicalViewsPagedResponse>
        listLogicalViewsSettings() {
      return listLogicalViewsSettings;
    }

    /** Returns the builder for the settings used for calls to updateLogicalView. */
    public UnaryCallSettings.Builder<UpdateLogicalViewRequest, Operation>
        updateLogicalViewSettings() {
      return updateLogicalViewSettings;
    }

    /** Returns the builder for the settings used for calls to updateLogicalView. */
    public OperationCallSettings.Builder<
            UpdateLogicalViewRequest, LogicalView, UpdateLogicalViewMetadata>
        updateLogicalViewOperationSettings() {
      return updateLogicalViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLogicalView. */
    public UnaryCallSettings.Builder<DeleteLogicalViewRequest, Empty> deleteLogicalViewSettings() {
      return deleteLogicalViewSettings;
    }

    /** Returns the builder for the settings used for calls to createMaterializedView. */
    public UnaryCallSettings.Builder<CreateMaterializedViewRequest, Operation>
        createMaterializedViewSettings() {
      return createMaterializedViewSettings;
    }

    /** Returns the builder for the settings used for calls to createMaterializedView. */
    public OperationCallSettings.Builder<
            CreateMaterializedViewRequest, MaterializedView, CreateMaterializedViewMetadata>
        createMaterializedViewOperationSettings() {
      return createMaterializedViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getMaterializedView. */
    public UnaryCallSettings.Builder<GetMaterializedViewRequest, MaterializedView>
        getMaterializedViewSettings() {
      return getMaterializedViewSettings;
    }

    /** Returns the builder for the settings used for calls to listMaterializedViews. */
    public PagedCallSettings.Builder<
            ListMaterializedViewsRequest,
            ListMaterializedViewsResponse,
            ListMaterializedViewsPagedResponse>
        listMaterializedViewsSettings() {
      return listMaterializedViewsSettings;
    }

    /** Returns the builder for the settings used for calls to updateMaterializedView. */
    public UnaryCallSettings.Builder<UpdateMaterializedViewRequest, Operation>
        updateMaterializedViewSettings() {
      return updateMaterializedViewSettings;
    }

    /** Returns the builder for the settings used for calls to updateMaterializedView. */
    public OperationCallSettings.Builder<
            UpdateMaterializedViewRequest, MaterializedView, UpdateMaterializedViewMetadata>
        updateMaterializedViewOperationSettings() {
      return updateMaterializedViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMaterializedView. */
    public UnaryCallSettings.Builder<DeleteMaterializedViewRequest, Empty>
        deleteMaterializedViewSettings() {
      return deleteMaterializedViewSettings;
    }

    @Override
    public BigtableInstanceAdminStubSettings build() throws IOException {
      return new BigtableInstanceAdminStubSettings(this);
    }
  }
}
