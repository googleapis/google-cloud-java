/*
 * Copyright 2017, Google Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.pubsub.spi.v1;

import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;
import static com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicsPagedResponse;

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.core.FlowControlSettings;
import com.google.api.gax.core.FlowController.LimitExceededBehavior;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.PropertiesProvider;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.BatchedRequestIssuer;
import com.google.api.gax.grpc.BatchingCallSettings;
import com.google.api.gax.grpc.BatchingDescriptor;
import com.google.api.gax.grpc.CallContext;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ClientSettings;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.InstantiatingChannelProvider;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.PagedCallSettings;
import com.google.api.gax.grpc.PagedListDescriptor;
import com.google.api.gax.grpc.PagedListResponseFactory;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.api.gax.grpc.UnaryCallSettings;
import com.google.api.gax.grpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.IAMPolicyGrpc;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.ExperimentalApi;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.Topic;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link TopicAdminClient}.
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
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of createTopic to 30 seconds:
 *
 * <pre>
 * <code>
 * TopicAdminSettings.Builder topicAdminSettingsBuilder =
 *     TopicAdminSettings.defaultBuilder();
 * topicAdminSettingsBuilder.createTopicSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * TopicAdminSettings topicAdminSettings = topicAdminSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@ExperimentalApi
public class TopicAdminSettings extends ClientSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "pubsub.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  private static final String DEFAULT_GAPIC_NAME = "gapic";
  private static final String DEFAULT_GAPIC_VERSION = "";

  private static final String PROPERTIES_FILE = "/project.properties";
  private static final String META_VERSION_KEY = "artifact.version";

  private static String gapicVersion;

  private final SimpleCallSettings<Topic, Topic> createTopicSettings;
  private final BatchingCallSettings<PublishRequest, PublishResponse> publishSettings;
  private final SimpleCallSettings<GetTopicRequest, Topic> getTopicSettings;
  private final PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings;
  private final PagedCallSettings<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsSettings;
  private final SimpleCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings;
  private final SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /** Returns the object with the settings used for calls to createTopic. */
  public SimpleCallSettings<Topic, Topic> createTopicSettings() {
    return createTopicSettings;
  }

  /** Returns the object with the settings used for calls to publish. */
  public BatchingCallSettings<PublishRequest, PublishResponse> publishSettings() {
    return publishSettings;
  }

  /** Returns the object with the settings used for calls to getTopic. */
  public SimpleCallSettings<GetTopicRequest, Topic> getTopicSettings() {
    return getTopicSettings;
  }

  /** Returns the object with the settings used for calls to listTopics. */
  public PagedCallSettings<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      listTopicsSettings() {
    return listTopicsSettings;
  }

  /** Returns the object with the settings used for calls to listTopicSubscriptions. */
  public PagedCallSettings<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      listTopicSubscriptionsSettings() {
    return listTopicSubscriptionsSettings;
  }

  /** Returns the object with the settings used for calls to deleteTopic. */
  public SimpleCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings() {
    return deleteTopicSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service address. */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingChannelProvider.Builder defaultChannelProviderBuilder() {
    return InstantiatingChannelProvider.newBuilder()
        .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
        .setPort(DEFAULT_SERVICE_PORT)
        .setGeneratorHeader(DEFAULT_GAPIC_NAME, getGapicVersion())
        .setCredentialsProvider(defaultCredentialsProviderBuilder().build());
  }

  private static String getGapicVersion() {
    if (gapicVersion == null) {
      gapicVersion =
          PropertiesProvider.loadProperty(
              TopicAdminSettings.class, PROPERTIES_FILE, META_VERSION_KEY);
      gapicVersion = gapicVersion == null ? DEFAULT_GAPIC_VERSION : gapicVersion;
    }
    return gapicVersion;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private TopicAdminSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder.getExecutorProvider(), settingsBuilder.getChannelProvider());

    createTopicSettings = settingsBuilder.createTopicSettings().build();
    publishSettings = settingsBuilder.publishSettings().build();
    getTopicSettings = settingsBuilder.getTopicSettings().build();
    listTopicsSettings = settingsBuilder.listTopicsSettings().build();
    listTopicSubscriptionsSettings = settingsBuilder.listTopicSubscriptionsSettings().build();
    deleteTopicSettings = settingsBuilder.deleteTopicSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  private static final PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_STR_DESC =
          new PagedListDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTopicsRequest injectToken(ListTopicsRequest payload, Object token) {
              return ListTopicsRequest.newBuilder(payload).setPageToken((String) token).build();
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
            public Object extractNextToken(ListTopicsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Topic> extractResources(ListTopicsResponse payload) {
              return payload.getTopicsList();
            }
          };

  private static final PagedListDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTopicSubscriptionsRequest injectToken(
                ListTopicSubscriptionsRequest payload, Object token) {
              return ListTopicSubscriptionsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
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
            public Object extractNextToken(ListTopicSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListTopicSubscriptionsResponse payload) {
              return payload.getSubscriptionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
      LIST_TOPICS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>() {
            @Override
            public ListTopicsPagedResponse createPagedListResponse(
                UnaryCallable<ListTopicsRequest, ListTopicsResponse> callable,
                ListTopicsRequest request,
                CallContext context) {
              return new ListTopicsPagedResponse(
                  callable, LIST_TOPICS_PAGE_STR_DESC, request, context);
            }
          };

  private static final PagedListResponseFactory<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
          ListTopicSubscriptionsPagedResponse>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
              ListTopicSubscriptionsPagedResponse>() {
            @Override
            public ListTopicSubscriptionsPagedResponse createPagedListResponse(
                UnaryCallable<ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse>
                    callable,
                ListTopicSubscriptionsRequest request,
                CallContext context) {
              return new ListTopicSubscriptionsPagedResponse(
                  callable, LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC, request, context);
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
              subresponseElements.add(batchResponse.getMessageIds(batchMessageIndex));
              batchMessageIndex += 1;
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

  /** Builder for TopicAdminSettings. */
  public static class Builder extends ClientSettings.Builder {
    private final ImmutableList<UnaryCallSettings.Builder> unaryMethodSettingsBuilders;

    private final SimpleCallSettings.Builder<Topic, Topic> createTopicSettings;
    private final BatchingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings;
    private final SimpleCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings;
    private final PagedCallSettings.Builder<
            ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings;
    private final PagedCallSettings.Builder<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
            ListTopicSubscriptionsPagedResponse>
        listTopicSubscriptionsSettings;
    private final SimpleCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings;
    private final SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put(
          "one_plus_delivery",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.CANCELLED,
                  Status.Code.UNKNOWN,
                  Status.Code.DEADLINE_EXCEEDED,
                  Status.Code.RESOURCE_EXHAUSTED,
                  Status.Code.ABORTED,
                  Status.Code.INTERNAL,
                  Status.Code.UNAVAILABLE)));
      definitions.put(
          "non_idempotent",
          Sets.immutableEnumSet(Lists.<Status.Code>newArrayList(Status.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(60000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("default", settingsBuilder);
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.millis(60000L))
              .setInitialRpcTimeout(Duration.millis(12000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.millis(12000L))
              .setTotalTimeout(Duration.millis(600000L));
      definitions.put("messaging", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(defaultChannelProviderBuilder().build());

      createTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_CREATE_TOPIC);

      publishSettings =
          BatchingCallSettings.newBuilder(PublisherGrpc.METHOD_PUBLISH, PUBLISH_BATCHING_DESC)
              .setBatchingSettingsBuilder(BatchingSettings.newBuilder());

      getTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_GET_TOPIC);

      listTopicsSettings =
          PagedCallSettings.newBuilder(PublisherGrpc.METHOD_LIST_TOPICS, LIST_TOPICS_PAGE_STR_FACT);

      listTopicSubscriptionsSettings =
          PagedCallSettings.newBuilder(
              PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS,
              LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_FACT);

      deleteTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_DELETE_TOPIC);

      setIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_SET_IAM_POLICY);

      getIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_GET_IAM_POLICY);

      testIamPermissionsSettings =
          SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_TEST_IAM_PERMISSIONS);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              createTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              deleteTopicSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .createTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .publishSettings()
          .getBatchingSettingsBuilder()
          .setElementCountThreshold(10)
          .setRequestByteThreshold(1024)
          .setDelayThreshold(Duration.millis(10))
          .setFlowControlSettings(
              FlowControlSettings.newBuilder()
                  .setLimitExceededBehavior(LimitExceededBehavior.Ignore)
                  .build());
      builder
          .publishSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("one_plus_delivery"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("messaging"));

      builder
          .getTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTopicsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listTopicSubscriptionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteTopicSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(TopicAdminSettings settings) {
      super(settings);

      createTopicSettings = settings.createTopicSettings.toBuilder();
      publishSettings = settings.publishSettings.toBuilder();
      getTopicSettings = settings.getTopicSettings.toBuilder();
      listTopicsSettings = settings.listTopicsSettings.toBuilder();
      listTopicSubscriptionsSettings = settings.listTopicSubscriptionsSettings.toBuilder();
      deleteTopicSettings = settings.deleteTopicSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder>of(
              createTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              deleteTopicSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    @Override
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      super.setExecutorProvider(executorProvider);
      return this;
    }

    @Override
    public Builder setChannelProvider(ChannelProvider channelProvider) {
      super.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Applies the given settings to all of the unary API methods in this service. Only values that
     * are non-null will be applied, so this method is not capable of un-setting any values.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(UnaryCallSettings.Builder unaryCallSettings)
        throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, unaryCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to createTopic. */
    public SimpleCallSettings.Builder<Topic, Topic> createTopicSettings() {
      return createTopicSettings;
    }

    /** Returns the builder for the settings used for calls to publish. */
    public BatchingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings() {
      return publishSettings;
    }

    /** Returns the builder for the settings used for calls to getTopic. */
    public SimpleCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings() {
      return getTopicSettings;
    }

    /** Returns the builder for the settings used for calls to listTopics. */
    public PagedCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, ListTopicsPagedResponse>
        listTopicsSettings() {
      return listTopicsSettings;
    }

    /** Returns the builder for the settings used for calls to listTopicSubscriptions. */
    public PagedCallSettings.Builder<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse,
            ListTopicSubscriptionsPagedResponse>
        listTopicSubscriptionsSettings() {
      return listTopicSubscriptionsSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTopic. */
    public SimpleCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings() {
      return deleteTopicSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public TopicAdminSettings build() throws IOException {
      return new TopicAdminSettings(this);
    }
  }
}
