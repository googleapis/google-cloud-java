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

import com.google.api.client.googleapis.json.GoogleJsonError;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * Tests for {@link BaseServiceException}.
 */
public class BaseServiceExceptionTest {

  private static final int CODE = 1;
  private static final String MESSAGE = "some message";
  private static final boolean RETRYABLE = true;
  private static final boolean IDEMPOTENT = true;

  @Test
  public void testBaseServiceException() {
    BaseServiceException serviceException = new BaseServiceException(CODE, MESSAGE, RETRYABLE,
        IDEMPOTENT);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(RETRYABLE, serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
    assertEquals(null, serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, RETRYABLE, false);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(false, serviceException.retryable());
    assertEquals(false, serviceException.idempotent());
    assertEquals(null, serviceException.getCause());

    Exception cause = new RuntimeException();
    serviceException = new BaseServiceException(CODE, MESSAGE, RETRYABLE, IDEMPOTENT, cause);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(RETRYABLE, serviceException.retryable());
    assertEquals(IDEMPOTENT, serviceException.idempotent());
    assertEquals(cause, serviceException.getCause());

    serviceException = new BaseServiceException(CODE, MESSAGE, RETRYABLE, false, cause);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(false, serviceException.retryable());
    assertEquals(false, serviceException.idempotent());

    IOException exception = new SocketTimeoutException();
    serviceException = new BaseServiceException(exception, true);
    assertEquals(true, serviceException.retryable());
    assertEquals(true, serviceException.idempotent());
    assertEquals(exception, serviceException.getCause());

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(CODE);
    error.setMessage(MESSAGE);
    serviceException = new BaseServiceException(error, true);
    assertEquals(CODE, serviceException.code());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(false, serviceException.retryable());
    assertEquals(true, serviceException.idempotent());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    BaseServiceException cause = new BaseServiceException(CODE, MESSAGE, RETRYABLE, IDEMPOTENT);
    RetryHelper.RetryHelperException exceptionMock = createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      BaseServiceException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(CODE, ex.code());
      assertEquals(MESSAGE, ex.getMessage());
      assertEquals(RETRYABLE, ex.retryable());
      assertEquals(IDEMPOTENT, ex.idempotent());
    } finally {
      verify(exceptionMock);
    }
  }
}
