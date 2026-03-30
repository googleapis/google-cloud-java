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

package com.google.cloud.storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.storage.NotificationInfo.EventType;
import com.google.cloud.storage.NotificationInfo.PayloadFormat;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Map;
import org.junit.Test;

public class NotificationInfoTest {
  private static final String ETAG = "0xFF00";
  private static final String SELF_LINK = "http://storage/b/n";
  private static final String OBJECT_NAME_PREFIX = "index.html";
  private static final String TOPIC = "projects/myProject/topics/topic1";
  private static final Map<String, String> CUSTOM_ATTRIBUTES = ImmutableMap.of("label1", "value1");
  private static final PayloadFormat PAYLOAD_FORMAT = PayloadFormat.JSON_API_V1.JSON_API_V1;
  private static final EventType[] EVENT_TYPES = {
    EventType.OBJECT_FINALIZE, EventType.OBJECT_METADATA_UPDATE
  };
  private static final NotificationInfo NOTIFICATION_INFO =
      NotificationInfo.newBuilder(TOPIC)
          .setEtag(ETAG)
          .setCustomAttributes(CUSTOM_ATTRIBUTES)
          .setSelfLink(SELF_LINK)
          .setEventTypes(EVENT_TYPES)
          .setObjectNamePrefix(OBJECT_NAME_PREFIX)
          .setPayloadFormat(PAYLOAD_FORMAT)
          .build();

  @Test
  public void testToBuilder() {
    compareBucketsNotification(NOTIFICATION_INFO, NOTIFICATION_INFO.toBuilder().build());
    NotificationInfo notificationInfo = NOTIFICATION_INFO.toBuilder().setTopic(TOPIC).build();
    assertEquals(TOPIC, notificationInfo.getTopic());
    notificationInfo = notificationInfo.toBuilder().setTopic(TOPIC).build();
    compareBucketsNotification(NOTIFICATION_INFO, notificationInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    NotificationInfo incompleteNotificationInfo = Notification.newBuilder(TOPIC).build();
    compareBucketsNotification(
        incompleteNotificationInfo, incompleteNotificationInfo.toBuilder().build());
  }

  @Test
  public void testOf() {
    NotificationInfo notificationInfo = NotificationInfo.of(TOPIC);
    assertEquals(TOPIC, notificationInfo.getTopic());
    assertNull(notificationInfo.getNotificationId());
    assertNull(notificationInfo.getCustomAttributes());
    assertNull(notificationInfo.getEtag());
    assertNull(notificationInfo.getSelfLink());
    assertNull(notificationInfo.getEventTypes());
    assertNull(notificationInfo.getObjectNamePrefix());
    assertNull(notificationInfo.getPayloadFormat());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, NOTIFICATION_INFO.getEtag());
    assertNull(NOTIFICATION_INFO.getNotificationId());
    assertEquals(SELF_LINK, NOTIFICATION_INFO.getSelfLink());
    assertEquals(OBJECT_NAME_PREFIX, NOTIFICATION_INFO.getObjectNamePrefix());
    assertEquals(PAYLOAD_FORMAT, NOTIFICATION_INFO.getPayloadFormat());
    assertEquals(TOPIC, NOTIFICATION_INFO.getTopic());
    assertEquals(CUSTOM_ATTRIBUTES, NOTIFICATION_INFO.getCustomAttributes());
    assertEquals(Arrays.asList(EVENT_TYPES), NOTIFICATION_INFO.getEventTypes());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBucketsNotification(
        NOTIFICATION_INFO,
        Conversions.json()
            .notificationInfo()
            .decode(Conversions.json().notificationInfo().encode(NOTIFICATION_INFO)));
    NotificationInfo notificationInfo =
        NotificationInfo.of(TOPIC).toBuilder().setPayloadFormat(PayloadFormat.NONE).build();
    compareBucketsNotification(
        notificationInfo,
        Conversions.json()
            .notificationInfo()
            .decode(Conversions.json().notificationInfo().encode(notificationInfo)));
  }

  private void compareBucketsNotification(NotificationInfo expected, NotificationInfo actual) {
    assertEquals(expected, actual);
    assertEquals(expected.getNotificationId(), actual.getNotificationId());
    assertEquals(expected.getCustomAttributes(), actual.getCustomAttributes());
    assertEquals(expected.getEtag(), actual.getEtag());
    assertEquals(expected.getSelfLink(), actual.getSelfLink());
    assertEquals(expected.getEventTypes(), actual.getEventTypes());
    assertEquals(expected.getObjectNamePrefix(), actual.getObjectNamePrefix());
    assertEquals(expected.getPayloadFormat(), actual.getPayloadFormat());
    assertEquals(expected.getTopic(), actual.getTopic());
  }
}
