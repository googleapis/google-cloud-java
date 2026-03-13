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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AutoValue
public abstract class AnonymousClassExpr implements Expr {
  @Override
  public abstract TypeNode type();

  public abstract ImmutableList<MethodDefinition> methods();

  public abstract ImmutableList<Statement> statements();

  // TODO(unsupported): nested class is not supported.
  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_AnonymousClassExpr.Builder()
        .setMethods(Collections.emptyList())
        .setStatements(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode type);

    public Builder setMethods(MethodDefinition... methods) {
      return setMethods(Arrays.asList(methods));
    }

    public abstract Builder setMethods(List<MethodDefinition> methods);

    public abstract Builder setStatements(List<Statement> statements);

    public abstract AnonymousClassExpr autoBuild();

    public AnonymousClassExpr build() {
      AnonymousClassExpr anonymousClassExpr = autoBuild();

      // 1. The anonymous class expression should be reference types.
      Preconditions.checkState(
          TypeNode.isReferenceType(anonymousClassExpr.type()),
          "Anonymous class expression must be reference types.");

      // 2. Check that there are no null methods or statements.
      String contextInfo =
          String.format("anonymous class of type %s", anonymousClassExpr.type().reference().name());
      NodeValidator.checkNoNullElements(anonymousClassExpr.methods(), "methods", contextInfo);
      NodeValidator.checkNoNullElements(anonymousClassExpr.statements(), "statements", contextInfo);

      for (MethodDefinition method : anonymousClassExpr.methods()) {
        // 3. Static methods are not allowed in anonymous class.
        Preconditions.checkState(!method.isStatic(), "Anonymous class cannot have static methods.");
        // 4. Anonymous class cannot have explicit constructors.
        Preconditions.checkState(
            !method.isConstructor(), "Anonymous class cannot have explicit constructors.");
      }
      // 5. Static variable expression is not allowed unless it is final.
      for (Statement statement : anonymousClassExpr.statements()) {
        if (statement instanceof ExprStatement) {
          Expr expr = ((ExprStatement) statement).expression();
          if (expr instanceof VariableExpr) {
            Preconditions.checkState(
                validVariableExpr((VariableExpr) expr),
                "Anonymous class cannot have static variable expression unless it is final.");
          } else if (expr instanceof AssignmentExpr) {
            Preconditions.checkState(
                validVariableExpr(((AssignmentExpr) expr).variableExpr()),
                "Anonymous class cannot have static variable expression in assignment expression"
                    + " unless it is final.");
          }
        }
      }
      return anonymousClassExpr;
    }

    private boolean validVariableExpr(VariableExpr expr) {
      return !expr.isStatic() || expr.isFinal();
    }
  }
}
