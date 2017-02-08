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
 * This file is referenced in Subscription's javadoc. Any change to this file should be reflected in
 * Subscription's javadoc.
 */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.Identity;
import com.google.cloud.Policy;
import com.google.cloud.Role;
import com.google.cloud.pubsub.deprecated.Message;
import com.google.cloud.pubsub.deprecated.PubSub.MessageConsumer;
import com.google.cloud.pubsub.deprecated.PubSub.MessageProcessor;
import com.google.cloud.pubsub.deprecated.PushConfig;
import com.google.cloud.pubsub.deprecated.ReceivedMessage;
import com.google.cloud.pubsub.deprecated.Subscription;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * This class contains a number of snippets for the {@link Subscription} class.
 */
public class SubscriptionSnippets {

  private final Subscription subscription;

  public SubscriptionSnippets(Subscription subscription) {
    this.subscription = subscription;
  }

  /**
   * Example of getting the subscription's latest information.
   */
  // [TARGET reload()]
  public Subscription reload() {
    // [START reload]
    Subscription latestSubscription = subscription.reload();
    if (latestSubscription == null) {
      // the subscription was not found
    }
    // [END reload]
    return latestSubscription;
  }

  /**
   * Example of asynchronously getting the subscription's latest information.
   */
  // [TARGET reloadAsync()]
  public Subscription reloadAsync() throws ExecutionException, InterruptedException {
    // [START reloadAsync]
    Future<Subscription> future = subscription.reloadAsync();
    // ...
    Subscription latestSubscription = future.get();
    if (latestSubscription == null) {
      // the subscription was not found
    }
    // [END reloadAsync]
    return latestSubscription;
  }

  /**
   * Example of deleting the subscription.
   */
  // [TARGET delete()]
  public boolean delete() {
    // [START delete]
    boolean deleted = subscription.delete();
    if (deleted) {
      // the subscription was deleted
    } else {
      // the subscription was not found
    }
    // [END delete]
    return deleted;
  }

  /**
   * Example of asynchronously deleting the subscription.
   */
  // [TARGET deleteAsync()]
  public boolean deleteAsync() throws ExecutionException, InterruptedException {
    // [START deleteAsync]
    Future<Boolean> future = subscription.deleteAsync();
    // ...
    boolean deleted = future.get();
    if (deleted) {
      // the subscription was deleted
    } else {
      // the subscription was not found
    }
    // [END deleteAsync]
    return deleted;
  }

  /**
   * Example of replacing the push configuration of the subscription, setting the push endpoint.
   */
  // [TARGET replacePushConfig(PushConfig)]
  // [VARIABLE "https://www.example.com/push"]
  public void replacePushConfig(String endpoint) {
    // [START replacePushConfig]
    PushConfig pushConfig = PushConfig.of(endpoint);
    subscription.replacePushConfig(pushConfig);
    // [END replacePushConfig]
  }

  /**
   * Example of replacing the push configuration of the subscription, making it a pull
   * subscription.
   */
  // [TARGET replacePushConfig(PushConfig)]
  public void replacePushConfigToPull() {
    // [START replacePushConfigToPull]
    subscription.replacePushConfig(null);
    // [END replacePushConfigToPull]
  }

  /**
   * Example of asynchronously replacing the push configuration of the subscription, setting the
   * push endpoint.
   */
  // [TARGET replacePushConfigAsync(PushConfig)]
  // [VARIABLE "https://www.example.com/push"]
  public void replacePushConfigAsync(String endpoint)
      throws ExecutionException, InterruptedException {
    // [START replacePushConfigAsync]
    PushConfig pushConfig = PushConfig.of(endpoint);
    Future<Void> future = subscription.replacePushConfigAsync(pushConfig);
    // ...
    future.get();
    // [END replacePushConfigAsync]
  }

  /**
   * Example of asynchronously replacing the push configuration of the subscription, making it a
   * pull subscription.
   */
  // [TARGET replacePushConfigAsync(PushConfig)]
  public void replacePushConfigToPullAsync()
      throws ExecutionException, InterruptedException {
    // [START replacePushConfigToPullAsync]
    Future<Void> future = subscription.replacePushConfigAsync(null);
    // ...
    future.get();
    // [END replacePushConfigToPullAsync]
  }

