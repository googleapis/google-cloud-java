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
public abstract class ReferenceConstructorExpr implements Expr {
  public enum KeywordKind {
    THIS,
    SUPER
  }

  @Override
  public abstract TypeNode type();

  public abstract KeywordKind keywordKind();

  public abstract ImmutableList<Expr> arguments();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder thisBuilder() {
    return new AutoValue_ReferenceConstructorExpr.Builder()
        .setArguments(Collections.emptyList())
        .setKeywordKind(KeywordKind.THIS);
  }

  public static Builder superBuilder() {
    return new AutoValue_ReferenceConstructorExpr.Builder()
        .setArguments(Collections.emptyList())
        .setKeywordKind(KeywordKind.SUPER);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode node);

    public Builder setArguments(Expr... arguments) {
      return setArguments(Arrays.asList(arguments));
    }

    public abstract Builder setArguments(List<Expr> arguments);

    // private.
    abstract Builder setKeywordKind(KeywordKind keywordKind);

    abstract TypeNode type();

    abstract ImmutableList<Expr> arguments();

    abstract ReferenceConstructorExpr autoBuild();

    public ReferenceConstructorExpr build() {
      ReferenceConstructorExpr referenceConstructorExpr = autoBuild();
      Preconditions.checkState(
          TypeNode.isReferenceType(referenceConstructorExpr.type()),
          "A this/super constructor must have a reference type.");

      NodeValidator.checkNoNullElements(
          arguments(), "the \"this\" or \"super\" initialization", type().reference().name());

      return referenceConstructorExpr;
    }
  }
}
