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
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigquery.storage.v1.AppendRowsRequest.MissingValueInterpretation;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializationError;
import com.google.cloud.bigquery.storage.v1.Exceptions.RowIndexToErrorException;
import com.google.common.base.Preconditions;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.DynamicMessage;
import com.google.rpc.Code;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * A StreamWriter that can write data to BigQuery tables. The SchemaAwareStreamWriter is built on
 * top of a StreamWriter, and it converts all data to Protobuf messages using provided converter
 * then calls StreamWriter's append() method to write to BigQuery tables. It maintains all
 * StreamWriter functions, but also provides an additional feature: schema update support, where if
 * the BigQuery table schema is updated, users will be able to ingest data on the new schema after
 * some time (in order of minutes).
 *
 * <p>NOTE: The schema update ability will be disabled when you pass in a table schema explicitly
 * through the writer. It is recommended that user either use JsonStreamWriter (which fully manages
 * table schema) or StreamWriter (which accepts proto format in raw and user will handle the schema
 * update event themsevles). If you use this class, you need to be very cautious about possible
 * mistmach between the writer's schema and the input data, any mismatch of the two will cause data
 * corruption.
 */
public class SchemaAwareStreamWriter<T> implements AutoCloseable {
  private static final Logger LOG = Logger.getLogger(SchemaAwareStreamWriter.class.getName());
  private final BigQueryWriteClient client;
  private final String streamName;
  private final StreamWriter.Builder streamWriterBuilder;
  private final boolean ignoreUnknownFields;
  private final ToProtoConverter<T> toProtoConverter;
  private StreamWriter streamWriter;
  private Descriptor descriptor;
  private TableSchema tableSchema;
  private ProtoSchema protoSchema;
  private String CompressorName;

  // During some sitaution we want to skip stream writer refresh for updated schema. e.g. when
  // the user provides the table schema, we should always use that schema.
  private final boolean skipRefreshStreamWriter;

