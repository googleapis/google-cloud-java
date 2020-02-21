/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.examples.securitycenter.snippets.v1p1beta1;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/** Smoke tests for {@link NotificationConfigSnippets} */
public class ITNotificationConfigSnippets {

  @Test
  public void testCreateNotificationConfig() throws IOException {
    assertNotNull(
        NotificationConfigSnippets.createNotificationConfig(
            getOrganizationId(), getPubsubTopic(), "java-notification-config-create"));

    deleteConfig("java-notification-config-create");
  }

  @Test
  public void testDeleteNotificationConfig() throws IOException {
    createConfig("java-notification-config-delete");

    assertTrue(
        NotificationConfigSnippets.deleteNotificationConfig(
            getOrganizationId(), "java-notification-config-delete"));
  }

  @Test
  public void testListNotificationConfig() throws IOException {
    createConfig("java-notification-config-list");

    assertNotNull(NotificationConfigSnippets.listNotificationConfigs(getOrganizationId()));

    deleteConfig("java-notification-config-list");
  }

  @Test
  public void testGetNotificationConfig() throws IOException {
    createConfig("java-notification-config-get");

    assertNotNull(
        NotificationConfigSnippets.getNotificationConfig(
            getOrganizationId(), "java-notification-config-get"));

    deleteConfig("java-notification-config-get");
  }

  @Test
  public void testUpdateNotificationConfig() throws IOException {
    createConfig("java-notification-config-update");

    assertNotNull(
        NotificationConfigSnippets.updateNotificationConfig(
            getOrganizationId(), "java-notification-config-update", getPubsubTopic()));

    deleteConfig("java-notification-config-update");
  }

  private static void createConfig(String configId) throws IOException {
    NotificationConfigSnippets.createNotificationConfig(
        getOrganizationId(), getPubsubTopic(), configId);
  }

  private static void deleteConfig(String configId) throws IOException {
    assertTrue(NotificationConfigSnippets.deleteNotificationConfig(getOrganizationId(), configId));
  }

  private static String getOrganizationId() {
    return System.getenv("GCLOUD_ORGANIZATION");
  }

  private static String getPubsubTopic() {
    return "projects/project-a-id/topics/notifications-sample-topic";
  }
}
