/*
 * Copyright 2026 Google LLC
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
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LoggingUtil {
  // Instantiate all  loggers as static final fields to maintain strong references

  private static final Logger slowAckLogger = Logger.getLogger("slow-ack");
  private static final Logger callbackDeliveryLogger = Logger.getLogger("callback-delivery");
  private static final Logger expiryLogger = Logger.getLogger("expiry");
  private static final Logger callbackExceptionsLogger = Logger.getLogger("callback-exceptions");
  private static final Logger ackBatchLogger = Logger.getLogger("ack-batch");
  private static final Logger subscriberFlowControlLogger =
      Logger.getLogger("subscriber-flow-control");
  private static final Logger ackNackLogger = Logger.getLogger("ack-nack");
  private static final Logger publishBatchLogger = Logger.getLogger("publish-batch");
  private static final Logger subscriberStreamsLogger = Logger.getLogger("subscriber-streams");

  public enum SubSystem {
    SLOW_ACK(slowAckLogger),
    CALLBACK_DELIVERY(callbackDeliveryLogger),
    EXPIRY(expiryLogger),
    CALLBACK_EXCEPTIONS(callbackExceptionsLogger),
    ACK_BATCH(ackBatchLogger),
    SUBSCRIBER_FLOW_CONTROL(subscriberFlowControlLogger),
    ACK_NACK(ackNackLogger),
    PUBLISH_BATCH(publishBatchLogger),
    SUBSCRIBER_STREAMS(subscriberStreamsLogger);

    private final Logger logger;

    SubSystem(Logger logger) {
      this.logger = logger;
    }

    public Logger getLogger() {
      return logger;
    }
  }

  public LoggingUtil() {}

  private String getSubscriptionLogPrefix(
      PubsubMessageWrapper messageWrapper, String ackId, boolean exactlyOnceDeliveryEnabled) {
    if (messageWrapper == null || messageWrapper.getPubsubMessage() == null) {
      return " Ack ID: "
          + ackId
          + ", Exactly Once Delivery: "
          + exactlyOnceDeliveryEnabled
          + " (Message details not available)";
    }

    PubsubMessage message = messageWrapper.getPubsubMessage();
    String messageId = message.getMessageId();
    String orderingKey = message.getOrderingKey();

    StringBuilder sb = new StringBuilder();
    sb.append("Message ID: ").append(messageId);
    sb.append(", Ack ID: ").append(ackId);
    if (orderingKey != null && !orderingKey.isEmpty()) {
      sb.append(", Ordering Key: ").append(orderingKey);
    }
    sb.append(", Exactly Once Delivery: ").append(exactlyOnceDeliveryEnabled);
    return sb.toString();
  }

  private String getPublisherLogPrefix(PubsubMessageWrapper messageWrapper) {
    if (messageWrapper == null || messageWrapper.getPubsubMessage() == null) {
      return " (Message details not available)";
    }

    PubsubMessage message = messageWrapper.getPubsubMessage();
    String messageId = message.getMessageId();
    String orderingKey = message.getOrderingKey();

    StringBuilder sb = new StringBuilder();
    sb.append("Message ID: ").append(messageId);
    if (orderingKey != null && !orderingKey.isEmpty()) {
      sb.append(", Ordering Key: ").append(orderingKey);
    }
    return sb.toString();
  }

  public void logSubscriber(
      SubSystem subSystem,
      Level level,
      String msg,
      PubsubMessageWrapper messageWrapper,
      String ackId,
      boolean exactlyOnceDeliveryEnabled) {
    Logger logger = subSystem.getLogger();
    if (logger.isLoggable(level)) {
      String prefix = getSubscriptionLogPrefix(messageWrapper, ackId, exactlyOnceDeliveryEnabled);
      logger.log(level, prefix + " - " + msg);
    }
  }

  public void logSubscriberWithThrowable(
      SubSystem subSystem,
      Level level,
      String msg,
      PubsubMessageWrapper messageWrapper,
      String ackId,
      boolean exactlyOnceDeliveryEnabled,
      Throwable throwable) {
    Logger logger = subSystem.getLogger();
    if (logger.isLoggable(level)) {
      String prefix = getSubscriptionLogPrefix(messageWrapper, ackId, exactlyOnceDeliveryEnabled);
      logger.log(level, prefix + " - " + msg, throwable);
    }
  }

  public void logPublisher(
      SubSystem subSystem, Level level, String msg, PubsubMessageWrapper messageWrapper) {
    Logger logger = subSystem.getLogger();
    if (logger.isLoggable(level)) {
      String prefix = getPublisherLogPrefix(messageWrapper);
      logger.log(level, prefix + " - " + msg);
    }
  }

  public void logEvent(SubSystem subSystem, Level level, String msg, Object... params) {
    Logger logger = subSystem.getLogger();
    if (logger.isLoggable(level)) {
      logger.log(level, msg, params);
    }
  }
}
