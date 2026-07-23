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

import static java.lang.Character.isSurrogate;

import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.firestore.v1.Value.ValueTypeCase;
import com.google.protobuf.ByteString;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.annotation.Nonnull;

/** Order implements the ordering semantics of the backend. */
class Order implements Comparator<Value> {
  enum TypeOrder implements Comparable<TypeOrder> {
    // NOTE: This order is defined by the backend and cannot be changed.
    NULL,
    MIN_KEY,
    BOOLEAN,
    NUMBER,
    TIMESTAMP,
    BSON_TIMESTAMP,
    STRING,
    BLOB,
    BSON_BINARY,
    REF,
    BSON_OBJECT_ID,
    GEO_POINT,
    REGEX,
    ARRAY,
    VECTOR,
    OBJECT,
    MAX_KEY;

    static TypeOrder fromValue(Value value) {
      switch (value.getValueTypeCase()) {
        case NULL_VALUE:
          return NULL;
        case BOOLEAN_VALUE:
          return BOOLEAN;
        case INTEGER_VALUE:
        case DOUBLE_VALUE:
          return NUMBER;
        case TIMESTAMP_VALUE:
          return TIMESTAMP;
        case STRING_VALUE:
          return STRING;
        case BYTES_VALUE:
          return BLOB;
        case REFERENCE_VALUE:
          return REF;
        case GEO_POINT_VALUE:
          return GEO_POINT;
        case ARRAY_VALUE:
          return ARRAY;
        case MAP_VALUE:
          return fromMapValue(value.getMapValue());
        default:
          throw new IllegalArgumentException("Could not detect value type for " + value);
      }
    }
  }

  static TypeOrder fromMapValue(MapValue mapValue) {
    switch (UserDataConverter.detectMapRepresentation(mapValue)) {
      case VECTOR_VALUE:
        return TypeOrder.VECTOR;
      case MIN_KEY:
        return TypeOrder.MIN_KEY;
      case MAX_KEY:
        return TypeOrder.MAX_KEY;
      case REGEX:
        return TypeOrder.REGEX;
      case DECIMAL128:
      case INT32:
        return TypeOrder.NUMBER;
      case BSON_OBJECT_ID:
        return TypeOrder.BSON_OBJECT_ID;
      case BSON_TIMESTAMP:
        return TypeOrder.BSON_TIMESTAMP;
      case BSON_BINARY_DATA:
        return TypeOrder.BSON_BINARY;
      case UNKNOWN:
      case NONE:
      default:
        return TypeOrder.OBJECT;
    }
  }

  static final Order INSTANCE = new Order();

  private Order() {}

  /**
   * Main comparison function for all Firestore types.
   *
   * @return -1 is left < right, 0 if left == right, otherwise 1
   */
  public int compare(@Nonnull Value left, @Nonnull Value right) {
    // First compare the types.
    TypeOrder leftType = TypeOrder.fromValue(left);
    TypeOrder rightType = TypeOrder.fromValue(right);
    int typeComparison = leftType.compareTo(rightType);
    if (typeComparison != 0) {
      return typeComparison;
    }

    // So they are the same type.
    switch (leftType) {
      // Nulls are all equal, MaxKeys are all equal, and MinKeys are all equal.
      case NULL:
      case MIN_KEY:
      case MAX_KEY:
        return 0;
      case BOOLEAN:
        return Boolean.compare(left.getBooleanValue(), right.getBooleanValue());
      case NUMBER:
        return compareNumbers(left, right);
      case TIMESTAMP:
        return compareTimestamps(left, right);
      case STRING:
        return compareUtf8Strings(left.getStringValue(), right.getStringValue());
      case BLOB:
        return compareBlobs(left, right);
      case REF:
        return compareResourcePaths(left, right);
      case GEO_POINT:
        return compareGeoPoints(left, right);
      case ARRAY:
        return compareArrays(
            left.getArrayValue().getValuesList(), right.getArrayValue().getValuesList());
      case OBJECT:
        return compareObjects(left, right);
      case VECTOR:
        return compareVectors(left, right);
      case REGEX:
        return compareRegex(left, right);
      case BSON_OBJECT_ID:
        return compareBsonObjectId(left, right);
      case BSON_TIMESTAMP:
        return compareBsonTimestamp(left, right);
      case BSON_BINARY:
        return compareBsonBinary(left, right);
      default:
        throw new IllegalArgumentException("Cannot compare " + leftType);
    }
  }

