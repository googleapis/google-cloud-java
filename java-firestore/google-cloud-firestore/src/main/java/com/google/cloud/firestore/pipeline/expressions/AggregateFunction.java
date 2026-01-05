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
import com.google.firestore.v1.Value;
import java.util.stream.Collectors;

/** A class that represents an aggregate function. */
@BetaApi
public class AggregateFunction {
  private final String name;
  private final ImmutableList<Expression> params;

  private AggregateFunction(String name, Expression... params) {
    this.name = name;
    this.params = ImmutableList.copyOf(params);
  }

  private AggregateFunction(String name, String fieldName) {
    this(name, Expression.field(fieldName));
  }

  /**
   * Creates a raw aggregation function.
   *
   * <p>This method provides a way to call aggregation functions that are supported by the Firestore
   * backend but that are not available as specific factory methods in this class.
   *
   * @param name The name of the aggregation function.
   * @param expr The expressions to pass as arguments to the function.
   * @return A new {@link AggregateFunction} for the specified function.
   */
  @BetaApi
  public static AggregateFunction rawAggregate(String name, Expression... expr) {
    return new AggregateFunction(name, expr);
  }

  /**
   * Creates an aggregation that counts the total number of stage inputs.
   *
   * @return A new {@link AggregateFunction} representing the countAll aggregation.
   */
  @BetaApi
  public static AggregateFunction countAll() {
    return new AggregateFunction("count");
  }

  /**
   * Creates an aggregation that counts the number of stage inputs where the input field exists.
   *
   * @param fieldName The name of the field to count.
   * @return A new {@link AggregateFunction} representing the 'count' aggregation.
   */
  @BetaApi
  public static AggregateFunction count(String fieldName) {
    return new AggregateFunction("count", fieldName);
  }

  /**
   * Creates an aggregation that counts the number of stage inputs with valid evaluations of the
   * provided {@code expression}.
   *
   * @param expression The expression to count.
   * @return A new {@link AggregateFunction} representing the 'count' aggregation.
   */
  @BetaApi
  public static AggregateFunction count(Expression expression) {
    return new AggregateFunction("count", expression);
  }

  /**
   * Creates an aggregation that counts the number of distinct values of a field across multiple
   * stage inputs.
   *
   * @param fieldName The name of the field to count the distinct values of.
   * @return A new {@link AggregateFunction} representing the count distinct aggregation.
   */
  @BetaApi
  public static AggregateFunction countDistinct(String fieldName) {
    return new AggregateFunction("count_distinct", fieldName);
  }

  /**
   * Creates an aggregation that counts the number of distinct values of an expression across
   * multiple stage inputs.
   *
   * @param expression The expression to count the distinct values of.
   * @return A new {@link AggregateFunction} representing the count distinct aggregation.
   */
  @BetaApi
  public static AggregateFunction countDistinct(Expression expression) {
    return new AggregateFunction("count_distinct", expression);
  }

  /**
   * Creates an aggregation that counts the number of stage inputs where the provided boolean
   * expression evaluates to true.
   *
   * @param condition The boolean expression to evaluate on each input.
   * @return A new {@link AggregateFunction} representing the count aggregation.
   */
  @BetaApi
  public static AggregateFunction countIf(BooleanExpression condition) {
    return new AggregateFunction("count_if", condition);
  }

  /**
   * Creates an aggregation that calculates the sum of a field's values across multiple stage
   * inputs.
   *
   * @param fieldName The name of the field containing numeric values to sum up.
   * @return A new {@link AggregateFunction} representing the sum aggregation.
   */
  @BetaApi
  public static AggregateFunction sum(String fieldName) {
    return new AggregateFunction("sum", fieldName);
  }

  /**
   * Creates an aggregation that calculates the sum of values from an expression across multiple
   * stage inputs.
   *
   * @param expression The expression to sum up.
   * @return A new {@link AggregateFunction} representing the sum aggregation.
   */
  @BetaApi
  public static AggregateFunction sum(Expression expression) {
    return new AggregateFunction("sum", expression);
  }

  /**
   * Creates an aggregation that calculates the average (mean) of a field's values across multiple
   * stage inputs.
   *
   * @param fieldName The name of the field containing numeric values to average.
   * @return A new {@link AggregateFunction} representing the average aggregation.
   */
  @BetaApi
  public static AggregateFunction average(String fieldName) {
    return new AggregateFunction("average", fieldName);
  }

  /**
   * Creates an aggregation that calculates the average (mean) of values from an expression across
   * multiple stage inputs.
   *
   * @param expression The expression representing the values to average.
   * @return A new {@link AggregateFunction} representing the average aggregation.
   */
  @BetaApi
  public static AggregateFunction average(Expression expression) {
    return new AggregateFunction("average", expression);
  }

  /**
   * Creates an aggregation that finds the minimum value of a field across multiple stage inputs.
   *
   * @param fieldName The name of the field to find the minimum value of.
   * @return A new {@link AggregateFunction} representing the minimum aggregation.
   */
  @BetaApi
  public static AggregateFunction minimum(String fieldName) {
    return new AggregateFunction("minimum", fieldName);
  }

  /**
   * Creates an aggregation that finds the minimum value of an expression across multiple stage
   * inputs.
   *
   * @param expression The expression to find the minimum value of.
   * @return A new {@link AggregateFunction} representing the minimum aggregation.
   */
  @BetaApi
  public static AggregateFunction minimum(Expression expression) {
    return new AggregateFunction("minimum", expression);
  }

  /**
   * Creates an aggregation that finds the maximum value of a field across multiple stage inputs.
   *
   * @param fieldName The name of the field to find the maximum value of.
   * @return A new {@link AggregateFunction} representing the maximum aggregation.
   */
  @BetaApi
  public static AggregateFunction maximum(String fieldName) {
    return new AggregateFunction("maximum", fieldName);
  }

  /**
   * Creates an aggregation that finds the maximum value of an expression across multiple stage
   * inputs.
   *
   * @param expression The expression to find the maximum value of.
   * @return A new {@link AggregateFunction} representing the maximum aggregation.
   */
  @BetaApi
  public static AggregateFunction maximum(Expression expression) {
    return new AggregateFunction("maximum", expression);
  }

  /**
   * Assigns an alias to this aggregate.
   *
   * @param alias The alias to assign to this aggregate.
   * @return A new {@link AliasedAggregate} that wraps this aggregate and associates it with the
   *     provided alias.
   */
  @BetaApi
  public AliasedAggregate as(String alias) {
    return new AliasedAggregate(alias, this);
  }

  Value toProto() {
    return Value.newBuilder()
        .setFunctionValue(
            com.google.firestore.v1.Function.newBuilder()
                .setName(this.name)
                .addAllArgs(
                    this.params.stream()
                        .map(FunctionUtils::exprToValue)
                        .collect(Collectors.toList())))
        .build();
  }
}
