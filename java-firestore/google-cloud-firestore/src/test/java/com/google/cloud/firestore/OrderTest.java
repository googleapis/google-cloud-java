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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.Order.compareByteStrings;
import static com.google.cloud.firestore.Order.compareUtf8Strings;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

public class OrderTest {

  @Test
  public void verifyOrder() {
    Value[][] groups = new Value[67][];

    groups[0] = new Value[] {nullValue()};

    groups[1] = new Value[] {booleanValue(false)};
    groups[2] = new Value[] {booleanValue(true)};

    // numbers
    groups[3] = new Value[] {doubleValue(Double.NaN), doubleValue(Double.NaN)};
    groups[4] = new Value[] {doubleValue(Double.NEGATIVE_INFINITY)};
    groups[5] = new Value[] {doubleValue((double) Long.MIN_VALUE - 100)};
    groups[6] = new Value[] {intValue((long) Integer.MIN_VALUE - 1)};
    groups[7] = new Value[] {intValue(Integer.MIN_VALUE)};
    groups[8] = new Value[] {doubleValue(-1.1)};
    // Integers and Doubles order the same.
    groups[9] = new Value[] {intValue(-1), doubleValue(-1.0)};
    groups[10] = new Value[] {doubleValue(-Double.MIN_VALUE)};
    // zeros all compare the same.
    groups[11] = new Value[] {intValue(0), doubleValue(-0.0), doubleValue(0.0), doubleValue(+0.0)};
    groups[12] = new Value[] {doubleValue(Double.MIN_VALUE)};
    groups[13] = new Value[] {intValue(1), doubleValue(1.0)};
    groups[14] = new Value[] {doubleValue(1.1)};
    groups[15] = new Value[] {intValue(Integer.MAX_VALUE)};
    groups[16] = new Value[] {intValue((long) Integer.MAX_VALUE + 1)};
    groups[17] = new Value[] {doubleValue(((double) Long.MAX_VALUE) + 100)};
    groups[18] = new Value[] {doubleValue(Double.POSITIVE_INFINITY)};

    groups[19] = new Value[] {timestampValue(123, 0)};
    groups[20] = new Value[] {timestampValue(123, 123)};
    groups[21] = new Value[] {timestampValue(345, 0)};

    // strings
    groups[22] = new Value[] {stringValue("")};
    groups[23] = new Value[] {stringValue("\u0000\ud7ff\ue000\uffff")};
    groups[24] = new Value[] {stringValue("(╯°□°）╯︵ ┻━┻")};
    groups[25] = new Value[] {stringValue("a")};
    groups[26] = new Value[] {stringValue("abc def")};
    // latin small letter e + combining acute accent + latin small letter b
    groups[27] = new Value[] {stringValue("e\u0301b")};
    groups[28] = new Value[] {stringValue("æ")};
    // latin small letter e with acute accent + latin small letter a
    groups[29] = new Value[] {stringValue("\u00e9a")};

    // blobs
    groups[30] = new Value[] {blobValue(new byte[] {})};
    groups[31] = new Value[] {blobValue(new byte[] {0})};
    groups[32] = new Value[] {blobValue(new byte[] {0, 1, 2, 3, 4})};
    groups[33] = new Value[] {blobValue(new byte[] {0, 1, 2, 4, 3})};
    groups[34] = new Value[] {blobValue(new byte[] {127})};

    // resource names
    groups[35] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc1")};
    groups[36] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2")};
    groups[37] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2/c2/doc1")};
    groups[38] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c1/doc2/c2/doc2")};
    groups[39] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c10/doc1")};
    groups[40] = new Value[] {referenceValue("projects/p1/databases/d1/documents/c2/doc1")};
    groups[41] = new Value[] {referenceValue("projects/p2/databases/d2/documents/c1/doc1")};
    groups[42] = new Value[] {referenceValue("projects/p2/databases/d2/documents/c1-/doc1")};
    groups[43] = new Value[] {referenceValue("projects/p2/databases/d3/documents/c1-/doc1")};

    // geo points
    groups[44] = new Value[] {geoPointValue(-90, -180)};
    groups[45] = new Value[] {geoPointValue(-90, 0)};
    groups[46] = new Value[] {geoPointValue(-90, 180)};
    groups[47] = new Value[] {geoPointValue(0, -180)};
    groups[48] = new Value[] {geoPointValue(0, 0)};
    groups[49] = new Value[] {geoPointValue(0, 180)};
    groups[50] = new Value[] {geoPointValue(1, -180)};
    groups[51] = new Value[] {geoPointValue(1, 0)};
    groups[52] = new Value[] {geoPointValue(1, 180)};
    groups[53] = new Value[] {geoPointValue(90, -180)};
    groups[54] = new Value[] {geoPointValue(90, 0)};
    groups[55] = new Value[] {geoPointValue(90, 180)};

    // arrays
    groups[56] = new Value[] {arrayValue()};
    groups[57] = new Value[] {arrayValue(stringValue("bar"))};
    groups[58] = new Value[] {arrayValue(stringValue("foo"))};
    groups[59] = new Value[] {arrayValue(stringValue("foo"), intValue(0))};
    groups[60] = new Value[] {arrayValue(stringValue("foo"), intValue(1))};
    groups[61] = new Value[] {arrayValue(stringValue("foo"), stringValue("0"))};

    // objects
    groups[62] = new Value[] {objectValue("bar", intValue(0))};
    groups[63] = new Value[] {objectValue("bar", intValue(0), "foo", intValue(1))};
    groups[64] = new Value[] {objectValue("bar", intValue(1))};
    groups[65] = new Value[] {objectValue("bar", intValue(2))};
    groups[66] = new Value[] {objectValue("bar", stringValue("0"))};

    for (int left = 0; left < groups.length; left++) {
      for (int right = 0; right < groups.length; right++) {
        for (int i = 0; i < groups[left].length; i++) {
          for (int j = 0; j < groups[right].length; j++) {
            assertEquals(
                String.format(
                    "Order does not match for: groups[%d][%d] and groups[%d][%d]",
                    left, i, right, j),
                Integer.compare(left, right),
                Integer.compare(Order.INSTANCE.compare(groups[left][i], groups[right][j]), 0));
          }
        }
      }
    }
  }

