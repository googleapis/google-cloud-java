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
package com.google.cloud.bigtable.data.v2.models.sql;

import com.google.api.core.BetaApi;
import java.util.List;

/** Provides information about the schema of a {@link ResultSet}. */
@BetaApi
public interface ResultSetMetadata {

  /** @return full list of {@link ColumnMetadata} for each column in the {@link ResultSet}. */
  List<ColumnMetadata> getColumns();

  /**
   * @param columnIndex index of the column
   * @return the {@link SqlType} of the column at the given index
   */
  SqlType<?> getColumnType(int columnIndex);

  /**
   * @param columnName name of the column
   * @return the {@link SqlType} of the column with the given name
   * @throws IllegalArgumentException if there is no column with the name *or* if there are multiple
   *     columns with the given name
   */
  SqlType<?> getColumnType(String columnName);

  /**
   * @param columnName name of the column
   * @return index of the column with the given name
   * @throws IllegalArgumentException if there is no column with the name *or* if there are multiple
   *     columns with the given name
   */
  int getColumnIndex(String columnName);
}
