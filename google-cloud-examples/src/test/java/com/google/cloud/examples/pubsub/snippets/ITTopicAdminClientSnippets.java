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

package com.google.cloud.examples.pubsub.snippets;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.ApiException;
import com.google.cloud.Identity;
import com.google.cloud.Role;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicsPagedResponse;
import com.google.cloud.pubsub.spi.v1.SubscriptionAdminClient;
import com.google.common.collect.Iterables;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITTopicAdminClientSnippets {

  private static final String NAME_SUFFIX = UUID.randomUUID().toString();

  private static String projectId;

  private static TopicAdminClientSnippets topicAdminClientSnippets;

  private static String[] topics = {
      formatForTest("topic-1"),
      formatForTest("topic-2"),
  };
  private static String[] subscriptions = {
      formatForTest("subscription-1"),
      formatForTest("subscription-2")
  };

  @Rule
  public Timeout globalTimeout = Timeout.seconds(300);

  private static String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  @BeforeClass
  public static void beforeClass() {
    topicAdminClientSnippets = new TopicAdminClientSnippets();
    projectId = topicAdminClientSnippets.getProjectId();
  }

  @Before
  public void setUp() throws Exception {
    Cleanup.deleteTestTopicsAndSubscriptions(projectId, topics, subscriptions);
  }

  @Test
  public void topicAddedIsSameAsRetrieved() throws Exception {
    String topicName = topics[0];
    Topic topicAdded = topicAdminClientSnippets.createTopic(topicName);
    assertNotNull(topicAdded);
    Topic topicRetrieved = topicAdminClientSnippets.getTopic(topicName);
    assertEquals(topicAdded, topicRetrieved);
  }

  @Test
  public void listTopicsRetreivesAddedTopics() throws Exception {
    List<Topic> addedTopics = new ArrayList<>();
    String topicName1 = topics[0];
    addedTopics.add(topicAdminClientSnippets.createTopic(topicName1));
    String topicName2 = topics[1];
    addedTopics.add(topicAdminClientSnippets.createTopic(topicName2));

    boolean[] topicFound = {false, false};
    ListTopicsPagedResponse response = topicAdminClientSnippets.listTopics();

    assertNotNull(response);
    Iterable<Topic> topics = response.iterateAllElements();
    for (int i = 0; i < 2; i++) {
      if (!topicFound[i]) {
        topicFound[i] = Iterables.contains(topics, addedTopics.get(i));
      }
    }

    assertTrue(topicFound[0] && topicFound[1]);
  }

  @Test
  public void listTopicSubscriptionsRetrievesAddedSubscriptions() throws Exception {
    List<String> addedSubscriptions = new ArrayList<>();
    String topicName1 = topics[0];
    topicAdminClientSnippets.createTopic(topicName1);
    String subscriptionName1 = subscriptions[0];
    String subscriptionName2 = subscriptions[1];
    addedSubscriptions.add(createSubscription(topicName1, subscriptionName1));
    addedSubscriptions.add(createSubscription(topicName1, subscriptionName2));

    boolean[] subFound = {false, false};

    ListTopicSubscriptionsPagedResponse response =
        topicAdminClientSnippets.listTopicSubscriptions(topicName1);


    assertNotNull(response);
    Iterable<String> subscriptions = response.iterateAllElements();
    for (int i = 0; i < 2; i++) {
      if (!subFound[i]) {
        subFound[i] = Iterables.contains(subscriptions, addedSubscriptions.get(i));
      }
    }
    assertTrue(subFound[0] && subFound[1]);
  }

  @Test(expected = ApiException.class)
  public void deletedTopicIsNotRetrievableAndThrowsException() throws Exception {
    String topicName = topics[0];
    Topic topicAdded = topicAdminClientSnippets.createTopic(topicName);
    assertNotNull(topicAdded);
    TopicName formattedName = topicAdminClientSnippets.deleteTopic(topicName);
    assertNotNull(formattedName);
    topicAdminClientSnippets.getTopic(topicName);
  }

  @Test
  public void topicPolicyIsCorrectlyRetrieved() throws Exception {
    String topicName = topics[0];
    topicAdminClientSnippets.createTopic(topicName);
    Policy policy = topicAdminClientSnippets.getTopicPolicy(topicName);
    assertNotNull(policy);
  }

  @Test
  public void replaceTopicPolicyAndTestPermissionsIsSuccessful() throws Exception {
    String topicName = topics[0];
    topicAdminClientSnippets.createTopic(topicName);
    Policy policy = topicAdminClientSnippets.replaceTopicPolicy(topicName);
    assertNotNull(policy.getBindingsCount());
    assertTrue(policy.getBindings(0).getRole().equalsIgnoreCase(Role.viewer().toString()));
    assertTrue(policy.getBindings(0).getMembers(0)
        .equalsIgnoreCase(Identity.allAuthenticatedUsers().toString()));
    TestIamPermissionsResponse response = topicAdminClientSnippets.testTopicPermissions(topicName);
    assertTrue(response.getPermissionsList().contains("pubsub.topics.get"));
  }

  private String createSubscription(String topic, String subscriptionName) throws Exception {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      Subscription subscription = subscriptionAdminClient.createSubscription(
          SubscriptionName.create(projectId, subscriptionName),
          TopicName.create(projectId, topic), PushConfig.getDefaultInstance(), 0);
      return subscription.getName();
    }
  }

  @After
  public void tearDown() throws Exception {
    Cleanup.deleteTestTopicsAndSubscriptions(projectId, topics, subscriptions);
  }
}
