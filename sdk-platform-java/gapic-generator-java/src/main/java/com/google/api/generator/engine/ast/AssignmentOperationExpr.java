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
public abstract class AssignmentOperationExpr implements OperationExpr {
  public abstract VariableExpr variableExpr();

  public abstract Expr valueExpr();

  @Override
  public abstract OperatorKind operatorKind();

  @Override
  public TypeNode type() {
    return variableExpr().type();
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static AssignmentOperationExpr xorAssignmentWithExprs(
      VariableExpr variableExpr, Expr valueExpr) {
    return builder()
        .setVariableExpr(variableExpr)
        .setValueExpr(valueExpr)
        .setOperatorKind(OperatorKind.ASSIGNMENT_XOR)
        .build();
  }

  public static AssignmentOperationExpr multiplyAssignmentWithExprs(
      VariableExpr variableExpr, Expr valueExpr) {
    return builder()
        .setVariableExpr(variableExpr)
        .setValueExpr(valueExpr)
        .setOperatorKind(OperatorKind.ASSIGNMENT_MULTIPLY)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_AssignmentOperationExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    // Private setter.
    abstract Builder setVariableExpr(VariableExpr variableExpr);

    // Private setter.
    abstract Builder setValueExpr(Expr valueExpr);

    // Private setter.
    abstract Builder setOperatorKind(OperatorKind operator);

    abstract AssignmentOperationExpr autoBuild();

    private AssignmentOperationExpr build() {
      AssignmentOperationExpr assignmentOperationExpr = autoBuild();
      TypeNode lhsType = assignmentOperationExpr.variableExpr().variable().type();
      TypeNode rhsType = assignmentOperationExpr.valueExpr().type();
      OperatorKind operator = assignmentOperationExpr.operatorKind();

      // Check if the variable exprs have been declared, if yes, throw error.
      Preconditions.checkState(
          !assignmentOperationExpr.variableExpr().isDecl(),
          String.format(
              "Variable `%s` should not be declaration in the variable expression.",
              assignmentOperationExpr.variableExpr().variable().name()));

      // errorMsg is type checking error message for operators.
      final String errorMsg =
          String.format(
              "Assignment operator %s can not be applied to %s, %s.",
              operator, lhsType.toString(), rhsType.toString());

      // Check type for multiply and assignment operator (*=).
      if (operator.equals(OperatorKind.ASSIGNMENT_MULTIPLY)) {
        Preconditions.checkState(isValidMultiplyAssignmentType(lhsType, rhsType), errorMsg);
      }

      // Check type for XOR and assignment operator (^=).
      if (operator.equals(OperatorKind.ASSIGNMENT_XOR)) {
        Preconditions.checkState(isValidXorAssignmentType(lhsType, rhsType), errorMsg);
      }
      return assignmentOperationExpr;
    }

    // isValidMultiplyAssignmentType validates the types for LHS variable expr and RHS expr.
    // *= can be only applied on Primitive numeric type.
    private boolean isValidMultiplyAssignmentType(TypeNode variableType, TypeNode valueType) {
      // LHS is numeric type, RHS should be any numeric type or any numeric boxed type.
      if (TypeNode.isNumericType(variableType) && !TypeNode.isBoxedType(variableType)) {
        return TypeNode.isNumericType(valueType);
      }
      // LHS is integer boxed type, RHS should be any numeric type except long, float, double.
      if (variableType.equals(TypeNode.INT)) {
        return TypeNode.isNumericType(valueType)
            && !(valueType.equals(TypeNode.LONG) || TypeNode.isFloatingPointType(valueType));
      }
      // LHS is long boxed type, RHS should be any numeric type except float, double.
      if (variableType.equals(TypeNode.LONG)) {
        return TypeNode.isNumericType(valueType) && !TypeNode.isFloatingPointType(valueType);
      }
      // LHS is integer boxed type, RHS should be any numeric type except double.
      if (variableType.equals(TypeNode.FLOAT)) {
        return TypeNode.isNumericType(valueType) && !valueType.equals(TypeNode.DOUBLE);
      }
      // LHS is integer boxed type, RHS should be any numeric type or any numeric boxed type.
      if (variableType.equals(TypeNode.DOUBLE)) {
        return TypeNode.isNumericType(valueType);
      }
      // *= operator does not support boxed Short, Character, Byte, null, reference, void type.
      return false;
    }

    // isValidXorAssignmentType validates the types for LHS variable expr and RHS expr.
    // ^= can be applied on boolean and non-floating-point numeric type.
    private boolean isValidXorAssignmentType(TypeNode variableType, TypeNode valueType) {
      // LHS is boolean or its boxed type, RHS should be boolean or its boxed type.
      if (variableType.equals(TypeNode.BOOLEAN)) {
        return valueType.equals(variableType);
      }
      // LHS is integer boxed type, RHS should be non-floating-point numeric types or their boxed
      // types.
      if (variableType.equals(TypeNode.INT)) {
        return TypeNode.isNumericType(valueType) && !TypeNode.isFloatingPointType(valueType);
      }
      // LHS is non-floating-point numeric types, RHS should be non-float-point numeric types or
      // their boxed types.
      return TypeNode.isNumericType(variableType)
          && TypeNode.isNumericType(valueType)
          && !TypeNode.isFloatingPointType(variableType)
          && !TypeNode.isFloatingPointType(valueType)
          && !TypeNode.isBoxedType(variableType);
    }
  }
}