  private Value booleanValue(boolean b) {
    return Value.newBuilder().setBooleanValue(b).build();
  }

  private Value doubleValue(double d) {
    return Value.newBuilder().setDoubleValue(d).build();
  }

  private Value intValue(long l) {
    return Value.newBuilder().setIntegerValue(l).build();
  }

  private Value stringValue(String s) {
    return Value.newBuilder().setStringValue(s).build();
  }

  private Value referenceValue(String r) {
    return Value.newBuilder().setReferenceValue(r).build();
  }

  private Value blobValue(byte[] b) {
    return Value.newBuilder().setBytesValue(ByteString.copyFrom(b)).build();
  }

  private Value nullValue() {
    return Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
  }

  private Value timestampValue(long seconds, int nanos) {
    return Value.newBuilder()
        .setTimestampValue(Timestamp.newBuilder().setSeconds(seconds).setNanos(nanos).build())
        .build();
  }

  private Value geoPointValue(double latitude, double longitude) {
    return Value.newBuilder()
        .setGeoPointValue(LatLng.newBuilder().setLatitude(latitude).setLongitude(longitude).build())
        .build();
  }

  private Value arrayValue(Value... values) {
    return Value.newBuilder()
        .setArrayValue(ArrayValue.newBuilder().addAllValues(Arrays.asList(values)).build())
        .build();
  }

  private Value objectValue(String key, Value value, Object... keysAndValues) {
    MapValue.Builder mapBuilder = MapValue.newBuilder();
    mapBuilder.putFields(key, value);

    for (int i = 0; i < keysAndValues.length; i += 2) {
      mapBuilder.putFields((String) keysAndValues[i], (Value) keysAndValues[i + 1]);
    }

    return Value.newBuilder().setMapValue(mapBuilder.build()).build();
  }

  @Test
  public void compareUtf8StringsShouldReturnCorrectValue() {
    ArrayList<String> errors = new ArrayList<>();
    int seed = new Random().nextInt(Integer.MAX_VALUE);
    int passCount = 0;
    StringGenerator stringGenerator = new StringGenerator(29750468);
    StringPairGenerator stringPairGenerator = new StringPairGenerator(stringGenerator);
    for (int i = 0; i < 1_000_000 && errors.size() < 10; i++) {
      StringPairGenerator.StringPair stringPair = stringPairGenerator.next();
      final String s1 = stringPair.s1;
      final String s2 = stringPair.s2;

      int actual = compareUtf8Strings(s1, s2);

      ByteString b1 = ByteString.copyFromUtf8(s1);
      ByteString b2 = ByteString.copyFromUtf8(s2);
      int expected = compareByteStrings(b1, b2);

      if (Integer.signum(actual) == Integer.signum(expected)) {
        passCount++;
      } else {
        errors.add(
            "compareUtf8Strings(s1=\""
                + s1
                + "\", s2=\""
                + s2
                + "\") returned "
                + signName(actual)
                + " ("
                + actual
                + ")"
                + ", but expected "
                + signName(expected)
                + " (i="
                + i
                + ", s1.length="
                + s1.length()
                + ", s2.length="
                + s2.length()
                + ")");
      }
    }

    if (!errors.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      sb.append(errors.size()).append(" test cases failed, ");
      sb.append(passCount).append(" test cases passed, ");
      sb.append("seed=").append(seed).append(";");
      for (int i = 0; i < errors.size(); i++) {
        sb.append("\nerrors[").append(i).append("]: ").append(errors.get(i));
      }
      fail(sb.toString());
    }
  }

