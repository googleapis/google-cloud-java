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
public abstract class NewObjectExpr implements Expr {
  @Override
  public abstract TypeNode type();

  public abstract ImmutableList<Expr> arguments();

  public abstract boolean isGeneric();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static NewObjectExpr withType(TypeNode type) {
    return builder().setType(type).build();
  }

  public static Builder builder() {
    return new AutoValue_NewObjectExpr.Builder()
        .setArguments(Collections.emptyList())
        .setIsGeneric(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode type);

    public Builder setArguments(Expr... arguments) {
      return setArguments(Arrays.asList(arguments));
    }

    public abstract Builder setArguments(List<Expr> arguments);

    public abstract Builder setIsGeneric(boolean isGeneric);

    // Private accessors.
    abstract TypeNode type();

    abstract boolean isGeneric();

    abstract ImmutableList<Expr> arguments();

    abstract NewObjectExpr autoBuild();

    public NewObjectExpr build() {
      Preconditions.checkState(
          TypeNode.isReferenceType(type()), "New object expression should be reference types.");

      NodeValidator.checkNoNullElements(
          arguments(), "the \"new\" constructor", type().reference().name());

      // Only the case where generics() is empty and isGeneric() is false, we set isGeneric() to
      // false. Otherwise, isGeneric() should be true.
      setIsGeneric(isGeneric() || !type().reference().generics().isEmpty());
      return autoBuild();
    }
  }
}
