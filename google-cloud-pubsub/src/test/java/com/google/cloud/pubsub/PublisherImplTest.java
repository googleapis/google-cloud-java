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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import com.google.cloud.pubsub.Publisher.Builder;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.internal.ServerImpl;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/** Tests for {@link PublisherImpl}. */
@RunWith(JUnit4.class)
public class PublisherImplTest {

  private static final String TEST_TOPIC = "projects/test-project/topics/test-topic";

  private static InProcessChannelBuilder testChannelBuilder;

  @Captor private ArgumentCaptor<PublishRequest> requestCaptor;

  private FakeScheduledExecutorService fakeExecutor;

  private FakeCredentials testCredentials;

  private static FakePublisherServiceImpl testPublisherServiceImpl;

  private static ServerImpl testServer;

  @BeforeClass
  public static void setUpClass() throws Exception {
    testPublisherServiceImpl = Mockito.spy(new FakePublisherServiceImpl());

    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName("test-server");
    testChannelBuilder = InProcessChannelBuilder.forName("test-server");
    InProcessChannelBuilder.forName("publisher_test");
    serverBuilder.addService(testPublisherServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();
  }

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    testPublisherServiceImpl.reset();
    Mockito.reset(testPublisherServiceImpl);
    fakeExecutor = new FakeScheduledExecutorService();
    testCredentials = new FakeCredentials();
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    testServer.shutdownNow().awaitTermination();
  }

  @Test
  public void testPublishByDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setMaxBatchDuration(Duration.standardSeconds(5))
            // To demonstrate that reaching duration will trigger publish
            .setMaxBatchMessages(10)
            .build();

