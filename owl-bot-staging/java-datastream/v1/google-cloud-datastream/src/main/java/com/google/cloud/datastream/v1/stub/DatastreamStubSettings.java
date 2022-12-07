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

package com.google.cloud.datastream.v1.stub;

import static com.google.cloud.datastream.v1.DatastreamClient.FetchStaticIpsPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListConnectionProfilesPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListLocationsPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListPrivateConnectionsPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListRoutesPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListStreamObjectsPagedResponse;
import static com.google.cloud.datastream.v1.DatastreamClient.ListStreamsPagedResponse;

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
import com.google.cloud.datastream.v1.ConnectionProfile;
import com.google.cloud.datastream.v1.CreateConnectionProfileRequest;
import com.google.cloud.datastream.v1.CreatePrivateConnectionRequest;
import com.google.cloud.datastream.v1.CreateRouteRequest;
import com.google.cloud.datastream.v1.CreateStreamRequest;
import com.google.cloud.datastream.v1.DeleteConnectionProfileRequest;
import com.google.cloud.datastream.v1.DeletePrivateConnectionRequest;
import com.google.cloud.datastream.v1.DeleteRouteRequest;
import com.google.cloud.datastream.v1.DeleteStreamRequest;
import com.google.cloud.datastream.v1.DiscoverConnectionProfileRequest;
import com.google.cloud.datastream.v1.DiscoverConnectionProfileResponse;
import com.google.cloud.datastream.v1.FetchStaticIpsRequest;
import com.google.cloud.datastream.v1.FetchStaticIpsResponse;
import com.google.cloud.datastream.v1.GetConnectionProfileRequest;
import com.google.cloud.datastream.v1.GetPrivateConnectionRequest;
import com.google.cloud.datastream.v1.GetRouteRequest;
import com.google.cloud.datastream.v1.GetStreamObjectRequest;
import com.google.cloud.datastream.v1.GetStreamRequest;
import com.google.cloud.datastream.v1.ListConnectionProfilesRequest;
import com.google.cloud.datastream.v1.ListConnectionProfilesResponse;
import com.google.cloud.datastream.v1.ListPrivateConnectionsRequest;
import com.google.cloud.datastream.v1.ListPrivateConnectionsResponse;
import com.google.cloud.datastream.v1.ListRoutesRequest;
import com.google.cloud.datastream.v1.ListRoutesResponse;
import com.google.cloud.datastream.v1.ListStreamObjectsRequest;
import com.google.cloud.datastream.v1.ListStreamObjectsResponse;
import com.google.cloud.datastream.v1.ListStreamsRequest;
import com.google.cloud.datastream.v1.ListStreamsResponse;
import com.google.cloud.datastream.v1.LookupStreamObjectRequest;
import com.google.cloud.datastream.v1.OperationMetadata;
import com.google.cloud.datastream.v1.PrivateConnection;
import com.google.cloud.datastream.v1.Route;
import com.google.cloud.datastream.v1.StartBackfillJobRequest;
import com.google.cloud.datastream.v1.StartBackfillJobResponse;
import com.google.cloud.datastream.v1.StopBackfillJobRequest;
import com.google.cloud.datastream.v1.StopBackfillJobResponse;
import com.google.cloud.datastream.v1.Stream;
import com.google.cloud.datastream.v1.StreamObject;
import com.google.cloud.datastream.v1.UpdateConnectionProfileRequest;
import com.google.cloud.datastream.v1.UpdateStreamRequest;
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
 * Settings class to configure an instance of {@link DatastreamStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (datastream.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getConnectionProfile to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DatastreamStubSettings.Builder datastreamSettingsBuilder = DatastreamStubSettings.newBuilder();
 * datastreamSettingsBuilder
 *     .getConnectionProfileSettings()
 *     .setRetrySettings(
 *         datastreamSettingsBuilder.getConnectionProfileSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * DatastreamStubSettings datastreamSettings = datastreamSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DatastreamStubSettings extends StubSettings<DatastreamStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings;
  private final UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings;
  private final UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings;
  private final OperationCallSettings<
          CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings;
  private final UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings;
  private final OperationCallSettings<
          UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings;
  private final UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings;
  private final OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings;
  private final UnaryCallSettings<
          DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileSettings;
  private final PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings;
  private final UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings;
  private final UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings;
  private final OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings;
  private final UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings;
  private final OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings;
  private final UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings;
  private final OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings;
  private final UnaryCallSettings<GetStreamObjectRequest, StreamObject> getStreamObjectSettings;
  private final UnaryCallSettings<LookupStreamObjectRequest, StreamObject>
      lookupStreamObjectSettings;
  private final PagedCallSettings<
          ListStreamObjectsRequest, ListStreamObjectsResponse, ListStreamObjectsPagedResponse>
      listStreamObjectsSettings;
  private final UnaryCallSettings<StartBackfillJobRequest, StartBackfillJobResponse>
      startBackfillJobSettings;
  private final UnaryCallSettings<StopBackfillJobRequest, StopBackfillJobResponse>
      stopBackfillJobSettings;
  private final PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings;
  private final UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings;
  private final OperationCallSettings<
          CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings;
  private final UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings;
  private final PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings;
  private final UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings;
  private final OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings;
  private final UnaryCallSettings<CreateRouteRequest, Operation> createRouteSettings;
  private final OperationCallSettings<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationSettings;
  private final UnaryCallSettings<GetRouteRequest, Route> getRouteSettings;
  private final PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings;
  private final UnaryCallSettings<DeleteRouteRequest, Operation> deleteRouteSettings;
  private final OperationCallSettings<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;

  private static final PagedListDescriptor<
          ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>
      LIST_CONNECTION_PROFILES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConnectionProfilesRequest, ListConnectionProfilesResponse, ConnectionProfile>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConnectionProfilesRequest injectToken(
                ListConnectionProfilesRequest payload, String token) {
              return ListConnectionProfilesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConnectionProfilesRequest injectPageSize(
                ListConnectionProfilesRequest payload, int pageSize) {
              return ListConnectionProfilesRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListConnectionProfilesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConnectionProfilesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConnectionProfile> extractResources(
                ListConnectionProfilesResponse payload) {
              return payload.getConnectionProfilesList() == null
                  ? ImmutableList.<ConnectionProfile>of()
                  : payload.getConnectionProfilesList();
            }
          };

  private static final PagedListDescriptor<ListStreamsRequest, ListStreamsResponse, Stream>
      LIST_STREAMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListStreamsRequest, ListStreamsResponse, Stream>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStreamsRequest injectToken(ListStreamsRequest payload, String token) {
              return ListStreamsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStreamsRequest injectPageSize(ListStreamsRequest payload, int pageSize) {
              return ListStreamsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStreamsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStreamsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Stream> extractResources(ListStreamsResponse payload) {
              return payload.getStreamsList() == null
                  ? ImmutableList.<Stream>of()
                  : payload.getStreamsList();
            }
          };

  private static final PagedListDescriptor<
          ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject>
      LIST_STREAM_OBJECTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListStreamObjectsRequest injectToken(
                ListStreamObjectsRequest payload, String token) {
              return ListStreamObjectsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListStreamObjectsRequest injectPageSize(
                ListStreamObjectsRequest payload, int pageSize) {
              return ListStreamObjectsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListStreamObjectsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListStreamObjectsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<StreamObject> extractResources(ListStreamObjectsResponse payload) {
              return payload.getStreamObjectsList() == null
                  ? ImmutableList.<StreamObject>of()
                  : payload.getStreamObjectsList();
            }
          };

  private static final PagedListDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse, String>
      FETCH_STATIC_IPS_PAGE_STR_DESC =
          new PagedListDescriptor<FetchStaticIpsRequest, FetchStaticIpsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public FetchStaticIpsRequest injectToken(FetchStaticIpsRequest payload, String token) {
              return FetchStaticIpsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public FetchStaticIpsRequest injectPageSize(
                FetchStaticIpsRequest payload, int pageSize) {
              return FetchStaticIpsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(FetchStaticIpsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(FetchStaticIpsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(FetchStaticIpsResponse payload) {
              return payload.getStaticIpsList() == null
                  ? ImmutableList.<String>of()
                  : payload.getStaticIpsList();
            }
          };

  private static final PagedListDescriptor<
          ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListPrivateConnectionsRequest, ListPrivateConnectionsResponse, PrivateConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPrivateConnectionsRequest injectToken(
                ListPrivateConnectionsRequest payload, String token) {
              return ListPrivateConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPrivateConnectionsRequest injectPageSize(
                ListPrivateConnectionsRequest payload, int pageSize) {
              return ListPrivateConnectionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListPrivateConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPrivateConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<PrivateConnection> extractResources(
                ListPrivateConnectionsResponse payload) {
              return payload.getPrivateConnectionsList() == null
                  ? ImmutableList.<PrivateConnection>of()
                  : payload.getPrivateConnectionsList();
            }
          };

  private static final PagedListDescriptor<ListRoutesRequest, ListRoutesResponse, Route>
      LIST_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoutesRequest, ListRoutesResponse, Route>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoutesRequest injectToken(ListRoutesRequest payload, String token) {
              return ListRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoutesRequest injectPageSize(ListRoutesRequest payload, int pageSize) {
              return ListRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Route> extractResources(ListRoutesResponse payload) {
              return payload.getRoutesList() == null
                  ? ImmutableList.<Route>of()
                  : payload.getRoutesList();
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
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      LIST_CONNECTION_PROFILES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConnectionProfilesRequest,
              ListConnectionProfilesResponse,
              ListConnectionProfilesPagedResponse>() {
            @Override
            public ApiFuture<ListConnectionProfilesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConnectionProfilesRequest, ListConnectionProfilesResponse>
                    callable,
                ListConnectionProfilesRequest request,
                ApiCallContext context,
                ApiFuture<ListConnectionProfilesResponse> futureResponse) {
              PageContext<
                      ListConnectionProfilesRequest,
                      ListConnectionProfilesResponse,
                      ConnectionProfile>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONNECTION_PROFILES_PAGE_STR_DESC, request, context);
              return ListConnectionProfilesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      LIST_STREAMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>() {
            @Override
            public ApiFuture<ListStreamsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStreamsRequest, ListStreamsResponse> callable,
                ListStreamsRequest request,
                ApiCallContext context,
                ApiFuture<ListStreamsResponse> futureResponse) {
              PageContext<ListStreamsRequest, ListStreamsResponse, Stream> pageContext =
                  PageContext.create(callable, LIST_STREAMS_PAGE_STR_DESC, request, context);
              return ListStreamsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListStreamObjectsRequest, ListStreamObjectsResponse, ListStreamObjectsPagedResponse>
      LIST_STREAM_OBJECTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListStreamObjectsRequest,
              ListStreamObjectsResponse,
              ListStreamObjectsPagedResponse>() {
            @Override
            public ApiFuture<ListStreamObjectsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListStreamObjectsRequest, ListStreamObjectsResponse> callable,
                ListStreamObjectsRequest request,
                ApiCallContext context,
                ApiFuture<ListStreamObjectsResponse> futureResponse) {
              PageContext<ListStreamObjectsRequest, ListStreamObjectsResponse, StreamObject>
                  pageContext =
                      PageContext.create(
                          callable, LIST_STREAM_OBJECTS_PAGE_STR_DESC, request, context);
              return ListStreamObjectsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      FETCH_STATIC_IPS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>() {
            @Override
            public ApiFuture<FetchStaticIpsPagedResponse> getFuturePagedResponse(
                UnaryCallable<FetchStaticIpsRequest, FetchStaticIpsResponse> callable,
                FetchStaticIpsRequest request,
                ApiCallContext context,
                ApiFuture<FetchStaticIpsResponse> futureResponse) {
              PageContext<FetchStaticIpsRequest, FetchStaticIpsResponse, String> pageContext =
                  PageContext.create(callable, FETCH_STATIC_IPS_PAGE_STR_DESC, request, context);
              return FetchStaticIpsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPrivateConnectionsRequest,
              ListPrivateConnectionsResponse,
              ListPrivateConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListPrivateConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPrivateConnectionsRequest, ListPrivateConnectionsResponse>
                    callable,
                ListPrivateConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPrivateConnectionsResponse> futureResponse) {
              PageContext<
                      ListPrivateConnectionsRequest,
                      ListPrivateConnectionsResponse,
                      PrivateConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_PRIVATE_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListPrivateConnectionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      LIST_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoutesRequest, ListRoutesResponse> callable,
                ListRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListRoutesResponse> futureResponse) {
              PageContext<ListRoutesRequest, ListRoutesResponse, Route> pageContext =
                  PageContext.create(callable, LIST_ROUTES_PAGE_STR_DESC, request, context);
              return ListRoutesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to listConnectionProfiles. */
  public PagedCallSettings<
          ListConnectionProfilesRequest,
          ListConnectionProfilesResponse,
          ListConnectionProfilesPagedResponse>
      listConnectionProfilesSettings() {
    return listConnectionProfilesSettings;
  }

  /** Returns the object with the settings used for calls to getConnectionProfile. */
  public UnaryCallSettings<GetConnectionProfileRequest, ConnectionProfile>
      getConnectionProfileSettings() {
    return getConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public UnaryCallSettings<CreateConnectionProfileRequest, Operation>
      createConnectionProfileSettings() {
    return createConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to createConnectionProfile. */
  public OperationCallSettings<CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      createConnectionProfileOperationSettings() {
    return createConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public UnaryCallSettings<UpdateConnectionProfileRequest, Operation>
      updateConnectionProfileSettings() {
    return updateConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to updateConnectionProfile. */
  public OperationCallSettings<UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
      updateConnectionProfileOperationSettings() {
    return updateConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public UnaryCallSettings<DeleteConnectionProfileRequest, Operation>
      deleteConnectionProfileSettings() {
    return deleteConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to deleteConnectionProfile. */
  public OperationCallSettings<DeleteConnectionProfileRequest, Empty, OperationMetadata>
      deleteConnectionProfileOperationSettings() {
    return deleteConnectionProfileOperationSettings;
  }

  /** Returns the object with the settings used for calls to discoverConnectionProfile. */
  public UnaryCallSettings<DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
      discoverConnectionProfileSettings() {
    return discoverConnectionProfileSettings;
  }

  /** Returns the object with the settings used for calls to listStreams. */
  public PagedCallSettings<ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
      listStreamsSettings() {
    return listStreamsSettings;
  }

  /** Returns the object with the settings used for calls to getStream. */
  public UnaryCallSettings<GetStreamRequest, Stream> getStreamSettings() {
    return getStreamSettings;
  }

  /** Returns the object with the settings used for calls to createStream. */
  public UnaryCallSettings<CreateStreamRequest, Operation> createStreamSettings() {
    return createStreamSettings;
  }

  /** Returns the object with the settings used for calls to createStream. */
  public OperationCallSettings<CreateStreamRequest, Stream, OperationMetadata>
      createStreamOperationSettings() {
    return createStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public UnaryCallSettings<UpdateStreamRequest, Operation> updateStreamSettings() {
    return updateStreamSettings;
  }

  /** Returns the object with the settings used for calls to updateStream. */
  public OperationCallSettings<UpdateStreamRequest, Stream, OperationMetadata>
      updateStreamOperationSettings() {
    return updateStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public UnaryCallSettings<DeleteStreamRequest, Operation> deleteStreamSettings() {
    return deleteStreamSettings;
  }

  /** Returns the object with the settings used for calls to deleteStream. */
  public OperationCallSettings<DeleteStreamRequest, Empty, OperationMetadata>
      deleteStreamOperationSettings() {
    return deleteStreamOperationSettings;
  }

  /** Returns the object with the settings used for calls to getStreamObject. */
  public UnaryCallSettings<GetStreamObjectRequest, StreamObject> getStreamObjectSettings() {
    return getStreamObjectSettings;
  }

  /** Returns the object with the settings used for calls to lookupStreamObject. */
  public UnaryCallSettings<LookupStreamObjectRequest, StreamObject> lookupStreamObjectSettings() {
    return lookupStreamObjectSettings;
  }

  /** Returns the object with the settings used for calls to listStreamObjects. */
  public PagedCallSettings<
          ListStreamObjectsRequest, ListStreamObjectsResponse, ListStreamObjectsPagedResponse>
      listStreamObjectsSettings() {
    return listStreamObjectsSettings;
  }

  /** Returns the object with the settings used for calls to startBackfillJob. */
  public UnaryCallSettings<StartBackfillJobRequest, StartBackfillJobResponse>
      startBackfillJobSettings() {
    return startBackfillJobSettings;
  }

  /** Returns the object with the settings used for calls to stopBackfillJob. */
  public UnaryCallSettings<StopBackfillJobRequest, StopBackfillJobResponse>
      stopBackfillJobSettings() {
    return stopBackfillJobSettings;
  }

  /** Returns the object with the settings used for calls to fetchStaticIps. */
  public PagedCallSettings<
          FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
      fetchStaticIpsSettings() {
    return fetchStaticIpsSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public UnaryCallSettings<CreatePrivateConnectionRequest, Operation>
      createPrivateConnectionSettings() {
    return createPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createPrivateConnection. */
  public OperationCallSettings<CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
      createPrivateConnectionOperationSettings() {
    return createPrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPrivateConnection. */
  public UnaryCallSettings<GetPrivateConnectionRequest, PrivateConnection>
      getPrivateConnectionSettings() {
    return getPrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listPrivateConnections. */
  public PagedCallSettings<
          ListPrivateConnectionsRequest,
          ListPrivateConnectionsResponse,
          ListPrivateConnectionsPagedResponse>
      listPrivateConnectionsSettings() {
    return listPrivateConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public UnaryCallSettings<DeletePrivateConnectionRequest, Operation>
      deletePrivateConnectionSettings() {
    return deletePrivateConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deletePrivateConnection. */
  public OperationCallSettings<DeletePrivateConnectionRequest, Empty, OperationMetadata>
      deletePrivateConnectionOperationSettings() {
    return deletePrivateConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to createRoute. */
  public UnaryCallSettings<CreateRouteRequest, Operation> createRouteSettings() {
    return createRouteSettings;
  }

  /** Returns the object with the settings used for calls to createRoute. */
  public OperationCallSettings<CreateRouteRequest, Route, OperationMetadata>
      createRouteOperationSettings() {
    return createRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to getRoute. */
  public UnaryCallSettings<GetRouteRequest, Route> getRouteSettings() {
    return getRouteSettings;
  }

  /** Returns the object with the settings used for calls to listRoutes. */
  public PagedCallSettings<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
      listRoutesSettings() {
    return listRoutesSettings;
  }

  /** Returns the object with the settings used for calls to deleteRoute. */
  public UnaryCallSettings<DeleteRouteRequest, Operation> deleteRouteSettings() {
    return deleteRouteSettings;
  }

  /** Returns the object with the settings used for calls to deleteRoute. */
  public OperationCallSettings<DeleteRouteRequest, Empty, OperationMetadata>
      deleteRouteOperationSettings() {
    return deleteRouteOperationSettings;
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

  public DatastreamStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcDatastreamStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonDatastreamStub.create(this);
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
    return "datastream.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "datastream.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(DatastreamStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(DatastreamStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DatastreamStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected DatastreamStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listConnectionProfilesSettings = settingsBuilder.listConnectionProfilesSettings().build();
    getConnectionProfileSettings = settingsBuilder.getConnectionProfileSettings().build();
    createConnectionProfileSettings = settingsBuilder.createConnectionProfileSettings().build();
    createConnectionProfileOperationSettings =
        settingsBuilder.createConnectionProfileOperationSettings().build();
    updateConnectionProfileSettings = settingsBuilder.updateConnectionProfileSettings().build();
    updateConnectionProfileOperationSettings =
        settingsBuilder.updateConnectionProfileOperationSettings().build();
    deleteConnectionProfileSettings = settingsBuilder.deleteConnectionProfileSettings().build();
    deleteConnectionProfileOperationSettings =
        settingsBuilder.deleteConnectionProfileOperationSettings().build();
    discoverConnectionProfileSettings = settingsBuilder.discoverConnectionProfileSettings().build();
    listStreamsSettings = settingsBuilder.listStreamsSettings().build();
    getStreamSettings = settingsBuilder.getStreamSettings().build();
    createStreamSettings = settingsBuilder.createStreamSettings().build();
    createStreamOperationSettings = settingsBuilder.createStreamOperationSettings().build();
    updateStreamSettings = settingsBuilder.updateStreamSettings().build();
    updateStreamOperationSettings = settingsBuilder.updateStreamOperationSettings().build();
    deleteStreamSettings = settingsBuilder.deleteStreamSettings().build();
    deleteStreamOperationSettings = settingsBuilder.deleteStreamOperationSettings().build();
    getStreamObjectSettings = settingsBuilder.getStreamObjectSettings().build();
    lookupStreamObjectSettings = settingsBuilder.lookupStreamObjectSettings().build();
    listStreamObjectsSettings = settingsBuilder.listStreamObjectsSettings().build();
    startBackfillJobSettings = settingsBuilder.startBackfillJobSettings().build();
    stopBackfillJobSettings = settingsBuilder.stopBackfillJobSettings().build();
    fetchStaticIpsSettings = settingsBuilder.fetchStaticIpsSettings().build();
    createPrivateConnectionSettings = settingsBuilder.createPrivateConnectionSettings().build();
    createPrivateConnectionOperationSettings =
        settingsBuilder.createPrivateConnectionOperationSettings().build();
    getPrivateConnectionSettings = settingsBuilder.getPrivateConnectionSettings().build();
    listPrivateConnectionsSettings = settingsBuilder.listPrivateConnectionsSettings().build();
    deletePrivateConnectionSettings = settingsBuilder.deletePrivateConnectionSettings().build();
    deletePrivateConnectionOperationSettings =
        settingsBuilder.deletePrivateConnectionOperationSettings().build();
    createRouteSettings = settingsBuilder.createRouteSettings().build();
    createRouteOperationSettings = settingsBuilder.createRouteOperationSettings().build();
    getRouteSettings = settingsBuilder.getRouteSettings().build();
    listRoutesSettings = settingsBuilder.listRoutesSettings().build();
    deleteRouteSettings = settingsBuilder.deleteRouteSettings().build();
    deleteRouteOperationSettings = settingsBuilder.deleteRouteOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
  }

  /** Builder for DatastreamStubSettings. */
  public static class Builder extends StubSettings.Builder<DatastreamStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings;
    private final UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings;
    private final UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings;
    private final OperationCallSettings.Builder<
            DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings;
    private final UnaryCallSettings.Builder<
            DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
        discoverConnectionProfileSettings;
    private final PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings;
    private final UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings;
    private final UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings;
    private final OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings;
    private final UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings;
    private final OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings;
    private final UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings;
    private final OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings;
    private final UnaryCallSettings.Builder<GetStreamObjectRequest, StreamObject>
        getStreamObjectSettings;
    private final UnaryCallSettings.Builder<LookupStreamObjectRequest, StreamObject>
        lookupStreamObjectSettings;
    private final PagedCallSettings.Builder<
            ListStreamObjectsRequest, ListStreamObjectsResponse, ListStreamObjectsPagedResponse>
        listStreamObjectsSettings;
    private final UnaryCallSettings.Builder<StartBackfillJobRequest, StartBackfillJobResponse>
        startBackfillJobSettings;
    private final UnaryCallSettings.Builder<StopBackfillJobRequest, StopBackfillJobResponse>
        stopBackfillJobSettings;
    private final PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings;
    private final UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings;
    private final PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings;
    private final UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings;
    private final OperationCallSettings.Builder<
            DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings;
    private final UnaryCallSettings.Builder<CreateRouteRequest, Operation> createRouteSettings;
    private final OperationCallSettings.Builder<CreateRouteRequest, Route, OperationMetadata>
        createRouteOperationSettings;
    private final UnaryCallSettings.Builder<GetRouteRequest, Route> getRouteSettings;
    private final PagedCallSettings.Builder<
            ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
        listRoutesSettings;
    private final UnaryCallSettings.Builder<DeleteRouteRequest, Operation> deleteRouteSettings;
    private final OperationCallSettings.Builder<DeleteRouteRequest, Empty, OperationMetadata>
        deleteRouteOperationSettings;
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
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listConnectionProfilesSettings =
          PagedCallSettings.newBuilder(LIST_CONNECTION_PROFILES_PAGE_STR_FACT);
      getConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      updateConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      deleteConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConnectionProfileOperationSettings = OperationCallSettings.newBuilder();
      discoverConnectionProfileSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStreamsSettings = PagedCallSettings.newBuilder(LIST_STREAMS_PAGE_STR_FACT);
      getStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createStreamOperationSettings = OperationCallSettings.newBuilder();
      updateStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateStreamOperationSettings = OperationCallSettings.newBuilder();
      deleteStreamSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteStreamOperationSettings = OperationCallSettings.newBuilder();
      getStreamObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      lookupStreamObjectSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listStreamObjectsSettings = PagedCallSettings.newBuilder(LIST_STREAM_OBJECTS_PAGE_STR_FACT);
      startBackfillJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopBackfillJobSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      fetchStaticIpsSettings = PagedCallSettings.newBuilder(FETCH_STATIC_IPS_PAGE_STR_FACT);
      createPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      getPrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPrivateConnectionsSettings =
          PagedCallSettings.newBuilder(LIST_PRIVATE_CONNECTIONS_PAGE_STR_FACT);
      deletePrivateConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePrivateConnectionOperationSettings = OperationCallSettings.newBuilder();
      createRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createRouteOperationSettings = OperationCallSettings.newBuilder();
      getRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRoutesSettings = PagedCallSettings.newBuilder(LIST_ROUTES_PAGE_STR_FACT);
      deleteRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRouteOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings,
              discoverConnectionProfileSettings,
              listStreamsSettings,
              getStreamSettings,
              createStreamSettings,
              updateStreamSettings,
              deleteStreamSettings,
              getStreamObjectSettings,
              lookupStreamObjectSettings,
              listStreamObjectsSettings,
              startBackfillJobSettings,
              stopBackfillJobSettings,
              fetchStaticIpsSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              deletePrivateConnectionSettings,
              createRouteSettings,
              getRouteSettings,
              listRoutesSettings,
              deleteRouteSettings,
              listLocationsSettings,
              getLocationSettings);
      initDefaults(this);
    }

    protected Builder(DatastreamStubSettings settings) {
      super(settings);

      listConnectionProfilesSettings = settings.listConnectionProfilesSettings.toBuilder();
      getConnectionProfileSettings = settings.getConnectionProfileSettings.toBuilder();
      createConnectionProfileSettings = settings.createConnectionProfileSettings.toBuilder();
      createConnectionProfileOperationSettings =
          settings.createConnectionProfileOperationSettings.toBuilder();
      updateConnectionProfileSettings = settings.updateConnectionProfileSettings.toBuilder();
      updateConnectionProfileOperationSettings =
          settings.updateConnectionProfileOperationSettings.toBuilder();
      deleteConnectionProfileSettings = settings.deleteConnectionProfileSettings.toBuilder();
      deleteConnectionProfileOperationSettings =
          settings.deleteConnectionProfileOperationSettings.toBuilder();
      discoverConnectionProfileSettings = settings.discoverConnectionProfileSettings.toBuilder();
      listStreamsSettings = settings.listStreamsSettings.toBuilder();
      getStreamSettings = settings.getStreamSettings.toBuilder();
      createStreamSettings = settings.createStreamSettings.toBuilder();
      createStreamOperationSettings = settings.createStreamOperationSettings.toBuilder();
      updateStreamSettings = settings.updateStreamSettings.toBuilder();
      updateStreamOperationSettings = settings.updateStreamOperationSettings.toBuilder();
      deleteStreamSettings = settings.deleteStreamSettings.toBuilder();
      deleteStreamOperationSettings = settings.deleteStreamOperationSettings.toBuilder();
      getStreamObjectSettings = settings.getStreamObjectSettings.toBuilder();
      lookupStreamObjectSettings = settings.lookupStreamObjectSettings.toBuilder();
      listStreamObjectsSettings = settings.listStreamObjectsSettings.toBuilder();
      startBackfillJobSettings = settings.startBackfillJobSettings.toBuilder();
      stopBackfillJobSettings = settings.stopBackfillJobSettings.toBuilder();
      fetchStaticIpsSettings = settings.fetchStaticIpsSettings.toBuilder();
      createPrivateConnectionSettings = settings.createPrivateConnectionSettings.toBuilder();
      createPrivateConnectionOperationSettings =
          settings.createPrivateConnectionOperationSettings.toBuilder();
      getPrivateConnectionSettings = settings.getPrivateConnectionSettings.toBuilder();
      listPrivateConnectionsSettings = settings.listPrivateConnectionsSettings.toBuilder();
      deletePrivateConnectionSettings = settings.deletePrivateConnectionSettings.toBuilder();
      deletePrivateConnectionOperationSettings =
          settings.deletePrivateConnectionOperationSettings.toBuilder();
      createRouteSettings = settings.createRouteSettings.toBuilder();
      createRouteOperationSettings = settings.createRouteOperationSettings.toBuilder();
      getRouteSettings = settings.getRouteSettings.toBuilder();
      listRoutesSettings = settings.listRoutesSettings.toBuilder();
      deleteRouteSettings = settings.deleteRouteSettings.toBuilder();
      deleteRouteOperationSettings = settings.deleteRouteOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listConnectionProfilesSettings,
              getConnectionProfileSettings,
              createConnectionProfileSettings,
              updateConnectionProfileSettings,
              deleteConnectionProfileSettings,
              discoverConnectionProfileSettings,
              listStreamsSettings,
              getStreamSettings,
              createStreamSettings,
              updateStreamSettings,
              deleteStreamSettings,
              getStreamObjectSettings,
              lookupStreamObjectSettings,
              listStreamObjectsSettings,
              startBackfillJobSettings,
              stopBackfillJobSettings,
              fetchStaticIpsSettings,
              createPrivateConnectionSettings,
              getPrivateConnectionSettings,
              listPrivateConnectionsSettings,
              deletePrivateConnectionSettings,
              createRouteSettings,
              getRouteSettings,
              listRoutesSettings,
              deleteRouteSettings,
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
          .listConnectionProfilesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .discoverConnectionProfileSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listStreamsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteStreamSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getStreamObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .lookupStreamObjectSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listStreamObjectsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .startBackfillJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .stopBackfillJobSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .fetchStaticIpsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getPrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPrivateConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deletePrivateConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectionProfile.class))
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
          .updateConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ConnectionProfile.class))
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
          .deleteConnectionProfileOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteConnectionProfileRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Stream.class))
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
          .updateStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Stream.class))
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
          .deleteStreamOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteStreamRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(PrivateConnection.class))
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
          .deletePrivateConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePrivateConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Route.class))
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
          .deleteRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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

    /** Returns the builder for the settings used for calls to listConnectionProfiles. */
    public PagedCallSettings.Builder<
            ListConnectionProfilesRequest,
            ListConnectionProfilesResponse,
            ListConnectionProfilesPagedResponse>
        listConnectionProfilesSettings() {
      return listConnectionProfilesSettings;
    }

    /** Returns the builder for the settings used for calls to getConnectionProfile. */
    public UnaryCallSettings.Builder<GetConnectionProfileRequest, ConnectionProfile>
        getConnectionProfileSettings() {
      return getConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    public UnaryCallSettings.Builder<CreateConnectionProfileRequest, Operation>
        createConnectionProfileSettings() {
      return createConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to createConnectionProfile. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        createConnectionProfileOperationSettings() {
      return createConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    public UnaryCallSettings.Builder<UpdateConnectionProfileRequest, Operation>
        updateConnectionProfileSettings() {
      return updateConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to updateConnectionProfile. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            UpdateConnectionProfileRequest, ConnectionProfile, OperationMetadata>
        updateConnectionProfileOperationSettings() {
      return updateConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    public UnaryCallSettings.Builder<DeleteConnectionProfileRequest, Operation>
        deleteConnectionProfileSettings() {
      return deleteConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConnectionProfile. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteConnectionProfileRequest, Empty, OperationMetadata>
        deleteConnectionProfileOperationSettings() {
      return deleteConnectionProfileOperationSettings;
    }

    /** Returns the builder for the settings used for calls to discoverConnectionProfile. */
    public UnaryCallSettings.Builder<
            DiscoverConnectionProfileRequest, DiscoverConnectionProfileResponse>
        discoverConnectionProfileSettings() {
      return discoverConnectionProfileSettings;
    }

    /** Returns the builder for the settings used for calls to listStreams. */
    public PagedCallSettings.Builder<
            ListStreamsRequest, ListStreamsResponse, ListStreamsPagedResponse>
        listStreamsSettings() {
      return listStreamsSettings;
    }

    /** Returns the builder for the settings used for calls to getStream. */
    public UnaryCallSettings.Builder<GetStreamRequest, Stream> getStreamSettings() {
      return getStreamSettings;
    }

    /** Returns the builder for the settings used for calls to createStream. */
    public UnaryCallSettings.Builder<CreateStreamRequest, Operation> createStreamSettings() {
      return createStreamSettings;
    }

    /** Returns the builder for the settings used for calls to createStream. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateStreamRequest, Stream, OperationMetadata>
        createStreamOperationSettings() {
      return createStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    public UnaryCallSettings.Builder<UpdateStreamRequest, Operation> updateStreamSettings() {
      return updateStreamSettings;
    }

    /** Returns the builder for the settings used for calls to updateStream. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateStreamRequest, Stream, OperationMetadata>
        updateStreamOperationSettings() {
      return updateStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    public UnaryCallSettings.Builder<DeleteStreamRequest, Operation> deleteStreamSettings() {
      return deleteStreamSettings;
    }

    /** Returns the builder for the settings used for calls to deleteStream. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteStreamRequest, Empty, OperationMetadata>
        deleteStreamOperationSettings() {
      return deleteStreamOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getStreamObject. */
    public UnaryCallSettings.Builder<GetStreamObjectRequest, StreamObject>
        getStreamObjectSettings() {
      return getStreamObjectSettings;
    }

    /** Returns the builder for the settings used for calls to lookupStreamObject. */
    public UnaryCallSettings.Builder<LookupStreamObjectRequest, StreamObject>
        lookupStreamObjectSettings() {
      return lookupStreamObjectSettings;
    }

    /** Returns the builder for the settings used for calls to listStreamObjects. */
    public PagedCallSettings.Builder<
            ListStreamObjectsRequest, ListStreamObjectsResponse, ListStreamObjectsPagedResponse>
        listStreamObjectsSettings() {
      return listStreamObjectsSettings;
    }

    /** Returns the builder for the settings used for calls to startBackfillJob. */
    public UnaryCallSettings.Builder<StartBackfillJobRequest, StartBackfillJobResponse>
        startBackfillJobSettings() {
      return startBackfillJobSettings;
    }

    /** Returns the builder for the settings used for calls to stopBackfillJob. */
    public UnaryCallSettings.Builder<StopBackfillJobRequest, StopBackfillJobResponse>
        stopBackfillJobSettings() {
      return stopBackfillJobSettings;
    }

    /** Returns the builder for the settings used for calls to fetchStaticIps. */
    public PagedCallSettings.Builder<
            FetchStaticIpsRequest, FetchStaticIpsResponse, FetchStaticIpsPagedResponse>
        fetchStaticIpsSettings() {
      return fetchStaticIpsSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    public UnaryCallSettings.Builder<CreatePrivateConnectionRequest, Operation>
        createPrivateConnectionSettings() {
      return createPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createPrivateConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreatePrivateConnectionRequest, PrivateConnection, OperationMetadata>
        createPrivateConnectionOperationSettings() {
      return createPrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPrivateConnection. */
    public UnaryCallSettings.Builder<GetPrivateConnectionRequest, PrivateConnection>
        getPrivateConnectionSettings() {
      return getPrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listPrivateConnections. */
    public PagedCallSettings.Builder<
            ListPrivateConnectionsRequest,
            ListPrivateConnectionsResponse,
            ListPrivateConnectionsPagedResponse>
        listPrivateConnectionsSettings() {
      return listPrivateConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    public UnaryCallSettings.Builder<DeletePrivateConnectionRequest, Operation>
        deletePrivateConnectionSettings() {
      return deletePrivateConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deletePrivateConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeletePrivateConnectionRequest, Empty, OperationMetadata>
        deletePrivateConnectionOperationSettings() {
      return deletePrivateConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createRoute. */
    public UnaryCallSettings.Builder<CreateRouteRequest, Operation> createRouteSettings() {
      return createRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createRoute. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateRouteRequest, Route, OperationMetadata>
        createRouteOperationSettings() {
      return createRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getRoute. */
    public UnaryCallSettings.Builder<GetRouteRequest, Route> getRouteSettings() {
      return getRouteSettings;
    }

    /** Returns the builder for the settings used for calls to listRoutes. */
    public PagedCallSettings.Builder<ListRoutesRequest, ListRoutesResponse, ListRoutesPagedResponse>
        listRoutesSettings() {
      return listRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRoute. */
    public UnaryCallSettings.Builder<DeleteRouteRequest, Operation> deleteRouteSettings() {
      return deleteRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRoute. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteRouteRequest, Empty, OperationMetadata>
        deleteRouteOperationSettings() {
      return deleteRouteOperationSettings;
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
    public DatastreamStubSettings build() throws IOException {
      return new DatastreamStubSettings(this);
    }
  }
}
