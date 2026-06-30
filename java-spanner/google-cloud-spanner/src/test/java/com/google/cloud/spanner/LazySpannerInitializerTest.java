/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LazySpannerInitializerTest {

  @Test
  public void testGet_shouldReturnSameInstance() throws Throwable {
    final LazySpannerInitializer initializer =
        new LazySpannerInitializer() {
          @Override
          public Spanner initialize() {
            return mock(Spanner.class);
          }
        };
    Spanner s1 = initializer.get();
    Spanner s2 = initializer.get();
    assertThat(s1).isSameInstanceAs(s2);
  }

  @Test
  public void testGet_shouldThrowErrorFromInitializeMethod() {
    final LazySpannerInitializer initializer =
        new LazySpannerInitializer() {
          @Override
          public Spanner initialize() throws IOException {
            throw new IOException("Could not find credentials file");
          }
        };
    Throwable t1 = assertThrows(Throwable.class, () -> initializer.get());
    Throwable t2 = assertThrows(Throwable.class, () -> initializer.get());
    assertThat(t1).isSameInstanceAs(t2);
  }

  @Test
  public void testGet_shouldInvokeInitializeOnlyOnce()
      throws InterruptedException, ExecutionException {
    final AtomicInteger count = new AtomicInteger();
    final LazySpannerInitializer initializer =
        new LazySpannerInitializer() {
          @Override
          public Spanner initialize() {
            count.incrementAndGet();
            return mock(Spanner.class);
          }
        };
    final int threads = 16;
    final CountDownLatch latch = new CountDownLatch(threads);
    ListeningExecutorService executor =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(threads));
    List<ListenableFuture<Spanner>> futures = new ArrayList<>(threads);
    for (int i = 0; i < threads; i++) {
      futures.add(
          executor.submit(
              () -> {
                latch.countDown();
                latch.await(10L, TimeUnit.SECONDS);
                return initializer.get();
              }));
    }
    assertThat(Futures.allAsList(futures).get()).hasSize(threads);
    for (int i = 0; i < threads - 1; i++) {
      assertThat(futures.get(i).get()).isSameInstanceAs(futures.get(i + 1).get());
    }
    assertThat(count.get()).isEqualTo(1);
    executor.shutdown();
  }
}
