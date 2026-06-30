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
public abstract class TernaryExpr implements Expr {
  public abstract Expr conditionExpr();

  public abstract Expr thenExpr();

  public abstract Expr elseExpr();

  @Override
  public TypeNode type() {
    TypeNode thenType = thenExpr().type();
    TypeNode elseType = elseExpr().type();
    if (thenType.isPrimitiveType() || elseType.isPrimitiveType()) {
      // If both types are equal primitive, return either of them (elseType).
      // If types are boxed/primitive equal, return the boxed type.
      return thenType.isPrimitiveType() ? elseType : thenType;
    } else {
      // If both types are reference types, return the super type.
      if (thenType.isSupertypeOrEquals(elseType) && !thenType.equals(TypeNode.NULL)) {
        return thenType;
      }
      return elseType;
    }
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_TernaryExpr.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setConditionExpr(Expr conditionExpr);

    public abstract Builder setThenExpr(Expr thenExpression);

    public abstract Builder setElseExpr(Expr elseExpression);

    // Private accessors.
    abstract Expr conditionExpr();

    abstract Expr thenExpr();

    abstract Expr elseExpr();

    abstract TernaryExpr autoBuild();

    public TernaryExpr build() {
      Preconditions.checkState(
          conditionExpr().type().equals(TypeNode.BOOLEAN),
          "Ternary condition must be a boolean-typed expression.");

      if (!thenExpr().type().equals(elseExpr().type())) {
        Preconditions.checkState(
            thenExpr().type().isSupertypeOrEquals(elseExpr().type())
                || elseExpr().type().isSupertypeOrEquals(thenExpr().type()),
            "The second and third expressions must be assignable types of the other");
      }
      return autoBuild();
    }
  }
}
