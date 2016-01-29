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
import com.google.api.services.bigquery.model.Table;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Google BigQuery table information. Use {@link DefaultTableType} to create simple BigQuery table.
 * Use {@link ViewType} to create a BigQuery view. Use {@link ExternalTableType} to create a
 * BigQuery a table backed by external data.
 *
 * @see <a href="https://cloud.google.com/bigquery/docs/tables">Managing Tables</a>
 */
public final class TableInfo implements Serializable {

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

  private final String etag;
  private final String id;
  private final String selfLink;
  private final TableId tableId;
  private final String friendlyName;
  private final String description;
  private final Long creationTime;
  private final Long expirationTime;
  private final Long lastModifiedTime;
  private final BaseTableType type;

  /**
   * Builder for tables.
   */
  public static class Builder {

    private String etag;
    private String id;
    private String selfLink;
    private TableId tableId;
    private String friendlyName;
    private String description;
    private Long creationTime;
    private Long expirationTime;
    private Long lastModifiedTime;
    private BaseTableType type;

    private Builder() {}

    private Builder(TableInfo tableInfo) {
      this.etag = tableInfo.etag;
      this.id = tableInfo.id;
      this.selfLink = tableInfo.selfLink;
      this.tableId = tableInfo.tableId;
      this.friendlyName = tableInfo.friendlyName;
      this.description = tableInfo.description;
      this.creationTime = tableInfo.creationTime;
      this.expirationTime = tableInfo.expirationTime;
      this.lastModifiedTime = tableInfo.lastModifiedTime;
      this.type = tableInfo.type;
    }

    private Builder(Table tablePb) {
      this.tableId = TableId.fromPb(tablePb.getTableReference());
      if (tablePb.getLastModifiedTime() != null) {
        this.lastModifiedTime(tablePb.getLastModifiedTime().longValue());
      }
      this.description = tablePb.getDescription();
      this.expirationTime = tablePb.getExpirationTime();
      this.friendlyName = tablePb.getFriendlyName();
      this.creationTime = tablePb.getCreationTime();
      this.etag = tablePb.getEtag();
      this.id = tablePb.getId();
      this.selfLink = tablePb.getSelfLink();
      this.type = BaseTableType.fromPb(tablePb);
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

    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * Sets the table identity.
     */
    public Builder tableId(TableId tableId) {
      this.tableId = checkNotNull(tableId);
      return this;
    }

    /**
     * Sets the table type.
     */
    public Builder type(BaseTableType type) {
      this.type = checkNotNull(type);
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
    this.creationTime = builder.creationTime;
    this.expirationTime = builder.expirationTime;
    this.lastModifiedTime = builder.lastModifiedTime;
    this.type = builder.type;
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
   * Returns the table type.
   */
  @SuppressWarnings("unchecked")
  public <T extends BaseTableType> T type() {
    return (T) type;
  }

  /**
   * Returns a builder for the object.
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  ToStringHelper toStringHelper() {
    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("etag", etag)
        .add("id", id)
        .add("selfLink", selfLink)
        .add("friendlyName", friendlyName)
        .add("description", description)
        .add("expirationTime", expirationTime)
        .add("creationTime", creationTime)
        .add("lastModifiedTime", lastModifiedTime)
        .add("type", type);
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
    return obj instanceof TableInfo && Objects.equals(toPb(), ((TableInfo) obj).toPb());
  }

  /**
   * Returns a builder for a {@code TableInfo} object given table identity and type.
   */
  public static Builder builder(TableId tableId, BaseTableType type) {
    return new Builder().tableId(tableId).type(type);
  }

  /**
   * Returns a {@code TableInfo} object given table identity and type.
   */
  public static TableInfo of(TableId tableId, BaseTableType type) {
    return builder(tableId, type).build();
  }

  TableInfo setProjectId(String projectId) {
    return toBuilder().tableId(tableId().setProjectId(projectId)).build();
  }

  Table toPb() {
    Table tablePb = type.toPb();
    tablePb.setTableReference(tableId.toPb());
    if (lastModifiedTime != null) {
      tablePb.setLastModifiedTime(BigInteger.valueOf(lastModifiedTime));
    }
    tablePb.setCreationTime(creationTime);
    tablePb.setDescription(description);
    tablePb.setEtag(etag);
    tablePb.setExpirationTime(expirationTime);
    tablePb.setFriendlyName(friendlyName);
    tablePb.setId(id);
    tablePb.setSelfLink(selfLink);
    return tablePb;
  }

  static TableInfo fromPb(Table tablePb) {
    return new Builder(tablePb).build();
  }
}
