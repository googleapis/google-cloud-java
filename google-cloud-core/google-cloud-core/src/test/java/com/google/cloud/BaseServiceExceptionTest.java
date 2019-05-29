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

package com.google.cloud;

import static com.google.cloud.BaseServiceException.UNKNOWN_CODE;
import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.cloud.BaseServiceException.ExceptionData;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.Test;

/** Tests for {@link BaseServiceException}. */
public class BaseServiceExceptionTest {

  private static final int CODE = 1;
  private static final int CODE_NO_REASON = 2;
  private static final String MESSAGE = "some message";
  private static final String REASON = "some reason";
  private static final boolean NOT_RETRYABLE = false;
  private static final boolean RETRYABLE = true;
  private static final boolean IDEMPOTENT = true;
  private static final String DEBUG_INFO = "debugInfo";
  private static final String LOCATION = "location";

  private static class CustomServiceException extends BaseServiceException {

    private static final long serialVersionUID = -195251309124875103L;

    public CustomServiceException(int code, String message, String reason, boolean idempotent) {
      super(
          ExceptionData.from(
              code,
              message,
              reason,
              BaseServiceException.isRetryable(code, reason, idempotent, RETRYABLE_ERRORS)));
    }

    private static final Set RETRYABLE_ERRORS =
        ImmutableSet.of(
            new Error(CODE, REASON), new Error(null, REASON), new Error(CODE_NO_REASON, null));
  }

  @Test
  public void testBaseServiceException() {
    BaseServiceException serviceException =
        new BaseServiceException(ExceptionData.from(CODE, MESSAGE, REASON, NOT_RETRYABLE));
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertNull(serviceException.getCause());

    Exception cause = new RuntimeException();
    serviceException =
        new BaseServiceException(ExceptionData.from(CODE, MESSAGE, REASON, NOT_RETRYABLE, cause));
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertFalse(serviceException.isRetryable());
    assertEquals(cause, serviceException.getCause());

    serviceException =
        new BaseServiceException(
            ExceptionData.newBuilder()
                .setMessage(MESSAGE)
                .setCause(cause)
                .setCode(CODE)
                .setReason(REASON)
                .setRetryable(RETRYABLE)
                .setDebugInfo(DEBUG_INFO)
                .setLocation(LOCATION)
                .build());
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertTrue(serviceException.isRetryable());
    assertEquals(cause, serviceException.getCause());
    assertEquals(DEBUG_INFO, serviceException.getDebugInfo());
    assertEquals(LOCATION, serviceException.getLocation());

    serviceException = new CustomServiceException(CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertTrue(serviceException.isRetryable());

    serviceException = new CustomServiceException(CODE_NO_REASON, MESSAGE, null, IDEMPOTENT);
    assertEquals(CODE_NO_REASON, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertNull(serviceException.getReason());
    assertTrue(serviceException.isRetryable());

    serviceException = new CustomServiceException(UNKNOWN_CODE, MESSAGE, REASON, IDEMPOTENT);
    assertEquals(UNKNOWN_CODE, serviceException.getCode());
    assertEquals(MESSAGE, serviceException.getMessage());
    assertEquals(REASON, serviceException.getReason());
    assertTrue(serviceException.isRetryable());
  }

  @Test
  public void testTranslateAndThrow() throws Exception {
    BaseServiceException cause =
        new BaseServiceException(ExceptionData.from(CODE, MESSAGE, REASON, NOT_RETRYABLE));
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
    } finally {
      verify(exceptionMock);
    }
  }

  @Test
  public void testError_Equal() {
    BaseServiceException.Error error = new BaseServiceException.Error(0, "reason", true);
    assertThat(error).isEqualTo(error);
    assertThat(error.hashCode()).isEqualTo(error.hashCode());

    BaseServiceException.Error sameError = new BaseServiceException.Error(0, "reason", true);
    assertThat(error).isEqualTo(sameError);
    assertThat(error.hashCode()).isEqualTo(sameError.hashCode());

    BaseServiceException.Error error2 = new BaseServiceException.Error(1, "other reason", false);
    assertThat(error).isNotEqualTo(error2);
    assertThat(error.hashCode()).isNotEqualTo(error2.hashCode());
  }
}
