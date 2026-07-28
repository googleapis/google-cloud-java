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

package com.google.cloud.firestore.pipeline.expressions;

import com.google.api.core.InternalApi;
import com.google.firestore.v1.Value;

@InternalApi
class BooleanField extends BooleanExpression {
  private final Field field;

  BooleanField(Field field) {
    this.field = field;
  }

  @Override
  Value toProto() {
    return field.toProto();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    if (o instanceof BooleanField) {
      return field.equals(((BooleanField) o).field);
    }
    if (o instanceof Field) {
      return field.equals(o);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return field.hashCode();
  }
}
