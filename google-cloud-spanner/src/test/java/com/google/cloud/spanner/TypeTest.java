/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.Type.StructField;
import static com.google.common.truth.Truth.assertThat;

import com.google.spanner.v1.TypeCode;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Type}. */
@RunWith(JUnit4.class)
public class TypeTest {
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private abstract static class ScalarTypeTester {
    final Type.Code expectedCode;
    final TypeCode expectedProtoCode;

    ScalarTypeTester(Type.Code expectedCode, TypeCode expectedProtoCode) {
      this.expectedCode = expectedCode;
      this.expectedProtoCode = expectedProtoCode;
    }

    abstract Type newType();

    void test() {
      Type t = newType();
      assertThat(t.getCode()).isEqualTo(expectedCode);
      assertThat(newType()).isSameAs(t); // Interned.
      // String form is deliberately the same as the corresponding type enum in the public API.
      assertThat(t.toString()).isEqualTo(expectedProtoCode.toString());

      com.google.spanner.v1.Type proto = t.toProto();
      assertThat(proto.getCode()).isEqualTo(expectedProtoCode);
      assertThat(proto.hasArrayElementType()).isFalse();
      assertThat(proto.hasStructType()).isFalse();

      // Round trip.
      Type fromProto = Type.fromProto(proto);
      assertThat(fromProto).isEqualTo(t);
      assertThat(fromProto).isSameAs(t);
    }
  }

  @Test
  public void bool() {
    new ScalarTypeTester(Type.Code.BOOL, TypeCode.BOOL) {
      @Override
      Type newType() {
        return Type.bool();
      }
    }.test();
  }

  @Test
  public void int64() {
    new ScalarTypeTester(Type.Code.INT64, TypeCode.INT64) {
      @Override
      Type newType() {
        return Type.int64();
      }
    }.test();
  }

  @Test
  public void float64() {
    new ScalarTypeTester(Type.Code.FLOAT64, TypeCode.FLOAT64) {
      @Override
      Type newType() {
        return Type.float64();
      }
    }.test();
  }

  @Test
  public void string() {
    new ScalarTypeTester(Type.Code.STRING, TypeCode.STRING) {
      @Override
      Type newType() {
        return Type.string();
      }
    }.test();
  }

  @Test
  public void bytes() {
    new ScalarTypeTester(Type.Code.BYTES, TypeCode.BYTES) {
      @Override
      Type newType() {
        return Type.bytes();
      }
    }.test();
  }

  @Test
  public void timestamp() {
    new ScalarTypeTester(Type.Code.TIMESTAMP, TypeCode.TIMESTAMP) {
      @Override
      Type newType() {
        return Type.timestamp();
      }
    }.test();
  }

  @Test
  public void date() {
    new ScalarTypeTester(Type.Code.DATE, TypeCode.DATE) {
      @Override
      Type newType() {
        return Type.date();
      }
    }.test();
  }

  abstract static class ArrayTypeTester {
    final Type.Code expectedElementCode;
    final TypeCode expectedElementProtoCode;
    final boolean expectInterned;

    protected ArrayTypeTester(
        Type.Code expectedElementCode, TypeCode expectedElementProtoCode, boolean expectInterned) {
      this.expectedElementCode = expectedElementCode;
      this.expectedElementProtoCode = expectedElementProtoCode;
      this.expectInterned = expectInterned;
    }

    abstract Type newElementType();

    void test() {
      Type elementType = newElementType();
      Type t = Type.array(elementType);
      assertThat(t.getCode()).isEqualTo(Type.Code.ARRAY);
      assertThat(t.getArrayElementType()).isEqualTo(elementType);
      if (expectInterned) {
        assertThat(Type.array(newElementType())).isSameAs(t);
      }
      assertThat(t.toString()).isEqualTo("ARRAY<" + elementType.toString() + ">");

      com.google.spanner.v1.Type proto = t.toProto();
      assertThat(proto.getCode()).isEqualTo(TypeCode.ARRAY);
      assertThat(proto.getArrayElementType()).isEqualTo(elementType.toProto());
      assertThat(proto.hasStructType()).isFalse();

      Type fromProto = Type.fromProto(proto);
      assertThat(fromProto).isEqualTo(t);

      if (expectInterned) {
        assertThat(fromProto).isSameAs(t);
      }
    }
  }

  @Test
  public void boolArray() {
    new ArrayTypeTester(Type.Code.BOOL, TypeCode.BOOL, true) {
      @Override
      Type newElementType() {
        return Type.bool();
      }
    }.test();
  }

