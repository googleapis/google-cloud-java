/*
 * Copyright 2026 Google LLC
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

import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Schema;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.arrow.vector.util.JsonStringArrayList;
import org.apache.arrow.vector.util.JsonStringHashMap;

/**
 * An implementation of {@link BigQueryBaseArray} used to represent Array values from Arrow data.
 */
class BigQueryArrowArray extends BigQueryBaseArray {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryArrowArray.class.getName());
  private static final BigQueryTypeCoercer BIGQUERY_TYPE_COERCER =
      BigQueryTypeCoercionUtility.INSTANCE;
  private JsonStringArrayList<?> values;

  public BigQueryArrowArray(Field schema, JsonStringArrayList<?> values) {
    super(schema);
    this.values = values;
  }

  @Override
  public Object getArray() {
    LOG.finest("++enter++");
    ensureValid();
    if (values == null) {
      return null;
    }
    return getArrayInternal(0, values.size());
  }

  @Override
  public Object getArray(long index, int count) {
    LOG.finest("++enter++");
    ensureValid();
    if (values == null) {
      return null;
    }
    Tuple<Integer, Integer> range = createRange(index, count, this.values.size());
    return getArrayInternal(range.x(), range.y());
  }

  @Override
  public ResultSet getResultSet() throws SQLException {
    LOG.finest("++enter++");
    ensureValid();
    if (values == null) {
      return new BigQueryArrowResultSet();
    }
    BigQueryArrowBatchWrapper arrowBatchWrapper =
        BigQueryArrowBatchWrapper.getNestedFieldValueListWrapper(values);
    return BigQueryArrowResultSet.getNestedResultSet(
        Schema.of(singleElementSchema()), arrowBatchWrapper, 0, this.values.size());
  }

  @Override
  public ResultSet getResultSet(long index, int count) throws SQLException {
    LOG.finest("++enter++");
    ensureValid();
    if (values == null) {
      return new BigQueryArrowResultSet();
    }
    Tuple<Integer, Integer> range = createRange(index, count, this.values.size());
    BigQueryArrowBatchWrapper arrowBatchWrapper =
        BigQueryArrowBatchWrapper.getNestedFieldValueListWrapper(values);
    return BigQueryArrowResultSet.getNestedResultSet(
        Schema.of(singleElementSchema()), arrowBatchWrapper, range.x(), range.y());
  }

  @Override
  public void free() {
    LOG.finest("++enter++");
    this.values = null;
    markInvalid();
  }

  @Override
  Object getCoercedValue(int index) {
    LOG.finest("++enter++");
    Object value = this.values.get(index);
    return this.arrayOfStruct
        ? new BigQueryArrowStruct(schema.getSubFields(), (JsonStringHashMap<?, ?>) value)
        : BIGQUERY_TYPE_COERCER.coerceTo(getTargetClass(), value);
  }
}
