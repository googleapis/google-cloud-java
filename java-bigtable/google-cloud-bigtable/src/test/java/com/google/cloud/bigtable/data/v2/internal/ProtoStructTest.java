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
package com.google.cloud.bigtable.data.v2.internal;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.floatValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapElement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structField;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.bigtable.v2.ArrayValue;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.Struct;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ProtoStructTest {

  static ProtoStruct struct =
      ProtoStruct.create(
          (SqlType.Struct)
              SqlType.fromProto(
                  structType(
                      structField("bytesField", bytesType()),
                      structField("stringField", stringType()),
                      structField("longField", int64Type()),
                      structField("doubleField", float64Type()),
                      structField("floatField", float32Type()),
                      structField("booleanField", boolType()),
                      structField("timestampField", timestampType()),
                      structField("dateField", dateType()),
                      structField(
                          "structField", structType(structField("stringField", stringType()))),
                      structField("listField", arrayType(stringType())),
                      structField("mapField", mapType(stringType(), stringType())))),
          arrayValue(
                  bytesValue("testBytes"),
                  stringValue("testString"),
                  int64Value(123),
                  floatValue(1.23),
                  floatValue(1.23),
                  boolValue(true),
                  timestampValue(100000, 100),
                  dateValue(2024, 6, 1),
                  structValue(stringValue("string")),
                  arrayValue(stringValue("foo"), stringValue("bar")),
                  arrayValue(
                      mapElement(stringValue("foo"), stringValue("bar")),
                      mapElement(stringValue("key"), stringValue("val"))))
              .getArrayValue());

  // These are more extensively tested in AbstractProtoStructReaderTest since that is what
  // implements the logic
  @Test
  public void getByIndex_supportsAllTypes() {
    assertThat(struct.getBytes(0)).isEqualTo(ByteString.copyFromUtf8("testBytes"));
    assertThat(struct.getString(1)).isEqualTo("testString");
    assertThat(struct.getLong(2)).isEqualTo(123);
    assertThat(struct.getDouble(3)).isEqualTo(1.23d);
    assertThat(struct.getFloat(4)).isEqualTo(1.23f);
    assertThat(struct.getBoolean(5)).isTrue();
    assertThat(struct.getTimestamp(6)).isEqualTo(Instant.ofEpochSecond(100000, 100));
    assertThat(struct.getDate(7)).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
    assertThat(struct.getStruct(8))
        .isEqualTo(
            ProtoStruct.create(
                (SqlType.Struct)
                    SqlType.fromProto(structType(structField("stringField", stringType()))),
                structValue(stringValue("string")).getArrayValue()));
    assertThat(struct.getList(9, SqlType.arrayOf(SqlType.string())))
        .isEqualTo(Arrays.asList("foo", "bar"));
    assertThat(struct.getMap(10, SqlType.mapOf(SqlType.string(), SqlType.string())))
        .isEqualTo(
            new HashMap<String, String>() {
              {
                put("foo", "bar");
                put("key", "val");
              }
            });
  }

  @Test
  public void getByNameSupportsAllTypes() {
    assertThat(struct.getBytes("bytesField")).isEqualTo(ByteString.copyFromUtf8("testBytes"));
    assertThat(struct.getString("stringField")).isEqualTo("testString");
    assertThat(struct.getLong("longField")).isEqualTo(123);
    assertThat(struct.getDouble("doubleField")).isEqualTo(1.23d);
    assertThat(struct.getFloat("floatField")).isEqualTo(1.23f);
    assertThat(struct.getBoolean("booleanField")).isTrue();
    assertThat(struct.getTimestamp("timestampField")).isEqualTo(Instant.ofEpochSecond(100000, 100));
    assertThat(struct.getDate("dateField")).isEqualTo(Date.fromYearMonthDay(2024, 6, 1));
    assertThat(struct.getStruct("structField"))
        .isEqualTo(
            ProtoStruct.create(
                (SqlType.Struct)
                    SqlType.fromProto(structType(structField("stringField", stringType()))),
                structValue(stringValue("string")).getArrayValue()));
    assertThat(struct.getList("listField", SqlType.arrayOf(SqlType.string())))
        .isEqualTo(Arrays.asList("foo", "bar"));
    assertThat(struct.getMap("mapField", SqlType.mapOf(SqlType.string(), SqlType.string())))
        .isEqualTo(
            new HashMap<String, String>() {
              {
                put("foo", "bar");
                put("key", "val");
              }
            });
  }

  @Test
  public void getColumnType_byName() {
    assertThat(struct.getColumnType("bytesField")).isEqualTo(SqlType.bytes());
    assertThat(struct.getColumnType("stringField")).isEqualTo(SqlType.string());
    assertThat(struct.getColumnType("longField")).isEqualTo(SqlType.int64());
    assertThat(struct.getColumnType("doubleField")).isEqualTo(SqlType.float64());
    assertThat(struct.getColumnType("floatField")).isEqualTo(SqlType.float32());
    assertThat(struct.getColumnType("booleanField")).isEqualTo(SqlType.bool());
    assertThat(struct.getColumnType("timestampField")).isEqualTo(SqlType.timestamp());
    assertThat(struct.getColumnType("dateField")).isEqualTo(SqlType.date());
    assertThat(struct.getColumnType("structField"))
        .isEqualTo(SqlType.fromProto(structType(structField("stringField", stringType()))));
    assertThat(struct.getColumnType("listField")).isEqualTo(SqlType.arrayOf(SqlType.string()));
    assertThat(struct.getColumnType("mapField"))
        .isEqualTo(SqlType.mapOf(SqlType.string(), SqlType.string()));
  }

  @Test
  public void getColumnType_byIndex() {
    assertThat(struct.getColumnType(0)).isEqualTo(SqlType.bytes());
    assertThat(struct.getColumnType(1)).isEqualTo(SqlType.string());
    assertThat(struct.getColumnType(2)).isEqualTo(SqlType.int64());
    assertThat(struct.getColumnType(3)).isEqualTo(SqlType.float64());
    assertThat(struct.getColumnType(4)).isEqualTo(SqlType.float32());
    assertThat(struct.getColumnType(5)).isEqualTo(SqlType.bool());
    assertThat(struct.getColumnType(6)).isEqualTo(SqlType.timestamp());
    assertThat(struct.getColumnType(7)).isEqualTo(SqlType.date());
    assertThat(struct.getColumnType(8))
        .isEqualTo(SqlType.fromProto(structType(structField("stringField", stringType()))));
    assertThat(struct.getColumnType(9)).isEqualTo(SqlType.arrayOf(SqlType.string()));
    assertThat(struct.getColumnType(10))
        .isEqualTo(SqlType.mapOf(SqlType.string(), SqlType.string()));
  }

  @Test
  public void getColumnIndex_worksForExistingColumns() {
    assertThat(struct.getColumnIndex("bytesField")).isEqualTo(0);
    assertThat(struct.getColumnIndex("stringField")).isEqualTo(1);
    assertThat(struct.getColumnIndex("longField")).isEqualTo(2);
    assertThat(struct.getColumnIndex("doubleField")).isEqualTo(3);
    assertThat(struct.getColumnIndex("floatField")).isEqualTo(4);
    assertThat(struct.getColumnIndex("booleanField")).isEqualTo(5);
    assertThat(struct.getColumnIndex("timestampField")).isEqualTo(6);
    assertThat(struct.getColumnIndex("dateField")).isEqualTo(7);
    assertThat(struct.getColumnIndex("structField")).isEqualTo(8);
    assertThat(struct.getColumnIndex("listField")).isEqualTo(9);
    assertThat(struct.getColumnIndex("mapField")).isEqualTo(10);
  }

  @Test
  public void getColumnIndex_throwsExceptionForNonExistentIndex() {
    assertThrows(IllegalArgumentException.class, () -> struct.getColumnIndex("nonexistent"));
  }

  @Test
  public void values_populatedFromFieldValues() {
    List<Value> values = Arrays.asList(stringValue("foo"), stringValue("bar"));
    ProtoStruct s =
        ProtoStruct.create(
            (SqlType.Struct)
                SqlType.fromProto(
                    structType(
                        structField("stringField1", stringType()),
                        structField("stringField2", stringType()))),
            arrayValue(values.toArray(new Value[] {})).getArrayValue());

    assertThat(s.values()).isEqualTo(values);
  }

  @Test
  public void getByColumnIndex_supportsUnnamedColumn() {
    ProtoStruct s =
        ProtoStruct.create(
            // This creates a struct with two unnamed string fields
            (SqlType.Struct) SqlType.fromProto(structType(stringType(), stringType())),
            arrayValue(stringValue("foo"), stringValue("bar")).getArrayValue());

    assertThat(s.getString(0)).isEqualTo("foo");
    assertThat(s.getString(1)).isEqualTo("bar");
  }

  @Test
  public void getByColumnName_supportsUnnamedColumn() {
    ProtoStruct s =
        ProtoStruct.create(
            // This creates a struct with one unnamed string fields
            (SqlType.Struct) SqlType.fromProto(structType(stringType())),
            arrayValue(stringValue("foo")).getArrayValue());

    assertThat(s.getString("")).isEqualTo("foo");
  }

  @Test
  public void emptyStruct_behavesCorrectly() {
    ProtoStruct empty =
        ProtoStruct.create(
            (SqlType.Struct)
                SqlType.fromProto(
                    Type.newBuilder().setStructType(Struct.newBuilder().build()).build()),
            ArrayValue.newBuilder().build());

    assertThrows(IndexOutOfBoundsException.class, () -> empty.getString(0));
    assertThrows(IllegalArgumentException.class, () -> empty.getString(""));
    assertThrows(IndexOutOfBoundsException.class, () -> empty.getColumnType(0));
    assertThrows(IllegalArgumentException.class, () -> empty.getColumnType(""));
  }

  @Test
  public void getColumnIndexOnDuplicateField_throwsException() {
    List<Value> values = Arrays.asList(stringValue("foo"), stringValue("bar"));
    ProtoStruct s =
        ProtoStruct.create(
            (SqlType.Struct)
                SqlType.fromProto(
                    structType(structField("dup", stringType()), structField("dup", stringType()))),
            arrayValue(values.toArray(new Value[] {})).getArrayValue());

    assertThrows(IllegalArgumentException.class, () -> s.getColumnIndex("dup"));
  }

  @Test
  public void getByFieldNameOnDuplicateField_throwsException() {
    List<Value> values = Arrays.asList(stringValue("foo"), stringValue("bar"));
    ProtoStruct s =
        ProtoStruct.create(
            (SqlType.Struct)
                SqlType.fromProto(
                    structType(structField("dup", stringType()), structField("dup", stringType()))),
            arrayValue(values.toArray(new Value[] {})).getArrayValue());

    assertThrows(IllegalArgumentException.class, () -> s.getString("dup"));
  }

  @Test
  public void getByIndex_worksWithDuplicateFieldNames() {
    List<Value> values = Arrays.asList(stringValue("foo"), stringValue("bar"));
    ProtoStruct s =
        ProtoStruct.create(
            (SqlType.Struct)
                SqlType.fromProto(
                    structType(structField("dup", stringType()), structField("dup", stringType()))),
            arrayValue(values.toArray(new Value[] {})).getArrayValue());

    assertThat(s.getString(0)).isEqualTo("foo");
    assertThat(s.getString(1)).isEqualTo("bar");
  }
}
