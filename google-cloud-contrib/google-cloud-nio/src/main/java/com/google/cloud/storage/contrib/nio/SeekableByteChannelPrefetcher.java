/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.NonWritableChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * SeekableByteChannelPrefetcher wraps an existing SeekableByteChannel to add prefetching.
 * The prefetching is done on different threads, so you can write simple code that repeatedly
 * calls read() to get data, processes it, and then calls read again -- and yet this
 * simple code overlaps computation and communication for you.
 * (Of course this is only worthwhile if the underlying SeekableByteChannel doesn't already
 * implement prefetching).
 *
 * <p> The prefetcher can read with multiple threads in parallel, and it can keep a buffered
 * copy of already-read bytes just in case the caller doesn't follow a strictly linear pattern.
 * It can also optionally use an extra thread in case of out-of-order reads to fetch the data at
 * once even if all prefetching threads are busy.
 *
 */
public class SeekableByteChannelPrefetcher implements SeekableByteChannel {

  // normal-case number of parallel reads.
  private final int prefetchingThreads;
  // in case the data we need isn't being prefetched, we can use up to this many
  // extra threads to fetch user-requested data.
  private final int extraThreads;
  // size in bytes for our buffer. Every fetcher grabs one buffer at a time.
  private final int bufferSize;
  // how many buffers we keep around. Should be at least prefetchingThreads + extraThreads.
  // bufferSize * bufferCount is how much memory this class'll allocate.
  private final int bufferCount;
  // size of the underlying channel(s).
  private final long size;
  // where we pretend to be, wrt returning bytes from read()
  private long position;
  // whether we're open.
  private boolean open = true;
  private boolean closing;

  private final ExecutorService exec;
  private final Sorted buffers;
  private final ArrayList<Worker> idleWorkers;
  private final int workerCount;

  private class Buffer {
    // index*bufferSize = file position. Set to -1 when we haven't yet decided.
    public long index;
    public Future<ByteBuffer> promise;

    public Buffer(int size) {
      ByteBuffer bb = ByteBuffer.allocate(size);
      this.index = -1;
      this.promise = Futures.immediateFuture(bb);
    }
  }

  // Holds all of the buffers. They are either being filled, or already full.
  // A thin wrapper around TreeMap, so we can change away from the
  // red-black tree if it's too heavy for this scale.
  private class Sorted {
    TreeMap<Long, Buffer> data;
    Queue<Buffer> byAge;

    public Sorted(int bufferCount) {
      data = new TreeMap<>();
      byAge = new ArrayBlockingQueue<Buffer>(bufferCount+1);
    }

    public void put(long index, Buffer item) {
      item.index = index;
      data.put(index, item);
      byAge.add(item);
    }
    public Buffer get(long index) {
      return data.get(index);
    }
    public Buffer getOldest() {
      Buffer oldest = byAge.remove();
      data.remove(oldest.index);
      oldest.index = -1;
      return oldest;
    }

    public int size() {
      return byAge.size();
    }
  }

  private class Worker implements Callable<ByteBuffer>, Closeable {
    ByteBuffer bb;
    long pos;
    SeekableByteChannel chan;

    public Worker(SeekableByteChannel chan) {
      this.chan = chan;
    }

    public void init(long pos, Buffer buf) throws ExecutionException, InterruptedException {
      if (!buf.promise.isDone()) {
        throw new RuntimeException("Cannot download onto buffer that's still being filled");
      }
      ByteBuffer bb = buf.promise.get();
      bb.clear();
      buf.index = pos / bufferSize;
      this.bb = bb;
      this.pos = pos;
    }

    public ByteBuffer call() throws IOException, ExecutionException, InterruptedException {
      if (pos > chan.size()) {
        reassignWorker(this);
        return null;
      }
      chan.position(pos);
      ByteBuffer b = this.bb;
      while (chan.read(b) > 0 && !closing) {
        // read until buffer is full, or EOF
      }
      reassignWorker(this);
      return b;
    }

    public void close() throws IOException {
      chan.close();
    }
  }

