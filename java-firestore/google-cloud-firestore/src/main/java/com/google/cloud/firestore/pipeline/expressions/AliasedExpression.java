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

import com.google.api.core.InternalApi;
import com.google.firestore.v1.Value;

@InternalApi
public final class AliasedExpression implements Selectable {

  private final String alias;
  private final Expression expr;

  @InternalApi
  AliasedExpression(Expression expr, String alias) {
    this.expr = expr;
    this.alias = alias;
  }

  @InternalApi
  public String getAlias() {
    return alias;
  }

  @InternalApi
  public Expression getExpr() {
    return expr;
  }

  /**
   * Creates a new {@link AliasedExpression} that wraps this expression and associates it with the
   * given alias.
   *
   * <p>Aliases are useful for renaming fields in the output of a stage or for giving meaningful
   * names to calculated values.
   *
   * @param alias The alias to assign to this expression.
   * @return A new {@link Selectable} that wraps this expression and associates it with the provided
   *     alias.
   */
  public Selectable as(String alias) {
    return new AliasedExpression(this.expr, alias);
  }

  Value toProto() {
    return expr.toProto();
  }
}
