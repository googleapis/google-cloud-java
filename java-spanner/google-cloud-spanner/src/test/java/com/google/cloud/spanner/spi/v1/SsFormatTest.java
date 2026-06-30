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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.ByteString;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Unit tests for {@link SsFormat}. */
@RunWith(JUnit4.class)
public class SsFormatTest {

  private static List<Long> signedIntTestValues;
  private static List<Long> unsignedIntTestValues;
  private static List<Double> doubleTestValues;

  /** Comparator for unsigned lexicographic comparison of byte arrays. */
  private static final Comparator<byte[]> UNSIGNED_BYTE_COMPARATOR =
      (a, b) ->
          ByteString.unsignedLexicographicalComparator()
              .compare(ByteString.copyFrom(a), ByteString.copyFrom(b));

  @BeforeClass
  public static void setUpTestData() {
    signedIntTestValues = buildSignedIntTestValues();
    unsignedIntTestValues = buildUnsignedIntTestValues();
    doubleTestValues = buildDoubleTestValues();
  }

  private static List<Long> buildSignedIntTestValues() {
    TreeSet<Long> values = new TreeSet<>();

    // Range of small values
    for (int i = -300; i < 300; i++) {
      values.add((long) i);
    }

    // Powers of 2 and boundaries
    for (int i = 0; i < 63; i++) {
      long powerOf2 = 1L << i;
      values.add(powerOf2);
      values.add(powerOf2 - 1);
      values.add(powerOf2 + 1);
      values.add(-powerOf2);
      values.add(-powerOf2 - 1);
      values.add(-powerOf2 + 1);
    }

    // Edge cases
    values.add(Long.MIN_VALUE);
    values.add(Long.MAX_VALUE);

    return new ArrayList<>(values);
  }

  private static List<Long> buildUnsignedIntTestValues() {
    TreeSet<Long> values = new TreeSet<>(Long::compareUnsigned);

    // Range of small values
    for (int i = 0; i < 600; i++) {
      values.add((long) i);
    }

    // Powers of 2 and boundaries (treating as unsigned)
    for (int i = 0; i < 64; i++) {
      long powerOf2 = 1L << i;
      values.add(powerOf2);
      if (powerOf2 > 0) {
        values.add(powerOf2 - 1);
      }
      values.add(powerOf2 + 1);
    }

    // Max unsigned value (all bits set)
    values.add(-1L); // 0xFFFFFFFFFFFFFFFF as unsigned

    return new ArrayList<>(values);
  }

  private static List<Double> buildDoubleTestValues() {
    TreeSet<Double> values =
        new TreeSet<>(
            (a, b) -> {
              // Handle NaN specially - put at end
              if (Double.isNaN(a) && Double.isNaN(b)) return 0;
              if (Double.isNaN(a)) return 1;
              if (Double.isNaN(b)) return -1;
              return Double.compare(a, b);
            });

    // Basic values
    values.add(0.0);
    values.add(-0.0);
    values.add(Double.POSITIVE_INFINITY);
    values.add(Double.NEGATIVE_INFINITY);
    values.add(Double.MIN_VALUE);
    values.add(Double.MAX_VALUE);
    values.add(-Double.MIN_VALUE);
    values.add(-Double.MAX_VALUE);

    // Powers of 10
    double value = 1.0;
    for (int i = 0; i < 10; i++) {
      values.add(value);
      values.add(-value);
      value /= 10;
    }

    long[] signs = {0, 1};
    long[] exponents = {
      0, 1, 2, 100, 200, 512, 1000, 1020, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029,
      2000, 2045, 2046, 2047
    };
    long[] fractions = {
      0,
      1,
      2,
      10,
      16,
      255,
      256,
      32767,
      32768,
      65535,
      65536,
      1000000,
      0x7ffffffeL,
      0x7fffffffL,
      0x80000000L,
      0x80000001L,
      0x80000002L,
      0x0003456789abcdefL,
      0x0007fffffffffffeL,
      0x0007ffffffffffffL,
      0x0008000000000000L,
      0x0008000000000001L,
      0x000cba9876543210L,
      0x000fffffffff0000L,
      0x000ffffffffff000L,
      0x000fffffffffff00L,
      0x000ffffffffffff0L,
      0x000ffffffffffff8L,
      0x000ffffffffffffcL,
      0x000ffffffffffffeL,
      0x000fffffffffffffL
    };

    for (long sign : signs) {
      for (long exponent : exponents) {
        for (long fraction : fractions) {
          long bits = (sign << 63) | (exponent << 52) | fraction;
          values.add(Double.longBitsToDouble(bits));
        }
      }
    }

    return new ArrayList<>(values);
  }

