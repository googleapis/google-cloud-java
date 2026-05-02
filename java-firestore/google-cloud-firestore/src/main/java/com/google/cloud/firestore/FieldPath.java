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

import com.google.api.core.InternalApi;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.StructuredQuery;
import java.util.regex.Pattern;
import javax.annotation.Nonnull;

/**
 * A {@code FieldPath} refers to a field in a document. The path may consist of a single field name
 * (referring to a top level field in the document), or a list of field names (referring to a nested
 * field in the document).
 */
@AutoValue
public abstract class FieldPath extends BasePath<FieldPath> implements Comparable<FieldPath> {

  private static final String DOCUMENT_ID_SENTINEL = "__name__";

  /**
   * A special sentinel FieldPath to refer to the ID of a document. It can be used in queries to
   * sort or filter by the document ID.
   */
  static final FieldPath DOCUMENT_ID = FieldPath.of(DOCUMENT_ID_SENTINEL);

  /** Regular expression to verify that dot-separated field paths do not contain ~*[]/. */
  private static final Pattern PROHIBITED_CHARACTERS = Pattern.compile(".*[~*/\\[\\]].*");

  private static FieldPath EMPTY = null;

  /**
   * Creates a FieldPath from the provided field names. If more than one field name is provided, the
   * path will point to a nested field in a document.
   *
   * @param fieldNames A list of field names.
   * @return A {@code FieldPath} that points to a field location in a document.
   */
  public static FieldPath of(@Nonnull String... fieldNames) {
    Preconditions.checkArgument(
        fieldNames.length > 0, "Invalid field path. Provided path must not be empty.");

    for (int i = 0; i < fieldNames.length; ++i) {
      Preconditions.checkArgument(
          fieldNames[i] != null && !fieldNames[i].isEmpty(),
          "Invalid field name at argument %s. Field names must not be null or empty.",
          (i + 1));
    }

    return new AutoValue_FieldPath(ImmutableList.copyOf(fieldNames));
  }

  /**
   * A special sentinel to refer to the ID of a document. It can be used in queries to sort or
   * filter by the document ID.
   */
  public static FieldPath documentId() {
    return DOCUMENT_ID;
  }

  /** Verifies if the provided path matches the path that is used for the Document ID sentinel. */
  static boolean isDocumentId(String path) {
    return DOCUMENT_ID_SENTINEL.equals(path);
  }

  /** Returns a field path from a dot separated string. Does not support escaping. */
  @InternalApi
  public static FieldPath fromDotSeparatedString(String field) {
    if (PROHIBITED_CHARACTERS.matcher(field).matches()) {
      throw new IllegalArgumentException("Use FieldPath.of() for field names containing '˜*/[]'.");
    }
    return empty().append(field);
  }

  /**
   * Creates a {@code FieldPath} from a server-encoded field path.
   *
   * <p>Copied from Firebase Android SDK:
   * https://github.com/firebase/firebase-android-sdk/blob/2d3b2be7d2d00d693eb74986f20a6265c918848f/firebase-firestore/src/main/java/com/google/firebase/firestore/model/FieldPath.java#L47
   */
  public static FieldPath fromServerFormat(String path) {
    ImmutableList.Builder<String> res = ImmutableList.builder();
    StringBuilder builder = new StringBuilder();

    int i = 0;

    // If we're inside '`' backticks, then we should ignore '.' dots.
    boolean inBackticks = false;

    int length = path.length();
    while (i < length) {
      char c = path.charAt(i);
      if (c == '\\') {
        if (i + 1 == length) {
          throw new IllegalArgumentException("Trailing escape character is not allowed");
        }
        i++;
        builder.append(path.charAt(i));
      } else if (c == '.') {
        if (!inBackticks) {
          String elem = builder.toString();
          if (elem.isEmpty()) {
            throw new IllegalArgumentException(
                "Invalid field path ("
                    + path
                    + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
          }
          builder = new StringBuilder();
          res.add(elem);
        } else {
          // escaped, append to current segment
          builder.append(c);
        }
      } else if (c == '`') {
        inBackticks = !inBackticks;
      } else {
        builder.append(c);
      }
      i++;
    }
    String lastElem = builder.toString();
    if (lastElem.isEmpty()) {
      throw new IllegalArgumentException(
          "Invalid field path ("
              + path
              + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }
    res.add(lastElem);
    return new AutoValue_FieldPath(res.build());
  }

  /** Returns an empty field path. */
  static FieldPath empty() {
    // NOTE: This static is lazy evaluated since otherwise it would create a
    // circular class dependency during initialization.
    return EMPTY == null ? (EMPTY = new AutoValue_FieldPath(ImmutableList.of())) : EMPTY;
  }

  private String encodedPath;

  String getEncodedPath() {
    if (encodedPath == null) {
      encodedPath = canonicalString();
    }
    return encodedPath;
  }

  /** Parses a field path string into a FieldPath, treating dots as separators. */
  @Override
  String[] splitChildPath(String path) {
    // By default, split() doesn't return empty leading and trailing segments. This can be enabled
    // by passing "-1" as the  limit.
    return path.split("\\.", -1);
  }

  /**
   * Return true if the string could be used as a segment in a field path without escaping. Valid
   * identifies follow the regex [a-zA-Z_][a-zA-Z0-9_]*
   */
  private static boolean isValidIdentifier(String identifier) {
    if (identifier.isEmpty()) {
      return false;
    }

    char first = identifier.charAt(0);
    if (first != '_' && (first < 'a' || first > 'z') && (first < 'A' || first > 'Z')) {
      return false;
    }
    for (int i = 1; i < identifier.length(); i++) {
      char c = identifier.charAt(i);
      if (c != '_' && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < '0' || c > '9')) {
        return false;
      }
    }
    return true;
  }

  /** Encodes a list of field name segments in the server-accepted format. */
  private String canonicalString() {
    ImmutableList<String> segments = getSegments();

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < segments.size(); i++) {
      if (i > 0) {
        builder.append(".");
      }
      // Escape backslashes and backticks.
      String escaped = segments.get(i);
      escaped = escaped.replace("\\", "\\\\").replace("`", "\\`");

      if (!isValidIdentifier(escaped)) {
        escaped = '`' + escaped + '`';
      }

      builder.append(escaped);
    }
    return builder.toString();
  }

  @Override
  FieldPath createPathWithSegments(ImmutableList<String> segments) {
    return new AutoValue_FieldPath(segments);
  }

  @Override
  public String toString() {
    return getEncodedPath();
  }

  StructuredQuery.FieldReference toProto() {
    return StructuredQuery.FieldReference.newBuilder().setFieldPath(getEncodedPath()).build();
  }
}
