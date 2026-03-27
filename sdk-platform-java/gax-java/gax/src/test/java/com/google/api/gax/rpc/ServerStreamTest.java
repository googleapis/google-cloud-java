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
package com.google.api.gax.rpc;

import com.google.api.gax.rpc.testing.MockStreamingApi.MockStreamController;
import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ServerStreamTest {
  private ServerStream<Integer> stream;
  private MockStreamController<Integer> controller;
  private ExecutorService executor;

  @BeforeEach
  void setUp() {
    stream = new ServerStream<>();
    controller = new MockStreamController<>(stream.observer());

    stream.observer().onStart(controller);
    executor = Executors.newCachedThreadPool();
  }

  @AfterEach
  void tearDown() {
    executor.shutdownNow();
  }

  @Test
  void testEmptyStream() {
    stream.observer().onComplete();

    Truth.assertThat(Lists.newArrayList(stream)).isEmpty();
  }

  @Test
  void testMultipleItemStream() throws Exception {
    Future<Void> producerFuture =
        executor.submit(
            () -> {
              for (int i = 0; i < 5; i++) {
                int requestCount = controller.popLastPull();

                Truth.assertWithMessage("ServerStream should request one item at a time")
                    .that(requestCount)
                    .isEqualTo(1);

                stream.observer().onResponse(i);
              }
              stream.observer().onComplete();
              return null;
            });

    Future<List<Integer>> consumerFuture = executor.submit(() -> Lists.newArrayList(stream));

    producerFuture.get(60, TimeUnit.SECONDS);
    List<Integer> results = consumerFuture.get();
    Truth.assertThat(results).containsExactly(0, 1, 2, 3, 4);
  }

  @Test
  void testMultipleItemStreamMethod() throws Exception {
    Future<Void> producerFuture =
        executor.submit(
            () -> {
              for (int i = 0; i < 5; i++) {
                int requestCount = controller.popLastPull();

                Truth.assertWithMessage("ServerStream should request one item at a time")
                    .that(requestCount)
                    .isEqualTo(1);

                stream.observer().onResponse(i);
              }
              stream.observer().onComplete();
              return null;
            });
    Future<List<Integer>> consumerFuture =
        executor.submit(() -> stream.stream().collect(Collectors.toList()));

    producerFuture.get(60, TimeUnit.SECONDS);
    List<Integer> results = consumerFuture.get();
    Truth.assertThat(results).containsExactly(0, 1, 2, 3, 4);
  }

  @Test
  void testEarlyTermination() throws Exception {
    Future<Void> taskFuture =
        executor.submit(
            () -> {
              int i = 0;
              while (controller.popLastPull() > 0) {
                stream.observer().onResponse(i++);
              }
              controller.waitForCancel();
              stream.observer().onError(new CancellationException("cancelled"));
              return null;
            });

    List<Integer> results = Lists.newArrayList();
    for (Integer result : stream) {
      results.add(result);

      if (result == 1) {
        stream.cancel();
      }
    }

    taskFuture.get(30, TimeUnit.SECONDS);

    Truth.assertThat(results).containsExactly(0, 1);
  }

  @Test
  void testErrorPropagation() {
    ClassCastException e = new ClassCastException("fake error");

    stream.observer().onError(e);

    Throwable actualError = null;
    try {
      Truth.assertThat(Lists.newArrayList(stream)).isNotNull();
    } catch (Throwable t) {
      actualError = t;
    }

    Truth.assertThat(actualError).hasMessageThat().contains(e.getMessage());
    Truth.assertThat(actualError).isEqualTo(e);
  }

  @Test
  void testNoErrorsBetweenHasNextAndNext() {
    Iterator<Integer> it = stream.iterator();

    controller.popLastPull();
    stream.observer().onResponse(1);

    Truth.assertThat(it.hasNext()).isTrue();

    RuntimeException fakeError = new RuntimeException("fake");
    stream.observer().onError(fakeError);
    Truth.assertThat(it.next()).isEqualTo(1);

    // Now the error should be thrown
    try {
      it.next();
      throw new RuntimeException("ServerStream never threw an error!");
    } catch (RuntimeException e) {
      Truth.assertThat(e).isSameInstanceAs(fakeError);
    }
  }

  @Test
  void testReady() {
    Iterator<Integer> it = stream.iterator();
    Truth.assertThat(stream.isReceiveReady()).isFalse();

    controller.popLastPull();
    stream.observer().onResponse(1);
    Truth.assertThat(stream.isReceiveReady()).isTrue();

    it.next();
    Truth.assertThat(stream.isReceiveReady()).isFalse();
  }

  @Test
  void testNextAfterEOF() {
    Iterator<Integer> it = stream.iterator();
    stream.observer().onComplete();

    // Precondition
    Truth.assertThat(it.hasNext()).isFalse();

    Throwable actualError = null;
    try {
      it.next();
    } catch (Throwable t) {
      actualError = t;
    }
    Truth.assertThat(actualError).isInstanceOf(NoSuchElementException.class);
  }

  @Test
  void testAfterError() {
    Iterator<Integer> it = stream.iterator();

    RuntimeException expectError = new RuntimeException("my upstream error");
    stream.observer().onError(expectError);

    Throwable actualError = null;

    try {
      @SuppressWarnings("unused")
      boolean ignored = it.hasNext();
    } catch (Throwable t) {
      actualError = t;
    }

    Truth.assertThat(actualError).isEqualTo(expectError);

    try {
      it.next();
    } catch (Throwable t) {
      actualError = t;
    }
    Truth.assertThat(actualError).isEqualTo(expectError);
  }
}
