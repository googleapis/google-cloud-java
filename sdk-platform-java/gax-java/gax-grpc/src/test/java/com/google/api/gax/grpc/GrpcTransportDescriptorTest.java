/*
 * Copyright 2017 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.grpc;

import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DataLossException;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.rpc.UnknownException;
import com.google.common.truth.Truth;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class GrpcTransportDescriptorTest {
  private static boolean NOT_RETRYABLE = false;
  private static boolean IS_RETRYABLE = true;

  @Test
  void translateException_StatusException_noRetry() {
    Throwable originalException = new StatusException(Status.INVALID_ARGUMENT);
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(originalException), Collections.<StatusCode.Code>emptySet());
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, InvalidArgumentException.class, NOT_RETRYABLE, originalException);
    }
  }

  @Test
  void translateException_StatusException_withRetry() {
    Throwable originalException = new StatusException(Status.UNAVAILABLE);
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(originalException), Collections.singleton(Code.UNAVAILABLE));
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, UnavailableException.class, IS_RETRYABLE, originalException);
    }
  }

  @Test
  void translateException_StatusRuntimeException_noRetry() {
    Throwable originalException = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(originalException), Collections.<StatusCode.Code>emptySet());
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, InvalidArgumentException.class, NOT_RETRYABLE, originalException);
    }
  }

  @Test
  void translateException_StatusRuntimeException_withRetry() {
    Throwable originalException = new StatusRuntimeException(Status.UNAVAILABLE);
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(originalException), Collections.singleton(Code.UNAVAILABLE));
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, UnavailableException.class, IS_RETRYABLE, originalException);
    }
  }

  @Test
  void translateException_cancelled() {
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(inactiveCallable(), Collections.<StatusCode.Code>emptySet());
    ApiFuture<Integer> result = exceptionCallable.futureCall(0);
    Truth.assertThat(result.isDone()).isFalse();
    result.cancel(true);
    Truth.assertThat(result.isCancelled()).isTrue();
    Truth.assertThat(result.isDone()).isTrue();
  }

  @Test
  void translateException_ApiException() {
    Throwable originalException = new RuntimeException("stuff went wrong");
    Throwable apiException =
        new DataLossException(
            originalException, GrpcStatusCode.of(Status.Code.UNKNOWN), IS_RETRYABLE);
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(apiException), Collections.<StatusCode.Code>emptySet());
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, DataLossException.class, IS_RETRYABLE, originalException);
    }
  }

  @Test
  void translateException_RuntimeException() {
    Throwable originalException = new RuntimeException("stuff went wrong");
    GrpcExceptionCallable<Integer, Integer> exceptionCallable =
        new GrpcExceptionCallable<>(
            failingCallable(originalException), Collections.<StatusCode.Code>emptySet());
    try {
      exceptionCallable.call(0);
      fail("Expected exception to be thrown");
    } catch (Throwable throwable) {
      assertInnerExceptionIsInstanceOf(
          throwable, UnknownException.class, NOT_RETRYABLE, originalException);
    }
  }

  private UnaryCallable<Integer, Integer> failingCallable(final Throwable exception) {
    return new UnaryCallable<Integer, Integer>() {
      @Override
      public ApiFuture<Integer> futureCall(Integer request, ApiCallContext context) {
        return ApiFutures.immediateFailedFuture(exception);
      }
    };
  }

  private UnaryCallable<Integer, Integer> inactiveCallable() {
    return new UnaryCallable<Integer, Integer>() {
      @Override
      public ApiFuture<Integer> futureCall(Integer request, ApiCallContext context) {
        return SettableApiFuture.create();
      }
    };
  }

  void assertInnerExceptionIsInstanceOf(
      Throwable thrownException, Class<?> clazz, boolean retryable, Throwable originalException) {
    Truth.assertThat(thrownException).isInstanceOf(clazz);
    ApiException apiException = (ApiException) thrownException;
    Truth.assertThat(apiException.isRetryable()).isEqualTo(retryable);
  }
}
