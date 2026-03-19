/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListDataProductsPagedResponse;
import static com.google.cloud.dataplex.v1.DataProductServiceClient.ListLocationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.api.gax.rpc.LibraryMetadata;
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
import com.google.cloud.dataplex.v1.CreateDataAssetRequest;
import com.google.cloud.dataplex.v1.CreateDataProductRequest;
import com.google.cloud.dataplex.v1.DataAsset;
import com.google.cloud.dataplex.v1.DataProduct;
import com.google.cloud.dataplex.v1.DeleteDataAssetRequest;
import com.google.cloud.dataplex.v1.DeleteDataProductRequest;
import com.google.cloud.dataplex.v1.GetDataAssetRequest;
import com.google.cloud.dataplex.v1.GetDataProductRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsRequest;
import com.google.cloud.dataplex.v1.ListDataAssetsResponse;
import com.google.cloud.dataplex.v1.ListDataProductsRequest;
import com.google.cloud.dataplex.v1.ListDataProductsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAssetRequest;
import com.google.cloud.dataplex.v1.UpdateDataProductRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link DataProductServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (dataplex.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataProduct:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataProductServiceStubSettings.Builder dataProductServiceSettingsBuilder =
 *     DataProductServiceStubSettings.newBuilder();
 * dataProductServiceSettingsBuilder
 *     .getDataProductSettings()
 *     .setRetrySettings(
 *         dataProductServiceSettingsBuilder
 *             .getDataProductSettings()
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
 * DataProductServiceStubSettings dataProductServiceSettings =
 *     dataProductServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createDataProduct:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataProductServiceStubSettings.Builder dataProductServiceSettingsBuilder =
 *     DataProductServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataProductServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class DataProductServiceStubSettings extends StubSettings<DataProductServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataProductRequest, Operation> createDataProductSettings;
  private final OperationCallSettings<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationSettings;
  private final UnaryCallSettings<DeleteDataProductRequest, Operation> deleteDataProductSettings;
  private final OperationCallSettings<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationSettings;
  private final UnaryCallSettings<GetDataProductRequest, DataProduct> getDataProductSettings;
  private final PagedCallSettings<
          ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
      listDataProductsSettings;
  private final UnaryCallSettings<UpdateDataProductRequest, Operation> updateDataProductSettings;
  private final OperationCallSettings<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationSettings;
  private final UnaryCallSettings<CreateDataAssetRequest, Operation> createDataAssetSettings;
  private final OperationCallSettings<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationSettings;
  private final UnaryCallSettings<UpdateDataAssetRequest, Operation> updateDataAssetSettings;
  private final OperationCallSettings<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationSettings;
  private final UnaryCallSettings<DeleteDataAssetRequest, Operation> deleteDataAssetSettings;
  private final OperationCallSettings<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationSettings;
  private final UnaryCallSettings<GetDataAssetRequest, DataAsset> getDataAssetSettings;
  private final PagedCallSettings<
          ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
      listDataAssetsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDataProductsRequest, ListDataProductsResponse, DataProduct>
      LIST_DATA_PRODUCTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataProductsRequest, ListDataProductsResponse, DataProduct>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataProductsRequest injectToken(
                ListDataProductsRequest payload, String token) {
              return ListDataProductsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataProductsRequest injectPageSize(
                ListDataProductsRequest payload, int pageSize) {
              return ListDataProductsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataProductsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataProductsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataProduct> extractResources(ListDataProductsResponse payload) {
              return payload.getDataProductsList();
            }
          };

  private static final PagedListDescriptor<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset>
      LIST_DATA_ASSETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAssetsRequest injectToken(ListDataAssetsRequest payload, String token) {
              return ListDataAssetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataAssetsRequest injectPageSize(
                ListDataAssetsRequest payload, int pageSize) {
              return ListDataAssetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataAssetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAssetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAsset> extractResources(ListDataAssetsResponse payload) {
              return payload.getDataAssetsList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
      LIST_DATA_PRODUCTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>() {
            @Override
            public ApiFuture<ListDataProductsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataProductsRequest, ListDataProductsResponse> callable,
                ListDataProductsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataProductsResponse> futureResponse) {
              PageContext<ListDataProductsRequest, ListDataProductsResponse, DataProduct>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_PRODUCTS_PAGE_STR_DESC, request, context);
              return ListDataProductsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
      LIST_DATA_ASSETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>() {
            @Override
            public ApiFuture<ListDataAssetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAssetsRequest, ListDataAssetsResponse> callable,
                ListDataAssetsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAssetsResponse> futureResponse) {
              PageContext<ListDataAssetsRequest, ListDataAssetsResponse, DataAsset> pageContext =
                  PageContext.create(callable, LIST_DATA_ASSETS_PAGE_STR_DESC, request, context);
              return ListDataAssetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createDataProduct. */
  public UnaryCallSettings<CreateDataProductRequest, Operation> createDataProductSettings() {
    return createDataProductSettings;
  }

  /** Returns the object with the settings used for calls to createDataProduct. */
  public OperationCallSettings<CreateDataProductRequest, DataProduct, OperationMetadata>
      createDataProductOperationSettings() {
    return createDataProductOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataProduct. */
  public UnaryCallSettings<DeleteDataProductRequest, Operation> deleteDataProductSettings() {
    return deleteDataProductSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataProduct. */
  public OperationCallSettings<DeleteDataProductRequest, Empty, OperationMetadata>
      deleteDataProductOperationSettings() {
    return deleteDataProductOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataProduct. */
  public UnaryCallSettings<GetDataProductRequest, DataProduct> getDataProductSettings() {
    return getDataProductSettings;
  }

  /** Returns the object with the settings used for calls to listDataProducts. */
  public PagedCallSettings<
          ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
      listDataProductsSettings() {
    return listDataProductsSettings;
  }

  /** Returns the object with the settings used for calls to updateDataProduct. */
  public UnaryCallSettings<UpdateDataProductRequest, Operation> updateDataProductSettings() {
    return updateDataProductSettings;
  }

  /** Returns the object with the settings used for calls to updateDataProduct. */
  public OperationCallSettings<UpdateDataProductRequest, DataProduct, OperationMetadata>
      updateDataProductOperationSettings() {
    return updateDataProductOperationSettings;
  }

  /** Returns the object with the settings used for calls to createDataAsset. */
  public UnaryCallSettings<CreateDataAssetRequest, Operation> createDataAssetSettings() {
    return createDataAssetSettings;
  }

  /** Returns the object with the settings used for calls to createDataAsset. */
  public OperationCallSettings<CreateDataAssetRequest, DataAsset, OperationMetadata>
      createDataAssetOperationSettings() {
    return createDataAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAsset. */
  public UnaryCallSettings<UpdateDataAssetRequest, Operation> updateDataAssetSettings() {
    return updateDataAssetSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAsset. */
  public OperationCallSettings<UpdateDataAssetRequest, DataAsset, OperationMetadata>
      updateDataAssetOperationSettings() {
    return updateDataAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAsset. */
  public UnaryCallSettings<DeleteDataAssetRequest, Operation> deleteDataAssetSettings() {
    return deleteDataAssetSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAsset. */
  public OperationCallSettings<DeleteDataAssetRequest, Empty, OperationMetadata>
      deleteDataAssetOperationSettings() {
    return deleteDataAssetOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataAsset. */
  public UnaryCallSettings<GetDataAssetRequest, DataAsset> getDataAssetSettings() {
    return getDataAssetSettings;
  }

  /** Returns the object with the settings used for calls to listDataAssets. */
  public PagedCallSettings<
          ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
      listDataAssetsSettings() {
    return listDataAssetsSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public DataProductServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataProductServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataProductServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "dataplex";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "dataplex.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "dataplex.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataProductServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataProductServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataProductServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataProductServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataProductSettings = settingsBuilder.createDataProductSettings().build();
    createDataProductOperationSettings =
        settingsBuilder.createDataProductOperationSettings().build();
    deleteDataProductSettings = settingsBuilder.deleteDataProductSettings().build();
    deleteDataProductOperationSettings =
        settingsBuilder.deleteDataProductOperationSettings().build();
    getDataProductSettings = settingsBuilder.getDataProductSettings().build();
    listDataProductsSettings = settingsBuilder.listDataProductsSettings().build();
    updateDataProductSettings = settingsBuilder.updateDataProductSettings().build();
    updateDataProductOperationSettings =
        settingsBuilder.updateDataProductOperationSettings().build();
    createDataAssetSettings = settingsBuilder.createDataAssetSettings().build();
    createDataAssetOperationSettings = settingsBuilder.createDataAssetOperationSettings().build();
    updateDataAssetSettings = settingsBuilder.updateDataAssetSettings().build();
    updateDataAssetOperationSettings = settingsBuilder.updateDataAssetOperationSettings().build();
    deleteDataAssetSettings = settingsBuilder.deleteDataAssetSettings().build();
    deleteDataAssetOperationSettings = settingsBuilder.deleteDataAssetOperationSettings().build();
    getDataAssetSettings = settingsBuilder.getDataAssetSettings().build();
    listDataAssetsSettings = settingsBuilder.listDataAssetsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-dataplex")
        .setRepository("googleapis/google-cloud-java")
        .build();
  }

  /** Builder for DataProductServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataProductServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataProductRequest, Operation>
        createDataProductSettings;
    private final OperationCallSettings.Builder<
            CreateDataProductRequest, DataProduct, OperationMetadata>
        createDataProductOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataProductRequest, Operation>
        deleteDataProductSettings;
    private final OperationCallSettings.Builder<DeleteDataProductRequest, Empty, OperationMetadata>
        deleteDataProductOperationSettings;
    private final UnaryCallSettings.Builder<GetDataProductRequest, DataProduct>
        getDataProductSettings;
    private final PagedCallSettings.Builder<
            ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
        listDataProductsSettings;
    private final UnaryCallSettings.Builder<UpdateDataProductRequest, Operation>
        updateDataProductSettings;
    private final OperationCallSettings.Builder<
            UpdateDataProductRequest, DataProduct, OperationMetadata>
        updateDataProductOperationSettings;
    private final UnaryCallSettings.Builder<CreateDataAssetRequest, Operation>
        createDataAssetSettings;
    private final OperationCallSettings.Builder<
            CreateDataAssetRequest, DataAsset, OperationMetadata>
        createDataAssetOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataAssetRequest, Operation>
        updateDataAssetSettings;
    private final OperationCallSettings.Builder<
            UpdateDataAssetRequest, DataAsset, OperationMetadata>
        updateDataAssetOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataAssetRequest, Operation>
        deleteDataAssetSettings;
    private final OperationCallSettings.Builder<DeleteDataAssetRequest, Empty, OperationMetadata>
        deleteDataAssetOperationSettings;
    private final UnaryCallSettings.Builder<GetDataAssetRequest, DataAsset> getDataAssetSettings;
    private final PagedCallSettings.Builder<
            ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
        listDataAssetsSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createDataProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataProductOperationSettings = OperationCallSettings.newBuilder();
      deleteDataProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataProductOperationSettings = OperationCallSettings.newBuilder();
      getDataProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataProductsSettings = PagedCallSettings.newBuilder(LIST_DATA_PRODUCTS_PAGE_STR_FACT);
      updateDataProductSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataProductOperationSettings = OperationCallSettings.newBuilder();
      createDataAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAssetOperationSettings = OperationCallSettings.newBuilder();
      updateDataAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataAssetOperationSettings = OperationCallSettings.newBuilder();
      deleteDataAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAssetOperationSettings = OperationCallSettings.newBuilder();
      getDataAssetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDataAssetsSettings = PagedCallSettings.newBuilder(LIST_DATA_ASSETS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataProductSettings,
              deleteDataProductSettings,
              getDataProductSettings,
              listDataProductsSettings,
              updateDataProductSettings,
              createDataAssetSettings,
              updateDataAssetSettings,
              deleteDataAssetSettings,
              getDataAssetSettings,
              listDataAssetsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(DataProductServiceStubSettings settings) {
      super(settings);

      createDataProductSettings = settings.createDataProductSettings.toBuilder();
      createDataProductOperationSettings = settings.createDataProductOperationSettings.toBuilder();
      deleteDataProductSettings = settings.deleteDataProductSettings.toBuilder();
      deleteDataProductOperationSettings = settings.deleteDataProductOperationSettings.toBuilder();
      getDataProductSettings = settings.getDataProductSettings.toBuilder();
      listDataProductsSettings = settings.listDataProductsSettings.toBuilder();
      updateDataProductSettings = settings.updateDataProductSettings.toBuilder();
      updateDataProductOperationSettings = settings.updateDataProductOperationSettings.toBuilder();
      createDataAssetSettings = settings.createDataAssetSettings.toBuilder();
      createDataAssetOperationSettings = settings.createDataAssetOperationSettings.toBuilder();
      updateDataAssetSettings = settings.updateDataAssetSettings.toBuilder();
      updateDataAssetOperationSettings = settings.updateDataAssetOperationSettings.toBuilder();
      deleteDataAssetSettings = settings.deleteDataAssetSettings.toBuilder();
      deleteDataAssetOperationSettings = settings.deleteDataAssetOperationSettings.toBuilder();
      getDataAssetSettings = settings.getDataAssetSettings.toBuilder();
      listDataAssetsSettings = settings.listDataAssetsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataProductSettings,
              deleteDataProductSettings,
              getDataProductSettings,
              listDataProductsSettings,
              updateDataProductSettings,
              createDataAssetSettings,
              updateDataAssetSettings,
              deleteDataAssetSettings,
              getDataAssetSettings,
              listDataAssetsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createDataProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataProductsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataProductSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataAssetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataAssetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataProductOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataProductRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataProduct.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteDataProductOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataProductRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateDataProductOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataProductRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataProduct.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .createDataAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAsset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .updateDataAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAsset.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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
          .deleteDataAssetOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataAssetRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createDataProduct. */
    public UnaryCallSettings.Builder<CreateDataProductRequest, Operation>
        createDataProductSettings() {
      return createDataProductSettings;
    }

    /** Returns the builder for the settings used for calls to createDataProduct. */
    public OperationCallSettings.Builder<CreateDataProductRequest, DataProduct, OperationMetadata>
        createDataProductOperationSettings() {
      return createDataProductOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataProduct. */
    public UnaryCallSettings.Builder<DeleteDataProductRequest, Operation>
        deleteDataProductSettings() {
      return deleteDataProductSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataProduct. */
    public OperationCallSettings.Builder<DeleteDataProductRequest, Empty, OperationMetadata>
        deleteDataProductOperationSettings() {
      return deleteDataProductOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataProduct. */
    public UnaryCallSettings.Builder<GetDataProductRequest, DataProduct> getDataProductSettings() {
      return getDataProductSettings;
    }

    /** Returns the builder for the settings used for calls to listDataProducts. */
    public PagedCallSettings.Builder<
            ListDataProductsRequest, ListDataProductsResponse, ListDataProductsPagedResponse>
        listDataProductsSettings() {
      return listDataProductsSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataProduct. */
    public UnaryCallSettings.Builder<UpdateDataProductRequest, Operation>
        updateDataProductSettings() {
      return updateDataProductSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataProduct. */
    public OperationCallSettings.Builder<UpdateDataProductRequest, DataProduct, OperationMetadata>
        updateDataProductOperationSettings() {
      return updateDataProductOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAsset. */
    public UnaryCallSettings.Builder<CreateDataAssetRequest, Operation> createDataAssetSettings() {
      return createDataAssetSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAsset. */
    public OperationCallSettings.Builder<CreateDataAssetRequest, DataAsset, OperationMetadata>
        createDataAssetOperationSettings() {
      return createDataAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAsset. */
    public UnaryCallSettings.Builder<UpdateDataAssetRequest, Operation> updateDataAssetSettings() {
      return updateDataAssetSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAsset. */
    public OperationCallSettings.Builder<UpdateDataAssetRequest, DataAsset, OperationMetadata>
        updateDataAssetOperationSettings() {
      return updateDataAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAsset. */
    public UnaryCallSettings.Builder<DeleteDataAssetRequest, Operation> deleteDataAssetSettings() {
      return deleteDataAssetSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAsset. */
    public OperationCallSettings.Builder<DeleteDataAssetRequest, Empty, OperationMetadata>
        deleteDataAssetOperationSettings() {
      return deleteDataAssetOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAsset. */
    public UnaryCallSettings.Builder<GetDataAssetRequest, DataAsset> getDataAssetSettings() {
      return getDataAssetSettings;
    }

    /** Returns the builder for the settings used for calls to listDataAssets. */
    public PagedCallSettings.Builder<
            ListDataAssetsRequest, ListDataAssetsResponse, ListDataAssetsPagedResponse>
        listDataAssetsSettings() {
      return listDataAssetsSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public DataProductServiceStubSettings build() throws IOException {
      return new DataProductServiceStubSettings(this);
    }
  }
}
