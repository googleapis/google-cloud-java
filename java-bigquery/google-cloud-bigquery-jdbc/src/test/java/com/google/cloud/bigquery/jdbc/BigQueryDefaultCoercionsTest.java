/*
 * Copyright 2026 Google LLC
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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BigQueryDefaultCoercionsTest {

  private final BigQueryTypeCoercer bigQueryTypeCoercer;

  public BigQueryDefaultCoercionsTest(String label, BigQueryTypeCoercer bigQueryTypeCoercer) {
    this.bigQueryTypeCoercer = bigQueryTypeCoercer;
  }

  @Parameters(name = "{index}: {0}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"default BigQueryTypeCoercer", INSTANCE},
          {"customizable BigQueryTypeCoercer", BigQueryTypeCoercer.builder().build()}
        });
  }

  @Test
  public void stringToBoolean() {
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, "true")).isTrue();
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, "false")).isFalse();
  }

  @Test
  public void stringToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, "3452148")).isEqualTo(3452148);
  }

  @Test
  public void stringToBigInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(BigInteger.class, "2147483647456"))
        .isEqualTo(new BigInteger("2147483647456"));
  }

  @Test
  public void stringToLong() {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, "2147483647456"))
        .isEqualTo(Long.valueOf("2147483647456"));
  }

  @Test
  public void stringToDouble() {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, "2147483647456.56684593495"))
        .isEqualTo(Double.valueOf("2147483647456.56684593495"));
  }

  @Test
  public void stringToBigDecimal() {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, "2147483647456.56684593495"))
        .isEqualTo(new BigDecimal("2147483647456.56684593495"));
  }

  @Test
  public void booleanToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, true)).isEqualTo("true");
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, false)).isEqualTo("false");
  }

  @Test
  public void booleanToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, true)).isEqualTo(1);
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, false)).isEqualTo(0);
  }

  @Test
  public void longToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, 2147483647L)).isEqualTo(2147483647);
  }

  @Test
  public void longToShort() {
    assertThat(bigQueryTypeCoercer.coerceTo(Short.class, 32000L)).isEqualTo((short) 32000);
  }

  @Test
  public void longToByte() {
    assertThat(bigQueryTypeCoercer.coerceTo(Byte.class, 127L)).isEqualTo((byte) 127);
  }

  @Test
  public void longToDouble() {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, 2147483647456L))
        .isEqualTo(Double.valueOf("2147483647456"));
  }

  @Test
  public void longToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, 2147483647456L))
        .isEqualTo("2147483647456");
  }

  @Test
  public void doubleToFloat() {
    assertThat(bigQueryTypeCoercer.coerceTo(Float.class, Double.valueOf("4567.213245")))
        .isEqualTo(Float.valueOf("4567.213245"));
  }

  @Test
  public void doubleToLong() {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, Double.valueOf("2147483647456.213245")))
        .isEqualTo(2147483647456L);
  }

  @Test
  public void doubleToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, Double.valueOf("21474836.213245")))
        .isEqualTo(21474836);
  }

  @Test
  public void doubleToBigDecimal() {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, Double.valueOf("21474836.213245")))
        .isEqualTo(new BigDecimal("21474836.213245"));
  }

  @Test
  public void doubleToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, Double.valueOf("21474836.213245")))
        .isEqualTo("2.1474836213245E7");
  }

  @Test
  public void floatToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, 62356.45f)).isEqualTo(62356);
  }

  @Test
  public void floatToDouble() {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, 62356.45f))
        .isEqualTo(Double.valueOf(62356.45f));
  }

  @Test
  public void floatToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, 62356.45f)).isEqualTo("62356.45");
  }

  @Test
  public void bigIntegerToLong() {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, new BigInteger("2147483647")))
        .isEqualTo(2147483647L);
  }

  @Test
  public void bigIntegerToBigDecimal() {
    assertThat(bigQueryTypeCoercer.coerceTo(BigDecimal.class, new BigInteger("2147483647")))
        .isEqualTo(new BigDecimal("2147483647"));
  }

  @Test
  public void bigIntegerToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, new BigInteger("2147483647")))
        .isEqualTo("2147483647");
  }

  @Test
  public void bigDecimalToDouble() {
    assertThat(bigQueryTypeCoercer.coerceTo(Double.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647.74356);
  }

  @Test
  public void bigDecimalToBigInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(BigInteger.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(new BigInteger("2147483647"));
  }

  @Test
  public void bigDecimalToInteger() {
    assertThat(bigQueryTypeCoercer.coerceTo(Integer.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647);
  }

  @Test
  public void bigDecimalToLong() {
    assertThat(bigQueryTypeCoercer.coerceTo(Long.class, new BigDecimal("2147483647.74356")))
        .isEqualTo(2147483647L);
  }

  @Test
  public void bigDecimalToString() {
    assertThat(bigQueryTypeCoercer.coerceTo(String.class, new BigDecimal("2147483647.74356")))
        .isEqualTo("2147483647.74356");
  }

  @Test
  public void nullToBoolean() {
    assertThat(bigQueryTypeCoercer.coerceTo(Boolean.class, null)).isFalse();
  }
}
