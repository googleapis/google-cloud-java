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

import com.google.auth.Credentials;
import com.google.cloud.Clock;
import com.google.cloud.pubsub.Publisher.CloudPubsubFlowControlException;
import com.google.cloud.pubsub.Subscriber.MessageReceiver;
import com.google.cloud.pubsub.Subscriber.MessageReceiver.AckReply;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract base implementation class of a subscriber connection in charge of receiving subscription
 * messages.
 */
abstract class AbstractSubscriberConnection extends AbstractService {
  private static final Logger logger = LoggerFactory.getLogger(AbstractSubscriberConnection.class);

  private static final int INITIAL_ACK_DEADLINE_EXTENSION_SECONDS = 2;
  @VisibleForTesting static final Duration PENDING_ACKS_SEND_DELAY = Duration.millis(100);
  private static final int MAX_ACK_DEADLINE_EXTENSION_SECS = 10 * 60;  // 10m

  protected final String subscription;
  protected final ScheduledExecutorService executor;
  private final Clock clock;

  private final Duration ackExpirationPadding;
  private final MessageReceiver receiver;

  private final FlowController flowController;
  private final MessagesWaiter messagesWaiter;

  // Map of outstanding messages (value) ordered by expiration time (key) in ascending order.
  private final Map<ExpirationInfo, List<AckHandler>> outstandingAckHandlers;
  private final Set<String> pendingAcks;
  private final Set<String> pendingNacks;

  private final Lock alarmsLock;
  private int messageDeadlineSeconds;
  private ScheduledFuture<?> ackDeadlineExtensionAlarm;
  private Instant nextAckDeadlineExtensionAlarmTime;
  private ScheduledFuture<?> pendingAcksAlarm;

  // To keep track of number of seconds the receiver takes to process messages.
  private final Distribution ackLatencyDistribution;

  private static class ExpirationInfo implements Comparable<ExpirationInfo> {
    private final Clock clock;
    Instant expiration;
    int nextExtensionSeconds;

    ExpirationInfo(Clock clock, Instant expiration, int initialAckDeadlineExtension) {
      this.clock = clock;
      this.expiration = expiration;
      nextExtensionSeconds = initialAckDeadlineExtension;
    }

    void extendExpiration() {
      expiration = new Instant(clock.millis()).plus(Duration.standardSeconds(nextExtensionSeconds));
      nextExtensionSeconds = 2 * nextExtensionSeconds;
      if (nextExtensionSeconds > MAX_ACK_DEADLINE_EXTENSION_SECS) {
        nextExtensionSeconds = MAX_ACK_DEADLINE_EXTENSION_SECS;
      }
    }

    @Override
    public int hashCode() {
      return expiration.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ExpirationInfo)) {
        return false;
      }

