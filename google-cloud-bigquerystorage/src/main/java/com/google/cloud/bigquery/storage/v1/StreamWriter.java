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
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auto.value.AutoOneOf;
import com.google.auto.value.AutoValue;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.MissingValueInterpretation;
import com.google.cloud.bigquery.storage.v1.ConnectionWorker.AppendRequestAndResponse;
import com.google.cloud.bigquery.storage.v1.ConnectionWorker.TableSchemaAndTimestamp;
import com.google.cloud.bigquery.storage.v1.StreamWriter.SingleConnectionOrConnectionPool.Kind;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>TODO: Support batching.
 */
public class StreamWriter implements AutoCloseable {
  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());

  private static String datasetsMatching = "projects/[^/]+/datasets/[^/]+/";
  private static Pattern streamPatternDatasets = Pattern.compile(datasetsMatching);

  private static String defaultStreamMatching = "/_default";
  private static Pattern streamPatternDefaultStream = Pattern.compile(defaultStreamMatching);

  // Cache of location info for a given dataset.
  private static Map<String, String> projectAndDatasetToLocation = new ConcurrentHashMap<>();

  // Map of fields to their MissingValueInterpretation, which dictates how a field should be
  // populated when it is missing from an input user row.
  private Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueInterpretationMap =
      new HashMap();

  /*
   * The identifier of stream to write to.
   */
  private final String streamName;

  /** Every writer has a fixed proto schema. */
  private final ProtoSchema writerSchema;

  /*
   * Location of the destination.
   */
  private final String location;

  /*
   * If user has closed the StreamWriter.
   */
  private AtomicBoolean userClosed = new AtomicBoolean(false);

  /*
   * A String that uniquely identifies this writer.
   */
  private final String writerId = UUID.randomUUID().toString();

  /**
   * The default missing value interpretation if the column has default value defined but not
   * presented in the missing value map.
   */
  private AppendRowsRequest.MissingValueInterpretation defaultMissingValueInterpretation =
      MissingValueInterpretation.MISSING_VALUE_INTERPRETATION_UNSPECIFIED;

  /**
   * Stream can access a single connection or a pool of connection depending on whether multiplexing
   * is enabled.
   */
  private final SingleConnectionOrConnectionPool singleConnectionOrConnectionPool;

  /** Test only param to tell how many times a client is created. */
  private static int testOnlyClientCreatedTimes = 0;

  /**
   * Static map from {@link ConnectionPoolKey} to connection pool. Note this map is static to be
   * shared by every stream writer in the same process.
   */
  private static final Map<ConnectionPoolKey, ConnectionWorkerPool> connectionPoolMap =
      new ConcurrentHashMap<>();

  /** Creation timestamp of this streamwriter */
  private final long creationTimestamp;

  private Lock lock;

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  /**
   * Connection pool with different key will be split.
   *
   * <p>Shard based only on location right now.
   */
  @AutoValue
  abstract static class ConnectionPoolKey {
    abstract String location();

    abstract int credentialsHashcode();

    public static ConnectionPoolKey create(String location, @Nullable Credentials credentials) {
      return new AutoValue_StreamWriter_ConnectionPoolKey(
          location, credentials != null ? credentials.hashCode() : 0);
    }
  }

  /**
   * When in single table mode, append directly to connectionWorker. Otherwise append to connection
   * pool in multiplexing mode.
   */
  @AutoOneOf(SingleConnectionOrConnectionPool.Kind.class)
  public abstract static class SingleConnectionOrConnectionPool {
    /** Kind of connection operation mode. */
    public enum Kind {
      CONNECTION_WORKER,
      CONNECTION_WORKER_POOL
    }

    public abstract Kind getKind();

    public abstract ConnectionWorker connectionWorker();

    public abstract ConnectionWorkerPool connectionWorkerPool();

    public ApiFuture<AppendRowsResponse> append(
        StreamWriter streamWriter, ProtoRows protoRows, long offset) {
      if (getKind() == Kind.CONNECTION_WORKER) {
        return connectionWorker().append(streamWriter, protoRows, offset);
      } else {
        return connectionWorkerPool().append(streamWriter, protoRows, offset);
      }
    }

    public void close(StreamWriter streamWriter) {
      if (getKind() == Kind.CONNECTION_WORKER) {
        connectionWorker().close();
      } else {
        connectionWorkerPool().close(streamWriter);
      }
    }

    long getInflightWaitSeconds(StreamWriter streamWriter) {
      if (getKind() == Kind.CONNECTION_WORKER_POOL) {
        return connectionWorkerPool().getInflightWaitSeconds(streamWriter);
      }
      return connectionWorker().getInflightWaitSeconds();
    }

    TableSchemaAndTimestamp getUpdatedSchema(StreamWriter streamWriter) {
      if (getKind() == Kind.CONNECTION_WORKER_POOL) {
        return connectionWorkerPool().getUpdatedSchema(streamWriter);
      }
      // Always populate MIN timestamp to w
      return connectionWorker().getUpdatedSchema();
    }

    String getWriterId(String streamWriterId) {
      if (getKind() == Kind.CONNECTION_WORKER_POOL) {
        return streamWriterId;
      }
      return connectionWorker().getWriterId();
    }

    public static SingleConnectionOrConnectionPool ofSingleConnection(ConnectionWorker connection) {
      return AutoOneOf_StreamWriter_SingleConnectionOrConnectionPool.connectionWorker(connection);
    }

    public static SingleConnectionOrConnectionPool ofConnectionPool(
        ConnectionWorkerPool connectionPool) {
      return AutoOneOf_StreamWriter_SingleConnectionOrConnectionPool.connectionWorkerPool(
          connectionPool);
    }
  }

  private StreamWriter(Builder builder) throws IOException {
    this.streamName = builder.streamName;
    this.writerSchema = builder.writerSchema;
    this.defaultMissingValueInterpretation = builder.defaultMissingValueInterpretation;
    BigQueryWriteSettings clientSettings = getBigQueryWriteSettings(builder);
    if (!builder.enableConnectionPool) {
      this.location = builder.location;
      this.singleConnectionOrConnectionPool =
          SingleConnectionOrConnectionPool.ofSingleConnection(
              new ConnectionWorker(
                  builder.streamName,
                  builder.location,
                  builder.writerSchema,
                  builder.maxInflightRequest,
                  builder.maxInflightBytes,
                  builder.maxRetryDuration,
                  builder.limitExceededBehavior,
                  builder.getFullTraceId(),
                  builder.compressorName,
                  clientSettings,
                  builder.retrySettings));
    } else {
      if (!isDefaultStream(streamName)) {
        log.warning(
            "Connection pool is only allowed in default stream! However received "
                + builder.streamName);
        throw new IllegalArgumentException(
            "Trying to enable connection pool in non-default stream.");
      }

      // We need a client to perform some getWriteStream calls.
      BigQueryWriteClient client =
          builder.client != null ? builder.client : new BigQueryWriteClient(clientSettings);
      String location = builder.location;
      if (location == null || location.isEmpty()) {
        // Location is not passed in, try to fetch from RPC
        String datasetAndProjectName = extractDatasetAndProjectName(builder.streamName);
        location =
            projectAndDatasetToLocation.computeIfAbsent(
                datasetAndProjectName,
                (key) -> {
                  GetWriteStreamRequest writeStreamRequest =
                      GetWriteStreamRequest.newBuilder()
                          .setName(this.getStreamName())
                          .setView(WriteStreamView.BASIC)
                          .build();

                  WriteStream writeStream = client.getWriteStream(writeStreamRequest);
                  TableSchema writeStreamTableSchema = writeStream.getTableSchema();
                  String fetchedLocation = writeStream.getLocation();
                  log.info(
                      String.format(
                          "Fethed location %s for stream name %s, extracted project and dataset"
                              + " name: %s\"",
                          fetchedLocation, streamName, datasetAndProjectName));
                  return fetchedLocation;
                });
        if (location.isEmpty()) {
          throw new IllegalStateException(
              String.format(
                  "The location is empty for both user passed in value and looked up value for "
                      + "stream: %s, extracted project and dataset name: %s",
                  streamName, datasetAndProjectName));
        }
      }
      this.location = location;
      CredentialsProvider credentialsProvider = client.getSettings().getCredentialsProvider();
      // Assume the connection in the same pool share the same client and trace id.
      // The first StreamWriter for a new stub will create the pool for the other
      // streams in the same region, meaning the per StreamWriter settings are no
      // longer working unless all streams share the same set of settings
      this.singleConnectionOrConnectionPool =
          SingleConnectionOrConnectionPool.ofConnectionPool(
              connectionPoolMap.computeIfAbsent(
                  ConnectionPoolKey.create(
                      location,
                      credentialsProvider != null ? credentialsProvider.getCredentials() : null),
                  (key) -> {
                    return new ConnectionWorkerPool(
                        builder.maxInflightRequest,
                        builder.maxInflightBytes,
                        builder.maxRetryDuration,
                        builder.limitExceededBehavior,
                        builder.getFullTraceId(),
                        builder.compressorName,
                        client.getSettings(),
                        builder.retrySettings);
                  }));
      validateFetchedConnectonPool(builder);
      // If the client is not from outside, then shutdown the client we created.
      if (builder.client == null) {
        client.shutdown();
        try {
          client.awaitTermination(150, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
          // Ignore interruption as this client is not used.
        }
        client.close();
      }
    }
    this.creationTimestamp = System.nanoTime();
  }

  @VisibleForTesting
  static String extractDatasetAndProjectName(String streamName) {
    Matcher streamMatcher = streamPatternDatasets.matcher(streamName);
    if (streamMatcher.find()) {
      return streamMatcher.group();
    } else {
      throw new IllegalStateException(
          String.format("The passed in stream name does not match standard format %s", streamName));
    }
  }

  @VisibleForTesting
  static boolean isDefaultStream(String streamName) {
    Matcher streamMatcher = streamPatternDefaultStream.matcher(streamName);
    return streamMatcher.find();
  }

  AppendRowsRequest.MissingValueInterpretation getDefaultValueInterpretation() {
    return defaultMissingValueInterpretation;
  }

  static BigQueryWriteSettings getBigQueryWriteSettings(Builder builder) throws IOException {
    BigQueryWriteSettings.Builder settingsBuilder = null;
    if (builder.client != null) {
      settingsBuilder = builder.client.getSettings().toBuilder();
    } else {
      settingsBuilder =
          new BigQueryWriteSettings.Builder()
              .setTransportChannelProvider(
                  BigQueryWriteSettings.defaultGrpcTransportProviderBuilder()
                      .setKeepAliveTime(org.threeten.bp.Duration.ofMinutes(1))
                      .setKeepAliveTimeout(org.threeten.bp.Duration.ofMinutes(1))
                      .setKeepAliveWithoutCalls(true)
                      .setChannelsPerCpu(2)
                      .build())
              .setCredentialsProvider(
                  BigQueryWriteSettings.defaultCredentialsProviderBuilder().build())
              .setBackgroundExecutorProvider(
                  BigQueryWriteSettings.defaultExecutorProviderBuilder().build())
              .setEndpoint(BigQueryWriteSettings.getDefaultEndpoint());
    }
    if (builder.channelProvider != null) {
      settingsBuilder.setTransportChannelProvider(builder.channelProvider);
    }
    if (builder.credentialsProvider != null) {
      settingsBuilder.setCredentialsProvider(builder.credentialsProvider);
    }
    if (builder.executorProvider != null) {
      settingsBuilder.setBackgroundExecutorProvider(builder.executorProvider);
    }
    if (builder.endpoint != null) {
      settingsBuilder.setEndpoint(builder.endpoint);
    }

    return settingsBuilder.build();
  }

  // Validate whether the fetched connection pool matched certain properties.
  private void validateFetchedConnectonPool(StreamWriter.Builder builder) {
    String storedTraceId =
        this.singleConnectionOrConnectionPool.connectionWorkerPool().getTraceId();
    if (!Objects.equals(storedTraceId, builder.getFullTraceId())) {
      throw new IllegalArgumentException(
          String.format(
              "Trace id used for the same connection pool for the same location must be the same, "
                  + "however stored trace id is %s, and expected trace id is %s.",
              storedTraceId, builder.getFullTraceId()));
    }
    FlowController.LimitExceededBehavior storedLimitExceededBehavior =
        singleConnectionOrConnectionPool.connectionWorkerPool().limitExceededBehavior();
    if (!Objects.equals(storedLimitExceededBehavior, builder.limitExceededBehavior)) {
      throw new IllegalArgumentException(
          String.format(
              "Limit exceeded behavior setting used for the same connection pool for the same "
                  + "location must be the same, however stored value is %s, and expected "
                  + "value is %s.",
              storedLimitExceededBehavior, builder.limitExceededBehavior));
    }
  }

  /**
   * Sets the missing value interpretation map for the stream writer. The input
   * missingValueInterpretationMap is used for all write requests unless otherwise changed.
   *
   * @param missingValueInterpretationMap the missing value interpretation map used by stream
   *     writer.
   */
  public void setMissingValueInterpretationMap(
      Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueInterpretationMap) {
    this.missingValueInterpretationMap = missingValueInterpretationMap;
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
    if (userClosed.get()) {
      AppendRequestAndResponse requestWrapper =
          new AppendRequestAndResponse(AppendRowsRequest.newBuilder().build(), this, null);
      requestWrapper.appendResult.setException(
          new Exceptions.StreamWriterClosedException(
              Status.fromCode(Status.Code.FAILED_PRECONDITION)
                  .withDescription("User closed StreamWriter"),
              streamName,
              getWriterId()));
      return requestWrapper.appendResult;
    }
    return this.singleConnectionOrConnectionPool.append(this, rows, offset);
  }

  /**
   * Returns the wait of a request in Client side before sending to the Server. Request could wait
   * in Client because it reached the client side inflight request limit (adjustable when
   * constructing the StreamWriter). The value is the wait time for the last sent request. A
   * constant high wait value indicates a need for more throughput, you can create a new Stream for
   * to increase the throughput in exclusive stream case, or create a new Writer in the default
   * stream case.
   */
  public long getInflightWaitSeconds() {
    return singleConnectionOrConnectionPool.getInflightWaitSeconds(this);
  }

  /** @return a unique Id for the writer. */
  public String getWriterId() {
    return singleConnectionOrConnectionPool.getWriterId(writerId);
  }

  /** @return name of the Stream that this writer is working on. */
  public String getStreamName() {
    return streamName;
  }

  /** @return the passed in user schema. */
  public ProtoSchema getProtoSchema() {
    return writerSchema;
  }

  /** @return the location of the destination. */
  public String getLocation() {
    return location;
  }

  /** @return the missing value interpretation map used for the writer. */
  public Map<String, AppendRowsRequest.MissingValueInterpretation>
      getMissingValueInterpretationMap() {
    return missingValueInterpretationMap;
  }

  /**
   * @return if a stream writer can no longer be used for writing. It is due to either the
   *     StreamWriter is explicitly closed or the underlying connection is broken when connection
   *     pool is not used. Client should recreate StreamWriter in this case.
   */
  public boolean isClosed() {
    if (singleConnectionOrConnectionPool.getKind() == Kind.CONNECTION_WORKER) {
      return userClosed.get()
          || singleConnectionOrConnectionPool.connectionWorker().isConnectionInUnrecoverableState();
    } else {
      // With ConnectionPool, we will replace the bad connection automatically.
      return userClosed.get();
    }
  }

  /** @return if user explicitly closed the writer. */
  public boolean isUserClosed() {
    return userClosed.get();
  }

  /** Close the stream writer. Shut down all resources. */
  @Override
  public void close() {
    userClosed.set(true);
    singleConnectionOrConnectionPool.close(this);
  }

  /** Constructs a new {@link StreamWriter.Builder} using the given stream and client. */
  public static StreamWriter.Builder newBuilder(String streamName, BigQueryWriteClient client) {
    return new StreamWriter.Builder(streamName, client);
  }

  /** Constructs a new {@link StreamWriter.Builder} using the given stream. */
  public static StreamWriter.Builder newBuilder(String streamName) {
    return new StreamWriter.Builder(streamName);
  }

  /**
   * Thread-safe getter of updated TableSchema.
   *
   * <p>This will return the updated schema only when the creation timestamp of this writer is older
   * than the updated schema.
   */
  public synchronized TableSchema getUpdatedSchema() {
    TableSchemaAndTimestamp tableSchemaAndTimestamp =
        singleConnectionOrConnectionPool.getUpdatedSchema(this);
    if (tableSchemaAndTimestamp == null) {
      return null;
    }
    return creationTimestamp < tableSchemaAndTimestamp.updateTimeStamp()
        ? tableSchemaAndTimestamp.updatedSchema()
        : null;
  }

  /**
   * Sets the maximum time a request is allowed to be waiting in request waiting queue. Under very
   * low chance, it's possible for append request to be waiting indefintely for request callback
   * when Google networking SDK does not detect the networking breakage. The default timeout is 15
   * minutes. We are investigating the root cause for callback not triggered by networking SDK.
   */
  public static void setMaxRequestCallbackWaitTime(Duration waitTime) {
    ConnectionWorker.MAXIMUM_REQUEST_CALLBACK_WAIT_TIME = waitTime;
  }

  long getCreationTimestamp() {
    return creationTimestamp;
  }

  @VisibleForTesting
  SingleConnectionOrConnectionPool.Kind getConnectionOperationType() {
    return singleConnectionOrConnectionPool.getKind();
  }

  @VisibleForTesting
  static int getTestOnlyClientCreatedTimes() {
    return testOnlyClientCreatedTimes;
  }

  @VisibleForTesting
  static void cleanUp() {
    testOnlyClientCreatedTimes = 0;
    connectionPoolMap.clear();
  }

  @VisibleForTesting
  ConnectionWorkerPool getTestOnlyConnectionWorkerPool() {
    ConnectionWorkerPool connectionWorkerPool = null;
    for (Entry<ConnectionPoolKey, ConnectionWorkerPool> entry : connectionPoolMap.entrySet()) {
      connectionWorkerPool = entry.getValue();
    }
    return connectionWorkerPool;
  }

  @VisibleForTesting
  Map<ConnectionPoolKey, ConnectionWorkerPool> getTestOnlyConnectionPoolMap() {
    return connectionPoolMap;
  }

  // A method to clear the static connectio pool to avoid making pool visible to other tests.
  @VisibleForTesting
  static void clearConnectionPool() {
    connectionPoolMap.clear();
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

    private String endpoint = null;

    private TransportChannelProvider channelProvider = null;

    private CredentialsProvider credentialsProvider = null;

    private ExecutorProvider executorProvider = null;

    private FlowController.LimitExceededBehavior limitExceededBehavior =
        FlowController.LimitExceededBehavior.Block;

    private String traceId = null;

    private String clientId = "java-streamwriter";

    private TableSchema updatedTableSchema = null;

    private String location = null;

    private boolean enableConnectionPool = false;

    private java.time.Duration maxRetryDuration = Duration.ofMinutes(5);

    private String compressorName = null;

    // Default missing value interpretation value.
    private AppendRowsRequest.MissingValueInterpretation defaultMissingValueInterpretation =
        MissingValueInterpretation.MISSING_VALUE_INTERPRETATION_UNSPECIFIED;

    private RetrySettings retrySettings = null;

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
     * Enable multiplexing for this writer. In multiplexing mode tables will share the same
     * connection if possible until the connection is overwhelmed.
     *
     * @param enableConnectionPool
     * @return Builder
     */
    public Builder setEnableConnectionPool(boolean enableConnectionPool) {
      this.enableConnectionPool = enableConnectionPool;
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

    /** {@code ExecutorProvider} to use to create Executor to run background jobs. */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider =
          Preconditions.checkNotNull(executorProvider, "ExecutorProvider is null.");
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

    /**
     * Sets the client id of the writer, for example, JsonStreamWriter has the client id of
     * "java-jsonwriter".
     */
    Builder setClientId(String clientId) {
      this.clientId = clientId;
      return this;
    }

    /** Location of the table this stream writer is targeting. */
    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    /**
     * Sets the limit exceeded behavior.
     *
     * @param limitExceededBehavior
     * @return
     */
    public Builder setLimitExceededBehavior(
        FlowController.LimitExceededBehavior limitExceededBehavior) throws StatusRuntimeException {
      if (limitExceededBehavior == FlowController.LimitExceededBehavior.Ignore) {
        throw new StatusRuntimeException(
            Status.fromCode(Code.INVALID_ARGUMENT)
                .withDescription("LimitExceededBehavior.Ignore is not supported on StreamWriter."));
      }
      this.limitExceededBehavior = limitExceededBehavior;
      return this;
    }

    /*
     * Max duration to retry on retryable errors. Default is 5 minutes. You can allow unlimited
     * retry by setting the value to be 0.
     */
    public Builder setMaxRetryDuration(java.time.Duration maxRetryDuration) {
      this.maxRetryDuration = maxRetryDuration;
      return this;
    }

    public Builder setCompressorName(String compressorName) {
      Preconditions.checkNotNull(compressorName);
      Preconditions.checkArgument(
          compressorName.equals("gzip"),
          "Compression of type \"%s\" isn't supported, only \"gzip\" compression is supported.",
          compressorName);
      this.compressorName = compressorName;
      return this;
    }

    /**
     * Sets the default missing value interpretation value if the column is not presented in the
     * missing_value_interpretations map.
     */
    public Builder setDefaultMissingValueInterpretation(
        AppendRowsRequest.MissingValueInterpretation defaultMissingValueInterpretation) {
      this.defaultMissingValueInterpretation = defaultMissingValueInterpretation;
      return this;
    }

    /**
     * Enable client lib automatic retries on request level errors.
     *
     * <pre>
     * Immeidate Retry code:
     * ABORTED, UNAVAILABLE, CANCELLED, INTERNAL, DEADLINE_EXCEEDED
     * Backoff Retry code:
     * RESOURCE_EXHAUSTED
     *
     * Example:
     * RetrySettings retrySettings = RetrySettings.newBuilder()
     *      .setInitialRetryDelay(Duration.ofMillis(500)) // applies to backoff retry
     *      .setRetryDelayMultiplier(1.1) // applies to backoff retry
     *      .setMaxAttempts(5) // applies to both retries
     *      .setMaxRetryDelay(Duration.ofMinutes(1)) // applies to backoff retry .build();
     * </pre>
     *
     * @param retrySettings
     * @return
     */
    public Builder setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      return this;
    }

    /** Builds the {@code StreamWriterV2}. */
    public StreamWriter build() throws IOException {
      return new StreamWriter(this);
    }

    String getFullTraceId() {
      String clientWithVersion =
          GaxProperties.getLibraryVersion(StreamWriter.class).isEmpty()
              ? clientId
              : clientId + ":" + GaxProperties.getLibraryVersion(StreamWriter.class);
      if (traceId == null || traceId.isEmpty()) {
        return clientWithVersion;
      } else {
        return clientWithVersion + " " + traceId;
      }
    }
  }
}
