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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public final class LazyReadChannelTest {

  private final AtomicInteger counter = new AtomicInteger(1);

  @Test
  public void repeatedCallsOfGetSessionMustReturnTheSameInstance() {
    LazyReadChannel<BufferedReadableByteChannel, String> lrc =
        new LazyReadChannel<>(this::newTestSession);

    ReadableByteChannelSession<BufferedReadableByteChannel, String> session1 = lrc.getSession();
    ReadableByteChannelSession<BufferedReadableByteChannel, String> session2 = lrc.getSession();
    assertThat(session1).isSameInstanceAs(session2);
  }

  @Test
  public void repeatedCallsOfGetChannelMustReturnTheSameInstance() {
    LazyReadChannel<BufferedReadableByteChannel, String> lrc =
        new LazyReadChannel<>(this::newTestSession);

    BufferedReadableByteChannel channel1 = lrc.getChannel();
    BufferedReadableByteChannel channel2 = lrc.getChannel();
    assertThat(channel1).isSameInstanceAs(channel2);
  }

  @Test
  public void isNotOpenUntilGetChannelIsCalled() {
    LazyReadChannel<BufferedReadableByteChannel, String> lrc =
        new LazyReadChannel<>(this::newTestSession);

    assertThat(lrc.isOpen()).isFalse();
    BufferedReadableByteChannel channel = lrc.getChannel();
    assertThat(channel.isOpen()).isTrue();

    assertThat(lrc.isOpen()).isTrue();
  }

  @Test
  public void closingUnderlyingChannelClosesTheLazyReadChannel() throws IOException {
    LazyReadChannel<BufferedReadableByteChannel, String> lrc =
        new LazyReadChannel<>(this::newTestSession);

    BufferedReadableByteChannel channel = lrc.getChannel();
    assertThat(channel.isOpen()).isTrue();
    channel.close();
    assertThat(lrc.isOpen()).isFalse();
  }

  private TestSession newTestSession() {
    return new TestSession(String.format(Locale.US, "test-%02d", counter.getAndIncrement()));
  }

  private static final class TestSession implements BufferedReadableByteChannelSession<String> {

    private final String s;
    private final ApiFuture<BufferedReadableByteChannel> channel;
    private final ApiFuture<String> result;

    private TestSession(String s) {
      this.s = s;
      this.channel = ApiFutures.immediateFuture(new TestChannel());
      this.result = ApiFutures.immediateFuture(s);
    }

    @Override
    public ApiFuture<BufferedReadableByteChannel> openAsync() {
      return channel;
    }

    @Override
    public ApiFuture<String> getResult() {
      return result;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("s", s)
          .add("channel", channel)
          .add("result", result)
          .toString();
    }
  }

  private static final class TestChannel implements BufferedReadableByteChannel {

    boolean open = true;

    @Override
    public int read(ByteBuffer dst) throws IOException {
      if (!open) {
        throw new ClosedChannelException();
      }
      return 0;
    }

    @Override
    public boolean isOpen() {
      return open;
    }

    @Override
    public void close() {
      open = false;
    }
  }
}
