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
 * This file is referenced in Topic's javadoc. Any change to this file should be reflected in
 * Topic's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.AsyncPage;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.deprecated.Message;
import com.google.cloud.pubsub.deprecated.PubSub.ListOption;
import com.google.cloud.pubsub.deprecated.SubscriptionId;
import com.google.cloud.pubsub.deprecated.Topic;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * This class contains a number of snippets for the {@link Topic} class.
 */
public class TopicSnippets {

  private final Topic topic;

  public TopicSnippets(Topic topic) {
    this.topic = topic;
  }

  /**
   * Example of getting the topic's latest information.
   */
  // [TARGET reload()]
  public Topic reload() {
    // [START reload]
    Topic latestTopic = topic.reload();
    if (latestTopic == null) {
      // the topic was not found
    }
    // [END reload]
    return latestTopic;
  }

  /**
   * Example of asynchronously getting the topic's latest information.
   */
  // [TARGET reloadAsync()]
  public Topic reloadAsync() throws ExecutionException, InterruptedException {
    // [START reloadAsync]
    Future<Topic> future = topic.reloadAsync();
    // ...
    Topic latestTopic = future.get();
    if (latestTopic == null) {
      // the topic was not found
    }
    // [END reloadAsync]
    return latestTopic;
  }

  /**
   * Example of deleting the topic.
   */
  // [TARGET delete()]
  public boolean delete() {
    // [START delete]
    boolean deleted = topic.delete();
    if (deleted) {
      // the topic was deleted
    } else {
      // the topic was not found
    }
    // [END delete]
    return deleted;
  }

