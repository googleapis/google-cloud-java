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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import com.google.api.client.util.Charsets;
import com.google.cloud.ByteArray;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.Futures;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class ReceivedMessageTest {

  private static final String SUBSCRIPTION = "subscription";
  private static final String ACK_ID = "ackId";
  private static final String MESSAGE_ID = "messageId";
  private static final String PAYLOAD_STRING = "payload";
  private static final ByteArray PAYLOAD =
      ByteArray.copyFrom("payload".getBytes(StandardCharsets.UTF_8));
  private static final Map<String, String> ATTRIBUTES =
      ImmutableMap.of("key1", "value1", "key2", "value2");
  private static final Long PUBLISH_TIME = 42L;
  private static final Message MESSAGE = Message.builder(PAYLOAD)
      .id(MESSAGE_ID)
      .attributes(ATTRIBUTES)
      .publishTime(PUBLISH_TIME)
      .build();
  private static final com.google.pubsub.v1.ReceivedMessage RECEIVED_MESSAGE_PB =
      com.google.pubsub.v1.ReceivedMessage.newBuilder()
          .setMessage(MESSAGE.toPb())
          .setAckId(ACK_ID)
          .build();

  private final PubSub serviceMockReturnsOptions = createStrictMock(PubSub.class);
  private final PubSubOptions mockOptions = createMock(PubSubOptions.class);
  private PubSub pubsub;
  private ReceivedMessage expectedMessage;
  private ReceivedMessage message;

  private void initializeExpectedMessage(int optionsCalls) {
    expect(serviceMockReturnsOptions.options()).andReturn(mockOptions).times(optionsCalls);
    replay(serviceMockReturnsOptions);
    pubsub = createStrictMock(PubSub.class);
    expectedMessage =
        ReceivedMessage.fromPb(serviceMockReturnsOptions, SUBSCRIPTION, RECEIVED_MESSAGE_PB);
  }

  private void initializeMessage() {
    message = ReceivedMessage.fromPb(pubsub, SUBSCRIPTION, RECEIVED_MESSAGE_PB);
  }

  @After
  public void tearDown() throws Exception {
    verify(pubsub, serviceMockReturnsOptions);
  }

  @Test
  public void testBuilder() {
    initializeExpectedMessage(3);
    replay(pubsub);
    Map<String, String> attributes = ImmutableMap.of("newKey1", "newVal1");
    ReceivedMessage builtMessage = expectedMessage.toBuilder()
        .payload("newPayload")
        .id("newMessageId")
        .attributes(attributes)
        .publishTime(PUBLISH_TIME + 1)
        .build();
    assertSame(serviceMockReturnsOptions, builtMessage.pubsub());
    assertEquals(SUBSCRIPTION, builtMessage.subscription());
    assertEquals(ACK_ID, builtMessage.ackId());
    assertEquals("newMessageId", builtMessage.id());
    assertArrayEquals("newPayload".getBytes(Charsets.UTF_8), builtMessage.payload().toByteArray());
    assertEquals("newPayload", builtMessage.payloadAsString());
    assertEquals(attributes, builtMessage.attributes());
    assertEquals(PUBLISH_TIME + 1, (long) builtMessage.publishTime());
    builtMessage = builtMessage.toBuilder()
        .payload(PAYLOAD)
        .id(MESSAGE_ID)
        .clearAttributes()
        .addAttribute("key1", "value1")
        .addAttribute("key2", "value2")
        .publishTime(PUBLISH_TIME)
        .build();
    assertSame(serviceMockReturnsOptions, builtMessage.pubsub());
    assertEquals(MESSAGE_ID, builtMessage.id());
    assertEquals(PAYLOAD, builtMessage.payload());
    assertEquals(PAYLOAD_STRING, builtMessage.payloadAsString());
    assertEquals(ATTRIBUTES, builtMessage.attributes());
    assertEquals(PUBLISH_TIME, builtMessage.publishTime());
    compareReceivedMessage(expectedMessage, builtMessage);
  }

  @Test
  public void testToBuilder() {
    initializeExpectedMessage(2);
    replay(pubsub);
    compareReceivedMessage(expectedMessage, expectedMessage.toBuilder().build());
  }

  @Test
  public void testAck() {
    initializeExpectedMessage(1);
    expect(pubsub.options()).andReturn(mockOptions);
    pubsub.ack(SUBSCRIPTION, ACK_ID);
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeMessage();
    message.ack();
  }

  @Test
  public void testAckAsync() throws ExecutionException, InterruptedException {
    initializeExpectedMessage(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.ackAsync(SUBSCRIPTION, ACK_ID)).andReturn(Futures.<Void>immediateFuture(null));
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeMessage();
    assertNull(message.ackAsync().get());
  }

  @Test
  public void testModifyAckDeadline() {
    initializeExpectedMessage(1);
    expect(pubsub.options()).andReturn(mockOptions);
    pubsub.modifyAckDeadline(SUBSCRIPTION, 10, TimeUnit.SECONDS, ACK_ID);
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeMessage();
    message.modifyAckDeadline(10, TimeUnit.SECONDS);
  }

  @Test
  public void testModifyAckDeadlineAsync() throws ExecutionException, InterruptedException {
    initializeExpectedMessage(1);
    expect(pubsub.options()).andReturn(mockOptions);
    expect(pubsub.modifyAckDeadlineAsync(SUBSCRIPTION, 10, TimeUnit.SECONDS, ACK_ID))
        .andReturn(Futures.<Void>immediateFuture(null));
    EasyMock.expectLastCall();
    replay(pubsub);
    initializeMessage();
    assertNull(message.modifyAckDeadlineAsync(10, TimeUnit.SECONDS).get());
  }

  private void compareReceivedMessage(ReceivedMessage expected, ReceivedMessage value) {
    assertEquals(expected, value);
    assertEquals(expected.id(), value.id());
    assertEquals(expected.payload(), value.payload());
    assertEquals(expected.payloadAsString(), value.payloadAsString());
    assertEquals(expected.attributes(), value.attributes());
    assertEquals(expected.publishTime(), value.publishTime());
    assertEquals(expected.ackId(), value.ackId());
    assertEquals(expected.subscription(), value.subscription());
    assertEquals(expected.hashCode(), value.hashCode());
  }
}
