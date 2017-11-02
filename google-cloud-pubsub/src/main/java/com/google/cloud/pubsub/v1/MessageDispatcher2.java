/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.FlowController.FlowControlException;
import com.google.common.collect.Lists;
import com.google.pubsub.v1.ReceivedMessage;
import com.google.pubsub.v1.StreamingPullRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

class MessageDispatcher2 {

  private static final Logger logger = Logger.getLogger(MessageDispatcher.class.getName());
  private static final int DEADLINE_EXTENSION_SEC = 60;
  private static final int KEEPALIVE_SEC = 45;
  private static final int MAX_CHANGE_PER_REQUEST = 1000;

  private final ExecutorService executor;
  private final ScheduledExecutorService systemExecutor;
  private final MessageReceiver receiver;
  private final FlowController flowController;

  private final ConcurrentLinkedQueue<WorkItem> workQueue = new ConcurrentLinkedQueue<>();
  private final ConcurrentLinkedQueue<String> idsToAck = new ConcurrentLinkedQueue<>();
  private final ConcurrentLinkedQueue<String> idsToNack = new ConcurrentLinkedQueue<>();

  // Boolean, not Void, because the map doesn't allow null values.
  private final ConcurrentHashMap<String, Boolean> extensionSet = new ConcurrentHashMap<>();

  private final LinkedBlockingQueue<Connection> connections = new LinkedBlockingQueue<>();

  private ScheduledFuture<?> ackNackJob;
  private ScheduledFuture<?> extensionJob;
  
  interface Connection {
    void send(StreamingPullRequest request);
  }

  private static class WorkItem {
    final ReceivedMessage message;
    final AtomicInteger remaining;
    final Runnable callback;

    WorkItem(ReceivedMessage message, AtomicInteger remaining, Runnable callback) {
      this.message = message;
      this.remaining = remaining;
      this.callback = callback;
    }
  }

  private class Consumer implements AckReplyConsumer {
    final AtomicReference<String> completed = new AtomicReference<>();
    final WorkItem workItem;

    Consumer(WorkItem workItem) {
      this.workItem = workItem;
    }

    private void complete(String reason) {
      if (!completed.compareAndSet(null, reason)) {
        throw new IllegalStateException(
            String.format(
                "the message has already been completed (%s), cannot %s", completed.get(), reason));
      }
      extensionSet.remove(workItem.message.getAckId());
      flowController.release(1, workItem.message.getMessage().getSerializedSize());
      if (workItem.remaining.decrementAndGet() == 0) {
        workItem.callback.run();
      }
      workMessages();
    }

    @Override
    public void ack() {
      complete("ack");
      idsToAck.add(workItem.message.getAckId());
    }

    @Override
    public void nack() {
      complete("nack");
      idsToNack.add(workItem.message.getAckId());
    }

    void throwException(Throwable t) {
      complete("throw exception");
      String ackId = workItem.message.getAckId();
      logger.log(
          Level.WARNING,
          "MessageReceiver failed to processes ack ID: " + ackId + ", the message will be nacked.",
          t);
      idsToNack.add(ackId);
    }
  }

  MessageDispatcher2(
      ExecutorService executor,
      ScheduledExecutorService systemExecutor,
      MessageReceiver receiver,
      FlowController flowController) {
    this.executor = executor;
    this.systemExecutor = systemExecutor;
    this.receiver = receiver;
    this.flowController = flowController;
  }

