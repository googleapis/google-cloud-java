/*
 * Copyright 2024 Google LLC
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

import com.google.protobuf.ByteString;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.sdk.testing.assertj.AttributesAssert;
import io.opentelemetry.sdk.testing.assertj.EventDataAssert;
import io.opentelemetry.sdk.testing.assertj.OpenTelemetryAssertions;
import io.opentelemetry.sdk.testing.assertj.SpanDataAssert;
import io.opentelemetry.sdk.testing.junit4.OpenTelemetryRule;
import io.opentelemetry.sdk.trace.data.LinkData;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.data.StatusData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class OpenTelemetryTest {
  private static final TopicName FULL_TOPIC_NAME =
      TopicName.parse("projects/test-project/topics/test-topic");
  private static final SubscriptionName FULL_SUBSCRIPTION_NAME =
      SubscriptionName.parse("projects/test-project/subscriptions/test-sub");
  private static final String PROJECT_NAME = "test-project";
  private static final String ORDERING_KEY = "abc";
  private static final String MESSAGE_ID = "m0";
  private static final String ACK_ID = "def";
  private static final int DELIVERY_ATTEMPT = 1;
  private static final int ACK_DEADLINE = 10;
  private static final boolean EXACTLY_ONCE_ENABLED = true;

  private static final String PUBLISHER_SPAN_NAME = FULL_TOPIC_NAME.getTopic() + " create";
  private static final String PUBLISH_FLOW_CONTROL_SPAN_NAME = "publisher flow control";
  private static final String PUBLISH_BATCHING_SPAN_NAME = "publisher batching";
  private static final String PUBLISH_RPC_SPAN_NAME = FULL_TOPIC_NAME.getTopic() + " publish";
  private static final String PUBLISH_START_EVENT = "publish start";
  private static final String PUBLISH_END_EVENT = "publish end";

  private static final String SUBSCRIBER_SPAN_NAME =
      FULL_SUBSCRIPTION_NAME.getSubscription() + " subscribe";
  private static final String SUBSCRIBE_CONCURRENCY_CONTROL_SPAN_NAME =
      "subscriber concurrency control";
  private static final String SUBSCRIBE_SCHEDULER_SPAN_NAME = "subscriber scheduler";
  private static final String SUBSCRIBE_PROCESS_SPAN_NAME =
      FULL_SUBSCRIPTION_NAME.getSubscription() + " process";
  private static final String SUBSCRIBE_MODACK_RPC_SPAN_NAME =
      FULL_SUBSCRIPTION_NAME.getSubscription() + " modack";
  private static final String SUBSCRIBE_ACK_RPC_SPAN_NAME =
      FULL_SUBSCRIPTION_NAME.getSubscription() + " ack";
  private static final String SUBSCRIBE_NACK_RPC_SPAN_NAME =
      FULL_SUBSCRIPTION_NAME.getSubscription() + " nack";

  private static final String PROCESS_ACTION = "ack";
  private static final String MODACK_START_EVENT = "modack start";
  private static final String MODACK_END_EVENT = "modack end";
  private static final String NACK_START_EVENT = "nack start";
  private static final String NACK_END_EVENT = "nack end";
  private static final String ACK_START_EVENT = "ack start";
  private static final String ACK_END_EVENT = "ack end";

  private static final String MESSAGING_SYSTEM_VALUE = "gcp_pubsub";
  private static final String PROJECT_ATTR_KEY = "gcp.project_id";
  private static final String MESSAGE_SIZE_ATTR_KEY = "messaging.message.body.size";
  private static final String ORDERING_KEY_ATTR_KEY = "messaging.gcp_pubsub.message.ordering_key";
  private static final String ACK_DEADLINE_ATTR_KEY = "messaging.gcp_pubsub.message.ack_deadline";
  private static final String RECEIPT_MODACK_ATTR_KEY = "messaging.gcp_pubsub.is_receipt_modack";
  private static final String MESSAGE_ACK_ID_ATTR_KEY = "messaging.gcp_pubsub.message.ack_id";
  private static final String MESSAGE_EXACTLY_ONCE_ATTR_KEY =
      "messaging.gcp_pubsub.message.exactly_once_delivery";
  private static final String MESSAGE_RESULT_ATTR_KEY = "messaging.gcp_pubsub.result";
  private static final String MESSAGE_DELIVERY_ATTEMPT_ATTR_KEY =
      "messaging.gcp_pubsub.message.delivery_attempt";

  private static final String TRACEPARENT_ATTRIBUTE = "googclient_traceparent";

  private static final OpenTelemetryRule openTelemetryTesting = OpenTelemetryRule.create();

  @Test
  public void testPublishSpansSuccess() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(getPubsubMessage(), FULL_TOPIC_NAME.toString()).build();
    List<PubsubMessageWrapper> messageWrappers = Arrays.asList(messageWrapper);

    long messageSize = messageWrapper.getPubsubMessage().getData().size();
    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    // Call all span start/end methods in the expected order
    tracer.startPublisherSpan(messageWrapper);
    tracer.startPublishFlowControlSpan(messageWrapper);
    tracer.endPublishFlowControlSpan(messageWrapper);
    tracer.startPublishBatchingSpan(messageWrapper);
    tracer.endPublishBatchingSpan(messageWrapper);
    Span publishRpcSpan = tracer.startPublishRpcSpan(FULL_TOPIC_NAME.toString(), messageWrappers);
    tracer.endPublishRpcSpan(publishRpcSpan);
    tracer.setPublisherMessageIdSpanAttribute(messageWrapper, MESSAGE_ID);
    tracer.endPublisherSpan(messageWrapper);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(4, allSpans.size());
    SpanData flowControlSpanData = allSpans.get(0);
    SpanData batchingSpanData = allSpans.get(1);
    SpanData publishRpcSpanData = allSpans.get(2);
    SpanData publisherSpanData = allSpans.get(3);

    SpanDataAssert flowControlSpanDataAssert =
        OpenTelemetryAssertions.assertThat(flowControlSpanData);
    flowControlSpanDataAssert
        .hasName(PUBLISH_FLOW_CONTROL_SPAN_NAME)
        .hasParent(publisherSpanData)
        .hasEnded();

    SpanDataAssert batchingSpanDataAssert = OpenTelemetryAssertions.assertThat(batchingSpanData);
    batchingSpanDataAssert
        .hasName(PUBLISH_BATCHING_SPAN_NAME)
        .hasParent(publisherSpanData)
        .hasEnded();

    // Check span data, links, and attributes for the publish RPC span
    SpanDataAssert publishRpcSpanDataAssert =
        OpenTelemetryAssertions.assertThat(publishRpcSpanData);
    publishRpcSpanDataAssert
        .hasName(PUBLISH_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasEnded();

    List<LinkData> publishRpcLinks = publishRpcSpanData.getLinks();
    assertEquals(messageWrappers.size(), publishRpcLinks.size());
    assertEquals(publisherSpanData.getSpanContext(), publishRpcLinks.get(0).getSpanContext());

    assertEquals(6, publishRpcSpanData.getAttributes().size());
    AttributesAssert publishRpcSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(publishRpcSpanData.getAttributes());
    publishRpcSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_TOPIC_NAME.getTopic())
        .containsEntry(PROJECT_ATTR_KEY, FULL_TOPIC_NAME.getProject())
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "publishCall")
        .containsEntry(SemanticAttributes.MESSAGING_OPERATION, "publish")
        .containsEntry(SemanticAttributes.MESSAGING_BATCH_MESSAGE_COUNT, messageWrappers.size());

    // Check span data, events, links, and attributes for the publisher create span
    SpanDataAssert publisherSpanDataAssert = OpenTelemetryAssertions.assertThat(publisherSpanData);
    publisherSpanDataAssert
        .hasName(PUBLISHER_SPAN_NAME)
        .hasKind(SpanKind.PRODUCER)
        .hasNoParent()
        .hasEnded();

    assertEquals(2, publisherSpanData.getEvents().size());
    EventDataAssert startEventAssert =
        OpenTelemetryAssertions.assertThat(publisherSpanData.getEvents().get(0));
    startEventAssert.hasName(PUBLISH_START_EVENT);
    EventDataAssert endEventAssert =
        OpenTelemetryAssertions.assertThat(publisherSpanData.getEvents().get(1));
    endEventAssert.hasName(PUBLISH_END_EVENT);

    List<LinkData> publisherLinks = publisherSpanData.getLinks();
    assertEquals(1, publisherLinks.size());
    assertEquals(publishRpcSpanData.getSpanContext(), publisherLinks.get(0).getSpanContext());

    assertEquals(8, publisherSpanData.getAttributes().size());
    AttributesAssert publisherSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(publisherSpanData.getAttributes());
    publisherSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_TOPIC_NAME.getTopic())
        .containsEntry(PROJECT_ATTR_KEY, PROJECT_NAME)
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "publish")
        .containsEntry(SemanticAttributes.MESSAGING_OPERATION, "create")
        .containsEntry(ORDERING_KEY_ATTR_KEY, ORDERING_KEY)
        .containsEntry(MESSAGE_SIZE_ATTR_KEY, messageSize)
        .containsEntry(SemanticAttributes.MESSAGING_MESSAGE_ID, MESSAGE_ID);

    // Check that the message has the attribute containing the trace context.
    PubsubMessage message = messageWrapper.getPubsubMessage();
    assertEquals(1, message.getAttributesMap().size());
    assertTrue(message.containsAttributes(TRACEPARENT_ATTRIBUTE));
    assertTrue(
        message
            .getAttributesOrDefault(TRACEPARENT_ATTRIBUTE, "")
            .contains(publisherSpanData.getTraceId()));
    assertTrue(
        message
            .getAttributesOrDefault(TRACEPARENT_ATTRIBUTE, "")
            .contains(publisherSpanData.getSpanId()));
  }

  @Test
  public void testPublishFlowControlSpanFailure() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(getPubsubMessage(), FULL_TOPIC_NAME.toString()).build();

    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    tracer.startPublisherSpan(messageWrapper);
    tracer.startPublishFlowControlSpan(messageWrapper);

    Exception e = new Exception("test-exception");
    tracer.setPublishFlowControlSpanException(messageWrapper, e);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(2, allSpans.size());
    SpanData flowControlSpanData = allSpans.get(0);
    SpanData publisherSpanData = allSpans.get(1);

    SpanDataAssert flowControlSpanDataAssert =
        OpenTelemetryAssertions.assertThat(flowControlSpanData);
    StatusData expectedStatus =
        StatusData.create(StatusCode.ERROR, "Exception thrown during publish flow control.");
    flowControlSpanDataAssert
        .hasName(PUBLISH_FLOW_CONTROL_SPAN_NAME)
        .hasParent(publisherSpanData)
        .hasStatus(expectedStatus)
        .hasException(e)
        .hasEnded();

    SpanDataAssert publisherSpanDataAssert = OpenTelemetryAssertions.assertThat(publisherSpanData);
    publisherSpanDataAssert
        .hasName(PUBLISHER_SPAN_NAME)
        .hasKind(SpanKind.PRODUCER)
        .hasNoParent()
        .hasEnded();
  }

  @Test
  public void testPublishRpcSpanFailure() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(getPubsubMessage(), FULL_TOPIC_NAME.toString()).build();

    List<PubsubMessageWrapper> messageWrappers = Arrays.asList(messageWrapper);
    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    tracer.startPublisherSpan(messageWrapper);
    Span publishRpcSpan = tracer.startPublishRpcSpan(FULL_TOPIC_NAME.toString(), messageWrappers);

    Exception e = new Exception("test-exception");
    tracer.setPublishRpcSpanException(publishRpcSpan, e);
    tracer.endPublisherSpan(messageWrapper);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(2, allSpans.size());
    SpanData rpcSpanData = allSpans.get(0);
    SpanData publisherSpanData = allSpans.get(1);

    SpanDataAssert rpcSpanDataAssert = OpenTelemetryAssertions.assertThat(rpcSpanData);
    StatusData expectedStatus =
        StatusData.create(StatusCode.ERROR, "Exception thrown on publish RPC.");
    rpcSpanDataAssert
        .hasName(PUBLISH_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasStatus(expectedStatus)
        .hasException(e)
        .hasEnded();

    SpanDataAssert publisherSpanDataAssert = OpenTelemetryAssertions.assertThat(publisherSpanData);
    publisherSpanDataAssert
        .hasName(PUBLISHER_SPAN_NAME)
        .hasKind(SpanKind.PRODUCER)
        .hasNoParent()
        .hasEnded();
  }

  @Test
  public void testSubscribeSpansSuccess() {
    openTelemetryTesting.clearSpans();

    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    PubsubMessageWrapper publishMessageWrapper =
        PubsubMessageWrapper.newBuilder(getPubsubMessage(), FULL_TOPIC_NAME.toString()).build();
    // Initialize the Publisher span to inject the context in the message
    tracer.startPublisherSpan(publishMessageWrapper);
    tracer.endPublisherSpan(publishMessageWrapper);

    PubsubMessage publishedMessage =
        publishMessageWrapper.getPubsubMessage().toBuilder().setMessageId(MESSAGE_ID).build();
    PubsubMessageWrapper subscribeMessageWrapper =
        PubsubMessageWrapper.newBuilder(
                publishedMessage, FULL_SUBSCRIPTION_NAME.toString(), ACK_ID, 1)
            .build();
    List<PubsubMessageWrapper> subscribeMessageWrappers = Arrays.asList(subscribeMessageWrapper);

    long messageSize = subscribeMessageWrapper.getPubsubMessage().getData().size();

    // Call all span start/end methods in the expected order
    tracer.startSubscriberSpan(subscribeMessageWrapper, EXACTLY_ONCE_ENABLED);
    tracer.startSubscribeConcurrencyControlSpan(subscribeMessageWrapper);
    tracer.endSubscribeConcurrencyControlSpan(subscribeMessageWrapper);
    tracer.startSubscribeSchedulerSpan(subscribeMessageWrapper);
    tracer.endSubscribeSchedulerSpan(subscribeMessageWrapper);
    tracer.startSubscribeProcessSpan(subscribeMessageWrapper);
    tracer.endSubscribeProcessSpan(subscribeMessageWrapper, PROCESS_ACTION);
    Span subscribeModackRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(),
            "modack",
            subscribeMessageWrappers,
            ACK_DEADLINE,
            true);
    tracer.endSubscribeRpcSpan(subscribeModackRpcSpan);
    tracer.addEndRpcEvent(subscribeMessageWrapper, true, true, ACK_DEADLINE);
    Span subscribeAckRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(), "ack", subscribeMessageWrappers, 0, false);
    tracer.endSubscribeRpcSpan(subscribeAckRpcSpan);
    tracer.addEndRpcEvent(subscribeMessageWrapper, true, false, 0);
    Span subscribeNackRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(), "nack", subscribeMessageWrappers, 0, false);
    tracer.endSubscribeRpcSpan(subscribeNackRpcSpan);
    tracer.addEndRpcEvent(subscribeMessageWrapper, true, true, 0);
    tracer.endSubscriberSpan(subscribeMessageWrapper);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(8, allSpans.size());

    SpanData publisherSpanData = allSpans.get(0);
    SpanData concurrencyControlSpanData = allSpans.get(1);
    SpanData schedulerSpanData = allSpans.get(2);
    SpanData processSpanData = allSpans.get(3);
    SpanData modackRpcSpanData = allSpans.get(4);
    SpanData ackRpcSpanData = allSpans.get(5);
    SpanData nackRpcSpanData = allSpans.get(6);
    SpanData subscriberSpanData = allSpans.get(7);

    SpanDataAssert concurrencyControlSpanDataAssert =
        OpenTelemetryAssertions.assertThat(concurrencyControlSpanData);
    concurrencyControlSpanDataAssert
        .hasName(SUBSCRIBE_CONCURRENCY_CONTROL_SPAN_NAME)
        .hasParent(subscriberSpanData)
        .hasEnded();

    SpanDataAssert schedulerSpanDataAssert = OpenTelemetryAssertions.assertThat(schedulerSpanData);
    schedulerSpanDataAssert
        .hasName(SUBSCRIBE_SCHEDULER_SPAN_NAME)
        .hasParent(subscriberSpanData)
        .hasEnded();

    SpanDataAssert processSpanDataAssert = OpenTelemetryAssertions.assertThat(processSpanData);
    processSpanDataAssert
        .hasName(SUBSCRIBE_PROCESS_SPAN_NAME)
        .hasParent(subscriberSpanData)
        .hasEnded();

    assertEquals(1, processSpanData.getEvents().size());
    EventDataAssert actionCalledEventAssert =
        OpenTelemetryAssertions.assertThat(processSpanData.getEvents().get(0));
    actionCalledEventAssert.hasName(PROCESS_ACTION + " called");

    // Check span data, links, and attributes for the modack RPC span
    SpanDataAssert modackRpcSpanDataAssert = OpenTelemetryAssertions.assertThat(modackRpcSpanData);
    modackRpcSpanDataAssert
        .hasName(SUBSCRIBE_MODACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasEnded();

    List<LinkData> modackRpcLinks = modackRpcSpanData.getLinks();
    assertEquals(subscribeMessageWrappers.size(), modackRpcLinks.size());
    assertEquals(subscriberSpanData.getSpanContext(), modackRpcLinks.get(0).getSpanContext());

    assertEquals(8, modackRpcSpanData.getAttributes().size());
    AttributesAssert modackRpcSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(modackRpcSpanData.getAttributes());
    modackRpcSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(
            SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_SUBSCRIPTION_NAME.getSubscription())
        .containsEntry(PROJECT_ATTR_KEY, FULL_TOPIC_NAME.getProject())
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "sendModAckOperations")
        .containsEntry(SemanticAttributes.MESSAGING_OPERATION, "modack")
        .containsEntry(
            SemanticAttributes.MESSAGING_BATCH_MESSAGE_COUNT, subscribeMessageWrappers.size())
        .containsEntry(ACK_DEADLINE_ATTR_KEY, 10)
        .containsEntry(RECEIPT_MODACK_ATTR_KEY, true);

    // Check span data, links, and attributes for the ack RPC span
    SpanDataAssert ackRpcSpanDataAssert = OpenTelemetryAssertions.assertThat(ackRpcSpanData);
    ackRpcSpanDataAssert
        .hasName(SUBSCRIBE_ACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasEnded();

    List<LinkData> ackRpcLinks = ackRpcSpanData.getLinks();
    assertEquals(subscribeMessageWrappers.size(), ackRpcLinks.size());
    assertEquals(subscriberSpanData.getSpanContext(), ackRpcLinks.get(0).getSpanContext());

    assertEquals(6, ackRpcSpanData.getAttributes().size());
    AttributesAssert ackRpcSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(ackRpcSpanData.getAttributes());
    ackRpcSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(
            SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_SUBSCRIPTION_NAME.getSubscription())
        .containsEntry(PROJECT_ATTR_KEY, FULL_TOPIC_NAME.getProject())
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "sendAckOperations")
        .containsEntry(SemanticAttributes.MESSAGING_OPERATION, "ack")
        .containsEntry(
            SemanticAttributes.MESSAGING_BATCH_MESSAGE_COUNT, subscribeMessageWrappers.size());

    // Check span data, links, and attributes for the nack RPC span
    SpanDataAssert nackRpcSpanDataAssert = OpenTelemetryAssertions.assertThat(nackRpcSpanData);
    nackRpcSpanDataAssert
        .hasName(SUBSCRIBE_NACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasEnded();

    List<LinkData> nackRpcLinks = nackRpcSpanData.getLinks();
    assertEquals(subscribeMessageWrappers.size(), nackRpcLinks.size());
    assertEquals(subscriberSpanData.getSpanContext(), nackRpcLinks.get(0).getSpanContext());

    assertEquals(6, nackRpcSpanData.getAttributes().size());
    AttributesAssert nackRpcSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(nackRpcSpanData.getAttributes());
    nackRpcSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(
            SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_SUBSCRIPTION_NAME.getSubscription())
        .containsEntry(PROJECT_ATTR_KEY, FULL_TOPIC_NAME.getProject())
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "sendModAckOperations")
        .containsEntry(SemanticAttributes.MESSAGING_OPERATION, "nack")
        .containsEntry(
            SemanticAttributes.MESSAGING_BATCH_MESSAGE_COUNT, subscribeMessageWrappers.size());

    // Check span data, events, links, and attributes for the publisher create span
    SpanDataAssert subscriberSpanDataAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData);
    subscriberSpanDataAssert
        .hasName(SUBSCRIBER_SPAN_NAME)
        .hasKind(SpanKind.CONSUMER)
        .hasParent(publisherSpanData)
        .hasEnded();

    assertEquals(6, subscriberSpanData.getEvents().size());
    EventDataAssert startModackEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(0));
    startModackEventAssert.hasName(MODACK_START_EVENT);
    EventDataAssert endModackEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(1));
    endModackEventAssert.hasName(MODACK_END_EVENT);
    EventDataAssert startAckEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(2));
    startAckEventAssert.hasName(ACK_START_EVENT);
    EventDataAssert endAckEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(3));
    endAckEventAssert.hasName(ACK_END_EVENT);
    EventDataAssert startNackEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(4));
    startNackEventAssert.hasName(NACK_START_EVENT);
    EventDataAssert endNackEventAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getEvents().get(5));
    endNackEventAssert.hasName(NACK_END_EVENT);

    List<LinkData> subscriberLinks = subscriberSpanData.getLinks();
    assertEquals(3, subscriberLinks.size());
    assertEquals(modackRpcSpanData.getSpanContext(), subscriberLinks.get(0).getSpanContext());
    assertEquals(ackRpcSpanData.getSpanContext(), subscriberLinks.get(1).getSpanContext());
    assertEquals(nackRpcSpanData.getSpanContext(), subscriberLinks.get(2).getSpanContext());

    assertEquals(11, subscriberSpanData.getAttributes().size());
    AttributesAssert subscriberSpanAttributesAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData.getAttributes());
    subscriberSpanAttributesAssert
        .containsEntry(SemanticAttributes.MESSAGING_SYSTEM, MESSAGING_SYSTEM_VALUE)
        .containsEntry(
            SemanticAttributes.MESSAGING_DESTINATION_NAME, FULL_SUBSCRIPTION_NAME.getSubscription())
        .containsEntry(PROJECT_ATTR_KEY, PROJECT_NAME)
        .containsEntry(SemanticAttributes.CODE_FUNCTION, "onResponse")
        .containsEntry(MESSAGE_SIZE_ATTR_KEY, messageSize)
        .containsEntry(ORDERING_KEY_ATTR_KEY, ORDERING_KEY)
        .containsEntry(MESSAGE_ACK_ID_ATTR_KEY, ACK_ID)
        .containsEntry(MESSAGE_DELIVERY_ATTEMPT_ATTR_KEY, DELIVERY_ATTEMPT)
        .containsEntry(MESSAGE_EXACTLY_ONCE_ATTR_KEY, EXACTLY_ONCE_ENABLED)
        .containsEntry(MESSAGE_RESULT_ATTR_KEY, PROCESS_ACTION)
        .containsEntry(SemanticAttributes.MESSAGING_MESSAGE_ID, MESSAGE_ID);
  }

  @Test
  public void testSubscribeConcurrencyControlSpanFailure() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(
                getPubsubMessage(), FULL_SUBSCRIPTION_NAME.toString(), ACK_ID, DELIVERY_ATTEMPT)
            .build();

    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    tracer.startSubscriberSpan(messageWrapper, EXACTLY_ONCE_ENABLED);
    tracer.startSubscribeConcurrencyControlSpan(messageWrapper);

    Exception e = new Exception("test-exception");
    tracer.setSubscribeConcurrencyControlSpanException(messageWrapper, e);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(2, allSpans.size());
    SpanData concurrencyControlSpanData = allSpans.get(0);
    SpanData subscriberSpanData = allSpans.get(1);

    SpanDataAssert concurrencyControlSpanDataAssert =
        OpenTelemetryAssertions.assertThat(concurrencyControlSpanData);
    StatusData expectedStatus =
        StatusData.create(
            StatusCode.ERROR, "Exception thrown during subscribe concurrency control.");
    concurrencyControlSpanDataAssert
        .hasName(SUBSCRIBE_CONCURRENCY_CONTROL_SPAN_NAME)
        .hasParent(subscriberSpanData)
        .hasStatus(expectedStatus)
        .hasException(e)
        .hasEnded();

    SpanDataAssert subscriberSpanDataAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData);
    subscriberSpanDataAssert
        .hasName(SUBSCRIBER_SPAN_NAME)
        .hasKind(SpanKind.CONSUMER)
        .hasNoParent()
        .hasEnded();
  }

  @Test
  public void testSubscriberSpanFailure() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(
                getPubsubMessage(), FULL_SUBSCRIPTION_NAME.toString(), ACK_ID, DELIVERY_ATTEMPT)
            .build();

    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    tracer.startSubscriberSpan(messageWrapper, EXACTLY_ONCE_ENABLED);

    Exception e = new Exception("test-exception");
    tracer.setSubscriberSpanException(messageWrapper, e, "Test exception");

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(1, allSpans.size());
    SpanData subscriberSpanData = allSpans.get(0);

    StatusData expectedStatus = StatusData.create(StatusCode.ERROR, "Test exception");
    SpanDataAssert subscriberSpanDataAssert =
        OpenTelemetryAssertions.assertThat(subscriberSpanData);
    subscriberSpanDataAssert
        .hasName(SUBSCRIBER_SPAN_NAME)
        .hasKind(SpanKind.CONSUMER)
        .hasNoParent()
        .hasStatus(expectedStatus)
        .hasException(e)
        .hasEnded();
  }

  @Test
  public void testSubscribeRpcSpanFailures() {
    openTelemetryTesting.clearSpans();

    PubsubMessageWrapper messageWrapper =
        PubsubMessageWrapper.newBuilder(
                getPubsubMessage(), FULL_SUBSCRIPTION_NAME.toString(), ACK_ID, DELIVERY_ATTEMPT)
            .build();
    List<PubsubMessageWrapper> messageWrappers = Arrays.asList(messageWrapper);

    Tracer openTelemetryTracer = openTelemetryTesting.getOpenTelemetry().getTracer("test");
    OpenTelemetryPubsubTracer tracer = new OpenTelemetryPubsubTracer(openTelemetryTracer, true);

    tracer.startSubscriberSpan(messageWrapper, EXACTLY_ONCE_ENABLED);
    Span subscribeModackRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(), "modack", messageWrappers, ACK_DEADLINE, true);
    Span subscribeAckRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(), "ack", messageWrappers, 0, false);
    Span subscribeNackRpcSpan =
        tracer.startSubscribeRpcSpan(
            FULL_SUBSCRIPTION_NAME.toString(), "nack", messageWrappers, 0, false);

    Exception e = new Exception("test-exception");
    tracer.setSubscribeRpcSpanException(subscribeModackRpcSpan, true, ACK_DEADLINE, e);
    tracer.setSubscribeRpcSpanException(subscribeAckRpcSpan, false, 0, e);
    tracer.setSubscribeRpcSpanException(subscribeNackRpcSpan, true, 0, e);
    tracer.endSubscriberSpan(messageWrapper);

    List<SpanData> allSpans = openTelemetryTesting.getSpans();
    assertEquals(4, allSpans.size());
    SpanData modackSpanData = allSpans.get(0);
    SpanData ackSpanData = allSpans.get(1);
    SpanData nackSpanData = allSpans.get(2);
    SpanData subscriberSpanData = allSpans.get(3);

    StatusData expectedModackStatus =
        StatusData.create(StatusCode.ERROR, "Exception thrown on modack RPC.");
    SpanDataAssert modackSpanDataAssert = OpenTelemetryAssertions.assertThat(modackSpanData);
    modackSpanDataAssert
        .hasName(SUBSCRIBE_MODACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasStatus(expectedModackStatus)
        .hasException(e)
        .hasEnded();

    StatusData expectedAckStatus =
        StatusData.create(StatusCode.ERROR, "Exception thrown on ack RPC.");
    SpanDataAssert ackSpanDataAssert = OpenTelemetryAssertions.assertThat(ackSpanData);
    ackSpanDataAssert
        .hasName(SUBSCRIBE_ACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasStatus(expectedAckStatus)
        .hasException(e)
        .hasEnded();

    StatusData expectedNackStatus =
        StatusData.create(StatusCode.ERROR, "Exception thrown on nack RPC.");
    SpanDataAssert nackSpanDataAssert = OpenTelemetryAssertions.assertThat(nackSpanData);
    nackSpanDataAssert
        .hasName(SUBSCRIBE_NACK_RPC_SPAN_NAME)
        .hasKind(SpanKind.CLIENT)
        .hasNoParent()
        .hasStatus(expectedNackStatus)
        .hasException(e)
        .hasEnded();
  }

  private PubsubMessage getPubsubMessage() {
    return PubsubMessage.newBuilder()
        .setData(ByteString.copyFromUtf8("test-data"))
        .setOrderingKey(ORDERING_KEY)
        .build();
  }
}
