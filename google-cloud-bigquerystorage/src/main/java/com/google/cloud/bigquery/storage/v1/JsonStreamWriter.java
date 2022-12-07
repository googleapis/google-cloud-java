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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.bigquery.storage.v1.Exceptions.AppendSerializtionError;
import com.google.common.base.Preconditions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import com.google.protobuf.Message;
import com.google.rpc.Code;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * A StreamWriter that can write JSON data (JSONObjects) to BigQuery tables. The JsonStreamWriter is
 * built on top of a StreamWriter, and it simply converts all JSON data to protobuf messages then
 * calls StreamWriter's append() method to write to BigQuery tables. It maintains all StreamWriter
 * functions, but also provides an additional feature: schema update support, where if the BigQuery
 * table schema is updated, users will be able to ingest data on the new schema after some time (in
 * order of minutes).
 */
public class JsonStreamWriter implements AutoCloseable {
  private static String streamPatternString =
      "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+";
  private static Pattern streamPattern = Pattern.compile(streamPatternString);
  private static final Logger LOG = Logger.getLogger(JsonStreamWriter.class.getName());
  private static final long UPDATE_SCHEMA_RETRY_INTERVAL_MILLIS = 30100L;

  private BigQueryWriteClient client;
  private String streamName;
  private StreamWriter streamWriter;
  private StreamWriter.Builder streamWriterBuilder;
  private Descriptor descriptor;
  private TableSchema tableSchema;
  private boolean ignoreUnknownFields = false;
  private boolean reconnectAfter10M = false;
  private long totalMessageSize = 0;
  private long absTotal = 0;
  private ProtoSchema protoSchema;
  private boolean enableConnectionPool = false;

