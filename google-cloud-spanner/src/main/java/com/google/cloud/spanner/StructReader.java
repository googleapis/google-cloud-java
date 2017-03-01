/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.cloud.ByteArray;
import java.util.List;

/**
 * A base interface for reading the fields of a {@code STRUCT}. The Cloud Spanner yields {@code
 * StructReader} instances as one of the subclasses {@link ResultSet} or {@link Struct}, most
 * commonly as the result of a read or query operation. At any point in time, a {@code StructReader}
 * provides access to a single tuple of data comprising multiple typed columns. Each column may have
 * a {@code NULL} or non-{@code NULL} value; in both cases, columns always have a type.
 *
 * <p>Column values are accessed using the {@code getTypeName()} methods; a set of methods exists
 * for each Java type that a column may be read as, and depending on the type of the column, only a
 * subset of those methods will be appropriate. For example, {@link #getString(int)} and {@link
 * #getString(String)} exist for reading columns of type {@link Type#string()}; attempting to call
 * those methods for columns of other types will result in an {@code IllegalStateException}. The
 * {@code getTypeName()} methods should only be called for non-{@code NULL} values, otherwise a
 * {@code NullPointerException} is raised; {@link #isNull(int)}/{@link #isNull(String)} can be used
 * to test for {@code NULL}-ness if necessary.
 *
 * <p>All methods for accessing a column have overloads that accept an {@code int} column index and
 * a {@code String} column name. Column indices are zero-based. The column name overloads will fail
 * with {@code IllegalArgumentException} if the column name does not appear exactly once in this
 * instance's {@link #getType()}. The {@code int} overloads are typically more efficient than their
 * {@code String} counterparts.
 *
 * <p>{@code StructReader} itself does not define whether the implementing type is mutable or
 * immutable. For example, {@link ResultSet} is a mutable implementation of {@code StructReader},
 * where the {@code StructReader} methods provide access to the row that the result set is currently
 * positioned over and {@link ResultSet#next()} changes that view to the next row, whereas {@link
 * Struct} is an immutable implementation of {@code StructReader}.
 */
public interface StructReader {
  /**
   * Returns the type of the underlying data. This will always be a {@code STRUCT} type, with fields
   * corresponding to the data's columns. For the result of a read or query, this will always match
   * the columns passed to the {@code read()} call or named in the query text, in order.
   */
  Type getType();

  /**
   * Returns the number of columns in the underlying data. This includes any columns with {@code
   * NULL} values.
   */
  int getColumnCount();

  /**
   * Returns the index of the column named {@code columnName}.
   *
   * @throws IllegalArgumentException if there is not exactly one element of {@code
   *     type().structFields()} with {@link Type.StructField#getName()} equal to {@code columnName}
   */
  int getColumnIndex(String columnName);

  /** Returns the type of a column. */
  Type getColumnType(int columnIndex);

  /** Returns the type of a column. */
  Type getColumnType(String columnName);

  /** Returns {@code true} if a column contains a {@code NULL} value. */
  boolean isNull(int columnIndex);

  /** Returns {@code true} if a column contains a {@code NULL} value. */
  boolean isNull(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#bool()}. */
  boolean getBoolean(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#bool()}. */
  boolean getBoolean(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#int64()}. */
  long getLong(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#int64()}. */
  long getLong(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#float64()}. */
  double getDouble(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#float64()}. */
  double getDouble(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#string()}. */
  String getString(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#string()}. */
  String getString(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#bytes()}. */
  ByteArray getBytes(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#bytes()}. */
  ByteArray getBytes(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#timestamp()}. */
  Timestamp getTimestamp(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#timestamp()}. */
  Timestamp getTimestamp(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#date()}. */
  Date getDate(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@link Type#date()}. */
  Date getDate(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getBooleanList(int)} instead.
   */
  boolean[] getBooleanArray(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getBooleanList(String)} instead.
   */
  boolean[] getBooleanArray(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}. */
  List<Boolean> getBooleanList(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bool())}. */
  List<Boolean> getBooleanList(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getLongList(int)} instead.
   */
  long[] getLongArray(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getLongList(String)} instead.
   */
  long[] getLongArray(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}. */
  List<Long> getLongList(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.int64())}. */
  List<Long> getLongList(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getDoubleList(int)} instead.
   */
  double[] getDoubleArray(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   *
   * @throws NullPointerException if any element of the array value is {@code NULL}. If the array
   *     may contain {@code NULL} values, use {@link #getDoubleList(String)} instead.
   */
  double[] getDoubleArray(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   */
  List<Double> getDoubleList(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.float64())}.
   */
  List<Double> getDoubleList(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.string())}. */
  List<String> getStringList(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.string())}. */
  List<String> getStringList(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bytes())}. */
  List<ByteArray> getBytesList(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.bytes())}. */
  List<ByteArray> getBytesList(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.timestamp())}.
   */
  List<Timestamp> getTimestampList(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.timestamp())}.
   */
  List<Timestamp> getTimestampList(String columnName);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.date())}. */
  List<Date> getDateList(int columnIndex);

  /** Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.date())}. */
  List<Date> getDateList(String columnName);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.struct(...))}.
   */
  List<Struct> getStructList(int columnIndex);

  /**
   * Returns the value of a non-{@code NULL} column with type {@code Type.array(Type.struct(...))}.
   */
  List<Struct> getStructList(String columnName);
}
