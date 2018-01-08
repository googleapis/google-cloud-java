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

package com.google.cloud.firestore;

import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.ArrayValue;
import com.google.firestore.v1beta1.MapValue;
import com.google.firestore.v1beta1.Value;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/** Converts user input into the Firestore Value representation. */
class UserDataConverter {

  /** Controls the behavior for field deletes. */
  interface EncodingOptions {
    /** Returns whether a field delete at `fieldPath` is allowed. */
    boolean allowDelete(FieldPath fieldPath);
  }

  /** Rejects all field deletes. */
  static final EncodingOptions NO_DELETES =
      new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return false;
        }
      };

  /** Allows all field deletes. */
  static final EncodingOptions ALLOW_ALL_DELETES =
      new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return true;
        }
      };

  private UserDataConverter() {
  }

  /**
   * Encodes a Java Object to a Firestore Value proto.
   *
   * @param path path THe field path of the object to encode.
   * @param sanitizedObject An Object that has been sanitized by CustomClassMapper and only contains
   *     valid types.
   * @param options Encoding opions to use for this value.
   * @return The Value proto.
   */
  @Nullable
  static Value encodeValue(
      FieldPath path, @Nullable Object sanitizedObject, EncodingOptions options) {
    if (sanitizedObject == FieldValue.DELETE_SENTINEL) {
      Preconditions.checkArgument(
          options.allowDelete(path), "Encountered unexpected delete sentinel at field '%s'.", path);
      return null;
    } else if (sanitizedObject == FieldValue.SERVER_TIMESTAMP_SENTINEL) {
      return null;
    } else if (sanitizedObject == null) {
      return Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    } else if (sanitizedObject instanceof String) {
      return Value.newBuilder().setStringValue((String) sanitizedObject).build();
    } else if (sanitizedObject instanceof Integer) {
      return Value.newBuilder().setIntegerValue((Integer) sanitizedObject).build();
    } else if (sanitizedObject instanceof Long) {
      return Value.newBuilder().setIntegerValue((Long) sanitizedObject).build();
    } else if (sanitizedObject instanceof Double) {
      return Value.newBuilder().setDoubleValue((Double) sanitizedObject).build();
    } else if (sanitizedObject instanceof Boolean) {
      return Value.newBuilder().setBooleanValue((Boolean) sanitizedObject).build();
    } else if (sanitizedObject instanceof Date) {
      Date date = (Date) sanitizedObject;
      long epochSeconds = TimeUnit.MILLISECONDS.toSeconds(date.getTime());
      long msOffset = date.getTime() - TimeUnit.SECONDS.toMillis(epochSeconds);
      Timestamp.Builder timestampBuilder = Timestamp.newBuilder();
      timestampBuilder.setSeconds(epochSeconds);
      timestampBuilder.setNanos((int) TimeUnit.MILLISECONDS.toNanos(msOffset));
      return Value.newBuilder().setTimestampValue(timestampBuilder.build()).build();
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
    } else if (sanitizedObject instanceof DocumentReference) {
      DocumentReference docRef = (DocumentReference) sanitizedObject;
      return Value.newBuilder().setReferenceValue(docRef.getName()).build();
    } else if (sanitizedObject instanceof Map) {
      MapValue.Builder res = MapValue.newBuilder();
      Map<String, Object> map = (Map<String, Object>) sanitizedObject;

      for (Map.Entry<String, Object> entry : map.entrySet()) {
        Value encodedValue = encodeValue(path.append(entry.getKey()), entry.getValue(), options);
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
    }

    throw FirestoreException.invalidState("Cannot convert %s to Firestore Value", sanitizedObject);
  }
}
