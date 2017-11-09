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

import com.google.api.client.util.Preconditions;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.PublisherGrpc.PublisherImplBase;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriberGrpc.SubscriberImplBase;
import com.google.pubsub.v1.Subscription;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A fake implementation of {@link PublisherImplBase}, that can be used to test clients of a Cloud
 * Pub/Sub Publisher.
 */
class FakeSubscriberServiceImpl extends SubscriberImplBase {
  private final AtomicBoolean subscriptionInitialized = new AtomicBoolean(false);
  private String subscription = "";
  private final AtomicInteger messageAckDeadline =
      new AtomicInteger(Subscriber.MIN_ACK_DEADLINE_SECONDS);
  private final AtomicInteger getSubscriptionCalled = new AtomicInteger();
  private final List<Stream> openedStreams = new ArrayList<>();
  private final List<Stream> closedStreams = new ArrayList<>();
  private final List<String> acks = new ArrayList<>();
  private final List<ModifyAckDeadline> modAckDeadlines = new ArrayList<>();
  private final List<PullRequest> receivedPullRequest = new ArrayList<>();
  private final BlockingQueue<PullResponse> pullResponses = new LinkedBlockingDeque<>();
  private int currentStream;

  public static enum CloseSide {
    SERVER,
    CLIENT
  }

  public static final class ModifyAckDeadline {
    private final String ackId;
    private final long seconds;

    public ModifyAckDeadline(String ackId, long seconds) {
      Preconditions.checkNotNull(ackId);
      this.ackId = ackId;
      this.seconds = seconds;
    }

    public String getAckId() {
      return ackId;
    }

