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

package com.google.cloud.pubsub.spi;

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

  // in all cases root cause of ExecutionException is PubSubException
  Future<Topic> create(Topic topic);

  Future<PublishResponse> publish(PublishRequest request);

  Future<Topic> get(GetTopicRequest request);

  Future<ListTopicsResponse> list(ListTopicsRequest request);

  Future<ListTopicSubscriptionsResponse> list(ListTopicSubscriptionsRequest request);

  Future<Empty> delete(DeleteTopicRequest request);

  Future<Subscription> create(Subscription subscription);

  Future<Subscription> get(GetSubscriptionRequest request);

  Future<ListSubscriptionsResponse> list(ListSubscriptionsRequest request);

  Future<Empty> delete(DeleteSubscriptionRequest request);

  Future<Empty> modify(ModifyAckDeadlineRequest request);

  Future<Empty> acknowledge(AcknowledgeRequest request);

  PullFuture pull(PullRequest request);

  Future<Empty> modify(ModifyPushConfigRequest request);
}
