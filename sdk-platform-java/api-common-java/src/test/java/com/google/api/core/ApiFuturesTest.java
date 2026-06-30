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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.util.concurrent.MoreExecutors.directExecutor;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class ApiFuturesTest {

  @Test
  void testAddCallback() {
    final AtomicInteger flag = new AtomicInteger();
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<Integer>() {
          @Override
          public void onSuccess(Integer i) {
            flag.set(i + 1);
          }

          @Override
          public void onFailure(Throwable t) {
            flag.set(-1);
          }
        },
        directExecutor());
    future.set(0);
    assertThat(flag.get()).isEqualTo(1);
  }

  @Test
  void testCatch() throws Exception {
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    ApiFuture<Integer> fallback =
        ApiFutures.catching(
            future,
            Exception.class,
            new ApiFunction<Exception, Integer>() {
              @Override
              public Integer apply(Exception ex) {
                return 42;
              }
            },
            directExecutor());
    future.setException(new Exception());
    assertThat(fallback.get()).isEqualTo(42);
  }

  @Test
  void testCatchAsync() throws Exception {
    SettableApiFuture<Integer> future = SettableApiFuture.<Integer>create();
    ApiFuture<Integer> fallback =
        ApiFutures.catchingAsync(
            future,
            Exception.class,
            new ApiAsyncFunction<Exception, Integer>() {
              @Override
              public ApiFuture<Integer> apply(Exception ex) {
                return ApiFutures.immediateFuture(42);
              }
            },
            directExecutor());
    future.setException(new Exception());
    assertThat(fallback.get()).isEqualTo(42);
  }

  @Test
  void testTransform() throws Exception {
    SettableApiFuture<Integer> inputFuture = SettableApiFuture.<Integer>create();
    ApiFuture<String> transformedFuture =
        ApiFutures.transform(
            inputFuture,
            new ApiFunction<Integer, String>() {
              @Override
              public String apply(Integer input) {
                return input.toString();
              }
            },
            directExecutor());
    inputFuture.set(6);
    assertThat(transformedFuture.get()).isEqualTo("6");
  }

  @Test
  void testTransformWithExecutor() throws Exception {
    SettableApiFuture<Integer> inputFuture = SettableApiFuture.<Integer>create();
    final AtomicInteger counter = new AtomicInteger(0);
    ApiFuture<String> transformedFuture =
        ApiFutures.transform(
            inputFuture,
            new ApiFunction<Integer, String>() {
              @Override
              public String apply(Integer input) {
                return input.toString();
              }
            },
            new Executor() {
              @Override
              public void execute(Runnable command) {
                counter.incrementAndGet();
                command.run();
              }
            });
    inputFuture.set(6);
    assertThat(transformedFuture.get()).isEqualTo("6");
    assertThat(counter.get()).isEqualTo(1);
  }

  @Test
  void testAllAsList() throws Exception {
    SettableApiFuture<Integer> inputFuture1 = SettableApiFuture.<Integer>create();
    SettableApiFuture<Integer> inputFuture2 = SettableApiFuture.<Integer>create();
    ApiFuture<List<Integer>> listFuture =
        ApiFutures.allAsList(ImmutableList.of(inputFuture1, inputFuture2));
    inputFuture1.set(1);
    inputFuture2.set(2);
    assertThat(listFuture.get()).containsExactly(1, 2).inOrder();
  }

  @Test
  void successfulAllAsList() throws Exception {
    SettableApiFuture<Integer> inputFuture1 = SettableApiFuture.<Integer>create();
    SettableApiFuture<Integer> inputFuture2 = SettableApiFuture.<Integer>create();
    ApiFuture<List<Integer>> listFuture =
        ApiFutures.successfulAsList(ImmutableList.of(inputFuture1, inputFuture2));
    inputFuture1.set(1);
    inputFuture2.setException(new Exception());
    assertThat(listFuture.get()).containsExactly(1, null).inOrder();
  }

  @Test
  void testTransformAsync() throws Exception {
    ApiFuture<Integer> inputFuture = ApiFutures.immediateFuture(0);
    ApiFuture<Integer> outputFuture =
        ApiFutures.transformAsync(
            inputFuture,
            new ApiAsyncFunction<Integer, Integer>() {
              @Override
              public ApiFuture<Integer> apply(Integer input) {
                return ApiFutures.immediateFuture(input + 1);
              }
            },
            directExecutor());
    assertThat(outputFuture.get()).isEqualTo(1);
  }

  @Test
  void testTransformAsyncWithExecutor() throws Exception {
    ApiFuture<Integer> inputFuture = ApiFutures.immediateFuture(0);
    final AtomicInteger counter = new AtomicInteger(0);
    ApiFuture<Integer> outputFuture =
        ApiFutures.transformAsync(
            inputFuture,
            (ApiAsyncFunction<Integer, Integer>) input -> ApiFutures.immediateFuture(input + 1),
            (Executor)
                command -> {
                  counter.incrementAndGet();
                  command.run();
                });
    assertThat(outputFuture.get()).isEqualTo(1);
    assertThat(counter.get()).isEqualTo(1);
  }

  @Test
  void testImmediateFailedFuture() throws InterruptedException {
    ApiFuture<String> future =
        ApiFutures.immediateFailedFuture(new IllegalArgumentException("The message"));
    IllegalArgumentException exception = null;
    try {
      future.get();
    } catch (ExecutionException e) {
      exception = (IllegalArgumentException) e.getCause();
    }
    assertThat(exception).isNotNull();
    assertThat(exception.getMessage()).isEqualTo("The message");
  }

  @Test
  void testImmediateCancelledFuture() throws InterruptedException, ExecutionException {
    ApiFuture<String> future = ApiFutures.immediateCancelledFuture();
    CancellationException exception = null;
    try {
      future.get();
    } catch (CancellationException e) {
      exception = e;
    }
    assertThat(exception).isNotNull();
  }
}
