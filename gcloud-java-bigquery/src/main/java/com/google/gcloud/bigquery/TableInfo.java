/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.bigquery;

import com.google.api.services.bigquery.model.Streamingbuffer;
import com.google.api.services.bigquery.model.Table;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * A Google BigQuery Table information. A BigQuery table is a standard, two-dimensional table with
 * individual records organized in rows, and a data type assigned to each column (also called a
 * field). Individual fields within a record may contain nested and repeated children fields. Every
 * table is described by a schema that describes field names, types, and other information.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
public class TableInfo extends BaseTableInfo {

  private static final long serialVersionUID = -5910575573063546949L;

  private final String location;
  private final StreamingBuffer streamingBuffer;

  /**
   * Google BigQuery Table's Streaming Buffer information. This class contains information on a
   * table's streaming buffer as the estimated size in number of rows/bytes.
   */
  public static class StreamingBuffer implements Serializable {

    private static final long serialVersionUID = -6713971364725267597L;
    private final long estimatedRows;
    private final long estimatedBytes;
    private final long oldestEntryTime;

    StreamingBuffer(long estimatedRows, long estimatedBytes, long oldestEntryTime) {
      this.estimatedRows = estimatedRows;
      this.estimatedBytes = estimatedBytes;
      this.oldestEntryTime = oldestEntryTime;
    }

    /**
     * Returns a lower-bound estimate of the number of rows currently in the streaming buffer.
     */
    public long estimatedRows() {
      return estimatedRows;
    }

    /**
     * Returns a lower-bound estimate of the number of bytes currently in the streaming buffer.
     */
    public long estimatedBytes() {
      return estimatedBytes;
    }

    /**
     * Returns the timestamp of the oldest entry in the streaming buffer, in milliseconds since
     * epoch.
     */
    public long oldestEntryTime() {
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
      return new StreamingBuffer(streamingBufferPb.getEstimatedRows().longValue(),
          streamingBufferPb.getEstimatedBytes().longValue(),
          streamingBufferPb.getOldestEntryTime().longValue());
    }
  }

  public static final class Builder extends BaseTableInfo.Builder<TableInfo, Builder> {

    private String location;
    private StreamingBuffer streamingBuffer;

    private Builder() {}

    private Builder(TableInfo tableInfo) {
      super(tableInfo);
      this.location = tableInfo.location;
      this.streamingBuffer = tableInfo.streamingBuffer;
    }

    protected Builder(Table tablePb) {
      super(tablePb);
      this.location = tablePb.getLocation();
      if (tablePb.getStreamingBuffer() != null) {
        this.streamingBuffer = StreamingBuffer.fromPb(tablePb.getStreamingBuffer());
      }
    }

    Builder location(String location) {
      this.location = location;
      return self();
    }

    Builder streamingBuffer(StreamingBuffer streamingBuffer) {
      this.streamingBuffer = streamingBuffer;
      return self();
    }

    /**
     * Creates a {@code TableInfo} object.
     */
    @Override
    public TableInfo build() {
      return new TableInfo(this);
    }
  }

  private TableInfo(Builder builder) {
    super(builder);
    this.location = builder.location;
    this.streamingBuffer = builder.streamingBuffer;
  }

  /**
   * Returns the geographic location where the table should reside. This value is inherited from the
   * dataset.
   *
   * @see <a href="https://cloud.google.com/bigquery/docs/managing_jobs_datasets_projects#dataset-location">
   *     Dataset Location</a>
   */
  public String location() {
    return location;
  }

  /**
   * Returns information on the table's streaming buffer if any exists. Returns {@code null} if no
   * streaming buffer exists.
   */
  public StreamingBuffer streamingBuffer() {
    return streamingBuffer;
  }

  /**
   * Returns a builder for a BigQuery Table.
   *
   * @param tableId table id
   * @param schema the schema of the table
   */
  public static Builder builder(TableId tableId, Schema schema) {
    return new Builder().tableId(tableId).type(Type.TABLE).schema(schema);
  }

  /**
   * Creates BigQuery table given its type.
   *
   * @param tableId table id
   * @param schema the schema of the table
   */
  public static TableInfo of(TableId tableId, Schema schema) {
    return builder(tableId, schema).build();
  }

  /**
   * Returns a builder for the {@code TableInfo} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("location", location)
        .add("streamingBuffer", streamingBuffer);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableInfo && baseEquals((TableInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseHashCode(), location, streamingBuffer);
  }

  @Override
  Table toPb() {
    Table tablePb = super.toPb();
    tablePb.setLocation(location);
    if (streamingBuffer != null) {
      tablePb.setStreamingBuffer(streamingBuffer.toPb());
    }
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static TableInfo fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }
}
