/*
 * Copyright 2016 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery;

import com.google.api.services.bigquery.model.Streamingbuffer;
import com.google.api.services.bigquery.model.Table;
import com.google.auto.value.AutoValue;
import com.google.common.base.MoreObjects;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * A Google BigQuery default table definition. This definition is used for standard, two-dimensional
 * tables with individual records organized in rows, and a data type assigned to each column (also
 * called a field). Individual fields within a record may contain nested and repeated children
 * fields. Every table is described by a schema that describes field names, types, and other
 * information.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
@AutoValue
public abstract class StandardTableDefinition extends TableDefinition {

  private static final long serialVersionUID = 2113445776046717900L;

  /**
   * Google BigQuery Table's Streaming Buffer information. This class contains information on a
   * table's streaming buffer as the estimated size in number of rows/bytes.
   */
  public static class StreamingBuffer implements Serializable {

    private static final long serialVersionUID = 822027055549277843L;
    private final long estimatedRows;
    private final long estimatedBytes;
    private final Long oldestEntryTime;

    StreamingBuffer(long estimatedRows, long estimatedBytes, Long oldestEntryTime) {
      this.estimatedRows = estimatedRows;
      this.estimatedBytes = estimatedBytes;
      this.oldestEntryTime = oldestEntryTime;
    }


    /**
     * Returns a lower-bound estimate of the number of rows currently in the streaming buffer.
     */
    public long getEstimatedRows() {
      return estimatedRows;
    }


    /**
     * Returns a lower-bound estimate of the number of bytes currently in the streaming buffer.
     */
    public long getEstimatedBytes() {
      return estimatedBytes;
    }


    /**
     * Returns the timestamp of the oldest entry in the streaming buffer, in milliseconds since
     * epoch. Returns {@code null} if the streaming buffer is empty.
     */
    public Long getOldestEntryTime() {
      return oldestEntryTime;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("estimatedRows", estimatedRows)
          .add("estimatedBytes", estimatedBytes)
          .add("oldestEntryTime", oldestEntryTime)
          .toString();
    }

    @Override
    public int hashCode() {
      return Objects.hash(estimatedRows, estimatedBytes, oldestEntryTime);
    }

    @Override
    public boolean equals(Object obj) {
      return obj instanceof StreamingBuffer
          && Objects.equals(toPb(), ((StreamingBuffer) obj).toPb());
    }

    Streamingbuffer toPb() {
      return new Streamingbuffer()
          .setEstimatedBytes(BigInteger.valueOf(estimatedBytes))
          .setEstimatedRows(BigInteger.valueOf(estimatedRows))
          .setOldestEntryTime(BigInteger.valueOf(oldestEntryTime));
    }

    static StreamingBuffer fromPb(Streamingbuffer streamingBufferPb) {
      Long oldestEntryTime = null;
      if (streamingBufferPb.getOldestEntryTime() != null) {
        oldestEntryTime = streamingBufferPb.getOldestEntryTime().longValue();
      }
      return new StreamingBuffer(streamingBufferPb.getEstimatedRows().longValue(),
          streamingBufferPb.getEstimatedBytes().longValue(),
          oldestEntryTime);
    }
  }

  @AutoValue.Builder
  public abstract static class Builder
      extends TableDefinition.Builder<StandardTableDefinition, Builder> {

    public abstract Builder setNumBytes(Long numBytes);

    public abstract Builder setNumRows(Long numRows);

    public abstract Builder setLocation(String location);

    public abstract Builder setStreamingBuffer(StreamingBuffer streamingBuffer);

    public abstract Builder setType(Type type);

    /** Sets the table schema. */
    public abstract Builder setSchema(Schema schema);

    /**
     * Sets the time partitioning configuration for the table. If not set, the table is not
     * time-partitioned.
     */
    public abstract Builder setTimePartitioning(TimePartitioning timePartitioning);

    /** Creates a {@code StandardTableDefinition} object. */
    public abstract StandardTableDefinition build();
  }

  /** Returns the size of this table in bytes, excluding any data in the streaming buffer. */
  @Nullable
  public abstract Long getNumBytes();

  /** Returns the number of rows in this table, excluding any data in the streaming buffer. */
  @Nullable
  public abstract Long getNumRows();

  /**
   * Returns the geographic location where the table should reside. This value is inherited from the
   * dataset.
   *
   * @see <a
   *     href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  @Nullable
  public abstract String getLocation();

  /**
   * Returns information on the table's streaming buffer if any exists. Returns {@code null} if no
   * streaming buffer exists.
   */
  @Nullable
  public abstract StreamingBuffer getStreamingBuffer();

  /**
   * Returns the time partitioning configuration for this table. If {@code null}, the table is not
   * time-partitioned.
   */
  @Nullable
  public abstract TimePartitioning getTimePartitioning();

  /**
   * Returns a builder for a BigQuery standard table definition.
   */
  public static Builder newBuilder() {
    return new AutoValue_StandardTableDefinition.Builder().setType(Type.TABLE);
  }

  /**
   * Creates a BigQuery standard table definition given its schema.
   *
   * @param schema the schema of the table
   */
  public static StandardTableDefinition of(Schema schema) {
    return newBuilder().setSchema(schema).build();
  }

  /** Returns a builder for the {@code StandardTableDefinition} object. */
  public abstract Builder toBuilder();

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    if (getNumRows() != null) {
      tablePb.setNumRows(BigInteger.valueOf(getNumRows()));
    }
    tablePb.setNumBytes(getNumBytes());
    tablePb.setLocation(getLocation());
    if (getStreamingBuffer() != null) {
      tablePb.setStreamingBuffer(getStreamingBuffer().toPb());
    }
    if (getTimePartitioning() != null) {
      tablePb.setTimePartitioning(getTimePartitioning().toPb());
    }
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static StandardTableDefinition fromPb(Table tablePb) {
    Builder builder = newBuilder().table(tablePb);
    if (tablePb.getNumRows() != null) {
      builder.setNumRows(tablePb.getNumRows().longValue());
    }
    if (tablePb.getStreamingBuffer() != null) {
      builder.setStreamingBuffer(StreamingBuffer.fromPb(tablePb.getStreamingBuffer()));
    }
    if (tablePb.getTimePartitioning() != null) {
      builder.setTimePartitioning(TimePartitioning.fromPb(tablePb.getTimePartitioning()));
    }
    return builder.setNumBytes(tablePb.getNumBytes()).setLocation(tablePb.getLocation()).build();
  }
}
