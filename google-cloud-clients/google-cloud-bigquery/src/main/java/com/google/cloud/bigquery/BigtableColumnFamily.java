/*
 * Copyright 2018 Google LLC
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


import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * List of column families to expose in the table schema along with their types. This list restricts
 * the column families that can be referenced in queries and specifies their value types.
 *
 * You can use this list to do type conversions - see the 'type' field for more details. If you
 * leave this list empty, all column families are present in the table schema and their values are
 * read as BYTES. During a query only the column families referenced in that query are read from
 * Bigtable.
 */


public class BigtableColumnFamily implements Serializable {

  static final Function<com.google.api.services.bigquery.model.BigtableColumnFamily, BigtableColumnFamily> FROM_PB_FUNCTION =
      new Function<com.google.api.services.bigquery.model.BigtableColumnFamily, BigtableColumnFamily>() {
        @Override
        public BigtableColumnFamily apply(
            com.google.api.services.bigquery.model.BigtableColumnFamily pb) {
          return BigtableColumnFamily.fromPb(pb);
        }
      };

  static final Function<BigtableColumnFamily, com.google.api.services.bigquery.model.BigtableColumnFamily> TO_PB_FUNCTION =
      new Function<BigtableColumnFamily, com.google.api.services.bigquery.model.BigtableColumnFamily>() {
        @Override
        public com.google.api.services.bigquery.model.BigtableColumnFamily apply(
            BigtableColumnFamily columnFamily) {
          return columnFamily.toPb();
        }
      };

  private static final long serialVersionUID = 1L;

  public String getFamilyID() {
    return familyID;
  }

  public List<BigtableColumn> getColumns() {
    return columns;
  }

  public String getEncoding() {
    return encoding;
  }

  public Boolean getOnlyReadLatest() {
    return onlyReadLatest;
  }

  public String getType() {
    return type;
  }

  private final String familyID;
  private final List<BigtableColumn> columns;
  private final String encoding;
  private final Boolean onlyReadLatest;
  private final String type;

  static final class Builder {

    private String familyID;
    private List<BigtableColumn> columns;
    private String encoding;
    private Boolean onlyReadLatest;
    private String type;

    private Builder() {
    }

    /**
     * Identifier of the column family.
     */
    Builder setFamilyID(String familyID) {
      this.familyID = familyID;
      return this;
    }

    /**
     * Lists of columns that should be exposed as individual fields as opposed to a list of (column
     * name, value) pairs. All columns whose qualifier matches a qualifier in this list can be
     * accessed as .. Other columns can be accessed as a list through .Column field.
     */
    Builder setColumns(List<BigtableColumn> columns) {
      this.columns = columns;
      return this;
    }

    /**
     * The encoding of the values when the type is not STRING.
     *
     * Acceptable encoding values are: TEXT - indicates values are alphanumeric text strings. BINARY
     * - indicates values are encoded using HBase Bytes.toBytes family of functions.
     *
     * This can be overridden for a specific column by listing that column in 'columns' and
     * specifying an encoding for it.
     */
    Builder setEncoding(String encoding) {
      this.encoding = encoding;
      return this;
    }

    /**
     * If true, only the latest version of values are exposed for all columns in this column family.
     * This can be overridden for a specific column by listing that column in 'columns' and
     * specifying a different setting for that column.
     */
    Builder setOnlyReadLatest(Boolean onlyReadLatest) {
      this.onlyReadLatest = onlyReadLatest;
      return this;
    }

    /**
     * The type to convert the value in cells of this column family. The values are expected to be
     * encoded using HBase Bytes.toBytes function when using the BINARY encoding value.
     *
     * Following BigQuery types are allowed (case-sensitive): BYTES STRING INTEGER FLOAT BOOLEAN.
     *
     * The default type is BYTES. This can be overridden for a specific column by listing that
     * column in 'columns' and specifying a type for it.
     */
    Builder setType(String type) {
      this.type = type;
      return this;
    }

    BigtableColumnFamily build() {
      return new BigtableColumnFamily(this);
    }
  }


  BigtableColumnFamily(Builder builder) {
    familyID = builder.familyID;
    columns = builder.columns;
    encoding = builder.encoding;
    onlyReadLatest = builder.onlyReadLatest;
    type = builder.type;

  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("familyID", familyID)
        .add("columns", columns)
        .add("encoding", encoding)
        .add("onlyReadLatest", onlyReadLatest)
        .add("type", type)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(
        familyID,
        columns,
        encoding,
        onlyReadLatest,
        type);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(BigtableColumnFamily.class)) {
      return false;
    }
    BigtableColumnFamily other = (BigtableColumnFamily) obj;
    return familyID == other.familyID
        && encoding == other.encoding
        && onlyReadLatest == other.onlyReadLatest
        && type == other.type
        && Objects.equals(columns, other.columns);
  }

  static Builder newBuilder() {
    return new Builder();
  }


  static BigtableColumnFamily fromPb(
      com.google.api.services.bigquery.model.BigtableColumnFamily columnFamily) {
    Builder builder = new BigtableColumnFamily.Builder();
    builder.setFamilyID(columnFamily.getFamilyId());
    builder.setColumns(Lists.transform(columnFamily.getColumns(), BigtableColumn.FROM_PB_FUNCTION));
    builder.setEncoding(columnFamily.getEncoding());
    builder.setOnlyReadLatest(columnFamily.getOnlyReadLatest());
    builder.setType(columnFamily.getType());
    return builder.build();

  }

  com.google.api.services.bigquery.model.BigtableColumnFamily toPb() {
    com.google.api.services.bigquery.model.BigtableColumnFamily colFamilyPb = new com.google.api.services.bigquery.model.BigtableColumnFamily()
        .setFamilyId(familyID)
        .setEncoding(encoding)
        .setOnlyReadLatest(onlyReadLatest)
        .setType(type);
    if (columns != null) {
      colFamilyPb.setColumns(Lists.transform(columns, BigtableColumn.TO_PB_FUNCTION));
    }
    return colFamilyPb;
  }
}



