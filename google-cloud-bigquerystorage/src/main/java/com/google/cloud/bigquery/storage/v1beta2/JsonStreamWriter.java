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
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.common.base.Preconditions;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Descriptors.Descriptor;
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
 * calls StreamWriter's append() method to write to BigQuery tables.
 *
 * <p>This client lib is deprecated, please use v1 instead.
 */
@Deprecated
public class JsonStreamWriter implements AutoCloseable {
  private static String streamPatternString =
      "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+";
  private static Pattern streamPattern = Pattern.compile(streamPatternString);
  private static final Logger LOG = Logger.getLogger(JsonStreamWriter.class.getName());

  private BigQueryWriteClient client;
  private String streamName;
  private StreamWriterV2 streamWriter;
  private StreamWriterV2.Builder streamWriterBuilder;
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
    this.client = builder.client;
    this.descriptor =
        BQTableSchemaToProtoDescriptor.convertBQTableSchemaToProtoDescriptor(builder.tableSchema);

    if (this.client == null) {
      streamWriterBuilder = StreamWriterV2.newBuilder(builder.streamName);
    } else {
      streamWriterBuilder = StreamWriterV2.newBuilder(builder.streamName, builder.client);
    }
    streamWriterBuilder.setWriterSchema(ProtoSchemaConverter.convert(this.descriptor));
    setStreamWriterSettings(
        builder.channelProvider,
        builder.credentialsProvider,
        builder.endpoint,
        builder.flowControlSettings,
        builder.traceId);
    this.streamWriter = streamWriterBuilder.build();
    this.streamName = builder.streamName;
    this.tableSchema = builder.tableSchema;
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr) {
    return append(jsonArr, -1);
  }

  /**
   * Writes a JSONArray that contains JSONObjects to the BigQuery table by first converting the JSON
   * data to protobuf messages, then using StreamWriter's append() to write the data.
   *
   * @param jsonArr The JSON array that contains JSONObjects to be written
   * @param offset Offset for deduplication
   * @return {@code ApiFuture<AppendRowsResponse>} returns an AppendRowsResponse message wrapped in
   *     an ApiFuture
   */
  public ApiFuture<AppendRowsResponse> append(JSONArray jsonArr, long offset) {
    ProtoRows.Builder rowsBuilder = ProtoRows.newBuilder();
    // Any error in convertJsonToProtoMessage will throw an
    // IllegalArgumentException/IllegalStateException/NullPointerException and will halt processing
    // of JSON data.
    for (int i = 0; i < jsonArr.length(); i++) {
      JSONObject json = jsonArr.getJSONObject(i);
      Message protoMessage =
          JsonToProtoMessage.convertJsonToProtoMessage(this.descriptor, this.tableSchema, json);
      rowsBuilder.addSerializedRows(protoMessage.toByteString());
    }
    // Need to make sure refreshAppendAndSetDescriptor finish first before this can run
    synchronized (this) {
      final ApiFuture<AppendRowsResponse> appendResponseFuture =
          this.streamWriter.append(rowsBuilder.build(), offset);
      return appendResponseFuture;
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
      @Nullable TransportChannelProvider channelProvider,
      @Nullable CredentialsProvider credentialsProvider,
      @Nullable String endpoint,
      @Nullable FlowControlSettings flowControlSettings,
      @Nullable String traceId) {
    if (channelProvider != null) {
      streamWriterBuilder.setChannelProvider(channelProvider);
    }
    if (credentialsProvider != null) {
      streamWriterBuilder.setCredentialsProvider(credentialsProvider);
    }
    if (endpoint != null) {
      streamWriterBuilder.setEndpoint(endpoint);
    }
    if (traceId != null) {
      streamWriterBuilder.setTraceId("JsonWriterBeta_" + traceId);
    } else {
      streamWriterBuilder.setTraceId("JsonWriterBeta:null");
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
    }
  }

  /**
   * newBuilder that constructs a JsonStreamWriter builder with BigQuery client being initialized by
   * StreamWriter by default.
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
   * @param streamOrTableName name of the stream that must follow
   *     "projects/[^/]+/datasets/[^/]+/tables/[^/]+/streams/[^/]+"
   * @param tableSchema The schema of the table when the stream was created, which is passed back
   *     through {@code WriteStream}
   * @param client
   * @return Builder
   */
  public static Builder newBuilder(
      String streamOrTableName, TableSchema tableSchema, BigQueryWriteClient client) {
    Preconditions.checkNotNull(streamOrTableName, "StreamName is null.");
    Preconditions.checkNotNull(tableSchema, "TableSchema is null.");
    Preconditions.checkNotNull(client, "BigQuery client is null.");
    return new Builder(streamOrTableName, tableSchema, client);
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
    private FlowControlSettings flowControlSettings;
    private String endpoint;
    private boolean createDefaultStream = false;
    private String traceId;

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
     * Setter for the underlying StreamWriter's FlowControlSettings.
     *
     * @param flowControlSettings
     * @return Builder
     */
    public Builder setFlowControlSettings(FlowControlSettings flowControlSettings) {
      Preconditions.checkNotNull(flowControlSettings, "FlowControlSettings is null.");
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
