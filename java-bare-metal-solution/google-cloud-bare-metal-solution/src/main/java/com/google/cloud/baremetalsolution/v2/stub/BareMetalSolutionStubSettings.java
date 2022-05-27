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

package com.google.cloud.baremetalsolution.v2.stub;

import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListInstancesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListLunsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNetworksPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListSnapshotSchedulePoliciesPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumeSnapshotsPagedResponse;
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListVolumesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.cloud.baremetalsolution.v2.CreateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.CreateVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.DeleteSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.DeleteVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesRequest;
import com.google.cloud.baremetalsolution.v2.ListSnapshotSchedulePoliciesResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumeSnapshotsResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.RestoreVolumeSnapshotRequest;
import com.google.cloud.baremetalsolution.v2.SnapshotSchedulePolicy;
import com.google.cloud.baremetalsolution.v2.UpdateSnapshotSchedulePolicyRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.cloud.baremetalsolution.v2.VolumeSnapshot;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BareMetalSolutionStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (baremetalsolution.googleapis.com) and default port (443) are
 *       used.
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
 * // This snippet has been automatically generated for illustrative purposes only.
 * // It may require modifications to work in your environment.
 * BareMetalSolutionStubSettings.Builder bareMetalSolutionSettingsBuilder =
 *     BareMetalSolutionStubSettings.newBuilder();
 * bareMetalSolutionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         bareMetalSolutionSettingsBuilder
 *             .getInstanceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * BareMetalSolutionStubSettings bareMetalSolutionSettings =
 *     bareMetalSolutionSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BareMetalSolutionStubSettings extends StubSettings<BareMetalSolutionStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings;
  private final OperationCallSettings<
          ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings;
  private final PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings;
  private final UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings;
  private final UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings;
  private final OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings;
  private final PagedCallSettings<
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings;
  private final PagedCallSettings<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesSettings;
  private final UnaryCallSettings<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicySettings;
  private final UnaryCallSettings<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicySettings;
  private final UnaryCallSettings<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicySettings;
  private final UnaryCallSettings<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicySettings;
  private final UnaryCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotSettings;
  private final UnaryCallSettings<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotSettings;
  private final OperationCallSettings<
          RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationSettings;
  private final UnaryCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotSettings;
  private final UnaryCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot>
      getVolumeSnapshotSettings;
  private final PagedCallSettings<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsSettings;
  private final UnaryCallSettings<GetLunRequest, Lun> getLunSettings;
  private final PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings;

  private static final PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>
      LIST_INSTANCES_PAGE_STR_DESC =
          new PagedListDescriptor<ListInstancesRequest, ListInstancesResponse, Instance>() {
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
              return ListInstancesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInstancesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInstancesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Instance> extractResources(ListInstancesResponse payload) {
              return payload.getInstancesList() == null
                  ? ImmutableList.<Instance>of()
                  : payload.getInstancesList();
            }
          };

  private static final PagedListDescriptor<ListVolumesRequest, ListVolumesResponse, Volume>
      LIST_VOLUMES_PAGE_STR_DESC =
          new PagedListDescriptor<ListVolumesRequest, ListVolumesResponse, Volume>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumesRequest injectToken(ListVolumesRequest payload, String token) {
              return ListVolumesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumesRequest injectPageSize(ListVolumesRequest payload, int pageSize) {
              return ListVolumesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Volume> extractResources(ListVolumesResponse payload) {
              return payload.getVolumesList() == null
                  ? ImmutableList.<Volume>of()
                  : payload.getVolumesList();
            }
          };

  private static final PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>
      LIST_NETWORKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListNetworksRequest, ListNetworksResponse, Network>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNetworksRequest injectToken(ListNetworksRequest payload, String token) {
              return ListNetworksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNetworksRequest injectPageSize(ListNetworksRequest payload, int pageSize) {
              return ListNetworksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNetworksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNetworksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Network> extractResources(ListNetworksResponse payload) {
              return payload.getNetworksList() == null
                  ? ImmutableList.<Network>of()
                  : payload.getNetworksList();
            }
          };

  private static final PagedListDescriptor<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          SnapshotSchedulePolicy>
      LIST_SNAPSHOT_SCHEDULE_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSnapshotSchedulePoliciesRequest,
              ListSnapshotSchedulePoliciesResponse,
              SnapshotSchedulePolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSnapshotSchedulePoliciesRequest injectToken(
                ListSnapshotSchedulePoliciesRequest payload, String token) {
              return ListSnapshotSchedulePoliciesRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSnapshotSchedulePoliciesRequest injectPageSize(
                ListSnapshotSchedulePoliciesRequest payload, int pageSize) {
              return ListSnapshotSchedulePoliciesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSnapshotSchedulePoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSnapshotSchedulePoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SnapshotSchedulePolicy> extractResources(
                ListSnapshotSchedulePoliciesResponse payload) {
              return payload.getSnapshotSchedulePoliciesList() == null
                  ? ImmutableList.<SnapshotSchedulePolicy>of()
                  : payload.getSnapshotSchedulePoliciesList();
            }
          };

  private static final PagedListDescriptor<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
      LIST_VOLUME_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListVolumeSnapshotsRequest injectToken(
                ListVolumeSnapshotsRequest payload, String token) {
              return ListVolumeSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListVolumeSnapshotsRequest injectPageSize(
                ListVolumeSnapshotsRequest payload, int pageSize) {
              return ListVolumeSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListVolumeSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListVolumeSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<VolumeSnapshot> extractResources(ListVolumeSnapshotsResponse payload) {
              return payload.getVolumeSnapshotsList() == null
                  ? ImmutableList.<VolumeSnapshot>of()
                  : payload.getVolumeSnapshotsList();
            }
          };

  private static final PagedListDescriptor<ListLunsRequest, ListLunsResponse, Lun>
      LIST_LUNS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLunsRequest, ListLunsResponse, Lun>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLunsRequest injectToken(ListLunsRequest payload, String token) {
              return ListLunsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLunsRequest injectPageSize(ListLunsRequest payload, int pageSize) {
              return ListLunsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLunsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLunsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Lun> extractResources(ListLunsResponse payload) {
              return payload.getLunsList() == null
                  ? ImmutableList.<Lun>of()
                  : payload.getLunsList();
            }
          };

  private static final PagedListResponseFactory<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      LIST_INSTANCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>() {
            @Override
            public ApiFuture<ListInstancesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInstancesRequest, ListInstancesResponse> callable,
                ListInstancesRequest request,
                ApiCallContext context,
                ApiFuture<ListInstancesResponse> futureResponse) {
              PageContext<ListInstancesRequest, ListInstancesResponse, Instance> pageContext =
                  PageContext.create(callable, LIST_INSTANCES_PAGE_STR_DESC, request, context);
              return ListInstancesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      LIST_VOLUMES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>() {
            @Override
            public ApiFuture<ListVolumesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumesRequest, ListVolumesResponse> callable,
                ListVolumesRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumesResponse> futureResponse) {
              PageContext<ListVolumesRequest, ListVolumesResponse, Volume> pageContext =
                  PageContext.create(callable, LIST_VOLUMES_PAGE_STR_DESC, request, context);
              return ListVolumesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      LIST_NETWORKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>() {
            @Override
            public ApiFuture<ListNetworksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNetworksRequest, ListNetworksResponse> callable,
                ListNetworksRequest request,
                ApiCallContext context,
                ApiFuture<ListNetworksResponse> futureResponse) {
              PageContext<ListNetworksRequest, ListNetworksResponse, Network> pageContext =
                  PageContext.create(callable, LIST_NETWORKS_PAGE_STR_DESC, request, context);
              return ListNetworksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          ListSnapshotSchedulePoliciesPagedResponse>
      LIST_SNAPSHOT_SCHEDULE_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSnapshotSchedulePoliciesRequest,
              ListSnapshotSchedulePoliciesResponse,
              ListSnapshotSchedulePoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListSnapshotSchedulePoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListSnapshotSchedulePoliciesRequest, ListSnapshotSchedulePoliciesResponse>
                    callable,
                ListSnapshotSchedulePoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListSnapshotSchedulePoliciesResponse> futureResponse) {
              PageContext<
                      ListSnapshotSchedulePoliciesRequest,
                      ListSnapshotSchedulePoliciesResponse,
                      SnapshotSchedulePolicy>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SNAPSHOT_SCHEDULE_POLICIES_PAGE_STR_DESC,
                          request,
                          context);
              return ListSnapshotSchedulePoliciesPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      LIST_VOLUME_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListVolumeSnapshotsRequest,
              ListVolumeSnapshotsResponse,
              ListVolumeSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListVolumeSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse> callable,
                ListVolumeSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListVolumeSnapshotsResponse> futureResponse) {
              PageContext<ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, VolumeSnapshot>
                  pageContext =
                      PageContext.create(
                          callable, LIST_VOLUME_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListVolumeSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      LIST_LUNS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>() {
            @Override
            public ApiFuture<ListLunsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLunsRequest, ListLunsResponse> callable,
                ListLunsRequest request,
                ApiCallContext context,
                ApiFuture<ListLunsResponse> futureResponse) {
              PageContext<ListLunsRequest, ListLunsResponse, Lun> pageContext =
                  PageContext.create(callable, LIST_LUNS_PAGE_STR_DESC, request, context);
              return ListLunsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings() {
    return resetInstanceSettings;
  }

  /** Returns the object with the settings used for calls to resetInstance. */
  public OperationCallSettings<ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings() {
    return resetInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to listVolumes. */
  public PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings() {
    return listVolumesSettings;
  }

  /** Returns the object with the settings used for calls to getVolume. */
  public UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings() {
    return getVolumeSettings;
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings() {
    return updateVolumeSettings;
  }

  /** Returns the object with the settings used for calls to updateVolume. */
  public OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings() {
    return updateVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return listNetworksSettings;
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return getNetworkSettings;
  }

  /** Returns the object with the settings used for calls to listSnapshotSchedulePolicies. */
  public PagedCallSettings<
          ListSnapshotSchedulePoliciesRequest,
          ListSnapshotSchedulePoliciesResponse,
          ListSnapshotSchedulePoliciesPagedResponse>
      listSnapshotSchedulePoliciesSettings() {
    return listSnapshotSchedulePoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getSnapshotSchedulePolicy. */
  public UnaryCallSettings<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      getSnapshotSchedulePolicySettings() {
    return getSnapshotSchedulePolicySettings;
  }

  /** Returns the object with the settings used for calls to createSnapshotSchedulePolicy. */
  public UnaryCallSettings<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      createSnapshotSchedulePolicySettings() {
    return createSnapshotSchedulePolicySettings;
  }

  /** Returns the object with the settings used for calls to updateSnapshotSchedulePolicy. */
  public UnaryCallSettings<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
      updateSnapshotSchedulePolicySettings() {
    return updateSnapshotSchedulePolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteSnapshotSchedulePolicy. */
  public UnaryCallSettings<DeleteSnapshotSchedulePolicyRequest, Empty>
      deleteSnapshotSchedulePolicySettings() {
    return deleteSnapshotSchedulePolicySettings;
  }

  /** Returns the object with the settings used for calls to createVolumeSnapshot. */
  public UnaryCallSettings<CreateVolumeSnapshotRequest, VolumeSnapshot>
      createVolumeSnapshotSettings() {
    return createVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public UnaryCallSettings<RestoreVolumeSnapshotRequest, Operation>
      restoreVolumeSnapshotSettings() {
    return restoreVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to restoreVolumeSnapshot. */
  public OperationCallSettings<RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
      restoreVolumeSnapshotOperationSettings() {
    return restoreVolumeSnapshotOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteVolumeSnapshot. */
  public UnaryCallSettings<DeleteVolumeSnapshotRequest, Empty> deleteVolumeSnapshotSettings() {
    return deleteVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to getVolumeSnapshot. */
  public UnaryCallSettings<GetVolumeSnapshotRequest, VolumeSnapshot> getVolumeSnapshotSettings() {
    return getVolumeSnapshotSettings;
  }

  /** Returns the object with the settings used for calls to listVolumeSnapshots. */
  public PagedCallSettings<
          ListVolumeSnapshotsRequest, ListVolumeSnapshotsResponse, ListVolumeSnapshotsPagedResponse>
      listVolumeSnapshotsSettings() {
    return listVolumeSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to getLun. */
  public UnaryCallSettings<GetLunRequest, Lun> getLunSettings() {
    return getLunSettings;
  }

  /** Returns the object with the settings used for calls to listLuns. */
  public PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings() {
    return listLunsSettings;
  }

  public BareMetalSolutionStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBareMetalSolutionStub.create(this);
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
    return "baremetalsolution.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "baremetalsolution.mtls.googleapis.com:443";
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BareMetalSolutionStubSettings.class))
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

  protected BareMetalSolutionStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    resetInstanceSettings = settingsBuilder.resetInstanceSettings().build();
    resetInstanceOperationSettings = settingsBuilder.resetInstanceOperationSettings().build();
    listVolumesSettings = settingsBuilder.listVolumesSettings().build();
    getVolumeSettings = settingsBuilder.getVolumeSettings().build();
    updateVolumeSettings = settingsBuilder.updateVolumeSettings().build();
    updateVolumeOperationSettings = settingsBuilder.updateVolumeOperationSettings().build();
    listNetworksSettings = settingsBuilder.listNetworksSettings().build();
    getNetworkSettings = settingsBuilder.getNetworkSettings().build();
    listSnapshotSchedulePoliciesSettings =
        settingsBuilder.listSnapshotSchedulePoliciesSettings().build();
    getSnapshotSchedulePolicySettings = settingsBuilder.getSnapshotSchedulePolicySettings().build();
    createSnapshotSchedulePolicySettings =
        settingsBuilder.createSnapshotSchedulePolicySettings().build();
    updateSnapshotSchedulePolicySettings =
        settingsBuilder.updateSnapshotSchedulePolicySettings().build();
    deleteSnapshotSchedulePolicySettings =
        settingsBuilder.deleteSnapshotSchedulePolicySettings().build();
    createVolumeSnapshotSettings = settingsBuilder.createVolumeSnapshotSettings().build();
    restoreVolumeSnapshotSettings = settingsBuilder.restoreVolumeSnapshotSettings().build();
    restoreVolumeSnapshotOperationSettings =
        settingsBuilder.restoreVolumeSnapshotOperationSettings().build();
    deleteVolumeSnapshotSettings = settingsBuilder.deleteVolumeSnapshotSettings().build();
    getVolumeSnapshotSettings = settingsBuilder.getVolumeSnapshotSettings().build();
    listVolumeSnapshotsSettings = settingsBuilder.listVolumeSnapshotsSettings().build();
    getLunSettings = settingsBuilder.getLunSettings().build();
    listLunsSettings = settingsBuilder.listLunsSettings().build();
  }

  /** Builder for BareMetalSolutionStubSettings. */
  public static class Builder extends StubSettings.Builder<BareMetalSolutionStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings;
    private final OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings;
    private final PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings;
    private final UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings;
    private final UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings;
    private final OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings;
    private final PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings;
    private final PagedCallSettings.Builder<
            ListSnapshotSchedulePoliciesRequest,
            ListSnapshotSchedulePoliciesResponse,
            ListSnapshotSchedulePoliciesPagedResponse>
        listSnapshotSchedulePoliciesSettings;
    private final UnaryCallSettings.Builder<
            GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        getSnapshotSchedulePolicySettings;
    private final UnaryCallSettings.Builder<
            CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        createSnapshotSchedulePolicySettings;
    private final UnaryCallSettings.Builder<
            UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        updateSnapshotSchedulePolicySettings;
    private final UnaryCallSettings.Builder<DeleteSnapshotSchedulePolicyRequest, Empty>
        deleteSnapshotSchedulePolicySettings;
    private final UnaryCallSettings.Builder<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotSettings;
    private final UnaryCallSettings.Builder<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotSettings;
    private final OperationCallSettings.Builder<
            RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
        restoreVolumeSnapshotOperationSettings;
    private final UnaryCallSettings.Builder<DeleteVolumeSnapshotRequest, Empty>
        deleteVolumeSnapshotSettings;
    private final UnaryCallSettings.Builder<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotSettings;
    private final PagedCallSettings.Builder<
            ListVolumeSnapshotsRequest,
            ListVolumeSnapshotsResponse,
            ListVolumeSnapshotsPagedResponse>
        listVolumeSnapshotsSettings;
    private final UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings;
    private final PagedCallSettings.Builder<
            ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceOperationSettings = OperationCallSettings.newBuilder();
      listVolumesSettings = PagedCallSettings.newBuilder(LIST_VOLUMES_PAGE_STR_FACT);
      getVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeOperationSettings = OperationCallSettings.newBuilder();
      listNetworksSettings = PagedCallSettings.newBuilder(LIST_NETWORKS_PAGE_STR_FACT);
      getNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSnapshotSchedulePoliciesSettings =
          PagedCallSettings.newBuilder(LIST_SNAPSHOT_SCHEDULE_POLICIES_PAGE_STR_FACT);
      getSnapshotSchedulePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createSnapshotSchedulePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSnapshotSchedulePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSnapshotSchedulePolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restoreVolumeSnapshotOperationSettings = OperationCallSettings.newBuilder();
      deleteVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getVolumeSnapshotSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listVolumeSnapshotsSettings =
          PagedCallSettings.newBuilder(LIST_VOLUME_SNAPSHOTS_PAGE_STR_FACT);
      getLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLunsSettings = PagedCallSettings.newBuilder(LIST_LUNS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              resetInstanceSettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              listNetworksSettings,
              getNetworkSettings,
              listSnapshotSchedulePoliciesSettings,
              getSnapshotSchedulePolicySettings,
              createSnapshotSchedulePolicySettings,
              updateSnapshotSchedulePolicySettings,
              deleteSnapshotSchedulePolicySettings,
              createVolumeSnapshotSettings,
              restoreVolumeSnapshotSettings,
              deleteVolumeSnapshotSettings,
              getVolumeSnapshotSettings,
              listVolumeSnapshotsSettings,
              getLunSettings,
              listLunsSettings);
      initDefaults(this);
    }

    protected Builder(BareMetalSolutionStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      resetInstanceSettings = settings.resetInstanceSettings.toBuilder();
      resetInstanceOperationSettings = settings.resetInstanceOperationSettings.toBuilder();
      listVolumesSettings = settings.listVolumesSettings.toBuilder();
      getVolumeSettings = settings.getVolumeSettings.toBuilder();
      updateVolumeSettings = settings.updateVolumeSettings.toBuilder();
      updateVolumeOperationSettings = settings.updateVolumeOperationSettings.toBuilder();
      listNetworksSettings = settings.listNetworksSettings.toBuilder();
      getNetworkSettings = settings.getNetworkSettings.toBuilder();
      listSnapshotSchedulePoliciesSettings =
          settings.listSnapshotSchedulePoliciesSettings.toBuilder();
      getSnapshotSchedulePolicySettings = settings.getSnapshotSchedulePolicySettings.toBuilder();
      createSnapshotSchedulePolicySettings =
          settings.createSnapshotSchedulePolicySettings.toBuilder();
      updateSnapshotSchedulePolicySettings =
          settings.updateSnapshotSchedulePolicySettings.toBuilder();
      deleteSnapshotSchedulePolicySettings =
          settings.deleteSnapshotSchedulePolicySettings.toBuilder();
      createVolumeSnapshotSettings = settings.createVolumeSnapshotSettings.toBuilder();
      restoreVolumeSnapshotSettings = settings.restoreVolumeSnapshotSettings.toBuilder();
      restoreVolumeSnapshotOperationSettings =
          settings.restoreVolumeSnapshotOperationSettings.toBuilder();
      deleteVolumeSnapshotSettings = settings.deleteVolumeSnapshotSettings.toBuilder();
      getVolumeSnapshotSettings = settings.getVolumeSnapshotSettings.toBuilder();
      listVolumeSnapshotsSettings = settings.listVolumeSnapshotsSettings.toBuilder();
      getLunSettings = settings.getLunSettings.toBuilder();
      listLunsSettings = settings.listLunsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              resetInstanceSettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              listNetworksSettings,
              getNetworkSettings,
              listSnapshotSchedulePoliciesSettings,
              getSnapshotSchedulePolicySettings,
              createSnapshotSchedulePolicySettings,
              updateSnapshotSchedulePolicySettings,
              deleteSnapshotSchedulePolicySettings,
              createVolumeSnapshotSettings,
              restoreVolumeSnapshotSettings,
              deleteVolumeSnapshotSettings,
              getVolumeSnapshotSettings,
              listVolumeSnapshotsSettings,
              getLunSettings,
              listLunsSettings);
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
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listVolumesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listSnapshotSchedulePoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getSnapshotSchedulePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createSnapshotSchedulePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateSnapshotSchedulePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteSnapshotSchedulePolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .restoreVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getVolumeSnapshotSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listVolumeSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLunSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLunsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResetInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ResetInstanceResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Volume.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .restoreVolumeSnapshotOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestoreVolumeSnapshotRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(VolumeSnapshot.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
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

    /** Returns the builder for the settings used for calls to listInstances. */
    public PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings() {
      return listInstancesSettings;
    }

    /** Returns the builder for the settings used for calls to getInstance. */
    public UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings() {
      return getInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    public UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings() {
      return resetInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to resetInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings() {
      return resetInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumes. */
    public PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings() {
      return listVolumesSettings;
    }

    /** Returns the builder for the settings used for calls to getVolume. */
    public UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings() {
      return getVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    public UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings() {
      return updateVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to updateVolume. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings() {
      return updateVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return listNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to listSnapshotSchedulePolicies. */
    public PagedCallSettings.Builder<
            ListSnapshotSchedulePoliciesRequest,
            ListSnapshotSchedulePoliciesResponse,
            ListSnapshotSchedulePoliciesPagedResponse>
        listSnapshotSchedulePoliciesSettings() {
      return listSnapshotSchedulePoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<GetSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        getSnapshotSchedulePolicySettings() {
      return getSnapshotSchedulePolicySettings;
    }

    /** Returns the builder for the settings used for calls to createSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<CreateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        createSnapshotSchedulePolicySettings() {
      return createSnapshotSchedulePolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<UpdateSnapshotSchedulePolicyRequest, SnapshotSchedulePolicy>
        updateSnapshotSchedulePolicySettings() {
      return updateSnapshotSchedulePolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteSnapshotSchedulePolicy. */
    public UnaryCallSettings.Builder<DeleteSnapshotSchedulePolicyRequest, Empty>
        deleteSnapshotSchedulePolicySettings() {
      return deleteSnapshotSchedulePolicySettings;
    }

    /** Returns the builder for the settings used for calls to createVolumeSnapshot. */
    public UnaryCallSettings.Builder<CreateVolumeSnapshotRequest, VolumeSnapshot>
        createVolumeSnapshotSettings() {
      return createVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    public UnaryCallSettings.Builder<RestoreVolumeSnapshotRequest, Operation>
        restoreVolumeSnapshotSettings() {
      return restoreVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to restoreVolumeSnapshot. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            RestoreVolumeSnapshotRequest, VolumeSnapshot, OperationMetadata>
        restoreVolumeSnapshotOperationSettings() {
      return restoreVolumeSnapshotOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteVolumeSnapshot. */
    public UnaryCallSettings.Builder<DeleteVolumeSnapshotRequest, Empty>
        deleteVolumeSnapshotSettings() {
      return deleteVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to getVolumeSnapshot. */
    public UnaryCallSettings.Builder<GetVolumeSnapshotRequest, VolumeSnapshot>
        getVolumeSnapshotSettings() {
      return getVolumeSnapshotSettings;
    }

    /** Returns the builder for the settings used for calls to listVolumeSnapshots. */
    public PagedCallSettings.Builder<
            ListVolumeSnapshotsRequest,
            ListVolumeSnapshotsResponse,
            ListVolumeSnapshotsPagedResponse>
        listVolumeSnapshotsSettings() {
      return listVolumeSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to getLun. */
    public UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings() {
      return getLunSettings;
    }

    /** Returns the builder for the settings used for calls to listLuns. */
    public PagedCallSettings.Builder<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings() {
      return listLunsSettings;
    }

    @Override
    public BareMetalSolutionStubSettings build() throws IOException {
      return new BareMetalSolutionStubSettings(this);
    }
  }
}
