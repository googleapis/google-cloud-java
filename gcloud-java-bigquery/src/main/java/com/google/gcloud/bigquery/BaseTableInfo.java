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
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Base class for Google BigQuery table information. Use {@link TableInfo} for a simple BigQuery
 * Table. Use {@link ViewInfo} for a BigQuery View Table. Use {@link ExternalTableInfo} for a
 * BigQuery Table backed by external data.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
public abstract class BaseTableInfo implements Serializable {

  static final Function<Table, BaseTableInfo> FROM_PB_FUNCTION =
      new Function<Table, BaseTableInfo>() {
        @Override
        public BaseTableInfo apply(Table pb) {
          return BaseTableInfo.fromPb(pb);
        }
      };
  static final Function<BaseTableInfo, Table> TO_PB_FUNCTION =
      new Function<BaseTableInfo, Table>() {
        @Override
        public Table apply(BaseTableInfo tableInfo) {
          return tableInfo.toPb();
        }
      };

  private static final long serialVersionUID = -7679032506430816205L;

  /**
   * The table type.
   */
  public enum Type {
    /**
     * A normal BigQuery table.
     */
    TABLE,
    /**
     * A virtual table defined by a SQL query.
     *
     * @see <a href="https://cloud.google.com/bigquery/querying-data#views">Views</a>
     */
    VIEW,
    /**
     * A BigQuery table backed by external data.
     *
     * @see <a href="https://cloud.google.com/bigquery/federated-data-sources">Federated Data
     *     Sources</a>
     */
    EXTERNAL
  }

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
  private final Type type;
  private final Schema schema;
  private final String friendlyName;
  private final String description;
  private final Long numBytes;
  private final Long numRows;
  private final Long creationTime;
  private final Long expirationTime;
  private final Long lastModifiedTime;

  public static abstract class Builder<T extends BaseTableInfo, B extends Builder<T, B>> {

    private String etag;
    private String id;
    private String selfLink;
    private TableId tableId;
    private Type type;
    private Schema schema;
    private String friendlyName;
    private String description;
    private Long numBytes;
    private Long numRows;
    private Long creationTime;
    private Long expirationTime;
    private Long lastModifiedTime;

    protected Builder() {}

    protected Builder(BaseTableInfo tableInfo) {
      this.etag = tableInfo.etag;
      this.id = tableInfo.id;
      this.selfLink = tableInfo.selfLink;
      this.tableId = tableInfo.tableId;
      this.type = tableInfo.type;
      this.schema = tableInfo.schema;
      this.friendlyName = tableInfo.friendlyName;
      this.description = tableInfo.description;
      this.numBytes = tableInfo.numBytes;
      this.numRows = tableInfo.numRows;
      this.creationTime = tableInfo.creationTime;
      this.expirationTime = tableInfo.expirationTime;
      this.lastModifiedTime = tableInfo.lastModifiedTime;
    }

