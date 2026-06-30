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
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
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
}
