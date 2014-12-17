package com.google.gcloud;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;
import java.util.concurrent.Callable;

/**
 * Tests for {@link ExceptionHandler}.
 */
@RunWith(JUnit4.class)
public class ExceptionHandlerTest {

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
        return null;
      }
    }

    class D extends C {
      @Override
      public Object call() throws IllegalArgumentException {
        return null;
      }
    }

    class E extends A {
      @Override
      public String call() throws NullPointerException {
        return null;
      }
    }

    class F extends A {
      @Override
      public Object call() throws Error {
        return null;
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

    handler = ExceptionHandler.builder()
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
    ExceptionHandler handler = ExceptionHandler.builder().retryOn(IOException.class).build();
    assertTrue(handler.shouldRetry(new IOException()));
    assertTrue(handler.shouldRetry(new ClosedByInterruptException()));
    assertFalse(handler.shouldRetry(new RuntimeException()));

    handler = ExceptionHandler.builder()
        .retryOn(IOException.class, NullPointerException.class)
        .abortOn(RuntimeException.class, ClosedByInterruptException.class,
            InterruptedException.class)
        .build();
    assertTrue(handler.shouldRetry(new IOException()));
    assertFalse(handler.shouldRetry(new ClosedByInterruptException()));
    assertFalse(handler.shouldRetry(new InterruptedException()));
    assertFalse(handler.shouldRetry(new RuntimeException()));
    assertTrue(handler.shouldRetry(new NullPointerException()));
  }
}
