/*
 * Copyright 2018 Google LLC
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

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * SeekableByteChannelPrefetcher wraps an existing SeekableByteChannel to add prefetching. The
 * prefetching is done on a different thread, so you can write simple code that repeatedly calls
 * read() to get data, processes it, and then calls read again -- and yet this simple code overlaps
 * computation and communication for you. (Of course this is only worthwhile if the underlying
 * SeekableByteChannel doesn't already implement prefetching).
 */
public final class SeekableByteChannelPrefetcher implements SeekableByteChannel {

  // Only one thread at a time should use chan.
  // To ensure this is the case, only the prefetching thread uses it.
  private final SeekableByteChannel chan;
  private final int bufSize;
  private final ExecutorService exec;
  private final long size;
  private final List<WorkUnit> full = new ArrayList<>();
  private WorkUnit fetching;
  // total number of buffers
  private static final int BUF_COUNT = 2;
  // where we pretend to be, wrt returning bytes from read()
  private long position;
  private boolean open;
  private Stopwatch betweenCallsToRead = Stopwatch.createUnstarted();
  private static int prefetcherCount;

  // statistics, for profiling.
  // time spent blocking the user because we're waiting on the network
  private long msWaitingForData;
  // time spent blocking the user because we're copying bytes
  private long msCopyingData;
  // total number of bytes returned by read (if the user asks for the same bytes multiple times,
  // they count)
  private long bytesReturned;
  // total number of bytes read over the network (whether returned to the user or not)
  private long bytesRead;
  // time spend in between calls to Read, ie. presumably while the user is processing the data we
  // returned.
  private long msBetweenCallsToRead;
  // number of times we had the user's data already ready, didn't have to grab it from the net.
  private long nbHit;
  // number of times we had already started to prefetch the user's data (but it hadn't arrived yet).
  private long nbNearHit;
  // number of times we don't have what the user's asking for, we have to wait for a prefetch to
  // finish,
  // and the prefetch didn't return what the user wanted (either they are going backward, or jumping
  // forward)
  private long nbMiss;
  // number of times the user asks for data with a lower index than what we already have
  // (so they're not following the expected pattern of increasing indexes)
  private long nbGoingBack;
  // number of times the user asks for data past the end of the file
  private long nbReadsPastEnd;
  // timing statistics have an overhead, so only turn them on when debugging performance
  // issues.
  private static final boolean trackTime = false;

  public static class Statistics {
    // statistics, for profiling.
    // time spent blocking the user because we're waiting on the network
    public final long msWaitingForData;
    // time spent blocking the user because we're copying bytes
    public final long msCopyingData;
    // total number of bytes returned by read (if the user asks for the same bytes multiple times,
    // they count)
    public final long bytesReturned;
    // total number of bytes read over the network (whether returned to the user or not)
    public final long bytesRead;
    // time spend in between calls to Read, ie. presumably while the user is processing the data we
    // returned.
    public final long msBetweenCallsToRead;
    // number of times we had the user's data already ready, didn't have to grab it from the net.
    public final long nbHit;
    // number of times we had already started to prefetch the user's data (but it hadn't arrived
    // yet).
    public final long nbNearHit;
    // number of times we don't have what the user's asking for, we have to wait for a prefetch to
    // finish,
    // and the prefetch didn't return what the user wanted (either they are going backward, or
    // jumping forward)
    public final long nbMiss;
    // number of times the user asks for data with a lower index than what we already have
    // (so they're not following the expected pattern of increasing indexes)
    public final long nbGoingBack;
    // number of times the user asks for data past the end of the file
    public final long nbReadsPastEnd;

    private Statistics(
        long msWaitingForData,
        long msCopyingData,
        long bytesReturned,
        long bytesRead,
        long msBetweenCallsToRead,
        long nbHit,
        long nbNearHit,
        long nbMiss,
        long nbGoingBack,
        long nbReadsPastEnd) {
      this.msWaitingForData = msWaitingForData;
      this.msCopyingData = msCopyingData;
      this.bytesReturned = bytesReturned;
      this.bytesRead = bytesRead;
      this.msBetweenCallsToRead = msBetweenCallsToRead;
      this.nbHit = nbHit;
      this.nbNearHit = nbNearHit;
      this.nbMiss = nbMiss;
      this.nbGoingBack = nbGoingBack;
      this.nbReadsPastEnd = nbReadsPastEnd;
    }

