/*
 * Copyright 2024 Google LLC
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

import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.GrpcUtils.ZeroCopyBidiStreamingCallable;
import com.google.cloud.storage.ReadProjectionConfig.ProjectionType;
import com.google.cloud.storage.RetryContext.RetryContextProvider;
import com.google.common.annotations.VisibleForTesting;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectResponse;
import com.google.storage.v2.Object;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

final class ObjectReadSessionImpl implements ObjectReadSession {

  private final ScheduledExecutorService executor;
  private final ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse>
      callable;
  private final ObjectReadSessionStream stream;
  @VisibleForTesting final ObjectReadSessionState state;
  private final Object resource;
  private final RetryContextProvider retryContextProvider;

  private final ConcurrentIdentityMap<ObjectReadSessionStream, ObjectReadSessionState> children;

  // Fast open reads: reads sent in the request that opened the stream, keyed by the config each was
  // created from. The first readAs with an equal config is given the read instead of sending a new
  // one.
  private final ConcurrentMap<ReadProjectionConfig<?>, ObjectReadSessionStreamRead<?>>
      fastOpenReads;

  private volatile boolean open;

  ObjectReadSessionImpl(
      ScheduledExecutorService executor,
      ZeroCopyBidiStreamingCallable<BidiReadObjectRequest, BidiReadObjectResponse> callable,
      ObjectReadSessionStream stream,
      ObjectReadSessionState state,
      RetryContextProvider retryContextProvider,
      Map<ReadProjectionConfig<?>, ObjectReadSessionStreamRead<?>> fastOpenReads) {
    this.executor = executor;
    this.callable = callable;
    this.stream = stream;
    this.state = state;
    this.resource = state.getMetadata();
    this.retryContextProvider = retryContextProvider;
    this.children = new ConcurrentIdentityMap<>();
    this.fastOpenReads = new ConcurrentHashMap<>(fastOpenReads);
    this.open = true;
  }

  @Override
  public Object getResource() {
    return resource;
  }

  @Override
  public <Projection> Projection readAs(ReadProjectionConfig<Projection> config) {
    checkState(open, "Session already closed");
    switch (config.getType()) {
      case STREAM_READ:
        ObjectReadSessionStreamRead<?> fastOpenRead = fastOpenReads.remove(config.unwrap());
        if (fastOpenRead != null) {
          // configs are final classes with a class-exact equals, so an equal config has the same
          // Projection type
          @SuppressWarnings("unchecked")
          Projection projection = (Projection) fastOpenRead.project();
          config.onFastOpenReadClaimed(projection);
          return projection;
        }
        long readId = state.newReadId();
        ObjectReadSessionStreamRead<Projection> read =
            config.cast().newRead(readId, retryContextProvider.create());
        registerReadInState(readId, read);
        return read.project();
      case SESSION_USER:
        return config.project(this, IOAutoCloseable.noOp());
      default:
        throw new IllegalStateException(
            String.format(
                Locale.US,
                "Broken java enum %s value=%s",
                ProjectionType.class.getName(),
                config.getType().name()));
    }
  }

  @Override
  public void close() throws IOException {
    try {
      if (!open) {
        return;
      }
      open = false;
      List<ApiFuture<Void>> closing =
          children.drainEntries((subStream, subStreamState) -> subStream.closeAsync());
      stream.close();
      ApiFutures.allAsList(closing).get();
    } catch (ExecutionException e) {
      throw new IOException(e.getCause());
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException();
    } finally {
      // a fast open read nobody asked for may already be complete and out of the state, so
      // stream.close() above does not reach it; close it here to release its buffers
      GrpcUtils.closeAll(fastOpenReads.values());
      fastOpenReads.clear();
    }
  }

  private void registerReadInState(long readId, ObjectReadSessionStreamRead<?> read) {
    BidiReadObjectRequest request =
        BidiReadObjectRequest.newBuilder().addReadRanges(read.makeReadRange()).build();
    if (state.canHandleNewRead(read)) {
      state.putOutstandingRead(readId, read);
      stream.send(request);
    } else {
      ObjectReadSessionState child = state.forkChild();
      ObjectReadSessionStream newStream =
          ObjectReadSessionStream.create(executor, callable, child, retryContextProvider.create());
      children.put(newStream, child);
      read.setOnCloseCallback(
          () -> {
            children.remove(newStream);
            newStream.close();
          });
      child.putOutstandingRead(readId, read);
      newStream.send(request);
    }
  }

  @VisibleForTesting
  static final class ConcurrentIdentityMap<K, V> {
    private final ReentrantLock lock;
    private final IdentityHashMap<K, V> children;

    @VisibleForTesting
    ConcurrentIdentityMap() {
      lock = new ReentrantLock();
      children = new IdentityHashMap<>();
    }

    public void put(K key, V value) {
      lock.lock();
      try {
        children.put(key, value);
      } finally {
        lock.unlock();
      }
    }

    public void remove(K key) {
      lock.lock();
      try {
        children.remove(key);
      } finally {
        lock.unlock();
      }
    }

    public <R> ArrayList<R> drainEntries(BiFunction<K, V, R> f) {
      lock.lock();
      try {
        Iterator<Entry<K, V>> it = children.entrySet().iterator();
        ArrayList<R> results = new ArrayList<>(children.size());
        while (it.hasNext()) {
          Entry<K, V> entry = it.next();
          K key = entry.getKey();
          V value = entry.getValue();
          it.remove();
          R r = f.apply(key, value);
          results.add(r);
        }
        return results;
      } finally {
        lock.unlock();
      }
    }
  }
}
