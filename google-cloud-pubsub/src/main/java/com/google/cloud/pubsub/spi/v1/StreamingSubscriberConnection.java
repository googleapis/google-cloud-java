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

import static com.google.cloud.pubsub.spi.v1.StatusUtil.isRetryable;

import com.google.api.gax.grpc.FlowController;
import com.google.api.stats.Distribution;
import com.google.auth.Credentials;
import com.google.cloud.Clock;
import com.google.cloud.pubsub.spi.v1.MessageDispatcher.AckProcessor;
import com.google.cloud.pubsub.spi.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriberGrpc;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.ClientResponseObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.joda.time.Duration;

/** Implementation of {@link AckProcessor} based on Cloud Pub/Sub streaming pull. */
final class StreamingSubscriberConnection extends AbstractService implements AckProcessor {
  private static final Logger logger =
      Logger.getLogger(StreamingSubscriberConnection.class.getName());

  private static final Duration INITIAL_CHANNEL_RECONNECT_BACKOFF = new Duration(100); // 100ms
  private static final int MAX_PER_REQUEST_CHANGES = 10000;

  private Duration channelReconnectBackoff = INITIAL_CHANNEL_RECONNECT_BACKOFF;

  private final Channel channel;
  private final Credentials credentials;

  private final String subscription;
  private final ScheduledExecutorService executor;
  private final MessageDispatcher messageDispatcher;
  private ClientCallStreamObserver<StreamingPullRequest> requestObserver;

  public StreamingSubscriberConnection(
      String subscription,
      Credentials credentials,
      MessageReceiver receiver,
      Duration ackExpirationPadding,
      int streamAckDeadlineSeconds,
      Distribution ackLatencyDistribution,
      Channel channel,
      FlowController flowController,
      ScheduledExecutorService executor,
      Clock clock) {
    this.subscription = subscription;
    this.executor = executor;
    this.credentials = credentials;
    this.channel = channel;
    this.messageDispatcher =
        new MessageDispatcher(
            receiver,
            this,
            ackExpirationPadding,
            ackLatencyDistribution,
            flowController,
            executor,
            clock);
    messageDispatcher.setMessageDeadlineSeconds(streamAckDeadlineSeconds);
  }

  @Override
  protected void doStart() {
    logger.log(Level.INFO, "Starting subscriber.");
    initialize();
    notifyStarted();
  }

  @Override
  protected void doStop() {
    messageDispatcher.stop();
    notifyStopped();
    requestObserver.onError(Status.CANCELLED.asException());
  }

  private class StreamingPullResponseObserver
      implements ClientResponseObserver<StreamingPullRequest, StreamingPullResponse> {

    final SettableFuture<Void> errorFuture;

    StreamingPullResponseObserver(SettableFuture<Void> errorFuture) {
      this.errorFuture = errorFuture;
    }

    @Override
    public void beforeStart(ClientCallStreamObserver<StreamingPullRequest> requestObserver) {
      StreamingSubscriberConnection.this.requestObserver = requestObserver;
      requestObserver.disableAutoInboundFlowControl();
    }

    @Override
    public void onNext(StreamingPullResponse response) {
      messageDispatcher.processReceivedMessages(response.getReceivedMessagesList());
      // Only if not shutdown we will request one more bundles of messages to be delivered.
      if (isAlive()) {
        requestObserver.request(1);
      }
    }

    @Override
    public void onError(Throwable t) {
      logger.log(Level.INFO, "Terminated streaming with exception", t);
      errorFuture.setException(t);
    }

    @Override
    public void onCompleted() {
      logger.log(Level.INFO, "Streaming pull terminated successfully!");
      errorFuture.set(null);
    }
  }

  private void initialize() {
    final SettableFuture<Void> errorFuture = SettableFuture.create();
    final ClientResponseObserver<StreamingPullRequest, StreamingPullResponse> responseObserver =
        new StreamingPullResponseObserver(errorFuture);
    final ClientCallStreamObserver<StreamingPullRequest> requestObserver =
        (ClientCallStreamObserver<StreamingPullRequest>)
            (ClientCalls.asyncBidiStreamingCall(
                channel.newCall(
                    SubscriberGrpc.METHOD_STREAMING_PULL,
                    CallOptions.DEFAULT.withCallCredentials(MoreCallCredentials.from(credentials))),
                responseObserver));
    logger.log(
        Level.INFO,
        "Initializing stream to subscription "
            + subscription
            + " with deadline "
            + messageDispatcher.getMessageDeadlineSeconds());
    requestObserver.onNext(
        StreamingPullRequest.newBuilder()
            .setSubscription(subscription)
            .setStreamAckDeadlineSeconds(messageDispatcher.getMessageDeadlineSeconds())
            .build());
    requestObserver.request(1);

    Futures.addCallback(
        errorFuture,
        new FutureCallback<Void>() {
          @Override
          public void onSuccess(@Nullable Void result) {
            channelReconnectBackoff = INITIAL_CHANNEL_RECONNECT_BACKOFF;
            // The stream was closed. And any case we want to reopen it to continue receiving
            // messages.
            initialize();
          }

          @Override
          public void onFailure(Throwable t) {
            Status errorStatus = Status.fromThrowable(t);
            if (isRetryable(errorStatus) && isAlive()) {
              long backoffMillis = channelReconnectBackoff.getMillis();
              channelReconnectBackoff = channelReconnectBackoff.plus(backoffMillis);
              executor.schedule(
                  new Runnable() {
                    @Override
                    public void run() {
                      initialize();
                    }
                  },
                  backoffMillis,
                  TimeUnit.MILLISECONDS);
            } else {
              if (isAlive()) {
                notifyFailed(t);
              }
            }
          }
        },
        executor);
  }

  private boolean isAlive() {
    return state() == State.RUNNING || state() == State.STARTING;
  }

  @Override
  public void sendAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions) {
    List<StreamingPullRequest> requests =
        partitionAckOperations(acksToSend, ackDeadlineExtensions, MAX_PER_REQUEST_CHANGES);
    for (StreamingPullRequest request : requests) {
      requestObserver.onNext(request);
    }
  }

  @VisibleForTesting
  static List<StreamingPullRequest> partitionAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions, int size) {
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
      for (String ackId : modify.ackIds) {
        requests
            .get(reqCount)
            .addModifyDeadlineSeconds(modify.deadlineExtensionSeconds)
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

  public void updateStreamAckDeadline(int newAckDeadlineSeconds) {
    messageDispatcher.setMessageDeadlineSeconds(newAckDeadlineSeconds);
    requestObserver.onNext(
        StreamingPullRequest.newBuilder()
            .setStreamAckDeadlineSeconds(newAckDeadlineSeconds)
            .build());
  }
}
