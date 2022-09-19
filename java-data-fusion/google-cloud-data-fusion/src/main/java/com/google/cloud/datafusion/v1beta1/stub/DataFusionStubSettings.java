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

package com.google.cloud.datafusion.v1beta1.stub;

import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListAvailableVersionsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListDnsPeeringsPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListInstancesPagedResponse;
import static com.google.cloud.datafusion.v1beta1.DataFusionClient.ListNamespacesPagedResponse;

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
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.AddDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.CreateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.DeleteInstanceRequest;
import com.google.cloud.datafusion.v1beta1.DnsPeering;
import com.google.cloud.datafusion.v1beta1.GetInstanceRequest;
import com.google.cloud.datafusion.v1beta1.Instance;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsRequest;
import com.google.cloud.datafusion.v1beta1.ListAvailableVersionsResponse;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsRequest;
import com.google.cloud.datafusion.v1beta1.ListDnsPeeringsResponse;
import com.google.cloud.datafusion.v1beta1.ListInstancesRequest;
import com.google.cloud.datafusion.v1beta1.ListInstancesResponse;
import com.google.cloud.datafusion.v1beta1.ListNamespacesRequest;
import com.google.cloud.datafusion.v1beta1.ListNamespacesResponse;
import com.google.cloud.datafusion.v1beta1.Namespace;
import com.google.cloud.datafusion.v1beta1.OperationMetadata;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringRequest;
import com.google.cloud.datafusion.v1beta1.RemoveDnsPeeringResponse;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyRequest;
import com.google.cloud.datafusion.v1beta1.RemoveIamPolicyResponse;
import com.google.cloud.datafusion.v1beta1.RestartInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpdateInstanceRequest;
import com.google.cloud.datafusion.v1beta1.UpgradeInstanceRequest;
import com.google.cloud.datafusion.v1beta1.Version;
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
 * Settings class to configure an instance of {@link DataFusionStub}.
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
 * DataFusionStubSettings.Builder dataFusionSettingsBuilder = DataFusionStubSettings.newBuilder();
 * dataFusionSettingsBuilder
 *     .getInstanceSettings()
 *     .setRetrySettings(
 *         dataFusionSettingsBuilder.getInstanceSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataFusionStubSettings dataFusionSettings = dataFusionSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataFusionStubSettings extends StubSettings<DataFusionStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          ListAvailableVersionsPagedResponse>
      listAvailableVersionsSettings;
  private final PagedCallSettings<
          ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings;
  private final UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings;
  private final UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings;
  private final OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings;
  private final UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings;
  private final OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings;
  private final UnaryCallSettings<UpdateInstanceRequest, Operation> updateInstanceSettings;
  private final OperationCallSettings<UpdateInstanceRequest, Instance, OperationMetadata>
      updateInstanceOperationSettings;
  private final UnaryCallSettings<RestartInstanceRequest, Operation> restartInstanceSettings;
  private final OperationCallSettings<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationSettings;
  private final UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings;
  private final OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings;
  private final UnaryCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicySettings;
  private final PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings;
  private final UnaryCallSettings<AddDnsPeeringRequest, AddDnsPeeringResponse>
      addDnsPeeringSettings;
  private final UnaryCallSettings<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringSettings;
  private final PagedCallSettings<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
      listDnsPeeringsSettings;

  private static final PagedListDescriptor<
          ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version>
      LIST_AVAILABLE_VERSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListAvailableVersionsRequest injectToken(
                ListAvailableVersionsRequest payload, String token) {
              return ListAvailableVersionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListAvailableVersionsRequest injectPageSize(
                ListAvailableVersionsRequest payload, int pageSize) {
              return ListAvailableVersionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListAvailableVersionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListAvailableVersionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Version> extractResources(ListAvailableVersionsResponse payload) {
              return payload.getAvailableVersionsList() == null
                  ? ImmutableList.<Version>of()
                  : payload.getAvailableVersionsList();
            }
          };

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

  private static final PagedListDescriptor<ListNamespacesRequest, ListNamespacesResponse, Namespace>
      LIST_NAMESPACES_PAGE_STR_DESC =
          new PagedListDescriptor<ListNamespacesRequest, ListNamespacesResponse, Namespace>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListNamespacesRequest injectToken(ListNamespacesRequest payload, String token) {
              return ListNamespacesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListNamespacesRequest injectPageSize(
                ListNamespacesRequest payload, int pageSize) {
              return ListNamespacesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListNamespacesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListNamespacesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Namespace> extractResources(ListNamespacesResponse payload) {
              return payload.getNamespacesList() == null
                  ? ImmutableList.<Namespace>of()
                  : payload.getNamespacesList();
            }
          };

  private static final PagedListDescriptor<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering>
      LIST_DNS_PEERINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDnsPeeringsRequest injectToken(
                ListDnsPeeringsRequest payload, String token) {
              return ListDnsPeeringsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDnsPeeringsRequest injectPageSize(
                ListDnsPeeringsRequest payload, int pageSize) {
              return ListDnsPeeringsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDnsPeeringsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDnsPeeringsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DnsPeering> extractResources(ListDnsPeeringsResponse payload) {
              return payload.getDnsPeeringsList() == null
                  ? ImmutableList.<DnsPeering>of()
                  : payload.getDnsPeeringsList();
            }
          };

  private static final PagedListResponseFactory<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          ListAvailableVersionsPagedResponse>
      LIST_AVAILABLE_VERSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListAvailableVersionsRequest,
              ListAvailableVersionsResponse,
              ListAvailableVersionsPagedResponse>() {
            @Override
            public ApiFuture<ListAvailableVersionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListAvailableVersionsRequest, ListAvailableVersionsResponse> callable,
                ListAvailableVersionsRequest request,
                ApiCallContext context,
                ApiFuture<ListAvailableVersionsResponse> futureResponse) {
              PageContext<ListAvailableVersionsRequest, ListAvailableVersionsResponse, Version>
                  pageContext =
                      PageContext.create(
                          callable, LIST_AVAILABLE_VERSIONS_PAGE_STR_DESC, request, context);
              return ListAvailableVersionsPagedResponse.createAsync(pageContext, futureResponse);
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
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      LIST_NAMESPACES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>() {
            @Override
            public ApiFuture<ListNamespacesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListNamespacesRequest, ListNamespacesResponse> callable,
                ListNamespacesRequest request,
                ApiCallContext context,
                ApiFuture<ListNamespacesResponse> futureResponse) {
              PageContext<ListNamespacesRequest, ListNamespacesResponse, Namespace> pageContext =
                  PageContext.create(callable, LIST_NAMESPACES_PAGE_STR_DESC, request, context);
              return ListNamespacesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
      LIST_DNS_PEERINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>() {
            @Override
            public ApiFuture<ListDnsPeeringsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDnsPeeringsRequest, ListDnsPeeringsResponse> callable,
                ListDnsPeeringsRequest request,
                ApiCallContext context,
                ApiFuture<ListDnsPeeringsResponse> futureResponse) {
              PageContext<ListDnsPeeringsRequest, ListDnsPeeringsResponse, DnsPeering> pageContext =
                  PageContext.create(callable, LIST_DNS_PEERINGS_PAGE_STR_DESC, request, context);
              return ListDnsPeeringsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listAvailableVersions. */
  public PagedCallSettings<
          ListAvailableVersionsRequest,
          ListAvailableVersionsResponse,
          ListAvailableVersionsPagedResponse>
      listAvailableVersionsSettings() {
    return listAvailableVersionsSettings;
  }

  /** Returns the object with the settings used for calls to listInstances. */
  public PagedCallSettings<ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
      listInstancesSettings() {
    return listInstancesSettings;
  }

  /** Returns the object with the settings used for calls to getInstance. */
  public UnaryCallSettings<GetInstanceRequest, Instance> getInstanceSettings() {
    return getInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public UnaryCallSettings<CreateInstanceRequest, Operation> createInstanceSettings() {
    return createInstanceSettings;
  }

  /** Returns the object with the settings used for calls to createInstance. */
  public OperationCallSettings<CreateInstanceRequest, Instance, OperationMetadata>
      createInstanceOperationSettings() {
    return createInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public UnaryCallSettings<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
    return deleteInstanceSettings;
  }

  /** Returns the object with the settings used for calls to deleteInstance. */
  public OperationCallSettings<DeleteInstanceRequest, Empty, OperationMetadata>
      deleteInstanceOperationSettings() {
    return deleteInstanceOperationSettings;
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

  /** Returns the object with the settings used for calls to restartInstance. */
  public UnaryCallSettings<RestartInstanceRequest, Operation> restartInstanceSettings() {
    return restartInstanceSettings;
  }

  /** Returns the object with the settings used for calls to restartInstance. */
  public OperationCallSettings<RestartInstanceRequest, Instance, OperationMetadata>
      restartInstanceOperationSettings() {
    return restartInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public UnaryCallSettings<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
    return upgradeInstanceSettings;
  }

  /** Returns the object with the settings used for calls to upgradeInstance. */
  public OperationCallSettings<UpgradeInstanceRequest, Instance, OperationMetadata>
      upgradeInstanceOperationSettings() {
    return upgradeInstanceOperationSettings;
  }

  /** Returns the object with the settings used for calls to removeIamPolicy. */
  public UnaryCallSettings<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
      removeIamPolicySettings() {
    return removeIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to listNamespaces. */
  public PagedCallSettings<
          ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
      listNamespacesSettings() {
    return listNamespacesSettings;
  }

  /** Returns the object with the settings used for calls to addDnsPeering. */
  public UnaryCallSettings<AddDnsPeeringRequest, AddDnsPeeringResponse> addDnsPeeringSettings() {
    return addDnsPeeringSettings;
  }

  /** Returns the object with the settings used for calls to removeDnsPeering. */
  public UnaryCallSettings<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
      removeDnsPeeringSettings() {
    return removeDnsPeeringSettings;
  }

  /** Returns the object with the settings used for calls to listDnsPeerings. */
  public PagedCallSettings<
          ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
      listDnsPeeringsSettings() {
    return listDnsPeeringsSettings;
  }

  public DataFusionStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataFusionStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataFusionStub.create(this);
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
    return "datafusion.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datafusion.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DataFusionStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataFusionStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataFusionStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataFusionStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listAvailableVersionsSettings = settingsBuilder.listAvailableVersionsSettings().build();
    listInstancesSettings = settingsBuilder.listInstancesSettings().build();
    getInstanceSettings = settingsBuilder.getInstanceSettings().build();
    createInstanceSettings = settingsBuilder.createInstanceSettings().build();
    createInstanceOperationSettings = settingsBuilder.createInstanceOperationSettings().build();
    deleteInstanceSettings = settingsBuilder.deleteInstanceSettings().build();
    deleteInstanceOperationSettings = settingsBuilder.deleteInstanceOperationSettings().build();
    updateInstanceSettings = settingsBuilder.updateInstanceSettings().build();
    updateInstanceOperationSettings = settingsBuilder.updateInstanceOperationSettings().build();
    restartInstanceSettings = settingsBuilder.restartInstanceSettings().build();
    restartInstanceOperationSettings = settingsBuilder.restartInstanceOperationSettings().build();
    upgradeInstanceSettings = settingsBuilder.upgradeInstanceSettings().build();
    upgradeInstanceOperationSettings = settingsBuilder.upgradeInstanceOperationSettings().build();
    removeIamPolicySettings = settingsBuilder.removeIamPolicySettings().build();
    listNamespacesSettings = settingsBuilder.listNamespacesSettings().build();
    addDnsPeeringSettings = settingsBuilder.addDnsPeeringSettings().build();
    removeDnsPeeringSettings = settingsBuilder.removeDnsPeeringSettings().build();
    listDnsPeeringsSettings = settingsBuilder.listDnsPeeringsSettings().build();
  }

  /** Builder for DataFusionStubSettings. */
  public static class Builder extends StubSettings.Builder<DataFusionStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListAvailableVersionsRequest,
            ListAvailableVersionsResponse,
            ListAvailableVersionsPagedResponse>
        listAvailableVersionsSettings;
    private final PagedCallSettings.Builder<
            ListInstancesRequest, ListInstancesResponse, ListInstancesPagedResponse>
        listInstancesSettings;
    private final UnaryCallSettings.Builder<GetInstanceRequest, Instance> getInstanceSettings;
    private final UnaryCallSettings.Builder<CreateInstanceRequest, Operation>
        createInstanceSettings;
    private final OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteInstanceRequest, Operation>
        deleteInstanceSettings;
    private final OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInstanceRequest, Operation>
        updateInstanceSettings;
    private final OperationCallSettings.Builder<UpdateInstanceRequest, Instance, OperationMetadata>
        updateInstanceOperationSettings;
    private final UnaryCallSettings.Builder<RestartInstanceRequest, Operation>
        restartInstanceSettings;
    private final OperationCallSettings.Builder<RestartInstanceRequest, Instance, OperationMetadata>
        restartInstanceOperationSettings;
    private final UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation>
        upgradeInstanceSettings;
    private final OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings;
    private final UnaryCallSettings.Builder<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicySettings;
    private final PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings;
    private final UnaryCallSettings.Builder<AddDnsPeeringRequest, AddDnsPeeringResponse>
        addDnsPeeringSettings;
    private final UnaryCallSettings.Builder<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
        removeDnsPeeringSettings;
    private final PagedCallSettings.Builder<
            ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
        listDnsPeeringsSettings;
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

      listAvailableVersionsSettings =
          PagedCallSettings.newBuilder(LIST_AVAILABLE_VERSIONS_PAGE_STR_FACT);
      listInstancesSettings = PagedCallSettings.newBuilder(LIST_INSTANCES_PAGE_STR_FACT);
      getInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInstanceOperationSettings = OperationCallSettings.newBuilder();
      deleteInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInstanceOperationSettings = OperationCallSettings.newBuilder();
      updateInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInstanceOperationSettings = OperationCallSettings.newBuilder();
      restartInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      restartInstanceOperationSettings = OperationCallSettings.newBuilder();
      upgradeInstanceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      upgradeInstanceOperationSettings = OperationCallSettings.newBuilder();
      removeIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listNamespacesSettings = PagedCallSettings.newBuilder(LIST_NAMESPACES_PAGE_STR_FACT);
      addDnsPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      removeDnsPeeringSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDnsPeeringsSettings = PagedCallSettings.newBuilder(LIST_DNS_PEERINGS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAvailableVersionsSettings,
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              deleteInstanceSettings,
              updateInstanceSettings,
              restartInstanceSettings,
              upgradeInstanceSettings,
              removeIamPolicySettings,
              listNamespacesSettings,
              addDnsPeeringSettings,
              removeDnsPeeringSettings,
              listDnsPeeringsSettings);
      initDefaults(this);
    }

    protected Builder(DataFusionStubSettings settings) {
      super(settings);

      listAvailableVersionsSettings = settings.listAvailableVersionsSettings.toBuilder();
      listInstancesSettings = settings.listInstancesSettings.toBuilder();
      getInstanceSettings = settings.getInstanceSettings.toBuilder();
      createInstanceSettings = settings.createInstanceSettings.toBuilder();
      createInstanceOperationSettings = settings.createInstanceOperationSettings.toBuilder();
      deleteInstanceSettings = settings.deleteInstanceSettings.toBuilder();
      deleteInstanceOperationSettings = settings.deleteInstanceOperationSettings.toBuilder();
      updateInstanceSettings = settings.updateInstanceSettings.toBuilder();
      updateInstanceOperationSettings = settings.updateInstanceOperationSettings.toBuilder();
      restartInstanceSettings = settings.restartInstanceSettings.toBuilder();
      restartInstanceOperationSettings = settings.restartInstanceOperationSettings.toBuilder();
      upgradeInstanceSettings = settings.upgradeInstanceSettings.toBuilder();
      upgradeInstanceOperationSettings = settings.upgradeInstanceOperationSettings.toBuilder();
      removeIamPolicySettings = settings.removeIamPolicySettings.toBuilder();
      listNamespacesSettings = settings.listNamespacesSettings.toBuilder();
      addDnsPeeringSettings = settings.addDnsPeeringSettings.toBuilder();
      removeDnsPeeringSettings = settings.removeDnsPeeringSettings.toBuilder();
      listDnsPeeringsSettings = settings.listDnsPeeringsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listAvailableVersionsSettings,
              listInstancesSettings,
              getInstanceSettings,
              createInstanceSettings,
              deleteInstanceSettings,
              updateInstanceSettings,
              restartInstanceSettings,
              upgradeInstanceSettings,
              removeIamPolicySettings,
              listNamespacesSettings,
              addDnsPeeringSettings,
              removeDnsPeeringSettings,
              listDnsPeeringsSettings);
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
          .listAvailableVersionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listInstancesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .restartInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .upgradeInstanceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .removeIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listNamespacesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .addDnsPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .removeDnsPeeringSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listDnsPeeringsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .deleteInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
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
          .restartInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RestartInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .upgradeInstanceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpgradeInstanceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listAvailableVersions. */
    public PagedCallSettings.Builder<
            ListAvailableVersionsRequest,
            ListAvailableVersionsResponse,
            ListAvailableVersionsPagedResponse>
        listAvailableVersionsSettings() {
      return listAvailableVersionsSettings;
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

    /** Returns the builder for the settings used for calls to createInstance. */
    public UnaryCallSettings.Builder<CreateInstanceRequest, Operation> createInstanceSettings() {
      return createInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to createInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateInstanceRequest, Instance, OperationMetadata>
        createInstanceOperationSettings() {
      return createInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    public UnaryCallSettings.Builder<DeleteInstanceRequest, Operation> deleteInstanceSettings() {
      return deleteInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteInstanceRequest, Empty, OperationMetadata>
        deleteInstanceOperationSettings() {
      return deleteInstanceOperationSettings;
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

    /** Returns the builder for the settings used for calls to restartInstance. */
    public UnaryCallSettings.Builder<RestartInstanceRequest, Operation> restartInstanceSettings() {
      return restartInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to restartInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<RestartInstanceRequest, Instance, OperationMetadata>
        restartInstanceOperationSettings() {
      return restartInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    public UnaryCallSettings.Builder<UpgradeInstanceRequest, Operation> upgradeInstanceSettings() {
      return upgradeInstanceSettings;
    }

    /** Returns the builder for the settings used for calls to upgradeInstance. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpgradeInstanceRequest, Instance, OperationMetadata>
        upgradeInstanceOperationSettings() {
      return upgradeInstanceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to removeIamPolicy. */
    public UnaryCallSettings.Builder<RemoveIamPolicyRequest, RemoveIamPolicyResponse>
        removeIamPolicySettings() {
      return removeIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to listNamespaces. */
    public PagedCallSettings.Builder<
            ListNamespacesRequest, ListNamespacesResponse, ListNamespacesPagedResponse>
        listNamespacesSettings() {
      return listNamespacesSettings;
    }

    /** Returns the builder for the settings used for calls to addDnsPeering. */
    public UnaryCallSettings.Builder<AddDnsPeeringRequest, AddDnsPeeringResponse>
        addDnsPeeringSettings() {
      return addDnsPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to removeDnsPeering. */
    public UnaryCallSettings.Builder<RemoveDnsPeeringRequest, RemoveDnsPeeringResponse>
        removeDnsPeeringSettings() {
      return removeDnsPeeringSettings;
    }

    /** Returns the builder for the settings used for calls to listDnsPeerings. */
    public PagedCallSettings.Builder<
            ListDnsPeeringsRequest, ListDnsPeeringsResponse, ListDnsPeeringsPagedResponse>
        listDnsPeeringsSettings() {
      return listDnsPeeringsSettings;
    }

    @Override
    public DataFusionStubSettings build() throws IOException {
      return new DataFusionStubSettings(this);
    }
  }
}
