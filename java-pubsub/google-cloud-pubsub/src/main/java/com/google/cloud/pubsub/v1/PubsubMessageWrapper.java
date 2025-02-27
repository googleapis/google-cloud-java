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

import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.SubscriptionName;
import com.google.pubsub.v1.TopicName;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapGetter;
import io.opentelemetry.context.propagation.TextMapSetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;

/**
 * A wrapper class for a {@link PubsubMessage} object that handles creation and tracking of
 * OpenTelemetry {@link Span} objects for different operations that occur during publishing.
 */
public class PubsubMessageWrapper {
  private PubsubMessage message;

  private final TopicName topicName;
  private final SubscriptionName subscriptionName;

  // Attributes set only for messages received from a streaming pull response.
  private final String ackId;
  private final int deliveryAttempt;

  private static final String PUBLISH_START_EVENT = "publish start";
  private static final String PUBLISH_END_EVENT = "publish end";

  private static final String MODACK_START_EVENT = "modack start";
  private static final String MODACK_END_EVENT = "modack end";
  private static final String NACK_START_EVENT = "nack start";
  private static final String NACK_END_EVENT = "nack end";
  private static final String ACK_START_EVENT = "ack start";
  private static final String ACK_END_EVENT = "ack end";

  private static final String GOOGCLIENT_PREFIX = "googclient_";

  private static final String MESSAGE_RESULT_ATTR_KEY = "messaging.gcp_pubsub.result";

  private Span publisherSpan;
  private Span publishFlowControlSpan;
  private Span publishBatchingSpan;

  private Span subscriberSpan;
  private Span subscribeConcurrencyControlSpan;
  private Span subscribeSchedulerSpan;
  private Span subscribeProcessSpan;

  private PubsubMessageWrapper(Builder builder) {
    this.message = builder.message;
    this.topicName = builder.topicName;
    this.subscriptionName = builder.subscriptionName;
    this.ackId = builder.ackId;
    this.deliveryAttempt = builder.deliveryAttempt;
  }

  static Builder newBuilder(PubsubMessage message, TopicName topicName) {
    return new Builder(message, topicName);
  }

  static Builder newBuilder(
      PubsubMessage message, SubscriptionName subscriptionName, String ackId, int deliveryAttempt) {
    return new Builder(message, subscriptionName, ackId, deliveryAttempt);
  }

  /** Returns the PubsubMessage associated with this wrapper. */
  PubsubMessage getPubsubMessage() {
    return message;
  }

  void setPubsubMessage(PubsubMessage message) {
    this.message = message;
  }

  /** Returns the TopicName for this wrapper as a string. */
  String getTopicName() {
    if (topicName != null) {
      return topicName.getTopic();
    }
    return "";
  }

  String getTopicProject() {
    if (topicName != null) {
      return topicName.getProject();
    }
    return "";
  }

  /** Returns the SubscriptionName for this wrapper as a string. */
  String getSubscriptionName() {
    if (subscriptionName != null) {
      return subscriptionName.getSubscription();
    }
    return "";
  }

  String getSubscriptionProject() {
    if (subscriptionName != null) {
      return subscriptionName.getProject();
    }
    return "";
  }

  String getMessageId() {
    return message.getMessageId();
  }

  String getAckId() {
    return ackId;
  }

  int getDataSize() {
    return message.getData().size();
  }

  String getOrderingKey() {
    return message.getOrderingKey();
  }

  int getDeliveryAttempt() {
    return deliveryAttempt;
  }

  Span getPublisherSpan() {
    return publisherSpan;
  }

  void setPublisherSpan(Span span) {
    this.publisherSpan = span;
  }

  void setPublishFlowControlSpan(Span span) {
    this.publishFlowControlSpan = span;
  }

  void setPublishBatchingSpan(Span span) {
    this.publishBatchingSpan = span;
  }

  Span getSubscriberSpan() {
    return subscriberSpan;
  }

  void setSubscriberSpan(Span span) {
    this.subscriberSpan = span;
  }

  void setSubscribeConcurrencyControlSpan(Span span) {
    this.subscribeConcurrencyControlSpan = span;
  }

  void setSubscribeSchedulerSpan(Span span) {
    this.subscribeSchedulerSpan = span;
  }

  void setSubscribeProcessSpan(Span span) {
    this.subscribeProcessSpan = span;
  }

  /** Creates a publish start event that is tied to the publish RPC span time. */
  void addPublishStartEvent() {
    if (publisherSpan != null) {
      publisherSpan.addEvent(PUBLISH_START_EVENT);
    }
  }

  /**
   * Sets the message ID attribute in the publisher parent span. This is called after the publish
   * RPC returns with a message ID.
   */
  void setPublisherMessageIdSpanAttribute(String messageId) {
    if (publisherSpan != null) {
      publisherSpan.setAttribute(SemanticAttributes.MESSAGING_MESSAGE_ID, messageId);
    }
  }

  /** Ends the publisher parent span if it exists. */
  void endPublisherSpan() {
    if (publisherSpan != null) {
      publisherSpan.addEvent(PUBLISH_END_EVENT);
      publisherSpan.end();
    }
  }

  /** Ends the publish flow control span if it exists. */
  void endPublishFlowControlSpan() {
    if (publishFlowControlSpan != null) {
      publishFlowControlSpan.end();
    }
  }

  /** Ends the publish batching span if it exists. */
  void endPublishBatchingSpan() {
    if (publishBatchingSpan != null) {
      publishBatchingSpan.end();
    }
  }

  /**
   * Sets an error status and records an exception when an exception is thrown during flow control.
   */
  void setPublishFlowControlSpanException(Throwable t) {
    if (publishFlowControlSpan != null) {
      publishFlowControlSpan.setStatus(
          StatusCode.ERROR, "Exception thrown during publish flow control.");
      publishFlowControlSpan.recordException(t);
      endAllPublishSpans();
    }
  }

