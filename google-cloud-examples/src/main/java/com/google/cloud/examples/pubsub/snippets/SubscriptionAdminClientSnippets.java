/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

/** This class contains snippets for the {@link SubscriptionAdminClient} interface. */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.Identity;
import com.google.cloud.Role;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;
import com.google.cloud.pubsub.spi.v1.TopicAdminClient;
import com.google.cloud.pubsub.spi.v1.SubscriptionAdminClient;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import edu.emory.mathcs.backport.java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/** This class contains a number of snippets for the {@link SubscriptionAdminClient} interface. */
public class SubscriptionAdminClientSnippets {

  private final String projectId;

  public SubscriptionAdminClientSnippets() {
    this.projectId = ServiceOptions.getDefaultProjectId();
  }

  public String getProjectId() {
    return projectId;
  }

  /** Example of creating a pull subscription for a topic. */
  public Subscription createSubscription(String topicId, String subscriptionId) throws Exception {
    // [START createSubscription]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // eg. projectId = "my-test-project", topicId = "my-test-topic"
      TopicName topicName = TopicName.create(projectId, topicId);
      // eg. subscriptionId = "my-test-subscription"
      SubscriptionName subscriptionName =
          SubscriptionName.create(projectId, subscriptionId);
      // create a pull subscription with default acknowledgement deadline
      Subscription subscription =
          subscriptionAdminClient.createSubscription(
              subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
      return subscription;
    }
    // [END createSubscription]
  }

  /** Example of creating a subscription with a push endpoint. */
  public Subscription createSubscriptionWithPushEndpoint(String topicId, String subscriptionId, String endpoint)
          throws Exception {
    // [START createSubscriptionWithPushEndpoint]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      TopicName topicName = TopicName.create(projectId, topicId);
      SubscriptionName subscriptionName =
              SubscriptionName.create(projectId, subscriptionId);

      // eg. endpoint = "https://my-test-project.appspot.com/push"
      PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();

      // acknowledgement deadline in seconds for the message received over the push endpoint
      int ackDeadlineInSeconds = 10;

      Subscription subscription =
              subscriptionAdminClient.createSubscription(
                      subscriptionName, topicName, pushConfig, ackDeadlineInSeconds);
      return subscription;
    }
    // [END createSubscriptionWithPushEndpoint]
  }

  /** Example of replacing the push configuration of a subscription, setting the push endpoint. */
  public void replacePushConfig(String subscriptionId, String endpoint) throws Exception {
    // [START replacePushConfig]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
      subscriptionAdminClient.modifyPushConfig(subscriptionName, pushConfig);
    }
    // [END replacePushConfig]
  }

  /** Example of listing subscriptions. */
  public ListSubscriptionsPagedResponse listSubscriptions() throws Exception {
    // [START listSubscriptions]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ListSubscriptionsRequest listSubscriptionsRequest =
          ListSubscriptionsRequest.newBuilder()
              .setProjectWithProjectName(ProjectName.create(projectId))
              .build();
      ListSubscriptionsPagedResponse response =
          subscriptionAdminClient.listSubscriptions(listSubscriptionsRequest);
      Iterable<Subscription> subscriptions = response.iterateAllElements();
      for (Subscription subscription : subscriptions) {
        // do something with the subscription
      }
      return response;
    }
    // [END listSubscriptions]
  }

  /** Example of deleting a subscription. */
  public SubscriptionName deleteSubscription(String subscriptionId) throws Exception {
    // [START deleteSubscription]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      subscriptionAdminClient.deleteSubscription(subscriptionName);
      return subscriptionName;
    }
    // [END deleteSubscription]
  }

  /** Example of getting a subscription policy. */
  public Policy getSubscriptionPolicy(String subscriptionId) throws Exception {
    // [START getSubscriptionPolicy]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      Policy policy = subscriptionAdminClient.getIamPolicy(subscriptionName.toString());
      if (policy == null) {
        // subscription was not found
      }
      return policy;
    }
    // [END getSubscriptionPolicy]
  }

  /** Example of replacing a subscription policy. */
  public Policy replaceSubscriptionPolicy(String subscriptionId) throws Exception {
    // [START replaceSubscriptionPolicy]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      Policy policy = subscriptionAdminClient.getIamPolicy(subscriptionName.toString());
      // Create a role => members binding
      Binding binding =
          Binding.newBuilder()
              .setRole(Role.viewer().toString())
              .addMembers(Identity.allAuthenticatedUsers().toString())
              .build();
      //Update policy
      Policy updatedPolicy = policy.toBuilder().addBindings(binding).build();

      updatedPolicy = subscriptionAdminClient.setIamPolicy(subscriptionName.toString(), updatedPolicy);
      return updatedPolicy;
    }
    // [END replaceSubscriptionPolicy]
  }

  /** Example of testing whether the caller has the provided permissions on a subscription. */
  public TestIamPermissionsResponse testSubscriptionPermissions(String subscriptionId)
      throws Exception {
    // [START testSubscriptionPermissions]
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.subscriptions.get");
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      TestIamPermissionsResponse testedPermissions =
          topicAdminClient.testIamPermissions(subscriptionName.toString(), permissions);
      return testedPermissions;
    }
    // [END testSubscriptionPermissions]
  }

  /** Example of getting a subscription. */
  public Subscription getSubscription(String subscriptionId) throws Exception {
    // [START getSubscription]
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      Subscription subscription = subscriptionAdminClient.getSubscription(subscriptionName);
      return subscription;
    }
    // [END getSubscription]
  }
}
