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

package com.google.cloud;

import static com.google.cloud.BaseServiceException.UNKNOWN_CODE;
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
import java.net.SocketException;
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
    protected Set<Error> getRetryableErrors() {
      return ImmutableSet.of(new Error(CODE, REASON), new Error(null, REASON),
          new Error(CODE_NO_REASON, null));
    }
  }

  @Test
  public void testBaseServiceException() {
    BaseServiceException serviceException = new BaseServiceException(CODE, MESSAGE, REASON,
        IDEMPOTENT);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());
    assertNull(serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());
    assertNull(serviceException.getCause());

    Exception cause = new RuntimeException();
    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT, cause);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());
    assertEquals(cause, serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, REASON, false, cause);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertFalse(serviceException.isIdempotent());
    assertEquals(cause, serviceException.getCause());

    IOException exception = new SocketTimeoutException();
    serviceException = new BaseServiceException(exception, true);
    assertTrue(serviceException.isRetryable());
    assertTrue(serviceException.isIdempotent());
    assertNull(serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());

    exception = new SocketException();
    serviceException = new BaseServiceException(exception, true);
    assertTrue(serviceException.isRetryable());
    assertTrue(serviceException.isIdempotent());
    assertNull(serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());

    exception = new IOException("insufficient data written");
    serviceException = new BaseServiceException(exception, true);
    assertTrue(serviceException.isRetryable());
    assertTrue(serviceException.isIdempotent());
    assertEquals("insufficient data written", serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(CODE);
    error.setMessage(MESSAGE);
    serviceException = new BaseServiceException(error, true);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertFalse(serviceException.isRetryable());
    assertTrue(serviceException.isIdempotent());

    serviceException = new CustomServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertEquals(RETRYABLE, serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());

    serviceException = new CustomServiceException(CODE_NO_REASON, MESSAGE, null, IDEMPOTENT);
    assertEquals(CODE_NO_REASON, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertNull(serviceException.getReason());
    assertEquals(RETRYABLE, serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());

    serviceException = new CustomServiceException(UNKNOWN_CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(UNKNOWN_CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertEquals(RETRYABLE, serviceException.isRetryable());
    assertEquals(IDEMPOTENT, serviceException.isIdempotent());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    BaseServiceException cause = new BaseServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    RetryHelper.RetryHelperException exceptionMock =
        createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      BaseServiceException.translate(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(CODE, ex.getCode());
      assertEquals(MESSAGE, ex.getMessage());
      assertFalse(ex.isRetryable());
      assertEquals(IDEMPOTENT, ex.isIdempotent());
    } finally {
      verify(exceptionMock);
    }
  }
}
