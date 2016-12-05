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

import com.google.api.client.util.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.pubsub.v1.PublisherGrpc.PublisherImplBase;
import com.google.pubsub.v1.StreamingPullRequest;
import com.google.pubsub.v1.StreamingPullResponse;
import com.google.pubsub.v1.SubscriberGrpc.SubscriberImplBase;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A fake implementation of {@link PublisherImplBase}, that can be used to test clients of a Cloud
 * Pub/Sub Publisher.
 */
class FakeSubscriberServiceImpl extends SubscriberImplBase {
  private final AtomicBoolean subscriptionInitialized = new AtomicBoolean(false);
  private String subscription = "";
  private final AtomicInteger streamAckDeadline = new AtomicInteger();
  private final List<Stream> openedStreams = new ArrayList<>();
  private final List<Stream> closedStreams = new ArrayList<>();
  private final List<String> acks = new ArrayList<>();
  private final List<ModifyAckDeadline> modAckDeadlines = new ArrayList<>();
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
  }

  private static class Stream {
    private StreamObserver<StreamingPullRequest> requestObserver;
    private StreamObserver<StreamingPullResponse> responseObserver;
  }

  private class PullStreamObserver implements StreamObserver<StreamingPullRequest> {
    private final Stream stream;

    public PullStreamObserver(Stream stream) {
      this.stream = stream;
    }

    @Override
    public void onNext(StreamingPullRequest request) {
      synchronized (stream) {
        if (!request.getSubscription().isEmpty()) {
          if (!initializeStream(request)) {
            return;
          }
        }

        if (request.getStreamAckDeadlineSeconds() > 0) {
          synchronized (streamAckDeadline) {
            streamAckDeadline.set(request.getStreamAckDeadlineSeconds());
            streamAckDeadline.notifyAll();
          }
        }
        if (subscription.isEmpty()) {
          closeStream(stream);
          stream.responseObserver.onError(
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
          processModifyAckDeadlines(request);
        }
      }
    }

    private boolean processModifyAckDeadlines(StreamingPullRequest request) {
      if (request.getModifyDeadlineAckIdsCount() != request.getModifyDeadlineSecondsCount()) {
        closeStream(stream);
        stream.responseObserver.onError(
            new StatusException(
                Status.fromCode(Code.ABORTED)
                    .withDescription("Invalid modify ack deadline request.")));
        return false;
      }
      Iterator<String> ackIds = request.getModifyDeadlineAckIdsList().iterator();
      Iterator<Integer> seconds = request.getModifyDeadlineSecondsList().iterator();
      while (ackIds.hasNext() && seconds.hasNext()) {
        addReceivedModifyAckDeadline(new ModifyAckDeadline(ackIds.next(), seconds.next()));
      }
      return true;
    }

    private boolean initializeStream(StreamingPullRequest request) {
      if (!subscription.isEmpty() && !subscription.equals(request.getSubscription())) {
        stream.responseObserver.onError(
            new StatusException(
                Status.fromCode(Code.ABORTED)
                    .withDescription("Can only set one subscription.")));
        return false;
      }

      synchronized (subscriptionInitialized) {
        if (subscription.isEmpty()) {
          if (request.getStreamAckDeadlineSeconds() == 0) {
            stream.responseObserver.onError(
                new StatusException(
                    Status.fromCode(Code.INVALID_ARGUMENT)
                        .withDescription("A stream must be initialized with a ack deadline.")));
            return false;
          }

          subscription = request.getSubscription();
          subscriptionInitialized.set(true);
          subscriptionInitialized.notifyAll();
        }
      }
      addOpenedStream(stream);
      stream.notifyAll();
      return true;
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
    final Stream stream = new Stream();
    stream.responseObserver = responseObserver;
    stream.requestObserver = new PullStreamObserver(stream);
    return stream.requestObserver;
  }

  public void sendResponse(StreamingPullResponse pullResponse) throws InterruptedException {
    waitForRegistedSubscription();
    synchronized (openedStreams) {
      openedStreams.get(getAndAdvanceCurrentStream()).responseObserver.onNext(pullResponse);
    }
  }

  public void sendError(Throwable error) throws InterruptedException {
    waitForRegistedSubscription();
    synchronized (openedStreams) {
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
      while (acks.size() < expectedCount) {
        acks.wait();
      }
      ImmutableList<String> receivedAcksCopy = ImmutableList.copyOf(acks);
      acks.clear();
      return receivedAcksCopy;
    }
  }

  public List<ModifyAckDeadline> waitAndConsumeModifyAckDeadlines(int expectedCount)
      throws InterruptedException {
    synchronized (modAckDeadlines) {
      while (modAckDeadlines.size() < expectedCount) {
        modAckDeadlines.wait();
      }
      ImmutableList<ModifyAckDeadline> modAckDeadlinesCopy = ImmutableList.copyOf(modAckDeadlines);
      modAckDeadlines.clear();
      return modAckDeadlinesCopy;
    }
  }

  public int waitForClosedStreams(int expectedCount) throws InterruptedException {
    synchronized (closedStreams) {
      while (closedStreams.size() < expectedCount) {
        closedStreams.wait();
      }
      return closedStreams.size();
    }
  }

  public int waitForOpenedStreams(int expectedCount) throws InterruptedException {
    synchronized (openedStreams) {
      while (openedStreams.size() < expectedCount) {
        openedStreams.wait();
      }
      return openedStreams.size();
    }
  }

  public void waitForStreamAckDeadline(int expectedValue) throws InterruptedException {
    synchronized (streamAckDeadline) {
      while (streamAckDeadline.get() != expectedValue) {
        streamAckDeadline.wait();
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
