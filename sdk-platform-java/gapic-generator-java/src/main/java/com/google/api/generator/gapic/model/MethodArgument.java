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

package com.google.api.generator.gapic.model;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;
import java.util.List;

@AutoValue
public abstract class MethodArgument implements Comparable<MethodArgument> {
  // The method argument name.
  public abstract String name();

  // The type. This can be different from the associated field (e.g. for resource references).
  public abstract TypeNode type();

  // Additional metadata.
  public abstract Field field();

  // Records the path of nested fields in descending order, excluding type() (which would have
  // appeared as the last element).
  public abstract ImmutableList<Field> nestedFields();

  // Returns true if this is a resource name helper method argument.
  public abstract boolean isResourceNameHelper();

  @Override
  public int compareTo(MethodArgument other) {
    int compareVal = type().compareTo(other.type());
    if (compareVal == 0) {
      compareVal = name().compareTo(other.name());
    }
    return compareVal;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof MethodArgument)) {
      return false;
    }

    MethodArgument other = (MethodArgument) o;
    return name().equals(other.name())
        && type().equals(other.type())
        && field().equals(other.field()) & nestedFields().equals(other.nestedFields())
        && isResourceNameHelper() == other.isResourceNameHelper();
  }

  @Override
  public int hashCode() {
    return 17 * name().hashCode()
        + 19 * type().hashCode()
        + 23 * field().hashCode()
        + 29 * nestedFields().hashCode()
        + (isResourceNameHelper() ? 1 : 0) * 31;
  }

  public static Builder builder() {
    return new AutoValue_MethodArgument.Builder()
        .setNestedFields(ImmutableList.of())
        .setIsResourceNameHelper(false);
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setType(TypeNode type);

    public abstract Builder setField(Field field);

    public abstract Builder setNestedFields(List<Field> nestedFields);

    public abstract Builder setIsResourceNameHelper(boolean isResourceNameHelper);

    public abstract MethodArgument build();
  }
}
