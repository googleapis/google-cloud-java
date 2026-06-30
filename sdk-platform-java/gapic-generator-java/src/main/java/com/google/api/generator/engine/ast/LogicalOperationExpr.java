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
public abstract class LogicalOperationExpr implements OperationExpr {

  public abstract Expr lhsExpr();

  public abstract Expr rhsExpr();

  @Override
  public abstract OperatorKind operatorKind();

  @Override
  public TypeNode type() {
    return TypeNode.BOOLEAN;
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  // Convenience wrapper.
  public static LogicalOperationExpr logicalAndWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.LOGICAL_AND)
        .build();
  }

  // Convenience wrapper.
  public static LogicalOperationExpr logicalOrWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.LOGICAL_OR)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_LogicalOperationExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    // Private setter.
    abstract Builder setLhsExpr(Expr expr);

    // Private setter.
    abstract Builder setRhsExpr(Expr expr);

    // Private setter.
    abstract Builder setOperatorKind(OperatorKind operator);

    abstract LogicalOperationExpr autoBuild();

    private LogicalOperationExpr build() {
      LogicalOperationExpr logicalOperationExpr = autoBuild();
      TypeNode lhsExprType = logicalOperationExpr.lhsExpr().type();
      TypeNode rhsExprType = logicalOperationExpr.rhsExpr().type();
      OperatorKind operator = logicalOperationExpr.operatorKind();
      final String errorMsg =
          String.format(
              "Logical operator %s is valid only on boolean or its boxed type, found %s, %s.",
              operator, lhsExprType.toString(), rhsExprType.toString());
      Preconditions.checkState(
          lhsExprType.equals(TypeNode.BOOLEAN) && rhsExprType.equals(TypeNode.BOOLEAN), errorMsg);
      return logicalOperationExpr;
    }
  }
}
