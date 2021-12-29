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

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigquery.storage.util.Errors;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.ProtoData;
import com.google.cloud.bigquery.storage.v1.StreamConnection.DoneCallback;
import com.google.cloud.bigquery.storage.v1.StreamConnection.RequestCallback;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>TODO: Support batching.
 */
public class StreamWriter implements AutoCloseable {
  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());

  private Lock lock;
  private Condition hasMessageInWaitingQueue;
  private Condition inflightReduced;

  /*
   * The identifier of stream to write to.
   */
  private final String streamName;

  /*
   * The proto schema of rows to write.
   */
  private final ProtoSchema writerSchema;

  /*
   * Max allowed inflight requests in the stream. Method append is blocked at this.
   */
  private final long maxInflightRequests;

  /*
   * Max allowed inflight bytes in the stream. Method append is blocked at this.
   */
  private final long maxInflightBytes;

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
   * Retry threshold, limits how often the connection is retried before processing halts.
   */
  private static final long RETRY_THRESHOLD = 3;

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
   * Contains the updated TableSchema.
   */
  @GuardedBy("lock")
  private TableSchema updatedSchema;

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

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  private StreamWriter(Builder builder) throws IOException {
    this.lock = new ReentrantLock();
    this.hasMessageInWaitingQueue = lock.newCondition();
    this.inflightReduced = lock.newCondition();
    this.streamName = builder.streamName;
    if (builder.writerSchema == null) {
      throw new StatusRuntimeException(
          Status.fromCode(Code.INVALID_ARGUMENT)
              .withDescription("Writer schema must be provided when building this writer."));
    }
    this.writerSchema = builder.writerSchema;
    this.maxInflightRequests = builder.maxInflightRequest;
    this.maxInflightBytes = builder.maxInflightBytes;
    this.traceId = builder.traceId;
    this.waitingRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.inflightRequestQueue = new LinkedList<AppendRequestAndResponse>();
    if (builder.client == null) {
      BigQueryWriteSettings stubSettings =
          BigQueryWriteSettings.newBuilder()
              .setCredentialsProvider(builder.credentialsProvider)
              .setTransportChannelProvider(builder.channelProvider)
              .setEndpoint(builder.endpoint)
              // (b/185842996): Temporily fix this by explicitly providing the header.
              .setHeaderProvider(
                  FixedHeaderProvider.create(
                      "x-goog-request-params", "write_stream=" + this.streamName))
              .build();
      this.client = BigQueryWriteClient.create(stubSettings);
      this.ownsBigQueryWriteClient = true;
    } else {
      this.client = builder.client;
      this.ownsBigQueryWriteClient = false;
    }

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

  /**
   * Schedules the writing of rows at the end of current stream.
   *
   * @param rows the rows in serialized format to write to BigQuery.
   * @return the append response wrapped in a future.
   */
  public ApiFuture<AppendRowsResponse> append(ProtoRows rows) {
    return append(rows, -1);
  }

  /**
   * Schedules the writing of rows at given offset.
   *
   * <p>Example of writing rows with specific offset.
   *
   * <pre>{@code
   * ApiFuture<AppendRowsResponse> future = writer.append(rows, 0);
   * ApiFutures.addCallback(future, new ApiFutureCallback<AppendRowsResponse>() {
   *   public void onSuccess(AppendRowsResponse response) {
   *     if (!response.hasError()) {
   *       System.out.println("written with offset: " + response.getAppendResult().getOffset());
   *     } else {
   *       System.out.println("received an in stream error: " + response.getError().toString());
   *     }
   *   }
   *
   *   public void onFailure(Throwable t) {
   *     System.out.println("failed to write: " + t);
   *   }
   * }, MoreExecutors.directExecutor());
   * }</pre>
   *
   * @param rows the rows in serialized format to write to BigQuery.
   * @param offset the offset of the first row. Provide -1 to write at the current end of stream.
   * @return the append response wrapped in a future.
   */
  public ApiFuture<AppendRowsResponse> append(ProtoRows rows, long offset) {
    AppendRowsRequest.Builder requestBuilder = AppendRowsRequest.newBuilder();
    requestBuilder.setProtoRows(ProtoData.newBuilder().setRows(rows).build());
    if (offset >= 0) {
      requestBuilder.setOffset(Int64Value.of(offset));
    }
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
            new StatusRuntimeException(
                Status.fromCode(Status.Code.FAILED_PRECONDITION)
                    .withDescription("Stream is already closed")));
        return requestWrapper.appendResult;
      }
      if (connectionFinalStatus != null) {
        requestWrapper.appendResult.setException(
            new StatusRuntimeException(
                Status.fromCode(Status.Code.FAILED_PRECONDITION)
                    .withDescription(
                        "Stream is closed due to " + connectionFinalStatus.toString())));
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
        this.client.awaitTermination(1, TimeUnit.MINUTES);
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
    // Set firstRequestInConnection to true immediately after connecting the steam,
    // indicates then next row sent, needs the schema and other metadata.
    boolean isFirstRequestInConnection = true;
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
        // metedata.
        isFirstRequestInConnection = true;
      }
      while (!localQueue.isEmpty()) {
        AppendRowsRequest preparedRequest =
            prepareRequestBasedOnPosition(
                localQueue.pollFirst().message, isFirstRequestInConnection);
        // Send should only throw an exception if there is a problem with the request. The catch
        // block will handle this case, and return the exception with the result.
        // Otherwise send will return:
        //   SUCCESS: Message was sent, wait for the callback.
        //   STREAM_CLOSED: Stream was closed, normally or due to en error
        //   NOT_ENOUGH_QUOTA: Message wasn't sent due to not enough quota.
        // TODO: Handle NOT_ENOUGH_QUOTA.
        // In the close case, the request is in the inflight queue, and will either be returned
        // to the user with an error, or will be resent.
        this.streamConnection.send(preparedRequest);
        isFirstRequestInConnection = false;
      }
    }

    log.fine("Cleanup starts. Stream: " + streamName);
    // At this point, the waiting queue is drained, so no more requests.
    // We can close the stream connection and handle the remaining inflight requests.
    if (streamConnection != null) {
      this.streamConnection.close();
      waitForDoneCallback();
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

  private void waitForDoneCallback() {
    log.fine("Waiting for done callback from stream connection. Stream: " + streamName);
    while (true) {
      this.lock.lock();
      try {
        if (connectionFinalStatus != null) {
          // Done callback is received, return.
          return;
        }
      } finally {
        this.lock.unlock();
      }
      Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
    }
  }

  private AppendRowsRequest prepareRequestBasedOnPosition(
      AppendRowsRequest original, boolean isFirstRequest) {
    AppendRowsRequest.Builder requestBuilder = original.toBuilder();
    if (isFirstRequest) {
      if (this.writerSchema != null) {
        requestBuilder.getProtoRowsBuilder().setWriterSchema(this.writerSchema);
      }
      requestBuilder.setWriteStream(this.streamName);
      if (this.traceId != null) {
        requestBuilder.setTraceId(this.traceId);
      }
    } else {
      requestBuilder.clearWriteStream();
      requestBuilder.getProtoRowsBuilder().clearWriterSchema();
    }
    return requestBuilder.build();
  }

  private void cleanupInflightRequests() {
    Throwable finalStatus = new Exceptions.WriterClosedException(streamName);
    Deque<AppendRequestAndResponse> localQueue = new LinkedList<AppendRequestAndResponse>();
    this.lock.lock();
    try {
      if (this.connectionFinalStatus != null) {
        finalStatus = this.connectionFinalStatus;
      }
      while (!this.inflightRequestQueue.isEmpty()) {
        localQueue.addLast(pollInflightRequestQueue());
      }
    } finally {
      this.lock.unlock();
    }
    log.fine(
        "Cleaning "
            + localQueue.size()
            + " inflight requests with error: "
            + finalStatus.toString());
    while (!localQueue.isEmpty()) {
      localQueue.pollFirst().appendResult.setException(finalStatus);
    }
  }

  private void requestCallback(AppendRowsResponse response) {
    AppendRequestAndResponse requestWrapper;
    this.lock.lock();
    if (response.hasUpdatedSchema()) {
      this.updatedSchema = response.getUpdatedSchema();
    }
    try {
      // Had a successful connection with at least one result, reset retries.
      // conectionRetryCountWithoutCallback is reset so that only multiple retries, without
      // successful records sent, will cause the stream to fail.
      if (conectionRetryCountWithoutCallback != 0) {
        conectionRetryCountWithoutCallback = 0;
      }
      requestWrapper = pollInflightRequestQueue();
    } finally {
      this.lock.unlock();
    }
    if (response.hasError()) {
      Exceptions.StorageException storageException =
          Exceptions.toStorageException(response.getError(), null);
      if (storageException != null) {
        requestWrapper.appendResult.setException(storageException);
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
    return status.getCode() == Status.Code.ABORTED || status.getCode() == Status.Code.UNAVAILABLE;
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
        if (isRetriableError(finalStatus)
            && conectionRetryCountWithoutCallback < RETRY_THRESHOLD
            && !userClosed) {
          this.conectionRetryCountWithoutCallback++;
          log.fine(
              "Retriable error "
                  + finalStatus.toString()
                  + " received, retry count "
                  + conectionRetryCountWithoutCallback
                  + " for stream "
                  + streamName);
        } else {
          this.connectionFinalStatus = finalStatus;
          log.info(
              "Stream finished with error " + finalStatus.toString() + " for stream " + streamName);
        }
      }
    } finally {
      this.lock.unlock();
    }
    Exceptions.StorageException storageException = Exceptions.toStorageException(finalStatus);
    if (storageException != null) {
      this.connectionFinalStatus = storageException;
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

  /**
   * Constructs a new {@link StreamWriterV2.Builder} using the given stream and client. AppendRows
   * needs special headers to be added to client, so a passed in client will not work. This should
   * be used by test only.
   */
  public static StreamWriter.Builder newBuilder(String streamName, BigQueryWriteClient client) {
    return new StreamWriter.Builder(streamName, client);
  }

  /** Constructs a new {@link StreamWriterV2.Builder} using the given stream. */
  public static StreamWriter.Builder newBuilder(String streamName) {
    return new StreamWriter.Builder(streamName);
  }

  /** Thread-safe getter of updated TableSchema */
  public synchronized TableSchema getUpdatedSchema() {
    return this.updatedSchema;
  }

  /** A builder of {@link StreamWriter}s. */
  public static final class Builder {

    private static final long DEFAULT_MAX_INFLIGHT_REQUESTS = 1000L;

    private static final long DEFAULT_MAX_INFLIGHT_BYTES = 100 * 1024 * 1024; // 100Mb.

    private String streamName;

    private BigQueryWriteClient client;

    private ProtoSchema writerSchema = null;

    private long maxInflightRequest = DEFAULT_MAX_INFLIGHT_REQUESTS;

    private long maxInflightBytes = DEFAULT_MAX_INFLIGHT_BYTES;

    private String endpoint = BigQueryWriteSettings.getDefaultEndpoint();

    private TransportChannelProvider channelProvider =
        BigQueryWriteSettings.defaultGrpcTransportProviderBuilder().setChannelsPerCpu(1).build();

    private CredentialsProvider credentialsProvider =
        BigQueryWriteSettings.defaultCredentialsProviderBuilder().build();

    private String traceId = null;

    private TableSchema updatedTableSchema = null;

    private Builder(String streamName) {
      this.streamName = Preconditions.checkNotNull(streamName);
      this.client = null;
    }

    private Builder(String streamName, BigQueryWriteClient client) {
      this.streamName = Preconditions.checkNotNull(streamName);
      this.client = Preconditions.checkNotNull(client);
    }

    /** Sets the proto schema of the rows. */
    public Builder setWriterSchema(ProtoSchema writerSchema) {
      this.writerSchema = writerSchema;
      return this;
    }

    public Builder setMaxInflightRequests(long value) {
      this.maxInflightRequest = value;
      return this;
    }

    public Builder setMaxInflightBytes(long value) {
      this.maxInflightBytes = value;
      return this;
    }

    /** Gives the ability to override the gRPC endpoint. */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = Preconditions.checkNotNull(endpoint, "Endpoint is null.");
      return this;
    }

    /**
     * {@code ChannelProvider} to use to create Channels, which must point at Cloud BigQuery Storage
     * API endpoint.
     *
     * <p>For performance, this client benefits from having multiple underlying connections. See
     * {@link com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder#setPoolSize(int)}.
     */
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
      this.channelProvider =
          Preconditions.checkNotNull(channelProvider, "ChannelProvider is null.");
      return this;
    }

    /** {@code CredentialsProvider} to use to create Credentials to authenticate calls. */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.credentialsProvider =
          Preconditions.checkNotNull(credentialsProvider, "CredentialsProvider is null.");
      return this;
    }

    /**
     * Sets traceId for debuging purpose. TraceId must follow the format of
     * CustomerDomain:DebugString, e.g. DATAFLOW:job_id_x.
     */
    public Builder setTraceId(String traceId) {
      int colonIndex = traceId.indexOf(':');
      if (colonIndex == -1 || colonIndex == 0 || colonIndex == traceId.length() - 1) {
        throw new IllegalArgumentException(
            "TraceId must follow the format of A:B. Actual:" + traceId);
      }
      this.traceId = traceId;
      return this;
    }

    /** Builds the {@code StreamWriterV2}. */
    public StreamWriter build() throws IOException {
      return new StreamWriter(this);
    }
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
}
