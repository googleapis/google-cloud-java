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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link com.google.cloud.spanner.ValueBinder}. */
@RunWith(JUnit4.class)
public class ValueBinderTest {
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
  public void reflection() throws InvocationTargetException, IllegalAccessException {
    // Test that every Value factory method has a counterpart in ValueBinder, and that invoking it
    // produces the expected Value.
    for (Method method : Value.class.getMethods()) {
      if (!Modifier.isStatic(method.getModifiers())
          || !method.getReturnType().equals(Value.class)) {
        continue;
      }
      Method binderMethod = findBinderMethod(method);
      assertThat(binderMethod).named("Binder for " + method.toString()).isNotNull();

      if (binderMethod.getParameterTypes().length == 1) {
        // Test unary null.
        if (!binderMethod.getParameterTypes()[0].isPrimitive()) {
          Value expected = (Value) method.invoke(Value.class, (Object) null);
          assertThat(binderMethod.invoke(binder, (Object) null)).isEqualTo(lastReturnValue);
          assertThat(lastValue).isEqualTo(expected);
        }
        // Test unary non-null.
        Object defaultObject = DefaultValues.getDefault(method.getGenericParameterTypes()[0]);
        Value expected = (Value) method.invoke(Value.class, defaultObject);
        assertThat(binderMethod.invoke(binder, defaultObject)).isEqualTo(lastReturnValue);
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

    public static double defaultDoublePrimitive() {
      return 1.0;
    }

    public static Double defaultDoubleWrapper() {
      return 1.0;
    }

    public static String defaultString() {
      return "x";
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

    public static double[] defaultDoubleArray() {
      return new double[] {1.0, 2.0};
    }

    public static Iterable<Double> defaultDoubleIterable() {
      return Arrays.asList(1.0, 2.0);
    }

    public static Iterable<String> defaultStringIterable() {
      return Arrays.asList("a", "b");
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
