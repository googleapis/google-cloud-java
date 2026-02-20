/*
 * Copyright 2021 Google LLC
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

import com.google.api.services.bigquery.model.StandardSqlTableType;
import com.google.auto.value.AutoValue;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/** Represents Standard SQL table type information. */
@AutoValue
public abstract class StandardSQLTableType implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /** Sets the columns in this table type. */
    public abstract Builder setColumns(List<StandardSQLField> columns);

    /** Creates a {@code StandardSQLTableType} object. */
    public abstract StandardSQLTableType build();
  }

  /** Returns the columns in this table type. */
  public abstract List<StandardSQLField> getColumns();

  public abstract Builder toBuilder();

  /** Returns a builder for a {@code StandardSQLTableType} object. */
  public static Builder newBuilder() {
    return new AutoValue_StandardSQLTableType.Builder();
  }

  /** Returns a builder for a {@code StandardSQLTableType} object with the specified columns. */
  public static StandardSQLTableType.Builder newBuilder(List<StandardSQLField> columns) {
    return newBuilder().setColumns(columns);
  }

  static StandardSQLTableType fromPb(
      com.google.api.services.bigquery.model.StandardSqlTableType tableTypePb) {
    StandardSQLTableType.Builder builder = newBuilder();
    if (tableTypePb.getColumns() != null) {
      builder.setColumns(
          Lists.transform(tableTypePb.getColumns(), StandardSQLField.FROM_PB_FUNCTION));
    }
    return builder.build();
  }

  StandardSqlTableType toPb() {
    StandardSqlTableType tableType = new StandardSqlTableType();
    if (getColumns() != null) {
      tableType.setColumns(Lists.transform(getColumns(), StandardSQLField.TO_PB_FUNCTION));
    }
    return tableType;
  }
}
