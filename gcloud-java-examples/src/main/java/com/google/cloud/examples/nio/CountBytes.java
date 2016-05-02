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
 * <p>It's meant for testing that NIO correctly saturates your network link.
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
      for (int read = 1; read > 0; ) {
        readCalls ++;
        read = chan.read(buf);
        buf.flip();
        total += read;
      }
      long elapsed = sw.elapsed(TimeUnit.SECONDS);
      System.out.println("Read all " + total + " bytes in " + elapsed + "s. (" + readCalls +" calls to chan.read)");
      if (total != size) {
        System.out.println("Wait, this doesn't match! We saw " + total + " bytes, yet the file size is listed at " + size + " bytes.");
      }
    } catch (Exception ex) {
      System.out.println(fname + ": " + ex.toString());
    }
  }

  private static void help() {
    String[] help =
        {"The argument is a <path>",
         "and we show the length of that file.",
        };
    for (String s : help) {
      System.out.println(s);
    }
  }

}
