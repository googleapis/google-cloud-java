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

import com.google.protobuf.ByteString;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;

/** Immutable class representing an array of bytes in Firestore. */
public final class Blob implements Serializable {

  private static final long serialVersionUID = 1441087101882481208L;

  private final ByteString byteString;
  private final int subtype;

  private Blob(ByteString byteString, int subtype) {
    if (subtype < 0 || subtype > 255) {
      throw new IllegalArgumentException(
          "The subtype for Blob must be a value in the inclusive [0, 255] range.");
    }
    this.byteString = byteString;
    this.subtype = subtype;
  }

  /**
   * Creates a new Blob instance from the provided ByteString. Defaults to subtype 0 and native
   * representation.
   *
   * @param byteString The byteString to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob fromByteString(@Nonnull ByteString byteString) {
    return new Blob(byteString, 0);
  }

  /**
   * Creates a new Blob instance from the provided bytes. Makes a copy of the bytes passed in.
   * Defaults to subtype 0 and native representation.
   *
   * @param bytes The bytes to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob fromBytes(@Nonnull byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes), 0);
  }

  /**
   * Creates a new Blob instance representing a BSON binary data type. Sets subtype to 0 and
   * representation to BSON.
   *
   * @param bytes The bytes to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob createBsonBinary(@Nonnull byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes), 0);
  }

  /**
   * Creates a new Blob instance representing a BSON binary data type. Sets subtype to 0 and
   * representation to BSON.
   *
   * @param data The ByteString to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob createBsonBinary(@Nonnull ByteString data) {
    return new Blob(data, 0);
  }

  /**
   * Creates a new Blob instance representing a BSON binary data type with a specific subtype. Sets
   * representation to BSON.
   *
   * @param subtype The subtype to use for this instance.
   * @param bytes The bytes to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob createBsonBinary(int subtype, @Nonnull byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes), subtype);
  }

  /**
   * Creates a new Blob instance representing a BSON binary data type with a specific subtype. Sets
   * representation to BSON.
   *
   * @param subtype The subtype to use for this instance.
   * @param data The ByteString to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob createBsonBinary(int subtype, @Nonnull ByteString data) {
    return new Blob(data, subtype);
  }

  /**
   * Returns the backing data as a ByteString.
   *
   * @return The bytes of this blob as a byteString
   */
  @Nonnull
  public ByteString toByteString() {
    return byteString;
  }

  /**
   * Returns a copy of the underlying bytes as a byte[] array.
   *
   * @return The bytes of this blob as a byte[] array.
   */
  @Nonnull
  public byte[] toBytes() {
    return byteString.toByteArray();
  }

  /**
   * Returns the subtype of this binary data. Defaults to 0 for both native binary and BSON binary
   * if not specified.
   *
   * @return The subtype of the binary data.
   */
  public int subtype() {
    return this.subtype;
  }

  /**
   * Returns true if this Blob is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this Blob is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Blob blob = (Blob) obj;
    return this.subtype == blob.subtype && Objects.equals(byteString, blob.byteString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(byteString, subtype);
  }

  @Nonnull
  @Override
  public String toString() {
    String dataStr;
    if (this.byteString.size() <= 100) {
      dataStr =
          com.google.common.io.BaseEncoding.base16()
              .lowerCase()
              .encode(this.byteString.toByteArray());
    } else {
      dataStr =
          com.google.common.io.BaseEncoding.base16()
                  .lowerCase()
                  .encode(this.byteString.substring(0, 20).toByteArray())
              + "... (size="
              + this.byteString.size()
              + ")";
    }
    return "Blob{subtype=" + this.subtype + ", data=" + dataStr + "}";
  }
}
