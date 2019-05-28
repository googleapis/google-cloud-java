/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.storage.contrib.nio;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SeekableByteChannel;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class CloudStorageWriteFileChannelTest {
  private static final class SeekableByteChannelImpl implements SeekableByteChannel {
    private boolean open = true;
    private ByteBuffer data;

    private SeekableByteChannelImpl(ByteBuffer data) {
      this.data = data;
    }

    @Override
    public boolean isOpen() {
      return open;
    }

    @Override
    public void close() throws IOException {
      open = false;
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
      byte[] tmp = new byte[Math.min(dst.remaining(), data.remaining())];
      if (tmp.length == 0) {
        return -1;
      } else {
        data.get(tmp);
        dst.put(tmp);
        return tmp.length;
      }
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      int res = src.remaining();
      if (data.position() + res > data.limit()) {
        data.limit(data.limit() + res);
      }
      data.put(src);
      return res;
    }

    @Override
    public long position() throws IOException {
      return data.position();
    }

    @Override
    public SeekableByteChannel position(long newPosition) throws IOException {
      if (newPosition >= data.limit()) {
        data.limit((int) newPosition);
      }
      data.position((int) newPosition);
      return this;
    }

    @Override
    public long size() throws IOException {
      return data.limit();
    }

    @Override
    public SeekableByteChannel truncate(long size) throws IOException {
      if (size < data.limit()) {
        if (data.position() >= size) {
          data.position((int) size - 1);
        }
        data.limit((int) size);
      }
      return this;
    }
  }

  @Rule public final ExpectedException thrown = ExpectedException.none();

  private CloudStorageWriteFileChannel fileChannel;
  private SeekableByteChannel writeChannel;
  private ByteBuffer data;

  @Before
  public void before() throws IOException {
    data = ByteBuffer.allocate(5000);
    data.limit(3);
    data.put(new byte[] {1, 2, 3});
    data.position(0);
    writeChannel = new SeekableByteChannelImpl(data);
    fileChannel = new CloudStorageWriteFileChannel(writeChannel);
  }

  @Test
  public void testWrite() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    buffer.put((byte) 100).position(0);
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.write(buffer), is(equalTo(1)));
    assertThat(fileChannel.position(), is(equalTo(1L)));
    assertThat(data.get(0), is(equalTo((byte) 100)));
  }

  @Test
  public void testWriteArray() throws IOException {
    ByteBuffer[] buffers =
        new ByteBuffer[] {ByteBuffer.allocate(1), ByteBuffer.allocate(1), ByteBuffer.allocate(1)};
    buffers[0].put((byte) 10).position(0);
    buffers[1].put((byte) 20).position(0);
    buffers[2].put((byte) 30).position(0);
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.write(buffers), is(equalTo(3L)));
    assertThat(fileChannel.position(), is(equalTo(3L)));

    assertThat(data.get(0), is(equalTo((byte) 10)));
    assertThat(data.get(1), is(equalTo((byte) 20)));
    assertThat(data.get(2), is(equalTo((byte) 30)));
  }

  @Test
  public void testPosition() throws IOException {
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.position(1L), is(equalTo((FileChannel) fileChannel)));
    assertThat(fileChannel.position(), is(equalTo(1L)));
    assertThat(fileChannel.position(0L), is(equalTo((FileChannel) fileChannel)));
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.position(100L), is(equalTo((FileChannel) fileChannel)));
    assertThat(fileChannel.position(), is(equalTo(100L)));
  }

  @Test
  public void testSizeAndTruncate() throws IOException {
    assertThat(fileChannel.size(), is(equalTo(3L)));
    fileChannel.truncate(1L);
    assertThat(fileChannel.size(), is(equalTo(1L)));
    fileChannel.truncate(10L);
    assertThat(fileChannel.size(), is(equalTo(1L)));
    assertThat(fileChannel.position(), is(equalTo(0L)));
  }

  @Test
  public void testTransferFrom() throws IOException {
    SeekableByteChannelImpl src = new SeekableByteChannelImpl(ByteBuffer.allocate(100));
    src.write(ByteBuffer.wrap(new byte[] {10, 20, 30}));
    src.position(0L);
    fileChannel.position(0L);
    assertThat(fileChannel.transferFrom(src, 0L, 3L), is(equalTo(3L)));
    assertThat(src.position(), is(equalTo(3L)));

    assertThat(data.get(0), is(equalTo((byte) 10)));
    assertThat(data.get(1), is(equalTo((byte) 20)));
    assertThat(data.get(2), is(equalTo((byte) 30)));
  }

  @Test
  public void testWriteOnPosition() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    buffer.put((byte) 100).position(0);
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.write(buffer, 0), is(equalTo(1)));
    assertThat(data.get(0), is(equalTo((byte) 100)));
  }

  @Test
  public void testWriteBeyondEnd() throws IOException {
    fileChannel.position(3L);
    ByteBuffer src = ByteBuffer.wrap(new byte[] {10, 20, 30});
    assertThat(fileChannel.write(src), is(equalTo(3)));
    assertThat(fileChannel.position(), is(equalTo(6L)));
    fileChannel.position(3L);
    assertThat(data.get(3), is(equalTo((byte) 10)));
    assertThat(data.get(4), is(equalTo((byte) 20)));
    assertThat(data.get(5), is(equalTo((byte) 30)));
  }
}
