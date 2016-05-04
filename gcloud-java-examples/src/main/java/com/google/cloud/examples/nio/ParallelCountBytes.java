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

package com.google.cloud.examples.nio;

import com.google.common.base.Stopwatch;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;

/**
 * ParallelCountBytes will read through the whole file given as input.
 *
 * <p>This example shows how to go through all the contents of a file,
 * in order, using multithreaded NIO reads.It also reports how long it took.
 *
 * <p>See the README for compilation instructions. Run this code with
 * {@code target/appassembler/bin/ParallelCountBytes <file>}
 */
public class ParallelCountBytes {

  private class BufWithLock {
    public Object lock;
    public ByteBuffer buf;
    public boolean full;
    public Thread t;

    public BufWithLock(int size) {
      this.buf = ByteBuffer.allocate(size);
      this.lock = new Object();
    }
  }

  /**
   * See the class documentation.
   */
  public static void main(String[] args) throws IOException {
    new ParallelCountBytes().start(args);
  }

  public void start(String[] args) throws IOException {
    if (args.length == 0 || args[0].equals("--help")) {
      help();
      return;
    }
    for (String a : args) {
      countFile(a);
    }
  }

  private void stridedRead(SeekableByteChannel chan, int blockSize, int firstBlock, int stride, BufWithLock output) {
    try {
      // stagger the threads a little bit.
      Thread.sleep(250 * firstBlock);
      long pos = firstBlock * blockSize;
      synchronized(output.lock) {
        while (true) {
          if (pos > chan.size()) {
            break;
          }
          chan.position(pos);
          // read until buffer is full, or EOF
          while (chan.read(output.buf) > 0) {};
          output.full = true;
          output.lock.notifyAll();
          if (output.buf.hasRemaining()) {
            break;
          }
          // wait for main thread to process it
          while (output.full) {
            output.lock.wait();
          }
          output.buf.flip();
          pos += stride * blockSize;
        }
      }
    } catch (InterruptedException | IOException o) {
      // this simple example doesn't handle errors, sorry.
    }
  }

  /**
   * Print the length of the indicated file.
   *
   * <p>This uses the normal Java NIO Api, so it can take advantage of any installed
   * NIO Filesystem provider without any extra effort.
   */
  private void countFile(String fname) throws IOException{
    // large buffers pay off
    final int bufSize = 50 * 1024 * 1024;
    try {
      Path path = Paths.get(new URI(fname));
      long size = Files.size(path);
      System.out.println(fname + ": " + size + " bytes.");
      ByteBuffer buf = ByteBuffer.allocate(bufSize);
      int nBlocks = (int)Math.ceil( size / (double)bufSize);
      int nThreads = nBlocks;
      if (nThreads > 4) nThreads = 4;
      System.out.println("Reading the whole file using " + nThreads + " threads...");
      Stopwatch sw = Stopwatch.createStarted();
      final BufWithLock[] bufs = new BufWithLock[nThreads];
      for (int i = 0; i < nThreads; i++) {
        bufs[i] = new BufWithLock(bufSize);
        final SeekableByteChannel chan = Files.newByteChannel(path);
        final int finalNThreads = nThreads;
        final int finalI = i;
        bufs[i].t = new Thread(new Runnable() {
          @Override
          public void run() {
            stridedRead(chan, bufSize, finalI, finalNThreads, bufs[finalI]);
          }
        });
            bufs[i].t.start();
      }

      long total = 0;
      MessageDigest md = MessageDigest.getInstance("MD5");
      for (int block = 0; block < nBlocks; block++) {
        BufWithLock bwl = bufs[block % bufs.length];
        synchronized (bwl.lock) {
          while (!bwl.full) {
            bwl.lock.wait();
          }
          md.update(bwl.buf.array(), 0, bwl.buf.position());
          total += bwl.buf.position();
          bwl.full = false;
          bwl.lock.notifyAll();
        }
      }

      long elapsed = sw.elapsed(TimeUnit.SECONDS);
      System.out.println("Read all " + total + " bytes in " + elapsed + "s. ");
      String hex = (new HexBinaryAdapter()).marshal(md.digest());
      System.out.println("The MD5 is: 0x" + hex);
      if (total != size) {
        System.out.println("Wait, this doesn't match! We saw " + total + " bytes, " +
            "yet the file size is listed at " + size + " bytes.");
      }
    } catch (Exception ex) {
      System.out.println(fname + ": " + ex.toString());
    }
  }

  private static void help() {
    String[] help =
        {"The argument is a <path>",
         "and we show the length of that file."
        };
    for (String s : help) {
      System.out.println(s);
    }
  }
}
