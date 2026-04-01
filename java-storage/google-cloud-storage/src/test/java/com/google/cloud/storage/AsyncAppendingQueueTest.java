/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.cloud.storage.AsyncAppendingQueue.ShortCircuitException;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public final class AsyncAppendingQueueTest {

  private static ExecutorService exec;

  @BeforeClass
  public static void beforeClass() {
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setDaemon(true).setNameFormat("test-aaqt-%d").build();
    exec = Executors.newCachedThreadPool(threadFactory);
  }

  @AfterClass
  public static void afterClass() {
    if (exec != null) {
      exec.shutdownNow();
    }
  }

  @Test
  public void attemptingToAppendAfterClose_errors() {
    Executor exec = MoreExecutors.newDirectExecutorService();
    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 3, AsyncAppendingQueueTest::agg);

    q.append(ApiFutures.immediateFuture("a"));
    q.close();

    IllegalStateException iae =
        assertThrows(IllegalStateException.class, () -> q.append(ApiFutures.immediateFuture("b")));

    assertThat(iae).hasMessageThat().contains("closed");
  }

  @Test
  public void getResultPendingUntilClose()
      throws ExecutionException, InterruptedException, TimeoutException {
    Executor exec = MoreExecutors.newDirectExecutorService();
    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 3, AsyncAppendingQueueTest::agg);

    q.append(ApiFutures.immediateFuture("a"));
    ApiFuture<String> result = q.getResult();
    assertThrows(TimeoutException.class, () -> result.get(3, TimeUnit.MILLISECONDS));
    q.close();
    String s = result.get(10, TimeUnit.MILLISECONDS);

    assertThat(s).isEqualTo("a");
  }

  @Test
  public void getResultAlwaysReturnsTheSameFuture() {
    Executor exec = MoreExecutors.newDirectExecutorService();
    try (AsyncAppendingQueue<String> q =
        AsyncAppendingQueue.of(exec, 3, AsyncAppendingQueueTest::agg)) {

      q.append(ApiFutures.immediateFuture("a"));
      ApiFuture<String> result1 = q.getResult();
      ApiFuture<String> result2 = q.getResult();

      assertThat(result1).isSameInstanceAs(result2);
    }
  }

  @Test
  public void closingWithoutAppending_throwNoSuchElementException() {
    Executor exec = MoreExecutors.newDirectExecutorService();
    //noinspection resource
    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 3, AsyncAppendingQueueTest::agg);

    ApiFuture<String> result = q.getResult();
    NoSuchElementException nse1 = assertThrows(NoSuchElementException.class, q::close);
    NoSuchElementException nse2 =
        assertThrows(
            NoSuchElementException.class, () -> ApiExceptions.callAndTranslateApiException(result));

    assertThat(nse1).hasMessageThat().contains("Never appended to");
    assertThat(nse2).hasMessageThat().contains("Never appended to");
  }

  @SuppressWarnings("resource")
  @Test
  public void factoryMethodMustNotAccept_nullExecutor() {
    assertThrows(NullPointerException.class, () -> AsyncAppendingQueue.of(null, 5, null));
  }

  @SuppressWarnings("resource")
  @Test
  public void factoryMethodMustNotAccept_maxElementsPerCompact_lte_1() {
    Executor exec = MoreExecutors.newDirectExecutorService();
    assertThrows(IllegalArgumentException.class, () -> AsyncAppendingQueue.of(exec, 1, null));
    assertThrows(IllegalArgumentException.class, () -> AsyncAppendingQueue.of(exec, 0, null));
    assertThrows(IllegalArgumentException.class, () -> AsyncAppendingQueue.of(exec, -10, null));
  }

  @Test
  public void happyPath() throws Exception {
    int arity = 2;
    ApiFuture<String> result;

    try (AsyncAppendingQueue<String> q =
        AsyncAppendingQueue.of(exec, arity, AsyncAppendingQueueTest::agg)) {

      q.append(immediate("a"))
          .append(immediate("b"))
          .append(immediate("c"))
          .append(immediate("d"))
          .append(immediate("e"))
          .append(immediate("f"))
          .append(immediate("g"));

      result = q.getResult();
    }
    assertThat(result).isNotNull();
    String s = result.get();
    assertThat(s).isEqualTo("abcdefg");
  }

  @Test
  public void appendShouldShortCircuit() {
    Executor exec = MoreExecutors.newDirectExecutorService();

    AtomicInteger aggCounter = new AtomicInteger(0);
    ApiFunction<ImmutableList<String>, String> agg =
        ss -> {
          aggCounter.getAndIncrement();
          return agg(ss);
        };

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 5, agg);
    q.append(immediate("a")).append(immediate("b")).append(immediate("c"));

    q.append(ApiFutures.immediateFailedFuture(new Kaboom()));

    assertThrows(ShortCircuitException.class, () -> q.append(immediate("d")));
    assertThrows(CancellationException.class, q::await);

    q.close();

    assertThat(aggCounter.get()).isEqualTo(0);
  }

  @Test
  public void resultFailureIfLastAppendFutureFails() {

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 2, AsyncAppendingQueueTest::agg);
    SettableApiFuture<String> d = SettableApiFuture.create();
    q.append(immediate("a"))
        .append(immediate("b"))
        .append(immediate("b"))
        .append(immediate("c"))
        .append(d);

    q.close();
    d.setException(new Kaboom());
    assertThrows(Kaboom.class, q::await);
  }

  @Test
  public void resultFailureIfFinalCompactFails() {
    ApiFunction<ImmutableList<String>, String> agg =
        ss -> {
          if (ss.equals(ImmutableList.of("abc", "d"))) {
            throw new Kaboom();
          } else {
            return agg(ss);
          }
        };

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 2, agg);
    q.append(immediate("a")).append(immediate("b")).append(immediate("c")).append(immediate("d"));

    q.close();
    assertThrows(Kaboom.class, q::await);
  }

  @Test
  public void append_multipleFailingFuturesWillAlwaysReturnTheFirstFailure() {

    // define a couple futures that will fail later
    SettableApiFuture<String> b = SettableApiFuture.create();
    SettableApiFuture<String> c = SettableApiFuture.create();

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 6, AsyncAppendingQueueTest::agg);
    q.append(immediate("a")).append(b).append(c).append(immediate("d"));

    b.setException(new Kaboom());
    c.setException(new RuntimeException());
    q.close();

    assertThrows(Kaboom.class, q::await);
  }

  @Test
  public void shortCircuitOnlyHappensBeforeClose_affirmative() {
    Executor exec = MoreExecutors.newDirectExecutorService();

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 5, AsyncAppendingQueueTest::agg);
    q.append(immediate("a"));
    q.append(ApiFutures.immediateFailedFuture(new Kaboom()));

    assertThrows(ShortCircuitException.class, () -> q.append(immediate("d")));
    assertThrows(CancellationException.class, q::await);

    q.close();
  }

  @Test
  public void shortCircuitOnlyHappensBeforeClose_negative() {

    AsyncAppendingQueue<String> q = AsyncAppendingQueue.of(exec, 5, AsyncAppendingQueueTest::agg);
    q.append(immediate("a"));
    SettableApiFuture<String> d = SettableApiFuture.create();
    q.append(d);

    q.close();
    d.setException(new Kaboom());

    assertThrows(Kaboom.class, q::await);
  }

  static String agg(ImmutableList<String> ss) {
    return ss.stream().reduce("", String::concat);
  }

  static ApiFuture<String> immediate(String s) {
    return ApiFutures.immediateFuture(s);
  }

  private static final class Kaboom extends RuntimeException {
    private Kaboom() {
      super("Kaboom!!!");
    }
  }
}
