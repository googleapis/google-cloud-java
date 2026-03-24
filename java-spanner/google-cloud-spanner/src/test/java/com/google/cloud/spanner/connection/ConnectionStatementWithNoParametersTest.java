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

import static com.google.cloud.spanner.connection.DialectNamespaceMapper.getNamespace;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConnectionStatementWithNoParametersTest {
  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  private AbstractStatementParser parser;

  @Before
  public void setup() {
    parser = AbstractStatementParser.getInstance(dialect);
  }

  ParsedStatement parse(String sql) {
    return parser.parse(Statement.of(sql));
  }

  @Test
  public void testExecuteGetAutocommit() {
    ParsedStatement statement = parser.parse(Statement.of("show variable autocommit"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementShowAutocommit()).thenCallRealMethod();
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).isAutocommit();
  }

  @Test
  public void testExecuteGetReadOnly() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(String.format("show variable %sreadonly", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).isReadOnly();
  }

  @Test
  public void testExecuteGetAutocommitDmlMode() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(
                String.format("show variable %sautocommit_dml_mode", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getAutocommitDmlMode()).thenReturn(AutocommitDmlMode.TRANSACTIONAL);
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getAutocommitDmlMode();
  }

  @Test
  public void testExecuteGetStatementTimeout() {
    ParsedStatement statement = parser.parse(Statement.of("show variable statement_timeout"));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
    when(executor.getConnection()).thenReturn(connection);
    when(executor.statementShowStatementTimeout()).thenCallRealMethod();
    when(connection.hasStatementTimeout()).thenReturn(true);
    when(connection.getStatementTimeout(TimeUnit.NANOSECONDS)).thenReturn(1L);
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(2)).getStatementTimeout(TimeUnit.NANOSECONDS);
  }

  @Test
  public void testExecuteGetReadTimestamp() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(String.format("show variable %sread_timestamp", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getReadTimestampOrNull()).thenReturn(Timestamp.now());
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getReadTimestampOrNull();
  }

  @Test
  public void testExecuteGetCommitTimestamp() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(String.format("show variable %scommit_timestamp", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getCommitTimestampOrNull()).thenReturn(Timestamp.now());
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getCommitTimestampOrNull();
  }

  @Test
  public void testExecuteGetReadOnlyStaleness() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(
                String.format("show variable %sread_only_staleness", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getReadOnlyStaleness()).thenReturn(TimestampBound.strong());
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getReadOnlyStaleness();
  }

  @Test
  public void testExecuteGetOptimizerVersion() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(
                String.format("show variable %soptimizer_version", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getOptimizerVersion()).thenReturn("1");
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getOptimizerVersion();
  }

  @Test
  public void testExecuteGetOptimizerStatisticsPackage() {
    ParsedStatement statement =
        parser.parse(
            Statement.of(
                String.format(
                    "show variable %soptimizer_statistics_package", getNamespace(dialect))));
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(dialect);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    when(connection.getOptimizerStatisticsPackage()).thenReturn("custom-package");
    statement.getClientSideStatement().execute(executor, statement);
    verify(connection, times(1)).getOptimizerStatisticsPackage();
  }

  @Test
  public void testExecuteBegin() {
    ParsedStatement subject = parser.parse(Statement.of("begin"));
    for (String statement : subject.getClientSideStatement().getExampleStatements()) {
      ConnectionImpl connection = mock(ConnectionImpl.class);
      ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
      subject.getClientSideStatement().execute(executor, parse(statement));
      if (statement.contains("isolation") && !statement.contains("default")) {
        verify(connection, times(1)).beginTransaction(any(IsolationLevel.class));
      } else {
        verify(connection, times(1)).beginTransaction();
      }
    }
  }

  @Test
  public void testExecuteCommit() {
    ParsedStatement subject = parser.parse(Statement.of("commit"));
    for (String statement : subject.getClientSideStatement().getExampleStatements()) {
      ConnectionImpl connection = mock(ConnectionImpl.class);
      ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
      when(executor.getConnection()).thenReturn(connection);
      when(executor.statementCommit()).thenCallRealMethod();
      subject.getClientSideStatement().execute(executor, parse(statement));
      verify(connection, times(1)).commit();
    }
  }

  @Test
  public void testExecuteRollback() {
    ParsedStatement subject = parser.parse(Statement.of("rollback"));
    for (String statement : subject.getClientSideStatement().getExampleStatements()) {
      ConnectionImpl connection = mock(ConnectionImpl.class);
      ConnectionStatementExecutorImpl executor = mock(ConnectionStatementExecutorImpl.class);
      when(executor.getConnection()).thenReturn(connection);
      when(executor.statementRollback()).thenCallRealMethod();
      subject.getClientSideStatement().execute(executor, parse(statement));
      verify(connection, times(1)).rollback();
    }
  }
}
