/*
 * Copyright 2019 Google LLC
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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.connection.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.DurationConverter;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DurationConverterTest {
  @Test
  public void testConvert() throws CompileException {
    String allowedValues =
        ReadOnlyStalenessConverterTest.getAllowedValues(
            DurationConverter.class, Dialect.GOOGLE_STANDARD_SQL);
    assertNotNull(allowedValues);
    DurationConverter converter = new DurationConverter(allowedValues);
    assertThat(converter.convert("'100ms'"), is(equalTo(Duration.ofMillis(100L))));
    assertThat(converter.convert("100"), is(equalTo(Duration.ofMillis(100))));
    assertThat(converter.convert("'0ms'"), is(Duration.ZERO));
    assertThat(converter.convert("'-100ms'"), is(nullValue()));
    assertThat(
        converter.convert("'315576000000000ms'"), is(equalTo(Duration.ofSeconds(315576000000L))));
    assertThat(converter.convert("'1000ms'"), is(equalTo(Duration.ofSeconds(1L))));
    assertThat(
        converter.convert("'1001ms'"),
        is(equalTo(Duration.ofSeconds(1L, TimeUnit.MILLISECONDS.toNanos(1L)))));

    assertThat(converter.convert("'1ns'"), is(equalTo(Duration.ofNanos(1))));
    assertThat(converter.convert("'1us'"), is(equalTo(Duration.ofNanos(1000))));
    assertThat(converter.convert("'1ms'"), is(equalTo(Duration.ofNanos(1000000))));
    assertThat(converter.convert("'999999999ns'"), is(equalTo(Duration.ofNanos(999999999))));
    assertThat(converter.convert("'1s'"), is(equalTo(Duration.ofSeconds(1L))));

    assertThat(converter.convert("''"), is(nullValue()));
    assertThat(converter.convert("' '"), is(nullValue()));
    assertThat(converter.convert("'random string'"), is(nullValue()));

    assertThat(converter.convert("null"), is(equalTo(Duration.ZERO)));
    assertThat(converter.convert("NULL"), is(equalTo(Duration.ZERO)));
    assertThat(converter.convert("Null"), is(equalTo(Duration.ZERO)));
    assertThat(converter.convert("'null'"), is(nullValue()));
    assertThat(converter.convert("'NULL'"), is(nullValue()));
    assertThat(converter.convert("'Null'"), is(nullValue()));
  }
}
