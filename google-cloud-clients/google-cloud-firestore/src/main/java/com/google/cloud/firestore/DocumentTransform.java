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

import com.google.firestore.v1.DocumentTransform.FieldTransform;
import com.google.firestore.v1.Write;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * A DocumentTransform contains pending server-side transforms and their corresponding field paths.
 */
final class DocumentTransform {

  private DocumentReference documentReference;
  private final SortedMap<FieldPath, FieldTransform> transforms; // Sorted for testing.

  private DocumentTransform(
      DocumentReference documentReference, SortedMap<FieldPath, FieldTransform> transforms) {
    this.documentReference = documentReference;
    this.transforms = transforms;
  }

  static DocumentTransform fromFieldPathMap(
      DocumentReference documentReference, Map<FieldPath, Object> values) {
    SortedMap<FieldPath, FieldTransform> transforms = new TreeMap<>();

    for (Map.Entry<FieldPath, Object> entry : values.entrySet()) {
      FieldPath path = entry.getKey();
      Object value = entry.getValue();
      if (value instanceof FieldValue) {
        FieldValue fieldValue = (FieldValue) value;
        if (fieldValue.includeInDocumentTransform()) {
          transforms.put(path, fieldValue.toProto(path));
        }
      } else if (value instanceof Map) {
        transforms.putAll(
            extractFromMap((Map<String, Object>) value, path, /* allowTransforms= */ true));
      } else if (entry.getValue() instanceof List) {
        // DocumentTransforms cannot be contained in Lists. We still process the List for
        // validation.
        validateArray((List<Object>) entry.getValue(), path);
      }
    }

    return new DocumentTransform(documentReference, transforms);
  }

  private static SortedMap<FieldPath, FieldTransform> extractFromMap(
      Map<String, Object> values, FieldPath path, boolean allowTransforms) {
    SortedMap<FieldPath, FieldTransform> transforms = new TreeMap<>();

    for (Map.Entry<String, Object> entry : values.entrySet()) {
      Object value = entry.getValue();
      path = path.append(FieldPath.of(entry.getKey()));
      if (value instanceof FieldValue) {
        FieldValue fieldValue = (FieldValue) value;
        if (allowTransforms) {
          if (fieldValue.includeInDocumentTransform()) {
            transforms.put(path, fieldValue.toProto(path));
          }
        } else {
          throw FirestoreException.invalidState(
              fieldValue.getMethodName() + " is not supported inside of an array.");
        }
      } else if (value instanceof Map) {
        transforms.putAll(extractFromMap((Map<String, Object>) value, path, allowTransforms));
      } else if (entry.getValue() instanceof List) {
        validateArray((List<Object>) entry.getValue(), path);
      }
      path = path.getParent();
    }

    return transforms;
  }

  private static void validateArray(List<Object> values, FieldPath path) {
    for (int i = 0; i < values.size(); ++i) {
      Object value = values.get(i);
      path = path.append(FieldPath.of(Integer.toString(i)));
      if (value instanceof FieldValue) {
        throw FirestoreException.invalidState(
            ((FieldValue) value).getMethodName() + " is not supported inside of an array.");
      } else if (value instanceof Map) {
        extractFromMap((Map<String, Object>) value, path, false);
      } else if (value instanceof List) {
        validateArray((List<Object>) value, path);
      }
      path = path.getParent();
    }
  }

  boolean isEmpty() {
    return transforms.isEmpty();
  }

  Set<FieldPath> getFields() {
    return Collections.unmodifiableSet(transforms.keySet());
  }

  Write.Builder toPb() {
    Write.Builder write = Write.newBuilder();
    com.google.firestore.v1.DocumentTransform.Builder transform = write.getTransformBuilder();
    transform.addAllFieldTransforms(transforms.values());
    transform.setDocument(documentReference.getName());
    return write;
  }
}
