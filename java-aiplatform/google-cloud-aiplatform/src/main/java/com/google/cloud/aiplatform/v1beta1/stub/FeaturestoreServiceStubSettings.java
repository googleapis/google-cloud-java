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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListEntityTypesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListFeaturesPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListFeaturestoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeaturestoreServiceClient.SearchFeaturesPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.BatchCreateFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.BatchReadFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.BatchReadFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.BatchReadFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.CreateEntityTypeOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateEntityTypeRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeaturestoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeaturestoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteEntityTypeRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.DeleteFeaturestoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.EntityType;
import com.google.cloud.aiplatform.v1beta1.ExportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ExportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.ExportFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.Feature;
import com.google.cloud.aiplatform.v1beta1.Featurestore;
import com.google.cloud.aiplatform.v1beta1.GetEntityTypeRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeaturestoreRequest;
import com.google.cloud.aiplatform.v1beta1.ImportFeatureValuesOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.ImportFeatureValuesRequest;
import com.google.cloud.aiplatform.v1beta1.ImportFeatureValuesResponse;
import com.google.cloud.aiplatform.v1beta1.ListEntityTypesRequest;
import com.google.cloud.aiplatform.v1beta1.ListEntityTypesResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeaturestoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeaturestoresResponse;
import com.google.cloud.aiplatform.v1beta1.SearchFeaturesRequest;
import com.google.cloud.aiplatform.v1beta1.SearchFeaturesResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateEntityTypeRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateFeaturestoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeaturestoreRequest;
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
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link FeaturestoreServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (aiplatform.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getFeaturestore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeaturestoreServiceStubSettings.Builder featurestoreServiceSettingsBuilder =
 *     FeaturestoreServiceStubSettings.newBuilder();
 * featurestoreServiceSettingsBuilder
 *     .getFeaturestoreSettings()
 *     .setRetrySettings(
 *         featurestoreServiceSettingsBuilder
 *             .getFeaturestoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FeaturestoreServiceStubSettings featurestoreServiceSettings =
 *     featurestoreServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeaturestoreServiceStubSettings extends StubSettings<FeaturestoreServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateFeaturestoreRequest, Operation> createFeaturestoreSettings;
  private final OperationCallSettings<
          CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
      createFeaturestoreOperationSettings;
  private final UnaryCallSettings<GetFeaturestoreRequest, Featurestore> getFeaturestoreSettings;
  private final PagedCallSettings<
          ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
      listFeaturestoresSettings;
  private final UnaryCallSettings<UpdateFeaturestoreRequest, Operation> updateFeaturestoreSettings;
  private final OperationCallSettings<
          UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
      updateFeaturestoreOperationSettings;
  private final UnaryCallSettings<DeleteFeaturestoreRequest, Operation> deleteFeaturestoreSettings;
  private final OperationCallSettings<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
      deleteFeaturestoreOperationSettings;
  private final UnaryCallSettings<CreateEntityTypeRequest, Operation> createEntityTypeSettings;
  private final OperationCallSettings<
          CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
      createEntityTypeOperationSettings;
  private final UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
  private final PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings;
  private final UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings;
  private final UnaryCallSettings<DeleteEntityTypeRequest, Operation> deleteEntityTypeSettings;
  private final OperationCallSettings<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
      deleteEntityTypeOperationSettings;
  private final UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings;
  private final OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings;
  private final UnaryCallSettings<BatchCreateFeaturesRequest, Operation>
      batchCreateFeaturesSettings;
  private final OperationCallSettings<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationSettings;
  private final UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings;
  private final PagedCallSettings<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings;
  private final UnaryCallSettings<UpdateFeatureRequest, Feature> updateFeatureSettings;
  private final UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings;
  private final OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings;
  private final UnaryCallSettings<ImportFeatureValuesRequest, Operation>
      importFeatureValuesSettings;
  private final OperationCallSettings<
          ImportFeatureValuesRequest,
          ImportFeatureValuesResponse,
          ImportFeatureValuesOperationMetadata>
      importFeatureValuesOperationSettings;
  private final UnaryCallSettings<BatchReadFeatureValuesRequest, Operation>
      batchReadFeatureValuesSettings;
  private final OperationCallSettings<
          BatchReadFeatureValuesRequest,
          BatchReadFeatureValuesResponse,
          BatchReadFeatureValuesOperationMetadata>
      batchReadFeatureValuesOperationSettings;
  private final UnaryCallSettings<ExportFeatureValuesRequest, Operation>
      exportFeatureValuesSettings;
  private final OperationCallSettings<
          ExportFeatureValuesRequest,
          ExportFeatureValuesResponse,
          ExportFeatureValuesOperationMetadata>
      exportFeatureValuesOperationSettings;
  private final UnaryCallSettings<DeleteFeatureValuesRequest, Operation>
      deleteFeatureValuesSettings;
  private final OperationCallSettings<
          DeleteFeatureValuesRequest,
          DeleteFeatureValuesResponse,
          DeleteFeatureValuesOperationMetadata>
      deleteFeatureValuesOperationSettings;
  private final PagedCallSettings<
          SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
      searchFeaturesSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListFeaturestoresRequest, ListFeaturestoresResponse, Featurestore>
      LIST_FEATURESTORES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeaturestoresRequest, ListFeaturestoresResponse, Featurestore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturestoresRequest injectToken(
                ListFeaturestoresRequest payload, String token) {
              return ListFeaturestoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeaturestoresRequest injectPageSize(
                ListFeaturestoresRequest payload, int pageSize) {
              return ListFeaturestoresRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeaturestoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturestoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Featurestore> extractResources(ListFeaturestoresResponse payload) {
              return payload.getFeaturestoresList() == null
                  ? ImmutableList.<Featurestore>of()
                  : payload.getFeaturestoresList();
            }
          };

  private static final PagedListDescriptor<
          ListEntityTypesRequest, ListEntityTypesResponse, EntityType>
      LIST_ENTITY_TYPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListEntityTypesRequest, ListEntityTypesResponse, EntityType>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEntityTypesRequest injectToken(
                ListEntityTypesRequest payload, String token) {
              return ListEntityTypesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEntityTypesRequest injectPageSize(
                ListEntityTypesRequest payload, int pageSize) {
              return ListEntityTypesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEntityTypesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEntityTypesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EntityType> extractResources(ListEntityTypesResponse payload) {
              return payload.getEntityTypesList() == null
                  ? ImmutableList.<EntityType>of()
                  : payload.getEntityTypesList();
            }
          };

  private static final PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>
      LIST_FEATURES_PAGE_STR_DESC =
          new PagedListDescriptor<ListFeaturesRequest, ListFeaturesResponse, Feature>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeaturesRequest injectToken(ListFeaturesRequest payload, String token) {
              return ListFeaturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeaturesRequest injectPageSize(ListFeaturesRequest payload, int pageSize) {
              return ListFeaturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeaturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeaturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feature> extractResources(ListFeaturesResponse payload) {
              return payload.getFeaturesList() == null
                  ? ImmutableList.<Feature>of()
                  : payload.getFeaturesList();
            }
          };

  private static final PagedListDescriptor<SearchFeaturesRequest, SearchFeaturesResponse, Feature>
      SEARCH_FEATURES_PAGE_STR_DESC =
          new PagedListDescriptor<SearchFeaturesRequest, SearchFeaturesResponse, Feature>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public SearchFeaturesRequest injectToken(SearchFeaturesRequest payload, String token) {
              return SearchFeaturesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public SearchFeaturesRequest injectPageSize(
                SearchFeaturesRequest payload, int pageSize) {
              return SearchFeaturesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(SearchFeaturesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(SearchFeaturesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Feature> extractResources(SearchFeaturesResponse payload) {
              return payload.getFeaturesList() == null
                  ? ImmutableList.<Feature>of()
                  : payload.getFeaturesList();
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
          ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
      LIST_FEATURESTORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturestoresRequest,
              ListFeaturestoresResponse,
              ListFeaturestoresPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturestoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeaturestoresRequest, ListFeaturestoresResponse> callable,
                ListFeaturestoresRequest request,
                ApiCallContext context,
                ApiFuture<ListFeaturestoresResponse> futureResponse) {
              PageContext<ListFeaturestoresRequest, ListFeaturestoresResponse, Featurestore>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURESTORES_PAGE_STR_DESC, request, context);
              return ListFeaturestoresPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      LIST_ENTITY_TYPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>() {
            @Override
            public ApiFuture<ListEntityTypesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse> callable,
                ListEntityTypesRequest request,
                ApiCallContext context,
                ApiFuture<ListEntityTypesResponse> futureResponse) {
              PageContext<ListEntityTypesRequest, ListEntityTypesResponse, EntityType> pageContext =
                  PageContext.create(callable, LIST_ENTITY_TYPES_PAGE_STR_DESC, request, context);
              return ListEntityTypesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      LIST_FEATURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>() {
            @Override
            public ApiFuture<ListFeaturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeaturesRequest, ListFeaturesResponse> callable,
                ListFeaturesRequest request,
                ApiCallContext context,
                ApiFuture<ListFeaturesResponse> futureResponse) {
              PageContext<ListFeaturesRequest, ListFeaturesResponse, Feature> pageContext =
                  PageContext.create(callable, LIST_FEATURES_PAGE_STR_DESC, request, context);
              return ListFeaturesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
      SEARCH_FEATURES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>() {
            @Override
            public ApiFuture<SearchFeaturesPagedResponse> getFuturePagedResponse(
                UnaryCallable<SearchFeaturesRequest, SearchFeaturesResponse> callable,
                SearchFeaturesRequest request,
                ApiCallContext context,
                ApiFuture<SearchFeaturesResponse> futureResponse) {
              PageContext<SearchFeaturesRequest, SearchFeaturesResponse, Feature> pageContext =
                  PageContext.create(callable, SEARCH_FEATURES_PAGE_STR_DESC, request, context);
              return SearchFeaturesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createFeaturestore. */
  public UnaryCallSettings<CreateFeaturestoreRequest, Operation> createFeaturestoreSettings() {
    return createFeaturestoreSettings;
  }

  /** Returns the object with the settings used for calls to createFeaturestore. */
  public OperationCallSettings<
          CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
      createFeaturestoreOperationSettings() {
    return createFeaturestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeaturestore. */
  public UnaryCallSettings<GetFeaturestoreRequest, Featurestore> getFeaturestoreSettings() {
    return getFeaturestoreSettings;
  }

  /** Returns the object with the settings used for calls to listFeaturestores. */
  public PagedCallSettings<
          ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
      listFeaturestoresSettings() {
    return listFeaturestoresSettings;
  }

  /** Returns the object with the settings used for calls to updateFeaturestore. */
  public UnaryCallSettings<UpdateFeaturestoreRequest, Operation> updateFeaturestoreSettings() {
    return updateFeaturestoreSettings;
  }

  /** Returns the object with the settings used for calls to updateFeaturestore. */
  public OperationCallSettings<
          UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
      updateFeaturestoreOperationSettings() {
    return updateFeaturestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeaturestore. */
  public UnaryCallSettings<DeleteFeaturestoreRequest, Operation> deleteFeaturestoreSettings() {
    return deleteFeaturestoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeaturestore. */
  public OperationCallSettings<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
      deleteFeaturestoreOperationSettings() {
    return deleteFeaturestoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public UnaryCallSettings<CreateEntityTypeRequest, Operation> createEntityTypeSettings() {
    return createEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to createEntityType. */
  public OperationCallSettings<
          CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
      createEntityTypeOperationSettings() {
    return createEntityTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEntityType. */
  public UnaryCallSettings<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
    return getEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to listEntityTypes. */
  public PagedCallSettings<
          ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
      listEntityTypesSettings() {
    return listEntityTypesSettings;
  }

  /** Returns the object with the settings used for calls to updateEntityType. */
  public UnaryCallSettings<UpdateEntityTypeRequest, EntityType> updateEntityTypeSettings() {
    return updateEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public UnaryCallSettings<DeleteEntityTypeRequest, Operation> deleteEntityTypeSettings() {
    return deleteEntityTypeSettings;
  }

  /** Returns the object with the settings used for calls to deleteEntityType. */
  public OperationCallSettings<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
      deleteEntityTypeOperationSettings() {
    return deleteEntityTypeOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public UnaryCallSettings<CreateFeatureRequest, Operation> createFeatureSettings() {
    return createFeatureSettings;
  }

  /** Returns the object with the settings used for calls to createFeature. */
  public OperationCallSettings<CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
      createFeatureOperationSettings() {
    return createFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public UnaryCallSettings<BatchCreateFeaturesRequest, Operation> batchCreateFeaturesSettings() {
    return batchCreateFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to batchCreateFeatures. */
  public OperationCallSettings<
          BatchCreateFeaturesRequest,
          BatchCreateFeaturesResponse,
          BatchCreateFeaturesOperationMetadata>
      batchCreateFeaturesOperationSettings() {
    return batchCreateFeaturesOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeature. */
  public UnaryCallSettings<GetFeatureRequest, Feature> getFeatureSettings() {
    return getFeatureSettings;
  }

  /** Returns the object with the settings used for calls to listFeatures. */
  public PagedCallSettings<ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
      listFeaturesSettings() {
    return listFeaturesSettings;
  }

  /** Returns the object with the settings used for calls to updateFeature. */
  public UnaryCallSettings<UpdateFeatureRequest, Feature> updateFeatureSettings() {
    return updateFeatureSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public UnaryCallSettings<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
    return deleteFeatureSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeature. */
  public OperationCallSettings<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOperationSettings() {
    return deleteFeatureOperationSettings;
  }

  /** Returns the object with the settings used for calls to importFeatureValues. */
  public UnaryCallSettings<ImportFeatureValuesRequest, Operation> importFeatureValuesSettings() {
    return importFeatureValuesSettings;
  }

  /** Returns the object with the settings used for calls to importFeatureValues. */
  public OperationCallSettings<
          ImportFeatureValuesRequest,
          ImportFeatureValuesResponse,
          ImportFeatureValuesOperationMetadata>
      importFeatureValuesOperationSettings() {
    return importFeatureValuesOperationSettings;
  }

  /** Returns the object with the settings used for calls to batchReadFeatureValues. */
  public UnaryCallSettings<BatchReadFeatureValuesRequest, Operation>
      batchReadFeatureValuesSettings() {
    return batchReadFeatureValuesSettings;
  }

  /** Returns the object with the settings used for calls to batchReadFeatureValues. */
  public OperationCallSettings<
          BatchReadFeatureValuesRequest,
          BatchReadFeatureValuesResponse,
          BatchReadFeatureValuesOperationMetadata>
      batchReadFeatureValuesOperationSettings() {
    return batchReadFeatureValuesOperationSettings;
  }

  /** Returns the object with the settings used for calls to exportFeatureValues. */
  public UnaryCallSettings<ExportFeatureValuesRequest, Operation> exportFeatureValuesSettings() {
    return exportFeatureValuesSettings;
  }

  /** Returns the object with the settings used for calls to exportFeatureValues. */
  public OperationCallSettings<
          ExportFeatureValuesRequest,
          ExportFeatureValuesResponse,
          ExportFeatureValuesOperationMetadata>
      exportFeatureValuesOperationSettings() {
    return exportFeatureValuesOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureValues. */
  public UnaryCallSettings<DeleteFeatureValuesRequest, Operation> deleteFeatureValuesSettings() {
    return deleteFeatureValuesSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureValues. */
  public OperationCallSettings<
          DeleteFeatureValuesRequest,
          DeleteFeatureValuesResponse,
          DeleteFeatureValuesOperationMetadata>
      deleteFeatureValuesOperationSettings() {
    return deleteFeatureValuesOperationSettings;
  }

  /** Returns the object with the settings used for calls to searchFeatures. */
  public PagedCallSettings<
          SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
      searchFeaturesSettings() {
    return searchFeaturesSettings;
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

  public FeaturestoreServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFeaturestoreServiceStub.create(this);
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
    return "aiplatform.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "aiplatform.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(FeaturestoreServiceStubSettings.class))
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

  protected FeaturestoreServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFeaturestoreSettings = settingsBuilder.createFeaturestoreSettings().build();
    createFeaturestoreOperationSettings =
        settingsBuilder.createFeaturestoreOperationSettings().build();
    getFeaturestoreSettings = settingsBuilder.getFeaturestoreSettings().build();
    listFeaturestoresSettings = settingsBuilder.listFeaturestoresSettings().build();
    updateFeaturestoreSettings = settingsBuilder.updateFeaturestoreSettings().build();
    updateFeaturestoreOperationSettings =
        settingsBuilder.updateFeaturestoreOperationSettings().build();
    deleteFeaturestoreSettings = settingsBuilder.deleteFeaturestoreSettings().build();
    deleteFeaturestoreOperationSettings =
        settingsBuilder.deleteFeaturestoreOperationSettings().build();
    createEntityTypeSettings = settingsBuilder.createEntityTypeSettings().build();
    createEntityTypeOperationSettings = settingsBuilder.createEntityTypeOperationSettings().build();
    getEntityTypeSettings = settingsBuilder.getEntityTypeSettings().build();
    listEntityTypesSettings = settingsBuilder.listEntityTypesSettings().build();
    updateEntityTypeSettings = settingsBuilder.updateEntityTypeSettings().build();
    deleteEntityTypeSettings = settingsBuilder.deleteEntityTypeSettings().build();
    deleteEntityTypeOperationSettings = settingsBuilder.deleteEntityTypeOperationSettings().build();
    createFeatureSettings = settingsBuilder.createFeatureSettings().build();
    createFeatureOperationSettings = settingsBuilder.createFeatureOperationSettings().build();
    batchCreateFeaturesSettings = settingsBuilder.batchCreateFeaturesSettings().build();
    batchCreateFeaturesOperationSettings =
        settingsBuilder.batchCreateFeaturesOperationSettings().build();
    getFeatureSettings = settingsBuilder.getFeatureSettings().build();
    listFeaturesSettings = settingsBuilder.listFeaturesSettings().build();
    updateFeatureSettings = settingsBuilder.updateFeatureSettings().build();
    deleteFeatureSettings = settingsBuilder.deleteFeatureSettings().build();
    deleteFeatureOperationSettings = settingsBuilder.deleteFeatureOperationSettings().build();
    importFeatureValuesSettings = settingsBuilder.importFeatureValuesSettings().build();
    importFeatureValuesOperationSettings =
        settingsBuilder.importFeatureValuesOperationSettings().build();
    batchReadFeatureValuesSettings = settingsBuilder.batchReadFeatureValuesSettings().build();
    batchReadFeatureValuesOperationSettings =
        settingsBuilder.batchReadFeatureValuesOperationSettings().build();
    exportFeatureValuesSettings = settingsBuilder.exportFeatureValuesSettings().build();
    exportFeatureValuesOperationSettings =
        settingsBuilder.exportFeatureValuesOperationSettings().build();
    deleteFeatureValuesSettings = settingsBuilder.deleteFeatureValuesSettings().build();
    deleteFeatureValuesOperationSettings =
        settingsBuilder.deleteFeatureValuesOperationSettings().build();
    searchFeaturesSettings = settingsBuilder.searchFeaturesSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for FeaturestoreServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FeaturestoreServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFeaturestoreRequest, Operation>
        createFeaturestoreSettings;
    private final OperationCallSettings.Builder<
            CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
        createFeaturestoreOperationSettings;
    private final UnaryCallSettings.Builder<GetFeaturestoreRequest, Featurestore>
        getFeaturestoreSettings;
    private final PagedCallSettings.Builder<
            ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
        listFeaturestoresSettings;
    private final UnaryCallSettings.Builder<UpdateFeaturestoreRequest, Operation>
        updateFeaturestoreSettings;
    private final OperationCallSettings.Builder<
            UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
        updateFeaturestoreOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeaturestoreRequest, Operation>
        deleteFeaturestoreSettings;
    private final OperationCallSettings.Builder<
            DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
        deleteFeaturestoreOperationSettings;
    private final UnaryCallSettings.Builder<CreateEntityTypeRequest, Operation>
        createEntityTypeSettings;
    private final OperationCallSettings.Builder<
            CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
        createEntityTypeOperationSettings;
    private final UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings;
    private final PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings;
    private final UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings;
    private final UnaryCallSettings.Builder<DeleteEntityTypeRequest, Operation>
        deleteEntityTypeSettings;
    private final OperationCallSettings.Builder<
            DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
        deleteEntityTypeOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings;
    private final UnaryCallSettings.Builder<BatchCreateFeaturesRequest, Operation>
        batchCreateFeaturesSettings;
    private final OperationCallSettings.Builder<
            BatchCreateFeaturesRequest,
            BatchCreateFeaturesResponse,
            BatchCreateFeaturesOperationMetadata>
        batchCreateFeaturesOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings;
    private final PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureRequest, Feature> updateFeatureSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings;
    private final UnaryCallSettings.Builder<ImportFeatureValuesRequest, Operation>
        importFeatureValuesSettings;
    private final OperationCallSettings.Builder<
            ImportFeatureValuesRequest,
            ImportFeatureValuesResponse,
            ImportFeatureValuesOperationMetadata>
        importFeatureValuesOperationSettings;
    private final UnaryCallSettings.Builder<BatchReadFeatureValuesRequest, Operation>
        batchReadFeatureValuesSettings;
    private final OperationCallSettings.Builder<
            BatchReadFeatureValuesRequest,
            BatchReadFeatureValuesResponse,
            BatchReadFeatureValuesOperationMetadata>
        batchReadFeatureValuesOperationSettings;
    private final UnaryCallSettings.Builder<ExportFeatureValuesRequest, Operation>
        exportFeatureValuesSettings;
    private final OperationCallSettings.Builder<
            ExportFeatureValuesRequest,
            ExportFeatureValuesResponse,
            ExportFeatureValuesOperationMetadata>
        exportFeatureValuesOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureValuesRequest, Operation>
        deleteFeatureValuesSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureValuesRequest,
            DeleteFeatureValuesResponse,
            DeleteFeatureValuesOperationMetadata>
        deleteFeatureValuesOperationSettings;
    private final PagedCallSettings.Builder<
            SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
        searchFeaturesSettings;
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
      definitions.put(
          "no_retry_12_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(5000L))
              .setTotalTimeout(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_12_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createFeaturestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeaturestoreOperationSettings = OperationCallSettings.newBuilder();
      getFeaturestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeaturestoresSettings = PagedCallSettings.newBuilder(LIST_FEATURESTORES_PAGE_STR_FACT);
      updateFeaturestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeaturestoreOperationSettings = OperationCallSettings.newBuilder();
      deleteFeaturestoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeaturestoreOperationSettings = OperationCallSettings.newBuilder();
      createEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEntityTypeOperationSettings = OperationCallSettings.newBuilder();
      getEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEntityTypesSettings = PagedCallSettings.newBuilder(LIST_ENTITY_TYPES_PAGE_STR_FACT);
      updateEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntityTypeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEntityTypeOperationSettings = OperationCallSettings.newBuilder();
      createFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureOperationSettings = OperationCallSettings.newBuilder();
      batchCreateFeaturesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchCreateFeaturesOperationSettings = OperationCallSettings.newBuilder();
      getFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeaturesSettings = PagedCallSettings.newBuilder(LIST_FEATURES_PAGE_STR_FACT);
      updateFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureOperationSettings = OperationCallSettings.newBuilder();
      importFeatureValuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      importFeatureValuesOperationSettings = OperationCallSettings.newBuilder();
      batchReadFeatureValuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      batchReadFeatureValuesOperationSettings = OperationCallSettings.newBuilder();
      exportFeatureValuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      exportFeatureValuesOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureValuesSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureValuesOperationSettings = OperationCallSettings.newBuilder();
      searchFeaturesSettings = PagedCallSettings.newBuilder(SEARCH_FEATURES_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeaturestoreSettings,
              getFeaturestoreSettings,
              listFeaturestoresSettings,
              updateFeaturestoreSettings,
              deleteFeaturestoreSettings,
              createEntityTypeSettings,
              getEntityTypeSettings,
              listEntityTypesSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings,
              createFeatureSettings,
              batchCreateFeaturesSettings,
              getFeatureSettings,
              listFeaturesSettings,
              updateFeatureSettings,
              deleteFeatureSettings,
              importFeatureValuesSettings,
              batchReadFeatureValuesSettings,
              exportFeatureValuesSettings,
              deleteFeatureValuesSettings,
              searchFeaturesSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FeaturestoreServiceStubSettings settings) {
      super(settings);

      createFeaturestoreSettings = settings.createFeaturestoreSettings.toBuilder();
      createFeaturestoreOperationSettings =
          settings.createFeaturestoreOperationSettings.toBuilder();
      getFeaturestoreSettings = settings.getFeaturestoreSettings.toBuilder();
      listFeaturestoresSettings = settings.listFeaturestoresSettings.toBuilder();
      updateFeaturestoreSettings = settings.updateFeaturestoreSettings.toBuilder();
      updateFeaturestoreOperationSettings =
          settings.updateFeaturestoreOperationSettings.toBuilder();
      deleteFeaturestoreSettings = settings.deleteFeaturestoreSettings.toBuilder();
      deleteFeaturestoreOperationSettings =
          settings.deleteFeaturestoreOperationSettings.toBuilder();
      createEntityTypeSettings = settings.createEntityTypeSettings.toBuilder();
      createEntityTypeOperationSettings = settings.createEntityTypeOperationSettings.toBuilder();
      getEntityTypeSettings = settings.getEntityTypeSettings.toBuilder();
      listEntityTypesSettings = settings.listEntityTypesSettings.toBuilder();
      updateEntityTypeSettings = settings.updateEntityTypeSettings.toBuilder();
      deleteEntityTypeSettings = settings.deleteEntityTypeSettings.toBuilder();
      deleteEntityTypeOperationSettings = settings.deleteEntityTypeOperationSettings.toBuilder();
      createFeatureSettings = settings.createFeatureSettings.toBuilder();
      createFeatureOperationSettings = settings.createFeatureOperationSettings.toBuilder();
      batchCreateFeaturesSettings = settings.batchCreateFeaturesSettings.toBuilder();
      batchCreateFeaturesOperationSettings =
          settings.batchCreateFeaturesOperationSettings.toBuilder();
      getFeatureSettings = settings.getFeatureSettings.toBuilder();
      listFeaturesSettings = settings.listFeaturesSettings.toBuilder();
      updateFeatureSettings = settings.updateFeatureSettings.toBuilder();
      deleteFeatureSettings = settings.deleteFeatureSettings.toBuilder();
      deleteFeatureOperationSettings = settings.deleteFeatureOperationSettings.toBuilder();
      importFeatureValuesSettings = settings.importFeatureValuesSettings.toBuilder();
      importFeatureValuesOperationSettings =
          settings.importFeatureValuesOperationSettings.toBuilder();
      batchReadFeatureValuesSettings = settings.batchReadFeatureValuesSettings.toBuilder();
      batchReadFeatureValuesOperationSettings =
          settings.batchReadFeatureValuesOperationSettings.toBuilder();
      exportFeatureValuesSettings = settings.exportFeatureValuesSettings.toBuilder();
      exportFeatureValuesOperationSettings =
          settings.exportFeatureValuesOperationSettings.toBuilder();
      deleteFeatureValuesSettings = settings.deleteFeatureValuesSettings.toBuilder();
      deleteFeatureValuesOperationSettings =
          settings.deleteFeatureValuesOperationSettings.toBuilder();
      searchFeaturesSettings = settings.searchFeaturesSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeaturestoreSettings,
              getFeaturestoreSettings,
              listFeaturestoresSettings,
              updateFeaturestoreSettings,
              deleteFeaturestoreSettings,
              createEntityTypeSettings,
              getEntityTypeSettings,
              listEntityTypesSettings,
              updateEntityTypeSettings,
              deleteEntityTypeSettings,
              createFeatureSettings,
              batchCreateFeaturesSettings,
              getFeatureSettings,
              listFeaturesSettings,
              updateFeatureSettings,
              deleteFeatureSettings,
              importFeatureValuesSettings,
              batchReadFeatureValuesSettings,
              exportFeatureValuesSettings,
              deleteFeatureValuesSettings,
              searchFeaturesSettings,
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
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createFeaturestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .getFeaturestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .listFeaturestoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .updateFeaturestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .deleteFeaturestoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .createEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .getEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .listEntityTypesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .updateEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .deleteEntityTypeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .createFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .batchCreateFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .getFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .listFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .updateFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .deleteFeatureSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .importFeatureValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .batchReadFeatureValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

      builder
          .exportFeatureValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteFeatureValuesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .searchFeaturesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"));

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
          .createFeaturestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeaturestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Featurestore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeaturestoreOperationMetadata.class))
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
          .updateFeaturestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeaturestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Featurestore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateFeaturestoreOperationMetadata.class))
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
          .deleteFeaturestoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeaturestoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .createEntityTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEntityTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EntityType.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateEntityTypeOperationMetadata.class))
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
          .deleteEntityTypeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEntityTypeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .createFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Feature.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureOperationMetadata.class))
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
          .batchCreateFeaturesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchCreateFeaturesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchCreateFeaturesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchCreateFeaturesOperationMetadata.class))
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
          .deleteFeatureOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(DeleteOperationMetadata.class))
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
          .importFeatureValuesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ImportFeatureValuesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ImportFeatureValuesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ImportFeatureValuesOperationMetadata.class))
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
          .batchReadFeatureValuesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<BatchReadFeatureValuesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_12_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_12_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  BatchReadFeatureValuesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  BatchReadFeatureValuesOperationMetadata.class))
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
          .exportFeatureValuesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<ExportFeatureValuesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  ExportFeatureValuesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  ExportFeatureValuesOperationMetadata.class))
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
          .deleteFeatureValuesOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureValuesRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  DeleteFeatureValuesResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  DeleteFeatureValuesOperationMetadata.class))
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

    /** Returns the builder for the settings used for calls to createFeaturestore. */
    public UnaryCallSettings.Builder<CreateFeaturestoreRequest, Operation>
        createFeaturestoreSettings() {
      return createFeaturestoreSettings;
    }

    /** Returns the builder for the settings used for calls to createFeaturestore. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateFeaturestoreRequest, Featurestore, CreateFeaturestoreOperationMetadata>
        createFeaturestoreOperationSettings() {
      return createFeaturestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeaturestore. */
    public UnaryCallSettings.Builder<GetFeaturestoreRequest, Featurestore>
        getFeaturestoreSettings() {
      return getFeaturestoreSettings;
    }

    /** Returns the builder for the settings used for calls to listFeaturestores. */
    public PagedCallSettings.Builder<
            ListFeaturestoresRequest, ListFeaturestoresResponse, ListFeaturestoresPagedResponse>
        listFeaturestoresSettings() {
      return listFeaturestoresSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeaturestore. */
    public UnaryCallSettings.Builder<UpdateFeaturestoreRequest, Operation>
        updateFeaturestoreSettings() {
      return updateFeaturestoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeaturestore. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateFeaturestoreRequest, Featurestore, UpdateFeaturestoreOperationMetadata>
        updateFeaturestoreOperationSettings() {
      return updateFeaturestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeaturestore. */
    public UnaryCallSettings.Builder<DeleteFeaturestoreRequest, Operation>
        deleteFeaturestoreSettings() {
      return deleteFeaturestoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeaturestore. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFeaturestoreRequest, Empty, DeleteOperationMetadata>
        deleteFeaturestoreOperationSettings() {
      return deleteFeaturestoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    public UnaryCallSettings.Builder<CreateEntityTypeRequest, Operation>
        createEntityTypeSettings() {
      return createEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to createEntityType. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateEntityTypeRequest, EntityType, CreateEntityTypeOperationMetadata>
        createEntityTypeOperationSettings() {
      return createEntityTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEntityType. */
    public UnaryCallSettings.Builder<GetEntityTypeRequest, EntityType> getEntityTypeSettings() {
      return getEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to listEntityTypes. */
    public PagedCallSettings.Builder<
            ListEntityTypesRequest, ListEntityTypesResponse, ListEntityTypesPagedResponse>
        listEntityTypesSettings() {
      return listEntityTypesSettings;
    }

    /** Returns the builder for the settings used for calls to updateEntityType. */
    public UnaryCallSettings.Builder<UpdateEntityTypeRequest, EntityType>
        updateEntityTypeSettings() {
      return updateEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    public UnaryCallSettings.Builder<DeleteEntityTypeRequest, Operation>
        deleteEntityTypeSettings() {
      return deleteEntityTypeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEntityType. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteEntityTypeRequest, Empty, DeleteOperationMetadata>
        deleteEntityTypeOperationSettings() {
      return deleteEntityTypeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    public UnaryCallSettings.Builder<CreateFeatureRequest, Operation> createFeatureSettings() {
      return createFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to createFeature. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateFeatureRequest, Feature, CreateFeatureOperationMetadata>
        createFeatureOperationSettings() {
      return createFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    public UnaryCallSettings.Builder<BatchCreateFeaturesRequest, Operation>
        batchCreateFeaturesSettings() {
      return batchCreateFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to batchCreateFeatures. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchCreateFeaturesRequest,
            BatchCreateFeaturesResponse,
            BatchCreateFeaturesOperationMetadata>
        batchCreateFeaturesOperationSettings() {
      return batchCreateFeaturesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeature. */
    public UnaryCallSettings.Builder<GetFeatureRequest, Feature> getFeatureSettings() {
      return getFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatures. */
    public PagedCallSettings.Builder<
            ListFeaturesRequest, ListFeaturesResponse, ListFeaturesPagedResponse>
        listFeaturesSettings() {
      return listFeaturesSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeature. */
    public UnaryCallSettings.Builder<UpdateFeatureRequest, Feature> updateFeatureSettings() {
      return updateFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    public UnaryCallSettings.Builder<DeleteFeatureRequest, Operation> deleteFeatureSettings() {
      return deleteFeatureSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeature. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteFeatureRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOperationSettings() {
      return deleteFeatureOperationSettings;
    }

    /** Returns the builder for the settings used for calls to importFeatureValues. */
    public UnaryCallSettings.Builder<ImportFeatureValuesRequest, Operation>
        importFeatureValuesSettings() {
      return importFeatureValuesSettings;
    }

    /** Returns the builder for the settings used for calls to importFeatureValues. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ImportFeatureValuesRequest,
            ImportFeatureValuesResponse,
            ImportFeatureValuesOperationMetadata>
        importFeatureValuesOperationSettings() {
      return importFeatureValuesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to batchReadFeatureValues. */
    public UnaryCallSettings.Builder<BatchReadFeatureValuesRequest, Operation>
        batchReadFeatureValuesSettings() {
      return batchReadFeatureValuesSettings;
    }

    /** Returns the builder for the settings used for calls to batchReadFeatureValues. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            BatchReadFeatureValuesRequest,
            BatchReadFeatureValuesResponse,
            BatchReadFeatureValuesOperationMetadata>
        batchReadFeatureValuesOperationSettings() {
      return batchReadFeatureValuesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to exportFeatureValues. */
    public UnaryCallSettings.Builder<ExportFeatureValuesRequest, Operation>
        exportFeatureValuesSettings() {
      return exportFeatureValuesSettings;
    }

    /** Returns the builder for the settings used for calls to exportFeatureValues. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            ExportFeatureValuesRequest,
            ExportFeatureValuesResponse,
            ExportFeatureValuesOperationMetadata>
        exportFeatureValuesOperationSettings() {
      return exportFeatureValuesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureValues. */
    public UnaryCallSettings.Builder<DeleteFeatureValuesRequest, Operation>
        deleteFeatureValuesSettings() {
      return deleteFeatureValuesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureValues. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteFeatureValuesRequest,
            DeleteFeatureValuesResponse,
            DeleteFeatureValuesOperationMetadata>
        deleteFeatureValuesOperationSettings() {
      return deleteFeatureValuesOperationSettings;
    }

    /** Returns the builder for the settings used for calls to searchFeatures. */
    public PagedCallSettings.Builder<
            SearchFeaturesRequest, SearchFeaturesResponse, SearchFeaturesPagedResponse>
        searchFeaturesSettings() {
      return searchFeaturesSettings;
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
    public FeaturestoreServiceStubSettings build() throws IOException {
      return new FeaturestoreServiceStubSettings(this);
    }
  }
}