  /** Compare strings in UTF-8 encoded byte order */
  public static int compareUtf8Strings(String left, String right) {
    // noinspection StringEquality
    if (left == right) {
      return 0;
    }

    // Find the first differing character (a.k.a. "UTF-16 code unit") in the two strings and,
    // if found, use that character to determine the relative ordering of the two strings as a
    // whole. Comparing UTF-16 strings in UTF-8 byte order can be done simply and efficiently by
    // comparing the UTF-16 code units (chars). This serendipitously works because of the way UTF-8
    // and UTF-16 happen to represent Unicode code points.
    //
    // After finding the first pair of differing characters, there are two cases:
    //
    // Case 1: Both characters are non-surrogates (code points less than or equal to 0xFFFF) or
    // both are surrogates from a surrogate pair (that collectively represent code points greater
    // than 0xFFFF). In this case their numeric order as UTF-16 code units is the same as the
    // lexicographical order of their corresponding UTF-8 byte sequences. A direct comparison is
    // sufficient.
    //
    // Case 2: One character is a surrogate and the other is not. In this case the surrogate-
    // containing string is always ordered after the non-surrogate. This is because surrogates are
    // used to represent code points greater than 0xFFFF which have 4-byte UTF-8 representations
    // and are lexicographically greater than the 1, 2, or 3-byte representations of code points
    // less than or equal to 0xFFFF.
    //
    // An example of why Case 2 is required is comparing the following two Unicode code points:
    //
    // |-----------------------|------------|---------------------|-----------------|
    // | Name                  | Code Point | UTF-8 Encoding      | UTF-16 Encoding |
    // |-----------------------|------------|---------------------|-----------------|
    // | Replacement Character | U+FFFD     | 0xEF 0xBF 0xBD      | 0xFFFD          |
    // | Grinning Face         | U+1F600    | 0xF0 0x9F 0x98 0x80 | 0xD83D 0xDE00   |
    // |-----------------------|------------|---------------------|-----------------|
    //
    // A lexicographical comparison of the UTF-8 encodings of these code points would order
    // "Replacement Character" _before_ "Grinning Face" because 0xEF is less than 0xF0. However, a
    // direct comparison of the UTF-16 code units, as would be done in case 1, would erroneously
    // produce the _opposite_ ordering, because 0xFFFD is _greater than_ 0xD83D. As it turns out,
    // this relative ordering holds for all comparisons of UTF-16 code points requiring a surrogate
    // pair with those that do not.
    final int length = Math.min(left.length(), right.length());
    for (int i = 0; i < length; i++) {
      final char leftChar = left.charAt(i);
      final char rightChar = right.charAt(i);
      if (leftChar != rightChar) {
        return (isSurrogate(leftChar) == isSurrogate(rightChar))
            ? Character.compare(leftChar, rightChar)
            : isSurrogate(leftChar) ? 1 : -1;
      }
    }

    // Use the lengths of the strings to determine the overall comparison result since either the
    // strings were equal or one is a prefix of the other.
    return Integer.compare(left.length(), right.length());
  }

  private int compareBlobs(Value left, Value right) {
    ByteString leftBytes = left.getBytesValue();
    ByteString rightBytes = right.getBytesValue();
    return compareByteStrings(leftBytes, rightBytes);
  }

  static int compareByteStrings(ByteString leftBytes, ByteString rightBytes) {
    int size = Math.min(leftBytes.size(), rightBytes.size());
    for (int i = 0; i < size; i++) {
      // Make sure the bytes are unsigned
      int thisByte = leftBytes.byteAt(i) & 0xff;
      int otherByte = rightBytes.byteAt(i) & 0xff;
      if (thisByte < otherByte) {
        return -1;
      } else if (thisByte > otherByte) {
        return 1;
      }
      // Byte values are equal, continue with comparison
    }
    return Integer.compare(leftBytes.size(), rightBytes.size());
  }

  private static int compareTimestamps(Value left, Value right) {
    int cmp =
        Long.compare(left.getTimestampValue().getSeconds(), right.getTimestampValue().getSeconds());

    if (cmp != 0) {
      return cmp;
    } else {
      return Integer.compare(
          left.getTimestampValue().getNanos(), right.getTimestampValue().getNanos());
    }
  }

  private static int compareGeoPoints(Value left, Value right) {
    int cmp =
        Double.compare(
            left.getGeoPointValue().getLatitude(), right.getGeoPointValue().getLatitude());

    if (cmp != 0) {
      return cmp;
    } else {
      return Double.compare(
          left.getGeoPointValue().getLongitude(), right.getGeoPointValue().getLongitude());
    }
  }

