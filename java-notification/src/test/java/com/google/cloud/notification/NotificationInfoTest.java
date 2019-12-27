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

package com.google.cloud.notification;

import static org.junit.Assert.assertEquals;

import com.google.cloud.notification.NotificationInfo.PayloadFormat;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.pubsub.v1.ProjectTopicName;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class NotificationInfoTest {

  private static final String ETAG = "0xFF00";
  private static final String GENERATED_ID = "B/N:1";
  private static final String SELF_LINK = "http://storage/b/n";
  private static final List<String> EVENT_TYPES =
      ImmutableList.of("OBJECT_FINALIZE", "OBJECT_METADATA_UPDATE");
  private static final String OBJECT_NAME_PREFIX = "index.html";
  private static final PayloadFormat PAYLOAD_FORMAT = PayloadFormat.JSON_API_V1;
  private static final ProjectTopicName TOPIC = ProjectTopicName.of("myProject", "topic1");
  private static final Map<String, String> CUSTOM_ATTRIBUTES = ImmutableMap.of("label1", "value1");
  private static final NotificationInfo NOTIFICATION_INFO =
      NotificationInfo.newBuilder(TOPIC)
          .setEtag(ETAG)
          .setCustomAttributes(CUSTOM_ATTRIBUTES)
          .setSelfLink(SELF_LINK)
          .setEventTypes(EVENT_TYPES)
          .setObjectNamePrefix(OBJECT_NAME_PREFIX)
          .setPayloadFormat(PAYLOAD_FORMAT)
          .setGeneratedId(GENERATED_ID)
          .build();

  @Test
  public void testToBuilder() {
    compareBuckets(NOTIFICATION_INFO, NOTIFICATION_INFO.toBuilder().build());
    NotificationInfo bucketInfo = NOTIFICATION_INFO.toBuilder().setGeneratedId("id").build();
    assertEquals("id", bucketInfo.getGeneratedId());
    bucketInfo = bucketInfo.toBuilder().setGeneratedId(GENERATED_ID).build();
    compareBuckets(NOTIFICATION_INFO, bucketInfo);
  }

  @Test
  public void testToBuilderIncomplete() {
    NotificationInfo incompleteBucketInfo =
        NotificationInfo.newBuilder(ProjectTopicName.of("myProject", "topic1")).build();
    compareBuckets(incompleteBucketInfo, incompleteBucketInfo.toBuilder().build());
  }

  @Test
  public void testOf() {
    NotificationInfo bucketInfo = NotificationInfo.of(ProjectTopicName.of("myProject", "topic1"));
    assertEquals(ProjectTopicName.of("myProject", "topic1"), bucketInfo.getTopic());
  }

  @Test
  public void testBuilder() {
    assertEquals(ETAG, NOTIFICATION_INFO.getEtag());
    assertEquals(GENERATED_ID, NOTIFICATION_INFO.getGeneratedId());
    assertEquals(SELF_LINK, NOTIFICATION_INFO.getSelfLink());
    assertEquals(EVENT_TYPES, NOTIFICATION_INFO.getEventTypes());
    assertEquals(OBJECT_NAME_PREFIX, NOTIFICATION_INFO.getObjectNamePrefix());
    assertEquals(PAYLOAD_FORMAT, NOTIFICATION_INFO.getPayloadFormat());
    assertEquals(TOPIC, NOTIFICATION_INFO.getTopic());
    assertEquals(CUSTOM_ATTRIBUTES, NOTIFICATION_INFO.getCustomAttributes());
  }

  @Test
  public void testToPbAndFromPb() {
    compareBuckets(NOTIFICATION_INFO, NotificationInfo.fromPb(NOTIFICATION_INFO.toPb()));
    NotificationInfo bucketInfo =
        NotificationInfo.of(ProjectTopicName.of("myProject", "topic1"))
            .toBuilder()
            .setPayloadFormat(PayloadFormat.NONE)
            .build();
    compareBuckets(bucketInfo, NotificationInfo.fromPb(bucketInfo.toPb()));
  }

  private void compareBuckets(NotificationInfo expected, NotificationInfo value) {
    assertEquals(expected, value);
    assertEquals(expected.getGeneratedId(), value.getGeneratedId());
    assertEquals(expected.getCustomAttributes(), value.getCustomAttributes());
    assertEquals(expected.getEtag(), value.getEtag());
    assertEquals(expected.getSelfLink(), value.getSelfLink());
    assertEquals(expected.getEventTypes(), value.getEventTypes());
    assertEquals(expected.getObjectNamePrefix(), value.getObjectNamePrefix());
    assertEquals(expected.getPayloadFormat(), value.getPayloadFormat());
    assertEquals(expected.getTopic(), value.getTopic());
  }
}
