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

package com.google.cloud.pubsub.spi.v1;

import com.google.api.gax.grpc.FlowController;
import com.google.api.stats.Distribution;
import com.google.cloud.Clock;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.pubsub.v1.PubsubMessage;
import com.google.pubsub.v1.ReceivedMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.Duration;
import org.joda.time.Instant;
import org.joda.time.Interval;

/**
 * Dispatches messages to a message receiver while handling the messages acking and lease
 * extensions.
 */
class MessageDispatcher {
  private static final Logger logger = Logger.getLogger(MessageDispatcher.class.getName());

  private static final int INITIAL_ACK_DEADLINE_EXTENSION_SECONDS = 2;
  @VisibleForTesting static final Duration PENDING_ACKS_SEND_DELAY = Duration.millis(100);
  private static final int MAX_ACK_DEADLINE_EXTENSION_SECS = 10 * 60; // 10m

  private final ScheduledExecutorService executor;
  private final Clock clock;

  private final Duration ackExpirationPadding;
  private final MessageReceiver receiver;
  private final AckProcessor ackProcessor;

  private final FlowController flowController;
  private final MessageWaiter messagesWaiter;

  private final PriorityQueue<ExtensionJob> outstandingAckHandlers;
  private final Set<String> pendingAcks;
  private final Set<String> pendingNacks;

  private final Lock alarmsLock;
  private int messageDeadlineSeconds;
  private ScheduledFuture<?> ackDeadlineExtensionAlarm;
  private Instant nextAckDeadlineExtensionAlarmTime;
  private ScheduledFuture<?> pendingAcksAlarm;

  // To keep track of number of seconds the receiver takes to process messages.
  private final Distribution ackLatencyDistribution;

  // ExtensionJob represents a group of {@code AckHandler}s that shares the same expiration.
  //
  // It is Comparable so that it may be put in a PriorityQueue.
  // For efficiency, it is also mutable, so great care should be taken to make sure
  // it is not modified while inside the queue.
  // The hashcode and equals methods are explicitly not implemented to discourage
  // the use of this class as keys in maps or similar containers.
  private static class ExtensionJob implements Comparable<ExtensionJob> {
    Instant expiration;
    int nextExtensionSeconds;
    ArrayList<AckHandler> ackHandlers;

    ExtensionJob(
        Instant expiration, int initialAckDeadlineExtension, ArrayList<AckHandler> ackHandlers) {
      this.expiration = expiration;
      nextExtensionSeconds = initialAckDeadlineExtension;
      this.ackHandlers = ackHandlers;
    }

    void extendExpiration(Instant now) {
      expiration = now.plus(Duration.standardSeconds(nextExtensionSeconds));
      nextExtensionSeconds = Math.min(2 * nextExtensionSeconds, MAX_ACK_DEADLINE_EXTENSION_SECS);
    }

    @Override
    public int compareTo(ExtensionJob other) {
      return expiration.compareTo(other.expiration);
    }

    public String toString() {
      ArrayList<String> ackIds = new ArrayList<>();
      for (AckHandler ah : ackHandlers) {
        ackIds.add(ah.ackId);
      }
      return String.format(
          "ExtensionJob {expiration: %s, nextExtensionSeconds: %d, ackIds: %s}",
          expiration, nextExtensionSeconds, ackIds);
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

    public String toString() {
      return String.format(
          "PendingModifyAckDeadline{extension: %d sec, ackIds: %s}",
          deadlineExtensionSeconds, ackIds);
    }
  }