    public String toString() {
      try {
        double returnedPct = (bytesRead > 0 ? 100.0 * bytesReturned / bytesRead : 100.0);
        return String.format(
                "Bytes read: %12d\n  returned: %12d ( %3.2f %% )",
                bytesRead, bytesReturned, returnedPct)
            + String.format("\nReads past the end: %3d", nbReadsPastEnd)
            + String.format("\nReads forcing re-fetching of an earlier block: %3d", nbGoingBack)
            // A near-hit is when we're already fetching the data the user is asking for,
            // but we're not done loading it in.
            + String.format(
                "\nCache\n hits:      %12d\n near-hits: %12d\n misses:    %12d",
                nbHit, nbNearHit, nbMiss);
      } catch (UnknownFormatConversionException x) {
        // let's not crash the whole program, instead just return no info
        return "(error while formatting statistics)";
      }
    }
  }

  /**
   * Wraps the provided SeekableByteChannel within a SeekableByteChannelPrefetcher, using the
   * provided buffer size
   *
   * @param bufferSizeMB buffer size in MB
   * @param channel channel to wrap in the prefetcher
   * @return wrapped channel
   */
  public static SeekableByteChannel addPrefetcher(int bufferSizeMB, SeekableByteChannel channel)
      throws IOException {
    return new SeekableByteChannelPrefetcher(channel, bufferSizeMB * 1024 * 1024);
  }

  /**
   * WorkUnit holds a buffer and the instructions for what to put in it.
   *
   * <p>Use it like this:
   *
   * <ol>
   *   <li>call()
   *   <li>the data is now in buf, you can access it directly
   *   <li>if need more, call resetForIndex(...) and go back to the top.
   *   <li>else, call close()
   * </ol>
   */
  private static class WorkUnit implements Callable<ByteBuffer>, Closeable {
    public final ByteBuffer buf;
    public long blockIndex;
    private final SeekableByteChannel chan;
    private final int blockSize;
    private Future<ByteBuffer> futureBuf;

    public WorkUnit(SeekableByteChannel chan, int blockSize, long blockIndex) {
      this.chan = chan;
      this.buf = ByteBuffer.allocate(blockSize);
      this.futureBuf = null;
      this.blockSize = blockSize;
      this.blockIndex = blockIndex;
    }

    @Override
    public ByteBuffer call() throws IOException {
      long pos = ((long) blockSize) * blockIndex;
      if (pos > chan.size()) {
        return null;
      }
      if (pos < 0) {
        // This should never happen, if the code's correct.
        throw new IllegalArgumentException(
            "blockIndex "
                + blockIndex
                + " has position "
                + pos
                + ": negative position is not valid.");
      }
      chan.position(pos);
      // read until buffer is full, or EOF
      while (chan.read(buf) >= 0 && buf.hasRemaining()) {}
      return buf;
    }

    public ByteBuffer getBuf() throws ExecutionException, InterruptedException {
      return futureBuf.get();
    }

    public WorkUnit resetForIndex(long blockIndex) {
      this.blockIndex = blockIndex;
      buf.clear();
      futureBuf = null;
      return this;
    }

    @Override
    public void close() throws IOException {
      chan.close();
    }
  }

  /**
   * Wraps the provided SeekableByteChannel within a SeekableByteChannelPrefetcher, using the
   * provided buffer size.
   *
   * @param bufSize buffer size in bytes
   * @param chan channel to wrap in the prefetcher
   */
  private SeekableByteChannelPrefetcher(SeekableByteChannel chan, int bufSize) throws IOException {
    Preconditions.checkArgument(
        !(chan instanceof SeekableByteChannelPrefetcher),
        "Cannot wrap a prefetcher with a prefetcher.");

    if (!chan.isOpen()) {
      throw new IllegalArgumentException("channel must be open");
    }
    this.chan = chan;
    if (bufSize <= 0) {
      throw new IllegalArgumentException("bufSize must be positive");
    }
    this.size = chan.size();
    if (bufSize > this.size) {
      this.bufSize = (int) this.size;
    } else {
      this.bufSize = bufSize;
    }
    this.open = true;
    int prefetcherIndex = prefetcherCount++;
    // Make sure the prefetching thread's name indicate what it is and
    // which prefetcher it belongs to (for debugging purposes only, naturally).
    String nameFormat = "nio-prefetcher-" + prefetcherIndex + "-thread-%d";
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setNameFormat(nameFormat).setDaemon(true).build();
    // Single thread to ensure no concurrent access to chan.
    exec = Executors.newFixedThreadPool(1, threadFactory);
  }

