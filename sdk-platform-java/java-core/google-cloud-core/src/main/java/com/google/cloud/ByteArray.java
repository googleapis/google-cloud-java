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

package com.google.cloud;

import com.google.api.core.BetaApi;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.io.BaseEncoding;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/** An immutable byte array holder. */
@BetaApi
public class ByteArray implements Iterable<Byte>, Serializable {

  private static final long serialVersionUID = -1908809133893782840L;
  private static final BaseEncoding encoder = BaseEncoding.base64();

  private final ByteString byteString;

  ByteArray(ByteString byteString) {
    this.byteString = byteString;
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

  /** Returns the number of bytes in this {@code ByteArray}. */
  public final int length() {
    return byteString.size();
  }

  /** Returns a copy of this {@code ByteArray} as an array of bytes. */
  public final byte[] toByteArray() {
    return byteString.toByteArray();
  }

  /** Returns a copy of this {@code ByteArray} as an {@code UTF-8} string. */
  public final String toStringUtf8() {
    return byteString.toStringUtf8();
  }

  /** Converts this byte array to its base64 representation. */
  public final String toBase64() {
    return encoder.encode(toByteArray());
  }

  /** Returns the content of this {@code ByteArray} as a read-only {@link ByteBuffer}. */
  public final ByteBuffer asReadOnlyByteBuffer() {
    return byteString.asReadOnlyByteBuffer();
  }

  /** Returns an {@link InputStream} for this {@code ByteArray} content. */
  public final InputStream asInputStream() {
    return byteString.newInput();
  }

  /**
   * Copies the content of this {@code ByteArray} into an existing {@code ByteBuffer}.
   *
   * @throws java.nio.ReadOnlyBufferException if the target is read-only
   * @throws java.nio.BufferOverflowException if the target's {@link ByteBuffer#remaining()} space
   *     is not large enough to hold the data
   */
  public final void copyTo(ByteBuffer target) {
    byteString.copyTo(target);
  }

  /**
   * Copies the content of this {@code ByteArray} into an array of bytes.
   *
   * @throws IndexOutOfBoundsException if the target is not large enough to hold the data
   */
  public final void copyTo(byte[] target) {
    byteString.copyTo(target, 0);
  }

  /** Creates a {@code ByteArray} object given an array of bytes. The bytes are copied. */
  public static final ByteArray copyFrom(byte[] bytes) {
    return new ByteArray(ByteString.copyFrom(bytes));
  }

  /**
   * Creates a {@code ByteArray} object given a string. The string is encoded in {@code UTF-8}. The
   * bytes are copied.
   */
  public static final ByteArray copyFrom(String string) {
    return new ByteArray(ByteString.copyFrom(string, StandardCharsets.UTF_8));
  }

  /** Creates a {@code ByteArray} object given a {@link ByteBuffer}. The bytes are copied. */
  public static final ByteArray copyFrom(ByteBuffer bytes) {
    return new ByteArray(ByteString.copyFrom(bytes));
  }

  /**
   * Creates a {@code ByteArray} object given an {@link InputStream}. The stream is read into the
   * created object.
   */
  public static final ByteArray copyFrom(InputStream input) throws IOException {
    return new ByteArray(ByteString.readFrom(input));
  }

  /** Creates a {@code ByteArray} from a base64 representation. */
  public static ByteArray fromBase64(String data) {
    return ByteArray.copyFrom(encoder.decode(data));
  }
}
