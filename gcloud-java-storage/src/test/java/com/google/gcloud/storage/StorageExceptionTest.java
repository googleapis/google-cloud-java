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

package com.google.gcloud.storage;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;

import org.junit.Test;

import java.io.IOException;
import java.net.SocketTimeoutException;

public class StorageExceptionTest {

  @Test
  public void testStorageException() {
    StorageException exception = new StorageException(500, "message");
    assertEquals(500, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(502, "message");
    assertEquals(502, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(503, "message");
    assertEquals(503, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(504, "message");
    assertEquals(504, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(429, "message");
    assertEquals(429, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(408, "message");
    assertEquals(408, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());

    exception = new StorageException(400, "message");
    assertEquals(400, exception.code());
    assertEquals("message", exception.getMessage());
    assertNull(exception.reason());
    assertFalse(exception.retryable());
    assertTrue(exception.idempotent());

    IOException cause = new SocketTimeoutException();
    exception = new StorageException(cause);
    assertNull(exception.reason());
    assertNull(exception.getMessage());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());
    assertEquals(cause, exception.getCause());

    GoogleJsonError error = new GoogleJsonError();
    error.setCode(503);
    error.setMessage("message");
    exception = new StorageException(error);
    assertEquals(503, exception.code());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.retryable());
    assertTrue(exception.idempotent());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    StorageException cause = new StorageException(503, "message");
    RetryHelperException exceptionMock = createMock(RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      StorageException.translateAndThrow(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(503, ex.code());
      assertEquals("message", ex.getMessage());
      assertTrue(ex.retryable());
      assertTrue(ex.idempotent());
    } finally {
      verify(exceptionMock);
    }
  }
}
