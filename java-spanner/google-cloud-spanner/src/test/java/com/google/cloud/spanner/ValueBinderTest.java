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

import static com.google.cloud.spanner.ValueBinderTest.DefaultValues.defaultBytesBase64;
import static com.google.cloud.spanner.ValueBinderTest.DefaultValues.defaultJson;
import static com.google.cloud.spanner.ValueBinderTest.DefaultValues.defaultLongWrapper;
import static com.google.cloud.spanner.ValueBinderTest.DefaultValues.defaultPgJsonb;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SingerProto.Genre;
import com.google.cloud.spanner.SingerProto.SingerInfo;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors.Descriptor;
import com.google.protobuf.Descriptors.EnumDescriptor;
import com.google.protobuf.ProtocolMessageEnum;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.ValueBinder}. */
@RunWith(JUnit4.class)
public class ValueBinderTest {
  private static final String JSON_METHOD_NAME = "json";
  private static final String PG_JSONB_METHOD_NAME = "pgJsonb";
  private static final String PG_OID_METHOD_NAME = "pgOid";
  private static final String PG_NUMERIC_METHOD_NAME = "pgNumeric";
  private static final String PROTO_MESSAGE_METHOD_NAME = "protoMessage";
  private static final String PROTO_ENUM_METHOD_NAME = "protoEnum";
  private static final String BYTES_BASE64_METHOD_NAME = "bytesFromBase64";
  public static final String DEFAULT_PG_NUMERIC = "1.23";

  private Value lastValue;
  private int lastReturnValue;
  private ValueBinder<Integer> binder = new BinderImpl();

  private class BinderImpl extends ValueBinder<Integer> {
    @Override
    Integer handle(Value value) {
      lastValue = value;
      return ++lastReturnValue;
    }
  }

