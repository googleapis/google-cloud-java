// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.generator.engine.ast;

import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;

@AutoValue
public abstract class UnaryOperationExpr implements OperationExpr {

  public abstract Expr expr();

  @Override
  public abstract OperatorKind operatorKind();

  @Override
  public abstract TypeNode type();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public boolean isPostfixIncrement() {
    return operatorKind().equals(OperatorKind.UNARY_POST_INCREMENT);
  }

  public static UnaryOperationExpr postfixIncrementWithExpr(Expr expr) {
    return builder()
        .setExpr(expr)
        .setOperatorKind(OperatorKind.UNARY_POST_INCREMENT)
        .setType(expr.type())
        .build();
  }

  public static UnaryOperationExpr logicalNotWithExpr(Expr expr) {
    return builder()
        .setOperatorKind(OperatorKind.UNARY_LOGICAL_NOT)
        .setExpr(expr)
        .setType(TypeNode.BOOLEAN)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_UnaryOperationExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {

    // Private setter.
    abstract Builder setExpr(Expr expr);

    // Private setter.
    abstract Builder setOperatorKind(OperatorKind operator);

    // Private setter.
    abstract Builder setType(TypeNode type);

    abstract UnaryOperationExpr autoBuild();

    private UnaryOperationExpr build() {
      UnaryOperationExpr unaryOperationExpr = autoBuild();
      TypeNode exprType = unaryOperationExpr.expr().type();
      OperatorKind operator = unaryOperationExpr.operatorKind();

      // Add final keyword checking for post/prefix ++, -- when needed.
      if (operator.equals(OperatorKind.UNARY_POST_INCREMENT)
          && unaryOperationExpr.expr() instanceof VariableExpr) {
        VariableExpr varExpr = (VariableExpr) unaryOperationExpr.expr();
        Preconditions.checkState(
            !varExpr.isFinal(),
            String.format("Cannot increment the final variable '%s'.", varExpr.variable().name()));

        Preconditions.checkState(
            !varExpr.isDecl(),
            String.format(
                "Cannot increment the declaration of variable %s", varExpr.variable().name()));
      }

      final String errorMsg =
          String.format(
              "Unary operator %s can not be applied to %s. ", operator, exprType.toString());

      Preconditions.checkState(
          !exprType.equals(TypeNode.VOID) && !exprType.equals(TypeNode.NULL), errorMsg);

      if (operator.equals(OperatorKind.UNARY_LOGICAL_NOT)) {
        Preconditions.checkState(isValidLogicalNotType(exprType), errorMsg);
      }

      if (operator.equals(OperatorKind.UNARY_POST_INCREMENT)) {
        Preconditions.checkState(isValidIncrementType(exprType), errorMsg);
      }

      return unaryOperationExpr;
    }
  }

  private static boolean isValidLogicalNotType(TypeNode exprType) {
    // Logical not (!) can only be applied on boolean/Boolean type
    return exprType.equals(TypeNode.BOOLEAN);
  }

  private static boolean isValidIncrementType(TypeNode exprType) {
    // Increment (++) can be applied on numeric types(int, double, float, long, short, char)
    // and its boxed type (exclude Boolean)
    return TypeNode.isNumericType(exprType);
  }
}
