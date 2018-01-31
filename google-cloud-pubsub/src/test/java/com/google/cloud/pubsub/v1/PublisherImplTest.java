/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.pubsub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.pubsub.v1.Publisher.Builder;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.TopicName;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JUnit4.class)
public class PublisherImplTest {

  private static final TopicName TEST_TOPIC = TopicName.of("test-project", "test-topic");

  private static final ExecutorProvider SINGLE_THREAD_EXECUTOR =
      InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build();

  private static final TransportChannelProvider TEST_CHANNEL_PROVIDER =
      new TransportChannelProvider() {
        @Override
        public boolean shouldAutoClose() {
          return true;
        }

        @Override
        public boolean needsExecutor() {
          return false;
        }

        @Override
        public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
          return null;
        }

        @Override
        public boolean needsHeaders() {
          return false;
        }

        @Override
        public TransportChannelProvider withHeaders(Map<String, String> headers) {
          return null;
        }

        @Override
        public boolean needsEndpoint() {
          return false;
        }

        @Override
        public TransportChannelProvider withEndpoint(String endpoint) {
          return null;
        }

        @Override
        public TransportChannel getTransportChannel() throws IOException {
          return GrpcTransportChannel.create(InProcessChannelBuilder.forName("test-server").build());
        }

        @Override
        public String getTransportName() {
          return null;
        }

      };

  private FakeScheduledExecutorService fakeExecutor;

  private FakePublisherServiceImpl testPublisherServiceImpl;

  private Server testServer;

  class FakeException extends Exception {}

  @Before
  public void setUp() throws Exception {
    testPublisherServiceImpl = new FakePublisherServiceImpl();

    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName("test-server");
    serverBuilder.addService(testPublisherServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();

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
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .setElementCountThreshold(10L)
                    .build())
            .build();

    testPublisherServiceImpl.addPublishResponse(
        PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ApiFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    assertFalse(publishFuture1.isDone());
    assertFalse(publishFuture2.isDone());

    fakeExecutor.advanceTime(Duration.ofSeconds(10));

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().get(0).getMessagesCount());
    publisher.shutdown();
  }

  @Test
  public void testPublishByNumBatchedMessages() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(100))
                    .build())
            .build();

    testPublisherServiceImpl
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"))
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("3").addMessageIds("4"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ApiFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    ApiFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    assertFalse(publishFuture3.isDone());

    ApiFuture<String> publishFuture4 =
        publisher.publish(PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8("D")).build());

    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().get(0).getMessagesCount());
    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().get(1).getMessagesCount());
    publisher.shutdown();
  }

  @Test
  public void testSinglePublishByNumBytes() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(100))
                    .build())
            .build();

    testPublisherServiceImpl
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"))
        .addPublishResponse(PublishResponse.newBuilder().addMessageIds("3").addMessageIds("4"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");
    ApiFuture<String> publishFuture2 = sendTestMessage(publisher, "B");
    ApiFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    // Note we are not advancing time but message should still get published

    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());
    assertFalse(publishFuture3.isDone());

    ApiFuture<String> publishFuture4 = sendTestMessage(publisher, "D");
    assertEquals("3", publishFuture3.get());
    assertEquals("4", publishFuture4.get());

    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().size());
    publisher.shutdown();
  }

  @Test
  public void testPublishMixedSizeAndDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            // To demonstrate that reaching duration will trigger publish
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(2L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build();

    testPublisherServiceImpl.addPublishResponse(
        PublishResponse.newBuilder().addMessageIds("1").addMessageIds("2"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("3"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    fakeExecutor.advanceTime(Duration.ofSeconds(2));
    assertFalse(publishFuture1.isDone());

    ApiFuture<String> publishFuture2 = sendTestMessage(publisher, "B");

    // Publishing triggered by batch size
    assertEquals("1", publishFuture1.get());
    assertEquals("2", publishFuture2.get());

    ApiFuture<String> publishFuture3 = sendTestMessage(publisher, "C");

    assertFalse(publishFuture3.isDone());

    // Publishing triggered by time
    fakeExecutor.advanceTime(Duration.ofSeconds(5));

    assertEquals("3", publishFuture3.get());

    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().get(0).getMessagesCount());
    assertEquals(1, testPublisherServiceImpl.getCapturedRequests().get(1).getMessagesCount());
    publisher.shutdown();
  }

  private ApiFuture<String> sendTestMessage(Publisher publisher, String data) {
    return publisher.publish(
        PubsubMessage.newBuilder().setData(ByteString.copyFromUtf8(data)).build());
  }

  @Test
  public void testPublishFailureRetries() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build(); // To demonstrate that reaching duration will trigger publish

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("1"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    assertEquals("1", publishFuture1.get());

    assertEquals(2, testPublisherServiceImpl.getCapturedRequests().size());
    publisher.shutdown();
  }

  @Test(expected = ExecutionException.class)
  public void testPublishFailureRetries_retriesDisabled() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.ofSeconds(10))
                    .setMaxAttempts(1)
                    .build())
            .build();

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    try {
      publishFuture1.get();
    } finally {
      assertSame(testPublisherServiceImpl.getCapturedRequests().size(), 1);
      publisher.shutdown();
    }
  }

  @Test
  public void testPublishFailureRetries_maxRetriesSetup() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.ofSeconds(10))
                    .setMaxAttempts(3)
                    .build())
            .build();

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("1"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    assertEquals("1", publishFuture1.get());

    assertEquals(3, testPublisherServiceImpl.getCapturedRequests().size());
    publisher.shutdown();
  }

  @Test
  public void testPublishFailureRetries_maxRetriesSetUnlimited() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.ofSeconds(10))
                    .setMaxAttempts(0)
                    .build())
            .build();

    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishError(new Throwable("Transiently failing"));
    testPublisherServiceImpl.addPublishResponse(PublishResponse.newBuilder().addMessageIds("1"));

    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    assertEquals("1", publishFuture1.get());

    assertEquals(3, testPublisherServiceImpl.getCapturedRequests().size());
    publisher.shutdown();
  }

  public void testPublishFailureRetries_exceededsRetryDuration() throws Exception {
    Publisher publisher =
        getTestPublisherBuilder()
            .setExecutorProvider(SINGLE_THREAD_EXECUTOR)
            .setRetrySettings(
                Publisher.Builder.DEFAULT_RETRY_SETTINGS
                    .toBuilder()
                    .setTotalTimeout(Duration.ofSeconds(10))
                    .build())
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build(); // To demonstrate that reaching duration will trigger publish

    // With exponential backoff, starting at 5ms we should have no more than 11 retries
    for (int i = 0; i < 11; ++i) {
      testPublisherServiceImpl.addPublishError(new FakeException());
    }
    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    try {
      publishFuture1.get();
    } catch (ExecutionException e) {
      if (!(e.getCause() instanceof FakeException)) {
        throw new IllegalStateException("unexpected exception", e);
      }
    } finally {
      assertTrue(testPublisherServiceImpl.getCapturedRequests().size() >= 10);
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
                    .setTotalTimeout(Duration.ofSeconds(10))
                    .build())
            .setBatchingSettings(
                Publisher.Builder.DEFAULT_BATCHING_SETTINGS
                    .toBuilder()
                    .setElementCountThreshold(1L)
                    .setDelayThreshold(Duration.ofSeconds(5))
                    .build())
            .build(); // To demonstrate that reaching duration will trigger publish

    testPublisherServiceImpl.addPublishError(new StatusException(Status.INVALID_ARGUMENT));
    ApiFuture<String> publishFuture1 = sendTestMessage(publisher, "A");

    try {
      publishFuture1.get();
    } finally {
      assertTrue(testPublisherServiceImpl.getCapturedRequests().size() >= 1);
      publisher.shutdown();
    }
  }

  @Test
  public void testPublisherGetters() throws Exception {
    Publisher.Builder builder = Publisher.newBuilder(TEST_TOPIC);
    builder.setChannelProvider(TEST_CHANNEL_PROVIDER);
    builder.setExecutorProvider(SINGLE_THREAD_EXECUTOR);
    builder.setBatchingSettings(
        BatchingSettings.newBuilder()
            .setRequestByteThreshold(10L)
            .setDelayThreshold(Duration.ofMillis(11))
            .setElementCountThreshold(12L)
            .build());
    builder.setCredentialsProvider(NoCredentialsProvider.create());
    Publisher publisher = builder.build();

    assertEquals(TEST_TOPIC, publisher.getTopicName());
    assertEquals(10, (long) publisher.getBatchingSettings().getRequestByteThreshold());
    assertEquals(Duration.ofMillis(11), publisher.getBatchingSettings().getDelayThreshold());
    assertEquals(12, (long) publisher.getBatchingSettings().getElementCountThreshold());
    publisher.shutdown();
  }

  @Test
  public void testBuilderParametersAndDefaults() {
    Publisher.Builder builder = Publisher.newBuilder(TEST_TOPIC);
    assertEquals(TEST_TOPIC, builder.topicName);
    assertEquals(Publisher.Builder.DEFAULT_EXECUTOR_PROVIDER, builder.executorProvider);
    assertEquals(
        Publisher.Builder.DEFAULT_REQUEST_BYTES_THRESHOLD,
        builder.batchingSettings.getRequestByteThreshold().longValue());
    assertEquals(
        Publisher.Builder.DEFAULT_DELAY_THRESHOLD, builder.batchingSettings.getDelayThreshold());
    assertEquals(
        Publisher.Builder.DEFAULT_ELEMENT_COUNT_THRESHOLD,
        builder.batchingSettings.getElementCountThreshold().longValue());
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
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold((Long) null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(0L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setRequestByteThreshold(-1L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBatchingSettings(
        Publisher.Builder.DEFAULT_BATCHING_SETTINGS
            .toBuilder()
            .setDelayThreshold(Duration.ofMillis(1))
            .build());
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS.toBuilder().setDelayThreshold(null).build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setDelayThreshold(Duration.ofMillis(-1))
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }

    builder.setBatchingSettings(
        Publisher.Builder.DEFAULT_BATCHING_SETTINGS
            .toBuilder()
            .setElementCountThreshold(1L)
            .build());
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold((Long) null)
              .build());
      fail("Should have thrown an NullPointerException");
    } catch (NullPointerException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(0L)
              .build());
      fail("Should have thrown an IllegalArgumentException");
    } catch (IllegalArgumentException expected) {
      // Expected
    }
    try {
      builder.setBatchingSettings(
          Publisher.Builder.DEFAULT_BATCHING_SETTINGS
              .toBuilder()
              .setElementCountThreshold(-1L)
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
              .setInitialRpcTimeout(Publisher.Builder.MIN_RPC_TIMEOUT.minusMillis(1))
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
              .setTotalTimeout(Publisher.Builder.MIN_TOTAL_TIMEOUT.minusMillis(1))
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
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setLongRandom(
            new Publisher.LongRandom() {
              @Override
              public long nextLong(long least, long bound) {
                return bound - 1;
              }
            });
  }
}
