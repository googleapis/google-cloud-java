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

import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigquery.storage.v1beta2.StreamConnection.DoneCallback;
import com.google.cloud.bigquery.storage.v1beta2.StreamConnection.RequestCallback;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Uninterruptibles;
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
 * <p>TODO: Attach schema.
 *
 * <p>TODO: Attach traceId.
 *
 * <p>TODO: Support batching.
 *
 * <p>TODO: Support schema change.
 */
public class StreamWriterV2 implements AutoCloseable {
  private static final Logger log = Logger.getLogger(StreamWriterV2.class.getName());

  private Lock lock;
  private Condition hasMessageInWaitingQueue;
  private Condition inflightReduced;

  /*
   * The identifier of stream to write to.
   */
  private final String streamName;

  /*
   * Max allowed inflight requests in the stream. Method append is blocked at this.
   */
  private final long maxInflightRequests;

  /*
   * Max allowed inflight bytes in the stream. Method append is blocked at this.
   */
  private final long maxInflightBytes;

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
    return 8L * 1000L * 1000L; // 8 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  private StreamWriterV2(Builder builder) throws IOException {
    this.lock = new ReentrantLock();
    this.hasMessageInWaitingQueue = lock.newCondition();
    this.inflightReduced = lock.newCondition();
    this.streamName = builder.streamName;
    this.maxInflightRequests = builder.maxInflightRequest;
    this.maxInflightBytes = builder.maxInflightBytes;
    this.waitingRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.inflightRequestQueue = new LinkedList<AppendRequestAndResponse>();
    if (builder.client == null) {
      BigQueryWriteSettings stubSettings =
          BigQueryWriteSettings.newBuilder()
              .setCredentialsProvider(builder.credentialsProvider)
              .setTransportChannelProvider(builder.channelProvider)
              .setEndpoint(builder.endpoint)
              .build();
      this.client = BigQueryWriteClient.create(stubSettings);
      this.ownsBigQueryWriteClient = true;
    } else {
      this.client = builder.client;
      this.ownsBigQueryWriteClient = false;
    }
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

  /**
   * Schedules the writing of a message.
   *
   * <p>Example of writing a message.
   *
   * <pre>{@code
   * AppendRowsRequest message;
   * ApiFuture<AppendRowsResponse> messageIdFuture = writer.append(message);
   * ApiFutures.addCallback(messageIdFuture, new ApiFutureCallback<AppendRowsResponse>() {
   *   public void onSuccess(AppendRowsResponse response) {
   *     if (response.hasOffset()) {
   *       System.out.println("written with offset: " + response.getOffset());
   *     } else {
   *       System.out.println("received an in stream error: " + response.error().toString());
   *     }
   *   }
   *
   *   public void onFailure(Throwable t) {
   *     System.out.println("failed to write: " + t);
   *   }
   * }, MoreExecutors.directExecutor());
   * }</pre>
   *
   * @param message the message in serialized format to write to BigQuery.
   * @return the message ID wrapped in a future.
   */
  public ApiFuture<AppendRowsResponse> append(AppendRowsRequest message) {
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
    log.info("Waiting for append thread to finish. Stream: " + streamName);
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
    }
  }

  /*
   * This loop is executed in a separate thread.
   *
   * It takes requests from waiting queue and sends them to server.
   */
  private void appendLoop() {
    Deque<AppendRequestAndResponse> localQueue = new LinkedList<AppendRequestAndResponse>();
    while (!waitingQueueDrained()) {
      this.lock.lock();
      try {
        hasMessageInWaitingQueue.await(100, TimeUnit.MILLISECONDS);
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

      // TODO: Add reconnection here.
      while (!localQueue.isEmpty()) {
        this.streamConnection.send(localQueue.pollFirst().message);
      }
    }

    log.info("Cleanup starts. Stream: " + streamName);
    // At this point, the waiting queue is drained, so no more requests.
    // We can close the stream connection and handle the remaining inflight requests.
    this.streamConnection.close();
    waitForDoneCallback();

    // At this point, there cannot be more callback. It is safe to clean up all inflight requests.
    log.info(
        "Stream connection is fully closed. Cleaning up inflight requests. Stream: " + streamName);
    cleanupInflightRequests();
    log.info("Append thread is done. Stream: " + streamName);
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
    log.info("Waiting for done callback from stream connection. Stream: " + streamName);
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

  private void cleanupInflightRequests() {
    Throwable finalStatus;
    Deque<AppendRequestAndResponse> localQueue = new LinkedList<AppendRequestAndResponse>();
    this.lock.lock();
    try {
      finalStatus = this.connectionFinalStatus;
      while (!this.inflightRequestQueue.isEmpty()) {
        localQueue.addLast(pollInflightRequestQueue());
      }
    } finally {
      this.lock.unlock();
    }
    log.info(
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
    try {
      requestWrapper = pollInflightRequestQueue();
    } finally {
      this.lock.unlock();
    }
    requestWrapper.appendResult.set(response);
  }

  private void doneCallback(Throwable finalStatus) {
    log.info(
        "Received done callback. Stream: "
            + streamName
            + " Final status: "
            + finalStatus.toString());
    this.lock.lock();
    try {
      this.connectionFinalStatus = finalStatus;
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

  /** Constructs a new {@link StreamWriterV2.Builder} using the given stream and client. */
  public static StreamWriterV2.Builder newBuilder(String streamName, BigQueryWriteClient client) {
    return new StreamWriterV2.Builder(streamName, client);
  }

  /** Constructs a new {@link StreamWriterV2.Builder} using the given stream. */
  public static StreamWriterV2.Builder newBuilder(String streamName) {
    return new StreamWriterV2.Builder(streamName);
  }

  /** A builder of {@link StreamWriterV2}s. */
  public static final class Builder {

    private static final long DEFAULT_MAX_INFLIGHT_REQUESTS = 1000L;

    private static final long DEFAULT_MAX_INFLIGHT_BYTES = 100 * 1024 * 1024; // 100Mb.

    private String streamName;

    private BigQueryWriteClient client;

    private long maxInflightRequest = DEFAULT_MAX_INFLIGHT_REQUESTS;

    private long maxInflightBytes = DEFAULT_MAX_INFLIGHT_BYTES;

    private String endpoint = BigQueryWriteSettings.getDefaultEndpoint();

    private TransportChannelProvider channelProvider =
        BigQueryWriteSettings.defaultGrpcTransportProviderBuilder().setChannelsPerCpu(1).build();

    private CredentialsProvider credentialsProvider =
        BigQueryWriteSettings.defaultCredentialsProviderBuilder().build();

    private Builder(String streamName) {
      this.streamName = Preconditions.checkNotNull(streamName);
      this.client = null;
    }

    private Builder(String streamName, BigQueryWriteClient client) {
      this.streamName = Preconditions.checkNotNull(streamName);
      this.client = Preconditions.checkNotNull(client);
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

    /** Builds the {@code StreamWriterV2}. */
    public StreamWriterV2 build() throws IOException {
      return new StreamWriterV2(this);
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
