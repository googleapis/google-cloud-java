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

package com.google.cloud.pubsub.v1;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MessageDispatcherTest {
  private static final String MOCK_SUBSCRIPTION_NAME =
      "projects/MOCK-PROJECT/subscriptions/MOCK-SUBSCRIPTION";
  private static final ByteString MESSAGE_DATA = ByteString.copyFromUtf8("message-data");
  private static final int DELIVERY_INFO_COUNT = 3;
  private static final String ACK_ID = "ACK-ID";
  private static final String ORDERING_KEY = "KEY";
  private static final ReceivedMessage TEST_MESSAGE =
      ReceivedMessage.newBuilder()
          .setAckId(ACK_ID)
          .setMessage(PubsubMessage.newBuilder().setData(MESSAGE_DATA).build())
          .setDeliveryAttempt(DELIVERY_INFO_COUNT)
          .build();
  private static final ByteString ORDERED_MESSAGE_DATA_1 = ByteString.copyFromUtf8("message-data1");
  private static final ReceivedMessage ORDERED_TEST_MESSAGE_1 =
      ReceivedMessage.newBuilder()
          .setAckId("ACK-ID-1")
          .setMessage(
              PubsubMessage.newBuilder()
                  .setData(ORDERED_MESSAGE_DATA_1)
                  .setOrderingKey(ORDERING_KEY)
                  .build())
          .build();
  private static final ByteString ORDERED_MESSAGE_DATA_2 = ByteString.copyFromUtf8("message-data2");
  private static final ReceivedMessage ORDERED_TEST_MESSAGE_2 =
      ReceivedMessage.newBuilder()
          .setAckId("ACK-ID-2")
          .setMessage(
              PubsubMessage.newBuilder()
                  .setData(ORDERED_MESSAGE_DATA_2)
                  .setOrderingKey(ORDERING_KEY)
                  .build())
          .build();
  private static final int MAX_SECONDS_PER_ACK_EXTENSION = 60;
  private static final int MIN_ACK_DEADLINE_SECONDS = 10;
  private static final Duration MAX_ACK_EXTENSION_PERIOD = Duration.ofMinutes(60);
  private static final Duration ACK_EXPIRATION_PADDING_DEFAULT =
      Subscriber.ACK_EXPIRATION_PADDING_DEFAULT;

  private Distribution mockAckLatencyDistribution;

  private MessageDispatcher.AckProcessor mockAckProcessor;
  private FakeClock clock;
  private boolean messageContainsDeliveryAttempt;

  private FakeScheduledExecutorService systemExecutor;

  private static MessageReceiver messageReceiver;
  private static MessageReceiverWithAckResponse messageReceiverWithAckResponse;

  private LinkedBlockingQueue<AckReplyConsumer> consumers;
  private LinkedBlockingQueue<AckReplyConsumerWithResponse> consumersWithResponse;

  @Before
  public void setUp() {
    systemExecutor = new FakeScheduledExecutorService();
    clock = new FakeClock();
    mockAckLatencyDistribution = mock(Distribution.class);

    mockAckProcessor = mock(MessageDispatcher.AckProcessor.class);
    messageContainsDeliveryAttempt = true;

    consumers = new LinkedBlockingQueue<>();
    consumersWithResponse = new LinkedBlockingQueue<>();

    // We are instantiating "real" message receivers to easily ack/nack messages
    messageReceiver =
        new MessageReceiver() {
          @Override
          public void receiveMessage(
              final PubsubMessage message, final AckReplyConsumer ackReplyConsumer) {
            assertThat(message.getData()).isEqualTo(MESSAGE_DATA);
            if (messageContainsDeliveryAttempt) {
              assertTrue(message.containsAttributes("googclient_deliveryattempt"));
              assertThat(message.getAttributesOrThrow("googclient_deliveryattempt"))
                  .isEqualTo(Integer.toString(DELIVERY_INFO_COUNT));
            } else {
              assertFalse(message.containsAttributes("googclient_deliveryattempt"));
            }
            consumers.add(ackReplyConsumer);
          }
        };

    messageReceiverWithAckResponse =
        new MessageReceiverWithAckResponse() {
          @Override
          public void receiveMessage(
              PubsubMessage message, AckReplyConsumerWithResponse ackReplyConsumerWithResponse) {
            assertThat(message.getData()).isEqualTo(MESSAGE_DATA);
            if (messageContainsDeliveryAttempt) {
              assertTrue(message.containsAttributes("googclient_deliveryattempt"));
              assertThat(message.getAttributesOrThrow("googclient_deliveryattempt"))
                  .isEqualTo(Integer.toString(DELIVERY_INFO_COUNT));
            } else {
              assertFalse(message.containsAttributes("googclient_deliveryattempt"));
            }
            consumersWithResponse.add(ackReplyConsumerWithResponse);
          }
        };
  }

  @Test
  public void testSetupAndTeardown() {
    MessageDispatcher messageDispatcher = getMessageDispatcher();

    messageDispatcher.start();
    messageDispatcher.stop();
  }

  @Test
  public void testReceiptMessageReceiver() {
    MessageReceiver mockMessageReceiver = mock(MessageReceiver.class);
    MessageDispatcher messageDispatcher = getMessageDispatcher(mockMessageReceiver);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));
    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(
        new ModackRequestData(
            MIN_ACK_DEADLINE_SECONDS, AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build()));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
    verify(mockMessageReceiver, never())
        .receiveMessage(eq(TEST_MESSAGE.getMessage()), any(AckReplyConsumer.class));
  }

  @Test
  public void testReceiptModackWithOrderingForExactlyOnceDelivered() {

    MessageReceiverWithAckResponse mockMessageReceiverWithAckResponse =
        mock(MessageReceiverWithAckResponse.class);
    MessageDispatcher messageDispatcher = getMessageDispatcher(mockMessageReceiverWithAckResponse);
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    ReceivedMessage TEST_MESSAGE1 =
        ReceivedMessage.newBuilder()
            .setAckId("ACK_ID1")
            .setMessage(
                PubsubMessage.newBuilder()
                    .setData(ByteString.copyFromUtf8("message-data1"))
                    .build())
            .setDeliveryAttempt(DELIVERY_INFO_COUNT)
            .build();
    ReceivedMessage TEST_MESSAGE2 =
        ReceivedMessage.newBuilder()
            .setAckId("ACK_ID2")
            .setMessage(
                PubsubMessage.newBuilder()
                    .setData(ByteString.copyFromUtf8("message-data2"))
                    .build())
            .setDeliveryAttempt(DELIVERY_INFO_COUNT)
            .build();
    ReceivedMessage TEST_MESSAGE3 =
        ReceivedMessage.newBuilder()
            .setAckId("ACK_ID3")
            .setMessage(
                PubsubMessage.newBuilder()
                    .setData(ByteString.copyFromUtf8("message-data3"))
                    .build())
            .setDeliveryAttempt(DELIVERY_INFO_COUNT)
            .build();

    messageDispatcher.processReceivedMessages(
        Arrays.asList(TEST_MESSAGE3, TEST_MESSAGE2, TEST_MESSAGE1));

    messageDispatcher.processOutstandingOperations();
    verify(mockMessageReceiverWithAckResponse, never())
        .receiveMessage(eq(TEST_MESSAGE.getMessage()), any(AckReplyConsumerWithResponse.class));

    AckRequestData ackRequestData1 = AckRequestData.newBuilder(TEST_MESSAGE1.getAckId()).build();
    AckRequestData ackRequestData2 = AckRequestData.newBuilder(TEST_MESSAGE2.getAckId()).build();
    AckRequestData ackRequestData3 = AckRequestData.newBuilder(TEST_MESSAGE3.getAckId()).build();
    messageDispatcher.notifyAckSuccess(ackRequestData2);
    messageDispatcher.processOutstandingOperations();

    messageDispatcher.notifyAckSuccess(ackRequestData1);
    messageDispatcher.notifyAckSuccess(ackRequestData3);
    messageDispatcher.processOutstandingOperations();

    verify(mockMessageReceiverWithAckResponse, times(1))
        .receiveMessage(
            argThat(new MessageDataMatcher(TEST_MESSAGE3.getMessage().getData())),
            any(AckReplyConsumerWithResponse.class));
    verify(mockMessageReceiverWithAckResponse, times(1))
        .receiveMessage(
            argThat(new MessageDataMatcher(TEST_MESSAGE2.getMessage().getData())),
            any(AckReplyConsumerWithResponse.class));
    verify(mockMessageReceiverWithAckResponse, times(1))
        .receiveMessage(
            argThat(new MessageDataMatcher(TEST_MESSAGE1.getMessage().getData())),
            any(AckReplyConsumerWithResponse.class));
  }

  @Test
  public void testReceiptModackForExactlyOnceDelivered() {

    MessageReceiverWithAckResponse mockMessageReceiverWithAckResponse =
        mock(MessageReceiverWithAckResponse.class);
    MessageDispatcher messageDispatcher = getMessageDispatcher(mockMessageReceiverWithAckResponse);
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));

    messageDispatcher.processOutstandingOperations();
    verify(mockMessageReceiverWithAckResponse, never())
        .receiveMessage(eq(TEST_MESSAGE.getMessage()), any(AckReplyConsumerWithResponse.class));

    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    messageDispatcher.notifyAckSuccess(ackRequestData);
    messageDispatcher.processOutstandingOperations();

    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockMessageReceiverWithAckResponse, times(1))
        .receiveMessage(
            argThat(new MessageDataMatcher(TEST_MESSAGE.getMessage().getData())),
            any(AckReplyConsumerWithResponse.class));
  }

  @Test
  public void testReceiptMessageReceiverWithAckResponse() {
    MessageReceiverWithAckResponse mockMessageReceiverWithAckResponse =
        mock(MessageReceiverWithAckResponse.class);
    MessageDispatcher messageDispatcher = getMessageDispatcher(mockMessageReceiverWithAckResponse);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));
    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(
        new ModackRequestData(
            MIN_ACK_DEADLINE_SECONDS, AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build()));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
    verify(mockMessageReceiverWithAckResponse, never())
        .receiveMessage(eq(TEST_MESSAGE.getMessage()), any(AckReplyConsumerWithResponse.class));
  }

  @Test
  public void testConsumerAckMessageReceiver() {
    MessageDispatcher messageDispatcher = getMessageDispatcher(messageReceiver);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));

    try {
      // Ack a message
      consumers.take().ack();
    } catch (Throwable t) {
      // In case our consumers fail
      throw new AssertionError();
    }

    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    ackRequestDataList.add(ackRequestData);

    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
    verify(mockAckProcessor, times(1))
        .sendAckOperations(
            argThat(new CustomArgumentMatchers.AckRequestDataListMatcher(ackRequestDataList)));
  }

  @Test
  public void testConsumerAckMessageReceiverWithAckResponse() {
    MessageDispatcher messageDispatcher = getMessageDispatcher(messageReceiverWithAckResponse);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));
    Future<AckResponse> ackResponseFuture;

    try {
      // Ack a message - at this point we do not care about the message future so just drop it
      consumersWithResponse.take().ack();
    } catch (Throwable t) {
      // In case our consumers fail
      throw new AssertionError();
    }

    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    ackRequestDataList.add(ackRequestData);

    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
    verify(mockAckProcessor, times(1))
        .sendAckOperations(
            argThat(new CustomArgumentMatchers.AckRequestDataListMatcher(ackRequestDataList)));
  }

  @Test
  public void testConsumerNackMessageReceiver() {
    MessageDispatcher messageDispatcher = getMessageDispatcher(messageReceiver);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));

    try {
      consumers.take().nack();
    } catch (Throwable t) {
      // Just in case something went wrong with our consumers
      throw new AssertionError();
    }

    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(0, ackRequestData));
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
  }

  @Test
  public void testConsumerNackMessageReceiverWithAckResponse() {
    MessageDispatcher messageDispatcher = getMessageDispatcher(messageReceiverWithAckResponse);
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));

    try {
      // Ack a message - at this point we do not care about the message future so just drop it
      consumersWithResponse.take().nack();
    } catch (Throwable t) {
      // Just in case something went wrong with our consumers
      throw new AssertionError();
    }

    messageDispatcher.processOutstandingOperations();

    // Assert expected behavior
    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(0, ackRequestData));
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
  }

  @Test
  public void testExtension() {
    MessageDispatcher messageDispatcher = getMessageDispatcher();
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));
    messageDispatcher.extendDeadlines();

    // Assert expected behavior
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();

    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    ackRequestDataList.add(ackRequestData);

    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(MIN_ACK_DEADLINE_SECONDS, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
  }

  @Test
  public void testExtension_ExpirationExtension() {
    MessageDispatcher messageDispatcher = getMessageDispatcher();
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));
    int secondsLeft = 5;
    // Advance clock to have 5 seconds left in extension period
    clock.advance(MAX_ACK_EXTENSION_PERIOD.getSeconds() - secondsLeft, TimeUnit.SECONDS);
    messageDispatcher.extendDeadlines();

    // Assert expected behavior
    List<AckRequestData> ackRequestDataList = new ArrayList<AckRequestData>();
    AckRequestData ackRequestData = AckRequestData.newBuilder(TEST_MESSAGE.getAckId()).build();
    ackRequestDataList.add(ackRequestData);
    List<ModackRequestData> modackRequestDataList = new ArrayList<ModackRequestData>();
    modackRequestDataList.add(new ModackRequestData(secondsLeft, ackRequestData));

    verify(mockAckProcessor, times(1))
        .sendModackOperations(
            argThat(
                new CustomArgumentMatchers.ModackRequestDataListMatcher(modackRequestDataList)));
  }

  @Test
  public void testExtension_GiveUp() throws Exception {
    MessageDispatcher messageDispatcher = getMessageDispatcher();
    messageDispatcher.processReceivedMessages(Collections.singletonList(TEST_MESSAGE));

    // If we run extendDeadlines after totalExpiration, we shouldn't send anything.
    clock.advance(1, TimeUnit.DAYS);
    messageDispatcher.extendDeadlines();

    // Assert expected behavior
    verify(mockAckProcessor, times(0)).sendAckOperations(eq(Collections.emptyList()));
    verify(mockAckProcessor, times(0)).sendModackOperations(eq(Collections.emptyList()));
  }

  @Test
  public void testAckExtensionDefaultsExactlyOnceDeliveryDisabledThenEnabled() {
    MessageDispatcher messageDispatcher =
        MessageDispatcher.newBuilder(mock(MessageReceiver.class))
            .setAckLatencyDistribution(mockAckLatencyDistribution)
            .setMinDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
            .setMinDurationPerAckExtensionDefaultUsed(true)
            .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MAX_ACK_DEADLINE_EXTENSION)
            .setMaxDurationPerAckExtensionDefaultUsed(true)
            .setSubscriptionName(MOCK_SUBSCRIPTION_NAME)
            .build();

    // ExactlyOnceDeliveryEnabled is turned off by default

    // We should be using the Subscriber set hard deadlines
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()),
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    // Should only change min deadline
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        Math.toIntExact(
            Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION_EXACTLY_ONCE_DELIVERY.getSeconds()),
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));
  }

  @Test
  public void testAckExtensionDefaultsExactlyOnceDeliveryEnabledThenDisabled() {
    MessageDispatcher messageDispatcher =
        MessageDispatcher.newBuilder(mock(MessageReceiver.class))
            .setAckLatencyDistribution(mockAckLatencyDistribution)
            .setMinDurationPerAckExtension(
                Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION_EXACTLY_ONCE_DELIVERY)
            .setMinDurationPerAckExtensionDefaultUsed(true)
            .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
            .setMaxDurationPerAckExtensionDefaultUsed(true)
            .setSubscriptionName(MOCK_SUBSCRIPTION_NAME)
            .build();

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        Math.toIntExact(
            Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION_EXACTLY_ONCE_DELIVERY.getSeconds()),
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setExactlyOnceDeliveryEnabled(false);

    // Should change min deadline
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()),
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));
  }

  @Test
  public void testOrderedDeliveryOrderingDisabled() throws Exception {
    MessageReceiver mockMessageReceiver = mock(MessageReceiver.class);
    MessageDispatcher messageDispatcher =
        getMessageDispatcher(mockMessageReceiver, Executors.newFixedThreadPool(5));

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setMessageOrderingEnabled(false);

    CountDownLatch receiveCalls = new CountDownLatch(2);

    doAnswer(
            new Answer<Void>() {
              public Void answer(InvocationOnMock invocation) throws Exception {
                Thread.sleep(1000);
                receiveCalls.countDown();
                return null;
              }
            })
        .when(mockMessageReceiver)
        .receiveMessage(eq(ORDERED_TEST_MESSAGE_1.getMessage()), any(AckReplyConsumer.class));
    doAnswer(
            new Answer<Void>() {
              public Void answer(InvocationOnMock invocation) {
                // Ensure the previous method didn't finish and we could process in parallel.
                assertEquals(2, receiveCalls.getCount());
                receiveCalls.countDown();
                return null;
              }
            })
        .when(mockMessageReceiver)
        .receiveMessage(eq(ORDERED_TEST_MESSAGE_2.getMessage()), any(AckReplyConsumer.class));

    messageDispatcher.processReceivedMessages(
        Arrays.asList(ORDERED_TEST_MESSAGE_1, ORDERED_TEST_MESSAGE_2));
    receiveCalls.await();
  }

  @Test
  public void testOrderedDeliveryOrderingEnabled() throws Exception {
    MessageReceiver mockMessageReceiver = mock(MessageReceiver.class);
    MessageDispatcher messageDispatcher =
        getMessageDispatcher(mockMessageReceiver, Executors.newFixedThreadPool(5));

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setMessageOrderingEnabled(true);

    CountDownLatch receiveCalls = new CountDownLatch(2);

    doAnswer(
            new Answer<Void>() {
              public Void answer(InvocationOnMock invocation) throws Exception {
                Thread.sleep(1000);
                receiveCalls.countDown();
                return null;
              }
            })
        .when(mockMessageReceiver)
        .receiveMessage(eq(ORDERED_TEST_MESSAGE_1.getMessage()), any(AckReplyConsumer.class));
    doAnswer(
            new Answer<Void>() {
              public Void answer(InvocationOnMock invocation) {
                // Ensure the previous method has finished completely.
                assertEquals(1, receiveCalls.getCount());
                receiveCalls.countDown();
                return null;
              }
            })
        .when(mockMessageReceiver)
        .receiveMessage(eq(ORDERED_TEST_MESSAGE_2.getMessage()), any(AckReplyConsumer.class));

    messageDispatcher.processReceivedMessages(
        Arrays.asList(ORDERED_TEST_MESSAGE_1, ORDERED_TEST_MESSAGE_2));
    receiveCalls.await();
  }

  @Test
  public void testAckExtensionCustomMinExactlyOnceDeliveryDisabledThenEnabled() {
    int customMinSeconds = 30;
    MessageDispatcher messageDispatcher =
        MessageDispatcher.newBuilder(mock(MessageReceiver.class))
            .setAckLatencyDistribution(mockAckLatencyDistribution)
            .setMinDurationPerAckExtension(Duration.ofSeconds(customMinSeconds))
            .setMinDurationPerAckExtensionDefaultUsed(false)
            .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
            .setMaxDurationPerAckExtensionDefaultUsed(true)
            .setSubscriptionName(MOCK_SUBSCRIPTION_NAME)
            .build();

    // ExactlyOnceDeliveryEnabled is turned off by default
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        customMinSeconds,
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    // no changes should occur
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        customMinSeconds,
        Math.toIntExact(Subscriber.MAX_STREAM_ACK_DEADLINE.getSeconds()));
  }

  @Test
  public void testAckExtensionCustomMaxExactlyOnceDeliveryDisabledThenEnabled() {
    int customMaxSeconds = 30;
    MessageDispatcher messageDispatcher =
        MessageDispatcher.newBuilder(mock(MessageReceiver.class))
            .setAckLatencyDistribution(mockAckLatencyDistribution)
            .setMinDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
            .setMinDurationPerAckExtensionDefaultUsed(true)
            .setMaxDurationPerAckExtension(Duration.ofSeconds(customMaxSeconds))
            .setMaxDurationPerAckExtensionDefaultUsed(false)
            .setSubscriptionName(MOCK_SUBSCRIPTION_NAME)
            .build();

    // ExactlyOnceDeliveryEnabled is turned off by default
    assertMinAndMaxAckDeadlines(
        messageDispatcher,
        Math.toIntExact(Subscriber.MIN_STREAM_ACK_DEADLINE.getSeconds()),
        customMaxSeconds);

    // This would normally be set from the streaming pull response in the
    // StreamingSubscriberConnection
    messageDispatcher.setExactlyOnceDeliveryEnabled(true);

    // Because the customMaxSeconds is above the
    // DEFAULT_MIN_ACK_DEADLINE_EXTENSION_EXACTLY_ONCE_DELIVERY, we should use the customMaxSeconds
    // as the new min
    assertMinAndMaxAckDeadlines(messageDispatcher, customMaxSeconds, customMaxSeconds);
  }

  private void assertMinAndMaxAckDeadlines(
      MessageDispatcher messageDispatcher, int minAckDeadline, int maxAckDeadline) {
    // Helper function to assert if min and max deadlines are being respected

    // Set distribution to return a low value to assert min value
    when(mockAckLatencyDistribution.getPercentile(
            MessageDispatcher.PERCENTILE_FOR_ACK_DEADLINE_UPDATES))
        .thenReturn(0);
    assertEquals(minAckDeadline, messageDispatcher.computeDeadlineSeconds());

    // Set distribution to return a high value to assert max value
    when(mockAckLatencyDistribution.getPercentile(
            MessageDispatcher.PERCENTILE_FOR_ACK_DEADLINE_UPDATES))
        .thenReturn(60 * 60);
    assertEquals(maxAckDeadline, messageDispatcher.computeDeadlineSeconds());
  }

  private MessageDispatcher getMessageDispatcher() {
    return getMessageDispatcher(mock(MessageReceiver.class), MoreExecutors.directExecutor());
  }

  private MessageDispatcher getMessageDispatcher(MessageReceiver messageReceiver) {
    return getMessageDispatcherFromBuilder(
        MessageDispatcher.newBuilder(messageReceiver), MoreExecutors.directExecutor());
  }

  private MessageDispatcher getMessageDispatcher(
      MessageReceiver messageReceiver, Executor executor) {
    return getMessageDispatcherFromBuilder(MessageDispatcher.newBuilder(messageReceiver), executor);
  }

  private MessageDispatcher getMessageDispatcher(
      MessageReceiverWithAckResponse messageReceiverWithAckResponse) {
    return getMessageDispatcherFromBuilder(
        MessageDispatcher.newBuilder(messageReceiverWithAckResponse),
        MoreExecutors.directExecutor());
  }

  private MessageDispatcher getMessageDispatcherFromBuilder(
      MessageDispatcher.Builder builder, Executor executor) {
    MessageDispatcher messageDispatcher =
        builder
            .setAckProcessor(mockAckProcessor)
            .setAckExpirationPadding(ACK_EXPIRATION_PADDING_DEFAULT)
            .setMaxAckExtensionPeriod(MAX_ACK_EXTENSION_PERIOD)
            .setMinDurationPerAckExtension(Subscriber.DEFAULT_MIN_ACK_DEADLINE_EXTENSION)
            .setMinDurationPerAckExtensionDefaultUsed(true)
            .setMaxDurationPerAckExtension(Subscriber.DEFAULT_MAX_ACK_DEADLINE_EXTENSION)
            .setMaxDurationPerAckExtensionDefaultUsed(true)
            .setAckLatencyDistribution(mock(Distribution.class))
            .setFlowController(mock(FlowController.class))
            .setExecutor(executor)
            .setSubscriptionName(MOCK_SUBSCRIPTION_NAME)
            .setSystemExecutor(systemExecutor)
            .setApiClock(clock)
            .build();

    messageDispatcher.setMessageDeadlineSeconds(MIN_ACK_DEADLINE_SECONDS);
    return messageDispatcher;
  }
}
