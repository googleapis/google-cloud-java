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

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/pubsub/v1/pubsub.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
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

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
/**
 * Settings class to configure an instance of {@link PublisherApi}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 * <li>The default service address (pubsub-experimental.googleapis.com) and default port (443)
 * are used.
 * <li>Credentials are acquired automatically through Application Default Credentials.
 * <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders.
 * When build() is called, the tree of builders is called to create the complete settings
 * object. For example, to set the total timeout of CreateTopic to 30 seconds:
 *
 * <pre>
 * <code>
 * PublisherSettings.Builder publisherSettingsBuilder =
 *     PublisherSettings.defaultInstance().toBuilder();
 * publisherSettingsBuilder.CreateTopicSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * PublisherSettings publisherSettings = publisherSettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class PublisherSettings extends ServiceApiSettings {

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String DEFAULT_SERVICE_ADDRESS = "pubsub-experimental.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  public static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/pubsub")
          .add("https://www.googleapis.com/auth/cloud-platform")
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
   * Returns an instance of this class with recommended defaults.
   */
  public static PublisherSettings defaultInstance() throws IOException {
    return newBuilder().build();
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
        settingsBuilder.getOrBuildChannel(),
        settingsBuilder.shouldAutoCloseChannel(),
        settingsBuilder.getOrBuildExecutor(),
        settingsBuilder.getConnectionSettings(),
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
          return request.getTopic();
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

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
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
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.millis(1000L))
              .setInitialRpcTimeout(Duration.millis(2000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.millis(30000L))
              .setTotalTimeout(Duration.millis(45000L));
      definitions.put("default", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(
          ConnectionSettings.newBuilder()
              .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
              .setPort(DEFAULT_SERVICE_PORT)
              .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
              .build());

      createTopicSettings =
          SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_CREATE_TOPIC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      BundlingSettings.Builder publishBundlingSettingsBuilder =
          BundlingSettings.newBuilder()
              .setElementCountThreshold(800)
              .setElementCountLimit(1000)
              .setRequestByteThreshold(8388608)
              .setRequestByteLimit(10485760)
              .setDelayThreshold(Duration.millis(100))
              .setBlockingCallCountThreshold(1);
      publishSettings =
          BundlingCallSettings.newBuilder(PublisherGrpc.METHOD_PUBLISH, PUBLISH_BUNDLING_DESC)
              .setBundlingSettingsBuilder(publishBundlingSettingsBuilder)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      getTopicSettings =
          SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_GET_TOPIC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      listTopicsSettings =
          PageStreamingCallSettings.newBuilder(
                  PublisherGrpc.METHOD_LIST_TOPICS, LIST_TOPICS_PAGE_STR_DESC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      listTopicSubscriptionsSettings =
          PageStreamingCallSettings.newBuilder(
                  PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS,
                  LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      deleteTopicSettings =
          SimpleCallSettings.newBuilder(PublisherGrpc.METHOD_DELETE_TOPIC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              createTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              deleteTopicSettings);
    }

    private Builder(PublisherSettings settings) {
      super(settings);

      createTopicSettings = settings.createTopicSettings.toBuilder();
      publishSettings = settings.publishSettings.toBuilder();
      getTopicSettings = settings.getTopicSettings.toBuilder();
      listTopicsSettings = settings.listTopicsSettings.toBuilder();
      listTopicSubscriptionsSettings = settings.listTopicSubscriptionsSettings.toBuilder();
      deleteTopicSettings = settings.deleteTopicSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              createTopicSettings,
              publishSettings,
              getTopicSettings,
              listTopicsSettings,
              listTopicSubscriptionsSettings,
              deleteTopicSettings);
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
    public Builder setExecutor(ScheduledExecutorService executor) {
      super.setExecutor(executor);
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

    @Override
    public PublisherSettings build() throws IOException {
      return new PublisherSettings(this);
    }
  }
}