  private static String signName(int value) {
    if (value < 0) {
      return "a negative value";
    } else if (value > 0) {
      return "a positive value";
    } else {
      return "0";
    }
  }

  private static class StringPairGenerator {

    private final StringGenerator stringGenerator;

    public StringPairGenerator(StringGenerator stringGenerator) {
      this.stringGenerator = stringGenerator;
    }

    public StringPair next() {
      String prefix = stringGenerator.next();
      String s1 = prefix + stringGenerator.next();
      String s2 = prefix + stringGenerator.next();
      return new StringPair(s1, s2);
    }

    public static class StringPair {
      public final String s1, s2;

      public StringPair(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
      }
    }
  }

  private static class StringGenerator {

    private static final float DEFAULT_SURROGATE_PAIR_PROBABILITY = 0.33f;
    private static final int DEFAULT_MAX_LENGTH = 20;

    private static final int MIN_HIGH_SURROGATE = 0xD800;
    private static final int MAX_HIGH_SURROGATE = 0xDBFF;
    private static final int MIN_LOW_SURROGATE = 0xDC00;
    private static final int MAX_LOW_SURROGATE = 0xDFFF;

    private final Random rnd;
    private final float surrogatePairProbability;
    private final int maxLength;

    public StringGenerator(int seed) {
      this(new Random(seed), DEFAULT_SURROGATE_PAIR_PROBABILITY, DEFAULT_MAX_LENGTH);
    }

    public StringGenerator(Random rnd, float surrogatePairProbability, int maxLength) {
      this.rnd = rnd;
      this.surrogatePairProbability = validateProbability(surrogatePairProbability);
      this.maxLength = validateLength(maxLength);
    }

    private static float validateProbability(float probability) {
      if (!Float.isFinite(probability)) {
        throw new IllegalArgumentException(
            "invalid surrogate pair probability: "
                + probability
                + " (must be between 0.0 and 1.0, inclusive)");
      } else if (probability < 0.0f) {
        throw new IllegalArgumentException(
            "invalid surrogate pair probability: "
                + probability
                + " (must be greater than or equal to zero)");
      } else if (probability > 1.0f) {
        throw new IllegalArgumentException(
            "invalid surrogate pair probability: "
                + probability
                + " (must be less than or equal to 1)");
      }
      return probability;
    }

    private static int validateLength(int length) {
      if (length < 0) {
        throw new IllegalArgumentException(
            "invalid maximum string length: "
                + length
                + " (must be greater than or equal to zero)");
      }
      return length;
    }

    public String next() {
      final int length = rnd.nextInt(maxLength + 1);
      final StringBuilder sb = new StringBuilder();
      while (sb.length() < length) {
        int codePoint = nextCodePoint();
        sb.appendCodePoint(codePoint);
      }
      return sb.toString();
    }

    private boolean isNextSurrogatePair() {
      return nextBoolean(rnd, surrogatePairProbability);
    }

    private static boolean nextBoolean(Random rnd, float probability) {
      if (probability == 0.0f) {
        return false;
      } else if (probability == 1.0f) {
        return true;
      } else {
        return rnd.nextFloat() < probability;
      }
    }

    private int nextCodePoint() {
      if (isNextSurrogatePair()) {
        return nextSurrogateCodePoint();
      } else {
        return nextNonSurrogateCodePoint();
      }
    }

    private int nextSurrogateCodePoint() {
      int highSurrogate =
          rnd.nextInt(MAX_HIGH_SURROGATE - MIN_HIGH_SURROGATE + 1) + MIN_HIGH_SURROGATE;
      int lowSurrogate = rnd.nextInt(MAX_LOW_SURROGATE - MIN_LOW_SURROGATE + 1) + MIN_LOW_SURROGATE;
      return Character.toCodePoint((char) highSurrogate, (char) lowSurrogate);
    }

    private int nextNonSurrogateCodePoint() {
      int codePoint;
      do {
        codePoint = rnd.nextInt(0x10000); // BMP range
      } while (codePoint >= MIN_HIGH_SURROGATE
          && codePoint <= MAX_LOW_SURROGATE); // Exclude surrogate range
      return codePoint;
    }
  }
}
