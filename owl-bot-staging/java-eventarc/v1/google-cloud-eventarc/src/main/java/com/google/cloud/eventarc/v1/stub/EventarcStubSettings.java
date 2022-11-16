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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.cloud.eventarc.v1.Channel;
import com.google.cloud.eventarc.v1.ChannelConnection;
import com.google.cloud.eventarc.v1.CreateChannelConnectionRequest;
import com.google.cloud.eventarc.v1.CreateChannelRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.UpdateTriggerRequest;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link EventarcStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (eventarc.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getTrigger to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EventarcStubSettings.Builder eventarcSettingsBuilder = EventarcStubSettings.newBuilder();
 * eventarcSettingsBuilder
 *     .getTriggerSettings()
 *     .setRetrySettings(
 *         eventarcSettingsBuilder.getTriggerSettings().getRetrySettings().toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * EventarcStubSettings eventarcSettings = eventarcSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class EventarcStubSettings extends StubSettings<EventarcStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<GetTriggerRequest, Trigger> getTriggerSettings;
  private final PagedCallSettings<
          ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
      listTriggersSettings;
  private final UnaryCallSettings<CreateTriggerRequest, Operation> createTriggerSettings;
  private final OperationCallSettings<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationSettings;
  private final UnaryCallSettings<UpdateTriggerRequest, Operation> updateTriggerSettings;
  private final OperationCallSettings<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationSettings;
  private final UnaryCallSettings<DeleteTriggerRequest, Operation> deleteTriggerSettings;
  private final OperationCallSettings<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationSettings;
  private final UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings;
  private final PagedCallSettings<
          ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings;
  private final UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings;
  private final OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings;
  private final UnaryCallSettings<UpdateChannelRequest, Operation> updateChannelSettings;
  private final OperationCallSettings<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationSettings;
  private final UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings;
  private final OperationCallSettings<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationSettings;
  private final UnaryCallSettings<GetProviderRequest, Provider> getProviderSettings;
  private final PagedCallSettings<
          ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
      listProvidersSettings;
  private final UnaryCallSettings<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionSettings;
  private final PagedCallSettings<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ListChannelConnectionsPagedResponse>
      listChannelConnectionsSettings;
  private final UnaryCallSettings<CreateChannelConnectionRequest, Operation>
      createChannelConnectionSettings;
  private final OperationCallSettings<
          CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationSettings;
  private final UnaryCallSettings<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionSettings;
  private final OperationCallSettings<
          DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationSettings;
  private final UnaryCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigSettings;
  private final UnaryCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListTriggersRequest, ListTriggersResponse, Trigger>
      LIST_TRIGGERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTriggersRequest, ListTriggersResponse, Trigger>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTriggersRequest injectToken(ListTriggersRequest payload, String token) {
              return ListTriggersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTriggersRequest injectPageSize(ListTriggersRequest payload, int pageSize) {
              return ListTriggersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTriggersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTriggersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Trigger> extractResources(ListTriggersResponse payload) {
              return payload.getTriggersList() == null
                  ? ImmutableList.<Trigger>of()
                  : payload.getTriggersList();
            }
          };

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

  private static final PagedListDescriptor<ListProvidersRequest, ListProvidersResponse, Provider>
      LIST_PROVIDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListProvidersRequest, ListProvidersResponse, Provider>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListProvidersRequest injectToken(ListProvidersRequest payload, String token) {
              return ListProvidersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListProvidersRequest injectPageSize(ListProvidersRequest payload, int pageSize) {
              return ListProvidersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListProvidersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListProvidersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Provider> extractResources(ListProvidersResponse payload) {
              return payload.getProvidersList() == null
                  ? ImmutableList.<Provider>of()
                  : payload.getProvidersList();
            }
          };

  private static final PagedListDescriptor<
          ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
      LIST_CHANNEL_CONNECTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListChannelConnectionsRequest injectToken(
                ListChannelConnectionsRequest payload, String token) {
              return ListChannelConnectionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListChannelConnectionsRequest injectPageSize(
                ListChannelConnectionsRequest payload, int pageSize) {
              return ListChannelConnectionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListChannelConnectionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListChannelConnectionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ChannelConnection> extractResources(
                ListChannelConnectionsResponse payload) {
              return payload.getChannelConnectionsList() == null
                  ? ImmutableList.<ChannelConnection>of()
                  : payload.getChannelConnectionsList();
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
          ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
      LIST_TRIGGERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>() {
            @Override
            public ApiFuture<ListTriggersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTriggersRequest, ListTriggersResponse> callable,
                ListTriggersRequest request,
                ApiCallContext context,
                ApiFuture<ListTriggersResponse> futureResponse) {
              PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> pageContext =
                  PageContext.create(callable, LIST_TRIGGERS_PAGE_STR_DESC, request, context);
              return ListTriggersPagedResponse.createAsync(pageContext, futureResponse);
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
          ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
      LIST_PROVIDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>() {
            @Override
            public ApiFuture<ListProvidersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListProvidersRequest, ListProvidersResponse> callable,
                ListProvidersRequest request,
                ApiCallContext context,
                ApiFuture<ListProvidersResponse> futureResponse) {
              PageContext<ListProvidersRequest, ListProvidersResponse, Provider> pageContext =
                  PageContext.create(callable, LIST_PROVIDERS_PAGE_STR_DESC, request, context);
              return ListProvidersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ListChannelConnectionsPagedResponse>
      LIST_CHANNEL_CONNECTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListChannelConnectionsRequest,
              ListChannelConnectionsResponse,
              ListChannelConnectionsPagedResponse>() {
            @Override
            public ApiFuture<ListChannelConnectionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
                    callable,
                ListChannelConnectionsRequest request,
                ApiCallContext context,
                ApiFuture<ListChannelConnectionsResponse> futureResponse) {
              PageContext<
                      ListChannelConnectionsRequest,
                      ListChannelConnectionsResponse,
                      ChannelConnection>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CHANNEL_CONNECTIONS_PAGE_STR_DESC, request, context);
              return ListChannelConnectionsPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getTrigger. */
  public UnaryCallSettings<GetTriggerRequest, Trigger> getTriggerSettings() {
    return getTriggerSettings;
  }

  /** Returns the object with the settings used for calls to listTriggers. */
  public PagedCallSettings<ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
      listTriggersSettings() {
    return listTriggersSettings;
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public UnaryCallSettings<CreateTriggerRequest, Operation> createTriggerSettings() {
    return createTriggerSettings;
  }

  /** Returns the object with the settings used for calls to createTrigger. */
  public OperationCallSettings<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationSettings() {
    return createTriggerOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public UnaryCallSettings<UpdateTriggerRequest, Operation> updateTriggerSettings() {
    return updateTriggerSettings;
  }

  /** Returns the object with the settings used for calls to updateTrigger. */
  public OperationCallSettings<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationSettings() {
    return updateTriggerOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public UnaryCallSettings<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
    return deleteTriggerSettings;
  }

  /** Returns the object with the settings used for calls to deleteTrigger. */
  public OperationCallSettings<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationSettings() {
    return deleteTriggerOperationSettings;
  }

  /** Returns the object with the settings used for calls to getChannel. */
  public UnaryCallSettings<GetChannelRequest, Channel> getChannelSettings() {
    return getChannelSettings;
  }

  /** Returns the object with the settings used for calls to listChannels. */
  public PagedCallSettings<ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
      listChannelsSettings() {
    return listChannelsSettings;
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public UnaryCallSettings<CreateChannelRequest, Operation> createChannelSettings() {
    return createChannelSettings;
  }

  /** Returns the object with the settings used for calls to createChannel. */
  public OperationCallSettings<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationSettings() {
    return createChannelOperationSettings;
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

  /** Returns the object with the settings used for calls to deleteChannel. */
  public UnaryCallSettings<DeleteChannelRequest, Operation> deleteChannelSettings() {
    return deleteChannelSettings;
  }

  /** Returns the object with the settings used for calls to deleteChannel. */
  public OperationCallSettings<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationSettings() {
    return deleteChannelOperationSettings;
  }

  /** Returns the object with the settings used for calls to getProvider. */
  public UnaryCallSettings<GetProviderRequest, Provider> getProviderSettings() {
    return getProviderSettings;
  }

  /** Returns the object with the settings used for calls to listProviders. */
  public PagedCallSettings<ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
      listProvidersSettings() {
    return listProvidersSettings;
  }

  /** Returns the object with the settings used for calls to getChannelConnection. */
  public UnaryCallSettings<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionSettings() {
    return getChannelConnectionSettings;
  }

  /** Returns the object with the settings used for calls to listChannelConnections. */
  public PagedCallSettings<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ListChannelConnectionsPagedResponse>
      listChannelConnectionsSettings() {
    return listChannelConnectionsSettings;
  }

  /** Returns the object with the settings used for calls to createChannelConnection. */
  public UnaryCallSettings<CreateChannelConnectionRequest, Operation>
      createChannelConnectionSettings() {
    return createChannelConnectionSettings;
  }

  /** Returns the object with the settings used for calls to createChannelConnection. */
  public OperationCallSettings<CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationSettings() {
    return createChannelConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteChannelConnection. */
  public UnaryCallSettings<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionSettings() {
    return deleteChannelConnectionSettings;
  }

  /** Returns the object with the settings used for calls to deleteChannelConnection. */
  public OperationCallSettings<DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationSettings() {
    return deleteChannelConnectionOperationSettings;
  }

  /** Returns the object with the settings used for calls to getGoogleChannelConfig. */
  public UnaryCallSettings<GetGoogleChannelConfigRequest, GoogleChannelConfig>
      getGoogleChannelConfigSettings() {
    return getGoogleChannelConfigSettings;
  }

  /** Returns the object with the settings used for calls to updateGoogleChannelConfig. */
  public UnaryCallSettings<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
      updateGoogleChannelConfigSettings() {
    return updateGoogleChannelConfigSettings;
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

  public EventarcStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcEventarcStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonEventarcStub.create(this);
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
    return "eventarc.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "eventarc.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(EventarcStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(EventarcStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return EventarcStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected EventarcStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getTriggerSettings = settingsBuilder.getTriggerSettings().build();
    listTriggersSettings = settingsBuilder.listTriggersSettings().build();
    createTriggerSettings = settingsBuilder.createTriggerSettings().build();
    createTriggerOperationSettings = settingsBuilder.createTriggerOperationSettings().build();
    updateTriggerSettings = settingsBuilder.updateTriggerSettings().build();
    updateTriggerOperationSettings = settingsBuilder.updateTriggerOperationSettings().build();
    deleteTriggerSettings = settingsBuilder.deleteTriggerSettings().build();
    deleteTriggerOperationSettings = settingsBuilder.deleteTriggerOperationSettings().build();
    getChannelSettings = settingsBuilder.getChannelSettings().build();
    listChannelsSettings = settingsBuilder.listChannelsSettings().build();
    createChannelSettings = settingsBuilder.createChannelSettings().build();
    createChannelOperationSettings = settingsBuilder.createChannelOperationSettings().build();
    updateChannelSettings = settingsBuilder.updateChannelSettings().build();
    updateChannelOperationSettings = settingsBuilder.updateChannelOperationSettings().build();
    deleteChannelSettings = settingsBuilder.deleteChannelSettings().build();
    deleteChannelOperationSettings = settingsBuilder.deleteChannelOperationSettings().build();
    getProviderSettings = settingsBuilder.getProviderSettings().build();
    listProvidersSettings = settingsBuilder.listProvidersSettings().build();
    getChannelConnectionSettings = settingsBuilder.getChannelConnectionSettings().build();
    listChannelConnectionsSettings = settingsBuilder.listChannelConnectionsSettings().build();
    createChannelConnectionSettings = settingsBuilder.createChannelConnectionSettings().build();
    createChannelConnectionOperationSettings =
        settingsBuilder.createChannelConnectionOperationSettings().build();
    deleteChannelConnectionSettings = settingsBuilder.deleteChannelConnectionSettings().build();
    deleteChannelConnectionOperationSettings =
        settingsBuilder.deleteChannelConnectionOperationSettings().build();
    getGoogleChannelConfigSettings = settingsBuilder.getGoogleChannelConfigSettings().build();
    updateGoogleChannelConfigSettings = settingsBuilder.updateGoogleChannelConfigSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for EventarcStubSettings. */
  public static class Builder extends StubSettings.Builder<EventarcStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetTriggerRequest, Trigger> getTriggerSettings;
    private final PagedCallSettings.Builder<
            ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
        listTriggersSettings;
    private final UnaryCallSettings.Builder<CreateTriggerRequest, Operation> createTriggerSettings;
    private final OperationCallSettings.Builder<CreateTriggerRequest, Trigger, OperationMetadata>
        createTriggerOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTriggerRequest, Operation> updateTriggerSettings;
    private final OperationCallSettings.Builder<UpdateTriggerRequest, Trigger, OperationMetadata>
        updateTriggerOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTriggerRequest, Operation> deleteTriggerSettings;
    private final OperationCallSettings.Builder<DeleteTriggerRequest, Trigger, OperationMetadata>
        deleteTriggerOperationSettings;
    private final UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings;
    private final PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings;
    private final UnaryCallSettings.Builder<CreateChannelRequest, Operation> createChannelSettings;
    private final OperationCallSettings.Builder<CreateChannelRequest, Channel, OperationMetadata>
        createChannelOperationSettings;
    private final UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings;
    private final OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings;
    private final OperationCallSettings.Builder<DeleteChannelRequest, Channel, OperationMetadata>
        deleteChannelOperationSettings;
    private final UnaryCallSettings.Builder<GetProviderRequest, Provider> getProviderSettings;
    private final PagedCallSettings.Builder<
            ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
        listProvidersSettings;
    private final UnaryCallSettings.Builder<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionSettings;
    private final PagedCallSettings.Builder<
            ListChannelConnectionsRequest,
            ListChannelConnectionsResponse,
            ListChannelConnectionsPagedResponse>
        listChannelConnectionsSettings;
    private final UnaryCallSettings.Builder<CreateChannelConnectionRequest, Operation>
        createChannelConnectionSettings;
    private final OperationCallSettings.Builder<
            CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
        createChannelConnectionOperationSettings;
    private final UnaryCallSettings.Builder<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionSettings;
    private final OperationCallSettings.Builder<
            DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
        deleteChannelConnectionOperationSettings;
    private final UnaryCallSettings.Builder<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigSettings;
    private final UnaryCallSettings.Builder<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigSettings;
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

      getTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTriggersSettings = PagedCallSettings.newBuilder(LIST_TRIGGERS_PAGE_STR_FACT);
      createTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTriggerOperationSettings = OperationCallSettings.newBuilder();
      updateTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTriggerOperationSettings = OperationCallSettings.newBuilder();
      deleteTriggerSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTriggerOperationSettings = OperationCallSettings.newBuilder();
      getChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listChannelsSettings = PagedCallSettings.newBuilder(LIST_CHANNELS_PAGE_STR_FACT);
      createChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createChannelOperationSettings = OperationCallSettings.newBuilder();
      updateChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateChannelOperationSettings = OperationCallSettings.newBuilder();
      deleteChannelSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteChannelOperationSettings = OperationCallSettings.newBuilder();
      getProviderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listProvidersSettings = PagedCallSettings.newBuilder(LIST_PROVIDERS_PAGE_STR_FACT);
      getChannelConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listChannelConnectionsSettings =
          PagedCallSettings.newBuilder(LIST_CHANNEL_CONNECTIONS_PAGE_STR_FACT);
      createChannelConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createChannelConnectionOperationSettings = OperationCallSettings.newBuilder();
      deleteChannelConnectionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteChannelConnectionOperationSettings = OperationCallSettings.newBuilder();
      getGoogleChannelConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGoogleChannelConfigSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTriggerSettings,
              listTriggersSettings,
              createTriggerSettings,
              updateTriggerSettings,
              deleteTriggerSettings,
              getChannelSettings,
              listChannelsSettings,
              createChannelSettings,
              updateChannelSettings,
              deleteChannelSettings,
              getProviderSettings,
              listProvidersSettings,
              getChannelConnectionSettings,
              listChannelConnectionsSettings,
              createChannelConnectionSettings,
              deleteChannelConnectionSettings,
              getGoogleChannelConfigSettings,
              updateGoogleChannelConfigSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(EventarcStubSettings settings) {
      super(settings);

      getTriggerSettings = settings.getTriggerSettings.toBuilder();
      listTriggersSettings = settings.listTriggersSettings.toBuilder();
      createTriggerSettings = settings.createTriggerSettings.toBuilder();
      createTriggerOperationSettings = settings.createTriggerOperationSettings.toBuilder();
      updateTriggerSettings = settings.updateTriggerSettings.toBuilder();
      updateTriggerOperationSettings = settings.updateTriggerOperationSettings.toBuilder();
      deleteTriggerSettings = settings.deleteTriggerSettings.toBuilder();
      deleteTriggerOperationSettings = settings.deleteTriggerOperationSettings.toBuilder();
      getChannelSettings = settings.getChannelSettings.toBuilder();
      listChannelsSettings = settings.listChannelsSettings.toBuilder();
      createChannelSettings = settings.createChannelSettings.toBuilder();
      createChannelOperationSettings = settings.createChannelOperationSettings.toBuilder();
      updateChannelSettings = settings.updateChannelSettings.toBuilder();
      updateChannelOperationSettings = settings.updateChannelOperationSettings.toBuilder();
      deleteChannelSettings = settings.deleteChannelSettings.toBuilder();
      deleteChannelOperationSettings = settings.deleteChannelOperationSettings.toBuilder();
      getProviderSettings = settings.getProviderSettings.toBuilder();
      listProvidersSettings = settings.listProvidersSettings.toBuilder();
      getChannelConnectionSettings = settings.getChannelConnectionSettings.toBuilder();
      listChannelConnectionsSettings = settings.listChannelConnectionsSettings.toBuilder();
      createChannelConnectionSettings = settings.createChannelConnectionSettings.toBuilder();
      createChannelConnectionOperationSettings =
          settings.createChannelConnectionOperationSettings.toBuilder();
      deleteChannelConnectionSettings = settings.deleteChannelConnectionSettings.toBuilder();
      deleteChannelConnectionOperationSettings =
          settings.deleteChannelConnectionOperationSettings.toBuilder();
      getGoogleChannelConfigSettings = settings.getGoogleChannelConfigSettings.toBuilder();
      updateGoogleChannelConfigSettings = settings.updateGoogleChannelConfigSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getTriggerSettings,
              listTriggersSettings,
              createTriggerSettings,
              updateTriggerSettings,
              deleteTriggerSettings,
              getChannelSettings,
              listChannelsSettings,
              createChannelSettings,
              updateChannelSettings,
              deleteChannelSettings,
              getProviderSettings,
              listProvidersSettings,
              getChannelConnectionSettings,
              listChannelConnectionsSettings,
              createChannelConnectionSettings,
              deleteChannelConnectionSettings,
              getGoogleChannelConfigSettings,
              updateGoogleChannelConfigSettings,
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
          .getTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listTriggersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listProvidersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listChannelConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getGoogleChannelConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateGoogleChannelConfigSettings()
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
          .createTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
          .updateTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
          .deleteTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
          .createChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .updateChannelOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateChannelRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
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
          .createChannelConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateChannelConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelConnection.class))
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
          .deleteChannelConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteChannelConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelConnection.class))
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

    /** Returns the builder for the settings used for calls to getTrigger. */
    public UnaryCallSettings.Builder<GetTriggerRequest, Trigger> getTriggerSettings() {
      return getTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to listTriggers. */
    public PagedCallSettings.Builder<
            ListTriggersRequest, ListTriggersResponse, ListTriggersPagedResponse>
        listTriggersSettings() {
      return listTriggersSettings;
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    public UnaryCallSettings.Builder<CreateTriggerRequest, Operation> createTriggerSettings() {
      return createTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to createTrigger. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<CreateTriggerRequest, Trigger, OperationMetadata>
        createTriggerOperationSettings() {
      return createTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public UnaryCallSettings.Builder<UpdateTriggerRequest, Operation> updateTriggerSettings() {
      return updateTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<UpdateTriggerRequest, Trigger, OperationMetadata>
        updateTriggerOperationSettings() {
      return updateTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public UnaryCallSettings.Builder<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
      return deleteTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteTriggerRequest, Trigger, OperationMetadata>
        deleteTriggerOperationSettings() {
      return deleteTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getChannel. */
    public UnaryCallSettings.Builder<GetChannelRequest, Channel> getChannelSettings() {
      return getChannelSettings;
    }

    /** Returns the builder for the settings used for calls to listChannels. */
    public PagedCallSettings.Builder<
            ListChannelsRequest, ListChannelsResponse, ListChannelsPagedResponse>
        listChannelsSettings() {
      return listChannelsSettings;
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

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings() {
      return deleteChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<DeleteChannelRequest, Channel, OperationMetadata>
        deleteChannelOperationSettings() {
      return deleteChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getProvider. */
    public UnaryCallSettings.Builder<GetProviderRequest, Provider> getProviderSettings() {
      return getProviderSettings;
    }

    /** Returns the builder for the settings used for calls to listProviders. */
    public PagedCallSettings.Builder<
            ListProvidersRequest, ListProvidersResponse, ListProvidersPagedResponse>
        listProvidersSettings() {
      return listProvidersSettings;
    }

    /** Returns the builder for the settings used for calls to getChannelConnection. */
    public UnaryCallSettings.Builder<GetChannelConnectionRequest, ChannelConnection>
        getChannelConnectionSettings() {
      return getChannelConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to listChannelConnections. */
    public PagedCallSettings.Builder<
            ListChannelConnectionsRequest,
            ListChannelConnectionsResponse,
            ListChannelConnectionsPagedResponse>
        listChannelConnectionsSettings() {
      return listChannelConnectionsSettings;
    }

    /** Returns the builder for the settings used for calls to createChannelConnection. */
    public UnaryCallSettings.Builder<CreateChannelConnectionRequest, Operation>
        createChannelConnectionSettings() {
      return createChannelConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to createChannelConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
        createChannelConnectionOperationSettings() {
      return createChannelConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannelConnection. */
    public UnaryCallSettings.Builder<DeleteChannelConnectionRequest, Operation>
        deleteChannelConnectionSettings() {
      return deleteChannelConnectionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannelConnection. */
    @BetaApi(
        "The surface for use by generated code is not stable yet and may change in the future.")
    public OperationCallSettings.Builder<
            DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
        deleteChannelConnectionOperationSettings() {
      return deleteChannelConnectionOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getGoogleChannelConfig. */
    public UnaryCallSettings.Builder<GetGoogleChannelConfigRequest, GoogleChannelConfig>
        getGoogleChannelConfigSettings() {
      return getGoogleChannelConfigSettings;
    }

    /** Returns the builder for the settings used for calls to updateGoogleChannelConfig. */
    public UnaryCallSettings.Builder<UpdateGoogleChannelConfigRequest, GoogleChannelConfig>
        updateGoogleChannelConfigSettings() {
      return updateGoogleChannelConfigSettings;
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
    public EventarcStubSettings build() throws IOException {
      return new EventarcStubSettings(this);
    }
  }
}