  public Statistics getStatistics() {
    return new Statistics(
        msWaitingForData,
        msCopyingData,
        bytesReturned,
        bytesRead,
        msBetweenCallsToRead,
        nbHit,
        nbNearHit,
        nbMiss,
        nbGoingBack,
        nbReadsPastEnd);
  }

  // if we don't already have that block and the fetching thread is idle,
  // make sure it now goes looking for that block index.
  private void ensureFetching(long blockIndex) {
    if (fetching != null) {
      if (fetching.futureBuf.isDone()) {
        full.add(fetching);
        fetching = null;
      } else {
        return;
      }
    }
    for (WorkUnit w : full) {
      if (w.blockIndex == blockIndex) {
        return;
      }
    }
    if (full.size() < BUF_COUNT) {
      fetching = new WorkUnit(chan, bufSize, blockIndex);
    } else {
      // reuse the oldest full buffer
      fetching = full.remove(0);
      fetching.resetForIndex(blockIndex);
    }
    bytesRead += bufSize;
    fetching.futureBuf = exec.submit(fetching);
  }

  // Return a buffer at this position, blocking if necessary.
  // Start a background read of the buffer after this one (if there isn't one already).
  public ByteBuffer fetch(long position) throws InterruptedException, ExecutionException {
    long blockIndex = position / bufSize;
    boolean goingBack = false;
    for (WorkUnit w : full) {
      if (w.blockIndex == blockIndex) {
        ensureFetching(blockIndex + 1);
        nbHit++;
        return w.buf;
      } else if (w.blockIndex > blockIndex) {
        goingBack = true;
      }
    }
    if (goingBack) {
      // user is asking for a block with a lower index than we've already fetched -
      // in other words they are not following the expected pattern of increasing indexes.
      nbGoingBack++;
    }
    if (null == fetching) {
      ensureFetching(blockIndex);
    }
    WorkUnit candidate = fetching;
    // block until we have the buffer
    ByteBuffer buf = candidate.getBuf();
    full.add(candidate);
    fetching = null;
    if (candidate.blockIndex == blockIndex) {
      // this is who we were waiting for
      nbNearHit++;
      ensureFetching(blockIndex + 1);
      return buf;
    } else {
      // wrong block. Let's fetch the right one now.
      nbMiss++;
      ensureFetching(blockIndex);
      candidate = fetching;
      buf = candidate.getBuf();
      full.add(candidate);
      fetching = null;
      ensureFetching(blockIndex + 1);
      return buf;
    }
  }

