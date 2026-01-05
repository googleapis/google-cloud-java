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

import com.google.api.core.BetaApi;
import com.google.common.collect.ImmutableList;

@BetaApi
public abstract class BooleanExpression extends Expression {
  BooleanExpression() {}

  /**
   * Creates an aggregation that counts the number of stage inputs where the this boolean expression
   * evaluates to true.
   *
   * @return A new {@link AggregateFunction} representing the count aggregation.
   */
  @BetaApi
  public AggregateFunction countIf() {
    return AggregateFunction.countIf(this);
  }

  /**
   * Creates a conditional expression that evaluates to a {@code thenExpr} expression if this
   * condition is true or an {@code elseExpr} expression if the condition is false.
   *
   * @param thenExpr The expression to evaluate if the condition is true.
   * @param elseExpr The expression to evaluate if the condition is false.
   * @return A new {@link Expression} representing the conditional operation.
   */
  @BetaApi
  public final Expression conditional(Expression thenExpr, Expression elseExpr) {
    return conditional((BooleanExpression) this, thenExpr, elseExpr);
  }

  /**
   * Creates a conditional expression that evaluates to a {@code thenValue} if this condition is
   * true or an {@code elseValue} if the condition is false.
   *
   * @param thenValue Value if the condition is true.
   * @param elseValue Value if the condition is false.
   * @return A new {@link Expression} representing the conditional operation.
   */
  @BetaApi
  public final Expression conditional(Object thenValue, Object elseValue) {
    return conditional((BooleanExpression) this, thenValue, elseValue);
  }

  /**
   * Creates an expression that returns the {@code catchExpr} argument if there is an error, else
   * return the result of this expression.
   *
   * @param catchExpr The catch expression that will be evaluated and returned if the this
   *     expression produces an error.
   * @return A new {@link Expression} representing the ifError operation.
   */
  @BetaApi
  public final BooleanExpression ifError(BooleanExpression catchExpr) {
    return ifError(this, catchExpr);
  }

  /**
   * Creates an expression that negates this boolean expression.
   *
   * @return A new {@link BooleanExpression} representing the not operation.
   */
  @BetaApi
  public final BooleanExpression not() {
    return not(this);
  }

  /**
   * Creates a 'raw' boolean function expression. This is useful if the expression is available in
   * the backend, but not yet in the current version of the SDK yet.
   *
   * @param name The name of the raw function.
   * @param params The expressions to be passed as arguments to the function.
   * @return A new [BooleanExpression] representing the raw function.
   */
  public static BooleanExpression rawFunction(String name, Expression... params) {
    return new BooleanFunctionExpression(name, ImmutableList.copyOf(params));
  }
}
