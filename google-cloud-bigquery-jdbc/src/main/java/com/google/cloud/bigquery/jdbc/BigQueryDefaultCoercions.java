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

import com.google.api.core.InternalApi;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/** A registry of all the inbuilt {@link BigQueryCoercion}s that framework offers by default. */
@InternalApi
class BigQueryDefaultCoercions {

  /**
   * Creates a {@link BigQueryTypeCoercerBuilder} with all the inbuilt {@link BigQueryCoercion}s.
   * <li>{@link BigQueryTypeCoercer#INSTANCE} uses this builder to populate itself with all the
   *     default {@link BigQueryCoercion}s.
   * <li>A {@link BigQueryTypeCoercerBuilder} created through {@link BigQueryTypeCoercer#builder()}
   *     method also contains all these default {@link BigQueryCoercion}s
   */
  static BigQueryTypeCoercerBuilder builder() {
    BigQueryTypeCoercerBuilder builder = new BigQueryTypeCoercerBuilder();

    // TODO: can we figure out the class parameters from coercion itself?
    builder.registerTypeCoercion(
        (String s) -> s != null && ("1".equals(s.trim()) || Boolean.parseBoolean(s)),
        String.class,
        Boolean.class);
    builder.registerTypeCoercion(Integer::parseInt, String.class, Integer.class);
    builder.registerTypeCoercion(BigInteger::new, String.class, BigInteger.class);
    builder.registerTypeCoercion(Long::valueOf, String.class, Long.class);
    builder.registerTypeCoercion(Double::valueOf, String.class, Double.class);
    builder.registerTypeCoercion(BigDecimal::new, String.class, BigDecimal.class);

    builder.registerTypeCoercion((b) -> b ? 1 : 0, Boolean.class, Integer.class);

    builder.registerTypeCoercion(Integer::intValue, Integer.class, Integer.class);
    builder.registerTypeCoercion(Integer::shortValue, Integer.class, Short.class);
    builder.registerTypeCoercion(Integer::byteValue, Integer.class, Byte.class);
    builder.registerTypeCoercion(Integer::doubleValue, Integer.class, Double.class);
    builder.registerTypeCoercion(Integer::floatValue, Integer.class, Float.class);

    builder.registerTypeCoercion(Long::intValue, Long.class, Integer.class);
    builder.registerTypeCoercion(Long::shortValue, Long.class, Short.class);
    builder.registerTypeCoercion(Long::byteValue, Long.class, Byte.class);
    builder.registerTypeCoercion(Long::doubleValue, Long.class, Double.class);
    builder.registerTypeCoercion(Long::floatValue, Long.class, Float.class);

    builder.registerTypeCoercion(Double::floatValue, Double.class, Float.class);
    builder.registerTypeCoercion(Double::longValue, Double.class, Long.class);
    builder.registerTypeCoercion(Double::intValue, Double.class, Integer.class);
    builder.registerTypeCoercion(Double::shortValue, Double.class, Short.class);
    builder.registerTypeCoercion(Double::byteValue, Double.class, Byte.class);
    builder.registerTypeCoercion(BigDecimal::valueOf, Double.class, BigDecimal.class);

    builder.registerTypeCoercion(Float::intValue, Float.class, Integer.class);
    builder.registerTypeCoercion(Float::byteValue, Float.class, Byte.class);
    builder.registerTypeCoercion(Float::shortValue, Float.class, Short.class);
    builder.registerTypeCoercion(Float::doubleValue, Float.class, Double.class);

    builder.registerTypeCoercion(BigInteger::longValue, BigInteger.class, Long.class);
    builder.registerTypeCoercion(BigDecimal::new, BigInteger.class, BigDecimal.class);

    builder.registerTypeCoercion(BigDecimal::doubleValue, BigDecimal.class, Double.class);
    builder.registerTypeCoercion(BigDecimal::toBigInteger, BigDecimal.class, BigInteger.class);
    builder.registerTypeCoercion(
        bigDecimal -> bigDecimal.setScale(0, RoundingMode.DOWN).intValueExact(),
        BigDecimal.class,
        Integer.class);
    builder.registerTypeCoercion(
        bigDecimal -> bigDecimal.setScale(0, RoundingMode.DOWN).longValueExact(),
        BigDecimal.class,
        Long.class);
    builder.registerTypeCoercion(
        bigDecimal -> bigDecimal.setScale(0, RoundingMode.DOWN).shortValueExact(),
        BigDecimal.class,
        Short.class);
    builder.registerTypeCoercion(
        bigDecimal -> bigDecimal.setScale(0, RoundingMode.DOWN).byteValueExact(),
        BigDecimal.class,
        Byte.class);
    builder.registerTypeCoercion(BigDecimal::floatValue, BigDecimal.class, Float.class);

    builder.registerTypeCoercion(unused -> false, Void.class, Boolean.class);

    return builder;
  }
}
