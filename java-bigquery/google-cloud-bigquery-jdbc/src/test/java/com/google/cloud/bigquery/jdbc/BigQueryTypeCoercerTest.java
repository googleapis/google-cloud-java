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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionException;
import com.google.cloud.bigquery.exception.BigQueryJdbcCoercionNotFoundException;
import com.google.cloud.bigquery.jdbc.TestType.Text;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;
import org.junit.Test;

public class BigQueryTypeCoercerTest {

  @Test
  public void shouldReturnSameValueWhenTargetTypeIsSameAsSourceType() {
    assertThat(BigQueryTypeCoercer.INSTANCE.coerceTo(Integer.class, 56)).isEqualTo(56);
    assertThat(BigQueryTypeCoercer.INSTANCE.coerceTo(Long.class, 56L)).isEqualTo(56L);
  }

  @Test
  public void shouldBeAbleToComposeMultipleCoercions() {
    StringToBigDecimal stringToBigDecimal = new StringToBigDecimal();
    BigDecimalToBigInteger bigDecimalToBigInteger = new BigDecimalToBigInteger();

    Function<String, BigInteger> composedCoercion =
        stringToBigDecimal.andThen(bigDecimalToBigInteger);

    BigQueryTypeCoercer bigQueryTypeCoercer =
        new BigQueryTypeCoercerBuilder()
            .registerTypeCoercion(composedCoercion, String.class, BigInteger.class)
            .build();

    assertThat(bigQueryTypeCoercer.coerceTo(BigInteger.class, "123567.66884"))
        .isEqualTo(BigInteger.valueOf(123567));
  }

  @Test
  public void shouldThrowCoercionNotFoundException() {
    byte[] bytesArray = {72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100, 33};
    Text text = new Text(bytesArray);

    BigQueryJdbcCoercionNotFoundException exception =
        assertThrows(
            BigQueryJdbcCoercionNotFoundException.class,
            () -> BigQueryTypeCoercer.INSTANCE.coerceTo(Long.class, text));
    assertThat(exception.getMessage())
        .isEqualTo(
            "Coercion not found for "
                + "[com.google.cloud.bigquery.jdbc.TestType.Text -> java.lang.Long]"
                + " conversion");
  }

  @Test
  public void shouldThrowCoercionException() {
    BigQueryTypeCoercer bigQueryTypeCoercer =
        new BigQueryTypeCoercerBuilder()
            .registerTypeCoercion(Math::toIntExact, Long.class, Integer.class)
            .build();
    BigQueryJdbcCoercionException exception =
        assertThrows(
            BigQueryJdbcCoercionException.class,
            () -> bigQueryTypeCoercer.coerceTo(Integer.class, 2147483648L));
    assertThat(exception.getMessage()).isEqualTo("Coercion error");
    assertThat(exception.getCause()).isInstanceOf(ArithmeticException.class);
  }

  private static class StringToBigDecimal implements BigQueryCoercion<String, BigDecimal> {

    @Override
    public BigDecimal coerce(String value) {
      return new BigDecimal(value);
    }
  }

  private static class BigDecimalToBigInteger implements BigQueryCoercion<BigDecimal, BigInteger> {

    @Override
    public BigInteger coerce(BigDecimal value) {
      return value.toBigInteger();
    }
  }
}
