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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriberGrpc;
import com.google.pubsub.v1.Subscription;
import io.grpc.Status;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
@javax.annotation.Generated("by GAPIC")
public class SubscriberSettings extends ApiCallSettings {

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
  public static ImmutableList<String> DEFAULT_SERVICE_SCOPES =
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

  private final ApiCallableBuilder<Subscription, Subscription> createSubscriptionMethod;
  private final ApiCallableBuilder<GetSubscriptionRequest, Subscription> getSubscriptionMethod;
  private final PageStreamingApiCallableBuilder<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      listSubscriptionsMethod;
  private final ApiCallableBuilder<DeleteSubscriptionRequest, Empty> deleteSubscriptionMethod;
  private final ApiCallableBuilder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineMethod;
  private final ApiCallableBuilder<AcknowledgeRequest, Empty> acknowledgeMethod;
  private final ApiCallableBuilder<PullRequest, PullResponse> pullMethod;
  private final ApiCallableBuilder<ModifyPushConfigRequest, Empty> modifyPushConfigMethod;
  private final ImmutableList<? extends ApiCallSettings> allMethods;

  // ===============
  // Factory Methods
  // ===============

  /**
   * Constructs an instance of SubscriberSettings with default settings.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static SubscriberSettings create() {
    SubscriberSettings settings = new SubscriberSettings();
    settings.provideChannelWith(
        ConnectionSettings.builder()
            .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
            .setPort(DEFAULT_SERVICE_PORT)
            .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
            .build());
    return settings;
  }

  /**
   * Constructs an instance of SubscriberSettings with default settings. This is protected so that it
   * easy to make a subclass, but otherwise, the static factory methods should be preferred.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  protected SubscriberSettings() {
    createSubscriptionMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);
    createSubscriptionMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    getSubscriptionMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);
    getSubscriptionMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    listSubscriptionsMethod =
        new PageStreamingApiCallableBuilder<>(
            SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS, LIST_SUBSCRIPTIONS_PAGE_STR_DESC);
    listSubscriptionsMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    deleteSubscriptionMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);
    deleteSubscriptionMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    modifyAckDeadlineMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);
    modifyAckDeadlineMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    acknowledgeMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_ACKNOWLEDGE);
    acknowledgeMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    pullMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_PULL);
    pullMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    modifyPushConfigMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);
    modifyPushConfigMethod.setRetryDefaults(
        RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"), RETRY_PARAM_DEFINITIONS.get("default"));

    allMethods =
        ImmutableList.<ApiCallSettings>builder()
            .add(
                createSubscriptionMethod,
                getSubscriptionMethod,
                listSubscriptionsMethod,
                deleteSubscriptionMethod,
                modifyAckDeadlineMethod,
                acknowledgeMethod,
                pullMethod,
                modifyPushConfigMethod)
            .build();
  }

  /**
   * Returns the ApiCallableBuilder for the API method createSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<Subscription, Subscription> createSubscriptionMethod() {
    return createSubscriptionMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method getSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<GetSubscriptionRequest, Subscription> getSubscriptionMethod() {
    return getSubscriptionMethod;
  }

  /**
   * Returns the PageStreamingApiCallableBuilder for the API method listSubscriptions.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      listSubscriptionsMethod() {
    return listSubscriptionsMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method deleteSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<DeleteSubscriptionRequest, Empty> deleteSubscriptionMethod() {
    return deleteSubscriptionMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method modifyAckDeadline.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineMethod() {
    return modifyAckDeadlineMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method acknowledge.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<AcknowledgeRequest, Empty> acknowledgeMethod() {
    return acknowledgeMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method pull.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<PullRequest, PullResponse> pullMethod() {
    return pullMethod;
  }

  /**
   * Returns the ApiCallableBuilder for the API method modifyPushConfig.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<ModifyPushConfigRequest, Empty> modifyPushConfigMethod() {
    return modifyPushConfigMethod;
  }

  public ImmutableList<? extends ApiCallSettings> allMethods() {
    return allMethods;
  }

  private static PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PageDescriptor<ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListSubscriptionsRequest injectToken(
                ListSubscriptionsRequest payload, Object token) {
              return ListSubscriptionsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public Object extractNextToken(ListSubscriptionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Subscription> extractResources(ListSubscriptionsResponse payload) {
              return payload.getSubscriptionsList();
            }
          };
}
