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

import static com.google.cloud.bigquery.jdbc.BigQueryFieldValueListWrapper.getNestedFieldValueListWrapper;

import com.google.api.core.InternalApi;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.Schema;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/** An implementation of {@link BigQueryBaseArray} used to represent Array values from Json data. */
@InternalApi
class BigQueryJsonArray extends BigQueryBaseArray {

  private List<FieldValue> values;
  private final boolean enableTimestampPicos;

  BigQueryJsonArray(Field schema, FieldValue values) {
    this(schema, values, BigQueryJdbcResultSetLogger.getLogger(BigQueryJsonArray.class), false);
  }

  BigQueryJsonArray(
      Field schema,
      FieldValue values,
      BigQueryJdbcResultSetLogger log,
      boolean enableTimestampPicos) {
    super(schema, log);
    this.values = (values == null || values.isNull()) ? null : values.getRepeatedValue();
    this.enableTimestampPicos = enableTimestampPicos;
  }

  @Override
  public Object getArray() throws SQLException {
    ensureValid();
    LOG.finestTrace("getArray");
    if (this.values == null) {
      return null;
    }
    return getArrayInternal(0, this.values.size());
  }

  @Override
  public Object getArray(long index, int count) throws SQLException {
    ensureValid();
    LOG.finestTrace("getArray");
    if (this.values == null) {
      return null;
    }
    Tuple<Integer, Integer> range = createRange(index, count, this.values.size());
    return getArrayInternal(range.x(), range.y());
  }

  @Override
  public ResultSet getResultSet() {
    ensureValid();
    LOG.finestTrace("getResultSet");
    if (this.values == null) {
      return new BigQueryJsonResultSet();
    }
    BigQueryFieldValueListWrapper bigQueryFieldValueListWrapper =
        getNestedFieldValueListWrapper(FieldList.of(singleElementSchema()), this.values);
    return BigQueryJsonResultSet.getNestedResultSet(
        Schema.of(this.schema),
        bigQueryFieldValueListWrapper,
        0,
        this.values.size(),
        this.enableTimestampPicos);
  }

  @Override
  public ResultSet getResultSet(long index, int count) {
    ensureValid();
    LOG.finestTrace("getResultSet");
    if (this.values == null) {
      return new BigQueryJsonResultSet();
    }
    Tuple<Integer, Integer> range = createRange(index, count, this.values.size());
    BigQueryFieldValueListWrapper bigQueryFieldValueListWrapper =
        getNestedFieldValueListWrapper(FieldList.of(singleElementSchema()), this.values);
    return BigQueryJsonResultSet.getNestedResultSet(
        Schema.of(this.schema),
        bigQueryFieldValueListWrapper,
        range.x(),
        range.y(),
        this.enableTimestampPicos);
  }

  @Override
  public void free() {
    this.values = null;
    markInvalid();
  }

  @Override
  protected Class<?> getTargetClass() {
    LOG.finestTrace("getTargetClass");
    if (this.enableTimestampPicos && BigQueryTemporalUtility.isPicosecondTimestamp(this.schema)) {
      return String.class;
    }
    return super.getTargetClass();
  }

  @Override
  Object getCoercedValue(int index) throws SQLException {
    LOG.finestTrace("getCoercedValue");
    FieldValue fieldValue = this.values.get(index);
    if (fieldValue == null || fieldValue.isNull()) {
      return null;
    }
    if (this.arrayOfStruct) {
      return new BigQueryJsonStruct(
          this.schema.getSubFields(),
          fieldValue,
          this.LOG.getJsonStructLogger(),
          this.enableTimestampPicos);
    }
    if (this.enableTimestampPicos && BigQueryTemporalUtility.isPicosecondTimestamp(this.schema)) {
      return BigQueryTemporalUtility.formatTimestampValue(fieldValue.getStringValue(), true);
    }
    if (this.enableTimestampPicos && BigQueryJsonResultSet.isRangeTimestamp(this.schema)) {
      return BigQueryJsonResultSet.formatRangeTimestamp(fieldValue);
    }
    return BigQueryTypeRegistry.convert(fieldValue, this.schema.getType().getStandardType(), null);
  }
}
