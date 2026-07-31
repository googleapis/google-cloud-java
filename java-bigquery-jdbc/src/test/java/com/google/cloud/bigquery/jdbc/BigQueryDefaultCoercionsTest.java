/*
 * Copyright 2023 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import static com.google.cloud.bigquery.jdbc.BigQueryTypeCoercer.INSTANCE;
import static com.google.common.truth.Truth.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BigQueryDefaultCoercionsTest {

  // migrated
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"default BigQueryTypeCoercer", INSTANCE},
          {"customizable BigQueryTypeCoercer", BigQueryTypeCoercer.builder().build()}
        });
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToBoolean(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, "true")).isTrue();
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, "false")).isFalse();
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, "3452148")).isEqualTo(3452148);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToBigInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(BigInteger.class, "2147483647456"))
        .isEqualTo(new BigInteger("2147483647456"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToLong(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, "2147483647456"))
        .isEqualTo(Long.valueOf("2147483647456"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToDouble(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, "2147483647456.56684593495"))
        .isEqualTo(Double.valueOf("2147483647456.56684593495"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void stringToBigDecimal(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, "2147483647456.56684593495"))
        .isEqualTo(new BigDecimal("2147483647456.56684593495"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void booleanToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, true)).isEqualTo("true");
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, false)).isEqualTo("false");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void booleanToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, true)).isEqualTo(1);
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, false)).isEqualTo(0);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void longToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, 2147483647L)).isEqualTo(2147483647);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void longToShort(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Short.class, 32000L)).isEqualTo((short) 32000);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void longToByte(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Byte.class, 127L)).isEqualTo((byte) 127);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void longToDouble(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, 2147483647456L))
        .isEqualTo(Double.valueOf("2147483647456"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void longToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, 2147483647456L))
        .isEqualTo("2147483647456");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void doubleToFloat(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Float.class, Double.valueOf("4567.213245")))
        .isEqualTo(Float.valueOf("4567.213245"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void doubleToLong(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, Double.valueOf("2147483647456.213245")))
        .isEqualTo(2147483647456L);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void doubleToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, Double.valueOf("21474836.213245")))
        .isEqualTo(21474836);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void doubleToBigDecimal(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, Double.valueOf("21474836.213245")))
        .isEqualTo(new BigDecimal("21474836.213245"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void doubleToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, Double.valueOf("21474836.213245")))
        .isEqualTo("2.1474836213245E7");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void floatToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, 62356.45f)).isEqualTo(62356);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void floatToDouble(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, 62356.45f))
        .isEqualTo(Double.valueOf(62356.45f));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void floatToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, 62356.45f)).isEqualTo("62356.45");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigIntegerToLong(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, new BigInteger("2147483647")))
        .isEqualTo(2147483647L);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigIntegerToBigDecimal(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, new BigInteger("2147483647")))
        .isEqualTo(new BigDecimal("2147483647"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigIntegerToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, new BigInteger("2147483647")))
        .isEqualTo("2147483647");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigDecimalToDouble(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647.74356);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigDecimalToBigInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(BigInteger.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(new BigInteger("2147483647"));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigDecimalToInteger(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigDecimalToLong(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647L);
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void bigDecimalToString(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, new BigDecimal("2147483647.74356")))
        .isEqualTo("2147483647.74356");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @MethodSource("data")
  public void nullToBoolean(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, null)).isFalse();
  }
}
