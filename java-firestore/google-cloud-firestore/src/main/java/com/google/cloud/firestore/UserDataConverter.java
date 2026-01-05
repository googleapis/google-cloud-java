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
    VECTOR_VALUE
  }

  static MapRepresentation detectMapRepresentation(MapValue mapValue) {
    Map<String, Value> fields = mapValue.getFieldsMap();
    if (!fields.containsKey(MapType.RESERVED_MAP_KEY)) {
      return MapRepresentation.NONE;
    }

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
