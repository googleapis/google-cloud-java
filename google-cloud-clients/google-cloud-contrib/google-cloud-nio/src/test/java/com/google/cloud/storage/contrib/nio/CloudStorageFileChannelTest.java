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
public class CloudStorageFileChannelTest {
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
      byte[] tmp = new byte[dst.remaining()];
      data.get(tmp);
      dst.put(tmp);
      return tmp.length;
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      int res = src.remaining();
      if (data.position() + res > data.capacity()) {
        ByteBuffer newData = ByteBuffer.allocate(data.capacity() + res);
        int currentPos = data.position();
        data.position(0);
        newData.put(data);
        data = newData;
        data.position(currentPos);
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
      if (newPosition >= data.capacity()) {
        ByteBuffer newData = ByteBuffer.allocate((int) newPosition);
        newData.put(data);
        data = newData;
      }
      data.position((int) newPosition);
      return this;
    }

    @Override
    public long size() throws IOException {
      return data.capacity();
    }

    @Override
    public SeekableByteChannel truncate(long size) throws IOException {
      if (size < data.capacity()) {
        int position = data.position();
        ByteBuffer newData = ByteBuffer.allocate((int) size);
        newData.put(data.array(), 0, (int) size);
        data = newData;
        data.position(position > (int) size ? (int) size : position);
      }
      return this;
    }
  }

  @Rule
  public final ExpectedException thrown = ExpectedException.none();

  private CloudStorageFileChannel fileChannel;
  private SeekableByteChannel writeChannel;

  @Before
  public void before() throws IOException {
    ByteBuffer data = ByteBuffer.wrap(new byte[] {1, 2, 3});
    writeChannel = new SeekableByteChannelImpl(data);
    fileChannel = new CloudStorageFileChannel(writeChannel);
  }

  @Test
  public void testRead() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.read(buffer), is(equalTo(1)));
    assertThat(fileChannel.position(), is(equalTo(1L)));
    assertThat(buffer.get(0), is(equalTo((byte) 1)));
  }

  @Test
  public void testReadArray() throws IOException {
    ByteBuffer[] buffers =
        new ByteBuffer[] {ByteBuffer.allocate(1), ByteBuffer.allocate(1), ByteBuffer.allocate(1)};
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.read(buffers), is(equalTo(3L)));
    assertThat(fileChannel.position(), is(equalTo(3L)));
    assertThat(buffers[0].get(0), is(equalTo((byte) 1)));
    assertThat(buffers[1].get(0), is(equalTo((byte) 2)));
    assertThat(buffers[2].get(0), is(equalTo((byte) 3)));
  }

  @Test
  public void testWrite() throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(1);
    buffer.put((byte) 100).position(0);
    assertThat(fileChannel.position(), is(equalTo(0L)));
    assertThat(fileChannel.write(buffer), is(equalTo(1)));
    assertThat(fileChannel.position(), is(equalTo(1L)));

    ByteBuffer read = ByteBuffer.allocate(1);
    fileChannel.position(0);
    fileChannel.read(read);
    assertThat(read.get(0), is(equalTo((byte) 100)));
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

    ByteBuffer[] read =
        new ByteBuffer[] {ByteBuffer.allocate(1), ByteBuffer.allocate(1), ByteBuffer.allocate(1)};
    fileChannel.position(0);
    fileChannel.read(read);
    assertThat(read[0].get(0), is(equalTo((byte) 10)));
    assertThat(read[1].get(0), is(equalTo((byte) 20)));
    assertThat(read[2].get(0), is(equalTo((byte) 30)));
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
  public void testTransferTo() throws IOException {
    SeekableByteChannelImpl target = new SeekableByteChannelImpl(ByteBuffer.allocate(100));
    assertThat(fileChannel.transferTo(0L, 3L, target), is(equalTo(3L)));
    assertThat(target.position(), is(equalTo(3L)));
    ByteBuffer dst = ByteBuffer.allocate(3);
    target.read(dst);
  }

}
