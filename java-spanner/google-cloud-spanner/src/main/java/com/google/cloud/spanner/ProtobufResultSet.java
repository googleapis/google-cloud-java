/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.spanner;

import com.google.api.core.InternalApi;
import com.google.protobuf.Value;

/** Interface for {@link ResultSet}s that can return a protobuf value. */
@InternalApi
public interface ProtobufResultSet extends ResultSet {

  /** Returns true if the protobuf value for the given column is still available. */
  boolean canGetProtobufValue(int columnIndex);

  /**
   * Returns the column value as a protobuf value.
   *
   * <p>This is an internal method not intended for external usage.
   *
   * <p>This method may only be called before the column value has been decoded to a plain Java
   * object. This means that the {@link DecodeMode} that is used for the {@link ResultSet} must be
   * one of {@link DecodeMode#LAZY_PER_ROW} and {@link DecodeMode#LAZY_PER_COL}, and that the
   * corresponding {@link ResultSet#getValue(int)}, {@link ResultSet#getBoolean(int)}, ... method
   * may not yet have been called for the column.
   */
  @InternalApi
  Value getProtobufValue(int columnIndex);
}
