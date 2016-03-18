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

package com.google.gcloud.pubsub.spi.v1;

import com.google.api.gax.core.BackoffParams;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetryParams;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.ApiCallable.ApiCallableBuilder;
import com.google.api.gax.grpc.ApiCallable.PageStreamingApiCallableBuilder;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
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
public class SubscriberSettings extends ServiceApiSettings {

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

    public MethodBuilders() {
      createSubscriptionMethod =
          new ApiCallableBuilder<>(SubscriberGrpc.METHOD_CREATE_SUBSCRIPTION);
      createSubscriptionMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      createSubscriptionMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      getSubscriptionMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_GET_SUBSCRIPTION);
      getSubscriptionMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      getSubscriptionMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      listSubscriptionsMethod =
          new PageStreamingApiCallableBuilder<>(
              SubscriberGrpc.METHOD_LIST_SUBSCRIPTIONS, LIST_SUBSCRIPTIONS_PAGE_STR_DESC);
      listSubscriptionsMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      listSubscriptionsMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      deleteSubscriptionMethod =
          new ApiCallableBuilder<>(SubscriberGrpc.METHOD_DELETE_SUBSCRIPTION);
      deleteSubscriptionMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"));
      deleteSubscriptionMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      modifyAckDeadlineMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_MODIFY_ACK_DEADLINE);
      modifyAckDeadlineMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      modifyAckDeadlineMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      acknowledgeMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_ACKNOWLEDGE);
      acknowledgeMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      acknowledgeMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      pullMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_PULL);
      pullMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      pullMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

      modifyPushConfigMethod = new ApiCallableBuilder<>(SubscriberGrpc.METHOD_MODIFY_PUSH_CONFIG);
      modifyPushConfigMethod.setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"));
      modifyPushConfigMethod.setRetryParams(RETRY_PARAM_DEFINITIONS.get("default"));

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
  }

  private final MethodBuilders methods;

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
    SubscriberSettings settings = new SubscriberSettings(new MethodBuilders());
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
  protected SubscriberSettings(MethodBuilders methods) {
    super(methods.allMethods);
    this.methods = methods;
  }

  /**
   * Returns the builder for the API method createSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<Subscription, Subscription> createSubscriptionMethod() {
    return methods.createSubscriptionMethod;
  }

  /**
   * Returns the builder for the API method getSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<GetSubscriptionRequest, Subscription> getSubscriptionMethod() {
    return methods.getSubscriptionMethod;
  }

  /**
   * Returns the builder for the API method listSubscriptions.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public PageStreamingApiCallableBuilder<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      listSubscriptionsMethod() {
    return methods.listSubscriptionsMethod;
  }

  /**
   * Returns the builder for the API method deleteSubscription.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<DeleteSubscriptionRequest, Empty> deleteSubscriptionMethod() {
    return methods.deleteSubscriptionMethod;
  }

  /**
   * Returns the builder for the API method modifyAckDeadline.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<ModifyAckDeadlineRequest, Empty> modifyAckDeadlineMethod() {
    return methods.modifyAckDeadlineMethod;
  }

  /**
   * Returns the builder for the API method acknowledge.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<AcknowledgeRequest, Empty> acknowledgeMethod() {
    return methods.acknowledgeMethod;
  }

  /**
   * Returns the builder for the API method pull.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<PullRequest, PullResponse> pullMethod() {
    return methods.pullMethod;
  }

  /**
   * Returns the builder for the API method modifyPushConfig.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public ApiCallableBuilder<ModifyPushConfigRequest, Empty> modifyPushConfigMethod() {
    return methods.modifyPushConfigMethod;
  }

  private static PageStreamingDescriptor<
          ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>
      LIST_SUBSCRIPTIONS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListSubscriptionsRequest, ListSubscriptionsResponse, Subscription>() {
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
