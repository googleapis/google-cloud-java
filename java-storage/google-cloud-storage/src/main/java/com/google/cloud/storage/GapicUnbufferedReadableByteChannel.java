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

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.api.gax.rpc.StateCheckingResponseObserver;
import com.google.api.gax.rpc.StreamController;
import com.google.api.gax.rpc.WatchdogTimeoutException;
import com.google.cloud.BaseServiceException;
import com.google.cloud.storage.Conversions.Decoder;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.GrpcUtils.ZeroCopyServerStreamingCallable;
import com.google.cloud.storage.Hasher.UncheckedChecksumMismatchException;
import com.google.cloud.storage.ResponseContentLifecycleHandle.ChildRef;
import com.google.cloud.storage.Retrying.Retrier;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.common.base.Suppliers;
import com.google.protobuf.ByteString;
import com.google.storage.v2.ChecksummedData;
import com.google.storage.v2.Object;
import com.google.storage.v2.ReadObjectRequest;
import com.google.storage.v2.ReadObjectResponse;
import io.grpc.Status.Code;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ScatteringByteChannel;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

final class GapicUnbufferedReadableByteChannel
    implements UnbufferedReadableByteChannel, ScatteringByteChannel {
  private static final java.lang.Object EOF_MARKER = new java.lang.Object();

  private final SettableApiFuture<Object> result;
  private final ZeroCopyServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> read;
  private final ReadObjectRequest req;
  private final Hasher hasher;
  private final Retrier retrier;
  private final ResultRetryAlgorithm<?> alg;
  private final SimpleBlockingQueue<java.lang.Object> queue;

  private final AtomicLong fetchOffset;
  private volatile ReadObjectObserver readObjectObserver;
  private volatile boolean open = true;
  private volatile boolean complete = false;

  private long blobOffset;
  private Object metadata;

  private ReadObjectResponseChildRef leftovers;

  GapicUnbufferedReadableByteChannel(
      SettableApiFuture<Object> result,
      ZeroCopyServerStreamingCallable<ReadObjectRequest, ReadObjectResponse> read,
      ReadObjectRequest req,
      Hasher hasher,
      Retrier retrier,
      ResultRetryAlgorithm<?> alg) {
    this.result = result;
    this.read = read;
    this.req = req;
    this.hasher = hasher;
    this.fetchOffset = new AtomicLong(req.getReadOffset());
    this.blobOffset = req.getReadOffset();
    this.retrier = retrier;
    this.alg =
        new BasicResultRetryAlgorithm<java.lang.Object>() {
          @Override
          public boolean shouldRetry(
              Throwable previousThrowable, java.lang.Object previousResponse) {
            // unfortunately we can't unit test this as this time, because WatchdogTimeoutException
            // does not have a publicly accessible way of constructing it.
            boolean isWatchdogTimeout =
                previousThrowable instanceof StorageException
                    && previousThrowable.getCause() instanceof WatchdogTimeoutException;
            boolean isChecksumMismatch =
                previousThrowable instanceof StorageException
                    && previousThrowable.getCause() instanceof UncheckedChecksumMismatchException;
            boolean shouldRetry =
                isWatchdogTimeout || isChecksumMismatch || alg.shouldRetry(previousThrowable, null);
            if (previousThrowable != null && !shouldRetry) {
              result.setException(previousThrowable);
            }
            return shouldRetry;
          }
        };
    // The reasoning for 2 elements below allow for a single response and the EOF/error signal
    // from onComplete or onError. Same thing com.google.api.gax.rpc.QueuingResponseObserver does.
    this.queue = new SimpleBlockingQueue<>(2);
  }

  @Override
  public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
    if (complete && open) {
      close();
      return -1;
    }
    if (!open) {
      throw new ClosedChannelException();
    }

    long totalBufferCapacity = Buffers.totalRemaining(dsts, offset, length);
    ReadCursor c = new ReadCursor(blobOffset, blobOffset + totalBufferCapacity);
    while (c.hasRemaining()) {
      if (leftovers != null) {
        leftovers.copy(c, dsts, offset, length);
        if (!leftovers.hasRemaining()) {
          leftovers.close();
          leftovers = null;
        }
        continue;
      }

      ensureStreamOpen();
      java.lang.Object take;
      try {
        take = queue.poll();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new InterruptedIOException();
      }
      if (take instanceof IOException) {
        IOException ioe = (IOException) take;
        if (alg.shouldRetry(ioe, null)) {
          readObjectObserver = null;
          continue;
        } else {
          ioe.addSuppressed(new AsyncStorageTaskException());
          throw ioe;
        }
      }
      if (take instanceof Throwable) {
        Throwable throwable = (Throwable) take;
        BaseServiceException coalesce = StorageException.coalesce(throwable);
        if (alg.shouldRetry(coalesce, null)) {
          readObjectObserver = null;
          continue;
        } else {
          close();
          throw new IOException(coalesce);
        }
      }
      if (take == EOF_MARKER) {
        complete = true;
        break;
      }

      ReadObjectResponseChildRef ref = (ReadObjectResponseChildRef) take;
      ref.copy(c, dsts, offset, length);
      if (ref.hasRemaining()) {
        leftovers = ref;
      } else {
        ref.close();
      }
    }
    long read = c.read();

    blobOffset += read;

    return read;
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    open = false;
    try {
      if (leftovers != null) {
        leftovers.close();
      }
      ReadObjectObserver obs = readObjectObserver;
      if (obs != null && !obs.cancellation.isDone()) {
        obs.cancel();
        drainQueue();
        try {
          // make sure our waiting doesn't lockup permanently
          obs.cancellation.get(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          InterruptedIOException ioe = new InterruptedIOException();
          ioe.initCause(e);
          ioe.addSuppressed(new AsyncStorageTaskException());
          throw ioe;
        } catch (ExecutionException e) {
          Throwable cause = e;
          if (e.getCause() != null) {
            cause = e.getCause();
          }
          IOException ioException = new IOException(cause);
          ioException.addSuppressed(new AsyncStorageTaskException());
          throw ioException;
        } catch (TimeoutException ignore) {
        }
      }
    } finally {
      drainQueue();
    }
  }

  private void drainQueue() throws IOException {
    boolean shouldInterupt = false;
    try {
      IOException ioException = null;
      while (queue.nonEmpty()) {
        try {
          java.lang.Object queueValue = queue.poll();
          if (queueValue instanceof ReadObjectResponse) {
            ReadObjectResponse resp = (ReadObjectResponse) queueValue;
            ResponseContentLifecycleHandle<ReadObjectResponse> handle =
                read.getResponseContentLifecycleManager().get(resp);
            handle.close();
          } else if (queueValue == EOF_MARKER || queueValue instanceof Throwable) {
            break;
          }
        } catch (IOException e) {
          if (ioException == null) {
            ioException = e;
          } else if (ioException != e) {
            ioException.addSuppressed(e);
          }
        } catch (InterruptedException e) {
          shouldInterupt = true;
          if (ioException == null) {
            ioException = new InterruptedIOException();
          } else {
            ioException.addSuppressed(e);
          }
        }
      }
      if (ioException != null) {
        throw ioException;
      }
    } finally {
      if (shouldInterupt) {
        Thread.currentThread().interrupt();
      }
    }
  }

  ApiFuture<Object> getResult() {
    return result;
  }

  private void ensureStreamOpen() {
    if (readObjectObserver == null) {
      java.lang.Object peek = queue.peek();
      if (peek instanceof Throwable || peek == EOF_MARKER) {
        // If our queue has an error or EOF, do not send another request
        return;
      }
      readObjectObserver =
          retrier.run(
              alg,
              () -> {
                ReadObjectObserver tmp = new ReadObjectObserver();
                ReadObjectRequest.Builder builder = req.toBuilder();
                long currentFetchOffset = fetchOffset.get();
                if (req.getReadOffset() != currentFetchOffset) {
                  builder.setReadOffset(currentFetchOffset);
                }
                if (metadata != null && req.getGeneration() == 0) {
                  builder.setGeneration(metadata.getGeneration());
                }
                read.call(builder.build(), tmp);
                ApiExceptions.callAndTranslateApiException(tmp.open);
                return tmp;
              },
              Decoder.identity());
    }
  }

  private IOException createError(String message) throws IOException {
    StorageException cause =
        new StorageException(HttpStatusCodes.STATUS_CODE_PRECONDITION_FAILED, message);
    return new IOException(message, cause);
  }

  private final class ReadObjectObserver extends StateCheckingResponseObserver<ReadObjectResponse> {

    private final SettableApiFuture<Void> open = SettableApiFuture.create();
    private final SettableApiFuture<Throwable> cancellation = SettableApiFuture.create();

    private volatile StreamController controller;

    void cancel() {
      controller.cancel();
    }

    @Override
    protected void onStartImpl(StreamController controller) {
      this.controller = controller;
      controller.disableAutoInboundFlowControl();
      controller.request(1);
    }

    @Override
    protected void onResponseImpl(ReadObjectResponse response) {
      controller.request(1);
      open.set(null);
      try (ResponseContentLifecycleHandle<ReadObjectResponse> handle =
          read.getResponseContentLifecycleManager().get(response)) {
        ChecksummedData checksummedData = response.getChecksummedData();
        ByteString content = checksummedData.getContent();
        int contentSize = content.size();
        // Very important to know whether a crc32c value is set. Without checking, protobuf will
        // happily return 0, which is a valid crc32c value.
        if (checksummedData.hasCrc32C()) {
          Crc32cLengthKnown expected = Crc32cValue.of(checksummedData.getCrc32C(), contentSize);
          try {
            hasher.validateUnchecked(expected, content);
          } catch (UncheckedChecksumMismatchException e) {
            queue.offer(e);
            return;
          }
        }
        if (response.hasMetadata()) {
          Object respMetadata = response.getMetadata();
          if (metadata == null) {
            metadata = respMetadata;
          } else if (metadata.getGeneration() != respMetadata.getGeneration()) {
            IOException exception =
                createError(
                    String.format(
                        Locale.US,
                        "Mismatch Generation between subsequent reads. Expected %d but received %d",
                        metadata.getGeneration(),
                        respMetadata.getGeneration()));
            queue.offer(exception);
            return;
          }
        }
        queue.offer(ReadObjectResponseChildRef.from(handle));
        fetchOffset.addAndGet(contentSize);
        if (response.hasMetadata() && !result.isDone()) {
          result.set(response.getMetadata());
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw Code.ABORTED.toStatus().withCause(e).asRuntimeException();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @Override
    protected void onErrorImpl(Throwable t) {
      if (t instanceof OutOfRangeException) {
        try {
          queue.offer(EOF_MARKER);
          open.set(null);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw Code.ABORTED.toStatus().withCause(e).asRuntimeException();
        }
      }
      if (t instanceof CancellationException) {
        cancellation.set(t);
      }
      if (!open.isDone()) {
        open.setException(t);
      }
      try {
        queue.offer(t);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw Code.ABORTED.toStatus().withCause(e).asRuntimeException();
      }
    }

    @Override
    protected void onCompleteImpl() {
      try {
        cancellation.set(null);
        queue.offer(EOF_MARKER);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw Code.ABORTED.toStatus().withCause(e).asRuntimeException();
      }
    }
  }

  /**
   * Simplified wrapper around an {@link java.util.concurrent.ArrayBlockingQueue}. We don't need the
   * majority of methods/functionality just blocking offer/poll.
   */
  static final class SimpleBlockingQueue<T> {

    private final ArrayBlockingQueue<T> queue;

    SimpleBlockingQueue(int poolMaxSize) {
      this.queue = new ArrayBlockingQueue<>(poolMaxSize);
    }

    public boolean nonEmpty() {
      return !queue.isEmpty();
    }

    @Nullable
    public T peek() {
      return queue.peek();
    }

    @NonNull
    public T poll() throws InterruptedException {
      return queue.take();
    }

    public void offer(@NonNull T element) throws InterruptedException {
      queue.put(element);
    }
  }

  private static final class ReadObjectResponseChildRef implements Closeable {
    private final ChildRef ref;
    private final Supplier<List<ByteBuffer>> lazyBuffers;

    ReadObjectResponseChildRef(ChildRef ref) {
      this.ref = ref;
      this.lazyBuffers = Suppliers.memoize(() -> ref.byteString().asReadOnlyByteBufferList());
    }

    static ReadObjectResponseChildRef from(
        ResponseContentLifecycleHandle<ReadObjectResponse> handle) {
      return new ReadObjectResponseChildRef(
          handle.borrow(response -> response.getChecksummedData().getContent()));
    }

    void copy(ReadCursor c, ByteBuffer[] dsts, int offset, int length) {
      List<ByteBuffer> buffers = lazyBuffers.get();
      for (ByteBuffer b : buffers) {
        long copiedBytes = Buffers.copy(b, dsts, offset, length);
        c.advance(copiedBytes);
        if (b.hasRemaining()) break;
      }
    }

    boolean hasRemaining() {
      List<ByteBuffer> buffers = lazyBuffers.get();
      for (ByteBuffer b : buffers) {
        if (b.hasRemaining()) return true;
      }
      return false;
    }

    public void close() throws IOException {
      ref.close();
    }
  }
}
