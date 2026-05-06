/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.spanner.connection;

import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Value;
import com.google.protobuf.util.Timestamps;
import com.google.spanner.v1.ResultSet;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.Type;
import com.google.spanner.v1.TypeAnnotationCode;
import com.google.spanner.v1.TypeCode;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Utility class for generating {@link ResultSet}s containing columns with all possible data types
 * of Cloud Spanner filled with random data.
 */
public class RandomResultSetGenerator {
  public static Type[] generateAllTypes(Dialect dialect) {
    List<Type> types =
        new ArrayList<Type>(
            Arrays.asList(
                Type.newBuilder().setCode(TypeCode.BOOL).build(),
                Type.newBuilder().setCode(TypeCode.INT64).build(),
                Type.newBuilder().setCode(TypeCode.FLOAT32).build(),
                Type.newBuilder().setCode(TypeCode.FLOAT64).build(),
                dialect == Dialect.POSTGRESQL
                    ? Type.newBuilder()
                        .setCode(TypeCode.NUMERIC)
                        .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                        .build()
                    : Type.newBuilder().setCode(TypeCode.NUMERIC).build(),
                Type.newBuilder().setCode(TypeCode.STRING).build(),
                dialect == Dialect.POSTGRESQL
                    ? Type.newBuilder()
                        .setCode(TypeCode.JSON)
                        .setTypeAnnotation(TypeAnnotationCode.PG_JSONB)
                        .build()
                    : Type.newBuilder().setCode(TypeCode.JSON).build(),
                Type.newBuilder().setCode(TypeCode.BYTES).build(),
                Type.newBuilder().setCode(TypeCode.DATE).build(),
                Type.newBuilder().setCode(TypeCode.UUID).build(),
                Type.newBuilder().setCode(TypeCode.TIMESTAMP).build()));
    if (dialect == Dialect.POSTGRESQL) {
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.INT64)
              .setTypeAnnotation(TypeAnnotationCode.PG_OID)
              .build());
    }
    types.addAll(
        Arrays.asList(
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.BOOL))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.INT64))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.FLOAT32))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.FLOAT64))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(
                    dialect == Dialect.POSTGRESQL
                        ? Type.newBuilder()
                            .setCode(TypeCode.NUMERIC)
                            .setTypeAnnotation(TypeAnnotationCode.PG_NUMERIC)
                        : Type.newBuilder().setCode(TypeCode.NUMERIC))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.STRING))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(
                    dialect == Dialect.POSTGRESQL
                        ? Type.newBuilder()
                            .setCode(TypeCode.JSON)
                            .setTypeAnnotation(TypeAnnotationCode.PG_JSONB)
                        : Type.newBuilder().setCode(TypeCode.JSON))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.BYTES))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.DATE))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.UUID))
                .build(),
            Type.newBuilder()
                .setCode(TypeCode.ARRAY)
                .setArrayElementType(Type.newBuilder().setCode(TypeCode.TIMESTAMP))
                .build()));

    appendProtoTypes(types, dialect);

    if (dialect == Dialect.POSTGRESQL) {
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.ARRAY)
              .setArrayElementType(
                  Type.newBuilder()
                      .setCode(TypeCode.INT64)
                      .setTypeAnnotation(TypeAnnotationCode.PG_OID))
              .build());
    }

    Type[] typeArray = new Type[types.size()];
    typeArray = types.toArray(typeArray);
    return typeArray;
  }

  /** To append Proto & Enum types * */
  private static void appendProtoTypes(List<Type> types, Dialect dialect) {
    if (dialect == Dialect.GOOGLE_STANDARD_SQL) {
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.PROTO)
              .setProtoTypeFqn(SingerInfo.getDescriptor().getFullName())
              .build());
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.ENUM)
              .setProtoTypeFqn(Genre.getDescriptor().getFullName())
              .build());
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.ARRAY)
              .setArrayElementType(
                  Type.newBuilder()
                      .setCode(TypeCode.PROTO)
                      .setProtoTypeFqn(SingerInfo.getDescriptor().getFullName()))
              .build());
      types.add(
          Type.newBuilder()
              .setCode(TypeCode.ARRAY)
              .setArrayElementType(
                  Type.newBuilder()
                      .setCode(TypeCode.ENUM)
                      .setProtoTypeFqn(Genre.getDescriptor().getFullName()))
              .build());
    }
  }

  public static ResultSetMetadata generateAllTypesMetadata(Type[] types) {
    StructType.Builder rowTypeBuilder = StructType.newBuilder();
    for (int col = 0; col < types.length; col++) {
      rowTypeBuilder.addFields(Field.newBuilder().setName("COL" + col).setType(types[col])).build();
    }
    ResultSetMetadata.Builder builder = ResultSetMetadata.newBuilder();
    builder.setRowType(rowTypeBuilder.build());
    return builder.build();
  }

  private final ResultSetMetadata metadata;
  private final Dialect dialect;
  private final Type[] types;
  private final int rowCount;
  private final Random random = new Random();

  public RandomResultSetGenerator(int rowCount) {
    this(rowCount, Dialect.GOOGLE_STANDARD_SQL);
  }

  public RandomResultSetGenerator(int rowCount, Dialect dialect) {
    this.rowCount = rowCount;
    this.dialect = dialect;
    this.types = generateAllTypes(dialect);
    this.metadata = generateAllTypesMetadata(types);
  }

  public ResultSet generate() {
    ResultSet.Builder builder = ResultSet.newBuilder();
    for (int row = 0; row < rowCount; row++) {
      ListValue.Builder rowBuilder = ListValue.newBuilder();
      for (Type type : types) {
        Value.Builder valueBuilder = Value.newBuilder();
        setRandomValue(valueBuilder, type);
        rowBuilder.addValues(valueBuilder.build());
      }
      builder.addRows(rowBuilder.build());
    }
    builder.setMetadata(metadata);
    return builder.build();
  }

  private void setRandomValue(Value.Builder builder, Type type) {
    if (randomNull()) {
      builder.setNullValue(NullValue.NULL_VALUE);
    } else {
      switch (type.getCode()) {
        case ARRAY:
          int length = random.nextInt(20) + 1;
          ListValue.Builder arrayBuilder = ListValue.newBuilder();
          for (int i = 0; i < length; i++) {
            Value.Builder valueBuilder = Value.newBuilder();
            setRandomValue(valueBuilder, type.getArrayElementType());
            arrayBuilder.addValues(valueBuilder.build());
          }
          builder.setListValue(arrayBuilder.build());
          break;
        case BOOL:
          builder.setBoolValue(random.nextBoolean());
          break;
        case STRING:
        case BYTES:
        case PROTO:
          byte[] bytes = new byte[random.nextInt(200)];
          random.nextBytes(bytes);
          builder.setStringValue(BaseEncoding.base64().encode(bytes));
          break;
        case JSON:
          builder.setStringValue("\"" + random.nextInt(200) + "\":\"" + random.nextInt(200) + "\"");
          break;
        case DATE:
          Date date =
              Date.fromYearMonthDay(
                  random.nextInt(2019) + 1, random.nextInt(11) + 1, random.nextInt(28) + 1);
          builder.setStringValue(date.toString());
          break;
        case UUID:
          UUID uuid = UUID.randomUUID();
          builder.setStringValue(uuid.toString());
          break;
        case FLOAT32:
          if (randomNaN()) {
            builder.setNumberValue(Float.NaN);
          } else {
            builder.setNumberValue(random.nextFloat());
          }
          break;
        case FLOAT64:
          if (randomNaN()) {
            builder.setNumberValue(Double.NaN);
          } else {
            builder.setNumberValue(random.nextDouble());
          }
          break;
        case NUMERIC:
          if (dialect == Dialect.POSTGRESQL && randomNaN()) {
            builder.setStringValue("NaN");
          } else {
            builder.setStringValue(
                BigDecimal.valueOf(random.nextDouble())
                    .setScale(9, RoundingMode.HALF_UP)
                    .toString());
          }
          break;
        case INT64:
        case ENUM:
          builder.setStringValue(String.valueOf(random.nextLong()));
          break;
        case TIMESTAMP:
          com.google.protobuf.Timestamp ts =
              Timestamps.add(
                  Timestamps.EPOCH,
                  com.google.protobuf.Duration.newBuilder()
                      .setSeconds(random.nextInt(100_000_000))
                      .setNanos(random.nextInt(1000_000_000))
                      .build());
          builder.setStringValue(Timestamp.fromProto(ts).toString());
          break;
        case STRUCT:
        case TYPE_CODE_UNSPECIFIED:
        case UNRECOGNIZED:
        default:
          throw new IllegalArgumentException("Unknown or unsupported type: " + type.getCode());
      }
    }
  }

  private boolean randomNull() {
    return random.nextInt(10) == 0;
  }

  private boolean randomNaN() {
    return random.nextInt(10) == 0;
  }
}
