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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.jdbc.StatementParser.ParsedStatement;
import com.google.cloud.spanner.jdbc.StatementParser.StatementType;
import com.google.cloud.spanner.jdbc.UnitOfWork.UnitOfWorkState;
import java.util.Arrays;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DmlBatchTest {
  private final ParsedStatement statement1 =
      StatementParser.INSTANCE.parse(Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2"));
  private final ParsedStatement statement2 =
      StatementParser.INSTANCE.parse(Statement.of("UPDATE FOO SET BAR=2 WHERE BAZ=3"));

  @Rule public ExpectedException exception = ExpectedException.none();

  private DmlBatch createSubject() {
    UnitOfWork transaction = mock(UnitOfWork.class);
    when(transaction.executeBatchUpdate(Arrays.asList(statement1, statement2)))
        .thenReturn(new long[] {3L, 5L});
    return createSubject(transaction);
  }

  private DmlBatch createSubject(UnitOfWork transaction) {
    return DmlBatch.newBuilder()
        .setTransaction(transaction)
        .withStatementExecutor(new StatementExecutor())
        .build();
  }

  @Test
  public void testExecuteQuery() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.executeQuery(mock(ParsedStatement.class), AnalyzeMode.NONE);
  }

  @Test
  public void testExecuteDdl() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.executeDdl(mock(ParsedStatement.class));
  }

  @Test
  public void testGetReadTimestamp() {
    DmlBatch batch = createSubject();
    batch.runBatch();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.getReadTimestamp();
  }

  @Test
  public void testIsReadOnly() {
    DmlBatch batch = createSubject();
    assertThat(batch.isReadOnly(), is(false));
  }

  @Test
  public void testGetCommitTimestamp() {
    DmlBatch batch = createSubject();
    batch.runBatch();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.getCommitTimestamp();
  }

  @Test
  public void testWrite() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.write(Mutation.newInsertBuilder("foo").build());
  }

  @Test
  public void testWriteIterable() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.write(Arrays.asList(Mutation.newInsertBuilder("foo").build()));
  }

  @Test
  public void testGetStateAndIsActive() {
    DmlBatch batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    batch.runBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    assertThat(batch.isActive(), is(false));

    batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    batch.abortBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.ABORTED));
    assertThat(batch.isActive(), is(false));

    UnitOfWork tx = mock(UnitOfWork.class);
    doThrow(SpannerException.class).when(tx).executeBatchUpdate(anyListOf(ParsedStatement.class));
    batch = createSubject(tx);
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getStatement()).thenReturn(Statement.of("UPDATE TEST SET COL1=2"));
    when(statement.getSqlWithoutComments()).thenReturn("UPDATE TEST SET COL1=2");
    when(statement.getType()).thenReturn(StatementType.UPDATE);
    batch.executeUpdate(statement);
    boolean exception = false;
    try {
      batch.runBatch();
    } catch (SpannerException e) {
      exception = true;
    }
    assertThat(exception, is(true));
    assertThat(batch.getState(), is(UnitOfWorkState.RUN_FAILED));
    assertThat(batch.isActive(), is(false));
  }

  @Test
  public void testCommit() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.commit();
  }

  @Test
  public void testRollback() {
    DmlBatch batch = createSubject();
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    batch.rollback();
  }
}
