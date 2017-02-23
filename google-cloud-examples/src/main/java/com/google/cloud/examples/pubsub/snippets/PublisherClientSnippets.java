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

import com.google.cloud.Identity;
import com.google.cloud.Role;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicsPagedResponse;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;

import com.google.cloud.pubsub.spi.v1.PublisherClient;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.util.LinkedList;
import java.util.List;

/** This class contains a number of snippets for the {@link PublisherClient} interface. */
public class PublisherClientSnippets {

  private final String projectId;

  public PublisherClientSnippets(String projectId) {
    this.projectId = projectId;
  }

  /** Example of creating a topic. */
  // [TARGET createTopic(TopicName)]
  // [VARIABLE "my_topic_name"]
  public Topic createTopic(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      // [START createTopic]
      TopicName topicName = TopicName.create(projectId, name);
      Topic topic = publisherClient.createTopic(topicName);
      // [END createTopic]
      return topic;
    }
  }

  /** Example of listing topics, specifying the page size. */
  // [TARGET listTopicSubscriptions(int)]
  public ListTopicSubscriptionsPagedResponse listTopicSubscriptions(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      TopicName topicName = TopicName.create(projectId, name);
      // [START listTopicSubscriptions]
      ListTopicSubscriptionsRequest request =
          ListTopicSubscriptionsRequest.newBuilder()
              .setTopicWithTopicName(topicName)
              .setPageSize(100)
              .build();
      ListTopicSubscriptionsPagedResponse response =
          publisherClient.listTopicSubscriptions(request);
      Iterable<String> subscriptions = response.iterateAllElements();
      for (String subscription : subscriptions) {
        // do something with the subscription name
      }
      // [END listTopicSubscriptions]
      return response;
    }
  }

  /** Example of listing topics, specifying the page size. */
  // [TARGET listTopics(int)]
  public ListTopicsPagedResponse listTopics() throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      // [START listTopics]
      ListTopicsRequest listTopicsRequest =
          ListTopicsRequest.newBuilder()
              .setProjectWithProjectName(ProjectName.create(projectId))
              .setPageSize(100)
              .build();
      ListTopicsPagedResponse response =
          publisherClient.listTopics(listTopicsRequest);
      Iterable<Topic> topics = response.iterateAllElements();
      for (Topic topic : topics) {
        // do something with the topic
      }
      // [END listTopics]
      return response;
    }
  }

  /** Example of deleting a topic. */
  // [TARGET deleteTopic(TopicName)]
  // [VARIABLE "my_topic_name"]
  public void deleteTopic(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      TopicName topicName = TopicName.create(projectId, name);
      // [START deleteTopic]
      publisherClient.deleteTopic(topicName);
      // [END deleteTopic]
    }
  }

  /** Example of getting a topic policy. */
  // [TARGET getTopicPolicy(TopicName)]
  // [VARIABLE "my_topic_name"]
  public Policy getTopicPolicy(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      TopicName topicName = TopicName.create(projectId, name);
      // [START getTopicPolicy]
      Policy policy = publisherClient.getIamPolicy(topicName.toString());
      if (policy == null) {
        // topic iam policy was not found
      }
      // [END getTopicPolicy]
      return policy;
    }
  }

  /** Example of replacing a topic policy. */
  // [TARGET replaceTopicPolicy(TopicName)]
  // [VARIABLE "my_topic_name"]
  public Policy replaceTopicPolicy(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      String topicName = TopicName.create(projectId, name).toString();
      // [START replaceTopicPolicy]
      Policy policy = publisherClient.getIamPolicy(topicName);
      // add role -> members binding
      Binding binding =
          Binding.newBuilder()
              .setRole(Role.viewer().toString())
              .addMembers(Identity.allAuthenticatedUsers().toString())
              .build();
      // create updated policy
      Policy updatedPolicy = Policy.newBuilder(policy).addBindings(binding).build();
      updatedPolicy = publisherClient.setIamPolicy(topicName, updatedPolicy);
      // [END replaceTopicPolicy]
      return updatedPolicy;
    }
  }

  /** Example of testing whether the caller has the provided permissions on a topic. */
  // [TARGET testTopicPermissions(TopicName)]
  // [VARIABLE "my_topic_name"]
  public TestIamPermissionsResponse testTopicPermissions(String name) throws Exception {
    try (PublisherClient publisherClient = PublisherClient.create()) {
      TopicName topicName = TopicName.create(projectId, name);
      // [START testTopicPermissions]
      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.topics.get");
      TestIamPermissionsResponse testedPermissions =
          publisherClient.testIamPermissions(topicName.toString(), permissions);
      // [END testTopicPermissions]
      return testedPermissions;
    }
  }
}
