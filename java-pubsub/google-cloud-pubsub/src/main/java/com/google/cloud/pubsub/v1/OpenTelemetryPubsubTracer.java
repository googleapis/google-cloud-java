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
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanBuilder;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import java.util.List;

public class OpenTelemetryPubsubTracer {
  private final Tracer tracer;
  private boolean enabled = false;

  private static final String PUBLISH_FLOW_CONTROL_SPAN_NAME = "publisher flow control";
  private static final String PUBLISH_BATCHING_SPAN_NAME = "publisher batching";
  private static final String SUBSCRIBE_CONCURRENCY_CONTROL_SPAN_NAME =
      "subscriber concurrency control";
  private static final String SUBSCRIBE_SCHEDULER_SPAN_NAME = "subscriber scheduler";

  private static final String MESSAGING_SYSTEM_ATTR_KEY = "messaging.system";
  private static final String MESSAGING_DESTINATION_NAME_ATTR_KEY = "messaging.destination.name";
  private static final String CODE_FUNCTION_ATTR_KEY = "code.function";
  private static final String MESSAGING_OPERATION_ATTR_KEY = "messaging.operation";
  private static final String MESSAGING_BATCH_MESSAGE_COUNT_ATTR_KEY =
      "messaging.batch.message_count";
  private static final String MESSAGING_MESSAGE_ID_ATTR_KEY = "messaging.message.id";
  private static final String MESSAGE_SIZE_ATTR_KEY = "messaging.message.body.size";
  private static final String ORDERING_KEY_ATTR_KEY = "messaging.gcp_pubsub.message.ordering_key";
  private static final String MESSAGE_ACK_ID_ATTR_KEY = "messaging.gcp_pubsub.message.ack_id";
  private static final String MESSAGE_EXACTLY_ONCE_ATTR_KEY =
      "messaging.gcp_pubsub.message.exactly_once_delivery";
  private static final String MESSAGE_DELIVERY_ATTEMPT_ATTR_KEY =
      "messaging.gcp_pubsub.message.delivery_attempt";
  private static final String ACK_DEADLINE_ATTR_KEY = "messaging.gcp_pubsub.message.ack_deadline";
  private static final String RECEIPT_MODACK_ATTR_KEY = "messaging.gcp_pubsub.is_receipt_modack";
  private static final String PROJECT_ATTR_KEY = "gcp.project_id";
  private static final String PUBLISH_RPC_SPAN_SUFFIX = " publish";

  private static final String MESSAGING_SYSTEM_VALUE = "gcp_pubsub";

  OpenTelemetryPubsubTracer(Tracer tracer, boolean enableOpenTelemetry) {
    this.tracer = tracer;
    if (this.tracer != null && enableOpenTelemetry) {
      this.enabled = true;
    }
  }

  /** Populates attributes that are common the publisher parent span and publish RPC span. */
  private static final AttributesBuilder createCommonSpanAttributesBuilder(
      String destinationName, String projectName, String codeFunction, String operation) {
    AttributesBuilder attributesBuilder =
        Attributes.builder()
            .put(MESSAGING_SYSTEM_ATTR_KEY, MESSAGING_SYSTEM_VALUE)
            .put(MESSAGING_DESTINATION_NAME_ATTR_KEY, destinationName)
            .put(PROJECT_ATTR_KEY, projectName)
            .put(CODE_FUNCTION_ATTR_KEY, codeFunction);
    if (operation != null) {
      attributesBuilder.put(MESSAGING_OPERATION_ATTR_KEY, operation);
    }

    return attributesBuilder;
  }

  private Span startChildSpan(String name, Span parent) {
    return tracer.spanBuilder(name).setParent(Context.current().with(parent)).startSpan();
  }

  /**
   * Creates and starts the parent span with the appropriate span attributes and injects the span
   * context into the {@link PubsubMessage} attributes.
   */
  void startPublisherSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    AttributesBuilder attributesBuilder =
        createCommonSpanAttributesBuilder(
            message.getTopicName(), message.getTopicProject(), "publish", "create");

