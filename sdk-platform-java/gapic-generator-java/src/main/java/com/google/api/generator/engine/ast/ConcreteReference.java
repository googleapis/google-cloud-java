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
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@AutoValue
public abstract class ConcreteReference implements Reference {
  private static final String EXTENDS = "extends";

  private static final String COMMA = ", ";
  private static final String DOT = ".";
  private static final String SPACE = " ";
  private static final String LEFT_ANGLE = "<";
  private static final String RIGHT_ANGLE = ">";
  private static final String QUESTION_MARK = "?";

  private static final Class<?> WILDCARD_CLAZZ = ReferenceWildcard.class;

  // Private.
  abstract Class<?> clazz();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  @Nullable
  @Override
  public abstract Reference wildcardUpperBound();

  @Override
  public abstract ImmutableList<Reference> generics();

  @Override
  public abstract boolean isStaticImport();

  @Override
  public String name() {
    StringBuilder sb = new StringBuilder();
    if (isWildcard()) {
      sb.append(QUESTION_MARK);
      if (wildcardUpperBound() != null) {
        // Handle the upper bound.
        sb.append(SPACE);
        sb.append(EXTENDS);
        sb.append(SPACE);
        sb.append(wildcardUpperBound().name());
      }
    } else {
      if (hasEnclosingClass() && !isStaticImport()) {
        sb.append(clazz().getEnclosingClass().getSimpleName());
        sb.append(DOT);
      }
      sb.append(clazz().getSimpleName());
    }
    if (!generics().isEmpty()) {
      sb.append(LEFT_ANGLE);
      for (int i = 0; i < generics().size(); i++) {
        Reference r = generics().get(i);
        sb.append(r.name());
        if (i < generics().size() - 1) {
          sb.append(COMMA);
        }
      }
      sb.append(RIGHT_ANGLE);
    }
    return sb.toString();
  }

  @Override
  public String simpleName() {
    return clazz().getSimpleName();
  }

  @Override
  public String pakkage() {
    return clazz().getPackage().getName();
  }

  @Override
  public abstract boolean useFullName();

  @Override
  public ImmutableList<String> enclosingClassNames() {
    if (!hasEnclosingClass()) {
      return ImmutableList.of();
    }
    // Builds list in order of inner to outer.
    // Return the reversed list, since the outermost type is expected to lie at index 0.
    ImmutableList.Builder<String> listBuilder = new ImmutableList.Builder<>();
    Class<?> currentClz = clazz();
    while (currentClz.getEnclosingClass() != null) {
      listBuilder.add(currentClz.getEnclosingClass().getSimpleName());
      currentClz = currentClz.getEnclosingClass();
    }
    return listBuilder.build().reverse();
  }

  @Override
  public String fullName() {
    return clazz().getCanonicalName();
  }

  @Override
  public boolean hasEnclosingClass() {
    return clazz().getEnclosingClass() != null;
  }

  @Override
  public boolean isFromPackage(String pkg) {
    return clazz().getPackage().getName().equals(pkg);
  }

  @Override
  public boolean isSupertypeOrEquals(Reference other) {
    // Don't check generics for cases like "List<String> foo = new ArrayList<>();
    if (!isAssignableFrom(other)) {
      return false;
    }

    if (generics().size() == other.generics().size()) {
      for (int i = 0; i < generics().size(); i++) {
        Reference thisGeneric = generics().get(i);
        Reference otherGeneric = other.generics().get(i);
        if (!thisGeneric.isSupertypeOrEquals(otherGeneric)) {
          return false;
        }
      }
    }

    return true;
  }

  @Override
  public boolean isAssignableFrom(Reference other) {
    if (other instanceof VaporReference && ((VaporReference) other).supertypeReference() != null) {
      return isAssignableFrom(((VaporReference) other).supertypeReference());
    }

    if (!(other instanceof ConcreteReference)) {
      return false;
    }

    if (generics().size() == other.generics().size()) {
      for (int i = 0; i < generics().size(); i++) {
        if (!generics().get(i).isSupertypeOrEquals(other.generics().get(i))) {
          return false;
        }
      }
    }

    return clazz().isAssignableFrom(((ConcreteReference) other).clazz());
  }

  @Override
  public boolean isWildcard() {
    return clazz().equals(WILDCARD_CLAZZ);
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ConcreteReference)) {
      return false;
    }

    ConcreteReference ref = (ConcreteReference) o;
    return clazz().equals(ref.clazz())
        && generics().equals(ref.generics())
        && Objects.equals(wildcardUpperBound(), ref.wildcardUpperBound());
  }

  @Override
  public int hashCode() {
    int wildcardUpperBoundHash =
        wildcardUpperBound() == null ? 0 : 11 * wildcardUpperBound().hashCode();
    return 17 * clazz().hashCode() + 31 * generics().hashCode() + wildcardUpperBoundHash;
  }

  @Override
  public Reference copyAndSetGenerics(List<Reference> generics) {
    return toBuilder().setGenerics(generics).build();
  }

  public static ConcreteReference withClazz(Class<?> clazz) {
    return builder().setClazz(clazz).build();
  }

  public static ConcreteReference wildcard() {
    return withClazz(ReferenceWildcard.class);
  }

  public static ConcreteReference wildcardWithUpperBound(Reference upperBoundReference) {
    return builder().setClazz(WILDCARD_CLAZZ).setWildcardUpperBound(upperBoundReference).build();
  }

  public static Builder builder() {
    return new AutoValue_ConcreteReference.Builder()
        .setUseFullName(false)
        .setGenerics(ImmutableList.of())
        .setIsStaticImport(false);
  }

  // Private.
  abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setClazz(Class<?> clazz);

    public abstract Builder setUseFullName(boolean useFullName);

    public abstract Builder setWildcardUpperBound(Reference reference);

    public Builder setGenerics(Reference... references) {
      return setGenerics(Arrays.asList(references));
    }

    public abstract Builder setGenerics(List<Reference> references);

    public abstract Builder setIsStaticImport(boolean isStaticImport);

    public abstract ConcreteReference autoBuild();

    // Private.
    abstract Class<?> clazz();

    abstract ImmutableList<Reference> generics();

    abstract boolean isStaticImport();

    public ConcreteReference build() {
      NodeValidator.checkNoNullElements(
          generics(), "generics", String.format("concrete reference %s", clazz().getSimpleName()));

      setIsStaticImport(clazz().getEnclosingClass() != null && isStaticImport());
      return autoBuild();
    }
  }
}
