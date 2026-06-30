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
import java.util.List;

@AutoValue
public abstract class SynchronizedStatement implements Statement {
  public abstract Expr lock();

  public abstract ImmutableList<Statement> body();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_SynchronizedStatement.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public Builder setLock(ThisObjectValue thisObjectValue) {
      return setLock(ValueExpr.withValue(thisObjectValue));
    }

    public Builder setLock(VariableExpr variableExpr) {
      // This will also prevent declared variables (i.e. setIsDecl(true)) due to their void types.
      Preconditions.checkState(
          TypeNode.isReferenceType(variableExpr.type()),
          String.format(
              "Synchronized lock object %s must be an object type, was %s",
              variableExpr.variable().identifier().name(), variableExpr.type()));
      return setLock((Expr) variableExpr);
    }

    public Builder setBody(Statement... statements) {
      return setBody(Arrays.asList(statements));
    }

    public abstract Builder setBody(List<Statement> body);

    // Private.
    abstract Builder setLock(Expr expr);

    abstract ImmutableList<Statement> body();

    abstract SynchronizedStatement autoBuild();

    public SynchronizedStatement build() {
      NodeValidator.checkNoNullElements(body(), "body statements", "synchronized statement");

      return autoBuild();
    }
  }
}