    protected Builder(Table tablePb) {
      this.type = Type.valueOf(tablePb.getType());
      this.tableId = TableId.fromPb(tablePb.getTableReference());
      if (tablePb.getSchema() != null) {
        this.schema(Schema.fromPb(tablePb.getSchema()));
      }
      if (tablePb.getLastModifiedTime() != null) {
        this.lastModifiedTime(tablePb.getLastModifiedTime().longValue());
      }
      if (tablePb.getNumRows() != null) {
        this.numRows(tablePb.getNumRows().longValue());
      }
      this.description = tablePb.getDescription();
      this.expirationTime = tablePb.getExpirationTime();
      this.friendlyName = tablePb.getFriendlyName();
      this.creationTime = tablePb.getCreationTime();
      this.etag = tablePb.getEtag();
      this.id = tablePb.getId();
      this.numBytes = tablePb.getNumBytes();
      this.selfLink = tablePb.getSelfLink();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    B creationTime(Long creationTime) {
      this.creationTime = creationTime;
      return self();
    }

    /**
     * Sets a user-friendly description for the table.
     */
    public B description(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return self();
    }

    B etag(String etag) {
      this.etag = etag;
      return self();
    }

    /**
     * Sets the time when this table expires, in milliseconds since the epoch. If not present, the
     * table will persist indefinitely. Expired tables will be deleted and their storage reclaimed.
     */
    public B expirationTime(Long expirationTime) {
      this.expirationTime = firstNonNull(expirationTime, Data.<Long>nullOf(Long.class));
      return self();
    }

    /**
     * Sets a user-friendly name for the table.
     */
    public B friendlyName(String friendlyName) {
      this.friendlyName = firstNonNull(friendlyName, Data.<String>nullOf(String.class));
      return self();
    }

    B id(String id) {
      this.id = id;
      return self();
    }

    B lastModifiedTime(Long lastModifiedTime) {
      this.lastModifiedTime = lastModifiedTime;
      return self();
    }

    B numBytes(Long numBytes) {
      this.numBytes = numBytes;
      return self();
    }

    B numRows(Long numRows) {
      this.numRows = numRows;
      return self();
    }

    B selfLink(String selfLink) {
      this.selfLink = selfLink;
      return self();
    }

    /**
     * Sets the table identity.
     */
    public B tableId(TableId tableId) {
      this.tableId = checkNotNull(tableId);
      return self();
    }

    B type(Type type) {
      this.type = type;
      return self();
    }

    /**
     * Sets the table schema.
     */
    public B schema(Schema schema) {
      this.schema = checkNotNull(schema);
      return self();
    }

    /**
     * Creates an object.
     */
    public abstract T build();
  }

  protected BaseTableInfo(Builder builder) {
    this.tableId = checkNotNull(builder.tableId);
    this.etag = builder.etag;
    this.id = builder.id;
    this.selfLink = builder.selfLink;
    this.friendlyName = builder.friendlyName;
    this.description = builder.description;
    this.type = builder.type;
    this.schema = builder.schema;
    this.numBytes = builder.numBytes;
    this.numRows = builder.numRows;
    this.creationTime = builder.creationTime;
    this.expirationTime = builder.expirationTime;
    this.lastModifiedTime = builder.lastModifiedTime;
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
   * Returns the table's type. If this table is simple table the method returns {@link Type#TABLE}.
   * If this table is an external table this method returns {@link Type#EXTERNAL}. If this table is
   * a view table this method returns {@link Type#VIEW}.
   */
  public Type type() {
    return type;
  }

  /**
   * Returns the table's schema.
   */
  public Schema schema() {
    return schema;
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
   * Returns a builder for the object.
   */
  public abstract Builder toBuilder();

  protected MoreObjects.ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("type", type)
        .add("schema", schema)
        .add("etag", etag)
        .add("id", id)
        .add("selfLink", selfLink)
        .add("friendlyName", friendlyName)
        .add("description", description)
        .add("numBytes", numBytes)
        .add("numRows", numRows)
        .add("expirationTime", expirationTime)
        .add("creationTime", creationTime)
        .add("lastModifiedTime", lastModifiedTime);
  }

  @Override
  public String toString() {
    return toStringHelper().toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof BaseTableInfo && Objects.equals(toPb(), ((BaseTableInfo) obj).toPb());
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
    if (schema != null) {
      tablePb.setSchema(schema.toPb());
    }
    tablePb.setType(type.name());
    tablePb.setCreationTime(creationTime);
    tablePb.setDescription(description);
    tablePb.setEtag(etag);
    tablePb.setExpirationTime(expirationTime);
    tablePb.setFriendlyName(friendlyName);
    tablePb.setId(id);
    tablePb.setNumBytes(numBytes);
    tablePb.setSelfLink(selfLink);
    return tablePb;
  }

  @SuppressWarnings("unchecked")
  static <T extends BaseTableInfo> T fromPb(Table tablePb) {
    switch (Type.valueOf(tablePb.getType())) {
      case TABLE:
        return (T) TableInfo.fromPb(tablePb);
      case VIEW:
        return (T) ViewInfo.fromPb(tablePb);
      case EXTERNAL:
        return (T) ExternalTableInfo.fromPb(tablePb);
      default:
        // never reached
        throw new IllegalArgumentException("Format " + tablePb.getType() + " is not supported");
    }
  }
}