  /**
   * Example of asynchronously deleting the topic.
   */
  // [TARGET deleteAsync()]
  public boolean deleteAsync() throws ExecutionException, InterruptedException {
    // [START deleteAsync]
    Future<Boolean> future = topic.deleteAsync();
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the topic was deleted
    } else {
      // the topic was not found
    }
    // [END deleteAsync]
    return deleted;
  }

  /**
   * Example of publishing one message to the topic.
   */
  // [TARGET publish(Message)]
  public String publishOneMessage() {
    // [START publishOneMessage]
    Message message = Message.of("payload");
    String messageId = topic.publish(message);
    // [END publishOneMessage]
    return messageId;
  }

  /**
   * Example of asynchronously publishing one message to the topic.
   */
  // [TARGET publishAsync(Message)]
  public String publishOneMessageAsync()
      throws ExecutionException, InterruptedException {
    // [START publishOneMessageAsync]
    Message message = Message.of("payload");
    Future<String> future = topic.publishAsync(message);
    // ...
    String messageId = future.get();
    // [END publishOneMessageAsync]
    return messageId;
  }


  /**
   * Example of publishing a list of messages to the topic.
   */
  // [TARGET publish(Iterable)]
  public List<String> publishMessageList() {
    // [START publishMessageList]
    List<Message> messages = new LinkedList<>();
    messages.add(Message.of("payload1"));
    messages.add(Message.of("payload2"));
    List<String> messageIds = topic.publish(messages);
    // [END publishMessageList]
    return messageIds;
  }

  /**
   * Example of asynchronously publishing a list of messages to the topic.
   */
  // [TARGET publishAsync(Iterable)]
  public List<String> publishMessageListAsync()
      throws ExecutionException, InterruptedException {
    // [START publishMessageListAsync]
    List<Message> messages = new LinkedList<>();
    messages.add(Message.of("payload1"));
    messages.add(Message.of("payload2"));
    Future<List<String>> future = topic.publishAsync(messages);
    // ...
    List<String> messageIds = future.get();
    // [END publishMessageListAsync]
    return messageIds;
  }

  /**
   * Example of publishing some messages to the topic.
   */
  // [TARGET publish(Message, Message...)]
  public List<String> publishMessages() {
    // [START publishMessages]
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    List<String> messageIds = topic.publish(message1, message2);
    // [END publishMessages]
    return messageIds;
  }

  /**
   * Example of asynchronously publishing some messages to the topic.
   */
  // [TARGET publishAsync(Message, Message...)]
  public List<String> publishMessagesAsync()
      throws ExecutionException, InterruptedException {
    // [START publishMessagesAsync]
    Message message1 = Message.of("payload1");
    Message message2 = Message.of("payload2");
    Future<List<String>> future = topic.publishAsync(message1, message2);
    // ...
    List<String> messageIds = future.get();
    // [END publishMessagesAsync]
    return messageIds;
  }

  /**
   * Example of listing subscriptions for the topic, specifying the page size.
   */
  // [TARGET listSubscriptions(ListOption...)]
  public Page<SubscriptionId> listSubscriptionsForTopic() {
    // [START listSubscriptionsForTopic]
    Page<SubscriptionId> subscriptions = topic.listSubscriptions(ListOption.pageSize(100));
    Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
    while (subscriptionIterator.hasNext()) {
      SubscriptionId subscription = subscriptionIterator.next();
      // do something with the subscription identity
    }
    // [END listSubscriptionsForTopic]
    return subscriptions;
  }

  /**
   * Example of asynchronously listing subscriptions for the topic, specifying the page size.
   */
  // [TARGET listSubscriptionsAsync(ListOption...)]
  public Page<SubscriptionId> listSubscriptionsForTopicAsync()
      throws ExecutionException, InterruptedException {
    // [START listSubscriptionsForTopicAsync]
    Future<AsyncPage<SubscriptionId>> future =
        topic.listSubscriptionsAsync(ListOption.pageSize(100));
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
   * Example of getting the topic's policy.
   */
  // [TARGET getPolicy()]
  public Policy getPolicy() {
    // [START getPolicy]
    Policy policy = topic.getPolicy();
    if (policy == null) {
      // topic was not found
    }
    // [END getPolicy]
    return policy;
  }

  /**
   * Example of asynchronously getting the topic's policy.
   */
  // [TARGET getPolicyAsync()]
  public Policy getPolicyAsync() throws ExecutionException, InterruptedException {
    // [START getPolicyAsync]
    Future<Policy> future = topic.getPolicyAsync();
    // ...
    Policy policy = future.get();
    if (policy == null) {
      // topic was not found
    }
    // [END getPolicyAsync]
    return policy;
  }

  /**
   * Example of replacing the topic's policy.
   */
  // [TARGET replacePolicy(Policy)]
  public Policy replacePolicy() {
    // [START replacePolicy]
    Policy policy = topic.getPolicy();
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    updatedPolicy = topic.replacePolicy(updatedPolicy);
    // [END replacePolicy]
    return updatedPolicy;
  }

  /**
   * Example of asynchronously replacing the topic's policy.
   */
  // [TARGET replacePolicyAsync(Policy)]
  public Policy replacePolicyAsync()
      throws ExecutionException, InterruptedException {
    // [START replacePolicyAsync]
    Policy policy = topic.getPolicy();
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    Future<Policy> future = topic.replacePolicyAsync(updatedPolicy);
    // ...
    updatedPolicy = future.get();
    // [END replacePolicyAsync]
    return updatedPolicy;
  }

  /**
   * Example of testing whether the caller has the provided permissions on the topic.
   */
  // [TARGET testPermissions(List)]
  public List<Boolean> testPermissions() {
    // [START testPermissions]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.topics.get");
    List<Boolean> testedPermissions = topic.testPermissions(permissions);
    // [END testPermissions]
    return testedPermissions;
  }

  /**
   * Example of asynchronously testing whether the caller has the provided permissions on the
   * topic.
   */
  // [TARGET testPermissionsAsync(List)]
  public List<Boolean> testPermissionsAsync()
      throws ExecutionException, InterruptedException {
    // [START testPermissionsAsync]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.topics.get");
    Future<List<Boolean>> future = topic.testPermissionsAsync(permissions);
    // ...
    List<Boolean> testedPermissions = future.get();
    // [END testPermissionsAsync]
    return testedPermissions;
  }
}
