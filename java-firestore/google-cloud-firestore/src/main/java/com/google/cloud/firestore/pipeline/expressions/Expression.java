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
import com.google.api.core.InternalApi;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.Blob;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.FieldPath;
import com.google.cloud.firestore.FieldValue;
import com.google.cloud.firestore.GeoPoint;
import com.google.cloud.firestore.VectorValue;
import com.google.common.collect.ImmutableList;
import com.google.firestore.v1.Value;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Represents an expression that can be evaluated to a value within the execution of a {@link
 * com.google.cloud.firestore.Pipeline}.
 *
 * <p>Expressions are the building blocks for creating complex queries and transformations in
 * Firestore pipelines. They can represent:
 *
 * <ul>
 *   <li>**Field references:** Access values from document fields.
 *   <li>**Literals:** Represent constant values (strings, numbers, booleans).
 *   <li>**Function calls:** Apply functions to one or more expressions.
 * </ul>
 *
 * <p>The `Expression` class provides a fluent API for building expressions. You can chain together
 * method calls to create complex expressions.
 */
@BetaApi
public abstract class Expression {

  /** Constructor is package-private to prevent extension. */
  Expression() {}

  private static Expression toExprOrConstant(Object o) {
    return o instanceof Expression ? (Expression) o : new Constant(o);
  }

  private static ImmutableList<Expression> toArrayOfExprOrConstant(Object... others) {
    return Arrays.stream(others)
        .map(Expression::toExprOrConstant)
        .collect(ImmutableList.toImmutableList());
  }

  @InternalApi
  abstract Value toProto();

  // Constants
  /**
   * Create a constant for a {@link String} value.
   *
   * @param value The {@link String} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(String value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link Number} value.
   *
   * @param value The {@link Number} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(Number value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link Date} value.
   *
   * @param value The {@link Date} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(Date value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link Timestamp} value.
   *
   * @param value The {@link Timestamp} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(Timestamp value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link Boolean} value.
   *
   * @param value The {@link Boolean} value.
   * @return A new {@link BooleanExpression} constant instance.
   */
  @BetaApi
  public static BooleanExpression constant(Boolean value) {
    return equal(new Constant(value), true);
  }

  /**
   * Create a constant for a {@link GeoPoint} value.
   *
   * @param value The {@link GeoPoint} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(GeoPoint value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link Blob} value.
   *
   * @param value The {@link Blob} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(Blob value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link DocumentReference} value.
   *
   * @param value The {@link DocumentReference} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(DocumentReference value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a bytes value.
   *
   * @param value The bytes value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(byte[] value) {
    return new Constant(value);
  }

  /**
   * Create a constant for a {@link VectorValue} value.
   *
   * @param value The {@link VectorValue} value.
   * @return A new {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression constant(VectorValue value) {
    return new Constant(value);
  }

  /**
   * Constant for a null value.
   *
   * @return An {@link Expression} constant instance.
   */
  @BetaApi
  public static Expression nullValue() {
    return Constant.NULL;
  }

  // Field Reference
  /**
   * Creates a {@link Field} instance representing the field at the given path.
   *
   * <p>The path can be a simple field name (e.g., "name") or a dot-separated path to a nested field
   * (e.g., "address.city").
   *
   * @param path The path to the field.
   * @return A new {@link Field} instance representing the specified path.
   */
  @BetaApi
  public static Field field(String path) {
    return Field.ofUserPath(path);
  }

  /**
   * Creates a {@link Field} instance representing the field at the given path.
   *
   * <p>The path can be a simple field name (e.g., "name") or a dot-separated path to a nested field
   * (e.g., "address.city").
   *
   * @param fieldPath The {@link FieldPath} to the field.
   * @return A new {@link Field} instance representing the specified path.
   */
  @BetaApi
  public static Field field(FieldPath fieldPath) {
    return Field.ofUserPath(fieldPath.toString());
  }

  /**
   * Creates an expression that returns the current timestamp.
   *
   * @return A new {@link Expression} representing the current timestamp.
   */
  @BetaApi
  public static Expression currentTimestamp() {
    return new FunctionExpression("current_timestamp", ImmutableList.of());
  }

  /**
   * Creates an expression that returns a default value if an expression evaluates to an absent
   * value.
   *
   * @param ifExpr The expression to check.
   * @param elseExpr The default value.
   * @return A new {@link Expression} representing the ifAbsent operation.
   */
  @BetaApi
  public static Expression ifAbsent(Expression ifExpr, Expression elseExpr) {
    return new FunctionExpression("if_absent", ImmutableList.of(ifExpr, elseExpr));
  }

  /**
   * Creates an expression that returns a default value if an expression evaluates to an absent
   * value.
   *
   * @param ifExpr The expression to check.
   * @param elseValue The default value.
   * @return A new {@link Expression} representing the ifAbsent operation.
   */
  @BetaApi
  public static Expression ifAbsent(Expression ifExpr, Object elseValue) {
    return ifAbsent(ifExpr, toExprOrConstant(elseValue));
  }

  /**
   * Creates an expression that returns a default value if a field is absent.
   *
   * @param ifFieldName The field to check.
   * @param elseExpr The default value.
   * @return A new {@link Expression} representing the ifAbsent operation.
   */
  @BetaApi
  public static Expression ifAbsent(String ifFieldName, Expression elseExpr) {
    return ifAbsent(field(ifFieldName), elseExpr);
  }

  /**
   * Creates an expression that returns a default value if a field is absent.
   *
   * @param ifFieldName The field to check.
   * @param elseValue The default value.
   * @return A new {@link Expression} representing the ifAbsent operation.
   */
  @BetaApi
  public static Expression ifAbsent(String ifFieldName, Object elseValue) {
    return ifAbsent(field(ifFieldName), toExprOrConstant(elseValue));
  }

  /**
   * Creates an expression that joins the elements of an array into a string.
   *
   * @param arrayExpression The expression representing the array.
   * @param delimiter The delimiter to use.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public static Expression join(Expression arrayExpression, String delimiter) {
    return new FunctionExpression("join", ImmutableList.of(arrayExpression, constant(delimiter)));
  }

  /**
   * Creates an expression that joins the elements of an array into a string.
   *
   * @param arrayExpression The expression representing the array.
   * @param delimiterExpression The expression representing the delimiter.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public static Expression join(Expression arrayExpression, Expression delimiterExpression) {
    return new FunctionExpression("join", ImmutableList.of(arrayExpression, delimiterExpression));
  }

  /**
   * Creates an expression that joins the elements of an array into a string.
   *
   * @param arrayFieldName The field name of the array.
   * @param delimiter The delimiter to use.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public static Expression join(String arrayFieldName, String delimiter) {
    return join(field(arrayFieldName), constant(delimiter));
  }

  /**
   * Creates an expression that joins the elements of an array into a string.
   *
   * @param arrayFieldName The field name of the array.
   * @param delimiterExpression The expression representing the delimiter.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public static Expression join(String arrayFieldName, Expression delimiterExpression) {
    return join(field(arrayFieldName), delimiterExpression);
  }

  // Generic Function
  /**
   * Creates a generic function expression that is not yet implemented.
   *
   * @param name The name of the generic function.
   * @param expr The expressions to be passed as arguments to the function.
   * @return A new {@link Expression} representing the generic function.
   */
  @BetaApi
  public static Expression rawExpression(String name, Expression... expr) {
    return new FunctionExpression(name, ImmutableList.copyOf(expr));
  }

