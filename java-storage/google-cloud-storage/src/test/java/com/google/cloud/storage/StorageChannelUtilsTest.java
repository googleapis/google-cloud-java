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

import static com.google.cloud.storage.StorageChannelUtils.blockingEmptyTo;
import static com.google.cloud.storage.StorageChannelUtils.blockingFillFrom;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public final class StorageChannelUtilsTest {

  @Test
  public void emptyTo_fullyConsumed() throws Exception {
    ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(16);
    AtomicInteger writeInvocationCount = new AtomicInteger(0);
    int written =
        blockingEmptyTo(
            buf,
            new SimpleWritableByteChannel() {
              @Override
              public int write(ByteBuffer src) {
                int i = writeInvocationCount.getAndIncrement();
                if (i % 2 == 0) {
                  return 0;
                } else {
                  src.get();
                  return 1;
                }
              }
            });
    assertAll(
        () -> assertThat(written).isEqualTo(16),
        () -> assertThat(writeInvocationCount.get()).isEqualTo(32),
        () -> assertThat(buf.hasRemaining()).isFalse());
  }

  @Test
  public void emptyTo_errorPropagated() throws Exception {
    ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(16);
    AtomicInteger writeInvocationCount = new AtomicInteger(0);
    IOException ioException =
        assertThrows(
            IOException.class,
            () ->
                blockingEmptyTo(
                    buf,
                    new SimpleWritableByteChannel() {
                      @Override
                      public int write(ByteBuffer src) throws IOException {
                        int i = writeInvocationCount.incrementAndGet();
                        if (i == 0) {
                          return 0;
                        } else if (i == 3) {
                          throw new IOException("boom boom");
                        } else {
                          src.get();
                          return 1;
                        }
                      }
                    }));
    assertAll(
        () -> assertThat(ioException).hasMessageThat().isEqualTo("boom boom"),
        () -> assertThat(writeInvocationCount.get()).isEqualTo(3),
        () -> assertThat(buf.position()).isEqualTo(2));
  }

  @Test
  public void fillFrom_fullyConsumed_dstGtEq_data() throws Exception {
    ByteBuffer data = DataGenerator.base64Characters().genByteBuffer(16);
    AtomicInteger readInvocationCount = new AtomicInteger(0);
    ByteBuffer buf = ByteBuffer.allocate(32);
    int read =
        blockingFillFrom(
            buf,
            new SimpleReadableByteChannel() {
              @Override
              public int read(ByteBuffer dst) {
                readInvocationCount.getAndIncrement();
                if (!data.hasRemaining()) {
                  return -1;
                } else {
                  dst.put(data.get());
                  return 1;
                }
              }
            });
    assertAll(
        () -> assertThat(read).isEqualTo(16),
        () -> assertThat(readInvocationCount.get()).isEqualTo(16 + 1), // + 1 to read EOF
        () -> assertThat(data.hasRemaining()).isFalse(),
        () -> assertThat(buf.position()).isEqualTo(16));
  }

  @Test
  public void fillFrom_fullyConsumed_dstLt_data() throws Exception {
    ByteBuffer data = DataGenerator.base64Characters().genByteBuffer(16);
    AtomicInteger readInvocationCount = new AtomicInteger(0);
    ByteBuffer buf = ByteBuffer.allocate(8);
    int read =
        blockingFillFrom(
            buf,
            new SimpleReadableByteChannel() {
              @Override
              public int read(ByteBuffer dst) {
                readInvocationCount.getAndIncrement();
                if (!data.hasRemaining()) {
                  return -1;
                } else {
                  dst.put(data.get());
                  return 1;
                }
              }
            });
    assertAll(
        () -> assertThat(read).isEqualTo(8),
        () -> assertThat(readInvocationCount.get()).isEqualTo(8),
        () -> assertThat(data.hasRemaining()).isTrue(),
        () -> assertThat(buf.position()).isEqualTo(8));
  }

  @Test
  public void fillFrom_eofPropagated() throws Exception {
    AtomicInteger readInvocationCount = new AtomicInteger(0);
    ByteBuffer buf = ByteBuffer.allocate(8);
    int read =
        blockingFillFrom(
            buf,
            new SimpleReadableByteChannel() {
              @Override
              public int read(ByteBuffer dst) {
                readInvocationCount.getAndIncrement();
                return -1;
              }
            });
    assertAll(
        () -> assertThat(read).isEqualTo(-1),
        () -> assertThat(readInvocationCount.get()).isEqualTo(1),
        () -> assertThat(buf.position()).isEqualTo(0));
  }

  @Test
  public void fillFrom_errorPropagated() throws Exception {
    ByteBuffer data = DataGenerator.base64Characters().genByteBuffer(16);
    AtomicInteger readInvocationCount = new AtomicInteger(0);
    ByteBuffer buf = ByteBuffer.allocate(32);
    IOException ioException =
        assertThrows(
            IOException.class,
            () ->
                blockingFillFrom(
                    buf,
                    new SimpleReadableByteChannel() {
                      @Override
                      public int read(ByteBuffer dst) throws IOException {
                        int i = readInvocationCount.incrementAndGet();
                        if (i == 0) {
                          return 0;
                        } else if (i == 3) {
                          throw new IOException("boom boom");
                        } else {
                          dst.put(data.get());
                          return 1;
                        }
                      }
                    }));
    assertAll(
        () -> assertThat(ioException).hasMessageThat().isEqualTo("boom boom"),
        () -> assertThat(readInvocationCount.get()).isEqualTo(3),
        () -> assertThat(buf.position()).isEqualTo(2),
        () -> assertThat(buf.position()).isEqualTo(2));
  }

  @Test
  public void fillFrom_handles_0SizeRead_someBytesRead() throws Exception {
    byte[] bytes = new byte[14];
    ByteBuffer buf = ByteBuffer.wrap(bytes);

    byte[] expected =
        new byte[] {
          (byte) 'A',
          (byte) 'B',
          (byte) 'C',
          (byte) 'A',
          (byte) 'B',
          (byte) 'A',
          (byte) 'A',
          (byte) 'A',
          (byte) 'B',
          (byte) 'A',
          (byte) 'B',
          (byte) 'C',
          (byte) 0,
          (byte) 0
        };

    int[] acceptSequence = new int[] {3, 2, 1, 0, 0, 1, 2, 3};
    AtomicInteger readCount = new AtomicInteger(0);

    int filled =
        blockingFillFrom(
            buf,
            new SimpleReadableByteChannel() {
              @Override
              public int read(ByteBuffer dst) {
                int i = readCount.getAndIncrement();
                if (i == acceptSequence.length) {
                  return -1;
                }
                int bytesToRead = acceptSequence[i];
                if (bytesToRead > 0) {
                  long copy =
                      Buffers.copy(
                          DataGenerator.base64Characters().genByteBuffer(bytesToRead), dst);
                  assertThat(copy).isEqualTo(bytesToRead);
                }

                return bytesToRead;
              }
            });

    assertAll(
        () -> assertThat(filled).isEqualTo(12),
        () -> assertThat(xxd(bytes)).isEqualTo(xxd(expected)));
  }

  private abstract static class SimpleWritableByteChannel implements WritableByteChannel {

    @Override
    public boolean isOpen() {
      return true;
    }

    @Override
    public void close() {}
  }

  private abstract static class SimpleReadableByteChannel implements ReadableByteChannel {

    @Override
    public boolean isOpen() {
      return true;
    }

    @Override
    public void close() {}
  }
}
