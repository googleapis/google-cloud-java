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

/** Specifies how and when to decode a value from protobuf to a plain Java object. */
public enum DecodeMode {
  /**
   * Decodes all columns of a row directly when a {@link ResultSet} is advanced to the next row with
   * {@link ResultSet#next()}
   */
  DIRECT,
  /**
   * Decodes all columns of a row the first time a {@link ResultSet} value is retrieved from the
   * row.
   */
  LAZY_PER_ROW,
  /**
   * Decodes a columns of a row the first time the value of that column is retrieved from the row.
   */
  LAZY_PER_COL,
}
