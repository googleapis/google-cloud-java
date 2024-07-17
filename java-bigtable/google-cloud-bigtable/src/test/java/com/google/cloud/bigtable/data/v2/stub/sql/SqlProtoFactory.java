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
package com.google.cloud.bigtable.data.v2.stub.sql;

import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.ExecuteQueryResponse;
import com.google.bigtable.v2.PartialResultSet;
import com.google.bigtable.v2.ProtoRows;
import com.google.bigtable.v2.ProtoRowsBatch;
import com.google.bigtable.v2.ProtoSchema;
import com.google.bigtable.v2.ResultSetMetadata;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.Struct.Field;
import com.google.bigtable.v2.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.type.Date;
import java.util.Arrays;

/** Utilities for creating sql proto objects in tests */
public class SqlProtoFactory {

  private SqlProtoFactory() {}

  public static ColumnMetadata columnMetadata(String name, Type type) {
    return ColumnMetadata.newBuilder().setName(name).setType(type).build();
  }

  public static Type stringType() {
    return Type.newBuilder().setStringType(Type.String.getDefaultInstance()).build();
  }

  public static Type bytesType() {
    return Type.newBuilder().setBytesType(Type.Bytes.getDefaultInstance()).build();
  }

  public static Type int64Type() {
    return Type.newBuilder().setInt64Type(Type.Int64.getDefaultInstance()).build();
  }

  public static Type boolType() {
    return Type.newBuilder().setBoolType(Type.Bool.getDefaultInstance()).build();
  }

  public static Type float32Type() {
    return Type.newBuilder().setFloat32Type(Type.Float32.getDefaultInstance()).build();
  }

  public static Type float64Type() {
    return Type.newBuilder().setFloat64Type(Type.Float64.getDefaultInstance()).build();
  }

  public static Type timestampType() {
    return Type.newBuilder().setTimestampType(Type.Timestamp.getDefaultInstance()).build();
  }

  public static Type dateType() {
    return Type.newBuilder().setDateType(Type.Date.getDefaultInstance()).build();
  }

  public static Type aggregateSumType() {
    return Type.newBuilder()
        .setAggregateType(
            Type.Aggregate.newBuilder().setSum(Type.Aggregate.Sum.getDefaultInstance()))
        .build();
  }

  public static Type arrayType(Type elementType) {
    return Type.newBuilder()
        .setArrayType(Type.Array.newBuilder().setElementType(elementType).build())
        .build();
  }

  public static Type structType(Type... fieldTypes) {
    Field[] fields = new Field[fieldTypes.length];
    for (int i = 0; i < fieldTypes.length; i++) {
      fields[i] = Type.Struct.Field.newBuilder().setType(fieldTypes[i]).build();
    }
    return structType(fields);
  }

  public static Type structType(Field... fields) {
    return Type.newBuilder()
        .setStructType(Type.Struct.newBuilder().addAllFields(Arrays.asList(fields)).build())
        .build();
  }

  public static Field structField(String name, Type type) {
    return Type.Struct.Field.newBuilder().setFieldName(name).setType(type).build();
  }

  public static Type mapType(Type keyType, Type valueType) {
    return Type.newBuilder()
        .setMapType(Type.Map.newBuilder().setKeyType(keyType).setValueType(valueType).build())
        .build();
  }

  public static Value nullValue() {
    return Value.newBuilder().build();
  }

  public static Value stringValue(String contents) {
    return Value.newBuilder().setStringValue(contents).build();
  }

  public static Value bytesValue(String contents) {
    return Value.newBuilder().setBytesValue(ByteString.copyFromUtf8(contents)).build();
  }

  public static Value int64Value(long data) {
    return Value.newBuilder().setIntValue(data).build();
  }

  public static Value floatValue(double data) {
    return Value.newBuilder().setFloatValue(data).build();
  }

  public static Value boolValue(boolean data) {
    return Value.newBuilder().setBoolValue(data).build();
  }

  public static Value timestampValue(long seconds, int nanos) {
    return Value.newBuilder()
        .setTimestampValue(Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build())
        .build();
  }

  public static Value dateValue(int year, int month, int day) {
    return Value.newBuilder()
        .setDateValue(Date.newBuilder().setYear(year).setMonth(month).setDay(day).build())
        .build();
  }

  public static Value arrayValue(Value... elements) {
    return Value.newBuilder()
        .setArrayValue(ArrayValue.newBuilder().addAllValues(Arrays.asList(elements)))
        .build();
  }

  public static Value structValue(Value... fields) {
    return arrayValue(fields);
  }

  public static Value mapValue(Value... elements) {
    return arrayValue(elements);
  }

  public static Value mapElement(Value... fields) {
    return structValue(fields);
  }

  private static ProtoRowsBatch protoRowsBatch(Value... values) {
    ProtoRows protoRows = ProtoRows.newBuilder().addAllValues(Arrays.asList(values)).build();
    return ProtoRowsBatch.newBuilder().setBatchData(protoRows.toByteString()).build();
  }

  public static ExecuteQueryResponse partialResultSetWithoutToken(Value... values) {
    return ExecuteQueryResponse.newBuilder()
        .setResults(PartialResultSet.newBuilder().setProtoRowsBatch(protoRowsBatch(values)).build())
        .build();
  }

  public static ExecuteQueryResponse partialResultSetWithToken(Value... values) {
    return ExecuteQueryResponse.newBuilder()
        .setResults(
            PartialResultSet.newBuilder()
                .setProtoRowsBatch(protoRowsBatch(values))
                .setResumeToken(ByteString.copyFromUtf8("test"))
                .build())
        .build();
  }

  public static ExecuteQueryResponse tokenOnlyResultSet(ByteString token) {
    return ExecuteQueryResponse.newBuilder()
        .setResults(PartialResultSet.newBuilder().setResumeToken(token))
        .build();
  }

  public static ExecuteQueryResponse metadata(ColumnMetadata... columnMetadata) {
    ProtoSchema schema =
        ProtoSchema.newBuilder().addAllColumns(Arrays.asList(columnMetadata)).build();
    ResultSetMetadata metadata = ResultSetMetadata.newBuilder().setProtoSchema(schema).build();

    return ExecuteQueryResponse.newBuilder().setMetadata(metadata).build();
  }
}
