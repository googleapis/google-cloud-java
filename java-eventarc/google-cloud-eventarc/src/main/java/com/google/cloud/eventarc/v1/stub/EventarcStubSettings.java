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

package com.google.cloud.eventarc.v1.stub;

import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelConnectionsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListChannelsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListGoogleApiSourcesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListLocationsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusEnrollmentsPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListMessageBusesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListPipelinesPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListProvidersPagedResponse;
import static com.google.cloud.eventarc.v1.EventarcClient.ListTriggersPagedResponse;

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
import com.google.cloud.eventarc.v1.CreateEnrollmentRequest;
import com.google.cloud.eventarc.v1.CreateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.CreateMessageBusRequest;
import com.google.cloud.eventarc.v1.CreatePipelineRequest;
import com.google.cloud.eventarc.v1.CreateTriggerRequest;
import com.google.cloud.eventarc.v1.DeleteChannelConnectionRequest;
import com.google.cloud.eventarc.v1.DeleteChannelRequest;
import com.google.cloud.eventarc.v1.DeleteEnrollmentRequest;
import com.google.cloud.eventarc.v1.DeleteGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.DeleteMessageBusRequest;
import com.google.cloud.eventarc.v1.DeletePipelineRequest;
import com.google.cloud.eventarc.v1.DeleteTriggerRequest;
import com.google.cloud.eventarc.v1.Enrollment;
import com.google.cloud.eventarc.v1.GetChannelConnectionRequest;
import com.google.cloud.eventarc.v1.GetChannelRequest;
import com.google.cloud.eventarc.v1.GetEnrollmentRequest;
import com.google.cloud.eventarc.v1.GetGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.GetGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.GetMessageBusRequest;
import com.google.cloud.eventarc.v1.GetPipelineRequest;
import com.google.cloud.eventarc.v1.GetProviderRequest;
import com.google.cloud.eventarc.v1.GetTriggerRequest;
import com.google.cloud.eventarc.v1.GoogleApiSource;
import com.google.cloud.eventarc.v1.GoogleChannelConfig;
import com.google.cloud.eventarc.v1.ListChannelConnectionsRequest;
import com.google.cloud.eventarc.v1.ListChannelConnectionsResponse;
import com.google.cloud.eventarc.v1.ListChannelsRequest;
import com.google.cloud.eventarc.v1.ListChannelsResponse;
import com.google.cloud.eventarc.v1.ListEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesRequest;
import com.google.cloud.eventarc.v1.ListGoogleApiSourcesResponse;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsRequest;
import com.google.cloud.eventarc.v1.ListMessageBusEnrollmentsResponse;
import com.google.cloud.eventarc.v1.ListMessageBusesRequest;
import com.google.cloud.eventarc.v1.ListMessageBusesResponse;
import com.google.cloud.eventarc.v1.ListPipelinesRequest;
import com.google.cloud.eventarc.v1.ListPipelinesResponse;
import com.google.cloud.eventarc.v1.ListProvidersRequest;
import com.google.cloud.eventarc.v1.ListProvidersResponse;
import com.google.cloud.eventarc.v1.ListTriggersRequest;
import com.google.cloud.eventarc.v1.ListTriggersResponse;
import com.google.cloud.eventarc.v1.MessageBus;
import com.google.cloud.eventarc.v1.OperationMetadata;
import com.google.cloud.eventarc.v1.Pipeline;
import com.google.cloud.eventarc.v1.Provider;
import com.google.cloud.eventarc.v1.Trigger;
import com.google.cloud.eventarc.v1.UpdateChannelRequest;
import com.google.cloud.eventarc.v1.UpdateEnrollmentRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleApiSourceRequest;
import com.google.cloud.eventarc.v1.UpdateGoogleChannelConfigRequest;
import com.google.cloud.eventarc.v1.UpdateMessageBusRequest;
import com.google.cloud.eventarc.v1.UpdatePipelineRequest;
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
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getTrigger:
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
 *         eventarcSettingsBuilder
 *             .getTriggerSettings()
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
 * EventarcStubSettings eventarcSettings = eventarcSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createTrigger:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EventarcStubSettings.Builder eventarcSettingsBuilder = EventarcStubSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * eventarcSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
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
  private final UnaryCallSettings<GetMessageBusRequest, MessageBus> getMessageBusSettings;
  private final PagedCallSettings<
          ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>
      listMessageBusesSettings;
  private final PagedCallSettings<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsSettings;
  private final UnaryCallSettings<CreateMessageBusRequest, Operation> createMessageBusSettings;
  private final OperationCallSettings<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationSettings;
  private final UnaryCallSettings<UpdateMessageBusRequest, Operation> updateMessageBusSettings;
  private final OperationCallSettings<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationSettings;
  private final UnaryCallSettings<DeleteMessageBusRequest, Operation> deleteMessageBusSettings;
  private final OperationCallSettings<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationSettings;
  private final UnaryCallSettings<GetEnrollmentRequest, Enrollment> getEnrollmentSettings;
  private final PagedCallSettings<
          ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>
      listEnrollmentsSettings;
  private final UnaryCallSettings<CreateEnrollmentRequest, Operation> createEnrollmentSettings;
  private final OperationCallSettings<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationSettings;
  private final UnaryCallSettings<UpdateEnrollmentRequest, Operation> updateEnrollmentSettings;
  private final OperationCallSettings<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationSettings;
  private final UnaryCallSettings<DeleteEnrollmentRequest, Operation> deleteEnrollmentSettings;
  private final OperationCallSettings<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationSettings;
  private final UnaryCallSettings<GetPipelineRequest, Pipeline> getPipelineSettings;
  private final PagedCallSettings<
          ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>
      listPipelinesSettings;
  private final UnaryCallSettings<CreatePipelineRequest, Operation> createPipelineSettings;
  private final OperationCallSettings<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationSettings;
  private final UnaryCallSettings<UpdatePipelineRequest, Operation> updatePipelineSettings;
  private final OperationCallSettings<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationSettings;
  private final UnaryCallSettings<DeletePipelineRequest, Operation> deletePipelineSettings;
  private final OperationCallSettings<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationSettings;
  private final UnaryCallSettings<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceSettings;
  private final PagedCallSettings<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesSettings;
  private final UnaryCallSettings<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceSettings;
  private final OperationCallSettings<
          CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationSettings;
  private final UnaryCallSettings<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceSettings;
  private final OperationCallSettings<
          UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationSettings;
  private final UnaryCallSettings<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceSettings;
  private final OperationCallSettings<
          DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationSettings;
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
              return payload.getTriggersList();
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
              return payload.getChannelsList();
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
              return payload.getProvidersList();
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
              return payload.getChannelConnectionsList();
            }
          };

  private static final PagedListDescriptor<
          ListMessageBusesRequest, ListMessageBusesResponse, MessageBus>
      LIST_MESSAGE_BUSES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMessageBusesRequest injectToken(
                ListMessageBusesRequest payload, String token) {
              return ListMessageBusesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMessageBusesRequest injectPageSize(
                ListMessageBusesRequest payload, int pageSize) {
              return ListMessageBusesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMessageBusesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMessageBusesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MessageBus> extractResources(ListMessageBusesResponse payload) {
              return payload.getMessageBusesList();
            }
          };

  private static final PagedListDescriptor<
          ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
      LIST_MESSAGE_BUS_ENROLLMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMessageBusEnrollmentsRequest injectToken(
                ListMessageBusEnrollmentsRequest payload, String token) {
              return ListMessageBusEnrollmentsRequest.newBuilder(payload)
                  .setPageToken(token)
                  .build();
            }

            @Override
            public ListMessageBusEnrollmentsRequest injectPageSize(
                ListMessageBusEnrollmentsRequest payload, int pageSize) {
              return ListMessageBusEnrollmentsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMessageBusEnrollmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMessageBusEnrollmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListMessageBusEnrollmentsResponse payload) {
              return payload.getEnrollmentsList();
            }
          };

  private static final PagedListDescriptor<
          ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment>
      LIST_ENROLLMENTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEnrollmentsRequest injectToken(
                ListEnrollmentsRequest payload, String token) {
              return ListEnrollmentsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEnrollmentsRequest injectPageSize(
                ListEnrollmentsRequest payload, int pageSize) {
              return ListEnrollmentsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEnrollmentsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEnrollmentsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Enrollment> extractResources(ListEnrollmentsResponse payload) {
              return payload.getEnrollmentsList();
            }
          };

  private static final PagedListDescriptor<ListPipelinesRequest, ListPipelinesResponse, Pipeline>
      LIST_PIPELINES_PAGE_STR_DESC =
          new PagedListDescriptor<ListPipelinesRequest, ListPipelinesResponse, Pipeline>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPipelinesRequest injectToken(ListPipelinesRequest payload, String token) {
              return ListPipelinesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPipelinesRequest injectPageSize(ListPipelinesRequest payload, int pageSize) {
              return ListPipelinesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPipelinesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPipelinesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Pipeline> extractResources(ListPipelinesResponse payload) {
              return payload.getPipelinesList();
            }
          };

  private static final PagedListDescriptor<
          ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
      LIST_GOOGLE_API_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGoogleApiSourcesRequest injectToken(
                ListGoogleApiSourcesRequest payload, String token) {
              return ListGoogleApiSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGoogleApiSourcesRequest injectPageSize(
                ListGoogleApiSourcesRequest payload, int pageSize) {
              return ListGoogleApiSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGoogleApiSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGoogleApiSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GoogleApiSource> extractResources(
                ListGoogleApiSourcesResponse payload) {
              return payload.getGoogleApiSourcesList();
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
          ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>
      LIST_MESSAGE_BUSES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>() {
            @Override
            public ApiFuture<ListMessageBusesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMessageBusesRequest, ListMessageBusesResponse> callable,
                ListMessageBusesRequest request,
                ApiCallContext context,
                ApiFuture<ListMessageBusesResponse> futureResponse) {
              PageContext<ListMessageBusesRequest, ListMessageBusesResponse, MessageBus>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MESSAGE_BUSES_PAGE_STR_DESC, request, context);
              return ListMessageBusesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          ListMessageBusEnrollmentsPagedResponse>
      LIST_MESSAGE_BUS_ENROLLMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMessageBusEnrollmentsRequest,
              ListMessageBusEnrollmentsResponse,
              ListMessageBusEnrollmentsPagedResponse>() {
            @Override
            public ApiFuture<ListMessageBusEnrollmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse>
                    callable,
                ListMessageBusEnrollmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListMessageBusEnrollmentsResponse> futureResponse) {
              PageContext<
                      ListMessageBusEnrollmentsRequest, ListMessageBusEnrollmentsResponse, String>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MESSAGE_BUS_ENROLLMENTS_PAGE_STR_DESC, request, context);
              return ListMessageBusEnrollmentsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>
      LIST_ENROLLMENTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>() {
            @Override
            public ApiFuture<ListEnrollmentsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEnrollmentsRequest, ListEnrollmentsResponse> callable,
                ListEnrollmentsRequest request,
                ApiCallContext context,
                ApiFuture<ListEnrollmentsResponse> futureResponse) {
              PageContext<ListEnrollmentsRequest, ListEnrollmentsResponse, Enrollment> pageContext =
                  PageContext.create(callable, LIST_ENROLLMENTS_PAGE_STR_DESC, request, context);
              return ListEnrollmentsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>
      LIST_PIPELINES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>() {
            @Override
            public ApiFuture<ListPipelinesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPipelinesRequest, ListPipelinesResponse> callable,
                ListPipelinesRequest request,
                ApiCallContext context,
                ApiFuture<ListPipelinesResponse> futureResponse) {
              PageContext<ListPipelinesRequest, ListPipelinesResponse, Pipeline> pageContext =
                  PageContext.create(callable, LIST_PIPELINES_PAGE_STR_DESC, request, context);
              return ListPipelinesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          ListGoogleApiSourcesPagedResponse>
      LIST_GOOGLE_API_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGoogleApiSourcesRequest,
              ListGoogleApiSourcesResponse,
              ListGoogleApiSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListGoogleApiSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse> callable,
                ListGoogleApiSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListGoogleApiSourcesResponse> futureResponse) {
              PageContext<
                      ListGoogleApiSourcesRequest, ListGoogleApiSourcesResponse, GoogleApiSource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_GOOGLE_API_SOURCES_PAGE_STR_DESC, request, context);
              return ListGoogleApiSourcesPagedResponse.createAsync(pageContext, futureResponse);
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

  /** Returns the object with the settings used for calls to getMessageBus. */
  public UnaryCallSettings<GetMessageBusRequest, MessageBus> getMessageBusSettings() {
    return getMessageBusSettings;
  }

  /** Returns the object with the settings used for calls to listMessageBuses. */
  public PagedCallSettings<
          ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>
      listMessageBusesSettings() {
    return listMessageBusesSettings;
  }

  /** Returns the object with the settings used for calls to listMessageBusEnrollments. */
  public PagedCallSettings<
          ListMessageBusEnrollmentsRequest,
          ListMessageBusEnrollmentsResponse,
          ListMessageBusEnrollmentsPagedResponse>
      listMessageBusEnrollmentsSettings() {
    return listMessageBusEnrollmentsSettings;
  }

  /** Returns the object with the settings used for calls to createMessageBus. */
  public UnaryCallSettings<CreateMessageBusRequest, Operation> createMessageBusSettings() {
    return createMessageBusSettings;
  }

  /** Returns the object with the settings used for calls to createMessageBus. */
  public OperationCallSettings<CreateMessageBusRequest, MessageBus, OperationMetadata>
      createMessageBusOperationSettings() {
    return createMessageBusOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMessageBus. */
  public UnaryCallSettings<UpdateMessageBusRequest, Operation> updateMessageBusSettings() {
    return updateMessageBusSettings;
  }

  /** Returns the object with the settings used for calls to updateMessageBus. */
  public OperationCallSettings<UpdateMessageBusRequest, MessageBus, OperationMetadata>
      updateMessageBusOperationSettings() {
    return updateMessageBusOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMessageBus. */
  public UnaryCallSettings<DeleteMessageBusRequest, Operation> deleteMessageBusSettings() {
    return deleteMessageBusSettings;
  }

  /** Returns the object with the settings used for calls to deleteMessageBus. */
  public OperationCallSettings<DeleteMessageBusRequest, MessageBus, OperationMetadata>
      deleteMessageBusOperationSettings() {
    return deleteMessageBusOperationSettings;
  }

  /** Returns the object with the settings used for calls to getEnrollment. */
  public UnaryCallSettings<GetEnrollmentRequest, Enrollment> getEnrollmentSettings() {
    return getEnrollmentSettings;
  }

  /** Returns the object with the settings used for calls to listEnrollments. */
  public PagedCallSettings<
          ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>
      listEnrollmentsSettings() {
    return listEnrollmentsSettings;
  }

  /** Returns the object with the settings used for calls to createEnrollment. */
  public UnaryCallSettings<CreateEnrollmentRequest, Operation> createEnrollmentSettings() {
    return createEnrollmentSettings;
  }

  /** Returns the object with the settings used for calls to createEnrollment. */
  public OperationCallSettings<CreateEnrollmentRequest, Enrollment, OperationMetadata>
      createEnrollmentOperationSettings() {
    return createEnrollmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEnrollment. */
  public UnaryCallSettings<UpdateEnrollmentRequest, Operation> updateEnrollmentSettings() {
    return updateEnrollmentSettings;
  }

  /** Returns the object with the settings used for calls to updateEnrollment. */
  public OperationCallSettings<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
      updateEnrollmentOperationSettings() {
    return updateEnrollmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnrollment. */
  public UnaryCallSettings<DeleteEnrollmentRequest, Operation> deleteEnrollmentSettings() {
    return deleteEnrollmentSettings;
  }

  /** Returns the object with the settings used for calls to deleteEnrollment. */
  public OperationCallSettings<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
      deleteEnrollmentOperationSettings() {
    return deleteEnrollmentOperationSettings;
  }

  /** Returns the object with the settings used for calls to getPipeline. */
  public UnaryCallSettings<GetPipelineRequest, Pipeline> getPipelineSettings() {
    return getPipelineSettings;
  }

  /** Returns the object with the settings used for calls to listPipelines. */
  public PagedCallSettings<ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>
      listPipelinesSettings() {
    return listPipelinesSettings;
  }

  /** Returns the object with the settings used for calls to createPipeline. */
  public UnaryCallSettings<CreatePipelineRequest, Operation> createPipelineSettings() {
    return createPipelineSettings;
  }

  /** Returns the object with the settings used for calls to createPipeline. */
  public OperationCallSettings<CreatePipelineRequest, Pipeline, OperationMetadata>
      createPipelineOperationSettings() {
    return createPipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to updatePipeline. */
  public UnaryCallSettings<UpdatePipelineRequest, Operation> updatePipelineSettings() {
    return updatePipelineSettings;
  }

  /** Returns the object with the settings used for calls to updatePipeline. */
  public OperationCallSettings<UpdatePipelineRequest, Pipeline, OperationMetadata>
      updatePipelineOperationSettings() {
    return updatePipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to deletePipeline. */
  public UnaryCallSettings<DeletePipelineRequest, Operation> deletePipelineSettings() {
    return deletePipelineSettings;
  }

  /** Returns the object with the settings used for calls to deletePipeline. */
  public OperationCallSettings<DeletePipelineRequest, Pipeline, OperationMetadata>
      deletePipelineOperationSettings() {
    return deletePipelineOperationSettings;
  }

  /** Returns the object with the settings used for calls to getGoogleApiSource. */
  public UnaryCallSettings<GetGoogleApiSourceRequest, GoogleApiSource>
      getGoogleApiSourceSettings() {
    return getGoogleApiSourceSettings;
  }

  /** Returns the object with the settings used for calls to listGoogleApiSources. */
  public PagedCallSettings<
          ListGoogleApiSourcesRequest,
          ListGoogleApiSourcesResponse,
          ListGoogleApiSourcesPagedResponse>
      listGoogleApiSourcesSettings() {
    return listGoogleApiSourcesSettings;
  }

  /** Returns the object with the settings used for calls to createGoogleApiSource. */
  public UnaryCallSettings<CreateGoogleApiSourceRequest, Operation>
      createGoogleApiSourceSettings() {
    return createGoogleApiSourceSettings;
  }

  /** Returns the object with the settings used for calls to createGoogleApiSource. */
  public OperationCallSettings<CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      createGoogleApiSourceOperationSettings() {
    return createGoogleApiSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGoogleApiSource. */
  public UnaryCallSettings<UpdateGoogleApiSourceRequest, Operation>
      updateGoogleApiSourceSettings() {
    return updateGoogleApiSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateGoogleApiSource. */
  public OperationCallSettings<UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      updateGoogleApiSourceOperationSettings() {
    return updateGoogleApiSourceOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGoogleApiSource. */
  public UnaryCallSettings<DeleteGoogleApiSourceRequest, Operation>
      deleteGoogleApiSourceSettings() {
    return deleteGoogleApiSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteGoogleApiSource. */
  public OperationCallSettings<DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
      deleteGoogleApiSourceOperationSettings() {
    return deleteGoogleApiSourceOperationSettings;
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

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "eventarc";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  @ObsoleteApi("Use getEndpoint() instead")
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(EventarcStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

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
    getMessageBusSettings = settingsBuilder.getMessageBusSettings().build();
    listMessageBusesSettings = settingsBuilder.listMessageBusesSettings().build();
    listMessageBusEnrollmentsSettings = settingsBuilder.listMessageBusEnrollmentsSettings().build();
    createMessageBusSettings = settingsBuilder.createMessageBusSettings().build();
    createMessageBusOperationSettings = settingsBuilder.createMessageBusOperationSettings().build();
    updateMessageBusSettings = settingsBuilder.updateMessageBusSettings().build();
    updateMessageBusOperationSettings = settingsBuilder.updateMessageBusOperationSettings().build();
    deleteMessageBusSettings = settingsBuilder.deleteMessageBusSettings().build();
    deleteMessageBusOperationSettings = settingsBuilder.deleteMessageBusOperationSettings().build();
    getEnrollmentSettings = settingsBuilder.getEnrollmentSettings().build();
    listEnrollmentsSettings = settingsBuilder.listEnrollmentsSettings().build();
    createEnrollmentSettings = settingsBuilder.createEnrollmentSettings().build();
    createEnrollmentOperationSettings = settingsBuilder.createEnrollmentOperationSettings().build();
    updateEnrollmentSettings = settingsBuilder.updateEnrollmentSettings().build();
    updateEnrollmentOperationSettings = settingsBuilder.updateEnrollmentOperationSettings().build();
    deleteEnrollmentSettings = settingsBuilder.deleteEnrollmentSettings().build();
    deleteEnrollmentOperationSettings = settingsBuilder.deleteEnrollmentOperationSettings().build();
    getPipelineSettings = settingsBuilder.getPipelineSettings().build();
    listPipelinesSettings = settingsBuilder.listPipelinesSettings().build();
    createPipelineSettings = settingsBuilder.createPipelineSettings().build();
    createPipelineOperationSettings = settingsBuilder.createPipelineOperationSettings().build();
    updatePipelineSettings = settingsBuilder.updatePipelineSettings().build();
    updatePipelineOperationSettings = settingsBuilder.updatePipelineOperationSettings().build();
    deletePipelineSettings = settingsBuilder.deletePipelineSettings().build();
    deletePipelineOperationSettings = settingsBuilder.deletePipelineOperationSettings().build();
    getGoogleApiSourceSettings = settingsBuilder.getGoogleApiSourceSettings().build();
    listGoogleApiSourcesSettings = settingsBuilder.listGoogleApiSourcesSettings().build();
    createGoogleApiSourceSettings = settingsBuilder.createGoogleApiSourceSettings().build();
    createGoogleApiSourceOperationSettings =
        settingsBuilder.createGoogleApiSourceOperationSettings().build();
    updateGoogleApiSourceSettings = settingsBuilder.updateGoogleApiSourceSettings().build();
    updateGoogleApiSourceOperationSettings =
        settingsBuilder.updateGoogleApiSourceOperationSettings().build();
    deleteGoogleApiSourceSettings = settingsBuilder.deleteGoogleApiSourceSettings().build();
    deleteGoogleApiSourceOperationSettings =
        settingsBuilder.deleteGoogleApiSourceOperationSettings().build();
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
    private final UnaryCallSettings.Builder<GetMessageBusRequest, MessageBus> getMessageBusSettings;
    private final PagedCallSettings.Builder<
            ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>
        listMessageBusesSettings;
    private final PagedCallSettings.Builder<
            ListMessageBusEnrollmentsRequest,
            ListMessageBusEnrollmentsResponse,
            ListMessageBusEnrollmentsPagedResponse>
        listMessageBusEnrollmentsSettings;
    private final UnaryCallSettings.Builder<CreateMessageBusRequest, Operation>
        createMessageBusSettings;
    private final OperationCallSettings.Builder<
            CreateMessageBusRequest, MessageBus, OperationMetadata>
        createMessageBusOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMessageBusRequest, Operation>
        updateMessageBusSettings;
    private final OperationCallSettings.Builder<
            UpdateMessageBusRequest, MessageBus, OperationMetadata>
        updateMessageBusOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMessageBusRequest, Operation>
        deleteMessageBusSettings;
    private final OperationCallSettings.Builder<
            DeleteMessageBusRequest, MessageBus, OperationMetadata>
        deleteMessageBusOperationSettings;
    private final UnaryCallSettings.Builder<GetEnrollmentRequest, Enrollment> getEnrollmentSettings;
    private final PagedCallSettings.Builder<
            ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>
        listEnrollmentsSettings;
    private final UnaryCallSettings.Builder<CreateEnrollmentRequest, Operation>
        createEnrollmentSettings;
    private final OperationCallSettings.Builder<
            CreateEnrollmentRequest, Enrollment, OperationMetadata>
        createEnrollmentOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEnrollmentRequest, Operation>
        updateEnrollmentSettings;
    private final OperationCallSettings.Builder<
            UpdateEnrollmentRequest, Enrollment, OperationMetadata>
        updateEnrollmentOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEnrollmentRequest, Operation>
        deleteEnrollmentSettings;
    private final OperationCallSettings.Builder<
            DeleteEnrollmentRequest, Enrollment, OperationMetadata>
        deleteEnrollmentOperationSettings;
    private final UnaryCallSettings.Builder<GetPipelineRequest, Pipeline> getPipelineSettings;
    private final PagedCallSettings.Builder<
            ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>
        listPipelinesSettings;
    private final UnaryCallSettings.Builder<CreatePipelineRequest, Operation>
        createPipelineSettings;
    private final OperationCallSettings.Builder<CreatePipelineRequest, Pipeline, OperationMetadata>
        createPipelineOperationSettings;
    private final UnaryCallSettings.Builder<UpdatePipelineRequest, Operation>
        updatePipelineSettings;
    private final OperationCallSettings.Builder<UpdatePipelineRequest, Pipeline, OperationMetadata>
        updatePipelineOperationSettings;
    private final UnaryCallSettings.Builder<DeletePipelineRequest, Operation>
        deletePipelineSettings;
    private final OperationCallSettings.Builder<DeletePipelineRequest, Pipeline, OperationMetadata>
        deletePipelineOperationSettings;
    private final UnaryCallSettings.Builder<GetGoogleApiSourceRequest, GoogleApiSource>
        getGoogleApiSourceSettings;
    private final PagedCallSettings.Builder<
            ListGoogleApiSourcesRequest,
            ListGoogleApiSourcesResponse,
            ListGoogleApiSourcesPagedResponse>
        listGoogleApiSourcesSettings;
    private final UnaryCallSettings.Builder<CreateGoogleApiSourceRequest, Operation>
        createGoogleApiSourceSettings;
    private final OperationCallSettings.Builder<
            CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        createGoogleApiSourceOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGoogleApiSourceRequest, Operation>
        updateGoogleApiSourceSettings;
    private final OperationCallSettings.Builder<
            UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        updateGoogleApiSourceOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGoogleApiSourceRequest, Operation>
        deleteGoogleApiSourceSettings;
    private final OperationCallSettings.Builder<
            DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        deleteGoogleApiSourceOperationSettings;
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
          "retry_policy_0_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNKNOWN)));
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
              .setMaxRetryDelayDuration(Duration.ofMillis(60000L))
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
      getMessageBusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMessageBusesSettings = PagedCallSettings.newBuilder(LIST_MESSAGE_BUSES_PAGE_STR_FACT);
      listMessageBusEnrollmentsSettings =
          PagedCallSettings.newBuilder(LIST_MESSAGE_BUS_ENROLLMENTS_PAGE_STR_FACT);
      createMessageBusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMessageBusOperationSettings = OperationCallSettings.newBuilder();
      updateMessageBusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMessageBusOperationSettings = OperationCallSettings.newBuilder();
      deleteMessageBusSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMessageBusOperationSettings = OperationCallSettings.newBuilder();
      getEnrollmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listEnrollmentsSettings = PagedCallSettings.newBuilder(LIST_ENROLLMENTS_PAGE_STR_FACT);
      createEnrollmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEnrollmentOperationSettings = OperationCallSettings.newBuilder();
      updateEnrollmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEnrollmentOperationSettings = OperationCallSettings.newBuilder();
      deleteEnrollmentSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEnrollmentOperationSettings = OperationCallSettings.newBuilder();
      getPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPipelinesSettings = PagedCallSettings.newBuilder(LIST_PIPELINES_PAGE_STR_FACT);
      createPipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createPipelineOperationSettings = OperationCallSettings.newBuilder();
      updatePipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updatePipelineOperationSettings = OperationCallSettings.newBuilder();
      deletePipelineSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deletePipelineOperationSettings = OperationCallSettings.newBuilder();
      getGoogleApiSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listGoogleApiSourcesSettings =
          PagedCallSettings.newBuilder(LIST_GOOGLE_API_SOURCES_PAGE_STR_FACT);
      createGoogleApiSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGoogleApiSourceOperationSettings = OperationCallSettings.newBuilder();
      updateGoogleApiSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGoogleApiSourceOperationSettings = OperationCallSettings.newBuilder();
      deleteGoogleApiSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGoogleApiSourceOperationSettings = OperationCallSettings.newBuilder();
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
              getMessageBusSettings,
              listMessageBusesSettings,
              listMessageBusEnrollmentsSettings,
              createMessageBusSettings,
              updateMessageBusSettings,
              deleteMessageBusSettings,
              getEnrollmentSettings,
              listEnrollmentsSettings,
              createEnrollmentSettings,
              updateEnrollmentSettings,
              deleteEnrollmentSettings,
              getPipelineSettings,
              listPipelinesSettings,
              createPipelineSettings,
              updatePipelineSettings,
              deletePipelineSettings,
              getGoogleApiSourceSettings,
              listGoogleApiSourcesSettings,
              createGoogleApiSourceSettings,
              updateGoogleApiSourceSettings,
              deleteGoogleApiSourceSettings,
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
      getMessageBusSettings = settings.getMessageBusSettings.toBuilder();
      listMessageBusesSettings = settings.listMessageBusesSettings.toBuilder();
      listMessageBusEnrollmentsSettings = settings.listMessageBusEnrollmentsSettings.toBuilder();
      createMessageBusSettings = settings.createMessageBusSettings.toBuilder();
      createMessageBusOperationSettings = settings.createMessageBusOperationSettings.toBuilder();
      updateMessageBusSettings = settings.updateMessageBusSettings.toBuilder();
      updateMessageBusOperationSettings = settings.updateMessageBusOperationSettings.toBuilder();
      deleteMessageBusSettings = settings.deleteMessageBusSettings.toBuilder();
      deleteMessageBusOperationSettings = settings.deleteMessageBusOperationSettings.toBuilder();
      getEnrollmentSettings = settings.getEnrollmentSettings.toBuilder();
      listEnrollmentsSettings = settings.listEnrollmentsSettings.toBuilder();
      createEnrollmentSettings = settings.createEnrollmentSettings.toBuilder();
      createEnrollmentOperationSettings = settings.createEnrollmentOperationSettings.toBuilder();
      updateEnrollmentSettings = settings.updateEnrollmentSettings.toBuilder();
      updateEnrollmentOperationSettings = settings.updateEnrollmentOperationSettings.toBuilder();
      deleteEnrollmentSettings = settings.deleteEnrollmentSettings.toBuilder();
      deleteEnrollmentOperationSettings = settings.deleteEnrollmentOperationSettings.toBuilder();
      getPipelineSettings = settings.getPipelineSettings.toBuilder();
      listPipelinesSettings = settings.listPipelinesSettings.toBuilder();
      createPipelineSettings = settings.createPipelineSettings.toBuilder();
      createPipelineOperationSettings = settings.createPipelineOperationSettings.toBuilder();
      updatePipelineSettings = settings.updatePipelineSettings.toBuilder();
      updatePipelineOperationSettings = settings.updatePipelineOperationSettings.toBuilder();
      deletePipelineSettings = settings.deletePipelineSettings.toBuilder();
      deletePipelineOperationSettings = settings.deletePipelineOperationSettings.toBuilder();
      getGoogleApiSourceSettings = settings.getGoogleApiSourceSettings.toBuilder();
      listGoogleApiSourcesSettings = settings.listGoogleApiSourcesSettings.toBuilder();
      createGoogleApiSourceSettings = settings.createGoogleApiSourceSettings.toBuilder();
      createGoogleApiSourceOperationSettings =
          settings.createGoogleApiSourceOperationSettings.toBuilder();
      updateGoogleApiSourceSettings = settings.updateGoogleApiSourceSettings.toBuilder();
      updateGoogleApiSourceOperationSettings =
          settings.updateGoogleApiSourceOperationSettings.toBuilder();
      deleteGoogleApiSourceSettings = settings.deleteGoogleApiSourceSettings.toBuilder();
      deleteGoogleApiSourceOperationSettings =
          settings.deleteGoogleApiSourceOperationSettings.toBuilder();
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
              getMessageBusSettings,
              listMessageBusesSettings,
              listMessageBusEnrollmentsSettings,
              createMessageBusSettings,
              updateMessageBusSettings,
              deleteMessageBusSettings,
              getEnrollmentSettings,
              listEnrollmentsSettings,
              createEnrollmentSettings,
              updateEnrollmentSettings,
              deleteEnrollmentSettings,
              getPipelineSettings,
              listPipelinesSettings,
              createPipelineSettings,
              updatePipelineSettings,
              deletePipelineSettings,
              getGoogleApiSourceSettings,
              listGoogleApiSourcesSettings,
              createGoogleApiSourceSettings,
              updateGoogleApiSourceSettings,
              deleteGoogleApiSourceSettings,
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
          .getTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listTriggersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteTriggerSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listChannelsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteChannelSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getProviderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listProvidersSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listChannelConnectionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteChannelConnectionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getGoogleChannelConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateGoogleChannelConfigSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getMessageBusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMessageBusesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMessageBusEnrollmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createMessageBusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateMessageBusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteMessageBusSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getEnrollmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listEnrollmentsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createEnrollmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateEnrollmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteEnrollmentSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPipelinesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createPipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updatePipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deletePipelineSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .getGoogleApiSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listGoogleApiSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .createGoogleApiSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .updateGoogleApiSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"));

      builder
          .deleteGoogleApiSourceSettings()
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
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTriggerOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTriggerRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Trigger.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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
                      .setInitialRetryDelayDuration(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelayDuration(Duration.ofMillis(45000L))
                      .setInitialRpcTimeoutDuration(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeoutDuration(Duration.ZERO)
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
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
              ProtoOperationTransformers.ResponseTransformer.create(Channel.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createChannelConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateChannelConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelConnection.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteChannelConnectionOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteChannelConnectionRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ChannelConnection.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMessageBusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateMessageBusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MessageBus.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMessageBusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateMessageBusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MessageBus.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMessageBusOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteMessageBusRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(MessageBus.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createEnrollmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEnrollmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Enrollment.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateEnrollmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEnrollmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Enrollment.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEnrollmentOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEnrollmentRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Enrollment.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createPipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreatePipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Pipeline.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updatePipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdatePipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Pipeline.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deletePipelineOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeletePipelineRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Pipeline.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGoogleApiSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGoogleApiSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GoogleApiSource.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGoogleApiSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGoogleApiSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GoogleApiSource.class))
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
                      .setTotalTimeoutDuration(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGoogleApiSourceOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGoogleApiSourceRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_1_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_1_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GoogleApiSource.class))
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
    public OperationCallSettings.Builder<CreateTriggerRequest, Trigger, OperationMetadata>
        createTriggerOperationSettings() {
      return createTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public UnaryCallSettings.Builder<UpdateTriggerRequest, Operation> updateTriggerSettings() {
      return updateTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to updateTrigger. */
    public OperationCallSettings.Builder<UpdateTriggerRequest, Trigger, OperationMetadata>
        updateTriggerOperationSettings() {
      return updateTriggerOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
    public UnaryCallSettings.Builder<DeleteTriggerRequest, Operation> deleteTriggerSettings() {
      return deleteTriggerSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTrigger. */
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
    public OperationCallSettings.Builder<CreateChannelRequest, Channel, OperationMetadata>
        createChannelOperationSettings() {
      return createChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public UnaryCallSettings.Builder<UpdateChannelRequest, Operation> updateChannelSettings() {
      return updateChannelSettings;
    }

    /** Returns the builder for the settings used for calls to updateChannel. */
    public OperationCallSettings.Builder<UpdateChannelRequest, Channel, OperationMetadata>
        updateChannelOperationSettings() {
      return updateChannelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
    public UnaryCallSettings.Builder<DeleteChannelRequest, Operation> deleteChannelSettings() {
      return deleteChannelSettings;
    }

    /** Returns the builder for the settings used for calls to deleteChannel. */
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

    /** Returns the builder for the settings used for calls to getMessageBus. */
    public UnaryCallSettings.Builder<GetMessageBusRequest, MessageBus> getMessageBusSettings() {
      return getMessageBusSettings;
    }

    /** Returns the builder for the settings used for calls to listMessageBuses. */
    public PagedCallSettings.Builder<
            ListMessageBusesRequest, ListMessageBusesResponse, ListMessageBusesPagedResponse>
        listMessageBusesSettings() {
      return listMessageBusesSettings;
    }

    /** Returns the builder for the settings used for calls to listMessageBusEnrollments. */
    public PagedCallSettings.Builder<
            ListMessageBusEnrollmentsRequest,
            ListMessageBusEnrollmentsResponse,
            ListMessageBusEnrollmentsPagedResponse>
        listMessageBusEnrollmentsSettings() {
      return listMessageBusEnrollmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createMessageBus. */
    public UnaryCallSettings.Builder<CreateMessageBusRequest, Operation>
        createMessageBusSettings() {
      return createMessageBusSettings;
    }

    /** Returns the builder for the settings used for calls to createMessageBus. */
    public OperationCallSettings.Builder<CreateMessageBusRequest, MessageBus, OperationMetadata>
        createMessageBusOperationSettings() {
      return createMessageBusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMessageBus. */
    public UnaryCallSettings.Builder<UpdateMessageBusRequest, Operation>
        updateMessageBusSettings() {
      return updateMessageBusSettings;
    }

    /** Returns the builder for the settings used for calls to updateMessageBus. */
    public OperationCallSettings.Builder<UpdateMessageBusRequest, MessageBus, OperationMetadata>
        updateMessageBusOperationSettings() {
      return updateMessageBusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMessageBus. */
    public UnaryCallSettings.Builder<DeleteMessageBusRequest, Operation>
        deleteMessageBusSettings() {
      return deleteMessageBusSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMessageBus. */
    public OperationCallSettings.Builder<DeleteMessageBusRequest, MessageBus, OperationMetadata>
        deleteMessageBusOperationSettings() {
      return deleteMessageBusOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getEnrollment. */
    public UnaryCallSettings.Builder<GetEnrollmentRequest, Enrollment> getEnrollmentSettings() {
      return getEnrollmentSettings;
    }

    /** Returns the builder for the settings used for calls to listEnrollments. */
    public PagedCallSettings.Builder<
            ListEnrollmentsRequest, ListEnrollmentsResponse, ListEnrollmentsPagedResponse>
        listEnrollmentsSettings() {
      return listEnrollmentsSettings;
    }

    /** Returns the builder for the settings used for calls to createEnrollment. */
    public UnaryCallSettings.Builder<CreateEnrollmentRequest, Operation>
        createEnrollmentSettings() {
      return createEnrollmentSettings;
    }

    /** Returns the builder for the settings used for calls to createEnrollment. */
    public OperationCallSettings.Builder<CreateEnrollmentRequest, Enrollment, OperationMetadata>
        createEnrollmentOperationSettings() {
      return createEnrollmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnrollment. */
    public UnaryCallSettings.Builder<UpdateEnrollmentRequest, Operation>
        updateEnrollmentSettings() {
      return updateEnrollmentSettings;
    }

    /** Returns the builder for the settings used for calls to updateEnrollment. */
    public OperationCallSettings.Builder<UpdateEnrollmentRequest, Enrollment, OperationMetadata>
        updateEnrollmentOperationSettings() {
      return updateEnrollmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnrollment. */
    public UnaryCallSettings.Builder<DeleteEnrollmentRequest, Operation>
        deleteEnrollmentSettings() {
      return deleteEnrollmentSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEnrollment. */
    public OperationCallSettings.Builder<DeleteEnrollmentRequest, Enrollment, OperationMetadata>
        deleteEnrollmentOperationSettings() {
      return deleteEnrollmentOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getPipeline. */
    public UnaryCallSettings.Builder<GetPipelineRequest, Pipeline> getPipelineSettings() {
      return getPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to listPipelines. */
    public PagedCallSettings.Builder<
            ListPipelinesRequest, ListPipelinesResponse, ListPipelinesPagedResponse>
        listPipelinesSettings() {
      return listPipelinesSettings;
    }

    /** Returns the builder for the settings used for calls to createPipeline. */
    public UnaryCallSettings.Builder<CreatePipelineRequest, Operation> createPipelineSettings() {
      return createPipelineSettings;
    }

    /** Returns the builder for the settings used for calls to createPipeline. */
    public OperationCallSettings.Builder<CreatePipelineRequest, Pipeline, OperationMetadata>
        createPipelineOperationSettings() {
      return createPipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updatePipeline. */
    public UnaryCallSettings.Builder<UpdatePipelineRequest, Operation> updatePipelineSettings() {
      return updatePipelineSettings;
    }

    /** Returns the builder for the settings used for calls to updatePipeline. */
    public OperationCallSettings.Builder<UpdatePipelineRequest, Pipeline, OperationMetadata>
        updatePipelineOperationSettings() {
      return updatePipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deletePipeline. */
    public UnaryCallSettings.Builder<DeletePipelineRequest, Operation> deletePipelineSettings() {
      return deletePipelineSettings;
    }

    /** Returns the builder for the settings used for calls to deletePipeline. */
    public OperationCallSettings.Builder<DeletePipelineRequest, Pipeline, OperationMetadata>
        deletePipelineOperationSettings() {
      return deletePipelineOperationSettings;
    }

    /** Returns the builder for the settings used for calls to getGoogleApiSource. */
    public UnaryCallSettings.Builder<GetGoogleApiSourceRequest, GoogleApiSource>
        getGoogleApiSourceSettings() {
      return getGoogleApiSourceSettings;
    }

    /** Returns the builder for the settings used for calls to listGoogleApiSources. */
    public PagedCallSettings.Builder<
            ListGoogleApiSourcesRequest,
            ListGoogleApiSourcesResponse,
            ListGoogleApiSourcesPagedResponse>
        listGoogleApiSourcesSettings() {
      return listGoogleApiSourcesSettings;
    }

    /** Returns the builder for the settings used for calls to createGoogleApiSource. */
    public UnaryCallSettings.Builder<CreateGoogleApiSourceRequest, Operation>
        createGoogleApiSourceSettings() {
      return createGoogleApiSourceSettings;
    }

    /** Returns the builder for the settings used for calls to createGoogleApiSource. */
    public OperationCallSettings.Builder<
            CreateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        createGoogleApiSourceOperationSettings() {
      return createGoogleApiSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGoogleApiSource. */
    public UnaryCallSettings.Builder<UpdateGoogleApiSourceRequest, Operation>
        updateGoogleApiSourceSettings() {
      return updateGoogleApiSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateGoogleApiSource. */
    public OperationCallSettings.Builder<
            UpdateGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        updateGoogleApiSourceOperationSettings() {
      return updateGoogleApiSourceOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGoogleApiSource. */
    public UnaryCallSettings.Builder<DeleteGoogleApiSourceRequest, Operation>
        deleteGoogleApiSourceSettings() {
      return deleteGoogleApiSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGoogleApiSource. */
    public OperationCallSettings.Builder<
            DeleteGoogleApiSourceRequest, GoogleApiSource, OperationMetadata>
        deleteGoogleApiSourceOperationSettings() {
      return deleteGoogleApiSourceOperationSettings;
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
