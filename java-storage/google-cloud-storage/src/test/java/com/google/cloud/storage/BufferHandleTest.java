/*
 * Copyright 2022 Google LLC
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

import com.google.cloud.storage.BufferHandle.LazyBufferHandle;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Assert;
import org.junit.Test;

public final class BufferHandleTest {

  @Test
  public void lazyBufferHandle_methodsBehaveTheSameAsAnEmptyByteBuffer() {
    int capacity = 10;
    ByteBuffer baseline = ByteBuffer.allocate(capacity);
    LazyBufferHandle handle =
        new LazyBufferHandle(
            capacity,
            i -> {
              Assert.fail("should not be called");
              return null;
            });

    assertThat(handle.remaining()).isEqualTo(baseline.remaining());
    assertThat(handle.position()).isEqualTo(baseline.position());
    assertThat(handle.capacity()).isEqualTo(baseline.capacity());
  }

  @Test
  public void lazyBufferHandle_afterAllocationOnlyBackingIsReferenced() {
    int capacity = 10;
    ByteBuffer baseline = ByteBuffer.allocate(capacity);
    AtomicBoolean alloc = new AtomicBoolean(false);
    LazyBufferHandle handle =
        new LazyBufferHandle(
            capacity,
            i -> {
              alloc.compareAndSet(false, true);
              return ByteBuffer.allocate(capacity);
            });

    assertThat(handle.remaining()).isEqualTo(baseline.remaining());
    assertThat(handle.position()).isEqualTo(baseline.position());
    assertThat(handle.capacity()).isEqualTo(baseline.capacity());

    byte[] bytes = new byte[] {(byte) 'a', (byte) 'b'};
    handle.get().put(bytes);
    assertThat(alloc.get()).isTrue();
    assertThat(handle.remaining()).isEqualTo(8);
    assertThat(handle.position()).isEqualTo(2);
    assertThat(handle.capacity()).isEqualTo(capacity);
  }

  @Test
  public void lazyBufferHandle_initIsThreadSafe() throws ExecutionException, InterruptedException {
    int capacity = 10;
    ExecutorService exec = Executors.newFixedThreadPool(2);
    AtomicBoolean alloc = new AtomicBoolean(false);
    LazyBufferHandle handle =
        new LazyBufferHandle(
            capacity,
            i -> {
              alloc.compareAndSet(false, true);
              return ByteBuffer.allocate(capacity);
            });

    Future<ByteBuffer> f1 = exec.submit(handle::get);
    Future<ByteBuffer> f2 = exec.submit(handle::get);

    assertThat(f1.get()).isSameInstanceAs(f2.get());

    assertThat(handle.get().capacity()).isEqualTo(capacity);
  }

  @Test
  public void eagerBufferHandle_methodsBehaveTheSameAsAnEmptyByteBuffer() {
    int capacity = 10;
    ByteBuffer baseline = ByteBuffer.allocate(capacity);
    BufferHandle handle = BufferHandle.handleOf(baseline);

    assertThat(handle.remaining()).isEqualTo(baseline.remaining());
    assertThat(handle.position()).isEqualTo(baseline.position());
    assertThat(handle.capacity()).isEqualTo(baseline.capacity());

    byte[] bytes = new byte[] {(byte) 'a', (byte) 'b'};
    baseline.put(bytes);
    assertThat(handle.remaining()).isEqualTo(8);
    assertThat(handle.position()).isEqualTo(2);
    assertThat(handle.capacity()).isEqualTo(capacity);

    assertThat(handle.get()).isSameInstanceAs(baseline);
  }
}
