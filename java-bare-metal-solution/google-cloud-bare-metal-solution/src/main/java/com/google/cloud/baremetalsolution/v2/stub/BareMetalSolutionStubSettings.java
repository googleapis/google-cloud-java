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
import static com.google.cloud.baremetalsolution.v2.BareMetalSolutionClient.ListNfsSharesPagedResponse;
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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.cloud.baremetalsolution.v2.DetachLunRequest;
import com.google.cloud.baremetalsolution.v2.GetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.GetLunRequest;
import com.google.cloud.baremetalsolution.v2.GetNetworkRequest;
import com.google.cloud.baremetalsolution.v2.GetNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.GetVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Instance;
import com.google.cloud.baremetalsolution.v2.ListInstancesRequest;
import com.google.cloud.baremetalsolution.v2.ListInstancesResponse;
import com.google.cloud.baremetalsolution.v2.ListLunsRequest;
import com.google.cloud.baremetalsolution.v2.ListLunsResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworkUsageResponse;
import com.google.cloud.baremetalsolution.v2.ListNetworksRequest;
import com.google.cloud.baremetalsolution.v2.ListNetworksResponse;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesRequest;
import com.google.cloud.baremetalsolution.v2.ListNfsSharesResponse;
import com.google.cloud.baremetalsolution.v2.ListVolumesRequest;
import com.google.cloud.baremetalsolution.v2.ListVolumesResponse;
import com.google.cloud.baremetalsolution.v2.Lun;
import com.google.cloud.baremetalsolution.v2.Network;
import com.google.cloud.baremetalsolution.v2.NfsShare;
import com.google.cloud.baremetalsolution.v2.OperationMetadata;
import com.google.cloud.baremetalsolution.v2.ResetInstanceRequest;
import com.google.cloud.baremetalsolution.v2.ResetInstanceResponse;
import com.google.cloud.baremetalsolution.v2.ResizeVolumeRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StartInstanceResponse;
import com.google.cloud.baremetalsolution.v2.StopInstanceRequest;
import com.google.cloud.baremetalsolution.v2.StopInstanceResponse;
import com.google.cloud.baremetalsolution.v2.UpdateInstanceRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNetworkRequest;
import com.google.cloud.baremetalsolution.v2.UpdateNfsShareRequest;
import com.google.cloud.baremetalsolution.v2.UpdateVolumeRequest;
import com.google.cloud.baremetalsolution.v2.Volume;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BareMetalSolutionStubSettings.Builder bareMetalSolutionSettingsBuilder =
 *     BareMetalSolutionStubSettings.newBuilder();
 * bareMetalSolutionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         bareMetalSolutionSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
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
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings;
  private final UnaryCallSettings<ResetInstanceRequest, Operation> resetInstanceSettings;
  private final OperationCallSettings<
          ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
      resetInstanceOperationSettings;
  private final UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings;
  private final OperationCallSettings<
          StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationSettings;
  private final UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings;
  private final OperationCallSettings<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationSettings;
  private final UnaryCallSettings<DetachLunRequest, Operation> detachLunSettings;
  private final OperationCallSettings<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationSettings;
  private final PagedCallSettings<ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
      listVolumesSettings;
  private final UnaryCallSettings<GetVolumeRequest, Volume> getVolumeSettings;
  private final UnaryCallSettings<UpdateVolumeRequest, Operation> updateVolumeSettings;
  private final OperationCallSettings<UpdateVolumeRequest, Volume, OperationMetadata>
      updateVolumeOperationSettings;
  private final UnaryCallSettings<ResizeVolumeRequest, Operation> resizeVolumeSettings;
  private final OperationCallSettings<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationSettings;
  private final PagedCallSettings<
          ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings;
  private final UnaryCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageSettings;
  private final UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings;
  private final UnaryCallSettings<UpdateNetworkRequest, Operation> updateNetworkSettings;
  private final OperationCallSettings<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationSettings;
  private final UnaryCallSettings<GetLunRequest, Lun> getLunSettings;
  private final PagedCallSettings<ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
      listLunsSettings;
  private final UnaryCallSettings<GetNfsShareRequest, NfsShare> getNfsShareSettings;
  private final PagedCallSettings<
          ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      listNfsSharesSettings;
  private final UnaryCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareSettings;
  private final OperationCallSettings<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationSettings;

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

  private static final PagedListDescriptor<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare>
      LIST_NFS_SHARES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNfsSharesRequest injectToken(ListNfsSharesRequest payload, String token) {
              return ListNfsSharesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNfsSharesRequest injectPageSize(ListNfsSharesRequest payload, int pageSize) {
              return ListNfsSharesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNfsSharesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNfsSharesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<NfsShare> extractResources(ListNfsSharesResponse payload) {
              return payload.getNfsSharesList() == null
                  ? ImmutableList.<NfsShare>of()
                  : payload.getNfsSharesList();
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

  private static final PagedListResponseFactory<
          ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      LIST_NFS_SHARES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>() {
            @Override
            public ApiFuture<ListNfsSharesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNfsSharesRequest, ListNfsSharesResponse> callable,
                ListNfsSharesRequest request,
                ApiCallContext context,
                ApiFuture<ListNfsSharesResponse> futureResponse) {
              PageContext<ListNfsSharesRequest, ListNfsSharesResponse, NfsShare> pageContext =
                  PageContext.create(callable, LIST_NFS_SHARES_PAGE_STR_DESC, request, context);
              return ListNfsSharesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to updateInstance. */
  public UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings() {
    return updateInstanceSettings;
  }

  /** Returns the object with the settings used for calls to updateInstance. */
  public OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings() {
    return updateInstanceOperationSettings;
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

  /** Returns the object with the settings used for calls to startInstance. */
  public UnaryCallSettings<StartInstanceRequest, Operation> startInstanceSettings() {
    return startInstanceSettings;
  }

  /** Returns the object with the settings used for calls to startInstance. */
  public OperationCallSettings<StartInstanceRequest, StartInstanceResponse, OperationMetadata>
      startInstanceOperationSettings() {
    return startInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public UnaryCallSettings<StopInstanceRequest, Operation> stopInstanceSettings() {
    return stopInstanceSettings;
  }

  /** Returns the object with the settings used for calls to stopInstance. */
  public OperationCallSettings<StopInstanceRequest, StopInstanceResponse, OperationMetadata>
      stopInstanceOperationSettings() {
    return stopInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public UnaryCallSettings<DetachLunRequest, Operation> detachLunSettings() {
    return detachLunSettings;
  }

  /** Returns the object with the settings used for calls to detachLun. */
  public OperationCallSettings<DetachLunRequest, Instance, OperationMetadata>
      detachLunOperationSettings() {
    return detachLunOperationSettings;
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

  /** Returns the object with the settings used for calls to resizeVolume. */
  public UnaryCallSettings<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
    return resizeVolumeSettings;
  }

  /** Returns the object with the settings used for calls to resizeVolume. */
  public OperationCallSettings<ResizeVolumeRequest, Volume, OperationMetadata>
      resizeVolumeOperationSettings() {
    return resizeVolumeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listNetworks. */
  public PagedCallSettings<ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
      listNetworksSettings() {
    return listNetworksSettings;
  }

  /** Returns the object with the settings used for calls to listNetworkUsage. */
  public UnaryCallSettings<ListNetworkUsageRequest, ListNetworkUsageResponse>
      listNetworkUsageSettings() {
    return listNetworkUsageSettings;
  }

  /** Returns the object with the settings used for calls to getNetwork. */
  public UnaryCallSettings<GetNetworkRequest, Network> getNetworkSettings() {
    return getNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public UnaryCallSettings<UpdateNetworkRequest, Operation> updateNetworkSettings() {
    return updateNetworkSettings;
  }

  /** Returns the object with the settings used for calls to updateNetwork. */
  public OperationCallSettings<UpdateNetworkRequest, Network, OperationMetadata>
      updateNetworkOperationSettings() {
    return updateNetworkOperationSettings;
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

  /** Returns the object with the settings used for calls to getNfsShare. */
  public UnaryCallSettings<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
    return getNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to listNfsShares. */
  public PagedCallSettings<ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
      listNfsSharesSettings() {
    return listNfsSharesSettings;
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public UnaryCallSettings<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
    return updateNfsShareSettings;
  }

  /** Returns the object with the settings used for calls to updateNfsShare. */
  public OperationCallSettings<UpdateNfsShareRequest, NfsShare, OperationMetadata>
      updateNfsShareOperationSettings() {
    return updateNfsShareOperationSettings;
  }

  public BareMetalSolutionStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBareMetalSolutionStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBareMetalSolutionStub.create(this);
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

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BareMetalSolutionStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BareMetalSolutionStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BareMetalSolutionStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
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

  protected BareMetalSolutionStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    updateInstanceOperationSettings = settingsBuilder.updateInstanceOperationSettings().build();
    resetInstanceSettings = settingsBuilder.resetInstanceSettings().build();
    resetInstanceOperationSettings = settingsBuilder.resetInstanceOperationSettings().build();
    startInstanceSettings = settingsBuilder.startInstanceSettings().build();
    startInstanceOperationSettings = settingsBuilder.startInstanceOperationSettings().build();
    stopInstanceSettings = settingsBuilder.stopInstanceSettings().build();
    stopInstanceOperationSettings = settingsBuilder.stopInstanceOperationSettings().build();
    detachLunSettings = settingsBuilder.detachLunSettings().build();
    detachLunOperationSettings = settingsBuilder.detachLunOperationSettings().build();
    listVolumesSettings = settingsBuilder.listVolumesSettings().build();
    getVolumeSettings = settingsBuilder.getVolumeSettings().build();
    updateVolumeSettings = settingsBuilder.updateVolumeSettings().build();
    updateVolumeOperationSettings = settingsBuilder.updateVolumeOperationSettings().build();
    resizeVolumeSettings = settingsBuilder.resizeVolumeSettings().build();
    resizeVolumeOperationSettings = settingsBuilder.resizeVolumeOperationSettings().build();
    listNetworksSettings = settingsBuilder.listNetworksSettings().build();
    listNetworkUsageSettings = settingsBuilder.listNetworkUsageSettings().build();
    getNetworkSettings = settingsBuilder.getNetworkSettings().build();
    updateNetworkSettings = settingsBuilder.updateNetworkSettings().build();
    updateNetworkOperationSettings = settingsBuilder.updateNetworkOperationSettings().build();
    getLunSettings = settingsBuilder.getLunSettings().build();
    listLunsSettings = settingsBuilder.listLunsSettings().build();
    getNfsShareSettings = settingsBuilder.getNfsShareSettings().build();
    listNfsSharesSettings = settingsBuilder.listNfsSharesSettings().build();
    updateNfsShareSettings = settingsBuilder.updateNfsShareSettings().build();
    updateNfsShareOperationSettings = settingsBuilder.updateNfsShareOperationSettings().build();
  }

  /** Builder for BareMetalSolutionStubSettings. */
  public static class Builder extends StubSettings.Builder<BareMetalSolutionStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation>
        updateInstanceSettings;
    private final OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<ResetInstanceRequest, Operation> resetInstanceSettings;
    private final OperationCallSettings.Builder<
            ResetInstanceRequest, ResetInstanceResponse, OperationMetadata>
        resetInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings;
    private final OperationCallSettings.Builder<
            StartInstanceRequest, StartInstanceResponse, OperationMetadata>
        startInstanceOperationSettings;
    private final UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings;
    private final OperationCallSettings.Builder<
            StopInstanceRequest, StopInstanceResponse, OperationMetadata>
        stopInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DetachLunRequest, Operation> detachLunSettings;
    private final OperationCallSettings.Builder<DetachLunRequest, Instance, OperationMetadata>
        detachLunOperationSettings;
    private final PagedCallSettings.Builder<
            ListVolumesRequest, ListVolumesResponse, ListVolumesPagedResponse>
        listVolumesSettings;
    private final UnaryCallSettings.Builder<GetVolumeRequest, Volume> getVolumeSettings;
    private final UnaryCallSettings.Builder<UpdateVolumeRequest, Operation> updateVolumeSettings;
    private final OperationCallSettings.Builder<UpdateVolumeRequest, Volume, OperationMetadata>
        updateVolumeOperationSettings;
    private final UnaryCallSettings.Builder<ResizeVolumeRequest, Operation> resizeVolumeSettings;
    private final OperationCallSettings.Builder<ResizeVolumeRequest, Volume, OperationMetadata>
        resizeVolumeOperationSettings;
    private final PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings;
    private final UnaryCallSettings.Builder<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageSettings;
    private final UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings;
    private final UnaryCallSettings.Builder<UpdateNetworkRequest, Operation> updateNetworkSettings;
    private final OperationCallSettings.Builder<UpdateNetworkRequest, Network, OperationMetadata>
        updateNetworkOperationSettings;
    private final UnaryCallSettings.Builder<GetLunRequest, Lun> getLunSettings;
    private final PagedCallSettings.Builder<
            ListLunsRequest, ListLunsResponse, ListLunsPagedResponse>
        listLunsSettings;
    private final UnaryCallSettings.Builder<GetNfsShareRequest, NfsShare> getNfsShareSettings;
    private final PagedCallSettings.Builder<
            ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
        listNfsSharesSettings;
    private final UnaryCallSettings.Builder<UpdateNfsShareRequest, Operation>
        updateNfsShareSettings;
    private final OperationCallSettings.Builder<UpdateNfsShareRequest, NfsShare, OperationMetadata>
        updateNfsShareOperationSettings;
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
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceOperationSettings = OperationCallSettings.newBuilder();
      resetInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resetInstanceOperationSettings = OperationCallSettings.newBuilder();
      startInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startInstanceOperationSettings = OperationCallSettings.newBuilder();
      stopInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopInstanceOperationSettings = OperationCallSettings.newBuilder();
      detachLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachLunOperationSettings = OperationCallSettings.newBuilder();
      listVolumesSettings = PagedCallSettings.newBuilder(LIST_VOLUMES_PAGE_STR_FACT);
      getVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateVolumeOperationSettings = OperationCallSettings.newBuilder();
      resizeVolumeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      resizeVolumeOperationSettings = OperationCallSettings.newBuilder();
      listNetworksSettings = PagedCallSettings.newBuilder(LIST_NETWORKS_PAGE_STR_FACT);
      listNetworkUsageSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNetworkOperationSettings = OperationCallSettings.newBuilder();
      getLunSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLunsSettings = PagedCallSettings.newBuilder(LIST_LUNS_PAGE_STR_FACT);
      getNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNfsSharesSettings = PagedCallSettings.newBuilder(LIST_NFS_SHARES_PAGE_STR_FACT);
      updateNfsShareSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateNfsShareOperationSettings = OperationCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              updateInstanceSettings,
              resetInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              detachLunSettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              resizeVolumeSettings,
              listNetworksSettings,
              listNetworkUsageSettings,
              getNetworkSettings,
              updateNetworkSettings,
              getLunSettings,
              listLunsSettings,
              getNfsShareSettings,
              listNfsSharesSettings,
              updateNfsShareSettings);
      initDefaults(this);
    }

    protected Builder(BareMetalSolutionStubSettings settings) {
      super(settings);

      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      updateInstanceOperationSettings = settings.updateInstanceOperationSettings.toBuilder();
      resetInstanceSettings = settings.resetInstanceSettings.toBuilder();
      resetInstanceOperationSettings = settings.resetInstanceOperationSettings.toBuilder();
      startInstanceSettings = settings.startInstanceSettings.toBuilder();
      startInstanceOperationSettings = settings.startInstanceOperationSettings.toBuilder();
      stopInstanceSettings = settings.stopInstanceSettings.toBuilder();
      stopInstanceOperationSettings = settings.stopInstanceOperationSettings.toBuilder();
      detachLunSettings = settings.detachLunSettings.toBuilder();
      detachLunOperationSettings = settings.detachLunOperationSettings.toBuilder();
      listVolumesSettings = settings.listVolumesSettings.toBuilder();
      getVolumeSettings = settings.getVolumeSettings.toBuilder();
      updateVolumeSettings = settings.updateVolumeSettings.toBuilder();
      updateVolumeOperationSettings = settings.updateVolumeOperationSettings.toBuilder();
      resizeVolumeSettings = settings.resizeVolumeSettings.toBuilder();
      resizeVolumeOperationSettings = settings.resizeVolumeOperationSettings.toBuilder();
      listNetworksSettings = settings.listNetworksSettings.toBuilder();
      listNetworkUsageSettings = settings.listNetworkUsageSettings.toBuilder();
      getNetworkSettings = settings.getNetworkSettings.toBuilder();
      updateNetworkSettings = settings.updateNetworkSettings.toBuilder();
      updateNetworkOperationSettings = settings.updateNetworkOperationSettings.toBuilder();
      getLunSettings = settings.getLunSettings.toBuilder();
      listLunsSettings = settings.listLunsSettings.toBuilder();
      getNfsShareSettings = settings.getNfsShareSettings.toBuilder();
      listNfsSharesSettings = settings.listNfsSharesSettings.toBuilder();
      updateNfsShareSettings = settings.updateNfsShareSettings.toBuilder();
      updateNfsShareOperationSettings = settings.updateNfsShareOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listInstancesSettings,
              getInstanceSettings,
              updateInstanceSettings,
              resetInstanceSettings,
              startInstanceSettings,
              stopInstanceSettings,
              detachLunSettings,
              listVolumesSettings,
              getVolumeSettings,
              updateVolumeSettings,
              resizeVolumeSettings,
              listNetworksSettings,
              listNetworkUsageSettings,
              getNetworkSettings,
              updateNetworkSettings,
              getLunSettings,
              listLunsSettings,
              getNfsShareSettings,
              listNfsSharesSettings,
              updateNfsShareSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
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
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .resetInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .startInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .stopInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .detachLunSettings()
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
          .resizeVolumeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNetworksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNetworkUsageSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getNetworkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNetworkSettings()
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
          .getNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNfsSharesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateNfsShareSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
          .startInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StartInstanceResponse.class))
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
          .stopInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StopInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(StopInstanceResponse.class))
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
          .detachLunOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DetachLunRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Instance.class))
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
          .resizeVolumeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ResizeVolumeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateNetworkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNetworkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Network.class))
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
          .updateNfsShareOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateNfsShareRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(NfsShare.class))
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

    /** Returns the builder for the settings used for calls to updateInstance. */
    public UnaryCallSettings.Builder<UpdateInstanceRequest, Operation> updateInstanceSettings() {
      return updateInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to updateInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings() {
      return updateInstanceOperationSettings;
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

    /** Returns the builder for the settings used for calls to startInstance. */
    public UnaryCallSettings.Builder<StartInstanceRequest, Operation> startInstanceSettings() {
      return startInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to startInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            StartInstanceRequest, StartInstanceResponse, OperationMetadata>
        startInstanceOperationSettings() {
      return startInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    public UnaryCallSettings.Builder<StopInstanceRequest, Operation> stopInstanceSettings() {
      return stopInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to stopInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            StopInstanceRequest, StopInstanceResponse, OperationMetadata>
        stopInstanceOperationSettings() {
      return stopInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    public UnaryCallSettings.Builder<DetachLunRequest, Operation> detachLunSettings() {
      return detachLunSettings;
    }

    /** Returns the builder for the settings used for calls to detachLun. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DetachLunRequest, Instance, OperationMetadata>
        detachLunOperationSettings() {
      return detachLunOperationSettings;
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

    /** Returns the builder for the settings used for calls to resizeVolume. */
    public UnaryCallSettings.Builder<ResizeVolumeRequest, Operation> resizeVolumeSettings() {
      return resizeVolumeSettings;
    }

    /** Returns the builder for the settings used for calls to resizeVolume. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<ResizeVolumeRequest, Volume, OperationMetadata>
        resizeVolumeOperationSettings() {
      return resizeVolumeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworks. */
    public PagedCallSettings.Builder<
            ListNetworksRequest, ListNetworksResponse, ListNetworksPagedResponse>
        listNetworksSettings() {
      return listNetworksSettings;
    }

    /** Returns the builder for the settings used for calls to listNetworkUsage. */
    public UnaryCallSettings.Builder<ListNetworkUsageRequest, ListNetworkUsageResponse>
        listNetworkUsageSettings() {
      return listNetworkUsageSettings;
    }

    /** Returns the builder for the settings used for calls to getNetwork. */
    public UnaryCallSettings.Builder<GetNetworkRequest, Network> getNetworkSettings() {
      return getNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    public UnaryCallSettings.Builder<UpdateNetworkRequest, Operation> updateNetworkSettings() {
      return updateNetworkSettings;
    }

    /** Returns the builder for the settings used for calls to updateNetwork. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateNetworkRequest, Network, OperationMetadata>
        updateNetworkOperationSettings() {
      return updateNetworkOperationSettings;
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

    /** Returns the builder for the settings used for calls to getNfsShare. */
    public UnaryCallSettings.Builder<GetNfsShareRequest, NfsShare> getNfsShareSettings() {
      return getNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to listNfsShares. */
    public PagedCallSettings.Builder<
            ListNfsSharesRequest, ListNfsSharesResponse, ListNfsSharesPagedResponse>
        listNfsSharesSettings() {
      return listNfsSharesSettings;
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    public UnaryCallSettings.Builder<UpdateNfsShareRequest, Operation> updateNfsShareSettings() {
      return updateNfsShareSettings;
    }

    /** Returns the builder for the settings used for calls to updateNfsShare. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateNfsShareRequest, NfsShare, OperationMetadata>
        updateNfsShareOperationSettings() {
      return updateNfsShareOperationSettings;
    }

    @Override
    public BareMetalSolutionStubSettings build() throws IOException {
      return new BareMetalSolutionStubSettings(this);
    }
  }
}
