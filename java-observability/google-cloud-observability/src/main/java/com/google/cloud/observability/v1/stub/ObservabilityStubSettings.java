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

package com.google.cloud.observability.v1.stub;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.observability.v1.Bucket;
import com.google.cloud.observability.v1.CreateBucketRequest;
import com.google.cloud.observability.v1.CreateLinkRequest;
import com.google.cloud.observability.v1.CreateTraceScopeRequest;
import com.google.cloud.observability.v1.Dataset;
import com.google.cloud.observability.v1.DeleteLinkRequest;
import com.google.cloud.observability.v1.DeleteTraceScopeRequest;
import com.google.cloud.observability.v1.GetBucketRequest;
import com.google.cloud.observability.v1.GetDatasetRequest;
import com.google.cloud.observability.v1.GetLinkRequest;
import com.google.cloud.observability.v1.GetScopeRequest;
import com.google.cloud.observability.v1.GetSettingsRequest;
import com.google.cloud.observability.v1.GetTraceScopeRequest;
import com.google.cloud.observability.v1.GetViewRequest;
import com.google.cloud.observability.v1.Link;
import com.google.cloud.observability.v1.ListBucketsRequest;
import com.google.cloud.observability.v1.ListBucketsResponse;
import com.google.cloud.observability.v1.ListDatasetsRequest;
import com.google.cloud.observability.v1.ListDatasetsResponse;
import com.google.cloud.observability.v1.ListLinksRequest;
import com.google.cloud.observability.v1.ListLinksResponse;
import com.google.cloud.observability.v1.ListTraceScopesRequest;
import com.google.cloud.observability.v1.ListTraceScopesResponse;
import com.google.cloud.observability.v1.ListViewsRequest;
import com.google.cloud.observability.v1.ListViewsResponse;
import com.google.cloud.observability.v1.OperationMetadata;
import com.google.cloud.observability.v1.Scope;
import com.google.cloud.observability.v1.Settings;
import com.google.cloud.observability.v1.TraceScope;
import com.google.cloud.observability.v1.UpdateBucketRequest;
import com.google.cloud.observability.v1.UpdateLinkRequest;
import com.google.cloud.observability.v1.UpdateScopeRequest;
import com.google.cloud.observability.v1.UpdateSettingsRequest;
import com.google.cloud.observability.v1.UpdateTraceScopeRequest;
import com.google.cloud.observability.v1.View;
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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ObservabilityStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (observability.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getScope:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ObservabilityStubSettings.Builder observabilitySettingsBuilder =
 *     ObservabilityStubSettings.newBuilder();
 * observabilitySettingsBuilder
 *     .getScopeSettings()
 *     .setRetrySettings(
 *         observabilitySettingsBuilder
 *             .getScopeSettings()
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
 * ObservabilityStubSettings observabilitySettings = observabilitySettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createBucket:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ObservabilityStubSettings.Builder observabilitySettingsBuilder =
 *     ObservabilityStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * observabilitySettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@NullMarked
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class ObservabilityStubSettings extends StubSettings<ObservabilityStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings;
  private final UnaryCallSettings<UpdateScopeRequest, Scope> updateScopeSettings;
  private final UnaryCallSettings<GetBucketRequest, Bucket> getBucketSettings;
  private final PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings;
  private final UnaryCallSettings<CreateBucketRequest, Operation> createBucketSettings;
  private final OperationCallSettings<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationSettings;
  private final UnaryCallSettings<UpdateBucketRequest, Operation> updateBucketSettings;
  private final OperationCallSettings<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationSettings;
  private final UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings;
  private final PagedCallSettings<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings;
  private final UnaryCallSettings<GetViewRequest, View> getViewSettings;
  private final PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings;
  private final UnaryCallSettings<GetLinkRequest, Link> getLinkSettings;
  private final PagedCallSettings<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
      listLinksSettings;
  private final UnaryCallSettings<CreateLinkRequest, Operation> createLinkSettings;
  private final OperationCallSettings<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationSettings;
  private final UnaryCallSettings<UpdateLinkRequest, Operation> updateLinkSettings;
  private final OperationCallSettings<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationSettings;
  private final UnaryCallSettings<DeleteLinkRequest, Operation> deleteLinkSettings;
  private final OperationCallSettings<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationSettings;
  private final UnaryCallSettings<GetTraceScopeRequest, TraceScope> getTraceScopeSettings;
  private final PagedCallSettings<
          ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
      listTraceScopesSettings;
  private final UnaryCallSettings<CreateTraceScopeRequest, TraceScope> createTraceScopeSettings;
  private final UnaryCallSettings<UpdateTraceScopeRequest, TraceScope> updateTraceScopeSettings;
  private final UnaryCallSettings<DeleteTraceScopeRequest, Empty> deleteTraceScopeSettings;
  private final UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings;
  private final UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings;
  private final OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListBucketsRequest, ListBucketsResponse, Bucket>
      LIST_BUCKETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBucketsRequest, ListBucketsResponse, Bucket>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBucketsRequest injectToken(ListBucketsRequest payload, String token) {
              return ListBucketsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBucketsRequest injectPageSize(ListBucketsRequest payload, int pageSize) {
              return ListBucketsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBucketsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBucketsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Bucket> extractResources(ListBucketsResponse payload) {
              return payload.getBucketsList();
            }
          };

  private static final PagedListDescriptor<ListDatasetsRequest, ListDatasetsResponse, Dataset>
      LIST_DATASETS_PAGE_STR_DESC =
          new PagedListDescriptor<ListDatasetsRequest, ListDatasetsResponse, Dataset>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDatasetsRequest injectToken(ListDatasetsRequest payload, String token) {
              return ListDatasetsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDatasetsRequest injectPageSize(ListDatasetsRequest payload, int pageSize) {
              return ListDatasetsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDatasetsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDatasetsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Dataset> extractResources(ListDatasetsResponse payload) {
              return payload.getDatasetsList();
            }
          };

  private static final PagedListDescriptor<ListViewsRequest, ListViewsResponse, View>
      LIST_VIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<ListViewsRequest, ListViewsResponse, View>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListViewsRequest injectToken(ListViewsRequest payload, String token) {
              return ListViewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListViewsRequest injectPageSize(ListViewsRequest payload, int pageSize) {
              return ListViewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListViewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListViewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<View> extractResources(ListViewsResponse payload) {
              return payload.getViewsList();
            }
          };

  private static final PagedListDescriptor<ListLinksRequest, ListLinksResponse, Link>
      LIST_LINKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLinksRequest, ListLinksResponse, Link>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLinksRequest injectToken(ListLinksRequest payload, String token) {
              return ListLinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLinksRequest injectPageSize(ListLinksRequest payload, int pageSize) {
              return ListLinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Link> extractResources(ListLinksResponse payload) {
              return payload.getLinksList();
            }
          };

  private static final PagedListDescriptor<
          ListTraceScopesRequest, ListTraceScopesResponse, TraceScope>
      LIST_TRACE_SCOPES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTraceScopesRequest injectToken(
                ListTraceScopesRequest payload, String token) {
              return ListTraceScopesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTraceScopesRequest injectPageSize(
                ListTraceScopesRequest payload, int pageSize) {
              return ListTraceScopesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTraceScopesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTraceScopesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TraceScope> extractResources(ListTraceScopesResponse payload) {
              return payload.getTraceScopesList();
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
          ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      LIST_BUCKETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>() {
            @Override
            public ApiFuture<ListBucketsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBucketsRequest, ListBucketsResponse> callable,
                ListBucketsRequest request,
                ApiCallContext context,
                ApiFuture<ListBucketsResponse> futureResponse) {
              PageContext<ListBucketsRequest, ListBucketsResponse, Bucket> pageContext =
                  PageContext.create(callable, LIST_BUCKETS_PAGE_STR_DESC, request, context);
              return ListBucketsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      LIST_DATASETS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>() {
            @Override
            public ApiFuture<ListDatasetsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDatasetsRequest, ListDatasetsResponse> callable,
                ListDatasetsRequest request,
                ApiCallContext context,
                ApiFuture<ListDatasetsResponse> futureResponse) {
              PageContext<ListDatasetsRequest, ListDatasetsResponse, Dataset> pageContext =
                  PageContext.create(callable, LIST_DATASETS_PAGE_STR_DESC, request, context);
              return ListDatasetsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      LIST_VIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>() {
            @Override
            public ApiFuture<ListViewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListViewsRequest, ListViewsResponse> callable,
                ListViewsRequest request,
                ApiCallContext context,
                ApiFuture<ListViewsResponse> futureResponse) {
              PageContext<ListViewsRequest, ListViewsResponse, View> pageContext =
                  PageContext.create(callable, LIST_VIEWS_PAGE_STR_DESC, request, context);
              return ListViewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
      LIST_LINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>() {
            @Override
            public ApiFuture<ListLinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLinksRequest, ListLinksResponse> callable,
                ListLinksRequest request,
                ApiCallContext context,
                ApiFuture<ListLinksResponse> futureResponse) {
              PageContext<ListLinksRequest, ListLinksResponse, Link> pageContext =
                  PageContext.create(callable, LIST_LINKS_PAGE_STR_DESC, request, context);
              return ListLinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
      LIST_TRACE_SCOPES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>() {
            @Override
            public ApiFuture<ListTraceScopesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTraceScopesRequest, ListTraceScopesResponse> callable,
                ListTraceScopesRequest request,
                ApiCallContext context,
                ApiFuture<ListTraceScopesResponse> futureResponse) {
              PageContext<ListTraceScopesRequest, ListTraceScopesResponse, TraceScope> pageContext =
                  PageContext.create(callable, LIST_TRACE_SCOPES_PAGE_STR_DESC, request, context);
              return ListTraceScopesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getScope. */
  public UnaryCallSettings<GetScopeRequest, Scope> getScopeSettings() {
    return getScopeSettings;
  }

  /** Returns the object with the settings used for calls to updateScope. */
  public UnaryCallSettings<UpdateScopeRequest, Scope> updateScopeSettings() {
    return updateScopeSettings;
  }

  /** Returns the object with the settings used for calls to getBucket. */
  public UnaryCallSettings<GetBucketRequest, Bucket> getBucketSettings() {
    return getBucketSettings;
  }

  /** Returns the object with the settings used for calls to listBuckets. */
  public PagedCallSettings<ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
      listBucketsSettings() {
    return listBucketsSettings;
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public UnaryCallSettings<CreateBucketRequest, Operation> createBucketSettings() {
    return createBucketSettings;
  }

  /** Returns the object with the settings used for calls to createBucket. */
  public OperationCallSettings<CreateBucketRequest, Bucket, OperationMetadata>
      createBucketOperationSettings() {
    return createBucketOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public UnaryCallSettings<UpdateBucketRequest, Operation> updateBucketSettings() {
    return updateBucketSettings;
  }

  /** Returns the object with the settings used for calls to updateBucket. */
  public OperationCallSettings<UpdateBucketRequest, Bucket, OperationMetadata>
      updateBucketOperationSettings() {
    return updateBucketOperationSettings;
  }

  /** Returns the object with the settings used for calls to getDataset. */
  public UnaryCallSettings<GetDatasetRequest, Dataset> getDatasetSettings() {
    return getDatasetSettings;
  }

  /** Returns the object with the settings used for calls to listDatasets. */
  public PagedCallSettings<ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
      listDatasetsSettings() {
    return listDatasetsSettings;
  }

  /** Returns the object with the settings used for calls to getView. */
  public UnaryCallSettings<GetViewRequest, View> getViewSettings() {
    return getViewSettings;
  }

  /** Returns the object with the settings used for calls to listViews. */
  public PagedCallSettings<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
      listViewsSettings() {
    return listViewsSettings;
  }

  /** Returns the object with the settings used for calls to getLink. */
  public UnaryCallSettings<GetLinkRequest, Link> getLinkSettings() {
    return getLinkSettings;
  }

  /** Returns the object with the settings used for calls to listLinks. */
  public PagedCallSettings<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
      listLinksSettings() {
    return listLinksSettings;
  }

  /** Returns the object with the settings used for calls to createLink. */
  public UnaryCallSettings<CreateLinkRequest, Operation> createLinkSettings() {
    return createLinkSettings;
  }

  /** Returns the object with the settings used for calls to createLink. */
  public OperationCallSettings<CreateLinkRequest, Link, OperationMetadata>
      createLinkOperationSettings() {
    return createLinkOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateLink. */
  public UnaryCallSettings<UpdateLinkRequest, Operation> updateLinkSettings() {
    return updateLinkSettings;
  }

  /** Returns the object with the settings used for calls to updateLink. */
  public OperationCallSettings<UpdateLinkRequest, Link, OperationMetadata>
      updateLinkOperationSettings() {
    return updateLinkOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public UnaryCallSettings<DeleteLinkRequest, Operation> deleteLinkSettings() {
    return deleteLinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteLink. */
  public OperationCallSettings<DeleteLinkRequest, Empty, OperationMetadata>
      deleteLinkOperationSettings() {
    return deleteLinkOperationSettings;
  }

  /** Returns the object with the settings used for calls to getTraceScope. */
  public UnaryCallSettings<GetTraceScopeRequest, TraceScope> getTraceScopeSettings() {
    return getTraceScopeSettings;
  }

  /** Returns the object with the settings used for calls to listTraceScopes. */
  public PagedCallSettings<
          ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
      listTraceScopesSettings() {
    return listTraceScopesSettings;
  }

  /** Returns the object with the settings used for calls to createTraceScope. */
  public UnaryCallSettings<CreateTraceScopeRequest, TraceScope> createTraceScopeSettings() {
    return createTraceScopeSettings;
  }

  /** Returns the object with the settings used for calls to updateTraceScope. */
  public UnaryCallSettings<UpdateTraceScopeRequest, TraceScope> updateTraceScopeSettings() {
    return updateTraceScopeSettings;
  }

  /** Returns the object with the settings used for calls to deleteTraceScope. */
  public UnaryCallSettings<DeleteTraceScopeRequest, Empty> deleteTraceScopeSettings() {
    return deleteTraceScopeSettings;
  }

  /** Returns the object with the settings used for calls to getSettings. */
  public UnaryCallSettings<GetSettingsRequest, Settings> getSettingsSettings() {
    return getSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public UnaryCallSettings<UpdateSettingsRequest, Operation> updateSettingsSettings() {
    return updateSettingsSettings;
  }

  /** Returns the object with the settings used for calls to updateSettings. */
  public OperationCallSettings<UpdateSettingsRequest, Settings, OperationMetadata>
      updateSettingsOperationSettings() {
    return updateSettingsOperationSettings;
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

  public ObservabilityStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcObservabilityStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonObservabilityStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "observability";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "observability.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "observability.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ObservabilityStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ObservabilityStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ObservabilityStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ObservabilityStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getScopeSettings = settingsBuilder.getScopeSettings().build();
    updateScopeSettings = settingsBuilder.updateScopeSettings().build();
    getBucketSettings = settingsBuilder.getBucketSettings().build();
    listBucketsSettings = settingsBuilder.listBucketsSettings().build();
    createBucketSettings = settingsBuilder.createBucketSettings().build();
    createBucketOperationSettings = settingsBuilder.createBucketOperationSettings().build();
    updateBucketSettings = settingsBuilder.updateBucketSettings().build();
    updateBucketOperationSettings = settingsBuilder.updateBucketOperationSettings().build();
    getDatasetSettings = settingsBuilder.getDatasetSettings().build();
    listDatasetsSettings = settingsBuilder.listDatasetsSettings().build();
    getViewSettings = settingsBuilder.getViewSettings().build();
    listViewsSettings = settingsBuilder.listViewsSettings().build();
    getLinkSettings = settingsBuilder.getLinkSettings().build();
    listLinksSettings = settingsBuilder.listLinksSettings().build();
    createLinkSettings = settingsBuilder.createLinkSettings().build();
    createLinkOperationSettings = settingsBuilder.createLinkOperationSettings().build();
    updateLinkSettings = settingsBuilder.updateLinkSettings().build();
    updateLinkOperationSettings = settingsBuilder.updateLinkOperationSettings().build();
    deleteLinkSettings = settingsBuilder.deleteLinkSettings().build();
    deleteLinkOperationSettings = settingsBuilder.deleteLinkOperationSettings().build();
    getTraceScopeSettings = settingsBuilder.getTraceScopeSettings().build();
    listTraceScopesSettings = settingsBuilder.listTraceScopesSettings().build();
    createTraceScopeSettings = settingsBuilder.createTraceScopeSettings().build();
    updateTraceScopeSettings = settingsBuilder.updateTraceScopeSettings().build();
    deleteTraceScopeSettings = settingsBuilder.deleteTraceScopeSettings().build();
    getSettingsSettings = settingsBuilder.getSettingsSettings().build();
    updateSettingsSettings = settingsBuilder.updateSettingsSettings().build();
    updateSettingsOperationSettings = settingsBuilder.updateSettingsOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-observability")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for ObservabilityStubSettings. */
  public static class Builder extends StubSettings.Builder<ObservabilityStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings;
    private final UnaryCallSettings.Builder<UpdateScopeRequest, Scope> updateScopeSettings;
    private final UnaryCallSettings.Builder<GetBucketRequest, Bucket> getBucketSettings;
    private final PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings;
    private final UnaryCallSettings.Builder<CreateBucketRequest, Operation> createBucketSettings;
    private final OperationCallSettings.Builder<CreateBucketRequest, Bucket, OperationMetadata>
        createBucketOperationSettings;
    private final UnaryCallSettings.Builder<UpdateBucketRequest, Operation> updateBucketSettings;
    private final OperationCallSettings.Builder<UpdateBucketRequest, Bucket, OperationMetadata>
        updateBucketOperationSettings;
    private final UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings;
    private final PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings;
    private final UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings;
    private final PagedCallSettings.Builder<
            ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings;
    private final UnaryCallSettings.Builder<GetLinkRequest, Link> getLinkSettings;
    private final PagedCallSettings.Builder<
            ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
        listLinksSettings;
    private final UnaryCallSettings.Builder<CreateLinkRequest, Operation> createLinkSettings;
    private final OperationCallSettings.Builder<CreateLinkRequest, Link, OperationMetadata>
        createLinkOperationSettings;
    private final UnaryCallSettings.Builder<UpdateLinkRequest, Operation> updateLinkSettings;
    private final OperationCallSettings.Builder<UpdateLinkRequest, Link, OperationMetadata>
        updateLinkOperationSettings;
    private final UnaryCallSettings.Builder<DeleteLinkRequest, Operation> deleteLinkSettings;
    private final OperationCallSettings.Builder<DeleteLinkRequest, Empty, OperationMetadata>
        deleteLinkOperationSettings;
    private final UnaryCallSettings.Builder<GetTraceScopeRequest, TraceScope> getTraceScopeSettings;
    private final PagedCallSettings.Builder<
            ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
        listTraceScopesSettings;
    private final UnaryCallSettings.Builder<CreateTraceScopeRequest, TraceScope>
        createTraceScopeSettings;
    private final UnaryCallSettings.Builder<UpdateTraceScopeRequest, TraceScope>
        updateTraceScopeSettings;
    private final UnaryCallSettings.Builder<DeleteTraceScopeRequest, Empty>
        deleteTraceScopeSettings;
    private final UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings;
    private final UnaryCallSettings.Builder<UpdateSettingsRequest, Operation>
        updateSettingsSettings;
    private final OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(clientContext);

      getScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBucketsSettings = PagedCallSettings.newBuilder(LIST_BUCKETS_PAGE_STR_FACT);
      createBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createBucketOperationSettings = OperationCallSettings.newBuilder();
      updateBucketSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBucketOperationSettings = OperationCallSettings.newBuilder();
      getDatasetSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listDatasetsSettings = PagedCallSettings.newBuilder(LIST_DATASETS_PAGE_STR_FACT);
      getViewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listViewsSettings = PagedCallSettings.newBuilder(LIST_VIEWS_PAGE_STR_FACT);
      getLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLinksSettings = PagedCallSettings.newBuilder(LIST_LINKS_PAGE_STR_FACT);
      createLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createLinkOperationSettings = OperationCallSettings.newBuilder();
      updateLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateLinkOperationSettings = OperationCallSettings.newBuilder();
      deleteLinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteLinkOperationSettings = OperationCallSettings.newBuilder();
      getTraceScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTraceScopesSettings = PagedCallSettings.newBuilder(LIST_TRACE_SCOPES_PAGE_STR_FACT);
      createTraceScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTraceScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTraceScopeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateSettingsOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getScopeSettings,
              updateScopeSettings,
              getBucketSettings,
              listBucketsSettings,
              createBucketSettings,
              updateBucketSettings,
              getDatasetSettings,
              listDatasetsSettings,
              getViewSettings,
              listViewsSettings,
              getLinkSettings,
              listLinksSettings,
              createLinkSettings,
              updateLinkSettings,
              deleteLinkSettings,
              getTraceScopeSettings,
              listTraceScopesSettings,
              createTraceScopeSettings,
              updateTraceScopeSettings,
              deleteTraceScopeSettings,
              getSettingsSettings,
              updateSettingsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(ObservabilityStubSettings settings) {
      super(settings);

      getScopeSettings = settings.getScopeSettings.toBuilder();
      updateScopeSettings = settings.updateScopeSettings.toBuilder();
      getBucketSettings = settings.getBucketSettings.toBuilder();
      listBucketsSettings = settings.listBucketsSettings.toBuilder();
      createBucketSettings = settings.createBucketSettings.toBuilder();
      createBucketOperationSettings = settings.createBucketOperationSettings.toBuilder();
      updateBucketSettings = settings.updateBucketSettings.toBuilder();
      updateBucketOperationSettings = settings.updateBucketOperationSettings.toBuilder();
      getDatasetSettings = settings.getDatasetSettings.toBuilder();
      listDatasetsSettings = settings.listDatasetsSettings.toBuilder();
      getViewSettings = settings.getViewSettings.toBuilder();
      listViewsSettings = settings.listViewsSettings.toBuilder();
      getLinkSettings = settings.getLinkSettings.toBuilder();
      listLinksSettings = settings.listLinksSettings.toBuilder();
      createLinkSettings = settings.createLinkSettings.toBuilder();
      createLinkOperationSettings = settings.createLinkOperationSettings.toBuilder();
      updateLinkSettings = settings.updateLinkSettings.toBuilder();
      updateLinkOperationSettings = settings.updateLinkOperationSettings.toBuilder();
      deleteLinkSettings = settings.deleteLinkSettings.toBuilder();
      deleteLinkOperationSettings = settings.deleteLinkOperationSettings.toBuilder();
      getTraceScopeSettings = settings.getTraceScopeSettings.toBuilder();
      listTraceScopesSettings = settings.listTraceScopesSettings.toBuilder();
      createTraceScopeSettings = settings.createTraceScopeSettings.toBuilder();
      updateTraceScopeSettings = settings.updateTraceScopeSettings.toBuilder();
      deleteTraceScopeSettings = settings.deleteTraceScopeSettings.toBuilder();
      getSettingsSettings = settings.getSettingsSettings.toBuilder();
      updateSettingsSettings = settings.updateSettingsSettings.toBuilder();
      updateSettingsOperationSettings = settings.updateSettingsOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getScopeSettings,
              updateScopeSettings,
              getBucketSettings,
              listBucketsSettings,
              createBucketSettings,
              updateBucketSettings,
              getDatasetSettings,
              listDatasetsSettings,
              getViewSettings,
              listViewsSettings,
              getLinkSettings,
              listLinksSettings,
              createLinkSettings,
              updateLinkSettings,
              deleteLinkSettings,
              getTraceScopeSettings,
              listTraceScopesSettings,
              createTraceScopeSettings,
              updateTraceScopeSettings,
              deleteTraceScopeSettings,
              getSettingsSettings,
              updateSettingsSettings,
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
          .getScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listBucketsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateBucketSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getDatasetSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listDatasetsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getViewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listViewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteLinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getTraceScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTraceScopesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTraceScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTraceScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTraceScopeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateSettingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createBucketOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Bucket.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateBucketOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateBucketRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Bucket.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .createLinkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateLinkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Link.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateLinkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateLinkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Link.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .deleteLinkOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteLinkRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(600000L))
                      .build()));

      builder
          .updateSettingsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateSettingsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Settings.class))
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

    /** Returns the builder for the settings used for calls to getScope. */
    public UnaryCallSettings.Builder<GetScopeRequest, Scope> getScopeSettings() {
      return getScopeSettings;
    }

    /** Returns the builder for the settings used for calls to updateScope. */
    public UnaryCallSettings.Builder<UpdateScopeRequest, Scope> updateScopeSettings() {
      return updateScopeSettings;
    }

    /** Returns the builder for the settings used for calls to getBucket. */
    public UnaryCallSettings.Builder<GetBucketRequest, Bucket> getBucketSettings() {
      return getBucketSettings;
    }

    /** Returns the builder for the settings used for calls to listBuckets. */
    public PagedCallSettings.Builder<
            ListBucketsRequest, ListBucketsResponse, ListBucketsPagedResponse>
        listBucketsSettings() {
      return listBucketsSettings;
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public UnaryCallSettings.Builder<CreateBucketRequest, Operation> createBucketSettings() {
      return createBucketSettings;
    }

    /** Returns the builder for the settings used for calls to createBucket. */
    public OperationCallSettings.Builder<CreateBucketRequest, Bucket, OperationMetadata>
        createBucketOperationSettings() {
      return createBucketOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public UnaryCallSettings.Builder<UpdateBucketRequest, Operation> updateBucketSettings() {
      return updateBucketSettings;
    }

    /** Returns the builder for the settings used for calls to updateBucket. */
    public OperationCallSettings.Builder<UpdateBucketRequest, Bucket, OperationMetadata>
        updateBucketOperationSettings() {
      return updateBucketOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getDataset. */
    public UnaryCallSettings.Builder<GetDatasetRequest, Dataset> getDatasetSettings() {
      return getDatasetSettings;
    }

    /** Returns the builder for the settings used for calls to listDatasets. */
    public PagedCallSettings.Builder<
            ListDatasetsRequest, ListDatasetsResponse, ListDatasetsPagedResponse>
        listDatasetsSettings() {
      return listDatasetsSettings;
    }

    /** Returns the builder for the settings used for calls to getView. */
    public UnaryCallSettings.Builder<GetViewRequest, View> getViewSettings() {
      return getViewSettings;
    }

    /** Returns the builder for the settings used for calls to listViews. */
    public PagedCallSettings.Builder<ListViewsRequest, ListViewsResponse, ListViewsPagedResponse>
        listViewsSettings() {
      return listViewsSettings;
    }

    /** Returns the builder for the settings used for calls to getLink. */
    public UnaryCallSettings.Builder<GetLinkRequest, Link> getLinkSettings() {
      return getLinkSettings;
    }

    /** Returns the builder for the settings used for calls to listLinks. */
    public PagedCallSettings.Builder<ListLinksRequest, ListLinksResponse, ListLinksPagedResponse>
        listLinksSettings() {
      return listLinksSettings;
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public UnaryCallSettings.Builder<CreateLinkRequest, Operation> createLinkSettings() {
      return createLinkSettings;
    }

    /** Returns the builder for the settings used for calls to createLink. */
    public OperationCallSettings.Builder<CreateLinkRequest, Link, OperationMetadata>
        createLinkOperationSettings() {
      return createLinkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateLink. */
    public UnaryCallSettings.Builder<UpdateLinkRequest, Operation> updateLinkSettings() {
      return updateLinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateLink. */
    public OperationCallSettings.Builder<UpdateLinkRequest, Link, OperationMetadata>
        updateLinkOperationSettings() {
      return updateLinkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public UnaryCallSettings.Builder<DeleteLinkRequest, Operation> deleteLinkSettings() {
      return deleteLinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteLink. */
    public OperationCallSettings.Builder<DeleteLinkRequest, Empty, OperationMetadata>
        deleteLinkOperationSettings() {
      return deleteLinkOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getTraceScope. */
    public UnaryCallSettings.Builder<GetTraceScopeRequest, TraceScope> getTraceScopeSettings() {
      return getTraceScopeSettings;
    }

    /** Returns the builder for the settings used for calls to listTraceScopes. */
    public PagedCallSettings.Builder<
            ListTraceScopesRequest, ListTraceScopesResponse, ListTraceScopesPagedResponse>
        listTraceScopesSettings() {
      return listTraceScopesSettings;
    }

    /** Returns the builder for the settings used for calls to createTraceScope. */
    public UnaryCallSettings.Builder<CreateTraceScopeRequest, TraceScope>
        createTraceScopeSettings() {
      return createTraceScopeSettings;
    }

    /** Returns the builder for the settings used for calls to updateTraceScope. */
    public UnaryCallSettings.Builder<UpdateTraceScopeRequest, TraceScope>
        updateTraceScopeSettings() {
      return updateTraceScopeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTraceScope. */
    public UnaryCallSettings.Builder<DeleteTraceScopeRequest, Empty> deleteTraceScopeSettings() {
      return deleteTraceScopeSettings;
    }

    /** Returns the builder for the settings used for calls to getSettings. */
    public UnaryCallSettings.Builder<GetSettingsRequest, Settings> getSettingsSettings() {
      return getSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public UnaryCallSettings.Builder<UpdateSettingsRequest, Operation> updateSettingsSettings() {
      return updateSettingsSettings;
    }

    /** Returns the builder for the settings used for calls to updateSettings. */
    public OperationCallSettings.Builder<UpdateSettingsRequest, Settings, OperationMetadata>
        updateSettingsOperationSettings() {
      return updateSettingsOperationSettings;
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
    public ObservabilityStubSettings build() throws IOException {
      return new ObservabilityStubSettings(this);
    }
  }
}
