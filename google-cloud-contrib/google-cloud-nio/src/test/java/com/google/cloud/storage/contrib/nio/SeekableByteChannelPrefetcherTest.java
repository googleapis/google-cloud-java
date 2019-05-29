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

package com.google.cloud.storage.contrib.nio;

import static com.google.common.truth.Truth.assertThat;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SeekableByteChannelPrefetcherTest {
  // A file big enough to try seeks on.
  private static Path input;

  /** Sets up an input file to play with. */
  @BeforeClass
  public static void setUp() throws IOException {
    // create input, fill with data
    input = Files.createTempFile("tmp_big_file", ".tmp");
    try (BufferedOutputStream writer = new BufferedOutputStream(Files.newOutputStream(input))) {
      byte[] buffer = new byte[1024];
      for (int i = 0; i < buffer.length; i++) {
        buffer[i] = (byte) i;
      }
      for (int i = 0; i < 1024; i++) {
        writer.write(buffer);
      }
    }
  }

  /** Deletes the test file. */
  @AfterClass
  public static void tearDown() throws IOException {
    Files.delete(input);
  }

  @Test
  public void testRead() throws Exception {
    SeekableByteChannel chan1 = Files.newByteChannel(input);
    SeekableByteChannel chan2 =
        SeekableByteChannelPrefetcher.addPrefetcher(1, Files.newByteChannel(input));

    testReading(chan1, chan2, 0);
    testReading(chan1, chan2, 128);
    testReading(chan1, chan2, 1024);
    testReading(chan1, chan2, 1500);
    testReading(chan1, chan2, 2048);
    testReading(chan1, chan2, 3000);
    testReading(chan1, chan2, 6000);
  }

  @Test
  public void testSeek() throws Exception {
    SeekableByteChannel chan1 = Files.newByteChannel(input);
    SeekableByteChannel chan2 =
        SeekableByteChannelPrefetcher.addPrefetcher(1, Files.newByteChannel(input));

    testSeeking(chan1, chan2, 1024);
    testSeeking(chan1, chan2, 1500);
    testSeeking(chan1, chan2, 128);
    testSeeking(chan1, chan2, 256);
    testSeeking(chan1, chan2, 128);
    // yes, testReading - let's make sure that reading more than one block still works
    // even after a seek.
    testReading(chan1, chan2, 1500);
    testSeeking(chan1, chan2, 2048);
    testSeeking(chan1, chan2, 0);
    testSeeking(chan1, chan2, 3000);
    testSeeking(chan1, chan2, 6000);
    testSeeking(chan1, chan2, (int) chan1.size() - 127);
    testSeeking(chan1, chan2, (int) chan1.size() - 128);
    testSeeking(chan1, chan2, (int) chan1.size() - 129);
  }

  @Test
  public void testPartialBuffers() throws Exception {
    SeekableByteChannel chan1 = Files.newByteChannel(input);
    SeekableByteChannel chan2 =
        SeekableByteChannelPrefetcher.addPrefetcher(1, Files.newByteChannel(input));
    // get a partial buffer
    testSeeking(chan1, chan2, (int) chan1.size() - 127);
    // make sure normal reads can use the full buffer
    for (int i = 0; i < 2; i++) {
      testSeeking(chan1, chan2, i * 1024);
    }
    // get a partial buffer, replacing one of the full ones
    testSeeking(chan1, chan2, (int) chan1.size() - 127);
    // make sure the buffers are still OK
    for (int i = 0; i < 2; i++) {
      testSeeking(chan1, chan2, i * 1024);
    }
  }

  @Test
  public void testEOF() throws Exception {
    SeekableByteChannel chan1 = Files.newByteChannel(input);
    SeekableByteChannel chan2 =
        SeekableByteChannelPrefetcher.addPrefetcher(1, Files.newByteChannel(input));
    // read the final 128 bytes, exactly.
    testSeeking(chan1, chan2, (int) chan1.size() - 128);
    // read truncated because we're asking for beyond EOF
    testSeeking(chan1, chan2, (int) chan1.size() - 64);
    // read starting past EOF
    testSeeking(chan1, chan2, (int) chan1.size() + 128);
    // read more than a whole block past EOF
    testSeeking(chan1, chan2, (int) chan1.size() + 1024 * 2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testDoubleWrapping() throws IOException {
    SeekableByteChannel chan1 =
        SeekableByteChannelPrefetcher.addPrefetcher(1, Files.newByteChannel(input));
    SeekableByteChannelPrefetcher.addPrefetcher(1, chan1);
  }

  @Test
  public void testCloseWhilePrefetching() throws Exception {
    SeekableByteChannel chan =
        SeekableByteChannelPrefetcher.addPrefetcher(10, Files.newByteChannel(input));
    // read just 1 byte, get the prefetching going
    ByteBuffer one = ByteBuffer.allocate(1);
    readFully(chan, one);
    // closing must not throw an exception, even if the prefetching
    // thread is active.
    chan.close();
  }

  private void testReading(SeekableByteChannel chan1, SeekableByteChannel chan2, int howMuch)
      throws IOException {
    ByteBuffer one = ByteBuffer.allocate(howMuch);
    ByteBuffer two = ByteBuffer.allocate(howMuch);

    readFully(chan1, one);
    readFully(chan2, two);

    assertThat(one.position()).isEqualTo(two.position());
    assertThat(one.array()).isEqualTo(two.array());
  }

  private void testSeeking(SeekableByteChannel chan1, SeekableByteChannel chan2, int position)
      throws IOException {
    ByteBuffer one = ByteBuffer.allocate(128);
    ByteBuffer two = ByteBuffer.allocate(128);

    chan1.position(position);
    chan2.position(position);

    readFully(chan1, one);
    readFully(chan2, two);

    assertThat(one.position()).isEqualTo(two.position());
    assertThat(one.array()).isEqualTo(two.array());
  }

  private void readFully(ReadableByteChannel chan, ByteBuffer buf) throws IOException {
    // the countdown isn't strictly necessary but it protects us against infinite loops
    // for some potential bugs in the channel implementation.
    int countdown = buf.capacity();
    while (chan.read(buf) > 0 && countdown > 0) {
      countdown--;
    }
  }
}
