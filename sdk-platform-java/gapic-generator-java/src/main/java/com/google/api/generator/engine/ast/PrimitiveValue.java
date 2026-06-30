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

import com.google.api.generator.engine.lexicon.Literal;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PrimitiveValue implements Value {
  @Override
  public abstract TypeNode type();

  @Override
  public abstract String value();

  public static Builder builder() {
    return new AutoValue_PrimitiveValue.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setType(TypeNode type);

    public abstract Builder setValue(String value);

    abstract PrimitiveValue autoBuild();

    public PrimitiveValue build() throws TypeMismatchException {
      // TODO(unsupported): byte, short, char, array initialization.
      PrimitiveValue primitiveValue = autoBuild();
      TypeNode type = primitiveValue.type();
      String value = primitiveValue.value();
      if (!typeMatchesValue(type, value)) {
        throw new TypeMismatchException(
            String.format("Type %s does not match value %s", type.typeKind(), value));
      }
      return primitiveValue;
    }

    private static boolean typeMatchesValue(TypeNode type, String value) {
      switch (type.typeKind()) {
        case INT:
          return Literal.isIntegerLiteral(value);
        case LONG:
          return Literal.isLongLiteral(value);
        case FLOAT:
          return Literal.isFloatLiteral(value);
        case DOUBLE:
          return Literal.isDoubleLiteral(value);
        case BOOLEAN:
          return Literal.isBooleanLiteral(value);
        case OBJECT: // Fall through.
        case BYTE: // Fall through.
        case CHAR: // Fall through.
        case SHORT: // Fall through.
        default:
      }
      return false;
    }
  }
}