  /**
   * Reads a sequence of bytes from this channel into the given buffer.
   *
   * <p>Bytes are read starting at this channel's current position, and then the position is updated
   * with the number of bytes actually read. Otherwise this method behaves exactly as specified in
   * the {@link java.nio.channels.ReadableByteChannel} interface.
   *
   * @param dst buffer to write into
   */
  @Override
  public synchronized int read(ByteBuffer dst) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    try {
      if (trackTime) {
        msBetweenCallsToRead += betweenCallsToRead.elapsed(TimeUnit.MILLISECONDS);
      }
      ByteBuffer src;
      try {
        Stopwatch waitingForData;
        if (trackTime) {
          waitingForData = Stopwatch.createStarted();
        }
        src = fetch(position);
        if (trackTime) {
          msWaitingForData += waitingForData.elapsed(TimeUnit.MILLISECONDS);
        }
      } catch (InterruptedException e) {
        // Restore interrupted status
        Thread.currentThread().interrupt();
        return 0;
      } catch (ExecutionException e) {
        throw new RuntimeException(e);
      }
      if (null == src) {
        // the caller is asking for a block past EOF
        nbReadsPastEnd++;
        return -1; // EOF
      }
      Stopwatch copyingData;
      if (trackTime) {
        copyingData = Stopwatch.createStarted();
      }
      // src.position is how far we've written into the array
      long blockIndex = position / bufSize;
      int offset = (int) (position - (blockIndex * bufSize));
      // src |==============---------------------|
      //     :<---src.pos-->------src.limit----->:
      // |---:--position->
      //     :<--offset-->
      //     ^ blockIndex*bufSize
      int availableToCopy = src.position() - offset;
      if (availableToCopy < 0) {
        // the caller is asking to read past the end of the file
        nbReadsPastEnd++;
        return -1; // EOF
      }
      int bytesToCopy = dst.remaining();
      byte[] array = src.array();
      if (availableToCopy < bytesToCopy) {
        bytesToCopy = availableToCopy;
      }
      dst.put(array, offset, bytesToCopy);
      position += bytesToCopy;
      if (trackTime) {
        msCopyingData += copyingData.elapsed(TimeUnit.MILLISECONDS);
      }
      bytesReturned += bytesToCopy;
      if (availableToCopy == 0) {
        // EOF
        return -1;
      }
      return bytesToCopy;
    } finally {
      if (trackTime) {
        betweenCallsToRead.reset();
        betweenCallsToRead.start();
      }
    }
  }

  /** Writing isn't supported. */
  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new NonWritableChannelException();
  }

  /**
   * Returns this channel's position.
   *
   * @return This channel's position, a non-negative integer counting the number of bytes from the
   *     beginning of the entity to the current position
   * @throws ClosedChannelException If this channel is closed
   * @throws IOException If some other I/O error occurs
   */
  @Override
  public long position() throws IOException {
    if (!open) throw new ClosedChannelException();
    return position;
  }

  /**
   * Sets this channel's position.
   *
   * <p>
   *
   * <p>Setting the position to a value that is greater than the current size is legal but does not
   * change the size of the entity. A later attempt to read bytes at such a position will
   * immediately return an end-of-file indication. A later attempt to write bytes at such a position
   * will cause the entity to grow to accommodate the new bytes; the values of any bytes between the
   * previous end-of-file and the newly-written bytes are unspecified.
   *
   * <p>Setting the channel's position is not recommended when connected to an entity, typically a
   * file, that is opened with the {@link java.nio.file.StandardOpenOption#APPEND APPEND} option.
   * When opened for append, the position is first advanced to the end before writing.
   *
   * @param newPosition The new position, a non-negative integer counting the number of bytes from
   *     the beginning of the entity
   * @return This channel
   * @throws ClosedChannelException If this channel is closed
   * @throws IllegalArgumentException If the new position is negative
   * @throws IOException If some other I/O error occurs
   */
  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    if (!open) throw new ClosedChannelException();
    position = newPosition;
    return this;
  }

  /**
   * Returns the current size of entity to which this channel is connected.
   *
   * @return The current size, measured in bytes
   * @throws ClosedChannelException If this channel is closed
   * @throws IOException If some other I/O error occurs
   */
  @Override
  public long size() throws IOException {
    if (!open) throw new ClosedChannelException();
    return size;
  }

  /** Not supported. */
  @Override
  public SeekableByteChannel truncate(long size) throws IOException {
    throw new NonWritableChannelException();
  }

  /**
   * Tells whether or not this channel is open.
   *
   * @return <tt>true</tt> if, and only if, this channel is open
   */
  @Override
  public boolean isOpen() {
    return open;
  }

  /**
   * Closes this channel.
   *
   * <p>
   *
   * <p>After a channel is closed, any further attempt to invoke I/O operations upon it will cause a
   * {@link ClosedChannelException} to be thrown.
   *
   * <p>
   *
   * <p>If this channel is already closed then invoking this method has no effect.
   *
   * <p>
   *
   * <p>This method may be invoked at any time. If some other thread has already invoked it,
   * however, then another invocation will block until the first invocation is complete, after which
   * it will return without effect.
   *
   * @throws IOException If an I/O error occurs
   */
  @Override
  public void close() throws IOException {
    if (open) {
      // stop accepting work, interrupt worker thread.
      exec.shutdownNow();
      try {
        // give worker thread a bit of time to process the interruption.
        exec.awaitTermination(1, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        // Restore interrupted status
        Thread.currentThread().interrupt();
      }
      chan.close();
      open = false;
    }
  }
}
