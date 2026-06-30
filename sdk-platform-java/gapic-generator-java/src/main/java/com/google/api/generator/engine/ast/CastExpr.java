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
public abstract class CastExpr implements Expr {
  @Override
  public abstract TypeNode type();

  public abstract Expr expr();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_CastExpr.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode type);

    public abstract Builder setExpr(Expr expr);

    abstract CastExpr autoBuild();

    public CastExpr build() {
      CastExpr castExpr = autoBuild();
      TypeNode castType = castExpr.type();
      TypeNode exprType = castExpr.expr().type();
      Preconditions.checkState(
          !castType.equals(TypeNode.VOID) && !exprType.equals(TypeNode.VOID),
          "Casting cannot be done on or to void types");

      // Only numeric types can be casted around.
      if (castType.isPrimitiveType() && exprType.isPrimitiveType()) {
        // Check that the types are either both booleans or both not booleans.
        Preconditions.checkState(
            !(castType.equals(TypeNode.BOOLEAN) ^ exprType.equals(TypeNode.BOOLEAN)),
            "Numeric and boolean types are not inter-castable");
      } else {
        boolean isExprTypeReferenceOrNull =
            exprType.equals(TypeNode.NULL) || TypeNode.isReferenceType(exprType);
        boolean isValidReferenceTypeCast =
            TypeNode.isReferenceType(castType) && isExprTypeReferenceOrNull;
        boolean isEqualType = castType.equals(exprType);
        Preconditions.checkState(
            isEqualType || isValidReferenceTypeCast,
            "Boxed type and primitive type are inter-castable, otherwise reference types can only be casted to reference types or null type.");
      }
      return castExpr;
    }
  }
}
