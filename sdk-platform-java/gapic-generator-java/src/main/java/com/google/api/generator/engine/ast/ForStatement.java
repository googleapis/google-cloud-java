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
import com.google.common.collect.ImmutableList;
import java.util.List;

@AutoValue
public abstract class ForStatement implements Statement {
  public abstract VariableExpr localVariableExpr();

  public abstract Expr collectionExpr();

  public abstract ImmutableList<Statement> body();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_ForStatement.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setLocalVariableExpr(VariableExpr variableExpr);

    public abstract Builder setBody(List<Statement> body);

    public abstract Builder setCollectionExpr(Expr collectionExpr);

    abstract ForStatement autoBuild();

    public ForStatement build() {
      ForStatement forStatement = autoBuild();
      NodeValidator.checkNoNullElements(forStatement.body(), "body", "for-statement");
      Preconditions.checkState(
          forStatement.localVariableExpr().isDecl(),
          "For-statement variable must be a declaration");
      return forStatement;
    }
  }
}
