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

/** Represents a BSON Timestamp type in Firestore documents. */
public class BsonTimestamp implements Serializable {
  private static final long serialVersionUID = -1693962317170687337L;
  public final long seconds;
  public final long increment;

  /**
   * Constructor that creates a new BSON Timestamp value with the given values.
   *
   * @param seconds An unsigned 32-bit integer value stored as long representing the seconds.
   * @param increment An unsigned 32-bit integer value stored as long representing the increment.
   */
  public BsonTimestamp(long seconds, long increment) {
    if (seconds < 0 || seconds > 4294967295L) {
      throw new IllegalArgumentException(
          "BsonTimestamp 'seconds' must be in the range of a 32-bit unsigned integer.");
    }
    if (increment < 0 || increment > 4294967295L) {
      throw new IllegalArgumentException(
          "BsonTimestamp 'increment' must be in the range of a 32-bit unsigned integer.");
    }
    this.seconds = seconds;
    this.increment = increment;
  }

  MapValue toProto() {
    return UserDataConverter.encodeBsonTimestamp(seconds, increment);
  }

  /**
   * Returns true if this BsonTimestamp is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this BsonTimestamp is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    BsonTimestamp other = (BsonTimestamp) obj;
    return this.seconds == other.seconds && this.increment == other.increment;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.seconds, this.increment);
  }

  @Nonnull
  @Override
  public String toString() {
    return "BsonTimestamp{seconds=" + this.seconds + ", increment=" + this.increment + "}";
  }
}