  private int compareResourcePaths(Value left, Value right) {
    ResourcePath leftPath = ResourcePath.create(left.getReferenceValue());
    ResourcePath rightPath = ResourcePath.create(right.getReferenceValue());
    return leftPath.compareTo(rightPath);
  }

  public int compareArrays(List<Value> left, List<Value> right) {
    int minLength = Math.min(left.size(), right.size());
    for (int i = 0; i < minLength; i++) {
      int cmp = compare(left.get(i), right.get(i));
      if (cmp != 0) {
        return cmp;
      }
    }
    return Integer.compare(left.size(), right.size());
  }

  private int compareObjects(Value left, Value right) {
    // This requires iterating over the keys in the object in order and doing a
    // deep comparison.
    SortedMap<String, Value> leftMap = new TreeMap<>(left.getMapValue().getFieldsMap());
    SortedMap<String, Value> rightMap = new TreeMap<>(right.getMapValue().getFieldsMap());

    Iterator<Entry<String, Value>> leftIterator = leftMap.entrySet().iterator();
    Iterator<Entry<String, Value>> rightIterator = rightMap.entrySet().iterator();

    while (leftIterator.hasNext() && rightIterator.hasNext()) {
      Entry<String, Value> leftEntry = leftIterator.next();
      Entry<String, Value> rightEntry = rightIterator.next();
      int keyCompare = compareUtf8Strings(leftEntry.getKey(), rightEntry.getKey());
      if (keyCompare != 0) {
        return keyCompare;
      }
      int valueCompare = compare(leftEntry.getValue(), rightEntry.getValue());
      if (valueCompare != 0) {
        return valueCompare;
      }
    }

    // Only equal if both iterators are exhausted.
    return Boolean.compare(leftIterator.hasNext(), rightIterator.hasNext());
  }

  private int compareVectors(Value left, Value right) {
    // The vector is a map, but only vector value is compared.
    Value leftValueField =
        left.getMapValue().getFieldsOrDefault(MapType.VECTOR_MAP_VECTORS_KEY, null);
    Value rightValueField =
        right.getMapValue().getFieldsOrDefault(MapType.VECTOR_MAP_VECTORS_KEY, null);

    List<Value> leftArray =
        (leftValueField != null)
            ? leftValueField.getArrayValue().getValuesList()
            : Collections.emptyList();
    List<Value> rightArray =
        (rightValueField != null)
            ? rightValueField.getArrayValue().getValuesList()
            : Collections.emptyList();

    Integer lengthCompare = Long.compare(leftArray.size(), rightArray.size());
    if (lengthCompare != 0) {
      return lengthCompare;
    }

    return compareArrays(leftArray, rightArray);
  }

  /**
   * Returns a long from a 32-bit or 64-bit proto integer value. Throws an exception if the value is
   * not an integer.
   */
  private long getIntegerValue(Value value) {
    if (value.hasIntegerValue()) {
      return value.getIntegerValue();
    }
    if (UserDataConverter.isInt32Value(value)) {
      return value.getMapValue().getFieldsMap().get(MapType.RESERVED_INT32_KEY).getIntegerValue();
    }
    throw new IllegalArgumentException("getIntegerValue was called on a non-integer value.");
  }

  private int compareNumbers(Value left, Value right) {
    // NaN is smaller than any other numbers
    if (isNaN(left)) {
      return isNaN(right) ? 0 : -1;
    } else if (isNaN(right)) {
      return 1;
    }

    // If either argument is Decimal128, we cast both to wider (128-bit) representation, and compare
    // Quadruple values.
    if (UserDataConverter.isDecimal128Value(left) || UserDataConverter.isDecimal128Value(right)) {
      Quadruple leftQuadruple = convertNumberToQuadruple(left);
      Quadruple rightQuadruple = convertNumberToQuadruple(right);

      // Firestore considers +0 and -0 to be equal, but `Quadruple.compareTo()` does not.
      if (leftQuadruple.isZero() && rightQuadruple.isZero()) return 0;

      return leftQuadruple.compareTo(rightQuadruple);
    }

    if (left.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
      if (right.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
        // left and right are both doubles.
        return compareDoubles(left.getDoubleValue(), right.getDoubleValue());
      } else {
        // left is a double and right is a 32/64-bit integer.
        return compareDoubleAndLong(left.getDoubleValue(), getIntegerValue(right));
      }
    } else {
      if (right.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) { // left is a 32/64-bit integer
        // left is a 32/64-bit integer and right is a double.
        return -compareDoubleAndLong(right.getDoubleValue(), getIntegerValue(left));
      } else {
        // left and right are both 32/64-bit integers.
        return Long.compare(getIntegerValue(left), getIntegerValue(right));
      }
    }
  }

