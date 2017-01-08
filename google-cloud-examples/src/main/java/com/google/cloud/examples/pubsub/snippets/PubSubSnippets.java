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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in PubSub's javadoc. Any change to this file should be reflected in
 * PubSub's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.AsyncPage;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.PubSub;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.cloud.pubsub.Subscription;
import com.google.cloud.pubsub.SubscriptionId;
import com.google.cloud.pubsub.SubscriptionInfo;
import com.google.cloud.pubsub.Topic;
import com.google.cloud.pubsub.TopicInfo;
import com.google.pubsub.v1.PushConfig;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * This class contains a number of snippets for the {@link PubSub} interface.
 */
public class PubSubSnippets {

  private final PubSub pubsub;

  public PubSubSnippets(PubSub pubsub) {
    this.pubsub = pubsub;
  }

  /**
   * Example of creating a topic.
   */
  // [TARGET create(TopicInfo)]
  // [VARIABLE "my_topic_name"]
  public Topic createTopic(String topicName) {
    // [START createTopic]
    TopicInfo topicInfo = TopicInfo.of(topicName);
    Topic topic = pubsub.create(topicInfo);
    // [END createTopic]
    return topic;
  }

  /**
   * Example of asynchronously creating a topic.
   */
  // [TARGET createAsync(TopicInfo)]
  // [VARIABLE "my_topic_name"]
  public Topic createTopicAsync(String topicName) throws ExecutionException, InterruptedException {
    // [START createTopicAsync]
    TopicInfo topicInfo = TopicInfo.of(topicName);
    Future<Topic> future = pubsub.createAsync(topicInfo);
    // ...
    Topic topic = future.get();
    // [END createTopicAsync]
    return topic;
  }

  /**
   * Example of getting a topic.
   */
  // [TARGET getTopic(String)]
  // [VARIABLE "my_topic_name"]
  public Topic getTopic(String topicName) {
    // [START getTopic]
    Topic topic = pubsub.getTopic(topicName);
    if (topic == null) {
      // topic was not found
    }
    // [END getTopic]
    return topic;
  }

  /**
   * Example of asynchronously getting a topic.
   */
  // [TARGET getTopicAsync(String)]
  // [VARIABLE "my_topic_name"]
  public Topic getTopicAsync(String topicName) throws ExecutionException, InterruptedException {
    // [START getTopicAsync]
    Future<Topic> future = pubsub.getTopicAsync(topicName);
    // ...
    Topic topic = future.get();
    if (topic == null) {
      // topic was not found
    }
    // [END getTopicAsync]
    return topic;
  }

  /**
   * Example of listing topics, specifying the page size.
   */
  // [TARGET listTopics(ListOption...)]
  public Page<Topic> listTopics() {
    // [START listTopics]
    Page<Topic> topics = pubsub.listTopics(ListOption.pageSize(100));
    Iterator<Topic> topicIterator = topics.iterateAll();
    while (topicIterator.hasNext()) {
      Topic topic = topicIterator.next();
      // do something with the topic
    }
    // [END listTopics]
    return topics;
  }

  /**
   * Example of asynchronously listing topics, specifying the page size.
   */
  // [TARGET listTopicsAsync(ListOption...)]
  public Page<Topic> listTopicsAsync() throws ExecutionException, InterruptedException {
    // [START listTopicsAsync]
    Future<AsyncPage<Topic>> future = pubsub.listTopicsAsync(ListOption.pageSize(100));
    // ...
    AsyncPage<Topic> topics = future.get();
    Iterator<Topic> topicIterator = topics.iterateAll();
    while (topicIterator.hasNext()) {
      Topic topic = topicIterator.next();
      // do something with the topic
    }
    // [END listTopicsAsync]
    return topics;
  }

  /**
   * Example of deleting a topic.
   */
  // [TARGET deleteTopic(String)]
  // [VARIABLE "my_topic_name"]
  public boolean deleteTopic(String topicName) {
    // [START deleteTopic]
    boolean deleted = pubsub.deleteTopic(topicName);
    if (deleted) {
      // the topic was deleted
    } else {
      // the topic was not found
    }
    // [END deleteTopic]
    return deleted;
  }

