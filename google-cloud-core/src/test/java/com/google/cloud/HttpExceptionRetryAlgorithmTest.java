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

package com.google.cloud;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.HttpExceptionRetryAlgorithm.Interceptor;
import com.google.cloud.HttpExceptionRetryAlgorithm.Interceptor.RetryResult;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Tests for {@link HttpExceptionRetryAlgorithm}.
 */
public class HttpExceptionRetryAlgorithmTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testVerifyCaller() {
    class A implements Callable<Object> {
      @Override
      public Object call() throws IOException, InterruptedException {
        return null;
      }
    }

    class B extends A {
    }

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
    HttpExceptionRetryAlgorithm handler = HttpExceptionRetryAlgorithm.getDefaultInstance();
    assertValidCallable(new A(), handler);
    assertValidCallable(new B(), handler);
    assertValidCallable(new C(), handler);
    assertValidCallable(new D(), handler);
    assertValidCallable(new E(), handler);
    assertInvalidCallable(new F(), handler);

    handler = HttpExceptionRetryAlgorithm.newBuilder()
        .retryOn(FileNotFoundException.class, NullPointerException.class)
        .build();
    assertInvalidCallable(new A(), handler);
    assertInvalidCallable(new B(), handler);
    assertValidCallable(new C(), handler);
    assertInvalidCallable(new D(), handler);
    assertValidCallable(new E(), handler);
    assertInvalidCallable(new F(), handler);
  }

  private static <T> void assertValidCallable(Callable<T> callable, HttpExceptionRetryAlgorithm handler) {
    handler.verifyCaller(callable);
  }

  private static <T> void assertInvalidCallable(Callable<T> callable, HttpExceptionRetryAlgorithm handler) {
    try {
      handler.verifyCaller(callable);
      fail("Expected RetryHelper constructor to fail");
    } catch (IllegalArgumentException ex) {
      // expected
    }
  }

  @Test
  public void testShouldTry() {
    HttpExceptionRetryAlgorithm handler = HttpExceptionRetryAlgorithm.newBuilder().retryOn(IOException.class).build();
    assertTrue(handler.accept(new IOException()));
    assertTrue(handler.accept(new ClosedByInterruptException()));
    assertFalse(handler.accept(new RuntimeException()));

    HttpExceptionRetryAlgorithm.Builder builder = HttpExceptionRetryAlgorithm.newBuilder()
        .retryOn(IOException.class, NullPointerException.class)
        .abortOn(RuntimeException.class, ClosedByInterruptException.class,
            InterruptedException.class);

    handler = builder.build();
    assertTrue(handler.accept(new IOException()));
    assertFalse(handler.accept(new ClosedByInterruptException()));
    assertFalse(handler.accept(new InterruptedException()));
    assertFalse(handler.accept(new RuntimeException()));
    assertTrue(handler.accept(new NullPointerException()));

    final AtomicReference<RetryResult> before = new AtomicReference<>(RetryResult.NO_RETRY);
    @SuppressWarnings("serial")
    Interceptor interceptor = new Interceptor() {

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
    assertFalse(handler.accept(new IOException()));
    assertFalse(handler.accept(new ClosedByInterruptException()));
    assertFalse(handler.accept(new InterruptedException()));
    assertFalse(handler.accept(new RuntimeException()));
    assertFalse(handler.accept(new NullPointerException()));

    before.set(RetryResult.RETRY);
    assertTrue(handler.accept(new IOException()));
    assertTrue(handler.accept(new ClosedByInterruptException()));
    assertTrue(handler.accept(new InterruptedException()));
    assertTrue(handler.accept(new RuntimeException()));
    assertTrue(handler.accept(new NullPointerException()));

    before.set(RetryResult.CONTINUE_EVALUATION);
    assertFalse(handler.accept(new IOException()));
    assertTrue(handler.accept(new ClosedByInterruptException()));
    assertTrue(handler.accept(new InterruptedException()));
    assertTrue(handler.accept(new RuntimeException()));
    assertFalse(handler.accept(new NullPointerException()));
  }

  @Test
  public void testNullRetryResultFromBeforeEval() {
    @SuppressWarnings("serial")
    Interceptor interceptor = new Interceptor() {

      @Override
      public RetryResult beforeEval(Exception exception) {
        return null;
      }

      @Override
      public RetryResult afterEval(Exception exception, RetryResult retryResult) {
        return RetryResult.CONTINUE_EVALUATION;
      }

    };

    HttpExceptionRetryAlgorithm handler = HttpExceptionRetryAlgorithm.newBuilder().addInterceptors(interceptor).build();
    thrown.expect(NullPointerException.class);
    handler.accept(new Exception());
  }

  @Test
  public void testNullRetryResultFromAfterEval() {
    @SuppressWarnings("serial")
    Interceptor interceptor = new Interceptor() {

      @Override
      public RetryResult beforeEval(Exception exception) {
        return RetryResult.CONTINUE_EVALUATION;
      }

      @Override
      public RetryResult afterEval(Exception exception, RetryResult retryResult) {
        return null;
      }

    };

    HttpExceptionRetryAlgorithm handler = HttpExceptionRetryAlgorithm.newBuilder().addInterceptors(interceptor).build();
    thrown.expect(NullPointerException.class);
    handler.accept(new Exception());
  }
}
