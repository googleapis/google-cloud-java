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

package com.google.cloud.grpc;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.InternalException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper;
import io.grpc.Status.Code;
import java.io.IOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.junit.Test;

public class BaseGrpcServiceExceptionTest {

  private static final String MESSAGE = "some message";
  private static final boolean NOT_RETRYABLE = false;
  private static final boolean IDEMPOTENT = true;

  @Test
  public void testBaseServiceException() {
    BaseGrpcServiceException serviceException = null;

    IOException exception = new SocketTimeoutException();
    serviceException = new BaseGrpcServiceException(exception, IDEMPOTENT);
    assertTrue(serviceException.isRetryable());
    assertNull(serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());
    assertNull(serviceException.getReason());
    assertNull(serviceException.getLocation());
    assertNull(serviceException.getDebugInfo());

    exception = new SocketException();
    serviceException = new BaseGrpcServiceException(exception, IDEMPOTENT);
    assertTrue(serviceException.isRetryable());
    assertNull(serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());
    assertNull(serviceException.getReason());
    assertNull(serviceException.getLocation());
    assertNull(serviceException.getDebugInfo());

    exception = new IOException("insufficient data written");
    serviceException = new BaseGrpcServiceException(exception, IDEMPOTENT);
    assertTrue(serviceException.isRetryable());
    assertEquals("insufficient data written", serviceException.getMessage());
    assertEquals(exception, serviceException.getCause());
    assertNull(serviceException.getReason());
    assertNull(serviceException.getLocation());
    assertNull(serviceException.getDebugInfo());

    Exception cause = new IllegalArgumentException("bad arg");
    InternalException apiException =
        new InternalException(MESSAGE, cause, GrpcStatusCode.of(Code.INTERNAL), NOT_RETRYABLE);
    serviceException = new BaseGrpcServiceException(apiException);
    assertFalse(serviceException.isRetryable());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(apiException, serviceException.getCause());
    assertEquals(500, serviceException.getCode());
    assertEquals(Code.INTERNAL.name(), serviceException.getReason());
    assertNull(serviceException.getLocation());
    assertNull(serviceException.getDebugInfo());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    IOException exception = new SocketTimeoutException();
    BaseGrpcServiceException cause = new BaseGrpcServiceException(exception, IDEMPOTENT);
    RetryHelper.RetryHelperException exceptionMock =
        createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    try {
      BaseServiceException.translate(exceptionMock);
    } catch (BaseServiceException ex) {
      assertEquals(0, ex.getCode());
      assertNull(ex.getMessage());
      assertTrue(ex.isRetryable());
    } finally {
      verify(exceptionMock);
    }
  }

}
