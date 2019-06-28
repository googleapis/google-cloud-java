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

import com.google.api.services.bigquery.model.StandardSqlDataType;
import com.google.auto.value.AutoValue;
import java.io.Serializable;
import javax.annotation.Nullable;

@AutoValue
public abstract class StandardSQLDataType implements Serializable {

  @AutoValue.Builder
  public abstract static class Builder {
    /** Sets the type of an array's elements, when the TypeKind is ARRAY. */
    public abstract Builder setArrayElementType(StandardSQLDataType arrayElementType);

    /** Sets the struct type definition (list of fields) when the TypeKind is STRUCT. */
    public abstract Builder setStructType(StandardSQLStructType structType);

    /**
     * Sets the top-level type of this data type. Can be any standard SQL data type. For more
     * information, see https://cloud.google.com/bigquery/docs/reference/standard-sql/data-types
     */
    public abstract Builder setTypeKind(String typeKind);

    /** Creates a {@code StandardSQLDataType} object. */
    public abstract StandardSQLDataType build();
  }

  public abstract String getTypeKind();

  @Nullable
  public abstract StandardSQLDataType getArrayElementType();

  @Nullable
  public abstract StandardSQLStructType getStructType();

  public abstract Builder toBuilder();

  public static Builder newBuilder() {
    return new AutoValue_StandardSQLDataType.Builder();
  }

  public static Builder newBuilder(String typeKind) {
    return newBuilder().setTypeKind(typeKind);
  }

  StandardSqlDataType toPb() {
    StandardSqlDataType dataTypePb = new StandardSqlDataType();
    dataTypePb.setTypeKind(getTypeKind());
    if (getArrayElementType() != null) {
      dataTypePb.setArrayElementType(getArrayElementType().toPb());
    }
    if (getStructType() != null) {
      dataTypePb.setStructType(getStructType().toPb());
    }
    return dataTypePb;
  }

  static StandardSQLDataType fromPb(StandardSqlDataType dataTypePb) {
    Builder builder = newBuilder();
    builder.setTypeKind(dataTypePb.getTypeKind());
    if (dataTypePb.getArrayElementType() != null) {
      builder.setArrayElementType(StandardSQLDataType.fromPb(dataTypePb.getArrayElementType()));
    }
    if (dataTypePb.getStructType() != null) {
      builder.setStructType(StandardSQLStructType.fromPb(dataTypePb.getStructType()));
    }
    return builder.build();
  }
}
