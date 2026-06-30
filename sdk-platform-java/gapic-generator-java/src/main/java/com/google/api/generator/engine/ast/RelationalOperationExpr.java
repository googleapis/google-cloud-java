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
public abstract class RelationalOperationExpr implements OperationExpr {
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
  public static RelationalOperationExpr equalToWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.RELATIONAL_EQUAL_TO)
        .build();
  }

  // Convenience wrapper.
  public static RelationalOperationExpr notEqualToWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.RELATIONAL_NOT_EQUAL_TO)
        .build();
  }

  public static RelationalOperationExpr lessThanWithExprs(Expr lhsExpr, Expr rhsExpr) {
    return builder()
        .setLhsExpr(lhsExpr)
        .setRhsExpr(rhsExpr)
        .setOperatorKind(OperatorKind.RELATIONAL_LESS_THAN)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_RelationalOperationExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {

    // Private setter.
    abstract Builder setLhsExpr(Expr expr);

    // Private setter.
    abstract Builder setRhsExpr(Expr expr);

    // Private setter.
    abstract Builder setOperatorKind(OperatorKind operator);

    abstract RelationalOperationExpr autoBuild();

    private RelationalOperationExpr build() {
      RelationalOperationExpr relationalOperationExpr = autoBuild();
      TypeNode lhsExprType = relationalOperationExpr.lhsExpr().type();
      TypeNode rhsExprType = relationalOperationExpr.rhsExpr().type();
      OperatorKind operator = relationalOperationExpr.operatorKind();
      final String errorMsg =
          String.format(
              "Relational operator %s can not be applied to %s, %s.",
              operator, lhsExprType.toString(), rhsExprType.toString());

      if (operator.equals(OperatorKind.RELATIONAL_EQUAL_TO)
          || operator.equals(OperatorKind.RELATIONAL_NOT_EQUAL_TO)) {
        Preconditions.checkState(isValidEqualityType(lhsExprType, rhsExprType), errorMsg);
      }

      if (operator.equals(OperatorKind.RELATIONAL_LESS_THAN)) {
        Preconditions.checkState(isValidRelationalType(lhsExprType, rhsExprType), errorMsg);
      }

      return relationalOperationExpr;
    }

    // isValidEqualityType checks expressions' type for equality operator (==) and non-equality
    // operator (!=).
    private boolean isValidEqualityType(TypeNode lhsType, TypeNode rhsType) {
      // If the expression's types are matched, return true
      if (lhsType.equals(rhsType)) {
        return true;
      }

      // If the expressions' type are array, the types should be array and matched, or either is
      // null type;
      if (lhsType.isArray() || rhsType.isArray()) {
        return lhsType.equals(TypeNode.NULL) || rhsType.equals(TypeNode.NULL);
      }

      // If lhs expression type is numeric type (char, byte, short, int, long, double), the rhs
      // expression type should be any numeric type or any numeric boxed type
      if (TypeNode.isNumericType(lhsType) && TypeNode.isNumericType(rhsType)) {
        return true;
      }

      // If lhs expression type is new Object or null, the rhs type should be a reference type or
      // null or boxed type;
      if (lhsType.equals(TypeNode.OBJECT) || lhsType.equals(TypeNode.NULL)) {
        return TypeNode.isReferenceType(rhsType)
            || rhsType.equals(TypeNode.OBJECT)
            || rhsType.equals(TypeNode.NULL);
      }

      // If lhs expression type is Boxed type or a referenced type, rhs should be null or object,
      // other cases have been covered in previous conditions.
      if (TypeNode.isBoxedType(lhsType) || TypeNode.isReferenceType(lhsType)) {
        return rhsType.equals(TypeNode.NULL) || rhsType.equals(TypeNode.OBJECT);
      }

      return false;
    }

    // isValidRelationalType checks expressions' types for relational operators (<, >, <=, >=).
    // The <, >, <=, and >= can be used with primitive data types that can be represented in
    // numbers.
    // It will work with char, byte, short, int, long, float, double, but not with boolean.
    // These operators are not supported for objects.
    private boolean isValidRelationalType(TypeNode lhsType, TypeNode rhsType) {
      return TypeNode.isNumericType(lhsType) && TypeNode.isNumericType(rhsType);
    }
  }
}
