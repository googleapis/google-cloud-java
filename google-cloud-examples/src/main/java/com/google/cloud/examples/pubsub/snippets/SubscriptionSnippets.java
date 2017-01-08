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
import com.google.cloud.pubsub.Subscription;
import com.google.pubsub.v1.PushConfig;
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
    PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
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
    PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
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
