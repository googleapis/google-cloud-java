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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.AccumulatingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.StreamingRead;
import com.google.cloud.storage.BaseObjectReadSessionStreamRead.ZeroCopyByteStringAccumulatingRead;
import com.google.cloud.storage.ObjectReadSessionStreamTest.TestObjectReadSessionStreamRead;
import com.google.cloud.storage.OtelStorageDecorator.OtelDecoratingObjectReadSessionStreamRead;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.protobuf.ByteString;
import com.google.protobuf.UnsafeByteOperations;
import com.google.storage.v2.ReadRange;
import io.opentelemetry.api.trace.Span;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;
import org.junit.Test;

public final class ObjectReadSessionStreamReadTest {

  @Test
  public void byteArrayAccumulatingRead_happyPath()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    byte[] genBytes = DataGenerator.base64Characters().genBytes(137);
    ByteString byteString = UnsafeByteOperations.unsafeWrap(genBytes);
    AtomicBoolean closed = new AtomicBoolean(false);
    Closeable close = () -> closed.set(true);
    ResponseContentLifecycleHandle<ByteString> handle =
        ResponseContentLifecycleHandle.create(byteString, close);
    ResponseContentLifecycleHandle<ByteString>.ChildRef childRef =
        handle.borrow(Function.identity());
    handle.close();

