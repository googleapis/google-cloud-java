/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigquery.storage.util.Errors;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.ProtoData;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializtionError;
import com.google.cloud.bigquery.storage.v1.StreamConnection.DoneCallback;
import com.google.cloud.bigquery.storage.v1.StreamConnection.RequestCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.time.Instant;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>TODO: Support batching.
 *
 * <p>TODO: support updated schema
 */
public class ConnectionWorker implements AutoCloseable {
  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());

  private Lock lock;
  private Condition hasMessageInWaitingQueue;
  private Condition inflightReduced;

  /*
   * The identifier of the current stream to write to. This stream name can change during
   * multiplexing.
   */
  private String streamName;

  /*
   * The proto schema of rows to write. This schema can change during multiplexing.
   */
  private ProtoSchema writerSchema;

  /*
   * Max allowed inflight requests in the stream. Method append is blocked at this.
   */
  private final long maxInflightRequests;

  /*
   * Max allowed inflight bytes in the stream. Method append is blocked at this.
   */
  private final long maxInflightBytes;

  /*
   * Behavior when inflight queue is exceeded. Only supports Block or Throw, default is Block.
   */
  private final FlowController.LimitExceededBehavior limitExceededBehavior;

  /*
   * TraceId for debugging purpose.
   */
  private final String traceId;

  /*
   * Tracks current inflight requests in the stream.
   */
  @GuardedBy("lock")
  private long inflightRequests = 0;

  /*
   * Tracks current inflight bytes in the stream.
   */
  @GuardedBy("lock")
  private long inflightBytes = 0;

  /*
   * Tracks how often the stream was closed due to a retriable error. Streaming will stop when the
   * count hits a threshold. Streaming should only be halted, if it isn't possible to establish a
   * connection. Keep track of the number of reconnections in succession. This will be reset if
   * a row is successfully called back.
   */
  @GuardedBy("lock")
  private long conectionRetryCountWithoutCallback = 0;

  /*
   * If false, streamConnection needs to be reset.
   */
  @GuardedBy("lock")
  private boolean streamConnectionIsConnected = false;

  /*
   * A boolean to track if we cleaned up inflight queue.
   */
  @GuardedBy("lock")
  private boolean inflightCleanuped = false;

  /*
   * Indicates whether user has called Close() or not.
   */
  @GuardedBy("lock")
  private boolean userClosed = false;

  /*
   * The final status of connection. Set to nonnull when connection is permanently closed.
   */
  @GuardedBy("lock")
  private Throwable connectionFinalStatus = null;

  /*
   * Contains requests buffered in the client and not yet sent to server.
   */
  @GuardedBy("lock")
  private final Deque<AppendRequestAndResponse> waitingRequestQueue;

  /*
   * Contains sent append requests waiting for response from server.
   */
  @GuardedBy("lock")
  private final Deque<AppendRequestAndResponse> inflightRequestQueue;

  /*
   * Tracks number of destinations handled by this connection.
   */
  private final Set<String> destinationSet = ConcurrentHashMap.newKeySet();

  /*
   * Contains the updated TableSchema.
   */
  @GuardedBy("lock")
  private TableSchemaAndTimestamp updatedSchema;

  /*
   * A client used to interact with BigQuery.
   */
  private BigQueryWriteClient client;

  /*
   * If true, the client above is created by this writer and should be closed.
   */
  private boolean ownsBigQueryWriteClient = false;

  /*
   * Wraps the underlying bi-directional stream connection with server.
   */
  private StreamConnection streamConnection;

  /*
   * A separate thread to handle actual communication with server.
   */
  private Thread appendThread;

  /*
   * The inflight wait time for the previous sent request.
   */
  private final AtomicLong inflightWaitSec = new AtomicLong(0);

  /*
   * A String that uniquely identifies this writer.
   */
  private final String writerId = UUID.randomUUID().toString();

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  public ConnectionWorker(
      String streamName,
      ProtoSchema writerSchema,
      long maxInflightRequests,
      long maxInflightBytes,
      FlowController.LimitExceededBehavior limitExceededBehavior,
      String traceId,
      BigQueryWriteClient client,
      boolean ownsBigQueryWriteClient)
      throws IOException {
    this.lock = new ReentrantLock();
    this.hasMessageInWaitingQueue = lock.newCondition();
    this.inflightReduced = lock.newCondition();
    this.streamName = streamName;
    if (writerSchema == null) {
      throw new StatusRuntimeException(
          Status.fromCode(Code.INVALID_ARGUMENT)
              .withDescription("Writer schema must be provided when building this writer."));
    }
    this.writerSchema = writerSchema;
    this.maxInflightRequests = maxInflightRequests;
    this.maxInflightBytes = maxInflightBytes;
    this.limitExceededBehavior = limitExceededBehavior;
    this.traceId = traceId;
    this.waitingRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.inflightRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.client = client;
    this.ownsBigQueryWriteClient = ownsBigQueryWriteClient;

    this.appendThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                appendLoop();
              }
            });
    this.appendThread.start();
  }

  private void resetConnection() {
    this.streamConnection =
        new StreamConnection(
            this.client,
            new RequestCallback() {
              @Override
              public void run(AppendRowsResponse response) {
                requestCallback(response);
              }
            },
            new DoneCallback() {
              @Override
              public void run(Throwable finalStatus) {
                doneCallback(finalStatus);
              }
            });
  }

  /** Schedules the writing of rows at given offset. */
  ApiFuture<AppendRowsResponse> append(
      String streamName, ProtoSchema writerSchema, ProtoRows rows, long offset) {
    AppendRowsRequest.Builder requestBuilder = AppendRowsRequest.newBuilder();
    requestBuilder.setProtoRows(
        ProtoData.newBuilder().setWriterSchema(writerSchema).setRows(rows).build());
    if (offset >= 0) {
      requestBuilder.setOffset(Int64Value.of(offset));
    }
    requestBuilder.setWriteStream(streamName);
    return appendInternal(requestBuilder.build());
  }

  private ApiFuture<AppendRowsResponse> appendInternal(AppendRowsRequest message) {
    AppendRequestAndResponse requestWrapper = new AppendRequestAndResponse(message);
    if (requestWrapper.messageSize > getApiMaxRequestBytes()) {
      requestWrapper.appendResult.setException(
          new StatusRuntimeException(
              Status.fromCode(Code.INVALID_ARGUMENT)
                  .withDescription(
                      "MessageSize is too large. Max allow: "
                          + getApiMaxRequestBytes()
                          + " Actual: "
                          + requestWrapper.messageSize)));
      return requestWrapper.appendResult;
    }
    this.lock.lock();
    try {
      if (userClosed) {
        requestWrapper.appendResult.setException(
            new Exceptions.StreamWriterClosedException(
                Status.fromCode(Status.Code.FAILED_PRECONDITION)
                    .withDescription("Connection is already closed"),
                streamName,
                writerId));
        return requestWrapper.appendResult;
      }
      // Check if queue is going to be full before adding the request.
      if (this.limitExceededBehavior == FlowController.LimitExceededBehavior.ThrowException) {
        if (this.inflightRequests + 1 >= this.maxInflightRequests) {
          throw new Exceptions.InflightRequestsLimitExceededException(
              writerId, this.maxInflightRequests);
        }
        if (this.inflightBytes + requestWrapper.messageSize >= this.maxInflightBytes) {
          throw new Exceptions.InflightBytesLimitExceededException(writerId, this.maxInflightBytes);
        }
      }

      if (connectionFinalStatus != null) {
        requestWrapper.appendResult.setException(
            new Exceptions.StreamWriterClosedException(
                Status.fromCode(Status.Code.FAILED_PRECONDITION)
                    .withDescription(
                        "Connection is closed due to " + connectionFinalStatus.toString()),
                streamName,
                writerId));
        return requestWrapper.appendResult;
      }

      ++this.inflightRequests;
      this.inflightBytes += requestWrapper.messageSize;
      waitingRequestQueue.addLast(requestWrapper);
      hasMessageInWaitingQueue.signal();
      maybeWaitForInflightQuota();
      return requestWrapper.appendResult;
    } finally {
      this.lock.unlock();
    }
  }

  @GuardedBy("lock")
  private void maybeWaitForInflightQuota() {
    long start_time = System.currentTimeMillis();
    while (this.inflightRequests >= this.maxInflightRequests
        || this.inflightBytes >= this.maxInflightBytes) {
      try {
        inflightReduced.await(100, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
        log.warning(
            "Interrupted while waiting for inflight quota. Stream: "
                + streamName
                + " Error: "
                + e.toString());
        throw new StatusRuntimeException(
            Status.fromCode(Code.CANCELLED)
                .withCause(e)
                .withDescription("Interrupted while waiting for quota."));
      }
    }
    inflightWaitSec.set((System.currentTimeMillis() - start_time) / 1000);
  }

  public long getInflightWaitSeconds() {
    return inflightWaitSec.longValue();
  }

  /** @return a unique Id for the writer. */
  public String getWriterId() {
    return writerId;
  }

  /** Close the stream writer. Shut down all resources. */
  @Override
  public void close() {
    log.info("User closing stream: " + streamName);
    this.lock.lock();
    try {
      this.userClosed = true;
    } finally {
      this.lock.unlock();
    }
    log.fine("Waiting for append thread to finish. Stream: " + streamName);
    try {
      appendThread.join();
      log.info("User close complete. Stream: " + streamName);
    } catch (InterruptedException e) {
      // Unexpected. Just swallow the exception with logging.
      log.warning(
          "Append handler join is interrupted. Stream: " + streamName + " Error: " + e.toString());
    }
    if (this.ownsBigQueryWriteClient) {
      this.client.close();
      try {
        // Backend request has a 2 minute timeout, so wait a little longer than that.
        this.client.awaitTermination(150, TimeUnit.SECONDS);
      } catch (InterruptedException ignored) {
      }
    }
  }

  /*
   * This loop is executed in a separate thread.
   *
   * It takes requests from waiting queue and sends them to server.
   */
  private void appendLoop() {
    Deque<AppendRequestAndResponse> localQueue = new LinkedList<AppendRequestAndResponse>();
    boolean streamNeedsConnecting = false;

    // Indicate whether we are at the first request after switching destination.
    // True means the schema and other metadata are needed.
    boolean firstRequestForDestinationSwitch = true;
    // Represent whether we have entered multiplexing.
    boolean isMultiplexing = false;

    while (!waitingQueueDrained()) {
      this.lock.lock();
      try {
        hasMessageInWaitingQueue.await(100, TimeUnit.MILLISECONDS);
        // Copy the streamConnectionIsConnected guarded by lock to a local variable.
        // In addition, only reconnect if there is a retriable error.
        streamNeedsConnecting = !streamConnectionIsConnected && connectionFinalStatus == null;
        if (streamNeedsConnecting) {
          // If the stream connection is broken, any requests on inflightRequestQueue will need
          // to be resent, as the new connection has no knowledge of the requests. Copy the requests
          // from inflightRequestQueue and prepent them onto the waitinRequestQueue. They need to be
          // prepended as they need to be sent before new requests.
          while (!inflightRequestQueue.isEmpty()) {
            waitingRequestQueue.addFirst(inflightRequestQueue.pollLast());
          }
        }
        while (!this.waitingRequestQueue.isEmpty()) {
          AppendRequestAndResponse requestWrapper = this.waitingRequestQueue.pollFirst();
          this.inflightRequestQueue.addLast(requestWrapper);
          localQueue.addLast(requestWrapper);
        }
      } catch (InterruptedException e) {
        log.warning(
            "Interrupted while waiting for message. Stream: "
                + streamName
                + " Error: "
                + e.toString());
      } finally {
        this.lock.unlock();
      }

      if (localQueue.isEmpty()) {
        continue;
      }
      if (streamNeedsConnecting) {
        // Set streamConnectionIsConnected to true, to indicate the stream has been connected. This
        // should happen before the call to resetConnection. As it is unknown when the connection
        // could be closed and the doneCallback called, and thus clearing the flag.
        lock.lock();
        try {
          this.streamConnectionIsConnected = true;
        } finally {
          lock.unlock();
        }
        resetConnection();
        // Set firstRequestInConnection to indicate the next request to be sent should include
        // metedata. Reset everytime after reconnection.
        firstRequestForDestinationSwitch = true;
      }
      while (!localQueue.isEmpty()) {
        AppendRowsRequest originalRequest = localQueue.pollFirst().message;
        AppendRowsRequest.Builder originalRequestBuilder = originalRequest.toBuilder();

        // Consider we enter multiplexing if we met a different non empty stream name.
        if (!originalRequest.getWriteStream().isEmpty()
            && !streamName.isEmpty()
            && !originalRequest.getWriteStream().equals(streamName)) {
          streamName = originalRequest.getWriteStream();
          isMultiplexing = true;
          firstRequestForDestinationSwitch = true;
        }

        if (firstRequestForDestinationSwitch) {
          // If we are at the first request for every table switch, including the first request in
          // the connection, we will attach both stream name and table schema to the request.
          // We don't support change of schema change during multiplexing for the saeme stream name.
          destinationSet.add(streamName);
          if (this.traceId != null) {
            originalRequestBuilder.setTraceId(this.traceId);
          }
        } else if (!isMultiplexing) {
          // If we are not in multiplexing and not in the first request, clear the stream name.
          originalRequestBuilder.clearWriteStream();
        }

        // We don't use message differencer to speed up the comparing process.
        // `equals(...)` can bring us false positive, e.g. two repeated field can be considered the
        // same but is not considered equals(). However as long as it's never provide false negative
        // we will always correctly pass writer schema to backend.
        if (firstRequestForDestinationSwitch
            || !originalRequest.getProtoRows().getWriterSchema().equals(writerSchema)) {
          writerSchema = originalRequest.getProtoRows().getWriterSchema();
        } else {
          originalRequestBuilder.getProtoRowsBuilder().clearWriterSchema();
        }
        firstRequestForDestinationSwitch = false;

        // Send should only throw an exception if there is a problem with the request. The catch
        // block will handle this case, and return the exception with the result.
        // Otherwise send will return:
        //   SUCCESS: Message was sent, wait for the callback.
        //   STREAM_CLOSED: Stream was closed, normally or due to en error
        //   NOT_ENOUGH_QUOTA: Message wasn't sent due to not enough quota.
        // TODO: Handle NOT_ENOUGH_QUOTA.
        // In the close case, the request is in the inflight queue, and will either be returned
        // to the user with an error, or will be resent.
        log.fine(
            "Sending "
                + originalRequestBuilder.getProtoRows().getRows().getSerializedRowsCount()
                + " rows to stream '"
                + originalRequestBuilder.getWriteStream()
                + "'");
        this.streamConnection.send(originalRequestBuilder.build());
      }
    }

    log.fine("Cleanup starts. Stream: " + streamName);
    // At this point, the waiting queue is drained, so no more requests.
    // We can close the stream connection and handle the remaining inflight requests.
    if (streamConnection != null) {
      this.streamConnection.close();
      waitForDoneCallback(3, TimeUnit.MINUTES);
    }

    // At this point, there cannot be more callback. It is safe to clean up all inflight requests.
    log.fine(
        "Stream connection is fully closed. Cleaning up inflight requests. Stream: " + streamName);
    cleanupInflightRequests();
    log.fine("Append thread is done. Stream: " + streamName);
  }

  /*
   * Returns true if waiting queue is drain, a.k.a. no more requests in the waiting queue.
   *
   * It serves as a signal to append thread that there cannot be any more requests in the waiting
   * queue and it can prepare to stop.
   */
  private boolean waitingQueueDrained() {
    this.lock.lock();
    try {
      return (this.userClosed || this.connectionFinalStatus != null)
          && this.waitingRequestQueue.isEmpty();
    } finally {
      this.lock.unlock();
    }
  }

  private void waitForDoneCallback(long duration, TimeUnit timeUnit) {
    log.fine("Waiting for done callback from stream connection. Stream: " + streamName);
    long deadline = System.nanoTime() + timeUnit.toNanos(duration);
    while (System.nanoTime() <= deadline) {
      this.lock.lock();
      try {
        if (!this.streamConnectionIsConnected) {
          // Done callback is received, return.
          return;
        }
      } finally {
        this.lock.unlock();
      }
      Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
    }
    this.lock.lock();
    try {
      if (connectionFinalStatus == null) {
        connectionFinalStatus =
            new StatusRuntimeException(
                Status.fromCode(Code.CANCELLED)
                    .withDescription("Timeout waiting for DoneCallback."));
      }
    } finally {
      this.lock.unlock();
    }

    return;
  }

  private void cleanupInflightRequests() {
    Throwable finalStatus =
        new Exceptions.StreamWriterClosedException(
            Status.fromCode(Status.Code.FAILED_PRECONDITION)
                .withDescription("Connection is already closed, cleanup inflight request"),
            streamName,
            writerId);
    Deque<AppendRequestAndResponse> localQueue = new LinkedList<AppendRequestAndResponse>();
    this.lock.lock();
    try {
      if (this.connectionFinalStatus != null) {
        finalStatus = this.connectionFinalStatus;
      }
      while (!this.inflightRequestQueue.isEmpty()) {
        localQueue.addLast(pollInflightRequestQueue());
      }
      this.inflightCleanuped = true;
    } finally {
      this.lock.unlock();
    }
    log.fine("Cleaning " + localQueue.size() + " inflight requests with error: " + finalStatus);
    while (!localQueue.isEmpty()) {
      localQueue.pollFirst().appendResult.setException(finalStatus);
    }
  }

  private void requestCallback(AppendRowsResponse response) {
    if (!response.hasUpdatedSchema()) {
      log.fine(String.format("Got response on stream %s", response.toString()));
    } else {
      AppendRowsResponse responseWithUpdatedSchemaRemoved =
          response.toBuilder().clearUpdatedSchema().build();

      log.fine(
          String.format(
              "Got response with schema updated (omitting updated schema in response here): %s",
              responseWithUpdatedSchemaRemoved.toString()));
    }

    AppendRequestAndResponse requestWrapper;
    this.lock.lock();
    if (response.hasUpdatedSchema()) {
      this.updatedSchema =
          TableSchemaAndTimestamp.create(Instant.now(), response.getUpdatedSchema());
    }
    try {
      // Had a successful connection with at least one result, reset retries.
      // conectionRetryCountWithoutCallback is reset so that only multiple retries, without
      // successful records sent, will cause the stream to fail.
      if (conectionRetryCountWithoutCallback != 0) {
        conectionRetryCountWithoutCallback = 0;
      }
      if (!this.inflightRequestQueue.isEmpty()) {
        requestWrapper = pollInflightRequestQueue();
      } else if (inflightCleanuped) {
        // It is possible when requestCallback is called, the inflight queue is already drained
        // because we timed out waiting for done.
        return;
      } else {
        // This is something not expected, we shouldn't have an empty inflight queue otherwise.
        log.log(Level.WARNING, "Unexpected: request callback called on an empty inflight queue.");
        connectionFinalStatus =
            new StatusRuntimeException(
                Status.fromCode(Code.FAILED_PRECONDITION)
                    .withDescription("Request callback called on an empty inflight queue."));
        return;
      }
    } finally {
      this.lock.unlock();
    }
    if (response.hasError()) {
      Exceptions.StorageException storageException =
          Exceptions.toStorageException(response.getError(), null);
      if (storageException != null) {
        requestWrapper.appendResult.setException(storageException);
      } else if (response.getRowErrorsCount() > 0) {
        Map<Integer, String> rowIndexToErrorMessage = new HashMap<>();
        for (int i = 0; i < response.getRowErrorsCount(); i++) {
          RowError rowError = response.getRowErrors(i);
          rowIndexToErrorMessage.put(Math.toIntExact(rowError.getIndex()), rowError.getMessage());
        }
        AppendSerializtionError exception =
            new AppendSerializtionError(
                response.getError().getCode(),
                response.getError().getMessage(),
                streamName,
                rowIndexToErrorMessage);
        requestWrapper.appendResult.setException(exception);
      } else {
        StatusRuntimeException exception =
            new StatusRuntimeException(
                Status.fromCodeValue(response.getError().getCode())
                    .withDescription(response.getError().getMessage()));
        requestWrapper.appendResult.setException(exception);
      }
    } else {
      requestWrapper.appendResult.set(response);
    }
  }

  private boolean isRetriableError(Throwable t) {
    Status status = Status.fromThrowable(t);
    if (Errors.isRetryableInternalStatus(status)) {
      return true;
    }
    return status.getCode() == Code.ABORTED
        || status.getCode() == Code.UNAVAILABLE
        || status.getCode() == Code.CANCELLED;
  }

  private void doneCallback(Throwable finalStatus) {
    log.fine(
        "Received done callback. Stream: "
            + streamName
            + " Final status: "
            + finalStatus.toString());
    this.lock.lock();
    try {
      this.streamConnectionIsConnected = false;
      if (connectionFinalStatus == null) {
        // If the error can be retried, don't set it here, let it try to retry later on.
        if (isRetriableError(finalStatus) && !userClosed) {
          this.conectionRetryCountWithoutCallback++;
          log.fine(
              "Retriable error "
                  + finalStatus.toString()
                  + " received, retry count "
                  + conectionRetryCountWithoutCallback
                  + " for stream "
                  + streamName);
        } else {
          Exceptions.StorageException storageException = Exceptions.toStorageException(finalStatus);
          this.connectionFinalStatus = storageException != null ? storageException : finalStatus;
          log.info(
              "Connection finished with error "
                  + finalStatus.toString()
                  + " for stream "
                  + streamName);
        }
      }
    } finally {
      this.lock.unlock();
    }
  }

  @GuardedBy("lock")
  private AppendRequestAndResponse pollInflightRequestQueue() {
    AppendRequestAndResponse requestWrapper = this.inflightRequestQueue.pollFirst();
    --this.inflightRequests;
    this.inflightBytes -= requestWrapper.messageSize;
    this.inflightReduced.signal();
    return requestWrapper;
  }

  /** Thread-safe getter of updated TableSchema */
  synchronized TableSchemaAndTimestamp getUpdatedSchema() {
    return this.updatedSchema;
  }

  // Class that wraps AppendRowsRequest and its corresponding Response future.
  private static final class AppendRequestAndResponse {
    final SettableApiFuture<AppendRowsResponse> appendResult;
    final AppendRowsRequest message;
    final long messageSize;

    AppendRequestAndResponse(AppendRowsRequest message) {
      this.appendResult = SettableApiFuture.create();
      this.message = message;
      this.messageSize = message.getProtoRows().getSerializedSize();
    }
  }

  /** Returns the current workload of this worker. */
  public Load getLoad() {
    return Load.create(
        inflightBytes,
        inflightRequests,
        destinationSet.size(),
        maxInflightBytes,
        maxInflightRequests);
  }

  /**
   * Represent the current workload for this worker. Used for multiplexing algorithm to determine
   * the distribution of requests.
   */
  @AutoValue
  public abstract static class Load {
    // Consider the load on this worker to be overwhelmed when above some percentage of
    // in-flight bytes or in-flight requests count.
    private static double overwhelmedInflightCount = 0.2;
    private static double overwhelmedInflightBytes = 0.2;

    // Number of in-flight requests bytes in the worker.
    abstract long inFlightRequestsBytes();

    // Number of in-flight requests count in the worker.
    abstract long inFlightRequestsCount();

    // Number of destination handled by this worker.
    abstract long destinationCount();

    // Max number of in-flight requests count allowed.
    abstract long maxInflightBytes();

    // Max number of in-flight requests bytes allowed.
    abstract long maxInflightCount();

    static Load create(
        long inFlightRequestsBytes,
        long inFlightRequestsCount,
        long destinationCount,
        long maxInflightBytes,
        long maxInflightCount) {
      return new AutoValue_ConnectionWorker_Load(
          inFlightRequestsBytes,
          inFlightRequestsCount,
          destinationCount,
          maxInflightBytes,
          maxInflightCount);
    }

    boolean isOverwhelmed() {
      // Consider only in flight bytes and count for now, as by experiment those two are the most
      // efficient and has great simplity.
      return inFlightRequestsCount() > overwhelmedInflightCount * maxInflightCount()
          || inFlightRequestsBytes() > overwhelmedInflightBytes * maxInflightBytes();
    }

    // Compares two different load. First compare in flight request bytes split by size 1024 bucket.
    // Then compare the inflight requests count.
    // Then compare destination count of the two connections.
    public static final Comparator<Load> LOAD_COMPARATOR =
        Comparator.comparing((Load key) -> (int) (key.inFlightRequestsBytes() / 1024))
            .thenComparing((Load key) -> (int) (key.inFlightRequestsCount() / 100))
            .thenComparing(Load::destinationCount);

    // Compares two different load without bucket, used in smaller scale unit testing.
    public static final Comparator<Load> TEST_LOAD_COMPARATOR =
        Comparator.comparing((Load key) -> (int) key.inFlightRequestsBytes())
            .thenComparing((Load key) -> (int) key.inFlightRequestsCount())
            .thenComparing(Load::destinationCount);

    @VisibleForTesting
    public static void setOverwhelmedBytesThreshold(double newThreshold) {
      overwhelmedInflightBytes = newThreshold;
    }

    @VisibleForTesting
    public static void setOverwhelmedCountsThreshold(double newThreshold) {
      overwhelmedInflightCount = newThreshold;
    }
  }

  @AutoValue
  abstract static class TableSchemaAndTimestamp {
    // Shows the timestamp updated schema is reported from response
    abstract Instant updateTimeStamp();

    // The updated schema returned from server.
    abstract TableSchema updatedSchema();

    static TableSchemaAndTimestamp create(Instant updateTimeStamp, TableSchema updatedSchema) {
      return new AutoValue_ConnectionWorker_TableSchemaAndTimestamp(updateTimeStamp, updatedSchema);
    }
  }
}
