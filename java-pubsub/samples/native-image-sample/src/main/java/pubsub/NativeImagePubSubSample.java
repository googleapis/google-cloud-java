/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pubsub;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.pubsub.v1.AckReplyConsumer;
import com.google.cloud.pubsub.v1.MessageReceiver;
import com.google.cloud.pubsub.v1.Subscriber;
import com.google.cloud.pubsub.v1.SubscriptionAdminClient;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.pubsub.v1.stub.GrpcSubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.cloud.pubsub.v1.stub.SubscriberStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeadLetterPolicy;
import com.google.pubsub.v1.DetachSubscriptionRequest;
import com.google.pubsub.v1.ProjectName;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.ProjectTopicName;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.PushConfig;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import com.google.pubsub.v1.UpdateSubscriptionRequest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import utilities.PublishOperations;

/** Pub/Sub sample application compiled with Native Image. */
public class NativeImagePubSubSample {

  /** Driver for the Pub/Sub Sample application which publishes a message to a specified topic. */
  public static void main(String[] args) throws Exception {
    Instant startTime = Instant.now();
    String projectId = ServiceOptions.getDefaultProjectId();

    String topicId = "native-pubsub-test-" + UUID.randomUUID().toString();
    String pullSubId = "native-pubsub-test-sub" + UUID.randomUUID().toString();
    String pushSubId = "native-pubsub-test-sub" + UUID.randomUUID().toString();

    try {
      // Topic management operations
      createTopic(projectId, topicId);
      createPullSubscription(projectId, pullSubId, topicId);
      createPushSubscription(projectId, pushSubId, topicId);
      detachSubscription(projectId, pushSubId);
      getTopicPolicy(projectId, topicId);
      getSubscriptionPolicy(projectId, pullSubId);
      listSubscriptionInProject(projectId);
      listSubscriptionInTopic(projectId, topicId);
      listTopics(projectId);
      updateSubscriptionDeadLetterTopic(projectId, pushSubId, topicId, topicId);
      testTopicPermissions(projectId, topicId);
      testSubscriptionPermissions(projectId, pushSubId);

      // Publish Operations
      PublishOperations.publishMessage(projectId, topicId);
      PublishOperations.publishWithBatchSettings(projectId, topicId);
      PublishOperations.publishWithCustomAttributes(projectId, topicId);
      PublishOperations.publishWithErrorHandler(projectId, topicId);

      // Receive messages
      subscribeSync(projectId, pullSubId);
      receiveMessagesWithDeliveryAttempts(projectId, pullSubId);
    } finally {
      deleteTopic(projectId, topicId);
      deleteSubscription(projectId, pullSubId);
      deleteSubscription(projectId, pushSubId);
    }
    Instant endTime = Instant.now();
    Duration duration = Duration.between(startTime, endTime);
    System.out.println("Duration: " + duration.toString());
  }

