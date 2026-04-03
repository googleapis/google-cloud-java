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

package com.google.cloud.firestore.pipeline.expressions;

import com.google.api.core.BetaApi;

@BetaApi
public interface Selectable {
  /**
   * Converts an object to a {@link Selectable}.
   *
   * @param o The object to convert. Supported types: {@link Selectable}, {@link String}, {@link
   *     com.google.cloud.firestore.FieldPath}.
   * @return The converted {@link Selectable}.
   */
  @com.google.api.core.InternalApi
  static Selectable toSelectable(Object o) {
    if (o instanceof Selectable) {
      return (Selectable) o;
    } else if (o instanceof String) {
      return Expression.field((String) o);
    } else if (o instanceof com.google.cloud.firestore.FieldPath) {
      return Expression.field((com.google.cloud.firestore.FieldPath) o);
    } else {
      throw new IllegalArgumentException("Unknown Selectable type: " + o.getClass().getName());
    }
  }
}
