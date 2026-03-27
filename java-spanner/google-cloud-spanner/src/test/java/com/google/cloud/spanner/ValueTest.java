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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.AbstractResultSet.LazyByteArray;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.cloud.spanner.Type.StructField;
import com.google.common.base.Strings;
import com.google.common.collect.ForwardingList;
import com.google.common.collect.Lists;
import com.google.common.testing.EqualsTester;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.spanner.v1.PartialResultSet;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.Value}. */
@RunWith(JUnit4.class)
public class ValueTest {
  private static final String NULL_STRING = "NULL";

  private static ByteArray newByteArray(String data) {
    return ByteArray.copyFrom(data);
  }

  /** Returns an {@code Iterable} over {@code values} that is not a {@code Collection}. */
  @SafeVarargs
  private static <T> Iterable<T> plainIterable(T... values) {
    return Lists.newArrayList(values);
  }

  @Test
  public void untyped() {
    com.google.protobuf.Value proto =
        com.google.protobuf.Value.newBuilder().setStringValue("test").build();
    Value v = Value.untyped(proto);
    assertNull(v.getType());
    assertFalse(v.isNull());
    assertSame(proto, v.toProto());
    assertNotEquals(0, v.hashCode());
    assertEquals(v, Value.untyped(proto));

    assertEquals(
        v, Value.untyped(com.google.protobuf.Value.newBuilder().setStringValue("test").build()));
    assertEquals(
        Value.untyped(com.google.protobuf.Value.newBuilder().setNumberValue(3.14d).build()),
        Value.untyped(com.google.protobuf.Value.newBuilder().setNumberValue(3.14d).build()));
    assertEquals(
        Value.untyped(com.google.protobuf.Value.newBuilder().setBoolValue(true).build()),
        Value.untyped(com.google.protobuf.Value.newBuilder().setBoolValue(true).build()));

    assertNotEquals(
        v, Value.untyped(com.google.protobuf.Value.newBuilder().setStringValue("foo").build()));
    assertNotEquals(
        Value.untyped(com.google.protobuf.Value.newBuilder().setNumberValue(3.14d).build()),
        Value.untyped(com.google.protobuf.Value.newBuilder().setNumberValue(0.14d).build()));
    assertNotEquals(
        Value.untyped(com.google.protobuf.Value.newBuilder().setBoolValue(false).build()),
        Value.untyped(com.google.protobuf.Value.newBuilder().setBoolValue(true).build()));

    assertEquals("test", v.getAsString());
  }

