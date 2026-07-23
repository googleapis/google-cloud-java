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

import static com.google.cloud.firestore.pipeline.expressions.FunctionUtils.aggregateFunctionToValue;
import static com.google.cloud.firestore.pipeline.expressions.FunctionUtils.exprToValue;
import static com.google.firestore.v1.Value.ValueTypeCase.BYTES_VALUE;
import static com.google.firestore.v1.Value.ValueTypeCase.INTEGER_VALUE;
import static com.google.firestore.v1.Value.ValueTypeCase.MAP_VALUE;
import static com.google.firestore.v1.Value.ValueTypeCase.NULL_VALUE;
import static com.google.firestore.v1.Value.ValueTypeCase.STRING_VALUE;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.pipeline.expressions.AggregateFunction;
import com.google.cloud.firestore.pipeline.expressions.Expression;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Doubles;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/** Converts user input into the Firestore Value representation. */
class UserDataConverter {

  static final Value NULL_VALUE = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();

  private static final Logger LOGGER = Logger.getLogger(UserDataConverter.class.getName());

  /** Controls the behavior for field deletes. */
  interface EncodingOptions {
    /** Returns whether a field delete at `fieldPath` is allowed. */
    boolean allowDelete(FieldPath fieldPath);

    /** Returns whether a field transform (server timestamp, array ops) is allowed. */
    boolean allowTransform();
  }