  @Test
  public void int64Array() {
    new ArrayTypeTester(Type.Code.INT64, TypeCode.INT64, true) {
      @Override
      Type newElementType() {
        return Type.int64();
      }
    }.test();
  }

  @Test
  public void float64Array() {
    new ArrayTypeTester(Type.Code.FLOAT64, TypeCode.FLOAT64, true) {
      @Override
      Type newElementType() {
        return Type.float64();
      }
    }.test();
  }

  @Test
  public void stringArray() {
    new ArrayTypeTester(Type.Code.STRING, TypeCode.STRING, true) {
      @Override
      Type newElementType() {
        return Type.string();
      }
    }.test();
  }

  @Test
  public void bytesArray() {
    new ArrayTypeTester(Type.Code.BYTES, TypeCode.BYTES, true) {
      @Override
      Type newElementType() {
        return Type.bytes();
      }
    }.test();
  }

  @Test
  public void timestampArray() {
    new ArrayTypeTester(Type.Code.TIMESTAMP, TypeCode.TIMESTAMP, true) {
      @Override
      Type newElementType() {
        return Type.timestamp();
      }
    }.test();
  }

  @Test
  public void dateArray() {
    new ArrayTypeTester(Type.Code.DATE, TypeCode.DATE, true) {
      @Override
      Type newElementType() {
        return Type.date();
      }
    }.test();
  }

  @Test
  public void arrayOfArray() {
    new ArrayTypeTester(Type.Code.ARRAY, TypeCode.ARRAY, false /* not interned */) {
      @Override
      Type newElementType() {
        return Type.array(Type.int64());
      }
    }.test();
  }

  @Test
  public void struct() {
    Type t = Type.struct(StructField.of("f1", Type.int64()), StructField.of("f2", Type.string()));
    assertThat(t.getCode()).isEqualTo(Type.Code.STRUCT);
    // Exercise StructField equality.
    assertThat(t.getStructFields())
        .containsExactly(StructField.of("f1", Type.int64()), StructField.of("f2", Type.string()))
        .inOrder();
    // Exercise StructField getters.
    assertThat(t.getStructFields().get(0).getName()).isEqualTo("f1");
    assertThat(t.getStructFields().get(0).getType()).isEqualTo(Type.int64());
    assertThat(t.getStructFields().get(1).getName()).isEqualTo("f2");
    assertThat(t.getStructFields().get(1).getType()).isEqualTo(Type.string());
    assertThat(t.toString()).isEqualTo("STRUCT<f1 INT64, f2 STRING>");
    assertThat(t.getFieldIndex("f1")).isEqualTo(0);
    assertThat(t.getFieldIndex("f2")).isEqualTo(1);

    assertProtoEquals(
        t.toProto(),
        "code: STRUCT struct_type { fields { name: 'f1' type { code: INT64 } }"
            + " fields { name: 'f2' type { code: STRING } } }");
  }

  @Test
  public void emptyStruct() {
    Type t = Type.struct();
    assertThat(t.getCode()).isEqualTo(Type.Code.STRUCT);
    assertThat(t.getStructFields()).isEmpty();
    assertThat(t.toString()).isEqualTo("STRUCT<>");
    assertProtoEquals(t.toProto(), "code: STRUCT struct_type {}");
  }

  @Test
  public void structFieldIndexNotFound() {
    Type t = Type.struct(StructField.of("f1", Type.int64()));

    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Field not found: f2");
    t.getFieldIndex("f2");
  }

  @Test
  public void structFieldIndexAmbiguous() {
    Type t = Type.struct(StructField.of("f1", Type.int64()), StructField.of("f1", Type.string()));

    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Ambiguous field name: f1");
    t.getFieldIndex("f1");
  }

  @Test
  public void parseErrorMissingTypeCode() {
    com.google.spanner.v1.Type proto = com.google.spanner.v1.Type.newBuilder().build();
    expectedException.expect(IllegalArgumentException.class);
    Type.fromProto(proto);
  }

  @Test
  public void parseErrorMissingArrayElementTypeProto() {
    com.google.spanner.v1.Type proto =
        com.google.spanner.v1.Type.newBuilder().setCode(TypeCode.ARRAY).build();
    expectedException.expect(IllegalArgumentException.class);
    Type.fromProto(proto);
  }

  private static void assertProtoEquals(com.google.spanner.v1.Type proto, String expected) {
    MatcherAssert.assertThat(
        proto, SpannerMatchers.matchesProto(com.google.spanner.v1.Type.class, expected));
  }
}
