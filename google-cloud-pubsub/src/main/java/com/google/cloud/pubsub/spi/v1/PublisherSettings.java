/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.BundlingCallSettings;
import com.google.api.gax.grpc.BundlingDescriptor;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.RequestIssuer;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.auth.Credentials;
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
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.Topic;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link PublisherApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (pubsub.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of createTopic to 30 seconds:
 *
 * <pre>
 * <code>
 * PublisherSettings.Builder publisherSettingsBuilder =
 *     PublisherSettings.defaultBuilder();
 * publisherSettingsBuilder.createTopicSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * PublisherSettings publisherSettings = publisherSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class PublisherSettings extends ServiceApiSettings {
  /**
   * The default address of the service.
   */
  private static final String DEFAULT_SERVICE_ADDRESS = "pubsub.googleapis.com";

  /**
   * The default port of the service.
   */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/pubsub")
          .build();

  /**
   * The default connection settings of the service.
   */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final SimpleCallSettings<Topic, Topic> createTopicSettings;
  private final BundlingCallSettings<PublishRequest, PublishResponse> publishSettings;
  private final SimpleCallSettings<GetTopicRequest, Topic> getTopicSettings;
  private final PageStreamingCallSettings<ListTopicsRequest, ListTopicsResponse, Topic>
      listTopicsSettings;
  private final PageStreamingCallSettings<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      listTopicSubscriptionsSettings;
  private final SimpleCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings;
  private final SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  /**
   * Returns the object with the settings used for calls to createTopic.
   */
  public SimpleCallSettings<Topic, Topic> createTopicSettings() {
    return createTopicSettings;
  }

  /**
   * Returns the object with the settings used for calls to publish.
   */
  public BundlingCallSettings<PublishRequest, PublishResponse> publishSettings() {
    return publishSettings;
  }

  /**
   * Returns the object with the settings used for calls to getTopic.
   */
  public SimpleCallSettings<GetTopicRequest, Topic> getTopicSettings() {
    return getTopicSettings;
  }

  /**
   * Returns the object with the settings used for calls to listTopics.
   */
  public PageStreamingCallSettings<ListTopicsRequest, ListTopicsResponse, Topic>
      listTopicsSettings() {
    return listTopicsSettings;
  }

  /**
   * Returns the object with the settings used for calls to listTopicSubscriptions.
   */
  public PageStreamingCallSettings<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      listTopicSubscriptionsSettings() {
    return listTopicSubscriptionsSettings;
  }

  /**
   * Returns the object with the settings used for calls to deleteTopic.
   */
  public SimpleCallSettings<DeleteTopicRequest, Empty> deleteTopicSettings() {
    return deleteTopicSettings;
  }

  /**
   * Returns the object with the settings used for calls to setIamPolicy.
   */
  public SimpleCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /**
   * Returns the object with the settings used for calls to getIamPolicy.
   */
  public SimpleCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /**
   * Returns the object with the settings used for calls to testIamPermissions.
   */
  public SimpleCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  /**
   * Returns the default service address.
   */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /**
   * Returns the default service port.
   */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /**
   * Returns the default service scopes.
   */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /**
   * Returns a builder for this class with recommended defaults.
   */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /**
   * Returns a new builder for this class.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Returns a builder containing all the values of this settings class.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private PublisherSettings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

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

  private static PageStreamingDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListTopicsRequest injectToken(ListTopicsRequest payload, Object token) {
              return ListTopicsRequest.newBuilder(payload).setPageToken((String) token).build();
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

  private static PageStreamingDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
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
            public Object extractNextToken(ListTopicSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListTopicSubscriptionsResponse payload) {
              return payload.getSubscriptionsList();
            }
          };

  private static BundlingDescriptor<PublishRequest, PublishResponse> PUBLISH_BUNDLING_DESC =
      new BundlingDescriptor<PublishRequest, PublishResponse>() {
        @Override
        public String getBundlePartitionKey(PublishRequest request) {
          return request.getTopic() + "|";
        }

        @Override
        public PublishRequest mergeRequests(Collection<PublishRequest> requests) {
          PublishRequest firstRequest = requests.iterator().next();

          List<PubsubMessage> elements = new ArrayList<>();
          for (PublishRequest request : requests) {
            elements.addAll(request.getMessagesList());
          }

          PublishRequest bundleRequest =
              PublishRequest.newBuilder()
                  .setTopic(firstRequest.getTopic())
                  .addAllMessages(elements)
                  .build();
          return bundleRequest;
        }

        @Override
        public void splitResponse(
            PublishResponse bundleResponse,
            Collection<? extends RequestIssuer<PublishRequest, PublishResponse>> bundle) {
          int bundleMessageIndex = 0;
          for (RequestIssuer<PublishRequest, PublishResponse> responder : bundle) {
            List<String> subresponseElements = new ArrayList<>();
            int subresponseCount = responder.getRequest().getMessagesCount();
            for (int i = 0; i < subresponseCount; i++) {
              subresponseElements.add(bundleResponse.getMessageIds(bundleMessageIndex));
              bundleMessageIndex += 1;
            }
            PublishResponse response =
                PublishResponse.newBuilder().addAllMessageIds(subresponseElements).build();
            responder.setResponse(response);
          }
        }

        @Override
        public void splitException(
            Throwable throwable,
            Collection<? extends RequestIssuer<PublishRequest, PublishResponse>> bundle) {
          for (RequestIssuer<PublishRequest, PublishResponse> responder : bundle) {
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

  /**
   * Builder for PublisherSettings.
   */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private SimpleCallSettings.Builder<Topic, Topic> createTopicSettings;
    private BundlingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings;
    private SimpleCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings;
    private PageStreamingCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, Topic>
        listTopicsSettings;
    private PageStreamingCallSettings.Builder<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        listTopicSubscriptionsSettings;
    private SimpleCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings;
    private SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
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
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
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
      super(DEFAULT_CONNECTION_SETTINGS);

      createTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_CREATE_TOPIC);

      publishSettings =
          BundlingCallSettings.newBuilder(PublisherGrpc.METHOD_PUBLISH, PUBLISH_BUNDLING_DESC)
              .setBundlingSettingsBuilder(BundlingSettings.newBuilder());

      getTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_GET_TOPIC);

      listTopicsSettings =
          PageStreamingCallSettings.newBuilder(
              PublisherGrpc.METHOD_LIST_TOPICS, LIST_TOPICS_PAGE_STR_DESC);

      listTopicSubscriptionsSettings =
          PageStreamingCallSettings.newBuilder(
              PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS,
              LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC);

      deleteTopicSettings = SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_DELETE_TOPIC);

      setIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_SET_IAM_POLICY);

      getIamPolicySettings = SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_GET_IAM_POLICY);

      testIamPermissionsSettings =
          SimpleCallSettings.newBuilder(IAMPolicyGrpc.METHOD_TEST_IAM_PERMISSIONS);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
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
          .getBundlingSettingsBuilder()
          .setElementCountThreshold(10)
          .setElementCountLimit(1000)
          .setRequestByteThreshold(1024)
          .setRequestByteLimit(10485760)
          .setDelayThreshold(Duration.millis(10))
          .setBlockingCallCountThreshold(1);
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

    private Builder(PublisherSettings settings) {
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

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
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
    protected ConnectionSettings getDefaultConnectionSettings() {
      return DEFAULT_CONNECTION_SETTINGS;
    }

    @Override
    public Builder provideExecutorWith(ScheduledExecutorService executor, boolean shouldAutoClose) {
      super.provideExecutorWith(executor, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ManagedChannel channel, boolean shouldAutoClose) {
      super.provideChannelWith(channel, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ConnectionSettings settings) {
      super.provideChannelWith(settings);
      return this;
    }

    @Override
    public Builder provideChannelWith(Credentials credentials) {
      super.provideChannelWith(credentials);
      return this;
    }

    @Override
    public Builder provideChannelWith(List<String> scopes) {
      super.provideChannelWith(scopes);
      return this;
    }

    @Override
    public Builder setGeneratorHeader(String name, String version) {
      super.setGeneratorHeader(name, version);
      return this;
    }

    @Override
    public Builder setClientLibHeader(String name, String version) {
      super.setClientLibHeader(name, version);
      return this;
    }

    /**
     * Applies the given settings to all of the API methods in this service. Only
     * values that are non-null will be applied, so this method is not capable
     * of un-setting any values.
     */
    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    /**
     * Returns the builder for the settings used for calls to createTopic.
     */
    public SimpleCallSettings.Builder<Topic, Topic> createTopicSettings() {
      return createTopicSettings;
    }

    /**
     * Returns the builder for the settings used for calls to publish.
     */
    public BundlingCallSettings.Builder<PublishRequest, PublishResponse> publishSettings() {
      return publishSettings;
    }

    /**
     * Returns the builder for the settings used for calls to getTopic.
     */
    public SimpleCallSettings.Builder<GetTopicRequest, Topic> getTopicSettings() {
      return getTopicSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listTopics.
     */
    public PageStreamingCallSettings.Builder<ListTopicsRequest, ListTopicsResponse, Topic>
        listTopicsSettings() {
      return listTopicsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to listTopicSubscriptions.
     */
    public PageStreamingCallSettings.Builder<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        listTopicSubscriptionsSettings() {
      return listTopicSubscriptionsSettings;
    }

    /**
     * Returns the builder for the settings used for calls to deleteTopic.
     */
    public SimpleCallSettings.Builder<DeleteTopicRequest, Empty> deleteTopicSettings() {
      return deleteTopicSettings;
    }

    /**
     * Returns the builder for the settings used for calls to setIamPolicy.
     */
    public SimpleCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to getIamPolicy.
     */
    public SimpleCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /**
     * Returns the builder for the settings used for calls to testIamPermissions.
     */
    public SimpleCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public PublisherSettings build() throws IOException {
      return new PublisherSettings(this);
    }
  }
}
