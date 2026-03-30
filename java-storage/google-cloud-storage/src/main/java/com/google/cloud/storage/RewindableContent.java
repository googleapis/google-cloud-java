/*
 * Copyright 2023 Google LLC
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

import com.google.api.client.http.AbstractHttpContent;
import com.google.api.client.http.HttpMediaType;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.Hasher.GuavaHasher;
import com.google.cloud.storage.Hasher.NoOpHasher;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.Nullable;

abstract class RewindableContent extends AbstractHttpContent {

  private RewindableContent() {
    super((HttpMediaType) null);
  }

  @Override
  public abstract long getLength();

  abstract void rewindTo(long offset);

  abstract long writeTo(WritableByteChannel gbc) throws IOException;

  abstract long writeTo(GatheringByteChannel gbc) throws IOException;

  abstract void flagDirty();

  @Override
  public final boolean retrySupported() {
    return false;
  }

  @Nullable
  abstract Crc32cLengthKnown getCrc32c();

  static RewindableContent empty() {
    return EmptyRewindableContent.INSTANCE;
  }

  static RewindableContent of(ByteBuffer... buffers) {
    return new ByteBufferContent(buffers);
  }

  public static RewindableContent of(ByteBuffer[] srcs, int srcsOffset, int srcsLength) {
    Preconditions.checkNotNull(srcs, "srcs must be non null");
    if (!(0 <= srcsOffset && srcsOffset <= srcs.length)) {
      throw new ArrayIndexOutOfBoundsException(
          String.format(
              Locale.US,
              "srcsOffset out of bounds (0 <= %d && %d <= %d)",
              srcsOffset,
              srcsOffset,
              srcs.length));
    }
    Preconditions.checkArgument(srcsLength >= 0, "srcsLength >= 0 (%d >= 0)", srcsLength);
    int end = srcsOffset + srcsLength;
    return new ByteBufferContent(Arrays.copyOfRange(srcs, srcsOffset, end));
  }

  static RewindableContent of(Path path) throws IOException {
    return new PathRewindableContent(path);
  }

  private static final class EmptyRewindableContent extends RewindableContent {
    private static final EmptyRewindableContent INSTANCE = new EmptyRewindableContent();

    @Override
    public long getLength() {
      return 0L;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
      out.flush();
    }

    @Override
    long writeTo(WritableByteChannel gbc) {
      return 0;
    }

    @Override
    long writeTo(GatheringByteChannel gbc) {
      return 0;
    }

    @Override
    protected void rewindTo(long offset) {}

    @Override
    void flagDirty() {}

    @Override
    @Nullable Crc32cLengthKnown getCrc32c() {
      return Hasher.defaultHasher().initialValue();
    }
  }

  private static final class PathRewindableContent extends RewindableContent {

    private final Path path;
    private final long size;

    private long readOffset;

    private PathRewindableContent(Path path) throws IOException {
      this.path = path;
      this.size = Files.size(path);
      this.readOffset = 0;
    }

    @Override
    public long getLength() {
      return size - readOffset;
    }

    @Override
    void rewindTo(long offset) {
      Preconditions.checkArgument(
          offset < size, "provided offset must be less than size (%d < %d)", offset, size);
      this.readOffset = offset;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
      try (SeekableByteChannel in = Files.newByteChannel(path, StandardOpenOption.READ)) {
        in.position(readOffset);
        ByteStreams.copy(in, Channels.newChannel(out));
        out.flush();
      }
    }

    @Override
    long writeTo(WritableByteChannel gbc) throws IOException {
      try (SeekableByteChannel in = Files.newByteChannel(path, StandardOpenOption.READ)) {
        in.position(readOffset);
        return ByteStreams.copy(in, gbc);
      }
    }

    @Override
    long writeTo(GatheringByteChannel gbc) throws IOException {
      try (SeekableByteChannel in = Files.newByteChannel(path, StandardOpenOption.READ)) {
        in.position(readOffset);
        return ByteStreams.copy(in, gbc);
      }
    }

    @Override
    void flagDirty() {}

    @Override
    @Nullable Crc32cLengthKnown getCrc32c() {
      GuavaHasher hasher;
      {
        Hasher defaultHasher = Hasher.defaultHasher();
        if (defaultHasher instanceof NoOpHasher) {
          return null;
        } else {
          hasher = Hasher.enabled();
        }
      }
      Crc32cLengthKnown cumulative = Crc32cValue.zero();

      int bufferSize = 8192; // 8KiB buffer for reading chunks
      ByteBuffer buffer = ByteBuffer.allocate(bufferSize);

      try (SeekableByteChannel channel = Files.newByteChannel(path, StandardOpenOption.READ)) {
        while (channel.read(buffer) != -1) {
          buffer.flip();
          if (buffer.hasRemaining()) {
            cumulative = cumulative.concat(hasher.hash(buffer::duplicate));
          }
          buffer.clear();
        }
      } catch (IOException e) {
        throw new RuntimeException("Failed to read file for CRC32C calculation: " + path, e);
      }
      return cumulative;
    }
  }

  private static final class ByteBufferContent extends RewindableContent {

    private final ByteBuffer[] buffers;
    // keep an array of the positions in case we need to rewind them for retries
    // doing this is simpler than duplicating the buffers and using marks, as we don't need to
    // advance the position of the original buffers upon success.
    // We generally expect success, and in this case are planning in case of failure.
    private final int[] positions;
    private final long totalLength;
    // track whether we have changed any state
    private boolean dirty;

    private long offset;

    private ByteBufferContent(ByteBuffer[] buffers) {
      this.buffers = buffers;
      this.positions = Arrays.stream(buffers).mapToInt(Buffers::position).toArray();
      this.totalLength = Buffers.totalRemaining(buffers, 0, buffers.length);
      this.dirty = false;
    }

    @Override
    public long getLength() {
      return totalLength - offset;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
      dirty = true;
      WritableByteChannel c = Channels.newChannel(out);
      for (ByteBuffer buffer : buffers) {
        c.write(buffer);
      }
      out.flush();
    }

    @Override
    long writeTo(WritableByteChannel gbc) throws IOException {
      dirty = true;
      int retVal = 0;
      for (ByteBuffer buffer : buffers) {
        retVal += gbc.write(buffer);
      }
      return retVal;
    }

    @Override
    long writeTo(GatheringByteChannel gbc) throws IOException {
      dirty = true;
      return gbc.write(buffers);
    }

    @Override
    void rewindTo(long offset) {
      Preconditions.checkArgument(
          offset <= totalLength,
          "provided offset must be less than or equal to totalLength (%s <= %s)",
          offset,
          totalLength);
      if (dirty || offset != this.offset) {
        // starting from the end of our data, walk back the buffers updating their position
        // to coincide with the rewind of the overall content
        int idx = buffers.length - 1;
        for (long currentOffset = totalLength; currentOffset > 0; ) {
          int position = positions[idx];
          ByteBuffer buf = buffers[idx];

          int origRemaining = buf.limit() - position;

          long begin = currentOffset - origRemaining;

          if (begin <= offset && offset < currentOffset) {
            long diff = offset - begin;
            Buffers.position(buf, position + Math.toIntExact(diff));
          } else if (offset >= currentOffset) {
            // the desired offset is after this buf
            // ensure it does not have any available
            Buffers.position(buf, buf.limit());
          } else {
            Buffers.position(buf, position);
          }

          currentOffset = begin;
          idx -= 1;
        }
      }
      this.offset = offset;
    }

    @Override
    void flagDirty() {
      this.dirty = true;
    }

    @Override
    @Nullable Crc32cLengthKnown getCrc32c() {
      GuavaHasher hasher;
      {
        Hasher defaultHasher = Hasher.defaultHasher();
        if (defaultHasher instanceof NoOpHasher) {
          return null;
        } else {
          hasher = Hasher.enabled();
        }
      }
      Crc32cLengthKnown cumulative = Crc32cValue.zero();
      for (ByteBuffer buffer : buffers) {
        cumulative = cumulative.concat(hasher.hash(buffer::duplicate));
      }
      return cumulative;
    }
  }
}