  /**
   * Constructs the SchemaAwareStreamWriter
   *
   * @param builder The Builder object for the SchemaAwareStreamWriter
   */
  private SchemaAwareStreamWriter(Builder<T> builder)
      throws DescriptorValidationException, IllegalArgumentException, IOException {
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(builder.tableSchema);

    if (builder.client == null) {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName);
    } else {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName, builder.client);
    }
    this.protoSchema = ProtoSchemaConverter.convert(this.descriptor);
    this.client = builder.client;
    streamWriterBuilder.setWriterSchema(protoSchema);
    setStreamWriterSettings(
        builder.channelProvider,
        builder.credentialsProvider,
        builder.executorProvider,
        builder.endpoint,
        builder.flowControlSettings,
        builder.traceId,
        builder.compressorName,
        builder.retrySettings);
    streamWriterBuilder.setEnableConnectionPool(builder.enableConnectionPool);
    streamWriterBuilder.setLocation(builder.location);
    streamWriterBuilder.setDefaultMissingValueInterpretation(
        builder.defaultMissingValueInterpretation);
    streamWriterBuilder.setClientId(builder.clientId);
    this.streamWriter = streamWriterBuilder.build();
    this.streamName = builder.streamName;
    this.tableSchema = builder.tableSchema;
    this.toProtoConverter = builder.toProtoConverter;
    this.ignoreUnknownFields = builder.ignoreUnknownFields;
    this.skipRefreshStreamWriter = builder.skipRefreshStreamWriter;
  }

  /**
   * Writes a collection that contains objects to the BigQuery table by first converting the data to
   * Protobuf messages, then using StreamWriter's append() to write the data at current end of
   * stream. If there is a schema update, the current StreamWriter is closed. A new StreamWriter is
   * created with the updated TableSchema.
   *
   * @param items The array that contains objects to be written
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(Iterable<T> items)
      throws IOException, DescriptorValidationException {
    return append(items, -1);
  }

  private void refreshWriter(TableSchema updatedSchema)
      throws DescriptorValidationException, IOException {
    Preconditions.checkNotNull(updatedSchema, "updatedSchema is null.");
    LOG.info("Refresh internal writer due to schema update, stream: " + this.streamName);
    // Close the StreamWriterf
    this.streamWriter.close();
    // Update SchemaAwareStreamWriter's TableSchema and Descriptor
    this.tableSchema = updatedSchema;
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(updatedSchema);
    this.protoSchema = ProtoSchemaConverter.convert(this.descriptor);
    // Create a new underlying StreamWriter with the updated TableSchema and Descriptor
    this.streamWriter = streamWriterBuilder.setWriterSchema(this.protoSchema).build();
  }

  private List<DynamicMessage> buildMessage(Iterable<T> items)
      throws InterruptedException, DescriptorValidationException, IOException {
    try {
      return this.toProtoConverter.convertToProtoMessage(
          this.descriptor, this.tableSchema, items, ignoreUnknownFields);
    } catch (RowIndexToErrorException ex) {
      // We only retry for data unknown error.
      if (!ex.hasDataUnknownError) {
        throw ex;
      }
      // Directly return error when stream writer refresh is disabled.
      if (this.skipRefreshStreamWriter) {
        throw ex;
      }
      LOG.warning(
          "Saw unknown field error during proto message conversin within error messages"
              + ex.rowIndexToErrorMessage
              + ", try to refresh the writer with updated schema, stream: "
              + streamName);
      GetWriteStreamRequest writeStreamRequest =
          GetWriteStreamRequest.newBuilder()
              .setName(this.streamName)
              .setView(WriteStreamView.FULL)
              .build();
      WriteStream writeStream = client.getWriteStream(writeStreamRequest);
      refreshWriter(writeStream.getTableSchema());
      return this.toProtoConverter.convertToProtoMessage(
          this.descriptor, this.tableSchema, items, ignoreUnknownFields);
    }
  }
  /**
   * Writes a collection that contains objects to the BigQuery table by first converting the data to
   * Protobuf messages, then using StreamWriter's append() to write the data at the specified
   * offset. If there is a schema update, the current StreamWriter is closed. A new StreamWriter is
   * created with the updated TableSchema.
   *
   * @param items The collection that contains objects to be written
   * @param offset Offset for deduplication
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(Iterable<T> items, long offset)
      throws IOException, DescriptorValidationException {
    // Handle schema updates in a Thread-safe way by locking down the operation
    synchronized (this) {
      // Create a new stream writer internally if a new updated schema is reported from backend.
      if (!this.skipRefreshStreamWriter && this.streamWriter.getUpdatedSchema() != null) {
        refreshWriter(this.streamWriter.getUpdatedSchema());
      }
      ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
      // Any error in convertToProtoMessage will throw an
      // IllegalArgumentException/IllegalStateException/NullPointerException.
      // IllegalArgumentException will be collected into a Map of row indexes to error messages.
      // After the conversion is finished an AppendSerializtionError exception that contains all the
      // conversion errors will be thrown.
      Map<Integer, String> rowIndexToErrorMessage = new HashMap<>();
      try {
        List<DynamicMessage> protoMessages = buildMessage(items);
        for (DynamicMessage dynamicMessage : protoMessages) {
          rowsBuilder.addSerializedRows(dynamicMessage.toByteString());
        }
      } catch (RowIndexToErrorException exception) {
        rowIndexToErrorMessage = exception.rowIndexToErrorMessage;
      } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
      }

      if (!rowIndexToErrorMessage.isEmpty()) {
        throw new AppendSerializationError(
            Code.INVALID_ARGUMENT.getNumber(),
            "Append serialization failed for writer: " + streamName,
            streamName,
            rowIndexToErrorMessage);
      }
      return this.streamWriter.append(rowsBuilder.build(), offset);
    }
  }

  /** @return The name of the write stream associated with this writer. */
  public String getStreamName() {
    return this.streamName;
  }

  /** @return A unique Id for this writer. */
  public String getWriterId() {
    return streamWriter.getWriterId();
  }

  /**
   * Gets current descriptor
   *
   * @return Descriptor
   */
  public Descriptor getDescriptor() {
    return this.descriptor;
  }

  /**
   * Gets the location of the destination
   *
   * @return Descriptor
   */
  public String getLocation() {
    return this.streamWriter.getLocation();
  }

  /**
   * Returns the wait of a request in Client side before sending to the Server. Request could wait
   * in Client because it reached the client side inflight request limit (adjustable when
   * constructing the Writer). The value is the wait time for the last sent request. A constant high
   * wait value indicates a need for more throughput, you can create a new Stream for to increase
   * the throughput in exclusive stream case, or create a new Writer in the default stream case.
   */
  public long getInflightWaitSeconds() {
    return streamWriter.getInflightWaitSeconds();
  }

  /**
   * Sets the missing value interpretation map for the SchemaAwareStreamWriter. The input
   * missingValueInterpretationMap is used for all append requests unless otherwise changed.
   *
   * @param missingValueInterpretationMap the missing value interpretation map used by the
   *     SchemaAwareStreamWriter.
   */
  public void setMissingValueInterpretationMap(
      Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueInterpretationMap) {
    streamWriter.setMissingValueInterpretationMap(missingValueInterpretationMap);
  }

  /** @return the missing value interpretation map used for the writer. */
  public Map<String, AppendRowsRequest.MissingValueInterpretation>
      getMissingValueInterpretationMap() {
    return streamWriter.getMissingValueInterpretationMap();
  }

  /** Sets all StreamWriter settings. */
  private void setStreamWriterSettings(
      @Nullable TransportChannelProvider channelProvider,
      @Nullable CredentialsProvider credentialsProvider,
      @Nullable ExecutorProvider executorProvider,
      @Nullable String endpoint,
      @Nullable FlowControlSettings flowControlSettings,
      @Nullable String traceId,
      @Nullable String compressorName,
      @Nullable RetrySettings retrySettings) {
    if (channelProvider != null) {
      streamWriterBuilder.setChannelProvider(channelProvider);
    }
    if (credentialsProvider != null) {
      streamWriterBuilder.setCredentialsProvider(credentialsProvider);
    }
    if (executorProvider != null) {
      streamWriterBuilder.setExecutorProvider(executorProvider);
    }
    if (endpoint != null) {
      streamWriterBuilder.setEndpoint(endpoint);
    }
    if (traceId != null) {
      streamWriterBuilder.setTraceId(traceId);
    }
    if (flowControlSettings != null) {
      if (flowControlSettings.getMaxOutstandingRequestBytes() != null) {
        streamWriterBuilder.setMaxInflightBytes(
            flowControlSettings.getMaxOutstandingRequestBytes());
      }
      if (flowControlSettings.getMaxOutstandingElementCount() != null) {
        streamWriterBuilder.setMaxInflightRequests(
            flowControlSettings.getMaxOutstandingElementCount());
      }
      if (flowControlSettings.getLimitExceededBehavior() != null) {
        streamWriterBuilder.setLimitExceededBehavior(
            flowControlSettings.getLimitExceededBehavior());
      }
    }
    if (compressorName != null) {
      streamWriterBuilder.setCompressorName(compressorName);
    }
    if (retrySettings != null) {
      streamWriterBuilder.setRetrySettings(retrySettings);
    }
  }

  /**
   * newBuilder that constructs a SchemaAwareStreamWriter builder with BigQuery client being
   * initialized by StreamWriter by default.
   *
   * <p>The table schema passed in will be updated automatically when there is a schema update
   * event. When used for Writer creation, it should be the latest schema. So when you are trying to
   * reuse a stream, you should use Builder newBuilder( String streamOrTableName,
   * BigQueryWriteClient client) instead, so the created Writer will be based on a fresh schema.
   *
   * @param streamOrTableName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+" or table name
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+"
   * @param tableSchema The schema of the table when the stream was created, which is passed back
   *     through {@code WriteStream}
   * @return Builder
   */
  public static <T> Builder<T> newBuilder(
      String streamOrTableName, TableSchema tableSchema, ToProtoConverter<T> toProtoConverter) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkNotNull(toProtoConverter, "ToProtoConverter is null.");
    return new Builder<>(streamOrTableName, tableSchema, null, toProtoConverter);
  }

  /**
   * newBuilder that constructs a SchemaAwareStreamWriter builder.
   *
   * <p>The table schema passed in will be updated automatically when there is a schema update
   * event. When used for Writer creation, it should be the latest schema. So when you are trying to
   * reuse a stream, you should use Builder newBuilder( String streamOrTableName,
   * BigQueryWriteClient client) instead, so the created Writer will be based on a fresh schema.
   *
   * @param streamOrTableName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param tableSchema The schema of the table when the stream was created, which is passed back
   *     through {@code WriteStream}
   * @param client
   * @return Builder
   */
  public static <T> Builder<T> newBuilder(
      String streamOrTableName,
      TableSchema tableSchema,
      BigQueryWriteClient client,
      ToProtoConverter<T> toProtoConverter) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    Preconditions.checkNotNull(toProtoConverter, "ToProtoConverter is null.");
    return new Builder<>(streamOrTableName, tableSchema, client, toProtoConverter);
  }

  /**
   * newBuilder that constructs a SchemaAwareStreamWriter builder with TableSchema being initialized
   * by StreamWriter by default.
   *
   * @param streamOrTableName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param client BigQueryWriteClient
   * @return Builder
   */
  public static <T> Builder<T> newBuilder(
      String streamOrTableName, BigQueryWriteClient client, ToProtoConverter<T> toProtoConverter) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    Preconditions.checkNotNull(toProtoConverter, "ToProtoConverter is null.");
    return new Builder<>(streamOrTableName, null, client, toProtoConverter);
  }

  /** Closes the underlying StreamWriter. */
  @Override
  public void close() {
    this.streamWriter.close();
  }

  /**
   * @return if a writer can no longer be used for writing. It is due to either the
   *     SchemaAwareStreamWriter is explicitly closed or the underlying connection is broken when
   *     connection pool is not used. Client should recreate SchemaAwareStreamWriter in this case.
   */
  public boolean isClosed() {
    return this.streamWriter.isClosed();
  }

  /** @return if user explicitly closed the writer. */
  public boolean isUserClosed() {
    return this.streamWriter.isUserClosed();
  }

  public static final class Builder<T> {
    private final String streamName;
    private final BigQueryWriteClient client;
    private final TableSchema tableSchema;

    private final boolean skipRefreshStreamWriter;

    private final ToProtoConverter<T> toProtoConverter;
    private TransportChannelProvider channelProvider;
    private CredentialsProvider credentialsProvider;
    private ExecutorProvider executorProvider;
    private FlowControlSettings flowControlSettings;
    private String endpoint;
    private String traceIdBase;
    private String traceId;
    private boolean ignoreUnknownFields = false;
    // Indicates whether multiplexing mode is enabled.
    private boolean enableConnectionPool = false;
    private String location;
    private String compressorName;
    private RetrySettings retrySettings;

    private AppendRowsRequest.MissingValueInterpretation defaultMissingValueInterpretation =
        MissingValueInterpretation.MISSING_VALUE_INTERPRETATION_UNSPECIFIED;
    private String clientId;

    private static final String streamPatternString =
        "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)/streams/[^/]+";
    private static final String tablePatternString = "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)";
    private static final String defaultStreamPatternString = tablePatternString + "/_default";

    private static final Pattern streamPattern = Pattern.compile(streamPatternString);
    private static final Pattern tablePattern = Pattern.compile(tablePatternString);
    private static final Pattern defaultStreamPattern = Pattern.compile(defaultStreamPatternString);

    /**
     * Constructor for SchemaAwareStreamWriter's Builder
     *
     * @param streamOrTableName name of the stream that must follow
     *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+" or
     *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+"
     * @param tableSchema schema used to convert items to proto messages.
     * @param client
     * @param toProtoConverter converter used to convert items to proto messages
     */
    private Builder(
        String streamOrTableName,
        TableSchema tableSchema,
        BigQueryWriteClient client,
        ToProtoConverter<T> toProtoConverter) {
      Matcher streamMatcher = streamPattern.matcher(streamOrTableName);
      if (!streamMatcher.matches()) {
        Matcher tableMatcher = tablePattern.matcher(streamOrTableName);
        Matcher defaultStreamMatcher = defaultStreamPattern.matcher(streamOrTableName);

        if (!tableMatcher.matches() && !defaultStreamMatcher.matches()) {
          throw new IllegalArgumentException("Invalid  name: " + streamOrTableName);
        } else {
          this.streamName = streamOrTableName + "/_default";
        }
      } else {
        this.streamName = streamOrTableName;
      }
      this.client = client;
      if (tableSchema == null) {
        GetWriteStreamRequest writeStreamRequest =
            GetWriteStreamRequest.newBuilder()
                .setName(this.getStreamName())
                .setView(WriteStreamView.FULL)
                .build();

        WriteStream writeStream = this.client.getWriteStream(writeStreamRequest);
        this.tableSchema = writeStream.getTableSchema();
        this.location = writeStream.getLocation();
        this.skipRefreshStreamWriter = false;
      } else {
        this.tableSchema = tableSchema;
        this.skipRefreshStreamWriter = true;
      }
      this.toProtoConverter = toProtoConverter;
    }

    /**
     * Setter for the underlying StreamWriter's TransportChannelProvider.
     *
     * @param channelProvider
     * @return Builder
     */
    public Builder<T> setChannelProvider(TransportChannelProvider channelProvider) {
      this.channelProvider =
          Preconditions.checkNotNull(channelProvider, "ChannelProvider is null.");
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's CredentialsProvider.
     *
     * @param credentialsProvider
     * @return Builder
     */
    public Builder<T> setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.credentialsProvider =
          Preconditions.checkNotNull(credentialsProvider, "CredentialsProvider is null.");
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's ExecutorProvider.
     *
     * @param executorProvider
     * @return
     */
    public Builder<T> setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider =
          Preconditions.checkNotNull(executorProvider, "ExecutorProvider is null.");
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's FlowControlSettings.
     *
     * @param flowControlSettings
     * @return Builder
     */
    public Builder<T> setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.flowControlSettings =
          Preconditions.checkNotNull(flowControlSettings, "FlowControlSettings is null.");
      return this;
    }

    /**
     * Stream name on the builder.
     *
     * @return Builder
     */
    public String getStreamName() {
      return streamName;
    }

    /**
     * Setter for the underlying StreamWriter's Endpoint.
     *
     * @param endpoint
     * @return Builder
     */
    public Builder<T> setEndpoint(String endpoint) {
      this.endpoint = Preconditions.checkNotNull(endpoint, "Endpoint is null.");
      return this;
    }

    /**
     * Setter for a traceId to help identify traffic origin.
     *
     * @param traceId
     * @return Builder
     */
    public Builder<T> setTraceId(String traceId) {
      this.traceId = Preconditions.checkNotNull(traceId, "TraceId is null.");
      return this;
    }

    Builder<T> setClientId(String clientId) {
      this.clientId = Preconditions.checkNotNull(clientId, "ClientId is null.");
      return this;
    }

    /**
     * Setter for a ignoreUnknownFields, if true, unknown fields to BigQuery will be ignored instead
     * of error out.
     *
     * @param ignoreUnknownFields
     * @return Builder
     */
    public Builder<T> setIgnoreUnknownFields(boolean ignoreUnknownFields) {
      this.ignoreUnknownFields = ignoreUnknownFields;
      return this;
    }

    /**
     * Enable multiplexing for this writer. In multiplexing mode tables will share the same
     * connection if possible until the connection is overwhelmed. This feature is still under
     * development, please contact write api team before using.
     *
     * @param enableConnectionPool
     * @return Builder
     */
    public Builder<T> setEnableConnectionPool(boolean enableConnectionPool) {
      this.enableConnectionPool = enableConnectionPool;
      return this;
    }

    /**
     * Location of the table this stream writer is targeting. Connection pools are shared by
     * location.
     *
     * @param location
     * @return Builder
     */
    public Builder<T> setLocation(String location) {
      if (this.location != null && !this.location.equals(location)) {
        throw new IllegalArgumentException(
            "Specified location " + location + " does not match the system value " + this.location);
      }
      this.location = location;
      return this;
    }

    /**
     * Sets the compression to use for the calls. The compressor must be of type gzip.
     *
     * @param compressorName
     * @return Builder
     */
    public Builder<T> setCompressorName(String compressorName) {
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
     * Sets the RetrySettings to use for in-stream error retry.
     *
     * @param retrySettings
     * @return Builder
     */
    public Builder setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = retrySettings;
      return this;
    }

    /**
     * Builds SchemaAwareStreamWriter
     *
     * @return SchemaAwareStreamWriter
     */
    public SchemaAwareStreamWriter<T> build()
        throws DescriptorValidationException, IllegalArgumentException, IOException,
            InterruptedException {
      return new SchemaAwareStreamWriter<>(this);
    }
  }
}