    testPublisherServiceImpl.addPublishResponse(
        PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"));

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ListenableFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    assertFalse(publishFuture1.isDone());
    assertFalse(publishFuture2.isDone());

    fakeExecutor.advanceTime(Duration.standardSeconds(10));

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    Mockito.verify(testPublisherServiceImpl)
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getValue().getMessagesCount());
  }

  @Test
  public void testPublishByNumBatchedMessages() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setMaxBatchDuration(Duration.standardSeconds(100))
            .setMaxBatchMessages(2)
            .build();

    testPublisherServiceImpl
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"))
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("3").addMessageIds("4"));

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ListenableFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    ListenableFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    assertFalse(publishFuture3.isDone());

    ListenableFuture<String> publishFuture4 =
        publisher.publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("D")).build());

    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getAllValues().get(0).getMessagesCount());
    assertEquals(2, requestCaptor.getAllValues().get(1).getMessagesCount());
  }

  @Test
  public void testSinglePublishByNumBytes() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setMaxBatchDuration(Duration.standardSeconds(100))
            .setMaxBatchMessages(2)
            .build();

    testPublisherServiceImpl
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"))
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("3").addMessageIds("4"));

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ListenableFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    ListenableFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());
    assertFalse(publishFuture3.isDone());

    ListenableFuture<String> publishFuture4 = sendTestMessage(publisher, "D");
    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
  }

  @Test
  public void testPublishMixedSizeAndDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setMaxBatchDuration(Duration.standardSeconds(5))
            // To demonstrate that reaching duration will trigger publish
            .setMaxBatchMessages(2)
            .build();

    testPublisherServiceImpl.addPublishResponse(
        PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("3"));

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    fakeExecutor.advanceTime(Duration.standardSeconds(2));
    assertFalse(publishFuture1.isDone());

    ListenableFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    // Publishing triggered by batch size
    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    ListenableFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    assertFalse(publishFuture3.isDone());

    // Publishing triggered by time
    fakeExecutor.advanceTime(Duration.standardSeconds(5));

    assertEquals("3", publishFuture3.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getAllValues().get(0).getMessagesCount());
    assertEquals(1, requestCaptor.getAllValues().get(1).getMessagesCount());
  }

  private ListenableFuture<String> sendTestMessage(Publisher publisher, String data) {
    return publisher.publish(
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(data)).build());
  }

  @Test
  public void testPublishFailureRetries() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutor(Executors.newSingleThreadScheduledExecutor())
            .setMaxBatchDuration(Duration.standardSeconds(5))
            .setMaxBatchMessages(1)
            .build(); // To demonstrate that reaching duration will trigger publish

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("1"));

    assertEquals("1", publishFuture1.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
  }

  @Test(expected = Throwable.class)
  public void testPublishFailureRetries_exceededsRetryDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutor(Executors.newSingleThreadScheduledExecutor())
            .setSendBatchDeadline(Duration.standardSeconds(10))
            .setMaxBatchDuration(Duration.standardSeconds(5))
            .setMaxBatchMessages(1)
            .build(); // To demonstrate that reaching duration will trigger publish

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    // With exponential backoff, starting at 5ms we should have no more than 11 retries
    for (int i = 0; i < 11; ++i) {
      testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    }

    try {
      publishFuture1.get();
    } finally {
      Mockito.verify(testPublisherServiceImpl, atLeast(10))
          .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
    }
  }

  @Test(expected = ExecutionException.class)
  public void testPublishFailureRetries_nonRetryableFailsImmediately() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutor(Executors.newSingleThreadScheduledExecutor())
            .setSendBatchDeadline(Duration.standardSeconds(10))
            .setMaxBatchDuration(Duration.standardSeconds(5))
            .setMaxBatchMessages(1)
            .build(); // To demonstrate that reaching duration will trigger publish

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    testPublisherServiceImpl.addPublishError(new StatusException(Status.INVALID_ARGUMENT));

    try {
      publishFuture1.get();
    } finally {
      Mockito.verify(testPublisherServiceImpl)
          .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
    }
  }

  @Test
  public void testPublisherGetters() throws Exception {
    FakeCredentials credentials = new FakeCredentials();
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    Publisher.Builder builder = Publisher.Builder.newBuilder(TEST_TOPIC);
    builder.setChannelBuilder(testChannelBuilder);
    builder.setCredentials(credentials);
    builder.setExecutor(executor);
    builder.setFailOnFlowControlLimits(true);
    builder.setMaxBatchBytes(10);
    builder.setMaxBatchDuration(new Duration(11));
    builder.setMaxBatchMessages(12);
    builder.setMaxOutstandingBytes(13);
    builder.setMaxOutstandingMessages(14);
    builder.setRequestTimeout(new Duration(15));
    builder.setSendBatchDeadline(new Duration(16000));
    Publisher publisher = builder.build();

    assertEquals(TEST_TOPIC, publisher.getTopic());
    assertEquals(10, publisher.getMaxBatchBytes());
    assertEquals(new Duration(11), publisher.getMaxBatchDuration());
    assertEquals(12, publisher.getMaxBatchMessages());
    assertEquals(Optional.of(13), publisher.getMaxOutstandingBytes());
    assertEquals(Optional.of(14), publisher.getMaxOutstandingMessages());
    assertTrue(publisher.failOnFlowControlLimits());
  }

  @Test
  public void testBuilderParametersAndDefaults() {
    Publisher.Builder builder = Publisher.Builder.newBuilder(TEST_TOPIC);
    assertEquals(TEST_TOPIC, builder.topic);
    assertEquals(Optional.absent(), builder.channelBuilder);
    assertEquals(Optional.absent(), builder.executor);
    assertFalse(builder.failOnFlowControlLimits);
    assertEquals(Publisher.DEFAULT_MAX_BATCH_BYTES, builder.maxBatchBytes);
    assertEquals(Publisher.DEFAULT_MAX_BATCH_DURATION, builder.maxBatchDuration);
    assertEquals(Publisher.DEFAULT_MAX_BATCH_MESSAGES, builder.maxBatchMessages);
    assertEquals(Optional.absent(), builder.maxOutstandingBytes);
    assertEquals(Optional.absent(), builder.maxOutstandingMessages);
    assertEquals(Publisher.DEFAULT_REQUEST_TIMEOUT, builder.requestTimeout);
    assertEquals(Publisher.MIN_SEND_BATCH_DURATION, builder.sendBatchDeadline);
    assertEquals(Optional.absent(), builder.userCredentials);
  }

  @Test
  public void testBuilderInvalidArguments() {
    Publisher.Builder builder = Publisher.Builder.newBuilder(TEST_TOPIC);

    try {
      builder.setChannelBuilder(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (NullPointerException expected) {
      // Expected
    }

    try {
      builder.setCredentials(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (NullPointerException expected) {
      // Expected
    }

    try {
      builder.setExecutor(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setMaxBatchBytes(0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setMaxBatchBytes(-1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setMaxBatchDuration(new Duration(1));
    try {
      builder.setMaxBatchDuration(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setMaxBatchDuration(new Duration(-1));
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setMaxBatchMessages(1);
    try {
      builder.setMaxBatchMessages(0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setMaxBatchMessages(-1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setMaxOutstandingBytes(1);
    try {
      builder.setMaxOutstandingBytes(0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setMaxOutstandingBytes(-1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setMaxOutstandingMessages(1);
    try {
      builder.setMaxOutstandingMessages(0);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setMaxOutstandingMessages(-1);
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setRequestTimeout(Publisher.MIN_REQUEST_TIMEOUT);
    try {
      builder.setRequestTimeout(Publisher.MIN_REQUEST_TIMEOUT.minus(1));
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    builder.setSendBatchDeadline(Publisher.MIN_SEND_BATCH_DURATION);
    try {
      builder.setSendBatchDeadline(Publisher.MIN_SEND_BATCH_DURATION.minus(1));
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
  }

  private Builder getTestPublisherBuilder() {
    return Publisher.Builder.newBuilder(TEST_TOPIC)
        .setCredentials(testCredentials)
        .setExecutor(fakeExecutor)
        .setChannelBuilder(testChannelBuilder);
  }
}