  /** Rejects all field deletes and allows all field transforms */
  static final EncodingOptions NO_DELETES =
      new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return false;
        }

        @Override
        public boolean allowTransform() {
          return true;
        }
      };

  /** Allows all field deletes and allows all field transforms. */
  static final EncodingOptions ALLOW_ALL_DELETES =
      new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return true;
        }

        @Override
        public boolean allowTransform() {
          return true;
        }
      };

  /** Rejects all field deletes and any field transform. */
  static final EncodingOptions ARGUMENT =
      new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return false;
        }

        @Override
        public boolean allowTransform() {
          return false;
        }
      };

  private UserDataConverter() {}

  /**
   * Encodes a Java Object to a Firestore Value proto.
   *
   * @param path path THe field path of the object to encode.
   * @param sanitizedObject An Object that has been sanitized by CustomClassMapper and only contains
   *     valid types.
   * @param options Encoding options to use for this value.
   * @return The Value proto.
   */
  @Nullable
  static Value encodeValue(
      FieldPath path, @Nullable Object sanitizedObject, EncodingOptions options) {
    if (sanitizedObject == FieldValue.DELETE_SENTINEL) {
      Preconditions.checkArgument(
          options.allowDelete(path), "FieldValue.delete() is not supported at field '%s'.", path);
      return null;
    } else if (sanitizedObject instanceof FieldValue) {
      Preconditions.checkArgument(
          options.allowTransform(),
          "Cannot use "
              + ((FieldValue) sanitizedObject).getMethodName()
              + " as an argument at field '%s'.",
          path);
      return null;

    } else if (sanitizedObject == null) {
      return NULL_VALUE;
    } else if (sanitizedObject instanceof String) {
      return Value.newBuilder().setStringValue((String) sanitizedObject).build();
    } else if (sanitizedObject instanceof Integer) {
      return Value.newBuilder().setIntegerValue((Integer) sanitizedObject).build();
    } else if (sanitizedObject instanceof Long) {
      return Value.newBuilder().setIntegerValue((Long) sanitizedObject).build();
    } else if (sanitizedObject instanceof Double) {
      return Value.newBuilder().setDoubleValue((Double) sanitizedObject).build();
    } else if (sanitizedObject instanceof Float) {
      return Value.newBuilder().setDoubleValue((Float) sanitizedObject).build();
    } else if (sanitizedObject instanceof Boolean) {
      return Value.newBuilder().setBooleanValue((Boolean) sanitizedObject).build();
    } else if (sanitizedObject instanceof Date) {
      Date date = (Date) sanitizedObject;
      long epochSeconds = TimeUnit.MILLISECONDS.toSeconds(date.getTime());
      long msOffset = date.getTime() - TimeUnit.SECONDS.toMillis(epochSeconds);
      com.google.protobuf.Timestamp.Builder timestampBuilder =
          com.google.protobuf.Timestamp.newBuilder();
      timestampBuilder.setSeconds(epochSeconds);
      timestampBuilder.setNanos((int) TimeUnit.MILLISECONDS.toNanos(msOffset));
      return Value.newBuilder().setTimestampValue(timestampBuilder.build()).build();
    } else if (sanitizedObject instanceof Timestamp) {
      Timestamp timestamp = (Timestamp) sanitizedObject;
      return Value.newBuilder().setTimestampValue(timestamp.toProto()).build();
    } else if (sanitizedObject instanceof List) {
      ArrayValue.Builder res = ArrayValue.newBuilder();
      int i = 0;
      for (Object child : (List) sanitizedObject) {
        Value encodedValue = encodeValue(path.append(Integer.toString(i++)), child, options);
        if (encodedValue != null) {
          res.addValues(encodedValue);
        }
      }
      return Value.newBuilder().setArrayValue(res.build()).build();
    } else if (sanitizedObject instanceof GeoPoint) {
      GeoPoint geopoint = (GeoPoint) sanitizedObject;
      return Value.newBuilder().setGeoPointValue(geopoint.toProto()).build();
    } else if (sanitizedObject instanceof Blob) {
      Blob blob = (Blob) sanitizedObject;
      return Value.newBuilder().setBytesValue(blob.toByteString()).build();
    } else if (sanitizedObject instanceof BsonBinaryData) {
      BsonBinaryData bson = (BsonBinaryData) sanitizedObject;
      return Value.newBuilder()
          .setMapValue(encodeBsonBinaryData(bson.subtype(), bson.dataAsByteString()))
          .build();
    } else if (sanitizedObject instanceof Expression) {
      return exprToValue((Expression) sanitizedObject);
    } else if (sanitizedObject instanceof AggregateFunction) {
      return aggregateFunctionToValue((AggregateFunction) sanitizedObject);
    } else if (sanitizedObject instanceof Value) {
      return (Value) sanitizedObject;
    } else if (sanitizedObject instanceof DocumentReference) {
      DocumentReference docRef = (DocumentReference) sanitizedObject;
      return Value.newBuilder().setReferenceValue(docRef.getName()).build();
    } else if (sanitizedObject instanceof Map) {
      MapValue.Builder res = MapValue.newBuilder();
      Map<String, Object> map = (Map<String, Object>) sanitizedObject;

      for (Map.Entry<String, Object> entry : map.entrySet()) {
        Value encodedValue =
            encodeValue(
                path.append(entry.getKey(), /* splitPath= */ false), entry.getValue(), options);
        if (encodedValue != null) {
          res.putFields(entry.getKey(), encodedValue);
        }
      }

      // If we encounter an empty object, we always need to send it to make sure
      // the server creates a map entry.
      if (map.isEmpty() || res.getFieldsCount() != 0) {
        return Value.newBuilder().setMapValue(res.build()).build();
      } else {
        // The input map may only have contained field transforms, in which case we don't need to
        // send the map.
        return null;
      }
    } else if (sanitizedObject instanceof VectorValue) {
      VectorValue vectorValue = (VectorValue) sanitizedObject;
      return Value.newBuilder().setMapValue(vectorValue.toProto()).build();
    } else if (sanitizedObject instanceof MinKey) {
      MinKey minKey = (MinKey) sanitizedObject;
      return Value.newBuilder().setMapValue(minKey.toProto()).build();
    } else if (sanitizedObject instanceof MaxKey) {
      MaxKey maxKey = (MaxKey) sanitizedObject;
      return Value.newBuilder().setMapValue(maxKey.toProto()).build();
    } else if (sanitizedObject instanceof RegexValue) {
      RegexValue regexValue = (RegexValue) sanitizedObject;
      return Value.newBuilder().setMapValue(regexValue.toProto()).build();
    } else if (sanitizedObject instanceof Int32Value) {
      Int32Value int32Value = (Int32Value) sanitizedObject;
      return Value.newBuilder().setMapValue(int32Value.toProto()).build();
    } else if (sanitizedObject instanceof Decimal128Value) {
      Decimal128Value decimal128Value = (Decimal128Value) sanitizedObject;
      return Value.newBuilder().setMapValue(decimal128Value.toProto()).build();
    } else if (sanitizedObject instanceof BsonObjectId) {
      BsonObjectId bsonObjectId = (BsonObjectId) sanitizedObject;
      return Value.newBuilder().setMapValue(bsonObjectId.toProto()).build();
    } else if (sanitizedObject instanceof BsonTimestamp) {
      BsonTimestamp bsonTimestamp = (BsonTimestamp) sanitizedObject;
      return Value.newBuilder().setMapValue(bsonTimestamp.toProto()).build();
    }

    throw FirestoreException.forInvalidArgument(
        "Cannot convert %s to Firestore Value", sanitizedObject);
  }

  static MapValue encodeVector(double[] rawVector) {
    MapValue.Builder res = MapValue.newBuilder();

    res.putFields(
        MapType.RESERVED_MAP_KEY,
        encodeValue(
            FieldPath.fromDotSeparatedString(MapType.RESERVED_MAP_KEY),
            MapType.RESERVED_MAP_KEY_VECTOR_VALUE,
            ARGUMENT));
    res.putFields(
        MapType.VECTOR_MAP_VECTORS_KEY,
        encodeValue(
            FieldPath.fromDotSeparatedString(MapType.RESERVED_MAP_KEY_VECTOR_VALUE),
            Doubles.asList(rawVector),
            ARGUMENT));

    return res.build();
  }

  static MapValue encodeMinKey() {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_MIN_KEY, Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
        .build();
  }

  static MapValue encodeMaxKey() {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_MAX_KEY, Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build())
        .build();
  }

  static MapValue encodeRegexValue(String pattern, String options) {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_REGEX_KEY,
            Value.newBuilder()
                .setMapValue(
                    MapValue.newBuilder()
                        .putFields(
                            MapType.RESERVED_REGEX_PATTERN_KEY,
                            Value.newBuilder().setStringValue(pattern).build())
                        .putFields(
                            MapType.RESERVED_REGEX_OPTIONS_KEY,
                            Value.newBuilder().setStringValue(options).build())
                        .build())
                .build())
        .build();
  }

  static MapValue encodeInt32Value(int value) {
    return MapValue.newBuilder()
        .putFields(MapType.RESERVED_INT32_KEY, Value.newBuilder().setIntegerValue(value).build())
        .build();
  }

  static MapValue encodeDecimal128Value(String value) {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_DECIMAL128_KEY, Value.newBuilder().setStringValue(value).build())
        .build();
  }

  static MapValue encodeBsonBinaryData(int subtype, ByteString data) {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_BSON_BINARY_KEY,
            Value.newBuilder()
                .setBytesValue(ByteString.copyFrom(new byte[] {(byte) subtype}).concat(data))
                .build())
        .build();
  }

  static MapValue encodeBsonObjectId(String oid) {
    return MapValue.newBuilder()
        .putFields(MapType.RESERVED_OBJECT_ID_KEY, Value.newBuilder().setStringValue(oid).build())
        .build();
  }

  static MapValue encodeBsonTimestamp(long seconds, long increment) {
    return MapValue.newBuilder()
        .putFields(
            MapType.RESERVED_BSON_TIMESTAMP_KEY,
            Value.newBuilder()
                .setMapValue(
                    MapValue.newBuilder()
                        .putFields(
                            MapType.RESERVED_BSON_TIMESTAMP_SECONDS_KEY,
                            Value.newBuilder().setIntegerValue(seconds).build())
                        .putFields(
                            MapType.RESERVED_BSON_TIMESTAMP_INCREMENT_KEY,
                            Value.newBuilder().setIntegerValue(increment).build())
                        .build())
                .build())
        .build();
  }

  static Object decodeValue(FirestoreRpcContext<?> rpcContext, Value v) {
    Value.ValueTypeCase typeCase = v.getValueTypeCase();
    switch (typeCase) {
      case NULL_VALUE:
        return null;
      case BOOLEAN_VALUE:
        return v.getBooleanValue();
      case INTEGER_VALUE:
        return v.getIntegerValue();
      case DOUBLE_VALUE:
        return v.getDoubleValue();
      case TIMESTAMP_VALUE:
        return Timestamp.fromProto(v.getTimestampValue());
      case STRING_VALUE:
        return v.getStringValue();
      case BYTES_VALUE:
        return Blob.fromByteString(v.getBytesValue());
      case REFERENCE_VALUE:
        String pathName = v.getReferenceValue();
        return new DocumentReference(rpcContext, ResourcePath.create(pathName));
      case FIELD_REFERENCE_VALUE:
        return v.getFieldReferenceValue();
      case VARIABLE_REFERENCE_VALUE:
        return v.getVariableReferenceValue();
      case GEO_POINT_VALUE:
        return new GeoPoint(
            v.getGeoPointValue().getLatitude(), v.getGeoPointValue().getLongitude());
      case ARRAY_VALUE:
        List<Object> list = new ArrayList<>();
        List<Value> lv = v.getArrayValue().getValuesList();
        for (Value iv : lv) {
          list.add(decodeValue(rpcContext, iv));
        }
        return list;
      case MAP_VALUE:
        return decodeMap(rpcContext, v.getMapValue());
      default:
        throw FirestoreException.forInvalidArgument(
            String.format("Unknown Value Type: %s", typeCase));
    }
  }

  /** Decodes the given MapValue into a Regex. Assumes the given map is a regex. */
  static RegexValue decodeRegexValue(MapValue mapValue) {
    Map<String, Value> regexMap =
        mapValue.getFieldsMap().get(MapType.RESERVED_REGEX_KEY).getMapValue().getFieldsMap();
    String pattern = regexMap.get(MapType.RESERVED_REGEX_PATTERN_KEY).getStringValue();
    String options = regexMap.get(MapType.RESERVED_REGEX_OPTIONS_KEY).getStringValue();
    return new RegexValue(pattern, options);
  }

  /** Decodes the given MapValue into a BsonObjectId. Assumes the given map is a BSON object ID. */
  static BsonObjectId decodeBsonObjectId(MapValue mapValue) {
    return new BsonObjectId(
        mapValue.getFieldsMap().get(MapType.RESERVED_OBJECT_ID_KEY).getStringValue());
  }

  /** Decodes the given MapValue into a BsonObjectId. Assumes the given map is a BSON object ID. */
  static BsonTimestamp decodeBsonTimestamp(MapValue mapValue) {
    Map<String, Value> timestampMap =
        mapValue
            .getFieldsMap()
            .get(MapType.RESERVED_BSON_TIMESTAMP_KEY)
            .getMapValue()
            .getFieldsMap();
    long seconds = timestampMap.get(MapType.RESERVED_BSON_TIMESTAMP_SECONDS_KEY).getIntegerValue();
    long increment =
        timestampMap.get(MapType.RESERVED_BSON_TIMESTAMP_INCREMENT_KEY).getIntegerValue();
    return new BsonTimestamp(seconds, increment);
  }

  /** Decodes the given MapValue into a BsonBinaryData. Assumes the given map is a BSON binary. */
  static BsonBinaryData decodeBsonBinary(MapValue mapValue) {
    ByteString bytes =
        mapValue.getFieldsMap().get(MapType.RESERVED_BSON_BINARY_KEY).getBytesValue();
    // Note: A byte is interpreted as a signed 8-bit value. Since values larger than 127 have a
    // leading '1' bit, simply casting them to integer results in sign-extension and lead to a
    // negative integer value. For example, the byte `0x80` casted to `int` results in `-128`,
    // rather than `128`, and the byte `0xFF` casted to `int` will be `-1` rather than `255`.
    // Since we want the `subtype` to be an unsigned byte, we need to perform 0-extension (rather
    // than sign-extension) to convert it to an int.
    int subtype = bytes.byteAt(0) & 0xFF;
    return BsonBinaryData.fromByteString(subtype, bytes.substring(1));
  }

  /**
   * Decodes the given MapValue into an Int32Value. Assumes the given map is a 32-bit integer value.
   */
  static Int32Value decodeInt32Value(MapValue mapValue) {
    // The "integer_value" in the proto is a 64-bit integer, but since this
    // value is in a special map with the "__int__" field, we know we can
    // safely cast this value down to a 32-bit integer value.
    long value = mapValue.getFieldsMap().get(MapType.RESERVED_INT32_KEY).getIntegerValue();
    return new Int32Value((int) value);
  }

  /**
   * Decodes the given MapValue into a Decimal128Value. Assumes the given map is a 128-bit decimal
   * value.
   */
  static Decimal128Value decodeDecimal128Value(MapValue mapValue) {
    String value = mapValue.getFieldsMap().get(MapType.RESERVED_DECIMAL128_KEY).getStringValue();
    return new Decimal128Value(value);
  }

  static Object decodeMap(FirestoreRpcContext<?> rpcContext, MapValue mapValue) {
    MapRepresentation mapRepresentation = detectMapRepresentation(mapValue);
    Map<String, Value> inputMap = mapValue.getFieldsMap();
    switch (mapRepresentation) {
      case UNKNOWN:
        LOGGER.warning(
            "Parsing unknown map type as generic map. This map type may be supported in a newer SDK"
                + " version.");
      case NONE:
        Map<String, Object> outputMap = new HashMap<>();
        for (Map.Entry<String, Value> entry : inputMap.entrySet()) {
          outputMap.put(entry.getKey(), decodeValue(rpcContext, entry.getValue()));
        }
        return outputMap;
      case VECTOR_VALUE:
        double[] values =
            inputMap.get(MapType.VECTOR_MAP_VECTORS_KEY).getArrayValue().getValuesList().stream()
                .mapToDouble(val -> val.getDoubleValue())
                .toArray();
        return new VectorValue(values);
      case MIN_KEY:
        return MinKey.instance();
      case MAX_KEY:
        return MaxKey.instance();
      case REGEX:
        return decodeRegexValue(mapValue);
      case INT32:
        return decodeInt32Value(mapValue);
      case DECIMAL128:
        return decodeDecimal128Value(mapValue);
      case BSON_OBJECT_ID:
        return decodeBsonObjectId(mapValue);
      case BSON_TIMESTAMP:
        return decodeBsonTimestamp(mapValue);
      case BSON_BINARY_DATA:
        return decodeBsonBinary(mapValue);
      default:
        throw FirestoreException.forInvalidArgument(
            String.format("Unsupported MapRepresentation: %s", mapRepresentation));
    }
  }

  /** Indicates the data type represented by a MapValue. */
  enum MapRepresentation {
    /** The MapValue represents an unknown data type. */
    UNKNOWN,
    /** The MapValue does not represent any special data type. */
    NONE,
    /** The MapValue represents a VectorValue. */
    VECTOR_VALUE,
    /** The MapValue represents a MinKey. */
    MIN_KEY,
    /** The MapValue represents a MaxKey. */
    MAX_KEY,
    /** The MapValue represents a regular expression. */
    REGEX,
    /** The MapValue represents a 32-bit integer. */
    INT32,
    /** The MapValue represents a 128-bit decimal. */
    DECIMAL128,
    /** The MapValue represents a BSON ObjectId. */
    BSON_OBJECT_ID,
    /** The MapValue represents a BSON Timestamp. */
    BSON_TIMESTAMP,
    /** The MapValue represents a BSON Binary Data. */
    BSON_BINARY_DATA,
  }

  private static boolean isMapWithSingleKeyAndType(
      MapValue mapValue, String key, Value.ValueTypeCase type) {
    return mapValue.getFieldsCount() == 1
        && mapValue.getFieldsMap().containsKey(key)
        && mapValue.getFieldsMap().get(key).getValueTypeCase().equals(type);
  }

  static boolean isMinKey(MapValue mapValue) {
    return isMapWithSingleKeyAndType(
        mapValue, MapType.RESERVED_MIN_KEY, Value.ValueTypeCase.NULL_VALUE);
  }

  static boolean isMaxKey(MapValue mapValue) {
    return isMapWithSingleKeyAndType(
        mapValue, MapType.RESERVED_MAX_KEY, Value.ValueTypeCase.NULL_VALUE);
  }

  static boolean isInt32Value(MapValue mapValue) {
    return isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_INT32_KEY, INTEGER_VALUE);
  }

  static boolean isInt32Value(Value value) {
    return value.hasMapValue() && isInt32Value(value.getMapValue());
  }

  static boolean isIntegerValue(Value value) {
    return value.hasIntegerValue() || isInt32Value(value);
  }

  static boolean isDecimal128Value(MapValue mapValue) {
    return isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_DECIMAL128_KEY, STRING_VALUE);
  }

  static boolean isDecimal128Value(Value value) {
    return value.hasMapValue() && isDecimal128Value(value.getMapValue());
  }

  static boolean isBsonObjectId(MapValue mapValue) {
    return isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_OBJECT_ID_KEY, STRING_VALUE);
  }

  static boolean isBsonBinaryData(MapValue mapValue) {
    return isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_BSON_BINARY_KEY, BYTES_VALUE);
  }

  static boolean isRegexValue(MapValue mapValue) {
    if (isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_REGEX_KEY, MAP_VALUE)) {
      MapValue innerMapValue =
          mapValue.getFieldsMap().get(MapType.RESERVED_REGEX_KEY).getMapValue();
      Map<String, Value> values = innerMapValue.getFieldsMap();
      return innerMapValue.getFieldsCount() == 2
          && values.containsKey(MapType.RESERVED_REGEX_PATTERN_KEY)
          && values.containsKey(MapType.RESERVED_REGEX_OPTIONS_KEY)
          && values.get(MapType.RESERVED_REGEX_PATTERN_KEY).hasStringValue()
          && values.get(MapType.RESERVED_REGEX_OPTIONS_KEY).hasStringValue();
    }
    return false;
  }

  static boolean isBsonTimestamp(MapValue mapValue) {
    if (isMapWithSingleKeyAndType(mapValue, MapType.RESERVED_BSON_TIMESTAMP_KEY, MAP_VALUE)) {
      MapValue innerMapValue =
          mapValue.getFieldsMap().get(MapType.RESERVED_BSON_TIMESTAMP_KEY).getMapValue();
      Map<String, Value> values = innerMapValue.getFieldsMap();
      return innerMapValue.getFieldsCount() == 2
          && values.containsKey(MapType.RESERVED_BSON_TIMESTAMP_SECONDS_KEY)
          && values.containsKey(MapType.RESERVED_BSON_TIMESTAMP_INCREMENT_KEY)
          && values.get(MapType.RESERVED_BSON_TIMESTAMP_SECONDS_KEY).hasIntegerValue()
          && values.get(MapType.RESERVED_BSON_TIMESTAMP_INCREMENT_KEY).hasIntegerValue();
    }
    return false;
  }

  static MapRepresentation detectMapRepresentation(MapValue mapValue) {
    Map<String, Value> fields = mapValue.getFieldsMap();

    if (isMinKey(mapValue)) {
      return MapRepresentation.MIN_KEY;
    } else if (isMaxKey(mapValue)) {
      return MapRepresentation.MAX_KEY;
    } else if (isRegexValue(mapValue)) {
      return MapRepresentation.REGEX;
    } else if (isInt32Value(mapValue)) {
      return MapRepresentation.INT32;
    } else if (isDecimal128Value(mapValue)) {
      return MapRepresentation.DECIMAL128;
    } else if (isBsonBinaryData(mapValue)) {
      return MapRepresentation.BSON_BINARY_DATA;
    } else if (isBsonObjectId(mapValue)) {
      return MapRepresentation.BSON_OBJECT_ID;
    } else if (isBsonTimestamp(mapValue)) {
      return MapRepresentation.BSON_TIMESTAMP;
    } else if (fields.containsKey(MapType.RESERVED_MAP_KEY)) { // Vector
      Value typeValue = fields.get(MapType.RESERVED_MAP_KEY);
      if (typeValue.getValueTypeCase() != Value.ValueTypeCase.STRING_VALUE) {
        LOGGER.warning(
            "Unable to parse __type__ field of map. Unsupported value type: "
                + typeValue.getValueTypeCase().toString());
        return MapRepresentation.UNKNOWN;
      }

      String typeString = typeValue.getStringValue();

      if (typeString.equals(MapType.RESERVED_MAP_KEY_VECTOR_VALUE)) {
        return MapRepresentation.VECTOR_VALUE;
      }

      LOGGER.warning("Unsupported __type__ value for map: " + typeString);
      return MapRepresentation.UNKNOWN;
    } else {
      // Regular map.
      return MapRepresentation.NONE;
    }
  }

  static Object decodeGoogleProtobufValue(com.google.protobuf.Value v) {
    switch (v.getKindCase()) {
      case NULL_VALUE:
        return null;
      case BOOL_VALUE:
        return v.getBoolValue();
      case NUMBER_VALUE:
        return v.getNumberValue();
      case STRING_VALUE:
        return v.getStringValue();
      case LIST_VALUE:
        return Lists.transform(
            v.getListValue().getValuesList(), UserDataConverter::decodeGoogleProtobufValue);
      case STRUCT_VALUE:
        return Maps.transformValues(
            v.getStructValue().getFieldsMap(), UserDataConverter::decodeGoogleProtobufValue);
      default:
        throw FirestoreException.forInvalidArgument(
            String.format("Unknown Value Type: %s", v.getKindCase().getNumber()));
    }
  }

  static Map<String, Object> decodeStruct(@Nullable Struct struct) {
    if (struct == null || struct.getFieldsCount() == 0) {
      return Collections.emptyMap();
    }
    return Maps.transformValues(
        struct.getFieldsMap(), UserDataConverter::decodeGoogleProtobufValue);
  }
}
