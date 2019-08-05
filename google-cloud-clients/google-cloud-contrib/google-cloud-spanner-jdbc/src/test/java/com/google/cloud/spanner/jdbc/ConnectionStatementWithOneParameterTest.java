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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.protobuf.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class ConnectionStatementWithOneParameterTest {
  private final StatementParser parser = StatementParser.INSTANCE;

  @Test
  public void testExecuteSetAutcommit() throws Exception {
    ParsedStatement subject = parser.parse(Statement.of("set autocommit = true"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementSetAutocommit(any(Boolean.class))).thenCallRealMethod();
    for (Boolean mode : new Boolean[] {Boolean.FALSE, Boolean.TRUE}) {
      subject
          .getClientSideStatement()
          .execute(executor, String.format("set autocommit = %s", mode));
      verify(connection, times(1)).setAutocommit(mode);
    }
  }

  @Test
  public void testExecuteSetReadOnly() throws Exception {
    ParsedStatement subject = parser.parse(Statement.of("set readonly = true"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementSetReadOnly(any(Boolean.class))).thenCallRealMethod();
    for (Boolean mode : new Boolean[] {Boolean.FALSE, Boolean.TRUE}) {
      subject
          .getClientSideStatement()
          .execute(executor, String.format("set readonly = %s", Boolean.toString(mode)));
      verify(connection, times(1)).setReadOnly(mode);
    }
  }

  @Test
  public void testExecuteSetAutcommitDmlMode() throws Exception {
    ParsedStatement subject = parser.parse(Statement.of("set autocommit_dml_mode='foo'"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementSetAutocommitDmlMode(any(AutocommitDmlMode.class))).thenCallRealMethod();
    for (AutocommitDmlMode mode : AutocommitDmlMode.values()) {
      subject
          .getClientSideStatement()
          .execute(executor, String.format("set autocommit_dml_mode='%s'", mode.name()));
      verify(connection, times(1)).setAutocommitDmlMode(mode);
    }
  }

  @Test
  public void testExecuteSetStatementTimeout() throws Exception {
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.statementSetStatementTimeout(any(Duration.class))).thenCallRealMethod();
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    for (TimeUnit unit : ReadOnlyStalenessUtil.SUPPORTED_UNITS) {
      for (Long val : new Long[] {1L, 100L, 999L}) {
        ParsedStatement subject =
            parser.parse(
                Statement.of(
                    String.format(
                        "set statement_timeout='%d%s'",
                        val, ReadOnlyStalenessUtil.getTimeUnitAbbreviation(unit))));
        subject
            .getClientSideStatement()
            .execute(
                executor,
                String.format(
                    "set statement_timeout='%d%s'",
                    val, ReadOnlyStalenessUtil.getTimeUnitAbbreviation(unit)));
        verify(connection, times(1)).setStatementTimeout(val, unit);
      }
    }
    ParsedStatement subject =
        parser.parse(Statement.of(String.format("set statement_timeout=null")));
    subject.getClientSideStatement().execute(executor, String.format("set statement_timeout=null"));
    verify(connection, times(1)).clearStatementTimeout();
  }

  @Test
  public void testExecuteSetReadOnlyStaleness() throws Exception {
    ParsedStatement subject = parser.parse(Statement.of("set read_only_staleness='foo'"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementSetReadOnlyStaleness(any(TimestampBound.class))).thenCallRealMethod();
    for (TimestampBound val :
        new TimestampBound[] {
          TimestampBound.strong(),
          TimestampBound.ofReadTimestamp(Timestamp.now()),
          TimestampBound.ofMinReadTimestamp(Timestamp.now()),
          TimestampBound.ofExactStaleness(1000L, TimeUnit.SECONDS),
          TimestampBound.ofMaxStaleness(2000L, TimeUnit.MICROSECONDS)
        }) {
      subject
          .getClientSideStatement()
          .execute(
              executor, String.format("set read_only_staleness='%s'", timestampBoundToString(val)));
      verify(connection, times(1)).setReadOnlyStaleness(val);
    }
  }

  private String timestampBoundToString(TimestampBound staleness) {
    switch (staleness.getMode()) {
      case STRONG:
        return "strong";
      case READ_TIMESTAMP:
        return "read_timestamp " + staleness.getReadTimestamp().toString();
      case MIN_READ_TIMESTAMP:
        return "min_read_timestamp " + staleness.getMinReadTimestamp().toString();
      case EXACT_STALENESS:
        return "exact_staleness " + staleness.getExactStaleness(TimeUnit.SECONDS) + "s";
      case MAX_STALENESS:
        return "max_staleness " + staleness.getMaxStaleness(TimeUnit.MICROSECONDS) + "us";
      default:
        throw new IllegalStateException("Unknown mode: " + staleness.getMode());
    }
  }

  @Test
  public void testExecuteSetTransaction() throws Exception {
    ParsedStatement subject = parser.parse(Statement.of("set transaction read_only"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementSetTransactionMode(any(TransactionMode.class))).thenCallRealMethod();
    for (TransactionMode mode : TransactionMode.values()) {
      subject
          .getClientSideStatement()
          .execute(executor, String.format("set transaction %s", mode.getStatementString()));
      verify(connection, times(1)).setTransactionMode(mode);
    }
  }
}
