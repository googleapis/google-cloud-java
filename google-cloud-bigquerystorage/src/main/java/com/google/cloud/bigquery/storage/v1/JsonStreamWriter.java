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
import com.google.protobuf.Descriptors;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;

/**
 * A StreamWriter that can write JSON data (JSONObjects) to BigQuery tables. The JsonStreamWriter is
 * built on top of a StreamWriter, and it simply converts all JSON data to protobuf messages then
 * calls StreamWriter's append() method to write to BigQuery tables. It maintains all StreamWriter
 * functions, but also provides an additional feature: schema update support, where if the BigQuery
 * table schema is updated, users will be able to ingest data on the new schema after some time (in
 * order of minutes).
 */
public class JsonStreamWriter implements AutoCloseable {
  private final SchemaAwareStreamWriter<Object> schemaAwareStreamWriter;

  /**
   * Constructs the JsonStreamWriter
   *
   * @param builder The Builder object for the JsonStreamWriter
   */
  private JsonStreamWriter(SchemaAwareStreamWriter.Builder<Object> builder)
      throws Descriptors.DescriptorValidationException, IllegalArgumentException, IOException,
          InterruptedException {
    this.schemaAwareStreamWriter = builder.build();
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data at current end
   * of stream. If there is a schema update, the current StreamWriter is closed. A new StreamWriter
   * is created with the updated TableSchema.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr)
      throws IOException, Descriptors.DescriptorValidationException {
    return this.schemaAwareStreamWriter.append(jsonArr);
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data at the
   * specified offset. If there is a schema update, the current StreamWriter is closed. A new
   * StreamWriter is created with the updated TableSchema.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @param offset Offset for deduplication
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr, long offset)
      throws IOException, Descriptors.DescriptorValidationException {
    return this.schemaAwareStreamWriter.append(jsonArr, offset);
  }

  public String getStreamName() {
    return this.schemaAwareStreamWriter.getStreamName();
  }

  /** @return A unique Id for this writer. */
  public String getWriterId() {
    return this.schemaAwareStreamWriter.getWriterId();
  }

  /**
   * Gets current descriptor
   *
   * @return Descriptor
   */
  public Descriptors.Descriptor getDescriptor() {
    return this.schemaAwareStreamWriter.getDescriptor();
  }

  /**
   * Gets the location of the destination
   *
   * @return Descriptor
   */
  public String getLocation() {
    return this.schemaAwareStreamWriter.getLocation();
  }

  /**
   * Returns the wait of a request in Client side before sending to the Server. Request could wait
   * in Client because it reached the client side inflight request limit (adjustable when
   * constructing the Writer). The value is the wait time for the last sent request. A constant high
   * wait value indicates a need for more throughput, you can create a new Stream for to increase
   * the throughput in exclusive stream case, or create a new Writer in the default stream case.
   */
  public long getInflightWaitSeconds() {
    return this.schemaAwareStreamWriter.getInflightWaitSeconds();
  }

  /**
   * Sets the missing value interpretation map for the JsonStreamWriter. The input
   * missingValueInterpretationMap is used for all append requests unless otherwise changed.
   *
   * @param missingValueInterpretationMap the missing value interpretation map used by the
   *     JsonStreamWriter.
   */
  public void setMissingValueInterpretationMap(
      Map<String, AppendRowsRequest.MissingValueInterpretation> missingValueInterpretationMap) {
    this.schemaAwareStreamWriter.setMissingValueInterpretationMap(missingValueInterpretationMap);
  }

  /** @return the missing value interpretation map used for the writer. */
  public Map<String, AppendRowsRequest.MissingValueInterpretation>
      getMissingValueInterpretationMap() {
    return this.schemaAwareStreamWriter.getMissingValueInterpretationMap();
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
    return new Builder(
        SchemaAwareStreamWriter.newBuilder(
            streamOrTableName, tableSchema, JsonToProtoMessage.INSTANCE));
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
    return new Builder(
        SchemaAwareStreamWriter.newBuilder(
            streamOrTableName, tableSchema, client, JsonToProtoMessage.INSTANCE));
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
    return new Builder(
        SchemaAwareStreamWriter.newBuilder(streamOrTableName, client, JsonToProtoMessage.INSTANCE));
  }

