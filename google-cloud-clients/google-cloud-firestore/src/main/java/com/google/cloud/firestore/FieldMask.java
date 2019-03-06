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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.annotation.Nonnull;

/** A FieldMask can be used to limit the number of fields returned by a `getAll()` call. */
public final class FieldMask {
  static final FieldMask EMPTY_MASK = new FieldMask(new TreeSet<FieldPath>());

  private final SortedSet<FieldPath> fieldPaths; // Sorted for testing.

  FieldMask(Collection<FieldPath> fieldPaths) {
    this(new TreeSet<>(fieldPaths));
  }

  private FieldMask(SortedSet<FieldPath> fieldPaths) {
    this.fieldPaths = fieldPaths;
  }

  /**
   * Creates a FieldMask from the provided field paths.
   *
   * @param fieldPaths A list of field paths.
   * @return A {@code FieldMask} that describes a subset of fields.
   */
  @Nonnull
  public static FieldMask of(String... fieldPaths) {
    List<FieldPath> paths = new ArrayList<>();
    for (String fieldPath : fieldPaths) {
      paths.add(FieldPath.fromDotSeparatedString(fieldPath));
    }
    return new FieldMask(paths);
  }

  /**
   * Creates a FieldMask from the provided field paths.
   *
   * @param fieldPaths A list of field paths.
   * @return A {@code FieldMask} that describes a subset of fields.
   */
  @Nonnull
  public static FieldMask of(FieldPath... fieldPaths) {
    return new FieldMask(Arrays.asList(fieldPaths));
  }

  static FieldMask fromObject(Map<String, Object> values) {
    List<FieldPath> fieldPaths = extractFromMap(values, FieldPath.empty());
    return new FieldMask(fieldPaths);
  }

  private static List<FieldPath> extractFromMap(Map<String, Object> values, FieldPath path) {
    List<FieldPath> fieldPaths = new ArrayList<>();

    for (Map.Entry<String, Object> entry : values.entrySet()) {
      Object value = entry.getValue();
      FieldPath childPath = path.append(FieldPath.of(entry.getKey()));
      if (entry.getValue() instanceof FieldValue) {
        if (((FieldValue) entry.getValue()).includeInDocumentMask()) {
          fieldPaths.add(childPath);
        }
      } else if (value instanceof Map) {
        fieldPaths.addAll(extractFromMap((Map<String, Object>) value, childPath));
      } else {
        // We don't need to special case arrays here as we don't support partial array updates.
        fieldPaths.add(childPath);
      }
    }

    return fieldPaths;
  }

  com.google.firestore.v1.DocumentMask toPb() {
    com.google.firestore.v1.DocumentMask.Builder updateMask =
        com.google.firestore.v1.DocumentMask.newBuilder();
    for (FieldPath fieldPath : fieldPaths) {
      updateMask.addFieldPaths(fieldPath.getEncodedPath());
    }
    return updateMask.build();
  }

  boolean isEmpty() {
    return fieldPaths.isEmpty();
  }
}
