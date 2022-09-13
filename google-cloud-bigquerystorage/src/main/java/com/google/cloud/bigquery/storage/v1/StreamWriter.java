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
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.common.base.Preconditions;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * A BigQuery Stream Writer that can be used to write data into BigQuery Table.
 *
 * <p>TODO: Support batching.
 */
public class StreamWriter implements AutoCloseable {
  private static final Logger log = Logger.getLogger(StreamWriter.class.getName());

  private final ConnectionWorker connectionWorker;

  /*
   * The identifier of stream to write to.
   */
  private final String streamName;

  /*
   * A String that uniquely identifies this writer.
   */
  private final String writerId = UUID.randomUUID().toString();

  /** The maximum size of one request. Defined by the API. */
  public static long getApiMaxRequestBytes() {
    return 10L * 1000L * 1000L; // 10 megabytes (https://en.wikipedia.org/wiki/Megabyte)
  }

  private StreamWriter(Builder builder) throws IOException {
    BigQueryWriteClient client;
    this.streamName = builder.streamName;
    boolean ownsBigQueryWriteClient;
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
      client = BigQueryWriteClient.create(stubSettings);
      ownsBigQueryWriteClient = true;
    } else {
      client = builder.client;
      ownsBigQueryWriteClient = false;
    }
    connectionWorker =
        new ConnectionWorker(
            builder.streamName,
            builder.writerSchema,
            builder.maxInflightRequest,
            builder.maxInflightBytes,
            builder.limitExceededBehavior,
            builder.traceId,
            client,
            ownsBigQueryWriteClient);
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
    return this.connectionWorker.append(rows, offset);
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
    return connectionWorker.getInflightWaitSeconds();
  }

  /** @return a unique Id for the writer. */
  public String getWriterId() {
    return connectionWorker.getWriterId();
  }

  /** @return name of the Stream that this writer is working on. */
  public String getStreamName() {
    return streamName;
  }

  /** Close the stream writer. Shut down all resources. */
  @Override
  public void close() {
    this.connectionWorker.close();
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
    return connectionWorker.getUpdatedSchema();
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

    private FlowController.LimitExceededBehavior limitExceededBehavior =
        FlowController.LimitExceededBehavior.Block;

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

    /** Builds the {@code StreamWriterV2}. */
    public StreamWriter build() throws IOException {
      return new StreamWriter(this);
    }
  }
}
