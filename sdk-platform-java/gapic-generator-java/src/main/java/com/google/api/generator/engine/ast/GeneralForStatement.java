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
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class GeneralForStatement implements Statement {
  public abstract Expr initializationExpr();

  public abstract Expr terminationExpr();

  public abstract Expr updateExpr();

  public abstract ImmutableList<Statement> body();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  // incrementWith is convenience wrapper to generate index-base for-loop with lower and upper bound
  // and post increment on variable, like code in ```for (int i = 0; i < getMax(); i++) {..}```
  // TODO (unsupported): Add more convenience wrapper for the future generation needs.
  public static GeneralForStatement incrementWith(
      VariableExpr localVariableExpr,
      ValueExpr initialValueExpr,
      Expr maxSizeExpr,
      List<Statement> body) {
    return builder()
        .setInitializationExpr(
            AssignmentExpr.builder()
                .setVariableExpr(localVariableExpr)
                .setValueExpr(initialValueExpr)
                .build())
        .setTerminationExpr(
            RelationalOperationExpr.lessThanWithExprs(
                localVariableExpr.toBuilder().setIsDecl(false).build(), maxSizeExpr))
        .setUpdateExpr(
            UnaryOperationExpr.postfixIncrementWithExpr(
                localVariableExpr.toBuilder().setIsDecl(false).build()))
        .setBody(body)
        .build();
  }

  private static Builder builder() {
    return new AutoValue_GeneralForStatement.Builder().setBody(Collections.emptyList());
  }

  @AutoValue.Builder
  abstract static class Builder {
    // Private setter.
    abstract Builder setInitializationExpr(Expr initializationExpr);

    // Private setter.
    abstract Builder setTerminationExpr(Expr terminationExpr);

    // Private setter.
    abstract Builder setUpdateExpr(Expr incrementExpr);

    // Private setter.
    abstract Builder setBody(List<Statement> body);

    abstract GeneralForStatement autoBuild();

    // Type-checking will be done in the sub-expressions.
    GeneralForStatement build() {
      GeneralForStatement generalForStatement = autoBuild();
      NodeValidator.checkNoNullElements(
          generalForStatement.body(), "body", "general for-statement");
      Expr initExpr = generalForStatement.initializationExpr();
      if (initExpr instanceof AssignmentExpr) {
        VariableExpr localVarExpr = ((AssignmentExpr) initExpr).variableExpr();
        // Declare a variable inside for-loop initialization expression.
        if (localVarExpr.isDecl()) {
          Preconditions.checkState(
              localVarExpr.scope().equals(ScopeNode.LOCAL),
              String.format(
                  "Variable %s declare in a general for-loop cannot have a non-local scope",
                  localVarExpr.variable().identifier().name()));
          Preconditions.checkState(!localVarExpr.isStatic(), "Modifier 'static' not allow here.");
        }
      }
      // TODO (unsupport): Add type-checking for initialization, termination, update exprs if public
      // setters for users for future needs.
      // Initialization and update expr should belong to StatementExpressionList.
      // Termination expr must have type boolean or Boolean. And these three exprs are optional.
      // More details at
      // https://docs.oracle.com/javase/specs/jls/se10/html/jls-14.html#jls-StatementExpressionList
      return autoBuild();
    }
  }
}