  // ==================== Prefix Successor Tests ====================

  @Test
  public void makePrefixSuccessor_emptyInput_returnsEmpty() {
    assertEquals(ByteString.EMPTY, SsFormat.makePrefixSuccessor(ByteString.EMPTY));
    assertEquals(ByteString.EMPTY, SsFormat.makePrefixSuccessor(null));
  }

  @Test
  public void makePrefixSuccessor_singleByte_setsLsb() {
    ByteString input = ByteString.copyFrom(new byte[] {0x00});
    ByteString result = SsFormat.makePrefixSuccessor(input);

    assertEquals(1, result.size());
    assertEquals(0x01, result.byteAt(0) & 0xFF);
  }

  @Test
  public void makePrefixSuccessor_multipleBytes_onlyModifiesLastByte() {
    ByteString input = ByteString.copyFrom(new byte[] {0x12, 0x34, 0x00});
    ByteString result = SsFormat.makePrefixSuccessor(input);

    assertEquals(3, result.size());
    assertEquals(0x12, result.byteAt(0) & 0xFF);
    assertEquals(0x34, result.byteAt(1) & 0xFF);
    assertEquals(0x01, result.byteAt(2) & 0xFF);
  }

  @Test
  public void makePrefixSuccessor_resultIsGreaterThanOriginal() {
    byte[] original = new byte[] {0x10, 0x20, 0x30};
    ByteString successor = SsFormat.makePrefixSuccessor(ByteString.copyFrom(original));

    assertTrue(
        ByteString.unsignedLexicographicalComparator()
                .compare(ByteString.copyFrom(original), successor)
            < 0);
  }

  // ==================== Composite Tag Tests ====================

  @Test
  public void appendCompositeTag_shortTag_encodesInOneByte() {
    // Tags 1-15 should fit in 1 byte
    for (int tag = 1; tag <= 15; tag++) {
      UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
      SsFormat.appendCompositeTag(out, tag);
      byte[] result = out.toByteArray();

      assertEquals("Tag " + tag + " should encode to 1 byte", 1, result.length);
      assertEquals("Tag " + tag + " should encode as tag << 1", tag << 1, result[0] & 0xFF);
    }
  }

  @Test
  public void appendCompositeTag_mediumTag_encodesInTwoBytes() {
    // Tags 16-4095 should fit in 2 bytes
    int[] testTags = {16, 100, 1000, 4095};
    for (int tag : testTags) {
      UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
      SsFormat.appendCompositeTag(out, tag);
      byte[] result = out.toByteArray();

      assertEquals("Tag " + tag + " should encode to 2 bytes", 2, result.length);
    }
  }

  @Test
  public void appendCompositeTag_largeTag_encodesInThreeBytes() {
    // Tags 4096-65535 should fit in 3 bytes
    int[] testTags = {4096, 10000, 65535};
    for (int tag : testTags) {
      UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
      SsFormat.appendCompositeTag(out, tag);
      byte[] result = out.toByteArray();

      assertEquals("Tag " + tag + " should encode to 3 bytes", 3, result.length);
    }
  }

