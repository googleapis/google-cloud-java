/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub.deprecated;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.cloud.ByteArray;
import com.google.common.collect.ImmutableMap;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;

public class MessageTest {

  private static final String MESSAGE_ID = "messageId";
  private static final String PAYLOAD_STRING = "payload";
  private static final ByteArray PAYLOAD =
      ByteArray.copyFrom("payload".getBytes(StandardCharsets.UTF_8));
  private static final Map<String, String> ATTRIBUTES =
      ImmutableMap.of("key1", "value1", "key2", "value2");
  private static final Long PUBLISH_TIME = 42L;
  private static final Message MESSAGE_STRING = Message.newBuilder(PAYLOAD_STRING)
      .setId(MESSAGE_ID)
      .setAttributes(ATTRIBUTES)
      .setPublishTime(PUBLISH_TIME)
      .build();
  private static final Message MESSAGE = Message.newBuilder(PAYLOAD)
      .setId(MESSAGE_ID)
      .setAttributes(ATTRIBUTES)
      .setPublishTime(PUBLISH_TIME)
      .build();
  private static final Message DEPRECATED_MESSAGE_STRING = Message.builder(PAYLOAD_STRING)
      .setId(MESSAGE_ID)
      .attributes(ATTRIBUTES)
      .setPublishTime(PUBLISH_TIME)
      .build();
  private static final Message DEPRECATED_MESSAGE = Message.builder(PAYLOAD)
      .setId(MESSAGE_ID)
      .attributes(ATTRIBUTES)
      .setPublishTime(PUBLISH_TIME)
      .build();

  @Test
  public void testToBuilder() {
    compareMessage(MESSAGE, MESSAGE.toBuilder().build());
    Message message = MESSAGE.toBuilder()
        .setPayload("newPayload")
        .clearAttributes()
        .addAttribute("key1", "value1")
        .build();
    assertEquals("newPayload", message.getPayloadAsString());
    assertEquals(ImmutableMap.of("key1", "value1"), message.getAttributes());
    message = message.toBuilder()
        .setPayload(PAYLOAD_STRING)
        .removeAttribute("key1")
        .setAttributes(ATTRIBUTES)
        .build();
    compareMessage(MESSAGE, message);
  }

  @Test
  public void testBuilder() {
    assertEquals(MESSAGE_ID, MESSAGE.getId());
    assertEquals(PAYLOAD, MESSAGE.getPayload());
    assertEquals(PAYLOAD_STRING, MESSAGE.getPayloadAsString());
    assertEquals(ATTRIBUTES, MESSAGE.getAttributes());
    assertEquals(PUBLISH_TIME, MESSAGE.getPublishTime());
    assertEquals(MESSAGE_ID, MESSAGE_STRING.getId());
    assertEquals(PAYLOAD, MESSAGE_STRING.getPayload());
    assertEquals(PAYLOAD_STRING, MESSAGE_STRING.getPayloadAsString());
    assertEquals(ATTRIBUTES, MESSAGE_STRING.getAttributes());
    assertEquals(PUBLISH_TIME, MESSAGE_STRING.getPublishTime());
    compareMessage(MESSAGE, MESSAGE_STRING);
    Message message = Message.newBuilder(PAYLOAD)
        .setId(MESSAGE_ID)
        .setAttributes(ATTRIBUTES)
        .clearAttributes()
        .addAttribute("key1", "value1")
        .addAttribute("key2", "value2")
        .setPublishTime(PUBLISH_TIME)
        .build();
    assertEquals(MESSAGE_ID, message.getId());
    assertEquals(PAYLOAD, message.getPayload());
    assertEquals(PAYLOAD_STRING, message.getPayloadAsString());
    assertEquals(ATTRIBUTES, message.getAttributes());
    assertEquals(PUBLISH_TIME, message.getPublishTime());
    compareMessage(MESSAGE, message);
  }

  @Test
  public void testBuilderDeprecated() {
    assertEquals(MESSAGE_ID, DEPRECATED_MESSAGE.id());
    assertEquals(PAYLOAD, DEPRECATED_MESSAGE.payload());
    assertEquals(PAYLOAD_STRING, DEPRECATED_MESSAGE.payloadAsString());
    assertEquals(ATTRIBUTES, DEPRECATED_MESSAGE.attributes());
    assertEquals(PUBLISH_TIME, DEPRECATED_MESSAGE.publishTime());
    assertEquals(MESSAGE_ID, DEPRECATED_MESSAGE_STRING.id());
    assertEquals(PAYLOAD, DEPRECATED_MESSAGE_STRING.payload());
    assertEquals(PAYLOAD_STRING, DEPRECATED_MESSAGE_STRING.payloadAsString());
    assertEquals(ATTRIBUTES, DEPRECATED_MESSAGE_STRING.attributes());
    assertEquals(PUBLISH_TIME, DEPRECATED_MESSAGE_STRING.publishTime());
    compareMessage(MESSAGE, DEPRECATED_MESSAGE_STRING);
    Message message = Message.builder(PAYLOAD)
        .setId(MESSAGE_ID)
        .attributes(ATTRIBUTES)
        .clearAttributes()
        .addAttribute("key1", "value1")
        .addAttribute("key2", "value2")
        .setPublishTime(PUBLISH_TIME)
        .build();
    assertEquals(MESSAGE_ID, message.id());
    assertEquals(PAYLOAD, message.payload());
    assertEquals(PAYLOAD_STRING, message.payloadAsString());
    assertEquals(ATTRIBUTES, message.attributes());
    assertEquals(PUBLISH_TIME, message.publishTime());
    compareMessage(MESSAGE, message);
  }

  @Test
  public void testOf() {
    Message message1 = Message.of(PAYLOAD_STRING);
    assertNull(message1.getId());
    assertEquals(PAYLOAD, message1.getPayload());
    assertEquals(PAYLOAD_STRING, message1.getPayloadAsString());
    assertEquals(ImmutableMap.of(), message1.getAttributes());
    assertNull(message1.getPublishTime());
    Message message2 = Message.of(PAYLOAD);
    assertNull(message2.getId());
    assertEquals(PAYLOAD, message2.getPayload());
    assertEquals(PAYLOAD_STRING, message2.getPayloadAsString());
    assertEquals(ImmutableMap.of(), message2.getAttributes());
    assertNull(message2.getPublishTime());
    compareMessage(message1 ,message2);
  }

  @Test
  public void testToAndFromPb() {
    compareMessage(MESSAGE, Message.fromPb(MESSAGE.toPb()));
    compareMessage(MESSAGE_STRING, Message.fromPb(MESSAGE_STRING.toPb()));
  }

  @Test
  public void testToAndFromPbIncomplete() {
    Message message = Message.of(PAYLOAD_STRING);
    compareMessage(message, Message.fromPb(message.toPb()));
    message = Message.of(PAYLOAD);
    compareMessage(message, Message.fromPb(message.toPb()));
  }

  private void compareMessage(Message expected, Message value) {
    assertEquals(expected, value);
    assertEquals(expected.getId(), value.getId());
    assertEquals(expected.getPayload(), value.getPayload());
    assertEquals(expected.getPayloadAsString(), value.getPayloadAsString());
    assertEquals(expected.getAttributes(), value.getAttributes());
    assertEquals(expected.getPublishTime(), value.getPublishTime());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
