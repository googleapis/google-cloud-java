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

import com.google.cloud.firestore.UserDataConverter.EncodingOptions;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * An options object that configures the behavior of set() calls. By providing one of the SetOptions
 * objects returned by {@link #merge}, {@link #mergeFields} and {@link #mergeFieldPaths}, the set()
 * calls in {@link DocumentReference}, {@link WriteBatch} and {@link Transaction} can be configured
 * to perform granular merges instead of overwriting the target documents in their entirety.
 */
public final class SetOptions {

  static final SetOptions OVERWRITE = new SetOptions(false, null);
  private static final SetOptions MERGE_ALL_FIELDS = new SetOptions(true, null);

  private final boolean merge;
  @Nullable private final List<FieldPath> fieldMask;

  private SetOptions(boolean merge, @Nullable List<FieldPath> fieldMask) {
    Preconditions.checkArgument(
        fieldMask == null || merge, "Cannot specify a fieldMask for non-merge sets()");
    this.merge = merge;
    this.fieldMask = fieldMask;
  }

  boolean isMerge() {
    return merge;
  }

  @Nullable
  List<FieldPath> getFieldMask() {
    return fieldMask;
  }

  /**
   * Changes the behavior of set() calls to only replace the values specified in its data argument.
   * Fields with no corresponding values in the data passed to set() will remain untouched.
   */
  @Nonnull
  public static SetOptions merge() {
    return MERGE_ALL_FIELDS;
  }

  /**
   * Changes the behavior of set() calls to only replace the fields under fieldPaths. Any field that
   * is not specified in fieldPaths is ignored and remains untouched.
   *
   * <p>It is an error to pass a SetOptions object to a set() call that is missing a value for any
   * of the fields specified here.
   *
   * @param fields The list of fields to merge. Fields can contain dots to reference nested fields
   *     within the document.
   */
  @Nonnull
  public static SetOptions mergeFields(List<String> fields) {
    List<FieldPath> fieldPaths = new ArrayList<>();

    for (String field : fields) {
      fieldPaths.add(FieldPath.fromDotSeparatedString(field));
    }

    return new SetOptions(true, fieldPaths);
  }

  /**
   * Changes the behavior of set() calls to only replace the fields under fieldPaths. Any field that
   * is not specified in fieldPaths is ignored and remains untouched.
   *
   * <p>It is an error to pass a SetOptions object to a set() call that is missing a value for any
   * of the fields specified here.
   *
   * @param fields The list of fields to merge. Fields can contain dots to reference nested fields
   *     within the document.
   */
  @Nonnull
  public static SetOptions mergeFields(String... fields) {
    List<FieldPath> fieldPaths = new ArrayList<>();

    for (String field : fields) {
      fieldPaths.add(FieldPath.fromDotSeparatedString(field));
    }

    return new SetOptions(true, fieldPaths);
  }

  /**
   * Changes the behavior of set() calls to only replace the fields under fieldPaths. Any field that
   * is not specified in fieldPaths is ignored and remains untouched.
   *
   * <p>It is an error to pass a SetOptions object to a set() call that is missing a value for any
   * of the fields specified here in its to data argument.
   *
   * @param fields The list of fields to merge.
   */
  @Nonnull
  public static SetOptions mergeFieldPaths(List<FieldPath> fields) {
    return new SetOptions(true, fields);
  }

  /** Returns the EncodingOptions to use for a set() call. */
  EncodingOptions getEncodingOptions() {
    if (!merge) {
      return UserDataConverter.NO_DELETES;
    } else if (fieldMask == null) {
      return UserDataConverter.ALLOW_ALL_DELETES;
    } else {
      return new EncodingOptions() {
        @Override
        public boolean allowDelete(FieldPath fieldPath) {
          return fieldMask.contains(fieldPath);
        }
      };
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SetOptions that = (SetOptions) o;
    return merge == that.merge && Objects.equals(fieldMask, that.fieldMask);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merge, fieldMask);
  }
}
