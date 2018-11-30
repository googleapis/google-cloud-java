/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.resourcemanager;

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
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.junit.Test;

public class ResourceManagerExceptionTest {

  @Test
  public void testResourceManagerException() {
    ResourceManagerException exception = new ResourceManagerException(500, "message");
    assertEquals(500, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());

    exception = new ResourceManagerException(503, "message");
    assertEquals(503, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());

    exception = new ResourceManagerException(429, "message");
    assertEquals(429, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertTrue(exception.isRetryable());

    exception = new ResourceManagerException(403, "message");
    assertEquals(403, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertFalse(exception.isRetryable());

    IOException cause = new SocketTimeoutException();
    exception = new ResourceManagerException(cause);
    assertNull(exception.getReason());
    assertNull(exception.getMessage());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new ResourceManagerException(404, "message", cause);
    assertEquals(404, exception.getCode());
    assertEquals("message", exception.getMessage());
    assertNull(exception.getReason());
    assertFalse(exception.isRetryable());
    assertSame(cause, exception.getCause());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    Exception cause = new ResourceManagerException(503, "message");
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      ResourceManagerException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(503, ex.getCode());
      assertEquals("message", ex.getMessage());
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
      ResourceManagerException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(ResourceManagerException.UNKNOWN_CODE, ex.getCode());
      assertEquals("message", ex.getMessage());
      assertFalse(ex.isRetryable());
      assertSame(cause, ex.getCause());
    } finally {
      verify(exceptionMock);
    }
  }
}
