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
public abstract class ReturnExpr implements Expr {
  public abstract Expr expr();

  @Override
  public TypeNode type() {
    return TypeNode.VOID;
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static ReturnExpr withExpr(Expr expr) {
    return builder().setExpr(expr).build();
  }

  // Private.
  static Builder builder() {
    return new AutoValue_ReturnExpr.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    public abstract Builder setExpr(Expr expr);

    // Private accessors.
    abstract Expr expr();

    abstract ReturnExpr autoBuild();

    public ReturnExpr build() {
      Preconditions.checkState(
          !(expr() instanceof ReturnExpr), "ReturnExpr can only return non-ReturnExpr expressions");
      return autoBuild();
    }
  }
}
