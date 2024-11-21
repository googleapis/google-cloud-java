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

import com.google.common.base.Optional;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PublisherGrpc.PublisherImplBase;
import io.grpc.stub.StreamObserver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A fake implementation of {@link PublisherImplBase}, that can be used to test clients of a Cloud
 * Pub/Sub Publisher.
 */
class FakePublisherServiceImpl extends PublisherImplBase {

  private final LinkedBlockingQueue<PublishRequest> requests = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<Response> publishResponses = new LinkedBlockingQueue<>();
  private final AtomicInteger nextMessageId = new AtomicInteger(1);
  private boolean autoPublishResponse;
  private ScheduledExecutorService executor = null;
  private Duration responseDelay = Duration.ZERO;

  /** Class used to save the state of a possible response. */
  private static class Response {
    Optional<PublishResponse> publishResponse;
    Optional<Throwable> error;

    public Response(PublishResponse publishResponse) {
      this.publishResponse = Optional.of(publishResponse);
      this.error = Optional.absent();
    }

    public Response(Throwable exception) {
      this.publishResponse = Optional.absent();
      this.error = Optional.of(exception);
    }

    public PublishResponse getPublishResponse() {
      return publishResponse.get();
    }

    public Throwable getError() {
      return error.get();
    }

    boolean isError() {
      return error.isPresent();
    }

    @Override
    public String toString() {
      if (isError()) {
        return error.get().toString();
      }
      return publishResponse.get().toString();
    }
  }

  @Override
  public void publish(
      PublishRequest request, final StreamObserver<PublishResponse> responseObserver) {
    requests.add(request);
    Response response;
    try {
      if (autoPublishResponse) {
        PublishResponse.Builder builder = PublishResponse.newBuilder();
        for (int i = 0; i < request.getMessagesCount(); i++) {
          builder.addMessageIds(Integer.toString(nextMessageId.getAndIncrement()));
        }
        response = new Response(builder.build());
      } else {
        response = publishResponses.take();
      }
    } catch (InterruptedException e) {
      throw new IllegalArgumentException(e);
    }
    if (responseDelay == Duration.ZERO) {
      sendResponse(response, responseObserver);
    } else {
      final Response responseToSend = response;
      executor.schedule(
          new Runnable() {
            @Override
            public void run() {
              sendResponse(responseToSend, responseObserver);
            }
          },
          responseDelay.toMillis(),
          TimeUnit.MILLISECONDS);
    }
  }

  private void sendResponse(Response response, StreamObserver<PublishResponse> responseObserver) {
    if (response.isError()) {
      responseObserver.onError(response.getError());
    } else {
      responseObserver.onNext(response.getPublishResponse());
      responseObserver.onCompleted();
    }
  }

  /**
   * If enabled, PublishResponse is generated with a unique message id automatically when publish()
   * is called.
   */
  public FakePublisherServiceImpl setAutoPublishResponse(boolean autoPublishResponse) {
    this.autoPublishResponse = autoPublishResponse;
    return this;
  }

  /** Set an executor to use to delay publish responses. */
  public FakePublisherServiceImpl setExecutor(ScheduledExecutorService executor) {
    this.executor = executor;
    return this;
  }

  /** Set an amount of time by which to delay publish responses. */
  public FakePublisherServiceImpl setPublishResponseDelay(Duration responseDelay) {
    this.responseDelay = responseDelay;
    return this;
  }

  public FakePublisherServiceImpl addPublishResponse(PublishResponse publishResponse) {
    publishResponses.add(new Response(publishResponse));
    return this;
  }

  public FakePublisherServiceImpl addPublishResponse(
      PublishResponse.Builder publishResponseBuilder) {
    return addPublishResponse(publishResponseBuilder.build());
  }

  public FakePublisherServiceImpl addPublishError(Throwable error) {
    publishResponses.add(new Response(error));
    return this;
  }

  public List<PublishRequest> getCapturedRequests() {
    return new ArrayList<PublishRequest>(requests);
  }
}
