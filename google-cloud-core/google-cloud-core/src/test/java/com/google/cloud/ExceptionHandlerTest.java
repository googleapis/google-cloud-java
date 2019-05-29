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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.ExceptionHandler.Interceptor;
import com.google.cloud.ExceptionHandler.Interceptor.RetryResult;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/** Tests for {@link ExceptionHandler}. */
public class ExceptionHandlerTest {

  @Rule public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testVerifyCaller() {
    class A implements Callable<Object> {
      @Override
      public Object call() throws IOException, InterruptedException {
        return null;
      }
    }

    class B extends A {}

    class C extends A {
      @Override
      public Object call() throws FileNotFoundException {
        return "c";
      }
    }

    class D extends C {
      @Override
      public Object call() throws IllegalArgumentException {
        return "d";
      }
    }

    class E extends A {
      @Override
      public String call() throws NullPointerException {
        return "e";
      }
    }

    class F extends A {
      @Override
      public Object call() throws Error {
        return "f";
      }
    }

    // using default exception handler (retry upon any non-runtime exceptions)
    ExceptionHandler handler = ExceptionHandler.getDefaultInstance();
    assertValidCallable(new A(), handler);
    assertValidCallable(new B(), handler);
    assertValidCallable(new C(), handler);
    assertValidCallable(new D(), handler);
    assertValidCallable(new E(), handler);
    assertInvalidCallable(new F(), handler);

    handler =
        ExceptionHandler.newBuilder()
            .retryOn(FileNotFoundException.class, NullPointerException.class)
            .build();
    assertInvalidCallable(new A(), handler);
    assertInvalidCallable(new B(), handler);
    assertValidCallable(new C(), handler);
    assertInvalidCallable(new D(), handler);
    assertValidCallable(new E(), handler);
    assertInvalidCallable(new F(), handler);
  }

  private static <T> void assertValidCallable(Callable<T> callable, ExceptionHandler handler) {
    handler.verifyCaller(callable);
  }

  private static <T> void assertInvalidCallable(Callable<T> callable, ExceptionHandler handler) {
    try {
      handler.verifyCaller(callable);
      fail("Expected RetryHelper constructor to fail");
    } catch (IllegalArgumentException ex) {
      // expected
    }
  }

  @Test
  public void testShouldTry() {
    ExceptionHandler handler = ExceptionHandler.newBuilder().retryOn(IOException.class).build();
    assertTrue(handler.shouldRetry(new IOException(), null));
    assertTrue(handler.shouldRetry(new ClosedByInterruptException(), null));
    assertFalse(handler.shouldRetry(new RuntimeException(), null));

    ExceptionHandler.Builder builder =
        ExceptionHandler.newBuilder()
            .retryOn(IOException.class, NullPointerException.class)
            .abortOn(
                RuntimeException.class,
                ClosedByInterruptException.class,
                InterruptedException.class);

    handler = builder.build();
    assertTrue(handler.shouldRetry(new IOException(), null));
    assertFalse(handler.shouldRetry(new ClosedByInterruptException(), null));
    assertFalse(handler.shouldRetry(new InterruptedException(), null));
    assertFalse(handler.shouldRetry(new RuntimeException(), null));
    assertTrue(handler.shouldRetry(new NullPointerException(), null));

    final AtomicReference<RetryResult> before = new AtomicReference<>(RetryResult.NO_RETRY);
    @SuppressWarnings("serial")
    Interceptor interceptor =
        new Interceptor() {

          @Override
          public RetryResult afterEval(Exception exception, RetryResult retryResult) {
            return retryResult == RetryResult.NO_RETRY ? RetryResult.RETRY : RetryResult.NO_RETRY;
          }

          @Override
          public RetryResult beforeEval(Exception exception) {
            return before.get();
          }
        };

    builder.addInterceptors(interceptor);
    handler = builder.build();
    assertFalse(handler.shouldRetry(new IOException(), null));
    assertFalse(handler.shouldRetry(new ClosedByInterruptException(), null));
    assertFalse(handler.shouldRetry(new InterruptedException(), null));
    assertFalse(handler.shouldRetry(new RuntimeException(), null));
    assertFalse(handler.shouldRetry(new NullPointerException(), null));

    before.set(RetryResult.RETRY);
    assertTrue(handler.shouldRetry(new IOException(), null));
    assertTrue(handler.shouldRetry(new ClosedByInterruptException(), null));
    assertTrue(handler.shouldRetry(new InterruptedException(), null));
    assertTrue(handler.shouldRetry(new RuntimeException(), null));
    assertTrue(handler.shouldRetry(new NullPointerException(), null));

    before.set(RetryResult.CONTINUE_EVALUATION);
    assertFalse(handler.shouldRetry(new IOException(), null));
    assertTrue(handler.shouldRetry(new ClosedByInterruptException(), null));
    assertTrue(handler.shouldRetry(new InterruptedException(), null));
    assertTrue(handler.shouldRetry(new RuntimeException(), null));
    assertFalse(handler.shouldRetry(new NullPointerException(), null));
  }

  @Test
  public void testNullRetryResultFromBeforeEval() {
    @SuppressWarnings("serial")
    Interceptor interceptor =
        new Interceptor() {

          @Override
          public RetryResult beforeEval(Exception exception) {
            return null;
          }

          @Override
          public RetryResult afterEval(Exception exception, RetryResult retryResult) {
            return RetryResult.CONTINUE_EVALUATION;
          }
        };

    ExceptionHandler handler = ExceptionHandler.newBuilder().addInterceptors(interceptor).build();
    thrown.expect(NullPointerException.class);
    handler.shouldRetry(new Exception(), null);
  }

  @Test
  public void testNullRetryResultFromAfterEval() {
    @SuppressWarnings("serial")
    Interceptor interceptor =
        new Interceptor() {

          @Override
          public RetryResult beforeEval(Exception exception) {
            return RetryResult.CONTINUE_EVALUATION;
          }

          @Override
          public RetryResult afterEval(Exception exception, RetryResult retryResult) {
            return null;
          }
        };

    ExceptionHandler handler = ExceptionHandler.newBuilder().addInterceptors(interceptor).build();
    thrown.expect(NullPointerException.class);
    handler.shouldRetry(new Exception(), null);
  }
}
