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

package com.google.cloud.bigquery.analyticshub.v1.stub;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSharedResourceSubscriptionsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.cloud.bigquery.analyticshub.v1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.CreateListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DataExchange;
import com.google.cloud.bigquery.analyticshub.v1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.DeleteSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.GetSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListListingsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSharedResourceSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsRequest;
import com.google.cloud.bigquery.analyticshub.v1.ListSubscriptionsResponse;
import com.google.cloud.bigquery.analyticshub.v1.Listing;
import com.google.cloud.bigquery.analyticshub.v1.OperationMetadata;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RefreshSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionRequest;
import com.google.cloud.bigquery.analyticshub.v1.RevokeSubscriptionResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeDataExchangeResponse;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingRequest;
import com.google.cloud.bigquery.analyticshub.v1.SubscribeListingResponse;
import com.google.cloud.bigquery.analyticshub.v1.Subscription;
import com.google.cloud.bigquery.analyticshub.v1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.analyticshub.v1.UpdateListingRequest;
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
 * Settings class to configure an instance of {@link AnalyticsHubServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticshub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getDataExchange to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceStubSettings.Builder analyticsHubServiceSettingsBuilder =
 *     AnalyticsHubServiceStubSettings.newBuilder();
 * analyticsHubServiceSettingsBuilder
 *     .getDataExchangeSettings()
 *     .setRetrySettings(
 *         analyticsHubServiceSettingsBuilder
 *             .getDataExchangeSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * AnalyticsHubServiceStubSettings analyticsHubServiceSettings =
 *     analyticsHubServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AnalyticsHubServiceStubSettings extends StubSettings<AnalyticsHubServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/bigquery")
          .add("https://www.googleapis.com/auth/cloud-platform")
          .build();

  private final PagedCallSettings<
          ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
      listDataExchangesSettings;
  private final PagedCallSettings<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesSettings;
  private final UnaryCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeSettings;
  private final UnaryCallSettings<CreateDataExchangeRequest, DataExchange>
      createDataExchangeSettings;
  private final UnaryCallSettings<UpdateDataExchangeRequest, DataExchange>
      updateDataExchangeSettings;
  private final UnaryCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeSettings;
  private final PagedCallSettings<
          ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
      listListingsSettings;
  private final UnaryCallSettings<GetListingRequest, Listing> getListingSettings;
  private final UnaryCallSettings<CreateListingRequest, Listing> createListingSettings;
  private final UnaryCallSettings<UpdateListingRequest, Listing> updateListingSettings;
  private final UnaryCallSettings<DeleteListingRequest, Empty> deleteListingSettings;
  private final UnaryCallSettings<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingSettings;
  private final UnaryCallSettings<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeSettings;
  private final OperationCallSettings<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationSettings;
  private final UnaryCallSettings<RefreshSubscriptionRequest, Operation>
      refreshSubscriptionSettings;
  private final OperationCallSettings<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationSettings;
  private final UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings;
  private final PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings;
  private final PagedCallSettings<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsSettings;
  private final UnaryCallSettings<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionSettings;
  private final UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings;
  private final OperationCallSettings<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationSettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListDataExchangesRequest, ListDataExchangesResponse, DataExchange>
      LIST_DATA_EXCHANGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListDataExchangesRequest, ListDataExchangesResponse, DataExchange>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListDataExchangesRequest injectToken(
                ListDataExchangesRequest payload, String token) {
              return ListDataExchangesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListDataExchangesRequest injectPageSize(
                ListDataExchangesRequest payload, int pageSize) {
              return ListDataExchangesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListDataExchangesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListDataExchangesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataExchange> extractResources(ListDataExchangesResponse payload) {
              return payload.getDataExchangesList() == null
                  ? ImmutableList.<DataExchange>of()
                  : payload.getDataExchangesList();
            }
          };

  private static final PagedListDescriptor<
          ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
      LIST_ORG_DATA_EXCHANGES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrgDataExchangesRequest injectToken(
                ListOrgDataExchangesRequest payload, String token) {
              return ListOrgDataExchangesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrgDataExchangesRequest injectPageSize(
                ListOrgDataExchangesRequest payload, int pageSize) {
              return ListOrgDataExchangesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOrgDataExchangesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrgDataExchangesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<DataExchange> extractResources(ListOrgDataExchangesResponse payload) {
              return payload.getDataExchangesList() == null
                  ? ImmutableList.<DataExchange>of()
                  : payload.getDataExchangesList();
            }
          };

  private static final PagedListDescriptor<ListListingsRequest, ListListingsResponse, Listing>
      LIST_LISTINGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListListingsRequest, ListListingsResponse, Listing>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListListingsRequest injectToken(ListListingsRequest payload, String token) {
              return ListListingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListListingsRequest injectPageSize(ListListingsRequest payload, int pageSize) {
              return ListListingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListListingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListListingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Listing> extractResources(ListListingsResponse payload) {
              return payload.getListingsList() == null
                  ? ImmutableList.<Listing>of()
                  : payload.getListingsList();
            }
          };

  private static final PagedListDescriptor<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, String token) {
              return ListSubscriptionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSubscriptionsRequest injectPageSize(
                ListSubscriptionsRequest payload, int pageSize) {
              return ListSubscriptionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSubscriptionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscription> extractResources(ListSubscriptionsResponse payload) {
              return payload.getSubscriptionsList() == null
                  ? ImmutableList.<Subscription>of()
                  : payload.getSubscriptionsList();
            }
          };

  private static final PagedListDescriptor<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          Subscription>
      LIST_SHARED_RESOURCE_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListSharedResourceSubscriptionsRequest,
              ListSharedResourceSubscriptionsResponse,
              Subscription>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSharedResourceSubscriptionsRequest injectToken(
                ListSharedResourceSubscriptionsRequest payload, String token) {
              return ListSharedResourceSubscriptionsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListSharedResourceSubscriptionsRequest injectPageSize(
                ListSharedResourceSubscriptionsRequest payload, int pageSize) {
              return ListSharedResourceSubscriptionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListSharedResourceSubscriptionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSharedResourceSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscription> extractResources(
                ListSharedResourceSubscriptionsResponse payload) {
              return payload.getSharedResourceSubscriptionsList() == null
                  ? ImmutableList.<Subscription>of()
                  : payload.getSharedResourceSubscriptionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
      LIST_DATA_EXCHANGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListDataExchangesRequest,
              ListDataExchangesResponse,
              ListDataExchangesPagedResponse>() {
            @Override
            public ApiFuture<ListDataExchangesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListDataExchangesRequest, ListDataExchangesResponse> callable,
                ListDataExchangesRequest request,
                ApiCallContext context,
                ApiFuture<ListDataExchangesResponse> futureResponse) {
              PageContext<ListDataExchangesRequest, ListDataExchangesResponse, DataExchange>
                  pageContext =
                      PageContext.create(
                          callable, LIST_DATA_EXCHANGES_PAGE_STR_DESC, request, context);
              return ListDataExchangesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          ListOrgDataExchangesPagedResponse>
      LIST_ORG_DATA_EXCHANGES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrgDataExchangesRequest,
              ListOrgDataExchangesResponse,
              ListOrgDataExchangesPagedResponse>() {
            @Override
            public ApiFuture<ListOrgDataExchangesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse> callable,
                ListOrgDataExchangesRequest request,
                ApiCallContext context,
                ApiFuture<ListOrgDataExchangesResponse> futureResponse) {
              PageContext<ListOrgDataExchangesRequest, ListOrgDataExchangesResponse, DataExchange>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ORG_DATA_EXCHANGES_PAGE_STR_DESC, request, context);
              return ListOrgDataExchangesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
      LIST_LISTINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>() {
            @Override
            public ApiFuture<ListListingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListListingsRequest, ListListingsResponse> callable,
                ListListingsRequest request,
                ApiCallContext context,
                ApiFuture<ListListingsResponse> futureResponse) {
              PageContext<ListListingsRequest, ListListingsResponse, Listing> pageContext =
                  PageContext.create(callable, LIST_LISTINGS_PAGE_STR_DESC, request, context);
              return ListListingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      LIST_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSubscriptionsRequest,
              ListSubscriptionsResponse,
              ListSubscriptionsPagedResponse>() {
            @Override
            public ApiFuture<ListSubscriptionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSubscriptionsRequest, ListSubscriptionsResponse> callable,
                ListSubscriptionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSubscriptionsResponse> futureResponse) {
              PageContext<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SUBSCRIPTIONS_PAGE_STR_DESC, request, context);
              return ListSubscriptionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          ListSharedResourceSubscriptionsPagedResponse>
      LIST_SHARED_RESOURCE_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSharedResourceSubscriptionsRequest,
              ListSharedResourceSubscriptionsResponse,
              ListSharedResourceSubscriptionsPagedResponse>() {
            @Override
            public ApiFuture<ListSharedResourceSubscriptionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListSharedResourceSubscriptionsRequest,
                        ListSharedResourceSubscriptionsResponse>
                    callable,
                ListSharedResourceSubscriptionsRequest request,
                ApiCallContext context,
                ApiFuture<ListSharedResourceSubscriptionsResponse> futureResponse) {
              PageContext<
                      ListSharedResourceSubscriptionsRequest,
                      ListSharedResourceSubscriptionsResponse,
                      Subscription>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_SHARED_RESOURCE_SUBSCRIPTIONS_PAGE_STR_DESC,
                          request,
                          context);
              return ListSharedResourceSubscriptionsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listDataExchanges. */
  public PagedCallSettings<
          ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
      listDataExchangesSettings() {
    return listDataExchangesSettings;
  }

  /** Returns the object with the settings used for calls to listOrgDataExchanges. */
  public PagedCallSettings<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesSettings() {
    return listOrgDataExchangesSettings;
  }

  /** Returns the object with the settings used for calls to getDataExchange. */
  public UnaryCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeSettings() {
    return getDataExchangeSettings;
  }

  /** Returns the object with the settings used for calls to createDataExchange. */
  public UnaryCallSettings<CreateDataExchangeRequest, DataExchange> createDataExchangeSettings() {
    return createDataExchangeSettings;
  }

  /** Returns the object with the settings used for calls to updateDataExchange. */
  public UnaryCallSettings<UpdateDataExchangeRequest, DataExchange> updateDataExchangeSettings() {
    return updateDataExchangeSettings;
  }

  /** Returns the object with the settings used for calls to deleteDataExchange. */
  public UnaryCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeSettings() {
    return deleteDataExchangeSettings;
  }

  /** Returns the object with the settings used for calls to listListings. */
  public PagedCallSettings<ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
      listListingsSettings() {
    return listListingsSettings;
  }

  /** Returns the object with the settings used for calls to getListing. */
  public UnaryCallSettings<GetListingRequest, Listing> getListingSettings() {
    return getListingSettings;
  }

  /** Returns the object with the settings used for calls to createListing. */
  public UnaryCallSettings<CreateListingRequest, Listing> createListingSettings() {
    return createListingSettings;
  }

  /** Returns the object with the settings used for calls to updateListing. */
  public UnaryCallSettings<UpdateListingRequest, Listing> updateListingSettings() {
    return updateListingSettings;
  }

  /** Returns the object with the settings used for calls to deleteListing. */
  public UnaryCallSettings<DeleteListingRequest, Empty> deleteListingSettings() {
    return deleteListingSettings;
  }

  /** Returns the object with the settings used for calls to subscribeListing. */
  public UnaryCallSettings<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingSettings() {
    return subscribeListingSettings;
  }

  /** Returns the object with the settings used for calls to subscribeDataExchange. */
  public UnaryCallSettings<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeSettings() {
    return subscribeDataExchangeSettings;
  }

  /** Returns the object with the settings used for calls to subscribeDataExchange. */
  public OperationCallSettings<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationSettings() {
    return subscribeDataExchangeOperationSettings;
  }

  /** Returns the object with the settings used for calls to refreshSubscription. */
  public UnaryCallSettings<RefreshSubscriptionRequest, Operation> refreshSubscriptionSettings() {
    return refreshSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to refreshSubscription. */
  public OperationCallSettings<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationSettings() {
    return refreshSubscriptionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return getSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return listSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to listSharedResourceSubscriptions. */
  public PagedCallSettings<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsSettings() {
    return listSharedResourceSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to revokeSubscription. */
  public UnaryCallSettings<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionSettings() {
    return revokeSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings() {
    return deleteSubscriptionSettings;
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public OperationCallSettings<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationSettings() {
    return deleteSubscriptionOperationSettings;
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

  public AnalyticsHubServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcAnalyticsHubServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonAnalyticsHubServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "analyticshub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "analyticshub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "analyticshub.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(AnalyticsHubServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AnalyticsHubServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected AnalyticsHubServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listDataExchangesSettings = settingsBuilder.listDataExchangesSettings().build();
    listOrgDataExchangesSettings = settingsBuilder.listOrgDataExchangesSettings().build();
    getDataExchangeSettings = settingsBuilder.getDataExchangeSettings().build();
    createDataExchangeSettings = settingsBuilder.createDataExchangeSettings().build();
    updateDataExchangeSettings = settingsBuilder.updateDataExchangeSettings().build();
    deleteDataExchangeSettings = settingsBuilder.deleteDataExchangeSettings().build();
    listListingsSettings = settingsBuilder.listListingsSettings().build();
    getListingSettings = settingsBuilder.getListingSettings().build();
    createListingSettings = settingsBuilder.createListingSettings().build();
    updateListingSettings = settingsBuilder.updateListingSettings().build();
    deleteListingSettings = settingsBuilder.deleteListingSettings().build();
    subscribeListingSettings = settingsBuilder.subscribeListingSettings().build();
    subscribeDataExchangeSettings = settingsBuilder.subscribeDataExchangeSettings().build();
    subscribeDataExchangeOperationSettings =
        settingsBuilder.subscribeDataExchangeOperationSettings().build();
    refreshSubscriptionSettings = settingsBuilder.refreshSubscriptionSettings().build();
    refreshSubscriptionOperationSettings =
        settingsBuilder.refreshSubscriptionOperationSettings().build();
    getSubscriptionSettings = settingsBuilder.getSubscriptionSettings().build();
    listSubscriptionsSettings = settingsBuilder.listSubscriptionsSettings().build();
    listSharedResourceSubscriptionsSettings =
        settingsBuilder.listSharedResourceSubscriptionsSettings().build();
    revokeSubscriptionSettings = settingsBuilder.revokeSubscriptionSettings().build();
    deleteSubscriptionSettings = settingsBuilder.deleteSubscriptionSettings().build();
    deleteSubscriptionOperationSettings =
        settingsBuilder.deleteSubscriptionOperationSettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for AnalyticsHubServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<AnalyticsHubServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
        listDataExchangesSettings;
    private final PagedCallSettings.Builder<
            ListOrgDataExchangesRequest,
            ListOrgDataExchangesResponse,
            ListOrgDataExchangesPagedResponse>
        listOrgDataExchangesSettings;
    private final UnaryCallSettings.Builder<GetDataExchangeRequest, DataExchange>
        getDataExchangeSettings;
    private final UnaryCallSettings.Builder<CreateDataExchangeRequest, DataExchange>
        createDataExchangeSettings;
    private final UnaryCallSettings.Builder<UpdateDataExchangeRequest, DataExchange>
        updateDataExchangeSettings;
    private final UnaryCallSettings.Builder<DeleteDataExchangeRequest, Empty>
        deleteDataExchangeSettings;
    private final PagedCallSettings.Builder<
            ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
        listListingsSettings;
    private final UnaryCallSettings.Builder<GetListingRequest, Listing> getListingSettings;
    private final UnaryCallSettings.Builder<CreateListingRequest, Listing> createListingSettings;
    private final UnaryCallSettings.Builder<UpdateListingRequest, Listing> updateListingSettings;
    private final UnaryCallSettings.Builder<DeleteListingRequest, Empty> deleteListingSettings;
    private final UnaryCallSettings.Builder<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingSettings;
    private final UnaryCallSettings.Builder<SubscribeDataExchangeRequest, Operation>
        subscribeDataExchangeSettings;
    private final OperationCallSettings.Builder<
            SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
        subscribeDataExchangeOperationSettings;
    private final UnaryCallSettings.Builder<RefreshSubscriptionRequest, Operation>
        refreshSubscriptionSettings;
    private final OperationCallSettings.Builder<
            RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
        refreshSubscriptionOperationSettings;
    private final UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings;
    private final PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings;
    private final PagedCallSettings.Builder<
            ListSharedResourceSubscriptionsRequest,
            ListSharedResourceSubscriptionsResponse,
            ListSharedResourceSubscriptionsPagedResponse>
        listSharedResourceSubscriptionsSettings;
    private final UnaryCallSettings.Builder<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
        revokeSubscriptionSettings;
    private final UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings;
    private final OperationCallSettings.Builder<DeleteSubscriptionRequest, Empty, OperationMetadata>
        deleteSubscriptionOperationSettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listDataExchangesSettings = PagedCallSettings.newBuilder(LIST_DATA_EXCHANGES_PAGE_STR_FACT);
      listOrgDataExchangesSettings =
          PagedCallSettings.newBuilder(LIST_ORG_DATA_EXCHANGES_PAGE_STR_FACT);
      getDataExchangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createDataExchangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateDataExchangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteDataExchangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listListingsSettings = PagedCallSettings.newBuilder(LIST_LISTINGS_PAGE_STR_FACT);
      getListingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createListingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateListingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteListingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      subscribeListingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      subscribeDataExchangeSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      subscribeDataExchangeOperationSettings = OperationCallSettings.newBuilder();
      refreshSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      refreshSubscriptionOperationSettings = OperationCallSettings.newBuilder();
      getSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSubscriptionsSettings = PagedCallSettings.newBuilder(LIST_SUBSCRIPTIONS_PAGE_STR_FACT);
      listSharedResourceSubscriptionsSettings =
          PagedCallSettings.newBuilder(LIST_SHARED_RESOURCE_SUBSCRIPTIONS_PAGE_STR_FACT);
      revokeSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteSubscriptionOperationSettings = OperationCallSettings.newBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDataExchangesSettings,
              listOrgDataExchangesSettings,
              getDataExchangeSettings,
              createDataExchangeSettings,
              updateDataExchangeSettings,
              deleteDataExchangeSettings,
              listListingsSettings,
              getListingSettings,
              createListingSettings,
              updateListingSettings,
              deleteListingSettings,
              subscribeListingSettings,
              subscribeDataExchangeSettings,
              refreshSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              listSharedResourceSubscriptionsSettings,
              revokeSubscriptionSettings,
              deleteSubscriptionSettings,
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(AnalyticsHubServiceStubSettings settings) {
      super(settings);

      listDataExchangesSettings = settings.listDataExchangesSettings.toBuilder();
      listOrgDataExchangesSettings = settings.listOrgDataExchangesSettings.toBuilder();
      getDataExchangeSettings = settings.getDataExchangeSettings.toBuilder();
      createDataExchangeSettings = settings.createDataExchangeSettings.toBuilder();
      updateDataExchangeSettings = settings.updateDataExchangeSettings.toBuilder();
      deleteDataExchangeSettings = settings.deleteDataExchangeSettings.toBuilder();
      listListingsSettings = settings.listListingsSettings.toBuilder();
      getListingSettings = settings.getListingSettings.toBuilder();
      createListingSettings = settings.createListingSettings.toBuilder();
      updateListingSettings = settings.updateListingSettings.toBuilder();
      deleteListingSettings = settings.deleteListingSettings.toBuilder();
      subscribeListingSettings = settings.subscribeListingSettings.toBuilder();
      subscribeDataExchangeSettings = settings.subscribeDataExchangeSettings.toBuilder();
      subscribeDataExchangeOperationSettings =
          settings.subscribeDataExchangeOperationSettings.toBuilder();
      refreshSubscriptionSettings = settings.refreshSubscriptionSettings.toBuilder();
      refreshSubscriptionOperationSettings =
          settings.refreshSubscriptionOperationSettings.toBuilder();
      getSubscriptionSettings = settings.getSubscriptionSettings.toBuilder();
      listSubscriptionsSettings = settings.listSubscriptionsSettings.toBuilder();
      listSharedResourceSubscriptionsSettings =
          settings.listSharedResourceSubscriptionsSettings.toBuilder();
      revokeSubscriptionSettings = settings.revokeSubscriptionSettings.toBuilder();
      deleteSubscriptionSettings = settings.deleteSubscriptionSettings.toBuilder();
      deleteSubscriptionOperationSettings =
          settings.deleteSubscriptionOperationSettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listDataExchangesSettings,
              listOrgDataExchangesSettings,
              getDataExchangeSettings,
              createDataExchangeSettings,
              updateDataExchangeSettings,
              deleteDataExchangeSettings,
              listListingsSettings,
              getListingSettings,
              createListingSettings,
              updateListingSettings,
              deleteListingSettings,
              subscribeListingSettings,
              subscribeDataExchangeSettings,
              refreshSubscriptionSettings,
              getSubscriptionSettings,
              listSubscriptionsSettings,
              listSharedResourceSubscriptionsSettings,
              revokeSubscriptionSettings,
              deleteSubscriptionSettings,
              getIamPolicySettings,
              setIamPolicySettings,
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
          .listDataExchangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOrgDataExchangesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getDataExchangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createDataExchangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateDataExchangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteDataExchangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listListingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getListingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createListingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateListingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteListingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .subscribeListingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .subscribeDataExchangeSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .refreshSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSharedResourceSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .revokeSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .subscribeDataExchangeOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SubscribeDataExchangeRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  SubscribeDataExchangeResponse.class))
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
          .refreshSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<RefreshSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(
                  RefreshSubscriptionResponse.class))
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
          .deleteSubscriptionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteSubscriptionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"))
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

    /** Returns the builder for the settings used for calls to listDataExchanges. */
    public PagedCallSettings.Builder<
            ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
        listDataExchangesSettings() {
      return listDataExchangesSettings;
    }

    /** Returns the builder for the settings used for calls to listOrgDataExchanges. */
    public PagedCallSettings.Builder<
            ListOrgDataExchangesRequest,
            ListOrgDataExchangesResponse,
            ListOrgDataExchangesPagedResponse>
        listOrgDataExchangesSettings() {
      return listOrgDataExchangesSettings;
    }

    /** Returns the builder for the settings used for calls to getDataExchange. */
    public UnaryCallSettings.Builder<GetDataExchangeRequest, DataExchange>
        getDataExchangeSettings() {
      return getDataExchangeSettings;
    }

    /** Returns the builder for the settings used for calls to createDataExchange. */
    public UnaryCallSettings.Builder<CreateDataExchangeRequest, DataExchange>
        createDataExchangeSettings() {
      return createDataExchangeSettings;
    }

    /** Returns the builder for the settings used for calls to updateDataExchange. */
    public UnaryCallSettings.Builder<UpdateDataExchangeRequest, DataExchange>
        updateDataExchangeSettings() {
      return updateDataExchangeSettings;
    }

    /** Returns the builder for the settings used for calls to deleteDataExchange. */
    public UnaryCallSettings.Builder<DeleteDataExchangeRequest, Empty>
        deleteDataExchangeSettings() {
      return deleteDataExchangeSettings;
    }

    /** Returns the builder for the settings used for calls to listListings. */
    public PagedCallSettings.Builder<
            ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
        listListingsSettings() {
      return listListingsSettings;
    }

    /** Returns the builder for the settings used for calls to getListing. */
    public UnaryCallSettings.Builder<GetListingRequest, Listing> getListingSettings() {
      return getListingSettings;
    }

    /** Returns the builder for the settings used for calls to createListing. */
    public UnaryCallSettings.Builder<CreateListingRequest, Listing> createListingSettings() {
      return createListingSettings;
    }

    /** Returns the builder for the settings used for calls to updateListing. */
    public UnaryCallSettings.Builder<UpdateListingRequest, Listing> updateListingSettings() {
      return updateListingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteListing. */
    public UnaryCallSettings.Builder<DeleteListingRequest, Empty> deleteListingSettings() {
      return deleteListingSettings;
    }

    /** Returns the builder for the settings used for calls to subscribeListing. */
    public UnaryCallSettings.Builder<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingSettings() {
      return subscribeListingSettings;
    }

    /** Returns the builder for the settings used for calls to subscribeDataExchange. */
    public UnaryCallSettings.Builder<SubscribeDataExchangeRequest, Operation>
        subscribeDataExchangeSettings() {
      return subscribeDataExchangeSettings;
    }

    /** Returns the builder for the settings used for calls to subscribeDataExchange. */
    public OperationCallSettings.Builder<
            SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
        subscribeDataExchangeOperationSettings() {
      return subscribeDataExchangeOperationSettings;
    }

    /** Returns the builder for the settings used for calls to refreshSubscription. */
    public UnaryCallSettings.Builder<RefreshSubscriptionRequest, Operation>
        refreshSubscriptionSettings() {
      return refreshSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to refreshSubscription. */
    public OperationCallSettings.Builder<
            RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
        refreshSubscriptionOperationSettings() {
      return refreshSubscriptionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return listSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to listSharedResourceSubscriptions. */
    public PagedCallSettings.Builder<
            ListSharedResourceSubscriptionsRequest,
            ListSharedResourceSubscriptionsResponse,
            ListSharedResourceSubscriptionsPagedResponse>
        listSharedResourceSubscriptionsSettings() {
      return listSharedResourceSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to revokeSubscription. */
    public UnaryCallSettings.Builder<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
        revokeSubscriptionSettings() {
      return revokeSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings() {
      return deleteSubscriptionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public OperationCallSettings.Builder<DeleteSubscriptionRequest, Empty, OperationMetadata>
        deleteSubscriptionOperationSettings() {
      return deleteSubscriptionOperationSettings;
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

    @Override
    public AnalyticsHubServiceStubSettings build() throws IOException {
      return new AnalyticsHubServiceStubSettings(this);
    }
  }
}
