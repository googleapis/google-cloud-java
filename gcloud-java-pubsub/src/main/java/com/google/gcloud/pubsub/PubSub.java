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

package com.google.gcloud.pubsub;

import com.google.gcloud.Page;
import com.google.gcloud.Service;

import java.util.List;
import java.util.concurrent.Future;

/**
 * An interface for Google Cloud Pub/Sub.
 *
 * @see <a href="https://cloud.google.com/pubsub/">Google Cloud Pub/Sub</a>
 */
public interface PubSub extends Service<PubSubOptions> {

  class ListOption {
    // page size
    // page token
  }

  class PullOption {
    // bool return_immediately = 2;
    // int32 max_messages = 3;
  }

  // topics
  //////////////////////
  Topic createTopic(TopicInfo topic);

  Future<Topic> createTopicAsync(String topic);

  // null if not found
  Topic getTopic(String topic);

  Future<Topic> getTopicAsync(String topic);

  // false if not found
  boolean deleteTopic(String topic);

  Future<Boolean> deleteTopicAsync(String topic);

  Page<Topic> listTopics(ListOption... options);

  // todo: consider AsyncPage that has nextPageAsync
  Future<Page<Topic>> listTopicsAsync(ListOption... options);

  String publish(String topic, Message message);

  Future<String> publishAsync(String topic, Message message);

  List<String> publish(String topic, Message first, Message... other);

  Future<List<String>> publishAsync(String topic, Message first, Message... other);

  // subscriptions
  ////////////////////////////
  Subscription createSubscription(SubscriptionInfo subscription);

  Future<Subscription> createSubscriptionAsync(SubscriptionInfo subscription);

  // null if not found
  Subscription getSubscription(String subscription);

  Future<Subscription> getSubscriptionAsync(String topic);

  // false if not found
  boolean deleteSubscription(String subscription);

  Future<Boolean> deleteSubscriptionAsync(String subscription);

  Page<Subscription> listSubscription(ListOption... options);

  // todo: consider AsyncPage that has nextPageAsync
  Future<Page<Subscription>> listSubscriptionAsync(ListOption... options);

  Page<Subscription> listSubscription(String topic, ListOption... options);

  // todo: consider AsyncPage that has nextPageAsync
  Future<Page<Subscription>> listSubscriptionAsync(String topic, ListOption... options);

  // Ack options:
  // 1) replace return value to ReceivedMessage (Message + functional ack)
  // 2) rename Message to MessageInfo and make Message functional with ack
  // 3) like (2) but with no auto-renew, so provide a function for renew
  // 4) return a "special" list (extends List) but has a way to "ackSoFar"
  // 5) instead of List use callback and auto-acknowledge per callback (and auto-renew)
  // ** Auto renew means, using a separate thread.
  List<Message> pull(String subscription, PullOption... options);

  Future<List<Message>> pullAsync(String subscription, PullOption... options);


  // Note regarding Date types:
  // 1) No field selection
  //  --- This is why there are no options for getters
  // 2) Never null for primitive values or collections
  //  --- should we replace default "" with null (e.g. id when not populated)?

  // IAM Policy operations:  getPolicy, replacePolicy, testPermissions
  // Not sure if ready (docs is not up-to-date), is it one per topic and
  // one per subscription?

}
