/*
 * Copyright 2016 Google LLC
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

import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.api.core.AbstractApiService;
import com.google.api.core.ApiClock;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.Distribution;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.cloud.pubsub.v1.MessageDispatcher.AckProcessor;
import com.google.cloud.pubsub.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.cloud.pubsub.v1.stub.SubscriberStub;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import io.grpc.Status;
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
  private static final int MAX_PER_REQUEST_CHANGES = 1000;

  private final SubscriberStub stub;
  private final int channelAffinity;
  private final String subscription;
  private final ScheduledExecutorService systemExecutor;
  private final MessageDispatcher messageDispatcher;

  private final AtomicLong channelReconnectBackoffMillis =
      new AtomicLong(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());

  private final Lock lock = new ReentrantLock();
  private ClientStream<StreamingPullRequest> clientStream;

  public StreamingSubscriberConnection(
      String subscription,
      MessageReceiver receiver,
      Duration ackExpirationPadding,
      Duration maxAckExtensionPeriod,
      Distribution ackLatencyDistribution,
      SubscriberStub stub,
      int channelAffinity,
      FlowController flowController,
      ScheduledExecutorService executor,
      ScheduledExecutorService systemExecutor,
      ApiClock clock) {
    this.subscription = subscription;
    this.systemExecutor = systemExecutor;
    this.stub = stub;
    this.channelAffinity = channelAffinity;
    this.messageDispatcher =
        new MessageDispatcher(
            receiver,
            this,
            ackExpirationPadding,
            maxAckExtensionPeriod,
            ackLatencyDistribution,
            flowController,
            executor,
            systemExecutor,
            clock);
  }

  @Override
  protected void doStart() {
    logger.config("Starting subscriber.");
    messageDispatcher.start();
    initialize();
    notifyStarted();
  }

  @Override
  protected void doStop() {
    messageDispatcher.stop();

    lock.lock();
    try {
      clientStream.closeSendWithError(Status.CANCELLED.asException());
    } finally {
      lock.unlock();
      notifyStopped();
    }
  }

  private class StreamingPullResponseObserver implements ResponseObserver<StreamingPullResponse> {

    final SettableApiFuture<Void> errorFuture;

    /**
     * When a batch finsihes processing, we want to request one more batch from the server. But by
     * the time this happens, our stream might have already errored, and new stream created. We
     * don't want to request more batches from the new stream -- that might pull more messages than
     * the user can deal with -- so we save the request observer this response observer is "paired
     * with". If the stream has already errored, requesting more messages is a no-op.
     */
    StreamController thisController;

    StreamingPullResponseObserver(SettableApiFuture<Void> errorFuture) {
      this.errorFuture = errorFuture;
    }

    @Override
    public void onStart(StreamController controller) {
      thisController = controller;
      thisController.disableAutoInboundFlowControl();
      thisController.request(1);
    }

    @Override
    public void onResponse(StreamingPullResponse response) {
      channelReconnectBackoffMillis.set(INITIAL_CHANNEL_RECONNECT_BACKOFF.toMillis());
      messageDispatcher.processReceivedMessages(response.getReceivedMessagesList());
      // Only request more if we're not shutdown.
      // If errorFuture is done, the stream has either failed or hung up,
      // and we don't need to request.
      if (isAlive() && !errorFuture.isDone()) {
        lock.lock();
        try {
          thisController.request(1);
        } catch (Exception e) {
          logger.log(Level.WARNING, "cannot request more messages", e);
        } finally {
          lock.unlock();
        }
      }
    }

    @Override
    public void onError(Throwable t) {
      errorFuture.setException(t);
    }

    @Override
    public void onComplete() {
      logger.fine("Streaming pull terminated successfully!");
      errorFuture.set(null);
    }
  }

  private void initialize() {
    final SettableApiFuture<Void> errorFuture = SettableApiFuture.create();
    final ResponseObserver<StreamingPullResponse> responseObserver =
        new StreamingPullResponseObserver(errorFuture);
    ClientStream<StreamingPullRequest> initClientStream =
        stub.streamingPullCallable()
            .splitCall(
                responseObserver,
                GrpcCallContext.createDefault().withChannelAffinity(channelAffinity));

    logger.log(Level.FINER, "Initializing stream to subscription {0}", subscription);
    // We need to set streaming ack deadline, but it's not useful since we'll modack to send receipt
    // anyway. Set to some big-ish value in case we modack late.
    initClientStream.send(
        StreamingPullRequest.newBuilder()
            .setSubscription(subscription)
            .setStreamAckDeadlineSeconds(60)
            .build());

    /**
     * Must make sure we do this after sending the subscription name and deadline. Otherwise, some
     * other thread might use this stream to do something else before we could send the first
     * request.
     */
    lock.lock();
    try {
      this.clientStream = initClientStream;
    } finally {
      lock.unlock();
    }

    ApiFutures.addCallback(
        errorFuture,
        new ApiFutureCallback<Void>() {
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
                  ApiExceptionFactory.createException(
                      cause, GrpcStatusCode.of(Status.fromThrowable(cause).getCode()), false);
              logger.log(Level.SEVERE, "terminated streaming with exception", gaxException);
              notifyFailed(gaxException);
              return;
            }
            logger.log(Level.FINE, "stream closed with retryable exception; will reconnect", cause);
            long backoffMillis = channelReconnectBackoffMillis.get();
            long newBackoffMillis =
                Math.min(backoffMillis * 2, MAX_CHANNEL_RECONNECT_BACKOFF.toMillis());
            channelReconnectBackoffMillis.set(newBackoffMillis);

            systemExecutor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    initialize();
                  }
                },
                backoffMillis,
                TimeUnit.MILLISECONDS);
          }
        },
        MoreExecutors.directExecutor());
  }

  private boolean isAlive() {
    State state = state(); // Read the state only once.
    return state == State.RUNNING || state == State.STARTING;
  }

  @Override
  public void sendAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions) {
    ApiFutureCallback<Empty> loggingCallback =
        new ApiFutureCallback<Empty>() {
          @Override
          public void onSuccess(Empty empty) {
            // noop
          }

          @Override
          public void onFailure(Throwable t) {
            Level level = isAlive() ? Level.WARNING : Level.FINER;
            logger.log(level, "failed to send operations", t);
          }
        };

    for (PendingModifyAckDeadline modack : ackDeadlineExtensions) {
      for (List<String> idChunk : Lists.partition(modack.ackIds, MAX_PER_REQUEST_CHANGES)) {
        ApiFuture<Empty> future =
            stub.modifyAckDeadlineCallable()
                .futureCall(
                    ModifyAckDeadlineRequest.newBuilder()
                        .setSubscription(subscription)
                        .addAllAckIds(idChunk)
                        .setAckDeadlineSeconds(modack.deadlineExtensionSeconds)
                        .build());
        ApiFutures.addCallback(future, loggingCallback, directExecutor());
      }
    }

    for (List<String> idChunk : Lists.partition(acksToSend, MAX_PER_REQUEST_CHANGES)) {
      ApiFuture<Empty> future =
          stub.acknowledgeCallable()
              .futureCall(
                  AcknowledgeRequest.newBuilder()
                      .setSubscription(subscription)
                      .addAllAckIds(idChunk)
                      .build());
      ApiFutures.addCallback(future, loggingCallback, directExecutor());
    }
  }
}