  /**
   * Handles callbacks for acking/nacking messages from the {@link
   * com.google.cloud.pubsub.deprecated.MessageReceiver}.
   */
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
      logger.log(
          Level.WARNING,
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

  public interface AckProcessor {
    void sendAckOperations(
        List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions);
  }

  MessageDispatcher(
      MessageReceiver receiver,
      AckProcessor ackProcessor,
      Duration ackExpirationPadding,
      Distribution ackLatencyDistribution,
      FlowController flowController,
      ScheduledExecutorService executor,
      Clock clock) {
    this.executor = executor;
    this.ackExpirationPadding = ackExpirationPadding;
    this.receiver = receiver;
    this.ackProcessor = ackProcessor;
    this.flowController = flowController;
    outstandingAckHandlers = new PriorityQueue<>();
    pendingAcks = new HashSet<>();
    pendingNacks = new HashSet<>();
    // 601 buckets of 1s resolution from 0s to MAX_ACK_DEADLINE_SECONDS
    this.ackLatencyDistribution = ackLatencyDistribution;
    alarmsLock = new ReentrantLock();
    nextAckDeadlineExtensionAlarmTime = new Instant(Long.MAX_VALUE);
    messagesWaiter = new MessageWaiter();
    this.clock = clock;
  }

  public void stop() {
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
  }

  public void setMessageDeadlineSeconds(int messageDeadlineSeconds) {
    this.messageDeadlineSeconds = messageDeadlineSeconds;
  }

  public int getMessageDeadlineSeconds() {
    return messageDeadlineSeconds;
  }

  public void processReceivedMessages(List<com.google.pubsub.v1.ReceivedMessage> responseMessages) {
    int receivedMessagesCount = responseMessages.size();
    if (receivedMessagesCount == 0) {
      return;
    }
    Instant now = new Instant(clock.millis());
    int totalByteCount = 0;
    final ArrayList<AckHandler> ackHandlers = new ArrayList<>(responseMessages.size());
    for (ReceivedMessage pubsubMessage : responseMessages) {
      int messageSize = pubsubMessage.getMessage().getSerializedSize();
      totalByteCount += messageSize;
      ackHandlers.add(new AckHandler(pubsubMessage.getAckId(), messageSize));
    }
    Instant expiration = now.plus(messageDeadlineSeconds * 1000);
    logger.log(Level.INFO, "Received " + responseMessages.size() + " messages at " + now);

    messagesWaiter.incrementPendingMessages(responseMessages.size());
    Iterator<AckHandler> acksIterator = ackHandlers.iterator();
    for (ReceivedMessage userMessage : responseMessages) {
      final PubsubMessage message = userMessage.getMessage();
      final AckHandler ackHandler = acksIterator.next();
      final SettableFuture<AckReply> response = SettableFuture.create();
      final AckReplyConsumer consumer =
          new AckReplyConsumer() {
            @Override
            public void accept(AckReply reply, Throwable t) {
              if (reply != null) {
                response.set(reply);
              } else {
                response.setException(t);
              }
            }
          };
      Futures.addCallback(response, ackHandler);
      executor.submit(
          new Runnable() {
            @Override
            public void run() {
              receiver.receiveMessage(message, consumer);
            }
          });
    }

    synchronized (outstandingAckHandlers) {
      outstandingAckHandlers.add(
          new ExtensionJob(expiration, INITIAL_ACK_DEADLINE_EXTENSION_SECONDS, ackHandlers));
    }
    setupNextAckDeadlineExtensionAlarm(expiration);

    try {
      flowController.reserve(receivedMessagesCount, totalByteCount);
    } catch (FlowController.FlowControlException unexpectedException) {
      throw new IllegalStateException("Flow control unexpected exception", unexpectedException);
    }
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
      logger.log(
          Level.INFO,
          "Running alarm sent outstanding acks, at now time: "
              + now
              + ", with cutover time: "
              + cutOverTime
              + ", padding: "
              + ackExpirationPadding);
      Instant nextScheduleExpiration = null;
      List<PendingModifyAckDeadline> modifyAckDeadlinesToSend = new ArrayList<>();

      // Holding area for jobs we'll put back into the queue
      // so we don't process the same job twice.
      List<ExtensionJob> renewJobs = new ArrayList<>();

      synchronized (outstandingAckHandlers) {
        while (!outstandingAckHandlers.isEmpty()
            && outstandingAckHandlers.peek().expiration.compareTo(cutOverTime) <= 0) {
          ExtensionJob job = outstandingAckHandlers.poll();

          // If a message has already been acked, remove it, nothing to do.
          for (int i = 0; i < job.ackHandlers.size(); ) {
            if (job.ackHandlers.get(i).acked.get()) {
              Collections.swap(job.ackHandlers, i, job.ackHandlers.size() - 1);
              job.ackHandlers.remove(job.ackHandlers.size() - 1);
            } else {
              i++;
            }
          }

          if (job.ackHandlers.isEmpty()) {
            continue;
          }

          job.extendExpiration(now);
          int extensionSeconds =
              Ints.saturatedCast(
                  new Interval(now, job.expiration).toDuration().getStandardSeconds());
          PendingModifyAckDeadline pendingModAckDeadline =
              new PendingModifyAckDeadline(extensionSeconds);
          for (AckHandler ackHandler : job.ackHandlers) {
            pendingModAckDeadline.addAckId(ackHandler.ackId);
          }
          modifyAckDeadlinesToSend.add(pendingModAckDeadline);
          renewJobs.add(job);
        }
        for (ExtensionJob job : renewJobs) {
          outstandingAckHandlers.add(job);
        }
        if (!outstandingAckHandlers.isEmpty()) {
          nextScheduleExpiration = outstandingAckHandlers.peek().expiration;
        }
      }

      processOutstandingAckOperations(modifyAckDeadlinesToSend);

      if (nextScheduleExpiration != null) {
        logger.log(
            Level.INFO,
            "Scheduling based on outstanding, now time: "
                + now
                + ", "
                + "next schedule time: "
                + nextScheduleExpiration);
        setupNextAckDeadlineExtensionAlarm(nextScheduleExpiration);
      }
    }
  }

  private void setupNextAckDeadlineExtensionAlarm(Instant expiration) {
    Instant possibleNextAlarmTime = expiration.minus(ackExpirationPadding);
    alarmsLock.lock();
    try {
      if (nextAckDeadlineExtensionAlarmTime.isAfter(possibleNextAlarmTime)) {
        logger.log(
            Level.INFO,
            "Scheduling next alarm time: "
                + possibleNextAlarmTime
                + ", last alarm set to time: "
                + nextAckDeadlineExtensionAlarmTime);
        if (ackDeadlineExtensionAlarm != null) {
          logger.log(Level.INFO, "Canceling previous alarm");
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
          logger.log(Level.INFO, "Sending {} acks", acksToSend.size());
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
          logger.log(Level.INFO, "Sending {} nacks", pendingNacks.size());
        } finally {
          pendingNacks.clear();
        }
        modifyAckDeadlinesToSend.add(nacksToSend);
      }
    }

    ackProcessor.sendAckOperations(acksToSend, modifyAckDeadlinesToSend);
  }
}
