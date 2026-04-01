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

import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.api.core.SettableApiFuture;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.ResponseContentLifecycleHandle.ChildRef;
import com.google.cloud.storage.RetryContext.OnFailure;
import com.google.cloud.storage.RetryContext.OnSuccess;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ReadRange;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import org.checkerframework.checker.nullness.qual.Nullable;

@InternalApi
@InternalExtensionOnly
abstract class BaseObjectReadSessionStreamRead<Projection>
    implements ObjectReadSessionStreamRead<Projection> {

  protected final RangeSpec rangeSpec;
  protected final RetryContext retryContext;
  protected final AtomicLong readOffset;
  protected boolean closed;
  protected boolean tombstoned;
  protected IOAutoCloseable onCloseCallback;

  BaseObjectReadSessionStreamRead(
      RangeSpec rangeSpec, RetryContext retryContext, IOAutoCloseable onCloseCallback) {
    this(rangeSpec, new AtomicLong(rangeSpec.begin()), retryContext, onCloseCallback, false);
  }

  BaseObjectReadSessionStreamRead(
      RangeSpec rangeSpec,
      AtomicLong readOffset,
      RetryContext retryContext,
      IOAutoCloseable onCloseCallback,
      boolean closed) {
    this.rangeSpec = rangeSpec;
    this.retryContext = retryContext;
    this.readOffset = readOffset;
    this.closed = closed;
    this.tombstoned = false;
    this.onCloseCallback = onCloseCallback;
  }

  abstract long readId();

  @Override
  public long readOffset() {
    return readOffset.get();
  }

  @Override
  public final void preFail() {
    tombstoned = true;
  }

  @Override
  public final ReadRange makeReadRange() {
    long currentOffset = readOffset.get();
    ReadRange.Builder b = ReadRange.newBuilder().setReadId(readId()).setReadOffset(currentOffset);
    rangeSpec
        .maxLength()
        .ifPresent(
            length -> {
              long readSoFar = currentOffset - rangeSpec.begin();
              b.setReadLength(length - readSoFar);
            });
    return b.build();
  }

  @Override
  public <T extends Throwable> void recordError(T t, OnSuccess onSuccess, OnFailure<T> onFailure) {
    retryContext.recordError(t, onSuccess, onFailure);
  }

  @Override
  public boolean readyToSend() {
    return !tombstoned && !retryContext.inBackoff();
  }

  @Override
  public boolean canShareStreamWith(ObjectReadSessionStreamRead<?> other) {
    return this.getClass() == other.getClass();
  }

  @Override
  public final void close() throws IOException {
    try {
      internalClose();
    } finally {
      onCloseCallback.close();
    }
  }

  @Override
  public void setOnCloseCallback(IOAutoCloseable onCloseCallback) {
    this.onCloseCallback = this.onCloseCallback.andThen(onCloseCallback);
  }

  /** Base class of a read that will accumulate before completing by resolving a future */
  abstract static class AccumulatingRead<Result>
      extends BaseObjectReadSessionStreamRead<ApiFuture<Result>> implements ApiFuture<Result> {
    protected final List<ChildRef> childRefs;
    protected final SettableApiFuture<Result> complete;
    protected final long readId;
    protected final Hasher hasher;

    private AccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        RetryContext retryContext,
        IOAutoCloseable onCloseCallback) {
      super(rangeSpec, retryContext, onCloseCallback);
      this.readId = readId;
      this.hasher = hasher;
      this.complete = SettableApiFuture.create();
      this.childRefs = Collections.synchronizedList(new ArrayList<>());
    }

    private AccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        List<ChildRef> childRefs,
        AtomicLong readOffset,
        RetryContext retryContext,
        boolean closed,
        SettableApiFuture<Result> complete,
        IOAutoCloseable onCloseCallback) {
      super(rangeSpec, readOffset, retryContext, onCloseCallback, closed);
      this.readId = readId;
      this.childRefs = childRefs;
      this.complete = complete;
      this.hasher = hasher;
    }

    @Override
    long readId() {
      return readId;
    }

    @Override
    public boolean acceptingBytes() {
      return !complete.isDone() && !tombstoned;
    }

    @Override
    public void accept(ChildRef childRef) throws IOException {
      retryContext.reset();
      int size = childRef.byteString().size();
      childRefs.add(childRef);
      readOffset.addAndGet(size);
    }

    @Override
    public ApiFuture<?> fail(Throwable t) {
      try {
        tombstoned = true;
        close();
      } catch (IOException e) {
        t.addSuppressed(e);
      } finally {
        complete.setException(t);
      }
      return complete;
    }

    @Override
    public Hasher hasher() {
      return hasher;
    }

    @Override
    public void internalClose() throws IOException {
      if (!closed) {
        retryContext.reset();
        closed = true;
        GrpcUtils.closeAll(childRefs);
      }
    }

    @Override
    public void addListener(Runnable listener, Executor executor) {
      complete.addListener(listener, executor);
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
      if (!complete.isCancelled()) {
        fail(new CancellationException());
      }
      return complete.cancel(mayInterruptIfRunning);
    }

    @Override
    public Result get() throws InterruptedException, ExecutionException {
      return complete.get();
    }

    @Override
    public Result get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException {
      return complete.get(timeout, unit);
    }

    @Override
    public boolean isCancelled() {
      return complete.isCancelled();
    }

    @Override
    public boolean isDone() {
      return complete.isDone();
    }

    @Override
    public boolean canShareStreamWith(ObjectReadSessionStreamRead<?> other) {
      return other instanceof AccumulatingRead;
    }
  }

  /**
   * Base class of a read that will be processed in a streaming manner (e.g. {@link
   * ReadableByteChannel})
   */
  static class StreamingRead extends BaseObjectReadSessionStreamRead<ScatteringByteChannel>
      implements UnbufferedReadableByteChannel {

    private final Hasher hasher;
    private final SettableApiFuture<Void> failFuture;
    private final ArrayBlockingQueue<Closeable> queue;

    private AtomicLong readId;
    private boolean complete;
    @Nullable private ChildRefHelper leftovers;

    StreamingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        RetryContext retryContext,
        IOAutoCloseable onCloseCallback) {
      super(rangeSpec, retryContext, onCloseCallback);
      this.readId = new AtomicLong(readId);
      this.hasher = hasher;
      this.closed = false;
      this.failFuture = SettableApiFuture.create();
      this.queue = new ArrayBlockingQueue<>(2);
      this.complete = false;
      this.leftovers = null;
    }

    @Override
    long readId() {
      return readId.get();
    }

    @Override
    public Hasher hasher() {
      return hasher;
    }

    @Override
    public boolean acceptingBytes() {
      return !closed && !tombstoned;
    }

    @Override
    public void accept(ChildRef childRef) throws IOException {
      retryContext.reset();
      int size = childRef.byteString().size();
      offer(childRef);
      readOffset.addAndGet(size);
    }

    @Override
    public void eof() throws IOException {
      retryContext.reset();
      offer(EofMarker.INSTANCE);
    }

    @Override
    public ApiFuture<?> fail(Throwable t) {
      try {
        offer(new SmuggledFailure(t));
        failFuture.set(null);
      } catch (InterruptedIOException e) {
        Thread.currentThread().interrupt();
        failFuture.setException(e);
      }
      return failFuture;
    }

    @Override
    public StreamingRead withNewReadId(long newReadId) {
      readId.set(newReadId);
      return this;
    }

    @Override
    public boolean canShareStreamWith(ObjectReadSessionStreamRead<?> other) {
      return false;
    }

    @Override
    public void internalClose() throws IOException {
      if (!closed) {
        closed = true;
        internalCleanup();
      }
    }

    @Override
    public boolean isOpen() {
      return !closed;
    }

    @Override
    public UnbufferedReadableByteChannel project() {
      return this;
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
      return Math.toIntExact(read(new ByteBuffer[] {dst}, 0, 1));
    }

    @Override
    public long read(ByteBuffer[] dsts) throws IOException {
      return read(dsts, 0, dsts.length);
    }

    @Override
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
      if (closed) {
        throw new ClosedChannelException();
      }
      if (complete) {
        internalCleanup();
        return -1;
      }

      long read = 0;
      if (leftovers != null) {
        read += leftovers.copy(dsts, offset, length);
        if (!leftovers.hasRemaining()) {
          leftovers.ref.close();
          leftovers = null;
        }
      }

      try {
        Object poll;
        while (leftovers == null && (poll = queue.poll(10, TimeUnit.MICROSECONDS)) != null) {
          if (poll instanceof ChildRef) {
            ChildRefHelper ref = new ChildRefHelper((ChildRef) poll);
            read += ref.copy(dsts, offset, length);
            if (ref.hasRemaining()) {
              leftovers = ref;
              break;
            } else {
              ref.ref.close();
            }
          } else if (poll == EofMarker.INSTANCE) {
            complete = true;
            if (read == 0) {
              internalCleanup();
              return -1;
            }
            break;
          } else if (poll instanceof SmuggledFailure) {
            SmuggledFailure throwable = (SmuggledFailure) poll;
            close();
            BaseServiceException coalesce = StorageException.coalesce(throwable.getSmuggled());
            throw new IOException(coalesce);
          } else {
            //noinspection DataFlowIssue
            Preconditions.checkState(
                false, "unhandled queue element type %s", poll.getClass().getName());
          }
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        InterruptedIOException ioe = new InterruptedIOException();
        ioe.initCause(e);
        throw ioe;
      }

      return read;
    }

    private void offer(Closeable offer) throws InterruptedIOException {
      try {
        queue.put(offer);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        InterruptedIOException ioe = new InterruptedIOException();
        ioe.initCause(e);
        throw ioe;
      }
    }

    private void internalCleanup() throws IOException {
      retryContext.reset();
      if (leftovers != null) {
        leftovers.ref.close();
      }
      GrpcUtils.closeAll(queue);
    }

    /**
     * The queue items are added to is a queue of {@link Closeable}. This class smuggles a Throwable
     * in a no-op Closable, such that the throwable can be in the queue.
     *
     * <p>Refer to {@link #fail(Throwable)} to see where this class is instantiated.
     */
    static final class SmuggledFailure implements Closeable {
      private final Throwable smuggled;

      private SmuggledFailure(Throwable smuggled) {
        this.smuggled = smuggled;
      }

      Throwable getSmuggled() {
        return smuggled;
      }

      @Override
      public void close() throws IOException {}
    }

    static final class ChildRefHelper {
      private final ChildRef ref;

      private final List<ByteBuffer> buffers;

      private ChildRefHelper(ChildRef ref) {
        this.ref = ref;
        this.buffers = ref.byteString().asReadOnlyByteBufferList();
      }

      long copy(ByteBuffer[] dsts, int offset, int length) {
        long copied = 0;
        for (ByteBuffer b : buffers) {
          long copiedBytes = Buffers.copy(b, dsts, offset, length);
          copied += copiedBytes;
          if (b.hasRemaining()) break;
        }
        return copied;
      }

      boolean hasRemaining() {
        for (ByteBuffer b : buffers) {
          if (b.hasRemaining()) return true;
        }
        return false;
      }
    }

    private static final class EofMarker implements Closeable {
      private static final EofMarker INSTANCE = new EofMarker();

      private EofMarker() {}

      @Override
      public void close() {}
    }
  }

  static final class ByteArrayAccumulatingRead extends AccumulatingRead<byte[]> {

    ByteArrayAccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        RetryContext retryContext,
        IOAutoCloseable onCloseCallback) {
      super(readId, rangeSpec, hasher, retryContext, onCloseCallback);
    }

    private ByteArrayAccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        List<ChildRef> childRefs,
        RetryContext retryContext,
        AtomicLong readOffset,
        boolean closed,
        SettableApiFuture<byte[]> complete,
        IOAutoCloseable onCloseCallback) {
      super(
          readId,
          rangeSpec,
          hasher,
          childRefs,
          readOffset,
          retryContext,
          closed,
          complete,
          onCloseCallback);
    }

    @Override
    public ApiFuture<byte[]> project() {
      return this;
    }

    @Override
    public void eof() throws IOException {
      retryContext.reset();
      try {
        ByteString base = ByteString.empty();
        for (ChildRef ref : childRefs) {
          base = base.concat(ref.byteString());
        }
        complete.set(base.toByteArray());
      } finally {
        close();
      }
    }

    @Override
    public ByteArrayAccumulatingRead withNewReadId(long newReadId) {
      this.tombstoned = true;
      return new ByteArrayAccumulatingRead(
          newReadId,
          rangeSpec,
          hasher,
          childRefs,
          retryContext,
          readOffset,
          closed,
          complete,
          onCloseCallback);
    }
  }

  static final class ZeroCopyByteStringAccumulatingRead
      extends AccumulatingRead<DisposableByteString> implements DisposableByteString {

    private volatile ByteString byteString;

    ZeroCopyByteStringAccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        RetryContext retryContext,
        IOAutoCloseable onCloseCallback) {
      super(readId, rangeSpec, hasher, retryContext, onCloseCallback);
    }

    public ZeroCopyByteStringAccumulatingRead(
        long readId,
        RangeSpec rangeSpec,
        Hasher hasher,
        List<ChildRef> childRefs,
        AtomicLong readOffset,
        RetryContext retryContext,
        boolean closed,
        SettableApiFuture<DisposableByteString> complete,
        ByteString byteString,
        IOAutoCloseable onCloseCallback) {
      super(
          readId,
          rangeSpec,
          hasher,
          childRefs,
          readOffset,
          retryContext,
          closed,
          complete,
          onCloseCallback);
      this.byteString = byteString;
    }

    @Override
    public ApiFuture<DisposableByteString> project() {
      return this;
    }

    @Override
    public ByteString byteString() {
      return byteString;
    }

    @Override
    public void eof() throws IOException {
      retryContext.reset();
      ByteString base = ByteString.empty();
      for (ChildRef ref : childRefs) {
        base = base.concat(ref.byteString());
      }
      byteString = base;
      complete.set(this);
    }

    @Override
    public ZeroCopyByteStringAccumulatingRead withNewReadId(long newReadId) {
      this.tombstoned = true;
      return new ZeroCopyByteStringAccumulatingRead(
          newReadId,
          rangeSpec,
          hasher,
          childRefs,
          readOffset,
          retryContext,
          closed,
          complete,
          byteString,
          onCloseCallback);
    }
  }
}
