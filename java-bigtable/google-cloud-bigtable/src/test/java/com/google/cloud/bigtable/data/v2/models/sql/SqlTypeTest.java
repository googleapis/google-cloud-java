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
package com.google.cloud.bigtable.data.v2.models.sql;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.boolType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.dateType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.enumType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float32Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.float64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.protoType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structField;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.Type;
import com.google.cloud.bigtable.common.Type.SchemalessEnum;
import com.google.cloud.bigtable.common.Type.SchemalessProto;
import com.google.cloud.bigtable.common.Type.StructWithSchema;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType.Code;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Album;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Format;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Genre;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Singer;
import com.google.protobuf.ByteString;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SqlTypeTest {

  private HashMap<Type, SqlType<?>> protoToJavaMapping;

  @Before
  public void setUp() {
    protoToJavaMapping = new HashMap<>();
    protoToJavaMapping.put(bytesType(), SqlType.bytes());
    protoToJavaMapping.put(stringType(), SqlType.string());
    protoToJavaMapping.put(int64Type(), SqlType.int64());
    protoToJavaMapping.put(float32Type(), SqlType.float32());
    protoToJavaMapping.put(float64Type(), SqlType.float64());
    protoToJavaMapping.put(boolType(), SqlType.bool());
    protoToJavaMapping.put(timestampType(), SqlType.timestamp());
    protoToJavaMapping.put(dateType(), SqlType.date());
    protoToJavaMapping.put(
        structType(structField("foo", stringType()), structField("bar", int64Type())),
        new StructWithSchema(
            Arrays.asList(
                StructWithSchema.Field.fromProto(structField("foo", stringType())),
                StructWithSchema.Field.fromProto(structField("bar", int64Type())))));
    protoToJavaMapping.put(arrayType(stringType()), SqlType.arrayOf(SqlType.string()));
    protoToJavaMapping.put(
        mapType(bytesType(), stringType()), SqlType.mapOf(SqlType.bytes(), SqlType.string()));
    protoToJavaMapping.put(protoType("foo"), SchemalessProto.create("foo"));
    protoToJavaMapping.put(enumType("foo"), SchemalessEnum.create("foo"));
  }

  @Test
  public void fromProto_supportsAllTypes() {
    EnumSet<Code> allCodes = EnumSet.allOf(SqlType.Code.class);
    for (Map.Entry<Type, SqlType<?>> entry : protoToJavaMapping.entrySet()) {
      SqlType<?> converted = SqlType.fromProto(entry.getKey());
      assertThat(converted).isEqualTo(entry.getValue());
      allCodes.remove(converted.getCode());
    }
    assertThat(allCodes).isEmpty();
  }

  @Test
  public void typesMatch_supportsAllTypes() {
    EnumSet<Code> allCodes = EnumSet.allOf(SqlType.Code.class);

    for (Map.Entry<Type, SqlType<?>> entry : protoToJavaMapping.entrySet()) {
      SqlType<?> type = entry.getValue();
      SqlType<?> copyOfType = SqlType.fromProto(entry.getKey());
      assertThat(SqlType.typesMatch(type, copyOfType)).isTrue();
      SqlType<?> otherType =
          type.getCode().equals(Code.STRING) ? SqlType.bytes() : SqlType.string();
      assertThat(SqlType.typesMatch(type, otherType)).isFalse();
      allCodes.remove(type.getCode());
    }

    assertThat(allCodes).isEmpty();
  }

  @Test
  public void historicalMap_matchesProto() {
    SqlType<?> expected =
        SqlType.fromProto(
            mapType(
                bytesType(),
                arrayType(
                    structType(
                        structField("timestamp", timestampType()),
                        structField("value", bytesType())))));
    assertThat(SqlType.typesMatch(SqlType.historicalMap(), expected)).isTrue();
  }

  @Test
  public void typesMatch_ignoresStructSchema() {
    SqlType.Struct schemalessStruct = SqlType.struct();
    Type structProto =
        structType(structField("timestamp", timestampType()), structField("value", bytesType()));
    StructWithSchema structWithSchema = StructWithSchema.fromProto(structProto.getStructType());
    SqlType.Array<Struct> arrayNestedSchemaless = SqlType.arrayOf(SqlType.struct());
    SqlType<?> arrayNestedSchema = SqlType.fromProto(arrayType(structProto));
    SqlType.Map<ByteString, List<Struct>> historicalMapSchemaless = SqlType.historicalMap();
    SqlType<?> mapNestedSchema = SqlType.fromProto(mapType(bytesType(), arrayType(structProto)));

    assertThat(SqlType.typesMatch(schemalessStruct, structWithSchema)).isTrue();
    assertThat(SqlType.typesMatch(arrayNestedSchema, arrayNestedSchemaless)).isTrue();
    assertThat(SqlType.typesMatch(historicalMapSchemaless, mapNestedSchema)).isTrue();
  }

  @Test
  public void typesMatch_checksArrayElements() {
    SqlType.Array<String> stringArray = SqlType.arrayOf(SqlType.string());
    SqlType.Array<ByteString> bytesArray = SqlType.arrayOf(SqlType.bytes());
    SqlType.Array<List<String>> nestedStringArray =
        SqlType.arrayOf(SqlType.arrayOf(SqlType.string()));
    SqlType.Array<List<ByteString>> nestedBytesArray =
        SqlType.arrayOf(SqlType.arrayOf(SqlType.bytes()));

    assertThat(SqlType.typesMatch(stringArray, bytesArray)).isFalse();
    assertThat(SqlType.typesMatch(nestedStringArray, nestedBytesArray)).isFalse();
  }

  @Test
  public void typesMatch_checksMapSchema() {
    SqlType.Map<ByteString, ByteString> bytesBytesMap =
        SqlType.mapOf(SqlType.bytes(), SqlType.bytes());
    SqlType.Map<String, ByteString> bytesStringMap =
        SqlType.mapOf(SqlType.string(), SqlType.bytes());
    SqlType.Map<ByteString, String> stringBytesMap =
        SqlType.mapOf(SqlType.bytes(), SqlType.string());

    assertThat(SqlType.typesMatch(bytesBytesMap, bytesStringMap)).isFalse();
    assertThat(SqlType.typesMatch(bytesBytesMap, stringBytesMap)).isFalse();
    assertThat(
            SqlType.typesMatch(
                SqlType.mapOf(SqlType.bytes(), bytesBytesMap),
                SqlType.mapOf(SqlType.bytes(), bytesStringMap)))
        .isFalse();
  }

  @Test
  public void typesMatch_checksProto() {
    SqlType.Proto<Singer> singerProto = SqlType.protoOf(Singer.getDefaultInstance());
    SqlType.Proto<Album> albumProto = SqlType.protoOf(Album.getDefaultInstance());
    SqlType.Proto schemalessSinger =
        SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Singer");
    SqlType.Proto schemalessAlbum =
        SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Album");

    // Both Schemaless types
    assertThat(SqlType.typesMatch(schemalessSinger, schemalessAlbum)).isFalse();
    assertThat(
            SqlType.typesMatch(
                schemalessSinger,
                SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Singer")))
        .isTrue();

    // Both concrete types
    assertThat(SqlType.typesMatch(singerProto, albumProto)).isFalse();
    assertThat(SqlType.typesMatch(singerProto, SqlType.protoOf(Singer.getDefaultInstance())))
        .isTrue();

    // Schemaless versus concrete types (unqualified proto message names must match)
    assertThat(SqlType.typesMatch(schemalessSinger, singerProto)).isTrue();
    assertThat(SqlType.typesMatch(singerProto, schemalessSinger)).isTrue();
    assertThat(SqlType.typesMatch(singerProto, SchemalessProto.create("Singer"))).isTrue();
    assertThat(SqlType.typesMatch(singerProto, SchemalessProto.create("foo.bar.Singer"))).isTrue();
    assertThat(SqlType.typesMatch(schemalessSinger, albumProto)).isFalse();
    assertThat(SqlType.typesMatch(albumProto, schemalessSinger)).isFalse();
    assertThat(SqlType.typesMatch(singerProto, SchemalessProto.create("Album"))).isFalse();
    assertThat(
            SqlType.typesMatch(
                singerProto,
                SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Album")))
        .isFalse();
    assertThat(SqlType.typesMatch(singerProto, SchemalessProto.create(""))).isFalse();
  }

  @Test
  public void typesMatch_checksEnum() {
    SqlType.Enum<Genre> genreEnum = SqlType.enumOf(Genre::forNumber);
    SqlType.Enum<Format> formatEnum = SqlType.enumOf(Format::forNumber);
    SqlType.Enum schemalessGenre =
        SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre");
    SqlType.Enum schemalessFormat =
        SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Format");

    // Both Schemaless types
    assertThat(SqlType.typesMatch(schemalessGenre, schemalessFormat)).isFalse();
    assertThat(
            SqlType.typesMatch(
                schemalessGenre,
                SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre")))
        .isTrue();

    // Both concrete types
    assertThat(SqlType.typesMatch(genreEnum, formatEnum)).isFalse();
    assertThat(SqlType.typesMatch(genreEnum, SqlType.enumOf(Genre::forNumber))).isTrue();

    // Schemaless versus concrete types (unqualified enum message names must match)
    assertThat(SqlType.typesMatch(schemalessGenre, genreEnum)).isTrue();
    assertThat(SqlType.typesMatch(genreEnum, schemalessGenre)).isTrue();
    assertThat(SqlType.typesMatch(genreEnum, SchemalessEnum.create("Genre"))).isTrue();
    assertThat(SqlType.typesMatch(genreEnum, SchemalessEnum.create("foo.bar.Genre"))).isTrue();
    assertThat(SqlType.typesMatch(schemalessGenre, formatEnum)).isFalse();
    assertThat(SqlType.typesMatch(formatEnum, schemalessGenre)).isFalse();
    assertThat(SqlType.typesMatch(genreEnum, SchemalessEnum.create("Format"))).isFalse();
    assertThat(
            SqlType.typesMatch(
                genreEnum, SchemalessProto.create("com.google.cloud.bigtable.data.v2.test.Format")))
        .isFalse();
    assertThat(SqlType.typesMatch(genreEnum, SchemalessEnum.create(""))).isFalse();
  }

  @Test
  public void struct_getFields() {
    Type structProto =
        structType(structField("timestamp", timestampType()), structField("value", bytesType()));
    SqlType<?> struct = SqlType.fromProto(structProto);
    SqlType.Struct typedStruct = (SqlType.Struct) struct;
    SqlType.Struct.Field timestampField = typedStruct.getFields().get(0);
    SqlType.Struct.Field valueField = typedStruct.getFields().get(1);
    assertThat(timestampField.name()).isEqualTo("timestamp");
    assertThat(timestampField.type()).isEqualTo(SqlType.timestamp());
    assertThat(valueField.name()).isEqualTo("value");
    assertThat(valueField.type()).isEqualTo(SqlType.bytes());
  }

  @Test
  public void array_getElementType() {
    SqlType<?> array = SqlType.fromProto(arrayType(stringType()));
    SqlType.Array<String> typedArray = (SqlType.Array<String>) array;

    assertThat(typedArray.getElementType()).isEqualTo(SqlType.string());
  }

  @Test
  public void map_getKeyAndValueTypes() {
    SqlType<?> map = SqlType.mapOf(SqlType.bytes(), SqlType.string());
    SqlType.Map<ByteString, String> typedMap = (SqlType.Map<ByteString, String>) map;

    assertThat(typedMap.getKeyType()).isEqualTo(SqlType.bytes());
    assertThat(typedMap.getValueType()).isEqualTo(SqlType.string());
  }
}
