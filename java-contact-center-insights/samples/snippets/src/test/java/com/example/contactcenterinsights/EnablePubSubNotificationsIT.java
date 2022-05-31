/*
 * Copyright 2021 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.contactcenterinsights;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient;
import com.google.cloud.contactcenterinsights.v1.Settings;
import com.google.cloud.contactcenterinsights.v1.SettingsName;
import com.google.cloud.pubsub.v1.TopicAdminClient;
import com.google.protobuf.FieldMask;
import com.google.pubsub.v1.Topic;
import com.google.pubsub.v1.TopicName;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EnablePubSubNotificationsIT {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private String conversationTopic;
  private String analysisTopic;

  private static void requireEnvVar(String varName) {
    assertNotNull(String.format(varName), String.format(varName));
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_APPLICATION_CREDENTIALS");
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
  }

  @Before
  public void setUp() throws IOException {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);

    // Create Pub/Sub topics.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      String conversationTopicId =
          String.format("create-conversation-%s", UUID.randomUUID().toString());
      String analysisTopicId = String.format("create-analysis-%s", UUID.randomUUID().toString());

      conversationTopic = TopicName.of(PROJECT_ID, conversationTopicId).toString();
      analysisTopic = TopicName.of(PROJECT_ID, analysisTopicId).toString();
      String[] topicNames = {conversationTopic, analysisTopic};

      for (String topicName : topicNames) {
        Topic topic = topicAdminClient.createTopic(topicName);
      }
    }
  }

  @After
  public void tearDown() throws IOException {
    // Disable Pub/Sub notifications.
    try (ContactCenterInsightsClient client = ContactCenterInsightsClient.create()) {
      SettingsName name = SettingsName.of(PROJECT_ID, "us-central1");
      Settings settings =
          Settings.newBuilder().setName(name.toString()).clearPubsubNotificationSettings().build();

      FieldMask updateMask =
          FieldMask.newBuilder().addPaths("pubsub_notification_settings").build();

      Settings response = client.updateSettings(settings, updateMask);
    }

    // Delete Pub/Sub topics.
    try (TopicAdminClient topicAdminClient = TopicAdminClient.create()) {
      topicAdminClient.deleteTopic(conversationTopic);
      topicAdminClient.deleteTopic(analysisTopic);
    }
    System.setOut(null);
  }

  @Test
  public void testEnablePubSubNotifications() throws IOException {
    EnablePubSubNotifications.enablePubSubNotifications(
        PROJECT_ID, conversationTopic, analysisTopic);
    assertThat(bout.toString()).contains("Enabled Pub/Sub notifications");
  }
}
