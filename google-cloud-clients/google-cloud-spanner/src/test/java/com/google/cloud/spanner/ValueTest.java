/*
 * Copyright 2017 Google LLC
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

import static com.google.common.testing.SerializableTester.reserializeAndAssert;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Value}. */
@RunWith(JUnit4.class)
public class ValueTest {
  private static final String NULL_STRING = "NULL";
  @Rule public ExpectedException expectedException = ExpectedException.none();

  private static ByteArray newByteArray(String data) {
    return ByteArray.copyFrom(data);
  }

  /** Returns an {@code Iterable} over {@code values} that is not a {@code Collection}. */
  @SafeVarargs
  private static <T> Iterable<T> plainIterable(T... values) {
    final List<T> list = Lists.newArrayList(values);
    return new Iterable<T>() {
      @Override
      public Iterator<T> iterator() {
        return list.iterator();
      }
    };
  }

  @Test
  public void bool() {
    Value v = Value.bool(true);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBool()).isTrue();
    assertThat(v.toString()).isEqualTo("true");
  }

  @Test
  public void boolWrapper() {
    Value v = Value.bool(Boolean.FALSE);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBool()).isFalse();
    assertThat(v.toString()).isEqualTo("false");
  }

  @Test
  public void boolWrapperNull() {
    Value v = Value.bool(null);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getBool();
  }

  @Test
  public void int64() {
    Value v = Value.int64(123);
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(123);
    assertThat(v.toString()).isEqualTo("123");
  }

  @Test
  public void int64TryGetBool() {
    Value value = Value.int64(1234);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: BOOL actual: INT64");
    value.getBool();
  }

  @Test
  public void int64NullTryGetBool() {
    Value value = Value.int64(null);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: BOOL actual: INT64");
    value.getBool();
  }

  @Test
  public void int64TryGetInt64Array() {
    Value value = Value.int64(1234);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: ARRAY<INT64> actual: INT64");
    value.getInt64Array();
  }

  @Test
  public void int64Wrapper() {
    Value v = Value.int64(Long.valueOf(123));
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(123);
    assertThat(v.toString()).isEqualTo("123");
  }

  @Test
  public void int64WrapperNull() {
    Value v = Value.int64(null);
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getInt64();
  }

  @Test
  public void float64() {
    Value v = Value.float64(1.23);
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64()).isWithin(0.0001).of(1.23);
    assertThat(v.toString()).isEqualTo("1.23");
  }

  @Test
  public void float64Wrapper() {
    Value v = Value.float64(Double.valueOf(1.23));
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64()).isWithin(0.0001).of(1.23);
    assertThat(v.toString()).isEqualTo("1.23");
  }

  @Test
  public void float64WrapperNull() {
    Value v = Value.float64(null);
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getFloat64();
  }

  @Test
  public void string() {
    Value v = Value.string("abc");
    assertThat(v.getType()).isEqualTo(Type.string());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getString()).isEqualTo("abc");
  }

  @Test
  public void stringNull() {
    Value v = Value.string(null);
    assertThat(v.getType()).isEqualTo(Type.string());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getString();
  }

  @Test
  public void stringLong() {
    String str = "aaaaaaaaaabbbbbbbbbbccccccccccdddddddddd";
    Value v = Value.string(str);
    assertThat(v.getString()).isEqualTo(str);
    assertThat(v.toString()).hasLength(32);
    assertThat(v.toString()).startsWith(str.substring(0, 32 - 3));
    assertThat(v.toString()).endsWith("...");
  }

  @Test
  public void bytes() {
    ByteArray bytes = newByteArray("abc");
    Value v = Value.bytes(bytes);
    assertThat(v.getType()).isEqualTo(Type.bytes());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBytes()).isSameAs(bytes);
    assertThat(v.toString()).isEqualTo(bytes.toString());
  }

  @Test
  public void bytesUnprintable() {
    ByteArray bytes = ByteArray.copyFrom(new byte[] {'a', 0, 15, -1, 'e'});
    Value v = Value.bytes(bytes);
    assertThat(v.getBytes()).isSameAs(bytes);
    assertThat(v.toString()).isEqualTo(bytes.toString());
  }

  @Test
  public void bytesNull() {
    Value v = Value.bytes(null);
    assertThat(v.getType()).isEqualTo(Type.bytes());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getBytes();
  }

  @Test
  public void timestamp() {
    String timestamp = "2016-09-15T00:00:00Z";
    Timestamp t = Timestamp.parseTimestamp(timestamp);
    Value v = Value.timestamp(t);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isFalse();
    assertThat(v.isCommitTimestamp()).isFalse();
    assertThat(v.getTimestamp()).isSameAs(t);
    assertThat(v.toString()).isEqualTo(timestamp);
  }

  @Test
  public void timestampNull() {
    Value v = Value.timestamp(null);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    assertThat(v.isCommitTimestamp()).isFalse();
    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getTimestamp();
  }

  @Test
  public void commitTimestamp() {
    Value v = Value.timestamp(Value.COMMIT_TIMESTAMP);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isFalse();
    assertThat(v.isCommitTimestamp()).isTrue();
    assertThat(v.toString()).isEqualTo("spanner.commit_timestamp()");
    assertThat(v.toProto())
        .isEqualTo(
            com.google.protobuf.Value.newBuilder()
                .setStringValue("spanner.commit_timestamp()")
                .build());
    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Commit timestamp value");
    v.getTimestamp();
  }

  @Test
  public void date() {
    String date = "2016-09-15";
    Date t = Date.parseDate(date);
    Value v = Value.date(t);
    assertThat(v.getType()).isEqualTo(Type.date());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getDate()).isSameAs(t);
    assertThat(v.toString()).isEqualTo(date);
  }

  @Test
  public void dateNull() {
    Value v = Value.date(null);
    assertThat(v.getType()).isEqualTo(Type.date());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getDate();
  }

  @Test
  public void boolArray() {
    Value v = Value.boolArray(new boolean[] {true, false});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(true, false).inOrder();
    assertThat(v.toString()).isEqualTo("[true,false]");
  }

  @Test
  public void boolArrayRange() {
    Value v = Value.boolArray(new boolean[] {true, false, false, true, false}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(false, false, true).inOrder();
    assertThat(v.toString()).isEqualTo("[false,false,true]");
  }

  @Test
  public void boolArrayNull() {
    Value v = Value.boolArray((boolean[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getBoolArray();
  }

  @Test
  public void boolArrayFromList() {
    Value v = Value.boolArray(Arrays.asList(true, null, false));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(true, null, false).inOrder();
    assertThat(v.toString()).isEqualTo("[true,NULL,false]");
  }

  @Test
  public void boolArrayFromListNull() {
    Value v = Value.boolArray((Iterable<Boolean>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getBoolArray();
  }

  @Test
  public void boolArrayFromPlainIterable() {
    // Test to ensure that PrimitiveArrayFactory understands how to create an appropriate backing
    // arrays from various sizes of plain Iterable input.  This test also covers the code paths
    // used by int64Array() and float64Array().
    for (int i = 0; i < 50; ++i) {
      Boolean[] data = new Boolean[i];
      for (int j = 0; j < data.length; ++j) {
        data[j] = (j % 3 == 2) ? null : ((j % 3) == 1);
      }
      String name = "boolArray() of length " + i;
      Value v = Value.boolArray(plainIterable(data));
      assertThat(v.isNull()).named(name).isFalse();
      assertThat(v.getBoolArray()).named(name).containsExactly((Object[]) data).inOrder();
    }
  }

  @Test
  public void boolArrayTryGetInt64Array() {
    Value value = Value.boolArray(Arrays.asList(true));

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: ARRAY<INT64> actual: ARRAY<BOOL>");
    value.getInt64Array();
  }

  @Test
  public void int64Array() {
    Value v = Value.int64Array(new long[] {1, 2});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, 2L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,2]");
  }

  @Test
  public void int64ArrayRange() {
    Value v = Value.int64Array(new long[] {1, 2, 3, 4, 5}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(2L, 3L, 4L).inOrder();
    assertThat(v.toString()).isEqualTo("[2,3,4]");
  }

  @Test
  public void int64ArrayNull() {
    Value v = Value.int64Array((long[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getInt64Array();
  }

  @Test
  public void int64ArrayWrapper() {
    Value v = Value.int64Array(Arrays.asList(1L, null, 3L));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, null, 3L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,NULL,3]");
  }

  @Test
  public void int64ArrayWrapperNull() {
    Value v = Value.int64Array((Iterable<Long>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getInt64Array();
  }

  @Test
  public void int64ArrayTryGetBool() {
    Value value = Value.int64Array(Arrays.asList(1234L));

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: BOOL actual: ARRAY<INT64>");
    value.getBool();
  }

  @Test
  public void int64ArrayNullTryGetBool() {
    Value value = Value.int64Array((Iterable<Long>) null);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: BOOL actual: ARRAY<INT64>");
    value.getBool();
  }

  @Test
  public void float64Array() {
    Value v = Value.float64Array(new double[] {.1, .2});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.1d, .2d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,0.2]");
  }

  @Test
  public void float64ArrayRange() {
    Value v = Value.float64Array(new double[] {.1, .2, .3, .4, .5}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.2d, .3d, .4d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.2,0.3,0.4]");
  }

  @Test
  public void float64ArrayNull() {
    Value v = Value.float64Array((double[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getFloat64Array();
  }

  @Test
  public void float64ArrayWrapper() {
    Value v = Value.float64Array(Arrays.asList(.1, null, .3));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.1d, null, .3d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,NULL,0.3]");
  }

  @Test
  public void float64ArrayWrapperNull() {
    Value v = Value.float64Array((Iterable<Double>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getFloat64Array();
  }

  @Test
  public void float64ArrayTryGetInt64Array() {
    Value value = Value.float64Array(Arrays.asList(.1));

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: ARRAY<INT64> actual: ARRAY<FLOAT64>");
    value.getInt64Array();
  }

  @Test
  public void stringArray() {
    Value v = Value.stringArray(Arrays.asList("a", null, "c"));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getStringArray()).containsExactly("a", null, "c").inOrder();
    assertThat(v.toString()).isEqualTo("[a,NULL,c]");
  }

  @Test
  public void stringArrayNull() {
    Value v = Value.stringArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getStringArray();
  }

  @Test
  public void stringArrayTryGetBytesArray() {
    Value value = Value.stringArray(Arrays.asList("a"));

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: ARRAY<BYTES> actual: ARRAY<STRING>");
    value.getBytesArray();
  }

  @Test
  public void bytesArray() {
    ByteArray a = newByteArray("a");
    ByteArray c = newByteArray("c");
    Value v = Value.bytesArray(Arrays.asList(a, null, c));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBytesArray()).containsExactly(a, null, c).inOrder();
    assertThat(v.toString()).isEqualTo(String.format("[%s,NULL,%s]", a, c));
  }

  @Test
  public void bytesArrayNull() {
    Value v = Value.bytesArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getBytesArray();
  }

  @Test
  public void bytesArrayTryGetStringArray() {
    Value value = Value.bytesArray(Arrays.asList(newByteArray("a")));

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Expected: ARRAY<STRING> actual: ARRAY<BYTES>");
    value.getStringArray();
  }

  @Test
  public void timestampArray() {
    String t1 = "2015-09-15T00:00:00Z";
    String t2 = "2015-09-14T00:00:00Z";
    Value v =
        Value.timestampArray(
            Arrays.asList(Timestamp.parseTimestamp(t1), null, Timestamp.parseTimestamp(t2)));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getTimestampArray())
        .containsExactly(Timestamp.parseTimestamp(t1), null, Timestamp.parseTimestamp(t2))
        .inOrder();
    assertThat(v.toString()).isEqualTo("[" + t1 + ",NULL," + t2 + "]");
  }

  @Test
  public void timestampArrayNull() {
    Value v = Value.timestampArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getTimestampArray();
  }

  @Test
  public void dateArray() {
    String d1 = "2016-09-15";
    String d2 = "2016-09-14";

    Value v = Value.dateArray(Arrays.asList(Date.parseDate(d1), null, Date.parseDate(d2)));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getDateArray())
        .containsExactly(Date.parseDate(d1), null, Date.parseDate(d2))
        .inOrder();
    assertThat(v.toString()).isEqualTo("[" + d1 + ",NULL," + d2 + "]");
  }

  @Test
  public void dateArrayNull() {
    Value v = Value.dateArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
    v.getDateArray();
  }

  @Test
  public void struct() {
    Struct struct = Struct.newBuilder().set("f1").to("v1").set("f2").to(30).build();
    Value v1 = Value.struct(struct);
    assertThat(v1.getType()).isEqualTo(struct.getType());
    assertThat(v1.isNull()).isFalse();
    assertThat(v1.getStruct()).isEqualTo(struct);
    assertThat(v1.toString()).isEqualTo("[v1, 30]");

    Value v2 = Value.struct(struct.getType(), struct);
    assertThat(v2).isEqualTo(v1);

    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("Mismatch between struct value and type.");
    Value.struct(Type.struct(Arrays.asList(StructField.of("f3", Type.string()))), struct);
  }

  @Test
  public void nullStruct() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("f1", Type.string()), Type.StructField.of("f2", Type.int64()));

    Value v = Value.struct(Type.struct(fieldTypes), null);
    assertThat(v.getType().getStructFields()).isEqualTo(fieldTypes);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(NullPointerException.class);
    expectedException.expectMessage("Illegal call to create a NULL struct value.");
    Value.struct(null);
  }

  @Test
  public void nullStructGetter() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("f1", Type.string()), Type.StructField.of("f2", Type.int64()));

    Value v = Value.struct(Type.struct(fieldTypes), null);
    assertThat(v.isNull()).isTrue();

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Illegal call to getter of null value.");
    v.getStruct();
  }

  @Test
  public void structArrayField() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build(),
            null,
            Struct.newBuilder().set("ff1").to("v3").set("ff2").to(3).build());
    Struct struct =
        Struct.newBuilder()
            .set("f1")
            .to("x")
            .set("f2")
            .toStructArray(elementType, arrayElements)
            .build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(elementType))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getStructList(1)).isEqualTo(arrayElements);
  }

  @Test
  public void structArrayFieldNull() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    Struct struct =
        Struct.newBuilder().set("f1").to("x").set("f2").toStructArray(elementType, null).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(elementType))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isTrue();
  }

  @Test
  public void structArray() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build(),
            null,
            null,
            Struct.newBuilder().set("ff1").to("v3").set("ff2").to(3).build());
    Value v = Value.structArray(elementType, arrayElements);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getType().getArrayElementType()).isEqualTo(elementType);
    assertThat(v.getStructArray()).isEqualTo(arrayElements);
    assertThat(v.toString()).isEqualTo("[[v1, 1],NULL,NULL,[v3, 3]]");
  }

  @Test
  public void structArrayNull() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    Value v = Value.structArray(elementType, null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.getType().getArrayElementType()).isEqualTo(elementType);
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("Illegal call to getter of null value");
    v.getStructArray();
  }

  @Test
  public void structArrayInvalidType() {
    Type elementType =
        Type.struct(
            Arrays.asList(
                Type.StructField.of("ff1", Type.string()),
                Type.StructField.of("ff2", Type.int64())));
    // Second element has INT64 first field, not STRING.
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("1").set("ff2").to(1).build(),
            Struct.newBuilder().set("ff1").to(2).set("ff2").to(3).build());

    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("must have type STRUCT<ff1 STRING, ff2 INT64>");
    Value.structArray(elementType, arrayElements);
  }

  @Test
  public void testEqualsHashCode() {
    EqualsTester tester = new EqualsTester();

    tester.addEqualityGroup(Value.bool(true), Value.bool(Boolean.TRUE));
    tester.addEqualityGroup(Value.bool(false));
    tester.addEqualityGroup(Value.bool(null));

    tester.addEqualityGroup(Value.int64(123), Value.int64(Long.valueOf(123)));
    tester.addEqualityGroup(Value.int64(456));
    tester.addEqualityGroup(Value.int64(null));

    tester.addEqualityGroup(Value.float64(1.23), Value.float64(Double.valueOf(1.23)));
    tester.addEqualityGroup(Value.float64(4.56));
    tester.addEqualityGroup(Value.float64(null));

    tester.addEqualityGroup(Value.string("abc"), Value.string("abc"));
    tester.addEqualityGroup(Value.string("def"));
    tester.addEqualityGroup(Value.string(null));

    tester.addEqualityGroup(Value.bytes(newByteArray("abc")), Value.bytes(newByteArray("abc")));
    tester.addEqualityGroup(Value.bytes(newByteArray("def")));
    tester.addEqualityGroup(Value.bytes(null));

    tester.addEqualityGroup(Value.timestamp(null), Value.timestamp(null));
    tester.addEqualityGroup(
        Value.timestamp(Value.COMMIT_TIMESTAMP), Value.timestamp(Value.COMMIT_TIMESTAMP));
    Timestamp now = Timestamp.now();
    tester.addEqualityGroup(Value.timestamp(now), Value.timestamp(now));
    tester.addEqualityGroup(Value.timestamp(Timestamp.ofTimeMicroseconds(0)));

    tester.addEqualityGroup(Value.date(null), Value.date(null));
    tester.addEqualityGroup(
        Value.date(Date.fromYearMonthDay(2018, 2, 26)),
        Value.date(Date.fromYearMonthDay(2018, 2, 26)));
    tester.addEqualityGroup(Value.date(Date.fromYearMonthDay(2018, 2, 27)));

    Struct structValue1 = Struct.newBuilder().set("f1").to(20).set("f2").to("def").build();
    Struct structValue2 = Struct.newBuilder().set("f1").to(20).set("f2").to("def").build();
    assertThat(Value.struct(structValue1).equals(Value.struct(structValue2))).isTrue();
    tester.addEqualityGroup(Value.struct(structValue1), Value.struct(structValue2));

    Type structType1 = structValue1.getType();
    Type structType2 = Type.struct(Arrays.asList(StructField.of("f1", Type.string())));
    tester.addEqualityGroup(Value.struct(structType1, null), Value.struct(structType1, null));
    tester.addEqualityGroup(Value.struct(structType2, null), Value.struct(structType2, null));

    tester.addEqualityGroup(
        Value.boolArray(Arrays.asList(false, true)),
        Value.boolArray(new boolean[] {false, true}),
        Value.boolArray(new boolean[] {true, false, true, false}, 1, 2),
        Value.boolArray(plainIterable(false, true)));
    tester.addEqualityGroup(Value.boolArray(Arrays.asList(false)));
    tester.addEqualityGroup(Value.boolArray((Iterable<Boolean>) null));

    tester.addEqualityGroup(
        Value.int64Array(Arrays.asList(1L, 2L)),
        Value.int64Array(new long[] {1L, 2L}),
        Value.int64Array(new long[] {0L, 1L, 2L, 3L}, 1, 2),
        Value.int64Array(plainIterable(1L, 2L)));
    tester.addEqualityGroup(Value.int64Array(Arrays.asList(3L)));
    tester.addEqualityGroup(Value.int64Array((Iterable<Long>) null));

    tester.addEqualityGroup(
        Value.float64Array(Arrays.asList(.1, .2)),
        Value.float64Array(new double[] {.1, .2}),
        Value.float64Array(new double[] {.0, .1, .2, .3}, 1, 2),
        Value.float64Array(plainIterable(.1, .2)));
    tester.addEqualityGroup(Value.float64Array(Arrays.asList(.3)));
    tester.addEqualityGroup(Value.float64Array((Iterable<Double>) null));

    tester.addEqualityGroup(
        Value.stringArray(Arrays.asList("a", "b")), Value.stringArray(Arrays.asList("a", "b")));
    tester.addEqualityGroup(Value.stringArray(Arrays.asList("c")));
    tester.addEqualityGroup(Value.stringArray(null));

    tester.addEqualityGroup(
        Value.bytesArray(Arrays.asList(newByteArray("a"), newByteArray("b"))),
        Value.bytesArray(Arrays.asList(newByteArray("a"), newByteArray("b"))));
    tester.addEqualityGroup(Value.bytesArray(Arrays.asList(newByteArray("c"))));
    tester.addEqualityGroup(Value.bytesArray(null));

    tester.addEqualityGroup(
        Value.timestampArray(Arrays.asList(null, now)),
        Value.timestampArray(Arrays.asList(null, now)));
    tester.addEqualityGroup(Value.timestampArray(null));

    tester.addEqualityGroup(
        Value.dateArray(Arrays.asList(null, Date.fromYearMonthDay(2018, 2, 26))),
        Value.dateArray(Arrays.asList(null, Date.fromYearMonthDay(2018, 2, 26))));
    tester.addEqualityGroup(Value.dateArray(null));

    tester.addEqualityGroup(
        Value.structArray(structType1, Arrays.asList(structValue1, null)),
        Value.structArray(structType1, Arrays.asList(structValue2, null)));
    tester.addEqualityGroup(
        Value.structArray(structType1, Arrays.asList((Struct) null)),
        Value.structArray(structType1, Arrays.asList((Struct) null)));
    tester.addEqualityGroup(
        Value.structArray(structType1, null), Value.structArray(structType1, null));
    tester.addEqualityGroup(
        Value.structArray(structType1, new ArrayList<Struct>()),
        Value.structArray(structType1, new ArrayList<Struct>()));

    tester.testEquals();
  }

  @Test
  public void serialization() {

    reserializeAndAssert(Value.bool(true));
    reserializeAndAssert(Value.bool(false));
    reserializeAndAssert(Value.bool(null));

    reserializeAndAssert(Value.int64(123));
    reserializeAndAssert(Value.int64(null));

    reserializeAndAssert(Value.float64(1.23));
    reserializeAndAssert(Value.float64(null));

    reserializeAndAssert(Value.string("abc"));
    reserializeAndAssert(Value.string(null));

    reserializeAndAssert(Value.bytes(newByteArray("abc")));
    reserializeAndAssert(Value.bytes(null));

    reserializeAndAssert(
        Value.struct(Struct.newBuilder().set("f").to(3).set("f").to((Date) null).build()));
    reserializeAndAssert(
        Value.struct(
            Type.struct(
                Arrays.asList(
                    Type.StructField.of("a", Type.string()),
                    Type.StructField.of("b", Type.int64()))),
            null));

    reserializeAndAssert(Value.boolArray(new boolean[] {false, true}));
    reserializeAndAssert(Value.boolArray(BrokenSerializationList.of(true, false)));
    reserializeAndAssert(Value.boolArray((Iterable<Boolean>) null));

    reserializeAndAssert(Value.int64Array(BrokenSerializationList.of(1L, 2L)));
    reserializeAndAssert(Value.int64Array(new long[] {1L, 2L}));
    reserializeAndAssert(Value.int64Array((Iterable<Long>) null));

    reserializeAndAssert(Value.float64Array(new double[] {.1, .2}));
    reserializeAndAssert(Value.float64Array(BrokenSerializationList.of(.1, .2, .3)));
    reserializeAndAssert(Value.float64Array((Iterable<Double>) null));

    reserializeAndAssert(Value.timestamp(null));
    reserializeAndAssert(Value.timestamp(Value.COMMIT_TIMESTAMP));
    reserializeAndAssert(Value.timestamp(Timestamp.now()));
    reserializeAndAssert(Value.timestampArray(Arrays.asList(null, Timestamp.now())));

    reserializeAndAssert(Value.date(null));
    reserializeAndAssert(Value.date(Date.fromYearMonthDay(2018, 2, 26)));
    reserializeAndAssert(Value.dateArray(Arrays.asList(null, Date.fromYearMonthDay(2018, 2, 26))));

    BrokenSerializationList<String> of = BrokenSerializationList.of("a", "b");
    reserializeAndAssert(Value.stringArray(of));
    reserializeAndAssert(Value.stringArray(null));

    reserializeAndAssert(
        Value.bytesArray(BrokenSerializationList.of(newByteArray("a"), newByteArray("b"))));
    reserializeAndAssert(Value.bytesArray(null));

    Struct s1 = Struct.newBuilder().set("f1").to(1).build();
    Struct s2 = Struct.newBuilder().set("f1").to(2).build();
    reserializeAndAssert(Value.structArray(s1.getType(), BrokenSerializationList.of(s1, null, s2)));
    reserializeAndAssert(Value.structArray(s1.getType(), null));
  }

  @Test(expected = IllegalStateException.class)
  public void verifyBrokenSerialization() {
    reserializeAndAssert(BrokenSerializationList.of(1, 2, 3));
  }

  private static class BrokenSerializationList<T> extends ForwardingList<T>
      implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<T> delegate;

    public static <T> BrokenSerializationList<T> of(T... values) {
      return new BrokenSerializationList<>(Arrays.asList(values));
    }

    private BrokenSerializationList(List<T> delegate) {
      this.delegate = delegate;
    }

    @Override
    protected List<T> delegate() {
      return delegate;
    }

    private void readObject(@SuppressWarnings("unused") java.io.ObjectInputStream unusedStream)
        throws IOException, ClassNotFoundException {
      throw new IllegalStateException("Serialization disabled");
    }

    private void writeObject(@SuppressWarnings("unused") java.io.ObjectOutputStream unusedStream)
        throws IOException {
      throw new IllegalStateException("Serialization disabled");
    }
  }
}