  /**
   * Example of asynchronously deleting a topic.
   */
  // [TARGET deleteTopicAsync(String)]
  // [VARIABLE "my_topic_name"]
  public boolean deleteTopicAsync(String topicName)
      throws ExecutionException, InterruptedException {
    // [START deleteTopicAsync]
    Future<Boolean> future = pubsub.deleteTopicAsync(topicName);
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the topic was deleted
    } else {
      // the topic was not found
    }
    // [END deleteTopicAsync]
    return deleted;
  }

  /**
   * Example of creating a pull subscription for a topic.
   */
  // [TARGET create(SubscriptionInfo)]
  // [VARIABLE "my_topic_name"]
  // [VARIABLE "my_subscription_name"]
  public Subscription createSubscription(String topicName, String subscriptionName) {
    // [START createSubscription]
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(topicName, subscriptionName);
    Subscription subscription = pubsub.create(subscriptionInfo);
    // [END createSubscription]
    return subscription;
  }

  /**
   * Example of asynchronously creating a pull subscription for a topic.
   */
  // [TARGET createAsync(SubscriptionInfo)]
  // [VARIABLE "my_topic_name"]
  // [VARIABLE "my_subscription_name"]
  public Subscription createSubscriptionAsync(String topicName, String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START createSubscriptionAsync]
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(topicName, subscriptionName);
    Future<Subscription> future = pubsub.createAsync(subscriptionInfo);
    // ...
    Subscription subscription = future.get();
    // [END createSubscriptionAsync]
    return subscription;
  }

  /**
   * Example of replacing the push configuration of a subscription, setting the push endpoint.
   */
  // [TARGET replacePushConfig(String, PushConfig)]
  // [VARIABLE "my_subscription_name"]
  // [VARIABLE "https://www.example.com/push"]
  public void replacePushConfig(String subscriptionName, String endpoint) {
    // [START replacePushConfig]
    PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
    pubsub.replacePushConfig(subscriptionName, pushConfig);
    // [END replacePushConfig]
  }

  /**
   * Example of replacing the push configuration of a subscription, making it a pull
   * subscription.
   */
  // [TARGET replacePushConfig(String, PushConfig)]
  // [VARIABLE "my_subscription_name"]
  public void replacePushConfigToPull(String subscriptionName) {
    // [START replacePushConfigToPull]
    pubsub.replacePushConfig(subscriptionName, null);
    // [END replacePushConfigToPull]
  }

  /**
   * Example of asynchronously replacing the push configuration of a subscription, setting the
   * push endpoint.
   */
  // [TARGET replacePushConfigAsync(String, PushConfig)]
  // [VARIABLE "my_subscription_name"]
  // [VARIABLE "https://www.example.com/push"]
  public void replacePushConfigAsync(String subscriptionName, String endpoint)
      throws ExecutionException, InterruptedException {
    // [START replacePushConfigAsync]
    PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
    Future<Void> future = pubsub.replacePushConfigAsync(subscriptionName, pushConfig);
    // ...
    future.get();
    // [END replacePushConfigAsync]
  }

  /**
   * Example of asynchronously replacing the push configuration of a subscription, making it a
   * pull subscription.
   */
  // [TARGET replacePushConfigAsync(String, PushConfig)]
  // [VARIABLE "my_subscription_name"]
  public void replacePushConfigToPullAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START replacePushConfigToPullAsync]
    Future<Void> future = pubsub.replacePushConfigAsync(subscriptionName, null);
    // ...
    future.get();
    // [END replacePushConfigToPullAsync]
  }

  /**
   * Example of getting a subscription.
   */
  // [TARGET getSubscription(String)]
  // [VARIABLE "my_subscription_name"]
  public Subscription getSubscription(String subscriptionName) {
    // [START getSubscription]
    Subscription subscription = pubsub.getSubscription(subscriptionName);
    if (subscription == null) {
      // subscription was not found
    }
    // [END getSubscription]
    return subscription;
  }

  /**
   * Example of asynchronously getting a subscription.
   */
  // [TARGET getSubscriptionAsync(String)]
  // [VARIABLE "my_subscription_name"]
  public Subscription getSubscriptionAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START getSubscriptionAsync]
    Future<Subscription> future = pubsub.getSubscriptionAsync(subscriptionName);
    // ...
    Subscription subscription = future.get();
    if (subscription == null) {
      // subscription was not found
    }
    // [END getSubscriptionAsync]
    return subscription;
  }

  /**
   * Example of listing subscriptions, specifying the page size.
   */
  // [TARGET listSubscriptions(ListOption...)]
  public Page<Subscription> listSubscriptions() {
    // [START listSubscriptions]
    Page<Subscription> subscriptions = pubsub.listSubscriptions(ListOption.pageSize(100));
    Iterator<Subscription> subscriptionIterator = subscriptions.iterateAll();
    while (subscriptionIterator.hasNext()) {
      Subscription subscription = subscriptionIterator.next();
      // do something with the subscription
    }
    // [END listSubscriptions]
    return subscriptions;
  }

  /**
   * Example of asynchronously listing subscriptions, specifying the page size.
   */
  // [TARGET listSubscriptionsAsync(ListOption...)]
  public Page<Subscription> listSubscriptionsAsync() throws ExecutionException, InterruptedException {
    // [START listSubscriptionsAsync]
    Future<AsyncPage<Subscription>> future =
        pubsub.listSubscriptionsAsync(ListOption.pageSize(100));
    // ...
    AsyncPage<Subscription> subscriptions = future.get();
    Iterator<Subscription> subscriptionIterator = subscriptions.iterateAll();
    while (subscriptionIterator.hasNext()) {
      Subscription subscription = subscriptionIterator.next();
      // do something with the subscription
    }
    // [END listSubscriptionsAsync]
    return subscriptions;
  }

  /**
   * Example of listing subscriptions for a topic, specifying the page size.
   */
  // [TARGET listSubscriptions(String, ListOption...)]
  // [VARIABLE "my_topic_name"]
  public Page<SubscriptionId> listSubscriptionsForTopic(String topicName) {
    // [START listSubscriptionsForTopic]
    Page<SubscriptionId> subscriptions =
        pubsub.listSubscriptions(topicName, ListOption.pageSize(100));
    Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
    while (subscriptionIterator.hasNext()) {
      SubscriptionId subscription = subscriptionIterator.next();
      // do something with the subscription identity
    }
    // [END listSubscriptionsForTopic]
    return subscriptions;
  }

  /**
   * Example of asynchronously listing subscriptions for a topic, specifying the page size.
   */
  // [TARGET listSubscriptionsAsync(String, ListOption...)]
  // [VARIABLE "my_topic_name"]
  public Page<SubscriptionId> listSubscriptionsForTopicAsync(String topicName)
      throws ExecutionException, InterruptedException {
    // [START listSubscriptionsForTopicAsync]
    Future<AsyncPage<SubscriptionId>> future =
        pubsub.listSubscriptionsAsync(topicName, ListOption.pageSize(100));
    // ...
    AsyncPage<SubscriptionId> subscriptions = future.get();
    Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
    while (subscriptionIterator.hasNext()) {
      SubscriptionId subscription = subscriptionIterator.next();
      // do something with the subscription identity
    }
    // [END listSubscriptionsForTopicAsync]
    return subscriptions;
  }

  /**
   * Example of deleting a subscription.
   */
  // [TARGET deleteSubscription(String)]
  // [VARIABLE "my_subscription_name"]
  public boolean deleteSubscription(String subscriptionName) {
    // [START deleteSubscription]
    boolean deleted = pubsub.deleteSubscription(subscriptionName);
    if (deleted) {
      // the subscription was deleted
    } else {
      // the subscription was not found
    }
    // [END deleteSubscription]
    return deleted;
  }

  /**
   * Example of asynchronously deleting a subscription.
   */
  // [TARGET deleteSubscriptionAsync(String)]
  // [VARIABLE "my_subscription_name"]
  public boolean deleteSubscriptionAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START deleteSubscriptionAsync]
    Future<Boolean> future = pubsub.deleteSubscriptionAsync(subscriptionName);
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the subscription was deleted
    } else {
      // the subscription was not found
    }
    // [END deleteSubscriptionAsync]
    return deleted;
  }

  /**
   * Example of getting a topic policy.
   */
  // [TARGET getTopicPolicy(String)]
  // [VARIABLE "my_topic_name"]
  public Policy getTopicPolicy(String topicName) {
    // [START getTopicPolicy]
    Policy policy = pubsub.getTopicPolicy(topicName);
    if (policy == null) {
      // topic was not found
    }
    // [END getTopicPolicy]
    return policy;
  }

  /**
   * Example of asynchronously getting a topic policy.
   */
  // [TARGET getTopicPolicyAsync(String)]
  // [VARIABLE "my_topic_name"]
  public Policy getTopicPolicyAsync(String topicName)
      throws ExecutionException, InterruptedException {
    // [START getTopicPolicyAsync]
    Future<Policy> future = pubsub.getTopicPolicyAsync(topicName);
    // ...
    Policy policy = future.get();
    if (policy == null) {
      // topic was not found
    }
    // [END getTopicPolicyAsync]
    return policy;
  }

  /**
   * Example of replacing a topic policy.
   */
  // [TARGET replaceTopicPolicy(String, Policy)]
  // [VARIABLE "my_topic_name"]
  public Policy replaceTopicPolicy(String topicName) {
    // [START replaceTopicPolicy]
    Policy policy = pubsub.getTopicPolicy(topicName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    updatedPolicy = pubsub.replaceTopicPolicy(topicName, updatedPolicy);
    // [END replaceTopicPolicy]
    return updatedPolicy;
  }

  /**
   * Example of asynchronously replacing a topic policy.
   */
  // [TARGET replaceTopicPolicyAsync(String, Policy)]
  // [VARIABLE "my_topic_name"]
  public Policy replaceTopicPolicyAsync(String topicName)
      throws ExecutionException, InterruptedException {
    // [START replaceTopicPolicyAsync]
    Policy policy = pubsub.getTopicPolicy(topicName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    Future<Policy> future = pubsub.replaceTopicPolicyAsync(topicName, updatedPolicy);
    // ...
    updatedPolicy = future.get();
    // [END replaceTopicPolicyAsync]
    return updatedPolicy;
  }

  /**
   * Example of testing whether the caller has the provided permissions on a topic.
   */
  // [TARGET testTopicPermissions(String, List)]
  // [VARIABLE "my_topic_name"]
  public List<Boolean> testTopicPermissions(String topicName) {
    // [START testTopicPermissions]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.topics.get");
    List<Boolean> testedPermissions = pubsub.testTopicPermissions(topicName, permissions);
    // [END testTopicPermissions]
    return testedPermissions;
  }

  /**
   * Example of asynchronously testing whether the caller has the provided permissions on a topic.
   */
  // [TARGET testTopicPermissionsAsync(String, List)]
  // [VARIABLE "my_topic_name"]
  public List<Boolean> testTopicPermissionsAsync(String topicName)
      throws ExecutionException, InterruptedException {
    // [START testTopicPermissionsAsync]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.topics.get");
    Future<List<Boolean>> future = pubsub.testTopicPermissionsAsync(topicName, permissions);
    // ...
    List<Boolean> testedPermissions = future.get();
    // [END testTopicPermissionsAsync]
    return testedPermissions;
  }

  /**
   * Example of getting a subscription policy.
   */
  // [TARGET getSubscriptionPolicy(String)]
  // [VARIABLE "my_subscription_name"]
  public Policy getSubscriptionPolicy(String subscriptionName) {
    // [START getSubscriptionPolicy]
    Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
    if (policy == null) {
      // subscription was not found
    }
    // [END getSubscriptionPolicy]
    return policy;
  }

  /**
   * Example of asynchronously getting a subscription policy.
   */
  // [TARGET getSubscriptionPolicyAsync(String)]
  // [VARIABLE "my_subscription_name"]
  public Policy getSubscriptionPolicyAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START getSubscriptionPolicyAsync]
    Future<Policy> future = pubsub.getSubscriptionPolicyAsync(subscriptionName);
    // ...
    Policy policy = future.get();
    if (policy == null) {
      // subscription was not found
    }
    // [END getSubscriptionPolicyAsync]
    return policy;
  }

  /**
   * Example of replacing a subscription policy.
   */
  // [TARGET replaceSubscriptionPolicy(String, Policy)]
  // [VARIABLE "my_subscription_name"]
  public Policy replaceSubscriptionPolicy(String subscriptionName) {
    // [START replaceSubscriptionPolicy]
    Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    updatedPolicy = pubsub.replaceSubscriptionPolicy(subscriptionName, updatedPolicy);
    // [END replaceSubscriptionPolicy]
    return updatedPolicy;
  }

  /**
   * Example of asynchronously replacing a subscription policy.
   */
  // [TARGET replaceSubscriptionPolicyAsync(String, Policy)]
  // [VARIABLE "my_subscription_name"]
  public Policy replaceSubscriptionPolicyAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START replaceSubscriptionPolicyAsync]
    Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    Future<Policy> future =
        pubsub.replaceSubscriptionPolicyAsync(subscriptionName, updatedPolicy);
    // ...
    updatedPolicy = future.get();
    // [END replaceSubscriptionPolicyAsync]
    return updatedPolicy;
  }

  /**
   * Example of testing whether the caller has the provided permissions on a subscription.
   */
  // [TARGET testSubscriptionPermissions(String, List)]
  // [VARIABLE "my_subscription_name"]
  public List<Boolean> testSubscriptionPermissions(String subscriptionName) {
    // [START testSubscriptionPermissions]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.subscriptions.get");
    List<Boolean> testedPermissions =
        pubsub.testSubscriptionPermissions(subscriptionName, permissions);
    // [END testSubscriptionPermissions]
    return testedPermissions;
  }

  /**
   * Example of asynchronously testing whether the caller has the provided permissions on a
   * subscription.
   */
  // [TARGET testSubscriptionPermissionsAsync(String, List)]
  // [VARIABLE "my_subscription_name"]
  public List<Boolean> testSubscriptionPermissionsAsync(String subscriptionName)
      throws ExecutionException, InterruptedException {
    // [START testSubscriptionPermissionsAsync]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.subscriptions.get");
    Future<List<Boolean>> future =
        pubsub.testSubscriptionPermissionsAsync(subscriptionName, permissions);
    // ...
    List<Boolean> testedPermissions = future.get();
    // [END testSubscriptionPermissionsAsync]
    return testedPermissions;
  }
}
