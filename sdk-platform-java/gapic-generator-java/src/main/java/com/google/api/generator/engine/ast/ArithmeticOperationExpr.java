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
public abstract class ArithmeticOperationExpr implements OperationExpr {

  public abstract Expr lhsExpr();

  public abstract Expr rhsExpr();

  @Override
  public abstract OperatorKind operatorKind();

  @Override
  public abstract TypeNode type();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static ArithmeticOperationExpr concatWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.ARITHMETIC_ADDITION)
        .setType(TypeNode.STRING)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_ArithmeticOperationExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {

    // Private setter.
    abstract Builder setLhsExpr(Expr expr);

    // Private setter.
    abstract Builder setRhsExpr(Expr expr);

    // Private setter.
    abstract Builder setOperatorKind(OperatorKind operator);

    // Private setter.
    abstract Builder setType(TypeNode type);

    abstract ArithmeticOperationExpr autoBuild();

    private ArithmeticOperationExpr build() {
      ArithmeticOperationExpr arithmeticOperationExpr = autoBuild();
      TypeNode lhsExprType = arithmeticOperationExpr.lhsExpr().type();
      TypeNode rhsExprType = arithmeticOperationExpr.rhsExpr().type();
      OperatorKind operator = arithmeticOperationExpr.operatorKind();
      final String errorMsg =
          String.format(
              "Arithmetic operator %s can not be applied to %s, %s.",
              operator, lhsExprType.toString(), rhsExprType.toString());

      // None of expression should be void type.
      Preconditions.checkState(
          !lhsExprType.equals(TypeNode.VOID) && !rhsExprType.equals(TypeNode.VOID), errorMsg);

      // Type-checking for Concat operator.
      if (operator.equals(OperatorKind.ARITHMETIC_ADDITION)) {
        Preconditions.checkState(isValidConcatTypes(lhsExprType, rhsExprType), errorMsg);
      }

      return arithmeticOperationExpr;
    }

    private boolean isValidConcatTypes(TypeNode lhsType, TypeNode rhsType) {
      // concat requires at least one String-typed expression
      return lhsType.equals(TypeNode.STRING) || rhsType.equals(TypeNode.STRING);
    }
  }
}
