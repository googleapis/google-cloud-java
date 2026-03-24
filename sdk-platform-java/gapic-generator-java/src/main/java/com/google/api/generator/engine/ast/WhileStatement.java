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
public abstract class WhileStatement implements Statement {

  public abstract Expr conditionExpr();

  public abstract ImmutableList<Statement> body();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_WhileStatement.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setConditionExpr(Expr expr);

    public abstract Builder setBody(List<Statement> body);

    // Private.
    abstract ImmutableList<Statement> body();

    abstract WhileStatement autoBuild();

    public WhileStatement build() {
      WhileStatement whileStatement = autoBuild();
      NodeValidator.checkNoNullElements(body(), "body", "while statement");
      Preconditions.checkState(
          whileStatement.conditionExpr().type().equals(TypeNode.BOOLEAN),
          "While condition must be a boolean-typed expression");
      return whileStatement;
    }
  }
}
