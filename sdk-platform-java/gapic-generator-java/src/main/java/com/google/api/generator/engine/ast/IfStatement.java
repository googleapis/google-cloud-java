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
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class IfStatement implements Statement {
  public abstract Expr conditionExpr();

  public abstract ImmutableList<Statement> body();

  public abstract ImmutableMap<Expr, List<Statement>> elseIfs(); // Optional.

  public abstract ImmutableList<Statement> elseBody(); // Optional.

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_IfStatement.Builder()
        .setElseIfs(ImmutableMap.of())
        .setElseBody(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setConditionExpr(Expr expr);

    public abstract Builder setBody(List<Statement> body);

    public abstract Builder setElseBody(List<Statement> elseBody);

    public Builder addElseIf(Expr conditionExpr, List<Statement> body) {
      elseIfsBuilder().put(conditionExpr, body);
      return this;
    }

    abstract ImmutableMap.Builder<Expr, List<Statement>> elseIfsBuilder();

    abstract Builder setElseIfs(ImmutableMap<Expr, List<Statement>> elseIfBlocks);

    abstract IfStatement autoBuild();

    public IfStatement build() {
      IfStatement ifStatement = autoBuild();
      NodeValidator.checkNoNullElements(ifStatement.body(), "body", "if-statement");
      NodeValidator.checkNoNullElements(ifStatement.elseIfs(), "else-ifs", "if-statement");
      NodeValidator.checkNoNullElements(ifStatement.elseBody(), "else-body", "if-statement");

      Preconditions.checkState(
          ifStatement.conditionExpr().type().equals(TypeNode.BOOLEAN),
          "If-condition must be a boolean-typed expression");
      return ifStatement;
    }
  }
}
