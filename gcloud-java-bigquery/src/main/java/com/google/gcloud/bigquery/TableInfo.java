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

import com.google.api.services.bigquery.model.Table;
import com.google.common.base.MoreObjects;

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

  public static final class Builder extends BaseTableInfo.Builder<TableInfo, Builder> {

    private String location;
    private StreamingBuffer streamingBuffer;

    private Builder() {}

    private Builder(TableInfo tableInfo) {
      super(tableInfo);
      this.location = tableInfo.location;
      this.streamingBuffer = tableInfo.streamingBuffer;
    }

    @Override
    protected Builder self() {
      return this;
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
   * Creates BigQuery table given its type
   *
   * @param tableId table id
   * @param schema the schema of the table
   */
  public static BaseTableInfo of(TableId tableId, Schema schema) {
    return builder(tableId, schema).build();
  }

  /**
   * Returns a builder for the {@code ExternalTableInfo} object.
   */
  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  protected MoreObjects.ToStringHelper toStringHelper() {
    return super.toStringHelper()
        .add("location", location)
        .add("streamingBuffer", streamingBuffer);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableInfo
        && Objects.equals(toPb(), ((TableInfo) obj).toPb());
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
}
