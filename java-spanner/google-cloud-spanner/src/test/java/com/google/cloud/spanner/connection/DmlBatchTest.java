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

import static com.google.cloud.spanner.SpannerApiFutures.get;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.AbstractStatementParser.ParsedStatement;
import com.google.cloud.spanner.connection.AbstractStatementParser.StatementType;
import com.google.cloud.spanner.connection.UnitOfWork.CallType;
import com.google.cloud.spanner.connection.UnitOfWork.UnitOfWorkState;
import io.opentelemetry.api.trace.Span;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DmlBatchTest {

  private final ParsedStatement statement1 =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2"));
  private final ParsedStatement statement2 =
      AbstractStatementParser.getInstance(Dialect.GOOGLE_STANDARD_SQL)
          .parse(Statement.of("UPDATE FOO SET BAR=2 WHERE BAZ=3"));

  private DmlBatch createSubject() {
    UnitOfWork transaction = mock(UnitOfWork.class);
    when(transaction.executeBatchUpdateAsync(any(), eq(Arrays.asList(statement1, statement2))))
        .thenReturn(ApiFutures.immediateFuture(new long[] {3L, 5L}));
    return createSubject(transaction);
  }

  private DmlBatch createSubject(UnitOfWork transaction) {
    return DmlBatch.newBuilder()
        .setTransaction(transaction)
        .withStatementExecutor(new StatementExecutor())
        .setSpan(Span.getInvalid())
        .build();
  }

  @Test
  public void testExecuteQuery() {
    DmlBatch batch = createSubject();
    try {
      batch.executeQueryAsync(CallType.SYNC, mock(ParsedStatement.class), AnalyzeMode.NONE);
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testExecuteDdl() {
    DmlBatch batch = createSubject();
    try {
      batch.executeDdlAsync(CallType.SYNC, mock(ParsedStatement.class));
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetReadTimestamp() {
    DmlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getReadTimestamp();
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testIsReadOnly() {
    DmlBatch batch = createSubject();
    assertThat(batch.isReadOnly(), is(false));
  }

  @Test
  public void testGetCommitTimestamp() {
    DmlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getCommitTimestamp();
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetCommitResponse() {
    DmlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    try {
      batch.getCommitResponse();
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetCommitResponseOrNull() {
    DmlBatch batch = createSubject();
    get(batch.runBatchAsync(CallType.SYNC));
    assertNull(batch.getCommitResponseOrNull());
  }

  @Test
  public void testWriteIterable() {
    DmlBatch batch = createSubject();
    try {
      batch.writeAsync(
          CallType.SYNC, Collections.singletonList(Mutation.newInsertBuilder("foo").build()));
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testGetStateAndIsActive() {
    DmlBatch batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    get(batch.runBatchAsync(CallType.SYNC));
    assertThat(batch.getState(), is(UnitOfWorkState.RAN));
    assertThat(batch.isActive(), is(false));

    batch = createSubject();
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    batch.abortBatch();
    assertThat(batch.getState(), is(UnitOfWorkState.ABORTED));
    assertThat(batch.isActive(), is(false));

    UnitOfWork tx = mock(UnitOfWork.class);
    when(tx.executeBatchUpdateAsync(any(), anyList()))
        .thenReturn(ApiFutures.immediateFailedFuture(mock(SpannerException.class)));
    batch = createSubject(tx);
    assertThat(batch.getState(), is(UnitOfWorkState.STARTED));
    assertThat(batch.isActive(), is(true));
    ParsedStatement statement = mock(ParsedStatement.class);
    when(statement.getStatement()).thenReturn(Statement.of("UPDATE TEST SET COL1=2"));
    when(statement.getSql()).thenReturn("UPDATE TEST SET COL1=2");
    when(statement.getType()).thenReturn(StatementType.UPDATE);
    get(batch.executeUpdateAsync(CallType.SYNC, statement));
    boolean exception = false;
    try {
      get(batch.runBatchAsync(CallType.SYNC));
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
    try {
      batch.commitAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }

  @Test
  public void testRollback() {
    DmlBatch batch = createSubject();
    try {
      batch.rollbackAsync(CallType.SYNC, NoopEndTransactionCallback.INSTANCE);
      fail("Expected exception");
    } catch (SpannerException e) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, e.getErrorCode());
    }
  }
}
