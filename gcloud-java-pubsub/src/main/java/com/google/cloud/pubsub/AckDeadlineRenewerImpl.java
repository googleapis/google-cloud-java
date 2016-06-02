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

import static java.lang.StrictMath.min;
import static java.lang.StrictMath.pow;

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

class AckDeadlineRenewerImpl implements AckDeadlineRenewer {

  private static final int MIN_DEADLINE_MILLISECONDS = 10_000;
  private static final int RENEW_THRESHOLD_MILLISECONDS = 2_000;

  private final Object lock = new Object();
  private final ScheduledExecutorService executor;
  private final ExecutorFactory executorFactory;
  private final PubSub pubsub;
  private final Clock clock;
  private final AckDeadlineRenewParams renewParams;
  private final Queue<Message> messageQueue;
  private final Map<MessageId, ExpectedDeadlineAndCount> messageDeadlines;
  private final ScheduledFuture<?> renewerFuture;

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

    /**
     * Returns the subscription name.
     */
    String subscription() {
      return subscription;
    }

    /**
     * Returns the message acknowledge id.
     */
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
  private static final class Message implements Comparable<Message> {

    private final MessageId messageId;
    private final Long expectedDeadline;

    Message(MessageId messageId, Long expectedDeadline) {
      this.messageId = messageId;
      this.expectedDeadline = expectedDeadline;
    }

    MessageId messageId() {
      return messageId;
    }

    Long expectedDeadline() {
      return expectedDeadline;
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
          && Objects.equals(other.expectedDeadline, this.expectedDeadline);
    }

    @Override
    public int hashCode() {
      return Objects.hash(messageId, expectedDeadline);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("messageId", messageId)
          .add("expectedDeadline", expectedDeadline)
          .toString();
    }

    @Override
    public int compareTo(Message other) {
      return expectedDeadline.compareTo(other.expectedDeadline);
    }
  }

  /**
   * This class holds the most updated expected deadline for a message and its renewal count.
   */
  private static final class ExpectedDeadlineAndCount {

    private final long expectedDeadline;
    private final long renewalCount;

    ExpectedDeadlineAndCount(long expectedDeadline, long renewalCount) {
      this.expectedDeadline = expectedDeadline;
      this.renewalCount = renewalCount;
    }

    /**
     * Returns the expected deadline.
     */
    long expectedDeadline() {
      return expectedDeadline;
    }