    public long getSeconds() {
      return seconds;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof ModifyAckDeadline)) {
        return false;
      }
      ModifyAckDeadline other = (ModifyAckDeadline) obj;
      return other.ackId.equals(this.ackId) && other.seconds == this.seconds;
    }

    @Override
    public int hashCode() {
      return ackId.hashCode();
    }

    @Override
    public String toString() {
      return "Ack ID: " + ackId + ", deadline seconds: " + seconds;
    }
  }

  private static class Stream {
    private StreamObserver<StreamingPullRequest> requestObserver;
    private StreamObserver<StreamingPullResponse> responseObserver;
  }

  private class StreamingPullRequestObserver implements StreamObserver<StreamingPullRequest> {
    private final Stream stream;
    private final StreamObserver<StreamingPullResponse> responseObserver;

    StreamingPullRequestObserver(
        Stream stream, StreamObserver<StreamingPullResponse> responseObserver) {
      this.stream = stream;
      this.responseObserver = responseObserver;
    }

    @Override
    public void onNext(StreamingPullRequest request) {
      synchronized (stream) {
        if (!request.getSubscription().isEmpty()) {
          if (!subscription.isEmpty() && !subscription.equals(request.getSubscription())) {
            responseObserver.onError(
                new StatusException(
                    Status.fromCode(Code.ABORTED)
                        .withDescription("Can only set one subscription.")));
            return;
          }

          synchronized (subscriptionInitialized) {
            if (subscription.isEmpty()) {
              if (request.getStreamAckDeadlineSeconds() == 0) {
                responseObserver.onError(
                    new StatusException(
                        Status.fromCode(Code.INVALID_ARGUMENT)
                            .withDescription("A stream must be initialized with a ack deadline.")));
              }

              subscription = request.getSubscription();
              subscriptionInitialized.set(true);
              subscriptionInitialized.notifyAll();
            }
          }
          addOpenedStream(stream);
          stream.notifyAll();
        }

        if (request.getStreamAckDeadlineSeconds() > 0) {
          synchronized (messageAckDeadline) {
            messageAckDeadline.set(request.getStreamAckDeadlineSeconds());
            messageAckDeadline.notifyAll();
          }
        }
        if (subscription.isEmpty()) {
          closeStream(stream);
          responseObserver.onError(
              new StatusException(
                  Status.fromCode(Code.ABORTED)
                      .withDescription(
                          "The stream has not been properly initialized with a "
                              + "subscription.")));
          return;
        }
        if (request.getAckIdsCount() > 0) {
          addReceivedAcks(request.getAckIdsList());
        }
        if (request.getModifyDeadlineAckIdsCount() > 0) {
          if (request.getModifyDeadlineAckIdsCount() != request.getModifyDeadlineSecondsCount()) {
            closeStream(stream);
            responseObserver.onError(
                new StatusException(
                    Status.fromCode(Code.ABORTED)
                        .withDescription("Invalid modify ack deadline request.")));
            return;
          }
          Iterator<String> ackIds = request.getModifyDeadlineAckIdsList().iterator();
          Iterator<Integer> seconds = request.getModifyDeadlineSecondsList().iterator();
          while (ackIds.hasNext() && seconds.hasNext()) {
            addReceivedModifyAckDeadline(new ModifyAckDeadline(ackIds.next(), seconds.next()));
          }
        }
      }
    }

    @Override
    public void onError(Throwable error) {
      closeStream(stream);
    }

    @Override
    public void onCompleted() {
      closeStream(stream);
      stream.responseObserver.onCompleted();
    }
  }

  @Override
  public StreamObserver<StreamingPullRequest> streamingPull(
      StreamObserver<StreamingPullResponse> responseObserver) {
    Stream stream = new Stream();
    stream.requestObserver = new StreamingPullRequestObserver(stream, responseObserver);
    stream.responseObserver = responseObserver;
    return stream.requestObserver;
  }

  public void sendStreamingResponse(StreamingPullResponse pullResponse)
      throws InterruptedException {
    waitForRegistedSubscription();
    synchronized (openedStreams) {
      waitForOpenedStreams(1);
      openedStreams.get(getAndAdvanceCurrentStream()).responseObserver.onNext(pullResponse);
    }
  }

  public void setMessageAckDeadlineSeconds(int ackDeadline) {
    messageAckDeadline.set(ackDeadline);
  }

  public void enqueuePullResponse(PullResponse response) {
    pullResponses.add(response);
  }

  @Override
  public void getSubscription(
      GetSubscriptionRequest request, StreamObserver<Subscription> responseObserver) {
    getSubscriptionCalled.incrementAndGet();
    responseObserver.onNext(
        Subscription.newBuilder()
            .setName(request.getSubscription())
            .setAckDeadlineSeconds(messageAckDeadline.get())
            .setTopic("fake-topic")
            .build());
    responseObserver.onCompleted();
  }

  /** Returns the number of times getSubscription is called. */
  @VisibleForTesting
  int getSubscriptionCalledCount() {
    return getSubscriptionCalled.get();
  }

  @Override
  public void pull(PullRequest request, StreamObserver<PullResponse> responseObserver) {
    synchronized (receivedPullRequest) {
      receivedPullRequest.add(request);
    }
    try {
      responseObserver.onNext(pullResponses.take());
      responseObserver.onCompleted();
    } catch (InterruptedException e) {
      responseObserver.onError(e);
    }
  }

  @Override
  public void acknowledge(
      AcknowledgeRequest request, io.grpc.stub.StreamObserver<Empty> responseObserver) {
    addReceivedAcks(request.getAckIdsList());
    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  @Override
  public void modifyAckDeadline(
      ModifyAckDeadlineRequest request, StreamObserver<Empty> responseObserver) {
    for (String ackId : request.getAckIdsList()) {
      addReceivedModifyAckDeadline(new ModifyAckDeadline(ackId, request.getAckDeadlineSeconds()));
    }
    responseObserver.onNext(Empty.getDefaultInstance());
    responseObserver.onCompleted();
  }

  public void sendError(Throwable error) throws InterruptedException {
    waitForRegistedSubscription();
    synchronized (openedStreams) {
      waitForOpenedStreams(1);
      Stream stream = openedStreams.get(getAndAdvanceCurrentStream());
      stream.responseObserver.onError(error);
      closeStream(stream);
    }
  }

  public String waitForRegistedSubscription() throws InterruptedException {
    synchronized (subscriptionInitialized) {
      while (!subscriptionInitialized.get()) {
        subscriptionInitialized.wait();
      }
    }
    return subscription;
  }

  public List<String> waitAndConsumeReceivedAcks(int expectedCount) throws InterruptedException {
    synchronized (acks) {
      waitAtLeast(acks, expectedCount);
      List<String> receivedAcksCopy = ImmutableList.copyOf(acks.subList(0, expectedCount));
      acks.subList(0, expectedCount).clear();
      return receivedAcksCopy;
    }
  }

  public List<ModifyAckDeadline> waitAndConsumeModifyAckDeadlines(int expectedCount)
      throws InterruptedException {
    synchronized (modAckDeadlines) {
      waitAtLeast(modAckDeadlines, expectedCount);
      List<ModifyAckDeadline> modAckDeadlinesCopy =
          ImmutableList.copyOf(modAckDeadlines.subList(0, expectedCount));
      modAckDeadlines.subList(0, expectedCount).clear();
      return modAckDeadlinesCopy;
    }
  }

  public int waitForClosedStreams(int expectedCount) throws InterruptedException {
    synchronized (closedStreams) {
      waitAtLeast(closedStreams, expectedCount);
      return closedStreams.size();
    }
  }

  public int waitForOpenedStreams(int expectedCount) throws InterruptedException {
    synchronized (openedStreams) {
      waitAtLeast(openedStreams, expectedCount);
      return openedStreams.size();
    }
  }

  // wait until the collection has at least target number of elements.
  // caller MUST hold the monitor for the collection.
  private static void waitAtLeast(Collection<?> collection, int target)
      throws InterruptedException {
    long untilMillis = System.currentTimeMillis() + 20_000;
    while (collection.size() < target) {
      long now = System.currentTimeMillis();
      if (now >= untilMillis) {
        throw new IllegalStateException("timed out, last state: " + collection);
      }
      collection.wait(untilMillis - now);
    }
  }

  public void waitForStreamAckDeadline(int expectedValue) throws InterruptedException {
    synchronized (messageAckDeadline) {
      while (messageAckDeadline.get() != expectedValue) {
        messageAckDeadline.wait();
      }
    }
  }

  public int getOpenedStreamsCount() {
    return openedStreams.size();
  }

  public int getClosedStreamsCount() {
    return closedStreams.size();
  }

  public List<String> getAcks() {
    return acks;
  }

  public List<ModifyAckDeadline> getModifyAckDeadlines() {
    return modAckDeadlines;
  }

  public void reset() {
    synchronized (subscriptionInitialized) {
      synchronized (openedStreams) {
        synchronized (acks) {
          synchronized (modAckDeadlines) {
            openedStreams.clear();
            closedStreams.clear();
            acks.clear();
            modAckDeadlines.clear();
            subscriptionInitialized.set(false);
            subscription = "";
            pullResponses.clear();
            receivedPullRequest.clear();
            currentStream = 0;
          }
        }
      }
    }
  }

  private void addOpenedStream(Stream stream) {
    synchronized (openedStreams) {
      openedStreams.add(stream);
      openedStreams.notifyAll();
    }
  }

  private void closeStream(Stream stream) {
    synchronized (openedStreams) {
      openedStreams.remove(stream);
      closedStreams.add(stream);
    }
    synchronized (closedStreams) {
      closedStreams.notifyAll();
    }
  }

  private int getAndAdvanceCurrentStream() {
    int current = currentStream;
    synchronized (openedStreams) {
      currentStream = (currentStream + 1) % openedStreams.size();
    }
    return current;
  }

  private void addReceivedAcks(Collection<String> newAckIds) {
    synchronized (acks) {
      acks.addAll(newAckIds);
      acks.notifyAll();
    }
  }

  private void addReceivedModifyAckDeadline(ModifyAckDeadline newAckDeadline) {
    synchronized (modAckDeadlines) {
      modAckDeadlines.add(newAckDeadline);
      modAckDeadlines.notifyAll();
    }
  }
}
