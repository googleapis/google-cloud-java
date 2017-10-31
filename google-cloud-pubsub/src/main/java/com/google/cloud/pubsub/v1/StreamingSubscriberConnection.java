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

package com.google.cloud.pubsub.v1;

import com.google.api.core.AbstractApiService;
import com.google.api.core.ApiClock;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.grpc.GrpcApiExceptionFactory;
import com.google.api.gax.rpc.ApiException;
import com.google.cloud.pubsub.v1.MessageDispatcher.AckProcessor;
import com.google.cloud.pubsub.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriberGrpc.SubscriberStub;
import io.grpc.Status;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/** Implementation of {@link AckProcessor} based on Cloud Pub/Sub streaming pull. */
final class StreamingSubscriberConnection extends AbstractApiService implements AckProcessor {
  private static final Logger logger =
      Logger.getLogger(StreamingSubscriberConnection.class.getName());

  private static final Duration INITIAL_CHANNEL_RECONNECT_BACKOFF = Duration.ofMillis(100);
  private static final Duration MAX_CHANNEL_RECONNECT_BACKOFF = Duration.ofSeconds(10);
  private static final int MAX_PER_REQUEST_CHANGES = 10000;

  private final SubscriberStub asyncStub;
  private final String subscription;
  private final ScheduledExecutorService executor;
  private final MessageDispatcher messageDispatcher;
  private final Duration ackExpirationPadding;

  private final AtomicLong channelReconnectBackoffMillis =
      new AtomicLong(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());

  private final Lock lock = new ReentrantLock();
  private ClientCallStreamObserver<StreamingPullRequest> requestObserver;

  public StreamingSubscriberConnection(
      String subscription,
      MessageReceiver receiver,
      Duration ackExpirationPadding,
      Duration maxAckExtensionPeriod,
      int streamAckDeadlineSeconds,
      Distribution ackLatencyDistribution,
      SubscriberStub asyncStub,
      FlowController flowController,
      Deque<MessageDispatcher.OutstandingMessageBatch> outstandingMessageBatches,
      ScheduledExecutorService executor,
      @Nullable ScheduledExecutorService alarmsExecutor,
      ApiClock clock) {
    this.subscription = subscription;
    this.executor = executor;
    this.asyncStub = asyncStub;
    this.ackExpirationPadding = ackExpirationPadding;
    this.messageDispatcher =
        new MessageDispatcher(
            receiver,
            this,
            Duration.ZERO,
            maxAckExtensionPeriod,
            ackLatencyDistribution,
            flowController,
            outstandingMessageBatches,
            executor,
            alarmsExecutor,
            clock);
    messageDispatcher.setMessageDeadline(
        intendedToExtensionDeadline(
            Duration.ofSeconds(streamAckDeadlineSeconds), ackExpirationPadding));
  }

  @Override
  protected void doStart() {
    logger.config("Starting subscriber.");
    initialize();
    notifyStarted();
  }

  @Override
  protected void doStop() {
    messageDispatcher.stop();

    lock.lock();
    try {
      requestObserver.onError(Status.CANCELLED.asException());
    } finally {
      lock.unlock();
      notifyStopped();
    }
  }

  private class StreamingPullResponseObserver
      implements ClientResponseObserver<StreamingPullRequest, StreamingPullResponse> {

    final SettableFuture<Void> errorFuture;

    /**
     * When a batch finsihes processing, we want to request one more batch from the server. But by
     * the time this happens, our stream might have already errored, and new stream created. We
     * don't want to request more batches from the new stream -- that might pull more messages than
     * the user can deal with -- so we save the request observer this response observer is "paired
     * with". If the stream has already errored, requesting more messages is a no-op.
     */
    ClientCallStreamObserver<StreamingPullRequest> thisRequestObserver;

    StreamingPullResponseObserver(SettableFuture<Void> errorFuture) {
      this.errorFuture = errorFuture;
    }

    @Override
    public void beforeStart(ClientCallStreamObserver<StreamingPullRequest> requestObserver) {
      thisRequestObserver = requestObserver;
      requestObserver.disableAutoInboundFlowControl();
    }

    @Override
    public void onNext(StreamingPullResponse response) {
      channelReconnectBackoffMillis.set(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());
      messageDispatcher.processReceivedMessages(
          response.getReceivedMessagesList(),
          new Runnable() {
            @Override
            public void run() {
              // Only request more if we're not shutdown.
              // If errorFuture is done, the stream has either failed or hung up,
              // and we don't need to request.
              if (isAlive() && !errorFuture.isDone()) {
                lock.lock();
                try {
                  thisRequestObserver.request(1);
                } catch (Exception e) {
                  logger.log(Level.WARNING, "cannot request more messages", e);
                } finally {
                  lock.unlock();
                }
              }
            }
          });
    }

    @Override
    public void onError(Throwable t) {
      errorFuture.setException(t);
    }

    @Override
    public void onCompleted() {
      logger.fine("Streaming pull terminated successfully!");
      errorFuture.set(null);
    }
  }