  @Test
  public void reflection()
      throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    // Test that every Value factory method has a counterpart in ValueBinder, and that invoking it
    // produces the expected Value. The only exception is for untyped values, which must be
    // constructed manually as an untyped value and then assigned as a parameter.
    for (Method method : Value.class.getMethods()) {
      if (!Modifier.isStatic(method.getModifiers())
          || !method.getReturnType().equals(Value.class)
          || (method.getParameterTypes().length > 0
              && method.getParameterTypes()[0].equals(com.google.protobuf.Value.class))) {
        continue;
      }
      Method binderMethod = findBinderMethod(method);
      assertWithMessage("Binder for " + method.toString()).that(binderMethod).isNotNull();

      if (method.getName().toLowerCase().contains("struct")) {
        // Struct / Array-of-struct binding methods.
        Struct struct = Struct.newBuilder().set("f1").to("abc").build();
        Type structType = struct.getType();

        if (binderMethod.getName().equals("toStructArray")) {
          // Array of structs.
          assertThat(binderMethod.getParameterTypes()).hasLength(2);

          Value expected =
              (Value) method.invoke(Value.class, structType, Collections.singletonList(struct));
          assertThat(binderMethod.invoke(binder, structType, Collections.singletonList(struct)))
              .isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);

          // Test ValueBinder.to(value)
          assertThat(binder.to(expected)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);

          // Null Array-of-structs
          Value expectedNull = (Value) method.invoke(Value.class, structType, null);
          assertThat(binderMethod.invoke(binder, structType, null)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expectedNull);

          assertThat(binder.to(expectedNull)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expectedNull);
        } else if (binderMethod.getParameterTypes().length == 2) {
          // NULL struct.
          assertThat(binderMethod.getParameterTypes()[0]).isEqualTo(Type.class);
          assertThat(binderMethod.getParameterTypes()[1]).isEqualTo(Struct.class);

          Value expectedNull = (Value) method.invoke(Value.class, structType, null);
          assertThat(binderMethod.invoke(binder, structType, null)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expectedNull);

          assertThat(binder.to(expectedNull)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expectedNull);
        } else {
          // non-NULL struct.
          assertThat(binderMethod.getParameterTypes()).hasLength(1);
          assertThat(binderMethod.getParameterTypes()[0]).isEqualTo(Struct.class);

          Value expected = (Value) method.invoke(Value.class, struct);
          assertThat(binderMethod.invoke(binder, struct)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);

          assertThat(binder.to(expected)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);
        }
      } else if (binderMethod.getParameterTypes().length == 1) {
        // Test unary null.
        if (!binderMethod.getParameterTypes()[0].isPrimitive()
            && (!method.getName().equalsIgnoreCase(PROTO_MESSAGE_METHOD_NAME)
                && !method.getName().equalsIgnoreCase(PROTO_ENUM_METHOD_NAME))) {
          if (method.getName().equalsIgnoreCase(JSON_METHOD_NAME)) {
            // Special case for json to change the method from ValueBinder.to(String) to
            // ValueBinder.to(Value)
            binderMethod = ValueBinder.class.getMethod("to", Value.class);
            assertThat(binderMethod.invoke(binder, Value.json(null))).isEqualTo(lastReturnValue);
          } else if (method.getName().equalsIgnoreCase(PG_JSONB_METHOD_NAME)) {
            binderMethod = ValueBinder.class.getMethod("to", Value.class);
            assertThat(binderMethod.invoke(binder, Value.pgJsonb(null))).isEqualTo(lastReturnValue);
          } else if (method.getName().equalsIgnoreCase(PG_OID_METHOD_NAME)) {
            binderMethod = ValueBinder.class.getMethod("to", Value.class);
            assertThat(binderMethod.invoke(binder, Value.pgOid(null))).isEqualTo(lastReturnValue);
          } else if (method.getName().equalsIgnoreCase(PG_NUMERIC_METHOD_NAME)) {
            binderMethod = ValueBinder.class.getMethod("to", Value.class);
            assertThat(binderMethod.invoke(binder, Value.pgNumeric(null)))
                .isEqualTo(lastReturnValue);
          } else if (method.getName().equalsIgnoreCase(BYTES_BASE64_METHOD_NAME)) {
            binderMethod = ValueBinder.class.getMethod("to", Value.class);
            assertThat(binderMethod.invoke(binder, Value.bytesFromBase64(null)))
                .isEqualTo(lastReturnValue);
          } else {
            assertThat(binderMethod.invoke(binder, (Object) null)).isEqualTo(lastReturnValue);
          }
          Value expected = (Value) method.invoke(Value.class, (Object) null);
          assertThat(lastValue).isEqualTo(expected);
          assertThat(binder.to(expected)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);
        }
        // Test unary non-null.
        Object defaultObject;
        if (method.getName().equalsIgnoreCase(JSON_METHOD_NAME)) {
          defaultObject = defaultJson();
          binderMethod = ValueBinder.class.getMethod("to", Value.class);
          assertThat(binderMethod.invoke(binder, Value.json(defaultJson())))
              .isEqualTo(lastReturnValue);
        } else if (method.getName().equalsIgnoreCase(PG_JSONB_METHOD_NAME)) {
          defaultObject = defaultPgJsonb();
          binderMethod = ValueBinder.class.getMethod("to", Value.class);
          assertThat(binderMethod.invoke(binder, Value.pgJsonb(defaultPgJsonb())))
              .isEqualTo(lastReturnValue);
        } else if (method.getName().equalsIgnoreCase(PG_OID_METHOD_NAME)) {
          defaultObject = defaultLongWrapper();
          binderMethod = ValueBinder.class.getMethod("to", Value.class);
          assertThat(binderMethod.invoke(binder, Value.pgOid(defaultLongWrapper())))
              .isEqualTo(lastReturnValue);
        } else if (method.getName().equalsIgnoreCase(PG_NUMERIC_METHOD_NAME)) {
          defaultObject = DEFAULT_PG_NUMERIC;
          binderMethod = ValueBinder.class.getMethod("to", Value.class);
          assertThat(binderMethod.invoke(binder, Value.pgNumeric(DEFAULT_PG_NUMERIC)))
              .isEqualTo(lastReturnValue);
        } else if (method.getName().equalsIgnoreCase(BYTES_BASE64_METHOD_NAME)) {
          defaultObject = defaultBytesBase64();
          binderMethod = ValueBinder.class.getMethod("to", Value.class);
          assertThat(binderMethod.invoke(binder, Value.bytesFromBase64(defaultBytesBase64())))
              .isEqualTo(lastReturnValue);
        } else {
          defaultObject = DefaultValues.getDefault(method.getGenericParameterTypes()[0]);
          assertThat(binderMethod.invoke(binder, defaultObject)).isEqualTo(lastReturnValue);
        }
        Value expected = (Value) method.invoke(Value.class, defaultObject);
        assertThat(lastValue).isEqualTo(expected);

        assertThat(binder.to(expected)).isEqualTo(lastReturnValue);
        assertThat(lastValue).isEqualTo(expected);
      } else if (binderMethod.getParameterTypes().length == 2
          && (method.getName().contains(PROTO_MESSAGE_METHOD_NAME)
              || method.getName().contains(PROTO_ENUM_METHOD_NAME))) {
        // Test unary null.
        Object firstArgument = null;
        if (binderMethod.getParameterTypes()[0].isPrimitive()) {
          firstArgument = 0;
        }

        Object secondArgument = "com.proto.example";
        if (binderMethod.getParameterTypes()[1] == Descriptor.class) {
          secondArgument = SingerInfo.getDescriptor();
        } else if (binderMethod.getParameterTypes()[1] == EnumDescriptor.class) {
          secondArgument = Genre.getDescriptor();
        }
        assertThat(binderMethod.invoke(binder, firstArgument, secondArgument))
            .isEqualTo(lastReturnValue);
        Value expected = (Value) method.invoke(Value.class, firstArgument, secondArgument);
        assertThat(lastValue).isEqualTo(expected);
        assertThat(binder.to(expected)).isEqualTo(lastReturnValue);
        assertThat(lastValue).isEqualTo(expected);
      } else {
        // Array slice method: depends on DefaultValues returning arrays of length 2.
        assertThat(binderMethod.getParameterTypes().length).isEqualTo(3);
        assertThat(binderMethod.getParameterTypes()[1]).isEqualTo(int.class);
        assertThat(binderMethod.getParameterTypes()[2]).isEqualTo(int.class);

        Value expectedNull = (Value) method.invoke(Value.class, null, -1, -1);
        assertThat(binderMethod.invoke(binder, null, 0, 0)).isEqualTo(lastReturnValue);
        assertThat(lastValue).isEqualTo(expectedNull);

        Object defaultObject = DefaultValues.getDefault(method.getGenericParameterTypes()[0]);
        Value expectedNonNull = (Value) method.invoke(Value.class, defaultObject, 0, 2);
        assertThat(binderMethod.invoke(binder, defaultObject, 0, 2)).isEqualTo(lastReturnValue);
        assertThat(lastValue).isEqualTo(expectedNonNull);
      }
    }
  }

  static Method findBinderMethod(Method valueMethod) {
    String name;
    if (valueMethod.getName().contains("Array")) {
      // int64Array -> toInt64Array.
      name =
          "to"
              + valueMethod.getName().substring(0, 1).toUpperCase()
              + valueMethod.getName().substring(1);
    } else {
      name = "to";
    }
    try {
      return ValueBinder.class.getMethod(name, valueMethod.getParameterTypes());
    } catch (NoSuchMethodException e) {
      return null;
    }
  }

  static class DefaultValues {
    public static boolean defaultBooleanPrimitive() {
      return true;
    }

    public static Boolean defaultBooleanWrapper() {
      return true;
    }

    public static long defaultLongPrimitive() {
      return 1234L;
    }

    public static Long defaultLongWrapper() {
      return 1234L;
    }

    public static float defaultFloatPrimitive() {
      return 1.0f;
    }

    public static Float defaultFloatWrapper() {
      return 1.0f;
    }

    public static double defaultDoublePrimitive() {
      return 1.0;
    }

    public static Double defaultDoubleWrapper() {
      return 1.0;
    }

    public static BigDecimal defaultBigDecimal() {
      return BigDecimal.valueOf(123, 2);
    }

    public static AbstractMessage defaultAbstractMessage() {
      return SingerInfo.newBuilder().setSingerId(323).build();
    }

    public static ProtocolMessageEnum defaultProtocolMessageEnum() {
      return Genre.FOLK;
    }

    public static String defaultString() {
      return "x";
    }

    public static String defaultJson() {
      return "{\"color\":\"red\",\"value\":\"#f00\"}";
    }

    public static String defaultPgJsonb() {
      return "{\"color\":\"red\",\"value\":\"#f00\"}";
    }

    public static String defaultBytesBase64() {
      return Base64.getEncoder().encodeToString("test-bytes".getBytes(StandardCharsets.UTF_8));
    }

    public static ByteArray defaultByteArray() {
      return ByteArray.copyFrom(new byte[] {'x'});
    }

    public static Timestamp defaultTimestamp() {
      return Timestamp.ofTimeSecondsAndNanos(0, 0);
    }

    public static Date defaultDate() {
      return Date.fromYearMonthDay(2016, 9, 15);
    }

    public static UUID defaultUuid() {
      return UUID.fromString("db09330e-cc05-472c-a54e-b2784deebac3");
    }

    public static Interval defaultInterval() {
      return Interval.parseFromString("P0Y");
    }

    public static boolean[] defaultBooleanArray() {
      return new boolean[] {false, true};
    }

    public static Iterable<Boolean> defaultBooleanIterable() {
      return Arrays.asList(false, true);
    }

    public static long[] defaultLongArray() {
      return new long[] {1, 2};
    }

    public static Iterable<Long> defaultLongIterable() {
      return Arrays.asList(1L, 2L);
    }

    public static float[] defaultFloatArray() {
      return new float[] {1.0f, 2.0f};
    }

    public static Iterable<Float> defaultFloatIterable() {
      return Arrays.asList(1.0f, 2.0f);
    }

    public static double[] defaultDoubleArray() {
      return new double[] {1.0, 2.0};
    }

    public static Iterable<Double> defaultDoubleIterable() {
      return Arrays.asList(1.0, 2.0);
    }

    public static Iterable<BigDecimal> defaultBigDecimalIterable() {
      return Arrays.asList(BigDecimal.valueOf(123, 2), BigDecimal.valueOf(456, 2));
    }

    public static Iterable<String> defaultStringIterable() {
      return Arrays.asList("a", "b");
    }

    public static Iterable<String> defaultJsonIterable() {
      return Arrays.asList("{}", "[]", "{\"color\":\"red\",\"value\":\"#f00\"}");
    }

    public static Iterable<ByteArray> defaultByteArrayIterable() {
      return Arrays.asList(ByteArray.copyFrom("x"), ByteArray.copyFrom("y"));
    }

    public static Iterable<Timestamp> defaultTimestampIterable() {
      return Arrays.asList(
          Timestamp.ofTimeSecondsAndNanos(0, 0), Timestamp.ofTimeSecondsAndNanos(0, 1));
    }

    public static Iterable<Date> defaultDateIterable() {
      return Arrays.asList(Date.fromYearMonthDay(2016, 9, 15), Date.fromYearMonthDay(2016, 9, 14));
    }

    public static Iterable<UUID> defaultUuidIterable() {
      return Arrays.asList(
          UUID.fromString("8ebe9153-2747-4c92-a462-6da13eb25ebb"),
          UUID.fromString("12c154ca-6500-4be0-89c8-160bcfa8c3f6"));
    }

    public static Interval[] defaultIntervalArray() {
      return new Interval[] {
        Interval.builder()
            .setMonths(-10)
            .setDays(-100)
            .setNanos(BigInteger.valueOf(-9999999L))
            .build(),
        Interval.parseFromString("P0Y"),
        Interval.builder().setMonths(10).setDays(100).setNanos(BigInteger.valueOf(9999999L)).build()
      };
    }

    public static Iterable<Interval> defaultIntervalIterable() {
      return Arrays.asList(
          Interval.builder()
              .setMonths(-10)
              .setDays(-100)
              .setNanos(BigInteger.valueOf(-9999999L))
              .build(),
          Interval.parseFromString("P0Y"),
          Interval.builder()
              .setMonths(10)
              .setDays(100)
              .setNanos(BigInteger.valueOf(9999999L))
              .build());
    }

    static Object getDefault(java.lang.reflect.Type type)
        throws InvocationTargetException, IllegalAccessException {
      for (Method method : DefaultValues.class.getMethods()) {
        if (method.getName().startsWith("default")
            && Modifier.isStatic(method.getModifiers())
            && method.getGenericReturnType().equals(type)) {
          return method.invoke(DefaultValues.class);
        }
      }
      throw new AssertionError("Could not find default value for " + type);
    }
  }
}
