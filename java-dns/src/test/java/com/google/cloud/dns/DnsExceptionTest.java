/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.dns;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.junit.Test;

public class DnsExceptionTest {

  @Test
  public void testDnsException() throws Exception {
    IOException cause = new SocketTimeoutException("socketTimeoutMessage");
    DnsException exception = new DnsException(500, "message", cause);
    assertEquals(500, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DnsException(502, "message", cause);
    assertEquals(502, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DnsException(503, "message", cause);
    assertEquals(503, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DnsException(429, "message", cause);
    assertEquals(429, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DnsException(404, "message", cause);
    assertEquals(404, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertFalse(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DnsException(cause, true);
    assertEquals(DnsException.UNKNOWN_CODE, exception.getCode());
    assertNull(exception.getReason());
    assertEquals("socketTimeoutMessage", exception.getMessage());
    assertEquals(cause, exception.getCause());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(503);
    error.setMessage("message");
    exception = new DnsException(error, true);
    assertEquals(503, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.isRetryable());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    IOException timeoutException = new SocketTimeoutException("message");
    Exception cause = new DnsException(timeoutException, true);
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      DnsException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(DnsException.UNKNOWN_CODE, ex.getCode());
      assertNull(ex.getReason());
      assertEquals("message", ex.getMessage());
      assertEquals(timeoutException, ex.getCause());
      assertTrue(ex.isRetryable());
    } finally {
      verify(exceptionMock);
    }
    cause = new IllegalArgumentException("message");
    exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getMessage()).andReturn("message").times(1);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      DnsException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(DnsException.UNKNOWN_CODE, ex.getCode());
      assertEquals("message", ex.getMessage());
      assertFalse(ex.isRetryable());
      assertSame(cause, ex.getCause());
    } finally {
      verify(exceptionMock);
    }
  }
}
