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

package com.google.cloud.spanner.jdbc;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.jdbc.ClientSideStatementImpl.CompileException;
import com.google.cloud.spanner.jdbc.ClientSideStatementValueConverters.ReadOnlyStalenessConverter;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ReadOnlyStalenessConverterTest {

  static String getAllowedValues(
      Class<? extends ClientSideStatementValueConverter<?>> converterClass)
      throws CompileException {
    Set<ClientSideStatementImpl> statements = ClientSideStatements.INSTANCE.getCompiledStatements();
    for (ClientSideStatementImpl statement : statements) {
      if (statement.getSetStatement() != null
          && converterClass.getName().endsWith(statement.getSetStatement().getConverterName())) {
        return statement.getSetStatement().getAllowedValues();
      }
    }
    return null;
  }

  @Test
  public void testConvert() throws CompileException {
    String allowedValues = getAllowedValues(ReadOnlyStalenessConverter.class);
    assertThat(allowedValues, is(notNullValue()));
    ReadOnlyStalenessConverter converter = new ReadOnlyStalenessConverter(allowedValues);

    assertThat(converter.convert("strong"), is(equalTo(TimestampBound.strong())));
    assertThat(converter.convert("Strong"), is(equalTo(TimestampBound.strong())));
    assertThat(converter.convert("STRONG"), is(equalTo(TimestampBound.strong())));

    assertThat(
        converter.convert("read_timestamp 2018-10-01T23:11:15.10001Z"),
        is(
            equalTo(
                TimestampBound.ofReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.10001Z")))));
    assertThat(
        converter.convert("Read_Timestamp 2018-10-01T23:11:15.999Z"),
        is(
            equalTo(
                TimestampBound.ofReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.999Z")))));
    assertThat(
        converter.convert("READ_TIMESTAMP 2018-10-01T23:11:15.1000Z"),
        is(
            equalTo(
                TimestampBound.ofReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.1000Z")))));
    assertThat(
        converter.convert("read_timestamp    2018-10-01T23:11:15.999999999Z"),
        is(
            equalTo(
                TimestampBound.ofReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.999999999Z")))));
    assertThat(
        converter.convert("read_timestamp\t2018-10-01T23:11:15.10001Z"),
        is(
            equalTo(
                TimestampBound.ofReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.10001Z")))));
    assertThat(converter.convert("read_timestamp\n2018-10-01T23:11:15.10001Z"), is(nullValue()));

    assertThat(
        converter.convert("min_read_timestamp 2018-10-01T23:11:15.10001Z"),
        is(
            equalTo(
                TimestampBound.ofMinReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.10001Z")))));
    assertThat(
        converter.convert("Min_Read_Timestamp 2018-10-01T23:11:15.999Z"),
        is(
            equalTo(
                TimestampBound.ofMinReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.999Z")))));
    assertThat(
        converter.convert("MIN_READ_TIMESTAMP 2018-10-01T23:11:15.1000Z"),
        is(
            equalTo(
                TimestampBound.ofMinReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.1000Z")))));
    assertThat(
        converter.convert("min_read_timestamp    2018-10-01T23:11:15.999999999Z"),
        is(
            equalTo(
                TimestampBound.ofMinReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.999999999Z")))));
    assertThat(
        converter.convert("min_read_timestamp\t2018-10-01T23:11:15.10001Z"),
        is(
            equalTo(
                TimestampBound.ofMinReadTimestamp(
                    Timestamp.parseTimestamp("2018-10-01T23:11:15.10001Z")))));
    assertThat(
        converter.convert("min_read_timestamp\n2018-10-01T23:11:15.10001Z"), is(nullValue()));

    assertThat(
        converter.convert("exact_staleness 10s"),
        is(equalTo(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS))));
    assertThat(
        converter.convert("Exact_Staleness 100ms"),
        is(equalTo(TimestampBound.ofExactStaleness(100L, TimeUnit.MILLISECONDS))));
    assertThat(
        converter.convert("EXACT_STALENESS 99999us"),
        is(equalTo(TimestampBound.ofExactStaleness(99999L, TimeUnit.MICROSECONDS))));
    assertThat(
        converter.convert("exact_staleness 999999999ns"),
        is(equalTo(TimestampBound.ofExactStaleness(999999999L, TimeUnit.NANOSECONDS))));
    assertThat(
        converter.convert("exact_staleness " + Long.MAX_VALUE + "ns"),
        is(equalTo(TimestampBound.ofExactStaleness(Long.MAX_VALUE, TimeUnit.NANOSECONDS))));

    assertThat(
        converter.convert("max_staleness 10s"),
        is(equalTo(TimestampBound.ofMaxStaleness(10L, TimeUnit.SECONDS))));
    assertThat(
        converter.convert("Max_Staleness 100ms"),
        is(equalTo(TimestampBound.ofMaxStaleness(100L, TimeUnit.MILLISECONDS))));
    assertThat(
        converter.convert("MAX_STALENESS 99999us"),
        is(equalTo(TimestampBound.ofMaxStaleness(99999L, TimeUnit.MICROSECONDS))));
    assertThat(
        converter.convert("max_staleness 999999999ns"),
        is(equalTo(TimestampBound.ofMaxStaleness(999999999L, TimeUnit.NANOSECONDS))));
    assertThat(
        converter.convert("max_staleness " + Long.MAX_VALUE + "ns"),
        is(equalTo(TimestampBound.ofMaxStaleness(Long.MAX_VALUE, TimeUnit.NANOSECONDS))));

    assertThat(converter.convert(""), is(nullValue()));
    assertThat(converter.convert(" "), is(nullValue()));
    assertThat(converter.convert("random string"), is(nullValue()));
    assertThat(converter.convert("read_timestamp"), is(nullValue()));
    assertThat(converter.convert("min_read_timestamp"), is(nullValue()));
    assertThat(converter.convert("exact_staleness"), is(nullValue()));
    assertThat(converter.convert("max_staleness"), is(nullValue()));
  }
}
