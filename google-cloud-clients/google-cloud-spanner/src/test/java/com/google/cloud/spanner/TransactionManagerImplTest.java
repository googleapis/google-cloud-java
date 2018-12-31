/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.SpannerImpl.SessionImpl;
import com.google.cloud.spanner.TransactionManager.TransactionState;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

@RunWith(JUnit4.class)
public class TransactionManagerImplTest {

  @Rule public ExpectedException exception = ExpectedException.none();

  @Mock private SessionImpl session;
  @Mock SpannerImpl.TransactionContextImpl txn;
  private TransactionManagerImpl manager;

  @Before
  public void setUp() {
    initMocks(this);
    manager = new TransactionManagerImpl(session);
  }

  @Test
  public void beginCalledTwiceFails() {
    when(session.newTransaction()).thenReturn(txn);
    assertThat(manager.begin()).isEqualTo(txn);
    assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
    exception.expect(IllegalStateException.class);
    manager.begin();
  }

  @Test
  public void commitBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.commit();
  }

  @Test
  public void rollbackBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.rollback();
  }

  @Test
  public void resetBeforeBeginFails() {
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void transactionRolledBackOnClose() {
    when(session.newTransaction()).thenReturn(txn);
    when(txn.isAborted()).thenReturn(false);
    manager.begin();
    manager.close();
    verify(txn).rollback();
  }

  @Test
  public void commitSucceeds() {
    when(session.newTransaction()).thenReturn(txn);
    Timestamp commitTimestamp = Timestamp.ofTimeMicroseconds(1);
    when(txn.commitTimestamp()).thenReturn(commitTimestamp);
    manager.begin();
    manager.commit();
    assertThat(manager.getState()).isEqualTo(TransactionState.COMMITTED);
    assertThat(manager.getCommitTimestamp()).isEqualTo(commitTimestamp);
  }

  @Test
  public void resetAfterSuccessfulCommitFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.commit();
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void resetAfterAbortSucceeds() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "")).when(txn).commit();
    try {
      manager.commit();
      fail("Expected AbortedException");
    } catch (AbortedException e) {
      assertThat(manager.getState()).isEqualTo(TransactionState.ABORTED);
    }
    txn = Mockito.mock(SpannerImpl.TransactionContextImpl.class);
    when(session.newTransaction()).thenReturn(txn);
    assertThat(manager.resetForRetry()).isEqualTo(txn);
    assertThat(manager.getState()).isEqualTo(TransactionState.STARTED);
  }

  @Test
  public void resetAfterErrorFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    doThrow(SpannerExceptionFactory.newSpannerException(ErrorCode.UNKNOWN, "")).when(txn).commit();
    try {
      manager.commit();
      fail("Expected AbortedException");
    } catch (SpannerException e) {
      assertThat(e.getErrorCode()).isEqualTo(ErrorCode.UNKNOWN);
    }
    exception.expect(IllegalStateException.class);
    manager.resetForRetry();
  }

  @Test
  public void rollbackAfterCommitFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.commit();
    exception.expect(IllegalStateException.class);
    manager.rollback();
  }

  @Test
  public void commitAfterRollbackFails() {
    when(session.newTransaction()).thenReturn(txn);
    manager.begin();
    manager.rollback();
    exception.expect(IllegalStateException.class);
    manager.commit();
  }
}
