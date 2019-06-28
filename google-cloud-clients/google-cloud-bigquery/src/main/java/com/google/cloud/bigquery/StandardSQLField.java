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

import com.google.api.services.bigquery.model.StandardSqlField;
import com.google.auto.value.AutoValue;
import com.google.common.base.Function;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class StandardSQLField implements Serializable {

  static final Function<StandardSqlField, StandardSQLField> FROM_PB_FUNCTION =
      new Function<StandardSqlField, StandardSQLField>() {
        @Override
        public StandardSQLField apply(StandardSqlField pb) {
          return StandardSQLField.fromPb(pb);
        }
      };
  static final Function<StandardSQLField, StandardSqlField> TO_PB_FUNCTION =
      new Function<StandardSQLField, StandardSqlField>() {
        @Override
        public StandardSqlField apply(StandardSQLField field) {
          return field.toPb();
        }
      };

  @AutoValue.Builder
  public abstract static class Builder {

    public abstract Builder setName(String name);

    public abstract Builder setDataType(StandardSQLDataType dataType);

    public abstract StandardSQLField build();
  }

  @Nullable
  public abstract String getName();

  public abstract StandardSQLDataType getDataType();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_StandardSQLField.Builder();
  }

  public static Builder newBuilder(StandardSQLDataType dataType) {
    return newBuilder().setDataType(dataType);
  }

  public static Builder newBuilder(String name, StandardSQLDataType dataType) {
    return newBuilder().setName(name).setDataType(dataType);
  }

  public StandardSqlField toPb() {
    StandardSqlField fieldPb = new StandardSqlField();
    fieldPb.setName(getName());
    if (getDataType() != null) {
      fieldPb.setType(getDataType().toPb());
    }
    return fieldPb;
  }

  static StandardSQLField fromPb(StandardSqlField fieldPb) {
    Builder builder = newBuilder();
    builder.setName(fieldPb.getName());
    if (fieldPb.getType() != null) {
      builder.setDataType(StandardSQLDataType.fromPb(fieldPb.getType()));
    }
    return builder.build();
  }
}
