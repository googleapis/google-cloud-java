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

package com.google.cloud.pubsub;

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
  private static final Message MESSAGE_STRING = Message.builder(PAYLOAD_STRING)
      .id(MESSAGE_ID)
      .attributes(ATTRIBUTES)
      .publishTime(PUBLISH_TIME)
      .build();
  private static final Message MESSAGE = Message.builder(PAYLOAD)
      .id(MESSAGE_ID)
      .attributes(ATTRIBUTES)
      .publishTime(PUBLISH_TIME)
      .build();

  @Test
  public void testToBuilder() {
    compareMessage(MESSAGE, MESSAGE.toBuilder().build());
    Message message = MESSAGE.toBuilder()
        .payload("newPayload")
        .clearAttributes()
        .addAttribute("key1", "value1")
        .build();
    assertEquals("newPayload", message.payloadAsString());
    assertEquals(ImmutableMap.of("key1", "value1"), message.attributes());
    message = message.toBuilder()
        .payload(PAYLOAD_STRING)
        .removeAttribute("key1")
        .attributes(ATTRIBUTES)
        .build();
    compareMessage(MESSAGE, message);
  }

  @Test
  public void testBuilder() {
    assertEquals(MESSAGE_ID, MESSAGE.id());
    assertEquals(PAYLOAD, MESSAGE.payload());
    assertEquals(PAYLOAD_STRING, MESSAGE.payloadAsString());
    assertEquals(ATTRIBUTES, MESSAGE.attributes());
    assertEquals(PUBLISH_TIME, MESSAGE.publishTime());
    assertEquals(MESSAGE_ID, MESSAGE_STRING.id());
    assertEquals(PAYLOAD, MESSAGE_STRING.payload());
    assertEquals(PAYLOAD_STRING, MESSAGE_STRING.payloadAsString());
    assertEquals(ATTRIBUTES, MESSAGE_STRING.attributes());
    assertEquals(PUBLISH_TIME, MESSAGE_STRING.publishTime());
    compareMessage(MESSAGE, MESSAGE_STRING);
    Message message = Message.builder(PAYLOAD)
        .id(MESSAGE_ID)
        .attributes(ATTRIBUTES)
        .clearAttributes()
        .addAttribute("key1", "value1")
        .addAttribute("key2", "value2")
        .publishTime(PUBLISH_TIME)
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
    assertNull(message1.id());
    assertEquals(PAYLOAD, message1.payload());
    assertEquals(PAYLOAD_STRING, message1.payloadAsString());
    assertEquals(ImmutableMap.of(), message1.attributes());
    assertNull(message1.publishTime());
    Message message2 = Message.of(PAYLOAD);
    assertNull(message2.id());
    assertEquals(PAYLOAD, message2.payload());
    assertEquals(PAYLOAD_STRING, message2.payloadAsString());
    assertEquals(ImmutableMap.of(), message2.attributes());
    assertNull(message2.publishTime());
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
    assertEquals(expected.id(), value.id());
    assertEquals(expected.payload(), value.payload());
    assertEquals(expected.payloadAsString(), value.payloadAsString());
    assertEquals(expected.attributes(), value.attributes());
    assertEquals(expected.publishTime(), value.publishTime());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
