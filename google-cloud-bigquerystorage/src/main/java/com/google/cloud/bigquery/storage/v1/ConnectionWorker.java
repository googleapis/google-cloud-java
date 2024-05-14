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
import com.google.api.core.NanoClock;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.MissingValueInterpretation;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.ProtoData;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializationError;
import com.google.cloud.bigquery.storage.v1.StreamConnection.DoneCallback;
import com.google.cloud.bigquery.storage.v1.StreamConnection.RequestCallback;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Int64Value;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>TODO: Support batching.
 *
 * <p>TODO: support updated schema
 */
class ConnectionWorker implements AutoCloseable {

  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());

  // Maximum wait time on inflight quota before error out.
  private static long INFLIGHT_QUOTA_MAX_WAIT_TIME_MILLI = 300000;

  /*
   * Maximum time waiting for request callback before shutting down the connection.
   *
   * We will constantly checking how much time we have been waiting for the next request callback
   * if we wait too much time we will start shutting down the connections and clean up the queues.
   */
  static Duration MAXIMUM_REQUEST_CALLBACK_WAIT_TIME = Duration.ofMinutes(5);

  private Lock lock;
  private Condition hasMessageInWaitingQueue;
  private Condition inflightReduced;
  /*
   * Max retry duration when trying to establish a connection.  This does not
   * apply to in-stream retries.
   */
  private final Duration maxRetryDuration;
  private ExecutorService threadPool = Executors.newFixedThreadPool(1);

  /*
   * The identifier of the current stream to write to. This stream name can change during
   * multiplexing.
   */
  private String streamName;

  /*
   * The location of this connection.
   */
  private String location = null;

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
   * Enables compression on the wire.
   */
  private String compressorName = null;
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

  @GuardedBy("lock")
  private long connectionRetryStartTime = 0;

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

  /*
   * Test only exception behavior testing params.
   */
  private RuntimeException testOnlyRunTimeExceptionInAppendLoop = null;
  private long testOnlyAppendLoopSleepTime = 0;

  /*
   * Tracks the number of responses to ignore in the case of exclusive stream retry
   */
  @GuardedBy("lock")
  private int responsesToIgnore = 0;

  /*
   * Contains settings related to in-stream retries.  If retrySettings is null,
   * this implies that no retries will occur on retryable in-stream errors.
   */
  private final RetrySettings retrySettings;

  private static String projectMatching = "projects/[^/]+/";
  private static Pattern streamPatternProject = Pattern.compile(projectMatching);

  static final Pattern DEFAULT_STREAM_PATTERN =
      Pattern.compile("projects/([^/]+)/datasets/([^/]+)/tables/([^/]+)/(streams/)?_default$");

  public static Boolean isDefaultStreamName(String streamName) {
    Matcher matcher = DEFAULT_STREAM_PATTERN.matcher(streamName);
    return matcher.matches();
  }

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 20L * 1000L * 1000L; // 20 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  static String extractProjectName(String streamName) {
    Matcher streamMatcher = streamPatternProject.matcher(streamName);
    if (streamMatcher.find()) {
      return streamMatcher.group();
    } else {
      throw new IllegalStateException(
          String.format("The passed in stream name does not match standard format %s", streamName));
    }
  }

  static String getRoutingHeader(String streamName, String location) {
    String project = extractProjectName(streamName);
    return project + "locations/" + location;
  }

  public ConnectionWorker(
      String streamName,
      String location,
      ProtoSchema writerSchema,
      long maxInflightRequests,
      long maxInflightBytes,
      Duration maxRetryDuration,
      FlowController.LimitExceededBehavior limitExceededBehavior,
      String traceId,
      @Nullable String compressorName,
      BigQueryWriteSettings clientSettings,
      RetrySettings retrySettings)
      throws IOException {
    this.lock = new ReentrantLock();
    this.hasMessageInWaitingQueue = lock.newCondition();
    this.inflightReduced = lock.newCondition();
    this.streamName = streamName;
    if (location != null && !location.isEmpty()) {
      this.location = location;
    }
    this.maxRetryDuration = maxRetryDuration != null ? maxRetryDuration : Duration.ofMinutes(5);
    if (writerSchema == null) {
      throw new StatusRuntimeException(
          Status.fromCode(Code.INVALID_ARGUMENT)
              .withDescription("Writer schema must be provided when building this writer."));
    }
    this.maxInflightRequests = maxInflightRequests;
    this.maxInflightBytes = maxInflightBytes;
    this.limitExceededBehavior = limitExceededBehavior;
    this.traceId = traceId;
    this.waitingRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.inflightRequestQueue = new LinkedList<AppendRequestAndResponse>();
    this.compressorName = compressorName;
    this.retrySettings = retrySettings;
    // Always recreate a client for connection worker.
    HashMap<String, String> newHeaders = new HashMap<>();
    newHeaders.putAll(clientSettings.toBuilder().getHeaderProvider().getHeaders());
    if (this.location == null) {
      newHeaders.put("x-goog-request-params", "write_stream=" + this.streamName);
    } else {
      newHeaders.put(
          "x-goog-request-params",
          "write_location=" + getRoutingHeader(this.streamName, this.location));
    }
    BigQueryWriteSettings stubSettings =
        clientSettings
            .toBuilder()
            .setHeaderProvider(FixedHeaderProvider.create(newHeaders))
            .build();
    this.client = BigQueryWriteClient.create(clientSettings);

    this.appendThread =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                appendLoop();
              }
            });
    appendThread.setUncaughtExceptionHandler(
        (Thread t, Throwable e) -> {
          log.warning(
              "Exception thrown from append loop, thus stream writer is shutdown due to exception: "
                  + e.toString());
          lock.lock();
          try {
            connectionFinalStatus = e;
            // Move all current waiting requests to in flight queue.
            while (!this.waitingRequestQueue.isEmpty()) {
              AppendRequestAndResponse requestWrapper = this.waitingRequestQueue.pollFirst();
              this.inflightRequestQueue.addLast(requestWrapper);
            }
          } finally {
            lock.unlock();
          }
          cleanupConnectionAndRequests(
              /* avoidBlocking= */ true); // don't perform blocking operations while on user thread
        });
    this.appendThread.start();
  }

  private void resetConnection() {
    log.info("Start connecting stream: " + streamName + " id: " + writerId);
    if (this.streamConnection != null) {
      // It's safe to directly close the previous connection as the in flight messages
      // will be picked up by the next connection.
      this.streamConnection.close();
      Uninterruptibles.sleepUninterruptibly(
          calculateSleepTimeMilli(conectionRetryCountWithoutCallback), TimeUnit.MILLISECONDS);
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
            },
            this.compressorName);
    log.info("Finish connecting stream: " + streamName + " id: " + writerId);
  }

  @GuardedBy("lock")
  private boolean shouldWaitForBackoff(AppendRequestAndResponse requestWrapper) {
    if (this.retrySettings != null
        && Instant.now().isBefore(requestWrapper.blockMessageSendDeadline)) {
      log.fine(
          String.format(
              "Waiting for wait queue to unblock at %s for retry # %s",
              requestWrapper.blockMessageSendDeadline, requestWrapper.retryCount));
      return true;
    }

    return false;
  }

  private void waitForBackoffIfNecessary(AppendRequestAndResponse requestWrapper) {
    lock.lock();
    try {
      Condition condition = lock.newCondition();
      while (shouldWaitForBackoff(requestWrapper)) {
        condition.await(100, java.util.concurrent.TimeUnit.MILLISECONDS);
      }
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    } finally {
      lock.unlock();
    }
  }

  @GuardedBy("lock")
  private void addMessageToFrontOfWaitingQueue(AppendRequestAndResponse requestWrapper) {
    addMessageToWaitingQueue(requestWrapper, /* addToFront= */ true);
  }

  @GuardedBy("lock")
  private void addMessageToBackOfWaitingQueue(AppendRequestAndResponse requestWrapper) {
    addMessageToWaitingQueue(requestWrapper, /* addToFront= */ false);
  }

  @GuardedBy("lock")
  private void addMessageToWaitingQueue(
      AppendRequestAndResponse requestWrapper, boolean addToFront) {
    ++this.inflightRequests;
    this.inflightBytes += requestWrapper.messageSize;
    hasMessageInWaitingQueue.signal();
    if (addToFront) {
      waitingRequestQueue.addFirst(requestWrapper);
    } else {
      waitingRequestQueue.add(requestWrapper);
    }
  }

  /** Schedules the writing of rows at given offset. */
  ApiFuture<AppendRowsResponse> append(StreamWriter streamWriter, ProtoRows rows, long offset) {
    if (this.location != null && !this.location.equals(streamWriter.getLocation())) {
      throw new StatusRuntimeException(
          Status.fromCode(Code.INVALID_ARGUMENT)
              .withDescription(
                  "StreamWriter with location "
                      + streamWriter.getLocation()
                      + " is scheduled to use a connection with location "
                      + this.location));
    } else if (this.location == null && !streamWriter.getStreamName().equals(this.streamName)) {
      // Location is null implies this is non-multiplexed connection.
      throw new StatusRuntimeException(
          Status.fromCode(Code.INVALID_ARGUMENT)
              .withDescription(
                  "StreamWriter with stream name "
                      + streamWriter.getStreamName()
                      + " is scheduled to use a connection with stream name "
                      + this.streamName));
    }
    Preconditions.checkNotNull(streamWriter);
    AppendRowsRequest.Builder requestBuilder = AppendRowsRequest.newBuilder();
    requestBuilder.setProtoRows(
        ProtoData.newBuilder()
            .setWriterSchema(streamWriter.getProtoSchema())
            .setRows(rows)
            .build());
    if (offset >= 0) {
      requestBuilder.setOffset(Int64Value.of(offset));
    }
    requestBuilder.setWriteStream(streamWriter.getStreamName());
    requestBuilder.putAllMissingValueInterpretations(
        streamWriter.getMissingValueInterpretationMap());
    if (streamWriter.getDefaultValueInterpretation()
        != MissingValueInterpretation.MISSING_VALUE_INTERPRETATION_UNSPECIFIED) {
      requestBuilder.setDefaultMissingValueInterpretation(
          streamWriter.getDefaultValueInterpretation());
    }
    return appendInternal(streamWriter, requestBuilder.build());
  }

  Boolean isUserClosed() {
    this.lock.lock();
    try {
      return userClosed;
    } finally {
      this.lock.unlock();
    }
  }

  String getWriteLocation() {
    return this.location;
  }

  private ApiFuture<AppendRowsResponse> appendInternal(
      StreamWriter streamWriter, AppendRowsRequest message) {
    AppendRequestAndResponse requestWrapper =
        new AppendRequestAndResponse(message, streamWriter, this.retrySettings);
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
                    .withDescription("Connection is already closed during append"),
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
      try {
        maybeWaitForInflightQuota();
      } catch (StatusRuntimeException ex) {
        --this.inflightRequests;
        waitingRequestQueue.pollLast();
        this.inflightBytes -= requestWrapper.messageSize;
        throw ex;
      }
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
      long current_wait_time = System.currentTimeMillis() - start_time;
      if (current_wait_time > INFLIGHT_QUOTA_MAX_WAIT_TIME_MILLI) {
        throw new StatusRuntimeException(
            Status.fromCode(Code.CANCELLED)
                .withDescription(
                    String.format(
                        "Interrupted while waiting for quota due to long waiting time %sms",
                        current_wait_time)));
      }
    }
    inflightWaitSec.set((System.currentTimeMillis() - start_time) / 1000);
  }

  @VisibleForTesting
  static long calculateSleepTimeMilli(long retryCount) {
    return (long) Math.min(Math.pow(2, retryCount) * 50, 60000);
  }

  @VisibleForTesting
  void setTestOnlyAppendLoopSleepTime(long testOnlyAppendLoopSleepTime) {
    this.testOnlyAppendLoopSleepTime = testOnlyAppendLoopSleepTime;
  }

  @VisibleForTesting
  void setTestOnlyRunTimeExceptionInAppendLoop(
      RuntimeException testOnlyRunTimeExceptionInAppendLoop) {
    this.testOnlyRunTimeExceptionInAppendLoop = testOnlyRunTimeExceptionInAppendLoop;
  }

  public long getInflightWaitSeconds() {
    return inflightWaitSec.longValue();
  }

  /** @return a unique Id for the writer. */
  public String getWriterId() {
    return writerId;
  }

  boolean isConnectionInUnrecoverableState() {
    this.lock.lock();
    try {
      // If final status is set, there's no
      return connectionFinalStatus != null;
    } finally {
      this.lock.unlock();
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
    log.info("Waiting for append thread to finish. Stream: " + streamName + " id: " + writerId);
    try {
      appendThread.join();
    } catch (InterruptedException e) {
      // Unexpected. Just swallow the exception with logging.
      log.warning(
          "Append handler join is interrupted. Stream: "
              + streamName
              + " id: "
              + writerId
              + " Error: "
              + e.toString());
    }
    this.client.close();
    try {
      // Backend request has a 2 minute timeout, so wait a little longer than that.
      this.client.awaitTermination(150, TimeUnit.SECONDS);
    } catch (InterruptedException ignored) {
      log.warning("Client await termination timeout in writer id " + writerId);
    }

    try {
      log.fine(
          "Begin shutting down user callback thread pool for stream "
              + streamName
              + " id: "
              + writerId);
      threadPool.shutdown();
      threadPool.awaitTermination(3, TimeUnit.MINUTES);
    } catch (InterruptedException e) {
      // Unexpected. Just swallow the exception with logging.
      log.warning(
          "Close on thread pool for "
              + streamName
              + " id: "
              + writerId
              + " is interrupted with exception: "
              + e.toString());
      throw new IllegalStateException(
          "Thread pool shutdown is interrupted for stream " + streamName);
    }
    log.info("User close finishes for stream " + streamName);
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
    boolean firstRequestForTableOrSchemaSwitch = true;
    // Represent whether we have entered multiplexing.
    boolean isMultiplexing = false;

    while (!waitingQueueDrained()) {
      this.lock.lock();
      try {
        hasMessageInWaitingQueue.await(100, TimeUnit.MILLISECONDS);
        // Check whether we should error out the current append loop.
        if (inflightRequestQueue.size() > 0) {
          Instant sendInstant = inflightRequestQueue.getFirst().requestSendTimeStamp;
          if (sendInstant != null) {
            throwIfWaitCallbackTooLong(sendInstant);
          }
        }

        // Copy the streamConnectionIsConnected guarded by lock to a local variable.
        // In addition, only reconnect if there is a retriable error.
        streamNeedsConnecting = !streamConnectionIsConnected && connectionFinalStatus == null;
        if (streamNeedsConnecting) {
          // If the stream connection is broken, any requests on inflightRequestQueue will need
          // to be resent, as the new connection has no knowledge of the requests. Copy the requests
          // from inflightRequestQueue and prepent them onto the waitinRequestQueue. They need to be
          // prepended as they need to be sent before new requests.
          while (!inflightRequestQueue.isEmpty()) {
            AppendRequestAndResponse requestWrapper = inflightRequestQueue.pollLast();
            requestWrapper.requestSendTimeStamp = null;
            waitingRequestQueue.addFirst(requestWrapper);
          }

          // If any of the inflight messages were meant to be ignored during requestCallback, they
          // no longer will be able to make the round trip, so clear responsesToIgnore.
          this.responsesToIgnore = 0;
        }
        while (!this.waitingRequestQueue.isEmpty()) {
          AppendRequestAndResponse requestWrapper = this.waitingRequestQueue.pollFirst();
          waitForBackoffIfNecessary(requestWrapper);
          this.inflightRequestQueue.add(requestWrapper);
          localQueue.addLast(requestWrapper);
        }
      } catch (InterruptedException e) {
        log.warning(
            "Interrupted while waiting for message. Stream: "
                + streamName
                + " id: "
                + writerId
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
        if (testOnlyRunTimeExceptionInAppendLoop != null) {
          Uninterruptibles.sleepUninterruptibly(testOnlyAppendLoopSleepTime, TimeUnit.MILLISECONDS);
          throw testOnlyRunTimeExceptionInAppendLoop;
        }
        resetConnection();
        // Set firstRequestInConnection to indicate the next request to be sent should include
        // metedata. Reset everytime after reconnection.
        firstRequestForTableOrSchemaSwitch = true;
      }
      while (!localQueue.isEmpty()) {
        localQueue.peekFirst().setRequestSendQueueTime();
        AppendRowsRequest originalRequest = localQueue.pollFirst().message;
        AppendRowsRequest.Builder originalRequestBuilder = originalRequest.toBuilder();
        // Always respect the first writer schema seen by the loop.
        if (writerSchema == null) {
          writerSchema = originalRequest.getProtoRows().getWriterSchema();
        }
        // Consider we enter multiplexing if we met a different non empty stream name or we meet
        // a new schema for the same stream name.
        // For the schema comparision we don't use message differencer to speed up the comparing
        // process. `equals(...)` can bring us false positive, e.g. two repeated field can be
        // considered the same but is not considered equals(). However as long as it's never provide
        // false negative we will always correctly pass writer schema to backend.
        if ((!originalRequest.getWriteStream().isEmpty()
                && !streamName.isEmpty()
                && !originalRequest.getWriteStream().equals(streamName))
            || (originalRequest.getProtoRows().hasWriterSchema()
                && !originalRequest.getProtoRows().getWriterSchema().equals(writerSchema))) {
          streamName = originalRequest.getWriteStream();
          writerSchema = originalRequest.getProtoRows().getWriterSchema();
          isMultiplexing = true;
          firstRequestForTableOrSchemaSwitch = true;
        }

        if (firstRequestForTableOrSchemaSwitch) {
          // If we are at the first request for every table switch, including the first request in
          // the connection, we will attach both stream name and table schema to the request.
          destinationSet.add(streamName);
          if (this.traceId != null) {
            originalRequestBuilder.setTraceId(this.traceId);
          }
        } else if (!isMultiplexing) {
          // If we are not in multiplexing and not in the first request, clear the stream name.
          originalRequestBuilder.clearWriteStream();
        }

        // During non table/schema switch requests, clear writer schema.
        if (!firstRequestForTableOrSchemaSwitch) {
          originalRequestBuilder.getProtoRowsBuilder().clearWriterSchema();
        }
        firstRequestForTableOrSchemaSwitch = false;

        // Send should only throw an exception if there is a problem with the request. The catch
        // block will handle this case, and return the exception with the result.
        // Otherwise send will return:
        //   SUCCESS: Message was sent, wait for the callback.
        //   STREAM_CLOSED: Stream was closed, normally or due to en error
        //   NOT_ENOUGH_QUOTA: Message wasn't sent due to not enough quota.
        // TODO: Handle NOT_ENOUGH_QUOTA.
        // In the close case, the request is in the inflight queue, and will either be returned
        // to the user with an error, or will be resent.
        this.streamConnection.send(originalRequestBuilder.build());
      }
    }
    cleanupConnectionAndRequests(/* avoidBlocking= */ false);
  }

  private void cleanupConnectionAndRequests(boolean avoidBlocking) {
    log.info(
        "Cleanup starts. Stream: "
            + streamName
            + " id: "
            + writerId
            + " userClose: "
            + userClosed
            + " final exception: "
            + (this.connectionFinalStatus == null
                ? "null"
                : this.connectionFinalStatus.toString()));
    // At this point, the waiting queue is drained, so no more requests.
    // We can close the stream connection and handle the remaining inflight requests.
    if (streamConnection != null) {
      this.streamConnection.close();
      if (!avoidBlocking) {
        waitForDoneCallback(3, TimeUnit.MINUTES);
      }
    }

    // At this point, there cannot be more callback. It is safe to clean up all inflight requests.
    log.info(
        "Stream connection is fully closed. Cleaning up inflight requests. Stream: "
            + streamName
            + " id: "
            + writerId);
    cleanupInflightRequests();
    log.info("Append thread is done. Stream: " + streamName + " id: " + writerId);
  }

  private void throwIfWaitCallbackTooLong(Instant timeToCheck) {
    Duration milliSinceLastCallback = Duration.between(timeToCheck, Instant.now());
    if (milliSinceLastCallback.compareTo(MAXIMUM_REQUEST_CALLBACK_WAIT_TIME) > 0) {
      throw new Exceptions.MaximumRequestCallbackWaitTimeExceededException(
          milliSinceLastCallback, writerId, MAXIMUM_REQUEST_CALLBACK_WAIT_TIME);
    }
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
    log.fine(
        "Waiting for done callback from stream connection. Stream: "
            + streamName
            + " id: "
            + writerId);
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
      log.warning("Donecallback is not triggered within timeout frame for writer " + writerId);
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
        localQueue.addLast(pollFirstInflightRequestQueue());
      }
      this.inflightCleanuped = true;
    } finally {
      this.lock.unlock();
    }
    log.fine(
        "Cleaning "
            + localQueue.size()
            + " inflight requests with error: "
            + finalStatus
            + " for Stream "
            + streamName
            + " id: "
            + writerId);
    int sizeOfQueue = localQueue.size();
    for (int i = 0; i < sizeOfQueue; i++) {
      if (i == 0) {
        localQueue.pollFirst().appendResult.setException(finalStatus);
      } else {
        localQueue
            .pollFirst()
            .appendResult
            .setException(
                new Exceptions.StreamWriterClosedException(
                    Status.fromCode(Code.ABORTED)
                        .withDescription(
                            "Connection is aborted due to an unrecoverable failure of "
                                + "another request sharing the connection. Please retry this "
                                + "request."),
                    streamName,
                    writerId));
      }
    }
  }

  private Boolean retryOnRetryableError(Code errorCode, AppendRequestAndResponse requestWrapper) {
    if (this.retrySettings == null) {
      return false;
    }

    if (this.retrySettings.getMaxAttempts() == 0) {
      return false;
    }

    if (!isConnectionErrorRetriable(errorCode) && errorCode != Code.RESOURCE_EXHAUSTED) {
      return false;
    }

    if (requestWrapper.retryCount < this.retrySettings.getMaxAttempts()) {
      lock.lock();
      try {
        requestWrapper.retryCount++;
        if (this.retrySettings != null && useBackoffForError(errorCode, streamName)) {
          // Trigger exponential backoff in append loop when request is resent for quota errors.
          // createNextAttempt correctly initializes the retry delay; createfirstAttempt does not
          // include a positive delay, just 0.
          requestWrapper.attemptSettings =
              requestWrapper.retryAlgorithm.createNextAttempt(
                  requestWrapper.attemptSettings == null
                      ? requestWrapper.retryAlgorithm.createFirstAttempt()
                      : requestWrapper.attemptSettings);
          requestWrapper.blockMessageSendDeadline =
              Instant.now().plusMillis(requestWrapper.attemptSettings.getRetryDelay().toMillis());
          log.info(
              "Messages blocked for retry for "
                  + java.time.Duration.between(
                      java.time.Instant.now(), requestWrapper.blockMessageSendDeadline)
                  + " until "
                  + requestWrapper.blockMessageSendDeadline);
        }

        Long offset =
            requestWrapper.message.hasOffset() ? requestWrapper.message.getOffset().getValue() : -1;
        if (isDefaultStreamName(streamName) || offset == -1) {
          log.info(
              String.format(
                  "Retrying default stream message in stream %s for in-stream error: %s, retry count:"
                      + " %s",
                  streamName, errorCode, requestWrapper.retryCount));
          addMessageToFrontOfWaitingQueue(requestWrapper);
        } else {
          log.info(
              String.format(
                  "Retrying exclusive message in stream %s at offset %d for in-stream error: %s, retry"
                      + " count: %s",
                  streamName,
                  requestWrapper.message.getOffset().getValue(),
                  errorCode,
                  requestWrapper.retryCount));
          // Send all inflight messages to front of queue
          while (!inflightRequestQueue.isEmpty()) {
            AppendRequestAndResponse element = pollLastInflightRequestQueue();
            addMessageToFrontOfWaitingQueue(element);
            responsesToIgnore++;
          }

          addMessageToFrontOfWaitingQueue(requestWrapper);
        }
        return true;
      } finally {
        lock.unlock();
      }
    }

    log.info(
        String.format(
            "Max retry count reached for message in stream %s at offset %d.  Retry count: %d",
            streamName, requestWrapper.message.getOffset().getValue(), requestWrapper.retryCount));
    return false;
  }

  private void requestCallback(AppendRowsResponse response) {
    if (response.hasUpdatedSchema()) {
      AppendRowsResponse responseWithUpdatedSchemaRemoved =
          response.toBuilder().clearUpdatedSchema().build();

      log.fine(
          String.format(
              "Got response with schema updated (omitting updated schema in response here): %s"
                  + " writer id %s",
              responseWithUpdatedSchemaRemoved.toString(), writerId));
    }

    AppendRequestAndResponse requestWrapper;
    this.lock.lock();
    try {
      // Ignored response has arrived
      if (responsesToIgnore > 0) {
        if (response.hasError()) {
          log.fine(
              String.format("Ignoring response in stream %s at offset %s.", streamName, response));
        } else {
          log.warning(
              String.format(
                  "Unexpected successful response in stream %s at offset %s.  Due to a previous"
                      + " retryable error being inflight, this message is being ignored.",
                  streamName, response.getAppendResult().getOffset()));
        }

        responsesToIgnore--;
        return;
      }

      if (response.hasUpdatedSchema()) {
        this.updatedSchema =
            TableSchemaAndTimestamp.create(System.nanoTime(), response.getUpdatedSchema());
      }
      // Had a successful connection with at least one result, reset retries.
      // conectionRetryCountWithoutCallback is reset so that only multiple retries, without
      // successful records sent, will cause the stream to fail.
      if (conectionRetryCountWithoutCallback != 0) {
        conectionRetryCountWithoutCallback = 0;
      }
      if (connectionRetryStartTime != 0) {
        connectionRetryStartTime = 0;
      }
      if (!this.inflightRequestQueue.isEmpty()) {
        requestWrapper = pollFirstInflightRequestQueue();
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

    // Retries need to happen on the same thread as queue locking may occur
    if (response.hasError()) {
      if (retryOnRetryableError(Code.values()[response.getError().getCode()], requestWrapper)) {
        log.info("Attempting to retry on error: " + response.getError().toString());
        return;
      }
    }

    // We need a separate thread pool to unblock the next request callback.
    // Otherwise user may call append inside request callback, which may be blocked on waiting
    // on in flight quota, causing deadlock as requests can't be popped out of queue until
    // the current request callback finishes.
    threadPool.submit(
        () -> {
          if (response.hasError()) {
            Exceptions.StorageException storageException =
                Exceptions.toStorageException(response.getError(), null);
            log.fine(String.format("Got error message: %s", response.toString()));
            if (storageException != null) {
              requestWrapper.appendResult.setException(storageException);
            } else if (response.getRowErrorsCount() > 0) {
              Map<Integer, String> rowIndexToErrorMessage = new HashMap<>();
              for (int i = 0; i < response.getRowErrorsCount(); i++) {
                RowError rowError = response.getRowErrors(i);
                rowIndexToErrorMessage.put(
                    Math.toIntExact(rowError.getIndex()), rowError.getMessage());
              }
              AppendSerializationError exception =
                  new AppendSerializationError(
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
        });
  }

  private boolean isConnectionErrorRetriable(Code statusCode) {
    return statusCode == Code.ABORTED
        || statusCode == Code.UNAVAILABLE
        || statusCode == Code.CANCELLED
        || statusCode == Code.INTERNAL
        || statusCode == Code.DEADLINE_EXCEEDED;
  }

  private boolean useBackoffForError(Code statusCode, String streamName) {
    // Default stream uses backoff for INTERNAL, as THROTTLED errors are more likely with default
    // streams.  RESOURCE_EXHAUSTED streams are used for backoff for each stream type.
    if (isDefaultStreamName(streamName)) {
      if (statusCode == Code.INTERNAL) {
        return true;
      }
    }
    return statusCode == Code.RESOURCE_EXHAUSTED;
  }

  private void doneCallback(Throwable finalStatus) {
    log.info(
        "Received done callback. Stream: "
            + streamName
            + " worker id: "
            + writerId
            + " Final status: "
            + finalStatus.toString());
    this.lock.lock();
    try {
      this.streamConnectionIsConnected = false;
      if (connectionFinalStatus == null) {
        if (connectionRetryStartTime == 0) {
          connectionRetryStartTime = System.currentTimeMillis();
        }
        // If the error can be retried, don't set it here, let it try to retry later on.
        if (isConnectionErrorRetriable(Status.fromThrowable(finalStatus).getCode())
            && !userClosed
            && (maxRetryDuration.toMillis() == 0f
                || System.currentTimeMillis() - connectionRetryStartTime
                    <= maxRetryDuration.toMillis())) {
          this.conectionRetryCountWithoutCallback++;
          log.info(
              "Connection is going to be reestablished with the next request. Retriable error "
                  + finalStatus.toString()
                  + " received, retry count "
                  + conectionRetryCountWithoutCallback
                  + ", millis left to retry "
                  + (maxRetryDuration.toMillis()
                      - (System.currentTimeMillis() - connectionRetryStartTime))
                  + ", for stream "
                  + streamName
                  + " id:"
                  + writerId);
        } else {
          Exceptions.StorageException storageException = Exceptions.toStorageException(finalStatus);
          this.connectionFinalStatus = storageException != null ? storageException : finalStatus;
          log.info(
              "Connection finished with error "
                  + finalStatus.toString()
                  + " for stream "
                  + streamName
                  + " with write id: "
                  + writerId);
        }
      }
    } finally {
      this.lock.unlock();
    }
  }

  @GuardedBy("lock")
  private AppendRequestAndResponse pollInflightRequestQueue(boolean pollLast) {
    AppendRequestAndResponse requestWrapper =
        pollLast ? inflightRequestQueue.pollLast() : inflightRequestQueue.poll();
    requestWrapper.requestSendTimeStamp = null;
    --this.inflightRequests;
    this.inflightBytes -= requestWrapper.messageSize;
    this.inflightReduced.signal();
    return requestWrapper;
  }

  @GuardedBy("lock")
  private AppendRequestAndResponse pollLastInflightRequestQueue() {
    return pollInflightRequestQueue(/* pollLast= */ true);
  }

  @GuardedBy("lock")
  private AppendRequestAndResponse pollFirstInflightRequestQueue() {
    return pollInflightRequestQueue(/* pollLast= */ false);
  }

  /** Thread-safe getter of updated TableSchema */
  synchronized TableSchemaAndTimestamp getUpdatedSchema() {
    return this.updatedSchema;
  }

  // Class that wraps AppendRowsRequest and its corresponding Response future.
  static final class AppendRequestAndResponse {

    final SettableApiFuture<AppendRowsResponse> appendResult;
    final AppendRowsRequest message;
    final long messageSize;
    // Used to determine the point at which appendLoop is able to process messages from the waiting
    // queue.  This is used to process errors that support exponential backoff retry.
    Instant blockMessageSendDeadline;

    Integer retryCount;
    ExponentialRetryAlgorithm retryAlgorithm;

    // The writer that issues the call of the request.
    final StreamWriter streamWriter;

    TimedAttemptSettings attemptSettings;

    // Time at which request was last sent over the network.
    // If a response is no longer expected this is set back to null.
    Instant requestSendTimeStamp;

    AppendRequestAndResponse(
        AppendRowsRequest message, StreamWriter streamWriter, RetrySettings retrySettings) {
      this.appendResult = SettableApiFuture.create();
      this.message = message;
      this.messageSize = message.getProtoRows().getSerializedSize();
      this.streamWriter = streamWriter;
      this.blockMessageSendDeadline = Instant.now();
      this.retryCount = 0;
      // To be set after first retry
      this.attemptSettings = null;
      if (retrySettings != null) {
        this.retryAlgorithm =
            new ExponentialRetryAlgorithm(retrySettings, NanoClock.getDefaultClock());
      } else {
        this.retryAlgorithm = null;
      }
    }

    void setRequestSendQueueTime() {
      requestSendTimeStamp = Instant.now();
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

  @VisibleForTesting
  static void setMaxInflightQueueWaitTime(long waitTime) {
    INFLIGHT_QUOTA_MAX_WAIT_TIME_MILLI = waitTime;
  }

  @VisibleForTesting
  static void setMaxInflightRequestWaitTime(Duration waitTime) {
    MAXIMUM_REQUEST_CALLBACK_WAIT_TIME = waitTime;
  }

  @AutoValue
  abstract static class TableSchemaAndTimestamp {

    // Shows the timestamp updated schema is reported from response
    abstract long updateTimeStamp();

    // The updated schema returned from server.
    abstract TableSchema updatedSchema();

    static TableSchemaAndTimestamp create(long updateTimeStamp, TableSchema updatedSchema) {
      return new AutoValue_ConnectionWorker_TableSchemaAndTimestamp(updateTimeStamp, updatedSchema);
    }
  }
}