  /**
   * Constructs the JsonStreamWriter
   *
   * @param builder The Builder object for the JsonStreamWriter
   */
  private JsonStreamWriter(Builder builder)
      throws Descriptors.DescriptorValidationException, IllegalArgumentException, IOException,
          InterruptedException {
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(builder.tableSchema);

    if (builder.client == null) {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName);
    } else {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName, builder.client);
    }
    this.protoSchema = ProtoSchemaConverter.convert(this.descriptor);
    this.totalMessageSize = protoSchema.getSerializedSize();
    this.client = builder.client;
    streamWriterBuilder.setWriterSchema(protoSchema);
    setStreamWriterSettings(
        builder.channelProvider,
        builder.credentialsProvider,
        builder.executorProvider,
        builder.endpoint,
        builder.flowControlSettings,
        builder.traceId);
    streamWriterBuilder.setEnableConnectionPool(builder.enableConnectionPool);
    streamWriterBuilder.setLocation(builder.location);
    this.streamWriter = streamWriterBuilder.build();
    this.streamName = builder.streamName;
    this.tableSchema = builder.tableSchema;
    this.ignoreUnknownFields = builder.ignoreUnknownFields;
    this.reconnectAfter10M = builder.reconnectAfter10M;
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data at current end
   * of stream. If there is a schema update, the current StreamWriter is closed. A new StreamWriter
   * is created with the updated TableSchema.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @return ApiFuture<AppendRowsResponse> returns an AppendRowsResponse message wrapped in an
   *     ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr)
      throws IOException, DescriptorValidationException {
    return append(jsonArr, -1);
  }

  private void refreshWriter(TableSchema updatedSchema)
      throws DescriptorValidationException, IOException {
    Preconditions.checkNotNull(updatedSchema, "updatedSchema is null.");
    LOG.info("Refresh internal writer due to schema update, stream: " + this.streamName);
    // Close the StreamWriterf
    this.streamWriter.close();
    // Update JsonStreamWriter's TableSchema and Descriptor
    this.tableSchema = updatedSchema;
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(updatedSchema);
    this.protoSchema = ProtoSchemaConverter.convert(this.descriptor);
    this.totalMessageSize = protoSchema.getSerializedSize();
    // Create a new underlying StreamWriter with the updated TableSchema and Descriptor
    this.streamWriter = streamWriterBuilder.setWriterSchema(this.protoSchema).build();
  }

  private Message buildMessage(JSONObject json)
      throws InterruptedException, DescriptorValidationException, IOException {
    try {
      return JsonToProtoMessage.convertJsonToProtoMessage(
          this.descriptor, this.tableSchema, json, ignoreUnknownFields);
    } catch (Exceptions.JsonDataHasUnknownFieldException ex) {
      // Backend cache for GetWriteStream schema staleness can be 30 seconds, wait a bit before
      // trying to get the table schema to increase the chance of succeed. This is to avoid
      // client's invalid datfa caused storm of GetWriteStream.
      LOG.warning(
          "Saw Json unknown field "
              + ex.getFieldName()
              + ", try to refresh the writer with updated schema, stream: "
              + streamName);
      GetWriteStreamRequest writeStreamRequest =
          GetWriteStreamRequest.newBuilder()
              .setName(this.streamName)
              .setView(WriteStreamView.FULL)
              .build();
      WriteStream writeStream = client.getWriteStream(writeStreamRequest);
      refreshWriter(writeStream.getTableSchema());
      try {
        return JsonToProtoMessage.convertJsonToProtoMessage(
            this.descriptor, this.tableSchema, json, ignoreUnknownFields);
      } catch (Exceptions.JsonDataHasUnknownFieldException exex) {
        LOG.warning(
            "First attempt failed, waiting for 30 seconds to retry, stream: " + this.streamName);
        Thread.sleep(UPDATE_SCHEMA_RETRY_INTERVAL_MILLIS);
        writeStream = client.getWriteStream(writeStreamRequest);
        // TODO(yiru): We should let TableSchema return a timestamp so that we can simply
        //     compare the timestamp to see if the table schema is the same. If it is the
        //     same, we don't need to go refresh the writer again.
        refreshWriter(writeStream.getTableSchema());
        return JsonToProtoMessage.convertJsonToProtoMessage(
            this.descriptor, this.tableSchema, json, ignoreUnknownFields);
      }
    }
  }
  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data at the
   * specified offset. If there is a schema update, the current StreamWriter is closed. A new
   * StreamWriter is created with the updated TableSchema.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @param offset Offset for deduplication
   * @return ApiFuture<AppendRowsResponse> returns an AppendRowsResponse message wrapped in an
   *     ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr, long offset)
      throws IOException, DescriptorValidationException {
    // Handle schema updates in a Thread-safe way by locking down the operation
    synchronized (this) {
      // Create a new stream writer internally if a new updated schema is reported from backend.
      if (this.streamWriter.getUpdatedSchema() != null) {
        refreshWriter(this.streamWriter.getUpdatedSchema());
      }

      ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
      // Any error in convertJsonToProtoMessage will throw an
      // IllegalArgumentException/IllegalStateException/NullPointerException.
      // IllegalArgumentException will be collected into a Map of row indexes to error messages.
      // After the conversion is finished an AppendSerializtionError exception that contains all the
      // conversion errors will be thrown.
      long currentRequestSize = 0;
      Map<Integer, String> rowIndexToErrorMessage = new HashMap<>();
      for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject json = jsonArr.getJSONObject(i);
        try {
          Message protoMessage = buildMessage(json);
          rowsBuilder.addSerializedRows(protoMessage.toByteString());
          currentRequestSize += protoMessage.getSerializedSize();
        } catch (IllegalArgumentException exception) {
          if (exception instanceof Exceptions.FieldParseError) {
            Exceptions.FieldParseError ex = (Exceptions.FieldParseError) exception;
            rowIndexToErrorMessage.put(
                i,
                "Field "
                    + ex.getFieldName()
                    + " failed to convert to "
                    + ex.getBqType()
                    + ". Error: "
                    + ex.getCause().getMessage());
          } else {
            rowIndexToErrorMessage.put(i, exception.getMessage());
          }
        } catch (InterruptedException ex) {
          throw new RuntimeException(ex);
        }
      }

      if (!rowIndexToErrorMessage.isEmpty()) {
        throw new AppendSerializtionError(
            Code.INVALID_ARGUMENT.getNumber(),
            "Append serialization failed for writer: " + streamName,
            streamName,
            rowIndexToErrorMessage);
      }
      final ApiFuture<AppendRowsResponse> appendResponseFuture =
          this.streamWriter.append(rowsBuilder.build(), offset);
      return appendResponseFuture;
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

  /** Sets all StreamWriter settings. */
  private void setStreamWriterSettings(
      @Nullable TransportChannelProvider channelProvider,
      @Nullable CredentialsProvider credentialsProvider,
      @Nullable ExecutorProvider executorProvider,
      @Nullable String endpoint,
      @Nullable FlowControlSettings flowControlSettings,
      @Nullable String traceId) {
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
      streamWriterBuilder.setTraceId("JsonWriter_" + traceId);
    } else {
      streamWriterBuilder.setTraceId("JsonWriter:null");
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
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder with BigQuery client being initialized by
   * StreamWriter by default.
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
  public static Builder newBuilder(String streamOrTableName, TableSchema tableSchema) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    return new Builder(streamOrTableName, tableSchema, null);
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder.
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
  public static Builder newBuilder(
      String streamOrTableName, TableSchema tableSchema, BigQueryWriteClient client) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    return new Builder(streamOrTableName, tableSchema, client);
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder with TableSchema being initialized by
   * StreamWriter by default.
   *
   * @param streamOrTableName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param client BigQueryWriteClient
   * @return Builder
   */
  public static Builder newBuilder(String streamOrTableName, BigQueryWriteClient client) {
    Preconditions.checkNotNull(streamOrTableName, "StreamOrTableName is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    return new Builder(streamOrTableName, null, client);
  }

  /** Closes the underlying StreamWriter. */
  @Override
  public void close() {
    this.streamWriter.close();
  }

  public static final class Builder {
    private String streamName;
    private BigQueryWriteClient client;
    private TableSchema tableSchema;

    private TransportChannelProvider channelProvider;
    private CredentialsProvider credentialsProvider;
    private ExecutorProvider executorProvider;
    private FlowControlSettings flowControlSettings;
    private String endpoint;
    private boolean createDefaultStream = false;
    private String traceId;
    private boolean ignoreUnknownFields = false;
    private boolean reconnectAfter10M = false;
    // Indicte whether multiplexing mode is enabled.
    private boolean enableConnectionPool = false;
    private String location;

    private static String streamPatternString =
        "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)/streams/[^/]+";
    private static String tablePatternString = "(projects/[^/]+/datasets/[^/]+/tables/[^/]+)";

    private static Pattern streamPattern = Pattern.compile(streamPatternString);
    private static Pattern tablePattern = Pattern.compile(tablePatternString);

    /**
     * Constructor for JsonStreamWriter's Builder
     *
     * @param streamOrTableName name of the stream that must follow
     *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+" or
     *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+"
     * @param tableSchema schema used to convert Json to proto messages.
     * @param client
     */
    private Builder(String streamOrTableName, TableSchema tableSchema, BigQueryWriteClient client) {
      Matcher streamMatcher = streamPattern.matcher(streamOrTableName);
      if (!streamMatcher.matches()) {
        Matcher tableMatcher = tablePattern.matcher(streamOrTableName);
        if (!tableMatcher.matches()) {
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
        TableSchema writeStreamTableSchema = writeStream.getTableSchema();

        this.tableSchema = writeStreamTableSchema;
        this.location = writeStream.getLocation();
      } else {
        this.tableSchema = tableSchema;
      }
    }

    /**
     * Setter for the underlying StreamWriter's TransportChannelProvider.
     *
     * @param channelProvider
     * @return Builder
     */
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
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
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
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
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
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
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
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
    public Builder setEndpoint(String endpoint) {
      this.endpoint = Preconditions.checkNotNull(endpoint, "Endpoint is null.");
      return this;
    }

    /**
     * Setter for a traceId to help identify traffic origin.
     *
     * @param traceId
     * @return Builder
     */
    public Builder setTraceId(String traceId) {
      this.traceId = Preconditions.checkNotNull(traceId, "TraceId is null.");
      return this;
    }

    /**
     * Setter for a ignoreUnkownFields, if true, unknown Json fields to BigQuery will be ignored
     * instead of error out.
     *
     * @param ignoreUnknownFields
     * @return Builder
     */
    public Builder setIgnoreUnknownFields(boolean ignoreUnknownFields) {
      this.ignoreUnknownFields = ignoreUnknownFields;
      return this;
    }

    /**
     * @Deprecated Setter for a reconnectAfter10M, temporaily workaround for omg/48020. Fix for the
     * omg is supposed to roll out by 2/11/2022 Friday. If you set this to True, your write will be
     * slower (0.75MB/s per connection), but your writes will not be stuck as a sympton of
     * omg/48020.
     *
     * @param reconnectAfter10M
     * @return Builder
     */
    public Builder setReconnectAfter10M(boolean reconnectAfter10M) {
      this.reconnectAfter10M = false;
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
    public Builder setEnableConnectionPool(boolean enableConnectionPool) {
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
    public Builder setLocation(String location) {
      if (this.location != null && !this.location.equals(location)) {
        throw new IllegalArgumentException(
            "Specified location " + location + " does not match the system value " + this.location);
      }
      this.location = location;
      return this;
    }

    /**
     * Builds JsonStreamWriter
     *
     * @return JsonStreamWriter
     */
    public JsonStreamWriter build()
        throws Descriptors.DescriptorValidationException, IllegalArgumentException, IOException,
            InterruptedException {
      return new JsonStreamWriter(this);
    }
  }
}
