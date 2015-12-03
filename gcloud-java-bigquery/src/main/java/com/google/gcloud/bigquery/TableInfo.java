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

import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.util.Data;
import com.google.api.services.bigquery.model.Streamingbuffer;
import com.google.api.services.bigquery.model.Table;
import com.google.api.services.bigquery.model.ViewDefinition;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;

/**
 * Google BigQuery Table information. A BigQuery table is a standard, two-dimensional table with
 * individual records organized in rows, and a data type assigned to each column (also called a
 * field). Individual fields within a record may contain nested and repeated children fields. Every
 * table is described by a schema that describes field names, types, and other information.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
public class TableInfo implements Serializable {

  static final Function<Table, TableInfo> FROM_PB_FUNCTION =
      new Function<Table, TableInfo>() {
        @Override
        public TableInfo apply(Table pb) {
          return TableInfo.fromPb(pb);
        }
      };
  static final Function<TableInfo, Table> TO_PB_FUNCTION =
      new Function<TableInfo, Table>() {
        @Override
        public Table apply(TableInfo tableInfo) {
          return tableInfo.toPb();
        }
      };

  private static final long serialVersionUID = -7679032506430816205L;

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

    public Streamingbuffer toPb() {
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

  private final String etag;
  private final String id;
  private final String selfLink;
  private final TableId tableId;
  private final TableType type;
  private final String friendlyName;
  private final String description;
  private final Long numBytes;
  private final Long numRows;
  private final Long creationTime;
  private final Long expirationTime;
  private final Long lastModifiedTime;
  private final String location;
  private final StreamingBuffer streamingBuffer;

  public static final class Builder {

    private String etag;
    private String id;
    private String selfLink;
    private TableId tableId;
    private TableType type;
    private String friendlyName;
    private String description;
    private Long numBytes;
    private Long numRows;
    private Long creationTime;
    private Long expirationTime;
    private Long lastModifiedTime;
    private String location;
    private StreamingBuffer streamingBuffer;

    private Builder() {}

    private Builder(TableInfo tableInfo) {
      this.etag = tableInfo.etag;
      this.id = tableInfo.id;
      this.selfLink = tableInfo.selfLink;
      this.tableId = tableInfo.tableId;
      this.type = tableInfo.type;
      this.friendlyName = tableInfo.friendlyName;
      this.description = tableInfo.description;
      this.numBytes = tableInfo.numBytes;
      this.numRows = tableInfo.numRows;
      this.creationTime = tableInfo.creationTime;
      this.expirationTime = tableInfo.expirationTime;
      this.lastModifiedTime = tableInfo.lastModifiedTime;
      this.location = tableInfo.location;
      this.streamingBuffer = tableInfo.streamingBuffer;
    }

    Builder creationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    /**
     * Sets a user-friendly description for the table.
     */
    public Builder description(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    /**
     * Sets the time when this table expires, in milliseconds since the epoch. If not present, the
     * table will persist indefinitely. Expired tables will be deleted and their storage reclaimed.
     */
    public Builder expirationTime(Long expirationTime) {
      this.expirationTime = firstNonNull(expirationTime, Data.<Long>nullOf(Long.class));
      return this;
    }

    /**
     * Sets a user-friendly name for the table.
     */
    public Builder friendlyName(String friendlyName) {
      this.friendlyName = firstNonNull(friendlyName, Data.<String>nullOf(String.class));
      return this;
    }

    Builder id(String id) {
      this.id = id;
      return this;
    }

    Builder lastModifiedTime(Long lastModifiedTime) {
      this.lastModifiedTime = lastModifiedTime;
      return this;
    }

    Builder location(String location) {
      this.location = location;
      return this;
    }

    Builder numBytes(Long numBytes) {
      this.numBytes = numBytes;
      return this;
    }

    Builder numRows(Long numRows) {
      this.numRows = numRows;
      return this;
    }

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    Builder streamingBuffer(StreamingBuffer streamingBuffer) {
      this.streamingBuffer = streamingBuffer;
      return this;
    }

    /**
     * Sets the table identity.
     */
    public Builder tableId(TableId tableId) {
      this.tableId = tableId;
      return this;
    }

    /**
     * Sets the table type.
     */
    public Builder type(TableType type) {
      this.type = type;
      return this;
    }

    /**
     * Creates a {@code TableInfo} object.
     */
    public TableInfo build() {
      return new TableInfo(this);
    }
  }

  private TableInfo(Builder builder) {
    this.tableId = checkNotNull(builder.tableId);
    this.etag = builder.etag;
    this.id = builder.id;
    this.selfLink = builder.selfLink;
    this.friendlyName = builder.friendlyName;
    this.description = builder.description;
    this.type = builder.type;
    this.numBytes = builder.numBytes;
    this.numRows = builder.numRows;
    this.creationTime = builder.creationTime;
    this.expirationTime = builder.expirationTime;
    this.lastModifiedTime = builder.lastModifiedTime;
    this.location = builder.location;
    this.streamingBuffer = builder.streamingBuffer;
  }

  /**
   * Returns the hash of the table resource.
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns an opaque id for the table.
   */
  public String id() {
    return id;
  }

  /**
   * Returns an URL that can be used to access the resource again. The returned URL can be used for
   * get or update requests.
   */
  public String selfLink() {
    return selfLink;
  }

  /**
   * Returns the table identity.
   */
  public TableId tableId() {
    return tableId;
  }

  /**
   * Returns a user-friendly name for the table.
   */
  public String friendlyName() {
    return Data.isNull(friendlyName) ? null : friendlyName;
  }

  /**
   * Returns a user-friendly description for the table.
   */
  public String description() {
    return Data.isNull(description) ? null : description;
  }

  /**
   * Returns the size of this table in bytes, excluding any data in the streaming buffer.
   */
  public Long numBytes() {
    return numBytes;
  }

  /**
   * Returns the number of rows in this table, excluding any data in the streaming buffer.
   */
  public Long numRows() {
    return numRows;
  }

  /**
   * Returns the time when this table was created, in milliseconds since the epoch.
   */
  public Long creationTime() {
    return creationTime;
  }

  /**
   * Returns the time when this table expires, in milliseconds since the epoch. If not present, the
   * table will persist indefinitely. Expired tables will be deleted and their storage reclaimed.
   */
  public Long expirationTime() {
    return Data.isNull(expirationTime) ? null : expirationTime;
  }

  /**
   * Returns the time when this table was last modified, in milliseconds since the epoch.
   */
  public Long lastModifiedTime() {
    return lastModifiedTime;
  }

  /**
   * Returns the type of the table.
   */
  public Schema schema() {
    return type.schema();
  }

  /**
   * Returns the table's type. If this table is simple table the method returns an instance of
   * {@link TableType}. If this table is an external table this method returns an instance of
   * {@link com.google.gcloud.bigquery.TableType.ExternalTable}. If this table is a view table this
   * method returns an instance of {@link com.google.gcloud.bigquery.TableType.View}.
   */
  @SuppressWarnings("unchecked")
  public <T extends TableType> T type() {
    return (T) type;
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
   * Returns a builder for the {@code TableInfo} object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("type", type)
        .add("location", location)
        .add("streamingBuffer", streamingBuffer)
        .add("etag", etag)
        .add("id", id)
        .add("selfLink", selfLink)
        .add("friendlyName", friendlyName)
        .add("description", description)
        .add("numBytes", numBytes)
        .add("numRows", numRows)
        .add("expirationTime", expirationTime)
        .add("creationTime", creationTime)
        .add("lastModifiedTime", lastModifiedTime)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TableInfo && Objects.equals(toPb(), ((TableInfo) obj).toPb());
  }

  Table toPb() {
    Table tablePb = new Table();
    tablePb.setTableReference(tableId.toPb());
    if (lastModifiedTime != null) {
      tablePb.setLastModifiedTime(BigInteger.valueOf(lastModifiedTime));
    }
    if (numRows != null) {
      tablePb.setNumRows(BigInteger.valueOf(numRows));
    }
    if (schema() != null) {
      tablePb.setSchema(schema().toPb());
    }
    if (type instanceof TableType.View) {
      TableType.View viewType = (TableType.View) type;
      ViewDefinition viewDefinition = new ViewDefinition().setQuery(viewType.query());
      if (viewType.userDefinedFunctions() != null) {
        viewDefinition.setUserDefinedFunctionResources(
            Lists.transform(viewType.userDefinedFunctions(), UserDefinedFunction.TO_PB_FUNCTION));
      }
      tablePb.setView(viewDefinition);
    }
    if (type instanceof TableType.ExternalTable) {
      tablePb.setExternalDataConfiguration(
          ((TableType.ExternalTable) type).configuration().toPb());
    }
    if (streamingBuffer != null) {
      tablePb.setStreamingBuffer(streamingBuffer.toPb());
    }
    tablePb.setCreationTime(creationTime);
    tablePb.setDescription(description);
    tablePb.setEtag(etag);
    tablePb.setExpirationTime(expirationTime);
    tablePb.setFriendlyName(friendlyName);
    tablePb.setId(id);
    tablePb.setLocation(location);
    tablePb.setNumBytes(numBytes);
    tablePb.setSelfLink(selfLink);
    return tablePb;
  }

  /**
   * Returns a builder for a BigQuery table given its type.
   *
   * @param tableId table id
   * @param type the type of the table
   */
  public static Builder builder(TableId tableId, TableType type) {
    return new Builder().tableId(tableId).type(type);
  }

  /**
   * Creates BigQuery table given its type
   *
   * @param tableId table id
   * @param type the type of the table
   */
  public static TableInfo of(TableId tableId, TableType type) {
    return builder(tableId, type).build();
  }

  static TableInfo fromPb(Table tablePb) {
    Builder builder = new Builder().tableId(TableId.fromPb(tablePb.getTableReference()));
    Schema schema = null;
    if (tablePb.getSchema() != null) {
      schema = Schema.fromPb(tablePb.getSchema());
      builder.type(TableType.table(schema));
    }
    if (tablePb.getDescription() != null) {
      builder.description(tablePb.getDescription());
    }
    if (tablePb.getExpirationTime() != null) {
      builder.expirationTime(tablePb.getExpirationTime());
    }
    if (tablePb.getFriendlyName() != null) {
      builder.friendlyName(tablePb.getFriendlyName());
    }
    if (tablePb.getLastModifiedTime() != null) {
      builder.lastModifiedTime(tablePb.getLastModifiedTime().longValue());
    }
    if (tablePb.getLocation() != null) {
      builder.location(tablePb.getLocation());
    }
    if (tablePb.getNumRows() != null) {
      builder.numRows(tablePb.getNumRows().longValue());
    }
    if (tablePb.getStreamingBuffer() != null) {
      builder.streamingBuffer(StreamingBuffer.fromPb(tablePb.getStreamingBuffer()));
    }
    if (tablePb.getView() != null) {
      String query = tablePb.getView().getQuery();
      List<UserDefinedFunction> functions = null;
      if (tablePb.getView().getUserDefinedFunctionResources() != null) {
        functions = Lists.transform(tablePb.getView().getUserDefinedFunctionResources(),
                UserDefinedFunction.FROM_PB_FUNCTION);
      }
      builder.type(new TableType.View(schema, query, functions));
    }
    if (tablePb.getExternalDataConfiguration() != null) {
      ExternalDataConfiguration configuration =
          ExternalDataConfiguration.fromPb(tablePb.getExternalDataConfiguration());
      builder.type(new TableType.ExternalTable(schema, configuration));
    }
    if (tablePb.getCreationTime() != null) {
      builder.creationTime(tablePb.getCreationTime());
    }
    if (tablePb.getEtag() != null) {
      builder.etag(tablePb.getEtag());
    }
    if (tablePb.getId() != null) {
      builder.id(tablePb.getId());
    }
    if (tablePb.getNumBytes() != null) {
      builder.numBytes(tablePb.getNumBytes());
    }
    if (tablePb.getSelfLink() != null) {
      builder.selfLink(tablePb.getSelfLink());
    }
    return builder.build();
  }
}
