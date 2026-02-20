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

import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.FieldValue;
import com.google.cloud.bigquery.FieldValueList;
import java.util.List;

/**
 * Package-private, This class acts as a facade layer and wraps the FieldList(schema) and
 * FieldValueList
 */
class BigQueryFieldValueListWrapper {

  // This is a reference schema to the schema
  private final FieldList fieldList;

  // POJO representation of the JSON response
  private final FieldValueList fieldValueList;

  // This is very similar to the FieldValueList above, except we get the
  // reference as a List<FieldValue> in case of an Array
  private final List<FieldValue> arrayFieldValueList;

  // This flag marks the end of the stream for the ResultSet
  private boolean isLast = false;

  static BigQueryFieldValueListWrapper of(
      FieldList fieldList, FieldValueList fieldValueList, boolean... isLast) {
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryFieldValueListWrapper(fieldList, fieldValueList, null, isLastFlag);
  }

  static BigQueryFieldValueListWrapper getNestedFieldValueListWrapper(
      FieldList fieldList, List<FieldValue> arrayFieldValueList, boolean... isLast) {
    boolean isLastFlag = isLast != null && isLast.length == 1 && isLast[0];
    return new BigQueryFieldValueListWrapper(fieldList, null, arrayFieldValueList, isLastFlag);
  }

  private BigQueryFieldValueListWrapper(
      FieldList fieldList,
      FieldValueList fieldValueList,
      List<FieldValue> arrayFieldValueList,
      boolean isLast) {
    this.fieldList = fieldList;
    this.fieldValueList = fieldValueList;
    this.arrayFieldValueList = arrayFieldValueList;
    this.isLast = isLast;
  }

  public FieldList getFieldList() {
    return this.fieldList;
  }

  public FieldValueList getFieldValueList() {
    return this.fieldValueList;
  }

  public List<FieldValue> getArrayFieldValueList() {
    return this.arrayFieldValueList;
  }

  public boolean isLast() {
    return this.isLast;
  }
}
