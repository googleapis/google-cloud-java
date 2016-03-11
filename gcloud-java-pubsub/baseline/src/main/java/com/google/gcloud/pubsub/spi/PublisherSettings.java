/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.pubsub.spi;

import com.google.api.gax.core.BackoffParams;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetryParams;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.ApiCallable.ApiCallableBuilder;
import com.google.api.gax.grpc.ApiCallable.PageStreamingApiCallableBuilder;
import com.google.api.gax.grpc.PageDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
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
import com.google.pubsub.v1.Topic;
import io.grpc.Status;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
@javax.annotation.Generated("by GAPIC")
public class PublisherSettings extends ServiceApiSettings {

  // =========
  // Constants
  // =========

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

  private static final ImmutableMap<String, RetryParams> RETRY_PARAM_DEFINITIONS;

  static {
    ImmutableMap.Builder<String, RetryParams> definitions = ImmutableMap.builder();
    RetryParams params = null;
    params =
        RetryParams.newBuilder()
            .setRetryBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(100L)
                    .setDelayMultiplier(1.2)
                    .setMaxDelayMillis(1000L)
                    .build())
            .setTimeoutBackoff(
                BackoffParams.newBuilder()
                    .setInitialDelayMillis(300L)
                    .setDelayMultiplier(1.3)
                    .setMaxDelayMillis(3000L)
                    .build())
            .setTotalTimeout(30000L)
            .build();
    definitions.put("default", params);
    RETRY_PARAM_DEFINITIONS = definitions.build();
  }

  private static class MethodBuilders {
    private final ApiCallableBuilder<Topic, Topic> createTopicMethod;
    private final ApiCallableBuilder<PublishRequest, PublishResponse> publishMethod;
    private final ApiCallableBuilder<GetTopicRequest, Topic> getTopicMethod;
    private final PageStreamingApiCallableBuilder<ListTopicsRequest, ListTopicsResponse, Topic>
        listTopicsMethod;
    private final PageStreamingApiCallableBuilder<
            ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
        listTopicSubscriptionsMethod;
    private final ApiCallableBuilder<DeleteTopicRequest, Empty> deleteTopicMethod;
    private final ImmutableList<? extends ApiCallSettings> allMethods;

    public MethodBuilders() {
      createTopicMethod = new ApiCallableBuilder<>(PublisherGrpc.METHOD_CREATE_TOPIC);
      createTopicMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      createTopicMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      publishMethod = new ApiCallableBuilder<>(PublisherGrpc.METHOD_PUBLISH);
      publishMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      publishMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      getTopicMethod = new ApiCallableBuilder<>(PublisherGrpc.METHOD_GET_TOPIC);
      getTopicMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      getTopicMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      listTopicsMethod =
          new PageStreamingApiCallableBuilder<>(
              PublisherGrpc.METHOD_LIST_TOPICS, LIST_TOPICS_PAGE_STR_DESC);
      listTopicsMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listTopicsMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      listTopicSubscriptionsMethod =
          new PageStreamingApiCallableBuilder<>(
              PublisherGrpc.METHOD_LIST_TOPIC_SUBSCRIPTIONS,
              LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC);
      listTopicSubscriptionsMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listTopicSubscriptionsMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      deleteTopicMethod = new ApiCallableBuilder<>(PublisherGrpc.METHOD_DELETE_TOPIC);
      deleteTopicMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      deleteTopicMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      allMethods =
          ImmutableList.<ApiCallSettings>builder()
              .add(
                  createTopicMethod,
                  publishMethod,
                  getTopicMethod,
                  listTopicsMethod,
                  listTopicSubscriptionsMethod,
                  deleteTopicMethod)
              .build();
    }
  }

  private final MethodBuilders methods;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of PublisherSettings with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static PublisherSettings create() {
    PublisherSettings settings = new PublisherSettings(new MethodBuilders());
    settings.provideChannelWith(
        ConnectionSettings.builder()
            .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
            .setPort(DEFAULT_SERVICE_PORT)
            .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
            .build());
    return settings;
  }

  /**
   * Constructs an instance of PublisherSettings with default settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected PublisherSettings(MethodBuilders methods) {
    super(methods.allMethods);
    this.methods = methods;
  }

  /**
   * Returns the ApiCallableBuilder for the API method createTopic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<Topic, Topic> createTopicMethod() {
    return methods.createTopicMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method publish.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<PublishRequest, PublishResponse> publishMethod() {
    return methods.publishMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method getTopic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<GetTopicRequest, Topic> getTopicMethod() {
    return methods.getTopicMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method listTopics.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<ListTopicsRequest, ListTopicsResponse, Topic>
      listTopicsMethod() {
    return methods.listTopicsMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method listTopicSubscriptions.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      listTopicSubscriptionsMethod() {
    return methods.listTopicSubscriptionsMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method deleteTopic.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<DeleteTopicRequest, Empty> deleteTopicMethod() {
    return methods.deleteTopicMethod;
  }

  private static PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>
      LIST_TOPICS_PAGE_STR_DESC =
          new PageDescriptor<ListTopicsRequest, ListTopicsResponse, Topic>() {
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

  private static PageDescriptor<
          ListTopicSubscriptionsRequest, ListTopicSubscriptionsResponse, String>
      LIST_TOPIC_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PageDescriptor<
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
}
