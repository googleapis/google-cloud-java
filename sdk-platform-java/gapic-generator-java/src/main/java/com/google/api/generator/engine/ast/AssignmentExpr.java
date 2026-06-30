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
public abstract class AssignmentExpr implements Expr {
  public abstract VariableExpr variableExpr();

  public abstract Expr valueExpr();

  @Override
  public TypeNode type() {
    return TypeNode.VOID;
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_AssignmentExpr.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setVariableExpr(VariableExpr variableExpr);

    public abstract Builder setValueExpr(Expr valueExpr);

    abstract AssignmentExpr autoBuild();

    public AssignmentExpr build() {
      AssignmentExpr assignmentExpr = autoBuild();
      TypeNode lhsType = assignmentExpr.variableExpr().variable().type();
      TypeNode rhsType = assignmentExpr.valueExpr().type();
      if (lhsType.isPrimitiveType() || rhsType.isPrimitiveType()) {
        if (rhsType == TypeNode.NULL || lhsType == TypeNode.NULL) {
          throw new TypeMismatchException(
              String.format(
                  "Null cannot be assigned to the primitive type %s", lhsType.toString()));
        }
        if (!lhsType.equals(rhsType)) {
          throw new TypeMismatchException(
              String.format(
                  "LHS type %s must match RHS type %s", lhsType.toString(), rhsType.toString()));
        }
      } else {
        if (rhsType != TypeNode.NULL && !lhsType.isSupertypeOrEquals(rhsType)) {
          throw new TypeMismatchException(
              String.format(
                  "LHS type %s of variable %s must be a supertype of the RHS type %s",
                  lhsType.reference().name(),
                  assignmentExpr.variableExpr().variable().identifier(),
                  rhsType.reference().name()));
        }
      }

      if (!assignmentExpr.variableExpr().isDecl()) {
        Preconditions.checkState(
            !assignmentExpr.variableExpr().isFinal(),
            String.format(
                "Cannot assign a value to final variable '%s'.",
                assignmentExpr.variableExpr().variable().name()));
      }

      return assignmentExpr;
    }
  }
}
