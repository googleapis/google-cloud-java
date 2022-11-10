/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.notification.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.rpc.FailedPreconditionException;
import com.google.cloud.ServiceOptions;
import com.google.cloud.notification.Notification;
import com.google.cloud.notification.NotificationImpl.DefaultNotificationFactory;
import com.google.cloud.notification.NotificationInfo;
import com.google.cloud.notification.NotificationInfo.PayloadFormat;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.testing.RemoteStorageHelper;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.pubsub.v1.ProjectTopicName;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ITSystemTest {

  private static TopicAdminClient topicAdminClient;
  private static Notification notificationService;
  private static Storage storageService;

  private static final Logger log = Logger.getLogger(ITSystemTest.class.getName());
  private static final String STORAGE_SERVICE_AGENT =
      Optional.ofNullable(System.getenv("GOOGLE_STORAGE_SERVICE_AGENT"))
          .map(agent -> "serviceAccount:" + agent)
          .orElse("allAuthenticatedUsers");
  private static final String BUCKET = RemoteStorageHelper.generateBucketName();
  private static final String NAME_SUFFIX = UUID.randomUUID().toString();
  private static String projectId;

  @Rule public Timeout globalTimeout = Timeout.seconds(300);

  @BeforeClass
  public static void beforeClass() throws IOException {
    RemoteStorageHelper remoteStorageHelper = RemoteStorageHelper.create();
    topicAdminClient = TopicAdminClient.create();
    storageService = remoteStorageHelper.getOptions().getService();
    notificationService = new DefaultNotificationFactory().create(storageService);
    storageService.create(BucketInfo.of(BUCKET));
    projectId = ServiceOptions.getDefaultProjectId();
  }

  @AfterClass
  public static void afterClass() throws Exception {
    topicAdminClient.close();
    if (notificationService != null) {
      boolean wasDeleted =
          RemoteStorageHelper.forceDelete(storageService, BUCKET, 5, TimeUnit.SECONDS);
      if (!wasDeleted && log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, "Deletion of bucket {0} timed out, bucket is not empty", BUCKET);
      }
    }
  }

  private String formatForTest(String resourceName) {
    return resourceName + "-" + NAME_SUFFIX;
  }

  @Test
  public void testNotifications() {
    // Use Pubsub to create a Topic.
    final ProjectTopicName topic =
        ProjectTopicName.of(projectId, formatForTest("testing-topic-foo"));
    topicAdminClient.createTopic(topic);

    Policy policy = topicAdminClient.getIamPolicy(topic.toString());
    Binding binding =
        Binding.newBuilder()
            .setRole("roles/pubsub.publisher")
            .addMembers(STORAGE_SERVICE_AGENT)
            .build();
    Policy modifiedPolicy = policy.toBuilder().addBindings(binding).build();
    Policy newPolicy;
    try {
      newPolicy = topicAdminClient.setIamPolicy(topic.toString(), modifiedPolicy);
    } catch (StatusRuntimeException | FailedPreconditionException ex) {
      System.out.println(
          "Failed setIamPolicy request for " + topic.toString() + " : " + modifiedPolicy);
      throw ex;
    }
    assertTrue(newPolicy.getBindingsList().contains(binding));

    String permissionName = "pubsub.topics.get";
    List<String> permissions =
        topicAdminClient
            .testIamPermissions(topic.toString(), Collections.singletonList(permissionName))
            .getPermissionsList();
    assertTrue(permissions.contains(permissionName));

    // Use Storage API to create a Notification on that Topic.
    NotificationInfo notification =
        notificationService.createNotification(BUCKET, NotificationInfo.of(topic));
    assertNotNull(notification);
    List<NotificationInfo> notifications = notificationService.listNotifications(BUCKET);
    assertTrue(notifications.contains(notification));
    assertEquals(1, notifications.size());

    NotificationInfo notification2 =
        notificationService.createNotification(
            BUCKET,
            NotificationInfo.of(topic)
                .toBuilder()
                .setPayloadFormat(PayloadFormat.JSON_API_V1)
                .build());
    assertEquals(topic, notification2.getTopic());
    notifications = notificationService.listNotifications(BUCKET);
    assertTrue(notifications.contains(notification));
    assertTrue(notifications.contains(notification2));
    assertEquals(2, notifications.size());
    assertTrue(notificationService.deleteNotification(BUCKET, notification.getGeneratedId()));
    assertTrue(notificationService.deleteNotification(BUCKET, notification2.getGeneratedId()));
    assertNull(notificationService.listNotifications(BUCKET));

    topicAdminClient.deleteTopic(topic);
  }
}
