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

import com.google.auto.value.AutoValue;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/**
 * List of column families to expose in the table schema along with their types. This list restricts
 * the column families that can be referenced in queries and specifies their value types.
 *
 * <p>You can use this list to do type conversions - see the 'type' field for more details. If you
 * leave this list empty, all column families are present in the table schema and their values are
 * read as BYTES. During a query only the column families referenced in that query are read from
 * Bigtable.
 */
@AutoValue
public abstract class BigtableColumnFamily implements Serializable {

  private static final long serialVersionUID = 1L;

  public abstract String getFamilyID();

  public abstract List<BigtableColumn> getColumns();

  public abstract String getEncoding();

  public abstract Boolean getOnlyReadLatest();

  public abstract String getType();

  @AutoValue.Builder
  public abstract static class Builder {

    /** Identifier of the column family. */
    public abstract Builder setFamilyID(String familyID);

    /**
     * Lists of columns that should be exposed as individual fields as opposed to a list of (column
     * name, value) pairs. All columns whose qualifier matches a qualifier in this list can be
     * accessed as .. Other columns can be accessed as a list through .Column field.
     */
    public abstract Builder setColumns(List<BigtableColumn> columns);

    /**
     * The encoding of the values when the type is not STRING.
     *
     * <p>Acceptable encoding values are: TEXT - indicates values are alphanumeric text strings.
     * BINARY - indicates values are encoded using HBase Bytes.toBytes family of functions.
     *
     * <p>This can be overridden for a specific column by listing that column in 'columns' and
     * specifying an encoding for it.
     */
    public abstract Builder setEncoding(String encoding);

    /**
     * If true, only the latest version of values are exposed for all columns in this column family.
     * This can be overridden for a specific column by listing that column in 'columns' and
     * specifying a different setting for that column.
     */
    public abstract Builder setOnlyReadLatest(Boolean onlyReadLatest);

    /**
     * The type to convert the value in cells of this column family. The values are expected to be
     * encoded using HBase Bytes.toBytes function when using the BINARY encoding value.
     *
     * <p>Following BigQuery types are allowed (case-sensitive): BYTES STRING INTEGER FLOAT BOOLEAN.
     *
     * <p>The default type is BYTES. This can be overridden for a specific column by listing that
     * column in 'columns' and specifying a type for it.
     */
    public abstract Builder setType(String type);

    public abstract BigtableColumnFamily build();
  }

  /** Returns a builder for a {@link BigtableColumnFamily} object. */
  public static Builder newBuilder() {
    return new AutoValue_BigtableColumnFamily.Builder();
  }

  static BigtableColumnFamily fromPb(
      com.google.api.services.bigquery.model.BigtableColumnFamily columnFamily) {
    Builder builder = newBuilder();
    builder.setFamilyID(columnFamily.getFamilyId());
    builder.setColumns(Lists.transform(columnFamily.getColumns(), BigtableColumn.FROM_PB_FUNCTION));
    builder.setEncoding(columnFamily.getEncoding());
    builder.setOnlyReadLatest(columnFamily.getOnlyReadLatest());
    builder.setType(columnFamily.getType());
    return builder.build();
  }

  com.google.api.services.bigquery.model.BigtableColumnFamily toPb() {
    com.google.api.services.bigquery.model.BigtableColumnFamily colFamilyPb =
        new com.google.api.services.bigquery.model.BigtableColumnFamily()
            .setFamilyId(getFamilyID())
            .setEncoding(getEncoding())
            .setOnlyReadLatest(getOnlyReadLatest())
            .setType(getType());
    if (getColumns() != null) {
      colFamilyPb.setColumns(Lists.transform(getColumns(), BigtableColumn.TO_PB_FUNCTION));
    }
    return colFamilyPb;
  }

  static final Function<
          com.google.api.services.bigquery.model.BigtableColumnFamily, BigtableColumnFamily>
      FROM_PB_FUNCTION =
          new Function<
              com.google.api.services.bigquery.model.BigtableColumnFamily, BigtableColumnFamily>() {
            @Override
            public BigtableColumnFamily apply(
                com.google.api.services.bigquery.model.BigtableColumnFamily pb) {
              return BigtableColumnFamily.fromPb(pb);
            }
          };

  static final Function<
          BigtableColumnFamily, com.google.api.services.bigquery.model.BigtableColumnFamily>
      TO_PB_FUNCTION =
          new Function<
              BigtableColumnFamily, com.google.api.services.bigquery.model.BigtableColumnFamily>() {
            @Override
            public com.google.api.services.bigquery.model.BigtableColumnFamily apply(
                BigtableColumnFamily columnFamily) {
              return columnFamily.toPb();
            }
          };
}
