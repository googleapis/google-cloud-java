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
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.TimestampBound;
import com.google.protobuf.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionStatementExecutorTest {

  private ConnectionImpl connection;
  private ConnectionStatementExecutorImpl subject;

  @Before
  public void createSubject() {
    connection = mock(ConnectionImpl.class);
    when(connection.getAutocommitDmlMode()).thenReturn(AutocommitDmlMode.TRANSACTIONAL);
    when(connection.getReadOnlyStaleness()).thenReturn(TimestampBound.strong());
    subject = new ConnectionStatementExecutorImpl(connection);
  }

  @Test
  public void testGetConnection() {
    assertThat(subject.getConnection(), is(equalTo(connection)));
  }

  @Test
  public void testStatementBeginTransaction() {
    subject.statementBeginTransaction();
    verify(connection).beginTransaction();
  }

  @Test
  public void testStatementCommit() {
    subject.statementCommit();
    verify(connection).commit();
  }

  @Test
  public void testStatementGetAutocommit() {
    subject.statementShowAutocommit();
    verify(connection).isAutocommit();
  }

  @Test
  public void testStatementGetAutocommitDmlMode() {
    subject.statementShowAutocommitDmlMode();
    verify(connection).getAutocommitDmlMode();
  }

  @Test
  public void testStatementGetCommitTimestamp() {
    subject.statementShowCommitTimestamp();
    verify(connection).getCommitTimestampOrNull();
  }

  @Test
  public void testStatementGetReadOnly() {
    subject.statementShowReadOnly();
    verify(connection).isReadOnly();
  }

  @Test
  public void testStatementGetReadOnlyStaleness() {
    subject.statementShowReadOnlyStaleness();
    verify(connection).getReadOnlyStaleness();
  }

  @Test
  public void testStatementGetReadTimestamp() {
    subject.statementShowReadTimestamp();
    verify(connection).getReadTimestampOrNull();
  }

  @Test
  public void testStatementGetStatementTimeout() {
    subject.statementSetStatementTimeout(Duration.newBuilder().setSeconds(1L).build());
    when(connection.hasStatementTimeout()).thenReturn(true);
    subject.statementShowStatementTimeout();
    verify(connection, atLeastOnce()).getStatementTimeout(any(TimeUnit.class));
    subject.statementSetStatementTimeout(Duration.getDefaultInstance());
    when(connection.hasStatementTimeout()).thenReturn(false);
  }

  @Test
  public void testStatementRollback() {
    subject.statementRollback();
    verify(connection).rollback();
  }

  @Test
  public void testStatementSetAutocommit() {
    subject.statementSetAutocommit(Boolean.TRUE);
    verify(connection).setAutocommit(true);
    subject.statementSetAutocommit(Boolean.FALSE);
    verify(connection).setAutocommit(false);
  }

  @Test
  public void testStatementSetAutocommitDmlMode() {
    subject.statementSetAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    verify(connection).setAutocommitDmlMode(AutocommitDmlMode.PARTITIONED_NON_ATOMIC);
    subject.statementSetAutocommitDmlMode(AutocommitDmlMode.TRANSACTIONAL);
    verify(connection).setAutocommitDmlMode(AutocommitDmlMode.TRANSACTIONAL);
  }

  @Test
  public void testStatementSetReadOnly() {
    subject.statementSetReadOnly(Boolean.TRUE);
    verify(connection).setReadOnly(true);
    subject.statementSetReadOnly(Boolean.FALSE);
    verify(connection).setReadOnly(false);
  }

  @Test
  public void testStatementSetReadOnlyStaleness() {
    subject.statementSetReadOnlyStaleness(TimestampBound.strong());
    verify(connection).setReadOnlyStaleness(TimestampBound.strong());

    subject.statementSetReadOnlyStaleness(
        TimestampBound.ofReadTimestamp(Timestamp.parseTimestamp("2018-10-31T10:11:12.123Z")));
    verify(connection)
        .setReadOnlyStaleness(
            TimestampBound.ofReadTimestamp(Timestamp.parseTimestamp("2018-10-31T10:11:12.123Z")));

    subject.statementSetReadOnlyStaleness(
        TimestampBound.ofMinReadTimestamp(Timestamp.parseTimestamp("2018-10-31T10:11:12.123Z")));
    verify(connection)
        .setReadOnlyStaleness(
            TimestampBound.ofReadTimestamp(Timestamp.parseTimestamp("2018-10-31T10:11:12.123Z")));

    subject.statementSetReadOnlyStaleness(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));
    verify(connection).setReadOnlyStaleness(TimestampBound.ofExactStaleness(10L, TimeUnit.SECONDS));

    subject.statementSetReadOnlyStaleness(
        TimestampBound.ofMaxStaleness(20L, TimeUnit.MILLISECONDS));
    verify(connection)
        .setReadOnlyStaleness(TimestampBound.ofMaxStaleness(20L, TimeUnit.MILLISECONDS));
  }

  @Test
  public void testStatementSetStatementTimeout() {
    subject.statementSetStatementTimeout(Duration.newBuilder().setNanos(100).build());
    verify(connection).setStatementTimeout(100L, TimeUnit.NANOSECONDS);
  }

  @Test
  public void testStatementSetTransactionMode() {
    subject.statementSetTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
    verify(connection).setTransactionMode(TransactionMode.READ_ONLY_TRANSACTION);
    subject.statementSetTransactionMode(TransactionMode.READ_WRITE_TRANSACTION);
    verify(connection).setTransactionMode(TransactionMode.READ_WRITE_TRANSACTION);
  }
}
