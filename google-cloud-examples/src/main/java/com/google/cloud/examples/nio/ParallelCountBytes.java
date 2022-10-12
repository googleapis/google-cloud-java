/*
 * Copyright 2016 Google LLC
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

package com.google.cloud.examples.nio;

import com.google.common.base.Stopwatch;
import com.google.common.io.BaseEncoding;
import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * ParallelCountBytes will read through the whole file given as input.
 *
 * <p>This example shows how to go through all the contents of a file, in order, using multithreaded
 * NIO reads. It prints a MD5 hash and reports how long it took.
 *
 * <p>See the <a
 * href="https://github.com/googleapis/google-cloud-java/blob/master/google-cloud-examples/README.md">
 * README</a> for compilation instructions. Run this code with
 *
 * <pre>{@code target/appassembler/bin/ParallelCountBytes <file>}</pre>
 */
public class ParallelCountBytes {

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
  private static class WorkUnit implements Callable<WorkUnit>, Closeable {
    public final ByteBuffer buf;
    final SeekableByteChannel chan;
    final int blockSize;
    int blockIndex;

    public WorkUnit(SeekableByteChannel chan, int blockSize, int blockIndex) {
      this.chan = chan;
      this.buf = ByteBuffer.allocate(blockSize);
      this.blockSize = blockSize;
      this.blockIndex = blockIndex;
    }

    @Override
    public WorkUnit call() throws IOException {
      long pos = ((long) blockSize) * blockIndex;
      if (pos > chan.size()) {
        return this;
      }
      chan.position(pos);
      // read until buffer is full, or EOF
      while (chan.read(buf) > 0) {}
      ;
      return this;
    }

    public WorkUnit resetForIndex(int blockIndex) {
      this.blockIndex = blockIndex;
      buf.flip();
      return this;
    }

    public void close() throws IOException {
      chan.close();
    }
  }

  /** See the class documentation. */
  public static void main(String[] args) throws Exception {
    if (args.length == 0 || args[0].equals("--help")) {
      help();
      return;
    }
    for (String a : args) {
      countFile(a);
    }
  }

  /**
   * Print the length and MD5 of the indicated file.
   *
   * <p>This uses the normal Java NIO Api, so it can take advantage of any installed NIO Filesystem
   * provider without any extra effort.
   */
  private static void countFile(String fname) throws Exception {
    // large buffers pay off
    final int bufSize = 50 * 1024 * 1024;
    Queue<Future<WorkUnit>> work = new ArrayDeque<>();
    Path path = Paths.get(new URI(fname));
    long size = Files.size(path);
    System.out.println(fname + ": " + size + " bytes.");
    int nThreads = (int) Math.ceil(size / (double) bufSize);
    if (nThreads > 4) nThreads = 4;
    System.out.println("Reading the whole file using " + nThreads + " threads...");
    Stopwatch sw = Stopwatch.createStarted();
    long total = 0;
    MessageDigest md = MessageDigest.getInstance("MD5");

    ExecutorService exec = Executors.newFixedThreadPool(nThreads);
    int blockIndex;
    for (blockIndex = 0; blockIndex < nThreads; blockIndex++) {
      work.add(exec.submit(new WorkUnit(Files.newByteChannel(path), bufSize, blockIndex)));
    }
    while (!work.isEmpty()) {
      WorkUnit full = work.remove().get();
      md.update(full.buf.array(), 0, full.buf.position());
      total += full.buf.position();
      if (full.buf.hasRemaining()) {
        full.close();
      } else {
        work.add(exec.submit(full.resetForIndex(blockIndex++)));
      }
    }
    exec.shutdown();

    long elapsed = sw.elapsed(TimeUnit.SECONDS);
    System.out.println("Read all " + total + " bytes in " + elapsed + "s. ");
    String hex = String.valueOf(BaseEncoding.base16().encode(md.digest()));
    System.out.println("The MD5 is: 0x" + hex);
    if (total != size) {
      System.out.println(
          "Wait, this doesn't match! We saw "
              + total
              + " bytes, "
              + "yet the file size is listed at "
              + size
              + " bytes.");
    }
  }

  private static void help() {
    String[] help = {"The argument is a <path>", "and we show the length of that file."};
    for (String s : help) {
      System.out.println(s);
    }
  }
}
