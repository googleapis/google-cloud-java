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

package com.google.gcloud;

import static com.google.gcloud.BaseServiceException.UNKNOWN_CODE;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.common.collect.ImmutableSet;

import org.junit.Test;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.Set;

/**
 * Tests for {@link BaseServiceException}.
 */
public class BaseServiceExceptionTest {

  private static final int CODE = 1;
  private static final int CODE_NO_REASON = 2;
  private static final String MESSAGE = "some message";
  private static final String REASON = "some reason";
  private static final boolean RETRYABLE = true;
  private static final boolean IDEMPOTENT = true;
  private static class CustomServiceException extends BaseServiceException {

    private static final long serialVersionUID = -195251309124875103L;

    public CustomServiceException(int code, String message, String reason, boolean idempotent) {
      super(code, message, reason, idempotent);
    }

    @Override
    protected Set<Error> retryableErrors() {
      return ImmutableSet.of(new Error(CODE, REASON), new Error(null, REASON),
          new Error(CODE_NO_REASON, null));
    }
  }

  @Test
  public void testBaseServiceException() {
    BaseServiceException serviceException = new BaseServiceException(CODE, MESSAGE, REASON,
         IDEMPOTENT);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertFalse(serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
    assertNull(serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertFalse(serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
    assertNull(serviceException.getCause());

    Exception cause = new RuntimeException();
    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT, cause);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertFalse(serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
    assertEquals(cause, serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, false, cause);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertFalse(serviceException.retryable());
    assertFalse(serviceException.idempotent());
    assertEquals(cause, serviceException.getCause());

    IOException exception = new SocketTimeoutException();
    serviceException = new BaseServiceException(exception, true);
    assertTrue(serviceException.retryable());
    assertTrue(serviceException.idempotent());
    assertEquals(exception, serviceException.getCause());

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(CODE);
    error.setMessage(MESSAGE);
    serviceException = new BaseServiceException(error, true);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertFalse(serviceException.retryable());
    assertTrue(serviceException.idempotent());

    serviceException = new CustomServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertEquals(RETRYABLE, serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());

    serviceException = new CustomServiceException(CODE_NO_REASON, MESSAGE, null, IDEMPOTENT);
    assertEquals(CODE_NO_REASON, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertNull(serviceException.reason());
    assertEquals(RETRYABLE, serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());

    serviceException = new CustomServiceException(UNKNOWN_CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(UNKNOWN_CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.reason());
    assertEquals(RETRYABLE, serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    BaseServiceException cause = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    RetryHelper.RetryHelperException exceptionMock = createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      BaseServiceException ex = BaseServiceException.translateAndThrow(exceptionMock);
      if (ex != null) {
        throw ex;
      }
    } catch (BaseServiceException ex) {
      assertEquals(CODE, ex.code());
      assertEquals(MESSAGE, ex.getMessage());
      assertFalse(ex.retryable());
      assertEquals(IDEMPOTENT, ex.idempotent());
    } finally {
      verify(exceptionMock);
    }
  }
}
