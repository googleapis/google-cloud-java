/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/**
 * Sortable String Format encoding utilities for Spanner keys.
 *
 * <p>This class provides methods to encode various data types into a byte format that preserves
 * lexicographic ordering. The encoding supports both increasing and decreasing sort orders.
 */
@InternalApi
public final class SsFormat {

  /**
   * Makes the given key a prefix successor. This means that the returned key is the smallest
   * possible key that is larger than the input key, and that does not have the input key as a
   * prefix.
   *
   * <p>This is done by flipping the least significant bit of the last byte of the key.
   *
   * @param key The key to make a prefix successor.
   * @return The prefix successor key.
   */
  public static ByteString makePrefixSuccessor(ByteString key) {
    if (key == null || key.isEmpty()) {
      return ByteString.EMPTY;
    }
    byte[] bytes = key.toByteArray();
    bytes[bytes.length - 1] = (byte) (bytes[bytes.length - 1] | 1);
    return ByteString.copyFrom(bytes);
  }

  private SsFormat() {}

  private static final int IS_KEY = 0x80;

  // HeaderType enum values
  // Unsigned integers (variable length 1-9 bytes)
  private static final int TYPE_UINT_1 = 0;
  private static final int TYPE_DECREASING_UINT_1 = 40;

  // Signed integers (variable length 1-8 bytes)
  private static final int TYPE_NEG_INT_1 = 16;
  private static final int TYPE_POS_INT_1 = 17;
  private static final int TYPE_DECREASING_NEG_INT_1 = 48;
  private static final int TYPE_DECREASING_POS_INT_1 = 49;

  // Strings
  private static final int TYPE_STRING = 25;
  private static final int TYPE_DECREASING_STRING = 57;

  // Nullable markers
  private static final int TYPE_NULL_ORDERED_FIRST = 27;
  private static final int TYPE_NULLABLE_NOT_NULL_NULL_ORDERED_FIRST = 28;
  private static final int TYPE_NULLABLE_NOT_NULL_NULL_ORDERED_LAST = 59;
  private static final int TYPE_NULL_ORDERED_LAST = 60;

  // Doubles (variable length 1-8 bytes, encoded as transformed int64)
  private static final int TYPE_NEG_DOUBLE_1 = 73;
  private static final int TYPE_POS_DOUBLE_1 = 74;
  private static final int TYPE_DECREASING_NEG_DOUBLE_1 = 89;
  private static final int TYPE_DECREASING_POS_DOUBLE_1 = 90;

  // EscapeChar enum values
  private static final byte ASCENDING_ZERO_ESCAPE = (byte) 0xf0;
  private static final byte ASCENDING_FF_ESCAPE = (byte) 0x10;
  private static final byte SEP = (byte) 0x78; // 'x'

  // For AppendCompositeTag
  private static final int K_OBJECT_EXISTENCE_TAG = 0x7e;
  private static final int K_MAX_FIELD_TAG = 0xffff;

  // Offset to make negative timestamp seconds sort correctly
  private static final long TIMESTAMP_SECONDS_OFFSET = 1L << 63;

  public static void appendCompositeTag(UnsynchronizedByteArrayOutputStream out, int tag) {
    if (tag == K_OBJECT_EXISTENCE_TAG || tag <= 0 || tag > K_MAX_FIELD_TAG) {
      throw new IllegalArgumentException("Invalid tag value: " + tag);
    }

    if (tag < 16) {
      // Short tag: 000 TTTT S (S is LSB of tag, but here tag is original, so S=0)
      // Encodes as (tag << 1)
      out.write((byte) (tag << 1));
    } else {
      // Long tag
      int shiftedTag = tag << 1; // LSB is 0 for prefix successor
      if (shiftedTag < (1 << (5 + 8))) { // Original tag < 4096
        // Header: num_extra_bytes=1 (01xxxxx), P=payload bits from tag
        // (1 << 5) is 00100000
        // (shiftedTag >> 8) are the 5 MSBs of the payload part of the tag
        out.write((byte) ((1 << 5) | (shiftedTag >> 8)));
        out.write((byte) (shiftedTag & 0xFF));
      } else { // Original tag >= 4096 and <= K_MAX_FIELD_TAG (65535)
        // Header: num_extra_bytes=2 (10xxxxx)
        // (2 << 5) is 01000000
        out.write((byte) ((2 << 5) | (shiftedTag >> 16)));
        out.write((byte) ((shiftedTag >> 8) & 0xFF));
        out.write((byte) (shiftedTag & 0xFF));
      }
    }
  }

