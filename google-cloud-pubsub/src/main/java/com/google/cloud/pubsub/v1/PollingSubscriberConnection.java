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
import com.google.cloud.pubsub.v1.MessageDispatcher.AckProcessor;
import com.google.cloud.pubsub.v1.MessageDispatcher.PendingModifyAckDeadline;
import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriberGrpc.SubscriberFutureStub;
import com.google.pubsub.v1.Subscription;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.threeten.bp.Duration;

/**
 * Implementation of {@link AckProcessor} based on Cloud Pub/Sub pull and acknowledge operations.
 */
final class PollingSubscriberConnection extends AbstractApiService implements AckProcessor {
  private static final int MAX_PER_REQUEST_CHANGES = 1000;
  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
  private static final int DEFAULT_MAX_MESSAGES = 1000;
  private static final Duration INITIAL_BACKOFF = Duration.ofMillis(100); // 100ms
  private static final Duration MAX_BACKOFF = Duration.ofSeconds(10); // 10s

  private static final Logger logger =
      Logger.getLogger(PollingSubscriberConnection.class.getName());

  private final String subscription;
  private final ScheduledExecutorService pollingExecutor;
  private final SubscriberFutureStub stub;
  private final MessageDispatcher messageDispatcher;
  private final int maxDesiredPulledMessages;

  public PollingSubscriberConnection(
      String subscription,
      MessageReceiver receiver,
      Duration ackExpirationPadding,
      Duration maxAckExtensionPeriod,
      Distribution ackLatencyDistribution,
      SubscriberFutureStub stub,
      FlowController flowController,
      @Nullable Long maxDesiredPulledMessages,
      ScheduledExecutorService executor,
      ScheduledExecutorService systemExecutor,
      ApiClock clock) {
    this.subscription = subscription;
    this.pollingExecutor = systemExecutor;
    this.stub = stub;
    messageDispatcher =
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
    messageDispatcher.setMessageDeadlineSeconds(Subscriber.MIN_ACK_DEADLINE_SECONDS);
    this.maxDesiredPulledMessages =
        maxDesiredPulledMessages != null
            ? Ints.saturatedCast(maxDesiredPulledMessages)
            : DEFAULT_MAX_MESSAGES;
  }

  @Override
  protected void doStart() {
    logger.config("Starting subscriber.");
    ListenableFuture<Subscription> subscriptionInfo =
        stub.withDeadlineAfter(DEFAULT_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS)
            .getSubscription(
                GetSubscriptionRequest.newBuilder().setSubscription(subscription).build());

    Futures.addCallback(
        subscriptionInfo,
        new FutureCallback<Subscription>() {
          @Override
          public void onSuccess(Subscription result) {
            messageDispatcher.setMessageDeadlineSeconds(result.getAckDeadlineSeconds());
            pullMessages(INITIAL_BACKOFF);
            notifyStarted();
          }

          @Override
          public void onFailure(Throwable cause) {
            notifyFailed(cause);
          }
        },
        pollingExecutor);
  }

  @Override
  protected void doStop() {
    messageDispatcher.stop();
    notifyStopped();
  }

  private void pullMessages(final Duration backoff) {
    if (!isAlive()) {
      return;
    }
    ListenableFuture<PullResponse> pullResult =
        stub.pull(
            PullRequest.newBuilder()
                .setSubscription(subscription)
                .setMaxMessages(maxDesiredPulledMessages)
                .setReturnImmediately(false)
                .build());

    Futures.addCallback(
        pullResult,
        new FutureCallback<PullResponse>() {
          @Override
          public void onSuccess(PullResponse pullResponse) {
            if (pullResponse.getReceivedMessagesCount() == 0) {
              // No messages in response, possibly caught up in backlog, we backoff to avoid
              // slamming the server.
              pollingExecutor.schedule(
                  new Runnable() {
                    @Override
                    public void run() {
                      Duration newBackoff = backoff.multipliedBy(2);
                      if (newBackoff.compareTo(MAX_BACKOFF) > 0) {
                        newBackoff = MAX_BACKOFF;
                      }
                      pullMessages(newBackoff);
                    }
                  },
                  backoff.toMillis(),
                  TimeUnit.MILLISECONDS);
              return;
            }
            messageDispatcher.processReceivedMessages(
                pullResponse.getReceivedMessagesList(),
                new Runnable() {
                  @Override
                  public void run() {
                    pullMessages(INITIAL_BACKOFF);
                  }
                });
          }

          @Override
          public void onFailure(Throwable cause) {
            if (!isAlive()) {
              // we don't care about subscription failures when we're no longer running.
              logger.log(Level.FINE, "pull failure after service no longer running", cause);
              return;
            }
            if (StatusUtil.isRetryable(cause)) {
              logger.log(Level.WARNING, "Failed to pull messages (recoverable): ", cause);
              pollingExecutor.schedule(
                  new Runnable() {
                    @Override
                    public void run() {
                      Duration newBackoff = backoff.multipliedBy(2);
                      if (newBackoff.compareTo(MAX_BACKOFF) > 0) {
                        newBackoff = MAX_BACKOFF;
                      }
                      pullMessages(newBackoff);
                    }
                  },
                  backoff.toMillis(),
                  TimeUnit.MILLISECONDS);
            } else {
              messageDispatcher.stop();
              notifyFailed(cause);
            }
          }
        },
        pollingExecutor);
  }

  private boolean isAlive() {
    // Read state only once. Because of threading, different calls can give different results.
    State state = state();
    return state == State.RUNNING || state == State.STARTING;
  }

  @Override
  public void sendAckOperations(
      List<String> acksToSend, List<PendingModifyAckDeadline> ackDeadlineExtensions) {
    // Send the modify ack deadlines in batches as not to exceed the max request
    // size.
    for (PendingModifyAckDeadline modifyAckDeadline : ackDeadlineExtensions) {
      for (List<String> ackIdChunk :
          Lists.partition(modifyAckDeadline.ackIds, MAX_PER_REQUEST_CHANGES)) {
        stub.withDeadlineAfter(DEFAULT_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS)
            .modifyAckDeadline(
                ModifyAckDeadlineRequest.newBuilder()
                    .setSubscription(subscription)
                    .addAllAckIds(ackIdChunk)
                    .setAckDeadlineSeconds(modifyAckDeadline.deadlineExtensionSeconds)
                    .build());
      }
    }

    for (List<String> ackChunk : Lists.partition(acksToSend, MAX_PER_REQUEST_CHANGES)) {
      stub.withDeadlineAfter(DEFAULT_TIMEOUT.toMillis(), TimeUnit.MILLISECONDS)
          .acknowledge(
              AcknowledgeRequest.newBuilder()
                  .setSubscription(subscription)
                  .addAllAckIds(ackChunk)
                  .build());
    }
  }
}
