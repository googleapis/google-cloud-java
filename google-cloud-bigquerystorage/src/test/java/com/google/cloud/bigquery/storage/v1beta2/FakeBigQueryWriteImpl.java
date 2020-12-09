/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.storage.v1beta2;

import com.google.common.base.Optional;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * A fake implementation of {@link BigQueryWriteImplBase} that can acts like server in StreamWriter
 * unit testing.
 */
class FakeBigQueryWriteImpl extends BigQueryWriteGrpc.BigQueryWriteImplBase {
  private static final Logger LOG = Logger.getLogger(FakeBigQueryWriteImpl.class.getName());

  private final LinkedBlockingQueue<AppendRowsRequest> requests = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<GetWriteStreamRequest> writeRequests =
      new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<FlushRowsRequest> flushRequests = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<Response> responses = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<WriteStream> writeResponses = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<FlushRowsResponse> flushResponses = new LinkedBlockingQueue<>();
  private final AtomicInteger nextMessageId = new AtomicInteger(1);
  private boolean autoPublishResponse;
  private ScheduledExecutorService executor = null;
  private Duration responseDelay = Duration.ZERO;

  /** Class used to save the state of a possible response. */
  private static class Response {
    Optional<AppendRowsResponse> appendResponse;
    Optional<Throwable> error;

    public Response(AppendRowsResponse appendResponse) {
      this.appendResponse = Optional.of(appendResponse);
      this.error = Optional.absent();
    }

    public Response(Throwable exception) {
      this.appendResponse = Optional.absent();
      this.error = Optional.of(exception);
    }

    public AppendRowsResponse getResponse() {
      return appendResponse.get();
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
      return appendResponse.get().toString();
    }
  }

  @Override
  public void getWriteStream(
      GetWriteStreamRequest request, StreamObserver<WriteStream> responseObserver) {
    Object response = writeResponses.remove();
    if (response instanceof WriteStream) {
      writeRequests.add(request);
      responseObserver.onNext((WriteStream) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public void flushRows(
      FlushRowsRequest request, StreamObserver<FlushRowsResponse> responseObserver) {
    Object response = writeResponses.remove();
    if (response instanceof FlushRowsResponse) {
      flushRequests.add(request);
      responseObserver.onNext((FlushRowsResponse) response);
      responseObserver.onCompleted();
    } else if (response instanceof Exception) {
      responseObserver.onError((Exception) response);
    } else {
      responseObserver.onError(new IllegalArgumentException("Unrecognized response type"));
    }
  }

  @Override
  public StreamObserver<AppendRowsRequest> appendRows(
      final StreamObserver<AppendRowsResponse> responseObserver) {
    StreamObserver<AppendRowsRequest> requestObserver =
        new StreamObserver<AppendRowsRequest>() {
          @Override
          public void onNext(AppendRowsRequest value) {
            LOG.info("Get request:" + value.toString());
            final Response response = responses.remove();
            requests.add(value);
            if (responseDelay == Duration.ZERO) {
              sendResponse(response, responseObserver);
            } else {
              final Response responseToSend = response;
              LOG.info("Schedule a response to be sent at delay");
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

          @Override
          public void onError(Throwable t) {
            responseObserver.onError(t);
          }

          @Override
          public void onCompleted() {
            responseObserver.onCompleted();
          }
        };
    return requestObserver;
  }

  private void sendResponse(
      Response response, StreamObserver<AppendRowsResponse> responseObserver) {
    LOG.info("Sending response: " + response.toString());
    if (response.isError()) {
      responseObserver.onError(response.getError());
    } else {
      responseObserver.onNext(response.getResponse());
    }
  }

  /** Set an executor to use to delay publish responses. */
  public FakeBigQueryWriteImpl setExecutor(ScheduledExecutorService executor) {
    this.executor = executor;
    return this;
  }

  /** Set an amount of time by which to delay publish responses. */
  public FakeBigQueryWriteImpl setResponseDelay(Duration responseDelay) {
    this.responseDelay = responseDelay;
    return this;
  }

  public FakeBigQueryWriteImpl addResponse(AppendRowsResponse appendRowsResponse) {
    responses.add(new Response(appendRowsResponse));
    return this;
  }

  public FakeBigQueryWriteImpl addResponse(AppendRowsResponse.Builder appendResponseBuilder) {
    return addResponse(appendResponseBuilder.build());
  }

  public FakeBigQueryWriteImpl addWriteStreamResponse(WriteStream response) {
    writeResponses.add(response);
    return this;
  }

  public FakeBigQueryWriteImpl addFlushRowsResponse(FlushRowsResponse response) {
    flushResponses.add(response);
    return this;
  }

  public FakeBigQueryWriteImpl addConnectionError(Throwable error) {
    responses.add(new Response(error));
    return this;
  }

  public List<AppendRowsRequest> getCapturedRequests() {
    return new ArrayList<AppendRowsRequest>(requests);
  }

  public List<GetWriteStreamRequest> getCapturedWriteRequests() {
    return new ArrayList<GetWriteStreamRequest>(writeRequests);
  }

  public void reset() {
    requests.clear();
    responses.clear();
  }
}
