/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.gcloud.compute;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;

import org.junit.Test;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class ComputeExceptionTest {

  @Test
  public void testResourceManagerException() {
    ComputeException exception = new ComputeException(500, "message");
    assertEquals(500, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new ComputeException(403, "message");
    assertEquals(403, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertFalse(exception.retryable());
    assertTrue(exception.idempotent());

    IOException cause = new SocketTimeoutException();
    exception = new ComputeException(cause);
    assertNull(exception.reason());
    assertNull(exception.getMessage());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());
    assertSame(cause, exception.getCause());

    exception = new ComputeException(403, "message", cause);
    assertEquals(403, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertFalse(exception.retryable());
    assertTrue(exception.idempotent());
    assertSame(cause, exception.getCause());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    Exception cause = new ComputeException(500, "message");
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      ComputeException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(500, ex.code());
      assertEquals("message", ex.getMessage());
      assertTrue(ex.retryable());
      assertTrue(ex.idempotent());
    } finally {
      verify(exceptionMock);
    }
    cause = new IllegalArgumentException("message");
    exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getMessage()).andReturn("message").times(1);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      ComputeException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(ComputeException.UNKNOWN_CODE, ex.code());
      assertEquals("message", ex.getMessage());
      assertFalse(ex.retryable());
      assertTrue(ex.idempotent());
      assertSame(cause, ex.getCause());
    } finally {
      verify(exceptionMock);
    }
  }
}
