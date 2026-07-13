/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.BigQueryBaseArray.isArray;
import static com.google.cloud.bigquery.jdbc.BigQueryBaseStruct.isStruct;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValue.Attribute;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import java.util.List;

/**
 * Package-private, This class acts as a facade layer and wraps the FieldList(schema) and
 * FieldValueList or lightweight Object[] row buffers.
 */
class BigQueryFieldValueListWrapper {

  // This is a reference schema to the schema
  private final FieldList fieldList;

  // POJO representation of the JSON response
  private final FieldValueList fieldValueList;

  // This is very similar to the FieldValueList above, except we get the
  // reference as a List<FieldValue> in case of an Array
  private final List<FieldValue> arrayFieldValueList;

  // Lightweight row values buffer (Object[]) for streaming parsing
  private final Object[] rowValues;

  // This flag marks the end of the stream for the ResultSet
  private boolean isLast = false;
  private final Exception exception;

  static BigQueryFieldValueListWrapper of(FieldList fieldList, FieldValueList fieldValueList) {
    return of(fieldList, fieldValueList, (boolean[]) null);
  }

  static BigQueryFieldValueListWrapper of(
      FieldList fieldList, FieldValueList fieldValueList, boolean[] isComplexColumn) {
    if (fieldValueList == null) {
      return new BigQueryFieldValueListWrapper(fieldList, null, null, null, true, null);
    }
    boolean[] flags =
        isComplexColumn != null ? isComplexColumn : createComplexColumnFlags(fieldList);
    Object[] rowValues = unpackRow(fieldValueList, flags);
    return new BigQueryFieldValueListWrapper(fieldList, null, null, rowValues, false, null);
  }

  static boolean[] createComplexColumnFlags(FieldList fieldList) {
    if (fieldList == null) {
      return new boolean[0];
    }
    int size = fieldList.size();
    boolean[] isComplex = new boolean[size];
    for (int i = 0; i < size; i++) {
      Field field = fieldList.get(i);
      isComplex[i] =
          isArray(field)
              || isStruct(field)
              || (field.getType() != null
                  && field.getType().getStandardType() == StandardSQLTypeName.RANGE);
    }
    return isComplex;
  }

  static Object[] unpackRow(FieldValueList fieldValueList, boolean[] isComplexColumn) {
    if (fieldValueList == null) {
      return null;
    }
    int size = fieldValueList.size();
    Object[] row = new Object[size];
    for (int i = 0; i < size; i++) {
      FieldValue fv = fieldValueList.get(i);
      if (fv == null || fv.isNull()) {
        row[i] = null;
      } else if ((i < isComplexColumn.length && isComplexColumn[i])
          || fv.getAttribute() != Attribute.PRIMITIVE) {
        row[i] = fv;
      } else {
        row[i] = fv.getStringValue();
      }
    }
    return row;
  }

  static BigQueryFieldValueListWrapper getNestedFieldValueListWrapper(
      FieldList fieldList, List<FieldValue> arrayFieldValueList, boolean... isLast) {
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryFieldValueListWrapper(
        fieldList, null, arrayFieldValueList, null, isLastFlag, null);
  }

  static BigQueryFieldValueListWrapper ofError(Exception exception) {
    return new BigQueryFieldValueListWrapper(null, null, null, null, true, exception);
  }

  private BigQueryFieldValueListWrapper(
      FieldList fieldList,
      FieldValueList fieldValueList,
      List<FieldValue> arrayFieldValueList,
      Object[] rowValues,
      boolean isLast,
      Exception exception) {
    this.fieldList = fieldList;
    this.fieldValueList = fieldValueList;
    this.arrayFieldValueList = arrayFieldValueList;
    this.rowValues = rowValues;
    this.isLast = isLast;
    this.exception = exception;
  }

  FieldList getFieldList() {
    return this.fieldList;
  }

  FieldValueList getFieldValueList() {
    return this.fieldValueList;
  }

  List<FieldValue> getArrayFieldValueList() {
    return this.arrayFieldValueList;
  }

  Object[] getRowValues() {
    return this.rowValues;
  }

  FieldValue get(int index) {
    if (this.fieldValueList != null) {
      return this.fieldValueList.get(index);
    }
    if (this.arrayFieldValueList != null) {
      return this.arrayFieldValueList.get(index);
    }
    if (this.rowValues != null && index >= 0 && index < this.rowValues.length) {
      Object val = this.rowValues[index];
      if (val == null) {
        return FieldValue.of(Attribute.PRIMITIVE, null);
      }
      if (val instanceof FieldValue) {
        return (FieldValue) val;
      }
      return FieldValue.of(Attribute.PRIMITIVE, val.toString());
    }
    return null;
  }

  boolean isLast() {
    return this.isLast;
  }

  Exception getException() {
    return this.exception;
  }
}
