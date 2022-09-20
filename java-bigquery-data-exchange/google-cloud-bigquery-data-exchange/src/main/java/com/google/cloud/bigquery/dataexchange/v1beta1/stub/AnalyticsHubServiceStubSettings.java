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

package com.google.cloud.bigquery.dataexchange.v1beta1.stub;

import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.bigquery.dataexchange.v1beta1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
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
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.CreateListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DataExchange;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.DeleteListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.GetListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListListingsResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.ListOrgDataExchangesResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.Listing;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.SubscribeListingResponse;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateDataExchangeRequest;
import com.google.cloud.bigquery.dataexchange.v1beta1.UpdateListingRequest;
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
@BetaApi
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
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

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

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
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

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(AnalyticsHubServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
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
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
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
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
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
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

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
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              listLocationsSettings,
              getLocationSettings);
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
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

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
              getIamPolicySettings,
              setIamPolicySettings,
              testIamPermissionsSettings,
              listLocationsSettings,
              getLocationSettings);
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
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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
    public AnalyticsHubServiceStubSettings build() throws IOException {
      return new AnalyticsHubServiceStubSettings(this);
    }
  }
}
