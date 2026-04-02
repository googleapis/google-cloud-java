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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SetPgSessionCharacteristicsTest {
  private final AbstractStatementParser parser =
      AbstractStatementParser.getInstance(Dialect.POSTGRESQL);

  @Test
  public void testSetIsolationLevelDefault() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql = "set session characteristics as transaction isolation level default";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection, never()).setReadOnly(anyBoolean());
    verify(connection).setDefaultIsolationLevel(IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED);
  }

  @Test
  public void testSetIsolationLevelSerializable() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql = "set session characteristics as transaction isolation level serializable";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection, never()).setReadOnly(anyBoolean());
    verify(connection).setDefaultIsolationLevel(IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testSetIsolationLevelRepeatableRead() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql = "set session characteristics as transaction isolation level repeatable read";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection, never()).setReadOnly(anyBoolean());
    verify(connection).setDefaultIsolationLevel(IsolationLevel.REPEATABLE_READ);
  }

  @Test
  public void testSetIsolationLevelReadOnly() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql = "set\tsession\ncharacteristics as transaction read   only";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection).setReadOnly(true);
    verify(connection, never()).setReadOnly(false);
    verify(connection, never()).setDefaultIsolationLevel(any(IsolationLevel.class));
  }

  @Test
  public void testSetIsolationLevelReadWrite() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql = "set   session   characteristics   as   transaction   read   write";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection).setReadOnly(false);
    verify(connection, never()).setReadOnly(true);
    verify(connection, never()).setDefaultIsolationLevel(any(IsolationLevel.class));
  }

  @Test
  public void testSetIsolationLevelSerializableReadWrite() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql =
        "set   session   characteristics   as   transaction  isolation level serializable read"
            + " write";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection).setReadOnly(false);
    verify(connection, never()).setReadOnly(true);
    verify(connection).setDefaultIsolationLevel(IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testSetIsolationLevelSerializableReadOnly() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql =
        "set   session   characteristics   as   transaction  isolation level serializable read"
            + " only";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection).setReadOnly(true);
    verify(connection).setDefaultIsolationLevel(IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testSetMultipleTransactionModes() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    String sql =
        "set session characteristics as transaction isolation level default, read only, isolation"
            + " level serializable, read write";
    ParsedStatement statement = parser.parse(Statement.of(sql));
    assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
    statement.getClientSideStatement().execute(executor, statement);

    verify(connection).setReadOnly(false);
    verify(connection, never()).setReadOnly(true);
    verify(connection).setDefaultIsolationLevel(IsolationLevel.SERIALIZABLE);
  }

  @Test
  public void testDefaultTransactionIsolation() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    int count = 0;
    for (String sql :
        new String[] {
          "set default_transaction_isolation = serializable",
          "set default_transaction_isolation = 'serializable'",
          "set default_transaction_isolation to serializable",
          "set default_transaction_isolation to 'serializable'",
          "set default_transaction_isolation to 'SERIALIZABLE'",
          "set default_transaction_isolation to \"SERIALIZABLE\"",
          "set default_transaction_isolation to default",
          "set default_transaction_isolation to DEFAULT",
          "set default_transaction_isolation = default",
          "set default_transaction_isolation = DEFAULT"
        }) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);
      count++;
    }

    verify(connection, never()).setReadOnly(anyBoolean());
    verify(connection, times(count)).setDefaultIsolationLevel(any(IsolationLevel.class));
  }

  @Test
  public void testDefaultTransactionReadOnlyTrue() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    String[] statements =
        new String[] {
          "set default_transaction_read_only = true",
          "set default_transaction_read_only = 'true'",
          "set default_transaction_read_only = \"true\"",
          "set default_transaction_read_only to true",
          "set default_transaction_read_only to 'true'",
          "set default_transaction_read_only to \"true\"",
          "set default_transaction_read_only = t",
          "set default_transaction_read_only = 'tr'",
          "set default_transaction_read_only = \"tru\"",
          "set default_transaction_read_only to tru",
          "set default_transaction_read_only to 'tr'",
          "set default_transaction_read_only to \"t\"",
          "set default_transaction_read_only = on",
          "set default_transaction_read_only = 1",
          "set default_transaction_read_only = yes",
          "set default_transaction_read_only = ye",
          "set default_transaction_read_only = y",
        };

    for (String sql : statements) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);
    }

    verify(connection, times(statements.length)).setReadOnly(true);
  }

  @Test
  public void testDefaultTransactionReadOnlyFalse() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    when(connection.getDialect()).thenReturn(Dialect.POSTGRESQL);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);
    String[] statements =
        new String[] {
          "set default_transaction_read_only = false",
          "set default_transaction_read_only = 'false'",
          "set default_transaction_read_only = \"false\"",
          "set default_transaction_read_only to false",
          "set default_transaction_read_only to 'false'",
          "set default_transaction_read_only to \"false\"",
          "set default_transaction_read_only = f",
          "set default_transaction_read_only = 'fa'",
          "set default_transaction_read_only = \"fal\"",
          "set default_transaction_read_only to fal",
          "set default_transaction_read_only to 'fa'",
          "set default_transaction_read_only to \"f\"",
          "set default_transaction_read_only = off",
          "set default_transaction_read_only = of",
          "set default_transaction_read_only = 0",
          "set default_transaction_read_only = no",
          "set default_transaction_read_only = n",
        };

    for (String sql : statements) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);
    }

    verify(connection, times(statements.length)).setReadOnly(false);
  }
}
