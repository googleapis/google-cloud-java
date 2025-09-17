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
package com.google.cloud.bigtable.common;

import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.arrayType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.bytesType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.int64Type;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.mapType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.stringType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structField;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.structType;
import static com.google.cloud.bigtable.data.v2.stub.sql.SqlProtoFactory.timestampType;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.bigtable.common.Type.SchemalessEnum;
import com.google.cloud.bigtable.common.Type.SchemalessProto;
import com.google.cloud.bigtable.common.Type.SchemalessStruct;
import com.google.cloud.bigtable.common.Type.StructWithSchema;
import com.google.cloud.bigtable.data.v2.models.sql.SqlType;
import com.google.cloud.bigtable.data.v2.models.sql.Struct;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Album;
import com.google.cloud.bigtable.data.v2.test.AlbumProto.Format;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Genre;
import com.google.cloud.bigtable.data.v2.test.SingerProto.Singer;
import com.google.common.testing.EqualsTester;
import com.google.protobuf.ByteString;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TypeTest {

  @Test
  public void simpleTypes_TypeToString() {
    assertThat(Type.String.create().toString()).isEqualTo("STRING");
    assertThat(Type.Bytes.create().toString()).isEqualTo("BYTES");
    assertThat(Type.Int64.create().toString()).isEqualTo("INT64");
    assertThat(Type.Float64.create().toString()).isEqualTo("FLOAT64");
    assertThat(Type.Float32.create().toString()).isEqualTo("FLOAT32");
    assertThat(Type.Bool.create().toString()).isEqualTo("BOOL");
    assertThat(Type.Timestamp.create().toString()).isEqualTo("TIMESTAMP");
    assertThat(Type.Date.create().toString()).isEqualTo("DATE");
    assertThat(Type.SchemalessStruct.create().toString()).isEqualTo("STRUCT");
    assertThat(Type.SchemalessProto.create("MyMessage", "my_bundle").toString())
        .isEqualTo("PROTO{messageName=MyMessage, schemaBundleId=my_bundle}");
    assertThat(Type.SchemalessEnum.create("MyEnum", "other_bundle").toString())
        .isEqualTo("ENUM{enumName=MyEnum, schemaBundleId=other_bundle}");
  }

  @Test
  public void simpleTypes_equals() {
    assertThat(Type.String.create()).isEqualTo(Type.String.create());
    assertThat(Type.Bytes.create()).isEqualTo(Type.Bytes.create());
    assertThat(Type.Int64.create()).isEqualTo(Type.Int64.create());
    assertThat(Type.Float32.create()).isEqualTo(Type.Float32.create());
    assertThat(Type.Float64.create()).isEqualTo(Type.Float64.create());
    assertThat(Type.Bool.create()).isEqualTo(Type.Bool.create());
    assertThat(Type.Timestamp.create()).isEqualTo(Type.Timestamp.create());
    assertThat(Type.Date.create()).isEqualTo(Type.Date.create());
    assertThat(Type.SchemalessStruct.create()).isEqualTo(Type.SchemalessStruct.create());

    assertThat(Type.String.create()).isNotEqualTo(Type.Bytes.create());
    assertThat(Type.Bytes.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Int64.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Float32.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Float64.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Bool.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Timestamp.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.Date.create()).isNotEqualTo(Type.String.create());
    assertThat(Type.SchemalessStruct.create()).isNotEqualTo(Type.String.create());
  }

  @Test
  public void array_equals() {
    assertThat(Type.Array.create(Type.String.create()))
        .isEqualTo(Type.Array.create(Type.String.create()));
    assertThat(Type.Array.create(Type.String.create()))
        .isNotEqualTo(Type.Array.create(Type.Bytes.create()));
    // Nested arrays
    assertThat(Type.Array.create(Type.Array.create(Type.String.create())))
        .isEqualTo(Type.Array.create(Type.Array.create(Type.String.create())));
    assertThat(Type.Array.create(Type.Array.create(Type.String.create())))
        .isNotEqualTo(Type.Array.create(Type.Array.create(Type.Bytes.create())));
  }

  @Test
  public void map_equals() {
    assertThat(Type.Map.create(Type.Bytes.create(), Type.String.create()))
        .isEqualTo(Type.Map.create(Type.Bytes.create(), Type.String.create()));
    assertThat(Type.Map.create(Type.Bytes.create(), Type.String.create()))
        .isNotEqualTo(Type.Map.create(Type.String.create(), Type.String.create()));
    assertThat(Type.Map.create(Type.Bytes.create(), Type.String.create()))
        .isNotEqualTo(Type.Map.create(Type.Bytes.create(), Type.Bytes.create()));
    // Nested Maps
    assertThat(
            Type.Map.create(
                Type.Bytes.create(), Type.Map.create(Type.String.create(), Type.Bytes.create())))
        .isEqualTo(
            Type.Map.create(
                Type.Bytes.create(), Type.Map.create(Type.String.create(), Type.Bytes.create())));
    assertThat(
            Type.Map.create(
                Type.Bytes.create(), Type.Map.create(Type.String.create(), Type.Bytes.create())))
        .isNotEqualTo(
            Type.Map.create(
                Type.Bytes.create(), Type.Map.create(Type.String.create(), Type.String.create())));
  }

  @Test
  public void proto_equals() {
    assertThat(Type.SchemalessProto.create("MyMessage", "my_bundle"))
        .isEqualTo(Type.SchemalessProto.create("MyMessage", "my_bundle"));
    assertThat(Type.Proto.create(Singer.getDefaultInstance()))
        .isEqualTo(Type.Proto.create(Singer.getDefaultInstance()));

    assertThat(Type.SchemalessProto.create("MyMessage", "my_bundle"))
        .isNotEqualTo(Type.SchemalessProto.create("AnotherMessage", "my_bundle"));
    assertThat(Type.SchemalessProto.create("MyMessage", "my_bundle"))
        .isNotEqualTo(Type.SchemalessProto.create("MyMessage", "another_bundle"));
    assertThat(Type.Proto.create(Singer.getDefaultInstance()))
        .isNotEqualTo(Type.Proto.create(Album.getDefaultInstance()));

    assertThat(
            Type.SchemalessProto.create(
                "com.google.cloud.bigtable.data.v2.test.Singer", "my_bundle"))
        .isNotEqualTo(Type.Proto.create(Singer.getDefaultInstance()));
    assertThat(Type.Proto.create(Singer.getDefaultInstance()))
        .isNotEqualTo(
            Type.SchemalessProto.create(
                "com.google.cloud.bigtable.data.v2.test.Singer", "my_bundle"));
  }

  @Test
  public void enum_equals() {
    assertThat(Type.SchemalessEnum.create("MyEnum", "my_bundle"))
        .isEqualTo(Type.SchemalessEnum.create("MyEnum", "my_bundle"));
    assertThat(Type.Enum.create(Genre::forNumber)).isEqualTo(Type.Enum.create(Genre::forNumber));

    assertThat(Type.SchemalessEnum.create("MyEnum", "my_bundle"))
        .isNotEqualTo(Type.SchemalessEnum.create("AnotherEnum", "my_bundle"));
    assertThat(Type.SchemalessEnum.create("MyEnum", "my_bundle"))
        .isNotEqualTo(Type.SchemalessEnum.create("MyEnum", "another_bundle"));
    assertThat(Type.Enum.create(Genre::forNumber))
        .isNotEqualTo(Type.Enum.create(Format::forNumber));

    assertThat(
            Type.SchemalessEnum.create("com.google.cloud.bigtable.data.v2.test.Genre", "my_bundle"))
        .isNotEqualTo(Type.Enum.create(Genre::forNumber));
    assertThat(Type.Enum.create(Genre::forNumber))
        .isNotEqualTo(
            Type.SchemalessEnum.create(
                "com.google.cloud.bigtable.data.v2.test.Genre", "my_bundle"));
  }

  @Test
  public void structWithSchema_equals() {
    com.google.bigtable.v2.Type structProto =
        structType(structField("timestamp", timestampType()), structField("value", bytesType()));
    com.google.bigtable.v2.Type complexStructProto =
        structType(
            structField("map", mapType(stringType(), bytesType())),
            structField("array", arrayType(stringType())));
    new EqualsTester()
        .addEqualityGroup(
            StructWithSchema.fromProto(structProto.getStructType()),
            StructWithSchema.fromProto(structProto.getStructType()))
        .addEqualityGroup(
            StructWithSchema.fromProto(complexStructProto.getStructType()),
            StructWithSchema.fromProto(complexStructProto.getStructType()))
        .testEquals();
  }

  @Test
  public void structWithSchema_fields() {
    StructWithSchema struct =
        StructWithSchema.fromProto(
            structType(structField("timestamp", timestampType()), structField("value", bytesType()))
                .getStructType());
    assertThat(struct.getFields()).hasSize(2);
    assertThat(struct.getFields().get(0).name()).isEqualTo("timestamp");
    assertThat(struct.getFields().get(0).type()).isEqualTo(Type.Timestamp.create());
    assertThat(struct.getType(0)).isEqualTo(Type.Timestamp.create());
    assertThat(struct.getType("timestamp")).isEqualTo(Type.Timestamp.create());
    assertThat(struct.getColumnIndex("timestamp")).isEqualTo(0);

    assertThat(struct.getFields().get(1).name()).isEqualTo("value");
    assertThat(struct.getFields().get(1).type()).isEqualTo(Type.Bytes.create());
    assertThat(struct.getType(1)).isEqualTo(Type.Bytes.create());
    assertThat(struct.getType("value")).isEqualTo(Type.Bytes.create());
    assertThat(struct.getColumnIndex("value")).isEqualTo(1);
  }

  @Test
  public void structWithSchema_handlesAmbiguousFields() {
    StructWithSchema struct =
        StructWithSchema.fromProto(
            structType(structField("foo", timestampType()), structField("foo", bytesType()))
                .getStructType());
    assertThat(struct.getFields()).hasSize(2);
    assertThat(struct.getType(0)).isEqualTo(Type.Timestamp.create());
    assertThat(struct.getType(1)).isEqualTo(Type.Bytes.create());

    assertThrows(IllegalArgumentException.class, () -> struct.getType("foo"));
    assertThrows(IllegalArgumentException.class, () -> struct.getColumnIndex("foo"));
  }

  @Test
  public void structWithSchema_toString() {
    StructWithSchema struct =
        StructWithSchema.fromProto(
            structType(structField("test", stringType()), structField("test2", int64Type()))
                .getStructType());
    assertThat(struct.toString())
        .isEqualTo("STRUCT{fields=[Field{name=test, type=STRING}, Field{name=test2, type=INT64}]}");
  }

  @Test
  public void schemalessStruct_throwsExceptionOnSchemaAccess() {
    SchemalessStruct struct = Type.SchemalessStruct.create();

    assertThrows(UnsupportedOperationException.class, () -> struct.getType("foo"));
    assertThrows(UnsupportedOperationException.class, () -> struct.getType(0));
    assertThrows(UnsupportedOperationException.class, () -> struct.getColumnIndex("foo"));
    assertThrows(UnsupportedOperationException.class, struct::getFields);
  }

  @Test
  public void schemalessProto_throwsExceptionOnGetParser() {
    SchemalessProto proto = Type.SchemalessProto.create("MyMessage", "my_bundle");
    assertThrows(UnsupportedOperationException.class, proto::getParserForType);
  }

  @Test
  public void schemalessEnum_throwsExceptionOnGetForNumber() {
    SchemalessEnum myEnum = Type.SchemalessEnum.create("MyEnum", "my_bundle");
    assertThrows(UnsupportedOperationException.class, myEnum::getForNumber);
  }

  @Test
  public void array_toString() {
    Type array = Type.Array.create(Type.String.create());

    assertThat(array.toString()).isEqualTo("ARRAY{elementType=STRING}");
  }

  @Test
  public void simpleMap_toString() {
    Type map = Type.Map.create(Type.Bytes.create(), Type.String.create());

    assertThat(map.toString()).isEqualTo("MAP{keyType=BYTES, valueType=STRING}");
  }

  @Test
  public void historicalMap_toString() {
    SqlType.Map<ByteString, List<Struct>> historicalMap = SqlType.historicalMap();

    assertThat(historicalMap.toString())
        .isEqualTo("MAP{keyType=BYTES, valueType=ARRAY{elementType=STRUCT}}");
  }

  @Test
  public void proto_toString() {
    SqlType.Proto<Singer> proto = Type.Proto.create(Singer.getDefaultInstance());

    assertThat(proto.toString())
        .isEqualTo("PROTO{message=com.google.cloud.bigtable.data.v2.test.Singer}");
  }

  @Test
  public void enum_toString() {
    SqlType.Enum<Genre> myEnum = Type.Enum.create(Genre::forNumber);

    assertThat(myEnum.toString())
        .isEqualTo("ENUM{enum=com.google.cloud.bigtable.data.v2.test.Genre}");
  }
}
