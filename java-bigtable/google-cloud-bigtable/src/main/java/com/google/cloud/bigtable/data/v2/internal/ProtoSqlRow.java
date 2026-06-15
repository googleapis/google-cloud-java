/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.Value;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import java.util.List;

@InternalApi
@AutoValue
public abstract class ProtoSqlRow extends AbstractProtoStructReader implements SqlRow {
  /**
   * Creates a new SqlRow
   *
   * @param metadata the {@link ResultSetMetadata} for the results
   * @param values list of the values for each column
   */
  public static ProtoSqlRow create(ResultSetMetadata metadata, List<Value> values) {
    return new AutoValue_ProtoSqlRow(values, metadata);
  }

  /** {@link ResultSetMetadata} describing the schema of the row. */
  abstract ResultSetMetadata metadata();

  @Override
  public int getColumnIndex(String columnName) {
    return metadata().getColumnIndex(columnName);
  }

  @Override
  public SqlType<?> getColumnType(int columnIndex) {
    return metadata().getColumnType(columnIndex);
  }
}
