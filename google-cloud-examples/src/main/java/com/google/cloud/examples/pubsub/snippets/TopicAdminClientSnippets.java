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
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicSubscriptionsPagedResponse;
import com.google.cloud.pubsub.spi.v1.PagedResponseWrappers.ListTopicsPagedResponse;
import com.google.cloud.pubsub.spi.v1.TopicAdminClient;
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

/** This class contains a number of snippets for the {@link TopicAdminClient} interface. */
public class TopicAdminClientSnippets {

  private final String projectId;

  public TopicAdminClientSnippets() {
    this.projectId = ServiceOptions.getDefaultProjectId();
  }

  public String getProjectId() {
    return projectId;
  }

  /** Example of creating a topic. */
  public Topic createTopic(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START createTopic]
      TopicName topicName = TopicName.create(projectId, topicId);
      Topic topic = topicAdminClient.createTopic(topicName);
      // [END createTopic]
      return topic;
    }
  }

  /** Example of listing topics.  */
  public ListTopicsPagedResponse listTopics() throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START listTopics]
      ListTopicsRequest listTopicsRequest =
          ListTopicsRequest.newBuilder()
              .setProjectWithProjectName(ProjectName.create(projectId))
              .build();
      ListTopicsPagedResponse response = topicAdminClient.listTopics(listTopicsRequest);
      Iterable<Topic> topics = response.iterateAllElements();
      for (Topic topic : topics) {
        // do something with the topic
      }
      // [END listTopics]
      return response;
    }
  }

  /** Example of listing topics for a subscription. */
  public ListTopicSubscriptionsPagedResponse listTopicSubscriptions(String topicId)
      throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START listTopicSubscriptions]
      TopicName topicName = TopicName.create(projectId, topicId);
      ListTopicSubscriptionsRequest request =
          ListTopicSubscriptionsRequest.newBuilder()
              .setTopicWithTopicName(topicName)
              .build();
      ListTopicSubscriptionsPagedResponse response =
          topicAdminClient.listTopicSubscriptions(request);
      Iterable<String> subscriptionNames = response.iterateAllElements();
      for (String subscriptionName : subscriptionNames) {
        // do something with the subscription name
      }
      // [END listTopicSubscriptions]
      return response;
    }
  }

  /** Example of deleting a topic. */
  public TopicName deleteTopic(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START deleteTopic]
      TopicName topicName = TopicName.create(projectId, topicId);
      topicAdminClient.deleteTopic(topicName);
      // [END deleteTopic]
      return topicName;
    }
  }

  /** Example of getting a topic policy. */
  public Policy getTopicPolicy(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START getTopicPolicy]
      TopicName topicName = TopicName.create(projectId, topicId);
      Policy policy = topicAdminClient.getIamPolicy(topicName.toString());
      if (policy == null) {
        // topic iam policy was not found
      }
      // [END getTopicPolicy]
      return policy;
    }
  }

  /** Example of replacing a topic policy. */
  public Policy replaceTopicPolicy(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START replaceTopicPolicy]
      String topicName = TopicName.create(projectId, topicId).toString();
      Policy policy = topicAdminClient.getIamPolicy(topicName);
      // add role -> members binding
      Binding binding =
          Binding.newBuilder()
              .setRole(Role.viewer().toString())
              .addMembers(Identity.allAuthenticatedUsers().toString())
              .build();
      // create updated policy
      Policy updatedPolicy = Policy.newBuilder(policy).addBindings(binding).build();
      updatedPolicy = topicAdminClient.setIamPolicy(topicName, updatedPolicy);
      // [END replaceTopicPolicy]
      return updatedPolicy;
    }
  }

  /** Example of testing whether the caller has the provided permissions on a topic.
   * Only viewer, editor or admin/owner can view results of pubsub.topics.get  */
  public TestIamPermissionsResponse testTopicPermissions(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START testTopicPermissions]
      List<String> permissions = new LinkedList<>();
      permissions.add("pubsub.topics.get");
      TopicName topicName = TopicName.create(projectId, topicId);
      TestIamPermissionsResponse testedPermissions =
          topicAdminClient.testIamPermissions(topicName.toString(), permissions);
      // [END testTopicPermissions]
      return testedPermissions;
    }
  }

  /** Example of getting a topic. */
  public Topic getTopic(String topicId) throws Exception {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      // [START getTopic]
      TopicName topicName = TopicName.create(projectId, topicId);
      Topic topic = topicAdminClient.getTopic(topicName);
      // [END createTopic]
      return topic;
    }
  }
}
