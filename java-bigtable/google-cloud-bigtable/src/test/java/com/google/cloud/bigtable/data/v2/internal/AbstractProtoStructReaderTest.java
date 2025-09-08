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
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.columnMetadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.enumType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.floatValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Value;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapElement;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.metadata;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.nullValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.protoType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structField;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structValue;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampValue;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.auto.value.AutoValue;
import com.google.bigtable.v2.ColumnMetadata;
import com.google.bigtable.v2.Type;
import com.google.bigtable.v2.Type.KindCase;
import com.google.bigtable.v2.Value;
import com.google.cloud.Date;
import com.google.cloud.bigtable.common.Type.SchemalessEnum;
import com.google.cloud.bigtable.common.Type.SchemalessProto;
import com.google.cloud.bigtable.data.v2.models.sql.ResultSetMetadata;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Album;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Genre;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Singer;
import com.google.protobuf.ByteString;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

@SuppressWarnings("DoubleBraceInitialization")
@RunWith(Enclosed.class)
public class AbstractProtoStructReaderTest {

  // Timestamp can be in micros up to max long
  private static final long MAX_TS_SECONDS = Long.MAX_VALUE / 1000 / 1000;

  @AutoValue
  public abstract static class TestProtoStruct extends AbstractProtoStructReader {
    public static TestProtoStruct create(ResultSetMetadata metadata, List<Value> values) {
      return new AutoValue_AbstractProtoStructReaderTest_TestProtoStruct(values, metadata);
    }

    abstract ResultSetMetadata metadata();

    @Override
    public int getColumnIndex(String columnName) {
      return metadata().getColumnIndex(columnName);
    }

    @Override
    public SqlType<?> getColumnType(int columnIndex) {
      return metadata().getColumnType(columnIndex);
    }
  }

  // New tests should always be added to types test
  // Specific tests we don't want to re-run for each type go here
  @RunWith(JUnit4.class)
  public static class OneOffTests {
    @Test
    public void simpleMapField_validatesType() {
      TestProtoStruct structWithMap =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(columnMetadata("testField", mapType(bytesType(), stringType())))),
              Collections.singletonList(
                  mapValue(
                      mapElement(bytesValue("foo"), stringValue("bar")),
                      mapElement(bytesValue("key"), stringValue("val")))));
      HashMap<ByteString, String> expectedMap = new HashMap<>();
      expectedMap.put(ByteString.copyFromUtf8("foo"), "bar");
      expectedMap.put(ByteString.copyFromUtf8("key"), "val");

