/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.Field.Mode.REPEATED;
import static com.google.cloud.bigquery.jdbc.BigQueryBaseStruct.isStruct;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED;
import static com.google.cloud.bigquery.jdbc.BigQueryErrorMessage.INVALID_ARRAY;

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * An abstract implementation of {@link java.sql.Array} used as a base class for {@link
 * BigQueryArrowArray} and {@link BigQueryJsonArray}. An Array value is a transaction-duration
 * reference to an SQL ARRAY value.
 */
abstract class BigQueryBaseArray implements java.sql.Array {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryBaseArray.class.getName());

  protected final boolean arrayOfStruct;
  private boolean valid;
  protected Field schema;

  BigQueryBaseArray(Field schema) {
    this.schema = schema;
    this.arrayOfStruct = isStruct(schema);
    this.valid = true;
  }

  @Override
  public final String getBaseTypeName() {
    LOG.finest("++enter++");
    ensureValid();
    return this.schema.getType().getStandardType().name();
  }

  @Override
  public final int getBaseType() {
    LOG.finest("++enter++");
    ensureValid();
    return BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(
        schema.getType().getStandardType());
  }

  @Override
  public final Object getArray(Map<String, Class<?>> map) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public final Object getArray(long index, int count, Map<String, Class<?>> map)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public final ResultSet getResultSet(Map<String, Class<?>> map) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  @Override
  public final ResultSet getResultSet(long index, int count, Map<String, Class<?>> map)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException(CUSTOMER_TYPE_MAPPING_NOT_SUPPORTED);
  }

  protected Object getArrayInternal(int fromIndex, int toIndexExclusive) {
    LOG.finest("++enter++");
    Class<?> targetClass = getTargetClass();
    int size = toIndexExclusive - fromIndex;
    Object javaArray = Array.newInstance(targetClass, size);

    for (int index = 0; index < size; index++) {
      Array.set(javaArray, index, getCoercedValue(fromIndex + index));
    }
    return javaArray;
  }

  protected void ensureValid() throws IllegalStateException {
    LOG.finest("++enter++");
    if (!this.valid) {
      throw new IllegalStateException(INVALID_ARRAY);
    }
  }

  protected void markInvalid() {
    LOG.finest("++enter++");
    this.schema = null;
    this.valid = false;
  }

  protected Field singleElementSchema() {
    LOG.finest("++enter++");
    return this.schema.toBuilder().setMode(Mode.REQUIRED).build();
  }

  protected Tuple<Integer, Integer> createRange(long index, int count, int size)
      throws IllegalStateException {
    LOG.finest("++enter++");
    // jdbc array follows 1 based array indexing
    long normalisedFromIndex = index - 1;
    if (normalisedFromIndex + count > size) {
      throw new IllegalArgumentException(
          String.format(
              "The array index is out of range: %d, number of elements: %d.", index + count, size));
    }
    long toIndex = normalisedFromIndex + count;
    return Tuple.of((int) normalisedFromIndex, (int) toIndex);
  }

  protected Class<?> getTargetClass() {
    LOG.finest("++enter++");
    return this.arrayOfStruct
        ? Struct.class
        : BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
            this.schema.getType().getStandardType());
  }

  abstract Object getCoercedValue(int index);

  static boolean isArray(Field currentSchema) {
    LOG.finest("++enter++");
    return currentSchema.getMode() == REPEATED;
  }

  @Override
  public String toString() {
    try {
      Object[] array = (Object[]) getArray();
      if (array == null) {
        return "null";
      }
      if (this.schema.getType().getStandardType() == StandardSQLTypeName.BYTES) {
        return Arrays.stream(array)
            .map(
                element ->
                    element == null ? "null" : Base64.getEncoder().encodeToString((byte[]) element))
            .collect(Collectors.joining(", ", "[", "]"));
      }
      return Arrays.deepToString(array);
    } catch (SQLException e) {
      return "[Error converting array to string: " + e.getMessage() + "]";
    }
  }
}