    /**
     * Returns how many times a message has been renewed so far.
     */
    long renewalCount() {
      return renewalCount;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof ExpectedDeadlineAndCount)) {
        return false;
      }
      ExpectedDeadlineAndCount other = (ExpectedDeadlineAndCount) obj;
      return Objects.equals(other.expectedDeadline, this.expectedDeadline)
          && Objects.equals(other.renewalCount, this.renewalCount);
    }

    @Override
    public int hashCode() {
      return Objects.hash(expectedDeadline, renewalCount);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("expectedDeadline", expectedDeadline)
          .add("renewalCount", renewalCount)
          .toString();
    }
  }

  /**
   * This class holds a subscription name and a relative acknowledge deadline. Objects of this class
   * are used to group messages before renewing their deadline, to limit the number of requests
   * needed.
   */
  private static final class SubscriptionAndDeadline {

    private final String subscription;
    private final int relativeDeadline;

    SubscriptionAndDeadline(String subscription, int relativeDeadline) {
      this.subscription = subscription;
      this.relativeDeadline = relativeDeadline;
    }

    /**
     * Returns the subscription name.
     */
    String subscription() {
      return subscription;
    }

    /**
     * Return the relative acknowledge deadline, used to send modify ack deadline requests.
     */
    int relativeDeadline() {
      return relativeDeadline;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof SubscriptionAndDeadline)) {
        return false;
      }
      SubscriptionAndDeadline other = (SubscriptionAndDeadline) obj;
      return Objects.equals(other.subscription, this.subscription)
          && Objects.equals(other.relativeDeadline, this.relativeDeadline);
    }

    @Override
    public int hashCode() {
      return Objects.hash(subscription, relativeDeadline);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("subscription", subscription)
          .add("relativeDeadline", relativeDeadline)
          .toString();
    }
  }

  AckDeadlineRenewerImpl(PubSubOptions options) {
    this.executorFactory = options.executorFactory();
    this.executor = executorFactory.get();
    this.pubsub = options.service();
    this.clock = options.clock();
    this.renewParams = options.ackDeadlineRenewParams();
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
    ListMultimap<SubscriptionAndDeadline, String> messagesToRenewNext = LinkedListMultimap.create();
    long threshold = clock.millis() + RENEW_THRESHOLD_MILLISECONDS;
    while (nextMessageToRenew(messagesToRenewNext, threshold)) {
      // keep adding messages for which the ack deadline must be renewed
    }
    for (Map.Entry<SubscriptionAndDeadline, List<String>> entry :
        Multimaps.asMap(messagesToRenewNext).entrySet()) {
      // We send all ack deadline renewals for a pair (subscription, relativeDeadline)
      pubsub.modifyAckDeadlineAsync(entry.getKey().subscription(),
          entry.getKey().relativeDeadline(), TimeUnit.MILLISECONDS, entry.getValue());
    }
  }

  /**
   * This method adds to {@code messagesToRenewNext} a message whose acknowledge deadline must be
   * renewed (if any exists). Returns {@code true} if other messages to renew may exist,
   * {@code false} otherwise.
   */
  private boolean nextMessageToRenew(
      ListMultimap<SubscriptionAndDeadline, String> messagesToRenewNext, long threshold) {
    synchronized (lock) {
      Message message = messageQueue.peek();
      // if the message does not exist or the next expected deadline is after threshold we stop
      if (message == null || message.expectedDeadline() > threshold) {
        return false;
      }
      MessageId messageId = messageQueue.poll().messageId();
      // Check if the next expected deadline changed. This can happen if the message was removed
      // from the ack deadline renewer or if it was nacked and then pulled again
      ExpectedDeadlineAndCount deadlineAndCount = messageDeadlines.get(messageId);
      Long deadline = deadlineAndCount != null ? deadlineAndCount.expectedDeadline() : null;
      if (deadline != null && deadline < threshold) {
        // Message deadline must be renewed, we must submit it again to the renewer and increment
        // renewal count
        int nextRelativeDeadline =
            nextRelativeDeadline(renewParams, deadlineAndCount.renewalCount());
        update(messageId, clock.millis() + nextRelativeDeadline);
        messagesToRenewNext.put(
            new SubscriptionAndDeadline(messageId.subscription(), nextRelativeDeadline),
            messageId.ackId());
      }
      return true;
    }
  }

  private static int nextRelativeDeadline(AckDeadlineRenewParams renewParams, long renewals) {
    return (int) TimeUnit.MILLISECONDS.convert((int) min(renewParams.maxDeadlineSeconds(),
        pow(renewParams.deadlineBackoffFactor(), renewals)
            * renewParams.initialDeadlineSeconds()), TimeUnit.SECONDS);
  }

  private void update(MessageId messageId, long expectedDeadline) {
    synchronized (lock) {
      Message message = new Message(messageId, expectedDeadline);
      messageQueue.add(message);
      ExpectedDeadlineAndCount count = messageDeadlines.get(messageId);
      messageDeadlines.put(message.messageId(),
          new ExpectedDeadlineAndCount(expectedDeadline, count.renewalCount + 1));
    }
  }

  private void add(MessageId messageId, long expectedDeadline) {
    synchronized (lock) {
      Message message = new Message(messageId, expectedDeadline);
      messageQueue.add(message);
      messageDeadlines.put(message.messageId(), new ExpectedDeadlineAndCount(expectedDeadline, 0L));
    }
  }

  @Override
  public void add(String subscription, String ackId) {
    long expectedDeadline = clock.millis() + MIN_DEADLINE_MILLISECONDS;
    add(new MessageId(subscription, ackId), expectedDeadline);
  }

  @Override
  public void add(String subscription, Iterable<String> ackIds) {
    long expectedDeadline = clock.millis() + MIN_DEADLINE_MILLISECONDS;
    for (String ackId : ackIds) {
      add(new MessageId(subscription, ackId), expectedDeadline);
    }
  }

  @Override
  public void remove(String subscription, String ackId) {
    synchronized (lock) {
      messageDeadlines.remove(new MessageId(subscription, ackId));
    }
  }

  @Override
  public void remove(String subscription, Iterable<String> ackIds) {
    for (String ackId : ackIds) {
      messageDeadlines.remove(new MessageId(subscription, ackId));
    }
  }

  @Override
  public void close() throws Exception {
    renewerFuture.cancel(false);
    executorFactory.release(executor);
  }
}
