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
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@AutoValue
public abstract class VaporReference implements Reference {
  private static final String DOT = ".";
  private static final String LEFT_ANGLE = "<";
  private static final String RIGHT_ANGLE = ">";
  private static final String COMMA = ", ";

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public abstract ImmutableList<Reference> generics();

  @Override
  public abstract String name();

  @Override
  public abstract String simpleName();

  @Override
  public abstract String pakkage();

  @Override
  public abstract boolean useFullName();

  @Nullable
  @Override
  public abstract ImmutableList<String> enclosingClassNames();

  @Nullable
  public abstract Reference supertypeReference();

  @Nullable
  @Override
  public Reference wildcardUpperBound() {
    return null;
  }

  @Override
  public String fullName() {
    if (hasEnclosingClass()) {
      return String.format(
          "%s.%s.%s", pakkage(), String.join(DOT, enclosingClassNames()), simpleName());
    }
    return String.format("%s.%s", pakkage(), simpleName());
  }

  @Override
  public abstract boolean isStaticImport();

  @Override
  public boolean hasEnclosingClass() {
    return !enclosingClassNames().isEmpty();
  }

  @Override
  public boolean isFromPackage(String pkg) {
    return pakkage().equals(pkg);
  }

  @Override
  public boolean isSupertypeOrEquals(Reference other) {
    // Not handling more complex cases for VaporReference.
    if (!(other instanceof VaporReference)) {
      return false;
    }

    VaporReference ref = (VaporReference) other;
    return pakkage().equals(ref.pakkage())
        && simpleName().equals(ref.simpleName())
        && Objects.equals(enclosingClassNames(), ref.enclosingClassNames());
  }

  @Override
  public boolean isAssignableFrom(Reference other) {
    // Not handling this yet for VaporReference.
    return false;
  }

  @Override
  public boolean isWildcard() {
    return false;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof VaporReference)) {
      return false;
    }

    VaporReference ref = (VaporReference) o;
    return pakkage().equals(ref.pakkage())
        && name().equals(ref.name())
        && generics().equals(ref.generics())
        && Objects.equals(enclosingClassNames(), ref.enclosingClassNames());
  }

  @Override
  public int hashCode() {
    int hash = 17 * pakkage().hashCode() + 19 * name().hashCode() + 23 * generics().hashCode();
    if (!enclosingClassNames().isEmpty()) {
      hash += 29 * enclosingClassNames().hashCode();
    }
    return hash;
  }

  @Override
  public Reference copyAndSetGenerics(List<Reference> generics) {
    return toBuilder().setGenerics(generics).build();
  }

  public static Builder builder() {
    return new AutoValue_VaporReference.Builder()
        .setUseFullName(false)
        .setGenerics(ImmutableList.of())
        .setIsStaticImport(false)
        .setEnclosingClassNames(Collections.emptyList());
  }

  // Private.
  abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setName(String name);

    public abstract Builder setPakkage(String pakkage);

    public abstract Builder setUseFullName(boolean useFullName);

    public Builder setGenerics(Reference... references) {
      return setGenerics(Arrays.asList(references));
    }

    public abstract Builder setGenerics(List<Reference> clazzes);

    public Builder setEnclosingClassNames(String... enclosingClassNames) {
      return setEnclosingClassNames(Arrays.asList(enclosingClassNames));
    }

    public abstract Builder setEnclosingClassNames(List<String> enclosingClassNames);

    public abstract Builder setIsStaticImport(boolean isStaticImport);

    public abstract Builder setSupertypeReference(Reference supertypeReference);

    // Private.
    abstract Builder setSimpleName(String simpleName);

    abstract String name();

    abstract ImmutableList<Reference> generics();

    abstract ImmutableList<String> enclosingClassNames();

    abstract boolean isStaticImport();

    abstract VaporReference autoBuild();

    public VaporReference build() {
      String contextInfo = String.format("vapor reference %s", name());
      NodeValidator.checkNoNullElements(generics(), "generics", contextInfo);
      NodeValidator.checkNoNullElements(enclosingClassNames(), "enclosingClassNames", contextInfo);

      // Validate the name.
      IdentifierNode.builder().setName(name()).build();
      // No exception thrown, so we can proceed.

      setSimpleName(name());

      setIsStaticImport(!enclosingClassNames().isEmpty() && isStaticImport());

      StringBuilder sb = new StringBuilder();
      if (!enclosingClassNames().isEmpty() && !isStaticImport()) {
        sb.append(String.join(DOT, enclosingClassNames()));
        sb.append(DOT);
      }

      sb.append(name());
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
      setName(sb.toString());

      return autoBuild();
    }
  }
}
