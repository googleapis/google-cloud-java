/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.bigtable.testproxy;

import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.Array;
import com.google.bigtable.v2.Type.Bool;
import com.google.bigtable.v2.Type.Bytes;
import com.google.bigtable.v2.Type.Float32;
import com.google.bigtable.v2.Type.Float64;
import com.google.bigtable.v2.Type.Int64;
import com.google.bigtable.v2.Type.Map;
import com.google.bigtable.v2.Type.Struct;
import com.google.bigtable.v2.Type.Timestamp;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.models.sql.ColumnMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSet;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.StructReader;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ResultSetSerializer {
  public static ExecuteQueryResult toExecuteQueryResult(ResultSet resultSet)
      throws ExecutionException, InterruptedException {
    ExecuteQueryResult.Builder resultBuilder = ExecuteQueryResult.newBuilder();
    for (ColumnMetadata columnMetadata : resultSet.getMetadata().getColumns()) {
      resultBuilder
          .getMetadataBuilder()
          .addColumnsBuilder()
          .setName(columnMetadata.name())
          .setType(toProtoType(columnMetadata.type()));
    }

    while (resultSet.next()) {
      SqlRow.Builder rowBuilder = resultBuilder.addRowsBuilder();

      for (int i = 0; i < resultSet.getMetadata().getColumns().size(); i++) {
        SqlType<?> colType = resultSet.getMetadata().getColumnType(i);
        rowBuilder.addValues(toProtoValue(getColumn(resultSet, i, colType), colType));
      }
    }

    return resultBuilder.build();
  }

  private static Value toProtoValue(Object value, SqlType<?> type) {
    if (value == null) {
      return Value.getDefaultInstance();
    }

    Value.Builder valueBuilder = Value.newBuilder();
    switch (type.getCode()) {
      case BYTES:
        valueBuilder.setBytesValue((ByteString) value);
        break;
      case STRING:
        valueBuilder.setStringValue((String) value);
        break;
      case INT64:
        valueBuilder.setIntValue((Long) value);
        break;
      case FLOAT32:
        valueBuilder.setFloatValue((Float) value);
        break;
      case FLOAT64:
        valueBuilder.setFloatValue((Double) value);
        break;
      case BOOL:
        valueBuilder.setBoolValue((Boolean) value);
        break;
      case TIMESTAMP:
        Instant ts = (Instant) value;
        valueBuilder.setTimestampValue(
            com.google.protobuf.Timestamp.newBuilder()
                .setSeconds(ts.getEpochSecond())
                .setNanos(ts.getNano())
                .build());
        break;
      case DATE:
        Date date = (Date) value;
        valueBuilder.setDateValue(
            com.google.type.Date.newBuilder()
                .setYear(date.getYear())
                .setMonth(date.getMonth())
                .setDay(date.getDayOfMonth())
                .build());
        break;
      case ARRAY:
        SqlType<?> elementType = ((SqlType.Array<?>) type).getElementType();
        ArrayValue.Builder arrayValue = ArrayValue.newBuilder();
        for (Object item : (List<?>) value) {
          arrayValue.addValues(toProtoValue(item, elementType));
        }
        valueBuilder.setArrayValue(arrayValue.build());
        break;
      case MAP:
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        SqlType<?> mapKeyType = mapType.getKeyType();
        SqlType<?> mapValueType = mapType.getValueType();

        ArrayValue.Builder mapArrayValue = ArrayValue.newBuilder();
        ((java.util.Map<?, ?>) value)
            .forEach(
                (k, v) ->
                    mapArrayValue.addValues(
                        Value.newBuilder()
                            .setArrayValue(
                                ArrayValue.newBuilder()
                                    .addValues(toProtoValue(k, mapKeyType))
                                    .addValues(toProtoValue(v, mapValueType))
                                    .build())));
        valueBuilder.setArrayValue(mapArrayValue.build());
        break;
      case STRUCT:
        StructReader structValue = (StructReader) value;
        SqlType.Struct structType = (SqlType.Struct) type;
        ArrayValue.Builder structArrayValue = ArrayValue.newBuilder();
        for (int i = 0; i < structType.getFields().size(); ++i) {
          SqlType<?> fieldType = structType.getType(i);
          structArrayValue.addValues(toProtoValue(getColumn(structValue, i, fieldType), fieldType));
        }
        valueBuilder.setArrayValue(structArrayValue);
        break;
      default:
        throw new IllegalStateException("Unexpected Type: " + type);
    }

    return valueBuilder.build();
  }

  private static Object getColumn(StructReader struct, int fieldIndex, SqlType<?> fieldType) {
    if (struct.isNull(fieldIndex)) {
      return null;
    }

    switch (fieldType.getCode()) {
      case ARRAY:
        return struct.getList(fieldIndex, (SqlType.Array<?>) fieldType);
      case BOOL:
        return struct.getBoolean(fieldIndex);
      case BYTES:
        return struct.getBytes(fieldIndex);
      case DATE:
        return struct.getDate(fieldIndex);
      case FLOAT32:
        return struct.getFloat(fieldIndex);
      case FLOAT64:
        return struct.getDouble(fieldIndex);
      case INT64:
        return struct.getLong(fieldIndex);
      case MAP:
        return struct.getMap(fieldIndex, (SqlType.Map<?, ?>) fieldType);
      case STRING:
        return struct.getString(fieldIndex);
      case STRUCT:
        return struct.getStruct(fieldIndex);
      case TIMESTAMP:
        return struct.getTimestamp(fieldIndex);
      default:
        throw new IllegalStateException("Unexpected Type: " + fieldType);
    }
  }

  private static Type toProtoType(SqlType<?> type) {
    switch (type.getCode()) {
      case BYTES:
        return Type.newBuilder().setBytesType(Bytes.getDefaultInstance()).build();
      case STRING:
        return Type.newBuilder()
            .setStringType(com.google.bigtable.v2.Type.String.getDefaultInstance())
            .build();
      case INT64:
        return Type.newBuilder().setInt64Type(Int64.getDefaultInstance()).build();
      case FLOAT32:
        return Type.newBuilder().setFloat32Type(Float32.getDefaultInstance()).build();
      case FLOAT64:
        return Type.newBuilder().setFloat64Type(Float64.getDefaultInstance()).build();
      case BOOL:
        return Type.newBuilder().setBoolType(Bool.getDefaultInstance()).build();
      case TIMESTAMP:
        return Type.newBuilder().setTimestampType(Timestamp.getDefaultInstance()).build();
      case DATE:
        return Type.newBuilder()
            .setDateType(com.google.bigtable.v2.Type.Date.getDefaultInstance())
            .build();
      case ARRAY:
        SqlType.Array<?> arrayType = (SqlType.Array<?>) type;
        return Type.newBuilder()
            .setArrayType(
                Array.newBuilder().setElementType(toProtoType(arrayType.getElementType())))
            .build();
      case MAP:
        SqlType.Map<?, ?> mapType = (SqlType.Map<?, ?>) type;
        return Type.newBuilder()
            .setMapType(
                Map.newBuilder()
                    .setKeyType(toProtoType(mapType.getKeyType()))
                    .setValueType(toProtoType(mapType.getValueType())))
            .build();
      case STRUCT:
        SqlType.Struct structType = (SqlType.Struct) type;
        Struct.Builder structBuilder = Struct.newBuilder();
        for (SqlType.Struct.Field field : structType.getFields()) {
          structBuilder
              .addFieldsBuilder()
              .setFieldName(field.name())
              .setType(toProtoType(field.type()));
        }
        return Type.newBuilder().setStructType(structBuilder.build()).build();

      default:
        throw new IllegalStateException("Unexpected Type: " + type);
    }
  }
}
