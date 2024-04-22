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

package com.google.cloud.pubsub.v1.stub;

import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSnapshotsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.v1.TopicAdminClient.ListTopicsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
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
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BatchingDescriptor;
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
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.DetachSubscriptionResponse;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSnapshotsRequest;
import com.google.pubsub.v1.ListTopicSnapshotsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.UpdateTopicRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PublisherStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (pubsub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createTopic to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PublisherStubSettings.Builder topicAdminSettingsBuilder = PublisherStubSettings.newBuilder();
 * topicAdminSettingsBuilder
 *     .createTopicSettings()
 *     .setRetrySettings(
 *         topicAdminSettingsBuilder
 *             .createTopicSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PublisherStubSettings topicAdminSettings = topicAdminSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PublisherStubSettings extends StubSettings<PublisherStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  private final UnaryCallSettings<Topic, Topic> createTopicSettings;
  private final UnaryCallSettings<UpdateTopicRequest, Topic> updateTopicSettings;
  private final BatchingCallSettings<PublishRequest, PublishResponse> publishSettings;
  private final UnaryCallSettings<GetTopicRequest, Topic> getTopicSettings;
  private final PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings;
  private final PagedCallSettings<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsSettings;
  private final PagedCallSettings<
          ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, ListTopicSnapshotsPagedResponse>
      listTopicSnapshotsSettings;
  private final UnaryCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings;
  private final UnaryCallSettings<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTopicsRequest injectToken(ListTopicsRequest payload, String token) {
              return ListTopicsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTopicsRequest injectPageSize(ListTopicsRequest payload, int pageSize) {
              return ListTopicsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTopicsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTopicsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Topic> extractResources(ListTopicsResponse payload) {
              return payload.getTopicsList() == null
                  ? ImmutableList.<Topic>of()
                  : payload.getTopicsList();
            }
          };

  private static final PagedListDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTopicSubscriptionsRequest injectToken(
                ListTopicSubscriptionsRequest payload, String token) {
              return ListTopicSubscriptionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTopicSubscriptionsRequest injectPageSize(
                ListTopicSubscriptionsRequest payload, int pageSize) {
              return ListTopicSubscriptionsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListTopicSubscriptionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTopicSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListTopicSubscriptionsResponse payload) {
              return payload.getSubscriptionsList() == null
                  ? ImmutableList.<String>of()
                  : payload.getSubscriptionsList();
            }
          };

  private static final PagedListDescriptor<
          ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String>
      LIST_TOPIC_SNAPSHOTS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTopicSnapshotsRequest injectToken(
                ListTopicSnapshotsRequest payload, String token) {
              return ListTopicSnapshotsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTopicSnapshotsRequest injectPageSize(
                ListTopicSnapshotsRequest payload, int pageSize) {
              return ListTopicSnapshotsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTopicSnapshotsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTopicSnapshotsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListTopicSnapshotsResponse payload) {
              return payload.getSnapshotsList() == null
                  ? ImmutableList.<String>of()
                  : payload.getSnapshotsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      LIST_TOPICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>() {
            @Override
            public ApiFuture<ListTopicsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTopicsRequest, ListTopicsResponse> callable,
                ListTopicsRequest request,
                ApiCallContext context,
                ApiFuture<ListTopicsResponse> futureResponse) {
              PageContext<ListTopicsRequest, ListTopicsResponse, Topic> pageContext =
                  PageContext.create(callable, LIST_TOPICS_PAGE_STR_DESC, request, context);
              return ListTopicsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicSubscriptionsRequest,
              ListTopicSubscriptionsResponse,
              ListTopicSubscriptionsPagedResponse>() {
            @Override
            public ApiFuture<ListTopicSubscriptionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
                    callable,
                ListTopicSubscriptionsRequest request,
                ApiCallContext context,
                ApiFuture<ListTopicSubscriptionsResponse> futureResponse) {
              PageContext<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC, request, context);
              return ListTopicSubscriptionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, ListTopicSnapshotsPagedResponse>
      LIST_TOPIC_SNAPSHOTS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicSnapshotsRequest,
              ListTopicSnapshotsResponse,
              ListTopicSnapshotsPagedResponse>() {
            @Override
            public ApiFuture<ListTopicSnapshotsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse> callable,
                ListTopicSnapshotsRequest request,
                ApiCallContext context,
                ApiFuture<ListTopicSnapshotsResponse> futureResponse) {
              PageContext<ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, String>
                  pageContext =
                      PageContext.create(
                          callable, LIST_TOPIC_SNAPSHOTS_PAGE_STR_DESC, request, context);
              return ListTopicSnapshotsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final BatchingDescriptor<PublishRequest, PublishResponse> PUBLISH_BATCHING_DESC =
      new BatchingDescriptor<PublishRequest, PublishResponse>() {
        @Override
        public PartitionKey getBatchPartitionKey(PublishRequest request) {
          return new PartitionKey(request.getTopic());
        }

        @Override
        public RequestBuilder<PublishRequest> getRequestBuilder() {
          return new RequestBuilder<PublishRequest>() {
            private PublishRequest.Builder builder;

            @Override
            public void appendRequest(PublishRequest request) {
              if (builder == null) {
                builder = request.toBuilder();
              } else {
                builder.addAllMessages(request.getMessagesList());
              }
            }

            @Override
            public PublishRequest build() {
              return builder.build();
            }
          };
        }

        @Override
        public void splitResponse(
            PublishResponse batchResponse,
            Collection<? extends BatchedRequestIssuer<PublishResponse>> batch) {
          int batchMessageIndex = 0;
          for (BatchedRequestIssuer<PublishResponse> responder : batch) {
            List<String> subresponseElements = new ArrayList<>();
            long subresponseCount = responder.getMessageCount();
            for (int i = 0; i < subresponseCount; i++) {
              subresponseElements.add(batchResponse.getMessageIds(batchMessageIndex++));
            }
            PublishResponse response =
                PublishResponse.newBuilder().addAllMessageIds(subresponseElements).build();
            responder.setResponse(response);
          }
        }

        @Override
        public void splitException(
            Throwable throwable,
            Collection<? extends BatchedRequestIssuer<PublishResponse>> batch) {
          for (BatchedRequestIssuer<PublishResponse> responder : batch) {
            responder.setException(throwable);
          }
        }

        @Override
        public long countElements(PublishRequest request) {
          return request.getMessagesCount();
        }

        @Override
        public long countBytes(PublishRequest request) {
          return request.getSerializedSize();
        }
      };

  /** Returns the object with the settings used for calls to createTopic. */
  public UnaryCallSettings<Topic, Topic> createTopicSettings() {
    return createTopicSettings;
  }

  /** Returns the object with the settings used for calls to updateTopic. */
  public UnaryCallSettings<UpdateTopicRequest, Topic> updateTopicSettings() {
    return updateTopicSettings;
  }

  /** Returns the object with the settings used for calls to publish. */
  public BatchingCallSettings<PublishRequest, PublishResponse> publishSettings() {
    return publishSettings;
  }

  /** Returns the object with the settings used for calls to getTopic. */
  public UnaryCallSettings<GetTopicRequest, Topic> getTopicSettings() {
    return getTopicSettings;
  }

  /** Returns the object with the settings used for calls to listTopics. */
  public PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings() {
    return listTopicsSettings;
  }

  /** Returns the object with the settings used for calls to listTopicSubscriptions. */
  public PagedCallSettings<
          ListTopicSubscriptionsRequest,
          ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsSettings() {
    return listTopicSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to listTopicSnapshots. */
  public PagedCallSettings<
          ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, ListTopicSnapshotsPagedResponse>
      listTopicSnapshotsSettings() {
    return listTopicSnapshotsSettings;
  }

  /** Returns the object with the settings used for calls to deleteTopic. */
  public UnaryCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings() {
    return deleteTopicSettings;
  }

  /** Returns the object with the settings used for calls to detachSubscription. */
  public UnaryCallSettings<DetachSubscriptionRequest, DetachSubscriptionResponse>
      detachSubscriptionSettings() {
    return detachSubscriptionSettings;
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

  public PublisherStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPublisherStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPublisherStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "pubsub";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "pubsub.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "pubsub.mtls.googleapis.com:443";
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
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PublisherStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken("gapic", GaxProperties.getLibraryVersion(PublisherStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PublisherStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PublisherStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createTopicSettings = settingsBuilder.createTopicSettings().build();
    updateTopicSettings = settingsBuilder.updateTopicSettings().build();
    publishSettings = settingsBuilder.publishSettings().build();
    getTopicSettings = settingsBuilder.getTopicSettings().build();
    listTopicsSettings = settingsBuilder.listTopicsSettings().build();
    listTopicSubscriptionsSettings = settingsBuilder.listTopicSubscriptionsSettings().build();
    listTopicSnapshotsSettings = settingsBuilder.listTopicSnapshotsSettings().build();
    deleteTopicSettings = settingsBuilder.deleteTopicSettings().build();
    detachSubscriptionSettings = settingsBuilder.detachSubscriptionSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for PublisherStubSettings. */
  public static class Builder extends StubSettings.Builder<PublisherStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<Topic, Topic> createTopicSettings;
    private final UnaryCallSettings.Builder<UpdateTopicRequest, Topic> updateTopicSettings;
    private final BatchingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings;
    private final UnaryCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings;
    private final PagedCallSettings.Builder<
            ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings;
    private final PagedCallSettings.Builder<
            ListTopicSubscriptionsRequest,
            ListTopicSubscriptionsResponse,
            ListTopicSubscriptionsPagedResponse>
        listTopicSubscriptionsSettings;
    private final PagedCallSettings.Builder<
            ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, ListTopicSnapshotsPagedResponse>
        listTopicSnapshotsSettings;
    private final UnaryCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings;
    private final UnaryCallSettings.Builder<DetachSubscriptionRequest, DetachSubscriptionResponse>
        detachSubscriptionSettings;
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
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.ABORTED,
                  StatusCode.Code.CANCELLED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.RESOURCE_EXHAUSTED,
                  StatusCode.Code.UNKNOWN,
                  StatusCode.Code.UNAVAILABLE,
                  StatusCode.Code.DEADLINE_EXCEEDED)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.UNKNOWN, StatusCode.Code.ABORTED, StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(4.0)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      publishSettings =
          BatchingCallSettings.newBuilder(PUBLISH_BATCHING_DESC)
              .setBatchingSettings(BatchingSettings.newBuilder().build());
      getTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listTopicsSettings = PagedCallSettings.newBuilder(LIST_TOPICS_PAGE_STR_FACT);
      listTopicSubscriptionsSettings =
          PagedCallSettings.newBuilder(LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_FACT);
      listTopicSnapshotsSettings = PagedCallSettings.newBuilder(LIST_TOPIC_SNAPSHOTS_PAGE_STR_FACT);
      deleteTopicSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      detachSubscriptionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTopicSettings,
              updateTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              listTopicSnapshotsSettings,
              deleteTopicSettings,
              detachSubscriptionSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(PublisherStubSettings settings) {
      super(settings);

      createTopicSettings = settings.createTopicSettings.toBuilder();
      updateTopicSettings = settings.updateTopicSettings.toBuilder();
      publishSettings = settings.publishSettings.toBuilder();
      getTopicSettings = settings.getTopicSettings.toBuilder();
      listTopicsSettings = settings.listTopicsSettings.toBuilder();
      listTopicSubscriptionsSettings = settings.listTopicSubscriptionsSettings.toBuilder();
      listTopicSnapshotsSettings = settings.listTopicSnapshotsSettings.toBuilder();
      deleteTopicSettings = settings.deleteTopicSettings.toBuilder();
      detachSubscriptionSettings = settings.detachSubscriptionSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createTopicSettings,
              updateTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              listTopicSnapshotsSettings,
              deleteTopicSettings,
              detachSubscriptionSettings,
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
          .createTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .publishSettings()
          .setBatchingSettings(
              BatchingSettings.newBuilder()
                  .setElementCountThreshold(100L)
                  .setRequestByteThreshold(1048576L)
                  .setDelayThreshold(Duration.ofMillis(10L))
                  .setFlowControlSettings(
                      FlowControlSettings.newBuilder()
                          .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Ignore)
                          .build())
                  .build());

      builder
          .publishSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .getTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listTopicsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listTopicSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .listTopicSnapshotsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .deleteTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .detachSubscriptionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_2_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_2_params"));

      builder
          .testIamPermissionsSettings()
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

    /** Returns the builder for the settings used for calls to createTopic. */
    public UnaryCallSettings.Builder<Topic, Topic> createTopicSettings() {
      return createTopicSettings;
    }

    /** Returns the builder for the settings used for calls to updateTopic. */
    public UnaryCallSettings.Builder<UpdateTopicRequest, Topic> updateTopicSettings() {
      return updateTopicSettings;
    }

    /** Returns the builder for the settings used for calls to publish. */
    public BatchingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings() {
      return publishSettings;
    }

    /** Returns the builder for the settings used for calls to getTopic. */
    public UnaryCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings() {
      return getTopicSettings;
    }

    /** Returns the builder for the settings used for calls to listTopics. */
    public PagedCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings() {
      return listTopicsSettings;
    }

    /** Returns the builder for the settings used for calls to listTopicSubscriptions. */
    public PagedCallSettings.Builder<
            ListTopicSubscriptionsRequest,
            ListTopicSubscriptionsResponse,
            ListTopicSubscriptionsPagedResponse>
        listTopicSubscriptionsSettings() {
      return listTopicSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to listTopicSnapshots. */
    public PagedCallSettings.Builder<
            ListTopicSnapshotsRequest, ListTopicSnapshotsResponse, ListTopicSnapshotsPagedResponse>
        listTopicSnapshotsSettings() {
      return listTopicSnapshotsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTopic. */
    public UnaryCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings() {
      return deleteTopicSettings;
    }

    /** Returns the builder for the settings used for calls to detachSubscription. */
    public UnaryCallSettings.Builder<DetachSubscriptionRequest, DetachSubscriptionResponse>
        detachSubscriptionSettings() {
      return detachSubscriptionSettings;
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
    public PublisherStubSettings build() throws IOException {
      return new PublisherStubSettings(this);
    }
  }
}
