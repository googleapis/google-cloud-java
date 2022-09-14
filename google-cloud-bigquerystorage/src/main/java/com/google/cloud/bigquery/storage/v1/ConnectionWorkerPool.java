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
import com.google.api.gax.batching.FlowController;
import com.google.auto.value.AutoValue;
import javax.annotation.concurrent.GuardedBy;

public class ConnectionWorkerPool {
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
   * Contains the updated TableSchema.
   */
  @GuardedBy("lock")
  private TableSchema updatedSchema;

  /*
   * A client used to interact with BigQuery.
   */
  private BigQueryWriteClient client;

  /*
   * If true, the client above is created by this writer and should be closed.
   */
  private boolean ownsBigQueryWriteClient = false;

  /** Settings for connection pool. */
  @AutoValue
  public abstract static class Settings {
    /**
     * The minimum connections each pool created before trying to reuse the previously created
     * connection in multiplexing mode.
     */
    abstract int minConnectionsPerPool();

    /** The maximum connections per connection pool. */
    abstract int maxConnectionsPerPool();

    public static Builder builder() {
      return new AutoValue_ConnectionWorkerPool_Settings.Builder()
          .setMinConnectionsPerPool(2)
          .setMaxConnectionsPerPool(10);
    }

    /** Builder for the options to config {@link ConnectionWorkerPool}. */
    @AutoValue.Builder
    public abstract static class Builder {
      public abstract Builder setMinConnectionsPerPool(int value);

      public abstract Builder setMaxConnectionsPerPool(int value);

      public abstract Settings build();
    }
  }

  /** Static setting for connection pool. */
  private static Settings settings = Settings.builder().build();

  public ConnectionWorkerPool(
      long maxInflightRequests,
      long maxInflightBytes,
      FlowController.LimitExceededBehavior limitExceededBehavior,
      String traceId,
      BigQueryWriteClient client,
      boolean ownsBigQueryWriteClient) {
    this.maxInflightRequests = maxInflightRequests;
    this.maxInflightBytes = maxInflightBytes;
    this.limitExceededBehavior = limitExceededBehavior;
    this.traceId = traceId;
    this.client = client;
    this.ownsBigQueryWriteClient = ownsBigQueryWriteClient;
  }

  /**
   * Sets static connection pool options.
   *
   * <p>Note: this method should be triggered prior to the construction of connection pool.
   */
  public static void setOptions(Settings settings) {
    ConnectionWorkerPool.settings = settings;
  }

  /** Distributes the writing of a message to an underlying connection. */
  public ApiFuture<AppendRowsResponse> append(StreamWriter streamWriter, ProtoRows rows) {
    throw new RuntimeException("Append is not implemented!");
  }

  /** Distributes the writing of a message to an underlying connection. */
  public ApiFuture<AppendRowsResponse> append(
      StreamWriter streamWriter, ProtoRows rows, long offset) {
    throw new RuntimeException("append with offset is not implemented on connection pool!");
  }

  /** Close the stream writer. Shut down all resources. */
  public void close(StreamWriter streamWriter) {
    throw new RuntimeException("close is implemented on connection pool");
  }
}
