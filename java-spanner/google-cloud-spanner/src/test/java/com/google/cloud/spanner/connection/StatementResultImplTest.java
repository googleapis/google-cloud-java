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
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import com.google.cloud.ByteArray;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.StatementResult.ClientSideStatementType;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatementResultImplTest {

  @Test
  public void testNoResultGetResultSet() {
    StatementResult subject = StatementResultImpl.noResult();
    assertThat(subject.getResultType(), is(equalTo(ResultType.NO_RESULT)));
    try {
      subject.getResultSet();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testNoResultGetUpdateCount() {
    StatementResult subject = StatementResultImpl.noResult();
    assertThat(subject.getResultType(), is(equalTo(ResultType.NO_RESULT)));
    try {
      subject.getUpdateCount();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
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
    try {
      subject.getUpdateCount();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
  }

  @Test
  public void testUpdateCountGetResultSet() {
    StatementResult subject = StatementResultImpl.of(1L);
    assertThat(subject.getResultType(), is(equalTo(ResultType.UPDATE_COUNT)));
    try {
      subject.getResultSet();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertEquals(ErrorCode.FAILED_PRECONDITION, ex.getErrorCode());
    }
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

    subject =
        StatementResultImpl.resultSet(
            "path", "descriptors.pb", ClientSideStatementType.SHOW_PROTO_DESCRIPTORS_FILE_PATH);
    assertThat(subject.getResultType(), is(equalTo(ResultType.RESULT_SET)));
    assertThat(
        subject.getClientSideStatementType(),
        is(equalTo(ClientSideStatementType.SHOW_PROTO_DESCRIPTORS_FILE_PATH)));
    assertThat(subject.getResultSet(), is(notNullValue()));
    assertThat(subject.getResultSet().next(), is(true));
    assertThat(subject.getResultSet().getString("path"), is(equalTo("descriptors.pb")));
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

  @Test
  public void testBytesResultSetGetResultSet() {
    StatementResult subject =
        StatementResultImpl.resultSet(
            "foo", "protoDescriptors".getBytes(), ClientSideStatementType.SHOW_PROTO_DESCRIPTORS);
    assertEquals(subject.getResultType(), ResultType.RESULT_SET);
    assertEquals(
        subject.getClientSideStatementType(), ClientSideStatementType.SHOW_PROTO_DESCRIPTORS);
    assertNotNull(subject.getResultSet());
    assertTrue(subject.getResultSet().next());
    assertEquals(
        subject.getResultSet().getBytes("foo"), ByteArray.copyFrom("protoDescriptors".getBytes()));
    assertFalse(subject.getResultSet().next());
  }
}
