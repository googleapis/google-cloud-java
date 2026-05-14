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

/** Represents a 128-bit decimal type in Firestore documents. */
public class Decimal128Value implements Serializable {
  private static final long serialVersionUID = 8091951856970036899L;

  public final String stringValue;
  final Quadruple value;

  public Decimal128Value(String val) {
    this.stringValue = val;
    this.value = Quadruple.fromString(val);
  }

  MapValue toProto() {
    return UserDataConverter.encodeDecimal128Value(stringValue);
  }

  /**
   * Returns true if this Decimal128Value is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this Decimal128Value is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    Quadruple lhs = this.value;
    Quadruple rhs = ((Decimal128Value) obj).value;

    // Firestore considers +0 and -0 to be equal, but `Quadruple.compareTo()` does not.
    if (lhs.isZero() && rhs.isZero()) return true;

    return this == obj || lhs.compareTo(rhs) == 0;
  }

  @Override
  public int hashCode() {
    // Since +0 and -0 are considered equal, they should have the same hash code.
    Quadruple quadruple =
        (this.value.compareTo(Quadruple.NEGATIVE_ZERO) == 0) ? Quadruple.POSITIVE_ZERO : this.value;

    return Objects.hash(quadruple);
  }

  @Nonnull
  @Override
  public String toString() {
    return "Decimal128Value{value=" + this.stringValue + "}";
  }
}
