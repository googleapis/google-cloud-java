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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.api.core.ApiClock;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.pubsub.v1.Subscriber.Builder;
import com.google.cloud.pubsub.v1.Subscriber.StreamingSubscriberConnectionProvider;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.pubsub.v1.ProjectSubscriptionName;
import com.google.pubsub.v1.PubsubMessage;
import io.grpc.ManagedChannel;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.threeten.bp.Duration;

/** Tests for {@link Subscriber}. */
public class SubscriberTest {

  private static final ProjectSubscriptionName TEST_SUBSCRIPTION =
      ProjectSubscriptionName.of("test-project", "test-subscription");

  private ManagedChannel testChannel;
  private FakeScheduledExecutorService fakeExecutor;
  private FakeSubscriberServiceImpl fakeSubscriberServiceImpl;
  private Server testServer;

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
    InProcessServerBuilder serverBuilder = InProcessServerBuilder.forName(testName.getMethodName());
    fakeSubscriberServiceImpl = new FakeSubscriberServiceImpl();
    fakeExecutor = new FakeScheduledExecutorService();
    testChannel = InProcessChannelBuilder.forName(testName.getMethodName()).build();
    serverBuilder.addService(fakeSubscriberServiceImpl);
    testServer = serverBuilder.build();
    testServer.start();
  }

  @After
  public void tearDown() throws Exception {
    testServer.shutdownNow().awaitTermination();
    testChannel.shutdown();
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

  @Test
  public void testSubscriberStats() throws Exception {
    final long acked = 8L;
    final long nacked = 2L;
    final long totalMessages = 10L;
    final long extended = 3L;
    final SubscriberStats stats =
        SubscriberStats.newBuilder()
            .setNumberOfAutoExtendedAckDeadlines(extended)
            .setTotalAckedMessages(acked)
            .setTotalNackedMessages(nacked)
            .setTotalReceivedMessages(totalMessages)
            .build();
    final AtomicInteger numberOfConnections = new AtomicInteger(0);
    StreamingSubscriberConnectionProvider provider =
        new StreamingSubscriberConnectionProvider() {
          @Override
          StreamingSubscriberConnection createConnection(
              String subscription,
              MessageReceiver receiver,
              Duration ackExpirationPadding,
              Duration maxAckExtensionPeriod,
              Distribution ackLatencyDistribution,
              SubscriberStub stub,
              int channelAffinity,
              FlowController flowController,
              ScheduledExecutorService executor,
              ScheduledExecutorService systemExecutor,
              ApiClock clock) {
            numberOfConnections.incrementAndGet();
            StreamingSubscriberConnection connection =
                new StreamingSubscriberConnection(
                    subscription,
                    receiver,
                    ackExpirationPadding,
                    maxAckExtensionPeriod,
                    ackLatencyDistribution,
                    stub,
                    channelAffinity,
                    flowController,
                    executor,
                    systemExecutor,
                    clock) {
                  @Override
                  SubscriberStats getSubscriberStats() {
                    return stats;
                  }
                };
            return connection;
          }
        };
    Builder builder =
        getTestSubscriberBuilder(testReceiver)
            .setStreamingSubscriberConnectionProvider(provider)
            .setParallelPullCount(5);
    Subscriber subscriber = startSubscriber(builder);
    assertEquals(
        numberOfConnections.get() * totalMessages,
        subscriber.getSubscriberStats().getTotalReceivedMessages());
    assertEquals(
        numberOfConnections.get() * acked, subscriber.getSubscriberStats().getTotalAckedMessages());
    assertEquals(
        numberOfConnections.get() * nacked,
        subscriber.getSubscriberStats().getTotalNackedMessages());
    assertEquals(
        numberOfConnections.get() * extended,
        subscriber.getSubscriberStats().getNumberOfAutoExtendedAckDeadlines());
    subscriber.stopAsync().awaitTerminated();
  }

  private Subscriber startSubscriber(Builder testSubscriberBuilder) throws Exception {
    Subscriber subscriber = testSubscriberBuilder.build();
    subscriber.startAsync().awaitRunning();
    return subscriber;
  }

  private Builder getTestSubscriberBuilder(MessageReceiver receiver) {
    return Subscriber.newBuilder(TEST_SUBSCRIPTION, receiver)
        .setExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setSystemExecutorProvider(FixedExecutorProvider.create(fakeExecutor))
        .setChannelProvider(
            FixedTransportChannelProvider.create(GrpcTransportChannel.create(testChannel)))
        .setCredentialsProvider(NoCredentialsProvider.create())
        .setClock(fakeExecutor.getClock())
        .setParallelPullCount(1);
  }
}
