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

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;

/**
 * Google BigQuery table information. Use {@link StandardTableDefinition} to create simple BigQuery
 * table. Use {@link ViewDefinition} to create a BigQuery view. Use {@link ExternalTableDefinition}
 * to create a BigQuery a table backed by external data.
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

  private static final long serialVersionUID = 609769795097719407L;

  private final String etag;
  private final String generatedId;
  private final String selfLink;
  private final TableId tableId;
  private final String friendlyName;
  private final String description;
  private final Long creationTime;
  private final Long expirationTime;
  private final Long lastModifiedTime;
  private final TableDefinition definition;

  /**
   * A builder for {@code TableInfo} objects.
   */
  public abstract static class Builder {

    abstract Builder creationTime(Long creationTime);

    /**
     * Sets a user-friendly description for the table.
     */
    public abstract Builder description(String description);

    abstract Builder etag(String etag);

    /**
     * Sets the time when this table expires, in milliseconds since the epoch. If not present, the
     * table will persist indefinitely. Expired tables will be deleted and their storage reclaimed.
     */
    public abstract Builder expirationTime(Long expirationTime);

    /**
     * Sets a user-friendly name for the table.
     */
    public abstract Builder friendlyName(String friendlyName);

    abstract Builder generatedId(String generatedId);

    abstract Builder lastModifiedTime(Long lastModifiedTime);

    abstract Builder selfLink(String selfLink);

    /**
     * Sets the table identity.
     */
    public abstract Builder tableId(TableId tableId);

    /**
     * Sets the table definition. Use {@link StandardTableDefinition} to create simple BigQuery
     * table. Use {@link ViewDefinition} to create a BigQuery view. Use
     * {@link ExternalTableDefinition} to create a BigQuery a table backed by external data.
     */
    public abstract Builder definition(TableDefinition definition);

    /**
     * Creates a {@code TableInfo} object.
     */
    public abstract TableInfo build();
  }

  static class BuilderImpl extends Builder {

    private String etag;
    private String generatedId;
    private String selfLink;
    private TableId tableId;
    private String friendlyName;
    private String description;
    private Long creationTime;
    private Long expirationTime;
    private Long lastModifiedTime;
    private TableDefinition definition;

    BuilderImpl() {}

    BuilderImpl(TableInfo tableInfo) {
      this.etag = tableInfo.etag;
      this.generatedId = tableInfo.generatedId;
      this.selfLink = tableInfo.selfLink;
      this.tableId = tableInfo.tableId;
      this.friendlyName = tableInfo.friendlyName;
      this.description = tableInfo.description;
      this.creationTime = tableInfo.creationTime;
      this.expirationTime = tableInfo.expirationTime;
      this.lastModifiedTime = tableInfo.lastModifiedTime;
      this.definition = tableInfo.definition;
    }

    BuilderImpl(Table tablePb) {
      this.tableId = TableId.fromPb(tablePb.getTableReference());
      if (tablePb.getLastModifiedTime() != null) {
        this.lastModifiedTime(tablePb.getLastModifiedTime().longValue());
      }
      this.description = tablePb.getDescription();
      this.expirationTime = tablePb.getExpirationTime();
      this.friendlyName = tablePb.getFriendlyName();
      this.creationTime = tablePb.getCreationTime();
      this.etag = tablePb.getEtag();
      this.generatedId = tablePb.getId();
      this.selfLink = tablePb.getSelfLink();
      this.definition = TableDefinition.fromPb(tablePb);
    }

    @Override
    Builder creationTime(Long creationTime) {
      this.creationTime = creationTime;
      return this;
    }

    @Override
    public Builder description(String description) {
      this.description = firstNonNull(description, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder etag(String etag) {
      this.etag = etag;
      return this;
    }

    @Override
    public Builder expirationTime(Long expirationTime) {
      this.expirationTime = firstNonNull(expirationTime, Data.<Long>nullOf(Long.class));
      return this;
    }

    @Override
    public Builder friendlyName(String friendlyName) {
      this.friendlyName = firstNonNull(friendlyName, Data.<String>nullOf(String.class));
      return this;
    }

    @Override
    Builder generatedId(String generatedId) {
      this.generatedId = generatedId;
      return this;
    }

    @Override
    Builder lastModifiedTime(Long lastModifiedTime) {
      this.lastModifiedTime = lastModifiedTime;
      return this;
    }

    @Override
    Builder selfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    @Override
    public Builder tableId(TableId tableId) {
      this.tableId = checkNotNull(tableId);
      return this;
    }

    @Override
    public Builder definition(TableDefinition definition) {
      this.definition = checkNotNull(definition);
      return this;
    }

    @Override
    public TableInfo build() {
      return new TableInfo(this);
    }
  }

  TableInfo(BuilderImpl builder) {
    this.tableId = checkNotNull(builder.tableId);
    this.etag = builder.etag;
    this.generatedId = builder.generatedId;
    this.selfLink = builder.selfLink;
    this.friendlyName = builder.friendlyName;
    this.description = builder.description;
    this.creationTime = builder.creationTime;
    this.expirationTime = builder.expirationTime;
    this.lastModifiedTime = builder.lastModifiedTime;
    this.definition = builder.definition;
  }

  /**
   * Returns the hash of the table resource.
   */
  public String etag() {
    return etag;
  }

  /**
   * Returns the service-generated id for the table.
   */
  public String generatedId() {
    return generatedId;
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
   * Returns the table definition.
   */
  @SuppressWarnings("unchecked")
  public <T extends TableDefinition> T definition() {
    return (T) definition;
  }

  /**
   * Returns a builder for the table object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("tableId", tableId)
        .add("etag", etag)
        .add("generatedId", generatedId)
        .add("selfLink", selfLink)
        .add("friendlyName", friendlyName)
        .add("description", description)
        .add("expirationTime", expirationTime)
        .add("creationTime", creationTime)
        .add("lastModifiedTime", lastModifiedTime)
        .add("definition", definition)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(tableId);
  }

  @Override
  public boolean equals(Object obj) {
    return obj != null
        && obj.getClass().equals(TableInfo.class)
        && Objects.equals(toPb(), ((TableInfo) obj).toPb());
  }

  /**
   * Returns a builder for a {@code TableInfo} object given table identity and definition. Use
   * {@link StandardTableDefinition} to create simple BigQuery table. Use {@link ViewDefinition} to
   * create a BigQuery view. Use {@link ExternalTableDefinition} to create a BigQuery a table backed
   * by external data.
   */
  public static Builder builder(TableId tableId, TableDefinition definition) {
    return new BuilderImpl().tableId(tableId).definition(definition);
  }

  /**
   * Returns a {@code TableInfo} object given table identity and definition. Use
   * {@link StandardTableDefinition} to create simple BigQuery table. Use {@link ViewDefinition} to
   * create a BigQuery view. Use {@link ExternalTableDefinition} to create a BigQuery a table backed
   * by external data.
   */
  public static TableInfo of(TableId tableId, TableDefinition definition) {
    return builder(tableId, definition).build();
  }

  TableInfo setProjectId(String projectId) {
    return toBuilder().tableId(tableId().setProjectId(projectId)).build();
  }

  Table toPb() {
    Table tablePb = definition.toPb();
    tablePb.setTableReference(tableId.toPb());
    if (lastModifiedTime != null) {
      tablePb.setLastModifiedTime(BigInteger.valueOf(lastModifiedTime));
    }
    tablePb.setCreationTime(creationTime);
    tablePb.setDescription(description);
    tablePb.setEtag(etag);
    tablePb.setExpirationTime(expirationTime);
    tablePb.setFriendlyName(friendlyName);
    tablePb.setId(generatedId);
    tablePb.setSelfLink(selfLink);
    return tablePb;
  }

  static TableInfo fromPb(Table tablePb) {
    return new BuilderImpl(tablePb).build();
  }
}
