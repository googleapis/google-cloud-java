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
package com.google.cloud.bigquery.storage.v1;

import com.google.common.base.Optional;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.rpc.Code;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * A fake implementation of {@link BigQueryWriteImplBase} that can acts like server in StreamWriter
 * unit testing.
 */
class FakeBigQueryWriteImpl extends BigQueryWriteGrpc.BigQueryWriteImplBase {

  private static final Logger LOG = Logger.getLogger(FakeBigQueryWriteImpl.class.getName());
  private final List<Supplier<Response>> responses =
      Collections.synchronizedList(new ArrayList<>());
  private final LinkedBlockingQueue<AppendRowsRequest> requests = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<GetWriteStreamRequest> writeRequests =
      new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<FlushRowsRequest> flushRequests = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<WriteStream> writeResponses = new LinkedBlockingQueue<>();
  private final LinkedBlockingQueue<FlushRowsResponse> flushResponses = new LinkedBlockingQueue<>();
  private final AtomicInteger nextMessageId = new AtomicInteger(1);
  private boolean autoPublishResponse;
  private ScheduledExecutorService executor = null;

  private Duration responseSleep = Duration.ZERO;
  private Semaphore responseSemaphore = new Semaphore(0, true);

  private long numberTimesToClose = 0;
  private long closeAfter = 0;
  private long recordCount = 0;
  private long connectionCount = 0;
  private long closeForeverAfter = 0;
  private int responseIndex = 0;
  private long expectedOffset = 0;
  private boolean verifyOffset = false;
  private boolean returnErrorDuringExclusiveStreamRetry = false;
  private boolean returnErrorUntilRetrySuccess = false;
  private Response retryResponse;
  private long retryingOffset = -1;

  // Record whether the first record has been seen on a connection.
  private final Map<StreamObserver<AppendRowsResponse>, Boolean> connectionToFirstRequest =
      new ConcurrentHashMap<>();
  private Status failedStatus = Status.ABORTED;
  private ArrayList<Instant> requestReceivedInstants = new ArrayList<>();

  /** Class used to save the state of a possible response. */
  public static class Response {

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

