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

package com.google.cloud.pubsub.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;

import com.google.api.gax.bundling.FlowController;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.cloud.pubsub.spi.v1.Publisher.Builder;
import com.google.common.base.Optional;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
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

  private static final TopicName TEST_TOPIC = TopicName.create("test-project", "test-topic");

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
            // To demonstrate that reaching duration will trigger publish
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .setElementCountThreshold(10)
                    .build())
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
  public void testPublishByNumBundledMessages() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2)
                    .setDelayThreshold(Duration.standardSeconds(100))
                    .build())
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
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2)
                    .setDelayThreshold(Duration.standardSeconds(100))
                    .build())
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
            // To demonstrate that reaching duration will trigger publish
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2)
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .build())
            .build();

    testPublisherServiceImpl.addPublishResponse(
        PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("3"));

    ListenableFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    fakeExecutor.advanceTime(Duration.standardSeconds(2));
    assertFalse(publishFuture1.isDone());

    ListenableFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    // Publishing triggered by bundle size
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
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1)
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .build())
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
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.standardSeconds(10))
                    .build())
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1)
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .build())
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
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.standardSeconds(10))
                    .build())
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1)
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .build())
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
    builder.setBundlingSettings(
        BundlingSettings.newBuilder()
            .setRequestByteThreshold(10)
            .setDelayThreshold(new Duration(11))
            .setElementCountThreshold(12)
            .build());
    builder.setFlowControlSettings(
        FlowController.Settings.newBuilder()
            .setMaxOutstandingRequestBytes(Optional.of(13))
            .setMaxOutstandingElementCount(Optional.of(14))
            .build());
    Publisher publisher = builder.build();

    assertEquals(TEST_TOPIC.toString(), publisher.getTopic());
    assertEquals(10, publisher.getMaxBundleBytes());
    assertEquals(new Duration(11), publisher.getMaxBundleDuration());
    assertEquals(12, publisher.getMaxBundleMessages());
    assertEquals(Optional.of(13), publisher.getMaxOutstandingRequestBytes());
    assertEquals(Optional.of(14), publisher.getMaxOutstandingElementCount());
    assertTrue(publisher.failOnFlowControlLimits());
  }

  @Test
  public void testBuilderParametersAndDefaults() {
    Publisher.Builder builder = Publisher.Builder.newBuilder(TEST_TOPIC);
    assertEquals(TEST_TOPIC.toString(), builder.topic);
    assertEquals(Optional.absent(), builder.channelBuilder);
    assertEquals(Optional.absent(), builder.executor);
    assertFalse(builder.failOnFlowControlLimits);
    assertEquals(
        Publisher.Builder.DEFAULT_REQUEST_BYTES_THRESHOLD,
        builder.bundlingSettings.getRequestByteThreshold().longValue());
    assertEquals(
        Publisher.Builder.DEFAULT_DELAY_THRESHOLD, builder.bundlingSettings.getDelayThreshold());
    assertEquals(
        Publisher.Builder.DEFAULT_ELEMENT_COUNT_THRESHOLD,
        builder.bundlingSettings.getElementCountThreshold().longValue());
    assertEquals(FlowController.Settings.DEFAULT, builder.flowControlSettings);
    assertEquals(Publisher.Builder.DEFAULT_RETRY_SETTINGS, builder.retrySettings);
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
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold((Long) null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(0)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(-1)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBundlingSettings(
        Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
            .toBuilder()
            .setDelayThreshold(new Duration(1))
            .build());
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS.toBuilder().setDelayThreshold(null).build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setDelayThreshold(new Duration(-1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBundlingSettings(
        Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
            .toBuilder()
            .setElementCountThreshold(1)
            .build());
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setElementCountThreshold((Long) null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(0)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBundlingSettings(
          Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(-1)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setFlowControlSettings(
        FlowController.Settings.DEFAULT
            .toBuilder()
            .setMaxOutstandingRequestBytes(Optional.of(1))
            .build());
    try {
      builder.setFlowControlSettings(
          FlowController.Settings.DEFAULT
              .toBuilder()
              .setMaxOutstandingRequestBytes(Optional.of(0))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setFlowControlSettings(
          FlowController.Settings.DEFAULT
              .toBuilder()
              .setMaxOutstandingRequestBytes(Optional.of(-1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setFlowControlSettings(
        FlowController.Settings.DEFAULT
            .toBuilder()
            .setMaxOutstandingElementCount(Optional.of(1))
            .build());
    try {
      builder.setFlowControlSettings(
          FlowController.Settings.DEFAULT
              .toBuilder()
              .setMaxOutstandingElementCount(Optional.of(0))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setFlowControlSettings(
          FlowController.Settings.DEFAULT
              .toBuilder()
              .setMaxOutstandingElementCount(Optional.of(-1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setRetrySettings(
        Publisher.Builder.DEFAULT_RETRY_SETTINGS
            .toBuilder()
            .setInitialRpcTimeout(Publisher.Builder.MIN_RPC_TIMEOUT)
            .build());
    try {
      builder.setRetrySettings(
          Publisher.Builder.DEFAULT_RETRY_SETTINGS
              .toBuilder()
              .setInitialRpcTimeout(Publisher.Builder.MIN_RPC_TIMEOUT.minus(1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    builder.setRetrySettings(
        Publisher.Builder.DEFAULT_RETRY_SETTINGS
            .toBuilder()
            .setTotalTimeout(Publisher.Builder.MIN_TOTAL_TIMEOUT)
            .build());
    try {
      builder.setRetrySettings(
          Publisher.Builder.DEFAULT_RETRY_SETTINGS
              .toBuilder()
              .setTotalTimeout(Publisher.Builder.MIN_TOTAL_TIMEOUT.minus(1))
              .build());
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