  public SeekableByteChannelPrefetcher(SeekableByteChannelPrefetcherOptions opts, Iterable<SeekableByteChannel> channels) throws IOException {
    this.bufferCount = opts.bufferCount;
    this.bufferSize = opts.bufferSize;
    buffers = new Sorted(bufferCount);
    this.prefetchingThreads = opts.prefetchingThreads;
    this.extraThreads = opts.extraThreads;
    this.idleWorkers = new ArrayList<>(this.prefetchingThreads + this.extraThreads);
    this.exec = Executors.newFixedThreadPool(prefetchingThreads + extraThreads);
    SeekableByteChannel chan = null;
    ImmutableList<SeekableByteChannel> underlyingChannels = ImmutableList.copyOf(channels);
    for (SeekableByteChannel bc : underlyingChannels) {
      chan = bc;
      idleWorkers.add(new Worker(bc));
    }
    workerCount = underlyingChannels.size();
    size = chan.size();
    position = 0;
  }

  /**
   * Reads a sequence of bytes from this channel into the given buffer.
   *
   * @param dst destination buffer
   */
  @Override
  public int read(ByteBuffer dst) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    ByteBuffer src;
    try {
      src = fetch(position);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      return 0;
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
    int bytesToCopy = dst.remaining();
    byte[] array = src.array();
    // src.position is how far we've written into the array.
    // This should always be all the way to the end, unless we've hit EOF.
    long blockIndex = position / bufferSize;
    // |----blocksize----|----blocksize----|
    //                    <-->|
    //                      | ^ position
    //                      ^ offset
    int offset = (int)(position - (blockIndex * bufferSize));
    int availableToCopy = src.position() - offset;
    if (availableToCopy < bytesToCopy) {
      bytesToCopy = availableToCopy;
    }
    dst.put(array, offset, bytesToCopy);
    position += bytesToCopy;
    if (availableToCopy == 0) {
      // EOF
      return -1;
    }
    return bytesToCopy;
  }

  /**
   * Writing isn't supported.
   */
  @Override
  public int write(ByteBuffer src) throws IOException {
    throw new NonWritableChannelException();
  }

