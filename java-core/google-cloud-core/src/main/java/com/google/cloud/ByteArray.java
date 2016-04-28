/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.cloud;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.ByteString;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * An immutable byte array holder.
 */
public class ByteArray implements Iterable<Byte>, Serializable {

  private static final long serialVersionUID = -1908809133893782840L;
  private final ByteString byteString;

  protected ByteArray(ByteString byteString) {
    this.byteString = byteString;
  }

  protected ByteArray(ByteArray byteArray) {
    this.byteString = byteArray.byteString();
  }

  @Override
  public final Iterator<Byte> iterator() {
    return byteString.iterator();
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    StringBuilder stBuilder = new StringBuilder();
    for (int i = 0; i < Math.min(256, byteString.size()); i++) {
      stBuilder.append(String.format("%02x", byteString.byteAt(i)));
    }
    if (byteString.size() > 256) {
      stBuilder.append("...");
    }
    return toStringHelper.add("bytes", stBuilder.toString()).toString();
  }

  @Override
  public final int hashCode() {
    return byteString.hashCode();
  }

  @Override
  public final boolean equals(Object obj) {
    return obj == this
        || obj instanceof ByteArray && byteString.equals(((ByteArray) obj).byteString);
  }

  /**
   * Returns the size of this blob.
   */
  public final int length() {
    return byteString.size();
  }

  /**
   * Returns a copy as byte array.
   */
  public final byte[] toByteArray() {
    return byteString.toByteArray();
  }

  /**
   * Returns the content as {@code UTF-8} string.
   */
  public final String toStringUtf8() {
    return byteString.toStringUtf8();
  }

  /**
   * Returns a read-only {@link ByteBuffer} for this blob content.
   */
  public final ByteBuffer asReadOnlyByteBuffer() {
    return byteString.asReadOnlyByteBuffer();
  }

  /**
   * Returns an {@link InputStream} for this blob content.
   */
  public final InputStream asInputStream() {
    final ByteBuffer byteBuffer = asReadOnlyByteBuffer();
    return new InputStream() {
      @Override public int read() {
        return !byteBuffer.hasRemaining() ? -1 : byteBuffer.get() & 0xFF;
      }
    };
  }

  protected ByteString byteString() {
    return byteString;
  }

  /**
   * Copies bytes into a ByteBuffer.
   *
   * @throws java.nio.ReadOnlyBufferException if the target is read-only
   * @throws java.nio.BufferOverflowException if the target's remaining() space is not large
   *        enough to hold the data
   */
  public final void copyTo(ByteBuffer target) {
    byteString.copyTo(target);
  }

  /**
   * Copies bytes into a buffer.
   *
   * @throws IndexOutOfBoundsException if an offset or size is negative or too large
   */
  public final void copyTo(byte[] target) {
    byteString.copyTo(target, 0, 0, length());
  }

  public static final ByteArray copyFrom(byte[] bytes) {
    return new ByteArray(ByteString.copyFrom(bytes));
  }

  /**
   * Copy the bytes using {@code UTF-8} decoding.
   */
  public static final ByteArray copyFrom(String string) {
    return new ByteArray(ByteString.copyFrom(string, StandardCharsets.UTF_8));
  }

  public static final ByteArray copyFrom(ByteBuffer bytes) {
    return new ByteArray(ByteString.copyFrom(bytes));
  }

  public static final ByteArray copyFrom(InputStream input) throws IOException {
    BufferedInputStream bufferedInput = new BufferedInputStream(input);
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    int value;
    while ((value = bufferedInput.read()) != -1) {
      bytes.write(value);
    }
    return copyFrom(bytes.toByteArray());
  }
}
