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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Notification;
import com.google.cloud.storage.NotificationInfo;
import com.google.cloud.storage.NotificationInfo.PayloadFormat;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableMap;
import com.google.iam.v1.Binding;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.SetIamPolicyRequest;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP},
    backends = {Backend.PROD})
public class ITNotificationTest {
  private static final Notification.PayloadFormat PAYLOAD_FORMAT = PayloadFormat.JSON_API_V1;
  private static final Map<String, String> CUSTOM_ATTRIBUTES = ImmutableMap.of("label1", "value1");
  private static final Logger LOGGER = LoggerFactory.getLogger(ITNotificationTest.class);
  private static final String DOES_NOT_EXIST_ID = "something-that-does-not-exist-probably";

  @Inject public Backend backend;
  @Inject public Transport transport;
  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  private TopicAdminClient topicAdminClient;
  private String topic;
  private NotificationInfo notificationInfo;

  @Before
  public void setup() throws IOException {
    String projectId = storage.getOptions().getProjectId();
    // square brackets are not acceptable characters for topic names, replace them with dash
    // https://cloud.google.com/pubsub/docs/admin#resource_names
    String name = generator.randomObjectName().replaceAll("[\\[\\]]", "-");
    topic = String.format(Locale.US, "projects/%s/topics/%s", projectId, name).trim();
    notificationInfo =
        NotificationInfo.newBuilder(topic)
            .setCustomAttributes(CUSTOM_ATTRIBUTES)
            .setPayloadFormat(PAYLOAD_FORMAT)
            .build();

    if (backend == Backend.PROD && transport == Transport.HTTP) {

      // Configure topic admin client for notification.
      topicAdminClient = TopicAdminClient.create();
      topicAdminClient.createTopic(this.topic);

      GetIamPolicyRequest getIamPolicyRequest =
          GetIamPolicyRequest.newBuilder().setResource(this.topic).build();

      com.google.iam.v1.Policy policy = topicAdminClient.getIamPolicy(getIamPolicyRequest);

      Binding binding =
          Binding.newBuilder().setRole("roles/owner").addMembers("allAuthenticatedUsers").build();

      SetIamPolicyRequest setIamPolicyRequest =
          SetIamPolicyRequest.newBuilder()
              .setResource(this.topic)
              .setPolicy(policy.toBuilder().addBindings(binding).build())
              .build();
      topicAdminClient.setIamPolicy(setIamPolicyRequest);
    }
  }

  @After
  public void cleanup() {
    /* Delete the Pub/Sub topic */
    if (topicAdminClient != null) {
      try {
        topicAdminClient.deleteTopic(topic);
        topicAdminClient.close();
      } catch (Exception e) {
        LOGGER.warn("Error while trying to delete topic and shutdown topic client", e);
      }
      topicAdminClient = null;
    }
  }

  @Test
  public void listNotification_doesNotExist() throws Exception {
    // create a temporary bucket to ensure we're immune from ordering on other tests
    try (TemporaryBucket tempB =
        TemporaryBucket.newBuilder()
            .setBucketInfo(BucketInfo.of(generator.randomBucketName()))
            .setStorage(storage)
            .build()) {
      List<Notification> notifications = storage.listNotifications(tempB.getBucket().getName());
      assertThat(notifications).isEmpty();
    }
  }

  @Test
  public void listNotification_exists() {
    Notification notification = storage.createNotification(bucket.getName(), notificationInfo);
    List<Notification> notifications = storage.listNotifications(bucket.getName());
    assertThat(notifications).isNotEmpty();
    assertThat(notifications).contains(notification);
  }

  @Test
  public void createNotification_doesNotExist() throws Exception {
    Notification notification = storage.createNotification(bucket.getName(), notificationInfo);
    assertAll(
        () -> assertThat(notification.getNotificationId()).isNotNull(),
        () -> assertThat(notification.getCustomAttributes()).isEqualTo(CUSTOM_ATTRIBUTES),
        () -> assertThat(notification.getPayloadFormat()).isEqualTo(PAYLOAD_FORMAT),
        () -> assertThat(notification.getTopic()).contains(topic));
  }

  @Test
  public void getNotification_exists() throws Exception {
    Notification notification = storage.createNotification(bucket.getName(), notificationInfo);

    Notification getResult =
        storage.getNotification(bucket.getName(), notification.getNotificationId());

    assertAll(
        () -> assertThat(getResult.getNotificationId()).isEqualTo(notification.getNotificationId()),
        () -> assertThat(getResult.getTopic()).isEqualTo(notification.getTopic()),
        () -> assertThat(getResult.getEtag()).isEqualTo(notification.getEtag()),
        () -> assertThat(getResult.getEventTypes()).isEqualTo(notification.getEventTypes()),
        () -> assertThat(getResult.getPayloadFormat()).isEqualTo(notification.getPayloadFormat()),
        () ->
            assertThat(getResult.getCustomAttributes())
                .isEqualTo(notification.getCustomAttributes()),
        () -> assertThat(getResult).isEqualTo(notification));
  }

  @Test
  public void getNotification_doesNotExists() {
    Notification getResult = storage.getNotification(bucket.getName(), DOES_NOT_EXIST_ID);

    assertThat(getResult).isNull();
  }

  @Test
  public void deleteNotification_exists() {
    Notification notification = storage.createNotification(bucket.getName(), notificationInfo);
    boolean deleteResult =
        storage.deleteNotification(bucket.getName(), notification.getNotificationId());
    assertThat(deleteResult).isTrue();
  }

  @Test
  public void deleteNotification_doesNotExists() {
    boolean deleteResult = storage.deleteNotification(bucket.getName(), DOES_NOT_EXIST_ID);
    assertThat(deleteResult).isFalse();
  }
}
