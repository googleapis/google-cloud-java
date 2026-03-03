// Copyright 2022 Google LLC
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
import java.util.List;

@AutoValue
public abstract class ArrayExpr implements Expr {

  public abstract List<Expr> exprs();

  public abstract TypeNode type();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static ArrayExpr.Builder builder() {
    return new AutoValue_ArrayExpr.Builder().setExprs(ImmutableList.of());
  }

  public static ArrayExpr withStrings(String... stringValues) {
    ArrayExpr.Builder builder = ArrayExpr.builder();
    Arrays.asList(stringValues).stream().forEach(s -> builder.addExpr(s));
    return builder.build();
  }

  public static ArrayExpr withExprs(Expr... exprs) {
    return ArrayExpr.builder().setExprs(Arrays.asList(exprs)).build();
  }

  @AutoValue.Builder
  public abstract static class Builder {

    private static final String SAME_TYPE_EXPRS_MESSAGE =
        "All expressions must be of the type" + " specified in this ArrayExpr";
    private static final String EXPR_ALLOWED_CLASSES_MESSAGE =
        "Only VariableExpr and ValueExpr can be used as elements of ArrayExpr";

    abstract List<Expr> exprs();

    abstract TypeNode type();

    /**
     * To add a string expression same-type validation is performed
     *
     * @param expr
     * @return Builder
     */
    public ArrayExpr.Builder addExpr(String expr) {
      return addExpr(ValueExpr.withValue(StringObjectValue.withValue(expr)));
    }

    public ArrayExpr.Builder addExpr(Expr expr) {
      return setExprs((new ImmutableList.Builder<Expr>().addAll(exprs()).add(expr).build()));
    }

    public abstract ArrayExpr.Builder setExprs(List<Expr> exprs);

    public abstract ArrayExpr.Builder setType(TypeNode type);

    abstract ArrayExpr autoBuild();

    public ArrayExpr build() {
      Preconditions.checkState(
          exprs().stream().allMatch(exp -> exp instanceof ValueExpr || exp instanceof VariableExpr),
          EXPR_ALLOWED_CLASSES_MESSAGE);
      TypeNode elementType = TypeNode.createElementTypeFromArrayType(type());
      Preconditions.checkState(
          exprs().stream().allMatch(exp -> exp.type().equals(elementType)),
          SAME_TYPE_EXPRS_MESSAGE);
      return autoBuild();
    }
  }
}
