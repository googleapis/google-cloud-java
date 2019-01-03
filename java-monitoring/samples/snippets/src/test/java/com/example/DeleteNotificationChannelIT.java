/*
 * Copyright 2018 Google LLC
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

package com.example;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.monitoring.v3.NotificationChannelServiceClient;
import com.google.monitoring.v3.NotificationChannel;
import com.google.monitoring.v3.ProjectName;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for delete notification channel sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class DeleteNotificationChannelIT {
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private static final String LEGACY_PROJECT_ENV_NAME = "GCLOUD_PROJECT";
  private static final String PROJECT_ENV_NAME = "GOOGLE_CLOUD_PROJECT";
  private static String NOTIFICATION_CHANNEL_NAME = "channelname";
  private static NotificationChannel NOTIFICATION_CHANNEL;

  private static String getProjectId() {
    String projectId = System.getProperty(PROJECT_ENV_NAME, System.getenv(PROJECT_ENV_NAME));
    if (projectId == null) {
      projectId = System.getProperty(LEGACY_PROJECT_ENV_NAME,
          System.getenv(LEGACY_PROJECT_ENV_NAME));
    }
    return projectId;
  }

  @BeforeClass
  public static void setupClass() throws IOException {
    try (NotificationChannelServiceClient client = NotificationChannelServiceClient.create()) {
      String projectId = getProjectId();
      NOTIFICATION_CHANNEL = NotificationChannel.newBuilder()
          .setType("email")
          .putLabels("email_address", "java-docs-samples-testing@google.com")
          .build();
      NotificationChannel channel = client.createNotificationChannel(ProjectName.of(projectId),
          NOTIFICATION_CHANNEL);
      NOTIFICATION_CHANNEL_NAME = channel.getName();
    }
  }

  @Before
  public void setUp() {
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    System.setOut(out);
    System.setProperty("projectId", DeleteNotificationChannelIT.getProjectId());
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testDeleteNotificationChannel() throws Exception {
    // Act
    DeleteNotificationChannel.deleteNotificationChannel(NOTIFICATION_CHANNEL_NAME);
    // Assert
    String got = bout.toString();
    assertThat(got).contains(NOTIFICATION_CHANNEL_NAME);
  }
}
