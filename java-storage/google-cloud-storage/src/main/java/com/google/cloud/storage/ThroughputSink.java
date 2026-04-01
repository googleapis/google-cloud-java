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

import com.google.common.base.MoreObjects;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.WritableByteChannel;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * Interface to mark a location in which throughput of byte movements can be recorded, and which can
 * provide a decorated underlying channel.
 */
interface ThroughputSink {

  void recordThroughput(Record r);

  WritableByteChannel decorate(WritableByteChannel wbc);

  GatheringByteChannel decorate(GatheringByteChannel gbc);

  static void computeThroughput(Clock clock, ThroughputSink sink, long numBytes, IO io)
      throws IOException {
    boolean exception = false;
    Instant begin = clock.instant();
    try {
      io.apply();
    } catch (IOException e) {
      exception = true;
      throw e;
    } finally {
      Instant end = clock.instant();
      Record record = Record.of(numBytes, begin, end, exception);
      sink.recordThroughput(record);
    }
  }

  @FunctionalInterface
  interface IO {
    void apply() throws IOException;
  }

  static ThroughputSink logged(String prefix, Clock clock) {
    return new LoggedThroughputSink(prefix, clock);
  }

  static ThroughputSink windowed(ThroughputMovingWindow w, Clock clock) {
    return new ThroughputMovingWindowThroughputSink(w, clock);
  }

  static ThroughputSink tee(ThroughputSink a, ThroughputSink b) {
    return new TeeThroughputSink(a, b);
  }

  static ThroughputSink nullSink() {
    return NullThroughputSink.INSTANCE;
  }

  final class Record {
    private final long numBytes;
    private final Instant begin;
    private final Instant end;
    private final boolean exception;

    private Record(long numBytes, Instant begin, Instant end, boolean exception) {
      this.numBytes = numBytes;
      this.begin = begin;
      this.end = end;
      this.exception = exception;
    }

    public long getNumBytes() {
      return numBytes;
    }

    public Instant getBegin() {
      return begin;
    }

    public Instant getEnd() {
      return end;
    }

    public Duration getDuration() {
      return Duration.between(begin, end);
    }

