package com.google.cloud.firestore;

import com.google.firestore.v1beta1.Value;
import com.google.firestore.v1beta1.Value.ValueTypeCase;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Order {
  enum TypeOrder implements Comparable<TypeOrder> {
    // NOTE: This order is defined by the backend and cannot be change.
    NULL(),
    BOOLEAN(),
    NUMBER(),
    TIMESTAMP(),
    STRING(),
    BLOB(),
    REF(),
    GEOPOINT(),
    ARRAY(),
    OBJECT();

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
          return GEOPOINT;
        case ARRAY_VALUE:
          return ARRAY;
        case MAP_VALUE:
          return OBJECT;
        default:
          throw new IllegalStateException("Could not detect value type for " + value);
      }
    }
  }

  public int compare(Value left, Value right) {
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
        return 0;  // Nulls are all equal.
      case BOOLEAN:
        return Boolean.compare(left.getBooleanValue(), right.getBooleanValue());
      case NUMBER:
        return compareNumbers(left, right);
      case TIMESTAMP:
        return compareTimestamps(left, right);
      case STRING:
        return left.getStringValue().compareTo(right.getStringValue());
      case BLOB:
        return compareBlobs(left, right);
      case REF:
        return compareResourcePaths(left, right);
      case GEOPOINT:
        return compareGeoPoints(left, right);
      case ARRAY:
        return compareArrays(left, right);
      case OBJECT:
        return compareObjects(left, right);
        default:
          throw new Error("Cannot compare " + leftType);
    }
  }

  private int compareBlobs(Value left, Value right) {
    ByteString leftBytes = left.getBytesValue();
    ByteString rightBytes = right.getBytesValue();

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

  private int compareTimestamps(Value left, Value right) {
    int cmp = Long.compare(left.getTimestampValue().getSeconds(), right.getTimestampValue().getSeconds());

    if (cmp != 0) {
      return cmp;
    } else {
     return  Integer.compare(left.getTimestampValue().getNanos(), right.getTimestampValue().getNanos());
    }
  }

  private int compareGeoPoints(Value left, Value right) {
    int cmp = Double.compare(left.getGeoPointValue().getLatitude(), right.getGeoPointValue().getLatitude());

    if (cmp != 0) {
      return cmp;
    } else {
      return  Double.compare(left.getGeoPointValue().getLongitude(), right.getGeoPointValue().getLongitude());
    }
  }


  private int compareResourcePaths(Value left, Value right) {
    ResourcePath leftPath = ResourcePath.create(left.getReferenceValue());
    ResourcePath rightPath = ResourcePath.create(right.getReferenceValue());
    return leftPath.compareTo(rightPath);
  }


  private int compareArrays(Value left, Value right) {
    List<Value> leftValue = left.getArrayValue().getValuesList();
    List<Value> rightValue = right.getArrayValue().getValuesList();

    int minLength = Math.min(leftValue.size(), rightValue.size());
      for (int i = 0; i < minLength; i++) {
        int cmp = compare(leftValue.get(i), rightValue.get(i));
        if (cmp != 0) {
          return cmp;
        }
      }
      return Integer.compare(leftValue.size(), rightValue.size());
  }

  private int compareObjects(Value left, Value right) {
    // This requires iterating over the keys in the object in order and doing a
    // deep comparison.
    SortedMap<String, Value> leftMap = new TreeMap<>();
    leftMap.putAll(left.getMapValue().getFieldsMap());
    SortedMap<String, Value> rightMap = new TreeMap<>();
    rightMap.putAll(right.getMapValue().getFieldsMap());

      Iterator<Entry<String, Value>> leftIterator = leftMap.entrySet().iterator();
      Iterator<Entry<String, Value>> rightIterator = rightMap.entrySet().iterator();

      while (leftIterator.hasNext() && rightIterator.hasNext()) {
        Entry<String, Value> leftEntry = leftIterator.next();
        Entry<String, Value> rightEntry = rightIterator.next();
        int keyCompare = leftEntry.getKey().compareTo(rightEntry.getKey());
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


  public int compareNumbers(Value left, Value right) {
    if (left.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
      if (right.getValueTypeCase() == ValueTypeCase.DOUBLE_VALUE) {
        return Double.compare(left.getDoubleValue(), right.getDoubleValue());
      } else {
        return Double.compare(left.getDoubleValue(), right.getIntegerValue());
      }
    } else {
      if (right.getValueTypeCase() == ValueTypeCase.INTEGER_VALUE) {
        return Double.compare(left.getIntegerValue(), right.getIntegerValue());
      } else {
        return Double.compare(left.getIntegerValue(), right.getDoubleValue());
      }
    }
  }


}


///*!
// * Copyright 2017 Google Inc. All Rights Reserved.
// *
// * Licensed under the Apache License, Version 2.0 (the "License");
// * you may not use this file except in compliance with the License.
// * You may obtain a copy of the License at
// *
// *      http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//'use strict';
//
//    const is = require('is');
//
///*!
// * @see ResourcePath
// */
//    const ResourcePath = require('./path').ResourcePath;
//
///*!
// * The type order as defined by the backend.
// */
//    const types = {
//    NULL: 0,
//    BOOLEAN: 1,
//    NUMBER: 2,
//    TIMESTAMP: 3,
//    STRING: 4,
//    BLOB: 5,
//    REF: 6,
//    GEOPOINT: 7,
//    ARRAY: 8,
//    OBJECT: 9,
//    };
//
///*!
// * @private
// */
//    function typeOrder(val) {
//    switch (val.valueType) {
//    case 'nullValue': {
//    return types.NULL;
//    }
//    case 'integerValue': {
//    return types.NUMBER;
//    }
//    case 'doubleValue': {
//    return types.NUMBER;
//    }
//    case 'stringValue': {
//    return types.STRING;
//    }
//    case 'booleanValue': {
//    return types.BOOLEAN;
//    }
//    case 'arrayValue': {
//    return types.ARRAY;
//    }
//    case 'timestampValue': {
//    return types.TIMESTAMP;
//    }
//    case 'geoPointValue': {
//    return types.GEOPOINT;
//    }
//    case 'bytesValue': {
//    return types.BLOB;
//    }
//    case 'referenceValue': {
//    return types.REF;
//    }
//    case 'mapValue': {
//    return types.OBJECT;
//    }
//default: {
//    throw new Error(
//    'Cannot use type (' +
//    val +
//    ': ' +
//    JSON.stringify(val) +
//    ') as a Firestore value.'
//    );
//    }
//    }
//    }
//
///*!
// * @private
// */
//    function primitiveComparator(left, right) {
//    if (left < right) {
//    return -1;
//    }
//    if (left > right) {
//    return 1;
//    }
//    return 0;
//    }
//
///*!
// * Utility function to compare doubles (using Firestore semantics for NaN).
// * @private
// */
//    function compareNumbers(left, right) {
//    if (left < right) {
//    return -1;
//    }
//    if (left > right) {
//    return 1;
//    }
//    if (left === right) {
//    return 0;
//    }
//    // one or both are NaN.
//    if (isNaN(left)) {
//    return isNaN(right) ? 0 : -1;
//    }
//    return 1;
//    }
//
///*!
// * @private
// */
//    function compareNumberProtos(left, right) {
//    let leftValue, rightValue;
//    if (left.valueType === 'integerValue') {
//    leftValue = parseInt(left.integerValue, 10);
//    } else {
//    leftValue = parseFloat(left.doubleValue, 10);
//    }
//    if (right.valueType === 'integerValue') {
//    rightValue = parseInt(right.integerValue, 10);
//    } else {
//    rightValue = parseFloat(right.doubleValue, 10);
//    }
//    return compareNumbers(leftValue, rightValue);
//    }
//
///*!
// * @private
// */
//    function compareTimestamps(left, right) {
//    let seconds = primitiveComparator(left.seconds || 0, right.seconds || 0);
//    if (seconds !== 0) {
//    return seconds;
//    }
//    return primitiveComparator(left.nanos || 0, right.nanos || 0);
//    }
//
///*!
// * @private
// */
//    function compareBlobs(left, right) {
//    if (!is.instanceof(left, Buffer) || !is.instanceof(right, Buffer)) {
//    throw new Error('Blobs can only be compared if they are Buffers.');
//    }
//    return Buffer.compare(left, right);
//    }
//
///*!
// * @private
// */
//    function compareReferenceProtos(left, right) {
//    const leftPath = ResourcePath.fromSlashSeparatedString(left.referenceValue);
//    const rightPath = ResourcePath.fromSlashSeparatedString(right.referenceValue);
//    return leftPath.compareTo(rightPath);
//    }
//
///*!
// * @private
// */
//    function compareGeoPoints(left, right) {
//    return (
//    primitiveComparator(left.latitude, right.latitude) ||
//    primitiveComparator(left.longitude, right.longitude)
//    );
//    }
//
///*!
// * @private
// */
//    function compareArrays(left, right) {
//    for (let i = 0; i < left.length && i < right.length; i++) {
//    const valueComparison = compare(left[i], right[i]);
//    if (valueComparison !== 0) {
//    return valueComparison;
//    }
//    }
//    // If all the values matched so far, just check the length.
//    return primitiveComparator(left.length, right.length);
//    }
//
///*!
// * @private
// */
//    function compareObjects(left, right) {
//    // This requires iterating over the keys in the object in order and doing a
//    // deep comparison.
//    const leftKeys = Object.keys(left);
//    const rightKeys = Object.keys(right);
//    leftKeys.sort();
//    rightKeys.sort();
//    for (let i = 0; i < leftKeys.length && i < rightKeys.length; i++) {
//    const keyComparison = primitiveComparator(leftKeys[i], rightKeys[i]);
//    if (keyComparison !== 0) {
//    return keyComparison;
//    }
//    const key = leftKeys[i];
//    const valueComparison = compare(left[key], right[key]);
//    if (valueComparison !== 0) {
//    return valueComparison;
//    }
//    }
//    // If all the keys matched so far, just check the length.
//    return primitiveComparator(leftKeys.length, rightKeys.length);
//    }
//
///*!
// * @private
// */
//    function compare(left, right) {
//    // First compare the types.
//    const leftType = typeOrder(left);
//    const rightType = typeOrder(right);
//    const typeComparison = primitiveComparator(leftType, rightType);
//    if (typeComparison !== 0) {
//    return typeComparison;
//    }
//
//    // So they are the same type.
//    switch (leftType) {
//    case types.NULL: {
//    // Nulls are all equal.
//    return 0;
//    }
//    case types.BOOLEAN: {
//    return primitiveComparator(left.booleanValue, right.booleanValue);
//    }
//    case types.STRING: {
//    return primitiveComparator(left.stringValue, right.stringValue);
//    }
//    case types.NUMBER: {
//    return compareNumberProtos(left, right);
//    }
//    case types.TIMESTAMP: {
//    return compareTimestamps(left.timestampValue, right.timestampValue);
//    }
//    case types.BLOB: {
//    return compareBlobs(left.bytesValue, right.bytesValue);
//    }
//    case types.REF: {
//    return compareReferenceProtos(left, right);
//    }
//    case types.GEOPOINT: {
//    return compareGeoPoints(left.geoPointValue, right.geoPointValue);
//    }
//    case types.ARRAY: {
//    return compareArrays(left.arrayValue.values, right.arrayValue.values);
//    }
//    case types.OBJECT: {
//    return compareObjects(left.mapValue.fields, right.mapValue.fields);
//    }
//    }
//    }
//
//    module.exports = {compare, primitiveComparator};
