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

/** This class contains snippets for the {@link SubscriberClient} interface. */

package com.google.cloud.examples.pubsub.snippets;

import com.google.cloud.Identity;
import com.google.cloud.Role;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListSubscriptionsPagedResponse;
import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.cloud.pubsub.spi.v1.SubscriberClient;
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

/** This class contains a number of snippets for the {@link SubscriberClient} interface. */
public class SubscriberClientSnippets {

  private final String projectId;

  public SubscriberClientSnippets(String projectId) {
    this.projectId = projectId;
  }

  /** Example of creating a pull subscription for a topic. */
  public Subscription createSubscription(String topic, String subscriptionName) throws Exception {
    TopicName topicName = TopicName.create(projectId, topic);
    SubscriptionName formattedSubscriptionName =
        SubscriptionName.create(projectId, subscriptionName);
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      // [START createSubscription]
      Subscription subscription =
          subscriberClient.createSubscription(
              formattedSubscriptionName, topicName, PushConfig.getDefaultInstance(), 0);
      // [END createSubscription]
      return subscription;
    }
  }

  /** Example of pulling a maximum number of messages from a subscription. */
  public PullResponse pull(String subscriptionName) throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      SubscriptionName subcriptionFormattedName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START pull]
      PullResponse response = subscriberClient.pull(subcriptionFormattedName, true, 100);
      for (ReceivedMessage message : response.getReceivedMessagesList()) {
        // do something with message, then ack or nack
        subscriberClient.acknowledge(
            subcriptionFormattedName, Collections.singletonList(message.getAckId()));
      }
      // [END pull]
      return response;
    }
  }

  /** Example of replacing the push configuration of a subscription, setting the push endpoint. */
  public void replacePushConfig(String subscriptionName, String endpoint) throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      SubscriptionName formattedSubscriptionName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START replacePushConfig]
      PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint(endpoint).build();
      subscriberClient.modifyPushConfig(formattedSubscriptionName, pushConfig);
      // [END replacePushConfig]
    }
  }

  /** Example of listing subscriptions, specifying the page size. */
  public ListSubscriptionsPagedResponse listSubscriptions() throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      ProjectName projectName = ProjectName.create(projectId);
      // [START listSubscriptions]
      ListSubscriptionsRequest listSubscriptionsRequest =
          ListSubscriptionsRequest.newBuilder()
              .setProjectWithProjectName(projectName)
              .setPageSize(100)
              .build();
      PagedResponseWrappers.ListSubscriptionsPagedResponse response =
          subscriberClient.listSubscriptions(listSubscriptionsRequest);
      Iterable<Subscription> subscriptions = response.iterateAllElements();
      for (Subscription subscription : subscriptions) {
        // do something with the subscription
      }
      // [END listSubscriptions]
      return response;
    }
  }

  /** Example of listing subscriptions, specifying the page size and page token. */
  public ListSubscriptionsPagedResponse listSubscriptionsWithPageToken(String pageToken)
      throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      ProjectName projectName = ProjectName.create(projectId);
      // [START listSubscriptionsWithPageToken]
      ListSubscriptionsRequest listSubscriptionsRequest =
          ListSubscriptionsRequest.newBuilder()
              .setProjectWithProjectName(projectName)
              .setPageSize(100)
              .setPageToken(pageToken)
              .build();
      PagedResponseWrappers.ListSubscriptionsPagedResponse response =
          subscriberClient.listSubscriptions(listSubscriptionsRequest);
      Iterable<Subscription> subscriptions = response.iterateAllElements();
      for (Subscription subscription : subscriptions) {
        // do something with the subscription
      }
      // [END listSubscriptionsWithPageToken]
      return response;
    }
  }

  /** Example of deleting a subscription. */
  public SubscriptionName deleteSubscription(String subscriptionName) throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      SubscriptionName formattedSubscriptionName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START deleteSubscription]
      subscriberClient.deleteSubscription(formattedSubscriptionName);
      // [END deleteSubscription]
      return formattedSubscriptionName;
    }
  }

  /** Example of getting a subscription policy. */
  public Policy getSubscriptionPolicy(String subscriptionName) throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      SubscriptionName formattedSubscriptionName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START getSubscriptionPolicy]
      Policy policy = subscriberClient.getIamPolicy(formattedSubscriptionName.toString());
      if (policy == null) {
        // subscription was not found
      }
      // [END getSubscriptionPolicy]
      return policy;
    }
  }

  /** Example of replacing a subscription policy. */
  public Policy replaceSubscriptionPolicy(String subscriptionName) throws Exception {
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      SubscriptionName formattedSubscriptionName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START replaceSubscriptionPolicy]
      Policy policy = subscriberClient.getIamPolicy(formattedSubscriptionName.toString());
      // Create a role => members binding
      Binding binding =
          Binding.newBuilder()
              .setRole(Role.viewer().toString())
              .addMembers(Identity.allAuthenticatedUsers().toString())
              .build();
      //Update policy
      Policy updatedPolicy = policy.toBuilder().addBindings(binding).build();

      updatedPolicy = subscriberClient.setIamPolicy(
          formattedSubscriptionName.toString(), updatedPolicy);
      // [END replaceSubscriptionPolicy]
      return updatedPolicy;
    }
  }

  /** Example of testing whether the caller has the provided permissions on a subscription. */
  public TestIamPermissionsResponse testSubscriptionPermissions(String subscriptionName)
      throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      SubscriptionName formattedSubscriptionName =
          SubscriptionName.create(projectId, subscriptionName);
      // [START testSubscriptionPermissions]
      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.subscriptions.get");
      TestIamPermissionsResponse testedPermissions =
          publisherClient.testIamPermissions(formattedSubscriptionName.toString(), permissions);
      // [END testSubscriptionPermissions]
      return testedPermissions;
    }
  }

  /** Example of getting a subscription. */
  public Subscription getSubscription(String subscriptionName) throws Exception {
    SubscriptionName formattedSubscriptionName =
        SubscriptionName.create(projectId, subscriptionName);
    try (SubscriberClient subscriberClient = SubscriberClient.create()) {
      // [START getSubscription]
      Subscription subscription = subscriberClient.getSubscription(formattedSubscriptionName);
      // [END getSubscription]
      return subscription;
    }
  }
}
