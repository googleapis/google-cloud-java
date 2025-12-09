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

package com.google.cloud.dataplex.v1.stub;

import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossariesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryCategoriesPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListGlossaryTermsPagedResponse;
import static com.google.cloud.dataplex.v1.BusinessGlossaryServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.dataplex.v1.CreateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryRequest;
import com.google.cloud.dataplex.v1.CreateGlossaryTermRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryRequest;
import com.google.cloud.dataplex.v1.DeleteGlossaryTermRequest;
import com.google.cloud.dataplex.v1.GetGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryRequest;
import com.google.cloud.dataplex.v1.GetGlossaryTermRequest;
import com.google.cloud.dataplex.v1.Glossary;
import com.google.cloud.dataplex.v1.GlossaryCategory;
import com.google.cloud.dataplex.v1.GlossaryTerm;
import com.google.cloud.dataplex.v1.ListGlossariesRequest;
import com.google.cloud.dataplex.v1.ListGlossariesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesRequest;
import com.google.cloud.dataplex.v1.ListGlossaryCategoriesResponse;
import com.google.cloud.dataplex.v1.ListGlossaryTermsRequest;
import com.google.cloud.dataplex.v1.ListGlossaryTermsResponse;
import com.google.cloud.dataplex.v1.OperationMetadata;
import com.google.cloud.dataplex.v1.UpdateGlossaryCategoryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryRequest;
import com.google.cloud.dataplex.v1.UpdateGlossaryTermRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link BusinessGlossaryServiceStub}.
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
 * of getGlossary:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessGlossaryServiceStubSettings.Builder businessGlossaryServiceSettingsBuilder =
 *     BusinessGlossaryServiceStubSettings.newBuilder();
 * businessGlossaryServiceSettingsBuilder
 *     .getGlossarySettings()
 *     .setRetrySettings(
 *         businessGlossaryServiceSettingsBuilder
 *             .getGlossarySettings()
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
 * BusinessGlossaryServiceStubSettings businessGlossaryServiceSettings =
 *     businessGlossaryServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createGlossary:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * BusinessGlossaryServiceStubSettings.Builder businessGlossaryServiceSettingsBuilder =
 *     BusinessGlossaryServiceStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * businessGlossaryServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class BusinessGlossaryServiceStubSettings
    extends StubSettings<BusinessGlossaryServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings;
  private final OperationCallSettings<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationSettings;
  private final UnaryCallSettings<UpdateGlossaryRequest, Operation> updateGlossarySettings;
  private final OperationCallSettings<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationSettings;
  private final UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings;
  private final OperationCallSettings<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationSettings;
  private final UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings;
  private final PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings;
  private final UnaryCallSettings<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategorySettings;
  private final UnaryCallSettings<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategorySettings;
  private final UnaryCallSettings<DeleteGlossaryCategoryRequest, Empty>
      deleteGlossaryCategorySettings;
  private final UnaryCallSettings<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategorySettings;
  private final PagedCallSettings<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesSettings;
  private final UnaryCallSettings<CreateGlossaryTermRequest, GlossaryTerm>
      createGlossaryTermSettings;
  private final UnaryCallSettings<UpdateGlossaryTermRequest, GlossaryTerm>
      updateGlossaryTermSettings;
  private final UnaryCallSettings<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermSettings;
  private final UnaryCallSettings<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermSettings;
  private final PagedCallSettings<
          ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
      listGlossaryTermsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListGlossariesRequest, ListGlossariesResponse, Glossary>
      LIST_GLOSSARIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListGlossariesRequest, ListGlossariesResponse, Glossary>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlossariesRequest injectToken(ListGlossariesRequest payload, String token) {
              return ListGlossariesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGlossariesRequest injectPageSize(
                ListGlossariesRequest payload, int pageSize) {
              return ListGlossariesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGlossariesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGlossariesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Glossary> extractResources(ListGlossariesResponse payload) {
              return payload.getGlossariesList();
            }
          };

  private static final PagedListDescriptor<
          ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>
      LIST_GLOSSARY_CATEGORIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse, GlossaryCategory>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlossaryCategoriesRequest injectToken(
                ListGlossaryCategoriesRequest payload, String token) {
              return ListGlossaryCategoriesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGlossaryCategoriesRequest injectPageSize(
                ListGlossaryCategoriesRequest payload, int pageSize) {
              return ListGlossaryCategoriesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListGlossaryCategoriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGlossaryCategoriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GlossaryCategory> extractResources(
                ListGlossaryCategoriesResponse payload) {
              return payload.getCategoriesList();
            }
          };

  private static final PagedListDescriptor<
          ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm>
      LIST_GLOSSARY_TERMS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGlossaryTermsRequest injectToken(
                ListGlossaryTermsRequest payload, String token) {
              return ListGlossaryTermsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGlossaryTermsRequest injectPageSize(
                ListGlossaryTermsRequest payload, int pageSize) {
              return ListGlossaryTermsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGlossaryTermsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGlossaryTermsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GlossaryTerm> extractResources(ListGlossaryTermsResponse payload) {
              return payload.getTermsList();
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
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      LIST_GLOSSARIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>() {
            @Override
            public ApiFuture<ListGlossariesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlossariesRequest, ListGlossariesResponse> callable,
                ListGlossariesRequest request,
                ApiCallContext context,
                ApiFuture<ListGlossariesResponse> futureResponse) {
              PageContext<ListGlossariesRequest, ListGlossariesResponse, Glossary> pageContext =
                  PageContext.create(callable, LIST_GLOSSARIES_PAGE_STR_DESC, request, context);
              return ListGlossariesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          ListGlossaryCategoriesPagedResponse>
      LIST_GLOSSARY_CATEGORIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlossaryCategoriesRequest,
              ListGlossaryCategoriesResponse,
              ListGlossaryCategoriesPagedResponse>() {
            @Override
            public ApiFuture<ListGlossaryCategoriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlossaryCategoriesRequest, ListGlossaryCategoriesResponse>
                    callable,
                ListGlossaryCategoriesRequest request,
                ApiCallContext context,
                ApiFuture<ListGlossaryCategoriesResponse> futureResponse) {
              PageContext<
                      ListGlossaryCategoriesRequest,
                      ListGlossaryCategoriesResponse,
                      GlossaryCategory>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GLOSSARY_CATEGORIES_PAGE_STR_DESC, request, context);
              return ListGlossaryCategoriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
      LIST_GLOSSARY_TERMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGlossaryTermsRequest,
              ListGlossaryTermsResponse,
              ListGlossaryTermsPagedResponse>() {
            @Override
            public ApiFuture<ListGlossaryTermsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGlossaryTermsRequest, ListGlossaryTermsResponse> callable,
                ListGlossaryTermsRequest request,
                ApiCallContext context,
                ApiFuture<ListGlossaryTermsResponse> futureResponse) {
              PageContext<ListGlossaryTermsRequest, ListGlossaryTermsResponse, GlossaryTerm>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GLOSSARY_TERMS_PAGE_STR_DESC, request, context);
              return ListGlossaryTermsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createGlossary. */
  public UnaryCallSettings<CreateGlossaryRequest, Operation> createGlossarySettings() {
    return createGlossarySettings;
  }

  /** Returns the object with the settings used for calls to createGlossary. */
  public OperationCallSettings<CreateGlossaryRequest, Glossary, OperationMetadata>
      createGlossaryOperationSettings() {
    return createGlossaryOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGlossary. */
  public UnaryCallSettings<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
    return updateGlossarySettings;
  }

  /** Returns the object with the settings used for calls to updateGlossary. */
  public OperationCallSettings<UpdateGlossaryRequest, Glossary, OperationMetadata>
      updateGlossaryOperationSettings() {
    return updateGlossaryOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public UnaryCallSettings<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
    return deleteGlossarySettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossary. */
  public OperationCallSettings<DeleteGlossaryRequest, Empty, OperationMetadata>
      deleteGlossaryOperationSettings() {
    return deleteGlossaryOperationSettings;
  }

  /** Returns the object with the settings used for calls to getGlossary. */
  public UnaryCallSettings<GetGlossaryRequest, Glossary> getGlossarySettings() {
    return getGlossarySettings;
  }

  /** Returns the object with the settings used for calls to listGlossaries. */
  public PagedCallSettings<
          ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
      listGlossariesSettings() {
    return listGlossariesSettings;
  }

  /** Returns the object with the settings used for calls to createGlossaryCategory. */
  public UnaryCallSettings<CreateGlossaryCategoryRequest, GlossaryCategory>
      createGlossaryCategorySettings() {
    return createGlossaryCategorySettings;
  }

  /** Returns the object with the settings used for calls to updateGlossaryCategory. */
  public UnaryCallSettings<UpdateGlossaryCategoryRequest, GlossaryCategory>
      updateGlossaryCategorySettings() {
    return updateGlossaryCategorySettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossaryCategory. */
  public UnaryCallSettings<DeleteGlossaryCategoryRequest, Empty> deleteGlossaryCategorySettings() {
    return deleteGlossaryCategorySettings;
  }

  /** Returns the object with the settings used for calls to getGlossaryCategory. */
  public UnaryCallSettings<GetGlossaryCategoryRequest, GlossaryCategory>
      getGlossaryCategorySettings() {
    return getGlossaryCategorySettings;
  }

  /** Returns the object with the settings used for calls to listGlossaryCategories. */
  public PagedCallSettings<
          ListGlossaryCategoriesRequest,
          ListGlossaryCategoriesResponse,
          ListGlossaryCategoriesPagedResponse>
      listGlossaryCategoriesSettings() {
    return listGlossaryCategoriesSettings;
  }

  /** Returns the object with the settings used for calls to createGlossaryTerm. */
  public UnaryCallSettings<CreateGlossaryTermRequest, GlossaryTerm> createGlossaryTermSettings() {
    return createGlossaryTermSettings;
  }

  /** Returns the object with the settings used for calls to updateGlossaryTerm. */
  public UnaryCallSettings<UpdateGlossaryTermRequest, GlossaryTerm> updateGlossaryTermSettings() {
    return updateGlossaryTermSettings;
  }

  /** Returns the object with the settings used for calls to deleteGlossaryTerm. */
  public UnaryCallSettings<DeleteGlossaryTermRequest, Empty> deleteGlossaryTermSettings() {
    return deleteGlossaryTermSettings;
  }

  /** Returns the object with the settings used for calls to getGlossaryTerm. */
  public UnaryCallSettings<GetGlossaryTermRequest, GlossaryTerm> getGlossaryTermSettings() {
    return getGlossaryTermSettings;
  }

  /** Returns the object with the settings used for calls to listGlossaryTerms. */
  public PagedCallSettings<
          ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
      listGlossaryTermsSettings() {
    return listGlossaryTermsSettings;
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

  public BusinessGlossaryServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcBusinessGlossaryServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonBusinessGlossaryServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(BusinessGlossaryServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(BusinessGlossaryServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return BusinessGlossaryServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected BusinessGlossaryServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createGlossarySettings = settingsBuilder.createGlossarySettings().build();
    createGlossaryOperationSettings = settingsBuilder.createGlossaryOperationSettings().build();
    updateGlossarySettings = settingsBuilder.updateGlossarySettings().build();
    updateGlossaryOperationSettings = settingsBuilder.updateGlossaryOperationSettings().build();
    deleteGlossarySettings = settingsBuilder.deleteGlossarySettings().build();
    deleteGlossaryOperationSettings = settingsBuilder.deleteGlossaryOperationSettings().build();
    getGlossarySettings = settingsBuilder.getGlossarySettings().build();
    listGlossariesSettings = settingsBuilder.listGlossariesSettings().build();
    createGlossaryCategorySettings = settingsBuilder.createGlossaryCategorySettings().build();
    updateGlossaryCategorySettings = settingsBuilder.updateGlossaryCategorySettings().build();
    deleteGlossaryCategorySettings = settingsBuilder.deleteGlossaryCategorySettings().build();
    getGlossaryCategorySettings = settingsBuilder.getGlossaryCategorySettings().build();
    listGlossaryCategoriesSettings = settingsBuilder.listGlossaryCategoriesSettings().build();
    createGlossaryTermSettings = settingsBuilder.createGlossaryTermSettings().build();
    updateGlossaryTermSettings = settingsBuilder.updateGlossaryTermSettings().build();
    deleteGlossaryTermSettings = settingsBuilder.deleteGlossaryTermSettings().build();
    getGlossaryTermSettings = settingsBuilder.getGlossaryTermSettings().build();
    listGlossaryTermsSettings = settingsBuilder.listGlossaryTermsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for BusinessGlossaryServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<BusinessGlossaryServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateGlossaryRequest, Operation>
        createGlossarySettings;
    private final OperationCallSettings.Builder<CreateGlossaryRequest, Glossary, OperationMetadata>
        createGlossaryOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGlossaryRequest, Operation>
        updateGlossarySettings;
    private final OperationCallSettings.Builder<UpdateGlossaryRequest, Glossary, OperationMetadata>
        updateGlossaryOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation>
        deleteGlossarySettings;
    private final OperationCallSettings.Builder<DeleteGlossaryRequest, Empty, OperationMetadata>
        deleteGlossaryOperationSettings;
    private final UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings;
    private final PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings;
    private final UnaryCallSettings.Builder<CreateGlossaryCategoryRequest, GlossaryCategory>
        createGlossaryCategorySettings;
    private final UnaryCallSettings.Builder<UpdateGlossaryCategoryRequest, GlossaryCategory>
        updateGlossaryCategorySettings;
    private final UnaryCallSettings.Builder<DeleteGlossaryCategoryRequest, Empty>
        deleteGlossaryCategorySettings;
    private final UnaryCallSettings.Builder<GetGlossaryCategoryRequest, GlossaryCategory>
        getGlossaryCategorySettings;
    private final PagedCallSettings.Builder<
            ListGlossaryCategoriesRequest,
            ListGlossaryCategoriesResponse,
            ListGlossaryCategoriesPagedResponse>
        listGlossaryCategoriesSettings;
    private final UnaryCallSettings.Builder<CreateGlossaryTermRequest, GlossaryTerm>
        createGlossaryTermSettings;
    private final UnaryCallSettings.Builder<UpdateGlossaryTermRequest, GlossaryTerm>
        updateGlossaryTermSettings;
    private final UnaryCallSettings.Builder<DeleteGlossaryTermRequest, Empty>
        deleteGlossaryTermSettings;
    private final UnaryCallSettings.Builder<GetGlossaryTermRequest, GlossaryTerm>
        getGlossaryTermSettings;
    private final PagedCallSettings.Builder<
            ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
        listGlossaryTermsSettings;
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

      createGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGlossaryOperationSettings = OperationCallSettings.newBuilder();
      updateGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGlossaryOperationSettings = OperationCallSettings.newBuilder();
      deleteGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGlossaryOperationSettings = OperationCallSettings.newBuilder();
      getGlossarySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGlossariesSettings = PagedCallSettings.newBuilder(LIST_GLOSSARIES_PAGE_STR_FACT);
      createGlossaryCategorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGlossaryCategorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGlossaryCategorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getGlossaryCategorySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGlossaryCategoriesSettings =
          PagedCallSettings.newBuilder(LIST_GLOSSARY_CATEGORIES_PAGE_STR_FACT);
      createGlossaryTermSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGlossaryTermSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGlossaryTermSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getGlossaryTermSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGlossaryTermsSettings = PagedCallSettings.newBuilder(LIST_GLOSSARY_TERMS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createGlossarySettings,
              updateGlossarySettings,
              deleteGlossarySettings,
              getGlossarySettings,
              listGlossariesSettings,
              createGlossaryCategorySettings,
              updateGlossaryCategorySettings,
              deleteGlossaryCategorySettings,
              getGlossaryCategorySettings,
              listGlossaryCategoriesSettings,
              createGlossaryTermSettings,
              updateGlossaryTermSettings,
              deleteGlossaryTermSettings,
              getGlossaryTermSettings,
              listGlossaryTermsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(BusinessGlossaryServiceStubSettings settings) {
      super(settings);

      createGlossarySettings = settings.createGlossarySettings.toBuilder();
      createGlossaryOperationSettings = settings.createGlossaryOperationSettings.toBuilder();
      updateGlossarySettings = settings.updateGlossarySettings.toBuilder();
      updateGlossaryOperationSettings = settings.updateGlossaryOperationSettings.toBuilder();
      deleteGlossarySettings = settings.deleteGlossarySettings.toBuilder();
      deleteGlossaryOperationSettings = settings.deleteGlossaryOperationSettings.toBuilder();
      getGlossarySettings = settings.getGlossarySettings.toBuilder();
      listGlossariesSettings = settings.listGlossariesSettings.toBuilder();
      createGlossaryCategorySettings = settings.createGlossaryCategorySettings.toBuilder();
      updateGlossaryCategorySettings = settings.updateGlossaryCategorySettings.toBuilder();
      deleteGlossaryCategorySettings = settings.deleteGlossaryCategorySettings.toBuilder();
      getGlossaryCategorySettings = settings.getGlossaryCategorySettings.toBuilder();
      listGlossaryCategoriesSettings = settings.listGlossaryCategoriesSettings.toBuilder();
      createGlossaryTermSettings = settings.createGlossaryTermSettings.toBuilder();
      updateGlossaryTermSettings = settings.updateGlossaryTermSettings.toBuilder();
      deleteGlossaryTermSettings = settings.deleteGlossaryTermSettings.toBuilder();
      getGlossaryTermSettings = settings.getGlossaryTermSettings.toBuilder();
      listGlossaryTermsSettings = settings.listGlossaryTermsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createGlossarySettings,
              updateGlossarySettings,
              deleteGlossarySettings,
              getGlossarySettings,
              listGlossariesSettings,
              createGlossaryCategorySettings,
              updateGlossaryCategorySettings,
              deleteGlossaryCategorySettings,
              getGlossaryCategorySettings,
              listGlossaryCategoriesSettings,
              createGlossaryTermSettings,
              updateGlossaryTermSettings,
              deleteGlossaryTermSettings,
              getGlossaryTermSettings,
              listGlossaryTermsSettings,
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
          .createGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGlossarySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listGlossariesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createGlossaryCategorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateGlossaryCategorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteGlossaryCategorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGlossaryCategorySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listGlossaryCategoriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createGlossaryTermSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateGlossaryTermSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteGlossaryTermSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGlossaryTermSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listGlossaryTermsSettings()
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
          .createGlossaryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGlossaryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Glossary.class))
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
          .updateGlossaryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGlossaryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Glossary.class))
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
          .deleteGlossaryOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGlossaryRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to createGlossary. */
    public UnaryCallSettings.Builder<CreateGlossaryRequest, Operation> createGlossarySettings() {
      return createGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to createGlossary. */
    public OperationCallSettings.Builder<CreateGlossaryRequest, Glossary, OperationMetadata>
        createGlossaryOperationSettings() {
      return createGlossaryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public UnaryCallSettings.Builder<UpdateGlossaryRequest, Operation> updateGlossarySettings() {
      return updateGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to updateGlossary. */
    public OperationCallSettings.Builder<UpdateGlossaryRequest, Glossary, OperationMetadata>
        updateGlossaryOperationSettings() {
      return updateGlossaryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public UnaryCallSettings.Builder<DeleteGlossaryRequest, Operation> deleteGlossarySettings() {
      return deleteGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossary. */
    public OperationCallSettings.Builder<DeleteGlossaryRequest, Empty, OperationMetadata>
        deleteGlossaryOperationSettings() {
      return deleteGlossaryOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getGlossary. */
    public UnaryCallSettings.Builder<GetGlossaryRequest, Glossary> getGlossarySettings() {
      return getGlossarySettings;
    }

    /** Returns the builder for the settings used for calls to listGlossaries. */
    public PagedCallSettings.Builder<
            ListGlossariesRequest, ListGlossariesResponse, ListGlossariesPagedResponse>
        listGlossariesSettings() {
      return listGlossariesSettings;
    }

    /** Returns the builder for the settings used for calls to createGlossaryCategory. */
    public UnaryCallSettings.Builder<CreateGlossaryCategoryRequest, GlossaryCategory>
        createGlossaryCategorySettings() {
      return createGlossaryCategorySettings;
    }

    /** Returns the builder for the settings used for calls to updateGlossaryCategory. */
    public UnaryCallSettings.Builder<UpdateGlossaryCategoryRequest, GlossaryCategory>
        updateGlossaryCategorySettings() {
      return updateGlossaryCategorySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossaryCategory. */
    public UnaryCallSettings.Builder<DeleteGlossaryCategoryRequest, Empty>
        deleteGlossaryCategorySettings() {
      return deleteGlossaryCategorySettings;
    }

    /** Returns the builder for the settings used for calls to getGlossaryCategory. */
    public UnaryCallSettings.Builder<GetGlossaryCategoryRequest, GlossaryCategory>
        getGlossaryCategorySettings() {
      return getGlossaryCategorySettings;
    }

    /** Returns the builder for the settings used for calls to listGlossaryCategories. */
    public PagedCallSettings.Builder<
            ListGlossaryCategoriesRequest,
            ListGlossaryCategoriesResponse,
            ListGlossaryCategoriesPagedResponse>
        listGlossaryCategoriesSettings() {
      return listGlossaryCategoriesSettings;
    }

    /** Returns the builder for the settings used for calls to createGlossaryTerm. */
    public UnaryCallSettings.Builder<CreateGlossaryTermRequest, GlossaryTerm>
        createGlossaryTermSettings() {
      return createGlossaryTermSettings;
    }

    /** Returns the builder for the settings used for calls to updateGlossaryTerm. */
    public UnaryCallSettings.Builder<UpdateGlossaryTermRequest, GlossaryTerm>
        updateGlossaryTermSettings() {
      return updateGlossaryTermSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGlossaryTerm. */
    public UnaryCallSettings.Builder<DeleteGlossaryTermRequest, Empty>
        deleteGlossaryTermSettings() {
      return deleteGlossaryTermSettings;
    }

    /** Returns the builder for the settings used for calls to getGlossaryTerm. */
    public UnaryCallSettings.Builder<GetGlossaryTermRequest, GlossaryTerm>
        getGlossaryTermSettings() {
      return getGlossaryTermSettings;
    }

    /** Returns the builder for the settings used for calls to listGlossaryTerms. */
    public PagedCallSettings.Builder<
            ListGlossaryTermsRequest, ListGlossaryTermsResponse, ListGlossaryTermsPagedResponse>
        listGlossaryTermsSettings() {
      return listGlossaryTermsSettings;
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
    public BusinessGlossaryServiceStubSettings build() throws IOException {
      return new BusinessGlossaryServiceStubSettings(this);
    }
  }
}
