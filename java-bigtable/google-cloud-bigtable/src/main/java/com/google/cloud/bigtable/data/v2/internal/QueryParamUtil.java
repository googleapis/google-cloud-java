/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal;

import com.google.api.core.InternalApi;
import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType.Array;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType.Code;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Helper to convert SqlTypes to protobuf query parameter representation
 *
 * <p>This is considered an internal implementation detail and should not be used by applications.
 */
@InternalApi("For internal use only")
public class QueryParamUtil {
  private static final Type STRING_TYPE =
      Type.newBuilder().setStringType(Type.String.getDefaultInstance()).build();
  private static final Type BYTES_TYPE =
      Type.newBuilder().setBytesType(Type.Bytes.getDefaultInstance()).build();
  private static final Type INT64_TYPE =
      Type.newBuilder().setInt64Type(Type.Int64.getDefaultInstance()).build();
  private static final Type FLOAT32_TYPE =
      Type.newBuilder().setFloat32Type(Type.Float32.getDefaultInstance()).build();
  private static final Type FLOAT64_TYPE =
      Type.newBuilder().setFloat64Type(Type.Float64.getDefaultInstance()).build();
  private static final Type BOOL_TYPE =
      Type.newBuilder().setBoolType(Type.Bool.getDefaultInstance()).build();
  private static final Type TIMESTAMP_TYPE =
      Type.newBuilder().setTimestampType(Type.Timestamp.getDefaultInstance()).build();
  private static final Type DATE_TYPE =
      Type.newBuilder().setDateType(Type.Date.getDefaultInstance()).build();

  private static final Set<Code> VALID_ARRAY_ELEMENT_TYPES =
      new HashSet<>(
          Arrays.asList(
              Code.STRING,
              Code.BYTES,
              Code.INT64,
              Code.FLOAT64,
              Code.FLOAT32,
              Code.BOOL,
              Code.TIMESTAMP,
              Code.DATE));

  public static Type convertToQueryParamProto(SqlType<?> sqlType) {
    switch (sqlType.getCode()) {
      case BYTES:
        return BYTES_TYPE;
      case STRING:
        return STRING_TYPE;
      case INT64:
        return INT64_TYPE;
      case FLOAT64:
        return FLOAT64_TYPE;
      case FLOAT32:
        return FLOAT32_TYPE;
      case BOOL:
        return BOOL_TYPE;
      case TIMESTAMP:
        return TIMESTAMP_TYPE;
      case DATE:
        return DATE_TYPE;
      case STRUCT:
        throw new IllegalArgumentException("STRUCT is not a supported query parameter type");
      case MAP:
        throw new IllegalArgumentException("MAP is not a supported query parameter type");
      case ARRAY:
        SqlType.Array<?> arrayType = (Array<?>) sqlType;
        if (!VALID_ARRAY_ELEMENT_TYPES.contains(arrayType.getElementType().getCode())) {
          throw new IllegalArgumentException(
              "Unsupported query parameter Array element type: " + arrayType.getElementType());
        }
        Type elementType = convertToQueryParamProto(arrayType.getElementType());
        Type.Array arrayProto = Type.Array.newBuilder().setElementType(elementType).build();
        return Type.newBuilder().setArrayType(arrayProto).build();
      default:
        throw new IllegalArgumentException("Unsupported Query parameter type: " + sqlType);
    }
  }
}
