/*
 * Copyright 2022 Google LLC
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

package com.example.storage.bucket;

import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT;
import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT_NUMBER;
import static com.google.common.truth.Truth.assertThat;

import com.example.storage.TestBase;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.storage.Notification;
import com.google.cloud.storage.NotificationInfo;
import com.google.cloud.storage.NotificationInfo.EventType;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PubSubNotificationTest extends TestBase {

  private static final Map<String, String> CUSTOM_ATTRIBUTES = ImmutableMap.of("label1", "value1");

  private static final String OBJECT_NAME_PREFIX = "index.html";
  private static final EventType[] EVENT_TYPES = {
    EventType.OBJECT_FINALIZE, EventType.OBJECT_METADATA_UPDATE
  };
  private static TopicAdminClient topicAdminClient;

  private String bucketName;
  private String topic;
  private NotificationInfo notificationInfo;

  @BeforeClass
  public static void configureTopicAdminClient() throws IOException {
    topicAdminClient = TopicAdminClient.create();
  }

  @AfterClass
  public static void deleteTopicAndClient() throws InterruptedException {
    /* Delete the Pub/Sub topic */
    if (topicAdminClient != null) {
      topicAdminClient.shutdownNow();
      topicAdminClient.awaitTermination(5, TimeUnit.SECONDS);
    }
  }

  @Before
  public void setUp() {
    assertThat(GOOGLE_CLOUD_PROJECT).isNotNull();

    bucketName = bucket.getName();

    String id = UUID.randomUUID().toString().substring(0, 8);
    topic = String.format("projects/%s/topics/new-topic-%s", GOOGLE_CLOUD_PROJECT, id);
    topicAdminClient.createTopic(topic);
    GetIamPolicyRequest getIamPolicyRequest =
        GetIamPolicyRequest.newBuilder().setResource(topic).build();
    com.google.iam.v1.Policy policy = topicAdminClient.getIamPolicy(getIamPolicyRequest);
    // For available bindings identities, see
    // https://cloud.google.com/iam/docs/overview#concepts_related_identity
    String member =
        GOOGLE_CLOUD_PROJECT_NUMBER != null
            ? String.format(
                "serviceAccount:service-%s@gs-project-accounts.iam.gserviceaccount.com",
                GOOGLE_CLOUD_PROJECT_NUMBER)
            : "allAuthenticatedUsers";
    Binding binding = Binding.newBuilder().setRole("roles/owner").addMembers(member).build();
    SetIamPolicyRequest setIamPolicyRequest =
        SetIamPolicyRequest.newBuilder()
            .setResource(topic)
            .setPolicy(policy.toBuilder().addBindings(binding).build())
            .build();
    topicAdminClient.setIamPolicy(setIamPolicyRequest);

    notificationInfo =
        NotificationInfo.newBuilder(topic)
            .setCustomAttributes(CUSTOM_ATTRIBUTES)
            .setPayloadFormat(Notification.PayloadFormat.JSON_API_V1)
            .build();
  }

  @After
  public void tearDown() {
    if (topic != null) {
      topicAdminClient.deleteTopic(topic);
    }
  }

  @Test
  public void testCreateBucketPubSubNotification() {
    CreateBucketPubSubNotification.createBucketPubSubNotification(
        bucketName,
        topic,
        CUSTOM_ATTRIBUTES,
        EVENT_TYPES,
        OBJECT_NAME_PREFIX,
        Notification.PayloadFormat.JSON_API_V1);
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(topic);
  }

  @Test
  public void testDeleteBucketPubSubNotification() {
    Notification notification = storage.createNotification(bucketName, notificationInfo);
    DeleteBucketPubSubNotification.deleteBucketPubSubNotification(
        bucketName, notification.getNotificationId());
    assertThat(stdOut.getCapturedOutputAsUtf8String())
        .contains("Successfully deleted notification");
  }

  @Test
  public void testNotificationNotFound() {
    Notification notification = storage.createNotification(bucketName, notificationInfo);
    // Do a delete first.
    storage.deleteNotification(bucketName, notification.getNotificationId());
    // Now try to delete again.
    DeleteBucketPubSubNotification.deleteBucketPubSubNotification(
        bucketName, notification.getNotificationId());
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains("Failed to find notification");
  }

  @Test
  public void testListBucketPubSubNotification() {
    storage.createNotification(bucketName, notificationInfo);
    ListPubSubNotifications.listPubSubNotifications(bucketName);
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(topic);
  }

  @Test
  public void testPrintBucketPubSubNotification() {
    Notification notification = storage.createNotification(bucketName, notificationInfo);
    PrintPubSubNotification.printPubSubNotification(bucketName, notification.getNotificationId());
    assertThat(stdOut.getCapturedOutputAsUtf8String()).contains(topic);
  }
}