  /**
   * Returns this channel's position.
   *
   * @return This channel's position,
   * a non-negative integer counting the number of bytes
   * from the beginning of the entity to the current position
   * @throws ClosedChannelException If this channel is closed
   * @throws IOException            If some other I/O error occurs
   */
  @Override
  public long position() throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    return position;
  }

  /**
   * Sets this channel's position.
   *
   * <p> Setting the position to a value that is greater than the current size
   * is legal but does not change the size of the entity.  A later attempt to
   * read bytes at such a position will immediately return an end-of-file
   * indication.  A later attempt to write bytes at such a position will cause
   * the entity to grow to accommodate the new bytes; the values of any bytes
   * between the previous end-of-file and the newly-written bytes are
   * unspecified.
   *
   * <p> Setting the channel's position is not recommended when connected to
   * an entity, typically a file, that is opened with the
   * StandardOpenOption.APPEND option. When opened for
   * append, the position is first advanced to the end before writing.
   *
   * @param newPosition The new position, a non-negative integer counting
   *                    the number of bytes from the beginning of the entity
   * @return This channel
   * @throws ClosedChannelException   If this channel is closed
   * @throws IllegalArgumentException If the new position is negative
   * @throws IOException              If some other I/O error occurs
   */
  @Override
  public SeekableByteChannel position(long newPosition) throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    position = newPosition;
    return this;
  }

  /**
   * Returns the current size of entity to which this channel is connected.
   *
   * @return The current size, measured in bytes
   * @throws ClosedChannelException If this channel is closed
   * @throws IOException            If some other I/O error occurs
   */
  @Override
  public long size() throws IOException {
    if (!open) {
      throw new ClosedChannelException();
    }
    return size;
  }

  /**
   * Not supported.
   */
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
   * <p> After a channel is closed, any further attempt to invoke I/O
   * operations upon it will cause a {@link ClosedChannelException} to be
   * thrown.
   *
   * <p> If this channel is already closed then invoking this method has no
   * effect.
   *
   * <p> This method may be invoked at any time.  If some other thread has
   * already invoked it, however, then another invocation will block until
   * the first invocation is complete, after which it will return without
   * effect. </p>
   *
   * @throws IOException If an I/O error occurs
   */
  @Override
  public void close() throws IOException {
    if (open) {
      closing = true;
      exec.shutdown();
      try {
        while (true) {
            synchronized (idleWorkers) {
            if (idleWorkers.size() >= workerCount) {
              // every thread is idle, we're done.
              break;
            }
            idleWorkers.wait(60_000);
          }
        }
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
      try {
        exec.awaitTermination(60, TimeUnit.SECONDS);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        exec.shutdownNow();
      }
      // Close all underlying channels
      for (Worker w : idleWorkers) {
        w.close();
      }
      open = false;
    }
  }

  // Return a buffer at this position, blocking if necessary.
  // Start a background read of the buffer after this one (if there isn't one already).
  public ByteBuffer fetch(long position) throws InterruptedException, ExecutionException {
    long index = position / bufferSize;
    Buffer buf = buffers.get(index);
    if (null != buf) {
      return buf.promise.get();
    }
    // we don't have data. Point a fetching thread at it.
    Buffer newBuf = getEmptyBuffer();
    Worker newWorker = getIdleWorker();
    sicWorker(newWorker, position, newBuf);
    startPrefetching(position);
    // now we wait.
    return newBuf.promise.get();
  }

  private Worker getIdleWorker() throws InterruptedException {
    while (true) {
      synchronized (idleWorkers) {
        while (idleWorkers.isEmpty()) {
          idleWorkers.wait();
        }
        if (!idleWorkers.isEmpty()) {
          return idleWorkers.remove(0);
        }
      }
    }
  }

  private Worker tryGetIdleWorker() throws InterruptedException {
    while (true) {
      synchronized (idleWorkers) {
        if (closing) {
          return null;
        }
        if (!idleWorkers.isEmpty()) {
          return idleWorkers.remove(0);
        }
        return null;
      }
    }
  }

  private void sicWorker(Worker worker, long pos, Buffer toFill) throws ExecutionException, InterruptedException {
    long bucketStart = beginningOfBucket(pos);
    worker.init(bucketStart, toFill);
    Future<ByteBuffer> promise = exec.submit(worker);
    toFill.promise = promise;
    buffers.put(index(bucketStart), toFill);
  }

  private long index(long pos) {
    return pos / bufferSize;
  }

  private long beginningOfBucket(long pos) {
    return index(pos) * bufferSize;
  }

  // Return the oldest buffer, or (if we haven't yet allocated all our buffers)
  // a newly-allocated buffer.
  private Buffer getEmptyBuffer() {
    if (buffers.size() < bufferCount) {
      return new Buffer(bufferSize);
    }
    Buffer candidate = buffers.getOldest();
    return candidate;
  }

  // Worker is idle. Do we have work for it?
  private void reassignWorker(Worker w) throws ExecutionException, InterruptedException {
    long lastIndex = index(size);
    long curIndex = index(position);
    if (!closing) {
      for (int i = 0; i < prefetchingThreads; i++) {
        if (i > lastIndex) {
          break;
        }
        if (buffers.get(curIndex + i) == null) {
          // work for you!
          Buffer buf = getEmptyBuffer();
          sicWorker(w, bufferSize * (curIndex + i), buf);
          return;
        }
      }
    }
    // nothing to do, return to idle pool
    synchronized (idleWorkers) {
      idleWorkers.add(w);
      idleWorkers.notifyAll();
    }
  }

  private void startPrefetching(long position) throws ExecutionException, InterruptedException {
    if (closing) {
      return;
    }
    long lastIndex = index(size);
    long curIndex = index(position);
    for (int i = 0; i < prefetchingThreads; i++) {
      if (i > lastIndex) {
        break;
      }
      if (buffers.get(curIndex + i) == null) {
        // work available!
        Worker w = tryGetIdleWorker();
        if (null == w) {
          break;
        }
        Buffer buf = getEmptyBuffer();
        sicWorker(w, bufferSize * (curIndex + i), buf);
      }
    }
  }
}