    attributesBuilder.put(MESSAGE_SIZE_ATTR_KEY, message.getDataSize());
    if (!message.getOrderingKey().isEmpty()) {
      attributesBuilder.put(ORDERING_KEY_ATTR_KEY, message.getOrderingKey());
    }

    Span publisherSpan =
        tracer
            .spanBuilder(message.getTopicName() + " create")
            .setSpanKind(SpanKind.PRODUCER)
            .setAllAttributes(attributesBuilder.build())
            .startSpan();

    message.setPublisherSpan(publisherSpan);
    if (publisherSpan.getSpanContext().isValid()) {
      message.injectSpanContext();
    }
  }

  void endPublisherSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endPublisherSpan();
  }

  void setPublisherMessageIdSpanAttribute(PubsubMessageWrapper message, String messageId) {
    if (!enabled) {
      return;
    }
    message.setPublisherMessageIdSpanAttribute(messageId);
  }

  /** Creates a span for publish-side flow control as a child of the parent publisher span. */
  void startPublishFlowControlSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    Span publisherSpan = message.getPublisherSpan();
    if (publisherSpan != null)
      message.setPublishFlowControlSpan(
          startChildSpan(PUBLISH_FLOW_CONTROL_SPAN_NAME, publisherSpan));
  }

  void endPublishFlowControlSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endPublishFlowControlSpan();
  }

  void setPublishFlowControlSpanException(PubsubMessageWrapper message, Throwable t) {
    if (!enabled) {
      return;
    }
    message.setPublishFlowControlSpanException(t);
  }

  /** Creates a span for publish message batching as a child of the parent publisher span. */
  void startPublishBatchingSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    Span publisherSpan = message.getPublisherSpan();
    if (publisherSpan != null) {
      message.setPublishBatchingSpan(startChildSpan(PUBLISH_BATCHING_SPAN_NAME, publisherSpan));
    }
  }

  void endPublishBatchingSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endPublishBatchingSpan();
  }

  /**
   * Creates, starts, and returns a publish RPC span for the given message batch. Bi-directional
   * links with the publisher parent span are created for sampled messages in the batch.
   */
  Span startPublishRpcSpan(TopicName topicName, List<PubsubMessageWrapper> messages) {
    if (!enabled) {
      return null;
    }
    Attributes attributes =
        createCommonSpanAttributesBuilder(
                topicName.getTopic(), topicName.getProject(), "publishCall", "publish")
            .put(MESSAGING_BATCH_MESSAGE_COUNT_ATTR_KEY, messages.size())
            .build();
    SpanBuilder publishRpcSpanBuilder =
        tracer
            .spanBuilder(topicName.getTopic() + PUBLISH_RPC_SPAN_SUFFIX)
            .setSpanKind(SpanKind.CLIENT)
            .setAllAttributes(attributes);
    Attributes linkAttributes =
        Attributes.builder().put(MESSAGING_OPERATION_ATTR_KEY, "publish").build();
    for (PubsubMessageWrapper message : messages) {
      if (message.getPublisherSpan().getSpanContext().isSampled())
        publishRpcSpanBuilder.addLink(message.getPublisherSpan().getSpanContext(), linkAttributes);
    }
    Span publishRpcSpan = publishRpcSpanBuilder.startSpan();

    for (PubsubMessageWrapper message : messages) {
      if (publishRpcSpan.getSpanContext().isSampled()) {
        message.getPublisherSpan().addLink(publishRpcSpan.getSpanContext(), linkAttributes);
        message.addPublishStartEvent();
      }
    }
    return publishRpcSpan;
  }

  /** Ends the given publish RPC span if it exists. */
  void endPublishRpcSpan(Span publishRpcSpan) {
    if (!enabled) {
      return;
    }
    if (publishRpcSpan != null) {
      publishRpcSpan.end();
    }
  }

  /**
   * Sets an error status and records an exception when an exception is thrown when publishing the
   * message batch.
   */
  void setPublishRpcSpanException(Span publishRpcSpan, Throwable t) {
    if (!enabled) {
      return;
    }
    if (publishRpcSpan != null) {
      publishRpcSpan.setStatus(StatusCode.ERROR, "Exception thrown on publish RPC.");
      publishRpcSpan.recordException(t);
      publishRpcSpan.end();
    }
  }

  void startSubscriberSpan(PubsubMessageWrapper message, boolean exactlyOnceDeliveryEnabled) {
    if (!enabled) {
      return;
    }
    AttributesBuilder attributesBuilder =
        createCommonSpanAttributesBuilder(
            message.getSubscriptionName(), message.getSubscriptionProject(), "onResponse", null);

    attributesBuilder
        .put(MESSAGING_MESSAGE_ID_ATTR_KEY, message.getMessageId())
        .put(MESSAGE_SIZE_ATTR_KEY, message.getDataSize())
        .put(MESSAGE_ACK_ID_ATTR_KEY, message.getAckId())
        .put(MESSAGE_EXACTLY_ONCE_ATTR_KEY, exactlyOnceDeliveryEnabled);
    if (!message.getOrderingKey().isEmpty()) {
      attributesBuilder.put(ORDERING_KEY_ATTR_KEY, message.getOrderingKey());
    }
    if (message.getDeliveryAttempt() > 0) {
      attributesBuilder.put(MESSAGE_DELIVERY_ATTEMPT_ATTR_KEY, message.getDeliveryAttempt());
    }
    Attributes attributes = attributesBuilder.build();
    Context publisherSpanContext = message.extractSpanContext(attributes);
    message.setPublisherSpan(Span.fromContextOrNull(publisherSpanContext));
    message.setSubscriberSpan(
        tracer
            .spanBuilder(message.getSubscriptionName() + " subscribe")
            .setSpanKind(SpanKind.CONSUMER)
            .setParent(publisherSpanContext)
            .setAllAttributes(attributes)
            .startSpan());
  }

  void endSubscriberSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endSubscriberSpan();
  }

  void setSubscriberSpanExpirationResult(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.setSubscriberSpanExpirationResult();
  }

  void setSubscriberSpanException(PubsubMessageWrapper message, Throwable t, String exception) {
    if (!enabled) {
      return;
    }
    message.setSubscriberSpanException(t, exception);
  }

  /** Creates a span for subscribe concurrency control as a child of the parent subscriber span. */
  void startSubscribeConcurrencyControlSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    Span subscriberSpan = message.getSubscriberSpan();
    if (subscriberSpan != null) {
      message.setSubscribeConcurrencyControlSpan(
          startChildSpan(SUBSCRIBE_CONCURRENCY_CONTROL_SPAN_NAME, subscriberSpan));
    }
  }

  void endSubscribeConcurrencyControlSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endSubscribeConcurrencyControlSpan();
  }

  void setSubscribeConcurrencyControlSpanException(PubsubMessageWrapper message, Throwable t) {
    if (!enabled) {
      return;
    }
    message.setSubscribeConcurrencyControlSpanException(t);
  }

  /**
   * Creates a span for subscribe ordering key scheduling as a child of the parent subscriber span.
   */
  void startSubscribeSchedulerSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    Span subscriberSpan = message.getSubscriberSpan();
    if (subscriberSpan != null) {
      message.setSubscribeSchedulerSpan(
          startChildSpan(SUBSCRIBE_SCHEDULER_SPAN_NAME, subscriberSpan));
    }
  }

  void endSubscribeSchedulerSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    message.endSubscribeSchedulerSpan();
  }

  /** Creates a span for subscribe message processing as a child of the parent subscriber span. */
  void startSubscribeProcessSpan(PubsubMessageWrapper message) {
    if (!enabled) {
      return;
    }
    Span subscriberSpan = message.getSubscriberSpan();
    if (subscriberSpan != null) {
      Span subscribeProcessSpan =
          startChildSpan(message.getSubscriptionName() + " process", subscriberSpan);
      subscribeProcessSpan.setAttribute(MESSAGING_SYSTEM_ATTR_KEY, MESSAGING_SYSTEM_VALUE);
      Span publisherSpan = message.getPublisherSpan();
      if (publisherSpan != null) {
        subscribeProcessSpan.addLink(publisherSpan.getSpanContext());
      }
      message.setSubscribeProcessSpan(subscribeProcessSpan);
    }
  }

  void endSubscribeProcessSpan(PubsubMessageWrapper message, String action) {
    if (!enabled) {
      return;
    }
    message.endSubscribeProcessSpan(action);
  }

  /**
   * Creates, starts, and returns spans for ModAck, Nack, and Ack RPC requests. Bi-directional links
   * to parent subscribe span for sampled messages are added.
   */
  Span startSubscribeRpcSpan(
      SubscriptionName subscriptionName,
      String rpcOperation,
      List<PubsubMessageWrapper> messages,
      int ackDeadline,
      boolean isReceiptModack) {
    if (!enabled) {
      return null;
    }
    String codeFunction = rpcOperation == "ack" ? "sendAckOperations" : "sendModAckOperations";
    AttributesBuilder attributesBuilder =
        createCommonSpanAttributesBuilder(
                subscriptionName.getSubscription(),
                subscriptionName.getProject(),
                codeFunction,
                rpcOperation)
            .put(MESSAGING_BATCH_MESSAGE_COUNT_ATTR_KEY, messages.size());

    // Ack deadline and receipt modack are specific to the modack operation
    if (rpcOperation == "modack") {
      attributesBuilder
          .put(ACK_DEADLINE_ATTR_KEY, ackDeadline)
          .put(RECEIPT_MODACK_ATTR_KEY, isReceiptModack);
    }

    SpanBuilder rpcSpanBuilder =
        tracer
            .spanBuilder(subscriptionName.getSubscription() + " " + rpcOperation)
            .setSpanKind(SpanKind.CLIENT)
            .setAllAttributes(attributesBuilder.build());
    Attributes linkAttributes =
        Attributes.builder().put(MESSAGING_OPERATION_ATTR_KEY, rpcOperation).build();
    for (PubsubMessageWrapper message : messages) {
      if (message.getSubscriberSpan().getSpanContext().isSampled()) {
        rpcSpanBuilder.addLink(message.getSubscriberSpan().getSpanContext(), linkAttributes);
      }
    }
    Span rpcSpan = rpcSpanBuilder.startSpan();

    for (PubsubMessageWrapper message : messages) {
      if (rpcSpan.getSpanContext().isSampled()) {
        message.getSubscriberSpan().addLink(rpcSpan.getSpanContext(), linkAttributes);
        switch (rpcOperation) {
          case "ack":
            message.addAckStartEvent();
            break;
          case "modack":
            message.addModAckStartEvent();
            break;
          case "nack":
            message.addNackStartEvent();
            break;
        }
      }
    }
    return rpcSpan;
  }

  /** Ends the given subscribe RPC span if it exists. */
  void endSubscribeRpcSpan(Span rpcSpan) {
    if (!enabled) {
      return;
    }
    if (rpcSpan != null) {
      rpcSpan.end();
    }
  }

  /**
   * Sets an error status and records an exception when an exception is thrown when handling a
   * subscribe-side RPC.
   */
  void setSubscribeRpcSpanException(Span rpcSpan, boolean isModack, int ackDeadline, Throwable t) {
    if (!enabled) {
      return;
    }
    if (rpcSpan != null) {
      String operation = !isModack ? "ack" : (ackDeadline == 0 ? "nack" : "modack");
      rpcSpan.setStatus(StatusCode.ERROR, "Exception thrown on " + operation + " RPC.");
      rpcSpan.recordException(t);
      rpcSpan.end();
    }
  }

  /** Adds the appropriate subscribe-side RPC end event. */
  void addEndRpcEvent(
      PubsubMessageWrapper message, boolean rpcSampled, boolean isModack, int ackDeadline) {
    if (!enabled || !rpcSampled) {
      return;
    }
    if (!isModack) {
      message.addAckEndEvent();
    } else if (ackDeadline == 0) {
      message.addNackEndEvent();
    } else {
      message.addModAckEndEvent();
    }
  }
}
