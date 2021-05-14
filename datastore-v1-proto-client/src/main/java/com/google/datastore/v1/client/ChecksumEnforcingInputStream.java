/*
 * Copyright 2021 Google LLC. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import com.google.common.annotations.VisibleForTesting;
import com.google.api.client.http.HttpResponse;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

/** This class provides End-to-End Checksum API for http protocol. */
class ChecksumEnforcingInputStream extends InputStream {
  private final InputStream delegate;
  private final MessageDigest messageDigest;
  private final String expectedChecksum;

  ChecksumEnforcingInputStream(InputStream originalInputStream,
                               HttpResponse response,
                               MessageDigest digest) {
    this(originalInputStream, EndToEndChecksumHandler.getChecksumHeader(response), digest);
  }

  @VisibleForTesting
  ChecksumEnforcingInputStream(InputStream originalInputStream,
                               String checksum,
                               MessageDigest digest) {
    delegate = originalInputStream;
    expectedChecksum = checksum;
    messageDigest = digest;
  }

  @Override
  public int available() throws IOException {
    return delegate.available();
  }

  @Override
  public void close() throws IOException {
    delegate.close();
  }

  @Override
  public void mark(int readlimit) {
    throw new RuntimeException("mark(int) Not Supported");
  }

  @Override
  public boolean markSupported() {
    // This class doesn't support mark, reset methods!
    return false;
  }

  @Override
  public int read() throws IOException {
    throw new RuntimeException("read() Not Supported");
  }

  @Override
  public int read(byte[] b) throws IOException {
    throw new RuntimeException("read(byte[]) Not Supported");
  }

  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    if (len <= 0) return 0;
    int i = delegate.read(b, off, len);
    if (i > 0) {
      messageDigest.update(b, off, i);
    } else {
      // no more payload to read. compute checksum and verify
      if (!expectedChecksum.equalsIgnoreCase(
          com.google.common.io.BaseEncoding.base16().encode(messageDigest.digest()))) {
        throw new IOException("possible memory corruption on payload detected");
      }
    }
    return i;
  }

  @Override
  public void reset() throws IOException {
    throw new RuntimeException("reset() Not Supported");
  }

  @Override
  public long skip(long n) throws IOException {
    if (n <= 0) return 0;
    // TODO: handle the case of n > Integer.MAX_VALUE ( that is, n > (2GB - 1). It is highly
    // unlikely that callers will want to skip that many bytes. That is the entire payload
    if (n > Integer.MAX_VALUE) {
      throw new IOException("can't skip more than Integer.MAX bytes");
    }
    int intSkip = (int) n;
    byte[] b = new byte[intSkip];
    return read(b, 0, intSkip);
  }
}
