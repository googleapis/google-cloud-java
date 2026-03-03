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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@AutoValue
public abstract class TryCatchStatement implements Statement {

  // Required.
  public abstract ImmutableList<Statement> tryBody();

  // Optional only if the sample code bit is set (i.e. this is sample code).
  public abstract List<VariableExpr> catchVariableExprs();

  // Optional only if the sample code bit is set (i.e. this is sample code).
  public abstract List<List<Statement>> catchBlocks();

  // Optional.
  @Nullable
  public abstract AssignmentExpr tryResourceExpr();

  public abstract boolean isSampleCode();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_TryCatchStatement.Builder()
        .setCatchVariableExprs(Collections.emptyList())
        .setCatchBlocks(Collections.emptyList())
        .setIsSampleCode(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setTryResourceExpr(AssignmentExpr assignmentExpr);

    public abstract Builder setTryBody(List<Statement> body);

    public abstract Builder setIsSampleCode(boolean isSampleCode);

    public Builder addCatch(@Nonnull VariableExpr variableExpr, List<Statement> body) {
      List<VariableExpr> catchVarExprs = new ArrayList<>(catchVariableExprs());
      catchVarExprs.add(variableExpr);
      setCatchVariableExprs(catchVarExprs);

      List<List<Statement>> blocks = new ArrayList<>(catchBlocks());
      blocks.add(body);
      return setCatchBlocks(blocks);
    }

    // Private.
    abstract Builder setCatchVariableExprs(List<VariableExpr> variableExpr);

    abstract Builder setCatchBlocks(List<List<Statement>> body);

    abstract ImmutableList<Statement> tryBody();

    abstract boolean isSampleCode();

    abstract List<VariableExpr> catchVariableExprs();

    abstract List<List<Statement>> catchBlocks();

    abstract TryCatchStatement autoBuild();

    public TryCatchStatement build() {
      NodeValidator.checkNoNullElements(tryBody(), "try body", "try-catch");
      NodeValidator.checkNoNullElements(
          catchVariableExprs(), "catch variable expressions", "try-catch");
      catchBlocks()
          .forEach(body -> NodeValidator.checkNoNullElements(body, "catch body", "try-catch"));

      if (!isSampleCode()) {
        Preconditions.checkState(
            !catchVariableExprs().isEmpty(),
            "Catch variable expression must be set for real, non-sample try-catch blocks.");
        Preconditions.checkState(
            catchVariableExprs().stream().allMatch(v -> v.isDecl()),
            "Catch variable expressions must all be declarations");
        Preconditions.checkState(
            catchVariableExprs().stream()
                .allMatch(v -> TypeNode.isExceptionType(v.variable().type())),
            "Catch variables must be an Exception object references");
      }

      // Catch any potential future breakage due to changing addCatch above.
      Preconditions.checkState(
          catchVariableExprs().size() == catchBlocks().size(),
          String.format(
              "%d catch variables found and %d blocks found, but these numbers must be equal",
              catchVariableExprs().size(), catchBlocks().size()));

      return autoBuild();
    }
  }
}
