/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.cloud.ByteArray;
import com.google.common.io.BaseEncoding;
import java.nio.ByteBuffer;

/**
 * Utilities for working with {@link ByteArray} instances. Intended for use by the Cloud Spanner
 * implementation.
 */
public final class ByteArrays {
  private static final String ELLIPSIS = "...";
  private static final BaseEncoding encoder = BaseEncoding.base64();

  private ByteArrays() {}

  /** Converts a byte array to its base64 representation. */
  static String toBase64(ByteArray data) {
    return encoder.encode(data.toByteArray());
  }

  /** Creates a byte array from a base64 representation. */
  static ByteArray fromBase64(String data) {
    return ByteArray.copyFrom(encoder.decode(data));
  }

  /**
   * Returns a readable string representation of a byte array. Printable ASCII bytes are displayed
   * as is, all other values are shown as Octal escape sequences.
   */
  public static String toString(ByteArray byteArray) {
    return toString(byteArray.asReadOnlyByteBuffer());
  }

  static String toString(ByteBuffer data) {
    return appendToString(data, new StringBuilder(), Integer.MAX_VALUE).toString();
  }

  /**
   * Returns a readable string representation of a byte array that is at most {@code maxLength} in
   * length.
   */
  static String toString(ByteArray byteArray, int maxLength) {
    return appendToString(byteArray, new StringBuilder(), maxLength).toString();
  }

  /**
   * Appends a string representation of {@code byteArray} to {@code b}, adding up to {@code
   * maxLength} additional characters. The implementation may temporarily use up to four additional
   * characters in {@code b} above {@code maxLength}, so callers may want to add a little slack if
   * calling {@link StringBuilder#ensureCapacity(int)}.
   */
  static StringBuilder appendToString(ByteArray byteArray, StringBuilder b, int maxLength) {
    return appendToString(byteArray.asReadOnlyByteBuffer(), b, maxLength);
  }

  static StringBuilder appendToString(ByteBuffer data, StringBuilder b, int maxLength) {
    maxLength = Math.max(ELLIPSIS.length(), maxLength);
    final int startPos = b.length();
    int lastFit = 0;
    boolean truncate = false;
    while (data.remaining() > 0 && !truncate) {
      byteToString(b, data.get());
      if (b.length() + ELLIPSIS.length() - startPos <= maxLength) {
        lastFit = b.length();
      } else {
        truncate = b.length() - startPos > maxLength;
      }
    }
    if (truncate) {
      b.setLength(lastFit);
      b.append(ELLIPSIS);
    }
    return b;
  }

  private static void byteToString(StringBuilder b, byte d) {
    if (isAsciiPrintable(d)) {
      b.append((char) d);
    } else {
      // Append as octal escape.
      b.append('\\').append(Integer.toString(0xff & d, 8));
    }
  }

  private static boolean isAsciiPrintable(byte b) {
    return b >= 32 && b < 127;
  }
}
