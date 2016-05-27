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

package com.google.cloud.pubsub;

import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.ServiceOptions.Clock;
import com.google.common.base.MoreObjects;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Class for an automatic ack deadline renewer. An ack deadline renewer automatically renews the
 * acknowledge deadline of messages added to it (via {@link #add(String, String)} or
 * {@link #add(String, Iterable)}. The acknowledge deadlines of added messages are renewed until the
 * messages are explicitly removed using {@link #remove(String, String)}.
 */
class AckDeadlineRenewer implements AutoCloseable {

  private static final int MIN_DEADLINE_MILLISECONDS = 10_000;
  private static final int RENEW_THRESHOLD_MILLISECONDS = 2_000;

  private final PubSub pubsub;
  private final ScheduledExecutorService executor;
  private final ExecutorFactory executorFactory;
  private final Clock clock;
  private final Queue<Message> messageQueue;
  private final Map<MessageId, Long> messageDeadlines;
  private final ScheduledFuture<?> renewerFuture;
  private final Object lock = new Object();

  /**
   * This class holds the identity of a message to renew: subscription and acknowledge id.
   */
  private static class MessageId {

    private final String subscription;
    private final String ackId;

    MessageId(String subscription, String ackId) {
      this.subscription = subscription;
      this.ackId = ackId;
    }

    String subscription() {
      return subscription;
    }

    String ackId() {
      return ackId;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof MessageId)) {
        return false;
      }
      MessageId other = (MessageId) obj;
      return Objects.equals(other.subscription, this.subscription)
          && Objects.equals(other.ackId, this.ackId);
    }

    @Override
    public int hashCode() {
      return Objects.hash(subscription, ackId);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("subscription", subscription)
          .add("ackId", ackId)
          .toString();
    }
  }

  /**
   * This class holds the identity of a message to renew and its expected ack deadline.
   */
  private static final class Message {

    private final MessageId messageId;
    private final Long deadline;

    Message(MessageId messageId, Long deadline) {
      this.messageId = messageId;
      this.deadline = deadline;
    }

    MessageId messageId() {
      return messageId;
    }

    Long expectedDeadline() {
      return deadline;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof Message)) {
        return false;
      }
      Message other = (Message) obj;
      return Objects.equals(other.messageId, this.messageId)
          && Objects.equals(other.deadline, this.deadline);
    }

    @Override
    public int hashCode() {
      return Objects.hash(messageId, deadline);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("messageId", messageId)
          .add("expectedDeadline", deadline)
          .toString();
    }
  }

  AckDeadlineRenewer(PubSub pubsub) {
    PubSubOptions options = pubsub.options();
    this.pubsub = pubsub;
    this.executorFactory = options.executorFactory();
    this.executor = executorFactory.get();
    this.clock = options.clock();
    this.messageQueue = new LinkedList<>();
    this.messageDeadlines = new HashMap<>();
    this.renewerFuture = this.executor.scheduleWithFixedDelay(new Runnable() {
      @Override
      public void run() {
        renewAckDeadlines();
      }
    }, 0, 1, TimeUnit.SECONDS);
  }

  private void renewAckDeadlines() {
    ListMultimap<String, String> messagesToRenewNext = LinkedListMultimap.create();
    // At every activation we renew all ack deadlines that will expier in the following
    // RENEW_THRESHOLD_MILLISECONDS
    long threshold = clock.millis() + RENEW_THRESHOLD_MILLISECONDS;
    Message message;
    while ((message = nextMessageToRenew(threshold)) != null) {
      // If the expected deadline is null the message was removed and we must ignore it, otherwise
      // we renew its ack deadline
      if (message.expectedDeadline() != null) {
        messagesToRenewNext.put(message.messageId().subscription(), message.messageId().ackId());
      }
    }
    for (Map.Entry<String, List<String>> entry : Multimaps.asMap(messagesToRenewNext).entrySet()) {
      // We send all ack deadline renewals for a subscription
      pubsub.modifyAckDeadlineAsync(entry.getKey(), MIN_DEADLINE_MILLISECONDS,
          TimeUnit.MILLISECONDS, entry.getValue());
    }
  }

  private Message nextMessageToRenew(long threshold) {
    synchronized (lock) {
      Message message = messageQueue.peek();
      // if the queue is empty or the next expected deadline is after threshold we stop
      if (message == null || message.expectedDeadline() > threshold) {
        return null;
      }
      MessageId messageId = messageQueue.poll().messageId();
      // Check if the next expected deadline changed. This can happen if the message was removed
      // from the ack deadline renewer or if it was nacked and then pulled again
      Long deadline = messageDeadlines.get(messageId);
      if (deadline == null || deadline > threshold) {
        // the message was removed (deadline == null) or removed and then added back
        // (deadline > threshold), we should not renew its deadline (yet)
        return new Message(messageId, null);
      } else {
        // Message deadline must be renewed, we must submit it again to the renewer
        add(messageId.subscription(), messageId.ackId());
        return new Message(messageId, deadline);
      }
    }
  }

  /**
   * Adds a new message for which the acknowledge deadline should be automatically renewed. The
   * message is identified by the subscription from which it was pulled and its acknowledge id.
   * Auto-renewal will take place until the message is removed (see {@link #remove(String, String)}
   * or {@link #remove(String, Iterable)}).
   *
   * @param subscription the subscription from which the message has been pulled
   * @param ackId the message's acknowledge id
   */
  void add(String subscription, String ackId) {
    synchronized (lock) {
      long deadline = clock.millis() + MIN_DEADLINE_MILLISECONDS;
      Message message = new Message(new MessageId(subscription, ackId), deadline);
      messageQueue.add(message);
      messageDeadlines.put(message.messageId(), deadline);
    }
  }

  /**
   * Adds new messages for which the acknowledge deadlined should be automatically renewed. The
   * messages are identified by the subscription from which they were pulled and their
   * acknowledge id. Auto-renewal will take place until the messages are removed (see
   * {@link #remove(String, String)} or {@link #remove(String, Iterable)}).
   *
   * @param subscription the subscription from which the messages have been pulled
   * @param ackIds the acknowledge ids of the messages
   */
  void add(String subscription, Iterable<String> ackIds) {
    synchronized (lock) {
      long deadline = clock.millis() + MIN_DEADLINE_MILLISECONDS;
      for (String ackId : ackIds) {
        Message message = new Message(new MessageId(subscription, ackId), deadline);
        messageQueue.add(message);
        messageDeadlines.put(message.messageId(), deadline);
      }
    }
  }

  /**
   * Removes a message from this {@code AckDeadlineRenewer}. The message is identified by the
   * subscription from which it was pulled and its acknowledge id. Once the message is removed from
   * this {@code AckDeadlineRenewer}, automated ack deadline renewals will stop.
   *
   * @param subscription the subscription from which the message has been pulled
   * @param ackId the message's acknowledge id
   */
  void remove(String subscription, String ackId) {
    synchronized (lock) {
      messageDeadlines.remove(new MessageId(subscription, ackId));
    }
  }

  @Override
  public void close() throws Exception {
    renewerFuture.cancel(false);
    executorFactory.release(executor);
  }
}
