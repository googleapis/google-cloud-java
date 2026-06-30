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

import static com.google.common.base.Preconditions.checkState;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import org.checkerframework.checker.nullness.qual.Nullable;

final class ObjectReadSessionSeekableByteChannel implements SeekableByteChannel, IOAutoCloseable {

  private final ObjectReadSession session;
  private final ReadAsSeekableChannel config;
  private final long size;
  private final ReadAsChannel channelConfig;
  private final IOAutoCloseable closeAlongWithThis;

  private ReadableByteChannel rbc;

  private long position;
  private boolean open = true;

  @Nullable private RangeSpec lastRangeSpec;

  ObjectReadSessionSeekableByteChannel(
      ObjectReadSession session, ReadAsSeekableChannel config, IOAutoCloseable closeAlongWithThis) {
    this.session = session;
    this.config = config;
    this.closeAlongWithThis = closeAlongWithThis;
    this.size = session.getResource().getSize();
    this.position = 0;
    this.channelConfig =
        ReadProjectionConfigs.asChannel()
            .withCrc32cValidationEnabled(config.getCrc32cValidationEnabled());
  }

  @Override
  public int read(ByteBuffer dst) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    if (remaining() <= 0) {
      return -1;
    }

    int totalRead = 0;
    if (rbc == null) {
      RangeSpec apply = config.getRangeSpecFunction().apply(position, lastRangeSpec);
      checkState(
          apply.begin() == position,
          "RangeSpec does not begin at provided position. expected = %s, actual = %s",
          position,
          apply.begin());
      rbc = session.readAs(channelConfig.withRangeSpec(apply));
      lastRangeSpec = apply;
    }

    int read = rbc.read(dst);
    if (read < 0) {
      rbc.close();
      rbc = null;
    } else {
      totalRead += read;
      position += read;
    }

    return totalRead;
  }

  private long remaining() {
    return size - position;
  }

  @Override
  public long size() throws IOException {
    return size;
  }

  @Override
  public long position() throws IOException {
    return position;
  }

  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    Preconditions.checkArgument(newPosition >= 0, "newPosition >= 0 (%s >= 0)", newPosition);
    if (position == newPosition) {
      return this;
    }
    position = newPosition;
    try (ReadableByteChannel ignore = rbc) {
      rbc = null;
    }
    return this;
  }

  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new UnsupportedOperationException("write(ByteBuffer)");
  }

  @Override
  public SeekableByteChannel truncate(long size) throws IOException {
    throw new UnsupportedOperationException("truncate(long)");
  }

  @Override
  public boolean isOpen() {
    return open;
  }

  @Override
  public void close() throws IOException {
    if (!open) {
      return;
    }
    try (IOAutoCloseable ignore1 = closeAlongWithThis;
        ReadableByteChannel ignore2 = rbc) {
      open = false;
      rbc = null;
    }
  }
}
