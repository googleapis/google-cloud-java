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

import static org.junit.Assert.*;

import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.*;
import com.google.cloud.pubsub.v1.Subscriber.Builder;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import java.time.Duration;
import java.util.concurrent.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

/** Tests for {@link Subscriber}. */
public class SubscriberTest {

  private static final ProjectSubscriptionName TEST_SUBSCRIPTION =
      ProjectSubscriptionName.of("test-project", "test-subscription");

  private ManagedChannel testChannel;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeSubscriberServiceImpl fakeSubscriberServiceImpl;
  private Server testServer;
  private LinkedBlockingQueue<AckReplyConsumerWithResponse> consumersWithResponse;
  private MessageReceiverWithAckResponse messageReceiverWithAckResponse;

  private final MessageReceiver testReceiver =
      new MessageReceiver() {
        @Override
        public void receiveMessage(PubsubMessage message, AckReplyConsumer consumer) {
          consumer.ack();
        }
      };

  @Rule public TestName testName = new TestName();

  @Before
  public void setUp() throws Exception {
    consumersWithResponse = new LinkedBlockingQueue<>();
    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(testName.getMethodName());
    fakeSubscriberServiceImpl = new FakeSubscriberServiceImpl();
    fakeExecutor = new FakeScheduledExecutorService();
    testChannel = InProcessChannelBuilder.forName(testName.getMethodName()).build();
    serverBuilder.addService(fakeSubscriberServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();

    messageReceiverWithAckResponse =
        new MessageReceiverWithAckResponse() {
          @Override
          public void receiveMessage(
              final PubsubMessage message,
              final AckReplyConsumerWithResponse consumerWithResponse) {
            consumersWithResponse.add(consumerWithResponse);
          }
        };
  }

  @After
  public void tearDown() throws Exception {
    testServer.shutdownNow().awaitTermination();
    testChannel.shutdown();
  }

  @Test
  public void testDeliveryAttemptHelper() {
    Integer deliveryAttempt = 3;
    PubsubMessage message =
        PubsubMessage.newBuilder()
            .putAttributes("googclient_deliveryattempt", Integer.toString(deliveryAttempt))
            .build();
    assertEquals(Subscriber.getDeliveryAttempt(message), deliveryAttempt);

    // In the case where delivery attempt attribute is not populated, expect null
    PubsubMessage emptyMessage = PubsubMessage.newBuilder().build();
    assertEquals(Subscriber.getDeliveryAttempt(emptyMessage), null);
  }

  @Test
  public void testOpenedChannels() throws Exception {
    int expectedChannelCount = 1;

    Subscriber subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));

    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testFailedChannel_recoverableError_channelReopened() throws Exception {
    int expectedChannelCount = 1;

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSystemExecutorProvider(
                    InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(1).build()));

    // Recoverable error
    fakeSubscriberServiceImpl.sendError(new StatusException(Status.INTERNAL));

    assertEquals(1, fakeSubscriberServiceImpl.waitForClosedStreams(1));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testFailedChannel_testTerminated() throws Exception {
    final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    ExecutorProvider provider =
        new ExecutorProvider() {
          @Override
          public boolean shouldAutoClose() {
            return true;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return scheduledExecutorService;
          }
        };

    try {
      Subscriber subscriber =
          startSubscriber(
              getTestSubscriberBuilder(testReceiver).setSystemExecutorProvider(provider));

      // wait long enough for the MessageDispatcher to set up, which at one point
      // caused shutdown problems.
      Thread.sleep(100);
      subscriber.stopAsync().awaitTerminated();

      assertTrue(scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS));
    } finally {
      scheduledExecutorService.shutdownNow();
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testFailedChannel_fatalError_subscriberFails() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSystemExecutorProvider(
                    InstantiatingExecutorProvider.newBuilder().setExecutorThreadCount(10).build()));

    // Fatal error
    fakeSubscriberServiceImpl.sendError(new StatusException(Status.INVALID_ARGUMENT));