  synchronized void start(Collection<? extends Connection> connections) {
    this.connections.addAll(connections);
    this.ackNackJob =
        systemExecutor.scheduleAtFixedRate(
            new Runnable() {
              @Override
              public void run() {
                StreamingPullRequest.Builder builder = StreamingPullRequest.newBuilder();
                boolean more = true;
                while (more) {
                  builder.clear();
                  more = drainAckNacks(builder);
                  // If both are 0, there's nothing to send.
                  if (builder.getAckIdsCount() != 0
                      || builder.getModifyDeadlineAckIdsCount() != 0) {
                    sendRequest(builder.build());
                  }
                }
              }
            },
            100,
            100,
            TimeUnit.MILLISECONDS);

    this.extensionJob =
        systemExecutor.scheduleAtFixedRate(
            new Runnable() {
              @Override
              public void run() {
                List<String> extendIds = new ArrayList<>(extensionSet.keySet());
                for (List<String> batch : Lists.partition(extendIds, MAX_CHANGE_PER_REQUEST)) {
                  sendRequest(
                      StreamingPullRequest.newBuilder()
                          .addAllModifyDeadlineAckIds(batch)
                          .addAllModifyDeadlineSeconds(
                              Collections.nCopies(batch.size(), DEADLINE_EXTENSION_SEC))
                          .build());
                }
              }
            },
            KEEPALIVE_SEC,
            KEEPALIVE_SEC,
            TimeUnit.SECONDS);
  }

  synchronized void shutdown() {
    ackNackJob.cancel(false);
    extensionJob.cancel(false);
  }

  private boolean drainAckNacks(StreamingPullRequest.Builder builder) {
    while (builder.getAckIdsCount() < MAX_CHANGE_PER_REQUEST) {
      String id = idsToAck.poll();
      if (id == null) {
        break;
      }
      builder.addAckIds(id);
    }

    while (builder.getModifyDeadlineAckIdsCount() < MAX_CHANGE_PER_REQUEST) {
      String id = idsToNack.poll();
      if (id == null) {
        break;
      }
      builder.addModifyDeadlineAckIds(id);
    }
    builder.addAllModifyDeadlineSeconds(
        Collections.nCopies(builder.getModifyDeadlineAckIdsCount(), 0));

    return builder.getAckIdsCount() == MAX_CHANGE_PER_REQUEST
        || builder.getModifyDeadlineAckIdsCount() == MAX_CHANGE_PER_REQUEST;
  }

  void processReceivedMessages(List<ReceivedMessage> messages, Runnable doneCallback) {
    if (messages.isEmpty()) {
      doneCallback.run();
      return;
    }

    StreamingPullRequest.Builder builder =
        StreamingPullRequest.newBuilder()
            .addAllModifyDeadlineSeconds(
                Collections.nCopies(messages.size(), DEADLINE_EXTENSION_SEC));
    for (ReceivedMessage message : messages) {
      builder.addModifyDeadlineAckIds(message.getAckId());
    }
    sendRequest(builder.build());

    AtomicInteger remaining = new AtomicInteger(messages.size());
    for (ReceivedMessage message : messages) {
      workQueue.add(new WorkItem(message, remaining, doneCallback));
      extensionSet.put(message.getAckId(), true);
    }
    workMessages();
  }

  private synchronized void workMessages() {
    for (; ; ) {
      final WorkItem item = workQueue.peek();
      if (item == null) {
        return;
      }

      try {
        flowController.reserve(1, item.message.getMessage().getSerializedSize());
      } catch (FlowControlException e) {
        return;
      }
      workQueue.poll();

      final Consumer consumer = new Consumer(item);
      executor.submit(
          new Runnable() {
            @Override
            public void run() {
              try {
                receiver.receiveMessage(item.message.getMessage(), consumer);
              } catch (Exception e) {
                consumer.throwException(e);
              }
            }
          });
    }
  }

  private void sendRequest(StreamingPullRequest request) {
    Connection connection = null;
    try {
      connection = connections.take();
      connection.send(request);
    } catch (InterruptedException e) {
      logger.log(
          Level.WARNING, "interrupted while waiting for available connection; message not sent", e);
    } finally {
      if (connection != null) {
        connections.add(connection);
      }
    }
  }

  int getMessageDeadlineSeconds() {
    return DEADLINE_EXTENSION_SEC;
  }
}