  @Test
  public void bool() {
    Value v = Value.bool(true);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBool()).isTrue();
    assertThat(v.toString()).isEqualTo("true");
    assertEquals("true", v.getAsString());
  }

  @Test
  public void boolWrapper() {
    Value v = Value.bool(Boolean.FALSE);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBool()).isFalse();
    assertThat(v.toString()).isEqualTo("false");
    assertEquals("false", v.getAsString());
  }

  @Test
  public void boolWrapperNull() {
    Value v = Value.bool(null);
    assertThat(v.getType()).isEqualTo(Type.bool());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getBool);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void int64() {
    Value v = Value.int64(123);
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(123);
    assertThat(v.toString()).isEqualTo("123");
    assertEquals("123", v.getAsString());
  }

  @Test
  public void int64TryGetBool() {
    Value value = Value.int64(1234);
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBool);
    assertThat(e.getMessage()).contains("Expected: BOOL actual: INT64");
  }

  @Test
  public void int64NullTryGetBool() {
    Value value = Value.int64(null);
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBool);
    assertThat(e.getMessage()).contains("Expected: BOOL actual: INT64");
  }

  @Test
  public void int64TryGetInt64Array() {
    Value value = Value.int64(1234);
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getInt64Array);
    assertThat(e.getMessage()).contains("Expected: ARRAY<INT64> actual: INT64");
  }

  @Test
  public void int64Wrapper() {
    Value v = Value.int64(Long.valueOf(123));
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(123);
    assertThat(v.toString()).isEqualTo("123");
    assertEquals("123", v.getAsString());
  }

  @Test
  public void int64WrapperNull() {
    Value v = Value.int64(null);
    assertThat(v.getType()).isEqualTo(Type.int64());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float32() {
    Value v = Value.float32(1.23f);
    assertThat(v.getType()).isEqualTo(Type.float32());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat32()).isWithin(0.0001f).of(1.23f);
    assertThat(v.toString()).isEqualTo("1.23");
    assertEquals("1.23", v.getAsString());
    assertEquals(Value.float32(Float.NaN), Value.float32(Float.NaN));
  }

  @Test
  public void float32Wrapper() {
    Value v = Value.float32(Float.valueOf(1.23f));
    assertThat(v.getType()).isEqualTo(Type.float32());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat32()).isWithin(0.0001f).of(1.23f);
    assertThat(v.toString()).isEqualTo("1.23");
    assertEquals("1.23", v.getAsString());
  }

  @Test
  public void float32WrapperNull() {
    Value v = Value.float32(null);
    assertThat(v.getType()).isEqualTo(Type.float32());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat32);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float64() {
    Value v = Value.float64(1.23);
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64()).isWithin(0.0001).of(1.23);
    assertThat(v.toString()).isEqualTo("1.23");
    assertEquals("1.23", v.getAsString());
    assertEquals(Value.float64(Double.NaN), Value.float64(Double.NaN));
  }

  @Test
  public void float64Wrapper() {
    Value v = Value.float64(Double.valueOf(1.23));
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64()).isWithin(0.0001).of(1.23);
    assertThat(v.toString()).isEqualTo("1.23");
    assertEquals("1.23", v.getAsString());
  }

  @Test
  public void float64WrapperNull() {
    Value v = Value.float64(null);
    assertThat(v.getType()).isEqualTo(Type.float64());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat64);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void numeric() {
    Value v = Value.numeric(new BigDecimal("1.23"));
    assertThat(v.getType()).isEqualTo(Type.numeric());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getNumeric()).isEqualTo(BigDecimal.valueOf(123, 2));
    assertThat(v.toString()).isEqualTo("1.23");
    assertEquals("1.23", v.getAsString());
  }

  @Test
  public void pgNumeric() {
    final Value value = Value.pgNumeric("1234.5678");
    assertEquals(Type.pgNumeric(), value.getType());
    assertFalse("pgNumeric value should not be null", value.isNull());
    assertEquals("1234.5678", value.getString());
    assertEquals(BigDecimal.valueOf(12345678, 4), value.getNumeric());
    assertEquals(1234.5678D, value.getFloat64(), 0.00001);
    assertEquals("1234.5678", value.toString());
    assertEquals("1234.5678", value.getAsString());
    assertEquals(Value.pgNumeric("NaN"), Value.pgNumeric("NaN"));
  }

  @Test
  public void pgNumericNaN() {
    final Value value = Value.pgNumeric("NaN");
    assertEquals(Type.pgNumeric(), value.getType());
    assertFalse("pgNumeric value should not be null", value.isNull());
    assertEquals("NaN", value.getString());
    assertThrows(NumberFormatException.class, value::getNumeric);
    assertEquals(Double.NaN, value.getFloat64(), 0.00001);
    assertEquals("NaN", value.toString());
    assertEquals("NaN", value.getAsString());
  }

  @Test
  public void testNumericFormats() {
    // The following is copied from the Numeric proto documentation.
    // Encoded as `string`, in decimal format or scientific notation format.
    // <br>Decimal format:
    // <br>`[+-]Digits[.[Digits]]` or
    // <br>`[+-][Digits].Digits`
    //
    // Scientific notation:
    // <br>`[+-]Digits[.[Digits]][ExponentIndicator[+-]Digits]` or
    // <br>`[+-][Digits].Digits[ExponentIndicator[+-]Digits]`
    // <br>(ExponentIndicator is `"e"` or `"E"`)

    // The following is copied from the BigDecimal#toString() documentation.
    // <li>There is a one-to-one mapping between the distinguishable
    // {@code BigDecimal} values and the result of this conversion.
    // That is, every distinguishable {@code BigDecimal} value
    // (unscaled value and scale) has a unique string representation
    // as a result of using {@code toString}.  If that string
    // representation is converted back to a {@code BigDecimal} using
    // the {@link #BigDecimal(String)} constructor, then the original
    // value will be recovered.
    //
    // <li>The string produced for a given number is always the same;
    // it is not affected by locale.  This means that it can be used
    // as a canonical string representation for exchanging decimal
    // data, or as a key for a Hashtable, etc.  Locale-sensitive
    // number formatting and parsing is handled by the {@link
    // java.text.NumberFormat} class and its subclasses.

    // Test that BigDecimal supports all formats that are supported by Cloud Spanner.
    assertThat(new BigDecimal("1").toString()).isEqualTo("1");
    assertThat(new BigDecimal("01").toString()).isEqualTo("1");
    assertThat(new BigDecimal("1.").toString()).isEqualTo("1");
    assertThat(new BigDecimal("+1").toString()).isEqualTo("1");
    assertThat(new BigDecimal("+1.").toString()).isEqualTo("1");
    assertThat(new BigDecimal("-1").toString()).isEqualTo("-1");
    assertThat(new BigDecimal("-1.").toString()).isEqualTo("-1");

    assertThat(new BigDecimal("0.1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("00.1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal(".1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("+0.1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("+.1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("-0.1").toString()).isEqualTo("-0.1");
    assertThat(new BigDecimal("-.1").toString()).isEqualTo("-0.1");

    assertThat(new BigDecimal("1E+1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1e+1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1E1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1e1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("01E+1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("01e+1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("01E1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("01e1").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1E+01").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1e+01").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1E01").toString()).isEqualTo("1E+1");
    assertThat(new BigDecimal("1e01").toString()).isEqualTo("1E+1");

    assertThat(new BigDecimal("1E-1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("1e-1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("01E-1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("01e-1").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("1E-01").toString()).isEqualTo("0.1");
    assertThat(new BigDecimal("1e-01").toString()).isEqualTo("0.1");
  }

  @Test
  public void numericPrecisionAndScale() {
    for (long s : new long[] {1L, -1L}) {
      BigDecimal sign = new BigDecimal(s);
      assertThat(Value.numeric(new BigDecimal(Strings.repeat("9", 29)).multiply(sign)).toString())
          .isEqualTo((s == -1L ? "-" : "") + Strings.repeat("9", 29));
      SpannerException e1 =
          assertThrows(
              SpannerException.class,
              () -> Value.numeric(new BigDecimal(Strings.repeat("9", 30)).multiply(sign)));
      assertThat(e1.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      SpannerException e2 =
          assertThrows(
              SpannerException.class,
              () -> Value.numeric(new BigDecimal("1" + Strings.repeat("0", 29)).multiply(sign)));
      assertThat(e2.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);

      assertThat(
              Value.numeric(new BigDecimal("0." + Strings.repeat("9", 9)).multiply(sign))
                  .toString())
          .isEqualTo((s == -1L ? "-" : "") + "0." + Strings.repeat("9", 9));
      assertThat(
              Value.numeric(new BigDecimal("0.1" + Strings.repeat("0", 8)).multiply(sign))
                  .toString())
          .isEqualTo((s == -1L ? "-" : "") + "0.1" + Strings.repeat("0", 8));
      // Cloud Spanner does not store precision and considers 0.1 to be equal to 0.10.
      // 0.100000000000000000000000000 is therefore also a valid value, as it will be capped to 0.1.
      assertThat(
              Value.numeric(new BigDecimal("0.1" + Strings.repeat("0", 20)).multiply(sign))
                  .toString())
          .isEqualTo((s == -1L ? "-" : "") + "0.1" + Strings.repeat("0", 20));
      SpannerException e3 =
          assertThrows(
              SpannerException.class,
              () -> Value.numeric(new BigDecimal("0." + Strings.repeat("9", 10)).multiply(sign)));
      assertThat(e3.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);

      assertThat(
              Value.numeric(
                      new BigDecimal(Strings.repeat("9", 29) + "." + Strings.repeat("9", 9))
                          .multiply(sign))
                  .toString())
          .isEqualTo(
              (s == -1L ? "-" : "") + Strings.repeat("9", 29) + "." + Strings.repeat("9", 9));

      SpannerException e4 =
          assertThrows(
              SpannerException.class,
              () ->
                  Value.numeric(
                      new BigDecimal(Strings.repeat("9", 30) + "." + Strings.repeat("9", 9))
                          .multiply(sign)));
      assertThat(e4.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      SpannerException e5 =
          assertThrows(
              SpannerException.class,
              () ->
                  Value.numeric(
                      new BigDecimal("1" + Strings.repeat("0", 29) + "." + Strings.repeat("9", 9))
                          .multiply(sign)));
      assertThat(e5.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);

      SpannerException e6 =
          assertThrows(
              SpannerException.class,
              () ->
                  Value.numeric(
                      new BigDecimal(Strings.repeat("9", 29) + "." + Strings.repeat("9", 10))
                          .multiply(sign)));
      assertThat(e6.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
      SpannerException e7 =
          assertThrows(
              SpannerException.class,
              () -> Value.numeric(new BigDecimal("1." + Strings.repeat("9", 10)).multiply(sign)));
      assertThat(e7.getErrorCode()).isEqualTo(ErrorCode.OUT_OF_RANGE);
    }
  }

  @Test
  public void numericNull() {
    Value v = Value.numeric(null);
    assertThat(v.getType()).isEqualTo(Type.numeric());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    IllegalStateException e = assertThrows(IllegalStateException.class, v::getNumeric);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void pgNumericNull() {
    final Value value = Value.pgNumeric(null);
    assertEquals(Type.pgNumeric(), value.getType());
    assertTrue("pgNumeric value should be null", value.isNull());
    assertEquals(NULL_STRING, value.toString());

    final IllegalStateException e1 = assertThrows(IllegalStateException.class, value::getString);
    assertTrue("exception should mention value is null", e1.getMessage().contains("null value"));
    final IllegalStateException e2 = assertThrows(IllegalStateException.class, value::getNumeric);
    assertTrue("exception should mention value is null", e2.getMessage().contains("null value"));
    final IllegalStateException e3 = assertThrows(IllegalStateException.class, value::getFloat64);
    assertTrue("exception should mention value is null", e3.getMessage().contains("null value"));
    assertEquals("NULL", value.getAsString());
  }

  @Test
  public void pgNumericInvalid() {
    final Value value = Value.pgNumeric("INVALID");
    assertEquals(Type.pgNumeric(), value.getType());
    assertFalse("pgNumeric value should not be null", value.isNull());
    assertEquals("INVALID", value.toString());

    assertEquals("INVALID", value.getString());
    assertThrows(NumberFormatException.class, value::getNumeric);
    assertThrows(NumberFormatException.class, value::getFloat64);
    assertEquals("INVALID", value.getAsString());
  }

  @Test
  public void string() {
    Value v = Value.string("abc");
    assertThat(v.getType()).isEqualTo(Type.string());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getString()).isEqualTo("abc");
    assertEquals("abc", v.getAsString());
  }

  @Test
  public void stringNull() {
    Value v = Value.string(null);
    assertThat(v.getType()).isEqualTo(Type.string());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getString);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void stringLong() {
    String str = "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeee";
    Value v = Value.string(str);
    assertThat(v.getString()).isEqualTo(str);
    assertThat(v.toString()).hasLength(36);
    assertThat(v.toString()).startsWith(str.substring(0, 36 - 3));
    assertThat(v.toString()).endsWith("...");
    assertEquals(str, v.getAsString());
  }

  @Test
  public void json() {
    String json = "{\"color\":\"red\",\"value\":\"#f00\"}";
    Value v = Value.json(json);
    assertEquals(Type.json(), v.getType());
    assertFalse(v.isNull());
    assertEquals(json, v.getJson());
    assertEquals(json, v.getString());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void jsonNull() {
    Value v = Value.json(null);
    assertEquals(Type.json(), v.getType());
    assertTrue(v.isNull());
    assertEquals(NULL_STRING, v.toString());
    assertThrowsWithMessage(v::getJson, "null value");
    assertThrowsWithMessage(v::getString, "null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void jsonEmpty() {
    String json = "{}";
    Value v = Value.json(json);
    assertEquals(json, v.getJson());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void jsonWithEmptyArray() {
    String json = "[]";
    Value v = Value.json(json);
    assertEquals(json, v.getJson());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void jsonWithArray() {
    String json =
        "[{\"color\":\"red\",\"value\":\"#f00\"},{\"color\":\"green\",\"value\":\"#0f0\"},{\"color\":\"blue\",\"value\":\"#00f\"},{\"color\":\"cyan\",\"value\":\"#0ff\"},{\"color\":\"magenta\",\"value\":\"#f0f\"},{\"color\":\"yellow\",\"value\":\"#ff0\"},{\"color\":\"black\",\"value\":\"#000\"}]";
    Value v = Value.json(json);
    assertEquals(json, v.getJson());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void jsonNested() {
    String json =
        "[{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's"
            + " Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered"
            + " Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with"
            + " Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]},{\"id\":\"0002\",\"type\":\"donut\",\"name\":\"Raised\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]},{\"id\":\"0003\",\"type\":\"donut\",\"name\":\"Old"
            + " Fashioned\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}]";
    Value v = Value.json(json);
    assertEquals(json, v.getJson());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgJsonb() {
    String json = "{\"color\":\"red\",\"value\":\"#f00\"}";
    Value v = Value.pgJsonb(json);
    assertEquals(Type.pgJsonb(), v.getType());
    assertFalse(v.isNull());
    assertEquals(json, v.getPgJsonb());
    assertEquals(json, v.getString());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgJsonbNull() {
    Value v = Value.pgJsonb(null);
    assertEquals(Type.pgJsonb(), v.getType());
    assertTrue(v.isNull());
    assertEquals(NULL_STRING, v.toString());
    assertThrowsWithMessage(v::getPgJsonb, "null value");
    assertThrowsWithMessage(v::getString, "null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void testPgJsonbEmpty() {
    String json = "{}";
    Value v = Value.pgJsonb(json);
    assertEquals(json, v.getPgJsonb());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgJsonbWithEmptyArray() {
    String json = "[]";
    Value v = Value.pgJsonb(json);
    assertEquals(json, v.getPgJsonb());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgJsonbWithArray() {
    String json =
        "[{\"color\":\"red\",\"value\":\"#f00\"},{\"color\":\"green\",\"value\":\"#0f0\"},{\"color\":\"blue\",\"value\":\"#00f\"},{\"color\":\"cyan\",\"value\":\"#0ff\"},{\"color\":\"magenta\",\"value\":\"#f0f\"},{\"color\":\"yellow\",\"value\":\"#ff0\"},{\"color\":\"black\",\"value\":\"#000\"}]";
    Value v = Value.pgJsonb(json);
    assertEquals(json, v.getPgJsonb());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgJsonbNested() {
    String json =
        "[{\"id\":\"0001\",\"type\":\"donut\",\"name\":\"Cake\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"},{\"id\":\"1003\",\"type\":\"Blueberry\"},{\"id\":\"1004\",\"type\":\"Devil's"
            + " Food\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5007\",\"type\":\"Powdered"
            + " Sugar\"},{\"id\":\"5006\",\"type\":\"Chocolate with"
            + " Sprinkles\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]},{\"id\":\"0002\",\"type\":\"donut\",\"name\":\"Raised\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5005\",\"type\":\"Sugar\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]},{\"id\":\"0003\",\"type\":\"donut\",\"name\":\"Old"
            + " Fashioned\",\"ppu\":0.55,\"batters\":{\"batter\":[{\"id\":\"1001\",\"type\":\"Regular\"},{\"id\":\"1002\",\"type\":\"Chocolate\"}]},\"topping\":[{\"id\":\"5001\",\"type\":\"None\"},{\"id\":\"5002\",\"type\":\"Glazed\"},{\"id\":\"5003\",\"type\":\"Chocolate\"},{\"id\":\"5004\",\"type\":\"Maple\"}]}]";
    Value v = Value.pgJsonb(json);
    assertEquals(json, v.getPgJsonb());
    assertEquals(json, v.getAsString());
  }

  @Test
  public void testPgOid() {
    Value v = Value.pgOid(Long.valueOf(123));
    assertThat(v.getType()).isEqualTo(Type.pgOid());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(123);
    assertThat(v.toString()).isEqualTo("123");
    assertEquals("123", v.getAsString());
  }

  @Test
  public void testPgOidNull() {
    Value v = Value.pgOid(null);
    assertThat(v.getType()).isEqualTo(Type.pgOid());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void bytes() {
    ByteArray bytes = newByteArray("abc");
    Value v = Value.bytes(bytes);
    assertThat(v.getType()).isEqualTo(Type.bytes());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBytes()).isSameInstanceAs(bytes);
    assertThat(v.toString()).isEqualTo(bytes.toBase64());
    assertEquals(Base64.getEncoder().encodeToString(bytes.toByteArray()), v.getAsString());
  }

  @Test
  public void bytesUnprintable() {
    ByteArray bytes = ByteArray.copyFrom(new byte[] {'a', 0, 15, -1, 'e'});
    Value v = Value.bytes(bytes);
    assertThat(v.getBytes()).isSameInstanceAs(bytes);
    assertThat(v.toString()).isEqualTo(bytes.toBase64());
    assertEquals(Base64.getEncoder().encodeToString(bytes.toByteArray()), v.getAsString());
  }

  @Test
  public void bytesNull() {
    Value v = Value.bytes(null);
    assertThat(v.getType()).isEqualTo(Type.bytes());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getBytes);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void timestamp() {
    String timestamp = "2016-09-15T00:00:00Z";
    Timestamp t = Timestamp.parseTimestamp(timestamp);
    Value v = Value.timestamp(t);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isFalse();
    assertThat(v.isCommitTimestamp()).isFalse();
    assertThat(v.getTimestamp()).isSameInstanceAs(t);
    assertThat(v.toString()).isEqualTo(timestamp);
    assertEquals(timestamp, v.getAsString());
  }

  @Test
  public void timestampNull() {
    Value v = Value.timestamp(null);
    assertThat(v.getType()).isEqualTo(Type.timestamp());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    assertThat(v.isCommitTimestamp()).isFalse();
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getTimestamp);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
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
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getTimestamp);
    assertThat(e.getMessage()).contains("Commit timestamp value");
    assertEquals("spanner.commit_timestamp()", v.getAsString());
  }

  @Test
  public void date() {
    String date = "2016-09-15";
    Date t = Date.parseDate(date);
    Value v = Value.date(t);
    assertThat(v.getType()).isEqualTo(Type.date());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getDate()).isSameInstanceAs(t);
    assertThat(v.toString()).isEqualTo(date);
    assertEquals(date, v.getAsString());
  }

  @Test
  public void dateNull() {
    Value v = Value.date(null);
    assertThat(v.getType()).isEqualTo(Type.date());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getDate);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void uuid() {
    UUID uuid = UUID.randomUUID();
    Value v = Value.uuid(uuid);
    assertThat(v.getType()).isEqualTo(Type.uuid());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getUuid()).isSameInstanceAs(uuid);
    assertThat(v.toString()).isEqualTo(uuid.toString());
    assertEquals(uuid.toString(), v.getAsString());
  }

  @Test
  public void uuidNull() {
    Value v = Value.uuid(null);
    assertThat(v.getType()).isEqualTo(Type.uuid());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getUuid);
  }

  public void interval() {
    String interval = "P1Y2M3DT67H45M5.123478678S";
    Interval t = Interval.parseFromString(interval);
    Value v = Value.interval(t);
    assertThat(v.getType()).isEqualTo(Type.interval());
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInterval()).isSameInstanceAs(t);
    assertThat(v.toString()).isEqualTo(interval);
    assertEquals(interval, v.getAsString());
  }

  @Test
  public void intervalNull() {
    Value v = Value.interval(null);
    assertThat(v.getType()).isEqualTo(Type.interval());
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInterval);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void protoMessage() {
    SingerInfo singerInfo = SingerInfo.newBuilder().setSingerId(111).setGenre(Genre.FOLK).build();
    Value v = Value.protoMessage(singerInfo);
    assertThat(v.getType()).isEqualTo(Type.proto(SingerInfo.getDescriptor().getFullName()));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getProtoMessage(SingerInfo.getDefaultInstance())).isEqualTo(singerInfo);
    assertThat(v.getBytes().toByteArray()).isEqualTo(singerInfo.toByteArray());
  }

  @Test
  public void protoMessageNull() {
    Value v = Value.protoMessage(null, SingerInfo.getDescriptor().getFullName());
    assertThat(v.getType()).isEqualTo(Type.proto(SingerInfo.getDescriptor().getFullName()));
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> {
              v.getProtoMessage(SingerInfo.getDefaultInstance());
            });
    assertThat(e.getMessage()).contains("null value");
  }

  @Test
  public void protoEnum() {
    Genre genre = Genre.FOLK;
    Value v = Value.protoEnum(genre);
    assertThat(v.getType()).isEqualTo(Type.protoEnum(Genre.getDescriptor().getFullName()));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64()).isEqualTo(genre.getNumber());
    assertEquals(genre, v.getProtoEnum(Genre::forNumber));
  }

  @Test
  public void protoEnumNull() {
    Value v = Value.protoEnum(null, Genre.getDescriptor().getFullName());
    assertThat(v.getType()).isEqualTo(Type.protoEnum(Genre.getDescriptor().getFullName()));
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> {
              v.getProtoEnum(Genre::forNumber);
            });
    assertThat(e.getMessage()).contains("null value");
  }

  @Test
  public void boolArray() {
    Value v = Value.boolArray(new boolean[] {true, false});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(true, false).inOrder();
    assertThat(v.toString()).isEqualTo("[true,false]");
    assertEquals("[true,false]", v.getAsString());
  }

  @Test
  public void boolArrayRange() {
    Value v = Value.boolArray(new boolean[] {true, false, false, true, false}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(false, false, true).inOrder();
    assertThat(v.toString()).isEqualTo("[false,false,true]");
    assertEquals("[false,false,true]", v.getAsString());
  }

  @Test
  public void boolArrayNull() {
    Value v = Value.boolArray((boolean[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getBoolArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void boolArrayFromList() {
    Value v = Value.boolArray(Arrays.asList(true, null, false));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBoolArray()).containsExactly(true, null, false).inOrder();
    assertThat(v.toString()).isEqualTo("[true,NULL,false]");
    assertEquals("[true,NULL,false]", v.getAsString());
  }

  @Test
  public void boolArrayFromListNull() {
    Value v = Value.boolArray((Iterable<Boolean>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getBoolArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
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
      assertWithMessage(name).that(v.isNull()).isFalse();
      assertWithMessage(name).that(v.getBoolArray()).containsExactly((Object[]) data).inOrder();
      assertEquals(
          Arrays.stream(data)
              .map(element -> String.valueOf(element).replace("null", "NULL"))
              .collect(Collectors.joining(",", "[", "]")),
          v.getAsString());
    }
  }

  @Test
  public void boolArrayTryGetInt64Array() {
    Value value = Value.boolArray(Collections.singletonList(true));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getInt64Array);
    assertThat(e.getMessage()).contains("Expected: ARRAY<INT64> actual: ARRAY<BOOL>");
  }

  @Test
  public void int64Array() {
    Value v = Value.int64Array(new long[] {1, 2});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, 2L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,2]");
    assertEquals("[1,2]", v.getAsString());
  }

  @Test
  public void int64ArrayRange() {
    Value v = Value.int64Array(new long[] {1, 2, 3, 4, 5}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(2L, 3L, 4L).inOrder();
    assertThat(v.toString()).isEqualTo("[2,3,4]");
    assertEquals("[2,3,4]", v.getAsString());
  }

  @Test
  public void int64ArrayNull() {
    Value v = Value.int64Array((long[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void int64ArrayWrapper() {
    Value v = Value.int64Array(Arrays.asList(1L, null, 3L));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, null, 3L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,NULL,3]");
    assertEquals("[1,NULL,3]", v.getAsString());
  }

  @Test
  public void int64ArrayWrapperNull() {
    Value v = Value.int64Array((Iterable<Long>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void int64ArrayTryGetBool() {
    Value value = Value.int64Array(Collections.singletonList(1234L));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBool);
    assertThat(e.getMessage()).contains("Expected: BOOL actual: ARRAY<INT64>");
  }

  @Test
  public void int64ArrayNullTryGetBool() {
    Value value = Value.int64Array((Iterable<Long>) null);
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBool);
    assertThat(e.getMessage()).contains("Expected: BOOL actual: ARRAY<INT64>");
  }

  @Test
  public void float32Array() {
    Value v = Value.float32Array(new float[] {.1f, .2f});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat32Array()).containsExactly(.1f, .2f).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,0.2]");
    assertEquals("[0.1,0.2]", v.getAsString());
  }

  @Test
  public void float32ArrayRange() {
    Value v = Value.float32Array(new float[] {.1f, .2f, .3f, .4f, .5f}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat32Array()).containsExactly(.2f, .3f, .4f).inOrder();
    assertThat(v.toString()).isEqualTo("[0.2,0.3,0.4]");
    assertEquals("[0.2,0.3,0.4]", v.getAsString());
  }

  @Test
  public void float32ArrayNull() {
    Value v = Value.float32Array((float[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat32Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float32ArrayWrapper() {
    Value v = Value.float32Array(Arrays.asList(.1f, null, .3f));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat32Array()).containsExactly(.1f, null, .3f).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,NULL,0.3]");
    assertEquals("[0.1,NULL,0.3]", v.getAsString());
  }

  @Test
  public void float32ArrayWrapperNull() {
    Value v = Value.float32Array((Iterable<Float>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat32Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float32ArrayTryGetFloat64Array() {
    Value value = Value.float32Array(Collections.singletonList(.1f));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getFloat64Array);
    assertThat(e.getMessage()).contains("Expected: ARRAY<FLOAT64> actual: ARRAY<FLOAT32>");
  }

  @Test
  public void float64Array() {
    Value v = Value.float64Array(new double[] {.1, .2});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.1d, .2d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,0.2]");
    assertEquals("[0.1,0.2]", v.getAsString());
  }

  @Test
  public void float64ArrayRange() {
    Value v = Value.float64Array(new double[] {.1, .2, .3, .4, .5}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.2d, .3d, .4d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.2,0.3,0.4]");
    assertEquals("[0.2,0.3,0.4]", v.getAsString());
  }

  @Test
  public void float64ArrayNull() {
    Value v = Value.float64Array((double[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float64ArrayWrapper() {
    Value v = Value.float64Array(Arrays.asList(.1, null, .3));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getFloat64Array()).containsExactly(.1d, null, .3d).inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,NULL,0.3]");
    assertEquals("[0.1,NULL,0.3]", v.getAsString());
  }

  @Test
  public void float64ArrayWrapperNull() {
    Value v = Value.float64Array((Iterable<Double>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getFloat64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void float64ArrayTryGetInt64Array() {
    Value value = Value.float64Array(Collections.singletonList(.1));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getInt64Array);
    assertThat(e.getMessage()).contains("Expected: ARRAY<INT64> actual: ARRAY<FLOAT64>");
  }

  @Test
  public void numericArray() {
    Value v =
        Value.numericArray(Arrays.asList(BigDecimal.valueOf(1, 1), null, BigDecimal.valueOf(3, 1)));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getNumericArray())
        .containsExactly(new BigDecimal("0.1"), null, new BigDecimal("0.3"))
        .inOrder();
    assertThat(v.toString()).isEqualTo("[0.1,NULL,0.3]");
    assertEquals("[0.1,NULL,0.3]", v.getAsString());
  }

  @Test
  public void pgNumericArray() {
    final Value value = Value.pgNumericArray(Arrays.asList("1.23", null, "1.24"));
    assertFalse("pgNumericArray value should not be null", value.isNull());
    assertEquals(Arrays.asList("1.23", null, "1.24"), value.getStringArray());
    assertEquals(
        Arrays.asList(new BigDecimal("1.23"), null, new BigDecimal("1.24")),
        value.getNumericArray());
    final List<Double> float64Array = value.getFloat64Array();
    assertEquals(1.23D, float64Array.get(0), 0.001);
    assertNull(float64Array.get(1));
    assertEquals(1.24D, float64Array.get(2), 0.001);
    assertEquals("[1.23,NULL,1.24]", value.getAsString());
  }

  @Test
  public void pgNumericArrayWithNaNs() {
    final Value value = Value.pgNumericArray(Arrays.asList("1.23", null, Value.NAN));
    assertFalse("pgNumericArray value should not be null", value.isNull());
    assertEquals(Arrays.asList("1.23", null, "NaN"), value.getStringArray());
    assertThrows(NumberFormatException.class, value::getNumericArray);
    final List<Double> float64Array = value.getFloat64Array();
    assertEquals(1.23D, float64Array.get(0), 0.001);
    assertNull(float64Array.get(1));
    assertEquals(Double.NaN, float64Array.get(2), 0.001);
    assertEquals("[1.23,NULL,NaN]", value.getAsString());
  }

  @Test
  public void numericArrayNull() {
    Value v = Value.numericArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);

    IllegalStateException e = assertThrows(IllegalStateException.class, v::getNumericArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void pgNumericArrayNull() {
    final Value value = Value.pgNumericArray(null);
    assertTrue("pgNumericArray value should be null", value.isNull());
    assertEquals(NULL_STRING, value.toString());

    final IllegalStateException e1 =
        assertThrows(IllegalStateException.class, value::getStringArray);
    assertTrue("exception should mention value is null", e1.getMessage().contains("null value"));
    final IllegalStateException e2 =
        assertThrows(IllegalStateException.class, value::getNumericArray);
    assertTrue("exception should mention value is null", e2.getMessage().contains("null value"));
    final IllegalStateException e3 =
        assertThrows(IllegalStateException.class, value::getFloat64Array);
    assertTrue("exception should mention value is null", e3.getMessage().contains("null value"));
    assertEquals("NULL", value.getAsString());
  }

  @Test
  public void numericArrayTryGetInt64Array() {
    Value value = Value.numericArray(Collections.singletonList(BigDecimal.valueOf(1, 1)));

    IllegalStateException e = assertThrows(IllegalStateException.class, value::getInt64Array);
    assertThat(e.getMessage()).contains("Expected: ARRAY<INT64> actual: ARRAY<NUMERIC>");
  }

  @Test
  public void pgNumericArrayTryGetInt64Array() {
    final Value value = Value.pgNumericArray(Collections.singletonList("1.23"));

    final IllegalStateException e = assertThrows(IllegalStateException.class, value::getInt64Array);
    assertTrue(
        "exception should mention type expectation",
        e.getMessage().contains("Expected: ARRAY<INT64> actual: ARRAY<NUMERIC<PG_NUMERIC>>"));
  }

  @Test
  public void stringArray() {
    Value v = Value.stringArray(Arrays.asList("a", null, "c"));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getStringArray()).containsExactly("a", null, "c").inOrder();
    assertThat(v.toString()).isEqualTo("[a,NULL,c]");
    assertEquals("[a,NULL,c]", v.getAsString());
  }

  @Test
  public void stringArrayNull() {
    Value v = Value.stringArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getStringArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void stringArrayTryGetBytesArray() {
    Value value = Value.stringArray(Collections.singletonList("a"));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBytesArray);
    assertThat(e.getMessage()).contains("Expected: ARRAY<BYTES> actual: ARRAY<STRING>");
  }

  @Test
  public void jsonArray() {
    String one = "{}";
    String two = null;
    String three = "{\"color\":\"red\",\"value\":\"#f00\"}";
    Value v = Value.jsonArray(Arrays.asList(one, two, three));
    assertFalse(v.isNull());
    assertArrayEquals(new String[] {one, two, three}, v.getJsonArray().toArray());
    assertEquals("[{},NULL,{\"color\":\"red\",\"value\":\"#f00\"}]", v.toString());
    assertArrayEquals(new String[] {one, two, three}, v.getStringArray().toArray());
    assertEquals("[{},NULL,{\"color\":\"red\",\"value\":\"#f00\"}]", v.getAsString());
  }

  @Test
  public void jsonArrayNull() {
    Value v = Value.jsonArray(null);
    assertTrue(v.isNull());
    assertEquals(NULL_STRING, v.toString());
    assertThrowsWithMessage(v::getJsonArray, "null value");
    assertThrowsWithMessage(v::getStringArray, "null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void jsonArrayTryGetBytesArray() {
    Value value = Value.jsonArray(Collections.singletonList("{}"));
    assertThrowsWithMessage(value::getBytesArray, "Expected: ARRAY<BYTES> actual: ARRAY<JSON>");
  }

  @Test
  public void jsonArrayTryGetFloat64Array() {
    Value value = Value.jsonArray(Collections.singletonList("{}"));
    assertThrowsWithMessage(value::getFloat64Array, "Expected: ARRAY<FLOAT64> actual: ARRAY<JSON>");
  }

  @Test
  public void testPgJsonbArray() {
    String one = "{}";
    String two = null;
    String three = "{\"color\":\"red\",\"value\":\"#f00\"}";
    Value v = Value.pgJsonbArray(Arrays.asList(one, two, three));
    assertFalse(v.isNull());
    assertArrayEquals(new String[] {one, two, three}, v.getPgJsonbArray().toArray());
    assertEquals("[{},NULL,{\"color\":\"red\",\"value\":\"#f00\"}]", v.toString());
    assertArrayEquals(new String[] {one, two, three}, v.getStringArray().toArray());
    assertEquals("[{},NULL,{\"color\":\"red\",\"value\":\"#f00\"}]", v.getAsString());
  }

  @Test
  public void testPgJsonbArrayNull() {
    Value v = Value.pgJsonbArray(null);
    assertTrue(v.isNull());
    assertEquals(NULL_STRING, v.toString());
    assertThrowsWithMessage(v::getPgJsonbArray, "null value");
    assertThrowsWithMessage(v::getStringArray, "null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void testPgJsonbArrayTryGetBytesArray() {
    Value value = Value.pgJsonbArray(Collections.singletonList("{}"));
    assertThrowsWithMessage(
        value::getBytesArray, "Expected: ARRAY<BYTES> actual: ARRAY<JSON<PG_JSONB>>");
  }

  @Test
  public void testPgJsonbArrayTryGetFloat64Array() {
    Value value = Value.pgJsonbArray(Collections.singletonList("{}"));
    assertThrowsWithMessage(
        value::getFloat64Array, "Expected: ARRAY<FLOAT64> actual: ARRAY<JSON<PG_JSONB>>");
  }

  @Test
  public void testPgOidArray() {
    Value v = Value.pgOidArray(new long[] {1, 2});
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, 2L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,2]");
    assertEquals("[1,2]", v.getAsString());
  }

  @Test
  public void testPgOidArrayRange() {
    Value v = Value.pgOidArray(new long[] {1, 2, 3, 4, 5}, 1, 3);
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(2L, 3L, 4L).inOrder();
    assertThat(v.toString()).isEqualTo("[2,3,4]");
    assertEquals("[2,3,4]", v.getAsString());
  }

  @Test
  public void pgOidArrayNull() {
    Value v = Value.pgOidArray((long[]) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void testPgOidArrayWrapper() {
    Value v = Value.pgOidArray(Arrays.asList(1L, null, 3L));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getInt64Array()).containsExactly(1L, null, 3L).inOrder();
    assertThat(v.toString()).isEqualTo("[1,NULL,3]");
    assertEquals("[1,NULL,3]", v.getAsString());
  }

  @Test
  public void testPgOidArrayWrapperNull() {
    Value v = Value.pgOidArray((Iterable<Long>) null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getInt64Array);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void testPgOidArrayTryGetBool() {
    Value value = Value.pgOidArray(Collections.singletonList(1234L));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBool);
    assertThat(e.getMessage()).contains("Expected: BOOL actual: ARRAY<INT64<PG_OID>>");
  }

  @Test
  public void testPgOidArrayNullTryGetBool() {
    Value value = Value.pgOidArray((Iterable<Long>) null);
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getBoolArray);
    assertThat(e.getMessage()).contains("Expected: ARRAY<BOOL> actual: ARRAY<INT64<PG_OID>>");
  }

  @Test
  public void bytesArray() {
    ByteArray a = newByteArray("a");
    ByteArray c = newByteArray("c");
    Value v = Value.bytesArray(Arrays.asList(a, null, c));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getBytesArray()).containsExactly(a, null, c).inOrder();
    assertThat(v.toString())
        .isEqualTo(
            String.format(
                "[%s,NULL,%s]",
                Base64.getEncoder().encodeToString("a".getBytes(StandardCharsets.UTF_8)),
                Base64.getEncoder().encodeToString("c".getBytes(StandardCharsets.UTF_8))));
    assertEquals(
        String.format(
            "[%s,NULL,%s]",
            Base64.getEncoder().encodeToString("a".getBytes(StandardCharsets.UTF_8)),
            Base64.getEncoder().encodeToString("c".getBytes(StandardCharsets.UTF_8))),
        v.getAsString());
  }

  @Test
  public void bytesArrayNull() {
    Value v = Value.bytesArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getBytesArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void bytesArrayTryGetStringArray() {
    Value value = Value.bytesArray(Collections.singletonList(newByteArray("a")));
    IllegalStateException e = assertThrows(IllegalStateException.class, value::getStringArray);
    assertThat(e.getMessage()).contains("Expected: ARRAY<STRING> actual: ARRAY<BYTES>");
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
    assertEquals(String.format("[%s,NULL,%s]", t1, t2), v.getAsString());
  }

  @Test
  public void timestampArrayNull() {
    Value v = Value.timestampArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getTimestampArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
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
    assertEquals(String.format("[%s,NULL,%s]", d1, d2), v.getAsString());
  }

  @Test
  public void dateArrayNull() {
    Value v = Value.dateArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getDateArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void uuidArray() {
    UUID uuid1 = UUID.randomUUID();
    UUID uuid2 = UUID.randomUUID();

    Value v = Value.uuidArray(Arrays.asList(uuid1, null, uuid2));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getUuidArray()).containsExactly(uuid1, null, uuid2).inOrder();
    assertThat(v.toString()).isEqualTo("[" + uuid1.toString() + ",NULL," + uuid2.toString() + "]");
    assertEquals(
        String.format("[%s,NULL,%s]", uuid1.toString(), uuid2.toString()), v.getAsString());
  }

  @Test
  public void uuidArrayNull() {
    Value v = Value.uuidArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getUuidArray);
  }

  @Test
  public void intervalArray() {
    Interval interval1 = Interval.parseFromString("P123Y34M678DT478H345M345.76857863S");
    Interval interval2 = Interval.parseFromString("P-123Y-34M678DT-478H-345M-345.76857863S");

    Value v = Value.intervalArray(Arrays.asList(interval1, null, interval2));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getIntervalArray()).containsExactly(interval1, null, interval2).inOrder();
    assertThat(v.toString())
        .isEqualTo("[" + interval1.toISO8601() + ",NULL," + interval2.toISO8601() + "]");
    assertEquals(
        String.format("[%s,NULL,%s]", interval1.toISO8601(), interval2.toISO8601()),
        v.getAsString());
  }

  @Test
  public void intervalArrayNull() {
    Value v = Value.intervalArray(null);
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getIntervalArray);
    assertThat(e.getMessage()).contains("null value");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void protoMessageArray() {
    SingerInfo singerInfo1 = SingerInfo.newBuilder().setSingerId(111).setGenre(Genre.FOLK).build();
    SingerInfo singerInfo2 = SingerInfo.newBuilder().setSingerId(222).build();
    Value v =
        Value.protoMessageArray(
            Arrays.asList(singerInfo1, null, singerInfo2), SingerInfo.getDescriptor());
    assertThat(v.getType())
        .isEqualTo(Type.array(Type.proto(SingerInfo.getDescriptor().getFullName())));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getProtoMessageArray(SingerInfo.getDefaultInstance()))
        .containsExactly(singerInfo1, null, singerInfo2);
    assertThat(v.getBytesArray())
        .containsExactly(
            ByteArray.copyFrom(singerInfo1.toByteArray()),
            null,
            ByteArray.copyFrom(singerInfo2.toByteArray()));
  }

  @Test
  public void protoMessageNullArray() {
    Value v = Value.protoMessageArray(null, SingerInfo.getDescriptor());
    assertThat(v.getType())
        .isEqualTo(Type.array(Type.proto(SingerInfo.getDescriptor().getFullName())));
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> {
              v.getProtoMessageArray(SingerInfo.getDefaultInstance());
            });
    assertThat(e.getMessage()).contains("null value");
  }

  @Test
  public void protoEnumArray() {
    Genre genre1 = Genre.ROCK;
    Genre genre2 = Genre.JAZZ;
    Value v = Value.protoEnumArray(Arrays.asList(genre1, null, genre2), Genre.getDescriptor());
    assertThat(v.getType())
        .isEqualTo(Type.array(Type.protoEnum(Genre.getDescriptor().getFullName())));
    assertThat(v.isNull()).isFalse();
    assertThat(v.getProtoEnumArray(Genre::forNumber)).containsExactly(genre1, null, genre2);
    assertThat(v.getInt64Array())
        .containsExactly((long) genre1.getNumber(), null, (long) genre2.getNumber());
  }

  @Test
  public void protoEnumNullArray() {
    Value v = Value.protoEnumArray(null, Genre.getDescriptor());
    assertThat(v.getType())
        .isEqualTo(Type.array(Type.protoEnum(Genre.getDescriptor().getFullName())));
    assertThat(v.isNull()).isTrue();
    assertThat(v.toString()).isEqualTo(NULL_STRING);
    IllegalStateException e =
        assertThrows(
            IllegalStateException.class,
            () -> {
              v.getProtoEnumArray(Genre::forNumber);
            });
    assertThat(e.getMessage()).contains("null value");
  }

  @Test
  public void struct() {
    Struct struct = Struct.newBuilder().set("f1").to("v1").set("f2").to(30).build();
    Value v1 = Value.struct(struct);
    assertThat(v1.getType()).isEqualTo(struct.getType());
    assertThat(v1.isNull()).isFalse();
    assertThat(v1.getStruct()).isEqualTo(struct);
    assertThat(v1.toString()).isEqualTo("[v1, 30]");
    assertEquals("[v1, 30]", v1.getAsString());

    Value v2 = Value.struct(struct.getType(), struct);
    assertThat(v2).isEqualTo(v1);
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                Value.struct(
                    Type.struct(Collections.singletonList(StructField.of("f3", Type.string()))),
                    struct));
    assertThat(e.getMessage()).contains("Mismatch between struct value and type.");
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
    NullPointerException e = assertThrows(NullPointerException.class, () -> Value.struct(null));
    assertThat(e.getMessage()).contains("Illegal call to create a NULL struct value.");
    assertEquals("NULL", v.getAsString());
  }

  @Test
  public void nullStructGetter() {
    List<Type.StructField> fieldTypes =
        Arrays.asList(
            Type.StructField.of("f1", Type.string()), Type.StructField.of("f2", Type.int64()));

    Value v = Value.struct(Type.struct(fieldTypes), null);
    assertThat(v.isNull()).isTrue();
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getStruct);
    assertThat(e.getMessage()).contains("Illegal call to getter of null value.");
    assertEquals("NULL", v.getAsString());
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
    assertEquals("[[v1, 1],NULL,NULL,[v3, 3]]", v.getAsString());
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
    IllegalStateException e = assertThrows(IllegalStateException.class, v::getStructArray);
    assertThat(e.getMessage()).contains("Illegal call to getter of null value");
    assertEquals("NULL", v.getAsString());
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
    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class, () -> Value.structArray(elementType, arrayElements));
    assertThat(e.getMessage()).contains("must have type STRUCT<ff1 STRING, ff2 INT64>");
  }

  @Test
  public void testValueToProto() {
    // BASE types.
    assertEquals(
        com.google.protobuf.Value.newBuilder().setBoolValue(true).build(),
        Value.bool(true).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setBoolValue(false).build(),
        Value.bool(false).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.bool(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("1").build(),
        Value.int64(1L).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.int64(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setNumberValue(3.14f).build(),
        Value.float32(3.14f).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.float32(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setNumberValue(3.14d).build(),
        Value.float64(3.14d).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.float64(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("test").build(),
        Value.string("test").toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.string(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("{}").build(),
        Value.json("{}").toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.json(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setStringValue(ByteArray.copyFrom("test").toBase64())
            .build(),
        Value.bytes(ByteArray.copyFrom("test")).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.bytes(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("3.14").build(),
        Value.numeric(new BigDecimal("3.14")).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.numeric(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("1234.5678").build(),
        Value.pgNumeric("1234.5678").toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.pgNumeric(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("2010-02-28").build(),
        Value.date(Date.fromYearMonthDay(2010, 2, 28)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.date(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setStringValue("e0d8a283-29d8-49ce-8d4c-e1d8cb0ea047")
            .build(),
        Value.uuid(UUID.fromString("e0d8a283-29d8-49ce-8d4c-e1d8cb0ea047")).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.uuid(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder().setStringValue("P1Y2M3DT5H6M3.624567878S").build(),
        Value.interval(Interval.fromMonthsDaysNanos(14, 3, BigInteger.valueOf(18363624567878L)))
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.interval(null).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setStringValue("2012-04-10T15:16:17.123456789Z")
            .build(),
        Value.timestamp(Timestamp.parseTimestamp("2012-04-10T15:16:17.123456789Z")).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build(),
        Value.timestamp(null).toProto());

    // ARRAY types.
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setBoolValue(true).build(),
                            com.google.protobuf.Value.newBuilder().setBoolValue(false).build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.boolArray(Arrays.asList(true, false, null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setStringValue("1").build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.int64Array(Arrays.asList(1L, null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setNumberValue(3.14f).build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.float32Array(Arrays.asList(3.14f, null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setNumberValue(3.14d).build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.float64Array(Arrays.asList(3.14d, null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setStringValue("test").build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.stringArray(Arrays.asList("test", null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setStringValue("{}").build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.jsonArray(Arrays.asList("{}", null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue(ByteArray.copyFrom("test").toBase64())
                                .build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.bytesArray(Arrays.asList(ByteArray.copyFrom("test"), null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setStringValue("3.14").build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.numericArray(Arrays.asList(new BigDecimal("3.14"), null)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder().setStringValue("1.23").build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build(),
                            com.google.protobuf.Value.newBuilder().setStringValue("NaN").build())))
            .build(),
        Value.pgNumericArray(Arrays.asList("1.23", null, Value.NAN)).toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue("2010-02-28")
                                .build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.dateArray(Arrays.asList(Date.fromYearMonthDay(2010, 2, 28), null)).toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue("3fb10ff0-4a9a-428a-bc20-a947181fd76d")
                                .build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.uuidArray(
                Arrays.asList(UUID.fromString("3fb10ff0-4a9a-428a-bc20-a947181fd76d"), null))
            .toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue("P1Y2M3DT5H6M2.456787800S")
                                .build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.intervalArray(
                Arrays.asList(
                    Interval.fromMonthsDaysNanos(14, 3, new BigInteger("18362456787800")), null))
            .toProto());

    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addAllValues(
                        Arrays.asList(
                            com.google.protobuf.Value.newBuilder()
                                .setStringValue("2012-04-10T15:16:17.123456789Z")
                                .build(),
                            com.google.protobuf.Value.newBuilder()
                                .setNullValue(NullValue.NULL_VALUE)
                                .build())))
            .build(),
        Value.timestampArray(
                Arrays.asList(Timestamp.parseTimestamp("2012-04-10T15:16:17.123456789Z"), null))
            .toProto());

    // STRUCT type with array field.
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setBoolValue(true)
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setBoolValue(false)
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder().add(Value.boolArray(Arrays.asList(true, false, null))).build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("1")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(Struct.newBuilder().add(Value.int64Array(Arrays.asList(1L, null))).build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setNumberValue(3.14f)
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder().add(Value.float32Array(Arrays.asList(3.14f, null))).build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setNumberValue(3.14d)
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder().add(Value.float64Array(Arrays.asList(3.14d, null))).build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("test")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder().add(Value.stringArray(Arrays.asList("test", null))).build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue(
                                                    ByteArray.copyFrom("test").toBase64())
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(Value.bytesArray(Arrays.asList(ByteArray.copyFrom("test"), null)))
                    .build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("3.14")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(Value.numericArray(Arrays.asList(new BigDecimal("3.14"), null)))
                    .build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("2010-02-28")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(Value.dateArray(Arrays.asList(Date.fromYearMonthDay(2010, 2, 28), null)))
                    .build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue(
                                                    "9e2f9eac-8d6f-45c1-ac1d-c589daad8821")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(
                        Value.uuidArray(
                            Arrays.asList(
                                UUID.fromString("9e2f9eac-8d6f-45c1-ac1d-c589daad8821"), null)))
                    .build())
            .toProto());
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("2012-04-10T15:16:17.123456789Z")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(
                        Value.timestampArray(
                            Arrays.asList(
                                Timestamp.parseTimestamp("2012-04-10T15:16:17.123456789Z"), null)))
                    .build())
            .toProto());
    // Struct with pgNumeric
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder().setStringValue("1.23").build())
                    .build())
            .build(),
        Value.struct(Struct.newBuilder().set("x").to(Value.pgNumeric("1.23")).build()).toProto());
    // Struct with pgNumeric Array
    assertEquals(
        com.google.protobuf.Value.newBuilder()
            .setListValue(
                ListValue.newBuilder()
                    .addValues(
                        com.google.protobuf.Value.newBuilder()
                            .setListValue(
                                ListValue.newBuilder()
                                    .addAllValues(
                                        Arrays.asList(
                                            com.google.protobuf.Value.newBuilder()
                                                .setNullValue(NullValue.NULL_VALUE)
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("1.23")
                                                .build(),
                                            com.google.protobuf.Value.newBuilder()
                                                .setStringValue("NaN")
                                                .build()))
                                    .build())
                            .build())
                    .build())
            .build(),
        Value.struct(
                Struct.newBuilder()
                    .add(Value.pgNumericArray(Arrays.asList(null, "1.23", "NaN")))
                    .build())
            .toProto());
  }

  @Test
  public void testEqualsHashCode() {
    EqualsTester tester = new EqualsTester();
    String emptyJson = "{}";
    String simpleJson = "{\"color\":\"red\",\"value\":\"#f00\"}";

    tester.addEqualityGroup(Value.bool(true), Value.bool(Boolean.TRUE));
    tester.addEqualityGroup(Value.bool(false));
    tester.addEqualityGroup(Value.bool(null));

    tester.addEqualityGroup(Value.int64(123), Value.int64(Long.valueOf(123)));
    tester.addEqualityGroup(Value.int64(456));
    tester.addEqualityGroup(Value.int64(null));

    tester.addEqualityGroup(Value.float32(1.23f), Value.float32(Float.valueOf(1.23f)));
    tester.addEqualityGroup(Value.float32(4.56f));
    tester.addEqualityGroup(Value.float32(null));

    tester.addEqualityGroup(Value.float64(1.23), Value.float64(Double.valueOf(1.23)));
    tester.addEqualityGroup(Value.float64(4.56));
    tester.addEqualityGroup(Value.float64(null));

    tester.addEqualityGroup(
        Value.numeric(BigDecimal.valueOf(123, 2)), Value.numeric(new BigDecimal("1.23")));
    tester.addEqualityGroup(Value.numeric(BigDecimal.valueOf(456, 2)));
    tester.addEqualityGroup(Value.numeric(null));

    tester.addEqualityGroup(Value.pgNumeric("1234.5678"), Value.pgNumeric("1234.5678"));
    tester.addEqualityGroup(Value.pgNumeric("NaN"), Value.pgNumeric(Value.NAN));
    tester.addEqualityGroup(Value.pgNumeric("8765.4321"));
    tester.addEqualityGroup(Value.pgNumeric(null));

    tester.addEqualityGroup(Value.pgOid(123L), Value.pgOid(Long.valueOf(123)));
    tester.addEqualityGroup(Value.pgOid(456L));
    tester.addEqualityGroup(Value.pgOid(null));

    tester.addEqualityGroup(Value.string("abc"), Value.string("abc"));
    tester.addEqualityGroup(Value.string("def"));
    tester.addEqualityGroup(Value.string(null));

    tester.addEqualityGroup(Value.json(simpleJson), Value.json(simpleJson));
    tester.addEqualityGroup(Value.json("{}"));
    tester.addEqualityGroup(Value.json("[]"));
    tester.addEqualityGroup(Value.json(null));

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

    UUID uuid = UUID.randomUUID();
    tester.addEqualityGroup(Value.uuid(null), Value.uuid(null));
    tester.addEqualityGroup(Value.uuid(uuid), Value.uuid(uuid));
    tester.addEqualityGroup(Value.uuid(UUID.randomUUID()));

    Struct structValue1 = Struct.newBuilder().set("f1").to(20).set("f2").to("def").build();
    Struct structValue2 = Struct.newBuilder().set("f1").to(20).set("f2").to("def").build();
    assertThat(Value.struct(structValue1).equals(Value.struct(structValue2))).isTrue();
    tester.addEqualityGroup(Value.struct(structValue1), Value.struct(structValue2));

    Type structType1 = structValue1.getType();
    Type structType2 = Type.struct(Collections.singletonList(StructField.of("f1", Type.string())));
    tester.addEqualityGroup(Value.struct(structType1, null), Value.struct(structType1, null));
    tester.addEqualityGroup(Value.struct(structType2, null), Value.struct(structType2, null));

    tester.addEqualityGroup(
        Value.boolArray(Arrays.asList(false, true)),
        Value.boolArray(new boolean[] {false, true}),
        Value.boolArray(new boolean[] {true, false, true, false}, 1, 2),
        Value.boolArray(plainIterable(false, true)));
    tester.addEqualityGroup(Value.boolArray(Collections.singletonList(false)));
    tester.addEqualityGroup(Value.boolArray((Iterable<Boolean>) null));

    tester.addEqualityGroup(
        Value.int64Array(Arrays.asList(1L, 2L)),
        Value.int64Array(new long[] {1L, 2L}),
        Value.int64Array(new long[] {0L, 1L, 2L, 3L}, 1, 2),
        Value.int64Array(plainIterable(1L, 2L)));
    tester.addEqualityGroup(Value.int64Array(Collections.singletonList(3L)));
    tester.addEqualityGroup(Value.int64Array((Iterable<Long>) null));

    tester.addEqualityGroup(
        Value.float32Array(Arrays.asList(.1f, .2f)),
        Value.float32Array(new float[] {.1f, .2f}),
        Value.float32Array(new float[] {.0f, .1f, .2f, .3f}, 1, 2),
        Value.float32Array(plainIterable(.1f, .2f)));
    tester.addEqualityGroup(Value.float32Array(Collections.singletonList(.3f)));
    tester.addEqualityGroup(Value.float32Array((Iterable<Float>) null));

    tester.addEqualityGroup(
        Value.float64Array(Arrays.asList(.1, .2)),
        Value.float64Array(new double[] {.1, .2}),
        Value.float64Array(new double[] {.0, .1, .2, .3}, 1, 2),
        Value.float64Array(plainIterable(.1, .2)));
    tester.addEqualityGroup(Value.float64Array(Collections.singletonList(.3)));
    tester.addEqualityGroup(Value.float64Array((Iterable<Double>) null));

    tester.addEqualityGroup(
        Value.numericArray(Arrays.asList(BigDecimal.valueOf(1, 1), BigDecimal.valueOf(2, 1))));
    tester.addEqualityGroup(
        Value.numericArray(Collections.singletonList(BigDecimal.valueOf(3, 1))));
    tester.addEqualityGroup(Value.numericArray(null));

    tester.addEqualityGroup(
        Value.pgNumericArray(Arrays.asList("1.23", null, Value.NAN)),
        Value.pgNumericArray(Arrays.asList("1.23", null, "NaN")));
    tester.addEqualityGroup(Value.pgNumericArray(Collections.singletonList("1.25")));
    tester.addEqualityGroup(Value.pgNumericArray(null), Value.pgNumericArray(null));

    tester.addEqualityGroup(
        Value.pgOidArray(Arrays.asList(1L, 2L)),
        Value.pgOidArray(new long[] {1L, 2L}),
        Value.pgOidArray(new long[] {0L, 1L, 2L, 3L}, 1, 2),
        Value.pgOidArray(plainIterable(1L, 2L)));
    tester.addEqualityGroup(Value.pgOidArray(Collections.singletonList(3L)));
    tester.addEqualityGroup(Value.pgOidArray(Collections.singletonList(null)));
    tester.addEqualityGroup(Value.pgOidArray((Iterable<Long>) null));

    tester.addEqualityGroup(
        Value.stringArray(Arrays.asList("a", "b")), Value.stringArray(Arrays.asList("a", "b")));
    tester.addEqualityGroup(Value.stringArray(Collections.singletonList("c")));
    tester.addEqualityGroup(Value.stringArray(null));

    tester.addEqualityGroup(
        Value.jsonArray(Arrays.asList(emptyJson, simpleJson)),
        Value.jsonArray(Arrays.asList(emptyJson, simpleJson)));
    tester.addEqualityGroup(Value.jsonArray(Arrays.asList("[]")));
    tester.addEqualityGroup(Value.jsonArray(null));

    tester.addEqualityGroup(
        Value.bytesArray(Arrays.asList(newByteArray("a"), newByteArray("b"))),
        Value.bytesArray(Arrays.asList(newByteArray("a"), newByteArray("b"))));
    tester.addEqualityGroup(Value.bytesArray(Collections.singletonList(newByteArray("c"))));
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
        Value.uuidArray(Arrays.asList(null, uuid)), Value.uuidArray(Arrays.asList(null, uuid)));
    tester.addEqualityGroup(Value.uuidArray(null));

    tester.addEqualityGroup(
        Value.intervalArray(
            Arrays.asList(null, Interval.fromMonthsDaysNanos(14, 3, BigInteger.valueOf(0)))),
        Value.intervalArray(
            Arrays.asList(null, Interval.fromMonthsDaysNanos(14, 3, BigInteger.valueOf(0)))));
    tester.addEqualityGroup(Value.intervalArray(null));

    tester.addEqualityGroup(
        Value.structArray(structType1, Arrays.asList(structValue1, null)),
        Value.structArray(structType1, Arrays.asList(structValue2, null)));
    tester.addEqualityGroup(
        Value.structArray(structType1, Collections.singletonList(null)),
        Value.structArray(structType1, Collections.singletonList(null)));
    tester.addEqualityGroup(
        Value.structArray(structType1, null), Value.structArray(structType1, null));
    tester.addEqualityGroup(
        Value.structArray(structType1, new ArrayList<>()),
        Value.structArray(structType1, new ArrayList<>()));

    tester.testEquals();
  }

  @Test
  public void testGetAsString() {
    assertEquals("true", Value.bool(true).getAsString());
    assertEquals("false", Value.bool(false).getAsString());

    assertEquals("1", Value.int64(1L).getAsString());
    assertEquals(String.valueOf(Long.MAX_VALUE), Value.int64(Long.MAX_VALUE).getAsString());
    assertEquals(String.valueOf(Long.MIN_VALUE), Value.int64(Long.MIN_VALUE).getAsString());

    assertEquals("3.14", Value.float32(3.14f).getAsString());
    assertEquals("NaN", Value.float32(Float.NaN).getAsString());
    assertEquals(String.valueOf(Float.MIN_VALUE), Value.float32(Float.MIN_VALUE).getAsString());
    assertEquals(String.valueOf(Float.MAX_VALUE), Value.float32(Float.MAX_VALUE).getAsString());

    assertEquals("3.14", Value.float64(3.14d).getAsString());
    assertEquals("NaN", Value.float64(Double.NaN).getAsString());
    assertEquals(String.valueOf(Double.MIN_VALUE), Value.float64(Double.MIN_VALUE).getAsString());
    assertEquals(String.valueOf(Double.MAX_VALUE), Value.float64(Double.MAX_VALUE).getAsString());

    assertEquals("3.14", Value.numeric(new BigDecimal("3.14")).getAsString());
    assertEquals(
        "123456789.123456789", Value.numeric(new BigDecimal("123456789.123456789")).getAsString());

    assertEquals("3.14", Value.pgNumeric("3.14").getAsString());
    assertEquals("123456789.123456789", Value.pgNumeric("123456789.123456789").getAsString());
    assertEquals("NaN", Value.pgNumeric("NaN").getAsString());

    assertEquals("1", Value.pgOid(1L).getAsString());
    assertEquals(String.valueOf(Long.MAX_VALUE), Value.pgOid(Long.MAX_VALUE).getAsString());
    assertEquals(String.valueOf(Long.MIN_VALUE), Value.pgOid(Long.MIN_VALUE).getAsString());

    assertEquals(Strings.repeat("foo", 36), Value.string(Strings.repeat("foo", 36)).getAsString());
    assertEquals(Strings.repeat("foo", 36), Value.json(Strings.repeat("foo", 36)).getAsString());
    assertEquals(Strings.repeat("foo", 36), Value.pgJsonb(Strings.repeat("foo", 36)).getAsString());

    assertEquals(
        "2023-01-10T18:59:00Z",
        Value.timestamp(Timestamp.parseTimestamp("2023-01-10T18:59:00Z")).getAsString());
    assertEquals("2023-01-10", Value.date(Date.parseDate("2023-01-10")).getAsString());
    assertEquals(
        "4ef8ba78-3bb5-4a8f-ae39-bf59a89a491d",
        Value.uuid(UUID.fromString("4ef8ba78-3bb5-4a8f-ae39-bf59a89a491d")).getAsString());
    assertEquals(
        "P1Y2M3DT4H5M6.789123456S",
        Value.interval(Interval.parseFromString("P1Y2M3DT4H5M6.789123456S")).getAsString());

    Random random = new Random();
    byte[] bytes = new byte[random.nextInt(256)];
    assertEquals(
        Base64.getEncoder().encodeToString(bytes),
        Value.bytes(ByteArray.copyFrom(bytes)).getAsString());
    assertEquals(
        Base64.getEncoder().encodeToString(bytes),
        Value.internalBytes(new LazyByteArray(Base64.getEncoder().encodeToString(bytes)))
            .getAsString());
  }

  @Test
  public void serialization() {

    reserializeAndAssert(Value.bool(true));
    reserializeAndAssert(Value.bool(false));
    reserializeAndAssert(Value.bool(null));

    reserializeAndAssert(Value.int64(123));
    reserializeAndAssert(Value.int64(null));

    reserializeAndAssert(Value.float32(1.23f));
    reserializeAndAssert(Value.float32(null));

    reserializeAndAssert(Value.float64(1.23));
    reserializeAndAssert(Value.float64(null));

    reserializeAndAssert(Value.numeric(BigDecimal.valueOf(123, 2)));
    reserializeAndAssert(Value.numeric(null));

    reserializeAndAssert(Value.pgNumeric("1.23"));
    reserializeAndAssert(Value.pgNumeric(Value.NAN));
    reserializeAndAssert(Value.pgNumeric(null));

    reserializeAndAssert(Value.pgOid(123L));
    reserializeAndAssert(Value.pgOid(null));

    reserializeAndAssert(Value.string("abc"));
    reserializeAndAssert(Value.string(null));

    reserializeAndAssert(Value.json("{\"color\":\"red\",\"value\":\"#f00\"}"));
    reserializeAndAssert(Value.json(null));

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

    reserializeAndAssert(Value.float32Array(new float[] {.1f, .2f}));
    reserializeAndAssert(Value.float32Array(BrokenSerializationList.of(.1f, .2f, .3f)));
    reserializeAndAssert(Value.float32Array((Iterable<Float>) null));

    reserializeAndAssert(Value.float64Array(new double[] {.1, .2}));
    reserializeAndAssert(Value.float64Array(BrokenSerializationList.of(.1, .2, .3)));
    reserializeAndAssert(Value.float64Array((Iterable<Double>) null));

    reserializeAndAssert(
        Value.numericArray(
            Arrays.asList(BigDecimal.valueOf(1, 1), null, BigDecimal.valueOf(2, 1))));
    reserializeAndAssert(
        Value.numericArray(
            BrokenSerializationList.of(
                BigDecimal.valueOf(1, 1), BigDecimal.valueOf(2, 1), BigDecimal.valueOf(3, 1))));
    reserializeAndAssert(Value.numericArray(null));

    reserializeAndAssert(Value.pgNumericArray(Arrays.asList("1.23", null, Value.NAN)));
    reserializeAndAssert(
        Value.pgNumericArray(BrokenSerializationList.of("1.23", "1.24", Value.NAN)));
    reserializeAndAssert(Value.pgNumericArray(null));

    reserializeAndAssert(
        Value.pgOidArray(BrokenSerializationList.of(Long.valueOf(1L), Long.valueOf(2L))));
    reserializeAndAssert(
        Value.pgOidArray(BrokenSerializationList.of(Long.valueOf(1L), Long.valueOf(2L), null)));
    reserializeAndAssert(Value.pgOidArray((Iterable<Long>) null));

    reserializeAndAssert(Value.timestamp(null));
    reserializeAndAssert(Value.timestamp(Value.COMMIT_TIMESTAMP));
    reserializeAndAssert(Value.timestamp(Timestamp.now()));
    reserializeAndAssert(Value.timestampArray(Arrays.asList(null, Timestamp.now())));

    reserializeAndAssert(Value.date(null));
    reserializeAndAssert(Value.date(Date.fromYearMonthDay(2018, 2, 26)));
    reserializeAndAssert(Value.dateArray(Arrays.asList(null, Date.fromYearMonthDay(2018, 2, 26))));

    reserializeAndAssert(Value.uuid(null));
    reserializeAndAssert(Value.uuid(UUID.fromString("20d55f8b-5cd4-46ae-81bc-38f6b53c243b")));
    reserializeAndAssert(
        Value.uuidArray(
            Arrays.asList(null, UUID.fromString("20d55f8b-5cd4-46ae-81bc-38f6b53c243b"))));

    reserializeAndAssert(Value.interval(null));
    reserializeAndAssert(
        Value.interval(Interval.fromMonthsDaysNanos(15, 7, BigInteger.valueOf(1234567891))));
    reserializeAndAssert(
        Value.intervalArray(
            Arrays.asList(
                null, Interval.fromMonthsDaysNanos(15, 7, BigInteger.valueOf(1234567891)))));

    BrokenSerializationList<String> of = BrokenSerializationList.of("a", "b");
    reserializeAndAssert(Value.stringArray(of));
    reserializeAndAssert(Value.stringArray(null));

    BrokenSerializationList<String> json =
        BrokenSerializationList.of("{}", "{\"color\":\"red\",\"value\":\"#f00\"}");
    reserializeAndAssert(Value.jsonArray(json));
    reserializeAndAssert(Value.jsonArray(null));

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

  @Test
  public void testToValue() {
    Value value = Value.toValue(null);
    assertNull(value.getType());
    assertEquals("NULL", value.getAsString());

    int i = 10;
    value = Value.toValue(i);
    assertNull(value.getType());
    assertEquals("10", value.getAsString());

    Integer j = 10;
    value = Value.toValue(j);
    assertNull(value.getType());
    assertEquals("10", value.getAsString());

    long k = 10L;
    value = Value.toValue(k);
    assertNull(value.getType());
    assertEquals("10", value.getAsString());

    Long l = 10L;
    value = Value.toValue(i);
    assertNull(value.getType());
    assertEquals("10", value.getAsString());

    boolean m = true;
    value = Value.toValue(m);
    assertEquals(Type.bool(), value.getType());
    assertTrue(value.getBool());

    Boolean n = true;
    value = Value.toValue(n);
    assertEquals(Type.bool(), value.getType());
    assertTrue(value.getBool());

    Float o = 0.3f;
    value = Value.toValue(o);
    assertEquals(Type.float32(), value.getType());
    assertEquals(0.3f, value.getFloat32(), 0);

    float p = 0.3f;
    value = Value.toValue(p);
    assertEquals(Type.float32(), value.getType());
    assertEquals(0.3f, value.getFloat32(), 0);

    Double q = 0.4d;
    value = Value.toValue(q);
    assertEquals(Type.float64(), value.getType());
    assertEquals(0.4d, value.getFloat64(), 0);

    double s = 0.5d;
    value = Value.toValue(s);
    assertEquals(Type.float64(), value.getType());
    assertEquals(0.5d, value.getFloat64(), 0);

    BigDecimal t = BigDecimal.valueOf(0.6d);
    value = Value.toValue(t);
    assertEquals(Type.numeric(), value.getType());
    assertEquals(t, value.getNumeric());

    ByteArray bytes = ByteArray.copyFrom("hello");
    value = Value.toValue(bytes);
    assertEquals(Type.bytes(), value.getType());
    assertEquals(bytes, value.getBytes());

    byte[] byteArray = "hello".getBytes();
    value = Value.toValue(byteArray);
    assertEquals(Type.bytes(), value.getType());
    assertEquals(bytes, value.getBytes());

    Date date = Date.fromYearMonthDay(2018, 2, 26);
    value = Value.toValue(date);
    assertEquals(Type.date(), value.getType());
    assertEquals(date, value.getDate());

    UUID uuid = UUID.randomUUID();
    value = Value.toValue(uuid);
    assertEquals(Type.uuid(), value.getType());
    assertEquals(uuid, value.getUuid());

    LocalDate localDate = LocalDate.of(2018, 2, 26);
    value = Value.toValue(localDate);
    assertEquals(Type.date(), value.getType());
    assertEquals(date, value.getDate());

    TimeZone defaultTimezone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("Europe/Paris"));
    LocalDateTime localDateTime = LocalDateTime.of(2018, 2, 26, 11, 30, 10);
    value = Value.toValue(localDateTime);
    assertNull(value.getType());
    assertEquals("2018-02-26T10:30:10.000Z", value.getAsString());
    TimeZone.setDefault(defaultTimezone);

    OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(10));
    value = Value.toValue(offsetDateTime);
    assertNull(value.getType());
    assertEquals("2018-02-26T01:30:10.000Z", value.getAsString());

    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Kolkata"));
    value = Value.toValue(zonedDateTime);
    assertNull(value.getType());
    assertEquals("2018-02-26T06:00:10.000Z", value.getAsString());

    ProtocolMessageEnum protocolMessageEnum = IsolationLevel.SERIALIZABLE;
    value = Value.toValue(protocolMessageEnum);
    assertEquals(
        Type.protoEnum("google.spanner.v1.TransactionOptions.IsolationLevel"), value.getType());
    assertEquals(
        protocolMessageEnum,
        value.getProtoEnum(
            (val -> {
              switch (val) {
                case 1:
                  return IsolationLevel.SERIALIZABLE;
                case 2:
                  return IsolationLevel.REPEATABLE_READ;
                default:
                  return IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED;
              }
            })));

    PartialResultSet partialResultSet =
        PartialResultSet.newBuilder()
            .addValues(com.google.protobuf.Value.newBuilder().setStringValue("hello").build())
            .build();
    value = Value.toValue(partialResultSet);
    assertEquals(Type.proto("google.spanner.v1.PartialResultSet"), value.getType());
    assertEquals(partialResultSet, value.getProtoMessage(PartialResultSet.getDefaultInstance()));

    Interval interval = Interval.ofDays(10);
    value = Value.toValue(interval);
    assertEquals(Type.interval(), value.getType());
    assertEquals(interval, value.getInterval());

    Struct struct = Struct.newBuilder().set("name").to(10L).build();
    value = Value.toValue(struct);
    assertEquals(Type.struct(StructField.of("name", Type.int64())), value.getType());
    assertEquals(struct, value.getStruct());

    Timestamp timestamp = Timestamp.now();
    value = Value.toValue(timestamp);
    assertEquals(Type.timestamp(), value.getType());
    assertEquals(timestamp, value.getTimestamp());

    List<Boolean> expectedBoolArray = Arrays.asList(true, false);
    boolean[] bools1 = {true, false};
    value = Value.toValue(bools1);
    assertEquals(Type.array(Type.bool()), value.getType());
    assertEquals(expectedBoolArray, value.getBoolArray());

    Boolean[] bools2 = {true, false};
    value = Value.toValue(bools2);
    assertEquals(Type.array(Type.bool()), value.getType());
    assertEquals(expectedBoolArray, value.getBoolArray());

    List<Float> expectedFloatArray = Arrays.asList(0.1f, 0.2f, 0.3f);
    Float[] floats1 = {0.1f, 0.2f, 0.3f};
    value = Value.toValue(floats1);
    assertEquals(Type.array(Type.float32()), value.getType());
    assertEquals(expectedFloatArray, value.getFloat32Array());

    float[] floats2 = {0.1f, 0.2f, 0.3f};
    value = Value.toValue(floats2);
    assertEquals(Type.array(Type.float32()), value.getType());
    assertEquals(expectedFloatArray, value.getFloat32Array());

    List<Double> expectedDoubleArray = Arrays.asList(0.1d, 0.2d, 0.3d, 0.4d);
    Double[] doubles1 = {0.1d, 0.2d, 0.3d, 0.4d};
    value = Value.toValue(doubles1);
    assertEquals(Type.array(Type.float64()), value.getType());
    assertEquals(expectedDoubleArray, value.getFloat64Array());

    double[] doubles2 = {0.1d, 0.2d, 0.3d, 0.4d};
    value = Value.toValue(doubles2);
    assertEquals(Type.array(Type.float64()), value.getType());
    assertEquals(expectedDoubleArray, value.getFloat64Array());

    List<String> expectedIntLongArray = Arrays.asList("1", "2", "3");
    int[] ints1 = {1, 2, 3};
    value = Value.toValue(ints1);
    assertNull(value.getType());
    assertEquals(expectedIntLongArray, value.getAsStringList());

    Integer[] ints2 = {1, 2, 3};
    value = Value.toValue(ints2);
    assertNull(value.getType());
    assertEquals(expectedIntLongArray, value.getAsStringList());

    Long[] longs1 = {1L, 2L, 3L};
    value = Value.toValue(longs1);
    assertNull(value.getType());
    assertEquals(expectedIntLongArray, value.getAsStringList());

    long[] longs2 = {1L, 2L, 3L};
    value = Value.toValue(longs2);
    assertNull(value.getType());
    assertEquals(expectedIntLongArray, value.getAsStringList());

    String string = "hello";
    value = Value.toValue(string);
    assertNull(value.getType());
    assertEquals("hello", value.getAsString());
  }

  @Test
  public void testToValueIterable() {
    List<Boolean> booleans = Arrays.asList(true, false);
    Value value = Value.toValue(booleans);
    assertEquals(Type.array(Type.bool()), value.getType());
    assertEquals(booleans, value.getBoolArray());

    List<Integer> ints = Arrays.asList(1, 2, 3);
    value = Value.toValue(ints);
    assertNull(value.getType());
    assertEquals(Arrays.asList("1", "2", "3"), value.getAsStringList());

    List<Long> longs = Arrays.asList(1L, 2L, 3L);
    value = Value.toValue(longs);
    assertNull(value.getType());
    assertEquals(Arrays.asList("1", "2", "3"), value.getAsStringList());

    Set<Float> floats = new HashSet<>(Arrays.asList(0.1f, 0.2f, 0.3f));
    value = Value.toValue(floats);
    assertEquals(Type.array(Type.float32()), value.getType());
    assertEquals(Arrays.asList(0.1f, 0.2f, 0.3f), value.getFloat32Array());

    List<Double> doubles = Arrays.asList(0.1d, 0.2d, 0.3d, 0.4d);
    value = Value.toValue(doubles);
    assertEquals(Type.array(Type.float64()), value.getType());
    assertEquals(doubles, value.getFloat64Array());

    List<BigDecimal> bigDecimals =
        Arrays.asList(BigDecimal.valueOf(0.1d), BigDecimal.valueOf(0.2d));
    value = Value.toValue(bigDecimals);
    assertEquals(Type.array(Type.numeric()), value.getType());
    assertEquals(bigDecimals, value.getNumericArray());

    List<ByteArray> byteArrays =
        Arrays.asList(ByteArray.copyFrom("hello"), ByteArray.copyFrom("world"));
    value = Value.toValue(byteArrays);
    assertEquals(Type.array(Type.bytes()), value.getType());
    assertEquals(byteArrays, value.getBytesArray());

    List<byte[]> bytes = Arrays.asList("hello".getBytes(), "world".getBytes());
    value = Value.toValue(bytes);
    assertEquals(Type.array(Type.bytes()), value.getType());
    assertEquals(byteArrays, value.getBytesArray());

    List<Interval> intervals = Arrays.asList(Interval.ofDays(10), Interval.ofDays(20));
    value = Value.toValue(intervals);
    assertEquals(Type.array(Type.interval()), value.getType());
    assertEquals(intervals, value.getIntervalArray());

    List<com.google.cloud.Timestamp> timestamps = Arrays.asList(Timestamp.now(), Timestamp.now());
    value = Value.toValue(timestamps);
    assertEquals(Type.array(Type.timestamp()), value.getType());
    assertEquals(timestamps, value.getTimestampArray());

    List<Date> dates =
        Arrays.asList(Date.fromYearMonthDay(2024, 8, 23), Date.fromYearMonthDay(2024, 12, 27));
    value = Value.toValue(dates);
    assertEquals(Type.array(Type.date()), value.getType());
    assertEquals(dates, value.getDateArray());

    List<UUID> uuids = Arrays.asList(UUID.randomUUID(), UUID.randomUUID());
    value = Value.toValue(uuids);
    assertEquals(Type.array(Type.uuid()), value.getType());
    assertEquals(uuids, value.getUuidArray());

    List<LocalDate> localDates =
        Arrays.asList(LocalDate.of(2024, 8, 23), LocalDate.of(2024, 12, 27));
    value = Value.toValue(localDates);
    assertEquals(Type.array(Type.date()), value.getType());
    assertEquals(dates, value.getDateArray());

    TimeZone defaultTimezone = TimeZone.getDefault();
    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
    List<LocalDateTime> localDateTimes =
        Arrays.asList(
            LocalDateTime.of(2024, 8, 23, 1, 49, 52, 10),
            LocalDateTime.of(2024, 12, 27, 1, 49, 52, 10));
    value = Value.toValue(localDateTimes);
    assertNull(value.getType());
    assertEquals(
        Arrays.asList("2024-08-22T20:19:52.000Z", "2024-12-26T20:19:52.000Z"),
        value.getAsStringList());
    TimeZone.setDefault(defaultTimezone);

    List<OffsetDateTime> offsetDateTimes =
        Arrays.asList(
            LocalDateTime.of(2024, 8, 23, 1, 49, 52, 10).atOffset(ZoneOffset.ofHours(1)),
            LocalDateTime.of(2024, 12, 27, 1, 49, 52, 10).atOffset(ZoneOffset.ofHours(1)));
    value = Value.toValue(offsetDateTimes);
    assertNull(value.getType());
    assertEquals(
        Arrays.asList("2024-08-23T00:49:52.000Z", "2024-12-27T00:49:52.000Z"),
        value.getAsStringList());

    List<ZonedDateTime> zonedDateTimes =
        Arrays.asList(
            LocalDateTime.of(2024, 8, 23, 1, 49, 52, 10).atZone(ZoneId.of("UTC")),
            LocalDateTime.of(2024, 12, 27, 1, 49, 52, 10).atZone(ZoneId.of("UTC")));
    value = Value.toValue(zonedDateTimes);
    assertNull(value.getType());
    assertEquals(
        Arrays.asList("2024-08-23T01:49:52.000Z", "2024-12-27T01:49:52.000Z"),
        value.getAsStringList());
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

    private void readObject(@SuppressWarnings("unused") java.io.ObjectInputStream unusedStream) {
      throw new IllegalStateException("Serialization disabled");
    }

    private void writeObject(@SuppressWarnings("unused") java.io.ObjectOutputStream unusedStream) {
      throw new IllegalStateException("Serialization disabled");
    }
  }

  private void assertThrowsWithMessage(Supplier<?> supplier, String message) {
    try {
      supplier.get();
      fail("Expected exception");
    } catch (Exception e) {
      assertTrue(
          "Expected exception message to contain: \""
              + message
              + "\", actual: \""
              + e.getMessage()
              + "\"",
          e.getMessage().contains(message));
    }
  }
}