    try {
      subscriber.awaitTerminated();
    } finally {
      // The subscriber must finish with an state error because its FAILED status.
      assertEquals(Subscriber.State.FAILED, subscriber.state());

      Throwable t = subscriber.failureCause();
      assertTrue(t instanceof ApiException);

      ApiException ex = (ApiException) (t);
      assertTrue(ex.getStatusCode() instanceof GrpcStatusCode);

      GrpcStatusCode grpcCode = (GrpcStatusCode) ex.getStatusCode();
      assertEquals(StatusCode.Code.INVALID_ARGUMENT, grpcCode.getCode());
    }
  }

  @Test(expected = IllegalStateException.class)
  public void testFailedChannel_shutdownBackgroundResources() throws Exception {
    ExecutorProvider provider =
        new ExecutorProvider() {
          @Override
          public boolean shouldAutoClose() {
            return true;
          }

          @Override
          public ScheduledExecutorService getExecutor() {
            return fakeExecutor;
          }
        };

    Subscriber subscriber =
        startSubscriber(getTestSubscriberBuilder(testReceiver).setExecutorProvider(provider));

    // Fatal error
    fakeSubscriberServiceImpl.sendError(new StatusException(Status.INVALID_ARGUMENT));

    try {
      subscriber.awaitTerminated();
    } finally {
      // The subscriber must finish with an state error because its FAILED status.
      assertEquals(Subscriber.State.FAILED, subscriber.state());

      // Make sure that our executor is shut down after a failure
      assertTrue(fakeExecutor.isShutdown());
    }
  }

  @Test
  public void testStreamAckDeadlineIsSetCorrectly() throws Exception {
    int expectedChannelCount = 1;
    // Deadline is smaller than the allowed streamAckDeadline.
    int maxDurationPerAckExtension = 5;

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setMaxDurationPerAckExtensionDuration(
                    Duration.ofSeconds(maxDurationPerAckExtension)));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));
    assertEquals(
        Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()),
        fakeSubscriberServiceImpl.getLastSeenRequest().getStreamAckDeadlineSeconds());

    subscriber.stopAsync().awaitTerminated();

    // Deadline is higher than the allowed streamAckDeadline.
    maxDurationPerAckExtension = 700;
    subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setMaxDurationPerAckExtensionDuration(
                    Duration.ofSeconds(maxDurationPerAckExtension)));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));
    assertEquals(
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()),
        fakeSubscriberServiceImpl.getLastSeenRequest().getStreamAckDeadlineSeconds());

    subscriber.stopAsync().awaitTerminated();

    // Deadline is within the allowed limits for streamAckDeadline.
    maxDurationPerAckExtension = 100;
    subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setMaxDurationPerAckExtensionDuration(
                    Duration.ofSeconds(maxDurationPerAckExtension)));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));
    assertEquals(
        maxDurationPerAckExtension,
        fakeSubscriberServiceImpl.getLastSeenRequest().getStreamAckDeadlineSeconds());

    subscriber.stopAsync().awaitTerminated();

    // maxDurationPerAckExtension is unset.
    subscriber = startSubscriber(getTestSubscriberBuilder(testReceiver));
    assertEquals(
        expectedChannelCount, fakeSubscriberServiceImpl.waitForOpenedStreams(expectedChannelCount));
    assertEquals(
        Math.toIntExact(Subscriber.STREAM_ACK_DEADLINE_DEFAULT.getSeconds()),
        fakeSubscriberServiceImpl.getLastSeenRequest().getStreamAckDeadlineSeconds());

    subscriber.stopAsync().awaitTerminated();
  }

  @Test
  public void testPartialFlowControlSettings() throws Exception {
    Subscriber subscriber =
        getTestSubscriberBuilder(testReceiver)
            .setFlowControlSettings(
                Subscriber.Builder.DEFAULT_FLOW_CONTROL_SETTINGS.toBuilder()
                    .setMaxOutstandingElementCount(500L)
                    .build())
            .build();
    assertEquals((long) subscriber.getFlowControlSettings().getMaxOutstandingElementCount(), 500);
    assertEquals(
        subscriber.getFlowControlSettings().getMaxOutstandingRequestBytes(),
        Subscriber.Builder.DEFAULT_FLOW_CONTROL_SETTINGS.getMaxOutstandingRequestBytes());

    subscriber =
        getTestSubscriberBuilder(testReceiver)
            .setFlowControlSettings(
                Subscriber.Builder.DEFAULT_FLOW_CONTROL_SETTINGS.toBuilder()
                    .setMaxOutstandingRequestBytes(5_000_000_000L)
                    .build())
            .build();
    assertEquals(
        (long) subscriber.getFlowControlSettings().getMaxOutstandingRequestBytes(), 5_000_000_000L);
    assertEquals(
        subscriber.getFlowControlSettings().getMaxOutstandingElementCount(),
        Subscriber.Builder.DEFAULT_FLOW_CONTROL_SETTINGS.getMaxOutstandingElementCount());
  }

  @Test
  public void testShutdown_waitForProcessing_indefinite() throws Exception {
    final CountDownLatch messageReceived = new CountDownLatch(1);
    final AckReplyConsumer[] consumer = new AckReplyConsumer[1];

    MessageReceiver receiver =
        new MessageReceiver() {
          @Override
          public void receiveMessage(PubsubMessage message, AckReplyConsumer c) {
            consumer[0] = c;
            messageReceived.countDown();
          }
        };

    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(receiver)
                .setSubscriberShutdownSettings(
                    SubscriberShutdownSettings.newBuilder()
                        .setMode(SubscriberShutdownSettings.ShutdownMode.WAIT_FOR_PROCESSING)
                        .setTimeout(Duration.ofSeconds(-1))
                        .build()));

    // Send a message and wait for it to be received.
    fakeSubscriberServiceImpl.sendMessages(1);
    messageReceived.await(10, TimeUnit.SECONDS);

    subscriber.stopAsync();

    try {
      subscriber.awaitTerminated(1, TimeUnit.SECONDS);
      fail("Subscriber should not have terminated yet.");
    } catch (TimeoutException e) {
      // Expected
    }

    // Now, ack the message, which should allow the subscriber to terminate.
    consumer[0].ack();
    subscriber.awaitTerminated(10, TimeUnit.SECONDS);
  }

  @Test
  public void testShutdown_waitForProcessing_withTimeout_success() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSubscriberShutdownSettings(
                    SubscriberShutdownSettings.newBuilder()
                        .setMode(SubscriberShutdownSettings.ShutdownMode.WAIT_FOR_PROCESSING)
                        .setTimeout(Duration.ofSeconds(10))
                        .build()));
    subscriber.stopAsync();
    fakeExecutor.advanceTime(Duration.ofSeconds(5));
    subscriber.awaitTerminated(1, TimeUnit.SECONDS); // Should terminate quickly now
  }

  @Test
  public void testShutdown_waitForProcessing_withTimeout_failure() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSubscriberShutdownSettings(
                    SubscriberShutdownSettings.newBuilder()
                        .setMode(SubscriberShutdownSettings.ShutdownMode.WAIT_FOR_PROCESSING)
                        .setTimeout(Duration.ofSeconds(5))
                        .build()));
    subscriber.stopAsync();
    fakeExecutor.advanceTime(Duration.ofSeconds(6));
    subscriber.awaitTerminated(1, TimeUnit.SECONDS); // Should have timed out and terminated
  }

  @Test
  public void testShutdown_waitForProcessing_zeroTimeout() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSubscriberShutdownSettings(
                    SubscriberShutdownSettings.newBuilder()
                        .setMode(SubscriberShutdownSettings.ShutdownMode.WAIT_FOR_PROCESSING)
                        .setTimeout(Duration.ZERO)
                        .build()));
    subscriber.stopAsync();
    subscriber.awaitTerminated(1, TimeUnit.SECONDS); // Should terminate almost immediately
  }

  @Test
  public void testShutdown_nackImmediately() throws Exception {
    Subscriber subscriber =
        startSubscriber(
            getTestSubscriberBuilder(testReceiver)
                .setSubscriberShutdownSettings(
                    SubscriberShutdownSettings.newBuilder()
                        .setMode(SubscriberShutdownSettings.ShutdownMode.NACK_IMMEDIATELY)
                        .build()));
    subscriber.stopAsync();
    subscriber.awaitTerminated(1, TimeUnit.SECONDS); // Should terminate almost immediately
  }

  private Subscriber startSubscriber(Builder testSubscriberBuilder) {
    Subscriber subscriber = testSubscriberBuilder.build();
    subscriber.startAsync().awaitRunning();
    return subscriber;
  }

  private Builder getTestSubscriberBuilder(MessageReceiver messageReceiver) {
    return Subscriber.newBuilder(TEST_SUBSCRIPTION, messageReceiver)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setSystemExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(
            FixedTransportChannelProvider.create(GrpcTransportChannel.create(testChannel)))
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setClock(fakeExecutor.getClock())
        .setParallelPullCount(1)
        .setFlowControlSettings(
            FlowControlSettings.newBuilder().setMaxOutstandingElementCount(1000L).build());
  }

  private Builder getTestSubscriberBuilder(
      MessageReceiverWithAckResponse messageReceiverWithAckResponse) {
    return Subscriber.newBuilder(TEST_SUBSCRIPTION, messageReceiverWithAckResponse)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setSystemExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(
            FixedTransportChannelProvider.create(GrpcTransportChannel.create(testChannel)))
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setClock(fakeExecutor.getClock())
        .setParallelPullCount(1)
        .setFlowControlSettings(
            FlowControlSettings.newBuilder().setMaxOutstandingElementCount(1000L).build());
  }
}