  @Override
  public void close() {
    this.schemaAwareStreamWriter.close();
  }

  /**
   * @return if a Json writer can no longer be used for writing. It is due to either the
   *     JsonStreamWriter is explicitly closed or the underlying connection is broken when
   *     connection pool is not used. Client should recreate JsonStreamWriter in this case.
   */
  public boolean isClosed() {
    return this.schemaAwareStreamWriter.isClosed();
  }

  /** @return if user explicitly closed the writer. */
  public boolean isUserClosed() {
    return this.schemaAwareStreamWriter.isUserClosed();
  }

  public static final class Builder {
    private final SchemaAwareStreamWriter.Builder<Object> schemaAwareStreamWriterBuilder;

    private Builder(SchemaAwareStreamWriter.Builder<Object> schemaAwareStreamWriterBuilder) {
      this.schemaAwareStreamWriterBuilder =
          schemaAwareStreamWriterBuilder.setTraceIdBase("JsonWriter");
    }

    /**
     * Setter for the underlying StreamWriter's TransportChannelProvider.
     *
     * @param channelProvider
     * @return Builder
     */
    public Builder setChannelProvider(TransportChannelProvider channelProvider) {
      this.schemaAwareStreamWriterBuilder.setChannelProvider(channelProvider);
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's CredentialsProvider.
     *
     * @param credentialsProvider
     * @return Builder
     */
    public Builder setCredentialsProvider(CredentialsProvider credentialsProvider) {
      this.schemaAwareStreamWriterBuilder.setCredentialsProvider(credentialsProvider);
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's ExecutorProvider.
     *
     * @param executorProvider
     * @return
     */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.schemaAwareStreamWriterBuilder.setExecutorProvider(executorProvider);
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's FlowControlSettings.
     *
     * @param flowControlSettings
     * @return Builder
     */
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      this.schemaAwareStreamWriterBuilder.setFlowControlSettings(flowControlSettings);
      return this;
    }

    /**
     * Stream name on the builder.
     *
     * @return Builder
     */
    public String getStreamName() {
      return this.schemaAwareStreamWriterBuilder.getStreamName();
    }

    /**
     * Setter for the underlying StreamWriter's Endpoint.
     *
     * @param endpoint
     * @return Builder
     */
    public Builder setEndpoint(String endpoint) {
      this.schemaAwareStreamWriterBuilder.setEndpoint(endpoint);
      return this;
    }

    /**
     * Setter for a traceId to help identify traffic origin.
     *
     * @param traceId
     * @return Builder
     */
    public Builder setTraceId(String traceId) {
      this.schemaAwareStreamWriterBuilder.setTraceId(traceId);
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
      this.schemaAwareStreamWriterBuilder.setIgnoreUnknownFields(ignoreUnknownFields);
      return this;
    }

    /** This parameter is not used. It will be removed soon. */
    public Builder setReconnectAfter10M(boolean reconnectAfter10M) {
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
      this.schemaAwareStreamWriterBuilder.setEnableConnectionPool(enableConnectionPool);
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
      this.schemaAwareStreamWriterBuilder.setLocation(location);
      return this;
    }

    /**
     * Sets the compression to use for the calls. The compressor must be of type gzip.
     *
     * @param compressorName
     * @return Builder
     */
    public Builder setCompressorName(String compressorName) {
      this.schemaAwareStreamWriterBuilder.setCompressorName(compressorName);
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
      this.schemaAwareStreamWriterBuilder.setRetrySettings(retrySettings);
      return this;
    }

    /**
     * Sets the default missing value interpretation value if the column is not presented in the
     * missing_value_interpretations map.
     *
     * <p>If this value is set to `DEFAULT_VALUE`, we will always populate default value if the
     * field is missing from json and default value is defined in the column.
     *
     * <p>If this value is set to `NULL_VALUE`, we will always not populate default value.
     */
    public Builder setDefaultMissingValueInterpretation(
        AppendRowsRequest.MissingValueInterpretation defaultMissingValueInterpretation) {
      this.schemaAwareStreamWriterBuilder.setDefaultMissingValueInterpretation(
          defaultMissingValueInterpretation);
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
      return new JsonStreamWriter(this.schemaAwareStreamWriterBuilder);
    }
  }
}
