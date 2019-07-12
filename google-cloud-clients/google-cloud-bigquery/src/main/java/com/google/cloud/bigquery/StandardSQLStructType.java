/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.bigquery;

import com.google.api.services.bigquery.model.StandardSqlStructType;
import com.google.auto.value.AutoValue;
import com.google.common.collect.Lists;
import java.io.Serializable;
import java.util.List;

/** A set of fields contained within a SQL STRUCT in Google BigQuery. */
@AutoValue
public abstract class StandardSQLStructType implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {

    /** Sets the fields of the struct type. */
    public abstract Builder setFields(List<StandardSQLField> fields);

    /** Creates a {@code StandardSQLStructType} object. */
    public abstract StandardSQLStructType build();
  }

  /** Returns the list of fields within a struct type. */
  public abstract List<StandardSQLField> getFields();

  /** Returns a builder pre-populated using the current values of this field. */
  public abstract Builder toBuilder();

  /** Returns a builder for a {@code StandardSQLStructType} object. */
  public static Builder newBuilder() {
    return new AutoValue_StandardSQLStructType.Builder();
  }

  /** Returns a builder for a {@code StandardSQLStructType} object with the specified fields. */
  public static Builder newBuilder(List<StandardSQLField> fieldList) {
    return newBuilder().setFields(fieldList);
  }

  static StandardSQLStructType fromPb(
      com.google.api.services.bigquery.model.StandardSqlStructType structTypePb) {
    Builder builder = newBuilder();
    if (structTypePb.getFields() != null) {
      builder.setFields(
          Lists.transform(structTypePb.getFields(), StandardSQLField.FROM_PB_FUNCTION));
    }
    return builder.build();
  }

  StandardSqlStructType toPb() {
    StandardSqlStructType structTypePb = new StandardSqlStructType();
    if (getFields() != null) {
      structTypePb.setFields(Lists.transform(getFields(), StandardSQLField.TO_PB_FUNCTION));
    }
    return structTypePb;
  }
}
