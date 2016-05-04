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

import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * CountBytes will read through the whole file given as input.
 *
 * <p>This example shows how to read a file size using NIO.
 * File.size returns the size of the file as saved in Storage metadata.
 * This class also shows how to read all of the file's contents using NIO,
 * and reports how long it took.
 *
 * <p>See the README for compilation instructions. Run this code with
 * {@code target/appassembler/bin/CountBytes <file>}
 */
public class CountBytes {

  /**
   * See the class documentation.
   */
  public static void main(String[] args) throws IOException {
    if (args.length == 0 || args[0].equals("--help")) {
      help();
      return;
    }
    for (String a : args) {
      countFile(a);
    }
  }

  /**
   * Print the length of the indicated file.
   *
   * <p>This uses the normal Java NIO Api, so it can take advantage of any installed
   * NIO Filesystem provider without any extra effort.
   */
  private static void countFile(String fname) {
    // large buffers pay off
    final int bufSize = 50 * 1024 * 1024;
    try {
      Path path = Paths.get(new URI(fname));
      long size = Files.size(path);
      System.out.println(fname + ": " + size + " bytes.");
      ByteBuffer buf = ByteBuffer.allocate(bufSize);
      System.out.println("Reading the whole file...");
      Stopwatch sw = Stopwatch.createStarted();
      SeekableByteChannel chan = Files.newByteChannel(path);
      long total = 0;
      int readCalls = 0;
      while (chan.read(buf) > 0) {
        readCalls++;
        total += buf.position();
        buf.flip();
      }
      readCalls++; // We must count the last call
      long elapsed = sw.elapsed(TimeUnit.SECONDS);
      System.out.println("Read all " + total + " bytes in " + elapsed + "s. " +
          "(" + readCalls +" calls to chan.read)");
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
