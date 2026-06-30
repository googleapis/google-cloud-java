/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.PgDurationConverter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PgDurationConverterTest {
  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(
            PgDurationConverter.class, Dialect.POSTGRESQL);
    assertNotNull(allowedValues);
    PgDurationConverter converter = new PgDurationConverter(allowedValues);

    assertEquals(Duration.ofNanos(1000000), converter.convert("1"));
    assertEquals(Duration.ofSeconds(1L), converter.convert("1000"));
    assertEquals(Duration.ofSeconds(1L, 1000000), converter.convert("1001"));

    assertEquals(
        Duration.ofNanos((int) TimeUnit.MILLISECONDS.toNanos(100L)), converter.convert("'100ms'"));
    assertEquals(Duration.ZERO, converter.convert("'0ms'"));
    assertNull(converter.convert("'-100ms'"));
    assertEquals(Duration.ofSeconds(315576000000L), converter.convert("'315576000000000ms'"));
    assertEquals(Duration.ofSeconds(1L), converter.convert("'1s'"));
    assertEquals(
        Duration.ofSeconds(1L, (int) TimeUnit.MILLISECONDS.toNanos(1L)),
        converter.convert("'1001ms'"));

    assertEquals(Duration.ofNanos(1), converter.convert("'1ns'"));
    assertEquals(Duration.ofNanos(1000), converter.convert("'1us'"));
    assertEquals(Duration.ofNanos(1000000), converter.convert("'1ms'"));
    assertEquals(Duration.ofNanos(999999999), converter.convert("'999999999ns'"));
    assertEquals(Duration.ofSeconds(1L), converter.convert("'1s'"));

    assertNull(converter.convert("''"));
    assertNull(converter.convert("' '"));
    assertNull(converter.convert("'random string'"));

    assertEquals(Duration.ZERO, converter.convert("default"));
    assertEquals(Duration.ZERO, converter.convert("DEFAULT"));
    assertEquals(Duration.ZERO, converter.convert("Default"));
    assertNull(converter.convert("'default'"));
    assertNull(converter.convert("'DEFAULT'"));
    assertNull(converter.convert("'Default'"));
  }
}