  /**
   * Creates start and end events for ModAcks, Nacks, and Acks that are tied to the corresponding
   * RPC span start and end times.
   */
  void addModAckStartEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(MODACK_START_EVENT);
    }
  }

  void addModAckEndEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(MODACK_END_EVENT);
    }
  }

  void addNackStartEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(NACK_START_EVENT);
    }
  }

  void addNackEndEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(NACK_END_EVENT);
    }
  }

  void addAckStartEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(ACK_START_EVENT);
    }
  }

  void addAckEndEvent() {
    if (subscriberSpan != null) {
      subscriberSpan.addEvent(ACK_END_EVENT);
    }
  }

  /** Ends the subscriber parent span if exists. */
  void endSubscriberSpan() {
    if (subscriberSpan != null) {
      subscriberSpan.end();
    }
  }

  /** Ends the subscribe concurreny control span if exists. */
  void endSubscribeConcurrencyControlSpan() {
    if (subscribeConcurrencyControlSpan != null) {
      subscribeConcurrencyControlSpan.end();
    }
  }

  /** Ends the subscribe scheduler span if exists. */
  void endSubscribeSchedulerSpan() {
    if (subscribeSchedulerSpan != null) {
      subscribeSchedulerSpan.end();
    }
  }

  /**
   * Ends the subscribe process span if it exists, creates an event with the appropriate result, and
   * sets the result on the parent subscriber span.
   */
  void endSubscribeProcessSpan(String action) {
    if (subscribeProcessSpan != null) {
      subscribeProcessSpan.addEvent(action + " called");
      subscribeProcessSpan.end();
      subscriberSpan.setAttribute(MESSAGE_RESULT_ATTR_KEY, action);
    }
  }

  /** Sets an exception on the subscriber span during Ack/ModAck/Nack failures */
  void setSubscriberSpanException(Throwable t, String exception) {
    if (subscriberSpan != null) {
      subscriberSpan.setStatus(StatusCode.ERROR, exception);
      subscriberSpan.recordException(t);
      endAllSubscribeSpans();
    }
  }

  /** Sets result of the parent subscriber span to expired and ends its. */
  void setSubscriberSpanExpirationResult() {
    if (subscriberSpan != null) {
      subscriberSpan.setAttribute(MESSAGE_RESULT_ATTR_KEY, "expired");
      endSubscriberSpan();
    }
  }

  /**
   * Sets an error status and records an exception when an exception is thrown subscriber
   * concurrency control.
   */
  void setSubscribeConcurrencyControlSpanException(Throwable t) {
    if (subscribeConcurrencyControlSpan != null) {
      subscribeConcurrencyControlSpan.setStatus(
          StatusCode.ERROR, "Exception thrown during subscribe concurrency control.");
      subscribeConcurrencyControlSpan.recordException(t);
      endAllSubscribeSpans();
    }
  }

  /** Ends all publisher-side spans associated with this message wrapper. */
  private void endAllPublishSpans() {
    endPublishFlowControlSpan();
    endPublishBatchingSpan();
    endPublisherSpan();
  }

  /** Ends all subscriber-side spans associated with this message wrapper. */
  private void endAllSubscribeSpans() {
    endSubscribeConcurrencyControlSpan();
    endSubscribeSchedulerSpan();
    endSubscriberSpan();
  }

  /**
   * Injects the span context into the attributes of a Pub/Sub message for propagation to the
   * subscriber client.
   */
  void injectSpanContext() {
    TextMapSetter<PubsubMessageWrapper> injectMessageAttributes =
        new TextMapSetter<PubsubMessageWrapper>() {
          @Override
          public void set(PubsubMessageWrapper carrier, String key, String value) {
            PubsubMessage newMessage =
                PubsubMessage.newBuilder(carrier.message)
                    .putAttributes(GOOGCLIENT_PREFIX + key, value)
                    .build();
            carrier.message = newMessage;
          }
        };
    W3CTraceContextPropagator.getInstance()
        .inject(Context.current().with(publisherSpan), this, injectMessageAttributes);
  }

  /**
   * Extracts the span context from the attributes of a Pub/Sub message and creates the parent
   * subscriber span using that context.
   */
  Context extractSpanContext(Attributes attributes) {
    TextMapGetter<PubsubMessageWrapper> extractMessageAttributes =
        new TextMapGetter<PubsubMessageWrapper>() {
          @Override
          public String get(PubsubMessageWrapper carrier, String key) {
            return carrier.message.getAttributesOrDefault(GOOGCLIENT_PREFIX + key, "");
          }

          public Iterable<String> keys(PubsubMessageWrapper carrier) {
            return carrier.message.getAttributesMap().keySet();
          }
        };
    Context context =
        W3CTraceContextPropagator.getInstance()
            .extract(Context.current(), this, extractMessageAttributes);
    return context;
  }

  /** Builder of {@link PubsubMessageWrapper PubsubMessageWrapper}. */
  static final class Builder {
    private PubsubMessage message = null;
    private TopicName topicName = null;
    private SubscriptionName subscriptionName = null;
    private String ackId = null;
    private int deliveryAttempt = 0;

    public Builder(PubsubMessage message, TopicName topicName) {
      this.message = message;
      this.topicName = topicName;
    }

    public Builder(
        PubsubMessage message,
        SubscriptionName subscriptionName,
        String ackId,
        int deliveryAttempt) {
      this.message = message;
      this.subscriptionName = subscriptionName;
      this.ackId = ackId;
      this.deliveryAttempt = deliveryAttempt;
    }

    public PubsubMessageWrapper build() {
      return new PubsubMessageWrapper(this);
    }
  }
}
