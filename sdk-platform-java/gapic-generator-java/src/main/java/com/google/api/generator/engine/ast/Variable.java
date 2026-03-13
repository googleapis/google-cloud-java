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
public abstract class Variable {
  public abstract IdentifierNode identifier();

  public abstract TypeNode type();

  abstract String name();

  public static Builder builder() {
    return new AutoValue_Variable.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode type);

    public abstract Builder setName(String name);

    abstract String name();

    abstract Builder setIdentifier(IdentifierNode identifier);

    abstract Variable autoBuild();

    public Variable build() {
      IdentifierNode identifier =
          IdentifierNode.builder().setName(name()).buildVariableIdentifier();
      setIdentifier(identifier);

      Variable variable = autoBuild();
      Preconditions.checkState(
          !variable.type().typeKind().equals(TypeNode.TypeKind.VOID),
          "Variable type cannot be void");
      Preconditions.checkState(
          !variable.type().equals(TypeNode.NULL), "Variable type cannot be null");
      return variable;
    }
  }
}
