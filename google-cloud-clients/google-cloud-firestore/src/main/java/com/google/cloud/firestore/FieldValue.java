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

import com.google.common.base.Preconditions;
import com.google.firestore.v1beta1.ArrayValue;
import com.google.firestore.v1beta1.DocumentTransform.FieldTransform;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nonnull;

/** Sentinel values that can be used when writing document fields with set() or update(). */
public abstract class FieldValue {

  private static final FieldValue SERVER_TIMESTAMP_SENTINEL =
      new FieldValue() {
        @Override
        boolean includeInDocumentMask() {
          return false;
        }

        @Override
        boolean includeInDocumentTransform() {
          return true;
        }

        @Override
        String getMethodName() {
          return "FieldValue.serverTimestamp()";
        }

        @Override
        FieldTransform toProto(FieldPath path) {
          FieldTransform.Builder fieldTransform = FieldTransform.newBuilder();
          fieldTransform.setFieldPath(path.getEncodedPath());
          fieldTransform.setSetToServerValue(FieldTransform.ServerValue.REQUEST_TIME);
          return fieldTransform.build();
        }
      };

  static final FieldValue DELETE_SENTINEL =
      new FieldValue() {
        @Override
        boolean includeInDocumentMask() {
          return true;
        }

        @Override
        boolean includeInDocumentTransform() {
          return false;
        }

        @Override
        String getMethodName() {
          return "FieldValue.delete()";
        }

        @Override
        FieldTransform toProto(FieldPath path) {
          throw new IllegalStateException(
              "FieldValue.delete() should not be included in a FieldTransform");
        }
      };

  static class ArrayUnionFieldValue extends FieldValue {
    final List<Object> elements;

    ArrayUnionFieldValue(List<Object> elements) {
      this.elements = elements;
    }

    @Override
    boolean includeInDocumentMask() {
      return false;
    }

    @Override
    boolean includeInDocumentTransform() {
      return true;
    }

    @Override
    String getMethodName() {
      return "FieldValue.arrayUnion()";
    }

    @Override
    FieldTransform toProto(FieldPath path) {
      ArrayValue.Builder encodedElements = ArrayValue.newBuilder();

      for (Object element : elements) {
        encodedElements.addValues(
            UserDataConverter.encodeValue(path, element, UserDataConverter.ARGUMENT));
      }

      FieldTransform.Builder fieldTransform = FieldTransform.newBuilder();
      fieldTransform.setFieldPath(path.getEncodedPath());
      fieldTransform.setAppendMissingElements(encodedElements);
      return fieldTransform.build();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ArrayUnionFieldValue that = (ArrayUnionFieldValue) o;
      return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
      return Objects.hash(elements);
    }
  }

  static class ArrayRemoveFieldValue extends FieldValue {
    final List<Object> elements;

    ArrayRemoveFieldValue(List<Object> elements) {
      this.elements = elements;
    }

    @Override
    boolean includeInDocumentMask() {
      return false;
    }

    @Override
    boolean includeInDocumentTransform() {
      return true;
    }

    @Override
    String getMethodName() {
      return "FieldValue.arrayRemove()";
    }

    @Override
    FieldTransform toProto(FieldPath path) {
      ArrayValue.Builder encodedElements = ArrayValue.newBuilder();

      for (Object element : elements) {
        encodedElements.addValues(
            UserDataConverter.encodeValue(path, element, UserDataConverter.ARGUMENT));
      }

      FieldTransform.Builder fieldTransform = FieldTransform.newBuilder();
      fieldTransform.setFieldPath(path.getEncodedPath());
      fieldTransform.setRemoveAllFromArray(encodedElements);
      return fieldTransform.build();
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      ArrayRemoveFieldValue that = (ArrayRemoveFieldValue) o;
      return Objects.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
      return Objects.hash(elements);
    }
  }

  private FieldValue() {}

  /**
   * Returns a sentinel used with set() or update() to include a server-generated timestamp in the
   * written data.
   */
  @Nonnull
  public static FieldValue serverTimestamp() {
    return SERVER_TIMESTAMP_SENTINEL;
  }

  /** Returns a sentinel used with update() to mark a field for deletion. */
  @Nonnull
  public static FieldValue delete() {
    return DELETE_SENTINEL;
  }

  /**
   * Returns a special value that can be used with set() or update() that tells the server to union
   * the given elements with any array value that already exists on the server. Each specified
   * element that doesn't already exist in the array will be added to the end. If the field being
   * modified is not already an array it will be overwritten with an array containing exactly the
   * specified elements.
   *
   * @param elements The elements to union into the array.
   * @return The FieldValue sentinel for use in a call to set() or update().
   */
  @Nonnull
  public static FieldValue arrayUnion(@Nonnull Object... elements) {
    Preconditions.checkArgument(elements.length > 0, "arrayUnion() expects at least 1 element");
    return new ArrayUnionFieldValue(Arrays.asList(elements));
  }

  /**
   * Returns a special value that can be used with set() or update() that tells the server to remove
   * the given elements from any array value that already exists on the server. All instances of
   * each element specified will be removed from the array. If the field being modified is not
   * already an array it will be overwritten with an empty array.
   *
   * @param elements The elements to remove from the array.
   * @return The FieldValue sentinel for use in a call to set() or update().
   */
  @Nonnull
  public static FieldValue arrayRemove(@Nonnull Object... elements) {
    Preconditions.checkArgument(elements.length > 0, "arrayRemove() expects at least 1 element");
    return new ArrayRemoveFieldValue(Arrays.asList(elements));
  }

  /** Whether this FieldTransform should be included in the document mask. */
  abstract boolean includeInDocumentMask();

  /** Whether this FieldTransform should be included in the list of document transforms. */
  abstract boolean includeInDocumentTransform();

  /** The name of the method that returned this FieldValue instance. */
  abstract String getMethodName();

  /** Generates the field transform proto. */
  abstract FieldTransform toProto(FieldPath path);

  /**
   * Returns true if this FieldValue is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this FieldValue is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
