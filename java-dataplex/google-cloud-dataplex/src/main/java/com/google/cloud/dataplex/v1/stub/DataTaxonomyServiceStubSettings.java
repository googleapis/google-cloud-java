/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributeBindingsPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataAttributesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListDataTaxonomiesPagedResponse;
import static com.google.cloud.dataplex.v1.DataTaxonomyServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.CreateDataAttributeRequest;
import com.google.cloud.dataplex.v1.CreateDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.DataAttribute;
import com.google.cloud.dataplex.v1.DataAttributeBinding;
import com.google.cloud.dataplex.v1.DataTaxonomy;
import com.google.cloud.dataplex.v1.DeleteDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.DeleteDataAttributeRequest;
import com.google.cloud.dataplex.v1.DeleteDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.GetDataAttributeRequest;
import com.google.cloud.dataplex.v1.GetDataTaxonomyRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsRequest;
import com.google.cloud.dataplex.v1.ListDataAttributeBindingsResponse;
import com.google.cloud.dataplex.v1.ListDataAttributesRequest;
import com.google.cloud.dataplex.v1.ListDataAttributesResponse;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesRequest;
import com.google.cloud.dataplex.v1.ListDataTaxonomiesResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateDataAttributeBindingRequest;
import com.google.cloud.dataplex.v1.UpdateDataAttributeRequest;
import com.google.cloud.dataplex.v1.UpdateDataTaxonomyRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link DataTaxonomyServiceStub}.
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
 * <p>For example, to set the total timeout of getDataTaxonomy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTaxonomyServiceStubSettings.Builder dataTaxonomyServiceSettingsBuilder =
 *     DataTaxonomyServiceStubSettings.newBuilder();
 * dataTaxonomyServiceSettingsBuilder
 *     .getDataTaxonomySettings()
 *     .setRetrySettings(
 *         dataTaxonomyServiceSettingsBuilder
 *             .getDataTaxonomySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DataTaxonomyServiceStubSettings dataTaxonomyServiceSettings =
 *     dataTaxonomyServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataTaxonomyServiceStubSettings extends StubSettings<DataTaxonomyServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateDataTaxonomyRequest, Operation> createDataTaxonomySettings;
  private final OperationCallSettings<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationSettings;
  private final UnaryCallSettings<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomySettings;
  private final OperationCallSettings<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationSettings;
  private final UnaryCallSettings<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomySettings;
  private final OperationCallSettings<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationSettings;
  private final PagedCallSettings<
          ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesSettings;
  private final UnaryCallSettings<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomySettings;
  private final UnaryCallSettings<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingSettings;
  private final OperationCallSettings<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationSettings;
  private final UnaryCallSettings<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingSettings;
  private final OperationCallSettings<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationSettings;
  private final UnaryCallSettings<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingSettings;
  private final OperationCallSettings<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationSettings;
  private final PagedCallSettings<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsSettings;
  private final UnaryCallSettings<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingSettings;
  private final UnaryCallSettings<CreateDataAttributeRequest, Operation>
      createDataAttributeSettings;
  private final OperationCallSettings<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationSettings;
  private final UnaryCallSettings<UpdateDataAttributeRequest, Operation>
      updateDataAttributeSettings;
  private final OperationCallSettings<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationSettings;
  private final UnaryCallSettings<DeleteDataAttributeRequest, Operation>
      deleteDataAttributeSettings;
  private final OperationCallSettings<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationSettings;
  private final PagedCallSettings<
          ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
      listDataAttributesSettings;
  private final UnaryCallSettings<GetDataAttributeRequest, DataAttribute> getDataAttributeSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy>
      LIST_DATA_TAXONOMIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataTaxonomiesRequest injectToken(
                ListDataTaxonomiesRequest payload, String token) {
              return ListDataTaxonomiesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataTaxonomiesRequest injectPageSize(
                ListDataTaxonomiesRequest payload, int pageSize) {
              return ListDataTaxonomiesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataTaxonomiesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataTaxonomiesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataTaxonomy> extractResources(ListDataTaxonomiesResponse payload) {
              return payload.getDataTaxonomiesList() == null
                  ? ImmutableList.<DataTaxonomy>of()
                  : payload.getDataTaxonomiesList();
            }
          };

  private static final PagedListDescriptor<
          ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse, DataAttributeBinding>
      LIST_DATA_ATTRIBUTE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataAttributeBindingsRequest,
              ListDataAttributeBindingsResponse,
              DataAttributeBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAttributeBindingsRequest injectToken(
                ListDataAttributeBindingsRequest payload, String token) {
              return ListDataAttributeBindingsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListDataAttributeBindingsRequest injectPageSize(
                ListDataAttributeBindingsRequest payload, int pageSize) {
              return ListDataAttributeBindingsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListDataAttributeBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAttributeBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAttributeBinding> extractResources(
                ListDataAttributeBindingsResponse payload) {
              return payload.getDataAttributeBindingsList() == null
                  ? ImmutableList.<DataAttributeBinding>of()
                  : payload.getDataAttributeBindingsList();
            }
          };

  private static final PagedListDescriptor<
          ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute>
      LIST_DATA_ATTRIBUTES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataAttributesRequest injectToken(
                ListDataAttributesRequest payload, String token) {
              return ListDataAttributesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataAttributesRequest injectPageSize(
                ListDataAttributesRequest payload, int pageSize) {
              return ListDataAttributesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataAttributesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataAttributesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataAttribute> extractResources(ListDataAttributesResponse payload) {
              return payload.getDataAttributesList() == null
                  ? ImmutableList.<DataAttribute>of()
                  : payload.getDataAttributesList();
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
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
      LIST_DATA_TAXONOMIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataTaxonomiesRequest,
              ListDataTaxonomiesResponse,
              ListDataTaxonomiesPagedResponse>() {
            @Override
            public ApiFuture<ListDataTaxonomiesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse> callable,
                ListDataTaxonomiesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataTaxonomiesResponse> futureResponse) {
              PageContext<ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, DataTaxonomy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_TAXONOMIES_PAGE_STR_DESC, request, context);
              return ListDataTaxonomiesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          ListDataAttributeBindingsPagedResponse>
      LIST_DATA_ATTRIBUTE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAttributeBindingsRequest,
              ListDataAttributeBindingsResponse,
              ListDataAttributeBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListDataAttributeBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAttributeBindingsRequest, ListDataAttributeBindingsResponse>
                    callable,
                ListDataAttributeBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAttributeBindingsResponse> futureResponse) {
              PageContext<
                      ListDataAttributeBindingsRequest,
                      ListDataAttributeBindingsResponse,
                      DataAttributeBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_ATTRIBUTE_BINDINGS_PAGE_STR_DESC, request, context);
              return ListDataAttributeBindingsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
      LIST_DATA_ATTRIBUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataAttributesRequest,
              ListDataAttributesResponse,
              ListDataAttributesPagedResponse>() {
            @Override
            public ApiFuture<ListDataAttributesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataAttributesRequest, ListDataAttributesResponse> callable,
                ListDataAttributesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataAttributesResponse> futureResponse) {
              PageContext<ListDataAttributesRequest, ListDataAttributesResponse, DataAttribute>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_ATTRIBUTES_PAGE_STR_DESC, request, context);
              return ListDataAttributesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createDataTaxonomy. */
  public UnaryCallSettings<CreateDataTaxonomyRequest, Operation> createDataTaxonomySettings() {
    return createDataTaxonomySettings;
  }

  /** Returns the object with the settings used for calls to createDataTaxonomy. */
  public OperationCallSettings<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      createDataTaxonomyOperationSettings() {
    return createDataTaxonomyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataTaxonomy. */
  public UnaryCallSettings<UpdateDataTaxonomyRequest, Operation> updateDataTaxonomySettings() {
    return updateDataTaxonomySettings;
  }

  /** Returns the object with the settings used for calls to updateDataTaxonomy. */
  public OperationCallSettings<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
      updateDataTaxonomyOperationSettings() {
    return updateDataTaxonomyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataTaxonomy. */
  public UnaryCallSettings<DeleteDataTaxonomyRequest, Operation> deleteDataTaxonomySettings() {
    return deleteDataTaxonomySettings;
  }

  /** Returns the object with the settings used for calls to deleteDataTaxonomy. */
  public OperationCallSettings<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
      deleteDataTaxonomyOperationSettings() {
    return deleteDataTaxonomyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDataTaxonomies. */
  public PagedCallSettings<
          ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
      listDataTaxonomiesSettings() {
    return listDataTaxonomiesSettings;
  }

  /** Returns the object with the settings used for calls to getDataTaxonomy. */
  public UnaryCallSettings<GetDataTaxonomyRequest, DataTaxonomy> getDataTaxonomySettings() {
    return getDataTaxonomySettings;
  }

  /** Returns the object with the settings used for calls to createDataAttributeBinding. */
  public UnaryCallSettings<CreateDataAttributeBindingRequest, Operation>
      createDataAttributeBindingSettings() {
    return createDataAttributeBindingSettings;
  }

  /** Returns the object with the settings used for calls to createDataAttributeBinding. */
  public OperationCallSettings<
          CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      createDataAttributeBindingOperationSettings() {
    return createDataAttributeBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAttributeBinding. */
  public UnaryCallSettings<UpdateDataAttributeBindingRequest, Operation>
      updateDataAttributeBindingSettings() {
    return updateDataAttributeBindingSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAttributeBinding. */
  public OperationCallSettings<
          UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
      updateDataAttributeBindingOperationSettings() {
    return updateDataAttributeBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAttributeBinding. */
  public UnaryCallSettings<DeleteDataAttributeBindingRequest, Operation>
      deleteDataAttributeBindingSettings() {
    return deleteDataAttributeBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAttributeBinding. */
  public OperationCallSettings<DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
      deleteDataAttributeBindingOperationSettings() {
    return deleteDataAttributeBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDataAttributeBindings. */
  public PagedCallSettings<
          ListDataAttributeBindingsRequest,
          ListDataAttributeBindingsResponse,
          ListDataAttributeBindingsPagedResponse>
      listDataAttributeBindingsSettings() {
    return listDataAttributeBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getDataAttributeBinding. */
  public UnaryCallSettings<GetDataAttributeBindingRequest, DataAttributeBinding>
      getDataAttributeBindingSettings() {
    return getDataAttributeBindingSettings;
  }

  /** Returns the object with the settings used for calls to createDataAttribute. */
  public UnaryCallSettings<CreateDataAttributeRequest, Operation> createDataAttributeSettings() {
    return createDataAttributeSettings;
  }

  /** Returns the object with the settings used for calls to createDataAttribute. */
  public OperationCallSettings<CreateDataAttributeRequest, DataAttribute, OperationMetadata>
      createDataAttributeOperationSettings() {
    return createDataAttributeOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAttribute. */
  public UnaryCallSettings<UpdateDataAttributeRequest, Operation> updateDataAttributeSettings() {
    return updateDataAttributeSettings;
  }

  /** Returns the object with the settings used for calls to updateDataAttribute. */
  public OperationCallSettings<UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
      updateDataAttributeOperationSettings() {
    return updateDataAttributeOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAttribute. */
  public UnaryCallSettings<DeleteDataAttributeRequest, Operation> deleteDataAttributeSettings() {
    return deleteDataAttributeSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataAttribute. */
  public OperationCallSettings<DeleteDataAttributeRequest, Empty, OperationMetadata>
      deleteDataAttributeOperationSettings() {
    return deleteDataAttributeOperationSettings;
  }

  /** Returns the object with the settings used for calls to listDataAttributes. */
  public PagedCallSettings<
          ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
      listDataAttributesSettings() {
    return listDataAttributesSettings;
  }

  /** Returns the object with the settings used for calls to getDataAttribute. */
  public UnaryCallSettings<GetDataAttributeRequest, DataAttribute> getDataAttributeSettings() {
    return getDataAttributeSettings;
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

  public DataTaxonomyServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDataTaxonomyServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDataTaxonomyServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(DataTaxonomyServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DataTaxonomyServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTaxonomyServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DataTaxonomyServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createDataTaxonomySettings = settingsBuilder.createDataTaxonomySettings().build();
    createDataTaxonomyOperationSettings =
        settingsBuilder.createDataTaxonomyOperationSettings().build();
    updateDataTaxonomySettings = settingsBuilder.updateDataTaxonomySettings().build();
    updateDataTaxonomyOperationSettings =
        settingsBuilder.updateDataTaxonomyOperationSettings().build();
    deleteDataTaxonomySettings = settingsBuilder.deleteDataTaxonomySettings().build();
    deleteDataTaxonomyOperationSettings =
        settingsBuilder.deleteDataTaxonomyOperationSettings().build();
    listDataTaxonomiesSettings = settingsBuilder.listDataTaxonomiesSettings().build();
    getDataTaxonomySettings = settingsBuilder.getDataTaxonomySettings().build();
    createDataAttributeBindingSettings =
        settingsBuilder.createDataAttributeBindingSettings().build();
    createDataAttributeBindingOperationSettings =
        settingsBuilder.createDataAttributeBindingOperationSettings().build();
    updateDataAttributeBindingSettings =
        settingsBuilder.updateDataAttributeBindingSettings().build();
    updateDataAttributeBindingOperationSettings =
        settingsBuilder.updateDataAttributeBindingOperationSettings().build();
    deleteDataAttributeBindingSettings =
        settingsBuilder.deleteDataAttributeBindingSettings().build();
    deleteDataAttributeBindingOperationSettings =
        settingsBuilder.deleteDataAttributeBindingOperationSettings().build();
    listDataAttributeBindingsSettings = settingsBuilder.listDataAttributeBindingsSettings().build();
    getDataAttributeBindingSettings = settingsBuilder.getDataAttributeBindingSettings().build();
    createDataAttributeSettings = settingsBuilder.createDataAttributeSettings().build();
    createDataAttributeOperationSettings =
        settingsBuilder.createDataAttributeOperationSettings().build();
    updateDataAttributeSettings = settingsBuilder.updateDataAttributeSettings().build();
    updateDataAttributeOperationSettings =
        settingsBuilder.updateDataAttributeOperationSettings().build();
    deleteDataAttributeSettings = settingsBuilder.deleteDataAttributeSettings().build();
    deleteDataAttributeOperationSettings =
        settingsBuilder.deleteDataAttributeOperationSettings().build();
    listDataAttributesSettings = settingsBuilder.listDataAttributesSettings().build();
    getDataAttributeSettings = settingsBuilder.getDataAttributeSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DataTaxonomyServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<DataTaxonomyServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateDataTaxonomyRequest, Operation>
        createDataTaxonomySettings;
    private final OperationCallSettings.Builder<
            CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        createDataTaxonomyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataTaxonomyRequest, Operation>
        updateDataTaxonomySettings;
    private final OperationCallSettings.Builder<
            UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        updateDataTaxonomyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataTaxonomyRequest, Operation>
        deleteDataTaxonomySettings;
    private final OperationCallSettings.Builder<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
        deleteDataTaxonomyOperationSettings;
    private final PagedCallSettings.Builder<
            ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
        listDataTaxonomiesSettings;
    private final UnaryCallSettings.Builder<GetDataTaxonomyRequest, DataTaxonomy>
        getDataTaxonomySettings;
    private final UnaryCallSettings.Builder<CreateDataAttributeBindingRequest, Operation>
        createDataAttributeBindingSettings;
    private final OperationCallSettings.Builder<
            CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        createDataAttributeBindingOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataAttributeBindingRequest, Operation>
        updateDataAttributeBindingSettings;
    private final OperationCallSettings.Builder<
            UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        updateDataAttributeBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataAttributeBindingRequest, Operation>
        deleteDataAttributeBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
        deleteDataAttributeBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListDataAttributeBindingsRequest,
            ListDataAttributeBindingsResponse,
            ListDataAttributeBindingsPagedResponse>
        listDataAttributeBindingsSettings;
    private final UnaryCallSettings.Builder<GetDataAttributeBindingRequest, DataAttributeBinding>
        getDataAttributeBindingSettings;
    private final UnaryCallSettings.Builder<CreateDataAttributeRequest, Operation>
        createDataAttributeSettings;
    private final OperationCallSettings.Builder<
            CreateDataAttributeRequest, DataAttribute, OperationMetadata>
        createDataAttributeOperationSettings;
    private final UnaryCallSettings.Builder<UpdateDataAttributeRequest, Operation>
        updateDataAttributeSettings;
    private final OperationCallSettings.Builder<
            UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
        updateDataAttributeOperationSettings;
    private final UnaryCallSettings.Builder<DeleteDataAttributeRequest, Operation>
        deleteDataAttributeSettings;
    private final OperationCallSettings.Builder<
            DeleteDataAttributeRequest, Empty, OperationMetadata>
        deleteDataAttributeOperationSettings;
    private final PagedCallSettings.Builder<
            ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
        listDataAttributesSettings;
    private final UnaryCallSettings.Builder<GetDataAttributeRequest, DataAttribute>
        getDataAttributeSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
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

      createDataTaxonomySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataTaxonomyOperationSettings = OperationCallSettings.newBuilder();
      updateDataTaxonomySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataTaxonomyOperationSettings = OperationCallSettings.newBuilder();
      deleteDataTaxonomySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataTaxonomyOperationSettings = OperationCallSettings.newBuilder();
      listDataTaxonomiesSettings = PagedCallSettings.newBuilder(LIST_DATA_TAXONOMIES_PAGE_STR_FACT);
      getDataTaxonomySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAttributeBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAttributeBindingOperationSettings = OperationCallSettings.newBuilder();
      updateDataAttributeBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataAttributeBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteDataAttributeBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAttributeBindingOperationSettings = OperationCallSettings.newBuilder();
      listDataAttributeBindingsSettings =
          PagedCallSettings.newBuilder(LIST_DATA_ATTRIBUTE_BINDINGS_PAGE_STR_FACT);
      getDataAttributeBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataAttributeOperationSettings = OperationCallSettings.newBuilder();
      updateDataAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataAttributeOperationSettings = OperationCallSettings.newBuilder();
      deleteDataAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataAttributeOperationSettings = OperationCallSettings.newBuilder();
      listDataAttributesSettings = PagedCallSettings.newBuilder(LIST_DATA_ATTRIBUTES_PAGE_STR_FACT);
      getDataAttributeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataTaxonomySettings,
              updateDataTaxonomySettings,
              deleteDataTaxonomySettings,
              listDataTaxonomiesSettings,
              getDataTaxonomySettings,
              createDataAttributeBindingSettings,
              updateDataAttributeBindingSettings,
              deleteDataAttributeBindingSettings,
              listDataAttributeBindingsSettings,
              getDataAttributeBindingSettings,
              createDataAttributeSettings,
              updateDataAttributeSettings,
              deleteDataAttributeSettings,
              listDataAttributesSettings,
              getDataAttributeSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DataTaxonomyServiceStubSettings settings) {
      super(settings);

      createDataTaxonomySettings = settings.createDataTaxonomySettings.toBuilder();
      createDataTaxonomyOperationSettings =
          settings.createDataTaxonomyOperationSettings.toBuilder();
      updateDataTaxonomySettings = settings.updateDataTaxonomySettings.toBuilder();
      updateDataTaxonomyOperationSettings =
          settings.updateDataTaxonomyOperationSettings.toBuilder();
      deleteDataTaxonomySettings = settings.deleteDataTaxonomySettings.toBuilder();
      deleteDataTaxonomyOperationSettings =
          settings.deleteDataTaxonomyOperationSettings.toBuilder();
      listDataTaxonomiesSettings = settings.listDataTaxonomiesSettings.toBuilder();
      getDataTaxonomySettings = settings.getDataTaxonomySettings.toBuilder();
      createDataAttributeBindingSettings = settings.createDataAttributeBindingSettings.toBuilder();
      createDataAttributeBindingOperationSettings =
          settings.createDataAttributeBindingOperationSettings.toBuilder();
      updateDataAttributeBindingSettings = settings.updateDataAttributeBindingSettings.toBuilder();
      updateDataAttributeBindingOperationSettings =
          settings.updateDataAttributeBindingOperationSettings.toBuilder();
      deleteDataAttributeBindingSettings = settings.deleteDataAttributeBindingSettings.toBuilder();
      deleteDataAttributeBindingOperationSettings =
          settings.deleteDataAttributeBindingOperationSettings.toBuilder();
      listDataAttributeBindingsSettings = settings.listDataAttributeBindingsSettings.toBuilder();
      getDataAttributeBindingSettings = settings.getDataAttributeBindingSettings.toBuilder();
      createDataAttributeSettings = settings.createDataAttributeSettings.toBuilder();
      createDataAttributeOperationSettings =
          settings.createDataAttributeOperationSettings.toBuilder();
      updateDataAttributeSettings = settings.updateDataAttributeSettings.toBuilder();
      updateDataAttributeOperationSettings =
          settings.updateDataAttributeOperationSettings.toBuilder();
      deleteDataAttributeSettings = settings.deleteDataAttributeSettings.toBuilder();
      deleteDataAttributeOperationSettings =
          settings.deleteDataAttributeOperationSettings.toBuilder();
      listDataAttributesSettings = settings.listDataAttributesSettings.toBuilder();
      getDataAttributeSettings = settings.getDataAttributeSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createDataTaxonomySettings,
              updateDataTaxonomySettings,
              deleteDataTaxonomySettings,
              listDataTaxonomiesSettings,
              getDataTaxonomySettings,
              createDataAttributeBindingSettings,
              updateDataAttributeBindingSettings,
              deleteDataAttributeBindingSettings,
              listDataAttributeBindingsSettings,
              getDataAttributeBindingSettings,
              createDataAttributeSettings,
              updateDataAttributeSettings,
              deleteDataAttributeSettings,
              listDataAttributesSettings,
              getDataAttributeSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .createDataTaxonomySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataTaxonomySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataTaxonomySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataTaxonomiesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataTaxonomySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataAttributeBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataAttributeBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataAttributeBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataAttributeBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataAttributeBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createDataAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateDataAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteDataAttributeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listDataAttributesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getDataAttributeSettings()
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
          .createDataTaxonomyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataTaxonomyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataTaxonomy.class))
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
          .updateDataTaxonomyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataTaxonomyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataTaxonomy.class))
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
          .deleteDataTaxonomyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataTaxonomyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDataAttributeBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataAttributeBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAttributeBinding.class))
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
          .updateDataAttributeBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataAttributeBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAttributeBinding.class))
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
          .deleteDataAttributeBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataAttributeBindingRequest, OperationSnapshot>
                      newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createDataAttributeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateDataAttributeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAttribute.class))
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
          .updateDataAttributeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateDataAttributeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(DataAttribute.class))
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
          .deleteDataAttributeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteDataAttributeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createDataTaxonomy. */
    public UnaryCallSettings.Builder<CreateDataTaxonomyRequest, Operation>
        createDataTaxonomySettings() {
      return createDataTaxonomySettings;
    }

    /** Returns the builder for the settings used for calls to createDataTaxonomy. */
    public OperationCallSettings.Builder<CreateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        createDataTaxonomyOperationSettings() {
      return createDataTaxonomyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataTaxonomy. */
    public UnaryCallSettings.Builder<UpdateDataTaxonomyRequest, Operation>
        updateDataTaxonomySettings() {
      return updateDataTaxonomySettings;
    }

    /** Returns the builder for the settings used for calls to updateDataTaxonomy. */
    public OperationCallSettings.Builder<UpdateDataTaxonomyRequest, DataTaxonomy, OperationMetadata>
        updateDataTaxonomyOperationSettings() {
      return updateDataTaxonomyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataTaxonomy. */
    public UnaryCallSettings.Builder<DeleteDataTaxonomyRequest, Operation>
        deleteDataTaxonomySettings() {
      return deleteDataTaxonomySettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataTaxonomy. */
    public OperationCallSettings.Builder<DeleteDataTaxonomyRequest, Empty, OperationMetadata>
        deleteDataTaxonomyOperationSettings() {
      return deleteDataTaxonomyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDataTaxonomies. */
    public PagedCallSettings.Builder<
            ListDataTaxonomiesRequest, ListDataTaxonomiesResponse, ListDataTaxonomiesPagedResponse>
        listDataTaxonomiesSettings() {
      return listDataTaxonomiesSettings;
    }

    /** Returns the builder for the settings used for calls to getDataTaxonomy. */
    public UnaryCallSettings.Builder<GetDataTaxonomyRequest, DataTaxonomy>
        getDataTaxonomySettings() {
      return getDataTaxonomySettings;
    }

    /** Returns the builder for the settings used for calls to createDataAttributeBinding. */
    public UnaryCallSettings.Builder<CreateDataAttributeBindingRequest, Operation>
        createDataAttributeBindingSettings() {
      return createDataAttributeBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAttributeBinding. */
    public OperationCallSettings.Builder<
            CreateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        createDataAttributeBindingOperationSettings() {
      return createDataAttributeBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAttributeBinding. */
    public UnaryCallSettings.Builder<UpdateDataAttributeBindingRequest, Operation>
        updateDataAttributeBindingSettings() {
      return updateDataAttributeBindingSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAttributeBinding. */
    public OperationCallSettings.Builder<
            UpdateDataAttributeBindingRequest, DataAttributeBinding, OperationMetadata>
        updateDataAttributeBindingOperationSettings() {
      return updateDataAttributeBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAttributeBinding. */
    public UnaryCallSettings.Builder<DeleteDataAttributeBindingRequest, Operation>
        deleteDataAttributeBindingSettings() {
      return deleteDataAttributeBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAttributeBinding. */
    public OperationCallSettings.Builder<
            DeleteDataAttributeBindingRequest, Empty, OperationMetadata>
        deleteDataAttributeBindingOperationSettings() {
      return deleteDataAttributeBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDataAttributeBindings. */
    public PagedCallSettings.Builder<
            ListDataAttributeBindingsRequest,
            ListDataAttributeBindingsResponse,
            ListDataAttributeBindingsPagedResponse>
        listDataAttributeBindingsSettings() {
      return listDataAttributeBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAttributeBinding. */
    public UnaryCallSettings.Builder<GetDataAttributeBindingRequest, DataAttributeBinding>
        getDataAttributeBindingSettings() {
      return getDataAttributeBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAttribute. */
    public UnaryCallSettings.Builder<CreateDataAttributeRequest, Operation>
        createDataAttributeSettings() {
      return createDataAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to createDataAttribute. */
    public OperationCallSettings.Builder<
            CreateDataAttributeRequest, DataAttribute, OperationMetadata>
        createDataAttributeOperationSettings() {
      return createDataAttributeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAttribute. */
    public UnaryCallSettings.Builder<UpdateDataAttributeRequest, Operation>
        updateDataAttributeSettings() {
      return updateDataAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataAttribute. */
    public OperationCallSettings.Builder<
            UpdateDataAttributeRequest, DataAttribute, OperationMetadata>
        updateDataAttributeOperationSettings() {
      return updateDataAttributeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAttribute. */
    public UnaryCallSettings.Builder<DeleteDataAttributeRequest, Operation>
        deleteDataAttributeSettings() {
      return deleteDataAttributeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataAttribute. */
    public OperationCallSettings.Builder<DeleteDataAttributeRequest, Empty, OperationMetadata>
        deleteDataAttributeOperationSettings() {
      return deleteDataAttributeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listDataAttributes. */
    public PagedCallSettings.Builder<
            ListDataAttributesRequest, ListDataAttributesResponse, ListDataAttributesPagedResponse>
        listDataAttributesSettings() {
      return listDataAttributesSettings;
    }

    /** Returns the builder for the settings used for calls to getDataAttribute. */
    public UnaryCallSettings.Builder<GetDataAttributeRequest, DataAttribute>
        getDataAttributeSettings() {
      return getDataAttributeSettings;
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

    @Override
    public DataTaxonomyServiceStubSettings build() throws IOException {
      return new DataTaxonomyServiceStubSettings(this);
    }
  }
}
