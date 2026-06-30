/*
 * Copyright 2020 Google LLC
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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

import com.google.api.core.ApiFutures;
import com.google.cloud.spanner.AsyncResultSet;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.connection.StatementResult.ResultType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AsyncStatementResultImplTest {

  @Test
  public void testNoResultGetResultSetAsync() {
    AsyncStatementResult subject =
        AsyncStatementResultImpl.noResult(ApiFutures.immediateFuture(null));
    assertThat(subject.getResultType()).isEqualTo(ResultType.NO_RESULT);
    try {
      subject.getResultSetAsync();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testNoResultGetUpdateCountAsync() {
    AsyncStatementResult subject =
        AsyncStatementResultImpl.noResult(ApiFutures.immediateFuture(null));
    assertThat(subject.getResultType()).isEqualTo(ResultType.NO_RESULT);
    try {
      subject.getUpdateCountAsync();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testResultSetGetResultSetAsync() {
    AsyncStatementResult subject = AsyncStatementResultImpl.of(mock(AsyncResultSet.class));
    assertThat(subject.getResultType()).isEqualTo(ResultType.RESULT_SET);
    assertThat(subject.getResultSetAsync()).isNotNull();
  }

  @Test
  public void testResultSetGetUpdateCountAsync() {
    AsyncStatementResult subject = AsyncStatementResultImpl.of(mock(AsyncResultSet.class));
    assertThat(subject.getResultType()).isEqualTo(ResultType.RESULT_SET);
    try {
      subject.getUpdateCountAsync();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testUpdateCountGetResultSetAsync() {
    AsyncStatementResult subject = AsyncStatementResultImpl.of(ApiFutures.immediateFuture(1L));
    assertThat(subject.getResultType()).isEqualTo(ResultType.UPDATE_COUNT);
    try {
      subject.getResultSetAsync();
      fail("Expected exception");
    } catch (SpannerException ex) {
      assertThat(ex.getErrorCode()).isEqualTo(ErrorCode.FAILED_PRECONDITION);
    }
  }

  @Test
  public void testUpdateCountGetUpdateCountAsync() {
    AsyncStatementResult subject = AsyncStatementResultImpl.of(ApiFutures.immediateFuture(1L));
    assertThat(subject.getResultType()).isEqualTo(ResultType.UPDATE_COUNT);
    assertThat(get(subject.getUpdateCountAsync())).isEqualTo(1L);
  }
}
