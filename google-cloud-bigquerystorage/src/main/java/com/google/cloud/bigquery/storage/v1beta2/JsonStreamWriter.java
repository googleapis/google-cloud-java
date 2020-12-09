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
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.common.base.Preconditions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Int64Value;
import com.google.protobuf.Message;
import java.io.IOException;
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

  private BigQueryWriteClient client;
  private String streamName;
  private StreamWriter streamWriter;
  private Descriptor descriptor;
  private TableSchema tableSchema;

  /**
   * Constructs the JsonStreamWriter
   *
   * @param builder The Builder object for the JsonStreamWriter
   */
  private JsonStreamWriter(Builder builder)
      throws Descriptors.DescriptorValidationException, IllegalArgumentException, IOException,
          InterruptedException {
    Matcher matcher = streamPattern.matcher(builder.streamName);
    if (!matcher.matches()) {
      throw new IllegalArgumentException("Invalid stream name: " + builder.streamName);
    }

    this.streamName = builder.streamName;
    this.client = builder.client;
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(builder.tableSchema);

    StreamWriter.Builder streamWriterBuilder;
    if (this.client == null) {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName);
    } else {
      streamWriterBuilder = StreamWriter.newBuilder(builder.streamName, builder.client);
    }
    setStreamWriterSettings(
        streamWriterBuilder,
        builder.channelProvider,
        builder.credentialsProvider,
        builder.batchingSettings,
        builder.retrySettings,
        builder.executorProvider,
        builder.endpoint);
    this.streamWriter = streamWriterBuilder.build();
  }
  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data. If there is a
   * schema update, the OnSchemaUpdateRunnable will be used to determine what actions to perform.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @param allowUnknownFields if true, json data can have fields unknown to the BigQuery table.
   * @return ApiFuture<AppendRowsResponse> returns an AppendRowsResponse message wrapped in an
   *     ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr, boolean allowUnknownFields) {
    return append(jsonArr, -1, allowUnknownFields);
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data. If there is a
   * schema update, the OnSchemaUpdateRunnable will be used to determine what actions to perform.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @param offset Offset for deduplication
   * @param allowUnknownFields if true, json data can have fields unknown to the BigQuery table.
   * @return ApiFuture<AppendRowsResponse> returns an AppendRowsResponse message wrapped in an
   *     ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(
      JSONArray jsonArr, long offset, boolean allowUnknownFields) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    // Any error in convertJsonToProtoMessage will throw an
    // IllegalArgumentException/IllegalStateException/NullPointerException and will halt processing
    // of JSON data.
    for (int i = 0; i < jsonArr.length(); i++) {
      JSONObject json = jsonArr.getJSONObject(i);
      Message protoMessage =
          JsonToProtoMessage.convertJsonToProtoMessage(this.descriptor, json, allowUnknownFields);
      rowsBuilder.addSerializedRows(protoMessage.toByteString());
    }
    AppendRowsRequest.ProtoData.Builder data = AppendRowsRequest.ProtoData.newBuilder();
    // Need to make sure refreshAppendAndSetDescriptor finish first before this can run
    synchronized (this) {
      data.setWriterSchema(ProtoSchemaConverter.convert(this.descriptor));
      data.setRows(rowsBuilder.build());
      final ApiFuture<AppendRowsResponse> appendResponseFuture =
          this.streamWriter.append(
              AppendRowsRequest.newBuilder()
                  .setProtoRows(data.build())
                  .setOffset(Int64Value.of(offset))
                  .build());
      return appendResponseFuture;
    }
  }

  /**
   * Refreshes connection for a JsonStreamWriter by first flushing all remaining rows, then calling
   * refreshAppend(), and finally setting the descriptor. All of these actions need to be performed
   * atomically to avoid having synchronization issues with append(). Flushing all rows first is
   * necessary since if there are rows remaining when the connection refreshes, it will send out the
   * old writer schema instead of the new one.
   */
  void refreshConnection()
      throws IOException, InterruptedException, Descriptors.DescriptorValidationException {
    synchronized (this) {
      this.streamWriter.writeAllOutstanding();
      this.streamWriter.refreshAppend();
      this.descriptor =
          BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(this.tableSchema);
    }
  }

  /**
   * Gets streamName
   *
   * @return String
   */
  public String getStreamName() {
    return this.streamName;
  }

  /**
   * Gets current descriptor
   *
   * @return Descriptor
   */
  public Descriptor getDescriptor() {
    return this.descriptor;
  }

  /** Sets all StreamWriter settings. */
  private void setStreamWriterSettings(
      StreamWriter.Builder builder,
      @Nullable TransportChannelProvider channelProvider,
      @Nullable CredentialsProvider credentialsProvider,
      @Nullable BatchingSettings batchingSettings,
      @Nullable RetrySettings retrySettings,
      @Nullable ExecutorProvider executorProvider,
      @Nullable String endpoint) {
    if (channelProvider != null) {
      builder.setChannelProvider(channelProvider);
    }
    if (credentialsProvider != null) {
      builder.setCredentialsProvider(credentialsProvider);
    }
    if (batchingSettings != null) {
      builder.setBatchingSettings(batchingSettings);
    }
    if (retrySettings != null) {
      builder.setRetrySettings(retrySettings);
    }
    if (executorProvider != null) {
      builder.setExecutorProvider(executorProvider);
    }
    if (endpoint != null) {
      builder.setEndpoint(endpoint);
    }
    JsonStreamWriterOnSchemaUpdateRunnable jsonStreamWriterOnSchemaUpdateRunnable =
        new JsonStreamWriterOnSchemaUpdateRunnable();
    jsonStreamWriterOnSchemaUpdateRunnable.setJsonStreamWriter(this);
    builder.setOnSchemaUpdateRunnable(jsonStreamWriterOnSchemaUpdateRunnable);
  }

  /**
   * Setter for table schema. Used for schema updates.
   *
   * @param tableSchema
   */
  void setTableSchema(TableSchema tableSchema) {
    this.tableSchema = tableSchema;
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder with BigQuery client being initialized by
   * StreamWriter by default.
   *
   * @param streamName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param tableSchema The schema of the table when the stream was created, which is passed back
   *     through {@code WriteStream}
   * @return Builder
   */
  public static Builder newBuilder(String streamName, TableSchema tableSchema) {
    Preconditions.checkNotNull(streamName, "StreamName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    return new Builder(streamName, tableSchema, null);
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder.
   *
   * @param streamName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param tableSchema The schema of the table when the stream was created, which is passed back
   *     through {@code WriteStream}
   * @param client
   * @return Builder
   */
  public static Builder newBuilder(
      String streamName, TableSchema tableSchema, BigQueryWriteClient client) {
    Preconditions.checkNotNull(streamName, "StreamName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    return new Builder(streamName, tableSchema, client);
  }

  /** Closes the underlying StreamWriter. */
  @Override
  public void close() {
    this.streamWriter.close();
  }

  private class JsonStreamWriterOnSchemaUpdateRunnable extends OnSchemaUpdateRunnable {
    private JsonStreamWriter jsonStreamWriter;
    /**
     * Setter for the jsonStreamWriter
     *
     * @param jsonStreamWriter
     */
    public void setJsonStreamWriter(JsonStreamWriter jsonStreamWriter) {
      this.jsonStreamWriter = jsonStreamWriter;
    }

    /** Getter for the jsonStreamWriter */
    public JsonStreamWriter getJsonStreamWriter() {
      return this.jsonStreamWriter;
    }

    @Override
    public void run() {
      this.getJsonStreamWriter().setTableSchema(this.getUpdatedSchema());
      try {
        this.getJsonStreamWriter().refreshConnection();
      } catch (InterruptedException | IOException e) {
        LOG.severe("StreamWriter failed to refresh upon schema update." + e);
        return;
      } catch (Descriptors.DescriptorValidationException e) {
        LOG.severe(
            "Schema update fail: updated schema could not be converted to a valid descriptor.");
        return;
      }
      LOG.info("Successfully updated schema: " + this.getUpdatedSchema());
    }
  }

  public static final class Builder {
    private String streamName;
    private BigQueryWriteClient client;
    private TableSchema tableSchema;

    private TransportChannelProvider channelProvider;
    private CredentialsProvider credentialsProvider;
    private BatchingSettings batchingSettings;
    private RetrySettings retrySettings;
    private ExecutorProvider executorProvider;
    private String endpoint;

    /**
     * Constructor for JsonStreamWriter's Builder
     *
     * @param streamName name of the stream that must follow
     *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
     * @param tableSchema schema used to convert Json to proto messages.
     * @param client
     */
    private Builder(String streamName, TableSchema tableSchema, BigQueryWriteClient client) {
      this.streamName = streamName;
      this.tableSchema = tableSchema;
      this.client = client;
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
     * Setter for the underlying StreamWriter's BatchingSettings.
     *
     * @param batchingSettings
     * @return Builder
     */
    public Builder setBatchingSettings(BatchingSettings batchingSettings) {
      this.batchingSettings =
          Preconditions.checkNotNull(batchingSettings, "BatchingSettings is null.");
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's RetrySettings.
     *
     * @param retrySettings
     * @return Builder
     */
    public Builder setRetrySettings(RetrySettings retrySettings) {
      this.retrySettings = Preconditions.checkNotNull(retrySettings, "RetrySettings is null.");
      return this;
    }

    /**
     * Setter for the underlying StreamWriter's ExecutorProvider.
     *
     * @param executorProvider
     * @return Builder
     */
    public Builder setExecutorProvider(ExecutorProvider executorProvider) {
      this.executorProvider =
          Preconditions.checkNotNull(executorProvider, "ExecutorProvider is null.");
      return this;
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
