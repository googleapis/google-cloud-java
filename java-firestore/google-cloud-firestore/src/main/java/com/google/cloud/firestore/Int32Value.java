/*
 * Copyright 2025 Google LLC
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

import com.google.firestore.v1.MapValue;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;

/** Represents a 32-bit integer type in Firestore documents. */
public class Int32Value implements Serializable {
  private static final long serialVersionUID = -2744130750746368548L;
  public final int value;

  public Int32Value(int value) {
    this.value = value;
  }

  MapValue toProto() {
    return UserDataConverter.encodeInt32Value(value);
  }

  /**
   * Returns true if this Int32Value is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this BsonObjectId is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    return this == obj || this.value == ((Int32Value) obj).value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @Nonnull
  @Override
  public String toString() {
    return "Int32Value{value=" + this.value + "}";
  }
}
