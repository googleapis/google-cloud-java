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
public abstract class SuperObjectValue implements ObjectValue {
  private static final String SUPER_VALUE = "super";

  @Override
  public abstract TypeNode type();

  @Override
  public String value() {
    return SUPER_VALUE;
  }

  // Note: This is the type of "super" object, and not the child type of the supertype.
  public static SuperObjectValue withType(TypeNode type) {
    return builder().setType(type).build();
  }

  private static Builder builder() {
    return new AutoValue_SuperObjectValue.Builder();
  }

  @AutoValue.Builder
  abstract static class Builder {
    abstract Builder setType(TypeNode type);

    abstract SuperObjectValue autoBuild();

    private SuperObjectValue build() {
      SuperObjectValue superObjectValue = autoBuild();
      Preconditions.checkState(
          TypeNode.isReferenceType(superObjectValue.type()),
          "The \"super\" can only refer to object types");
      return superObjectValue;
    }
  }
}