  @Test
  public void appendCompositeTag_invalidTag_throws() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    assertThrows(IllegalArgumentException.class, () -> SsFormat.appendCompositeTag(out, 0));
    assertThrows(IllegalArgumentException.class, () -> SsFormat.appendCompositeTag(out, -1));
    assertThrows(IllegalArgumentException.class, () -> SsFormat.appendCompositeTag(out, 65536));
  }

  @Test
  public void appendCompositeTag_preservesOrdering() {
    // Verify smaller tags encode to lexicographically smaller byte sequences
    for (int tag1 = 1; tag1 <= 100; tag1++) {
      for (int tag2 = tag1 + 1; tag2 <= 101 && tag2 <= tag1 + 10; tag2++) {
        UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
        UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

        SsFormat.appendCompositeTag(out1, tag1);
        SsFormat.appendCompositeTag(out2, tag2);

        assertTrue(
            "Tag " + tag1 + " should encode smaller than tag " + tag2,
            UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
      }
    }
  }

  // ==================== Signed Integer Tests ====================

  @Test
  public void appendInt64Increasing_preservesOrdering() {
    // Verify that encoded integers maintain their natural ordering
    for (int i = 0; i < signedIntTestValues.size() - 1; i++) {
      long v1 = signedIntTestValues.get(i);
      long v2 = signedIntTestValues.get(i + 1);

      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendInt64Increasing(out1, v1);
      SsFormat.appendInt64Increasing(out2, v2);

      assertTrue(
          "Encoded " + v1 + " should be less than encoded " + v2,
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
    }
  }

  @Test
  public void appendInt64Decreasing_reversesOrdering() {
    // Verify that decreasing encoding reverses the ordering
    for (int i = 0; i < signedIntTestValues.size() - 1; i++) {
      long v1 = signedIntTestValues.get(i);
      long v2 = signedIntTestValues.get(i + 1);

      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendInt64Decreasing(out1, v1);
      SsFormat.appendInt64Decreasing(out2, v2);

      assertTrue(
          "Decreasing encoded " + v1 + " should be greater than encoded " + v2,
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) > 0);
    }
  }

  @Test
  public void appendInt64Increasing_hasIsKeyBitSet() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendInt64Increasing(out, 42);
    byte[] result = out.toByteArray();

    assertTrue("IS_KEY bit (0x80) should be set", (result[0] & 0x80) != 0);
  }

  @Test
  public void appendInt64Increasing_edgeCases() {
    long[] edgeCases = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE};

    for (long value : edgeCases) {
      UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
      SsFormat.appendInt64Increasing(out, value);
      byte[] result = out.toByteArray();

      assertTrue("Result should have at least 2 bytes for value " + value, result.length >= 2);
      assertTrue("IS_KEY bit should be set for value " + value, (result[0] & 0x80) != 0);
    }
  }

  // ==================== Boolean Tests ====================

  @Test
  public void appendBoolIncreasing_preservesOrdering() {
    UnsynchronizedByteArrayOutputStream outFalse = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outTrue = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendBoolIncreasing(outFalse, false);
    SsFormat.appendBoolIncreasing(outTrue, true);

    assertTrue(
        "Encoded false should be less than encoded true",
        UNSIGNED_BYTE_COMPARATOR.compare(outFalse.toByteArray(), outTrue.toByteArray()) < 0);
  }

  @Test
  public void appendBoolIncreasing_encodesCorrectly() {
    UnsynchronizedByteArrayOutputStream outFalse = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outTrue = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendBoolIncreasing(outFalse, false);
    SsFormat.appendBoolIncreasing(outTrue, true);

    // false=0: header 0x80 (IS_KEY | TYPE_UINT_1), payload 0x00
    assertArrayEquals(new byte[] {(byte) 0x80, 0x00}, outFalse.toByteArray());
    // true=1: header 0x80, payload 0x02 (1 << 1)
    assertArrayEquals(new byte[] {(byte) 0x80, 0x02}, outTrue.toByteArray());
  }

  @Test
  public void appendBoolDecreasing_reversesOrdering() {
    UnsynchronizedByteArrayOutputStream outFalse = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outTrue = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendBoolDecreasing(outFalse, false);
    SsFormat.appendBoolDecreasing(outTrue, true);

    assertTrue(
        "Decreasing encoded false should be greater than encoded true",
        UNSIGNED_BYTE_COMPARATOR.compare(outFalse.toByteArray(), outTrue.toByteArray()) > 0);
  }

  @Test
  public void appendBoolDecreasing_encodesCorrectly() {
    UnsynchronizedByteArrayOutputStream outFalse = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outTrue = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendBoolDecreasing(outFalse, false);
    SsFormat.appendBoolDecreasing(outTrue, true);

    // false=0 inverted: header 0xA8 (IS_KEY | TYPE_DECREASING_UINT_1), payload 0xFE (~0 & 0x7F) <<
    // 1
    assertArrayEquals(new byte[] {(byte) 0xA8, (byte) 0xFE}, outFalse.toByteArray());
    // true=1 inverted: header 0xA8, payload 0xFC (~1 & 0x7F) << 1
    assertArrayEquals(new byte[] {(byte) 0xA8, (byte) 0xFC}, outTrue.toByteArray());
  }

  // ==================== String Tests ====================

  @Test
  public void appendStringIncreasing_preservesOrdering() {
    String[] strings = {"", "a", "aa", "ab", "b", "hello", "world", "\u00ff"};
    Arrays.sort(strings);

    for (int i = 0; i < strings.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendStringIncreasing(out1, strings[i]);
      SsFormat.appendStringIncreasing(out2, strings[i + 1]);

      assertTrue(
          "Encoded '" + strings[i] + "' should be less than '" + strings[i + 1] + "'",
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
    }
  }

  @Test
  public void appendStringDecreasing_reversesOrdering() {
    String[] strings = {"", "a", "b", "hello"};

    for (int i = 0; i < strings.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendStringDecreasing(out1, strings[i]);
      SsFormat.appendStringDecreasing(out2, strings[i + 1]);

      assertTrue(
          "Decreasing encoded '" + strings[i] + "' should be greater than '" + strings[i + 1] + "'",
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) > 0);
    }
  }

  @Test
  public void appendStringIncreasing_escapesSpecialBytes() {
    // Test that 0x00 and 0xFF bytes are properly escaped
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendBytesIncreasing(out, new byte[] {0x00, (byte) 0xFF, 0x42});
    byte[] result = out.toByteArray();

    // Result should be longer due to escaping:
    // header (1) + escaped 0x00 (2) + escaped 0xFF (2) + 0x42 (1) + terminator (2) = 8
    assertTrue("Result should include escape sequences", result.length > 5);
  }

  @Test
  public void appendStringIncreasing_emptyString() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendStringIncreasing(out, "");
    byte[] result = out.toByteArray();

    // Empty string should still have header + terminator
    assertTrue("Empty string encoding should have at least 3 bytes", result.length >= 3);
    assertTrue("IS_KEY bit should be set", (result[0] & 0x80) != 0);
  }

  // ==================== Bytes Tests ====================

  @Test
  public void appendBytesIncreasing_preservesOrdering() {
    byte[][] testBytes = {
      new byte[] {},
      new byte[] {0x00},
      new byte[] {0x01},
      new byte[] {0x01, 0x02},
      new byte[] {(byte) 0xFF}
    };

    for (int i = 0; i < testBytes.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendBytesIncreasing(out1, testBytes[i]);
      SsFormat.appendBytesIncreasing(out2, testBytes[i + 1]);

      assertTrue(
          "Encoded bytes should maintain lexicographic order",
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
    }
  }

  @Test
  public void appendBytesDecreasing_reversesOrdering() {
    byte[][] testBytes = {
      new byte[] {},
      new byte[] {0x00},
      new byte[] {0x01},
      new byte[] {0x01, 0x02},
      new byte[] {(byte) 0xFF}
    };

    for (int i = 0; i < testBytes.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendBytesDecreasing(out1, testBytes[i]);
      SsFormat.appendBytesDecreasing(out2, testBytes[i + 1]);

      assertTrue(
          "Decreasing encoded bytes should reverse lexicographic order",
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) > 0);
    }
  }

  @Test
  public void appendBytesDecreasing_escapesSpecialBytes() {
    // Test that 0x00 and 0xFF bytes are properly escaped in decreasing mode
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendBytesDecreasing(out, new byte[] {0x00, (byte) 0xFF, 0x42});
    byte[] result = out.toByteArray();

    // Result should be longer due to escaping
    // In decreasing mode: bytes are inverted, then escaped
    // Original 0x00 -> inverted to 0xFF -> needs escape (0xFF, 0x10)
    // Original 0xFF -> inverted to 0x00 -> needs escape (0x00, 0xF0)
    // Original 0x42 -> inverted to 0xBD -> no escape needed
    assertTrue("Result should include escape sequences", result.length > 5);
  }

  @Test
  public void appendBytesDecreasing_emptyArray() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendBytesDecreasing(out, new byte[] {});
    byte[] result = out.toByteArray();

    // Empty bytes should still have header + terminator
    assertTrue("Empty bytes encoding should have at least 3 bytes", result.length >= 3);
    assertTrue("IS_KEY bit should be set", (result[0] & 0x80) != 0);
  }

  @Test
  public void appendBytesIncreasing_vs_Decreasing_sameInput_differentOutput() {
    byte[] input = new byte[] {0x01, 0x02, 0x03};

    UnsynchronizedByteArrayOutputStream outInc = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outDec = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendBytesIncreasing(outInc, input);
    SsFormat.appendBytesDecreasing(outDec, input);

    // The outputs should be different (different header type and inverted bytes)
    assertFalse(
        "Increasing and decreasing encodings should differ",
        Arrays.equals(outInc.toByteArray(), outDec.toByteArray()));
  }

  // ==================== Double Tests ====================

  @Test
  public void appendDoubleIncreasing_preservesOrdering() {
    // Filter out NaN as it has special comparison semantics
    List<Double> sortedDoubles = new ArrayList<>();
    for (double d : doubleTestValues) {
      if (!Double.isNaN(d)) {
        sortedDoubles.add(d);
      }
    }
    sortedDoubles.sort(Double::compare);

    for (int i = 0; i < sortedDoubles.size() - 1; i++) {
      double v1 = sortedDoubles.get(i);
      double v2 = sortedDoubles.get(i + 1);

      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendDoubleIncreasing(out1, v1);
      SsFormat.appendDoubleIncreasing(out2, v2);

      int cmp = UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray());

      // Note: -0.0 and 0.0 encode identically (both map to 0 internally), so allow equality
      assertTrue("Encoded " + v1 + " should be <= encoded " + v2, cmp <= 0);
    }
  }

  @Test
  public void appendDoubleDecreasing_reversesOrdering() {
    double[] values = {-Double.MAX_VALUE, -1.0, 0.0, 1.0, Double.MAX_VALUE};

    for (int i = 0; i < values.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendDoubleDecreasing(out1, values[i]);
      SsFormat.appendDoubleDecreasing(out2, values[i + 1]);

      assertTrue(
          "Decreasing encoded " + values[i] + " should be greater than " + values[i + 1],
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) > 0);
    }
  }

  @Test
  public void appendDoubleIncreasing_specialValues() {
    // Test special double values
    // Note: -0.0 is excluded because it encodes identically to 0.0
    // (both have internal representation mapping to 0)
    double[] specialValues = {
      Double.NEGATIVE_INFINITY,
      -Double.MAX_VALUE,
      -1.0,
      -Double.MIN_VALUE,
      0.0, // -0.0 encodes the same as 0.0
      Double.MIN_VALUE,
      1.0,
      Double.MAX_VALUE,
      Double.POSITIVE_INFINITY
    };

    // Verify ordering is preserved
    for (int i = 0; i < specialValues.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendDoubleIncreasing(out1, specialValues[i]);
      SsFormat.appendDoubleIncreasing(out2, specialValues[i + 1]);

      assertTrue(
          "Special value " + specialValues[i] + " should encode less than " + specialValues[i + 1],
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
    }
  }

  @Test
  public void appendDoubleIncreasing_negativeZeroEqualsPositiveZero() {
    // Verify that -0.0 and 0.0 encode identically
    // This is correct behavior: both map to internal representation 0
    UnsynchronizedByteArrayOutputStream outNegZero = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream outPosZero = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendDoubleIncreasing(outNegZero, -0.0);
    SsFormat.appendDoubleIncreasing(outPosZero, 0.0);

    assertArrayEquals(
        "-0.0 and 0.0 should encode identically",
        outNegZero.toByteArray(),
        outPosZero.toByteArray());
  }

  @Test
  public void appendDoubleIncreasing_nan() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendDoubleIncreasing(out, Double.NaN);
    byte[] result = out.toByteArray();

    assertTrue("NaN encoding should have at least 2 bytes", result.length >= 2);
    assertTrue("IS_KEY bit should be set for NaN", (result[0] & 0x80) != 0);
  }

  // ==================== Null Marker Tests ====================

  @Test
  public void appendNullOrderedFirst_encoding() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendNullOrderedFirst(out);
    byte[] result = out.toByteArray();

    assertEquals("Null ordered first should encode to 2 bytes", 2, result.length);
    assertTrue("IS_KEY bit should be set", (result[0] & 0x80) != 0);
  }

  @Test
  public void appendNullOrderedLast_encoding() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendNullOrderedLast(out);
    byte[] result = out.toByteArray();

    assertEquals("Null ordered last should encode to 2 bytes", 2, result.length);
    assertTrue("IS_KEY bit should be set", (result[0] & 0x80) != 0);
  }

  @Test
  public void appendNotNullMarkerNullOrderedFirst_encoding() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendNotNullMarkerNullOrderedFirst(out);
    byte[] result = out.toByteArray();

    assertEquals("Not-null marker (nulls first) should encode to 1 byte", 1, result.length);
  }

  @Test
  public void appendNotNullMarkerNullOrderedLast_encoding() {
    UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
    SsFormat.appendNotNullMarkerNullOrderedLast(out);
    byte[] result = out.toByteArray();

    assertEquals("Not-null marker (nulls last) should encode to 1 byte", 1, result.length);
  }

  @Test
  public void nullOrderedFirst_sortsBeforeValues() {
    UnsynchronizedByteArrayOutputStream nullOut = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream valueOut = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendNullOrderedFirst(nullOut);
    SsFormat.appendNotNullMarkerNullOrderedFirst(valueOut);
    SsFormat.appendInt64Increasing(valueOut, Long.MIN_VALUE);

    assertTrue(
        "Null (ordered first) should sort before any value",
        UNSIGNED_BYTE_COMPARATOR.compare(nullOut.toByteArray(), valueOut.toByteArray()) < 0);
  }

  @Test
  public void nullOrderedLast_sortsAfterValues() {
    UnsynchronizedByteArrayOutputStream nullOut = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream valueOut = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendNullOrderedLast(nullOut);
    SsFormat.appendNotNullMarkerNullOrderedLast(valueOut);
    SsFormat.appendInt64Increasing(valueOut, Long.MAX_VALUE);

    assertTrue(
        "Null (ordered last) should sort after any value",
        UNSIGNED_BYTE_COMPARATOR.compare(nullOut.toByteArray(), valueOut.toByteArray()) > 0);
  }

  // ==================== Timestamp Tests ====================

  @Test
  public void encodeTimestamp_length() {
    byte[] result = SsFormat.encodeTimestamp(0, 0);
    assertEquals("Timestamp should encode to 12 bytes", 12, result.length);
  }

  @Test
  public void encodeTimestamp_preservesOrdering() {
    long[][] timestamps = {
      {0, 0},
      {0, 1},
      {0, 999999999},
      {1, 0},
      {100, 500000000},
      {Long.MAX_VALUE / 2, 0}
    };

    for (int i = 0; i < timestamps.length - 1; i++) {
      byte[] t1 = SsFormat.encodeTimestamp(timestamps[i][0], (int) timestamps[i][1]);
      byte[] t2 = SsFormat.encodeTimestamp(timestamps[i + 1][0], (int) timestamps[i + 1][1]);

      assertTrue(
          "Earlier timestamp should encode smaller", UNSIGNED_BYTE_COMPARATOR.compare(t1, t2) < 0);
    }
  }

  // ==================== UUID Tests ====================

  @Test
  public void encodeUuid_length() {
    byte[] result = SsFormat.encodeUuid(0, 0);
    assertEquals("UUID should encode to 16 bytes", 16, result.length);
  }

  @Test
  public void encodeUuid_bigEndianEncoding() {
    byte[] result = SsFormat.encodeUuid(0x0102030405060708L, 0x090A0B0C0D0E0F10L);

    // Verify big-endian encoding of high bits
    assertEquals(0x01, result[0] & 0xFF);
    assertEquals(0x02, result[1] & 0xFF);
    assertEquals(0x03, result[2] & 0xFF);
    assertEquals(0x04, result[3] & 0xFF);
    assertEquals(0x05, result[4] & 0xFF);
    assertEquals(0x06, result[5] & 0xFF);
    assertEquals(0x07, result[6] & 0xFF);
    assertEquals(0x08, result[7] & 0xFF);

    // Verify big-endian encoding of low bits
    assertEquals(0x09, result[8] & 0xFF);
    assertEquals(0x0A, result[9] & 0xFF);
    assertEquals(0x0B, result[10] & 0xFF);
    assertEquals(0x0C, result[11] & 0xFF);
    assertEquals(0x0D, result[12] & 0xFF);
    assertEquals(0x0E, result[13] & 0xFF);
    assertEquals(0x0F, result[14] & 0xFF);
    assertEquals(0x10, result[15] & 0xFF);
  }

  @Test
  public void encodeUuid_preservesOrdering() {
    // UUIDs compared as unsigned 128-bit integers should preserve order
    long[][] uuids = {
      {0, 0},
      {0, 1},
      {0, Long.MAX_VALUE},
      {1, 0},
      {Long.MAX_VALUE, Long.MAX_VALUE}
    };

    for (int i = 0; i < uuids.length - 1; i++) {
      byte[] u1 = SsFormat.encodeUuid(uuids[i][0], uuids[i][1]);
      byte[] u2 = SsFormat.encodeUuid(uuids[i + 1][0], uuids[i + 1][1]);

      assertTrue("UUID ordering should be preserved", UNSIGNED_BYTE_COMPARATOR.compare(u1, u2) < 0);
    }
  }

  // ==================== Composite Key Tests ====================

  @Test
  public void compositeKey_tagPlusIntPreservesOrdering() {
    int tag = 5;
    long[] values = {Long.MIN_VALUE, -1, 0, 1, Long.MAX_VALUE};

    for (int i = 0; i < values.length - 1; i++) {
      UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
      UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

      SsFormat.appendCompositeTag(out1, tag);
      SsFormat.appendInt64Increasing(out1, values[i]);

      SsFormat.appendCompositeTag(out2, tag);
      SsFormat.appendInt64Increasing(out2, values[i + 1]);

      assertTrue(
          "Composite key with " + values[i] + " should be less than with " + values[i + 1],
          UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
    }
  }

  @Test
  public void compositeKey_differentTagsSortByTag() {
    long value = 100;

    UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendCompositeTag(out1, 5);
    SsFormat.appendInt64Increasing(out1, value);

    SsFormat.appendCompositeTag(out2, 10);
    SsFormat.appendInt64Increasing(out2, value);

    assertTrue(
        "Key with smaller tag should sort first",
        UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
  }

  @Test
  public void compositeKey_multipleKeyParts() {
    // Simulate encoding a composite key with multiple parts: tag + int + string
    UnsynchronizedByteArrayOutputStream out1 = new UnsynchronizedByteArrayOutputStream();
    UnsynchronizedByteArrayOutputStream out2 = new UnsynchronizedByteArrayOutputStream();

    SsFormat.appendCompositeTag(out1, 1);
    SsFormat.appendInt64Increasing(out1, 100);
    SsFormat.appendStringIncreasing(out1, "alice");

    SsFormat.appendCompositeTag(out2, 1);
    SsFormat.appendInt64Increasing(out2, 100);
    SsFormat.appendStringIncreasing(out2, "bob");

    assertTrue(
        "Keys with same prefix but different strings should order by string",
        UNSIGNED_BYTE_COMPARATOR.compare(out1.toByteArray(), out2.toByteArray()) < 0);
  }

  // ==================== Order Preservation Summary Test ====================

  @Test
  public void orderPreservation_comprehensiveIntTest() {
    // Take a sample of values to avoid O(n^2) test time
    int step = Math.max(1, signedIntTestValues.size() / 100);
    List<Long> sample = new ArrayList<>();
    for (int i = 0; i < signedIntTestValues.size(); i += step) {
      sample.add(signedIntTestValues.get(i));
    }

    // Encode all values
    List<byte[]> encoded = new ArrayList<>();
    for (long v : sample) {
      UnsynchronizedByteArrayOutputStream out = new UnsynchronizedByteArrayOutputStream();
      SsFormat.appendInt64Increasing(out, v);
      encoded.add(out.toByteArray());
    }

    // Verify the encoded values are in the same order as the original values
    for (int i = 0; i < sample.size() - 1; i++) {
      int comparison = UNSIGNED_BYTE_COMPARATOR.compare(encoded.get(i), encoded.get(i + 1));
      assertTrue(
          "Order should be preserved: " + sample.get(i) + " < " + sample.get(i + 1),
          comparison < 0);
    }
  }
}
