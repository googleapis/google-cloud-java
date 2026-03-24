// Copyright 2021 Google LLC
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
import java.util.Set;
import java.util.stream.Collectors;

@AutoValue
public abstract class LambdaExpr implements Expr {
  @Override
  public TypeNode type() {
    return returnExpr().expr().type();
  }

  public abstract ImmutableList<VariableExpr> arguments();

  public abstract ReturnExpr returnExpr();

  public abstract ImmutableList<Statement> body();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_LambdaExpr.Builder()
        .setArguments(Collections.emptyList())
        .setBody(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public Builder setArguments(VariableExpr... arguments) {
      return setArguments(Arrays.asList(arguments));
    }

    public abstract Builder setArguments(List<VariableExpr> arguments);

    public abstract Builder setBody(List<Statement> body);

    public abstract Builder setReturnExpr(ReturnExpr returnExpr);

    public Builder setReturnExpr(Expr expr) {
      return setReturnExpr(ReturnExpr.builder().setExpr(expr).build());
    }

    public abstract LambdaExpr autoBuild();

    public LambdaExpr build() {
      LambdaExpr lambdaExpr = autoBuild();
      // Must be a declaration.
      lambdaExpr.arguments().stream()
          .forEach(
              varExpr ->
                  Preconditions.checkState(
                      varExpr.isDecl(),
                      String.format(
                          "Argument %s must be a variable declaration",
                          varExpr.variable().identifier())));
      // No modifiers allowed.
      lambdaExpr.arguments().stream()
          .forEach(
              varExpr ->
                  Preconditions.checkState(
                      varExpr.scope().equals(ScopeNode.LOCAL)
                          && !varExpr.isStatic()
                          && !varExpr.isFinal()
                          && !varExpr.isVolatile(),
                      String.format(
                          "Argument %s must have local scope, and cannot have static, final, or"
                              + " volatile modifiers",
                          varExpr.variable().identifier())));

      // Check that there aren't any arguments with duplicate names.
      List<String> allArgNames =
          lambdaExpr.arguments().stream()
              .map(v -> v.variable().identifier().name())
              .collect(Collectors.toList());
      Set<String> duplicateArgNames =
          allArgNames.stream()
              .filter(n -> Collections.frequency(allArgNames, n) > 1)
              .collect(Collectors.toSet());
      Preconditions.checkState(
          duplicateArgNames.isEmpty(),
          String.format(
              "Lambda arguments cannot have duplicate names: %s", duplicateArgNames.toString()));

      return lambdaExpr;
    }
  }
}
