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

  private Blob(ByteString byteString) {
    this.byteString = byteString;
  }

  /**
   * Creates a new Blob instance from the provided ByteString.
   *
   * @param byteString The byteString to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob fromByteString(@Nonnull ByteString byteString) {
    return new Blob(byteString);
  }

  /**
   * Creates a new Blob instance from the provided bytes. Makes a copy of the bytes passed in.
   *
   * @param bytes The bytes to use for this Blob instance.
   * @return The new Blob instance
   */
  @Nonnull
  public static Blob fromBytes(@Nonnull byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes));
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Blob blob = (Blob) o;
    return Objects.equals(byteString, blob.byteString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(byteString);
  }
}