    public boolean isException() {
      return exception;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof Record)) {
        return false;
      }
      Record record = (Record) o;
      return numBytes == record.numBytes
          && exception == record.exception
          && Objects.equals(begin, record.begin)
          && Objects.equals(end, record.end);
    }

    @Override
    public int hashCode() {
      return Objects.hash(numBytes, begin, end, exception);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("numBytes", numBytes)
          .add("begin", begin)
          .add("end", end)
          .add("exception", exception)
          .toString();
    }

    public static Record of(long numBytes, Instant begin, Instant end, boolean exception) {
      return new Record(numBytes, begin, end, exception);
    }
  }

  final class LoggedThroughputSink implements ThroughputSink {
    private static final Logger LOGGER = Logger.getLogger(ThroughputSink.class.getName());

    private final String prefix;
    private final Clock clock;

    private LoggedThroughputSink(String prefix, Clock clock) {
      this.prefix = prefix;
      this.clock = clock;
    }

    private static final double MiB = 1d / (1024 * 1024);

    @Override
    public void recordThroughput(Record r) {
      LOGGER.info(
          () ->
              String.format(
                  Locale.US,
                  "{%s} (%01.03f MiB/s) %s",
                  prefix,
                  ((r.numBytes * MiB)
                      / (Duration.between(r.getBegin(), r.getEnd()).toMillis() / 1000d)),
                  r));
    }

    @Override
    public WritableByteChannel decorate(WritableByteChannel wbc) {
      return new ThroughputRecordingWritableByteChannel(wbc, this, clock);
    }

    @Override
    public GatheringByteChannel decorate(GatheringByteChannel gbc) {
      return new ThroughputRecordingGatheringByteChannel(gbc, this, clock);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("prefix", prefix).add("clock", clock).toString();
    }
  }

  final class ThroughputRecordingWritableByteChannel implements WritableByteChannel {
    private final WritableByteChannel delegate;
    private final ThroughputSink sink;
    private final Clock clock;

    private ThroughputRecordingWritableByteChannel(
        WritableByteChannel delegate, ThroughputSink sink, Clock clock) {
      this.delegate = delegate;
      this.sink = sink;
      this.clock = clock;
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      return ThroughputRecordingWritableByteChannel.write(src, clock, delegate, sink);
    }

    @Override
    public boolean isOpen() {
      return delegate.isOpen();
    }

    @Override
    public void close() throws IOException {
      delegate.close();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("delegate", delegate)
          .add("sink", sink)
          .add("clock", clock)
          .toString();
    }

    static int write(ByteBuffer src, Clock clock, WritableByteChannel delegate, ThroughputSink sink)
        throws IOException {
      boolean exception = false;
      int remaining = src.remaining();
      Instant begin = clock.instant();
      try {
        return delegate.write(src);
      } catch (IOException e) {
        exception = true;
        throw e;
      } finally {
        Instant end = clock.instant();
        Record record = Record.of(remaining - src.remaining(), begin, end, exception);
        sink.recordThroughput(record);
      }
    }
  }

  final class ThroughputRecordingGatheringByteChannel implements GatheringByteChannel {
    private final GatheringByteChannel delegate;
    private final ThroughputSink sink;
    private final Clock clock;

    private ThroughputRecordingGatheringByteChannel(
        GatheringByteChannel delegate, ThroughputSink sink, Clock clock) {
      this.delegate = delegate;
      this.sink = sink;
      this.clock = clock;
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      return ThroughputRecordingWritableByteChannel.write(src, clock, delegate, sink);
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
      boolean exception = false;
      long available = Buffers.totalRemaining(srcs, offset, length);
      Instant begin = clock.instant();
      try {
        return delegate.write(srcs, offset, length);
      } catch (IOException e) {
        exception = true;
        throw e;
      } finally {
        Instant end = clock.instant();
        long remaining = Buffers.totalRemaining(srcs, offset, length);
        Record record = Record.of(available - remaining, begin, end, exception);
        sink.recordThroughput(record);
      }
    }

    @Override
    public long write(ByteBuffer[] srcs) throws IOException {
      boolean exception = false;
      long available = Buffers.totalRemaining(srcs, 0, srcs.length);
      Instant begin = clock.instant();
      try {
        return delegate.write(srcs);
      } catch (IOException e) {
        exception = true;
        throw e;
      } finally {
        Instant end = clock.instant();
        long remaining = Buffers.totalRemaining(srcs, 0, srcs.length);
        Record record = Record.of(available - remaining, begin, end, exception);
        sink.recordThroughput(record);
      }
    }

    @Override
    public boolean isOpen() {
      return delegate.isOpen();
    }

    @Override
    public void close() throws IOException {
      delegate.close();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("delegate", delegate)
          .add("sink", sink)
          .add("clock", clock)
          .toString();
    }
  }

  final class TeeThroughputSink implements ThroughputSink {
    private final ThroughputSink a;
    private final ThroughputSink b;

    private TeeThroughputSink(ThroughputSink a, ThroughputSink b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public void recordThroughput(Record r) {
      a.recordThroughput(r);
      b.recordThroughput(r);
    }

    @Override
    public WritableByteChannel decorate(WritableByteChannel wbc) {
      return b.decorate(a.decorate(wbc));
    }

    @Override
    public GatheringByteChannel decorate(GatheringByteChannel gbc) {
      return b.decorate(a.decorate(gbc));
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("a", a).add("b", b).toString();
    }
  }

  final class ThroughputMovingWindowThroughputSink implements ThroughputSink {
    private final ThroughputMovingWindow w;
    private final Clock clock;
    private final ReentrantLock lock;

    private ThroughputMovingWindowThroughputSink(ThroughputMovingWindow w, Clock clock) {
      this.w = w;
      this.clock = clock;
      this.lock = new ReentrantLock();
    }

    @Override
    public void recordThroughput(Record r) {
      lock.lock();
      try {
        w.add(r.end, Throughput.of(r.getNumBytes(), r.getDuration()));
      } finally {
        lock.unlock();
      }
    }

    @Override
    public WritableByteChannel decorate(WritableByteChannel wbc) {
      return new ThroughputRecordingWritableByteChannel(wbc, this, clock);
    }

    @Override
    public GatheringByteChannel decorate(GatheringByteChannel gbc) {
      return new ThroughputRecordingGatheringByteChannel(gbc, this, clock);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("w", w).add("clock", clock).toString();
    }
  }

  final class NullThroughputSink implements ThroughputSink {
    private static final NullThroughputSink INSTANCE = new NullThroughputSink();

    private NullThroughputSink() {}

    @Override
    public void recordThroughput(Record r) {}

    @Override
    public WritableByteChannel decorate(WritableByteChannel wbc) {
      return wbc;
    }

    @Override
    public GatheringByteChannel decorate(GatheringByteChannel gbc) {
      return gbc;
    }
  }
}