  public static void appendNullOrderedFirst(UnsynchronizedByteArrayOutputStream out) {
    out.write((byte) (IS_KEY | TYPE_NULL_ORDERED_FIRST));
    out.write((byte) 0);
  }

  public static void appendNullOrderedLast(UnsynchronizedByteArrayOutputStream out) {
    out.write((byte) (IS_KEY | TYPE_NULL_ORDERED_LAST));
    out.write((byte) 0);
  }

  public static void appendNotNullMarkerNullOrderedFirst(UnsynchronizedByteArrayOutputStream out) {
    out.write((byte) (IS_KEY | TYPE_NULLABLE_NOT_NULL_NULL_ORDERED_FIRST));
  }

  public static void appendNotNullMarkerNullOrderedLast(UnsynchronizedByteArrayOutputStream out) {
    out.write((byte) (IS_KEY | TYPE_NULLABLE_NOT_NULL_NULL_ORDERED_LAST));
  }

  /**
   * Appends a boolean value in ascending (increasing) sort order.
   *
   * <p>Boolean values are encoded using unsigned integer encoding where false=0 and true=1. This
   * preserves the natural ordering where false &lt; true.
   *
   * @param out the output stream to append to
   * @param value the boolean value to encode
   */
  public static void appendBoolIncreasing(UnsynchronizedByteArrayOutputStream out, boolean value) {
    // BOOL uses unsigned int encoding: false=0, true=1
    // For values 0 and 1, payload is always 1 byte
    int encoded = value ? 1 : 0;
    out.write((byte) (IS_KEY | TYPE_UINT_1)); // Header for 1-byte unsigned int
    out.write(
        (byte) (encoded << 1)); // Payload: value shifted left by 1 (LSB is prefix-successor bit)
  }

  /**
   * Appends a boolean value in descending (decreasing) sort order.
   *
   * <p>Boolean values are encoded using unsigned integer encoding where false=0 and true=1, then
   * inverted for descending order. This preserves reverse ordering where true &lt; false.
   *
   * @param out the output stream to append to
   * @param value the boolean value to encode
   */
  public static void appendBoolDecreasing(UnsynchronizedByteArrayOutputStream out, boolean value) {
    // BOOL uses decreasing unsigned int encoding: false=0, true=1, then inverted
    // For values 0 and 1, payload is always 1 byte
    int encoded = value ? 1 : 0;
    out.write(
        (byte) (IS_KEY | TYPE_DECREASING_UINT_1)); // Header for 1-byte decreasing unsigned int
    out.write((byte) ((~encoded & 0x7F) << 1)); // Inverted payload
  }

  private static void appendInt64Internal(
      UnsynchronizedByteArrayOutputStream out, long val, boolean decreasing, boolean isDouble) {
    if (decreasing) {
      val = ~val;
    }

    byte[] buf = new byte[8]; // Max 8 bytes for payload
    int len = 0;
    long tempVal = val;

    if (tempVal >= 0) {
      buf[7 - len] = (byte) ((tempVal & 0x7F) << 1);
      tempVal >>= 7;
      len++;
      while (tempVal > 0) {
        buf[7 - len] = (byte) (tempVal & 0xFF);
        tempVal >>= 8;
        len++;
      }
    } else { // tempVal < 0
      // For negative numbers, extend sign bit after shifting
      buf[7 - len] = (byte) ((tempVal & 0x7F) << 1);
      // Simulate sign extension for right shift of negative number
      // (x >> 7) | 0xFE00000000000000ULL; (if x has 64 bits)
      // In Java, right shift `>>` on negative longs performs sign extension.
      tempVal >>= 7;
      len++;
      while (tempVal != -1L) { // Loop until all remaining bits are 1s (sign extension)
        buf[7 - len] = (byte) (tempVal & 0xFF);
        tempVal >>= 8;
        len++;
        if (len > 8) {
          // Defensive assertion: unreachable for any valid 64-bit signed integer
          throw new AssertionError("Signed int encoding overflow");
        }
      }
    }

    int type;
    if (val >= 0) { // Original val before potential bit-negation for decreasing
      if (!decreasing) {
        type = isDouble ? (TYPE_POS_DOUBLE_1 + len - 1) : (TYPE_POS_INT_1 + len - 1);
      } else {
        type =
            isDouble
                ? (TYPE_DECREASING_POS_DOUBLE_1 + len - 1)
                : (TYPE_DECREASING_POS_INT_1 + len - 1);
      }
    } else {
      if (!decreasing) {
        type = isDouble ? (TYPE_NEG_DOUBLE_1 - len + 1) : (TYPE_NEG_INT_1 - len + 1);
      } else {
        type =
            isDouble
                ? (TYPE_DECREASING_NEG_DOUBLE_1 - len + 1)
                : (TYPE_DECREASING_NEG_INT_1 - len + 1);
      }
    }
    out.write((byte) (IS_KEY | type));
    out.write(buf, 8 - len, len);
  }

