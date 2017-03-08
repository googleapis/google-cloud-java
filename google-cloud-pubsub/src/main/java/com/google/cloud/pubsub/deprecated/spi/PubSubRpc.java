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

import com.google.api.gax.core.ApiFuture;
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

public interface PubSubRpc extends AutoCloseable {

  /**
   * Sends a request to create a topic. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns the created topic.
   *
   * @param topic the topic to create
   */
  ApiFuture<Topic> create(Topic topic);

  /**
   * Sends a request to publish messages. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns a response object containing the publish result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<PublishResponse> publish(PublishRequest request);

  /**
   * Sends a request to get a topic. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns the requested topic or {@code null} if not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Topic> get(GetTopicRequest request);

  /**
   * Sends a request to list the topics in a project. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns a response object containing the listing
   * result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListTopicsResponse> list(ListTopicsRequest request);

  /**
   * Sends a request to list the subscriptions for a topic. This method returns a {@code ApiFuture}
   * object to consume the result. {@link ApiFuture#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request);

  /**
   * Sends a request to delete a topic. This method returns a {@code ApiFuture} object to consume the
   * result. {@link ApiFuture#get()} returns {@link Empty#getDefaultInstance()} or {@code null} if the
   * topic was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> delete(DeleteTopicRequest request);

  /**
   * Sends a request to create a subscription. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns the created subscription.
   *
   * @param subscription the subscription to create
   */
  ApiFuture<Subscription> create(Subscription subscription);

  /**
   * Sends a request to get a subscription. This method returns a {@code ApiFuture} object to consume
   * the result. {@link ApiFuture#get()} returns the requested subscription or {@code null} if not
   * found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Subscription> get(GetSubscriptionRequest request);

  /**
   * Sends a request to list the subscriptions in a project. This method returns a {@code ApiFuture}
   * object to consume the result. {@link ApiFuture#get()} returns a response object containing the
   * listing result.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<ListSubscriptionsResponse> list(ListSubscriptionsRequest request);

  /**
   * Sends a request to delete a subscription. This method returns a {@code ApiFuture} object to
   * consume the result. {@link ApiFuture#get()} returns {@link Empty#getDefaultInstance()} or
   * {@code null} if the subscription was not found.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> delete(DeleteSubscriptionRequest request);

  /**
   * Sends a request to modify the acknowledge deadline of a subscription. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> modify(ModifyAckDeadlineRequest request);

  /**
   * Sends a request to acknowledge messages for a subscription. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> acknowledge(AcknowledgeRequest request);

  /**
   * Sends a request to pull messages from a subscription. This method returns a {@link ApiFuture}
   * object to consume the result. {@link ApiFuture#get()} returns a response object containing the
   * pulled messages.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<PullResponse> pull(PullRequest request);

  /**
   * Sends a request to modify the push configuration of a subscription. This method returns a
   * {@code ApiFuture} object to consume the result. {@link ApiFuture#get()} returns
   * {@link Empty#getDefaultInstance()} if the request was issued correctly.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Empty> modify(ModifyPushConfigRequest request);

  /**
   * Sends a request to get the IAM policy for the provided resource.
   *
   * @param resource the resource for which to get the IAM policy
   */
  ApiFuture<Policy> getIamPolicy(String resource);

  /**
   * Sends a request to set the IAM policy for a resource.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<Policy> setIamPolicy(SetIamPolicyRequest request);

  /**
   * Sends a request to test the permissions that the caller has on a provided resource.
   *
   * @param request the request object containing all of the parameters for the API call
   */
  ApiFuture<TestIamPermissionsResponse> testIamPermissions(TestIamPermissionsRequest request);
}