  private int compareRegex(Value left, Value right) {
    RegexValue lhs = UserDataConverter.decodeRegexValue(left.getMapValue());
    RegexValue rhs = UserDataConverter.decodeRegexValue(right.getMapValue());
    int comparePatterns = compareUtf8Strings(lhs.pattern, rhs.pattern);
    return comparePatterns != 0 ? comparePatterns : lhs.options.compareTo(rhs.options);
  }

  private int compareBsonObjectId(Value left, Value right) {
    BsonObjectId lhs = UserDataConverter.decodeBsonObjectId(left.getMapValue());
    BsonObjectId rhs = UserDataConverter.decodeBsonObjectId(right.getMapValue());
    return compareUtf8Strings(lhs.value, rhs.value);
  }

  private int compareBsonTimestamp(Value left, Value right) {
    BsonTimestamp lhs = UserDataConverter.decodeBsonTimestamp(left.getMapValue());
    BsonTimestamp rhs = UserDataConverter.decodeBsonTimestamp(right.getMapValue());
    int secondsDiff = Long.compare(lhs.seconds, rhs.seconds);
    return secondsDiff != 0 ? secondsDiff : Long.compare(lhs.increment, rhs.increment);
  }

  private int compareBsonBinary(Value left, Value right) {
    ByteString lhs =
        left.getMapValue().getFieldsMap().get(MapType.RESERVED_BSON_BINARY_KEY).getBytesValue();
    ByteString rhs =
        right.getMapValue().getFieldsMap().get(MapType.RESERVED_BSON_BINARY_KEY).getBytesValue();
    return compareByteStrings(lhs, rhs);
  }

  private boolean isNaN(Value value) {
    if (value.hasDoubleValue() && Double.isNaN(value.getDoubleValue())) {
      return true;
    }

    if (UserDataConverter.isDecimal128Value(value)) {
      return value
          .getMapValue()
          .getFieldsMap()
          .get(MapType.RESERVED_DECIMAL128_KEY)
          .getStringValue()
          .equals("NaN");
    }

    return false;
  }

  /**
   * Converts the given number value to a Quadruple. Throws an exception if the value is not a
   * number.
   */
  private Quadruple convertNumberToQuadruple(Value value) {
    // Doubles
    if (value.hasDoubleValue()) {
      return Quadruple.fromDouble(value.getDoubleValue());
    }

    // 32-bit and 64-bit integers.
    if (UserDataConverter.isIntegerValue(value)) {
      return Quadruple.fromLong(getIntegerValue(value));
    }

    // Decimal128 numbers
    if (UserDataConverter.isDecimal128Value(value)) {
      return UserDataConverter.decodeDecimal128Value(value.getMapValue()).value;
    }

    throw new IllegalArgumentException(
        "convertNumberToQuadruple was called on a non-numeric value.");
  }

  private int compareDoubles(double left, double right) {
    // Firestore treats -0.0, 0.0 and +0.0 as equal.
    return Double.compare(left == -0.0 ? 0 : left, right == -0.0 ? 0 : right);
  }

  /**
   * The maximum integer absolute number that can be represented as a double without loss of
   * precision. This is 2^53 because double-precision floating point numbers have 53 bits
   * significand precision (52 explicit bit + 1 hidden bit).
   */
  private static final long MAX_INTEGER_TO_DOUBLE_PRECISION = 1L << 53;

  private int compareDoubleAndLong(double doubleValue, long longValue) {
    if (Math.abs(longValue) <= MAX_INTEGER_TO_DOUBLE_PRECISION) {
      // Enough precision to compare as double, the cast will not be lossy.
      return compareDoubles(doubleValue, (double) longValue);
    } else if (doubleValue < ((double) Long.MAX_VALUE)
        && doubleValue >= ((double) Long.MIN_VALUE)) {
      // The above condition captures all doubles that belong to [min long, max long] inclusive.
      // Java long to double conversion rounds-to-nearest, so Long.MAX_VALUE casts to 2^63, hence
      // the use of "<" operator.
      // The cast to long below may be lossy, but only for absolute values < 2^52 so the loss of
      // precision does not affect the comparison, as longValue is outside that range.
      return Long.compare((long) doubleValue, longValue);
    } else {
      // doubleValue is outside the representable range for longs, so always smaller if negative,
      // and always greater otherwise.
      return doubleValue < 0 ? -1 : 1;
    }
  }
}
