/*
 * Copyright 2017, Google Inc.
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
 *     * Neither the name of Google Inc. nor the names of its
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
package com.google.api.core;

import com.google.common.truth.Truth;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SettableApiFutureTest {
  @Test
  void testSet() throws Exception {
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    Truth.assertThat(future.isDone()).isFalse();
    future.set(42);
    Truth.assertThat(future.get()).isEqualTo(42);
    Truth.assertThat(future.get(1, TimeUnit.HOURS)).isEqualTo(42);
    Truth.assertThat(future.isDone()).isTrue();
  }

  @Test
  void testCancel() {
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    Truth.assertThat(future.isDone()).isFalse();
    Truth.assertThat(future.isCancelled()).isFalse();
    future.cancel(false);
    Truth.assertThat(future.isDone()).isTrue();
    Truth.assertThat(future.isCancelled()).isTrue();
  }

  @Test
  void testException() {
    Assertions.assertThrows(
        ExecutionException.class,
        () -> {
          SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
          future.setException(new Exception());
          future.get();
        });
  }

  @Test
  void testListener() {
    final AtomicInteger flag = new AtomicInteger();
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    future.addListener(
        new Runnable() {
          @Override
          public void run() {
            flag.set(1);
          }
        },
        new Executor() {
          @Override
          public void execute(Runnable r) {
            r.run();
          }
        });
    future.set(0);
    Truth.assertThat(flag.get()).isEqualTo(1);
  }

  @Test
  void testCompletableApplied() {
    final AtomicInteger flag = new AtomicInteger();
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    future.completable(
        new Executor() {
          @Override
          public void execute(Runnable r) {
            r.run();
          }
        }).handle(
        new BiFunction<Integer, Throwable, Object>() {
          @Override
          public Object apply(Integer integer, Throwable throwable) {
            flag.set(1);
            return null;
          }
        });
    future.set(0);
    Truth.assertThat(flag.get()).isEqualTo(1);
  }

  @Test
  void testCompletableSuccess() throws Exception {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    Truth.assertThat(completable.isDone()).isFalse();
    future.set(42);
    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.get()).isEqualTo(42);
  }

  @Test
  void testCompletableException() {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    Exception expectedException = new IllegalArgumentException("something failed");
    future.setException(expectedException);

    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.isCompletedExceptionally()).isTrue();
    ExecutionException thrown =
        Assertions.assertThrows(ExecutionException.class, completable::get);
    Truth.assertThat(thrown.getCause()).isSameInstanceAs(expectedException);
  }

  @Test
  void testCompletableCancelApiFutureCancelsCompletableFuture() {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    future.cancel(false);

    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.isCancelled()).isTrue();
    Assertions.assertThrows(CancellationException.class, completable::get);
  }

  @Test
  void testCompletableCancelCompletableFutureCancelsApiFuture() {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    completable.cancel(true);

    Truth.assertThat(future.isDone()).isTrue();
    Truth.assertThat(future.isCancelled()).isTrue();
    Assertions.assertThrows(CancellationException.class, future::get);
  }

  @Test
  void testCompletableAlreadyCompleted() throws Exception {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    future.set(100);

    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.get()).isEqualTo(100);
  }

  @Test
  void testCompletableAlreadyFailed() {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    RuntimeException expectedException = new RuntimeException("pre-failed");
    future.setException(expectedException);

    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.isCompletedExceptionally()).isTrue();
    ExecutionException thrown =
        Assertions.assertThrows(ExecutionException.class, completable::get);
    Truth.assertThat(thrown.getCause()).isSameInstanceAs(expectedException);
  }

  @Test
  void testCompletableAlreadyCancelled() {
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    future.cancel(false);

    CompletableFuture<Integer> completable = future.completable(Runnable::run);

    Truth.assertThat(completable.isDone()).isTrue();
    Truth.assertThat(completable.isCancelled()).isTrue();
  }

  @Test
  void testCompletableUsesExecutor() {
    AtomicBoolean executorRan = new AtomicBoolean(false);
    SettableApiFuture<Integer> future = SettableApiFuture.create();
    CompletableFuture<Integer> completable =
        future.completable(
            command -> {
              executorRan.set(true);
              command.run();
            });

    Truth.assertThat(executorRan.get()).isFalse();
    future.set(7);
    Truth.assertThat(executorRan.get()).isTrue();
    Truth.assertThat(completable.isDone()).isTrue();
  }
}