  public ArrayList<Instant> getLatestRequestReceivedInstants() {
    return requestReceivedInstants;
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

  public void waitForResponseScheduled() throws InterruptedException {
    responseSemaphore.acquire();
  }

  /* Return the number of times the stream was connected. */
  public long getConnectionCount() {
    return connectionCount;
  }

  public void setFailedStatus(Status failedStatus) {
    this.failedStatus = failedStatus;
  }

  private Response determineResponse(long offset) {
    // The logic here checks to see if a retry is ongoing.  The implication is that the
    // offset that is being retried (retryingOffset) should lead to returning the same error
    // over and over until a request eventually resolves, instead of calling get() on
    // suppliers that, in the future, may be expected to trigger full retry loops.
    Response response;
    // Retry is in progress and the offset isn't the retrying offset; return saved response
    if (returnErrorUntilRetrySuccess && offset != retryingOffset) {
      response = retryResponse;
    } else {
      // We received the retryingOffset OR we aren't in retry mode; get response as
      // expected.
      // In case of connection reset: normally each response will only be sent once. But, if the
      // stream is aborted, the last few responses may not be received, and the client will request
      // them again.
      response = responses.get(Math.toIntExact(offset)).get();
      // If we are in retry mode and don't have an error, clear retry variables
      if (returnErrorUntilRetrySuccess && !response.getResponse().hasError()) {
        retryingOffset = -1;
        retryResponse = null;
      }
    }

    returnErrorUntilRetrySuccess =
        returnErrorDuringExclusiveStreamRetry && response.getResponse().hasError();
    // If this is a new retry cycle, set retry variables
    if (retryingOffset == -1 && returnErrorUntilRetrySuccess) {
      retryingOffset = offset;
      retryResponse = response;
    }

    return response;
  }

  @Override
  public StreamObserver<AppendRowsRequest> appendRows(
      final StreamObserver<AppendRowsResponse> responseObserver) {
    this.connectionCount++;
    connectionToFirstRequest.put(responseObserver, true);
    StreamObserver<AppendRowsRequest> requestObserver =
        new StreamObserver<AppendRowsRequest>() {
          @Override
          public void onNext(AppendRowsRequest value) {
            requestReceivedInstants.add(Instant.now());
            recordCount++;
            requests.add(value);
            long offset = value.getOffset().getValue();
            if (offset == -1 || !value.hasOffset()) {
              offset = responseIndex;
            }
            responseIndex++;
            if (responseSleep.compareTo(Duration.ZERO) > 0) {
              LOG.info("Sleeping before response for " + responseSleep.toString());
              Uninterruptibles.sleepUninterruptibly(
                  responseSleep.toMillis(), TimeUnit.MILLISECONDS);
            }
            if (connectionToFirstRequest.get(responseObserver)) {
              if (!value.getProtoRows().hasWriterSchema() || value.getWriteStream().isEmpty()) {
                LOG.info(
                    String.valueOf(
                        !value.getProtoRows().hasWriterSchema()
                            || value.getWriteStream().isEmpty()));
                responseObserver.onError(
                    Status.INVALID_ARGUMENT
                        .withDescription("Unexpected first request: " + value.toString())
                        .asException());
                return;
              }
            }
            connectionToFirstRequest.put(responseObserver, false);
            if (closeAfter > 0
                && responseIndex % closeAfter == 0
                && recordCount % closeAfter == 0
                && (numberTimesToClose == 0 || connectionCount <= numberTimesToClose)) {
              LOG.info("Shutting down connection from test...");
              responseObserver.onError(failedStatus.asException());
            } else if (closeForeverAfter > 0 && recordCount > closeForeverAfter) {
              LOG.info("Shutting down connection from test...");
              responseObserver.onError(failedStatus.asException());
            } else {
              Response response = determineResponse(offset);
              if (verifyOffset
                  && !response.getResponse().hasError()
                  && response.getResponse().getAppendResult().getOffset().getValue() > -1) {
                // No error and offset is present; verify order
                if (response.getResponse().getAppendResult().getOffset().getValue()
                    != expectedOffset) {
                  com.google.rpc.Status status =
                      com.google.rpc.Status.newBuilder().setCode(Code.INTERNAL_VALUE).build();
                  response = new Response(AppendRowsResponse.newBuilder().setError(status).build());
                } else {
                  LOG.info(
                      String.format(
                          "asserted offset: %s expected: %s",
                          response.getResponse().getAppendResult().getOffset().getValue(),
                          expectedOffset));
                  LOG.info(String.format("sending response: %s", response.getResponse()));
                  expectedOffset++;
                }
              }
              sendResponse(response, responseObserver);
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

  /** Set an amount of time by which to sleep before publishing responses. */
  public FakeBigQueryWriteImpl setResponseSleep(Duration responseSleep) {
    this.responseSleep = responseSleep;
    return this;
  }

  /**
   * Add a response to end of list. Response can be either an record, or an exception. All repsones
   * must be set up before any rows are appended.
   */
  public void addResponse(AppendRowsResponse appendRowsResponse) {
    responses.add(() -> new Response(appendRowsResponse));
  }

  /**
   * Add a response supplier to end of list. This supplier can be used to simulate retries or other
   * forms of behavior.
   */
  public void addResponse(Supplier<Response> response) {
    responses.add(response);
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
    responses.add(() -> new Response(error));
    return this;
  }

  /**
   * Returns the given status, instead of a valid response. This should be treated as an exception
   * on the other side. This will not stop processing.
   */
  public void addException(com.google.rpc.Status status) {
    responses.add(() -> new Response(AppendRowsResponse.newBuilder().setError(status).build()));
  }

  /**
   * Will abort the connection instead of return a valid response. This should NOT be used to return
   * a retriable error (as that will cause an infinite loop.)
   */
  public void addNonRetriableError(com.google.rpc.Status status) {
    responses.add(() -> new Response(AppendRowsResponse.newBuilder().setError(status).build()));
  }

  public void setVerifyOffset(boolean verifyOffset) {
    this.verifyOffset = verifyOffset;
  }

  public void setReturnErrorDuringExclusiveStreamRetry(boolean retryOnError) {
    this.returnErrorDuringExclusiveStreamRetry = retryOnError;
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

  /* Abort the stream after N records. The primary use case is to test the retry logic. After N
   * records are sent, the stream will be aborted with Code.ABORTED. This is a retriable error.
   * The abort will call the onDone callback immediately, and thus potentially losing some messages
   * that have already been sent. If the value of closeAfter is too small, the client might not get
   * a chance to process any records before a subsequent abort is sent. Which means multiple retries
   * in a row on the client side. After 3 retries in a row the write will fail.
   * closeAfter should be large enough to give the client some opportunity to receive some of the
   * messages.
   **/
  public void setCloseEveryNAppends(long closeAfter) {
    this.closeAfter = closeAfter;
  }

  /* If setCloseEveryNAppends is greater than 0, then the stream will be aborted every N appends.
   * setTimesToClose will limit the number of times to do the abort. If it is set to 0, it will
   * abort every N appends.
   * The primary use cases is, send a couple of records, then abort. But if there are only a couple
   * of records, it is possible these two records are sent, then the abort happens before those two
   * records are processed by the client, requiring them to be sent again, and thus a potential
   * infinite loop. Therefore set the times to close to 1. This will send the two records, force
   * an abort an retry, and then reprocess the records to completion.
   **/
  public void setTimesToClose(long numberTimesToClose) {
    this.numberTimesToClose = numberTimesToClose;
  }

  /* The connection will forever return failure after numberTimesToClose. This option shouldn't
   * be used together with setCloseEveryNAppends and setTimesToClose*/
  public void setCloseForeverAfter(long closeForeverAfter) {
    this.closeForeverAfter = closeForeverAfter;
  }
}
