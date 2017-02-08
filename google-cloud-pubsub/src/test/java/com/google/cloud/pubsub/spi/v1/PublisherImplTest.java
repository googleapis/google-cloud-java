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

import com.google.api.gax.core.RpcFuture;
import com.google.api.gax.grpc.BundlingSettings;
import com.google.api.gax.grpc.ChannelProvider;
import com.google.api.gax.grpc.ExecutorProvider;
import com.google.api.gax.grpc.FixedExecutorProvider;
import com.google.api.gax.grpc.FlowControlSettings;
import com.google.api.gax.grpc.InstantiatingExecutorProvider;
import com.google.cloud.pubsub.spi.v1.Publisher.Builder;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.internal.ServerImpl;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.joda.time.Duration;
import org.junit.After;
import org.junit.Before;
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

  private static final ExecutorProvider SINGLE_THREAD_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();

  private static final ChannelProvider TEST_CHANNEL_PROVIDER =
      new ChannelProvider() {
        @Override
        public boolean shouldAutoClose() {
          return true;
        }

        @Override
        public boolean needsExecutor() {
          return false;
        }

        @Override
        public ManagedChannel getChannel() {
          return InProcessChannelBuilder.forName("test-server").build();
        }

        @Override
        public ManagedChannel getChannel(Executor executor) {
          throw new IllegalArgumentException("testChannelprovider doesn't need an executor");
        }
      };

  @Captor private ArgumentCaptor<PublishRequest> requestCaptor;

  private FakeScheduledExecutorService fakeExecutor;

  private FakeCredentials testCredentials;

  private FakePublisherServiceImpl testPublisherServiceImpl;

  private ServerImpl testServer;

  class FakeException extends Exception {}

  @Before
  public void setUp() throws Exception {
    testPublisherServiceImpl = Mockito.spy(new FakePublisherServiceImpl());

    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName("test-server");
    serverBuilder.addService(testPublisherServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();

    MockitoAnnotations.initMocks(this);
    testPublisherServiceImpl.reset();
    Mockito.reset(testPublisherServiceImpl);
    fakeExecutor = new FakeScheduledExecutorService();
  }

  @After
  public void tearDown() throws Exception {
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

    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    RpcFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    assertFalse(publishFuture1.isDone());
    assertFalse(publishFuture2.isDone());

    fakeExecutor.advanceTime(Duration.standardSeconds(10));

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    Mockito.verify(testPublisherServiceImpl)
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getValue().getMessagesCount());
    publisher.shutdown();
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

    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    RpcFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    RpcFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    assertFalse(publishFuture3.isDone());

    RpcFuture<String> publishFuture4 =
        publisher.publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("D")).build());

    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getAllValues().get(0).getMessagesCount());
    assertEquals(2, requestCaptor.getAllValues().get(1).getMessagesCount());
    publisher.shutdown();
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

    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    RpcFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    RpcFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());
    assertFalse(publishFuture3.isDone());

    RpcFuture<String> publishFuture4 = sendTestMessage(publisher, "D");
    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    publisher.shutdown();
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

    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    fakeExecutor.advanceTime(Duration.standardSeconds(2));
    assertFalse(publishFuture1.isDone());

    RpcFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    // Publishing triggered by bundle size
    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    RpcFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    assertFalse(publishFuture3.isDone());

    // Publishing triggered by time
    fakeExecutor.advanceTime(Duration.standardSeconds(5));

    assertEquals("3", publishFuture3.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(requestCaptor.capture(), Mockito.<StreamObserver<PublishResponse>>any());
    assertEquals(2, requestCaptor.getAllValues().get(0).getMessagesCount());
    assertEquals(1, requestCaptor.getAllValues().get(1).getMessagesCount());
    publisher.shutdown();
  }

  private RpcFuture<String> sendTestMessage(Publisher publisher, String data) {
    return publisher.publish(
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(data)).build());
  }

  @Test
  public void testPublishFailureRetries() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setBundlingSettings(
                Publisher.Builder.DEFAULT_BUNDLING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1)
                    .setDelayThreshold(Duration.standardSeconds(5))
                    .build())
            .build(); // To demonstrate that reaching duration will trigger publish

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("1"));

    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    assertEquals("1", publishFuture1.get());

    Mockito.verify(testPublisherServiceImpl, times(2))
        .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
    publisher.shutdown();
  }

  public void testPublishFailureRetries_exceededsRetryDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
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

    // With exponential backoff, starting at 5ms we should have no more than 11 retries
    for (int i = 0; i < 11; ++i) {
      testPublisherServiceImpl.addPublishError(new FakeException());
    }
    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    try {
      publishFuture1.get();
    } catch (ExecutionException e) {
      if (!(e.getCause() instanceof FakeException)) {
        throw new IllegalStateException("unexpected exception", e);
      }
    } finally {
      Mockito.verify(testPublisherServiceImpl, atLeast(10))
          .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
      publisher.shutdown();
    }
  }

  @Test(expected = ExecutionException.class)
  public void testPublishFailureRetries_nonRetryableFailsImmediately() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
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

    testPublisherServiceImpl.addPublishError(new StatusException(Status.INVALID_ARGUMENT));
    RpcFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    try {
      publishFuture1.get();
    } finally {
      Mockito.verify(testPublisherServiceImpl)
          .publish(Mockito.<PublishRequest>any(), Mockito.<StreamObserver<PublishResponse>>any());
      publisher.shutdown();
    }
  }

  @Test
  public void testPublisherGetters() throws Exception {
    Publisher.Builder builder = Publisher.newBuilder(TEST_TOPIC);
    builder.setChannelProvider(TEST_CHANNEL_PROVIDER);
    builder.setExecutorProvider(SINGLE_THREAD_EXECUTOR);
    builder.setFailOnFlowControlLimits(true);
    builder.setBundlingSettings(
        BundlingSettings.newBuilder()
            .setRequestByteThreshold(10)
            .setDelayThreshold(new Duration(11))
            .setElementCountThreshold(12)
            .build());
    builder.setFlowControlSettings(
        FlowControlSettings.newBuilder()
            .setMaxOutstandingRequestBytes(13)
            .setMaxOutstandingElementCount(14)
            .build());
    Publisher publisher = builder.build();

    assertEquals(TEST_TOPIC, publisher.getTopicName());
    assertEquals(10, (long) publisher.getBundlingSettings().getRequestByteThreshold());
    assertEquals(new Duration(11), publisher.getBundlingSettings().getDelayThreshold());
    assertEquals(12, (long) publisher.getBundlingSettings().getElementCountThreshold());
    assertEquals(13, (long) publisher.getFlowControlSettings().getMaxOutstandingRequestBytes());
    assertEquals(14, (long) publisher.getFlowControlSettings().getMaxOutstandingElementCount());
    assertTrue(publisher.failOnFlowControlLimits());
    publisher.shutdown();
  }

  @Test
  public void testBuilderParametersAndDefaults() {
    Publisher.Builder builder = Publisher.newBuilder(TEST_TOPIC);
    assertEquals(TEST_TOPIC, builder.topicName);
    assertEquals(Publisher.Builder.DEFAULT_EXECUTOR_PROVIDER, builder.executorProvider);
    assertFalse(builder.failOnFlowControlLimits);
    assertEquals(
        Publisher.Builder.DEFAULT_REQUEST_BYTES_THRESHOLD,
        builder.bundlingSettings.getRequestByteThreshold().longValue());
    assertEquals(
        Publisher.Builder.DEFAULT_DELAY_THRESHOLD, builder.bundlingSettings.getDelayThreshold());
    assertEquals(
        Publisher.Builder.DEFAULT_ELEMENT_COUNT_THRESHOLD,
        builder.bundlingSettings.getElementCountThreshold().longValue());
    assertEquals(FlowControlSettings.getDefaultInstance(), builder.flowControlSettings);
    assertEquals(Publisher.Builder.DEFAULT_RETRY_SETTINGS, builder.retrySettings);
  }

  @Test
  public void testBuilderInvalidArguments() {
    Publisher.Builder builder = Publisher.newBuilder(TEST_TOPIC);

    try {
      builder.setChannelProvider(null);
      fail("Should have thrown an IllegalArgumentException");
    } catch (NullPointerException expected) {
      // Expected
    }

    try {
      builder.setExecutorProvider(null);
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
        FlowControlSettings.getDefaultInstance()
            .toBuilder()
            .setMaxOutstandingRequestBytes(1)
            .build());
    try {
      builder.setFlowControlSettings(
          FlowControlSettings.getDefaultInstance()
              .toBuilder()
              .setMaxOutstandingRequestBytes(0)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setFlowControlSettings(
          FlowControlSettings.getDefaultInstance()
              .toBuilder()
              .setMaxOutstandingRequestBytes(-1)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setFlowControlSettings(
        FlowControlSettings.getDefaultInstance()
            .toBuilder()
            .setMaxOutstandingElementCount(1)
            .build());
    try {
      builder.setFlowControlSettings(
          FlowControlSettings.getDefaultInstance()
              .toBuilder()
              .setMaxOutstandingElementCount(0)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setFlowControlSettings(
          FlowControlSettings.getDefaultInstance()
              .toBuilder()
              .setMaxOutstandingElementCount(-1)
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
    return Publisher.newBuilder(TEST_TOPIC)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(TEST_CHANNEL_PROVIDER)
        .setLongRandom(
            new Publisher.LongRandom() {
              @Override
              public long nextLong(long least, long bound) {
                return bound - 1;
              }
            });
  }
}