  static void createTopic(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      Topic topic = topicAdminClient.createTopic(topicName);
      System.out.println("Created topic: " + topic.getName() + " under project: " + projectId);
    }
  }

  static void createPullSubscription(String projectId, String subscriptionId, String topicId)
      throws IOException {

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);
      Subscription subscription =
          subscriptionAdminClient.createSubscription(
              subscriptionName, topicName, PushConfig.getDefaultInstance(), 10);
      System.out.println("Created pull subscription: " + subscription.getName());
    }
  }

  static void createPushSubscription(String projectId, String subscriptionId, String topicId)
      throws IOException {

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      // Intentionally set pushEndpoint empty just to exercise API call
      PushConfig pushConfig = PushConfig.newBuilder().setPushEndpoint("").build();

      Subscription subscription =
          subscriptionAdminClient.createSubscription(subscriptionName, topicName, pushConfig, 10);
      System.out.println("Created push subscription: " + subscription.getName());
    }
  }

  static void detachSubscription(String projectId, String subscriptionId) throws IOException {

    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.detachSubscription(
          DetachSubscriptionRequest.newBuilder()
              .setSubscription(subscriptionName.toString())
              .build());
    }

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      Subscription subscription = subscriptionAdminClient.getSubscription(subscriptionName);
      if (subscription.getDetached()) {
        System.out.println("Subscription is detached.");
      } else {
        throw new RuntimeException("Subscription detachment was not successful.");
      }
    }
  }

  static void getSubscriptionPolicy(String projectId, String subscriptionId) throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);
      GetIamPolicyRequest getIamPolicyRequest =
          GetIamPolicyRequest.newBuilder().setResource(subscriptionName.toString()).build();
      Policy policy = subscriptionAdminClient.getIamPolicy(getIamPolicyRequest);
      System.out.println("Subscription policy: " + policy.toString().trim());
    }
  }

  static void getTopicPolicy(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      GetIamPolicyRequest getIamPolicyRequest =
          GetIamPolicyRequest.newBuilder().setResource(topicName.toString()).build();
      Policy policy = topicAdminClient.getIamPolicy(getIamPolicyRequest);
      System.out.println("Topic policy: " + policy.toString().trim());
    }
  }

  static void listSubscriptionInProject(String projectId) throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectName projectName = ProjectName.of(projectId);
      int count = 0;
      for (Subscription subscription :
          subscriptionAdminClient.listSubscriptions(projectName).iterateAll()) {
        count += 1;
      }
      System.out.println("Subscriptions in project count: " + count);
    }
  }

  static void listSubscriptionInTopic(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      int count = 0;
      for (String subscription : topicAdminClient.listTopicSubscriptions(topicName).iterateAll()) {
        count += 1;
      }
      System.out.println("Subscriptions under topic: " + count);
    }
  }

  static void listTopics(String projectId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      ProjectName projectName = ProjectName.of(projectId);
      int count = 0;
      for (Topic topic : topicAdminClient.listTopics(projectName).iterateAll()) {
        count += 1;
      }
      System.out.println("Topic count under project: " + count);
    }
  }

  static void receiveMessagesWithDeliveryAttempts(String projectId, String subscriptionId) {

    ProjectSubscriptionName subscriptionName =
        ProjectSubscriptionName.of(projectId, subscriptionId);

    // Instantiate an asynchronous message receiver.
    MessageReceiver receiver =
        new MessageReceiver() {
          @Override
          public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
            consumer.ack();
          }
        };

    Subscriber subscriber = null;
    try {
      subscriber = Subscriber.newBuilder(subscriptionName, receiver).build();
      // Start the subscriber.
      subscriber.startAsync().awaitRunning();
      System.out.println("Successfully started an async message receiver.");
    } finally {
      // Shut down the subscriber after 10s. Stop receiving messages.
      subscriber.stopAsync();
    }
  }

  static void subscribeSync(String projectId, String subscriptionId) throws IOException {
    SubscriberStubSettings subscriberStubSettings =
        SubscriberStubSettings.newBuilder()
            .setTransportChannelProvider(
                SubscriberStubSettings.defaultGrpcTransportProviderBuilder()
                    .setMaxInboundMessageSize(20 * 1024 * 1024) // 20MB (maximum message size).
                    .build())
            .build();

    try (SubscriberStub subscriber = GrpcSubscriberStub.create(subscriberStubSettings)) {
      String subscriptionName = ProjectSubscriptionName.format(projectId, subscriptionId);
      PullRequest pullRequest =
          PullRequest.newBuilder().setMaxMessages(1).setSubscription(subscriptionName).build();

      PullResponse pullResponse = subscriber.pullCallable().call(pullRequest);
      List<String> ackIds = new ArrayList<>();
      for (ReceivedMessage message : pullResponse.getReceivedMessagesList()) {
        String payload = message.getMessage().getData().toStringUtf8();
        ackIds.add(message.getAckId());
        System.out.println("Received Payload: " + payload);
      }

      AcknowledgeRequest acknowledgeRequest =
          AcknowledgeRequest.newBuilder()
              .setSubscription(subscriptionName)
              .addAllAckIds(ackIds)
              .build();

      subscriber.acknowledgeCallable().call(acknowledgeRequest);
    }
  }

  static void updateSubscriptionDeadLetterTopic(
      String projectId, String subscriptionId, String topicId, String deadLetterTopicId)
      throws IOException {

    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      TopicName topicName = TopicName.of(projectId, topicId);
      TopicName deadLetterTopicName = TopicName.of(projectId, deadLetterTopicId);

      DeadLetterPolicy deadLetterPolicy =
          DeadLetterPolicy.newBuilder()
              .setDeadLetterTopic(deadLetterTopicName.toString())
              .setMaxDeliveryAttempts(20)
              .build();

      Subscription subscription =
          Subscription.newBuilder()
              .setName(subscriptionName.toString())
              .setTopic(topicName.toString())
              .setDeadLetterPolicy(deadLetterPolicy)
              .build();

      FieldMask updateMask = FieldMask.newBuilder().addPaths("dead_letter_policy").build();

      UpdateSubscriptionRequest request =
          UpdateSubscriptionRequest.newBuilder()
              .setSubscription(subscription)
              .setUpdateMask(updateMask)
              .build();

      Subscription response = subscriptionAdminClient.updateSubscription(request);
      System.out.println("Updated subscription " + response.getName());
    }
  }

  static void testSubscriptionPermissions(String projectId, String subscriptionId)
      throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);

      List<String> permissions = new ArrayList<>();
      permissions.add("pubsub.subscriptions.consume");
      permissions.add("pubsub.subscriptions.update");

      TestIamPermissionsRequest testIamPermissionsRequest =
          TestIamPermissionsRequest.newBuilder()
              .setResource(subscriptionName.toString())
              .addAllPermissions(permissions)
              .build();

      TestIamPermissionsResponse testedPermissionsResponse =
          subscriptionAdminClient.testIamPermissions(testIamPermissionsRequest);

      System.out.println(
          "Tested PubSub subscription permissions\n" + testedPermissionsResponse.toString().trim());
    }
  }

  static void testTopicPermissions(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      ProjectTopicName topicName = ProjectTopicName.of(projectId, topicId);

      List<String> permissions = new ArrayList<>();
      permissions.add("pubsub.topics.attachSubscription");
      permissions.add("pubsub.topics.publish");
      permissions.add("pubsub.topics.update");

      TestIamPermissionsRequest testIamPermissionsRequest =
          TestIamPermissionsRequest.newBuilder()
              .setResource(topicName.toString())
              .addAllPermissions(permissions)
              .build();

      TestIamPermissionsResponse testedPermissionsResponse =
          topicAdminClient.testIamPermissions(testIamPermissionsRequest);

      System.out.println(
          "Tested topic permissions\n" + testedPermissionsResponse.toString().trim());
    }
  }

  static void deleteTopic(String projectId, String topicId) throws IOException {
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      TopicName topicName = TopicName.of(projectId, topicId);
      try {
        topicAdminClient.deleteTopic(topicName);
        System.out.println("Deleted topic " + topicName);
      } catch (NotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  static void deleteSubscription(String projectId, String subscriptionId) throws IOException {
    try (SubscriptionAdminClient subscriptionAdminClient = SubscriptionAdminClient.create()) {
      ProjectSubscriptionName subscriptionName =
          ProjectSubscriptionName.of(projectId, subscriptionId);
      try {
        subscriptionAdminClient.deleteSubscription(subscriptionName);
        System.out.println("Deleted subscription " + subscriptionName);
      } catch (NotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
