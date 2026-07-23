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

/** Represents the Firestore "Max Key" data type. */
public class MaxKey implements Serializable {
  private static final long serialVersionUID = -3351949427549917324L;
  private static final MaxKey INSTANCE = new MaxKey();

  private MaxKey() {}

  @Nonnull
  public static MaxKey instance() {
    return INSTANCE;
  }

  MapValue toProto() {
    return UserDataConverter.encodeMaxKey();
  }

  /**
   * Returns true if this MaxKey is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this MaxKey is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    return this == obj;
  }

  @Override
  public int hashCode() {
    return Objects.hash(serialVersionUID);
  }

  @Nonnull
  @Override
  public String toString() {
    return "MaxKey{}";
  }
}
