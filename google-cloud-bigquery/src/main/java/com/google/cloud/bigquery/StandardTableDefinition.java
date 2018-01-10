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
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * A Google BigQuery default table definition. This definition is used for standard, two-dimensional
 * tables with individual records organized in rows, and a data type assigned to each column (also
 * called a field). Individual fields within a record may contain nested and repeated children
 * fields. Every table is described by a schema that describes field names, types, and other
 * information.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
public class StandardTableDefinition extends TableDefinition {

  private static final long serialVersionUID = 2113445776046717900L;

  private final Long numBytes;
  private final Long numRows;
  private final String location;
  private final StreamingBuffer streamingBuffer;
  private final TimePartitioning timePartitioning;

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

  public static final class Builder
      extends TableDefinition.Builder<StandardTableDefinition, Builder> {

    private Long numBytes;
    private Long numRows;
    private String location;
    private StreamingBuffer streamingBuffer;
    private TimePartitioning timePartitioning;

    private Builder() {
      super(Type.TABLE);
    }

    private Builder(StandardTableDefinition tableDefinition) {
      super(tableDefinition);
      this.numBytes = tableDefinition.numBytes;
      this.numRows = tableDefinition.numRows;
      this.location = tableDefinition.location;
      this.streamingBuffer = tableDefinition.streamingBuffer;
      this.timePartitioning = tableDefinition.timePartitioning;
    }

    private Builder(Table tablePb) {
      super(tablePb);
      if (tablePb.getNumRows() != null) {
        this.setNumRows(tablePb.getNumRows().longValue());
      }
      this.numBytes = tablePb.getNumBytes();
      this.location = tablePb.getLocation();
      if (tablePb.getStreamingBuffer() != null) {
        this.streamingBuffer = StreamingBuffer.fromPb(tablePb.getStreamingBuffer());
      }
      if (tablePb.getTimePartitioning() != null) {
        this.timePartitioning = TimePartitioning.fromPb(tablePb.getTimePartitioning());
      }
    }

    Builder setNumBytes(Long numBytes) {
      this.numBytes = numBytes;
      return self();
    }

    Builder setNumRows(Long numRows) {
      this.numRows = numRows;
      return self();
    }

    Builder setLocation(String location) {
      this.location = location;
      return self();
    }

    Builder setStreamingBuffer(StreamingBuffer streamingBuffer) {
      this.streamingBuffer = streamingBuffer;
      return self();
    }


    /**
     * Sets the time partitioning configuration for the table. If not set, the table is not
     * time-partitioned.
     */
    public Builder setTimePartitioning(TimePartitioning timePartitioning) {
      this.timePartitioning = timePartitioning;
      return this;
    }

    /**
     * Creates a {@code StandardTableDefinition} object.
     */
    @Override
    public StandardTableDefinition build() {
      return new StandardTableDefinition(this);
    }
  }

  private StandardTableDefinition(Builder builder) {
    super(builder);
    this.numBytes = builder.numBytes;
    this.numRows = builder.numRows;
    this.location = builder.location;
    this.streamingBuffer = builder.streamingBuffer;
    this.timePartitioning = builder.timePartitioning;
  }


  /**
   * Returns the size of this table in bytes, excluding any data in the streaming buffer.
   */
  public Long getNumBytes() {
    return numBytes;
  }


  /**
   * Returns the number of rows in this table, excluding any data in the streaming buffer.
   */
  public Long getNumRows() {
    return numRows;
  }


  /**
   * Returns the geographic location where the table should reside. This value is inherited from the
   * dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  public String getLocation() {
    return location;
  }


  /**
   * Returns information on the table's streaming buffer if any exists. Returns {@code null} if no
   * streaming buffer exists.
   */
  public StreamingBuffer getStreamingBuffer() {
    return streamingBuffer;
  }


  /**
   * Returns the time partitioning configuration for this table. If {@code null}, the table is not
   * time-partitioned.
   */
  public TimePartitioning getTimePartitioning() {
    return timePartitioning;
  }


  /**
   * Returns a builder for a BigQuery standard table definition.
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a BigQuery standard table definition given its schema.
   *
   * @param schema the schema of the table
   */
  public static StandardTableDefinition of(Schema schema) {
    return newBuilder().setSchema(schema).build();
  }

  /**
   * Returns a builder for the {@code StandardTableDefinition} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("numBytes", numBytes)
        .add("numRows", numRows)
        .add("location", location)
        .add("streamingBuffer", streamingBuffer)
        .add("timePartitioning", timePartitioning);
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(StandardTableDefinition.class)
        && baseEquals((StandardTableDefinition) obj);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(baseHashCode(), numBytes, numRows, location, streamingBuffer,
        timePartitioning);
  }

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    if (numRows != null) {
      tablePb.setNumRows(BigInteger.valueOf(numRows));
    }
    tablePb.setNumBytes(numBytes);
    tablePb.setLocation(location);
    if (streamingBuffer != null) {
      tablePb.setStreamingBuffer(streamingBuffer.toPb());
    }
    if (timePartitioning != null) {
      tablePb.setTimePartitioning(timePartitioning.toPb());
    }
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static StandardTableDefinition fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }
}
