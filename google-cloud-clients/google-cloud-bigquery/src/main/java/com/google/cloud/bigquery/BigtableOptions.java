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

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Objects;

public class BigtableOptions extends FormatOptions {

  private static final long serialVersionUID = 1L;

  private final Boolean ignoreUnspecifiedColumnFamilies;
  private final Boolean readRowkeyAsString;
  private final List<BigtableColumnFamily> columnFamilies;

  public Boolean getIgnoreUnspecifiedColumnFamilies() {
    return ignoreUnspecifiedColumnFamilies;
  }

  public Boolean getReadRowkeyAsString() {
    return readRowkeyAsString;
  }

  public List<BigtableColumnFamily> getColumnFamilies() {
    return columnFamilies;
  }

  static final class Builder {

    private Boolean ignoreUnspecifiedColumnFamilies;
    private Boolean readRowkeyAsString;
    private List<BigtableColumnFamily> columnFamilies;

    private Builder() {}

    private Builder(BigtableOptions bigtableOptions) {
      this.ignoreUnspecifiedColumnFamilies = bigtableOptions.ignoreUnspecifiedColumnFamilies;
      this.readRowkeyAsString = bigtableOptions.readRowkeyAsString;
      this.columnFamilies = bigtableOptions.columnFamilies;
    }

    /**
     * If field is true, then the column families that are not specified in columnFamilies list are
     * not exposed in the table schema. Otherwise, they are read with BYTES type values. The default
     * value is false.
     */
    Builder setIgnoreUnspecifiedColumnFamilies(Boolean ignoreUnspecifiedColumnFamilies) {
      this.ignoreUnspecifiedColumnFamilies = ignoreUnspecifiedColumnFamilies;
      return this;
    }

    /**
     * If readRowkeyAsString is true, then the rowkey column families will be read and converted to
     * string. Otherwise they are read with BYTES type values and users need to manually cast them
     * with CAST if necessary. The default value is false.
     */
    Builder setReadRowkeyAsString(Boolean readRowkeyAsString) {
      this.readRowkeyAsString = readRowkeyAsString;
      return this;
    }

    /**
     * List of column families to expose in the table schema along with their types.
     *
     * <p>This list restricts the column families that can be referenced in queries and specifies
     * their value types. You can use this list to do type conversions - see the 'type' field for
     * more details. If you leave this list empty, all column families are present in the table
     * schema and their values are read as BYTES. During a query only the column families referenced
     * in that query are read from Bigtable.
     */
    Builder setColumnFamilies(List<BigtableColumnFamily> columnFamilies) {
      this.columnFamilies = columnFamilies;
      return this;
    }

    BigtableOptions build() {
      return new BigtableOptions(this);
    }
  }

  BigtableOptions(Builder builder) {
    super(FormatOptions.BIGTABLE);
    ignoreUnspecifiedColumnFamilies = builder.ignoreUnspecifiedColumnFamilies;
    readRowkeyAsString = builder.readRowkeyAsString;
    columnFamilies = builder.columnFamilies;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("ignoreUnspecifiedColumnFamilies", ignoreUnspecifiedColumnFamilies)
        .add("readRowkeyAsString", readRowkeyAsString)
        .add("columnFamilies", columnFamilies)
        .toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(ignoreUnspecifiedColumnFamilies, readRowkeyAsString, columnFamilies);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(BigtableOptions.class)) {
      return false;
    }
    BigtableOptions other = (BigtableOptions) obj;
    return ignoreUnspecifiedColumnFamilies == other.ignoreUnspecifiedColumnFamilies
        && readRowkeyAsString == other.readRowkeyAsString
        && Objects.equals(columnFamilies, other.columnFamilies);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  static BigtableOptions fromPb(com.google.api.services.bigquery.model.BigtableOptions options) {
    Builder builder = newBuilder();
    builder.setIgnoreUnspecifiedColumnFamilies(options.getIgnoreUnspecifiedColumnFamilies());
    builder.setReadRowkeyAsString(options.getReadRowkeyAsString());
    builder.setColumnFamilies(
        Lists.transform(options.getColumnFamilies(), BigtableColumnFamily.FROM_PB_FUNCTION));
    return builder.build();
  }

  com.google.api.services.bigquery.model.BigtableOptions toPb() {
    com.google.api.services.bigquery.model.BigtableOptions options =
        new com.google.api.services.bigquery.model.BigtableOptions()
            .setIgnoreUnspecifiedColumnFamilies(ignoreUnspecifiedColumnFamilies)
            .setReadRowkeyAsString(readRowkeyAsString);
    if (columnFamilies != null) {
      options.setColumnFamilies(
          Lists.transform(columnFamilies, BigtableColumnFamily.TO_PB_FUNCTION));
    }
    return options;
  }
}