  private void initialize() {
    final SettableFuture<Void> errorFuture = SettableFuture.create();
    final ClientResponseObserver<StreamingPullRequest, StreamingPullResponse> responseObserver =
        new StreamingPullResponseObserver(errorFuture);
    final ClientCallStreamObserver<StreamingPullRequest> requestObserver =
        (ClientCallStreamObserver<StreamingPullRequest>)
            (asyncStub.streamingPull(responseObserver));

    Duration deadline =
        extensionToServerDeadline(
            Duration.ofSeconds(messageDispatcher.getMessageDeadlineSeconds()),
            ackExpirationPadding);
    logger.log(
        Level.FINER,
        "Initializing stream to subscription {0} with deadline {1}",
        new Object[] {subscription, deadline});
    requestObserver.onNext(
        StreamingPullRequest.newBuilder()
            .setSubscription(subscription)
            .setStreamAckDeadlineSeconds(Ints.saturatedCast(deadline.getSeconds()))
            .build());
    requestObserver.request(1);

    /**
     * Must make sure we do this after sending the subscription name and deadline. Otherwise, some
     * other thread might use this stream to do something else before we could send the first
     * request.
     */
    lock.lock();
    try {
      this.requestObserver = requestObserver;
    } finally {
      lock.unlock();
    }

    Futures.addCallback(
        errorFuture,
        new FutureCallback<Void>() {
          @Override
          public void onSuccess(@Nullable Void result) {
            if (!isAlive()) {
              return;
            }
            channelReconnectBackoffMillis.set(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());
            // The stream was closed. And any case we want to reopen it to continue receiving
            // messages.
            initialize();
          }

          @Override
          public void onFailure(Throwable cause) {
            if (!isAlive()) {
              // we don't care about subscription failures when we're no longer running.
              logger.log(Level.FINE, "pull failure after service no longer running", cause);
              return;
            }
            if (!StatusUtil.isRetryable(cause)) {
              ApiException gaxException =
                  GrpcApiExceptionFactory.createException(
                      cause, Status.fromThrowable(cause).getCode(), false);
              logger.log(Level.SEVERE, "terminated streaming with exception", gaxException);
              notifyFailed(gaxException);
              return;
            }
            logger.log(Level.FINE, "stream closed with retryable exception; will reconnect", cause);
            long backoffMillis = channelReconnectBackoffMillis.get();
            long newBackoffMillis =
                Math.min(backoffMillis * 2, MAX_CHANNEL_RECONNECT_BACKOFF.toMillis());
            channelReconnectBackoffMillis.set(newBackoffMillis);

            executor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    initialize();
                  }
                },
                backoffMillis,
                TimeUnit.MILLISECONDS);
          }
        });
  }

  private boolean isAlive() {
    return state() == State.RUNNING || state() == State.STARTING;
  }

  @Override
  public void sendAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions) {
    List<StreamingPullRequest> requests =
        partitionAckOperations(
            acksToSend, ackDeadlineExtensions, MAX_PER_REQUEST_CHANGES, ackExpirationPadding);
    lock.lock();
    try {
      for (StreamingPullRequest request : requests) {
        requestObserver.onNext(request);
      }
    } catch (Exception e) {
      logger.log(Level.WARNING, "failed to send acks", e);
    } finally {
      lock.unlock();
    }
  }

  @VisibleForTesting
  static List<StreamingPullRequest> partitionAckOperations(
      List<String> acksToSend,
      List<PendingModifyAckDeadline> ackDeadlineExtensions,
      int size,
      Duration padding) {
    int numExtensions = 0;
    for (PendingModifyAckDeadline modify : ackDeadlineExtensions) {
      numExtensions += modify.ackIds.size();
    }
    int numChanges = Math.max(numExtensions, acksToSend.size());
    int numRequests = numChanges / size + (numChanges % size == 0 ? 0 : 1);

    List<StreamingPullRequest.Builder> requests = new ArrayList<>(numRequests);
    for (int i = 0; i < numRequests; i++) {
      requests.add(StreamingPullRequest.newBuilder());
    }

    int reqCount = 0;
    for (List<String> acksChunk : Lists.partition(acksToSend, size)) {
      requests.get(reqCount).addAllAckIds(acksChunk);
      reqCount++;
    }

    reqCount = 0;
    int ackCount = 0;
    for (PendingModifyAckDeadline modify : ackDeadlineExtensions) {
      // If the extension is zero, it's a nack, don't do anything.
      // Otherwise, add the padding.
      int serverExtensionSeconds = 0;
      if (modify.deadlineExtensionSeconds != 0) {
        Duration intendedDeadlineExtension = Duration.ofSeconds(modify.deadlineExtensionSeconds);
        Duration serverExtension = intendedToServerDeadline(intendedDeadlineExtension, padding);
        serverExtensionSeconds = (int) (serverExtension.getSeconds());
      }
      for (String ackId : modify.ackIds) {
        requests
            .get(reqCount)
            .addModifyDeadlineSeconds(serverExtensionSeconds)
            .addModifyDeadlineAckIds(ackId);
        ackCount++;
        if (ackCount == size) {
          reqCount++;
          ackCount = 0;
        }
      }
    }

    List<StreamingPullRequest> ret = new ArrayList<>(requests.size());
    for (StreamingPullRequest.Builder builder : requests) {
      ret.add(builder.build());
    }
    return ret;
  }

  public void updateStreamAckDeadline(int intendedDeadlineSeconds) {
    Duration intendedDeadline = Duration.ofSeconds(intendedDeadlineSeconds);
    messageDispatcher.setMessageDeadline(
        intendedToExtensionDeadline(intendedDeadline, ackExpirationPadding));
    lock.lock();
    try {
      requestObserver.onNext(
          StreamingPullRequest.newBuilder()
              .setStreamAckDeadlineSeconds(
                  (int)
                      (intendedToServerDeadline(intendedDeadline, ackExpirationPadding)
                          .getSeconds()))
              .build());
    } catch (Exception e) {
      logger.log(Level.WARNING, "failed to set deadline", e);
    } finally {
      lock.unlock();
    }
  }

  /*
    We define 3 forms of deadline:
    1. intendedDeadline: The amount of time we take to process a message.
    2. extensionDeadline: After we hold on to the message for this amount of time,
      we ask the server for extension.
    3. serverDeadline: The deadline we configure the stream to.

    Consider the following scenarios:
    Scenario 1.
    We take about 10 seconds to process a message (intendedDeadline = 10s).
    However, we expect 5s communication latency, so we have to ask the server
    for a little more time (serverDeadline = intendedDeadline + padding = 10s + 5s = 15s)
    so that the message doesn't expire before our ACK reaches the server.
    The latency also affect modify deadline requests, so we need to send modify request
    a little before the serverDeadline (extensionDeadline = serverDeadline - padding = 15s - 5s = 10s).

    Scenario 2.
    We think we take 600 seconds to process a message (intendedDeadline = 600s).
    We also expect 5s latency, but then we can't set server deadline to 605s,
    since pubsub only supports deadline up to 600s.
    Our best course of action is to set serverDeadline as high as possible (serverDeadline = 600s).
    Like scenario 1, we need to send modify deadline requests a little before
    (extensionDeadline = serverDeadline - padding = 600s - 5s = 595s)

    The helper methods below convert between these deadlines.
  */

  private static Duration intendedToServerDeadline(Duration intendedDeadline, Duration padding) {
    Duration deadline = intendedDeadline.plus(padding);
    if (deadline.compareTo(MessageDispatcher.MAX_ACK_DEADLINE) > 0) {
      deadline = MessageDispatcher.MAX_ACK_DEADLINE;
    }
    return deadline;
  }

  private static Duration intendedToExtensionDeadline(Duration intendedDeadline, Duration padding) {
    return intendedToServerDeadline(intendedDeadline, padding).minus(padding);
  }

  private static Duration extensionToServerDeadline(Duration extensionDeadline, Duration padding) {
    return extensionDeadline.plus(padding);
  }
}