  // Logical Operators
  /**
   * Creates an expression that performs a logical 'AND' operation.
   *
   * @param condition The first {@link BooleanExpression}.
   * @param conditions Additional {@link BooleanExpression}s.
   * @return A new {@link BooleanExpression} representing the logical 'AND' operation.
   */
  @BetaApi
  public static BooleanExpression and(
      BooleanExpression condition, BooleanExpression... conditions) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(condition);
    builder.add(conditions);
    return new BooleanFunctionExpression("and", builder.build());
  }

  /**
   * Creates an expression that performs a logical 'OR' operation.
   *
   * @param condition The first {@link BooleanExpression}.
   * @param conditions Additional {@link BooleanExpression}s.
   * @return A new {@link BooleanExpression} representing the logical 'OR' operation.
   */
  @BetaApi
  public static BooleanExpression or(BooleanExpression condition, BooleanExpression... conditions) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(condition);
    builder.add(conditions);
    return new BooleanFunctionExpression("or", builder.build());
  }

  /**
   * Creates an expression that performs a logical 'XOR' operation.
   *
   * @param condition The first {@link BooleanExpression}.
   * @param conditions Additional {@link BooleanExpression}s.
   * @return A new {@link BooleanExpression} representing the logical 'XOR' operation.
   */
  @BetaApi
  public static BooleanExpression xor(
      BooleanExpression condition, BooleanExpression... conditions) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(condition);
    builder.add(conditions);
    return new BooleanFunctionExpression("xor", builder.build());
  }

  /**
   * Creates an expression that negates a boolean expression.
   *
   * @param condition The boolean expression to negate.
   * @return A new {@link BooleanExpression} representing the not operation.
   */
  @BetaApi
  public static BooleanExpression not(BooleanExpression condition) {
    return new BooleanFunctionExpression("not", condition);
  }

  // Arithmetic Operators
  /**
   * Creates an expression that adds numeric expressions.
   *
   * @param first Numeric expression to add.
   * @param second Numeric expression to add.
   * @return A new {@link Expression} representing the addition operation.
   */
  @BetaApi
  public static Expression add(Expression first, Expression second) {
    return new FunctionExpression("add", ImmutableList.of(first, second));
  }

  /**
   * Creates an expression that adds numeric expressions with a constant.
   *
   * @param first Numeric expression to add.
   * @param second Constant to add.
   * @return A new {@link Expression} representing the addition operation.
   */
  @BetaApi
  public static Expression add(Expression first, Number second) {
    return add(first, constant(second));
  }

  /**
   * Creates an expression that adds a numeric field with a numeric expression.
   *
   * @param fieldName Numeric field to add.
   * @param second Numeric expression to add to field value.
   * @return A new {@link Expression} representing the addition operation.
   */
  @BetaApi
  public static Expression add(String fieldName, Expression second) {
    return add(field(fieldName), second);
  }

  /**
   * Creates an expression that adds a numeric field with constant.
   *
   * @param fieldName Numeric field to add.
   * @param second Constant to add.
   * @return A new {@link Expression} representing the addition operation.
   */
  @BetaApi
  public static Expression add(String fieldName, Number second) {
    return add(field(fieldName), constant(second));
  }

  /**
   * Creates an expression that subtracts two expressions.
   *
   * @param minuend Numeric expression to subtract from.
   * @param subtrahend Numeric expression to subtract.
   * @return A new {@link Expression} representing the subtract operation.
   */
  @BetaApi
  public static Expression subtract(Expression minuend, Expression subtrahend) {
    return new FunctionExpression("subtract", ImmutableList.of(minuend, subtrahend));
  }

  /**
   * Creates an expression that subtracts a constant value from a numeric expression.
   *
   * @param minuend Numeric expression to subtract from.
   * @param subtrahend Constant to subtract.
   * @return A new {@link Expression} representing the subtract operation.
   */
  @BetaApi
  public static Expression subtract(Expression minuend, Number subtrahend) {
    return subtract(minuend, constant(subtrahend));
  }

  /**
   * Creates an expression that subtracts a numeric expressions from numeric field.
   *
   * @param fieldName Numeric field to subtract from.
   * @param subtrahend Numeric expression to subtract.
   * @return A new {@link Expression} representing the subtract operation.
   */
  @BetaApi
  public static Expression subtract(String fieldName, Expression subtrahend) {
    return subtract(field(fieldName), subtrahend);
  }

  /**
   * Creates an expression that subtracts a constant from numeric field.
   *
   * @param fieldName Numeric field to subtract from.
   * @param subtrahend Constant to subtract.
   * @return A new {@link Expression} representing the subtract operation.
   */
  @BetaApi
  public static Expression subtract(String fieldName, Number subtrahend) {
    return subtract(field(fieldName), constant(subtrahend));
  }

  /**
   * Creates an expression that multiplies numeric expressions.
   *
   * @param first Numeric expression to multiply.
   * @param second Numeric expression to multiply.
   * @return A new {@link Expression} representing the multiplication operation.
   */
  @BetaApi
  public static Expression multiply(Expression first, Expression second) {
    return new FunctionExpression("multiply", ImmutableList.of(first, second));
  }

  /**
   * Creates an expression that multiplies numeric expressions with a constant.
   *
   * @param first Numeric expression to multiply.
   * @param second Constant to multiply.
   * @return A new {@link Expression} representing the multiplication operation.
   */
  @BetaApi
  public static Expression multiply(Expression first, Number second) {
    return multiply(first, constant(second));
  }

  /**
   * Creates an expression that multiplies a numeric field with a numeric expression.
   *
   * @param fieldName Numeric field to multiply.
   * @param second Numeric expression to multiply.
   * @return A new {@link Expression} representing the multiplication operation.
   */
  @BetaApi
  public static Expression multiply(String fieldName, Expression second) {
    return multiply(field(fieldName), second);
  }

  /**
   * Creates an expression that multiplies a numeric field with a constant.
   *
   * @param fieldName Numeric field to multiply.
   * @param second Constant to multiply.
   * @return A new {@link Expression} representing the multiplication operation.
   */
  @BetaApi
  public static Expression multiply(String fieldName, Number second) {
    return multiply(field(fieldName), constant(second));
  }

  /**
   * Creates an expression that divides two numeric expressions.
   *
   * @param dividend The numeric expression to be divided.
   * @param divisor The numeric expression to divide by.
   * @return A new {@link Expression} representing the division operation.
   */
  @BetaApi
  public static Expression divide(Expression dividend, Expression divisor) {
    return new FunctionExpression("divide", ImmutableList.of(dividend, divisor));
  }

  /**
   * Creates an expression that divides a numeric expression by a constant.
   *
   * @param dividend The numeric expression to be divided.
   * @param divisor The constant to divide by.
   * @return A new {@link Expression} representing the division operation.
   */
  @BetaApi
  public static Expression divide(Expression dividend, Number divisor) {
    return divide(dividend, constant(divisor));
  }

  /**
   * Creates an expression that divides numeric field by a numeric expression.
   *
   * @param fieldName The numeric field name to be divided.
   * @param divisor The numeric expression to divide by.
   * @return A new {@link Expression} representing the divide operation.
   */
  @BetaApi
  public static Expression divide(String fieldName, Expression divisor) {
    return divide(field(fieldName), divisor);
  }

  /**
   * Creates an expression that divides a numeric field by a constant.
   *
   * @param fieldName The numeric field name to be divided.
   * @param divisor The constant to divide by.
   * @return A new {@link Expression} representing the divide operation.
   */
  @BetaApi
  public static Expression divide(String fieldName, Number divisor) {
    return divide(field(fieldName), constant(divisor));
  }

  /**
   * Creates an expression that calculates the modulo (remainder) of dividing two numeric
   * expressions.
   *
   * @param dividend The numeric expression to be divided.
   * @param divisor The numeric expression to divide by.
   * @return A new {@link Expression} representing the modulo operation.
   */
  @BetaApi
  public static Expression mod(Expression dividend, Expression divisor) {
    return new FunctionExpression("mod", ImmutableList.of(dividend, divisor));
  }

  /**
   * Creates an expression that calculates the modulo (remainder) of dividing a numeric expression
   * by a constant.
   *
   * @param dividend The numeric expression to be divided.
   * @param divisor The constant to divide by.
   * @return A new {@link Expression} representing the modulo operation.
   */
  @BetaApi
  public static Expression mod(Expression dividend, Number divisor) {
    return mod(dividend, constant(divisor));
  }

  /**
   * Creates an expression that calculates the modulo (remainder) of dividing a numeric field by a
   * constant.
   *
   * @param fieldName The numeric field name to be divided.
   * @param divisor The numeric expression to divide by.
   * @return A new {@link Expression} representing the modulo operation.
   */
  @BetaApi
  public static Expression mod(String fieldName, Expression divisor) {
    return mod(field(fieldName), divisor);
  }

  /**
   * Creates an expression that calculates the modulo (remainder) of dividing a numeric field by a
   * constant.
   *
   * @param fieldName The numeric field name to be divided.
   * @param divisor The constant to divide by.
   * @return A new {@link Expression} representing the modulo operation.
   */
  @BetaApi
  public static Expression mod(String fieldName, Number divisor) {
    return mod(field(fieldName), constant(divisor));
  }

  // Comparison Operators
  /**
   * Creates an expression that checks if two expressions are equal.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the equality comparison.
   */
  @BetaApi
  public static BooleanExpression equal(Expression left, Expression right) {
    return new BooleanFunctionExpression("equal", left, right);
  }

  /**
   * Creates an expression that checks if an expression is equal to a constant value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the equality comparison.
   */
  @BetaApi
  public static BooleanExpression equal(Expression left, Object right) {
    return new BooleanFunctionExpression("equal", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is equal to an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the equality comparison.
   */
  @BetaApi
  public static BooleanExpression equal(String fieldName, Expression right) {
    return equal(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is equal to a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the equality comparison.
   */
  @BetaApi
  public static BooleanExpression equal(String fieldName, Object right) {
    return equal(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if two expressions are not equal.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the inequality comparison.
   */
  @BetaApi
  public static BooleanExpression notEqual(Expression left, Expression right) {
    return new BooleanFunctionExpression("not_equal", left, right);
  }

  /**
   * Creates an expression that checks if an expression is not equal to a constant value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the inequality comparison.
   */
  @BetaApi
  public static BooleanExpression notEqual(Expression left, Object right) {
    return new BooleanFunctionExpression("not_equal", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is not equal to an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the inequality comparison.
   */
  @BetaApi
  public static BooleanExpression notEqual(String fieldName, Expression right) {
    return notEqual(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is not equal to a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the inequality comparison.
   */
  @BetaApi
  public static BooleanExpression notEqual(String fieldName, Object right) {
    return notEqual(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if the first expression is greater than the second
   * expression.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the greater than comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThan(Expression left, Expression right) {
    return new BooleanFunctionExpression("greater_than", left, right);
  }

  /**
   * Creates an expression that checks if an expression is greater than a constant value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the greater than comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThan(Expression left, Object right) {
    return new BooleanFunctionExpression("greater_than", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is greater than an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the greater than comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThan(String fieldName, Expression right) {
    return greaterThan(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is greater than a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the greater than comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThan(String fieldName, Object right) {
    return greaterThan(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if the first expression is greater than or equal to the
   * second expression.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the greater than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThanOrEqual(Expression left, Expression right) {
    return new BooleanFunctionExpression("greater_than_or_equal", left, right);
  }

  /**
   * Creates an expression that checks if an expression is greater than or equal to a constant
   * value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the greater than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThanOrEqual(Expression left, Object right) {
    return new BooleanFunctionExpression("greater_than_or_equal", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is greater than or equal to an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the greater than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThanOrEqual(String fieldName, Expression right) {
    return greaterThanOrEqual(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is greater than or equal to a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the greater than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression greaterThanOrEqual(String fieldName, Object right) {
    return greaterThanOrEqual(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if the first expression is less than the second expression.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the less than comparison.
   */
  @BetaApi
  public static BooleanExpression lessThan(Expression left, Expression right) {
    return new BooleanFunctionExpression("less_than", left, right);
  }

  /**
   * Creates an expression that checks if an expression is less than a constant value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the less than comparison.
   */
  @BetaApi
  public static BooleanExpression lessThan(Expression left, Object right) {
    return new BooleanFunctionExpression("less_than", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is less than an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the less than comparison.
   */
  @BetaApi
  public static BooleanExpression lessThan(String fieldName, Expression right) {
    return lessThan(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is less than a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the less than comparison.
   */
  @BetaApi
  public static BooleanExpression lessThan(String fieldName, Object right) {
    return lessThan(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if the first expression is less than or equal to the second
   * expression.
   *
   * @param left The first expression.
   * @param right The second expression.
   * @return A new {@link BooleanExpression} representing the less than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression lessThanOrEqual(Expression left, Expression right) {
    return new BooleanFunctionExpression("less_than_or_equal", left, right);
  }

  /**
   * Creates an expression that checks if an expression is less than or equal to a constant value.
   *
   * @param left The expression.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the less than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression lessThanOrEqual(Expression left, Object right) {
    return new BooleanFunctionExpression("less_than_or_equal", left, toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if a field is less than or equal to an expression.
   *
   * @param fieldName The field name.
   * @param right The expression.
   * @return A new {@link BooleanExpression} representing the less than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression lessThanOrEqual(String fieldName, Expression right) {
    return lessThanOrEqual(field(fieldName), right);
  }

  /**
   * Creates an expression that checks if a field is less than or equal to a constant value.
   *
   * @param fieldName The field name.
   * @param right The constant value.
   * @return A new {@link BooleanExpression} representing the less than or equal to comparison.
   */
  @BetaApi
  public static BooleanExpression lessThanOrEqual(String fieldName, Object right) {
    return lessThanOrEqual(field(fieldName), toExprOrConstant(right));
  }

  /**
   * Creates an expression that checks if an {@code expression}, when evaluated, is equal to any of
   * the provided {@code values}.
   *
   * @param expression The expression whose results to compare.
   * @param values The values to check against.
   * @return A new {@link BooleanExpression} representing the 'IN' comparison.
   */
  @BetaApi
  public static BooleanExpression equalAny(Expression expression, List<Object> values) {
    return new BooleanFunctionExpression(
        "equal_any",
        expression,
        new FunctionExpression("array", toArrayOfExprOrConstant(values.toArray())));
  }

  /**
   * Creates an expression that checks if an {@code expression}, when evaluated, is equal to any of
   * the elements of {@code arrayExpression}.
   *
   * @param expression The expression whose results to compare.
   * @param arrayExpression An expression that evaluates to an array, whose elements to check for
   *     equality to the input.
   * @return A new {@link BooleanExpression} representing the 'IN' comparison.
   */
  @BetaApi
  public static BooleanExpression equalAny(Expression expression, Expression arrayExpression) {
    return new BooleanFunctionExpression("equal_any", expression, arrayExpression);
  }

  /**
   * Creates an expression that checks if a field's value is equal to any of the provided {@code
   * values}.
   *
   * @param fieldName The field to compare.
   * @param values The values to check against.
   * @return A new {@link BooleanExpression} representing the 'IN' comparison.
   */
  @BetaApi
  public static BooleanExpression equalAny(String fieldName, List<Object> values) {
    return equalAny(
        field(fieldName),
        new FunctionExpression("array", toArrayOfExprOrConstant(values.toArray())));
  }

  /**
   * Creates an expression that checks if a field's value is equal to any of the elements of {@code
   * arrayExpression}.
   *
   * @param fieldName The field to compare.
   * @param arrayExpression An expression that evaluates to an array, whose elements to check for
   *     equality to the input.
   * @return A new {@link BooleanExpression} representing the 'IN' comparison.
   */
  @BetaApi
  public static BooleanExpression equalAny(String fieldName, Expression arrayExpression) {
    return equalAny(field(fieldName), arrayExpression);
  }

  /**
   * Creates an expression that checks if an {@code expression}, when evaluated, is not equal to all
   * the provided {@code values}.
   *
   * @param expression The expression whose results to compare.
   * @param values The values to check against.
   * @return A new {@link BooleanExpression} representing the 'NOT IN' comparison.
   */
  @BetaApi
  public static BooleanExpression notEqualAny(Expression expression, List<Object> values) {
    return new BooleanFunctionExpression(
        "not_equal_any",
        expression,
        new FunctionExpression("array", toArrayOfExprOrConstant(values.toArray())));
  }

  /**
   * Creates an expression that checks if an {@code expression}, when evaluated, is not equal to all
   * the elements of {@code arrayExpression}.
   *
   * @param expression The expression whose results to compare.
   * @param arrayExpression An expression that evaluates to an array, whose elements to check for
   *     equality to the input.
   * @return A new {@link BooleanExpression} representing the 'NOT IN' comparison.
   */
  @BetaApi
  public static BooleanExpression notEqualAny(Expression expression, Expression arrayExpression) {
    return new BooleanFunctionExpression("not_equal_any", expression, arrayExpression);
  }

  /**
   * Creates an expression that checks if a field's value is not equal to all of the provided {@code
   * values}.
   *
   * @param fieldName The field to compare.
   * @param values The values to check against.
   * @return A new {@link BooleanExpression} representing the 'NOT IN' comparison.
   */
  @BetaApi
  public static BooleanExpression notEqualAny(String fieldName, List<Object> values) {
    return notEqualAny(
        field(fieldName),
        new FunctionExpression("array", toArrayOfExprOrConstant(values.toArray())));
  }

  /**
   * Creates an expression that checks if a field's value is not equal to all of the elements of
   * {@code arrayExpression}.
   *
   * @param fieldName The field to compare.
   * @param arrayExpression An expression that evaluates to an array, whose elements to check for
   *     equality to the input.
   * @return A new {@link BooleanExpression} representing the 'NOT IN' comparison.
   */
  @BetaApi
  public static BooleanExpression notEqualAny(String fieldName, Expression arrayExpression) {
    return notEqualAny(field(fieldName), arrayExpression);
  }

  // String Functions
  /**
   * Creates an expression that calculates the character length of a string expression in UTF8.
   *
   * @param string The expression representing the string.
   * @return A new {@link Expression} representing the charLength operation.
   */
  @BetaApi
  public static Expression charLength(Expression string) {
    return new FunctionExpression("char_length", ImmutableList.of(string));
  }

  /**
   * Creates an expression that calculates the character length of a string field in UTF8.
   *
   * @param fieldName The name of the field containing the string.
   * @return A new {@link Expression} representing the charLength operation.
   */
  @BetaApi
  public static Expression charLength(String fieldName) {
    return charLength(field(fieldName));
  }

  /**
   * Creates an expression that calculates the length of a string in UTF-8 bytes, or just the length
   * of a Blob.
   *
   * @param string The expression representing the string.
   * @return A new {@link Expression} representing the length of the string in bytes.
   */
  @BetaApi
  public static Expression byteLength(Expression string) {
    return new FunctionExpression("byte_length", ImmutableList.of(string));
  }

  /**
   * Creates an expression that calculates the length of a string represented by a field in UTF-8
   * bytes, or just the length of a Blob.
   *
   * @param fieldName The name of the field containing the string.
   * @return A new {@link Expression} representing the length of the string in bytes.
   */
  @BetaApi
  public static Expression byteLength(String fieldName) {
    return byteLength(field(fieldName));
  }

  /**
   * Creates an expression that calculates the length of string, array, map, vector, or Blob.
   *
   * @param string The expression representing the value to calculate the length of.
   * @return A new {@link Expression} representing the length of the value.
   */
  @BetaApi
  public static Expression length(Expression string) {
    return new FunctionExpression("length", ImmutableList.of(string));
  }

  /**
   * Creates an expression that calculates the length of string, array, map, vector, or Blob.
   *
   * @param fieldName The name of the field containing the value.
   * @return A new {@link Expression} representing the length of the value.
   */
  @BetaApi
  public static Expression length(String fieldName) {
    return byteLength(field(fieldName));
  }

  /**
   * Creates an expression that performs a case-sensitive wildcard string comparison.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param pattern The pattern to search for. You can use "%" as a wildcard character.
   * @return A new {@link BooleanExpression} representing the like operation.
   */
  @BetaApi
  public static BooleanExpression like(Expression string, Expression pattern) {
    return new BooleanFunctionExpression("like", string, pattern);
  }

  /**
   * Creates an expression that performs a case-sensitive wildcard string comparison.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param pattern The pattern to search for. You can use "%" as a wildcard character.
   * @return A new {@link BooleanExpression} representing the like operation.
   */
  @BetaApi
  public static BooleanExpression like(Expression string, String pattern) {
    return like(string, constant(pattern));
  }

  /**
   * Creates an expression that performs a case-sensitive wildcard string comparison against a
   * field.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The pattern to search for. You can use "%" as a wildcard character.
   * @return A new {@link BooleanExpression} representing the like comparison.
   */
  @BetaApi
  public static BooleanExpression like(String fieldName, Expression pattern) {
    return like(field(fieldName), pattern);
  }

  /**
   * Creates an expression that performs a case-sensitive wildcard string comparison against a
   * field.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The pattern to search for. You can use "%" as a wildcard character.
   * @return A new {@link BooleanExpression} representing the like comparison.
   */
  @BetaApi
  public static BooleanExpression like(String fieldName, String pattern) {
    return like(field(fieldName), constant(pattern));
  }

  /**
   * Creates an expression that checks if a string expression contains a specified regular
   * expression as a substring.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param pattern The regular expression to use for the search.
   * @return A new {@link BooleanExpression} representing the contains regular expression
   *     comparison.
   */
  @BetaApi
  public static BooleanExpression regexContains(Expression string, Expression pattern) {
    return new BooleanFunctionExpression("regex_contains", string, pattern);
  }

  /**
   * Creates an expression that checks if a string expression contains a specified regular
   * expression as a substring.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param pattern The regular expression to use for the search.
   * @return A new {@link BooleanExpression} representing the contains regular expression
   *     comparison.
   */
  @BetaApi
  public static BooleanExpression regexContains(Expression string, String pattern) {
    return regexContains(string, constant(pattern));
  }

  /**
   * Creates an expression that checks if a string field contains a specified regular expression as
   * a substring.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The regular expression to use for the search.
   * @return A new {@link BooleanExpression} representing the contains regular expression
   *     comparison.
   */
  @BetaApi
  public static BooleanExpression regexContains(String fieldName, Expression pattern) {
    return regexContains(field(fieldName), pattern);
  }

  /**
   * Creates an expression that checks if a string field contains a specified regular expression as
   * a substring.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The regular expression to use for the search.
   * @return A new {@link BooleanExpression} representing the contains regular expression
   *     comparison.
   */
  @BetaApi
  public static BooleanExpression regexContains(String fieldName, String pattern) {
    return regexContains(field(fieldName), constant(pattern));
  }

  /**
   * Creates an expression that returns the first substring of a string expression that matches a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param string The expression representing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} representing the regular expression find function.
   */
  @BetaApi
  public static Expression regexFind(Expression string, Expression pattern) {
    return new FunctionExpression("regex_find", ImmutableList.of(string, pattern));
  }

  /**
   * Creates an expression that returns the first substring of a string expression that matches a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param string The expression representing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} representing the regular expression find function.
   */
  @BetaApi
  public static Expression regexFind(Expression string, String pattern) {
    return regexFind(string, constant(pattern));
  }

  /**
   * Creates an expression that returns the first substring of a string field that matches a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param fieldName The name of the field containing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} representing the regular expression find function.
   */
  @BetaApi
  public static Expression regexFind(String fieldName, Expression pattern) {
    return regexFind(field(fieldName), pattern);
  }

  /**
   * Creates an expression that returns the first substring of a string field that matches a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param fieldName The name of the field containing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} representing the regular expression find function.
   */
  @BetaApi
  public static Expression regexFind(String fieldName, String pattern) {
    return regexFind(field(fieldName), constant(pattern));
  }

  /**
   * Creates an expression that evaluates to a list of all substrings in a string expression that
   * match a specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param string The expression representing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} that evaluates to a list of matched substrings.
   */
  @BetaApi
  public static Expression regexFindAll(Expression string, Expression pattern) {
    return new FunctionExpression("regex_find_all", ImmutableList.of(string, pattern));
  }

  /**
   * Creates an expression that evaluates to a list of all substrings in a string expression that
   * match a specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param string The expression representing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} that evaluates to a list of matched substrings.
   */
  @BetaApi
  public static Expression regexFindAll(Expression string, String pattern) {
    return regexFindAll(string, constant(pattern));
  }

  /**
   * Creates an expression that evaluates to a list of all substrings in a string field that match a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param fieldName The name of the field containing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} that evaluates to a list of matched substrings.
   */
  @BetaApi
  public static Expression regexFindAll(String fieldName, Expression pattern) {
    return regexFindAll(field(fieldName), pattern);
  }

  /**
   * Creates an expression that evaluates to a list of all substrings in a string field that match a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param fieldName The name of the field containing the string to search.
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} that evaluates to a list of matched substrings.
   */
  @BetaApi
  public static Expression regexFindAll(String fieldName, String pattern) {
    return regexFindAll(field(fieldName), constant(pattern));
  }

  /**
   * Creates an expression that checks if a string field matches a specified regular expression.
   *
   * @param string The expression representing the string to match against.
   * @param pattern The regular expression to use for the match.
   * @return A new {@link BooleanExpression} representing the regular expression match comparison.
   */
  @BetaApi
  public static BooleanExpression regexMatch(Expression string, Expression pattern) {
    return new BooleanFunctionExpression("regex_match", string, pattern);
  }

  /**
   * Creates an expression that checks if a string field matches a specified regular expression.
   *
   * @param string The expression representing the string to match against.
   * @param pattern The regular expression to use for the match.
   * @return A new {@link BooleanExpression} representing the regular expression match comparison.
   */
  @BetaApi
  public static BooleanExpression regexMatch(Expression string, String pattern) {
    return regexMatch(string, constant(pattern));
  }

  /**
   * Creates an expression that checks if a string field matches a specified regular expression.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The regular expression to use for the match.
   * @return A new {@link BooleanExpression} representing the regular expression match comparison.
   */
  @BetaApi
  public static BooleanExpression regexMatch(String fieldName, Expression pattern) {
    return regexMatch(field(fieldName), pattern);
  }

  /**
   * Creates an expression that checks if a string field matches a specified regular expression.
   *
   * @param fieldName The name of the field containing the string.
   * @param pattern The regular expression to use for the match.
   * @return A new {@link BooleanExpression} representing the regular expression match comparison.
   */
  @BetaApi
  public static BooleanExpression regexMatch(String fieldName, String pattern) {
    return regexMatch(field(fieldName), constant(pattern));
  }

  /**
   * Creates an expression that checks if a string expression contains a specified substring.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param substring The expression representing the substring to search for.
   * @return A new {@link BooleanExpression} representing the contains comparison.
   */
  @BetaApi
  public static BooleanExpression stringContains(Expression string, Expression substring) {
    return new BooleanFunctionExpression("string_contains", string, substring);
  }

  /**
   * Creates an expression that checks if a string expression contains a specified substring.
   *
   * @param string The expression representing the string to perform the comparison on.
   * @param substring The substring to search for.
   * @return A new {@link BooleanExpression} representing the contains comparison.
   */
  @BetaApi
  public static BooleanExpression stringContains(Expression string, String substring) {
    return stringContains(string, constant(substring));
  }

  /**
   * Creates an expression that checks if a string field contains a specified substring.
   *
   * @param fieldName The name of the field to perform the comparison on.
   * @param substring The expression representing the substring to search for.
   * @return A new {@link BooleanExpression} representing the contains comparison.
   */
  @BetaApi
  public static BooleanExpression stringContains(String fieldName, Expression substring) {
    return stringContains(field(fieldName), substring);
  }

  /**
   * Creates an expression that checks if a string field contains a specified substring.
   *
   * @param fieldName The name of the field to perform the comparison on.
   * @param substring The substring to search for.
   * @return A new {@link BooleanExpression} representing the contains comparison.
   */
  @BetaApi
  public static BooleanExpression stringContains(String fieldName, String substring) {
    return stringContains(field(fieldName), constant(substring));
  }

  /**
   * Creates an expression that checks if a string expression starts with a given {@code prefix}.
   *
   * @param string The expression to check.
   * @param prefix The prefix string expression to check for.
   * @return A new {@link BooleanExpression} representing the 'starts with' comparison.
   */
  @BetaApi
  public static BooleanExpression startsWith(Expression string, Expression prefix) {
    return new BooleanFunctionExpression("starts_with", string, prefix);
  }

  /**
   * Creates an expression that checks if a string expression starts with a given {@code prefix}.
   *
   * @param string The expression to check.
   * @param prefix The prefix string to check for.
   * @return A new {@link BooleanExpression} representing the 'starts with' comparison.
   */
  @BetaApi
  public static BooleanExpression startsWith(Expression string, String prefix) {
    return startsWith(string, constant(prefix));
  }

  /**
   * Creates an expression that checks if a string expression starts with a given {@code prefix}.
   *
   * @param fieldName The name of field that contains a string to check.
   * @param prefix The prefix string expression to check for.
   * @return A new {@link BooleanExpression} representing the 'starts with' comparison.
   */
  @BetaApi
  public static BooleanExpression startsWith(String fieldName, Expression prefix) {
    return startsWith(field(fieldName), prefix);
  }

  /**
   * Creates an expression that checks if a string expression starts with a given {@code prefix}.
   *
   * @param fieldName The name of field that contains a string to check.
   * @param prefix The prefix string to check for.
   * @return A new {@link BooleanExpression} representing the 'starts with' comparison.
   */
  @BetaApi
  public static BooleanExpression startsWith(String fieldName, String prefix) {
    return startsWith(field(fieldName), constant(prefix));
  }

  /**
   * Creates an expression that checks if a string expression ends with a given {@code suffix}.
   *
   * @param string The expression to check.
   * @param suffix The suffix string expression to check for.
   * @return A new {@link BooleanExpression} representing the 'ends with' comparison.
   */
  @BetaApi
  public static BooleanExpression endsWith(Expression string, Expression suffix) {
    return new BooleanFunctionExpression("ends_with", string, suffix);
  }

  /**
   * Creates an expression that checks if a string expression ends with a given {@code suffix}.
   *
   * @param string The expression to check.
   * @param suffix The suffix string to check for.
   * @return A new {@link BooleanExpression} representing the 'ends with' comparison.
   */
  @BetaApi
  public static BooleanExpression endsWith(Expression string, String suffix) {
    return endsWith(string, constant(suffix));
  }

  /**
   * Creates an expression that checks if a string expression ends with a given {@code suffix}.
   *
   * @param fieldName The name of field that contains a string to check.
   * @param suffix The suffix string expression to check for.
   * @return A new {@link BooleanExpression} representing the 'ends with' comparison.
   */
  @BetaApi
  public static BooleanExpression endsWith(String fieldName, Expression suffix) {
    return endsWith(field(fieldName), suffix);
  }

  /**
   * Creates an expression that checks if a string expression ends with a given {@code suffix}.
   *
   * @param fieldName The name of field that contains a string to check.
   * @param suffix The suffix string to check for.
   * @return A new {@link BooleanExpression} representing the 'ends with' comparison.
   */
  @BetaApi
  public static BooleanExpression endsWith(String fieldName, String suffix) {
    return endsWith(field(fieldName), constant(suffix));
  }

  /**
   * Creates an expression that returns a substring of the given string.
   *
   * @param string The expression representing the string to get a substring from.
   * @param index The starting index of the substring.
   * @param length The length of the substring.
   * @return A new {@link Expression} representing the substring.
   */
  @BetaApi
  public static Expression substring(Expression string, Expression index, Expression length) {
    return new FunctionExpression("substring", ImmutableList.of(string, index, length));
  }

  /**
   * Creates an expression that returns a substring of the given string.
   *
   * @param fieldName The name of the field containing the string to get a substring from.
   * @param index The starting index of the substring.
   * @param length The length of the substring.
   * @return A new {@link Expression} representing the substring.
   */
  @BetaApi
  public static Expression substring(String fieldName, int index, int length) {
    return substring(field(fieldName), constant(index), constant(length));
  }

  /**
   * Creates an expression that converts a string expression to lowercase.
   *
   * @param string The expression representing the string to convert to lowercase.
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public static Expression toLower(Expression string) {
    return new FunctionExpression("to_lower", ImmutableList.of(string));
  }

  /**
   * Creates an expression that converts a string field to lowercase.
   *
   * @param fieldName The name of the field containing the string to convert to lowercase.
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public static Expression toLower(String fieldName) {
    return toLower(field(fieldName));
  }

  /**
   * Creates an expression that converts a string expression to uppercase.
   *
   * @param string The expression representing the string to convert to uppercase.
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public static Expression toUpper(Expression string) {
    return new FunctionExpression("to_upper", ImmutableList.of(string));
  }

  /**
   * Creates an expression that converts a string field to uppercase.
   *
   * @param fieldName The name of the field containing the string to convert to uppercase.
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public static Expression toUpper(String fieldName) {
    return toUpper(field(fieldName));
  }

  /**
   * Creates an expression that removes leading and trailing whitespace from a string expression.
   *
   * @param string The expression representing the string to trim.
   * @return A new {@link Expression} representing the trimmed string.
   */
  @BetaApi
  public static Expression trim(Expression string) {
    return new FunctionExpression("trim", ImmutableList.of(string));
  }

  /**
   * Creates an expression that removes leading and trailing whitespace from a string field.
   *
   * @param fieldName The name of the field containing the string to trim.
   * @return A new {@link Expression} representing the trimmed string.
   */
  @BetaApi
  public static Expression trim(String fieldName) {
    return trim(field(fieldName));
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of a string
   * or blob.
   *
   * @param value The expression representing the string or blob to trim.
   * @param characters The characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public static Expression trimValue(Expression value, String characters) {
    return new FunctionExpression("trim", ImmutableList.of(value, constant(characters)));
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of a string
   * or blob.
   *
   * @param fieldName The name of the field containing the string or blob to trim.
   * @param characters The characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public static Expression trimValue(String fieldName, String characters) {
    return trimValue(field(fieldName), characters);
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of a string
   * or blob.
   *
   * @param value The expression representing the string or blob to trim.
   * @param characters The expression representing the characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public static Expression trimValue(Expression value, Expression characters) {
    return new FunctionExpression("trim", ImmutableList.of(value, characters));
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of a string
   * or blob.
   *
   * @param fieldName The name of the field containing the string or blob to trim.
   * @param characters The expression representing the characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public static Expression trimValue(String fieldName, Expression characters) {
    return trimValue(field(fieldName), characters);
  }

  /**
   * Creates an expression that splits a string or blob by a delimiter.
   *
   * @param value The expression representing the string or blob to split.
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public static Expression split(Expression value, Expression delimiter) {
    return new FunctionExpression("split", ImmutableList.of(value, delimiter));
  }

  /**
   * Creates an expression that splits a string or blob by a delimiter.
   *
   * @param value The expression representing the string or blob to split.
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public static Expression split(Expression value, String delimiter) {
    return split(value, constant(delimiter));
  }

  /**
   * Creates an expression that splits a string or blob by a delimiter.
   *
   * @param fieldName The name of the field containing the string or blob to split.
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public static Expression split(String fieldName, Expression delimiter) {
    return split(field(fieldName), delimiter);
  }

  /**
   * Creates an expression that splits a string or blob by a delimiter.
   *
   * @param fieldName The name of the field containing the string or blob to split.
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public static Expression split(String fieldName, String delimiter) {
    return split(field(fieldName), constant(delimiter));
  }

  /**
   * Creates an expression that concatenates string expressions together.
   *
   * @param firstString The expression representing the initial string value.
   * @param otherStrings Optional additional string expressions or string constants to concatenate.
   * @return A new {@link Expression} representing the concatenated string.
   */
  @BetaApi
  public static Expression stringConcat(Expression firstString, Object... otherStrings) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(firstString);
    builder.addAll(toArrayOfExprOrConstant(otherStrings));
    return new FunctionExpression("string_concat", builder.build());
  }

  /**
   * Creates an expression that concatenates string expressions together.
   *
   * @param fieldName The field name containing the initial string value.
   * @param otherStrings Optional additional string expressions or string constants to concatenate.
   * @return A new {@link Expression} representing the concatenated string.
   */
  @BetaApi
  public static Expression stringConcat(String fieldName, Object... otherStrings) {
    return stringConcat(field(fieldName), otherStrings);
  }

  /**
   * Creates an expression that concatenates expressions together.
   *
   * @param first The expression representing the initial value.
   * @param others Optional additional expressions or constants to concatenate.
   * @return A new {@link Expression} representing the concatenated value.
   */
  @BetaApi
  public static Expression concat(Expression first, Object... others) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(first);
    builder.addAll(toArrayOfExprOrConstant(others));
    return new FunctionExpression("concat", builder.build());
  }

  /**
   * Creates an expression that concatenates expressions together.
   *
   * @param fieldName The field name containing the initial value.
   * @param others Optional additional expressions or constants to concatenate.
   * @return A new {@link Expression} representing the concatenated value.
   */
  @BetaApi
  public static Expression concat(String fieldName, Object... others) {
    return concat(field(fieldName), others);
  }

  // Map Functions
  /**
   * Creates an expression that creates a Firestore map value from an input object.
   *
   * @param elements The input map to evaluate in the expression.
   * @return A new {@link Expression} representing the map function.
   */
  @BetaApi
  public static Expression map(Map<String, Object> elements) {
    ImmutableList<Expression> params =
        elements.entrySet().stream()
            .flatMap(
                e -> Arrays.asList(constant(e.getKey()), toExprOrConstant(e.getValue())).stream())
            .collect(ImmutableList.toImmutableList());
    return new FunctionExpression("map", params);
  }

  /**
   * Accesses a value from a map (object) field using the provided {@code keyExpression}.
   *
   * @param map The expression representing the map.
   * @param key The key to access in the map.
   * @return A new {@link Expression} representing the value associated with the given key in the
   *     map.
   */
  @BetaApi
  public static Expression mapGet(Expression map, Expression key) {
    return new FunctionExpression("map_get", ImmutableList.of(map, key));
  }

  /**
   * Accesses a value from a map (object) field using the provided {@code key}.
   *
   * @param map The expression representing the map.
   * @param key The key to access in the map.
   * @return A new {@link Expression} representing the value associated with the given key in the
   *     map.
   */
  @BetaApi
  public static Expression mapGet(Expression map, String key) {
    return mapGet(map, constant(key));
  }

  /**
   * Accesses a value from a map (object) field using the provided {@code key}.
   *
   * @param fieldName The field name of the map field.
   * @param key The key to access in the map.
   * @return A new {@link Expression} representing the value associated with the given key in the
   *     map.
   */
  @BetaApi
  public static Expression mapGet(String fieldName, String key) {
    return mapGet(field(fieldName), constant(key));
  }

  /**
   * Accesses a value from a map (object) field using the provided {@code keyExpression}.
   *
   * @param fieldName The field name of the map field.
   * @param key The key to access in the map.
   * @return A new {@link Expression} representing the value associated with the given key in the
   *     map.
   */
  @BetaApi
  public static Expression mapGet(String fieldName, Expression key) {
    return mapGet(field(fieldName), key);
  }

  @BetaApi
  public static Expression mapMerge(Expression firstMap, Expression secondMap) {
    return mapMerge(firstMap, secondMap, new Expression[0]);
  }

  @BetaApi
  public static Expression mapMerge(String firstMapFieldName, Expression secondMap) {
    return mapMerge(field(firstMapFieldName), secondMap, new Expression[0]);
  }

  /**
   * Creates an expression that merges multiple maps into a single map. If multiple maps have the
   * same key, the later value is used.
   *
   * @param firstMap First map expression that will be merged.
   * @param secondMap Second map expression that will be merged.
   * @param otherMaps Additional maps to merge.
   * @return A new {@link Expression} representing the mapMerge operation.
   */
  @BetaApi
  public static Expression mapMerge(
      Expression firstMap, Expression secondMap, Expression... otherMaps) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(firstMap);
    builder.add(secondMap);
    builder.add(otherMaps);
    return new FunctionExpression("map_merge", builder.build());
  }

  /**
   * Creates an expression that merges multiple maps into a single map. If multiple maps have the
   * same key, the later value is used.
   *
   * @param firstMapFieldName Field name of the first map expression that will be merged.
   * @param secondMap Second map expression that will be merged.
   * @param otherMaps Additional maps to merge.
   * @return A new {@link Expression} representing the mapMerge operation.
   */
  @BetaApi
  public static Expression mapMerge(
      String firstMapFieldName, Expression secondMap, Expression... otherMaps) {
    return mapMerge(field(firstMapFieldName), secondMap, otherMaps);
  }

  /**
   * Creates an expression that removes a key from a map.
   *
   * @param mapExpr The expression representing the map.
   * @param key The key to remove from the map.
   * @return A new {@link Expression} representing the map with the key removed.
   */
  @BetaApi
  public static Expression mapRemove(Expression mapExpr, Expression key) {
    return new FunctionExpression("map_remove", ImmutableList.of(mapExpr, key));
  }

  /**
   * Creates an expression that removes a key from a map.
   *
   * @param mapField The field name of the map.
   * @param key The key to remove from the map.
   * @return A new {@link Expression} representing the map with the key removed.
   */
  @BetaApi
  public static Expression mapRemove(String mapField, Expression key) {
    return mapRemove(field(mapField), key);
  }

  /**
   * Creates an expression that removes a key from a map.
   *
   * @param mapExpr The expression representing the map.
   * @param key The key to remove from the map.
   * @return A new {@link Expression} representing the map with the key removed.
   */
  @BetaApi
  public static Expression mapRemove(Expression mapExpr, String key) {
    return mapRemove(mapExpr, constant(key));
  }

  /**
   * Creates an expression that removes a key from a map.
   *
   * @param mapField The field name of the map.
   * @param key The key to remove from the map.
   * @return A new {@link Expression} representing the map with the key removed.
   */
  @BetaApi
  public static Expression mapRemove(String mapField, String key) {
    return mapRemove(field(mapField), key);
  }

  /**
   * Creates an expression that reverses a string, blob, or array.
   *
   * @param expr An expression evaluating to a string, blob, or array value, which will be reversed.
   * @return A new {@link Expression} representing the reversed value.
   */
  @BetaApi
  public static Expression reverse(Expression expr) {
    return new FunctionExpression("reverse", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that reverses the field value, which must be a string, blob, or array.
   *
   * @param fieldName A field evaluating to a string, blob, or array value.
   * @return A new {@link Expression} representing the reversed value.
   */
  @BetaApi
  public static Expression reverse(String fieldName) {
    return reverse(field(fieldName));
  }

  // Array Functions
  /**
   * Creates an expression that creates a Firestore array value from an input object.
   *
   * @param elements The input elements to evaluate in the expression.
   * @return A new {@link Expression} representing the array function.
   */
  @BetaApi
  public static Expression array(Object... elements) {
    return new FunctionExpression("array", toArrayOfExprOrConstant(elements));
  }

  /**
   * Creates an expression that creates a Firestore array value from an input object.
   *
   * @param elements The input elements to evaluate in the expression.
   * @return A new {@link Expression} representing the array function.
   */
  @BetaApi
  public static Expression array(List<Object> elements) {
    return new FunctionExpression("array", toArrayOfExprOrConstant(elements.toArray()));
  }

  /**
   * Creates an expression that concatenates multiple arrays into a single array.
   *
   * @param firstArray The first array expression to concatenate.
   * @param otherArrays Additional arrays to concatenate.
   * @return A new {@link Expression} representing the concatenated array.
   */
  @BetaApi
  public static Expression arrayConcat(Expression firstArray, Object... otherArrays) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(firstArray);
    builder.addAll(toArrayOfExprOrConstant(otherArrays));
    return new FunctionExpression("array_concat", builder.build());
  }

  /**
   * Creates an expression that concatenates multiple arrays into a single array.
   *
   * @param firstArrayField The field name of the first array to concatenate.
   * @param otherArrays Additional arrays to concatenate.
   * @return A new {@link Expression} representing the concatenated array.
   */
  @BetaApi
  public static Expression arrayConcat(String firstArrayField, Object... otherArrays) {
    return arrayConcat(field(firstArrayField), otherArrays);
  }

  /**
   * Creates an expression that reverses an array.
   *
   * @param array The expression representing the array to reverse.
   * @return A new {@link Expression} representing the reversed array.
   */
  @BetaApi
  public static Expression arrayReverse(Expression array) {
    return new FunctionExpression("array_reverse", ImmutableList.of(array));
  }

  /**
   * Creates an expression that reverses an array.
   *
   * @param arrayFieldName The field name of the array to reverse.
   * @return A new {@link Expression} representing the reversed array.
   */
  @BetaApi
  public static Expression arrayReverse(String arrayFieldName) {
    return arrayReverse(field(arrayFieldName));
  }

  /**
   * Creates an expression that checks if an array contains a specified element.
   *
   * @param array The expression representing the array.
   * @param element The element to check for.
   * @return A new {@link BooleanExpression} representing the array contains comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContains(Expression array, Expression element) {
    return new BooleanFunctionExpression("array_contains", array, element);
  }

  /**
   * Creates an expression that checks if an array contains a specified element.
   *
   * @param arrayFieldName The field name of the array.
   * @param element The element to check for.
   * @return A new {@link BooleanExpression} representing the array contains comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContains(String arrayFieldName, Expression element) {
    return arrayContains(field(arrayFieldName), element);
  }

  /**
   * Creates an expression that checks if an array contains a specified element.
   *
   * @param array The expression representing the array.
   * @param element The element to check for.
   * @return A new {@link BooleanExpression} representing the array contains comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContains(Expression array, Object element) {
    return arrayContains(array, toExprOrConstant(element));
  }

  /**
   * Creates an expression that checks if an array contains a specified element.
   *
   * @param arrayFieldName The field name of the array.
   * @param element The element to check for.
   * @return A new {@link BooleanExpression} representing the array contains comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContains(String arrayFieldName, Object element) {
    return arrayContains(field(arrayFieldName), toExprOrConstant(element));
  }

  /**
   * Creates an expression that checks if an array contains all of the provided values.
   *
   * @param array The expression representing the array.
   * @param values The values to check for.
   * @return A new {@link BooleanExpression} representing the array contains all comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAll(Expression array, List<Object> values) {
    return arrayContainsAll(array, array(values));
  }

  /**
   * Creates an expression that checks if an array contains all of the elements of another array.
   *
   * @param array The expression representing the array.
   * @param arrayExpression The expression representing the array of values to check for.
   * @return A new {@link BooleanExpression} representing the array contains all comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAll(Expression array, Expression arrayExpression) {
    return new BooleanFunctionExpression("array_contains_all", array, arrayExpression);
  }

  /**
   * Creates an expression that checks if an array contains all of the provided values.
   *
   * @param arrayFieldName The field name of the array.
   * @param values The values to check for.
   * @return A new {@link BooleanExpression} representing the array contains all comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAll(String arrayFieldName, List<Object> values) {
    return arrayContainsAll(field(arrayFieldName), array(values));
  }

  /**
   * Creates an expression that checks if an array contains all of the elements of another array.
   *
   * @param arrayFieldName The field name of the array.
   * @param arrayExpression The expression representing the array of values to check for.
   * @return A new {@link BooleanExpression} representing the array contains all comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAll(
      String arrayFieldName, Expression arrayExpression) {
    return arrayContainsAll(field(arrayFieldName), arrayExpression);
  }

  /**
   * Creates an expression that checks if an array contains any of the provided values.
   *
   * @param array The expression representing the array.
   * @param values The values to check for.
   * @return A new {@link BooleanExpression} representing the array contains any comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAny(Expression array, List<Object> values) {
    return new BooleanFunctionExpression("array_contains_any", array, array(values));
  }

  /**
   * Creates an expression that checks if an array contains any of the elements of another array.
   *
   * @param array The expression representing the array.
   * @param arrayExpression The expression representing the array of values to check for.
   * @return A new {@link BooleanExpression} representing the array contains any comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAny(Expression array, Expression arrayExpression) {
    return new BooleanFunctionExpression("array_contains_any", array, arrayExpression);
  }

  /**
   * Creates an expression that checks if an array contains any of the provided values.
   *
   * @param arrayFieldName The field name of the array.
   * @param values The values to check for.
   * @return A new {@link BooleanExpression} representing the array contains any comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAny(String arrayFieldName, List<Object> values) {
    return arrayContainsAny(field(arrayFieldName), array(values));
  }

  /**
   * Creates an expression that checks if an array contains any of the elements of another array.
   *
   * @param arrayFieldName The field name of the array.
   * @param arrayExpression The expression representing the array of values to check for.
   * @return A new {@link BooleanExpression} representing the array contains any comparison.
   */
  @BetaApi
  public static BooleanExpression arrayContainsAny(
      String arrayFieldName, Expression arrayExpression) {
    return arrayContainsAny(field(arrayFieldName), arrayExpression);
  }

  /**
   * Creates an expression that returns the length of an array.
   *
   * @param array The expression representing the array.
   * @return A new {@link Expression} representing the length of the array.
   */
  @BetaApi
  public static Expression arrayLength(Expression array) {
    return new FunctionExpression("array_length", ImmutableList.of(array));
  }

  /**
   * Creates an expression that returns the length of an array.
   *
   * @param arrayFieldName The field name of the array.
   * @return A new {@link Expression} representing the length of the array.
   */
  @BetaApi
  public static Expression arrayLength(String arrayFieldName) {
    return arrayLength(field(arrayFieldName));
  }

  /**
   * Creates an expression that returns an element from an array at a specified index.
   *
   * @param array The expression representing the array.
   * @param offset The index of the element to return.
   * @return A new {@link Expression} representing the element at the specified index.
   */
  @BetaApi
  public static Expression arrayGet(Expression array, Expression offset) {
    return new FunctionExpression("array_get", ImmutableList.of(array, offset));
  }

  /**
   * Creates an expression that returns an element from an array at a specified index.
   *
   * @param array The expression representing the array.
   * @param offset The index of the element to return.
   * @return A new {@link Expression} representing the element at the specified index.
   */
  @BetaApi
  public static Expression arrayGet(Expression array, int offset) {
    return arrayGet(array, constant(offset));
  }

  /**
   * Creates an expression that returns an element from an array at a specified index.
   *
   * @param arrayFieldName The field name of the array.
   * @param offset The index of the element to return.
   * @return A new {@link Expression} representing the element at the specified index.
   */
  @BetaApi
  public static Expression arrayGet(String arrayFieldName, Expression offset) {
    return arrayGet(field(arrayFieldName), offset);
  }

  /**
   * Creates an expression that returns an element from an array at a specified index.
   *
   * @param arrayFieldName The field name of the array.
   * @param offset The index of the element to return.
   * @return A new {@link Expression} representing the element at the specified index.
   */
  @BetaApi
  public static Expression arrayGet(String arrayFieldName, int offset) {
    return arrayGet(field(arrayFieldName), constant(offset));
  }

  /**
   * Creates an expression that returns the sum of the elements of an array.
   *
   * @param array The expression representing the array.
   * @return A new {@link Expression} representing the sum of the elements of the array.
   */
  @BetaApi
  public static Expression arraySum(Expression array) {
    return new FunctionExpression("sum", ImmutableList.of(array));
  }

  /**
   * Creates an expression that returns the sum of the elements of an array.
   *
   * @param arrayFieldName The field name of the array.
   * @return A new {@link Expression} representing the sum of the elements of the array.
   */
  @BetaApi
  public static Expression arraySum(String arrayFieldName) {
    return arraySum(field(arrayFieldName));
  }

  // Vector Functions
  /**
   * Creates an expression that calculates the cosine distance between two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the cosine distance.
   */
  @BetaApi
  public static Expression cosineDistance(Expression vector1, Expression vector2) {
    return new FunctionExpression("cosine_distance", ImmutableList.of(vector1, vector2));
  }

  /**
   * Creates an expression that calculates the cosine distance between two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the cosine distance.
   */
  @BetaApi
  public static Expression cosineDistance(Expression vector1, double[] vector2) {
    return cosineDistance(vector1, constant(FieldValue.vector(vector2)));
  }

  /**
   * Creates an expression that calculates the cosine distance between two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the cosine distance.
   */
  @BetaApi
  public static Expression cosineDistance(String vectorFieldName, Expression vector) {
    return cosineDistance(field(vectorFieldName), vector);
  }

  /**
   * Creates an expression that calculates the cosine distance between two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the cosine distance.
   */
  @BetaApi
  public static Expression cosineDistance(String vectorFieldName, double[] vector) {
    return cosineDistance(field(vectorFieldName), constant(FieldValue.vector(vector)));
  }

  /**
   * Creates an expression that calculates the dot product of two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the dot product.
   */
  @BetaApi
  public static Expression dotProduct(Expression vector1, Expression vector2) {
    return new FunctionExpression("dot_product", ImmutableList.of(vector1, vector2));
  }

  /**
   * Creates an expression that calculates the dot product of two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the dot product.
   */
  @BetaApi
  public static Expression dotProduct(Expression vector1, double[] vector2) {
    return dotProduct(vector1, constant(FieldValue.vector(vector2)));
  }

  /**
   * Creates an expression that calculates the dot product of two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the dot product.
   */
  @BetaApi
  public static Expression dotProduct(String vectorFieldName, Expression vector) {
    return dotProduct(field(vectorFieldName), vector);
  }

  /**
   * Creates an expression that calculates the dot product of two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the dot product.
   */
  @BetaApi
  public static Expression dotProduct(String vectorFieldName, double[] vector) {
    return dotProduct(field(vectorFieldName), constant(FieldValue.vector(vector)));
  }

  /**
   * Creates an expression that calculates the Euclidean distance between two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the Euclidean distance.
   */
  @BetaApi
  public static Expression euclideanDistance(Expression vector1, Expression vector2) {
    return new FunctionExpression("euclidean_distance", ImmutableList.of(vector1, vector2));
  }

  /**
   * Creates an expression that calculates the Euclidean distance between two vectors.
   *
   * @param vector1 The first vector.
   * @param vector2 The second vector.
   * @return A new {@link Expression} representing the Euclidean distance.
   */
  @BetaApi
  public static Expression euclideanDistance(Expression vector1, double[] vector2) {
    return euclideanDistance(vector1, constant(FieldValue.vector(vector2)));
  }

  /**
   * Creates an expression that calculates the Euclidean distance between two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the Euclidean distance.
   */
  @BetaApi
  public static Expression euclideanDistance(String vectorFieldName, Expression vector) {
    return euclideanDistance(field(vectorFieldName), vector);
  }

  /**
   * Creates an expression that calculates the Euclidean distance between two vectors.
   *
   * @param vectorFieldName The field name of the first vector.
   * @param vector The second vector.
   * @return A new {@link Expression} representing the Euclidean distance.
   */
  @BetaApi
  public static Expression euclideanDistance(String vectorFieldName, double[] vector) {
    return euclideanDistance(field(vectorFieldName), constant(FieldValue.vector(vector)));
  }

  /**
   * Creates an expression that calculates the length of a vector.
   *
   * @param vectorExpression The expression representing the vector.
   * @return A new {@link Expression} representing the length of the vector.
   */
  @BetaApi
  public static Expression vectorLength(Expression vectorExpression) {
    return new FunctionExpression("vector_length", ImmutableList.of(vectorExpression));
  }

  /**
   * Creates an expression that calculates the length of a vector.
   *
   * @param fieldName The field name of the vector.
   * @return A new {@link Expression} representing the length of the vector.
   */
  @BetaApi
  public static Expression vectorLength(String fieldName) {
    return vectorLength(field(fieldName));
  }

  // Timestamp Functions
  /**
   * Creates an expression that converts a Unix timestamp in microseconds to a Firestore timestamp.
   *
   * @param expr The expression representing the Unix timestamp in microseconds.
   * @return A new {@link Expression} representing the Firestore timestamp.
   */
  @BetaApi
  public static Expression unixMicrosToTimestamp(Expression expr) {
    return new FunctionExpression("unix_micros_to_timestamp", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that interprets a field's value as the number of microseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @param fieldName The name of the field containing the number of microseconds since epoch.
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public static Expression unixMicrosToTimestamp(String fieldName) {
    return unixMicrosToTimestamp(field(fieldName));
  }

  /**
   * Creates an expression that converts a timestamp expression to the number of microseconds since
   * the Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @param expr The expression representing the timestamp.
   * @return A new {@link Expression} representing the number of microseconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixMicros(Expression expr) {
    return new FunctionExpression("timestamp_to_unix_micros", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that converts a timestamp field to the number of microseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @return A new {@link Expression} representing the number of microseconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixMicros(String fieldName) {
    return timestampToUnixMicros(field(fieldName));
  }

  /**
   * Creates an expression that interprets an expression as the number of milliseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @param expr The expression representing the number of milliseconds since epoch.
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public static Expression unixMillisToTimestamp(Expression expr) {
    return new FunctionExpression("unix_millis_to_timestamp", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that interprets a field's value as the number of milliseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @param fieldName The name of the field containing the number of milliseconds since epoch.
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public static Expression unixMillisToTimestamp(String fieldName) {
    return unixMillisToTimestamp(field(fieldName));
  }

  /**
   * Creates an expression that converts a timestamp expression to the number of milliseconds since
   * the Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @param expr The expression representing the timestamp.
   * @return A new {@link Expression} representing the number of milliseconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixMillis(Expression expr) {
    return new FunctionExpression("timestamp_to_unix_millis", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that converts a timestamp field to the number of milliseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @return A new {@link Expression} representing the number of milliseconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixMillis(String fieldName) {
    return timestampToUnixMillis(field(fieldName));
  }

  /**
   * Creates an expression that interprets an expression as the number of seconds since the Unix
   * epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @param expr The expression representing the number of seconds since epoch.
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public static Expression unixSecondsToTimestamp(Expression expr) {
    return new FunctionExpression("unix_seconds_to_timestamp", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that interprets a field's value as the number of seconds since the Unix
   * epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @param fieldName The name of the field containing the number of seconds since epoch.
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public static Expression unixSecondsToTimestamp(String fieldName) {
    return unixSecondsToTimestamp(field(fieldName));
  }

  /**
   * Creates an expression that converts a timestamp expression to the number of seconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @param expr The expression representing the timestamp.
   * @return A new {@link Expression} representing the number of seconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixSeconds(Expression expr) {
    return new FunctionExpression("timestamp_to_unix_seconds", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that converts a timestamp field to the number of seconds since the Unix
   * epoch (1970-01-01 00:00:00 UTC).
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @return A new {@link Expression} representing the number of seconds since epoch.
   */
  @BetaApi
  public static Expression timestampToUnixSeconds(String fieldName) {
    return timestampToUnixSeconds(field(fieldName));
  }

  /**
   * Creates an expression that adds a specified amount of time to a timestamp.
   *
   * @param timestamp The expression representing the timestamp.
   * @param unit The expression representing the unit of time to add. Valid units include
   *     "microsecond", "millisecond", "second", "minute", "hour" and "day".
   * @param amount The expression representing the amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampAdd(Expression timestamp, Expression unit, Expression amount) {
    return new FunctionExpression("timestamp_add", ImmutableList.of(timestamp, unit, amount));
  }

  /**
   * Creates an expression that adds a specified amount of time to a timestamp.
   *
   * @param timestamp The expression representing the timestamp.
   * @param unit The unit of time to add. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampAdd(Expression timestamp, String unit, long amount) {
    return timestampAdd(timestamp, constant(unit), constant(amount));
  }

  /**
   * Creates an expression that adds a specified amount of time to a timestamp.
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @param unit The expression representing the unit of time to add. Valid units include
   *     "microsecond", "millisecond", "second", "minute", "hour" and "day".
   * @param amount The expression representing the amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampAdd(String fieldName, Expression unit, Expression amount) {
    return timestampAdd(field(fieldName), unit, amount);
  }

  /**
   * Creates an expression that adds a specified amount of time to a timestamp.
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @param unit The unit of time to add. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampAdd(String fieldName, String unit, long amount) {
    return timestampAdd(field(fieldName), constant(unit), constant(amount));
  }

  /**
   * Creates an expression that subtracts a specified amount of time to a timestamp.
   *
   * @param timestamp The expression representing the timestamp.
   * @param unit The expression representing the unit of time to subtract. Valid units include
   *     "microsecond", "millisecond", "second", "minute", "hour" and "day".
   * @param amount The expression representing the amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampSubtract(
      Expression timestamp, Expression unit, Expression amount) {
    return new FunctionExpression("timestamp_subtract", ImmutableList.of(timestamp, unit, amount));
  }

  /**
   * Creates an expression that subtracts a specified amount of time to a timestamp.
   *
   * @param timestamp The expression representing the timestamp.
   * @param unit The unit of time to subtract. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampSubtract(Expression timestamp, String unit, long amount) {
    return timestampSubtract(timestamp, constant(unit), constant(amount));
  }

  /**
   * Creates an expression that subtracts a specified amount of time to a timestamp.
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @param unit The unit of time to subtract. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampSubtract(String fieldName, Expression unit, Expression amount) {
    return timestampSubtract(field(fieldName), unit, amount);
  }

  /**
   * Creates an expression that subtracts a specified amount of time to a timestamp.
   *
   * @param fieldName The name of the field that contains the timestamp.
   * @param unit The unit of time to subtract. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public static Expression timestampSubtract(String fieldName, String unit, long amount) {
    return timestampSubtract(field(fieldName), constant(unit), constant(amount));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity.
   *
   * @param timestamp The timestamp expression.
   * @param granularity The granularity to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(Expression timestamp, String granularity) {
    return new FunctionExpression(
        "timestamp_trunc", ImmutableList.of(timestamp, constant(granularity)));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity.
   *
   * @param timestamp The timestamp expression.
   * @param granularity The granularity expression to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(Expression timestamp, Expression granularity) {
    return new FunctionExpression("timestamp_trunc", ImmutableList.of(timestamp, granularity));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity.
   *
   * @param fieldName The name of the field containing the timestamp.
   * @param granularity The granularity to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(String fieldName, String granularity) {
    return timestampTruncate(field(fieldName), constant(granularity));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity.
   *
   * @param fieldName The name of the field containing the timestamp.
   * @param granularity The granularity expression to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(String fieldName, Expression granularity) {
    return timestampTruncate(field(fieldName), granularity);
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity in a given
   * timezone.
   *
   * @param timestamp The timestamp expression.
   * @param granularity The granularity to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @param timezone The timezone to use for truncation. Valid values are from the TZ database
   *     (e.g., "America/Los_Angeles") or in the format "Etc/GMT-1".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(
      Expression timestamp, String granularity, String timezone) {
    return new FunctionExpression(
        "timestamp_trunc", ImmutableList.of(timestamp, constant(granularity), constant(timezone)));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity in a given
   * timezone.
   *
   * @param timestamp The timestamp expression.
   * @param granularity The granularity expression to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @param timezone The timezone to use for truncation. Valid values are from the TZ database
   *     (e.g., "America/Los_Angeles") or in the format "Etc/GMT-1".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(
      Expression timestamp, Expression granularity, String timezone) {
    return new FunctionExpression(
        "timestamp_trunc", ImmutableList.of(timestamp, granularity, constant(timezone)));
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity in a given
   * timezone.
   *
   * @param fieldName The name of the field containing the timestamp.
   * @param granularity The granularity to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @param timezone The timezone to use for truncation. Valid values are from the TZ database
   *     (e.g., "America/Los_Angeles") or in the format "Etc/GMT-1".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(
      String fieldName, String granularity, String timezone) {
    return timestampTruncate(field(fieldName), constant(granularity), timezone);
  }

  /**
   * Creates an expression that truncates a timestamp to a specified granularity in a given
   * timezone.
   *
   * @param fieldName The name of the field containing the timestamp.
   * @param granularity The granularity expression to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @param timezone The timezone to use for truncation. Valid values are from the TZ database
   *     (e.g., "America/Los_Angeles") or in the format "Etc/GMT-1".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public static Expression timestampTruncate(
      String fieldName, Expression granularity, String timezone) {
    return timestampTruncate(field(fieldName), granularity, timezone);
  }

  // Conditional Functions
  /**
   * Creates a conditional expression that evaluates to a {@code thenExpr} expression if a condition
   * is true or an {@code elseExpr} expression if the condition is false.
   *
   * @param condition The condition to evaluate.
   * @param thenExpr The expression to evaluate if the condition is true.
   * @param elseExpr The expression to evaluate if the condition is false.
   * @return A new {@link Expression} representing the conditional operation.
   */
  @BetaApi
  public static Expression conditional(
      BooleanExpression condition, Expression thenExpr, Expression elseExpr) {
    return new FunctionExpression("conditional", ImmutableList.of(condition, thenExpr, elseExpr));
  }

  /**
   * Creates a conditional expression that evaluates to a {@code thenValue} if a condition is true
   * or an {@code elseValue} if the condition is false.
   *
   * @param condition The condition to evaluate.
   * @param thenValue Value if the condition is true.
   * @param elseValue Value if the condition is false.
   * @return A new {@link Expression} representing the conditional operation.
   */
  @BetaApi
  public static Expression conditional(
      BooleanExpression condition, Object thenValue, Object elseValue) {
    return conditional(condition, toExprOrConstant(thenValue), toExprOrConstant(elseValue));
  }

  // Error Handling Functions
  /**
   * Creates an expression that returns the {@code catchExpr} argument if there is an error, else
   * return the result of the {@code tryExpr} argument evaluation.
   *
   * @param tryExpr The try expression.
   * @param catchExpr The catch expression that will be evaluated and returned if the {@code
   *     tryExpr} produces an error.
   * @return A new {@link Expression} representing the ifError operation.
   */
  @BetaApi
  public static Expression ifError(Expression tryExpr, Expression catchExpr) {
    return new FunctionExpression("if_error", ImmutableList.of(tryExpr, catchExpr));
  }

  /**
   * Creates an expression that returns the {@code catchExpr} argument if there is an error, else
   * return the result of the {@code tryExpr} argument evaluation.
   *
   * <p>This overload will return {@link BooleanExpression} when both parameters are also {@link
   * BooleanExpression}.
   *
   * @param tryExpr The try boolean expression.
   * @param catchExpr The catch boolean expression that will be evaluated and returned if the {@code
   *     tryExpr} produces an error.
   * @return A new {@link BooleanExpression} representing the ifError operation.
   */
  @BetaApi
  public static BooleanExpression ifError(BooleanExpression tryExpr, BooleanExpression catchExpr) {
    return new BooleanFunctionExpression("if_error", tryExpr, catchExpr);
  }

  /**
   * Creates an expression that returns the {@code catchValue} argument if there is an error, else
   * return the result of the {@code tryExpr} argument evaluation.
   *
   * @param tryExpr The try expression.
   * @param catchValue The value that will be returned if the {@code tryExpr} produces an error.
   * @return A new {@link Expression} representing the ifError operation.
   */
  @BetaApi
  public static Expression ifError(Expression tryExpr, Object catchValue) {
    return ifError(tryExpr, toExprOrConstant(catchValue));
  }

  /**
   * Creates an expression that checks if a given expression produces an error.
   *
   * @param expr The expression to check.
   * @return A new {@link BooleanExpression} representing the `isError` check.
   */
  @BetaApi
  public static BooleanExpression isError(Expression expr) {
    return new BooleanFunctionExpression("is_error", expr);
  }

  // Other Utility Functions
  /**
   * Creates an expression that returns the document ID from a path.
   *
   * @param documentPath An expression the evaluates to document path.
   * @return A new {@link Expression} representing the documentId operation.
   */
  @BetaApi
  public static Expression documentId(Expression documentPath) {
    return new FunctionExpression("document_id", ImmutableList.of(documentPath));
  }

  /**
   * Creates an expression that returns the document ID from a path.
   *
   * @param documentPath The string representation of the document path.
   * @return A new {@link Expression} representing the documentId operation.
   */
  @BetaApi
  public static Expression documentId(String documentPath) {
    return documentId(constant(documentPath));
  }

  /**
   * Creates an expression that returns the document ID from a {@link DocumentReference}.
   *
   * @param docRef The {@link DocumentReference}.
   * @return A new {@link Expression} representing the documentId operation.
   */
  @BetaApi
  public static Expression documentId(DocumentReference docRef) {
    return documentId(constant(docRef));
  }

  /**
   * Creates an expression that returns the collection ID from a path.
   *
   * @param path An expression the evaluates to document path.
   * @return A new {@link Expression} representing the collectionId operation.
   */
  @BetaApi
  public static Expression collectionId(Expression path) {
    return new FunctionExpression("collection_id", ImmutableList.of(path));
  }

  /**
   * Creates an expression that returns the collection ID from a path.
   *
   * @param pathFieldName The field name of the path.
   * @return A new {@link Expression} representing the collectionId operation.
   */
  @BetaApi
  public static Expression collectionId(String pathFieldName) {
    return collectionId(field(pathFieldName));
  }

  // Type Checking Functions
  /**
   * Creates an expression that checks if a field exists.
   *
   * @param value An expression evaluates to the name of the field to check.
   * @return A new {@link Expression} representing the exists check.
   */
  @BetaApi
  public static BooleanExpression exists(Expression value) {
    return new BooleanFunctionExpression("exists", value);
  }

  /**
   * Creates an expression that checks if a field exists.
   *
   * @param fieldName The field name to check.
   * @return A new {@link Expression} representing the exists check.
   */
  @BetaApi
  public static BooleanExpression exists(String fieldName) {
    return exists(field(fieldName));
  }

  /**
   * Creates an expression that returns true if a value is absent. Otherwise, returns false even if
   * the value is null.
   *
   * @param value The expression to check.
   * @return A new {@link BooleanExpression} representing the isAbsent operation.
   */
  @BetaApi
  public static BooleanExpression isAbsent(Expression value) {
    return new BooleanFunctionExpression("is_absent", value);
  }

  /**
   * Creates an expression that returns true if a field is absent. Otherwise, returns false even if
   * the field value is null.
   *
   * @param fieldName The field to check.
   * @return A new {@link BooleanExpression} representing the isAbsent operation.
   */
  @BetaApi
  public static BooleanExpression isAbsent(String fieldName) {
    return isAbsent(field(fieldName));
  }

  /**
   * Creates an expression that checks if an expression evaluates to 'NaN' (Not a Number).
   *
   * @param value The expression to check.
   * @return A new {@link BooleanExpression} representing the isNan operation.
   */
  @BetaApi
  static BooleanExpression isNaN(Expression value) {
    return new BooleanFunctionExpression("is_nan", value);
  }

  /**
   * Creates an expression that checks if a field's value evaluates to 'NaN' (Not a Number).
   *
   * @param fieldName The field to check.
   * @return A new {@link BooleanExpression} representing the isNan operation.
   */
  @BetaApi
  static BooleanExpression isNaN(String fieldName) {
    return isNaN(field(fieldName));
  }

  /**
   * Creates an expression that checks if the result of an expression is null.
   *
   * @param value The expression to check.
   * @return A new {@link BooleanExpression} representing the isNull operation.
   */
  @BetaApi
  static BooleanExpression isNull(Expression value) {
    return new BooleanFunctionExpression("is_null", value);
  }

  /**
   * Creates an expression that checks if the value of a field is null.
   *
   * @param fieldName The field to check.
   * @return A new {@link BooleanExpression} representing the isNull operation.
   */
  @BetaApi
  static BooleanExpression isNull(String fieldName) {
    return isNull(field(fieldName));
  }

  /**
   * Creates an expression that checks if the result of an expression is not null.
   *
   * @param value The expression to check.
   * @return A new {@link BooleanExpression} representing the isNotNull operation.
   */
  @BetaApi
  static BooleanExpression isNotNull(Expression value) {
    return new BooleanFunctionExpression("is_not_null", value);
  }

  /**
   * Creates an expression that checks if the value of a field is not null.
   *
   * @param fieldName The field to check.
   * @return A new {@link BooleanExpression} representing the isNotNull operation.
   */
  @BetaApi
  static BooleanExpression isNotNull(String fieldName) {
    return isNotNull(field(fieldName));
  }

  /**
   * Creates an expression that returns a string indicating the type of the value this expression
   * evaluates to.
   *
   * @param expr The expression to get the type of.
   * @return A new {@link Expression} representing the type operation.
   */
  @BetaApi
  public static Expression type(Expression expr) {
    return new FunctionExpression("type", ImmutableList.of(expr));
  }

  /**
   * Creates an expression that returns a string indicating the type of the value this field
   * evaluates to.
   *
   * @param fieldName The name of the field to get the type of.
   * @return A new {@link Expression} representing the type operation.
   */
  @BetaApi
  public static Expression type(String fieldName) {
    return type(field(fieldName));
  }

  // Numeric Operations
  /**
   * Creates an expression that rounds {@code numericExpr} to nearest integer.
   *
   * <p>Rounds away from zero in halfway cases.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the round operation.
   */
  @BetaApi
  public static Expression round(Expression numericExpr) {
    return new FunctionExpression("round", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that rounds {@code numericField} to nearest integer.
   *
   * <p>Rounds away from zero in halfway cases.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the round operation.
   */
  @BetaApi
  public static Expression round(String numericField) {
    return round(field(numericField));
  }

  /**
   * Creates an expression that rounds off {@code numericExpr} to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public static Expression roundToPrecision(Expression numericExpr, int decimalPlace) {
    return new FunctionExpression("round", ImmutableList.of(numericExpr, constant(decimalPlace)));
  }

  /**
   * Creates an expression that rounds off {@code numericField} to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public static Expression roundToPrecision(String numericField, int decimalPlace) {
    return roundToPrecision(field(numericField), decimalPlace);
  }

  /**
   * Creates an expression that rounds off {@code numericExpr} to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public static Expression roundToPrecision(Expression numericExpr, Expression decimalPlace) {
    return new FunctionExpression("round", ImmutableList.of(numericExpr, decimalPlace));
  }

  /**
   * Creates an expression that rounds off {@code numericField} to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public static Expression roundToPrecision(String numericField, Expression decimalPlace) {
    return roundToPrecision(field(numericField), decimalPlace);
  }

  /**
   * Creates an expression that returns the smallest integer that isn't less than {@code
   * numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the ceil operation.
   */
  @BetaApi
  public static Expression ceil(Expression numericExpr) {
    return new FunctionExpression("ceil", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the smallest integer that isn't less than {@code
   * numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the ceil operation.
   */
  @BetaApi
  public static Expression ceil(String numericField) {
    return ceil(field(numericField));
  }

  /**
   * Creates an expression that returns the largest integer that isn't less than {@code
   * numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the floor operation.
   */
  @BetaApi
  public static Expression floor(Expression numericExpr) {
    return new FunctionExpression("floor", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the largest integer that isn't less than {@code
   * numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing an integer result from the floor operation.
   */
  @BetaApi
  public static Expression floor(String numericField) {
    return floor(field(numericField));
  }

  /**
   * Creates an expression that returns the {@code numericExpr} raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param exponent The numeric power to raise the {@code numericExpr}.
   * @return A new {@link Expression} representing a numeric result from raising {@code numericExpr}
   *     to the power of {@code exponent}.
   */
  @BetaApi
  public static Expression pow(Expression numericExpr, Number exponent) {
    return new FunctionExpression("pow", ImmutableList.of(numericExpr, constant(exponent)));
  }

  /**
   * Creates an expression that returns the {@code numericField} raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param exponent The numeric power to raise the {@code numericField}.
   * @return A new {@link Expression} representing a numeric result from raising {@code
   *     numericField} to the power of {@code exponent}.
   */
  @BetaApi
  public static Expression pow(String numericField, Number exponent) {
    return pow(field(numericField), exponent);
  }

  /**
   * Creates an expression that returns the {@code numericExpr} raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param exponent The numeric power to raise the {@code numericExpr}.
   * @return A new {@link Expression} representing a numeric result from raising {@code numericExpr}
   *     to the power of {@code exponent}.
   */
  @BetaApi
  public static Expression pow(Expression numericExpr, Expression exponent) {
    return new FunctionExpression("pow", ImmutableList.of(numericExpr, exponent));
  }

  /**
   * Creates an expression that returns the {@code numericField} raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param exponent The numeric power to raise the {@code numericField}.
   * @return A new {@link Expression} representing a numeric result from raising {@code
   *     numericField} to the power of {@code exponent}.
   */
  @BetaApi
  public static Expression pow(String numericField, Expression exponent) {
    return pow(field(numericField), exponent);
  }

  /**
   * Creates an expression that returns the absolute value of {@code numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the absolute value
   *     operation.
   */
  @BetaApi
  public static Expression abs(Expression numericExpr) {
    return new FunctionExpression("abs", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the absolute value of {@code numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the absolute value
   *     operation.
   */
  @BetaApi
  public static Expression abs(String numericField) {
    return abs(field(numericField));
  }

  /**
   * Creates an expression that returns Euler's number e raised to the power of {@code numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the exponentiation.
   */
  @BetaApi
  public static Expression exp(Expression numericExpr) {
    return new FunctionExpression("exp", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns Euler's number e raised to the power of {@code
   * numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the exponentiation.
   */
  @BetaApi
  public static Expression exp(String numericField) {
    return exp(field(numericField));
  }

  /**
   * Creates an expression that returns the natural logarithm (base e) of {@code numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the natural logarithm.
   */
  @BetaApi
  public static Expression ln(Expression numericExpr) {
    return new FunctionExpression("ln", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the natural logarithm (base e) of {@code numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the natural logarithm.
   */
  @BetaApi
  public static Expression ln(String numericField) {
    return ln(field(numericField));
  }

  /**
   * Creates an expression that returns the logarithm of {@code numericExpr} with a given {@code
   * base}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param base The base of the logarithm.
   * @return A new {@link Expression} representing a numeric result from the logarithm of {@code
   *     numericExpr} with a given {@code base}.
   */
  @BetaApi
  public static Expression log(Expression numericExpr, Number base) {
    return new FunctionExpression("log", ImmutableList.of(numericExpr, constant(base)));
  }

  /**
   * Creates an expression that returns the logarithm of {@code numericField} with a given {@code
   * base}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param base The base of the logarithm.
   * @return A new {@link Expression} representing a numeric result from the logarithm of {@code
   *     numericField} with a given {@code base}.
   */
  @BetaApi
  public static Expression log(String numericField, Number base) {
    return log(field(numericField), base);
  }

  /**
   * Creates an expression that returns the logarithm of {@code numericExpr} with a given {@code
   * base}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @param base The base of the logarithm.
   * @return A new {@link Expression} representing a numeric result from the logarithm of {@code
   *     numericExpr} with a given {@code base}.
   */
  @BetaApi
  public static Expression log(Expression numericExpr, Expression base) {
    return new FunctionExpression("log", ImmutableList.of(numericExpr, base));
  }

  /**
   * Creates an expression that returns the logarithm of {@code numericField} with a given {@code
   * base}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @param base The base of the logarithm.
   * @return A new {@link Expression} representing a numeric result from the logarithm of {@code
   *     numericField} with a given {@code base}.
   */
  @BetaApi
  public static Expression log(String numericField, Expression base) {
    return log(field(numericField), base);
  }

  /**
   * Creates an expression that returns the base 10 logarithm of {@code numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the base 10 logarithm.
   */
  @BetaApi
  public static Expression log10(Expression numericExpr) {
    return new FunctionExpression("log10", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the base 10 logarithm of {@code numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the base 10 logarithm.
   */
  @BetaApi
  public static Expression log10(String numericField) {
    return log10(field(numericField));
  }

  /**
   * Creates an expression that returns the square root of {@code numericExpr}.
   *
   * @param numericExpr An expression that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the square root operation.
   */
  @BetaApi
  public static Expression sqrt(Expression numericExpr) {
    return new FunctionExpression("sqrt", ImmutableList.of(numericExpr));
  }

  /**
   * Creates an expression that returns the square root of {@code numericField}.
   *
   * @param numericField Name of field that returns number when evaluated.
   * @return A new {@link Expression} representing the numeric result of the square root operation.
   */
  @BetaApi
  public static Expression sqrt(String numericField) {
    return sqrt(field(numericField));
  }

  // Logical/Comparison Operations
  /**
   * Creates an expression that checks if the results of {@code expr} is NOT 'NaN' (Not a Number).
   *
   * @param expr The expression to check.
   * @return A new {@link BooleanExpression} representing the isNotNan operation.
   */
  @BetaApi
  public static BooleanExpression isNotNaN(Expression expr) {
    return new BooleanFunctionExpression("is_not_nan", expr);
  }

  /**
   * Creates an expression that checks if the results of this expression is NOT 'NaN' (Not a
   * Number).
   *
   * @param fieldName The field to check.
   * @return A new {@link BooleanExpression} representing the isNotNan operation.
   */
  @BetaApi
  public static BooleanExpression isNotNaN(String fieldName) {
    return isNotNaN(field(fieldName));
  }

  /**
   * Creates an expression that returns the largest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param expr The first operand expression.
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical maximum operation.
   */
  @BetaApi
  public static Expression logicalMaximum(Expression expr, Object... others) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(expr);
    builder.addAll(toArrayOfExprOrConstant(others));
    return new FunctionExpression("maximum", builder.build());
  }

  /**
   * Creates an expression that returns the largest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param fieldName The first operand field name.
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical maximum operation.
   */
  @BetaApi
  public static Expression logicalMaximum(String fieldName, Object... others) {
    return logicalMaximum(field(fieldName), others);
  }

  /**
   * Creates an expression that returns the smallest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param expr The first operand expression.
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical minimum operation.
   */
  @BetaApi
  public static Expression logicalMinimum(Expression expr, Object... others) {
    ImmutableList.Builder<Expression> builder = ImmutableList.builder();
    builder.add(expr);
    builder.addAll(toArrayOfExprOrConstant(others));
    return new FunctionExpression("minimum", builder.build());
  }

  /**
   * Creates an expression that returns the smallest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param fieldName The first operand field name.
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical minimum operation.
   */
  @BetaApi
  public static Expression logicalMinimum(String fieldName, Object... others) {
    return logicalMinimum(field(fieldName), others);
  }

  /**
   * Creates an expression that concatenates this expression with other values.
   *
   * @param others Optional additional expressions or constants to concatenate.
   * @return A new {@link Expression} representing the concatenated value.
   */
  @BetaApi
  public Expression concat(Object... others) {
    return Expression.concat(this, others);
  }

  /**
   * Creates an expression that returns a default value if this expression evaluates to an absent
   * value.
   *
   * @param elseValue The default value.
   * @return A new {@link Expression} representing the ifAbsent operation.
   */
  @BetaApi
  public Expression ifAbsent(Object elseValue) {
    return Expression.ifAbsent(this, elseValue);
  }

  /**
   * Creates an expression that joins the elements of this array expression into a string.
   *
   * @param delimiter The delimiter to use.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public Expression join(String delimiter) {
    return Expression.join(this, delimiter);
  }

  /**
   * Creates an expression that joins the elements of this array expression into a string.
   *
   * @param delimiter The delimiter to use.
   * @return A new {@link Expression} representing the join operation.
   */
  @BetaApi
  public Expression join(Expression delimiter) {
    return Expression.join(this, delimiter);
  }

  /**
   * Creates an expression that checks if the results of this expression is NOT 'NaN' (Not a
   * Number).
   *
   * @return A new {@link BooleanExpression} representing the isNotNan operation.
   */
  @BetaApi
  public final BooleanExpression isNotNaN() {
    return isNotNaN(this);
  }

  /**
   * Creates an expression that returns the largest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical maximum operation.
   */
  @BetaApi
  public final Expression logicalMaximum(Object... others) {
    return logicalMaximum(this, others);
  }

  /**
   * Creates an expression that returns the smallest value between multiple input expressions or
   * literal values. Based on Firestore's value type ordering.
   *
   * @param others Optional additional expressions or literals.
   * @return A new {@link Expression} representing the logical minimum operation.
   */
  @BetaApi
  public final Expression logicalMinimum(Object... others) {
    return logicalMinimum(this, others);
  }

  /**
   * Creates an expression that rounds this numeric expression to nearest integer.
   *
   * <p>Rounds away from zero in halfway cases.
   *
   * @return A new {@link Expression} representing an integer result from the round operation.
   */
  @BetaApi
  public final Expression round() {
    return round(this);
  }

  /**
   * Creates an expression that rounds off this numeric expression to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public final Expression roundToPrecision(int decimalPlace) {
    return roundToPrecision(this, decimalPlace);
  }

  /**
   * Creates an expression that rounds off this numeric expression to {@code decimalPlace} decimal
   * places if {@code decimalPlace} is positive, rounds off digits to the left of the decimal point
   * if {@code decimalPlace} is negative. Rounds away from zero in halfway cases.
   *
   * @param decimalPlace The number of decimal places to round.
   * @return A new {@link Expression} representing the round operation.
   */
  @BetaApi
  public final Expression roundToPrecision(Expression decimalPlace) {
    return roundToPrecision(this, decimalPlace);
  }

  /**
   * Creates an expression that returns the smallest integer that isn't less than this numeric
   * expression.
   *
   * @return A new {@link Expression} representing an integer result from the ceil operation.
   */
  @BetaApi
  public final Expression ceil() {
    return ceil(this);
  }

  /**
   * Creates an expression that returns the largest integer that isn't less than this numeric
   * expression.
   *
   * @return A new {@link Expression} representing an integer result from the floor operation.
   */
  @BetaApi
  public final Expression floor() {
    return floor(this);
  }

  /**
   * Creates an expression that returns this numeric expression raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param exponent The numeric power to raise this numeric expression.
   * @return A new {@link Expression} representing a numeric result from raising this numeric
   *     expression to the power of {@code exponent}.
   */
  @BetaApi
  public final Expression pow(Number exponent) {
    return pow(this, exponent);
  }

  /**
   * Creates an expression that returns this numeric expression raised to the power of the {@code
   * exponent}. Returns infinity on overflow and zero on underflow.
   *
   * @param exponent The numeric power to raise this numeric expression.
   * @return A new {@link Expression} representing a numeric result from raising this numeric
   *     expression to the power of {@code exponent}.
   */
  @BetaApi
  public final Expression pow(Expression exponent) {
    return pow(this, exponent);
  }

  /**
   * Creates an expression that returns the absolute value of this numeric expression.
   *
   * @return A new {@link Expression} representing the numeric result of the absolute value
   *     operation.
   */
  @BetaApi
  public final Expression abs() {
    return abs(this);
  }

  /**
   * Creates an expression that returns Euler's number e raised to the power of this numeric
   * expression.
   *
   * @return A new {@link Expression} representing the numeric result of the exponentiation.
   */
  @BetaApi
  public final Expression exp() {
    return exp(this);
  }

  /**
   * Creates an expression that returns the natural logarithm (base e) of this numeric expression.
   *
   * @return A new {@link Expression} representing the numeric result of the natural logarithm.
   */
  @BetaApi
  public final Expression ln() {
    return ln(this);
  }

  /**
   * Creates an expression that returns the base 10 logarithm of this numeric expression.
   *
   * @return A new {@link Expression} representing the numeric result of the base 10 logarithm.
   */
  @BetaApi
  public Expression log10() {
    return Expression.log10(this);
  }

  /**
   * Creates an expression that returns the sum of the elements of this array expression.
   *
   * @return A new {@link Expression} representing the sum of the elements of the array.
   */
  @BetaApi
  public Expression arraySum() {
    return Expression.arraySum(this);
  }

  /**
   * Creates an expression that returns the square root of this numeric expression.
   *
   * @return A new {@link Expression} representing the numeric result of the square root operation.
   */
  @BetaApi
  public final Expression sqrt() {
    return sqrt(this);
  }

  // Fluent API
  /**
   * Creates an expression that adds this numeric expression to another numeric expression.
   *
   * @param other Numeric expression to add.
   * @return A new {@link Expression} representing the addition operation.
   */
  @BetaApi
  public final Expression add(Object other) {
    return add(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that subtracts a numeric expressions from this numeric expression.
   *
   * @param other Constant to subtract.
   * @return A new {@link Expression} representing the subtract operation.
   */
  @BetaApi
  public final Expression subtract(Object other) {
    return subtract(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that multiplies this numeric expression with another numeric expression.
   *
   * @param other Numeric expression to multiply.
   * @return A new {@link Expression} representing the multiplication operation.
   */
  @BetaApi
  public final Expression multiply(Object other) {
    return multiply(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that divides this numeric expression by another numeric expression.
   *
   * @param other Numeric expression to divide this numeric expression by.
   * @return A new {@link Expression} representing the division operation.
   */
  @BetaApi
  public final Expression divide(Object other) {
    return divide(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that calculates the modulo (remainder) of dividing this numeric
   * expressions by another numeric expression.
   *
   * @param other The numeric expression to divide this expression by.
   * @return A new {@link Expression} representing the modulo operation.
   */
  @BetaApi
  public final Expression mod(Object other) {
    return mod(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is equal to a {@code value}.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the equality comparison.
   */
  @BetaApi
  public final BooleanExpression equal(Object other) {
    return equal(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is not equal to a {@code value}.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the inequality comparison.
   */
  @BetaApi
  public final BooleanExpression notEqual(Object other) {
    return notEqual(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is greater than a {@code value}.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the greater than comparison.
   */
  @BetaApi
  public final BooleanExpression greaterThan(Object other) {
    return greaterThan(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is greater than or equal to a {@code
   * value}.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the greater than or equal to comparison.
   */
  @BetaApi
  public final BooleanExpression greaterThanOrEqual(Object other) {
    return greaterThanOrEqual(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is less than a value.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the less than comparison.
   */
  @BetaApi
  public final BooleanExpression lessThan(Object other) {
    return lessThan(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression is less than or equal to a {@code value}.
   *
   * @param other The value to compare to.
   * @return A new {@link BooleanExpression} representing the less than or equal to comparison.
   */
  @BetaApi
  public final BooleanExpression lessThanOrEqual(Object other) {
    return lessThanOrEqual(this, toExprOrConstant(other));
  }

  /**
   * Creates an expression that checks if this expression, when evaluated, is equal to any of the
   * provided {@code values}.
   *
   * @param other The values to check against.
   * @return A new {@link BooleanExpression} representing the 'IN' comparison.
   */
  @BetaApi
  public final BooleanExpression equalAny(List<Object> other) {
    return equalAny(this, other);
  }

  /**
   * Creates an expression that checks if this expression, when evaluated, is not equal to all the
   * provided {@code values}.
   *
   * @param other The values to check against.
   * @return A new {@link BooleanExpression} representing the 'NOT IN' comparison.
   */
  @BetaApi
  public final BooleanExpression notEqualAny(List<Object> other) {
    return notEqualAny(this, other);
  }

  /**
   * Creates an expression that calculates the character length of this string expression in UTF8.
   *
   * @return A new {@link Expression} representing the charLength operation.
   */
  @BetaApi
  public final Expression charLength() {
    return charLength(this);
  }

  /**
   * Creates an expression that calculates the length of a string in UTF-8 bytes, or just the length
   * of a Blob.
   *
   * @return A new {@link Expression} representing the length of the string in bytes.
   */
  @BetaApi
  public final Expression byteLength() {
    return byteLength(this);
  }

  /**
   * Creates an expression that calculates the length of the expression if it is a string, array,
   * map, or Blob.
   *
   * @return A new {@link Expression} representing the length of the expression.
   */
  @BetaApi
  public final Expression length() {
    return length(this);
  }

  /**
   * Creates an expression that performs a case-sensitive wildcard string comparison.
   *
   * @param pattern The pattern to search for. You can use "%" as a wildcard character.
   * @return A new {@link BooleanExpression} representing the like operation.
   */
  @BetaApi
  public final BooleanExpression like(Object pattern) {
    return like(this, toExprOrConstant(pattern));
  }

  /**
   * Creates an expression that checks if this string expression contains a specified regular
   * expression as a substring.
   *
   * @param pattern The regular expression to use for the search.
   * @return A new {@link BooleanExpression} representing the contains regular expression
   *     comparison.
   */
  @BetaApi
  public final BooleanExpression regexContains(Object pattern) {
    return regexContains(this, toExprOrConstant(pattern));
  }

  /**
   * Creates an expression that returns the first substring of a string expression that matches a
   * specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} representing the regular expression find function.
   */
  @BetaApi
  public final Expression regexFind(Object pattern) {
    return regexFind(this, toExprOrConstant(pattern));
  }

  /**
   * Creates an expression that evaluates to a list of all substrings in a string expression that
   * match a specified regular expression.
   *
   * <p>This expression uses the [RE2](https://github.com/google/re2/wiki/Syntax) regular expression
   * syntax.
   *
   * @param pattern The regular expression to search for.
   * @return A new {@link Expression} that evaluates to a list of matched substrings.
   */
  @BetaApi
  public final Expression regexFindAll(Object pattern) {
    return regexFindAll(this, toExprOrConstant(pattern));
  }

  /**
   * Creates an expression that checks if this string expression matches a specified regular
   * expression.
   *
   * @param pattern The regular expression to use for the match.
   * @return A new {@link BooleanExpression} representing the regular expression match comparison.
   */
  @BetaApi
  public final BooleanExpression regexMatch(Object pattern) {
    return regexMatch(this, toExprOrConstant(pattern));
  }

  /**
   * Creates an expression that checks if this string expression contains a specified substring.
   *
   * @param substring The expression representing the substring to search for.
   * @return A new {@link BooleanExpression} representing the contains comparison.
   */
  @BetaApi
  public final BooleanExpression stringContains(Object substring) {
    return stringContains(this, toExprOrConstant(substring));
  }

  /**
   * Creates an expression that checks if this string expression starts with a given {@code prefix}.
   *
   * @param prefix The prefix string expression to check for.
   * @return A new {@link Expression} representing the the 'starts with' comparison.
   */
  @BetaApi
  public final BooleanExpression startsWith(Object prefix) {
    return startsWith(this, toExprOrConstant(prefix));
  }

  /**
   * Creates an expression that checks if this string expression ends with a given {@code suffix}.
   *
   * @param suffix The suffix string expression to check for.
   * @return A new {@link Expression} representing the 'ends with' comparison.
   */
  @BetaApi
  public final BooleanExpression endsWith(Object suffix) {
    return endsWith(this, toExprOrConstant(suffix));
  }

  /**
   * Creates an expression that returns a substring of the given string.
   *
   * @param index The starting index of the substring.
   * @param length The length of the substring.
   * @return A new {@link Expression} representing the substring.
   */
  @BetaApi
  public final Expression substring(Object index, Object length) {
    return substring(this, toExprOrConstant(index), toExprOrConstant(length));
  }

  /**
   * Creates an expression that converts this string expression to lowercase.
   *
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public final Expression toLower() {
    return toLower(this);
  }

  /**
   * Creates an expression that converts this string expression to uppercase.
   *
   * @return A new {@link Expression} representing the lowercase string.
   */
  @BetaApi
  public final Expression toUpper() {
    return toUpper(this);
  }

  /**
   * Creates an expression that removes leading and trailing whitespace from this string expression.
   *
   * @return A new {@link Expression} representing the trimmed string.
   */
  @BetaApi
  public final Expression trim() {
    return trim(this);
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of this
   * string or blob expression.
   *
   * @param characters The characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public Expression trimValue(String characters) {
    return trimValue(this, characters);
  }

  /**
   * Creates an expression that removes specified characters from the beginning and end of this
   * string or blob expression.
   *
   * @param characters The expression representing the characters to remove.
   * @return A new {@link Expression} representing the trimmed string or blob.
   */
  @BetaApi
  public Expression trimValue(Expression characters) {
    return trimValue(this, characters);
  }

  /**
   * Creates an expression that splits this string or blob expression by a delimiter.
   *
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public Expression split(Expression delimiter) {
    return split(this, delimiter);
  }

  /**
   * Creates an expression that splits this string or blob expression by a delimiter.
   *
   * @param delimiter The delimiter to split by.
   * @return A new {@link Expression} representing the split string or blob as an array.
   */
  @BetaApi
  public Expression split(String delimiter) {
    return split(this, delimiter);
  }

  /**
   * Creates an expression that concatenates string expressions and string constants together.
   *
   * @param others The string expressions or string constants to concatenate.
   * @return A new {@link Expression} representing the concatenated string.
   */
  @BetaApi
  public final Expression stringConcat(String... others) {
    return stringConcat(this, others);
  }

  /**
   * Creates an expression that concatenates string expressions together.
   *
   * @param others The string expressions or string constants to concatenate.
   * @return A new {@link Expression} representing the concatenated string.
   */
  @BetaApi
  public final Expression stringConcat(Expression... others) {
    return stringConcat(this, others);
  }

  /**
   * Accesses a map (object) value using the provided {@code key}.
   *
   * @param key The key to access in the map.
   * @return A new {@link Expression} representing the value associated with the given key in the
   *     map.
   */
  @BetaApi
  public final Expression mapGet(Object key) {
    return mapGet(this, toExprOrConstant(key));
  }

  /**
   * Creates an expression that returns true if yhe result of this expression is absent. Otherwise,
   * returns false even if the value is null.
   *
   * @return A new {@link BooleanExpression} representing the isAbsent operation.
   */
  @BetaApi
  public final BooleanExpression isAbsent() {
    return isAbsent(this);
  }

  /**
   * Creates an expression that checks if this expression evaluates to 'NaN' (Not a Number).
   *
   * @return A new {@link BooleanExpression} representing the isNan operation.
   */
  @BetaApi
  public final BooleanExpression isNaN() {
    return isNaN(this);
  }

  /**
   * Creates an expression that checks if tbe result of this expression is null.
   *
   * @return A new {@link BooleanExpression} representing the isNull operation.
   */
  @BetaApi
  public final BooleanExpression isNull() {
    return isNull(this);
  }

  /**
   * Creates an expression that checks if tbe result of this expression is not null.
   *
   * @return A new {@link BooleanExpression} representing the isNotNull operation.
   */
  @BetaApi
  public final BooleanExpression isNotNull() {
    return isNotNull(this);
  }

  /**
   * Creates an aggregation that calculates the sum of this numeric expression across multiple stage
   * inputs.
   *
   * @return A new {@link AggregateFunction} representing the sum aggregation.
   */
  @BetaApi
  public final AggregateFunction sum() {
    return AggregateFunction.sum(this);
  }

  /**
   * Creates an aggregation that calculates the average (mean) of this numeric expression across
   * multiple stage inputs.
   *
   * @return A new {@link AggregateFunction} representing the average aggregation.
   */
  @BetaApi
  public final AggregateFunction average() {
    return AggregateFunction.average(this);
  }

  /**
   * Creates an aggregation that finds the minimum value of this expression across multiple stage
   * inputs.
   *
   * @return A new {@link AggregateFunction} representing the minimum aggregation.
   */
  @BetaApi
  public final AggregateFunction minimum() {
    return AggregateFunction.minimum(this);
  }

  /**
   * Creates an aggregation that finds the maximum value of this expression across multiple stage
   * inputs.
   *
   * @return A new {@link AggregateFunction} representing the maximum aggregation.
   */
  @BetaApi
  public final AggregateFunction maximum() {
    return AggregateFunction.maximum(this);
  }

  /**
   * Creates an aggregation that counts the number of stage inputs with valid evaluations of the
   * this expression.
   *
   * @return A new {@link AggregateFunction} representing the count aggregation.
   */
  @BetaApi
  public final AggregateFunction count() {
    return AggregateFunction.count(this);
  }

  /**
   * Creates an aggregation that counts the number of distinct values of this expression.
   *
   * @return A new {@link AggregateFunction} representing the count distinct aggregation.
   */
  @BetaApi
  public final AggregateFunction countDistinct() {
    return AggregateFunction.countDistinct(this);
  }

  /**
   * Create an {@link Ordering} that sorts documents in ascending order based on value of this
   * expression
   *
   * @return A new {@link Ordering} object with ascending sort by this expression.
   */
  @BetaApi
  public final Ordering ascending() {
    return Ordering.ascending(this);
  }

  /**
   * Create an {@link Ordering} that sorts documents in descending order based on value of this
   * expression
   *
   * @return A new {@link Ordering} object with descending sort by this expression.
   */
  @BetaApi
  public final Ordering descending() {
    return Ordering.descending(this);
  }

  /**
   * Assigns an alias to this expression.
   *
   * <p>Aliases are useful for renaming fields in the output of a stage or for giving meaningful
   * names to calculated values.
   *
   * @param alias The alias to assign to this expression.
   * @return A new {@link AliasedExpression} that wraps this expression and associates it with the
   *     provided alias.
   */
  @BetaApi
  public AliasedExpression as(String alias) {
    return new AliasedExpression(this, alias);
  }

  // Fluent API for new functions
  /**
   * Creates an expression that merges multiple maps into a single map. If multiple maps have the
   * same key, the later value is used.
   *
   * @param secondMap Map expression that will be merged.
   * @param otherMaps Additional maps to merge.
   * @return A new {@link Expression} representing the mapMerge operation.
   */
  @BetaApi
  public final Expression mapMerge(Expression secondMap, Expression... otherMaps) {
    return mapMerge(this, secondMap, otherMaps);
  }

  /**
   * Creates an expression that removes a key from this map expression.
   *
   * @param key The name of the key to remove from this map expression.
   * @return A new {@link Expression} that evaluates to a modified map.
   */
  @BetaApi
  public final Expression mapRemove(Expression key) {
    return mapRemove(this, key);
  }

  /**
   * Creates an expression that removes a key from this map expression.
   *
   * @param key The name of the key to remove from this map expression.
   * @return A new {@link Expression} that evaluates to a modified map.
   */
  @BetaApi
  public final Expression mapRemove(String key) {
    return mapRemove(this, key);
  }

  /**
   * Creates an expression that reverses this expression, which must be a string, blob, or array.
   *
   * @return A new {@link Expression} representing the reversed value.
   */
  @BetaApi
  public final Expression reverse() {
    return reverse(this);
  }

  /**
   * Creates an expression that concatenates a field's array value with other arrays.
   *
   * @param otherArrays Optional additional array expressions or array literals to concatenate.
   * @return A new {@link Expression} representing the arrayConcat operation.
   */
  @BetaApi
  public final Expression arrayConcat(Expression... otherArrays) {
    return arrayConcat(this, otherArrays);
  }

  /**
   * Reverses the order of elements in the array.
   *
   * @return A new {@link Expression} representing the arrayReverse operation.
   */
  @BetaApi
  public final Expression arrayReverse() {
    return arrayReverse(this);
  }

  /**
   * Creates an expression that checks if array contains a specific {@code element}.
   *
   * @param element The element to search for in the array.
   * @return A new {@link BooleanExpression} representing the arrayContains operation.
   */
  @BetaApi
  public final BooleanExpression arrayContains(Object element) {
    return arrayContains(this, element);
  }

  /**
   * Creates an expression that checks if array contains all the specified {@code values}.
   *
   * @param values The elements to check for in the array.
   * @return A new {@link BooleanExpression} representing the arrayContainsAll operation.
   */
  @BetaApi
  public final BooleanExpression arrayContainsAll(List<Object> values) {
    return arrayContainsAll(this, values);
  }

  /**
   * Creates an expression that checks if array contains all elements of {@code arrayExpression}.
   *
   * @param arrayExpression The elements to check for in the array.
   * @return A new {@link BooleanExpression} representing the arrayContainsAll operation.
   */
  @BetaApi
  public final BooleanExpression arrayContainsAll(Expression arrayExpression) {
    return arrayContainsAll(this, arrayExpression);
  }

  /**
   * Creates an expression that checks if array contains any of the specified {@code values}.
   *
   * @param values The elements to check for in the array.
   * @return A new {@link BooleanExpression} representing the arrayContainsAny operation.
   */
  @BetaApi
  public final BooleanExpression arrayContainsAny(List<Object> values) {
    return arrayContainsAny(this, values);
  }

  /**
   * Creates an expression that checks if array contains any elements of {@code arrayExpression}.
   *
   * @param arrayExpression The elements to check for in the array.
   * @return A new {@link BooleanExpression} representing the arrayContainsAny operation.
   */
  @BetaApi
  public final BooleanExpression arrayContainsAny(Expression arrayExpression) {
    return arrayContainsAny(this, arrayExpression);
  }

  /**
   * Creates an expression that calculates the length of an array expression.
   *
   * @return A new {@link Expression} representing the length of the array.
   */
  @BetaApi
  public final Expression arrayLength() {
    return arrayLength(this);
  }

  /**
   * Creates an expression that indexes into an array from the beginning or end and return the
   * element. If the offset exceeds the array length, an error is returned. A negative offset,
   * starts from the end.
   *
   * @param offset An Expression evaluating to the index of the element to return.
   * @return A new {@link Expression} representing the arrayGet operation.
   */
  @BetaApi
  public final Expression arrayGet(Expression offset) {
    return arrayGet(this, offset);
  }

  /**
   * Creates an expression that indexes into an array from the beginning or end and return the
   * element. If the offset exceeds the array length, an error is returned. A negative offset,
   * starts from the end.
   *
   * @param offset An Expression evaluating to the index of the element to return.
   * @return A new {@link Expression} representing the arrayOffset operation.
   */
  @BetaApi
  public final Expression arrayGet(int offset) {
    return arrayGet(this, offset);
  }

  /**
   * Calculates the Cosine distance between this and another vector expressions.
   *
   * @param vector The other vector (represented as an Expression) to compare against.
   * @return A new {@link Expression} representing the cosine distance between the two vectors.
   */
  @BetaApi
  public final Expression cosineDistance(Expression vector) {
    return cosineDistance(this, vector);
  }

  /**
   * Calculates the Cosine distance between this vector expression and a vector literal.
   *
   * @param vector The other vector (as an array of doubles) to compare against.
   * @return A new {@link Expression} representing the cosine distance between the two vectors.
   */
  @BetaApi
  public final Expression cosineDistance(double[] vector) {
    return cosineDistance(this, vector);
  }

  /**
   * Calculates the dot product distance between this and another vector expression.
   *
   * @param vector The other vector (represented as an Expression) to compare against.
   * @return A new {@link Expression} representing the dot product distance between the two vectors.
   */
  @BetaApi
  public final Expression dotProduct(Expression vector) {
    return dotProduct(this, vector);
  }

  /**
   * Calculates the dot product distance between this vector expression and a vector literal.
   *
   * @param vector The other vector (as an array of doubles) to compare against.
   * @return A new {@link Expression} representing the dot product distance between the two vectors.
   */
  @BetaApi
  public final Expression dotProduct(double[] vector) {
    return dotProduct(this, vector);
  }

  /**
   * Calculates the Euclidean distance between this and another vector expression.
   *
   * @param vector The other vector (represented as an Expression) to compare against.
   * @return A new {@link Expression} representing the Euclidean distance between the two vectors.
   */
  @BetaApi
  public final Expression euclideanDistance(Expression vector) {
    return euclideanDistance(this, vector);
  }

  /**
   * Calculates the Euclidean distance between this vector expression and a vector literal.
   *
   * @param vector The other vector (as an array of doubles) to compare against.
   * @return A new {@link Expression} representing the Euclidean distance between the two vectors.
   */
  @BetaApi
  public final Expression euclideanDistance(double[] vector) {
    return euclideanDistance(this, vector);
  }

  /**
   * Creates an expression that calculates the length (dimension) of a Firestore Vector.
   *
   * @return A new {@link Expression} representing the length (dimension) of the vector.
   */
  @BetaApi
  public final Expression vectorLength() {
    return vectorLength(this);
  }

  /**
   * Creates an expression that interprets this expression as the number of microseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public final Expression unixMicrosToTimestamp() {
    return unixMicrosToTimestamp(this);
  }

  /**
   * Creates an expression that converts this timestamp expression to the number of microseconds
   * since the Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @return A new {@link Expression} representing the number of microseconds since epoch.
   */
  @BetaApi
  public final Expression timestampToUnixMicros() {
    return timestampToUnixMicros(this);
  }

  /**
   * Creates an expression that interprets this expression as the number of milliseconds since the
   * Unix epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public final Expression unixMillisToTimestamp() {
    return unixMillisToTimestamp(this);
  }

  /**
   * Creates an expression that converts this timestamp expression to the number of milliseconds
   * since the Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @return A new {@link Expression} representing the number of milliseconds since epoch.
   */
  @BetaApi
  public final Expression timestampToUnixMillis() {
    return timestampToUnixMillis(this);
  }

  /**
   * Creates an expression that interprets this expression as the number of seconds since the Unix
   * epoch (1970-01-01 00:00:00 UTC) and returns a timestamp.
   *
   * @return A new {@link Expression} representing the timestamp.
   */
  @BetaApi
  public final Expression unixSecondsToTimestamp() {
    return unixSecondsToTimestamp(this);
  }

  /**
   * Creates an expression that converts this timestamp expression to the number of seconds since
   * the Unix epoch (1970-01-01 00:00:00 UTC).
   *
   * @return A new {@link Expression} representing the number of seconds since epoch.
   */
  @BetaApi
  public final Expression timestampToUnixSeconds() {
    return timestampToUnixSeconds(this);
  }

  /**
   * Creates an expression that adds a specified amount of time to this timestamp expression.
   *
   * @param unit The expression representing the unit of time to add. Valid units include
   *     "microsecond", "millisecond", "second", "minute", "hour" and "day".
   * @param amount The expression representing the amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public final Expression timestampAdd(Expression unit, Expression amount) {
    return timestampAdd(this, unit, amount);
  }

  /**
   * Creates an expression that adds a specified amount of time to this timestamp expression.
   *
   * @param unit The unit of time to add. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to add.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public final Expression timestampAdd(String unit, long amount) {
    return timestampAdd(this, unit, amount);
  }

  /**
   * Creates an expression that subtracts a specified amount of time to this timestamp expression.
   *
   * @param unit The expression representing the unit of time to subtract. Valid units include
   *     "microsecond", "millisecond", "second", "minute", "hour" and "day".
   * @param amount The expression representing the amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public final Expression timestampSubtract(Expression unit, Expression amount) {
    return timestampSubtract(this, unit, amount);
  }

  /**
   * Creates an expression that subtracts a specified amount of time to this timestamp expression.
   *
   * @param unit The unit of time to subtract. Valid units include "microsecond", "millisecond",
   *     "second", "minute", "hour" and "day".
   * @param amount The amount of time to subtract.
   * @return A new {@link Expression} representing the resulting timestamp.
   */
  @BetaApi
  public final Expression timestampSubtract(String unit, long amount) {
    return timestampSubtract(this, unit, amount);
  }

  /**
   * Creates an expression that truncates this timestamp expression to a specified granularity.
   *
   * @param granularity The granularity to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public final Expression timestampTruncate(String granularity) {
    return timestampTruncate(this, granularity);
  }

  /**
   * Creates an expression that truncates this timestamp expression to a specified granularity.
   *
   * @param granularity The granularity expression to truncate to. Valid values are "microsecond",
   *     "millisecond", "second", "minute", "hour", "day", "week", "week(monday)", "week(tuesday)",
   *     "week(wednesday)", "week(thursday)", "week(friday)", "week(saturday)", "week(sunday)",
   *     "isoweek", "month", "quarter", "year", and "isoyear".
   * @return A new {@link Expression} representing the truncated timestamp.
   */
  @BetaApi
  public final Expression timestampTruncate(Expression granularity) {
    return timestampTruncate(this, granularity);
  }

  /**
   * Creates an expression that checks if this expression evaluates to a name of the field that
   * exists.
   *
   * @return A new {@link Expression} representing the exists check.
   */
  @BetaApi
  public final BooleanExpression exists() {
    return exists(this);
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
  public final Expression ifError(Expression catchExpr) {
    return ifError(this, catchExpr);
  }

  /**
   * Creates an expression that returns the {@code catchValue} argument if there is an error, else
   * return the result of this expression.
   *
   * @param catchValue The value that will be returned if this expression produces an error.
   * @return A new {@link Expression} representing the ifError operation.
   */
  @BetaApi
  public final Expression ifError(Object catchValue) {
    return ifError(this, catchValue);
  }

  /**
   * Creates an expression that checks if this expression produces an error.
   *
   * @return A new {@link BooleanExpression} representing the `isError` check.
   */
  @BetaApi
  public final BooleanExpression isError() {
    return isError(this);
  }

  /**
   * Creates an expression that returns the document ID from this path expression.
   *
   * @return A new {@link Expression} representing the documentId operation.
   */
  @BetaApi
  public final Expression documentId() {
    return documentId(this);
  }

  /**
   * Creates an expression that returns the collection ID from this path expression.
   *
   * @return A new {@link Expression} representing the collectionId operation.
   */
  @BetaApi
  public final Expression collectionId() {
    return collectionId(this);
  }

  /**
   * Creates an expression that returns a string indicating the type of the value this expression
   * evaluates to.
   *
   * @return A new {@link Expression} representing the type operation.
   */
  @BetaApi
  public final Expression type() {
    return type(this);
  }
}
