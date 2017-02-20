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

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ByteArray;
import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
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
    assertThat(v.toString()).isEqualTo("abc");
  }

  @Test
  public void bytesUnprintable() {
    ByteArray bytes = ByteArray.copyFrom(new byte[] {'a', 0, 15, -1, 'e'});
    Value v = Value.bytes(bytes);
    assertThat(v.getBytes()).isSameAs(bytes);
    assertThat(v.toString()).isEqualTo("a\\0\\17\\377e");
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
  public void bytesLong() {
    String str = "aaaaaaaaaabbbbbbbbbbccccccccccdddddddddd";
    ByteArray bytes = newByteArray(str);
    Value v = Value.bytes(bytes);
    assertThat(v.getBytes()).isEqualTo(bytes);
    assertThat(v.toString()).hasLength(32);
    assertThat(v.toString()).startsWith(str.substring(0, 32 - 3));
    assertThat(v.toString()).endsWith("...");
  }

  @Test
  public void timestamp() {
    String timestamp = "2016-09-15T00:00:00Z";
    Timestamp t = Timestamp.parseTimestamp(timestamp);
    Value v = Value.timestamp(t);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getTimestamp()).isSameAs(t);
    assertThat(v.toString()).isEqualTo(timestamp);
  }

  @Test
  public void timestampNull() {
    Value v = Value.timestamp(null);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    expectedException.expect(IllegalStateException.class);
    expectedException.expectMessage("null value");
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
    Value v = Value.bytesArray(Arrays.asList(newByteArray("a"), null, newByteArray("c")));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBytesArray())
        .containsExactly(newByteArray("a"), null, newByteArray("c"))
        .inOrder();
    assertThat(v.toString()).isEqualTo("[a,NULL,c]");
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
  public void structArray() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("ff1", Type.string()), Type.StructField.of("ff2", Type.int64()));
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("v1").set("ff2").to(1).build(),
            null,
            Struct.newBuilder().set("ff1").to("v3").set("ff2").to(3).build());
    Struct struct =
        Struct.newBuilder().set("f1").to("x").add("f2", fieldTypes, arrayElements).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(Type.struct(fieldTypes)))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isFalse();
    assertThat(struct.getString(0)).isEqualTo("x");
    assertThat(struct.getStructList(1)).isEqualTo(arrayElements);
  }

  @Test
  public void structArrayNull() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("ff1", Type.string()), Type.StructField.of("ff2", Type.int64()));
    Struct struct = Struct.newBuilder().set("f1").to("x").add("f2", fieldTypes, null).build();
    assertThat(struct.getType())
        .isEqualTo(
            Type.struct(
                Type.StructField.of("f1", Type.string()),
                Type.StructField.of("f2", Type.array(Type.struct(fieldTypes)))));
    assertThat(struct.isNull(0)).isFalse();
    assertThat(struct.isNull(1)).isTrue();
  }

  @Test
  public void structArrayInvalidType() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("ff1", Type.string()), Type.StructField.of("ff2", Type.int64()));
    // Second element has INT64 first field, not STRING.
    List<Struct> arrayElements =
        Arrays.asList(
            Struct.newBuilder().set("ff1").to("1").set("ff2").to(1).build(),
            Struct.newBuilder().set("ff1").to(2).set("ff2").to(3).build());

    expectedException.expect(IllegalArgumentException.class);
    expectedException.expectMessage("must have type STRUCT<ff1 STRING, ff2 INT64>");
    Struct.newBuilder().add("f1", fieldTypes, arrayElements);
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

    tester.testEquals();
  }
}
