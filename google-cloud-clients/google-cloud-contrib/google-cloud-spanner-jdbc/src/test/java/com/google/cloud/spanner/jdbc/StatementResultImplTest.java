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

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.ResultSet;
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
}
