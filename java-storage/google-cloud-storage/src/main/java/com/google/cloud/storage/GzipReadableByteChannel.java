/*
 * Copyright 2022 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.ExecutionException;
import java.util.zip.GZIPInputStream;

final class GzipReadableByteChannel implements UnbufferedReadableByteChannel {
  private final UnbufferedReadableByteChannel source;
  private final ApiFuture<String> contentEncoding;

  private boolean retEOF = false;
  private ScatteringByteChannel delegate;
  private ByteBuffer leftovers;

  GzipReadableByteChannel(UnbufferedReadableByteChannel source, ApiFuture<String> contentEncoding) {
    this.source = source;
    this.contentEncoding = contentEncoding;
  }

  @Override
  public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
    if (retEOF) {
      return -1;
    }
    long bytesRead = 0;
    // if our delegate is null, that means this is the first read attempt
    if (delegate == null) {
      // try to determine if the underlying data coming out of `source` is gzip
      byte[] firstByte = new byte[1];
      ByteBuffer wrap = ByteBuffer.wrap(firstByte);
      // Step 1: initiate a read of the first byte of the object
      //   this will have minimal overhead as the messages coming from gcs are inherently windowed
      //   if the object size is between 2 and 2MiB the remaining bytes will be held in the channel
      //   for later read.
      source.read(wrap);
      try {
        // Step 2: wait for the object metadata, this is populated in the first message from GCS
        String contentEncoding = this.contentEncoding.get();
        // if the Content-Encoding is gzip, Step 3: wire gzip decompression into the byte path
        //   this will have a copy impact as we are no longer controlling all the buffers
        if ("gzip".equals(contentEncoding) || "x-gzip".equals(contentEncoding)) {
          // to wire gzip decompression into the byte path:
          // Create an input stream of the firstByte bytes we already read
          ByteArrayInputStream firstByteAgain = new ByteArrayInputStream(firstByte);
          // Create an InputStream facade of source
          InputStream sourceInputStream = Channels.newInputStream(source);
          // create a new InputStream with the firstByte bytes prepended to source
          SequenceInputStream first4AndSource =
              new SequenceInputStream(firstByteAgain, sourceInputStream);
          // add gzip decompression
          GZIPInputStream decompress =
              new GZIPInputStream(new OptimisticAvailabilityInputStream(first4AndSource));
          // create a channel from our GZIPInputStream
          ReadableByteChannel decompressedChannel = Channels.newChannel(decompress);
          // turn our ReadableByteChannel into a ScatteringByteChannel
          delegate = StorageByteChannels.readable().asScatteringByteChannel(decompressedChannel);
        } else {
          // if content encoding isn't gzip, copy the bytes we read into the dsts and set delegate
          // to source
          wrap.flip();
          bytesRead += Buffers.copy(wrap, dsts, offset, length);
          if (wrap.hasRemaining()) {
            leftovers = wrap;
          }
          delegate = source;
        }
      } catch (InterruptedException | ExecutionException e) {
        throw new IOException(e);
      }
    } else if (leftovers != null && leftovers.hasRemaining()) {
      bytesRead += Buffers.copy(leftovers, dsts, offset, length);
      if (!leftovers.hasRemaining()) {
        leftovers = null;
      }
    }

    // Because we're pre-reading a byte of the object in order to determine if we need to
    // plumb in gzip decompress, there is the possibility we will reach EOF while probing.
    // In order to maintain correctness of EOF propagation, determine if we will need to signal EOF
    // upon the next read.
    long read = delegate.read(dsts, offset, length);
    if (read == -1 && bytesRead == 0) {
      return -1;
    } else if (read == -1) {
      retEOF = true;
    } else {
      bytesRead += read;
    }

    return bytesRead;
  }

  @Override
  public boolean isOpen() {
    return !retEOF && source.isOpen();
  }

  @Override
  public void close() throws IOException {
    // leverage try-with-resource to handle the dance closing these two resources
    try (AutoCloseable ignored1 = source;
        AutoCloseable ignored2 = delegate) {
      delegate = null;
    } catch (Exception e) {
      throw new IOException("Error while attempting to close channel.", e);
    }
  }

  /**
   * There is an edge-case in the JDK's {@link GZIPInputStream} where it will prematurely terminate
   * reading from the underlying InputStream.
   *
   * <p>This class decorates an InputStream to be optimistic about the number of available bytes
   * when reading data to encourage GzipInputStream to consume the entire stream.
   *
   * <p>For a more in-depth write up see <a target="_blank"
   * href="https://github.com/googleapis/google-http-java-client/pull/1608">google-http-java-client/pull/1608</a>
   *
   * <p><i>NOTE</i> This class is a copy of the private class from {@code
   * com.google.api.client.http.GzipSupport}. This class should not be made public, as it is not
   * general purpose and so is reproduced here.
   */
  private static final class OptimisticAvailabilityInputStream extends FilterInputStream {
    private int lastRead = 0;

    OptimisticAvailabilityInputStream(InputStream delegate) {
      super(delegate);
    }

    @Override
    public int available() throws IOException {
      return lastRead > -1 ? Integer.MAX_VALUE : 0;
    }

    @Override
    public int read() throws IOException {
      return lastRead = super.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
      return lastRead = super.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
      return lastRead = super.read(b, off, len);
    }
  }
}
