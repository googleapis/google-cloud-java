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

import static com.google.cloud.storage.StorageByteChannels.readable;
import static com.google.cloud.storage.TestUtils.snapshotData;
import static com.google.common.truth.Truth.assertThat;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.Test;

public final class ScatteringByteChannelFacadeTest {

  @Test
  public void lackOfAvailabilityDoesNotBlock() throws IOException {
    ByteArrayInputStream bais1 = new ByteArrayInputStream(new byte[] {0, 1, 2, 3, 4});
    ByteArrayInputStream bais2 = new ByteArrayInputStream(new byte[] {5, 6, 7, 8, 9});
    SequenceInputStream all = new SequenceInputStream(bais1, bais2);
    ReadableByteChannel rbc = Channels.newChannel(all);
    ScatteringByteChannel sbc = newSbc(rbc);

    ByteBuffer[] bufs = {ByteBuffer.allocate(6), ByteBuffer.allocate(6)};
    sbc.read(bufs);
    assertThat(snapshotData(bufs[0])).isEqualTo(new byte[] {0, 1, 2, 3, 4});
    assertThat(snapshotData(bufs[1])).isEqualTo(new byte[] {});
    sbc.read(bufs);
    assertThat(snapshotData(bufs[0])).isEqualTo(new byte[] {0, 1, 2, 3, 4, 5});
    assertThat(snapshotData(bufs[1])).isEqualTo(new byte[] {6, 7, 8, 9});
  }

  @Test
  public void lackOfCapacityReturnsFast() throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {0, 1, 2, 3, 4});
    ReadableByteChannel rbc = Channels.newChannel(bais);
    ScatteringByteChannel sbc = newSbc(rbc);

    ByteBuffer[] bufs = {ByteBuffer.allocate(0)};
    long read = sbc.read(bufs);
    assertThat(read).isEqualTo(0);
  }

  @Test
  public void readNegativeOneReturnIfPreviouslyReadBytes() throws IOException {
    ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {0});
    ReadableByteChannel rbc = Channels.newChannel(bais);
    ScatteringByteChannel sbc = newSbc(rbc);

    ByteBuffer[] bufs = {ByteBuffer.allocate(1), ByteBuffer.allocate(1)};
    long read = sbc.read(bufs);
    assertThat(read).isEqualTo(1);
    assertThat(snapshotData(bufs[0])).isEqualTo(new byte[] {0});
    assertThat(snapshotData(bufs[1])).isEqualTo(new byte[] {});
  }

  @Test
  public void readNegativeOneReturnsNegativeOneIfPreviouslyReadZeroBytes() throws IOException {
    AtomicBoolean closeCalled = new AtomicBoolean(false);
    ScatteringByteChannel sbc =
        newSbc(
            new ReadableByteChannelStub() {
              @Override
              public int read(ByteBuffer dst) {
                return -1;
              }

              @Override
              public boolean isOpen() {
                return true;
              }

              @Override
              public void close() {
                closeCalled.compareAndSet(false, true);
              }
            });

    ByteBuffer buf = ByteBuffer.allocate(1);
    int read = sbc.read(buf);
    assertThat(read).isEqualTo(-1);
    assertThat(snapshotData(buf)).isEqualTo(new byte[] {});
    assertThat(closeCalled.get()).isTrue();
  }

  @Test(expected = ClosedChannelException.class)
  public void closeChannelExceptionIfUnderlyingIsNotOpen() throws IOException {
    ScatteringByteChannel sbc = newSbc(new ClosedReadableByteChannel());
    sbc.read(null, 0, 0);
  }

  @Test
  public void openDelegates() {
    AtomicBoolean open = new AtomicBoolean(false);
    ScatteringByteChannel sbc =
        newSbc(
            new ReadableByteChannelStub() {
              @Override
              public boolean isOpen() {
                return open.get();
              }
            });

    assertThat(sbc.isOpen()).isFalse();
    open.set(true);
    assertThat(sbc.isOpen()).isTrue();
  }

  @Test
  public void closeDelegates() throws IOException {
    AtomicBoolean closeCalled = new AtomicBoolean(false);
    ScatteringByteChannel sbc =
        newSbc(
            new ReadableByteChannelStub() {
              @Override
              public void close() {
                closeCalled.compareAndSet(false, true);
              }
            });

    sbc.close();
    assertThat(closeCalled.get()).isTrue();
  }

  private static ScatteringByteChannel newSbc(ReadableByteChannel c) {
    return readable().asScatteringByteChannel(c);
  }

  private static final class ClosedReadableByteChannel implements ReadableByteChannel {

    @Override
    public int read(ByteBuffer dst) throws IOException {
      throw new ClosedChannelException();
    }

    @Override
    public boolean isOpen() {
      return false;
    }

    @Override
    public void close() {}
  }

  private abstract static class ReadableByteChannelStub implements ReadableByteChannel {

    @Override
    public int read(ByteBuffer dst) throws IOException {
      return 0;
    }

    @Override
    public boolean isOpen() {
      return false;
    }

    @Override
    public void close() throws IOException {}
  }
}
