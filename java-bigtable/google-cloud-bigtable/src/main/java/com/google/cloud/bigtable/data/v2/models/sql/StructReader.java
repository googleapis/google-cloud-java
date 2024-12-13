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
import com.google.cloud.Date;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.util.List;
import java.util.Map;

/**
 * An interface for reading the columns of a {@code Struct} or {@code
 * com.google.cloud.bigtable.data.v2.models.sql.ResultSet}.
 *
 * <p>This provides accessors for each valid type in the form of {@code getTypeName()}. Attempting
 * to call these methods for a column of another type will result in an {@code
 * IllegalStateException}. Each method has an overload accepting both {@code int} column index and
 * {@code String} column Name. Attempting to call an index-based method with a non-existent index
 * will result in an {@code IndexOutOfBoundsException}. Attempting to call a columnName based getter
 * with a column name that does not appear exactly once in the set of fields will result in an
 * {@code IllegalArgumentException}. Attempting to access a column with a null value will result in
 * a {@code NullPointerException}; {@link #isNull(int)} & {@link #isNull(String)} can be used to
 * check for null values.
 */
@BetaApi
public interface StructReader {
  /**
   * @param columnIndex index of the column
   * @return {@code true} if the column contains a {@code NULL} value
   */
  boolean isNull(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@code true} if the column contains a {@code NULL} value
   * @throws IllegalArgumentException if there is not exactly one column with the given name
   */
  boolean isNull(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link ByteString} type value of a non-{@code NULL} column
   */
  ByteString getBytes(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link ByteString} type value of a non-{@code NULL} column
   */
  ByteString getBytes(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link String} type value of a non-{@code NULL} column
   */
  String getString(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link String} type value of a non-{@code NULL} column
   */
  String getString(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link long} type value of a non-{@code NULL} column
   */
  long getLong(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link long} type value of a non-{@code NULL} column
   */
  long getLong(String columnName);

  /**
   * Getter for FLOAT_64 type Sql data
   *
   * @param columnIndex index of the column
   * @return {@link double} type value of a non-{@code NULL} column
   */
  double getDouble(int columnIndex);

  /**
   * Getter for FLOAT_64 type Sql data
   *
   * @param columnName name of the column
   * @return {@link double} type value of a non-{@code NULL} column
   */
  double getDouble(String columnName);

  /**
   * Getter for FLOAT_32 type Sql data
   *
   * @param columnIndex index of the column
   * @return {@link float} type value of a non-{@code NULL} column
   */
  float getFloat(int columnIndex);

  /**
   * Getter for FLOAT_32 type Sql data
   *
   * @param columnName name of the column
   * @return {@link float} type value of a non-{@code NULL} column
   */
  float getFloat(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link boolean} type value of a non-{@code NULL} column
   */
  boolean getBoolean(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link boolean} type value of a non-{@code NULL} column
   */
  boolean getBoolean(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link Instant} type value of a non-{@code NULL} column
   */
  Instant getTimestamp(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link Instant} type value of a non-{@code NULL} column
   */
  Instant getTimestamp(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link Date} type value of a non-{@code NULL} column
   */
  Date getDate(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link Date} type value of a non-{@code NULL} column
   */
  Date getDate(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link com.google.cloud.bigtable.data.v2.models.sql.Struct} type value of a non-{@code
   *     NULL} column
   */
  Struct getStruct(int columnIndex);

  /**
   * @param columnName name of the column
   * @return {@link com.google.cloud.bigtable.data.v2.models.sql.Struct} type value of a non-{@code
   *     NULL} column
   */
  Struct getStruct(String columnName);

  /**
   * @param columnIndex index of the column
   * @return {@link List} type value of a non-{@code NULL} column
   * @param <ElemType> Java type of the list elements
   */
  <ElemType> List<ElemType> getList(int columnIndex, SqlType.Array<ElemType> arrayType);

  /**
   * @param columnName name of the column
   * @return {@link List} type value of a non-{@code NULL} column
   * @param <ElemType> Java type of the list elements
   */
  <ElemType> List<ElemType> getList(String columnName, SqlType.Array<ElemType> arrayType);

  /**
   * @param columnIndex index of the column
   * @return {@link Map} type value of a non-{@code NULL} column
   * @param <K> Java type of the map keys
   * @param <V> Java type of the map values
   */
  <K, V> Map<K, V> getMap(int columnIndex, SqlType.Map<K, V> mapType);

  /**
   * @param columnName name of the column
   * @return {@link Map} type value of a non-{@code NULL} column
   * @param <K> Java type of the map keys
   * @param <V> Java type of the map values
   */
  <K, V> Map<K, V> getMap(String columnName, SqlType.Map<K, V> mapType);
}
