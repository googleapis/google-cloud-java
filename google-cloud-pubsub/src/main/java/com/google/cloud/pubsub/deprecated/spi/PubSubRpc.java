/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.deprecated.spi;

import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import java.util.concurrent.Future;

public interface PubSubRpc extends AutoCloseable {

  /**
   * A callback that can be registered to {@link PullFuture} objects. Objects of this class allow
   * to asynchronously react to the success or failure of a pull RPC.
   */
  interface PullCallback {

    /**
     * This method is invoked with the result of a {@link PullFuture} when it was successful.
     *
     * @param response the pull response
     */
    void success(PullResponse response);

    /**
     * This method is invoked when the {@link PullFuture} failed or was cancelled.
     *
     * @param error the execption that caused the {@link PullFuture} to fail
     */
    void failure(Throwable error);
  }

  /**
   * A {@link Future} implementation for pull RPCs. This class also allows users to register
   * callbacks via {@link #addCallback(PullCallback)}.
   */
  interface PullFuture extends Future<PullResponse> {

    /**
     * Registers a callback to be run on the given executor. The listener will run when the pull
     * future completed its computation or, if the computation is already complete, immediately.
     * There is no guaranteed ordering of execution of callbacks.
     *
     * <p>Registered callbacks are run using the same thread that run the RPC call. Only lightweight
     * callbacks should be registered via this method.
     */
    void addCallback(final PullCallback callback);
  }

  /**
   * Sends a request to create a topic. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the created topic.
   *
   * @param topic the topic to create
   */
  Future<Topic> create(Topic topic);

  /**
   * Sends a request to publish messages. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns a response object containing the publish result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<PublishResponse> publish(PublishRequest request);

  /**
   * Sends a request to get a topic. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the requested topic or {@code null} if not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Topic> get(GetTopicRequest request);

  /**
   * Sends a request to list the topics in a project. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns a response object containing the listing
   * result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<ListTopicsResponse> list(ListTopicsRequest request);

  /**
   * Sends a request to list the subscriptions for a topic. This method returns a {@code Future}
   * object to consume the result. {@link Future#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request);

  /**
   * Sends a request to delete a topic. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns {@link Empty#getDefaultInstance()} or {@code null} if the
   * topic was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Empty> delete(DeleteTopicRequest request);

  /**
   * Sends a request to create a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns the created subscription.
   *
   * @param subscription the subscription to create
   */
  Future<Subscription> create(Subscription subscription);

  /**
   * Sends a request to get a subscription. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns the requested subscription or {@code null} if not
   * found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Subscription> get(GetSubscriptionRequest request);

  /**
   * Sends a request to list the subscriptions in a project. This method returns a {@code Future}
   * object to consume the result. {@link Future#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<ListSubscriptionsResponse> list(ListSubscriptionsRequest request);

  /**
   * Sends a request to delete a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns {@link Empty#getDefaultInstance()} or
   * {@code null} if the subscription was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Empty> delete(DeleteSubscriptionRequest request);

  /**
   * Sends a request to modify the acknowledge deadline of a subscription. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Empty> modify(ModifyAckDeadlineRequest request);

  /**
   * Sends a request to acknowledge messages for a subscription. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Empty> acknowledge(AcknowledgeRequest request);

  /**
   * Sends a request to pull messages from a subscription. This method returns a {@link PullFuture}
   * object to consume the result. {@link PullFuture#get()} returns a response object containing the
   * pulled messages. {@link PullFuture#addCallback(PullCallback)} can be used to register a
   * callback for the request's completion.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  PullFuture pull(PullRequest request);

  /**
   * Sends a request to modify the push configuration of a subscription. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Empty> modify(ModifyPushConfigRequest request);

  /**
   * Sends a request to get the IAM policy for the provided resource.
   *
   * @param resource the resource for which to get the IAM policy
   */
  Future<Policy> getIamPolicy(String resource);

  /**
   * Sends a request to set the IAM policy for a resource.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<Policy> setIamPolicy(SetIamPolicyRequest request);

  /**
   * Sends a request to test the permissions that the caller has on a provided resource.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  Future<TestIamPermissionsResponse> testIamPermissions(TestIamPermissionsRequest request);
}
