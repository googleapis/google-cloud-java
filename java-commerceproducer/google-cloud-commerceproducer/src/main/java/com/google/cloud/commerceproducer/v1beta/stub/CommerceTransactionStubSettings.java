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

package com.google.cloud.commerceproducer.v1beta.stub;

import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListLocationsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOfferDocumentsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOffersPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListServicesPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkuGroupsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkusPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListStandardOffersPagedResponse;

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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.LibraryMetadata;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.commerceproducer.v1beta.CancelPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.CreatePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.DeletePrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.GetPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.GetServiceRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuGroupRequest;
import com.google.cloud.commerceproducer.v1beta.GetSkuRequest;
import com.google.cloud.commerceproducer.v1beta.GetStandardOfferRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOfferDocumentsResponse;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListPrivateOffersResponse;
import com.google.cloud.commerceproducer.v1beta.ListServicesRequest;
import com.google.cloud.commerceproducer.v1beta.ListServicesResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkuGroupsResponse;
import com.google.cloud.commerceproducer.v1beta.ListSkusRequest;
import com.google.cloud.commerceproducer.v1beta.ListSkusResponse;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersRequest;
import com.google.cloud.commerceproducer.v1beta.ListStandardOffersResponse;
import com.google.cloud.commerceproducer.v1beta.PrivateOffer;
import com.google.cloud.commerceproducer.v1beta.PrivateOfferDocument;
import com.google.cloud.commerceproducer.v1beta.PublishPrivateOfferRequest;
import com.google.cloud.commerceproducer.v1beta.Service;
import com.google.cloud.commerceproducer.v1beta.Sku;
import com.google.cloud.commerceproducer.v1beta.SkuGroup;
import com.google.cloud.commerceproducer.v1beta.StandardOffer;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferDocumentRequest;
import com.google.cloud.commerceproducer.v1beta.UpdatePrivateOfferRequest;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CommerceTransactionStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (commerceproducer.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getService:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CommerceTransactionStubSettings.Builder commerceTransactionSettingsBuilder =
 *     CommerceTransactionStubSettings.newBuilder();
 * commerceTransactionSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         commerceTransactionSettingsBuilder
 *             .getServiceSettings()
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
 * CommerceTransactionStubSettings commerceTransactionSettings =
 *     commerceTransactionSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class CommerceTransactionStubSettings extends StubSettings<CommerceTransactionStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings;
  private final UnaryCallSettings<GetServiceRequest, Service> getServiceSettings;
  private final PagedCallSettings<
          ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
      listPrivateOffersSettings;
  private final UnaryCallSettings<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferSettings;
  private final UnaryCallSettings<CreatePrivateOfferRequest, PrivateOffer>
      createPrivateOfferSettings;
  private final UnaryCallSettings<UpdatePrivateOfferRequest, PrivateOffer>
      updatePrivateOfferSettings;
  private final UnaryCallSettings<PublishPrivateOfferRequest, PrivateOffer>
      publishPrivateOfferSettings;
  private final UnaryCallSettings<CancelPrivateOfferRequest, PrivateOffer>
      cancelPrivateOfferSettings;
  private final UnaryCallSettings<DeletePrivateOfferRequest, Empty> deletePrivateOfferSettings;
  private final PagedCallSettings<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsSettings;
  private final UnaryCallSettings<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentSettings;
  private final UnaryCallSettings<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentSettings;
  private final UnaryCallSettings<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentSettings;
  private final UnaryCallSettings<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentSettings;
  private final PagedCallSettings<
          ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
      listStandardOffersSettings;
  private final UnaryCallSettings<GetStandardOfferRequest, StandardOffer> getStandardOfferSettings;
  private final UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings;
  private final PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings;
  private final UnaryCallSettings<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings;
  private final PagedCallSettings<
          ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
      listSkuGroupsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>
      LIST_SERVICES_PAGE_STR_DESC =
          new PagedListDescriptor<ListServicesRequest, ListServicesResponse, Service>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServicesRequest injectToken(ListServicesRequest payload, String token) {
              return ListServicesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServicesRequest injectPageSize(ListServicesRequest payload, int pageSize) {
              return ListServicesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServicesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServicesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Service> extractResources(ListServicesResponse payload) {
              return payload.getServicesList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>
      LIST_PRIVATE_OFFERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateOffersRequest injectToken(
                ListPrivateOffersRequest payload, String token) {
              return ListPrivateOffersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateOffersRequest injectPageSize(
                ListPrivateOffersRequest payload, int pageSize) {
              return ListPrivateOffersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPrivateOffersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateOffersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateOffer> extractResources(ListPrivateOffersResponse payload) {
              return payload.getPrivateOffersList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse, PrivateOfferDocument>
      LIST_PRIVATE_OFFER_DOCUMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateOfferDocumentsRequest,
              ListPrivateOfferDocumentsResponse,
              PrivateOfferDocument>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateOfferDocumentsRequest injectToken(
                ListPrivateOfferDocumentsRequest payload, String token) {
              return ListPrivateOfferDocumentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListPrivateOfferDocumentsRequest injectPageSize(
                ListPrivateOfferDocumentsRequest payload, int pageSize) {
              return ListPrivateOfferDocumentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrivateOfferDocumentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateOfferDocumentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateOfferDocument> extractResources(
                ListPrivateOfferDocumentsResponse payload) {
              return payload.getPrivateOfferDocumentsList();
            }
          };

  private static final PagedListDescriptor<
          ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>
      LIST_STANDARD_OFFERS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStandardOffersRequest injectToken(
                ListStandardOffersRequest payload, String token) {
              return ListStandardOffersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStandardOffersRequest injectPageSize(
                ListStandardOffersRequest payload, int pageSize) {
              return ListStandardOffersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStandardOffersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStandardOffersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StandardOffer> extractResources(ListStandardOffersResponse payload) {
              return payload.getStandardOffersList();
            }
          };

  private static final PagedListDescriptor<ListSkusRequest, ListSkusResponse, Sku>
      LIST_SKUS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSkusRequest, ListSkusResponse, Sku>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSkusRequest injectToken(ListSkusRequest payload, String token) {
              return ListSkusRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSkusRequest injectPageSize(ListSkusRequest payload, int pageSize) {
              return ListSkusRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSkusRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSkusResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Sku> extractResources(ListSkusResponse payload) {
              return payload.getSkusList();
            }
          };

  private static final PagedListDescriptor<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup>
      LIST_SKU_GROUPS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSkuGroupsRequest injectToken(ListSkuGroupsRequest payload, String token) {
              return ListSkuGroupsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSkuGroupsRequest injectPageSize(ListSkuGroupsRequest payload, int pageSize) {
              return ListSkuGroupsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSkuGroupsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSkuGroupsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<SkuGroup> extractResources(ListSkuGroupsResponse payload) {
              return payload.getSkuGroupsList();
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
          ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      LIST_SERVICES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>() {
            @Override
            public ApiFuture<ListServicesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServicesRequest, ListServicesResponse> callable,
                ListServicesRequest request,
                ApiCallContext context,
                ApiFuture<ListServicesResponse> futureResponse) {
              PageContext<ListServicesRequest, ListServicesResponse, Service> pageContext =
                  PageContext.create(callable, LIST_SERVICES_PAGE_STR_DESC, request, context);
              return ListServicesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
      LIST_PRIVATE_OFFERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateOffersRequest,
              ListPrivateOffersResponse,
              ListPrivateOffersPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateOffersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateOffersRequest, ListPrivateOffersResponse> callable,
                ListPrivateOffersRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateOffersResponse> futureResponse) {
              PageContext<ListPrivateOffersRequest, ListPrivateOffersResponse, PrivateOffer>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_OFFERS_PAGE_STR_DESC, request, context);
              return ListPrivateOffersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          ListPrivateOfferDocumentsPagedResponse>
      LIST_PRIVATE_OFFER_DOCUMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateOfferDocumentsRequest,
              ListPrivateOfferDocumentsResponse,
              ListPrivateOfferDocumentsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateOfferDocumentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateOfferDocumentsRequest, ListPrivateOfferDocumentsResponse>
                    callable,
                ListPrivateOfferDocumentsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateOfferDocumentsResponse> futureResponse) {
              PageContext<
                      ListPrivateOfferDocumentsRequest,
                      ListPrivateOfferDocumentsResponse,
                      PrivateOfferDocument>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_OFFER_DOCUMENTS_PAGE_STR_DESC, request, context);
              return ListPrivateOfferDocumentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
      LIST_STANDARD_OFFERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStandardOffersRequest,
              ListStandardOffersResponse,
              ListStandardOffersPagedResponse>() {
            @Override
            public ApiFuture<ListStandardOffersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStandardOffersRequest, ListStandardOffersResponse> callable,
                ListStandardOffersRequest request,
                ApiCallContext context,
                ApiFuture<ListStandardOffersResponse> futureResponse) {
              PageContext<ListStandardOffersRequest, ListStandardOffersResponse, StandardOffer>
                  pageContext =
                      PageContext.create(
                          callable, LIST_STANDARD_OFFERS_PAGE_STR_DESC, request, context);
              return ListStandardOffersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      LIST_SKUS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>() {
            @Override
            public ApiFuture<ListSkusPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSkusRequest, ListSkusResponse> callable,
                ListSkusRequest request,
                ApiCallContext context,
                ApiFuture<ListSkusResponse> futureResponse) {
              PageContext<ListSkusRequest, ListSkusResponse, Sku> pageContext =
                  PageContext.create(callable, LIST_SKUS_PAGE_STR_DESC, request, context);
              return ListSkusPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
      LIST_SKU_GROUPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>() {
            @Override
            public ApiFuture<ListSkuGroupsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSkuGroupsRequest, ListSkuGroupsResponse> callable,
                ListSkuGroupsRequest request,
                ApiCallContext context,
                ApiFuture<ListSkuGroupsResponse> futureResponse) {
              PageContext<ListSkuGroupsRequest, ListSkuGroupsResponse, SkuGroup> pageContext =
                  PageContext.create(callable, LIST_SKU_GROUPS_PAGE_STR_DESC, request, context);
              return ListSkuGroupsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return listServicesSettings;
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return getServiceSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateOffers. */
  public PagedCallSettings<
          ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
      listPrivateOffersSettings() {
    return listPrivateOffersSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateOffer. */
  public UnaryCallSettings<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferSettings() {
    return getPrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateOffer. */
  public UnaryCallSettings<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferSettings() {
    return createPrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateOffer. */
  public UnaryCallSettings<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferSettings() {
    return updatePrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to publishPrivateOffer. */
  public UnaryCallSettings<PublishPrivateOfferRequest, PrivateOffer> publishPrivateOfferSettings() {
    return publishPrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to cancelPrivateOffer. */
  public UnaryCallSettings<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferSettings() {
    return cancelPrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateOffer. */
  public UnaryCallSettings<DeletePrivateOfferRequest, Empty> deletePrivateOfferSettings() {
    return deletePrivateOfferSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateOfferDocuments. */
  public PagedCallSettings<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsSettings() {
    return listPrivateOfferDocumentsSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateOfferDocument. */
  public UnaryCallSettings<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentSettings() {
    return getPrivateOfferDocumentSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateOfferDocument. */
  public UnaryCallSettings<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentSettings() {
    return createPrivateOfferDocumentSettings;
  }

  /** Returns the object with the settings used for calls to updatePrivateOfferDocument. */
  public UnaryCallSettings<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentSettings() {
    return updatePrivateOfferDocumentSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateOfferDocument. */
  public UnaryCallSettings<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentSettings() {
    return deletePrivateOfferDocumentSettings;
  }

  /** Returns the object with the settings used for calls to listStandardOffers. */
  public PagedCallSettings<
          ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
      listStandardOffersSettings() {
    return listStandardOffersSettings;
  }

  /** Returns the object with the settings used for calls to getStandardOffer. */
  public UnaryCallSettings<GetStandardOfferRequest, StandardOffer> getStandardOfferSettings() {
    return getStandardOfferSettings;
  }

  /** Returns the object with the settings used for calls to getSku. */
  public UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings() {
    return getSkuSettings;
  }

  /** Returns the object with the settings used for calls to listSkus. */
  public PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings() {
    return listSkusSettings;
  }

  /** Returns the object with the settings used for calls to getSkuGroup. */
  public UnaryCallSettings<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings() {
    return getSkuGroupSettings;
  }

  /** Returns the object with the settings used for calls to listSkuGroups. */
  public PagedCallSettings<ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
      listSkuGroupsSettings() {
    return listSkuGroupsSettings;
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

  public CommerceTransactionStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcCommerceTransactionStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonCommerceTransactionStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "commerceproducer";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "commerceproducer.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "commerceproducer.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(CommerceTransactionStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(CommerceTransactionStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CommerceTransactionStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected CommerceTransactionStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listServicesSettings = settingsBuilder.listServicesSettings().build();
    getServiceSettings = settingsBuilder.getServiceSettings().build();
    listPrivateOffersSettings = settingsBuilder.listPrivateOffersSettings().build();
    getPrivateOfferSettings = settingsBuilder.getPrivateOfferSettings().build();
    createPrivateOfferSettings = settingsBuilder.createPrivateOfferSettings().build();
    updatePrivateOfferSettings = settingsBuilder.updatePrivateOfferSettings().build();
    publishPrivateOfferSettings = settingsBuilder.publishPrivateOfferSettings().build();
    cancelPrivateOfferSettings = settingsBuilder.cancelPrivateOfferSettings().build();
    deletePrivateOfferSettings = settingsBuilder.deletePrivateOfferSettings().build();
    listPrivateOfferDocumentsSettings = settingsBuilder.listPrivateOfferDocumentsSettings().build();
    getPrivateOfferDocumentSettings = settingsBuilder.getPrivateOfferDocumentSettings().build();
    createPrivateOfferDocumentSettings =
        settingsBuilder.createPrivateOfferDocumentSettings().build();
    updatePrivateOfferDocumentSettings =
        settingsBuilder.updatePrivateOfferDocumentSettings().build();
    deletePrivateOfferDocumentSettings =
        settingsBuilder.deletePrivateOfferDocumentSettings().build();
    listStandardOffersSettings = settingsBuilder.listStandardOffersSettings().build();
    getStandardOfferSettings = settingsBuilder.getStandardOfferSettings().build();
    getSkuSettings = settingsBuilder.getSkuSettings().build();
    listSkusSettings = settingsBuilder.listSkusSettings().build();
    getSkuGroupSettings = settingsBuilder.getSkuGroupSettings().build();
    listSkuGroupsSettings = settingsBuilder.listSkuGroupsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:google-cloud-commerceproducer")
        .setRepository("googleapis/google-cloud-java")
        .setVersion(Version.VERSION)
        .build();
  }

  /** Builder for CommerceTransactionStubSettings. */
  public static class Builder
      extends StubSettings.Builder<CommerceTransactionStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings;
    private final UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings;
    private final PagedCallSettings.Builder<
            ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
        listPrivateOffersSettings;
    private final UnaryCallSettings.Builder<GetPrivateOfferRequest, PrivateOffer>
        getPrivateOfferSettings;
    private final UnaryCallSettings.Builder<CreatePrivateOfferRequest, PrivateOffer>
        createPrivateOfferSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateOfferRequest, PrivateOffer>
        updatePrivateOfferSettings;
    private final UnaryCallSettings.Builder<PublishPrivateOfferRequest, PrivateOffer>
        publishPrivateOfferSettings;
    private final UnaryCallSettings.Builder<CancelPrivateOfferRequest, PrivateOffer>
        cancelPrivateOfferSettings;
    private final UnaryCallSettings.Builder<DeletePrivateOfferRequest, Empty>
        deletePrivateOfferSettings;
    private final PagedCallSettings.Builder<
            ListPrivateOfferDocumentsRequest,
            ListPrivateOfferDocumentsResponse,
            ListPrivateOfferDocumentsPagedResponse>
        listPrivateOfferDocumentsSettings;
    private final UnaryCallSettings.Builder<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
        getPrivateOfferDocumentSettings;
    private final UnaryCallSettings.Builder<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
        createPrivateOfferDocumentSettings;
    private final UnaryCallSettings.Builder<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
        updatePrivateOfferDocumentSettings;
    private final UnaryCallSettings.Builder<DeletePrivateOfferDocumentRequest, Empty>
        deletePrivateOfferDocumentSettings;
    private final PagedCallSettings.Builder<
            ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
        listStandardOffersSettings;
    private final UnaryCallSettings.Builder<GetStandardOfferRequest, StandardOffer>
        getStandardOfferSettings;
    private final UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings;
    private final PagedCallSettings.Builder<
            ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings;
    private final UnaryCallSettings.Builder<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings;
    private final PagedCallSettings.Builder<
            ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
        listSkuGroupsSettings;
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

      listServicesSettings = PagedCallSettings.newBuilder(LIST_SERVICES_PAGE_STR_FACT);
      getServiceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateOffersSettings = PagedCallSettings.newBuilder(LIST_PRIVATE_OFFERS_PAGE_STR_FACT);
      getPrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      publishPrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelPrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateOfferDocumentsSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_OFFER_DOCUMENTS_PAGE_STR_FACT);
      getPrivateOfferDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateOfferDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePrivateOfferDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateOfferDocumentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStandardOffersSettings = PagedCallSettings.newBuilder(LIST_STANDARD_OFFERS_PAGE_STR_FACT);
      getStandardOfferSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getSkuSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSkusSettings = PagedCallSettings.newBuilder(LIST_SKUS_PAGE_STR_FACT);
      getSkuGroupSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listSkuGroupsSettings = PagedCallSettings.newBuilder(LIST_SKU_GROUPS_PAGE_STR_FACT);
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServicesSettings,
              getServiceSettings,
              listPrivateOffersSettings,
              getPrivateOfferSettings,
              createPrivateOfferSettings,
              updatePrivateOfferSettings,
              publishPrivateOfferSettings,
              cancelPrivateOfferSettings,
              deletePrivateOfferSettings,
              listPrivateOfferDocumentsSettings,
              getPrivateOfferDocumentSettings,
              createPrivateOfferDocumentSettings,
              updatePrivateOfferDocumentSettings,
              deletePrivateOfferDocumentSettings,
              listStandardOffersSettings,
              getStandardOfferSettings,
              getSkuSettings,
              listSkusSettings,
              getSkuGroupSettings,
              listSkuGroupsSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(CommerceTransactionStubSettings settings) {
      super(settings);

      listServicesSettings = settings.listServicesSettings.toBuilder();
      getServiceSettings = settings.getServiceSettings.toBuilder();
      listPrivateOffersSettings = settings.listPrivateOffersSettings.toBuilder();
      getPrivateOfferSettings = settings.getPrivateOfferSettings.toBuilder();
      createPrivateOfferSettings = settings.createPrivateOfferSettings.toBuilder();
      updatePrivateOfferSettings = settings.updatePrivateOfferSettings.toBuilder();
      publishPrivateOfferSettings = settings.publishPrivateOfferSettings.toBuilder();
      cancelPrivateOfferSettings = settings.cancelPrivateOfferSettings.toBuilder();
      deletePrivateOfferSettings = settings.deletePrivateOfferSettings.toBuilder();
      listPrivateOfferDocumentsSettings = settings.listPrivateOfferDocumentsSettings.toBuilder();
      getPrivateOfferDocumentSettings = settings.getPrivateOfferDocumentSettings.toBuilder();
      createPrivateOfferDocumentSettings = settings.createPrivateOfferDocumentSettings.toBuilder();
      updatePrivateOfferDocumentSettings = settings.updatePrivateOfferDocumentSettings.toBuilder();
      deletePrivateOfferDocumentSettings = settings.deletePrivateOfferDocumentSettings.toBuilder();
      listStandardOffersSettings = settings.listStandardOffersSettings.toBuilder();
      getStandardOfferSettings = settings.getStandardOfferSettings.toBuilder();
      getSkuSettings = settings.getSkuSettings.toBuilder();
      listSkusSettings = settings.listSkusSettings.toBuilder();
      getSkuGroupSettings = settings.getSkuGroupSettings.toBuilder();
      listSkuGroupsSettings = settings.listSkuGroupsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listServicesSettings,
              getServiceSettings,
              listPrivateOffersSettings,
              getPrivateOfferSettings,
              createPrivateOfferSettings,
              updatePrivateOfferSettings,
              publishPrivateOfferSettings,
              cancelPrivateOfferSettings,
              deletePrivateOfferSettings,
              listPrivateOfferDocumentsSettings,
              getPrivateOfferDocumentSettings,
              createPrivateOfferDocumentSettings,
              updatePrivateOfferDocumentSettings,
              deletePrivateOfferDocumentSettings,
              listStandardOffersSettings,
              getStandardOfferSettings,
              getSkuSettings,
              listSkusSettings,
              getSkuGroupSettings,
              listSkuGroupsSettings,
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
          .listServicesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getServiceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPrivateOffersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .publishPrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .cancelPrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePrivateOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listPrivateOfferDocumentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPrivateOfferDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateOfferDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePrivateOfferDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePrivateOfferDocumentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listStandardOffersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getStandardOfferSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSkuSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSkusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getSkuGroupSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listSkuGroupsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return listServicesSettings;
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getServiceSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateOffers. */
    public PagedCallSettings.Builder<
            ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
        listPrivateOffersSettings() {
      return listPrivateOffersSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateOffer. */
    public UnaryCallSettings.Builder<GetPrivateOfferRequest, PrivateOffer>
        getPrivateOfferSettings() {
      return getPrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateOffer. */
    public UnaryCallSettings.Builder<CreatePrivateOfferRequest, PrivateOffer>
        createPrivateOfferSettings() {
      return createPrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateOffer. */
    public UnaryCallSettings.Builder<UpdatePrivateOfferRequest, PrivateOffer>
        updatePrivateOfferSettings() {
      return updatePrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to publishPrivateOffer. */
    public UnaryCallSettings.Builder<PublishPrivateOfferRequest, PrivateOffer>
        publishPrivateOfferSettings() {
      return publishPrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to cancelPrivateOffer. */
    public UnaryCallSettings.Builder<CancelPrivateOfferRequest, PrivateOffer>
        cancelPrivateOfferSettings() {
      return cancelPrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateOffer. */
    public UnaryCallSettings.Builder<DeletePrivateOfferRequest, Empty>
        deletePrivateOfferSettings() {
      return deletePrivateOfferSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateOfferDocuments. */
    public PagedCallSettings.Builder<
            ListPrivateOfferDocumentsRequest,
            ListPrivateOfferDocumentsResponse,
            ListPrivateOfferDocumentsPagedResponse>
        listPrivateOfferDocumentsSettings() {
      return listPrivateOfferDocumentsSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateOfferDocument. */
    public UnaryCallSettings.Builder<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
        getPrivateOfferDocumentSettings() {
      return getPrivateOfferDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateOfferDocument. */
    public UnaryCallSettings.Builder<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
        createPrivateOfferDocumentSettings() {
      return createPrivateOfferDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to updatePrivateOfferDocument. */
    public UnaryCallSettings.Builder<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
        updatePrivateOfferDocumentSettings() {
      return updatePrivateOfferDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateOfferDocument. */
    public UnaryCallSettings.Builder<DeletePrivateOfferDocumentRequest, Empty>
        deletePrivateOfferDocumentSettings() {
      return deletePrivateOfferDocumentSettings;
    }

    /** Returns the builder for the settings used for calls to listStandardOffers. */
    public PagedCallSettings.Builder<
            ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
        listStandardOffersSettings() {
      return listStandardOffersSettings;
    }

    /** Returns the builder for the settings used for calls to getStandardOffer. */
    public UnaryCallSettings.Builder<GetStandardOfferRequest, StandardOffer>
        getStandardOfferSettings() {
      return getStandardOfferSettings;
    }

    /** Returns the builder for the settings used for calls to getSku. */
    public UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings() {
      return getSkuSettings;
    }

    /** Returns the builder for the settings used for calls to listSkus. */
    public PagedCallSettings.Builder<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings() {
      return listSkusSettings;
    }

    /** Returns the builder for the settings used for calls to getSkuGroup. */
    public UnaryCallSettings.Builder<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings() {
      return getSkuGroupSettings;
    }

    /** Returns the builder for the settings used for calls to listSkuGroups. */
    public PagedCallSettings.Builder<
            ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
        listSkuGroupsSettings() {
      return listSkuGroupsSettings;
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
    public CommerceTransactionStubSettings build() throws IOException {
      return new CommerceTransactionStubSettings(this);
    }
  }
}
