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

package com.google.cloud.video.livestream.v1.stub;

import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListChannelsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListEventsPagedResponse;
import static com.google.cloud.video.livestream.v1.LivestreamServiceClient.ListInputsPagedResponse;

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
import com.google.cloud.video.livestream.v1.Channel;
import com.google.cloud.video.livestream.v1.ChannelOperationResponse;
import com.google.cloud.video.livestream.v1.CreateChannelRequest;
import com.google.cloud.video.livestream.v1.CreateEventRequest;
import com.google.cloud.video.livestream.v1.CreateInputRequest;
import com.google.cloud.video.livestream.v1.DeleteChannelRequest;
import com.google.cloud.video.livestream.v1.DeleteEventRequest;
import com.google.cloud.video.livestream.v1.DeleteInputRequest;
import com.google.cloud.video.livestream.v1.Event;
import com.google.cloud.video.livestream.v1.GetChannelRequest;
import com.google.cloud.video.livestream.v1.GetEventRequest;
import com.google.cloud.video.livestream.v1.GetInputRequest;
import com.google.cloud.video.livestream.v1.Input;
import com.google.cloud.video.livestream.v1.ListChannelsRequest;
import com.google.cloud.video.livestream.v1.ListChannelsResponse;
import com.google.cloud.video.livestream.v1.ListEventsRequest;
import com.google.cloud.video.livestream.v1.ListEventsResponse;
import com.google.cloud.video.livestream.v1.ListInputsRequest;
import com.google.cloud.video.livestream.v1.ListInputsResponse;
import com.google.cloud.video.livestream.v1.OperationMetadata;
import com.google.cloud.video.livestream.v1.StartChannelRequest;
import com.google.cloud.video.livestream.v1.StopChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateChannelRequest;
import com.google.cloud.video.livestream.v1.UpdateInputRequest;
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
 * Settings class to configure an instance of {@link LivestreamServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (livestream.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getChannel to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * LivestreamServiceStubSettings.Builder livestreamServiceSettingsBuilder =
 *     LivestreamServiceStubSettings.newBuilder();
 * livestreamServiceSettingsBuilder
 *     .getChannelSettings()
 *     .setRetrySettings(
 *         livestreamServiceSettingsBuilder
 *             .getChannelSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LivestreamServiceStubSettings livestreamServiceSettings =
 *     livestreamServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class LivestreamServiceStubSettings extends StubSettings<LivestreamServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings;
  private final OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings;
  private final PagedCallSettings<
          ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings;
  private final UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings;
  private final UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings;
  private final OperationCallSettings<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationSettings;
  private final UnaryCallSettings<UpdateChannelRequest, Operation> updateChannelSettings;
  private final OperationCallSettings<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationSettings;
  private final UnaryCallSettings<StartChannelRequest, Operation> startChannelSettings;
  private final OperationCallSettings<
          StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationSettings;
  private final UnaryCallSettings<StopChannelRequest, Operation> stopChannelSettings;
  private final OperationCallSettings<
          StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationSettings;
  private final UnaryCallSettings<CreateInputRequest, Operation> createInputSettings;
  private final OperationCallSettings<CreateInputRequest, Input, OperationMetadata>
      createInputOperationSettings;
  private final PagedCallSettings<ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
      listInputsSettings;
  private final UnaryCallSettings<GetInputRequest, Input> getInputSettings;
  private final UnaryCallSettings<DeleteInputRequest, Operation> deleteInputSettings;
  private final OperationCallSettings<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationSettings;
  private final UnaryCallSettings<UpdateInputRequest, Operation> updateInputSettings;
  private final OperationCallSettings<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationSettings;
  private final UnaryCallSettings<CreateEventRequest, Event> createEventSettings;
  private final PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings;
  private final UnaryCallSettings<GetEventRequest, Event> getEventSettings;
  private final UnaryCallSettings<DeleteEventRequest, Empty> deleteEventSettings;

  private static final PagedListDescriptor<ListChannelsRequest, ListChannelsResponse, Channel>
      LIST_CHANNELS_PAGE_STR_DESC =
          new PagedListDescriptor<ListChannelsRequest, ListChannelsResponse, Channel>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListChannelsRequest injectToken(ListChannelsRequest payload, String token) {
              return ListChannelsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListChannelsRequest injectPageSize(ListChannelsRequest payload, int pageSize) {
              return ListChannelsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListChannelsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListChannelsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Channel> extractResources(ListChannelsResponse payload) {
              return payload.getChannelsList() == null
                  ? ImmutableList.<Channel>of()
                  : payload.getChannelsList();
            }
          };

  private static final PagedListDescriptor<ListInputsRequest, ListInputsResponse, Input>
      LIST_INPUTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListInputsRequest, ListInputsResponse, Input>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListInputsRequest injectToken(ListInputsRequest payload, String token) {
              return ListInputsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListInputsRequest injectPageSize(ListInputsRequest payload, int pageSize) {
              return ListInputsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListInputsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListInputsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Input> extractResources(ListInputsResponse payload) {
              return payload.getInputsList() == null
                  ? ImmutableList.<Input>of()
                  : payload.getInputsList();
            }
          };

  private static final PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>
      LIST_EVENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEventsRequest, ListEventsResponse, Event>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEventsRequest injectToken(ListEventsRequest payload, String token) {
              return ListEventsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEventsRequest injectPageSize(ListEventsRequest payload, int pageSize) {
              return ListEventsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEventsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEventsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Event> extractResources(ListEventsResponse payload) {
              return payload.getEventsList() == null
                  ? ImmutableList.<Event>of()
                  : payload.getEventsList();
            }
          };

  private static final PagedListResponseFactory<
          ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      LIST_CHANNELS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>() {
            @Override
            public ApiFuture<ListChannelsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListChannelsRequest, ListChannelsResponse> callable,
                ListChannelsRequest request,
                ApiCallContext context,
                ApiFuture<ListChannelsResponse> futureResponse) {
              PageContext<ListChannelsRequest, ListChannelsResponse, Channel> pageContext =
                  PageContext.create(callable, LIST_CHANNELS_PAGE_STR_DESC, request, context);
              return ListChannelsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
      LIST_INPUTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>() {
            @Override
            public ApiFuture<ListInputsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListInputsRequest, ListInputsResponse> callable,
                ListInputsRequest request,
                ApiCallContext context,
                ApiFuture<ListInputsResponse> futureResponse) {
              PageContext<ListInputsRequest, ListInputsResponse, Input> pageContext =
                  PageContext.create(callable, LIST_INPUTS_PAGE_STR_DESC, request, context);
              return ListInputsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      LIST_EVENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>() {
            @Override
            public ApiFuture<ListEventsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEventsRequest, ListEventsResponse> callable,
                ListEventsRequest request,
                ApiCallContext context,
                ApiFuture<ListEventsResponse> futureResponse) {
              PageContext<ListEventsRequest, ListEventsResponse, Event> pageContext =
                  PageContext.create(callable, LIST_EVENTS_PAGE_STR_DESC, request, context);
              return ListEventsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createChannel. */
  public UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings() {
    return createChannelSettings;
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings() {
    return createChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to listChannels. */
  public PagedCallSettings<ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings() {
    return listChannelsSettings;
  }

  /** Returns the object with the settings used for calls to getChannel. */
  public UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings() {
    return getChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings() {
    return deleteChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public OperationCallSettings<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationSettings() {
    return deleteChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public UnaryCallSettings<UpdateChannelRequest, Operation> updateChannelSettings() {
    return updateChannelSettings;
  }

  /** Returns the object with the settings used for calls to updateChannel. */
  public OperationCallSettings<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationSettings() {
    return updateChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to startChannel. */
  public UnaryCallSettings<StartChannelRequest, Operation> startChannelSettings() {
    return startChannelSettings;
  }

  /** Returns the object with the settings used for calls to startChannel. */
  public OperationCallSettings<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationSettings() {
    return startChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to stopChannel. */
  public UnaryCallSettings<StopChannelRequest, Operation> stopChannelSettings() {
    return stopChannelSettings;
  }

  /** Returns the object with the settings used for calls to stopChannel. */
  public OperationCallSettings<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationSettings() {
    return stopChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to createInput. */
  public UnaryCallSettings<CreateInputRequest, Operation> createInputSettings() {
    return createInputSettings;
  }

  /** Returns the object with the settings used for calls to createInput. */
  public OperationCallSettings<CreateInputRequest, Input, OperationMetadata>
      createInputOperationSettings() {
    return createInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to listInputs. */
  public PagedCallSettings<ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
      listInputsSettings() {
    return listInputsSettings;
  }

  /** Returns the object with the settings used for calls to getInput. */
  public UnaryCallSettings<GetInputRequest, Input> getInputSettings() {
    return getInputSettings;
  }

  /** Returns the object with the settings used for calls to deleteInput. */
  public UnaryCallSettings<DeleteInputRequest, Operation> deleteInputSettings() {
    return deleteInputSettings;
  }

  /** Returns the object with the settings used for calls to deleteInput. */
  public OperationCallSettings<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationSettings() {
    return deleteInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateInput. */
  public UnaryCallSettings<UpdateInputRequest, Operation> updateInputSettings() {
    return updateInputSettings;
  }

  /** Returns the object with the settings used for calls to updateInput. */
  public OperationCallSettings<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationSettings() {
    return updateInputOperationSettings;
  }

  /** Returns the object with the settings used for calls to createEvent. */
  public UnaryCallSettings<CreateEventRequest, Event> createEventSettings() {
    return createEventSettings;
  }

  /** Returns the object with the settings used for calls to listEvents. */
  public PagedCallSettings<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
      listEventsSettings() {
    return listEventsSettings;
  }

  /** Returns the object with the settings used for calls to getEvent. */
  public UnaryCallSettings<GetEventRequest, Event> getEventSettings() {
    return getEventSettings;
  }

  /** Returns the object with the settings used for calls to deleteEvent. */
  public UnaryCallSettings<DeleteEventRequest, Empty> deleteEventSettings() {
    return deleteEventSettings;
  }

  public LivestreamServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLivestreamServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonLivestreamServiceStub.create(this);
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
    return "livestream.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "livestream.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(LivestreamServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LivestreamServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return LivestreamServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected LivestreamServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createChannelSettings = settingsBuilder.createChannelSettings().build();
    createChannelOperationSettings = settingsBuilder.createChannelOperationSettings().build();
    listChannelsSettings = settingsBuilder.listChannelsSettings().build();
    getChannelSettings = settingsBuilder.getChannelSettings().build();
    deleteChannelSettings = settingsBuilder.deleteChannelSettings().build();
    deleteChannelOperationSettings = settingsBuilder.deleteChannelOperationSettings().build();
    updateChannelSettings = settingsBuilder.updateChannelSettings().build();
    updateChannelOperationSettings = settingsBuilder.updateChannelOperationSettings().build();
    startChannelSettings = settingsBuilder.startChannelSettings().build();
    startChannelOperationSettings = settingsBuilder.startChannelOperationSettings().build();
    stopChannelSettings = settingsBuilder.stopChannelSettings().build();
    stopChannelOperationSettings = settingsBuilder.stopChannelOperationSettings().build();
    createInputSettings = settingsBuilder.createInputSettings().build();
    createInputOperationSettings = settingsBuilder.createInputOperationSettings().build();
    listInputsSettings = settingsBuilder.listInputsSettings().build();
    getInputSettings = settingsBuilder.getInputSettings().build();
    deleteInputSettings = settingsBuilder.deleteInputSettings().build();
    deleteInputOperationSettings = settingsBuilder.deleteInputOperationSettings().build();
    updateInputSettings = settingsBuilder.updateInputSettings().build();
    updateInputOperationSettings = settingsBuilder.updateInputOperationSettings().build();
    createEventSettings = settingsBuilder.createEventSettings().build();
    listEventsSettings = settingsBuilder.listEventsSettings().build();
    getEventSettings = settingsBuilder.getEventSettings().build();
    deleteEventSettings = settingsBuilder.deleteEventSettings().build();
  }

  /** Builder for LivestreamServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<LivestreamServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateChannelRequest, Operation> createChannelSettings;
    private final OperationCallSettings.Builder<CreateChannelRequest, Channel, OperationMetadata>
        createChannelOperationSettings;
    private final PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings;
    private final UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings;
    private final UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings;
    private final OperationCallSettings.Builder<DeleteChannelRequest, Empty, OperationMetadata>
        deleteChannelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings;
    private final OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings;
    private final UnaryCallSettings.Builder<StartChannelRequest, Operation> startChannelSettings;
    private final OperationCallSettings.Builder<
            StartChannelRequest, ChannelOperationResponse, OperationMetadata>
        startChannelOperationSettings;
    private final UnaryCallSettings.Builder<StopChannelRequest, Operation> stopChannelSettings;
    private final OperationCallSettings.Builder<
            StopChannelRequest, ChannelOperationResponse, OperationMetadata>
        stopChannelOperationSettings;
    private final UnaryCallSettings.Builder<CreateInputRequest, Operation> createInputSettings;
    private final OperationCallSettings.Builder<CreateInputRequest, Input, OperationMetadata>
        createInputOperationSettings;
    private final PagedCallSettings.Builder<
            ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
        listInputsSettings;
    private final UnaryCallSettings.Builder<GetInputRequest, Input> getInputSettings;
    private final UnaryCallSettings.Builder<DeleteInputRequest, Operation> deleteInputSettings;
    private final OperationCallSettings.Builder<DeleteInputRequest, Empty, OperationMetadata>
        deleteInputOperationSettings;
    private final UnaryCallSettings.Builder<UpdateInputRequest, Operation> updateInputSettings;
    private final OperationCallSettings.Builder<UpdateInputRequest, Input, OperationMetadata>
        updateInputOperationSettings;
    private final UnaryCallSettings.Builder<CreateEventRequest, Event> createEventSettings;
    private final PagedCallSettings.Builder<
            ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings;
    private final UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings;
    private final UnaryCallSettings.Builder<DeleteEventRequest, Empty> deleteEventSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_1_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_1_params", settings);
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
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createChannelOperationSettings = OperationCallSettings.newBuilder();
      listChannelsSettings = PagedCallSettings.newBuilder(LIST_CHANNELS_PAGE_STR_FACT);
      getChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteChannelOperationSettings = OperationCallSettings.newBuilder();
      updateChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateChannelOperationSettings = OperationCallSettings.newBuilder();
      startChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      startChannelOperationSettings = OperationCallSettings.newBuilder();
      stopChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      stopChannelOperationSettings = OperationCallSettings.newBuilder();
      createInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createInputOperationSettings = OperationCallSettings.newBuilder();
      listInputsSettings = PagedCallSettings.newBuilder(LIST_INPUTS_PAGE_STR_FACT);
      getInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteInputOperationSettings = OperationCallSettings.newBuilder();
      updateInputSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateInputOperationSettings = OperationCallSettings.newBuilder();
      createEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEventsSettings = PagedCallSettings.newBuilder(LIST_EVENTS_PAGE_STR_FACT);
      getEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEventSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createChannelSettings,
              listChannelsSettings,
              getChannelSettings,
              deleteChannelSettings,
              updateChannelSettings,
              startChannelSettings,
              stopChannelSettings,
              createInputSettings,
              listInputsSettings,
              getInputSettings,
              deleteInputSettings,
              updateInputSettings,
              createEventSettings,
              listEventsSettings,
              getEventSettings,
              deleteEventSettings);
      initDefaults(this);
    }

    protected Builder(LivestreamServiceStubSettings settings) {
      super(settings);

      createChannelSettings = settings.createChannelSettings.toBuilder();
      createChannelOperationSettings = settings.createChannelOperationSettings.toBuilder();
      listChannelsSettings = settings.listChannelsSettings.toBuilder();
      getChannelSettings = settings.getChannelSettings.toBuilder();
      deleteChannelSettings = settings.deleteChannelSettings.toBuilder();
      deleteChannelOperationSettings = settings.deleteChannelOperationSettings.toBuilder();
      updateChannelSettings = settings.updateChannelSettings.toBuilder();
      updateChannelOperationSettings = settings.updateChannelOperationSettings.toBuilder();
      startChannelSettings = settings.startChannelSettings.toBuilder();
      startChannelOperationSettings = settings.startChannelOperationSettings.toBuilder();
      stopChannelSettings = settings.stopChannelSettings.toBuilder();
      stopChannelOperationSettings = settings.stopChannelOperationSettings.toBuilder();
      createInputSettings = settings.createInputSettings.toBuilder();
      createInputOperationSettings = settings.createInputOperationSettings.toBuilder();
      listInputsSettings = settings.listInputsSettings.toBuilder();
      getInputSettings = settings.getInputSettings.toBuilder();
      deleteInputSettings = settings.deleteInputSettings.toBuilder();
      deleteInputOperationSettings = settings.deleteInputOperationSettings.toBuilder();
      updateInputSettings = settings.updateInputSettings.toBuilder();
      updateInputOperationSettings = settings.updateInputOperationSettings.toBuilder();
      createEventSettings = settings.createEventSettings.toBuilder();
      listEventsSettings = settings.listEventsSettings.toBuilder();
      getEventSettings = settings.getEventSettings.toBuilder();
      deleteEventSettings = settings.deleteEventSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createChannelSettings,
              listChannelsSettings,
              getChannelSettings,
              deleteChannelSettings,
              updateChannelSettings,
              startChannelSettings,
              stopChannelSettings,
              createInputSettings,
              listInputsSettings,
              getInputSettings,
              deleteInputSettings,
              updateInputSettings,
              createEventSettings,
              listEventsSettings,
              getEventSettings,
              deleteEventSettings);
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
          .createChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .startChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .stopChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listInputsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateInputSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .listEventsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteEventSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .createChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Channel.class))
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
          .deleteChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Channel.class))
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
          .startChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<StartChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelOperationResponse.class))
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
          .stopChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<StopChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelOperationResponse.class))
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
          .createInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateInputRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Input.class))
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
          .deleteInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteInputRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
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
          .updateInputOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateInputRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Input.class))
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

    /** Returns the builder for the settings used for calls to createChannel. */
    public UnaryCallSettings.Builder<CreateChannelRequest, Operation> createChannelSettings() {
      return createChannelSettings;
    }

    /** Returns the builder for the settings used for calls to createChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateChannelRequest, Channel, OperationMetadata>
        createChannelOperationSettings() {
      return createChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listChannels. */
    public PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings() {
      return listChannelsSettings;
    }

    /** Returns the builder for the settings used for calls to getChannel. */
    public UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings() {
      return getChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings() {
      return deleteChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteChannelRequest, Empty, OperationMetadata>
        deleteChannelOperationSettings() {
      return deleteChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings() {
      return updateChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings() {
      return updateChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to startChannel. */
    public UnaryCallSettings.Builder<StartChannelRequest, Operation> startChannelSettings() {
      return startChannelSettings;
    }

    /** Returns the builder for the settings used for calls to startChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            StartChannelRequest, ChannelOperationResponse, OperationMetadata>
        startChannelOperationSettings() {
      return startChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to stopChannel. */
    public UnaryCallSettings.Builder<StopChannelRequest, Operation> stopChannelSettings() {
      return stopChannelSettings;
    }

    /** Returns the builder for the settings used for calls to stopChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            StopChannelRequest, ChannelOperationResponse, OperationMetadata>
        stopChannelOperationSettings() {
      return stopChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createInput. */
    public UnaryCallSettings.Builder<CreateInputRequest, Operation> createInputSettings() {
      return createInputSettings;
    }

    /** Returns the builder for the settings used for calls to createInput. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateInputRequest, Input, OperationMetadata>
        createInputOperationSettings() {
      return createInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listInputs. */
    public PagedCallSettings.Builder<ListInputsRequest, ListInputsResponse, ListInputsPagedResponse>
        listInputsSettings() {
      return listInputsSettings;
    }

    /** Returns the builder for the settings used for calls to getInput. */
    public UnaryCallSettings.Builder<GetInputRequest, Input> getInputSettings() {
      return getInputSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInput. */
    public UnaryCallSettings.Builder<DeleteInputRequest, Operation> deleteInputSettings() {
      return deleteInputSettings;
    }

    /** Returns the builder for the settings used for calls to deleteInput. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteInputRequest, Empty, OperationMetadata>
        deleteInputOperationSettings() {
      return deleteInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateInput. */
    public UnaryCallSettings.Builder<UpdateInputRequest, Operation> updateInputSettings() {
      return updateInputSettings;
    }

    /** Returns the builder for the settings used for calls to updateInput. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateInputRequest, Input, OperationMetadata>
        updateInputOperationSettings() {
      return updateInputOperationSettings;
    }

    /** Returns the builder for the settings used for calls to createEvent. */
    public UnaryCallSettings.Builder<CreateEventRequest, Event> createEventSettings() {
      return createEventSettings;
    }

    /** Returns the builder for the settings used for calls to listEvents. */
    public PagedCallSettings.Builder<ListEventsRequest, ListEventsResponse, ListEventsPagedResponse>
        listEventsSettings() {
      return listEventsSettings;
    }

    /** Returns the builder for the settings used for calls to getEvent. */
    public UnaryCallSettings.Builder<GetEventRequest, Event> getEventSettings() {
      return getEventSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEvent. */
    public UnaryCallSettings.Builder<DeleteEventRequest, Empty> deleteEventSettings() {
      return deleteEventSettings;
    }

    @Override
    public LivestreamServiceStubSettings build() throws IOException {
      return new LivestreamServiceStubSettings(this);
    }
  }
}