  public static void appendInt64Increasing(UnsynchronizedByteArrayOutputStream out, long value) {
    appendInt64Internal(out, value, false, false);
  }

  public static void appendInt64Decreasing(UnsynchronizedByteArrayOutputStream out, long value) {
    appendInt64Internal(out, value, true, false);
  }

  public static void appendDoubleIncreasing(UnsynchronizedByteArrayOutputStream out, double value) {
    long enc = Double.doubleToRawLongBits(value);
    if (enc < 0) {
      // Transform negative doubles to maintain lexicographic sort order
      enc = Long.MIN_VALUE - enc;
    }
    appendInt64Internal(out, enc, false, true);
  }

  public static void appendDoubleDecreasing(UnsynchronizedByteArrayOutputStream out, double value) {
    long enc = Double.doubleToRawLongBits(value);
    if (enc < 0) {
      enc = Long.MIN_VALUE - enc;
    }
    appendInt64Internal(out, enc, true, true);
  }

  private static void appendByteSequence(
      UnsynchronizedByteArrayOutputStream out, byte[] bytes, boolean decreasing) {
    out.write((byte) (IS_KEY | (decreasing ? TYPE_DECREASING_STRING : TYPE_STRING)));

    for (byte b : bytes) {
      byte currentByte = decreasing ? (byte) ~b : b;
      int unsignedByte = currentByte & 0xFF;
      if (unsignedByte == 0x00) {
        // Escape sequence for 0x00: write 0x00 followed by 0xF0
        out.write((byte) 0x00);
        out.write(ASCENDING_ZERO_ESCAPE);
      } else if (unsignedByte == 0xFF) {
        // Escape sequence for 0xFF: write 0xFF followed by 0x10
        out.write((byte) 0xFF);
        out.write(ASCENDING_FF_ESCAPE);
      } else {
        out.write((byte) unsignedByte);
      }
    }
    // Terminator
    out.write((byte) (decreasing ? 0xFF : 0x00));
    out.write(SEP);
  }

  public static void appendStringIncreasing(UnsynchronizedByteArrayOutputStream out, String value) {
    appendByteSequence(out, value.getBytes(StandardCharsets.UTF_8), false);
  }

  public static void appendStringDecreasing(UnsynchronizedByteArrayOutputStream out, String value) {
    appendByteSequence(out, value.getBytes(StandardCharsets.UTF_8), true);
  }

  public static void appendBytesIncreasing(UnsynchronizedByteArrayOutputStream out, byte[] value) {
    appendByteSequence(out, value, false);
  }

  public static void appendBytesDecreasing(UnsynchronizedByteArrayOutputStream out, byte[] value) {
    appendByteSequence(out, value, true);
  }

  /**
   * Encodes a timestamp as 12 bytes: 8 bytes for seconds since epoch (with offset to handle
   * negative), 4 bytes for nanoseconds.
   */
  public static byte[] encodeTimestamp(long seconds, int nanos) {
    long offsetSeconds = seconds + TIMESTAMP_SECONDS_OFFSET;
    byte[] buf = new byte[12];
    ByteBuffer.wrap(buf).order(ByteOrder.BIG_ENDIAN).putLong(offsetSeconds).putInt(nanos);
    return buf;
  }

  /** Encodes a UUID (128-bit) as 16 bytes in big-endian order. */
  public static byte[] encodeUuid(long high, long low) {
    byte[] buf = new byte[16];
    ByteBuffer.wrap(buf).order(ByteOrder.BIG_ENDIAN).putLong(high).putLong(low);
    return buf;
  }
}
