/*
 * Copyright 2017 Google LLC
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

import com.google.cloud.storage.contrib.nio.testing.LocalStorageHelper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Unit tests for {@link CloudStorageFileSystem}.
 */
@RunWith(JUnit4.class)
public class CloudStorageReadTest {

  private static final String ALONE =
      "To be, or not to be, that is the question—\n"
          + "Whether 'tis Nobler in the mind to suffer\n"
          + "The Slings and Arrows of outrageous Fortune,\n"
          + "Or to take Arms against a Sea of troubles,\n"
          + "And by opposing, end them? To die, to sleep—\n"
          + "No more; and by a sleep, to say we end\n"
          + "The Heart-ache, and the thousand Natural shocks\n"
          + "That Flesh is heir to? 'Tis a consummation\n";

  // Large enough value that we write more than one "chunk", for interesting behavior.
  private static final int repeat = 10000;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void before() {
    CloudStorageFileSystemProvider.setStorageOptions(LocalStorageHelper.getOptions());
  }

  @Test
  public void testInputStreamReads() throws IOException, InterruptedException {
    // fill in the file
    byte[] bytes = ALONE.getBytes(UTF_8);
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      Path p = fillFile(fs, bytes, repeat);

      try (InputStream is = Files.newInputStream(p)) {
        byte[] buf = new byte[bytes.length];
        for (int i = 0; i < repeat; i++) {
          Arrays.fill(buf, (byte) 0);
          for (int off = 0; off < bytes.length;) {
            int delta = is.read(buf, off, bytes.length - off);
            if (delta < 0) {
              // EOF
              break;
            }
            off += delta;
          }
          assertWithMessage("Wrong bytes from input stream at repeat " + i)
              .that(new String(buf, UTF_8)).isEqualTo(ALONE);
        }
        // reading past the end
        int eof = is.read(buf, 0, 1);
        assertWithMessage("EOF should return -1").that(eof).isEqualTo(-1);
      }
    }
  }

  @Test
  public void testChannelReads() throws IOException, InterruptedException {
    // fill in the file
    byte[] bytes = ALONE.getBytes(UTF_8);
    try (FileSystem fs = CloudStorageFileSystem.forBucket("bucket")) {
      Path p = fillFile(fs, bytes, repeat);

      try (SeekableByteChannel chan = Files.newByteChannel(p, StandardOpenOption.READ)) {
        ByteBuffer buf = ByteBuffer.allocate(bytes.length);
        for (int i = 0; i < repeat; i++) {
          buf.clear();
          for (int off = 0; off < bytes.length;) {
            int read = chan.read(buf);
            if (read < 0) {
              // EOF
              break;
            }
            off += read;
          }
          assertWithMessage("Wrong bytes from channel at repeat " + i)
              .that(new String(buf.array(), UTF_8)).isEqualTo(ALONE);
        }
        // reading past the end
        buf.clear();
        int eof = chan.read(buf);
        assertWithMessage("EOF should return -1").that(eof).isEqualTo(-1);
      }
    }
  }

  private Path fillFile(FileSystem fs, byte[] bytes, int repeat) throws IOException {
    Path p = fs.getPath("/alone");
    try (OutputStream os = Files.newOutputStream(p)) {
      for (int i = 0; i < repeat; i++) {
        os.write(bytes);
      }
    }
    assertThat(Files.size(p) == repeat * bytes.length);
    return p;
  }

}
