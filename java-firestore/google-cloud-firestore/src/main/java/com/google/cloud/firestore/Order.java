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
    BOOLEAN,
    NUMBER,
    TIMESTAMP,
    STRING,
    BLOB,
    REF,
    GEO_POINT,
    ARRAY,
    VECTOR,
    OBJECT;

    static TypeOrder fromValue(Value value) {
      switch (value.getValueTypeCase()) {
        case NULL_VALUE:
          return NULL;
        case BOOLEAN_VALUE:
          return BOOLEAN;
        case INTEGER_VALUE:
          return NUMBER;
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
      case NULL:
        return 0; // Nulls are all equal.
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
      default:
        throw new IllegalArgumentException("Cannot compare " + leftType);
    }
  }

  /** Compare strings in UTF-8 encoded byte order */
  public static int compareUtf8Strings(String left, String right) {
    ByteString leftBytes = ByteString.copyFromUtf8(left);
    ByteString rightBytes = ByteString.copyFromUtf8(right);
    return compareByteStrings(leftBytes, rightBytes);
  }

  private int compareBlobs(Value left, Value right) {
    ByteString leftBytes = left.getBytesValue();
    ByteString rightBytes = right.getBytesValue();
    return compareByteStrings(leftBytes, rightBytes);
  }

  private static int compareByteStrings(ByteString leftBytes, ByteString rightBytes) {
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

  private int compareNumbers(Value left, Value right) {
    // NaN is smaller than any other numbers
    if (isNaN(left)) {
      return isNaN(right) ? 0 : -1;
    } else if (isNaN(right)) {
      return 1;
    }

    if (left.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
      if (right.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
        return compareDoubles(left.getDoubleValue(), right.getDoubleValue());
      } else {
        return compareDoubleAndLong(left.getDoubleValue(), right.getIntegerValue());
      }
    } else {
      if (right.getValueTypeCase() == ValueTypeCase.INTEGER_VALUE) {
        return Long.compare(left.getIntegerValue(), right.getIntegerValue());
      } else {
        return -compareDoubleAndLong(right.getDoubleValue(), left.getIntegerValue());
      }
    }
  }

  private boolean isNaN(Value value) {
    return value.hasDoubleValue() && Double.isNaN(value.getDoubleValue());
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
