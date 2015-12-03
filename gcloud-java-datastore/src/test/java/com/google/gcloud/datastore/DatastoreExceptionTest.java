/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.common.collect.ImmutableSet;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.datastore.DatastoreException.Reason;

import org.junit.Test;

import java.util.Set;

public class DatastoreExceptionTest {

  private static final Reason RETRYABLE_REASON = Reason.ABORTED;
  private static final Reason NON_RETRYABLE_REASON = Reason.PERMISSION_DENIED;
  private static final String MESSAGE = "message";
  private static final int NON_RETRYABLE_CODE = 500;
  private static final int RETRYABLE_CODE = 403;
  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(409, 403, 503);

  @Test
  public void testConstructor() {
    DatastoreException exception;
    for (int code : RETRYABLE_CODES) {
      exception = new DatastoreException(RETRYABLE_REASON, code, MESSAGE);
      assertTrue(exception.idempotent());
      assertTrue(exception.retryable());
      assertEquals(code, exception.code());
      assertEquals(RETRYABLE_REASON, exception.reason());
      assertEquals(MESSAGE, exception.getMessage());
    }
    exception = new DatastoreException(RETRYABLE_REASON, NON_RETRYABLE_CODE, MESSAGE);
    assertTrue(exception.idempotent());
    assertFalse(exception.retryable());
    assertEquals(NON_RETRYABLE_CODE, exception.code());
    assertEquals(RETRYABLE_REASON, exception.reason());
    assertEquals(MESSAGE, exception.getMessage());
    exception = new DatastoreException(NON_RETRYABLE_REASON, RETRYABLE_CODE, MESSAGE);
    assertTrue(exception.idempotent());
    assertFalse(exception.retryable());
    assertEquals(RETRYABLE_CODE, exception.code());
    assertEquals(NON_RETRYABLE_REASON, exception.reason());
    assertEquals(MESSAGE, exception.getMessage());
    Exception cause = new Exception();
    for (int code : RETRYABLE_CODES) {
      exception = new DatastoreException(RETRYABLE_REASON, code, MESSAGE, cause);
      assertTrue(exception.idempotent());
      assertTrue(exception.retryable());
      assertEquals(code, exception.code());
      assertEquals(RETRYABLE_REASON, exception.reason());
      assertEquals(MESSAGE, exception.getMessage());
      assertSame(cause, exception.getCause());
    }
  }

  @Test
  public void testPropagateUserException() throws Exception {
    Exception cause = new Exception(MESSAGE);
    try {
      DatastoreException.propagateUserException(cause);
      fail("DatastoreException expected");
    } catch (DatastoreException ex) {
      assertEquals(Reason.UNKNOWN, ex.reason());
      assertEquals(BaseServiceException.UNKNOWN_CODE, ex.code());
      assertEquals(MESSAGE, ex.getMessage());
      assertEquals(false, ex.retryable());
      assertEquals(true, ex.idempotent());
      assertSame(cause, ex.getCause());
    }
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    Exception cause = new Exception();
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause);
    expect(exceptionMock.getMessage()).andReturn(MESSAGE);
    replay(exceptionMock);
    try {
      DatastoreException.translateAndThrow(exceptionMock);
    } catch (DatastoreException ex) {
      assertEquals(Reason.UNKNOWN, ex.reason());
      assertEquals(BaseServiceException.UNKNOWN_CODE, ex.code());
      assertEquals(MESSAGE, ex.getMessage());
      assertEquals(false, ex.retryable());
      assertEquals(true, ex.idempotent());
    } finally {
      verify(exceptionMock);
    }
  }
}
