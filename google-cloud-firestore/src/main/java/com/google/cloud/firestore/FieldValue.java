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

import javax.annotation.Nonnull;

/** Sentinel values that can be used when writing document fields with set() or update(). */
public abstract class FieldValue {

  static final Object SERVER_TIMESTAMP_SENTINEL = new Object();
  static final Object DELETE_SENTINEL = new Object();

  private FieldValue() {}

  /**
   * Returns a sentinel used with set() or update() to include a server-generated timestamp in the
   * written data.
   */
  @Nonnull
  public static Object serverTimestamp() {
    return SERVER_TIMESTAMP_SENTINEL;
  }

  /** Returns a sentinel used with update() to mark a field for deletion. */
  @Nonnull
  public static Object delete() {
    return DELETE_SENTINEL;
  }

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