      ExpirationInfo other = (ExpirationInfo) obj;
      return expiration.equals(other.expiration);
    }

    @Override
    public int compareTo(ExpirationInfo other) {
      return expiration.compareTo(other.expiration);
    }
  }

  /** Stores the data needed to asynchronously modify acknowledgement deadlines. */
  static class PendingModifyAckDeadline {
    final List<String> ackIds;
    final int deadlineExtensionSeconds;

    PendingModifyAckDeadline(int deadlineExtensionSeconds) {
      this.ackIds = new ArrayList<String>();
      this.deadlineExtensionSeconds = deadlineExtensionSeconds;
    }

    PendingModifyAckDeadline(String ackId, int deadlineExtensionSeconds) {
      this(deadlineExtensionSeconds);
      addAckId(ackId);
    }

    public void addAckId(String ackId) {
      ackIds.add(ackId);
    }
  }

  /** Handles callbacks for acking/nacking messages from the {@link MessageReceiver}. */
  private class AckHandler implements FutureCallback<AckReply> {
    private final String ackId;
    private final int outstandingBytes;
    private final AtomicBoolean acked;
    private final Instant receivedTime;

    AckHandler(String ackId, int outstandingBytes) {
      this.ackId = ackId;
      this.outstandingBytes = outstandingBytes;
      acked = new AtomicBoolean(false);
      receivedTime = new Instant(clock.millis());
    }

    @Override
    public void onFailure(Throwable t) {
      logger.warn(
          "MessageReceiver failed to processes ack ID: " + ackId + ", the message will be nacked.",
          t);
      synchronized (pendingNacks) {
        pendingNacks.add(ackId);
      }
      setupPendingAcksAlarm();
      flowController.release(1, outstandingBytes);
      messagesWaiter.incrementPendingMessages(-1);
    }

    @Override
    public void onSuccess(AckReply reply) {
      acked.getAndSet(true);
      switch (reply) {
        case ACK:
          synchronized (pendingAcks) {
            pendingAcks.add(ackId);
          }
          setupPendingAcksAlarm();
          flowController.release(1, outstandingBytes);
          // Record the latency rounded to the next closest integer.
          ackLatencyDistribution.record(
              Ints.saturatedCast(
                  (long) Math.ceil((clock.millis() - receivedTime.getMillis()) / 1000D)));
          messagesWaiter.incrementPendingMessages(-1);
          return;
        case NACK:
          synchronized (pendingNacks) {
            pendingNacks.add(ackId);
          }
          setupPendingAcksAlarm();
          flowController.release(1, outstandingBytes);
          messagesWaiter.incrementPendingMessages(-1);
          return;
        default:
          throw new IllegalArgumentException(String.format("AckReply: %s not supported", reply));
      }
    }
  }

  AbstractSubscriberConnection(
      String subscription,
      MessageReceiver receiver,
      Duration ackExpirationPadding,
      Distribution ackLatencyDistribution,
      FlowController flowController,
      ScheduledExecutorService executor,
      Clock clock) {
    this.executor = executor;
    this.ackExpirationPadding = ackExpirationPadding;
    this.receiver = receiver;
    this.subscription = subscription;
    this.flowController = flowController;
    outstandingAckHandlers = new HashMap<>();
    pendingAcks = new HashSet<>();
    pendingNacks = new HashSet<>();
    // 601 buckets of 1s resolution from 0s to MAX_ACK_DEADLINE_SECONDS
    this.ackLatencyDistribution = ackLatencyDistribution;
    alarmsLock = new ReentrantLock();
    nextAckDeadlineExtensionAlarmTime = new Instant(Long.MAX_VALUE);
    messagesWaiter = new MessagesWaiter();
    this.clock = clock;
  }

  @Override
  protected void doStart() {
    logger.debug("Starting subscriber.");
    initialize();
    notifyStarted();
  }

  abstract void initialize();

  @Override
  protected void doStop() {
    messagesWaiter.waitNoMessages();
    alarmsLock.lock();
    try {
      if (ackDeadlineExtensionAlarm != null) {
        ackDeadlineExtensionAlarm.cancel(true);
        ackDeadlineExtensionAlarm = null;
      }
    } finally {
      alarmsLock.unlock();
    }
    processOutstandingAckOperations();
    notifyStopped();
  }

  protected boolean isRetryable(Status status) {
    switch (status.getCode()) {
      case DEADLINE_EXCEEDED:
      case INTERNAL:
      case CANCELLED:
      case RESOURCE_EXHAUSTED:
      case UNAVAILABLE:
        return true;
      default:
        return false;
    }
  }

  protected void setMessageDeadlineSeconds(int messageDeadlineSeconds) {
    this.messageDeadlineSeconds = messageDeadlineSeconds;
  }

  protected int getMessageDeadlineSeconds() {
    return messageDeadlineSeconds;
  }

  protected void processReceivedMessages(
      List<com.google.pubsub.v1.ReceivedMessage> responseMessages) {
    int receivedMessagesCount = responseMessages.size();
    if (receivedMessagesCount == 0) {
      return;
    }
    Instant now = new Instant(clock.millis());
    int totalByteCount = 0;
    final List<AckHandler> ackHandlers = new ArrayList<>(responseMessages.size());
    for (ReceivedMessage pubsubMessage : responseMessages) {
      int messageSize = pubsubMessage.getMessage().getSerializedSize();
      totalByteCount += messageSize;
      ackHandlers.add(new AckHandler(pubsubMessage.getAckId(), messageSize));
    }
    ExpirationInfo expiration =
        new ExpirationInfo(
            clock, now.plus(messageDeadlineSeconds * 1000), INITIAL_ACK_DEADLINE_EXTENSION_SECONDS);
    synchronized (outstandingAckHandlers) {
      addOutstadingAckHandlers(expiration, ackHandlers);
    }
    logger.debug("Received {} messages at {}", responseMessages.size(), now);
    setupNextAckDeadlineExtensionAlarm(expiration);

    messagesWaiter.incrementPendingMessages(responseMessages.size());
    Iterator<AckHandler> acksIterator = ackHandlers.iterator();
    for (ReceivedMessage userMessage : responseMessages) {
      final PubsubMessage message = userMessage.getMessage();
      final AckHandler ackHandler = acksIterator.next();
      executor.submit(
          new Runnable() {
            @Override
            public void run() {
              Futures.addCallback(receiver.receiveMessage(message), ackHandler);
            }
          });
    }
    try {
      flowController.reserve(receivedMessagesCount, totalByteCount);
    } catch (CloudPubsubFlowControlException unexpectedException) {
      throw new IllegalStateException("Flow control unexpected exception", unexpectedException);
    }
  }

  private void addOutstadingAckHandlers(
      ExpirationInfo expiration, final List<AckHandler> ackHandlers) {
    if (!outstandingAckHandlers.containsKey(expiration)) {
      outstandingAckHandlers.put(expiration, new ArrayList<AckHandler>(ackHandlers.size()));
    }
    outstandingAckHandlers.get(expiration).addAll(ackHandlers);
  }

  private void setupPendingAcksAlarm() {
    alarmsLock.lock();
    try {
      if (pendingAcksAlarm == null) {
        pendingAcksAlarm =
            executor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    alarmsLock.lock();
                    try {
                      pendingAcksAlarm = null;
                    } finally {
                      alarmsLock.unlock();
                    }
                    processOutstandingAckOperations();
                  }
                },
                PENDING_ACKS_SEND_DELAY.getMillis(),
                TimeUnit.MILLISECONDS);
      }
    } finally {
      alarmsLock.unlock();
    }
  }

  private class AckDeadlineAlarm implements Runnable {
    @Override
    public void run() {
      alarmsLock.lock();
      try {
        nextAckDeadlineExtensionAlarmTime = new Instant(Long.MAX_VALUE);
        ackDeadlineExtensionAlarm = null;
        if (pendingAcksAlarm != null) {
          pendingAcksAlarm.cancel(false);
          pendingAcksAlarm = null;
        }
      } finally {
        alarmsLock.unlock();
      }

      Instant now = new Instant(clock.millis());
      // Rounded to the next second, so we only schedule future alarms at the second
      // resolution.
      Instant cutOverTime =
          new Instant(
              ((long) Math.ceil(now.plus(ackExpirationPadding).plus(500).getMillis() / 1000.0))
                  * 1000L);
      logger.debug(
          "Running alarm sent outstanding acks, at now time: {}, with cutover "
              + "time: {}, padding: {}",
          now,
          cutOverTime,
          ackExpirationPadding);
      ExpirationInfo nextScheduleExpiration = null;
      List<PendingModifyAckDeadline> modifyAckDeadlinesToSend = new ArrayList<>();

      synchronized (outstandingAckHandlers) {
        for (ExpirationInfo messageExpiration : outstandingAckHandlers.keySet()) {
          if (messageExpiration.expiration.compareTo(cutOverTime) <= 0) {
            Collection<AckHandler> expiringAcks = outstandingAckHandlers.get(messageExpiration);
            outstandingAckHandlers.remove(messageExpiration);
            List<AckHandler> renewedAckHandlers = new ArrayList<>(expiringAcks.size());
            messageExpiration.extendExpiration();
            int extensionSeconds =
                Ints.saturatedCast(
                    new Interval(now, messageExpiration.expiration)
                        .toDuration()
                        .getStandardSeconds());
            PendingModifyAckDeadline pendingModAckDeadline =
                new PendingModifyAckDeadline(extensionSeconds);
            for (AckHandler ackHandler : expiringAcks) {
              if (ackHandler.acked.get()) {
                continue;
              }
              pendingModAckDeadline.addAckId(ackHandler.ackId);
              renewedAckHandlers.add(ackHandler);
            }
            modifyAckDeadlinesToSend.add(pendingModAckDeadline);
            if (!renewedAckHandlers.isEmpty()) {
              addOutstadingAckHandlers(messageExpiration, renewedAckHandlers);
            } else {
              outstandingAckHandlers.remove(messageExpiration);
            }
          }
          if (nextScheduleExpiration == null
              || nextScheduleExpiration.expiration.isAfter(messageExpiration.expiration)) {
            nextScheduleExpiration = messageExpiration;
          }
        }
      }

      processOutstandingAckOperations(modifyAckDeadlinesToSend);

      if (nextScheduleExpiration != null) {
        logger.debug(
            "Scheduling based on outstanding, now time: {}, " + "next schedule time: {}",
            now,
            nextScheduleExpiration);
        setupNextAckDeadlineExtensionAlarm(nextScheduleExpiration);
      }
    }
  }

  private void setupNextAckDeadlineExtensionAlarm(ExpirationInfo messageExpiration) {
    Instant possibleNextAlarmTime = messageExpiration.expiration.minus(ackExpirationPadding);
    alarmsLock.lock();
    try {
      if (nextAckDeadlineExtensionAlarmTime.isAfter(possibleNextAlarmTime)) {
        logger.debug(
            "Scheduling next alarm time: {}, last alarm set to time: {}",
            possibleNextAlarmTime,
            nextAckDeadlineExtensionAlarmTime);
        if (ackDeadlineExtensionAlarm != null) {
          logger.debug("Canceling previous alarm");
          ackDeadlineExtensionAlarm.cancel(false);
        }

        nextAckDeadlineExtensionAlarmTime = possibleNextAlarmTime;

        ackDeadlineExtensionAlarm =
            executor.schedule(
                new AckDeadlineAlarm(),
                nextAckDeadlineExtensionAlarmTime.getMillis() - clock.millis(),
                TimeUnit.MILLISECONDS);
      }

    } finally {
      alarmsLock.unlock();
    }
  }

  private void processOutstandingAckOperations() {
    processOutstandingAckOperations(new ArrayList<PendingModifyAckDeadline>());
  }

  private void processOutstandingAckOperations(
      List<PendingModifyAckDeadline> ackDeadlineExtensions) {
    List<PendingModifyAckDeadline> modifyAckDeadlinesToSend =
        Lists.newArrayList(ackDeadlineExtensions);
    List<String> acksToSend = new ArrayList<>(pendingAcks.size());
    synchronized (pendingAcks) {
      if (!pendingAcks.isEmpty()) {
        try {
          acksToSend = new ArrayList<>(pendingAcks);
          logger.debug("Sending {} acks", acksToSend.size());
        } finally {
          pendingAcks.clear();
        }
      }
    }
    PendingModifyAckDeadline nacksToSend = new PendingModifyAckDeadline(0);
    synchronized (pendingNacks) {
      if (!pendingNacks.isEmpty()) {
        try {
          for (String ackId : pendingNacks) {
            nacksToSend.addAckId(ackId);
          }
          logger.debug("Sending {} nacks", pendingNacks.size());
        } finally {
          pendingNacks.clear();
        }
        modifyAckDeadlinesToSend.add(nacksToSend);
      }
    }

    sendAckOperations(acksToSend, modifyAckDeadlinesToSend);
  }

  abstract void sendAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions);
}
