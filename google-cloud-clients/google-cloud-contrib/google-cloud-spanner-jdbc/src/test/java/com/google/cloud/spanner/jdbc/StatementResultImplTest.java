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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.jdbc.StatementResult.ClientSideStatementType;
import com.google.cloud.spanner.jdbc.StatementResult.ResultType;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatementResultImplTest {
  @Rule public ExpectedException exception = ExpectedException.none();

  @Test
  public void testNoResultGetResultSet() {
    StatementResult subject = StatementResultImpl.noResult();
    assertThat(subject.getResultType(), is(equalTo(ResultType.NO_RESULT)));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getResultSet();
  }

  @Test
  public void testNoResultGetUpdateCount() {
    StatementResult subject = StatementResultImpl.noResult();
    assertThat(subject.getResultType(), is(equalTo(ResultType.NO_RESULT)));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getUpdateCount();
  }

  @Test
  public void testResultSetGetResultSet() {
    StatementResult subject = StatementResultImpl.of(mock(ResultSet.class));
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(subject.getResultSet(), is(notNullValue()));
  }

  @Test
  public void testResultSetGetUpdateCount() {
    StatementResult subject = StatementResultImpl.of(mock(ResultSet.class));
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getUpdateCount();
  }

  @Test
  public void testUpdateCountGetResultSet() {
    StatementResult subject = StatementResultImpl.of(1L);
    assertThat(subject.getResultType(), is(equalTo(ResultType.UPDATE_COUNT)));
    exception.expect(SpannerExceptionMatcher.matchCode(ErrorCode.FAILED_PRECONDITION));
    subject.getResultSet();
  }

  @Test
  public void testUpdateCountGetUpdateCount() {
    StatementResult subject = StatementResultImpl.of(1L);
    assertThat(subject.getResultType(), is(equalTo(ResultType.UPDATE_COUNT)));
    assertThat(subject.getUpdateCount(), is(notNullValue()));
  }

  @Test
  public void testBooleanResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet("foo", Boolean.TRUE, ClientSideStatementType.SHOW_AUTOCOMMIT);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(), is(equalTo(ClientSideStatementType.SHOW_AUTOCOMMIT)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(subject.getResultSet().getBoolean("foo"), is(true));
    assertThat(subject.getResultSet().next(), is(false));
  }

  @Test
  public void testLongResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet("foo", 10L, ClientSideStatementType.SHOW_READ_ONLY_STALENESS);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(),
        is(equalTo(ClientSideStatementType.SHOW_READ_ONLY_STALENESS)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(subject.getResultSet().getLong("foo"), is(equalTo(10L)));
    assertThat(subject.getResultSet().next(), is(false));
  }

  @Test
  public void testLongArrayResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet(
            "foo", new long[] {1L, 2L, 3L}, ClientSideStatementType.SHOW_RETRY_ABORTS_INTERNALLY);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(),
        is(equalTo(ClientSideStatementType.SHOW_RETRY_ABORTS_INTERNALLY)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(subject.getResultSet().getLongArray("foo"), is(equalTo(new long[] {1L, 2L, 3L})));
    assertThat(subject.getResultSet().next(), is(false));
  }

  @Test
  public void testStringResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet(
            "foo", "bar", ClientSideStatementType.SHOW_READ_ONLY_STALENESS);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(),
        is(equalTo(ClientSideStatementType.SHOW_READ_ONLY_STALENESS)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(subject.getResultSet().getString("foo"), is(equalTo("bar")));
    assertThat(subject.getResultSet().next(), is(false));
  }

  @Test
  public void testEnumResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet(
            "foo", TransactionMode.READ_ONLY_TRANSACTION, ClientSideStatementType.SHOW_READONLY);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(), is(equalTo(ClientSideStatementType.SHOW_READONLY)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(
        subject.getResultSet().getString("foo"),
        is(equalTo(TransactionMode.READ_ONLY_TRANSACTION.toString())));
    assertThat(subject.getResultSet().next(), is(false));
  }

  @Test
  public void testTimestampResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet(
            "foo",
            Timestamp.ofTimeSecondsAndNanos(10L, 10),
            ClientSideStatementType.SHOW_READ_TIMESTAMP);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(),
        is(equalTo(ClientSideStatementType.SHOW_READ_TIMESTAMP)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(
        subject.getResultSet().getTimestamp("foo"),
        is(equalTo(Timestamp.ofTimeSecondsAndNanos(10L, 10))));
    assertThat(subject.getResultSet().next(), is(false));
  }
}
