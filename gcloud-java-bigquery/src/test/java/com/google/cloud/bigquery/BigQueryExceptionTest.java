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

package com.google.cloud.bigquery;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;

import org.junit.Test;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class BigQueryExceptionTest {

  @Test
  public void testBigqueryException() {
    BigQueryException exception = new BigQueryException(500, "message");
    assertEquals(500, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new BigQueryException(502, "message");
    assertEquals(502, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new BigQueryException(503, "message");
    assertEquals(503, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new BigQueryException(504, "message");
    assertEquals(504, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new BigQueryException(400, "message");
    assertEquals(400, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertFalse(exception.retryable());
    assertTrue(exception.idempotent());

    BigQueryError error = new BigQueryError("reason", null, null);
    exception = new BigQueryException(504, "message", error);
    assertEquals(504, exception.code());
    assertEquals("message", exception.getMessage());
    assertEquals("reason", exception.reason());
    assertEquals(error, exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    IOException cause = new SocketTimeoutException("socketTimeoutMessage");
    exception = new BigQueryException(cause);
    assertEquals(BigQueryException.UNKNOWN_CODE, exception.code());
    assertNull(exception.reason());
    assertEquals("socketTimeoutMessage", exception.getMessage());
    assertEquals(cause, exception.getCause());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());
    assertSame(cause, exception.getCause());

    exception = new BigQueryException(504, "message", cause);
    assertEquals(504, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertNull(exception.error());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());
    assertSame(cause, exception.getCause());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    Exception cause = new BigQueryException(503, "message");
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      BigQueryException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(503, ex.code());
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
      BigQueryException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(BigQueryException.UNKNOWN_CODE, ex.code());
      assertEquals("message", ex.getMessage());
      assertFalse(ex.retryable());
      assertTrue(ex.idempotent());
      assertSame(cause, ex.getCause());
    } finally {
      verify(exceptionMock);
    }
  }
}
