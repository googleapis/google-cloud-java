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

import static com.google.cloud.bigquery.jdbc.BigQueryBaseArray.isArray;

import com.google.api.core.InternalApi;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import java.lang.reflect.Array;
import java.util.List;

/**
 * An implementation of {@link BigQueryBaseStruct} used to represent Struct values from Json data.
 */
@InternalApi
class BigQueryJsonStruct extends BigQueryBaseStruct {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJsonStruct.class.getName());

  private static final BigQueryTypeCoercer BIGQUERY_TYPE_COERCER =
      BigQueryTypeCoercionUtility.INSTANCE;

  private final FieldList schema;
  private final List<FieldValue> values;

  public BigQueryJsonStruct(FieldList schema, FieldValue values) {
    this.schema = schema;
    this.values = (values == null || values.isNull()) ? null : values.getRecordValue();
  }

  @Override
  FieldList getSchema() {
    return this.schema;
  }

  @Override
  public Object[] getAttributes() {
    LOG.finest("++enter++");
    int size = schema.size();
    Object[] attributes = (Object[]) Array.newInstance(Object.class, size);

    for (int index = 0; index < size; index++) {
      Field currentSchema = schema.get(index);
      FieldValue currentValue = values == null ? null : values.get(index);
      Object coercedValue = getValue(currentSchema, currentValue);
      Array.set(attributes, index, coercedValue);
    }
    return attributes;
  }

  private Object getValue(Field currentSchema, FieldValue currentValue) {
    LOG.finest("++enter++");
    if (isArray(currentSchema)) {
      return new BigQueryJsonArray(currentSchema, currentValue);
    } else if (isStruct(currentSchema)) {
      return new BigQueryJsonStruct(currentSchema.getSubFields(), currentValue);
    } else {
      Class<?> targetClass =
          BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping.get(
              currentSchema.getType().getStandardType());
      return BIGQUERY_TYPE_COERCER.coerceTo(targetClass, currentValue);
    }
  }
}
