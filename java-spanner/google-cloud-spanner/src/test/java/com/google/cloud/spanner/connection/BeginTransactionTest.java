/*
 * Copyright 2025 Google LLC
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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.common.collect.ImmutableList;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BeginTransactionTest {
  private final AbstractStatementParser parser =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL);

  @Test
  public void testBeginNoIsolationLevel() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    int index = 1;
    for (String sql :
        ImmutableList.of(
            "begin",
            "begin transaction",
            "start",
            "start transaction",
            "\t\n begin\n  \ttransaction   \n")) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);

      verify(connection, times(index)).beginTransaction();
      verify(connection, never()).setTransactionMode(any());
      index++;
    }
  }

  @Test
  public void testBeginRepeatableRead() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    int index = 1;
    for (String sql :
        ImmutableList.of(
            "begin isolation level repeatable read",
            "begin transaction isolation level repeatable read",
            "start isolation level repeatable read",
            "start transaction isolation level repeatable read",
            "start transaction isolation level repeatable    read",
            "start\n  \ttransaction \t\nisolation\n\t level   \t \nrepeatable \n  \t read")) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);

      verify(connection, times(index)).beginTransaction(IsolationLevel.REPEATABLE_READ);
      verify(connection, never()).setTransactionMode(any());
      index++;
    }
  }

  @Test
  public void testBeginSerializable() {
    ConnectionImpl connection = mock(ConnectionImpl.class);
    ConnectionStatementExecutorImpl executor = new ConnectionStatementExecutorImpl(connection);

    int index = 1;
    for (String sql :
        ImmutableList.of(
            "begin isolation level serializable",
            "begin transaction isolation level serializable",
            "start isolation level serializable",
            "start transaction isolation level serializable",
            "start transaction isolation level    serializable",
            "start\n  \ttransaction \t\nisolation\n\t level   \t \nserializable \n  \t ")) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.CLIENT_SIDE, statement.getType());
      statement.getClientSideStatement().execute(executor, statement);

      verify(connection, times(index)).beginTransaction(IsolationLevel.SERIALIZABLE);
      verify(connection, never()).setTransactionMode(any());
      index++;
    }
  }

  @Test
  public void testInvalidStatements() {
    for (String sql :
        ImmutableList.of(
            "begin isolation level",
            "begin transaction level serializable",
            "start isolation serializable",
            "start transaction repeatable read",
            "begin isolation level read committed",
            "begin isloation level serializable",
            "begin transaction isolation level repeatable",
            "begin transaction isolation level serializable read",
            "begin transaction isolation level repeatable_read")) {
      ParsedStatement statement = parser.parse(Statement.of(sql));
      assertEquals(sql, StatementType.UNKNOWN, statement.getType());
    }
  }
}
