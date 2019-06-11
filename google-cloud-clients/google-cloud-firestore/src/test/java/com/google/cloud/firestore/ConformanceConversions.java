/*
 * Copyright 2019 Google LLC
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

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.conformance.TestDefinition;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class ConformanceConversions {

  private static final Gson gson = new Gson();

  private ConformanceConversions() {}

  /** Converts a Protobuf Precondition to its API counterpart. */
  static Precondition convertPrecondition(com.google.firestore.v1.Precondition precondition) {
    switch (precondition.getConditionTypeCase()) {
      case EXISTS:
        return Precondition.exists(precondition.getExists());
      case UPDATE_TIME:
        return Precondition.updatedAt(Timestamp.fromProto(precondition.getUpdateTime()));
      default:
        return Precondition.NONE;
    }
  }

  /** Converts a list of Proto FieldPaths to its API counterpart. */
  static List<FieldPath> convertPaths(List<TestDefinition.FieldPath> fieldsList) {
    List<FieldPath> convertedPaths = new ArrayList<>();
    for (TestDefinition.FieldPath fieldPath : fieldsList) {
      convertedPaths.add(convertPath(fieldPath));
    }
    return convertedPaths;
  }

  /** Converts a Proto FieldPath to its API counterpart. */
  static FieldPath convertPath(TestDefinition.FieldPath fieldPath) {
    return FieldPath.of(fieldPath.getFieldList().toArray(new String[0]));
  }

  /** Converts a JSON string into a Java Map. */
  static Map<String, Object> convertInput(String jsonMap) {
    Type type = new TypeToken<Map<String, Object>>() {}.getType();
    Map<String, Object> parsedData = gson.fromJson(jsonMap, type);
    return convertMap(parsedData);
  }

  /** Converts a list of Strings into a Java Object. Parses JSON when provided. */
  static List<Object> convertInput(List<String> jsonValues) {
    List<Object> result = new ArrayList<>();
    for (String input : jsonValues) {
      if (input.matches("^\\{.*}$")) {
        result.add(convertInput(input));
      } else {
        // We need to "fake" a proper JSON object to let GSON convert to native types.
        result.add(convertInput("{a:" + input + "}").get("a"));
      }
    }
    return result;
  }

  /** Helper function to convert test values in a nested Map to Firestore API types. */
  private static Map<String, Object> convertMap(Map<String, Object> parsedData) {
    for (Map.Entry<String, Object> entry : parsedData.entrySet()) {
      parsedData.put(entry.getKey(), convertValue(entry.getValue()));
    }
    return parsedData;
  }

  /**
   * Converts test values to Firestore API types. Replaces sentinel values with their FieldValue
   * constants.
   */
  @SuppressWarnings("unchecked")
  private static Object convertValue(Object data) {
    if (data instanceof Map) {
      return convertMap((Map<String, Object>) data);
    } else if (data instanceof List) {
      return convertArray((List<Object>) data);
    } else if ("NaN".equals(data)) {
      return Double.NaN;
    } else if ("Delete".equals(data)) {
      return FieldValue.delete();
    } else if ("ServerTimestamp".equals(data)) {
      return FieldValue.serverTimestamp();
    } else if (data instanceof Double
        && Double.compare((double) data, Math.floor((double) data)) == 0) {
      return (long) (double) data;
    } else {
      return data;
    }
  }

  /** Helper function to convert test values in a list to Firestore API types. */
  @SuppressWarnings("unchecked")
  private static Object convertArray(List<Object> list) {
    if (!list.isEmpty() && list.get(0).equals("ArrayUnion")) {
      return FieldValue.arrayUnion(
          ((List<Object>) convertArray(list.subList(1, list.size()))).toArray());
    } else if (!list.isEmpty() && list.get(0).equals("ArrayRemove")) {
      return FieldValue.arrayRemove(
          ((List<Object>) convertArray(list.subList(1, list.size()))).toArray());
    } else {
      for (int i = 0; i < list.size(); ++i) {
        list.set(i, convertValue(list.get(i)));
      }
      return list;
    }
  }
}
