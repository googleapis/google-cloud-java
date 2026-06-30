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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.ThroughputSink.Record;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.Assert;
import org.junit.Test;

public final class ThroughputSinkTest {

  @Test
  public void tee_record() {
    AtomicReference<Record> r1 = new AtomicReference<>(null);
    AtomicReference<Record> r2 = new AtomicReference<>(null);
    ThroughputSink test =
        ThroughputSink.tee(
            new AbstractThroughputSink() {
              @Override
              public void recordThroughput(Record r) {
                r1.compareAndSet(null, r);
              }
            },
            new AbstractThroughputSink() {
              @Override
              public void recordThroughput(Record r) {
                r2.compareAndSet(null, r);
              }
            });

    Record expected = Record.of(10, Instant.EPOCH, Instant.ofEpochSecond(1), false);
    test.recordThroughput(expected);

    assertThat(r1.get()).isEqualTo(expected);
    assertThat(r2.get()).isEqualTo(expected);
  }

  @Test
  public void tee_decorate() throws Exception {
    AtomicReference<ByteBuffer> b1 = new AtomicReference<>(null);
    AtomicReference<ByteBuffer> b2 = new AtomicReference<>(null);
    AtomicReference<ByteBuffer> b3 = new AtomicReference<>(null);
    ThroughputSink test =
        ThroughputSink.tee(
            new AbstractThroughputSink() {
              @Override
              public WritableByteChannel decorate(WritableByteChannel wbc) {
                return new WritableByteChannel() {
                  @Override
                  public int write(ByteBuffer src) throws IOException {
                    b1.compareAndSet(null, src.duplicate());
                    return wbc.write(src);
                  }

                  @Override
                  public boolean isOpen() {
                    return wbc.isOpen();
                  }

                  @Override
                  public void close() throws IOException {
                    wbc.close();
                  }
                };
              }
            },
            new AbstractThroughputSink() {
              @Override
              public WritableByteChannel decorate(WritableByteChannel wbc) {
                return new WritableByteChannel() {
                  @Override
                  public int write(ByteBuffer src) throws IOException {
                    ByteBuffer duplicate = src.duplicate();
                    duplicate.position(src.limit());
                    b2.compareAndSet(null, duplicate);
                    return wbc.write(src);
                  }

                  @Override
                  public boolean isOpen() {
                    return wbc.isOpen();
                  }

                  @Override
                  public void close() throws IOException {
                    wbc.close();
                  }
                };
              }
            });

    AtomicBoolean callIsOpen = new AtomicBoolean(false);
    AtomicBoolean callClose = new AtomicBoolean(false);
    WritableByteChannel anon =
        new WritableByteChannel() {
          @Override
          public int write(ByteBuffer src) {
            int remaining = src.remaining();
            src.position(src.limit());
            b3.compareAndSet(null, src);
            return remaining;
          }

          @Override
          public boolean isOpen() {
            callIsOpen.compareAndSet(false, true);
            return true;
          }

          @Override
          public void close() {
            callClose.compareAndSet(false, true);
          }
        };

    byte[] bytes = DataGenerator.base64Characters().genBytes(16);

    ByteBuffer expected1 = ByteBuffer.wrap(bytes);
    ByteBuffer expected2 = ByteBuffer.wrap(bytes);
    expected2.position(16);

    ByteBuffer buf = ByteBuffer.wrap(bytes);
    try (WritableByteChannel decorated = test.decorate(anon)) {
      if (decorated.isOpen()) {
        decorated.write(buf);
      }
    }

    assertAll(
        () -> assertThat(b1.get()).isEqualTo(expected1),
        () -> assertThat(b2.get()).isEqualTo(expected2),
        () -> assertThat(b3.get()).isSameInstanceAs(buf),
        () -> assertThat(b3.get().hasRemaining()).isFalse(),
        () -> assertThat(callIsOpen.get()).isTrue(),
        () -> assertThat(callClose.get()).isTrue());
  }

  @Test
  public void computeThroughput_noError() throws IOException {
    // create a clock that will start at Epoch UTC, and will tick in one second increments
    TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));
    AtomicReference<Record> actual = new AtomicReference<>(null);

    ThroughputSink.computeThroughput(
        clock,
        new AbstractThroughputSink() {
          @Override
          public void recordThroughput(Record r) {
            actual.compareAndSet(null, r);
          }
        },
        300,
        () -> {});

    Record expected = Record.of(300, Instant.EPOCH, Instant.ofEpochSecond(1), false);
    assertThat(actual.get()).isEqualTo(expected);
  }

  @Test
  public void computeThroughput_ioError() {
    // create a clock that will start at Epoch UTC, and will tick in one second increments
    TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));
    AtomicReference<Record> actual = new AtomicReference<>(null);

    IOException ioException =
        Assert.assertThrows(
            IOException.class,
            () ->
                ThroughputSink.computeThroughput(
                    clock,
                    new AbstractThroughputSink() {
                      @Override
                      public void recordThroughput(Record r) {
                        actual.compareAndSet(null, r);
                      }
                    },
                    300,
                    () -> {
                      throw new IOException("kablamo!");
                    }));

    Record expected = Record.of(300, Instant.EPOCH, Instant.ofEpochSecond(1), true);
    assertThat(actual.get()).isEqualTo(expected);

    assertThat(ioException).hasMessageThat().isEqualTo("kablamo!");
  }

  @Test
  public void windowed() throws IOException {
    // create a clock that will start at Epoch UTC, and will tick in one second increments
    TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));

    AtomicReference<ByteBuffer> b3 = new AtomicReference<>(null);
    WritableByteChannel anon =
        new WritableByteChannel() {
          @Override
          public int write(ByteBuffer src) {
            int remaining = src.remaining();
            src.position(src.limit());
            b3.compareAndSet(null, src);
            return remaining;
          }

          @Override
          public boolean isOpen() {
            return true;
          }

          @Override
          public void close() {}
        };

    Duration windowDuration = Duration.ofMinutes(1);
    ThroughputMovingWindow window = ThroughputMovingWindow.of(windowDuration);
    ThroughputSink sink = ThroughputSink.windowed(window, clock);

    int numBytes = 120;
    ByteBuffer buf = DataGenerator.base64Characters().genByteBuffer(numBytes);
    try (WritableByteChannel decorated = sink.decorate(anon)) {
      decorated.write(buf);
    }

    Throughput avg = window.avg(clock.instant());

    assertThat(avg).isEqualTo(Throughput.of(numBytes, windowDuration));
    assertThat(avg).isEqualTo(Throughput.bytesPerSecond(2));
  }

  private abstract static class AbstractThroughputSink implements ThroughputSink {

    @Override
    public void recordThroughput(Record r) {}

    @Override
    public WritableByteChannel decorate(WritableByteChannel wbc) {
      return null;
    }

    @Override
    public GatheringByteChannel decorate(GatheringByteChannel wbc) {
      return null;
    }
  }
}
