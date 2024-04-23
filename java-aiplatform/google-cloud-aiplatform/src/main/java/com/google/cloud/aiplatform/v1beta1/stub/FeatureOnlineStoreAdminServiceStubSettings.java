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

package com.google.cloud.aiplatform.v1beta1.stub;

import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureOnlineStoresPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewSyncsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListFeatureViewsPagedResponse;
import static com.google.cloud.aiplatform.v1beta1.FeatureOnlineStoreAdminServiceClient.ListLocationsPagedResponse;

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
import com.google.cloud.aiplatform.v1beta1.CreateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.CreateFeatureViewRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteFeatureViewRequest;
import com.google.cloud.aiplatform.v1beta1.DeleteOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.FeatureOnlineStore;
import com.google.cloud.aiplatform.v1beta1.FeatureView;
import com.google.cloud.aiplatform.v1beta1.FeatureViewSync;
import com.google.cloud.aiplatform.v1beta1.GetFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureViewRequest;
import com.google.cloud.aiplatform.v1beta1.GetFeatureViewSyncRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureOnlineStoresRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureOnlineStoresResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeatureViewSyncsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureViewSyncsResponse;
import com.google.cloud.aiplatform.v1beta1.ListFeatureViewsRequest;
import com.google.cloud.aiplatform.v1beta1.ListFeatureViewsResponse;
import com.google.cloud.aiplatform.v1beta1.SyncFeatureViewRequest;
import com.google.cloud.aiplatform.v1beta1.SyncFeatureViewResponse;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureOnlineStoreOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureOnlineStoreRequest;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureViewOperationMetadata;
import com.google.cloud.aiplatform.v1beta1.UpdateFeatureViewRequest;
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
 * Settings class to configure an instance of {@link FeatureOnlineStoreAdminServiceStub}.
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
 * <p>For example, to set the total timeout of getFeatureOnlineStore to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeatureOnlineStoreAdminServiceStubSettings.Builder
 *     featureOnlineStoreAdminServiceSettingsBuilder =
 *         FeatureOnlineStoreAdminServiceStubSettings.newBuilder();
 * featureOnlineStoreAdminServiceSettingsBuilder
 *     .getFeatureOnlineStoreSettings()
 *     .setRetrySettings(
 *         featureOnlineStoreAdminServiceSettingsBuilder
 *             .getFeatureOnlineStoreSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * FeatureOnlineStoreAdminServiceStubSettings featureOnlineStoreAdminServiceSettings =
 *     featureOnlineStoreAdminServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FeatureOnlineStoreAdminServiceStubSettings
    extends StubSettings<FeatureOnlineStoreAdminServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreSettings;
  private final OperationCallSettings<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationSettings;
  private final UnaryCallSettings<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreSettings;
  private final PagedCallSettings<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresSettings;
  private final UnaryCallSettings<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreSettings;
  private final OperationCallSettings<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationSettings;
  private final UnaryCallSettings<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreSettings;
  private final OperationCallSettings<
          DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationSettings;
  private final UnaryCallSettings<CreateFeatureViewRequest, Operation> createFeatureViewSettings;
  private final OperationCallSettings<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationSettings;
  private final UnaryCallSettings<GetFeatureViewRequest, FeatureView> getFeatureViewSettings;
  private final PagedCallSettings<
          ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
      listFeatureViewsSettings;
  private final UnaryCallSettings<UpdateFeatureViewRequest, Operation> updateFeatureViewSettings;
  private final OperationCallSettings<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationSettings;
  private final UnaryCallSettings<DeleteFeatureViewRequest, Operation> deleteFeatureViewSettings;
  private final OperationCallSettings<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationSettings;
  private final UnaryCallSettings<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewSettings;
  private final UnaryCallSettings<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncSettings;
  private final PagedCallSettings<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse, FeatureOnlineStore>
      LIST_FEATURE_ONLINE_STORES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureOnlineStoresRequest,
              ListFeatureOnlineStoresResponse,
              FeatureOnlineStore>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureOnlineStoresRequest injectToken(
                ListFeatureOnlineStoresRequest payload, String token) {
              return ListFeatureOnlineStoresRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureOnlineStoresRequest injectPageSize(
                ListFeatureOnlineStoresRequest payload, int pageSize) {
              return ListFeatureOnlineStoresRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListFeatureOnlineStoresRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureOnlineStoresResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureOnlineStore> extractResources(
                ListFeatureOnlineStoresResponse payload) {
              return payload.getFeatureOnlineStoresList() == null
                  ? ImmutableList.<FeatureOnlineStore>of()
                  : payload.getFeatureOnlineStoresList();
            }
          };

  private static final PagedListDescriptor<
          ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView>
      LIST_FEATURE_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureViewsRequest injectToken(
                ListFeatureViewsRequest payload, String token) {
              return ListFeatureViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureViewsRequest injectPageSize(
                ListFeatureViewsRequest payload, int pageSize) {
              return ListFeatureViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeatureViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureView> extractResources(ListFeatureViewsResponse payload) {
              return payload.getFeatureViewsList() == null
                  ? ImmutableList.<FeatureView>of()
                  : payload.getFeatureViewsList();
            }
          };

  private static final PagedListDescriptor<
          ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
      LIST_FEATURE_VIEW_SYNCS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListFeatureViewSyncsRequest injectToken(
                ListFeatureViewSyncsRequest payload, String token) {
              return ListFeatureViewSyncsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListFeatureViewSyncsRequest injectPageSize(
                ListFeatureViewSyncsRequest payload, int pageSize) {
              return ListFeatureViewSyncsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListFeatureViewSyncsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListFeatureViewSyncsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<FeatureViewSync> extractResources(
                ListFeatureViewSyncsResponse payload) {
              return payload.getFeatureViewSyncsList() == null
                  ? ImmutableList.<FeatureViewSync>of()
                  : payload.getFeatureViewSyncsList();
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
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          ListFeatureOnlineStoresPagedResponse>
      LIST_FEATURE_ONLINE_STORES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureOnlineStoresRequest,
              ListFeatureOnlineStoresResponse,
              ListFeatureOnlineStoresPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureOnlineStoresPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureOnlineStoresRequest, ListFeatureOnlineStoresResponse>
                    callable,
                ListFeatureOnlineStoresRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureOnlineStoresResponse> futureResponse) {
              PageContext<
                      ListFeatureOnlineStoresRequest,
                      ListFeatureOnlineStoresResponse,
                      FeatureOnlineStore>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_ONLINE_STORES_PAGE_STR_DESC, request, context);
              return ListFeatureOnlineStoresPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
      LIST_FEATURE_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureViewsRequest, ListFeatureViewsResponse> callable,
                ListFeatureViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureViewsResponse> futureResponse) {
              PageContext<ListFeatureViewsRequest, ListFeatureViewsResponse, FeatureView>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_VIEWS_PAGE_STR_DESC, request, context);
              return ListFeatureViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          ListFeatureViewSyncsPagedResponse>
      LIST_FEATURE_VIEW_SYNCS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListFeatureViewSyncsRequest,
              ListFeatureViewSyncsResponse,
              ListFeatureViewSyncsPagedResponse>() {
            @Override
            public ApiFuture<ListFeatureViewSyncsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse> callable,
                ListFeatureViewSyncsRequest request,
                ApiCallContext context,
                ApiFuture<ListFeatureViewSyncsResponse> futureResponse) {
              PageContext<
                      ListFeatureViewSyncsRequest, ListFeatureViewSyncsResponse, FeatureViewSync>
                  pageContext =
                      PageContext.create(
                          callable, LIST_FEATURE_VIEW_SYNCS_PAGE_STR_DESC, request, context);
              return ListFeatureViewSyncsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createFeatureOnlineStore. */
  public UnaryCallSettings<CreateFeatureOnlineStoreRequest, Operation>
      createFeatureOnlineStoreSettings() {
    return createFeatureOnlineStoreSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureOnlineStore. */
  public OperationCallSettings<
          CreateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          CreateFeatureOnlineStoreOperationMetadata>
      createFeatureOnlineStoreOperationSettings() {
    return createFeatureOnlineStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureOnlineStore. */
  public UnaryCallSettings<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
      getFeatureOnlineStoreSettings() {
    return getFeatureOnlineStoreSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureOnlineStores. */
  public PagedCallSettings<
          ListFeatureOnlineStoresRequest,
          ListFeatureOnlineStoresResponse,
          ListFeatureOnlineStoresPagedResponse>
      listFeatureOnlineStoresSettings() {
    return listFeatureOnlineStoresSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureOnlineStore. */
  public UnaryCallSettings<UpdateFeatureOnlineStoreRequest, Operation>
      updateFeatureOnlineStoreSettings() {
    return updateFeatureOnlineStoreSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureOnlineStore. */
  public OperationCallSettings<
          UpdateFeatureOnlineStoreRequest,
          FeatureOnlineStore,
          UpdateFeatureOnlineStoreOperationMetadata>
      updateFeatureOnlineStoreOperationSettings() {
    return updateFeatureOnlineStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureOnlineStore. */
  public UnaryCallSettings<DeleteFeatureOnlineStoreRequest, Operation>
      deleteFeatureOnlineStoreSettings() {
    return deleteFeatureOnlineStoreSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureOnlineStore. */
  public OperationCallSettings<DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
      deleteFeatureOnlineStoreOperationSettings() {
    return deleteFeatureOnlineStoreOperationSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureView. */
  public UnaryCallSettings<CreateFeatureViewRequest, Operation> createFeatureViewSettings() {
    return createFeatureViewSettings;
  }

  /** Returns the object with the settings used for calls to createFeatureView. */
  public OperationCallSettings<
          CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
      createFeatureViewOperationSettings() {
    return createFeatureViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureView. */
  public UnaryCallSettings<GetFeatureViewRequest, FeatureView> getFeatureViewSettings() {
    return getFeatureViewSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureViews. */
  public PagedCallSettings<
          ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
      listFeatureViewsSettings() {
    return listFeatureViewsSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureView. */
  public UnaryCallSettings<UpdateFeatureViewRequest, Operation> updateFeatureViewSettings() {
    return updateFeatureViewSettings;
  }

  /** Returns the object with the settings used for calls to updateFeatureView. */
  public OperationCallSettings<
          UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
      updateFeatureViewOperationSettings() {
    return updateFeatureViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureView. */
  public UnaryCallSettings<DeleteFeatureViewRequest, Operation> deleteFeatureViewSettings() {
    return deleteFeatureViewSettings;
  }

  /** Returns the object with the settings used for calls to deleteFeatureView. */
  public OperationCallSettings<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
      deleteFeatureViewOperationSettings() {
    return deleteFeatureViewOperationSettings;
  }

  /** Returns the object with the settings used for calls to syncFeatureView. */
  public UnaryCallSettings<SyncFeatureViewRequest, SyncFeatureViewResponse>
      syncFeatureViewSettings() {
    return syncFeatureViewSettings;
  }

  /** Returns the object with the settings used for calls to getFeatureViewSync. */
  public UnaryCallSettings<GetFeatureViewSyncRequest, FeatureViewSync>
      getFeatureViewSyncSettings() {
    return getFeatureViewSyncSettings;
  }

  /** Returns the object with the settings used for calls to listFeatureViewSyncs. */
  public PagedCallSettings<
          ListFeatureViewSyncsRequest,
          ListFeatureViewSyncsResponse,
          ListFeatureViewSyncsPagedResponse>
      listFeatureViewSyncsSettings() {
    return listFeatureViewSyncsSettings;
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

  public FeatureOnlineStoreAdminServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcFeatureOnlineStoreAdminServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "aiplatform";
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

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic",
            GaxProperties.getLibraryVersion(FeatureOnlineStoreAdminServiceStubSettings.class))
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

  protected FeatureOnlineStoreAdminServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createFeatureOnlineStoreSettings = settingsBuilder.createFeatureOnlineStoreSettings().build();
    createFeatureOnlineStoreOperationSettings =
        settingsBuilder.createFeatureOnlineStoreOperationSettings().build();
    getFeatureOnlineStoreSettings = settingsBuilder.getFeatureOnlineStoreSettings().build();
    listFeatureOnlineStoresSettings = settingsBuilder.listFeatureOnlineStoresSettings().build();
    updateFeatureOnlineStoreSettings = settingsBuilder.updateFeatureOnlineStoreSettings().build();
    updateFeatureOnlineStoreOperationSettings =
        settingsBuilder.updateFeatureOnlineStoreOperationSettings().build();
    deleteFeatureOnlineStoreSettings = settingsBuilder.deleteFeatureOnlineStoreSettings().build();
    deleteFeatureOnlineStoreOperationSettings =
        settingsBuilder.deleteFeatureOnlineStoreOperationSettings().build();
    createFeatureViewSettings = settingsBuilder.createFeatureViewSettings().build();
    createFeatureViewOperationSettings =
        settingsBuilder.createFeatureViewOperationSettings().build();
    getFeatureViewSettings = settingsBuilder.getFeatureViewSettings().build();
    listFeatureViewsSettings = settingsBuilder.listFeatureViewsSettings().build();
    updateFeatureViewSettings = settingsBuilder.updateFeatureViewSettings().build();
    updateFeatureViewOperationSettings =
        settingsBuilder.updateFeatureViewOperationSettings().build();
    deleteFeatureViewSettings = settingsBuilder.deleteFeatureViewSettings().build();
    deleteFeatureViewOperationSettings =
        settingsBuilder.deleteFeatureViewOperationSettings().build();
    syncFeatureViewSettings = settingsBuilder.syncFeatureViewSettings().build();
    getFeatureViewSyncSettings = settingsBuilder.getFeatureViewSyncSettings().build();
    listFeatureViewSyncsSettings = settingsBuilder.listFeatureViewSyncsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for FeatureOnlineStoreAdminServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<FeatureOnlineStoreAdminServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateFeatureOnlineStoreRequest, Operation>
        createFeatureOnlineStoreSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            CreateFeatureOnlineStoreOperationMetadata>
        createFeatureOnlineStoreOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
        getFeatureOnlineStoreSettings;
    private final PagedCallSettings.Builder<
            ListFeatureOnlineStoresRequest,
            ListFeatureOnlineStoresResponse,
            ListFeatureOnlineStoresPagedResponse>
        listFeatureOnlineStoresSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureOnlineStoreRequest, Operation>
        updateFeatureOnlineStoreSettings;
    private final OperationCallSettings.Builder<
            UpdateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            UpdateFeatureOnlineStoreOperationMetadata>
        updateFeatureOnlineStoreOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureOnlineStoreRequest, Operation>
        deleteFeatureOnlineStoreSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOnlineStoreOperationSettings;
    private final UnaryCallSettings.Builder<CreateFeatureViewRequest, Operation>
        createFeatureViewSettings;
    private final OperationCallSettings.Builder<
            CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
        createFeatureViewOperationSettings;
    private final UnaryCallSettings.Builder<GetFeatureViewRequest, FeatureView>
        getFeatureViewSettings;
    private final PagedCallSettings.Builder<
            ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
        listFeatureViewsSettings;
    private final UnaryCallSettings.Builder<UpdateFeatureViewRequest, Operation>
        updateFeatureViewSettings;
    private final OperationCallSettings.Builder<
            UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
        updateFeatureViewOperationSettings;
    private final UnaryCallSettings.Builder<DeleteFeatureViewRequest, Operation>
        deleteFeatureViewSettings;
    private final OperationCallSettings.Builder<
            DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
        deleteFeatureViewOperationSettings;
    private final UnaryCallSettings.Builder<SyncFeatureViewRequest, SyncFeatureViewResponse>
        syncFeatureViewSettings;
    private final UnaryCallSettings.Builder<GetFeatureViewSyncRequest, FeatureViewSync>
        getFeatureViewSyncSettings;
    private final PagedCallSettings.Builder<
            ListFeatureViewSyncsRequest,
            ListFeatureViewSyncsResponse,
            ListFeatureViewSyncsPagedResponse>
        listFeatureViewSyncsSettings;
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
          "no_retry_14_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
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
      definitions.put("no_retry_14_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createFeatureOnlineStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureOnlineStoreOperationSettings = OperationCallSettings.newBuilder();
      getFeatureOnlineStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureOnlineStoresSettings =
          PagedCallSettings.newBuilder(LIST_FEATURE_ONLINE_STORES_PAGE_STR_FACT);
      updateFeatureOnlineStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureOnlineStoreOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureOnlineStoreSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureOnlineStoreOperationSettings = OperationCallSettings.newBuilder();
      createFeatureViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createFeatureViewOperationSettings = OperationCallSettings.newBuilder();
      getFeatureViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureViewsSettings = PagedCallSettings.newBuilder(LIST_FEATURE_VIEWS_PAGE_STR_FACT);
      updateFeatureViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateFeatureViewOperationSettings = OperationCallSettings.newBuilder();
      deleteFeatureViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteFeatureViewOperationSettings = OperationCallSettings.newBuilder();
      syncFeatureViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getFeatureViewSyncSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listFeatureViewSyncsSettings =
          PagedCallSettings.newBuilder(LIST_FEATURE_VIEW_SYNCS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeatureOnlineStoreSettings,
              getFeatureOnlineStoreSettings,
              listFeatureOnlineStoresSettings,
              updateFeatureOnlineStoreSettings,
              deleteFeatureOnlineStoreSettings,
              createFeatureViewSettings,
              getFeatureViewSettings,
              listFeatureViewsSettings,
              updateFeatureViewSettings,
              deleteFeatureViewSettings,
              syncFeatureViewSettings,
              getFeatureViewSyncSettings,
              listFeatureViewSyncsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(FeatureOnlineStoreAdminServiceStubSettings settings) {
      super(settings);

      createFeatureOnlineStoreSettings = settings.createFeatureOnlineStoreSettings.toBuilder();
      createFeatureOnlineStoreOperationSettings =
          settings.createFeatureOnlineStoreOperationSettings.toBuilder();
      getFeatureOnlineStoreSettings = settings.getFeatureOnlineStoreSettings.toBuilder();
      listFeatureOnlineStoresSettings = settings.listFeatureOnlineStoresSettings.toBuilder();
      updateFeatureOnlineStoreSettings = settings.updateFeatureOnlineStoreSettings.toBuilder();
      updateFeatureOnlineStoreOperationSettings =
          settings.updateFeatureOnlineStoreOperationSettings.toBuilder();
      deleteFeatureOnlineStoreSettings = settings.deleteFeatureOnlineStoreSettings.toBuilder();
      deleteFeatureOnlineStoreOperationSettings =
          settings.deleteFeatureOnlineStoreOperationSettings.toBuilder();
      createFeatureViewSettings = settings.createFeatureViewSettings.toBuilder();
      createFeatureViewOperationSettings = settings.createFeatureViewOperationSettings.toBuilder();
      getFeatureViewSettings = settings.getFeatureViewSettings.toBuilder();
      listFeatureViewsSettings = settings.listFeatureViewsSettings.toBuilder();
      updateFeatureViewSettings = settings.updateFeatureViewSettings.toBuilder();
      updateFeatureViewOperationSettings = settings.updateFeatureViewOperationSettings.toBuilder();
      deleteFeatureViewSettings = settings.deleteFeatureViewSettings.toBuilder();
      deleteFeatureViewOperationSettings = settings.deleteFeatureViewOperationSettings.toBuilder();
      syncFeatureViewSettings = settings.syncFeatureViewSettings.toBuilder();
      getFeatureViewSyncSettings = settings.getFeatureViewSyncSettings.toBuilder();
      listFeatureViewSyncsSettings = settings.listFeatureViewSyncsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createFeatureOnlineStoreSettings,
              getFeatureOnlineStoreSettings,
              listFeatureOnlineStoresSettings,
              updateFeatureOnlineStoreSettings,
              deleteFeatureOnlineStoreSettings,
              createFeatureViewSettings,
              getFeatureViewSettings,
              listFeatureViewsSettings,
              updateFeatureViewSettings,
              deleteFeatureViewSettings,
              syncFeatureViewSettings,
              getFeatureViewSyncSettings,
              listFeatureViewSyncsSettings,
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

    private static Builder initDefaults(Builder builder) {
      builder
          .createFeatureOnlineStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .getFeatureOnlineStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .listFeatureOnlineStoresSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .updateFeatureOnlineStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .deleteFeatureOnlineStoreSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .createFeatureViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .getFeatureViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .listFeatureViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .updateFeatureViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .deleteFeatureViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"));

      builder
          .syncFeatureViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getFeatureViewSyncSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listFeatureViewSyncsSettings()
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
          .createFeatureOnlineStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureOnlineStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureOnlineStore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureOnlineStoreOperationMetadata.class))
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
          .updateFeatureOnlineStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureOnlineStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureOnlineStore.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateFeatureOnlineStoreOperationMetadata.class))
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
          .deleteFeatureOnlineStoreOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureOnlineStoreRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
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
          .createFeatureViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateFeatureViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  CreateFeatureViewOperationMetadata.class))
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
          .updateFeatureViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateFeatureViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(FeatureView.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(
                  UpdateFeatureViewOperationMetadata.class))
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
          .deleteFeatureViewOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteFeatureViewRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_14_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_14_params"))
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

    /** Returns the builder for the settings used for calls to createFeatureOnlineStore. */
    public UnaryCallSettings.Builder<CreateFeatureOnlineStoreRequest, Operation>
        createFeatureOnlineStoreSettings() {
      return createFeatureOnlineStoreSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            CreateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            CreateFeatureOnlineStoreOperationMetadata>
        createFeatureOnlineStoreOperationSettings() {
      return createFeatureOnlineStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureOnlineStore. */
    public UnaryCallSettings.Builder<GetFeatureOnlineStoreRequest, FeatureOnlineStore>
        getFeatureOnlineStoreSettings() {
      return getFeatureOnlineStoreSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureOnlineStores. */
    public PagedCallSettings.Builder<
            ListFeatureOnlineStoresRequest,
            ListFeatureOnlineStoresResponse,
            ListFeatureOnlineStoresPagedResponse>
        listFeatureOnlineStoresSettings() {
      return listFeatureOnlineStoresSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureOnlineStore. */
    public UnaryCallSettings.Builder<UpdateFeatureOnlineStoreRequest, Operation>
        updateFeatureOnlineStoreSettings() {
      return updateFeatureOnlineStoreSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            UpdateFeatureOnlineStoreRequest,
            FeatureOnlineStore,
            UpdateFeatureOnlineStoreOperationMetadata>
        updateFeatureOnlineStoreOperationSettings() {
      return updateFeatureOnlineStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureOnlineStore. */
    public UnaryCallSettings.Builder<DeleteFeatureOnlineStoreRequest, Operation>
        deleteFeatureOnlineStoreSettings() {
      return deleteFeatureOnlineStoreSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureOnlineStore. */
    public OperationCallSettings.Builder<
            DeleteFeatureOnlineStoreRequest, Empty, DeleteOperationMetadata>
        deleteFeatureOnlineStoreOperationSettings() {
      return deleteFeatureOnlineStoreOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureView. */
    public UnaryCallSettings.Builder<CreateFeatureViewRequest, Operation>
        createFeatureViewSettings() {
      return createFeatureViewSettings;
    }

    /** Returns the builder for the settings used for calls to createFeatureView. */
    public OperationCallSettings.Builder<
            CreateFeatureViewRequest, FeatureView, CreateFeatureViewOperationMetadata>
        createFeatureViewOperationSettings() {
      return createFeatureViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureView. */
    public UnaryCallSettings.Builder<GetFeatureViewRequest, FeatureView> getFeatureViewSettings() {
      return getFeatureViewSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureViews. */
    public PagedCallSettings.Builder<
            ListFeatureViewsRequest, ListFeatureViewsResponse, ListFeatureViewsPagedResponse>
        listFeatureViewsSettings() {
      return listFeatureViewsSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureView. */
    public UnaryCallSettings.Builder<UpdateFeatureViewRequest, Operation>
        updateFeatureViewSettings() {
      return updateFeatureViewSettings;
    }

    /** Returns the builder for the settings used for calls to updateFeatureView. */
    public OperationCallSettings.Builder<
            UpdateFeatureViewRequest, FeatureView, UpdateFeatureViewOperationMetadata>
        updateFeatureViewOperationSettings() {
      return updateFeatureViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureView. */
    public UnaryCallSettings.Builder<DeleteFeatureViewRequest, Operation>
        deleteFeatureViewSettings() {
      return deleteFeatureViewSettings;
    }

    /** Returns the builder for the settings used for calls to deleteFeatureView. */
    public OperationCallSettings.Builder<DeleteFeatureViewRequest, Empty, DeleteOperationMetadata>
        deleteFeatureViewOperationSettings() {
      return deleteFeatureViewOperationSettings;
    }

    /** Returns the builder for the settings used for calls to syncFeatureView. */
    public UnaryCallSettings.Builder<SyncFeatureViewRequest, SyncFeatureViewResponse>
        syncFeatureViewSettings() {
      return syncFeatureViewSettings;
    }

    /** Returns the builder for the settings used for calls to getFeatureViewSync. */
    public UnaryCallSettings.Builder<GetFeatureViewSyncRequest, FeatureViewSync>
        getFeatureViewSyncSettings() {
      return getFeatureViewSyncSettings;
    }

    /** Returns the builder for the settings used for calls to listFeatureViewSyncs. */
    public PagedCallSettings.Builder<
            ListFeatureViewSyncsRequest,
            ListFeatureViewSyncsResponse,
            ListFeatureViewSyncsPagedResponse>
        listFeatureViewSyncsSettings() {
      return listFeatureViewSyncsSettings;
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
    public FeatureOnlineStoreAdminServiceStubSettings build() throws IOException {
      return new FeatureOnlineStoreAdminServiceStubSettings(this);
    }
  }
}
