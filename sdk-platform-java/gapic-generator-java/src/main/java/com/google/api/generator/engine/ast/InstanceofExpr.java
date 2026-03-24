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
public abstract class InstanceofExpr implements Expr {
  public abstract Expr expr();

  public abstract TypeNode checkType();

  @Override
  public TypeNode type() {
    return TypeNode.BOOLEAN;
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_InstanceofExpr.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setExpr(Expr expr);

    public abstract Builder setCheckType(TypeNode checkType);

    abstract InstanceofExpr autoBuild();

    public InstanceofExpr build() {
      InstanceofExpr instanceofExpr = autoBuild();
      Preconditions.checkState(
          TypeNode.isReferenceType(instanceofExpr.checkType()),
          "Instanceof can only check reference types");
      return instanceofExpr;
    }
  }
}
