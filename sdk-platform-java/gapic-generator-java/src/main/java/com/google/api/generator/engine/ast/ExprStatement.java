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
public abstract class ExprStatement implements Statement {
  public abstract Expr expression();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static ExprStatement withExpr(Expr expr) {
    return builder().setExpression(expr).build();
  }

  static Builder builder() {
    return new AutoValue_ExprStatement.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setExpression(Expr expr);

    abstract ExprStatement autoBuild();

    public ExprStatement build() {
      ExprStatement exprStatement = autoBuild();
      Expr expr = exprStatement.expression();
      if (expr instanceof VariableExpr) {
        VariableExpr variableExpr = (VariableExpr) expr;
        Preconditions.checkState(
            variableExpr.isDecl(), "Expression variable statements must be declarations");
      } else {
        Preconditions.checkState(
            (expr instanceof MethodInvocationExpr)
                || (expr instanceof ReferenceConstructorExpr)
                || (expr instanceof AssignmentExpr)
                || (expr instanceof AssignmentOperationExpr)
                || (expr instanceof ThrowExpr)
                || (expr instanceof ReturnExpr)
                || (expr instanceof UnaryOperationExpr
                    && ((UnaryOperationExpr) expr).isPostfixIncrement()),
            "Expression statements must be either a method invocation, assignment, throw, "
                + "this/super constructor, return, or unary post-fix operation expression");
      }
      return exprStatement;
    }
  }
}
