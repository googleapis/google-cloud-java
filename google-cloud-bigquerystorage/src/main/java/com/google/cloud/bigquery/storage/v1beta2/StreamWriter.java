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
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.core.BackgroundResourceAggregation;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorAsBackgroundResource;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.AbortedException;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.ClientStream;
import com.google.api.gax.rpc.ResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.bigquery.storage.v1beta2.StorageProto.*;
import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.Duration;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>This is to be used to managed streaming write when you are working with PENDING streams or
 * want to explicitly manage offset. In that most common cases when writing with COMMITTED stream
 * without offset, please use a simpler writer {@code DirectWriter}.
 *
 * <p>A {@link StreamWrier} provides built-in capabilities to: handle batching of messages;
 * controlling memory utilization (through flow control); automatic connection re-establishment and
 * request cleanup (only keeps write schema on first request in the stream).
 *
 * <p>With customizable options that control:
 *
 * <ul>
 *   <li>Message batching: such as number of messages or max batch byte size, and batching deadline
 *   <li>Inflight message control: such as number of messages or max batch byte size
 * </ul>
 *
 * <p>{@link StreamWriter} will use the credentials set on the channel, which uses application
 * default credentials through {@link GoogleCredentials#getApplicationDefault} by default.
 */
public class StreamWriter implements AutoCloseable {
  private static final Logger LOG = Logger.getLogger(StreamWriter.class.getName());

  private static String streamPatternString =
      "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)/(streams/[^/]+|_default)";

  private static Pattern streamPattern = Pattern.compile(streamPatternString);

  private final String streamName;
  private final String tableName;

  private final BatchingSettings batchingSettings;
  private final RetrySettings retrySettings;
  private BigQueryWriteSettings stubSettings;

  private final Lock messagesBatchLock;
  private final Lock appendAndRefreshAppendLock;
  private final MessagesBatch messagesBatch;

  // Indicates if a stream has some non recoverable exception happened.
  private final Lock exceptionLock;
  private Throwable streamException;

  private BackgroundResource backgroundResources;
  private List<BackgroundResource> backgroundResourceList;

  private BigQueryWriteClient stub;
  BidiStreamingCallable<AppendRowsRequest, AppendRowsResponse> bidiStreamingCallable;
  ClientStream<AppendRowsRequest> clientStream;
  private final AppendResponseObserver responseObserver;

  private final ScheduledExecutorService executor;

  private final AtomicBoolean shutdown;
  private final Waiter messagesWaiter;
  private final AtomicBoolean activeAlarm;
  private ScheduledFuture<?> currentAlarmFuture;

  private Integer currentRetries = 0;

  // Used for schema updates
  private OnSchemaUpdateRunnable onSchemaUpdateRunnable;

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  /** The maximum size of in flight requests. Defined by the API. */
  public static long getApiMaxInflightRequests() {
    return 5000L;
  }

  private StreamWriter(Builder builder)
      throws IllegalArgumentException, IOException, InterruptedException {
    Matcher matcher = streamPattern.matcher(builder.streamName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid stream name: " + builder.streamName);
    }
    streamName = builder.streamName;
    tableName = matcher.group(1);

    this.batchingSettings = builder.batchingSettings;
    this.retrySettings = builder.retrySettings;
    this.messagesBatch = new MessagesBatch(batchingSettings, this.streamName, this);
    messagesBatchLock = new ReentrantLock();
    appendAndRefreshAppendLock = new ReentrantLock();
    activeAlarm = new AtomicBoolean(false);
    this.exceptionLock = new ReentrantLock();
    this.streamException = null;

    executor = builder.executorProvider.getExecutor();
    backgroundResourceList = new ArrayList<>();
    if (builder.executorProvider.shouldAutoClose()) {
      backgroundResourceList.add(new ExecutorAsBackgroundResource(executor));
    }
    messagesWaiter = new Waiter(this.batchingSettings.getFlowControlSettings());
    responseObserver = new AppendResponseObserver(this);

    if (builder.client == null) {
      stubSettings =
          BigQueryWriteSettings.newBuilder()
              .setCredentialsProvider(builder.credentialsProvider)
              .setTransportChannelProvider(builder.channelProvider)
              .setEndpoint(builder.endpoint)
              .build();
      stub = BigQueryWriteClient.create(stubSettings);
      backgroundResourceList.add(stub);
    } else {
      stub = builder.client;
    }
    backgroundResources = new BackgroundResourceAggregation(backgroundResourceList);
    shutdown = new AtomicBoolean(false);
    if (builder.onSchemaUpdateRunnable != null) {
      this.onSchemaUpdateRunnable = builder.onSchemaUpdateRunnable;
      this.onSchemaUpdateRunnable.setStreamWriter(this);
    }

    refreshAppend();
  }

  /** Stream name we are writing to. */
  public String getStreamNameString() {
    return streamName;
  }

  /** Table name we are writing to. */
  public String getTableNameString() {
    return tableName;
  }

  /** OnSchemaUpdateRunnable for this streamWriter. */
  OnSchemaUpdateRunnable getOnSchemaUpdateRunnable() {
    return this.onSchemaUpdateRunnable;
  }

  private void setException(Throwable t) {
    exceptionLock.lock();
    if (this.streamException == null) {
      this.streamException = t;
    }
    exceptionLock.unlock();
  }

  /**
   * Schedules the writing of a message. The write of the message may occur immediately or be
   * delayed based on the writer batching options.
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
    appendAndRefreshAppendLock.lock();
    Preconditions.checkState(!shutdown.get(), "Cannot append on a shut-down writer.");
    Preconditions.checkNotNull(message, "Message is null.");
    final AppendRequestAndFutureResponse outstandingAppend =
        new AppendRequestAndFutureResponse(message);
    List<InflightBatch> batchesToSend;
    messagesBatchLock.lock();
    try {
      batchesToSend = messagesBatch.add(outstandingAppend);
      // Setup the next duration based delivery alarm if there are messages batched.
      setupAlarm();
      if (!batchesToSend.isEmpty()) {
        for (final InflightBatch batch : batchesToSend) {
          LOG.fine("Scheduling a batch for immediate sending.");
          writeBatch(batch);
        }
      }
    } finally {
      messagesBatchLock.unlock();
      appendAndRefreshAppendLock.unlock();
    }

    return outstandingAppend.appendResult;
  }

  /**
   * This is the general flush method for asynchronise append operation. When you have outstanding
   * append requests, calling flush will make sure all outstanding append requests completed and
   * successful. Otherwise there will be an exception thrown.
   *
   * @throws Exception
   */
  public void flushAll(long timeoutMillis) throws Exception {
    appendAndRefreshAppendLock.lock();
    try {
      writeAllOutstanding();
      synchronized (messagesWaiter) {
        messagesWaiter.waitComplete(timeoutMillis);
      }
    } finally {
      appendAndRefreshAppendLock.unlock();
    }
    exceptionLock.lock();
    try {
      if (streamException != null) {
        throw new Exception(streamException);
      }
    } finally {
      exceptionLock.unlock();
    }
  }

  /**
   * Re-establishes a stream connection.
   *
   * @throws IOException
   */
  public void refreshAppend() throws IOException, InterruptedException {
    appendAndRefreshAppendLock.lock();
    if (shutdown.get()) {
      LOG.warning("Cannot refresh on a already shutdown writer.");
      appendAndRefreshAppendLock.unlock();
      return;
    }
    // There could be a moment, stub is not yet initialized.
    if (clientStream != null) {
      LOG.info("Closing the stream " + streamName);
      clientStream.closeSend();
    }
    messagesBatch.resetAttachSchema();
    bidiStreamingCallable = stub.appendRowsCallable();
    clientStream = bidiStreamingCallable.splitCall(responseObserver);
    try {
      while (!clientStream.isSendReady()) {
        Thread.sleep(10);
      }
    } catch (InterruptedException expected) {
    }
    Thread.sleep(this.retrySettings.getInitialRetryDelay().toMillis());
    // Can only unlock here since need to sleep the full 7 seconds before stream can allow appends.
    appendAndRefreshAppendLock.unlock();
    LOG.info("Write Stream " + streamName + " connection established");
  }

  private void setupAlarm() {
    if (!messagesBatch.isEmpty()) {
      if (!activeAlarm.getAndSet(true)) {
        long delayThresholdMs = getBatchingSettings().getDelayThreshold().toMillis();
        LOG.log(Level.FINE, "Setting up alarm for the next {0} ms.", delayThresholdMs);
        currentAlarmFuture =
            executor.schedule(
                new Runnable() {
                  @Override
                  public void run() {
                    LOG.fine("Sending messages based on schedule");
                    activeAlarm.getAndSet(false);
                    messagesBatchLock.lock();
                    try {
                      writeBatch(messagesBatch.popBatch());
                    } finally {
                      messagesBatchLock.unlock();
                    }
                  }
                },
                delayThresholdMs,
                TimeUnit.MILLISECONDS);
      }
    } else if (currentAlarmFuture != null) {
      LOG.log(Level.FINER, "Cancelling alarm, no more messages");
      if (activeAlarm.getAndSet(false)) {
        currentAlarmFuture.cancel(false);
      }
    }
  }

  /**
   * Write any outstanding batches if non-empty. This method sends buffered messages, but does not
   * wait for the send operations to complete. To wait for messages to send, call {@code get} on the
   * futures returned from {@code append}.
   */
  public void writeAllOutstanding() {
    InflightBatch unorderedOutstandingBatch = null;
    messagesBatchLock.lock();
    try {
      if (!messagesBatch.isEmpty()) {
        writeBatch(messagesBatch.popBatch());
      }
      messagesBatch.reset();
    } finally {
      messagesBatchLock.unlock();
    }
  }

  private void writeBatch(final InflightBatch inflightBatch) {
    if (inflightBatch != null) {
      AppendRowsRequest request = inflightBatch.getMergedRequest();
      try {
        messagesWaiter.acquire(inflightBatch.getByteSize());
        responseObserver.addInflightBatch(inflightBatch);
        clientStream.send(request);
      } catch (FlowController.FlowControlException ex) {
        inflightBatch.onFailure(ex);
      }
    }
  }

  /** Close the stream writer. Shut down all resources. */
  @Override
  public void close() {
    LOG.info("Closing stream writer:" + streamName);
    shutdown();
    try {
      awaitTermination(1, TimeUnit.MINUTES);
    } catch (InterruptedException ignored) {
    }
  }

  // The batch of messages that is being sent/processed.
  private static final class InflightBatch {
    // List of requests that is going to be batched.
    final List<AppendRequestAndFutureResponse> inflightRequests;
    // A list tracks expected offset for each AppendRequest. Used to reconstruct the Response
    // future.
    private final ArrayList<Long> offsetList;
    private final long creationTime;
    private int attempt;
    private long batchSizeBytes;
    private long expectedOffset;
    private Boolean attachSchema;
    private String streamName;
    private final AtomicBoolean failed;
    private final StreamWriter streamWriter;

    InflightBatch(
        List<AppendRequestAndFutureResponse> inflightRequests,
        long batchSizeBytes,
        String streamName,
        Boolean attachSchema,
        StreamWriter streamWriter) {
      this.inflightRequests = inflightRequests;
      this.offsetList = new ArrayList<Long>(inflightRequests.size());
      for (AppendRequestAndFutureResponse request : inflightRequests) {
        if (request.message.getOffset().getValue() > 0) {
          offsetList.add(new Long(request.message.getOffset().getValue()));
        } else {
          offsetList.add(new Long(-1));
        }
      }
      this.expectedOffset = offsetList.get(0).longValue();
      attempt = 1;
      creationTime = System.currentTimeMillis();
      this.batchSizeBytes = batchSizeBytes;
      this.attachSchema = attachSchema;
      this.streamName = streamName;
      this.failed = new AtomicBoolean(false);
      this.streamWriter = streamWriter;
    }

    int count() {
      return inflightRequests.size();
    }

    long getByteSize() {
      return this.batchSizeBytes;
    }

    long getExpectedOffset() {
      return expectedOffset;
    }

    private AppendRowsRequest getMergedRequest() throws IllegalStateException {
      if (inflightRequests.size() == 0) {
        throw new IllegalStateException("Unexpected empty message batch");
      }
      ProtoRows.Builder rowsBuilder =
          inflightRequests.get(0).message.getProtoRows().getRows().toBuilder();
      for (int i = 1; i < inflightRequests.size(); i++) {
        rowsBuilder.addAllSerializedRows(
            inflightRequests.get(i).message.getProtoRows().getRows().getSerializedRowsList());
      }
      AppendRowsRequest.ProtoData.Builder data =
          inflightRequests.get(0).message.getProtoRows().toBuilder().setRows(rowsBuilder.build());
      AppendRowsRequest.Builder requestBuilder = inflightRequests.get(0).message.toBuilder();
      if (!attachSchema) {
        data.clearWriterSchema();
        requestBuilder.clearWriteStream();
      } else {
        if (!data.hasWriterSchema()) {
          throw new IllegalStateException(
              "The first message on the connection must have writer schema set");
        }
        requestBuilder.setWriteStream(streamName);
      }
      return requestBuilder.setProtoRows(data.build()).build();
    }

    private void onFailure(Throwable t) {
      if (failed.getAndSet(true)) {
        // Error has been set already.
        LOG.warning("Ignore " + t.toString() + " since error has already been set");
        return;
      } else {
        LOG.info("Setting " + t.toString() + " on response");
        this.streamWriter.setException(t);
      }

      for (AppendRequestAndFutureResponse request : inflightRequests) {
        request.appendResult.setException(t);
      }
    }

    // Disassemble the batched response and sets the furture on individual request.
    private void onSuccess(AppendRowsResponse response) {
      for (int i = 0; i < inflightRequests.size(); i++) {
        AppendRowsResponse.Builder singleResponse = response.toBuilder();
        // if (offsetList.get(i) > 0) {
        //   singleResponse.setOffset(offsetList.get(i));
        // } else {
        //   long actualOffset = response.getOffset();
        //   for (int j = 0; j < i; j++) {
        //     actualOffset +=
        //
        // inflightRequests.get(j).message.getProtoRows().getRows().getSerializedRowsCount();
        //   }
        //  singleResponse.setOffset(actualOffset);
        // }
        inflightRequests.get(i).appendResult.set(singleResponse.build());
      }
    }
  }

  // Class that wraps AppendRowsRequest and its cooresponding Response future.
  private static final class AppendRequestAndFutureResponse {
    final SettableApiFuture<AppendRowsResponse> appendResult;
    final AppendRowsRequest message;
    final int messageSize;

    AppendRequestAndFutureResponse(AppendRowsRequest message) {
      this.appendResult = SettableApiFuture.create();
      this.message = message;
      this.messageSize = message.getProtoRows().getSerializedSize();
      if (this.messageSize > getApiMaxRequestBytes()) {
        throw new StatusRuntimeException(
            Status.fromCode(Status.Code.FAILED_PRECONDITION)
                .withDescription("Message exceeded max size limit: " + getApiMaxRequestBytes()));
      }
    }
  }

  /** The batching settings configured on this {@code StreamWriter}. */
  public BatchingSettings getBatchingSettings() {
    return batchingSettings;
  }

  /** The retry settings configured on this {@code StreamWriter}. */
  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  /**
   * Schedules immediate flush of any outstanding messages and waits until all are processed.
   *
   * <p>Sends remaining outstanding messages and prevents future calls to publish. This method
   * should be invoked prior to deleting the {@link WriteStream} object in order to ensure that no
   * pending messages are lost.
   */
  protected void shutdown() {
    if (shutdown.getAndSet(true)) {
      LOG.fine("Already shutdown.");
      return;
    }
    LOG.fine("Shutdown called on writer");
    if (currentAlarmFuture != null && activeAlarm.getAndSet(false)) {
      currentAlarmFuture.cancel(false);
    }
    writeAllOutstanding();
    try {
      synchronized (messagesWaiter) {
        messagesWaiter.waitComplete(0);
      }
    } catch (InterruptedException e) {
      LOG.warning("Failed to wait for messages to return " + e.toString());
    }
    if (clientStream.isSendReady()) {
      clientStream.closeSend();
    }
    backgroundResources.shutdown();
  }

  /**
   * Wait for all work has completed execution after a {@link #shutdown()} request, or the timeout
   * occurs, or the current thread is interrupted.
   *
   * <p>Call this method to make sure all resources are freed properly.
   */
  protected boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return backgroundResources.awaitTermination(duration, unit);
  }

  /**
   * Constructs a new {@link Builder} using the given stream.
   *
   * <p>Example of creating a {@code WriteStream}.
   *
   * <pre>{@code
   * String table = "projects/my_project/datasets/my_dataset/tables/my_table";
   * String stream;
   * try (BigQueryWriteClient bigqueryWriteClient = BigQueryWriteClient.create()) {
   *     CreateWriteStreamRequest request = CreateWriteStreamRequest.newBuilder().setParent(table).build();
   *     WriteStream response = bigQueryWriteClient.createWriteStream(request);
   *     stream = response.getName();
   * }
   * try (WriteStream writer = WriteStream.newBuilder(stream).build()) {
   *   //...
   * }
   * }</pre>
   */
  public static Builder newBuilder(String streamName) {
    Preconditions.checkNotNull(streamName, "StreamName is null.");
    return new Builder(streamName, null);
  }

  /**
   * Constructs a new {@link Builder} using the given stream and an existing BigQueryWriteClient.
   */
  public static Builder newBuilder(String streamName, BigQueryWriteClient client) {
    Preconditions.checkNotNull(streamName, "StreamName is null.");
    Preconditions.checkNotNull(client, "Client is null.");
    return new Builder(streamName, client);
  }

  /** A builder of {@link StreamWriter}s. */
  public static final class Builder {
    static final Duration MIN_TOTAL_TIMEOUT = Duration.ofSeconds(10);
    static final Duration MIN_RPC_TIMEOUT = Duration.ofMillis(10);

    // Meaningful defaults.
    static final FlowControlSettings DEFAULT_FLOW_CONTROL_SETTINGS =
        FlowControlSettings.newBuilder()
            .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
            .setMaxOutstandingElementCount(1000L)
            .setMaxOutstandingRequestBytes(100 * 1024 * 1024L) // 100 Mb
            .build();
    public static final BatchingSettings DEFAULT_BATCHING_SETTINGS =
        BatchingSettings.newBuilder()
            .setDelayThreshold(Duration.ofMillis(10))
            .setRequestByteThreshold(100 * 1024L) // 100 kb
            .setElementCountThreshold(100L)
            .setFlowControlSettings(DEFAULT_FLOW_CONTROL_SETTINGS)
            .build();
    public static final RetrySettings DEFAULT_RETRY_SETTINGS =
        RetrySettings.newBuilder()
            .setMaxRetryDelay(Duration.ofSeconds(60))
            .setInitialRetryDelay(Duration.ofMillis(100))
            .setMaxAttempts(3)
            .build();
    static final boolean DEFAULT_ENABLE_MESSAGE_ORDERING = false;
    private static final int THREADS_PER_CPU = 5;
    static final ExecutorProvider DEFAULT_EXECUTOR_PROVIDER =
        InstantiatingExecutorProvider.newBuilder()
            .setExecutorThreadCount(THREADS_PER_CPU * Runtime.getRuntime().availableProcessors())
            .build();

    private String streamName;
    private String endpoint = BigQueryWriteSettings.getDefaultEndpoint();

    private BigQueryWriteClient client = null;

    // Batching options
    BatchingSettings batchingSettings = DEFAULT_BATCHING_SETTINGS;

    RetrySettings retrySettings = DEFAULT_RETRY_SETTINGS;

    private boolean enableMessageOrdering = DEFAULT_ENABLE_MESSAGE_ORDERING;

    private TransportChannelProvider channelProvider =
        BigQueryWriteSettings.defaultGrpcTransportProviderBuilder().setChannelsPerCpu(1).build();

    ExecutorProvider executorProvider = DEFAULT_EXECUTOR_PROVIDER;
    private CredentialsProvider credentialsProvider =
        BigQueryWriteSettings.defaultCredentialsProviderBuilder().build();

    private OnSchemaUpdateRunnable onSchemaUpdateRunnable;

    private Builder(String stream, BigQueryWriteClient client) {
      this.streamName = Preconditions.checkNotNull(stream);
      this.client = client;
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
     * Sets the {@code BatchSettings} on the writer.
     *
     * @param batchingSettings
     * @return
     */
    public Builder setBatchingSettings(BatchingSettings batchingSettings) {
      Preconditions.checkNotNull(batchingSettings, "BatchingSettings is null.");

      BatchingSettings.Builder builder = batchingSettings.toBuilder();
      Preconditions.checkNotNull(batchingSettings.getElementCountThreshold());
      Preconditions.checkArgument(batchingSettings.getElementCountThreshold() > 0);
      Preconditions.checkNotNull(batchingSettings.getRequestByteThreshold());
      Preconditions.checkArgument(batchingSettings.getRequestByteThreshold() > 0);
      if (batchingSettings.getRequestByteThreshold() > getApiMaxRequestBytes()) {
        builder.setRequestByteThreshold(getApiMaxRequestBytes());
      }
      Preconditions.checkNotNull(batchingSettings.getDelayThreshold());
      Preconditions.checkArgument(batchingSettings.getDelayThreshold().toMillis() > 0);
      if (batchingSettings.getFlowControlSettings() == null) {
        builder.setFlowControlSettings(DEFAULT_FLOW_CONTROL_SETTINGS);
      } else {

        if (batchingSettings.getFlowControlSettings().getMaxOutstandingElementCount() == null) {
          builder.setFlowControlSettings(
              batchingSettings
                  .getFlowControlSettings()
                  .toBuilder()
                  .setMaxOutstandingElementCount(
                      DEFAULT_FLOW_CONTROL_SETTINGS.getMaxOutstandingElementCount())
                  .build());
        } else {
          Preconditions.checkArgument(
              batchingSettings.getFlowControlSettings().getMaxOutstandingElementCount() > 0);
          if (batchingSettings.getFlowControlSettings().getMaxOutstandingElementCount()
              > getApiMaxInflightRequests()) {
            builder.setFlowControlSettings(
                batchingSettings
                    .getFlowControlSettings()
                    .toBuilder()
                    .setMaxOutstandingElementCount(getApiMaxInflightRequests())
                    .build());
          }
        }
        if (batchingSettings.getFlowControlSettings().getMaxOutstandingRequestBytes() == null) {
          builder.setFlowControlSettings(
              batchingSettings
                  .getFlowControlSettings()
                  .toBuilder()
                  .setMaxOutstandingRequestBytes(
                      DEFAULT_FLOW_CONTROL_SETTINGS.getMaxOutstandingRequestBytes())
                  .build());
        } else {
          Preconditions.checkArgument(
              batchingSettings.getFlowControlSettings().getMaxOutstandingRequestBytes() > 0);
        }
        if (batchingSettings.getFlowControlSettings().getLimitExceededBehavior() == null) {
          builder.setFlowControlSettings(
              batchingSettings
                  .getFlowControlSettings()
                  .toBuilder()
                  .setLimitExceededBehavior(
                      DEFAULT_FLOW_CONTROL_SETTINGS.getLimitExceededBehavior())
                  .build());
        } else {
          Preconditions.checkArgument(
              batchingSettings.getFlowControlSettings().getLimitExceededBehavior()
                  != FlowController.LimitExceededBehavior.Ignore);
        }
      }
      this.batchingSettings = builder.build();
      return this;
    }

    /**
     * Sets the {@code RetrySettings} on the writer.
     *
     * @param retrySettings
     * @return
     */
    public Builder setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = Preconditions.checkNotNull(retrySettings, "RetrySettings is null.");
      return this;
    }

    /** Gives the ability to set a custom executor to be used by the library. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider =
          Preconditions.checkNotNull(executorProvider, "ExecutorProvider is null.");
      return this;
    }

    /** Gives the ability to override the gRPC endpoint. */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = Preconditions.checkNotNull(endpoint, "Endpoint is null.");
      return this;
    }

    /** Gives the ability to set action on schema update. */
    public Builder setOnSchemaUpdateRunnable(OnSchemaUpdateRunnable onSchemaUpdateRunnable) {
      this.onSchemaUpdateRunnable =
          Preconditions.checkNotNull(onSchemaUpdateRunnable, "onSchemaUpdateRunnable is null.");
      return this;
    }

    /** Builds the {@code StreamWriter}. */
    public StreamWriter build() throws IllegalArgumentException, IOException, InterruptedException {
      return new StreamWriter(this);
    }
  }

  private static final class AppendResponseObserver
      implements ResponseObserver<AppendRowsResponse> {
    private Queue<InflightBatch> inflightBatches = new LinkedList<InflightBatch>();
    private StreamWriter streamWriter;

    public void addInflightBatch(InflightBatch batch) {
      synchronized (this.inflightBatches) {
        this.inflightBatches.add(batch);
      }
    }

    public AppendResponseObserver(StreamWriter streamWriter) {
      this.streamWriter = streamWriter;
    }

    private boolean isRecoverableError(Throwable t) {
      Status status = Status.fromThrowable(t);
      return status.getCode() == Status.Code.UNAVAILABLE;
    }

    @Override
    public void onStart(StreamController controller) {
      // no-op
    }

    private void abortInflightRequests(Throwable t) {
      synchronized (this.inflightBatches) {
        while (!this.inflightBatches.isEmpty()) {
          InflightBatch inflightBatch = this.inflightBatches.poll();
          inflightBatch.onFailure(
              new AbortedException(
                  "Request aborted due to previous failures",
                  t,
                  GrpcStatusCode.of(Status.Code.ABORTED),
                  true));
          streamWriter.messagesWaiter.release(inflightBatch.getByteSize());
        }
      }
    }

    @Override
    public void onResponse(AppendRowsResponse response) {
      InflightBatch inflightBatch = null;
      synchronized (this.inflightBatches) {
        inflightBatch = this.inflightBatches.poll();
      }
      try {
        streamWriter.currentRetries = 0;
        if (response == null) {
          inflightBatch.onFailure(new IllegalStateException("Response is null"));
        }
        if (response.hasUpdatedSchema()) {
          if (streamWriter.getOnSchemaUpdateRunnable() != null) {
            streamWriter.getOnSchemaUpdateRunnable().setUpdatedSchema(response.getUpdatedSchema());
            streamWriter.executor.schedule(
                streamWriter.getOnSchemaUpdateRunnable(), 0L, TimeUnit.MILLISECONDS);
          }
        }
        // Currently there is nothing retryable. If the error is already exists, then ignore it.
        if (response.hasError()) {
          if (response.getError().getCode() != 6 /* ALREADY_EXISTS */) {
            StatusRuntimeException exception =
                new StatusRuntimeException(
                    Status.fromCodeValue(response.getError().getCode())
                        .withDescription(response.getError().getMessage()));
            inflightBatch.onFailure(exception);
          }
        }
        // Temp for Breaking Change.
        // if (inflightBatch.getExpectedOffset() > 0
        //     && response.getOffset() != inflightBatch.getExpectedOffset()) {
        //   IllegalStateException exception =
        //      new IllegalStateException(
        //          String.format(
        //              "The append result offset %s does not match " + "the expected offset %s.",
        //              response.getOffset(), inflightBatch.getExpectedOffset()));
        //  inflightBatch.onFailure(exception);
        //  abortInflightRequests(exception);
        // } else {
        inflightBatch.onSuccess(response);
        // }
      } finally {
        streamWriter.messagesWaiter.release(inflightBatch.getByteSize());
      }
    }

    @Override
    public void onComplete() {
      LOG.info("OnComplete called");
    }

    @Override
    public void onError(Throwable t) {
      LOG.fine("OnError called");
      if (streamWriter.shutdown.get()) {
        return;
      }
      InflightBatch inflightBatch = null;
      synchronized (this.inflightBatches) {
        if (inflightBatches.isEmpty()) {
          // The batches could have been aborted.
          return;
        }
        inflightBatch = this.inflightBatches.poll();
      }
      try {
        if (isRecoverableError(t)) {
          try {
            if (streamWriter.currentRetries < streamWriter.getRetrySettings().getMaxAttempts()
                && !streamWriter.shutdown.get()) {
              streamWriter.refreshAppend();
              LOG.info("Resending requests on transient error:" + streamWriter.currentRetries);
              streamWriter.writeBatch(inflightBatch);
              synchronized (streamWriter.currentRetries) {
                streamWriter.currentRetries++;
              }
            } else {
              inflightBatch.onFailure(t);
              abortInflightRequests(t);
              synchronized (streamWriter.currentRetries) {
                streamWriter.currentRetries = 0;
              }
            }
          } catch (IOException | InterruptedException e) {
            LOG.info("Got exception while retrying.");
            inflightBatch.onFailure(e);
            abortInflightRequests(e);
            synchronized (streamWriter.currentRetries) {
              streamWriter.currentRetries = 0;
            }
          }
        } else {
          inflightBatch.onFailure(t);
          abortInflightRequests(t);
          synchronized (streamWriter.currentRetries) {
            streamWriter.currentRetries = 0;
          }
        }
      } finally {
        streamWriter.messagesWaiter.release(inflightBatch.getByteSize());
      }
    }
  };

  // This class controls how many messages are going to be sent out in a batch.
  private static class MessagesBatch {
    private List<AppendRequestAndFutureResponse> messages;
    private long batchedBytes;
    private final BatchingSettings batchingSettings;
    private Boolean attachSchema = true;
    private final String streamName;
    private final StreamWriter streamWriter;

    private MessagesBatch(
        BatchingSettings batchingSettings, String streamName, StreamWriter streamWriter) {
      this.batchingSettings = batchingSettings;
      this.streamName = streamName;
      this.streamWriter = streamWriter;
      reset();
    }

    // Get all the messages out in a batch.
    private InflightBatch popBatch() {
      InflightBatch batch =
          new InflightBatch(
              messages, batchedBytes, this.streamName, this.attachSchema, this.streamWriter);
      this.attachSchema = false;
      reset();
      return batch;
    }

    private void reset() {
      messages = new LinkedList<>();
      batchedBytes = 0;
    }

    private void resetAttachSchema() {
      attachSchema = true;
    }

    private boolean isEmpty() {
      return messages.isEmpty();
    }

    private long getBatchedBytes() {
      return batchedBytes;
    }

    private int getMessagesCount() {
      return messages.size();
    }

    private boolean hasBatchingBytes() {
      return getMaxBatchBytes() > 0;
    }

    private long getMaxBatchBytes() {
      return batchingSettings.getRequestByteThreshold();
    }

    // The message batch returned could contain the previous batch of messages plus the current
    // message.
    // if the message is too large.
    private List<InflightBatch> add(AppendRequestAndFutureResponse outstandingAppend) {
      List<InflightBatch> batchesToSend = new ArrayList<>();
      // Check if the next message makes the current batch exceed the max batch byte size.
      if (!isEmpty()
          && hasBatchingBytes()
          && getBatchedBytes() + outstandingAppend.messageSize >= getMaxBatchBytes()) {
        batchesToSend.add(popBatch());
      }

      messages.add(outstandingAppend);
      batchedBytes += outstandingAppend.messageSize;

      // Border case: If the message to send is greater or equals to the max batch size then send it
      // immediately.
      // Alternatively if after adding the message we have reached the batch max messages then we
      // have a batch to send.
      if ((hasBatchingBytes() && outstandingAppend.messageSize >= getMaxBatchBytes())
          || getMessagesCount() == batchingSettings.getElementCountThreshold()) {
        batchesToSend.add(popBatch());
      }

      return batchesToSend;
    }
  }
}