      assertThat(
              structWithMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.string())))
          .isEqualTo(expectedMap);
      assertThat(structWithMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.string())))
          .isEqualTo(expectedMap);

      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
    }

    @Test
    public void nestedMapField_validatesType() {
      TestProtoStruct historicalMap =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(
                      columnMetadata(
                          "testField",
                          mapType(
                              bytesType(),
                              arrayType(
                                  structType(
                                      structField("timestamp", timestampType()),
                                      structField("value", bytesType()))))))),
              Collections.singletonList(
                  mapValue(
                      mapElement(
                          bytesValue("qual"),
                          arrayValue(
                              structValue(timestampValue(10000, 100), bytesValue("test1")),
                              structValue(timestampValue(20000, 100), bytesValue("test2")))))));

      HashMap<ByteString, List<Struct>> expectedMap = new HashMap<>();
      expectedMap.put(
          ByteString.copyFromUtf8("qual"),
          Arrays.asList(
              ProtoStruct.create(
                  (SqlType.Struct)
                      SqlType.fromProto(
                          structType(
                              structField("timestamp", timestampType()),
                              structField("value", bytesType()))),
                  arrayValue(timestampValue(10000, 100), bytesValue("test1")).getArrayValue()),
              ProtoStruct.create(
                  (SqlType.Struct)
                      SqlType.fromProto(
                          structType(
                              structField("timestamp", timestampType()),
                              structField("value", bytesType()))),
                  arrayValue(timestampValue(20000, 100), bytesValue("test2")).getArrayValue())));

      assertThat(historicalMap.getMap("testField", SqlType.historicalMap())).isEqualTo(expectedMap);
      assertThat(historicalMap.getMap(0, SqlType.historicalMap())).isEqualTo(expectedMap);

      assertThrows(
          IllegalStateException.class,
          () -> historicalMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () ->
              historicalMap.getMap(
                  "testField", SqlType.mapOf(SqlType.bytes(), SqlType.arrayOf(SqlType.string()))));
      assertThrows(
          IllegalStateException.class,
          () -> historicalMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () ->
              historicalMap.getMap(
                  0, SqlType.mapOf(SqlType.bytes(), SqlType.arrayOf(SqlType.string()))));
    }

    @Test
    public void arrayField_validatesType() {
      TestProtoStruct structWithList =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(columnMetadata("testField", arrayType(stringType())))),
              Collections.singletonList(arrayValue(stringValue("foo"), stringValue("bar"))));
      List<String> expectedList = Arrays.asList("foo", "bar");

      assertThat(structWithList.getList("testField", SqlType.arrayOf(SqlType.string())))
          .isEqualTo(expectedList);
      assertThat(structWithList.getList(0, SqlType.arrayOf(SqlType.string())))
          .isEqualTo(expectedList);

      assertThrows(
          IllegalStateException.class,
          () -> structWithList.getList("testField", SqlType.arrayOf(SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithList.getList(0, SqlType.arrayOf(SqlType.bytes())));
    }

    // Test this independently since it won't throw an exception until accessing an element if
    // float is converted to double incorrectly
    @Test
    public void arrayField_accessingFloat() {
      TestProtoStruct structWithList =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(columnMetadata("testField", arrayType(float32Type())))),
              Collections.singletonList(arrayValue(floatValue(1.1f), floatValue(1.2f))));

      List<Float> floatList =
          structWithList.getList("testField", SqlType.arrayOf(SqlType.float32()));
      assertThat(floatList.get(0)).isEqualTo(1.1f);
      assertThat(floatList.get(1)).isEqualTo(1.2f);
    }

    // Test this independently since it verifies that parsing fails when data is deserialized into
    // an incompatible Protobuf message, which is highly proto-specific.
    @Test
    public void mapField_accessingProto() {
      Singer singer = Singer.newBuilder().setName("Foo").setGenre(Genre.POP).build();
      TestProtoStruct structWithMap =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(
                      columnMetadata(
                          "testField",
                          mapType(
                              bytesType(),
                              protoType("com.google.cloud.bigtable.data.v2.test.Singer"))))),
              Collections.singletonList(
                  mapValue(mapElement(bytesValue("key"), bytesValue(singer.toByteArray())))));
      HashMap<ByteString, Singer> expectedMap = new HashMap<>();
      expectedMap.put(ByteString.copyFromUtf8("key"), singer);

      assertThat(
              structWithMap.getMap(
                  "testField",
                  SqlType.mapOf(SqlType.bytes(), SqlType.protoOf(Singer.getDefaultInstance()))))
          .isEqualTo(expectedMap);
      assertThat(
              structWithMap.getMap(
                  0, SqlType.mapOf(SqlType.bytes(), SqlType.protoOf(Singer.getDefaultInstance()))))
          .isEqualTo(expectedMap);

      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  "testField",
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Singer"))));
      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  0,
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Singer"))));
      assertThrows(
          IllegalStateException.class,
          () ->
              structWithMap.getMap(
                  "testField",
                  SqlType.mapOf(SqlType.bytes(), SqlType.protoOf(Album.getDefaultInstance()))));
      assertThrows(
          IllegalStateException.class,
          () ->
              structWithMap.getMap(
                  0, SqlType.mapOf(SqlType.bytes(), SqlType.protoOf(Album.getDefaultInstance()))));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
    }

    // Test this independently since it performs enum-specific verifications.
    @Test
    public void mapField_accessingEnum() {
      TestProtoStruct structWithMap =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(
                      columnMetadata(
                          "testField",
                          mapType(
                              bytesType(),
                              enumType("com.google.cloud.bigtable.data.v2.test.Genre"))))),
              Collections.singletonList(mapValue(mapElement(bytesValue("key"), int64Value(0)))));
      HashMap<ByteString, Genre> expectedMap = new HashMap<>();
      expectedMap.put(ByteString.copyFromUtf8("key"), Genre.POP);

      assertThat(
              structWithMap.getMap(
                  "testField", SqlType.mapOf(SqlType.bytes(), SqlType.enumOf(Genre::forNumber))))
          .isEqualTo(expectedMap);
      assertThat(
              structWithMap.getMap(
                  0, SqlType.mapOf(SqlType.bytes(), SqlType.enumOf(Genre::forNumber))))
          .isEqualTo(expectedMap);

      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  "testField",
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre"))));
      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  0,
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre"))));
      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  "testField",
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre"))));
      assertThrows(
          UnsupportedOperationException.class,
          () ->
              structWithMap.getMap(
                  0,
                  SqlType.mapOf(
                      SqlType.bytes(),
                      SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre"))));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap("testField", SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
      assertThrows(
          IllegalStateException.class,
          () -> structWithMap.getMap(0, SqlType.mapOf(SqlType.bytes(), SqlType.bytes())));
    }
  }

  @RunWith(Parameterized.class)
  public static class TypesTest {
    @Parameterized.Parameters()
    public static List<Object[]> parameters() {
      return Arrays.asList(
          new Object[][] {
            // Bytes
            {
              Collections.singletonList(columnMetadata("testField", bytesType())),
              Collections.singletonList(bytesValue("test")),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, ByteString>) TestProtoStruct::getBytes,
              (BiFunction<TestProtoStruct, Integer, ByteString>) TestProtoStruct::getBytes,
              ByteString.copyFromUtf8("test")
            },
            // String
            {
              Collections.singletonList(columnMetadata("testField", stringType())),
              Collections.singletonList(stringValue("test")),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, String>) TestProtoStruct::getString,
              (BiFunction<TestProtoStruct, Integer, String>) TestProtoStruct::getString,
              "test"
            },
            // Long
            {
              Collections.singletonList(columnMetadata("testField", int64Type())),
              Collections.singletonList(int64Value(110L)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Long>) TestProtoStruct::getLong,
              (BiFunction<TestProtoStruct, Integer, Long>) TestProtoStruct::getLong,
              110L
            },
            // Double
            {
              Collections.singletonList(columnMetadata("testField", float64Type())),
              Collections.singletonList(floatValue(100.3d)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Double>) TestProtoStruct::getDouble,
              (BiFunction<TestProtoStruct, Integer, Double>) TestProtoStruct::getDouble,
              100.3d
            },
            // Float
            {
              Collections.singletonList(columnMetadata("testField", float32Type())),
              Collections.singletonList(floatValue(100.3f)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Float>) TestProtoStruct::getFloat,
              (BiFunction<TestProtoStruct, Integer, Float>) TestProtoStruct::getFloat,
              100.3f
            },
            // Boolean
            {
              Collections.singletonList(columnMetadata("testField", boolType())),
              Collections.singletonList(boolValue(true)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Boolean>) TestProtoStruct::getBoolean,
              (BiFunction<TestProtoStruct, Integer, Boolean>) TestProtoStruct::getBoolean,
              true
            },
            // Timestamp
            {
              Collections.singletonList(columnMetadata("testField", timestampType())),
              Collections.singletonList(timestampValue(1000000, 100)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Instant>) TestProtoStruct::getTimestamp,
              (BiFunction<TestProtoStruct, Integer, Instant>) TestProtoStruct::getTimestamp,
              Instant.ofEpochSecond(1000000, 100)
            },
            // MAX long timestamp - bigtable allows users to set timestamp micros to any long
            // so the client should parse them. In practice the server doesn't currently,
            // support timestamps this large.
            {
              Collections.singletonList(columnMetadata("testField", timestampType())),
              Collections.singletonList(timestampValue(MAX_TS_SECONDS, 0)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Instant>) TestProtoStruct::getTimestamp,
              (BiFunction<TestProtoStruct, Integer, Instant>) TestProtoStruct::getTimestamp,
              Instant.ofEpochSecond(MAX_TS_SECONDS)
            },
            // Date
            {
              Collections.singletonList(columnMetadata("testField", dateType())),
              Collections.singletonList(dateValue(2024, 6, 1)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Date>) TestProtoStruct::getDate,
              (BiFunction<TestProtoStruct, Integer, Date>) TestProtoStruct::getDate,
              Date.fromYearMonthDay(2024, 6, 1)
            },
            // Struct
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField",
                      structType(
                          structField("stringField", stringType()),
                          structField("intField", int64Type()),
                          structField("listField", arrayType(stringType())),
                          structField("protoField", protoType("MyMessage")),
                          structField("enumField", enumType("MyEnum"))))),
              Collections.singletonList(
                  arrayValue(
                      stringValue("test"),
                      int64Value(100),
                      arrayValue(stringValue("nested"), stringValue("nested2")),
                      bytesValue("proto"),
                      int64Value(1))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Struct>) TestProtoStruct::getStruct,
              (BiFunction<TestProtoStruct, Integer, Struct>) TestProtoStruct::getStruct,
              ProtoStruct.create(
                  (SqlType.Struct)
                      SqlType.fromProto(
                          structType(
                              structField("stringField", stringType()),
                              structField("intField", int64Type()),
                              structField("listField", arrayType(stringType())),
                              structField("protoField", protoType("MyMessage")),
                              structField("enumField", enumType("MyEnum")))),
                  arrayValue(
                          stringValue("test"),
                          int64Value(100),
                          arrayValue(stringValue("nested"), stringValue("nested2")),
                          bytesValue("proto"),
                          int64Value(1))
                      .getArrayValue())
            },
            // Simple List
            {
              Collections.singletonList(columnMetadata("testField", arrayType(stringType()))),
              Collections.singletonList(
                  arrayValue(stringValue("foo"), stringValue("bar"), stringValue("baz"))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<String>>)
                  (row, field) -> row.getList(field, SqlType.arrayOf(SqlType.string())),
              (BiFunction<TestProtoStruct, Integer, List<String>>)
                  (row, index) -> row.getList(index, SqlType.arrayOf(SqlType.string())),
              Arrays.asList("foo", "bar", "baz")
            },
            // List With Null Values
            {
              Collections.singletonList(columnMetadata("testField", arrayType(stringType()))),
              Collections.singletonList(
                  arrayValue(stringValue("foo"), nullValue(), stringValue("baz"))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<String>>)
                  (row, field) -> row.getList(field, SqlType.arrayOf(SqlType.string())),
              (BiFunction<TestProtoStruct, Integer, List<String>>)
                  (row, index) -> row.getList(index, SqlType.arrayOf(SqlType.string())),
              Arrays.asList("foo", null, "baz")
            },
            // Float List
            {
              Collections.singletonList(columnMetadata("testField", arrayType(float32Type()))),
              Collections.singletonList(
                  arrayValue(floatValue(1.1f), floatValue(1.2f), floatValue(1.3f))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<Float>>)
                  (row, field) -> row.getList(field, SqlType.arrayOf(SqlType.float32())),
              (BiFunction<TestProtoStruct, Integer, List<Float>>)
                  (row, index) -> row.getList(index, SqlType.arrayOf(SqlType.float32())),
              Arrays.asList(1.1f, 1.2f, 1.3f)
            },
            // Double List
            {
              Collections.singletonList(columnMetadata("testField", arrayType(float64Type()))),
              Collections.singletonList(
                  arrayValue(floatValue(1.11d), floatValue(1.22d), floatValue(1.33d))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<Double>>)
                  (row, field) -> row.getList(field, SqlType.arrayOf(SqlType.float64())),
              (BiFunction<TestProtoStruct, Integer, List<Double>>)
                  (row, index) -> row.getList(index, SqlType.arrayOf(SqlType.float64())),
              Arrays.asList(1.11d, 1.22d, 1.33d)
            },
            // Simple Map
            {
              Collections.singletonList(
                  columnMetadata("testField", mapType(bytesType(), stringType()))),
              Collections.singletonList(
                  mapValue(
                      mapElement(bytesValue("foo"), stringValue("bar")),
                      mapElement(bytesValue("key"), stringValue("val")))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, String>>)
                  (row, field) ->
                      row.getMap(field, SqlType.mapOf(SqlType.bytes(), SqlType.string())),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, String>>)
                  (row, index) ->
                      row.getMap(index, SqlType.mapOf(SqlType.bytes(), SqlType.string())),
              new HashMap<ByteString, String>() {
                {
                  put(ByteString.copyFromUtf8("foo"), "bar");
                  put(ByteString.copyFromUtf8("key"), "val");
                }
              }
            },
            // Map With Null Keys and Values
            {
              Collections.singletonList(
                  columnMetadata("testField", mapType(bytesType(), stringType()))),
              Collections.singletonList(
                  mapValue(
                      mapElement(bytesValue("foo"), nullValue()),
                      mapElement(nullValue(), stringValue("val")))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, String>>)
                  (row, field) ->
                      row.getMap(field, SqlType.mapOf(SqlType.bytes(), SqlType.string())),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, String>>)
                  (row, index) ->
                      row.getMap(index, SqlType.mapOf(SqlType.bytes(), SqlType.string())),
              new HashMap<ByteString, String>() {
                {
                  put(ByteString.copyFromUtf8("foo"), null);
                  put(null, "val");
                }
              }
            },
            // Map With List Values
            {
              Collections.singletonList(
                  columnMetadata("testField", mapType(bytesType(), arrayType(stringType())))),
              Collections.singletonList(
                  mapValue(
                      mapElement(
                          bytesValue("key1"), arrayValue(stringValue("1.1"), stringValue("1.2"))),
                      mapElement(bytesValue("key2"), arrayValue(stringValue("2.1"))))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, List<String>>>)
                  (row, field) ->
                      row.getMap(
                          field, SqlType.mapOf(SqlType.bytes(), SqlType.arrayOf(SqlType.string()))),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, List<String>>>)
                  (row, index) ->
                      row.getMap(
                          index, SqlType.mapOf(SqlType.bytes(), SqlType.arrayOf(SqlType.string()))),
              new HashMap<ByteString, List<String>>() {
                {
                  put(ByteString.copyFromUtf8("key1"), Arrays.asList("1.1", "1.2"));
                  put(ByteString.copyFromUtf8("key2"), Collections.singletonList("2.1"));
                }
              }
            },
            {
              Collections.singletonList(
                  columnMetadata(
                      "historicalField",
                      mapType(
                          bytesType(),
                          arrayType(
                              structType(
                                  structField("timestamp", timestampType()),
                                  structField("value", bytesType())))))),
              Collections.singletonList(
                  mapValue(
                      mapElement(
                          bytesValue("qual"),
                          arrayValue(
                              structValue(timestampValue(10000, 100), bytesValue("test1")),
                              structValue(timestampValue(20000, 100), bytesValue("test2")))))),
              0,
              "historicalField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, List<Struct>>>)
                  (row, field) -> row.getMap(field, SqlType.historicalMap()),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, List<Struct>>>)
                  (row, index) -> row.getMap(index, SqlType.historicalMap()),
              new HashMap<ByteString, List<Struct>>() {
                {
                  put(
                      ByteString.copyFromUtf8("qual"),
                      Arrays.asList(
                          ProtoStruct.create(
                              (SqlType.Struct)
                                  SqlType.fromProto(
                                      structType(
                                          structField("timestamp", timestampType()),
                                          structField("value", bytesType()))),
                              arrayValue(timestampValue(10000, 100), bytesValue("test1"))
                                  .getArrayValue()),
                          ProtoStruct.create(
                              (SqlType.Struct)
                                  SqlType.fromProto(
                                      structType(
                                          structField("timestamp", timestampType()),
                                          structField("value", bytesType()))),
                              arrayValue(timestampValue(20000, 100), bytesValue("test2"))
                                  .getArrayValue())));
                }
              },
            },
            // Proto
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField", protoType("com.google.cloud.bigtable.data.v2.test.Singer"))),
              Collections.singletonList(
                  bytesValue(
                      Singer.newBuilder()
                          .setName("Foo")
                          .setGenre(Genre.POP)
                          .build()
                          .toByteArray())),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Singer>)
                  (row, field) -> row.getProtoMessage(field, Singer.getDefaultInstance()),
              (BiFunction<TestProtoStruct, Integer, Singer>)
                  (row, index) -> row.getProtoMessage(index, Singer.getDefaultInstance()),
              Singer.newBuilder().setName("Foo").setGenre(Genre.POP).build()
            },
            // Proto List
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField",
                      arrayType(protoType("com.google.cloud.bigtable.data.v2.test.Singer")))),
              Collections.singletonList(
                  arrayValue(
                      bytesValue(
                          Singer.newBuilder()
                              .setName("Foo")
                              .setGenre(Genre.POP)
                              .build()
                              .toByteArray()),
                      bytesValue(
                          Singer.newBuilder()
                              .setName("Bar")
                              .setGenre(Genre.JAZZ)
                              .build()
                              .toByteArray()))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<Singer>>)
                  (row, field) ->
                      row.getList(
                          field, SqlType.arrayOf(SqlType.protoOf(Singer.getDefaultInstance()))),
              (BiFunction<TestProtoStruct, Integer, List<Singer>>)
                  (row, index) ->
                      row.getList(
                          index, SqlType.arrayOf(SqlType.protoOf(Singer.getDefaultInstance()))),
              Arrays.asList(
                  Singer.newBuilder().setName("Foo").setGenre(Genre.POP).build(),
                  Singer.newBuilder().setName("Bar").setGenre(Genre.JAZZ).build())
            },
            // Proto Map
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField",
                      mapType(
                          bytesType(),
                          protoType("com.google.cloud.bigtable.data.v2.test.Singer")))),
              Collections.singletonList(
                  mapValue(
                      mapElement(
                          bytesValue("foo"),
                          bytesValue(
                              Singer.newBuilder()
                                  .setName("Foo")
                                  .setGenre(Genre.POP)
                                  .build()
                                  .toByteArray())),
                      mapElement(
                          bytesValue("key"),
                          bytesValue(
                              Singer.newBuilder()
                                  .setName("Bar")
                                  .setGenre(Genre.JAZZ)
                                  .build()
                                  .toByteArray())))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, Singer>>)
                  (row, field) ->
                      row.getMap(
                          field,
                          SqlType.mapOf(
                              SqlType.bytes(), SqlType.protoOf(Singer.getDefaultInstance()))),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, Singer>>)
                  (row, index) ->
                      row.getMap(
                          index,
                          SqlType.mapOf(
                              SqlType.bytes(), SqlType.protoOf(Singer.getDefaultInstance()))),
              new HashMap<ByteString, Singer>() {
                {
                  put(
                      ByteString.copyFromUtf8("foo"),
                      Singer.newBuilder().setName("Foo").setGenre(Genre.POP).build());
                  put(
                      ByteString.copyFromUtf8("key"),
                      Singer.newBuilder().setName("Bar").setGenre(Genre.JAZZ).build());
                }
              }
            },
            // Enum
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField", enumType("com.google.cloud.bigtable.data.v2.test.Genre"))),
              Collections.singletonList(int64Value(1)),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Genre>)
                  (row, field) -> row.getProtoEnum(field, Genre::forNumber),
              (BiFunction<TestProtoStruct, Integer, Genre>)
                  (row, index) -> row.getProtoEnum(index, Genre::forNumber),
              Genre.JAZZ
            },
            // Enum List
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField",
                      arrayType(enumType("com.google.cloud.bigtable.data.v2.test.Genre")))),
              Collections.singletonList(arrayValue(nullValue(), int64Value(2), int64Value(100))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, List<Genre>>)
                  (row, field) ->
                      row.getList(field, SqlType.arrayOf(SqlType.enumOf(Genre::forNumber))),
              (BiFunction<TestProtoStruct, Integer, List<Genre>>)
                  (row, index) ->
                      row.getList(index, SqlType.arrayOf(SqlType.enumOf(Genre::forNumber))),
              Arrays.asList(null, Genre.FOLK, null)
            },
            // Enum Map
            {
              Collections.singletonList(
                  columnMetadata(
                      "testField",
                      mapType(
                          bytesType(), enumType("com.google.cloud.bigtable.data.v2.test.Genre")))),
              Collections.singletonList(
                  mapValue(
                      mapElement(bytesValue("foo"), int64Value(1)),
                      mapElement(bytesValue("key"), int64Value(2)))),
              0,
              "testField",
              (BiFunction<TestProtoStruct, String, Map<ByteString, Genre>>)
                  (row, field) ->
                      row.getMap(
                          field, SqlType.mapOf(SqlType.bytes(), SqlType.enumOf(Genre::forNumber))),
              (BiFunction<TestProtoStruct, Integer, Map<ByteString, Genre>>)
                  (row, index) ->
                      row.getMap(
                          index, SqlType.mapOf(SqlType.bytes(), SqlType.enumOf(Genre::forNumber))),
              new HashMap<ByteString, Genre>() {
                {
                  put(ByteString.copyFromUtf8("foo"), Genre.JAZZ);
                  put(ByteString.copyFromUtf8("key"), Genre.FOLK);
                }
              }
            }
          });
    }

    @Parameter(value = 0)
    public List<ColumnMetadata> schema;

    @Parameter(value = 1)
    public List<Value> values;

    @Parameter(value = 2)
    public Integer index;

    @Parameter(value = 3)
    public String columnName;

    @Parameter(value = 4)
    public BiFunction<TestProtoStruct, String, Object> getByColumn;

    @Parameter(value = 5)
    public BiFunction<TestProtoStruct, Integer, Object> getByIndex;

    @Parameter(value = 6)
    public Object expectedJavaValue;

    private TestProtoStruct getTestRow() {
      return TestProtoStruct.create(
          ProtoResultSetMetadata.fromProto(metadata(schema.toArray(new ColumnMetadata[] {}))),
          values);
    }

    @Test
    public void getByColumnName_convertsValues() {
      assertThat(getByColumn.apply(getTestRow(), columnName)).isEqualTo(expectedJavaValue);
    }

    @Test
    public void getByIndex_convertsValues() {
      assertThat(getByIndex.apply(getTestRow(), index)).isEqualTo(expectedJavaValue);
    }

    @Test
    public void getByColumnName_throwsExceptionOnNonExistentColumn() {
      assertThrows(
          IllegalArgumentException.class, () -> getByColumn.apply(getTestRow(), "invalid"));
    }

    @Test
    public void getByColumnIndex_throwsExceptionOnNonExistentColumn() {
      // Assume none of the tests have 10k columns
      assertThrows(IndexOutOfBoundsException.class, () -> getByIndex.apply(getTestRow(), 10000));
    }

    @Test
    public void getByColumnIndex_throwsNullPointerOnNullValue() {
      TestProtoStruct row =
          TestProtoStruct.create(
              getTestRow().metadata(),
              schema.stream()
                  .map((ColumnMetadata t) -> SqlProtoFactory.nullValue())
                  .collect(Collectors.toList()));

      assertThrows(NullPointerException.class, () -> getByIndex.apply(row, index));
    }

    @Test
    public void getByColumnName_throwsNullPointerOnNullValue() {
      TestProtoStruct row =
          TestProtoStruct.create(
              getTestRow().metadata(),
              schema.stream()
                  .map((ColumnMetadata t) -> SqlProtoFactory.nullValue())
                  .collect(Collectors.toList()));

      assertThrows(NullPointerException.class, () -> getByColumn.apply(row, columnName));
    }

    @Test
    public void getByColumnIndex_throwsExceptionOnWrongType() {
      // Replace the given column with a column of a different type
      Type updatedType = stringType();
      Value updatedValue = stringValue("test");
      if (schema.get(index).getType().getKindCase().equals(KindCase.STRING_TYPE)) {
        updatedType = int64Type();
        updatedValue = int64Value(1000);
      }
      List<ColumnMetadata> updatedSchema = new ArrayList<>(schema);
      updatedSchema.set(index, columnMetadata(columnName, updatedType));
      List<Value> updatedValues = new ArrayList<>(values);
      updatedValues.set(index, updatedValue);
      TestProtoStruct row =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(updatedSchema.toArray(new ColumnMetadata[] {}))),
              updatedValues);

      assertThrows(IllegalStateException.class, () -> getByIndex.apply(row, index));
    }

    @Test
    public void getByColumnName_throwsExceptionOnWrongType() {
      // Replace the given column with a column of a different type
      Type updatedType = stringType();
      Value updatedValue = stringValue("test");
      if (schema.get(index).getType().getKindCase().equals(KindCase.STRING_TYPE)) {
        updatedType = int64Type();
        updatedValue = int64Value(1000);
      }
      List<ColumnMetadata> updatedSchema = new ArrayList<>(schema);
      updatedSchema.set(index, columnMetadata(columnName, updatedType));
      List<Value> updatedValues = new ArrayList<>(values);
      updatedValues.set(index, updatedValue);
      TestProtoStruct row =
          TestProtoStruct.create(
              ProtoResultSetMetadata.fromProto(
                  metadata(updatedSchema.toArray(new ColumnMetadata[] {}))),
              updatedValues);

      assertThrows(IllegalStateException.class, () -> getByColumn.apply(row, columnName));
    }

    @Test
    public void isNull_worksForNullValues() {
      TestProtoStruct row =
          TestProtoStruct.create(
              getTestRow().metadata(),
              schema.stream()
                  .map((ColumnMetadata t) -> SqlProtoFactory.nullValue())
                  .collect(Collectors.toList()));

      assertTrue(row.isNull(columnName));
      assertTrue(row.isNull(index));
    }

    @Test
    public void isNull_worksForNonNullValues() {
      assertFalse(getTestRow().isNull(columnName));
      assertFalse(getTestRow().isNull(index));
    }

    @Test
    public void getColumnTypeByName() {
      assertThat(SqlType.fromProto(schema.get(index).getType()))
          .isEqualTo(getTestRow().getColumnType(columnName));
    }

    // consider moving it to non-parameterized test
    @Test
    public void getByColumnName_throwsExceptionForDuplicateColumnName() {
      // Add all fields to the schema twice
      List<ColumnMetadata> duplicatedSchema = new ArrayList<>(schema);
      duplicatedSchema.addAll(schema);
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(duplicatedSchema.toArray(new ColumnMetadata[] {})));
      List<Value> duplicatedValues = new ArrayList<>(values);
      duplicatedValues.addAll(values);
      TestProtoStruct row = TestProtoStruct.create(metadata, duplicatedValues);

      assertThrows(IllegalArgumentException.class, () -> getByColumn.apply(row, columnName));
    }

    @Test
    public void getByIndex_worksWithDuplicateColumnName() {
      // Add all fields to the schema twice
      List<ColumnMetadata> duplicatedSchema = new ArrayList<>(schema);
      duplicatedSchema.addAll(schema);
      ResultSetMetadata metadata =
          ProtoResultSetMetadata.fromProto(
              metadata(duplicatedSchema.toArray(new ColumnMetadata[] {})));
      List<Value> duplicatedValues = new ArrayList<>(values);
      duplicatedValues.addAll(values);
      TestProtoStruct row = TestProtoStruct.create(metadata, duplicatedValues);

      assertThat(expectedJavaValue).isEqualTo(getByIndex.apply(row, index));
    }
  }
}
