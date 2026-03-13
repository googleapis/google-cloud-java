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

package com.google.showcase.v1beta1.stub;

import static com.google.showcase.v1beta1.MessagingClient.ListBlurbsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListLocationsPagedResponse;
import static com.google.showcase.v1beta1.MessagingClient.ListRoomsPagedResponse;

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
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
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
import com.google.showcase.v1beta1.Blurb;
import com.google.showcase.v1beta1.ConnectRequest;
import com.google.showcase.v1beta1.CreateBlurbRequest;
import com.google.showcase.v1beta1.CreateRoomRequest;
import com.google.showcase.v1beta1.DeleteBlurbRequest;
import com.google.showcase.v1beta1.DeleteRoomRequest;
import com.google.showcase.v1beta1.GetBlurbRequest;
import com.google.showcase.v1beta1.GetRoomRequest;
import com.google.showcase.v1beta1.ListBlurbsRequest;
import com.google.showcase.v1beta1.ListBlurbsResponse;
import com.google.showcase.v1beta1.ListRoomsRequest;
import com.google.showcase.v1beta1.ListRoomsResponse;
import com.google.showcase.v1beta1.Room;
import com.google.showcase.v1beta1.SearchBlurbsMetadata;
import com.google.showcase.v1beta1.SearchBlurbsRequest;
import com.google.showcase.v1beta1.SearchBlurbsResponse;
import com.google.showcase.v1beta1.SendBlurbsResponse;
import com.google.showcase.v1beta1.StreamBlurbsRequest;
import com.google.showcase.v1beta1.StreamBlurbsResponse;
import com.google.showcase.v1beta1.UpdateBlurbRequest;
import com.google.showcase.v1beta1.UpdateRoomRequest;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MessagingStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (localhost) and default port (7469) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of createRoom:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MessagingStubSettings.Builder messagingSettingsBuilder = MessagingStubSettings.newBuilder();
 * messagingSettingsBuilder
 *     .createRoomSettings()
 *     .setRetrySettings(
 *         messagingSettingsBuilder
 *             .createRoomSettings()
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
 * MessagingStubSettings messagingSettings = messagingSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for searchBlurbs:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MessagingStubSettings.Builder messagingSettingsBuilder = MessagingStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * messagingSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
@SuppressWarnings("CanonicalDuration")
public class MessagingStubSettings extends StubSettings<MessagingStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<CreateRoomRequest, Room> createRoomSettings;
  private final UnaryCallSettings<GetRoomRequest, Room> getRoomSettings;
  private final UnaryCallSettings<UpdateRoomRequest, Room> updateRoomSettings;
  private final UnaryCallSettings<DeleteRoomRequest, Empty> deleteRoomSettings;
  private final PagedCallSettings<ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
      listRoomsSettings;
  private final UnaryCallSettings<CreateBlurbRequest, Blurb> createBlurbSettings;
  private final UnaryCallSettings<GetBlurbRequest, Blurb> getBlurbSettings;
  private final UnaryCallSettings<UpdateBlurbRequest, Blurb> updateBlurbSettings;
  private final UnaryCallSettings<DeleteBlurbRequest, Empty> deleteBlurbSettings;
  private final PagedCallSettings<ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
      listBlurbsSettings;
  private final UnaryCallSettings<SearchBlurbsRequest, Operation> searchBlurbsSettings;
  private final OperationCallSettings<
          SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationSettings;
  private final ServerStreamingCallSettings<StreamBlurbsRequest, StreamBlurbsResponse>
      streamBlurbsSettings;
  private final StreamingCallSettings<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsSettings;
  private final StreamingCallSettings<ConnectRequest, StreamBlurbsResponse> connectSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListRoomsRequest, ListRoomsResponse, Room>
      LIST_ROOMS_PAGE_STR_DESC =
          new PagedListDescriptor<ListRoomsRequest, ListRoomsResponse, Room>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListRoomsRequest injectToken(ListRoomsRequest payload, String token) {
              return ListRoomsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListRoomsRequest injectPageSize(ListRoomsRequest payload, int pageSize) {
              return ListRoomsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListRoomsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListRoomsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Room> extractResources(ListRoomsResponse payload) {
              return payload.getRoomsList();
            }
          };

  private static final PagedListDescriptor<ListBlurbsRequest, ListBlurbsResponse, Blurb>
      LIST_BLURBS_PAGE_STR_DESC =
          new PagedListDescriptor<ListBlurbsRequest, ListBlurbsResponse, Blurb>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListBlurbsRequest injectToken(ListBlurbsRequest payload, String token) {
              return ListBlurbsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListBlurbsRequest injectPageSize(ListBlurbsRequest payload, int pageSize) {
              return ListBlurbsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListBlurbsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListBlurbsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Blurb> extractResources(ListBlurbsResponse payload) {
              return payload.getBlurbsList();
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
          ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
      LIST_ROOMS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>() {
            @Override
            public ApiFuture<ListRoomsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListRoomsRequest, ListRoomsResponse> callable,
                ListRoomsRequest request,
                ApiCallContext context,
                ApiFuture<ListRoomsResponse> futureResponse) {
              PageContext<ListRoomsRequest, ListRoomsResponse, Room> pageContext =
                  PageContext.create(callable, LIST_ROOMS_PAGE_STR_DESC, request, context);
              return ListRoomsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
      LIST_BLURBS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>() {
            @Override
            public ApiFuture<ListBlurbsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListBlurbsRequest, ListBlurbsResponse> callable,
                ListBlurbsRequest request,
                ApiCallContext context,
                ApiFuture<ListBlurbsResponse> futureResponse) {
              PageContext<ListBlurbsRequest, ListBlurbsResponse, Blurb> pageContext =
                  PageContext.create(callable, LIST_BLURBS_PAGE_STR_DESC, request, context);
              return ListBlurbsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to createRoom. */
  public UnaryCallSettings<CreateRoomRequest, Room> createRoomSettings() {
    return createRoomSettings;
  }

  /** Returns the object with the settings used for calls to getRoom. */
  public UnaryCallSettings<GetRoomRequest, Room> getRoomSettings() {
    return getRoomSettings;
  }

  /** Returns the object with the settings used for calls to updateRoom. */
  public UnaryCallSettings<UpdateRoomRequest, Room> updateRoomSettings() {
    return updateRoomSettings;
  }

  /** Returns the object with the settings used for calls to deleteRoom. */
  public UnaryCallSettings<DeleteRoomRequest, Empty> deleteRoomSettings() {
    return deleteRoomSettings;
  }

  /** Returns the object with the settings used for calls to listRooms. */
  public PagedCallSettings<ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
      listRoomsSettings() {
    return listRoomsSettings;
  }

  /** Returns the object with the settings used for calls to createBlurb. */
  public UnaryCallSettings<CreateBlurbRequest, Blurb> createBlurbSettings() {
    return createBlurbSettings;
  }

  /** Returns the object with the settings used for calls to getBlurb. */
  public UnaryCallSettings<GetBlurbRequest, Blurb> getBlurbSettings() {
    return getBlurbSettings;
  }

  /** Returns the object with the settings used for calls to updateBlurb. */
  public UnaryCallSettings<UpdateBlurbRequest, Blurb> updateBlurbSettings() {
    return updateBlurbSettings;
  }

  /** Returns the object with the settings used for calls to deleteBlurb. */
  public UnaryCallSettings<DeleteBlurbRequest, Empty> deleteBlurbSettings() {
    return deleteBlurbSettings;
  }

  /** Returns the object with the settings used for calls to listBlurbs. */
  public PagedCallSettings<ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
      listBlurbsSettings() {
    return listBlurbsSettings;
  }

  /** Returns the object with the settings used for calls to searchBlurbs. */
  public UnaryCallSettings<SearchBlurbsRequest, Operation> searchBlurbsSettings() {
    return searchBlurbsSettings;
  }

  /** Returns the object with the settings used for calls to searchBlurbs. */
  public OperationCallSettings<SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
      searchBlurbsOperationSettings() {
    return searchBlurbsOperationSettings;
  }

  /** Returns the object with the settings used for calls to streamBlurbs. */
  public ServerStreamingCallSettings<StreamBlurbsRequest, StreamBlurbsResponse>
      streamBlurbsSettings() {
    return streamBlurbsSettings;
  }

  /** Returns the object with the settings used for calls to sendBlurbs. */
  public StreamingCallSettings<CreateBlurbRequest, SendBlurbsResponse> sendBlurbsSettings() {
    return sendBlurbsSettings;
  }

  /** Returns the object with the settings used for calls to connect. */
  public StreamingCallSettings<ConnectRequest, StreamBlurbsResponse> connectSettings() {
    return connectSettings;
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

  public MessagingStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMessagingStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMessagingStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
  public static String getDefaultEndpoint() {
    return "localhost:7469";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "localhost:7469";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(MessagingStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(MessagingStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MessagingStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MessagingStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createRoomSettings = settingsBuilder.createRoomSettings().build();
    getRoomSettings = settingsBuilder.getRoomSettings().build();
    updateRoomSettings = settingsBuilder.updateRoomSettings().build();
    deleteRoomSettings = settingsBuilder.deleteRoomSettings().build();
    listRoomsSettings = settingsBuilder.listRoomsSettings().build();
    createBlurbSettings = settingsBuilder.createBlurbSettings().build();
    getBlurbSettings = settingsBuilder.getBlurbSettings().build();
    updateBlurbSettings = settingsBuilder.updateBlurbSettings().build();
    deleteBlurbSettings = settingsBuilder.deleteBlurbSettings().build();
    listBlurbsSettings = settingsBuilder.listBlurbsSettings().build();
    searchBlurbsSettings = settingsBuilder.searchBlurbsSettings().build();
    searchBlurbsOperationSettings = settingsBuilder.searchBlurbsOperationSettings().build();
    streamBlurbsSettings = settingsBuilder.streamBlurbsSettings().build();
    sendBlurbsSettings = settingsBuilder.sendBlurbsSettings().build();
    connectSettings = settingsBuilder.connectSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  @Override
  protected LibraryMetadata getLibraryMetadata() {
    return LibraryMetadata.newBuilder()
        .setArtifactName("com.google.cloud:gapic-showcase")
        .setRepository("googleapis/sdk-platform-java")
        .build();
  }

  /** Builder for MessagingStubSettings. */
  public static class Builder extends StubSettings.Builder<MessagingStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateRoomRequest, Room> createRoomSettings;
    private final UnaryCallSettings.Builder<GetRoomRequest, Room> getRoomSettings;
    private final UnaryCallSettings.Builder<UpdateRoomRequest, Room> updateRoomSettings;
    private final UnaryCallSettings.Builder<DeleteRoomRequest, Empty> deleteRoomSettings;
    private final PagedCallSettings.Builder<
            ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
        listRoomsSettings;
    private final UnaryCallSettings.Builder<CreateBlurbRequest, Blurb> createBlurbSettings;
    private final UnaryCallSettings.Builder<GetBlurbRequest, Blurb> getBlurbSettings;
    private final UnaryCallSettings.Builder<UpdateBlurbRequest, Blurb> updateBlurbSettings;
    private final UnaryCallSettings.Builder<DeleteBlurbRequest, Empty> deleteBlurbSettings;
    private final PagedCallSettings.Builder<
            ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
        listBlurbsSettings;
    private final UnaryCallSettings.Builder<SearchBlurbsRequest, Operation> searchBlurbsSettings;
    private final OperationCallSettings.Builder<
            SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
        searchBlurbsOperationSettings;
    private final ServerStreamingCallSettings.Builder<StreamBlurbsRequest, StreamBlurbsResponse>
        streamBlurbsSettings;
    private final StreamingCallSettings.Builder<CreateBlurbRequest, SendBlurbsResponse>
        sendBlurbsSettings;
    private final StreamingCallSettings.Builder<ConnectRequest, StreamBlurbsResponse>
        connectSettings;
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
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNKNOWN)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeoutDuration(Duration.ofMillis(5000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(5000L))
              .setTotalTimeoutDuration(Duration.ofMillis(5000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelayDuration(Duration.ofMillis(3000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(10000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(10000L))
              .setTotalTimeoutDuration(Duration.ofMillis(10000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createRoomSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getRoomSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateRoomSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteRoomSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listRoomsSettings = PagedCallSettings.newBuilder(LIST_ROOMS_PAGE_STR_FACT);
      createBlurbSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getBlurbSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateBlurbSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteBlurbSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listBlurbsSettings = PagedCallSettings.newBuilder(LIST_BLURBS_PAGE_STR_FACT);
      searchBlurbsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      searchBlurbsOperationSettings = OperationCallSettings.newBuilder();
      streamBlurbsSettings = ServerStreamingCallSettings.newBuilder();
      sendBlurbsSettings = StreamingCallSettings.newBuilder();
      connectSettings = StreamingCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRoomSettings,
              getRoomSettings,
              updateRoomSettings,
              deleteRoomSettings,
              listRoomsSettings,
              createBlurbSettings,
              getBlurbSettings,
              updateBlurbSettings,
              deleteBlurbSettings,
              listBlurbsSettings,
              searchBlurbsSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(MessagingStubSettings settings) {
      super(settings);

      createRoomSettings = settings.createRoomSettings.toBuilder();
      getRoomSettings = settings.getRoomSettings.toBuilder();
      updateRoomSettings = settings.updateRoomSettings.toBuilder();
      deleteRoomSettings = settings.deleteRoomSettings.toBuilder();
      listRoomsSettings = settings.listRoomsSettings.toBuilder();
      createBlurbSettings = settings.createBlurbSettings.toBuilder();
      getBlurbSettings = settings.getBlurbSettings.toBuilder();
      updateBlurbSettings = settings.updateBlurbSettings.toBuilder();
      deleteBlurbSettings = settings.deleteBlurbSettings.toBuilder();
      listBlurbsSettings = settings.listBlurbsSettings.toBuilder();
      searchBlurbsSettings = settings.searchBlurbsSettings.toBuilder();
      searchBlurbsOperationSettings = settings.searchBlurbsOperationSettings.toBuilder();
      streamBlurbsSettings = settings.streamBlurbsSettings.toBuilder();
      sendBlurbsSettings = settings.sendBlurbsSettings.toBuilder();
      connectSettings = settings.connectSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createRoomSettings,
              getRoomSettings,
              updateRoomSettings,
              deleteRoomSettings,
              listRoomsSettings,
              createBlurbSettings,
              getBlurbSettings,
              updateBlurbSettings,
              deleteBlurbSettings,
              listBlurbsSettings,
              searchBlurbsSettings,
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
          .createRoomSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getRoomSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateRoomSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteRoomSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listRoomsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .createBlurbSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getBlurbSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .updateBlurbSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteBlurbSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listBlurbsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .searchBlurbsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .streamBlurbsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .searchBlurbsOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<SearchBlurbsRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(SearchBlurbsResponse.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(SearchBlurbsMetadata.class))
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

    /** Returns the builder for the settings used for calls to createRoom. */
    public UnaryCallSettings.Builder<CreateRoomRequest, Room> createRoomSettings() {
      return createRoomSettings;
    }

    /** Returns the builder for the settings used for calls to getRoom. */
    public UnaryCallSettings.Builder<GetRoomRequest, Room> getRoomSettings() {
      return getRoomSettings;
    }

    /** Returns the builder for the settings used for calls to updateRoom. */
    public UnaryCallSettings.Builder<UpdateRoomRequest, Room> updateRoomSettings() {
      return updateRoomSettings;
    }

    /** Returns the builder for the settings used for calls to deleteRoom. */
    public UnaryCallSettings.Builder<DeleteRoomRequest, Empty> deleteRoomSettings() {
      return deleteRoomSettings;
    }

    /** Returns the builder for the settings used for calls to listRooms. */
    public PagedCallSettings.Builder<ListRoomsRequest, ListRoomsResponse, ListRoomsPagedResponse>
        listRoomsSettings() {
      return listRoomsSettings;
    }

    /** Returns the builder for the settings used for calls to createBlurb. */
    public UnaryCallSettings.Builder<CreateBlurbRequest, Blurb> createBlurbSettings() {
      return createBlurbSettings;
    }

    /** Returns the builder for the settings used for calls to getBlurb. */
    public UnaryCallSettings.Builder<GetBlurbRequest, Blurb> getBlurbSettings() {
      return getBlurbSettings;
    }

    /** Returns the builder for the settings used for calls to updateBlurb. */
    public UnaryCallSettings.Builder<UpdateBlurbRequest, Blurb> updateBlurbSettings() {
      return updateBlurbSettings;
    }

    /** Returns the builder for the settings used for calls to deleteBlurb. */
    public UnaryCallSettings.Builder<DeleteBlurbRequest, Empty> deleteBlurbSettings() {
      return deleteBlurbSettings;
    }

    /** Returns the builder for the settings used for calls to listBlurbs. */
    public PagedCallSettings.Builder<ListBlurbsRequest, ListBlurbsResponse, ListBlurbsPagedResponse>
        listBlurbsSettings() {
      return listBlurbsSettings;
    }

    /** Returns the builder for the settings used for calls to searchBlurbs. */
    public UnaryCallSettings.Builder<SearchBlurbsRequest, Operation> searchBlurbsSettings() {
      return searchBlurbsSettings;
    }

    /** Returns the builder for the settings used for calls to searchBlurbs. */
    public OperationCallSettings.Builder<
            SearchBlurbsRequest, SearchBlurbsResponse, SearchBlurbsMetadata>
        searchBlurbsOperationSettings() {
      return searchBlurbsOperationSettings;
    }

    /** Returns the builder for the settings used for calls to streamBlurbs. */
    public ServerStreamingCallSettings.Builder<StreamBlurbsRequest, StreamBlurbsResponse>
        streamBlurbsSettings() {
      return streamBlurbsSettings;
    }

    /** Returns the builder for the settings used for calls to sendBlurbs. */
    public StreamingCallSettings.Builder<CreateBlurbRequest, SendBlurbsResponse>
        sendBlurbsSettings() {
      return sendBlurbsSettings;
    }

    /** Returns the builder for the settings used for calls to connect. */
    public StreamingCallSettings.Builder<ConnectRequest, StreamBlurbsResponse> connectSettings() {
      return connectSettings;
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
    public MessagingStubSettings build() throws IOException {
      return new MessagingStubSettings(this);
    }
  }
}
