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

import static com.google.common.collect.Sets.newHashSet;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.BufferHandlePool.FixedBufferHandlePool;
import com.google.cloud.storage.BufferHandlePool.PooledBuffer;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public final class BufferHandlePoolTest {

  private static ExecutorService exec;

  @BeforeClass
  public static void beforeClass() {
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setDaemon(true).setNameFormat("test-bhmt-%d").build();
    exec = Executors.newCachedThreadPool(threadFactory);
  }

  @AfterClass
  public static void afterClass() {
    if (exec != null) {
      exec.shutdownNow();
    }
  }

  @Test
  public void fixedPool_doesNotAllowTheSameBufferToBeReturnedWhilePresent() {
    BufferHandle b1 = BufferHandle.allocate(10);
    BufferHandle b2 = BufferHandle.allocate(10);

    PooledBuffer p1 = PooledBuffer.of(b1);
    PooledBuffer p2 = PooledBuffer.of(b2);
    HashSet<PooledBuffer> pooledBuffers = newHashSet(p1, p2);
    FixedBufferHandlePool pool = new FixedBufferHandlePool(pooledBuffers);

    PooledBuffer g1 = pool.getBuffer();
    PooledBuffer g2 = pool.getBuffer();

    pool.returnBuffer(g1);
    pool.returnBuffer(g1);

    assertThat(pool.pool).isEqualTo(newHashSet(g1));
  }

  @Test
  public void fixedPool_getBuffer_blocksIfEmpty() {
    FixedBufferHandlePool pool = FixedBufferHandlePool.of(1, 10);
    PooledBuffer p1 = pool.getBuffer();

    Future<PooledBuffer> f = exec.submit(pool::getBuffer);
    assertThrows(TimeoutException.class, () -> f.get(10, TimeUnit.MILLISECONDS));
  }

  @Test
  public void fixedPool_returnBuffer_blocksIfFull() {
    FixedBufferHandlePool pool = FixedBufferHandlePool.of(1, 10);

    PooledBuffer imposter = PooledBuffer.of(BufferHandle.allocate(5));
    Future<Void> f =
        exec.submit(
            () -> {
              pool.returnBuffer(imposter);
              return null;
            });
    assertThrows(TimeoutException.class, () -> f.get(10, TimeUnit.MILLISECONDS));
  }
}
