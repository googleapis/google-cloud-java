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
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.cloud.storage.RetryContext.OnFailure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.storage.v2.BidiReadHandle;
import com.google.storage.v2.BidiReadObjectRequest;
import com.google.storage.v2.BidiReadObjectSpec;
import com.google.storage.v2.Object;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.checkerframework.checker.lock.qual.GuardedBy;
import org.checkerframework.checker.nullness.qual.MonotonicNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ObjectReadSessionState {

  private final GrpcCallContext baseContext;
  private final BidiReadObjectRequest openRequest;
  private final AtomicReference<@Nullable BidiReadHandle> bidiReadHandle;
  private final AtomicReference<@Nullable String> routingToken;
  private final AtomicReference<@MonotonicNonNull Object> metadata;
  private final AtomicLong readIdSeq;

  @GuardedBy("this.lock") // https://errorprone.info/bugpattern/GuardedBy
  private final Map<Long, ObjectReadSessionStreamRead<?>> outstandingReads;

  private final ReentrantLock lock;

  ObjectReadSessionState(
      @NonNull GrpcCallContext baseContext, @NonNull BidiReadObjectRequest openRequest) {
    this(
        baseContext,
        openRequest,
        new AtomicLong(1),
        new AtomicReference<>(),
        new AtomicReference<>(),
        new AtomicReference<>());
  }

  private ObjectReadSessionState(
      @NonNull GrpcCallContext baseContext,
      @NonNull BidiReadObjectRequest openRequest,
      AtomicLong readIdSeq,
      AtomicReference<@Nullable BidiReadHandle> bidiReadHandle,
      AtomicReference<@Nullable String> routingToken,
      AtomicReference<@MonotonicNonNull Object> metadata) {
    this.baseContext = baseContext;
    this.openRequest = openRequest;
    this.bidiReadHandle = bidiReadHandle;
    this.routingToken = routingToken;
    this.metadata = metadata;
    this.readIdSeq = readIdSeq;
    this.outstandingReads = new HashMap<>();
    this.lock = new ReentrantLock();
  }

  ObjectReadSessionState forkChild() {
    return new ObjectReadSessionState(
        baseContext,
        openRequest,
        readIdSeq,
        new AtomicReference<>(bidiReadHandle.get()),
        new AtomicReference<>(routingToken.get()),
        new AtomicReference<>(metadata.get()));
  }

  boolean canHandleNewRead(ObjectReadSessionStreamRead<?> newRead) {
    lock.lock();
    try {
      // when the map is empty this will also return true, see #allMatch docs
      return outstandingReads.values().stream().allMatch(r -> r.canShareStreamWith(newRead));
    } finally {
      lock.unlock();
    }
  }

  OpenArguments getOpenArguments() {
    lock.lock();
    try {
      BidiReadObjectRequest.Builder b = openRequest.toBuilder().clearReadRanges();

      Object obj = metadata.get();
      BidiReadObjectSpec spec = openRequest.getReadObjectSpec();
      if (obj != null && obj.getGeneration() != spec.getGeneration()) {
        b.getReadObjectSpecBuilder().setGeneration(obj.getGeneration());
      }

      String routingToken = this.routingToken.get();
      if (routingToken != null) {
        b.getReadObjectSpecBuilder().setRoutingToken(routingToken);
      }

      BidiReadHandle bidiReadHandle = this.bidiReadHandle.get();
      if (bidiReadHandle != null) {
        b.getReadObjectSpecBuilder().setReadHandle(bidiReadHandle);
      }

      outstandingReads.values().stream()
          .filter(ObjectReadSessionStreamRead::readyToSend)
          .map(ObjectReadSessionStreamRead::makeReadRange)
          .forEach(b::addReadRanges);

      ImmutableMap<String, List<String>> headers =
          ImmutableMap.of(
              "x-goog-request-params",
              ImmutableList.of(
                  Stream.of(
                          "bucket=" + spec.getBucket(),
                          routingToken != null ? "routing_token=" + routingToken : null)
                      .filter(Objects::nonNull)
                      .collect(Collectors.joining("&"))));
      return OpenArguments.of(baseContext.withExtraHeaders(headers), b.build());
    } finally {
      lock.unlock();
    }
  }

  void setBidiReadHandle(BidiReadHandle newValue) {
    bidiReadHandle.set(newValue);
  }

  Object getMetadata() {
    return metadata.get();
  }

  void setMetadata(Object metadata) {
    this.metadata.set(metadata);
  }

  long newReadId() {
    return readIdSeq.getAndIncrement();
  }

  @Nullable ObjectReadSessionStreamRead<?> getOutstandingRead(long key) {
    lock.lock();
    try {
      return outstandingReads.get(key);
    } finally {
      lock.unlock();
    }
  }

  void putOutstandingRead(long key, ObjectReadSessionStreamRead<?> value) {
    lock.lock();
    try {
      outstandingReads.put(key, value);
    } finally {
      lock.unlock();
    }
  }

  void removeOutstandingRead(long key) {
    lock.lock();
    try {
      outstandingReads.remove(key);
    } finally {
      lock.unlock();
    }
  }

  <T extends Throwable> OnFailure<T> removeOutstandingReadOnFailure(long key, OnFailure<T> onFail) {
    return t -> {
      removeOutstandingRead(key);
      onFail.onFailure(t);
    };
  }

  void setRoutingToken(String routingToken) {
    this.routingToken.set(routingToken);
  }

  ObjectReadSessionStreamRead<?> assignNewReadId(long oldReadId) {
    lock.lock();
    try {
      ObjectReadSessionStreamRead<?> remove = outstandingReads.remove(oldReadId);
      checkState(remove != null, "unable to locate old read");
      long newReadId = newReadId();
      ObjectReadSessionStreamRead<?> withNewReadId = remove.withNewReadId(newReadId);
      outstandingReads.put(newReadId, withNewReadId);
      return withNewReadId;
    } finally {
      lock.unlock();
    }
  }

  ApiFuture<?> failAll(Executor executor, Supplier<Throwable> terminalFailure) {
    lock.lock();
    try {
      Iterator<Entry<Long, ObjectReadSessionStreamRead<?>>> iter =
          outstandingReads.entrySet().iterator();
      ArrayList<ApiFuture<?>> futures = new ArrayList<>();
      while (iter.hasNext()) {
        Entry<Long, ObjectReadSessionStreamRead<?>> entry = iter.next();
        iter.remove();
        ObjectReadSessionStreamRead<?> read = entry.getValue();
        read.preFail();
        ApiFuture<?> f =
            ApiFutures.transformAsync(
                ApiFutures.immediateFuture("trigger"),
                ignore -> read.fail(StorageException.coalesce(terminalFailure.get())),
                executor);
        futures.add(f);
      }
      // for our result here, we don't care if the individual futures fail or succeed, only that
      // they resolve. Only collect successful results so we don't cause a failure to the caller
      // that awaits this future.
      return ApiFutures.successfulAsList(futures);
    } finally {
      lock.unlock();
    }
  }

  static final class OpenArguments {
    private final GrpcCallContext ctx;
    private final BidiReadObjectRequest req;

    private OpenArguments(GrpcCallContext ctx, BidiReadObjectRequest req) {
      this.ctx = ctx;
      this.req = req;
    }

    public GrpcCallContext getCtx() {
      return ctx;
    }

    public BidiReadObjectRequest getReq() {
      return req;
    }

    public static OpenArguments of(GrpcCallContext ctx, BidiReadObjectRequest req) {
      return new OpenArguments(ctx, req);
    }
  }
}
