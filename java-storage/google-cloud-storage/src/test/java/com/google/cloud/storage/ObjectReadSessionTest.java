/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.ObjectReadSessionImpl.ConcurrentIdentityMap;
import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public final class ObjectReadSessionTest {
  private static final AtomicInteger vCounter = new AtomicInteger(1);

  private static ListeningExecutorService exec;

  @BeforeClass
  public static void beforeClass() {
    exec =
        MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(2, new ThreadFactoryBuilder().setDaemon(true).build()));
  }

  @AfterClass
  public static void afterClass() {
    exec.shutdownNow();
  }

  @Test
  public void concurrentIdentityMap_basic() throws Exception {
    ConcurrentIdentityMap<Key, Value> map = new ConcurrentIdentityMap<>();

    map.put(new Key("k1"), new Value());
    map.put(new Key("k2"), new Value());
    map.put(new Key("k3"), new Value());
    map.put(new Key("k4"), new Value());

    List<String> strings = map.drainEntries((k, v) -> String.format("%s -> %s", k, v));
    assertThat(strings).hasSize(4);

    String joined = String.join("\n", strings);
    assertAll(
        () -> assertThat(joined).contains("k1"),
        () -> assertThat(joined).contains("k2"),
        () -> assertThat(joined).contains("k3"),
        () -> assertThat(joined).contains("k4"));
  }

  @Test
  public void concurrentIdentityMap_multipleThreadsAdding() throws Exception {
    ConcurrentIdentityMap<Key, Value> map = new ConcurrentIdentityMap<>();

    CountDownLatch cdl = new CountDownLatch(1);
    map.put(new Key("t1k1"), new Value());
    map.put(new Key("t1k2"), new Value());

    ListenableFuture<Boolean> submitted =
        exec.submit(
            () -> {
              try {
                boolean await = cdl.await(3, TimeUnit.SECONDS);
                assertThat(await).isTrue();
                map.put(new Key("t2k1"), new Value());
                return true;
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    BiFunction<Key, Value, String> f =
        (k, v) -> {
          cdl.countDown();
          return String.format("%s -> %s", k, v);
        };
    List<String> strings = map.drainEntries(f);
    assertThat(strings).hasSize(2);
    String joined = String.join("\n", strings);
    assertAll(() -> assertThat(joined).contains("t1k1"), () -> assertThat(joined).contains("t1k2"));

    submitted.get(1, TimeUnit.SECONDS);
    List<String> drain2 = map.drainEntries(f);
    assertThat(drain2).hasSize(1);
  }

  @Test
  public void concurrentIdentityMap_removeAfterDrainClean() throws Exception {
    ConcurrentIdentityMap<Key, Value> map = new ConcurrentIdentityMap<>();

    CountDownLatch cdl = new CountDownLatch(1);
    map.put(new Key("t1k1"), new Value());
    Key t1k2 = new Key("t1k2");
    map.put(t1k2, new Value());

    ListenableFuture<Boolean> submit =
        exec.submit(
            () -> {
              try {
                boolean await = cdl.await(3, TimeUnit.SECONDS);
                assertThat(await).isTrue();
                map.remove(t1k2);
                return true;
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            });

    BiFunction<Key, Value, String> f =
        (k, v) -> {
          cdl.countDown();
          return String.format("%s -> %s", k, v);
        };
    List<String> strings = map.drainEntries(f);
    assertThat(strings).hasSize(2);
    String joined = String.join("\n", strings);
    assertAll(() -> assertThat(joined).contains("t1k1"), () -> assertThat(joined).contains("t1k2"));

    assertThat(submit.get(1, TimeUnit.SECONDS)).isEqualTo(true);
  }

  private static final class Key {
    private final String k;

    private Key(String k) {
      this.k = k;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("k", k).toString();
    }
  }

  private static final class Value {
    private final String v = String.format("v/%d", vCounter.getAndIncrement());

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("v", v).toString();
    }
  }
}