    AccumulatingRead<byte[]> byteArrayAccumulatingRead =
        ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry());

    byteArrayAccumulatingRead.accept(childRef);
    byteArrayAccumulatingRead.eof();

    String expectedBytes = xxd(genBytes);

    byte[] actualFutureBytes = byteArrayAccumulatingRead.get(1, TimeUnit.SECONDS);
    assertThat(xxd(actualFutureBytes)).isEqualTo(expectedBytes);
    assertThat(closed.get()).isTrue();
  }

  @Test
  public void byteArrayAccumulatingRead_childRef_close_ioException_propagated() throws IOException {
    byte[] genBytes = DataGenerator.base64Characters().genBytes(137);
    ByteString byteString = UnsafeByteOperations.unsafeWrap(genBytes);
    Closeable throwOnClose =
        () -> {
          throw new IOException(new Kaboom());
        };
    ResponseContentLifecycleHandle<ByteString> handle =
        ResponseContentLifecycleHandle.create(byteString, throwOnClose);
    ResponseContentLifecycleHandle<ByteString>.ChildRef childRef =
        handle.borrow(Function.identity());
    handle.close();

    AccumulatingRead<byte[]> byteArrayAccumulatingRead =
        ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry());

    IOException ioException =
        assertThrows(
            IOException.class,
            () -> {
              byteArrayAccumulatingRead.accept(childRef);
              byteArrayAccumulatingRead.eof();
            });
    assertThat(ioException).hasCauseThat().isInstanceOf(Kaboom.class);
  }

  @Test
  public void byteArrayAccumulatingRead_producesAnAccurateReadRange()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    int readId = 1;
    try (AccumulatingRead<byte[]> read =
        ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
            readId, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {

      ReadRange readRange1 = read.makeReadRange();
      ReadRange expectedReadRange1 =
          ReadRange.newBuilder().setReadId(readId).setReadOffset(0).setReadLength(137).build();
      assertThat(readRange1).isEqualTo(expectedReadRange1);

      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
      ByteString bytes2 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
      ByteString bytes3 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));

      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes1)) {
        read.accept(handle.borrow(Function.identity()));
      }

      ReadRange readRange2 = read.makeReadRange();
      ReadRange expectedReadRange2 =
          ReadRange.newBuilder().setReadId(readId).setReadOffset(64).setReadLength(73).build();
      assertThat(readRange2).isEqualTo(expectedReadRange2);

      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes2)) {
        read.accept(handle.borrow(Function.identity()));
      }

      ReadRange readRange3 = read.makeReadRange();
      ReadRange expectedReadRange3 =
          ReadRange.newBuilder().setReadId(readId).setReadOffset(128).setReadLength(9).build();
      assertThat(readRange3).isEqualTo(expectedReadRange3);

      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes3)) {
        read.accept(handle.borrow(Function.identity()));
        read.eof();
      }

      ReadRange readRange4 = read.makeReadRange();
      ReadRange expectedReadRange4 =
          ReadRange.newBuilder().setReadId(readId).setReadOffset(137).setReadLength(0).build();
      assertThat(readRange4).isEqualTo(expectedReadRange4);

      byte[] actualBytes = read.get(1, TimeUnit.SECONDS);
      assertThat(xxd(actualBytes)).isEqualTo(xxd(DataGenerator.base64Characters().genBytes(137)));
    }
  }

  @Test
  public void streamingRead_producesAnAccurateReadRange() throws Exception {
    int readId = 1;
    ExecutorService exec = Executors.newSingleThreadExecutor();
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            readId, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      ByteBuffer buffer = ByteBuffer.allocate(512);

      Future<Integer> f =
          exec.submit(
              () -> {
                try {
                  return Buffers.fillFrom(buffer, read);
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
              });

      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
      ByteString bytes2 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
      ByteString bytes3 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));

      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes1)) {
        read.accept(handle.borrow(Function.identity()));
      }
      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes2)) {
        read.accept(handle.borrow(Function.identity()));
      }
      try (ResponseContentLifecycleHandle<ByteString> handle = noopContentHandle(bytes3)) {
        read.accept(handle.borrow(Function.identity()));
        read.eof();
      }

      int copied = f.get(5, TimeUnit.SECONDS);
      assertAll(
          () -> assertThat(copied).isEqualTo(137),
          () ->
              assertThat(xxd(buffer))
                  .isEqualTo(xxd(DataGenerator.base64Characters().genBytes(137))));
    } finally {
      exec.shutdownNow();
    }
  }

  @Test
  public void streamingRead_shouldNotBlockWaitingForMessages() throws Exception {
    int readId = 1;
    ExecutorService exec = Executors.newSingleThreadExecutor();
    ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
    ByteString bytes2 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(64));
    ByteString bytes3 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(9));

    CountDownLatch accept1 = new CountDownLatch(1);
    CountDownLatch accept2 = new CountDownLatch(1);
    CountDownLatch accept3 = new CountDownLatch(1);
    CountDownLatch eof = new CountDownLatch(1);

    CountDownLatch accept1Ack = new CountDownLatch(1);
    CountDownLatch accept2Ack = new CountDownLatch(1);
    CountDownLatch accept3Ack = new CountDownLatch(1);
    CountDownLatch eofAck = new CountDownLatch(1);

    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            readId, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {

      Future<Void> f =
          exec.submit(
              () -> {
                try {
                  accept1.await();
                  try (ResponseContentLifecycleHandle<ByteString> handle =
                      noopContentHandle(bytes1)) {
                    read.accept(handle.borrow(Function.identity()));
                  }
                  accept1Ack.countDown();
                  accept2.await();
                  try (ResponseContentLifecycleHandle<ByteString> handle =
                      noopContentHandle(bytes2)) {
                    read.accept(handle.borrow(Function.identity()));
                  }
                  accept2Ack.countDown();
                  accept3.await();
                  try (ResponseContentLifecycleHandle<ByteString> handle =
                      noopContentHandle(bytes3)) {
                    read.accept(handle.borrow(Function.identity()));
                  }
                  accept3Ack.countDown();
                  eof.await();
                  read.eof();
                  eofAck.countDown();
                  return null;
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
              });
      ByteBuffer buffer = ByteBuffer.allocate(512);

      int read0 = read.read(buffer);
      assertThat(read0).isEqualTo(0);

      accept1.countDown();
      accept1Ack.await();
      int read1 = read.read(buffer);
      assertThat(read1).isEqualTo(64);

      accept2.countDown();
      accept2Ack.await();
      int read2 = read.read(buffer);
      assertThat(read2).isEqualTo(64);

      accept3.countDown();
      accept3Ack.await();
      int read3 = read.read(buffer);
      assertThat(read3).isEqualTo(9);

      eof.countDown();
      eofAck.await();
      int read4 = read.read(buffer);
      assertThat(read4).isEqualTo(-1);

      f.get(5, TimeUnit.SECONDS);

      assertThat(xxd(buffer)).isEqualTo(xxd(DataGenerator.base64Characters().genBytes(137)));
    } finally {
      accept1.countDown();
      accept2.countDown();
      accept3.countDown();
      eof.countDown();
      exec.shutdownNow();
    }
  }

  @Test
  public void streamingRead_fail() throws IOException {
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      read.fail(new Kaboom());

      IOException ioe = assertThrows(IOException.class, () -> read.read(ByteBuffer.allocate(1)));

      assertThat(ioe).hasCauseThat().isInstanceOf(StorageException.class);
      assertThat(ioe).hasCauseThat().hasCauseThat().isInstanceOf(Kaboom.class);
    }
  }

  @Test
  public void streamingRead_closedChannelException() throws IOException {
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      read.close();
      assertThat(read.isOpen()).isFalse();

      assertThrows(ClosedChannelException.class, () -> read.read(ByteBuffer.allocate(1)));
    }
  }

  @Test
  public void streamingRead_leftoversAreOnlyClearedWhenFullyConsumed() throws Exception {
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(62));
      AtomicBoolean bytes1Close = new AtomicBoolean(false);
      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes1, () -> bytes1Close.compareAndSet(false, true))) {
        read.accept(handle.borrow(Function.identity()));
      }

      ByteBuffer buf = ByteBuffer.allocate(512);
      ByteBuffer slice1 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read.read(slice1)).isEqualTo(16);
      buf.position(buf.position() + 16);
      ByteBuffer slice2 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read.read(slice2)).isEqualTo(16);
      buf.position(buf.position() + 16);
      ByteBuffer slice3 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read.read(slice3)).isEqualTo(16);
      buf.position(buf.position() + 16);
      ByteBuffer slice4 = (ByteBuffer) buf.slice().limit(14);
      assertThat(read.read(slice4)).isEqualTo(14);
      buf.position(buf.position() + 14);

      assertAll(
          () -> assertThat(bytes1Close.get()).isTrue(),
          () -> assertThat(xxd(buf)).isEqualTo(xxd(bytes1.toByteArray())));
    }
  }

  @Test
  public void streamingRead_eofShouldBeReturnedIfNoOtherBytesRead() throws Exception {
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      read.eof();
      assertThat(read.read(ByteBuffer.allocate(1))).isEqualTo(-1);
      assertThat(read.isOpen()).isTrue();
      read.close();
      assertThat(read.isOpen()).isFalse();
    }
  }

  @Test
  public void streamingRead_leftoversAreClosedIfNonNullAndStreamClosed() throws Exception {
    try (StreamingRead read =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(62));
      AtomicBoolean bytes1Close = new AtomicBoolean(false);
      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes1, () -> bytes1Close.compareAndSet(false, true))) {
        read.accept(handle.borrow(Function.identity()));
      }

      ByteBuffer buf = ByteBuffer.allocate(1);
      read.read(buf); // load into leftovers
      read.close();

      assertAll(() -> assertThat(bytes1Close.get()).isTrue());
    }
  }

  @Test
  public void streamingRead_withNewReadIdDoesNotOrphanAnyData() throws Exception {
    try (StreamingRead read1 =
        ObjectReadSessionStreamRead.streamingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry())) {
      ByteString bytes1 = ByteString.copyFrom(DataGenerator.base64Characters().genBytes(62));
      AtomicBoolean bytes1Close = new AtomicBoolean(false);
      try (ResponseContentLifecycleHandle<ByteString> handle =
          ResponseContentLifecycleHandle.create(
              bytes1, () -> bytes1Close.compareAndSet(false, true))) {
        read1.accept(handle.borrow(Function.identity()));
      }

      ByteBuffer buf = ByteBuffer.allocate(512);
      // read some bytes, causing leftovers to be populated
      ByteBuffer slice1 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read1.read(slice1)).isEqualTo(16);
      buf.position(buf.position() + 16);
      ByteBuffer slice2 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read1.read(slice2)).isEqualTo(16);
      buf.position(buf.position() + 16);

      // update read id (like would happen during a retry)
      StreamingRead read2 = read1.withNewReadId(2);
      assertThat(read2).isSameInstanceAs(read1);

      // make sure we can read from both read1 and read 2
      ByteBuffer slice3 = (ByteBuffer) buf.slice().limit(16);
      assertThat(read1.read(slice3)).isEqualTo(16);
      buf.position(buf.position() + 16);
      ByteBuffer slice4 = (ByteBuffer) buf.slice().limit(14);
      assertThat(read2.read(slice4)).isEqualTo(14);
      buf.position(buf.position() + 14);

      assertAll(
          () -> assertThat(bytes1Close.get()).isTrue(),
          () -> assertThat(xxd(buf)).isEqualTo(xxd(bytes1.toByteArray())));
    }
  }

  @Test
  public void canShareStreamWith() throws Exception {
    try (AccumulatingRead<byte[]> bytes =
            ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
                1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry());
        ZeroCopyByteStringAccumulatingRead byteString =
            ObjectReadSessionStreamRead.createZeroCopyByteStringAccumulatingRead(
                2, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry());
        StreamingRead streamingRead =
            ObjectReadSessionStreamRead.streamingRead(
                3, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry())) {
      assertAll(
          () -> assertThat(bytes.canShareStreamWith(byteString)).isTrue(),
          () -> assertThat(byteString.canShareStreamWith(bytes)).isTrue(),
          () -> assertThat(byteString.canShareStreamWith(streamingRead)).isFalse(),
          () -> assertThat(bytes.canShareStreamWith(streamingRead)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(byteString)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(bytes)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(streamingRead)).isFalse());
    }
  }

  @Test
  public void canShareStreamWith_otelDecorated() throws Exception {
    try (OtelDecoratingObjectReadSessionStreamRead<ApiFuture<byte[]>> bytes =
            new OtelDecoratingObjectReadSessionStreamRead<>(
                ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
                    1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry()),
                Span.getInvalid());
        OtelDecoratingObjectReadSessionStreamRead<ApiFuture<DisposableByteString>> byteString =
            new OtelDecoratingObjectReadSessionStreamRead<>(
                ObjectReadSessionStreamRead.createZeroCopyByteStringAccumulatingRead(
                    2, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry()),
                Span.getInvalid());
        OtelDecoratingObjectReadSessionStreamRead<ScatteringByteChannel> streamingRead =
            new OtelDecoratingObjectReadSessionStreamRead<>(
                ObjectReadSessionStreamRead.streamingRead(
                    3, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry()),
                Span.getInvalid())) {
      assertAll(
          () -> assertThat(bytes.canShareStreamWith(byteString)).isTrue(),
          () -> assertThat(byteString.canShareStreamWith(bytes)).isTrue(),
          () -> assertThat(byteString.canShareStreamWith(streamingRead)).isFalse(),
          () -> assertThat(bytes.canShareStreamWith(streamingRead)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(byteString)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(bytes)).isFalse(),
          () -> assertThat(streamingRead.canShareStreamWith(streamingRead)).isFalse());
    }
  }

  @Test
  public void onCloseCallbackIsCalled() throws IOException {
    final AtomicBoolean closed = new AtomicBoolean(false);

    try (TestObjectReadSessionStreamRead read = TestObjectReadSessionStreamRead.of()) {
      read.setOnCloseCallback(() -> closed.set(true));
    }

    assertThat(closed.get()).isTrue();
  }

  @Test
  public void onCloseCallbackIsCalled_evenIfThrown() throws Exception {
    final AtomicBoolean closed = new AtomicBoolean(false);

    TestObjectReadSessionStreamRead read =
        new TestObjectReadSessionStreamRead(1, RangeSpec.all(), RetryContext.neverRetry()) {
          @Override
          public void internalClose() throws IOException {
            throw new IOException("Kaboom");
          }
        };
    read.setOnCloseCallback(() -> closed.set(true));

    IOException ioException = assertThrows(IOException.class, read::close);

    assertAll(
        () -> assertThat(ioException).hasMessageThat().isEqualTo("Kaboom"),
        () -> assertThat(closed.get()).isTrue());
  }

  @Test
  public void accumulating_futureCancel_disposes() throws IOException {
    byte[] genBytes = DataGenerator.base64Characters().genBytes(137);
    ByteString byteString = UnsafeByteOperations.unsafeWrap(genBytes);
    AtomicBoolean closed = new AtomicBoolean(false);
    Closeable close = () -> closed.set(true);
    ResponseContentLifecycleHandle<ByteString> handle =
        ResponseContentLifecycleHandle.create(byteString, close);
    ResponseContentLifecycleHandle<ByteString>.ChildRef childRef =
        handle.borrow(Function.identity());
    handle.close();

    AccumulatingRead<byte[]> byteArrayAccumulatingRead =
        ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
            1, RangeSpec.of(0, 137), Hasher.enabled(), RetryContext.neverRetry());

    byteArrayAccumulatingRead.accept(childRef);

    byteArrayAccumulatingRead.cancel(true);

    assertThat(closed.get()).isTrue();
  }

  @Test
  public void projections() throws Exception {
    assertAll(
        () -> {
          AccumulatingRead<byte[]> read =
              ObjectReadSessionStreamRead.createByteArrayAccumulatingRead(
                  1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry());
          ApiFuture<byte[]> projected = read.project();
          assertThat(projected).isSameInstanceAs(read);
        },
        () -> {
          StreamingRead read =
              ObjectReadSessionStreamRead.streamingRead(
                  1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry());
          UnbufferedReadableByteChannel projected = read.project();
          assertThat(projected).isSameInstanceAs(read);
        },
        () -> {
          AccumulatingRead<ZeroCopySupport.DisposableByteString> read =
              ObjectReadSessionStreamRead.createZeroCopyByteStringAccumulatingRead(
                  1, RangeSpec.all(), Hasher.enabled(), RetryContext.neverRetry());
          ApiFuture<ZeroCopySupport.DisposableByteString> projected = read.project();
          assertThat(projected).isSameInstanceAs(read);
        });
  }

  private static ResponseContentLifecycleHandle<ByteString> noopContentHandle(
      ByteString byteString) {
    return ResponseContentLifecycleHandle.create(byteString, () -> {});
  }

  private static final class Kaboom extends RuntimeException {
    private Kaboom() {
      super("Kaboom!!!");
    }
  }
}