  /**
   * Example of pulling a maximum number of messages from the subscription.
   */
  // [TARGET pull(int)]
  public void pull() {
    // [START pull]
    Iterator<ReceivedMessage> messages = subscription.pull(100);
    // Ack deadline is renewed until the message is consumed
    while (messages.hasNext()) {
      ReceivedMessage message = messages.next();
      // do something with message and ack/nack it
      message.ack(); // or message.nack()
    }
    // [END pull]
  }

  /**
   * Example of asynchronously pulling a maximum number of messages from the subscription.
   */
  // [TARGET pullAsync(int)]
  public void pullAsync() throws ExecutionException, InterruptedException {
    // [START pullAsync]
    Future<Iterator<ReceivedMessage>> future = subscription.pullAsync(100);
    // ...
    Iterator<ReceivedMessage> messages = future.get();
    // Ack deadline is renewed until the message is consumed
    while (messages.hasNext()) {
      ReceivedMessage message = messages.next();
      // do something with message and ack/nack it
      message.ack(); // or message.nack()
    }
    // [END pullAsync]
  }

  /**
   * Example of continuously pulling messages from the subscription.
   */
  // [TARGET pullAsync(MessageProcessor, PullOption...)]
  // [VARIABLE "my_subscription_name"]
  public void pullWithMessageConsumer(String subscriptionName) throws Exception {
    // [START pullWithMessageConsumer]
    MessageProcessor callback = new MessageProcessor() {
      public void process(Message message) throws Exception {
        // Ack deadline is renewed until this method returns
        // Message is acked if this method returns successfully
        // Message is nacked if this method throws an exception
      }
    };
    MessageConsumer consumer = subscription.pullAsync(callback);
    // ...
    // Stop pulling
    consumer.close();
    // [END pullWithMessageConsumer]
  }

  /**
   * Example of getting the subscription's policy.
   */
  // [TARGET getPolicy()]
  public Policy getPolicy() {
    // [START getPolicy]
    Policy policy = subscription.getPolicy();
    if (policy == null) {
      // subscription was not found
    }
    // [END getPolicy]
    return policy;
  }

  /**
   * Example of asynchronously getting the subscription's policy.
   */
  // [TARGET getPolicyAsync()]
  public Policy getPolicyAsync() throws ExecutionException, InterruptedException {
    // [START getPolicyAsync]
    Future<Policy> future = subscription.getPolicyAsync();
    // ...
    Policy policy = future.get();
    if (policy == null) {
      // subscription was not found
    }
    // [END getPolicyAsync]
    return policy;
  }

  /**
   * Example of replacing the subscription's policy.
   */
  // [TARGET replacePolicy(Policy)]
  public Policy replacePolicy() {
    // [START replacePolicy]
    Policy policy = subscription.getPolicy();
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    updatedPolicy = subscription.replacePolicy(updatedPolicy);
    // [END replacePolicy]
    return updatedPolicy;
  }

  /**
   * Example of asynchronously replacing the subscription's policy.
   */
  // [TARGET replacePolicyAsync(Policy)]
  public Policy replacePolicyAsync()
      throws ExecutionException, InterruptedException {
    // [START replacePolicyAsync]
    Policy policy = subscription.getPolicy();
    Policy updatedPolicy = policy.toBuilder()
        .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
        .build();
    Future<Policy> future = subscription.replacePolicyAsync(updatedPolicy);
    // ...
    updatedPolicy = future.get();
    // [END replacePolicyAsync]
    return updatedPolicy;
  }

  /**
   * Example of testing whether the caller has the provided permissions on the subscription.
   */
  // [TARGET testPermissions(List)]
  public List<Boolean> testPermissions() {
    // [START testPermissions]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.subscriptions.get");
    List<Boolean> testedPermissions = subscription.testPermissions(permissions);
    // [END testPermissions]
    return testedPermissions;
  }

  /**
   * Example of asynchronously testing whether the caller has the provided permissions on the
   * subscription.
   */
  // [TARGET testPermissionsAsync(List)]
  public List<Boolean> testPermissionsAsync()
      throws ExecutionException, InterruptedException {
    // [START testPermissionsAsync]
    List<String> permissions = new LinkedList<>();
    permissions.add("pubsub.subscriptions.get");
    Future<List<Boolean>> future = subscription.testPermissionsAsync(permissions);
    // ...
    List<Boolean> testedPermissions = future.get();
    // [END testPermissionsAsync]
    return testedPermissions;
  }
}
