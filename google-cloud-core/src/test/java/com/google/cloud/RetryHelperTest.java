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

import static java.util.concurrent.Executors.callable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.RetryHelper.NonRetriableException;
import com.google.cloud.RetryHelper.RetriesExhaustedException;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Tests for {@link RetryHelper}.
 */
public class RetryHelperTest {

  static class E1Exception extends Exception {
    private static final long serialVersionUID = 3874933713392137001L;
  }

  static class E2Exception extends E1Exception {
    private static final long serialVersionUID = -8710227162480133598L;
  }

  static class E3Exception extends E1Exception {
    private static final long serialVersionUID = -7794256022024001666L;
  }

  static class E4Exception extends E2Exception {
    private static final long serialVersionUID = -5508018234693709156L;
  }

  @Test
  public void testTriesWithExceptionHandling() {
    assertNull(RetryHelper.getContext());
    RetryParams params =
        RetryParams.newBuilder().setInitialRetryDelayMillis(0).setRetryMaxAttempts(3).build();
    ExceptionHandler handler = ExceptionHandler.newBuilder()
        .retryOn(IOException.class).abortOn(RuntimeException.class).build();
    final AtomicInteger count = new AtomicInteger(3);
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws IOException, NullPointerException {
          if (count.decrementAndGet() == 2) {
            assertEquals(1, RetryHelper.getContext().getAttemptNumber());
            throw new IOException("should be retried");
          }
          assertEquals(2, RetryHelper.getContext().getAttemptNumber());
          throw new NullPointerException("Boo!");
        }
      }, params, handler);
      fail("Exception should have been thrown");
    } catch (NonRetriableException ex) {
      assertEquals("Boo!", ex.getCause().getMessage());
      assertEquals(1, count.intValue());
    }
    assertNull(RetryHelper.getContext());

    params = RetryParams.newBuilder().setInitialRetryDelayMillis(0).setRetryMaxAttempts(5).build();
    handler = ExceptionHandler.newBuilder()
        .retryOn(E1Exception.class, E4Exception.class)
        .abortOn(E3Exception.class).build();
    final Iterator<? extends E1Exception> exceptions = Arrays.asList(
        new E1Exception(), new E2Exception(), new E4Exception(), new E3Exception()).iterator();
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws E1Exception {
          throw exceptions.next();
        }
      }, params, handler);
      fail("Exception should have been thrown");
    } catch (NonRetriableException ex) {
      assertTrue(ex.getCause() instanceof E3Exception);
    }
    assertNull(RetryHelper.getContext());
  }

  @Test
  public void testTriesWithExceptionHandlingDeprecated() {
    assertNull(RetryHelper.getContext());
    RetryParams params =
        RetryParams.builder().initialRetryDelayMillis(0).retryMaxAttempts(3).build();
    ExceptionHandler handler = ExceptionHandler.builder()
        .retryOn(IOException.class).abortOn(RuntimeException.class).build();
    final AtomicInteger count = new AtomicInteger(3);
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws IOException, NullPointerException {
          if (count.decrementAndGet() == 2) {
            assertEquals(1, RetryHelper.getContext().getAttemptNumber());
            throw new IOException("should be retried");
          }
          assertEquals(2, RetryHelper.getContext().getAttemptNumber());
          throw new NullPointerException("Boo!");
        }
      }, params, handler);
      fail("Exception should have been thrown");
    } catch (NonRetriableException ex) {
      assertEquals("Boo!", ex.getCause().getMessage());
      assertEquals(1, count.intValue());
    }
    assertNull(RetryHelper.getContext());

    params = RetryParams.builder().initialRetryDelayMillis(0).retryMaxAttempts(5).build();
    handler = ExceptionHandler.builder()
        .retryOn(E1Exception.class, E4Exception.class)
        .abortOn(E3Exception.class).build();
    final Iterator<? extends E1Exception> exceptions = Arrays.asList(
        new E1Exception(), new E2Exception(), new E4Exception(), new E3Exception()).iterator();
    try {
      RetryHelper.runWithRetries(new Callable<Void>() {
        @Override public Void call() throws E1Exception {
          throw exceptions.next();
        }
      }, params, handler);
      fail("Exception should have been thrown");
    } catch (NonRetriableException ex) {
      assertTrue(ex.getCause() instanceof E3Exception);
    }
    assertNull(RetryHelper.getContext());
  }

  @Test
  public void testTriesAtLeastMinTimes() {
    // Total retry period set to 60 seconds so as to not factor into test
    RetryParams params = RetryParams.newBuilder().setInitialRetryDelayMillis(0)
        .setTotalRetryPeriodMillis(60000)
        .setRetryMinAttempts(5)
        .setRetryMaxAttempts(10)
        .build();
    final int timesToFail = 7;
    assertNull(RetryHelper.getContext());
    int attempted = RetryHelper.runWithRetries(new Callable<Integer>() {
      int timesCalled;
      @Override public Integer call() throws IOException {
        timesCalled++;
        assertEquals(timesCalled, RetryHelper.getContext().getAttemptNumber());
        assertEquals(10, RetryHelper.getContext().getRetryParams().getRetryMaxAttempts());
        if (timesCalled <= timesToFail) {
          throw new IOException();
        }
        return timesCalled;
      }
    }, params, ExceptionHandler.getDefaultInstance());
    assertEquals(timesToFail + 1, attempted);
    assertNull(RetryHelper.getContext());
  }

  @Test
  public void testTriesAtLeastMinTimesDeprecated() {
    // Total retry period set to 60 seconds so as to not factor into test
    RetryParams params = RetryParams.builder().initialRetryDelayMillis(0)
        .totalRetryPeriodMillis(60000)
        .retryMinAttempts(5)
        .retryMaxAttempts(10)
        .build();
    final int timesToFail = 7;
    assertNull(RetryHelper.getContext());
    int attempted = RetryHelper.runWithRetries(new Callable<Integer>() {
      int timesCalled;
      @Override public Integer call() throws IOException {
        timesCalled++;
        assertEquals(timesCalled, RetryHelper.getContext().getAttemptNumber());
        assertEquals(10, RetryHelper.getContext().getRetryParams().retryMaxAttempts());
        if (timesCalled <= timesToFail) {
          throw new IOException();
        }
        return timesCalled;
      }
    }, params, ExceptionHandler.defaultInstance());
    assertEquals(timesToFail + 1, attempted);
    assertNull(RetryHelper.getContext());
  }

  @Test
  public void testTriesNoMoreThanMaxTimes() {
    // Total retry period set to 60 seconds so as to not factor into test
    final int maxAttempts = 10;
    RetryParams params = RetryParams.newBuilder().setInitialRetryDelayMillis(0)
        .setTotalRetryPeriodMillis(60000)
        .setRetryMinAttempts(0)
        .setRetryMaxAttempts(maxAttempts)
        .build();
    final AtomicInteger timesCalled = new AtomicInteger(0);
    try {
      RetryHelper.runWithRetries(callable(new Runnable() {
        @Override public void run() {
          // Throw an exception up to maxAttempts times, should never be called beyond that
          if (timesCalled.incrementAndGet() <= maxAttempts) {
            throw new RuntimeException();
          }
          fail("Body was executed too many times: " + timesCalled.get());
        }
      }), params, ExceptionHandler.newBuilder().retryOn(RuntimeException.class).build());
      // Unnecessary as this line should not be possible reach even if RetryHandler is broken
      fail("Should not have succeeded, expected all attempts to fail and give up.");
    } catch (RetriesExhaustedException expected) {
      // Expect the body to run exactly maxAttempts times
      assertEquals(maxAttempts, timesCalled.get());
    }
  }

  @Test
  public void testTriesNoMoreThanMaxTimesDeprecated() {
    // Total retry period set to 60 seconds so as to not factor into test
    final int maxAttempts = 10;
    RetryParams params = RetryParams.builder().initialRetryDelayMillis(0)
        .totalRetryPeriodMillis(60000)
        .retryMinAttempts(0)
        .retryMaxAttempts(maxAttempts)
        .build();
    final AtomicInteger timesCalled = new AtomicInteger(0);
    try {
      RetryHelper.runWithRetries(callable(new Runnable() {
        @Override public void run() {
          // Throw an exception up to maxAttempts times, should never be called beyond that
          if (timesCalled.incrementAndGet() <= maxAttempts) {
            throw new RuntimeException();
          }
          fail("Body was executed too many times: " + timesCalled.get());
        }
      }), params, ExceptionHandler.builder().retryOn(RuntimeException.class).build());
      // Unnecessary as this line should not be possible reach even if RetryHandler is broken
      fail("Should not have succeeded, expected all attempts to fail and give up.");
    } catch (RetriesExhaustedException expected) {
      // Expect the body to run exactly maxAttempts times
      assertEquals(maxAttempts, timesCalled.get());
    }
  }

  private static class FakeClock extends Clock {

    private final AtomicLong millis = new AtomicLong();

    // Advances the clock value by {@code time} in {@code timeUnit}.
    void advance(long time, TimeUnit timeUnit) {
      millis.addAndGet(timeUnit.toMillis(time));
    }

    @Override
    public long millis() {
      return millis.get();
    }
  }

  @Test
  public void testTriesNoMoreLongerThanTotalRetryPeriod() {
    final FakeClock fakeClock = new FakeClock();
    // The 8th attempt (after min and before max) will trigger a 1 second (virtual) delay exceeding
    // total retry period which is set just under 1 second. Test occurs faster than realtime.
    RetryParams params = RetryParams.newBuilder().setInitialRetryDelayMillis(0)
        .setTotalRetryPeriodMillis(999)
        .setRetryMinAttempts(5)
        .setRetryMaxAttempts(10)
        .build();
    ExceptionHandler handler = ExceptionHandler.newBuilder().retryOn(RuntimeException.class).build();
    final int sleepOnAttempt = 8;
    final AtomicInteger timesCalled = new AtomicInteger(0);
    try {
      RetryHelper.runWithRetries(callable(new Runnable() {
        @Override public void run() {
          timesCalled.incrementAndGet();
          if (timesCalled.get() == sleepOnAttempt) {
            fakeClock.advance(1000, TimeUnit.MILLISECONDS);
          }
          throw new RuntimeException();
        }
      }), params, handler, fakeClock);
      fail();
    } catch (RetriesExhaustedException expected) {
      // verify timesCalled
      assertEquals(sleepOnAttempt, timesCalled.get());
    }
  }

  @Test
  public void testBackoffIsExponential() {
    // Total retry period set to 60 seconds so as to not factor into test
    RetryParams params = RetryParams.newBuilder()
        .setInitialRetryDelayMillis(10)
        .setMaxRetryDelayMillis(10_000_000)
        .setRetryDelayBackoffFactor(2)
        .setTotalRetryPeriodMillis(60_000)
        .setRetryMinAttempts(0)
        .setRetryMaxAttempts(100)
        .build();
    long sleepDuration = RetryHelper.getSleepDuration(params, 1);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 13 && sleepDuration >= 7);
    sleepDuration = RetryHelper.getSleepDuration(params, 2);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 25 && sleepDuration >= 15);
    sleepDuration = RetryHelper.getSleepDuration(params, 3);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 50 && sleepDuration >= 30);
    sleepDuration = RetryHelper.getSleepDuration(params, 4);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 100 && sleepDuration >= 60);
    sleepDuration = RetryHelper.getSleepDuration(params, 5);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 200 && sleepDuration >= 120);
    sleepDuration = RetryHelper.getSleepDuration(params, 6);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 400 && sleepDuration >= 240);
    sleepDuration = RetryHelper.getSleepDuration(params, 7);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 800 && sleepDuration >= 480);
    sleepDuration = RetryHelper.getSleepDuration(params, 8);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 1600 && sleepDuration >= 960);
    sleepDuration = RetryHelper.getSleepDuration(params, 9);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 3200 && sleepDuration >= 1920);
    sleepDuration = RetryHelper.getSleepDuration(params, 10);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 6400 && sleepDuration >= 3840);
    sleepDuration = RetryHelper.getSleepDuration(params, 11);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 12800 && sleepDuration >= 7680);
    sleepDuration = RetryHelper.getSleepDuration(params, 12);
    assertTrue(String.valueOf(sleepDuration), sleepDuration < 25600 && sleepDuration >= 15360);
  }

  @Test
  public void testNestedUsage() {
    assertEquals((1 + 3) * 2, invokeNested(3, 2));
  }

  private int invokeNested(final int level, final int retries) {
    if (level < 0) {
      return 0;
    }
    return RetryHelper.runWithRetries(new Callable<Integer>() {
      @Override
      public Integer call() throws IOException {
        if (RetryHelper.getContext().getAttemptNumber() < retries) {
          throw new IOException();
        }
        assertEquals(retries, RetryHelper.getContext().getAttemptNumber());
        return invokeNested(level - 1, retries) + RetryHelper.getContext().getAttemptNumber();
      }
    });
  }

}
