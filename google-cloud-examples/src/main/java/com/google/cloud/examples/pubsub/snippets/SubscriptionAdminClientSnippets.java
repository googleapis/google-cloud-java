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
  public Subscription createSubscription(String topic, String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START createSubscription]
      TopicName topicName = TopicName.create(projectId, topic);
      SubscriptionName subscriptionName =
          SubscriptionName.create(projectId, subscriptionId);
      Subscription subscription =
          subscriptionAdminClient.createSubscription(
              subscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
      // [END createSubscription]
      return subscription;
    }
  }

  /** Example of pulling a maximum number of messages from a subscription. */
  public PullResponse pull(String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START pull]
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      PullResponse response = subscriptionAdminClient.pull(subscriptionName, true, 100);
      for (ReceivedMessage message : response.getReceivedMessagesList()) {
        // do something with message, then ack or nack
        subscriptionAdminClient.acknowledge(
            subscriptionName, Collections.singletonList(message.getAckId()));
      }
      // [END pull]
      return response;
    }
  }

  /** Example of replacing the push configuration of a subscription, setting the push endpoint. */
  public void replacePushConfig(String subscriptionId, String endpoint) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START replacePushConfig]
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
      subscriptionAdminClient.modifyPushConfig(subscriptionName, pushConfig);
      // [END replacePushConfig]
    }
  }

  /** Example of listing subscriptions. */
  public ListSubscriptionsPagedResponse listSubscriptions() throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START listSubscriptions]
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
      // [END listSubscriptions]
      return response;
    }
  }

  /** Example of deleting a subscription. */
  public SubscriptionName deleteSubscription(String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START deleteSubscription]
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      subscriptionAdminClient.deleteSubscription(subscriptionName);
      // [END deleteSubscription]
      return subscriptionName;
    }
  }

  /** Example of getting a subscription policy. */
  public Policy getSubscriptionPolicy(String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START getSubscriptionPolicy]
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      Policy policy = subscriptionAdminClient.getIamPolicy(subscriptionName.toString());
      if (policy == null) {
        // subscription was not found
      }
      // [END getSubscriptionPolicy]
      return policy;
    }
  }

  /** Example of replacing a subscription policy. */
  public Policy replaceSubscriptionPolicy(String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START replaceSubscriptionPolicy]
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
      // [END replaceSubscriptionPolicy]
      return updatedPolicy;
    }
  }

  /** Example of testing whether the caller has the provided permissions on a subscription. */
  public TestIamPermissionsResponse testSubscriptionPermissions(String subscriptionId)
      throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START testSubscriptionPermissions]
      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.subscriptions.get");
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      TestIamPermissionsResponse testedPermissions =
          topicAdminClient.testIamPermissions(subscriptionName.toString(), permissions);
      // [END testSubscriptionPermissions]
      return testedPermissions;
    }
  }

  /** Example of getting a subscription. */
  public Subscription getSubscription(String subscriptionId) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      // [START getSubscription]
      SubscriptionName subscriptionName = SubscriptionName.create(projectId, subscriptionId);
      Subscription subscription = subscriptionAdminClient.getSubscription(subscriptionName);
      // [END getSubscription]
      return subscription;
    }
  }
}
