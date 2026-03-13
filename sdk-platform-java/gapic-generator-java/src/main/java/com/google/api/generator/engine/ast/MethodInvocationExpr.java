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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class MethodInvocationExpr implements Expr {
  public abstract IdentifierNode methodIdentifier();

  public abstract TypeNode returnType();

  @Nullable
  public abstract Expr exprReferenceExpr();

  @Nullable
  public abstract TypeNode staticReferenceType();

  public abstract List<Expr> arguments();

  public abstract List<Reference> generics();

  // Private.
  abstract String methodName();

  public boolean isGeneric() {
    return !generics().isEmpty();
  }

  @Override
  public TypeNode type() {
    return returnType();
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_MethodInvocationExpr.Builder()
        .setReturnType(TypeNode.VOID)
        .setGenerics(Collections.emptyList())
        .setArguments(Collections.emptyList());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    // Required.
    public abstract Builder setMethodName(String methodName);

    abstract String methodName();

    // Required only if this is used in an AssignmentExpr (for type-checking).
    public abstract Builder setReturnType(TypeNode type);

    // Optional, but cannot co-exist with a static reference.
    public abstract Builder setExprReferenceExpr(Expr exprReference);

    // Optional, but cannot co-exist with an expression reference.
    public abstract Builder setStaticReferenceType(TypeNode type);

    // Optional.
    public Builder setArguments(Expr... arguments) {
      return setArguments(Arrays.asList(arguments));
    }

    public abstract Builder setArguments(List<Expr> arguments);

    // Optional.
    public abstract Builder setGenerics(List<Reference> generics);

    // Private setter.
    abstract Builder setMethodIdentifier(IdentifierNode methodIdentifier);

    abstract MethodInvocationExpr autoBuild();

    public MethodInvocationExpr build() {
      // IdentifierNode will validate the name.
      IdentifierNode identifier = IdentifierNode.builder().setName(methodName()).build();
      setMethodIdentifier(identifier);

      MethodInvocationExpr methodInvocationExpr = autoBuild();

      if (methodInvocationExpr.staticReferenceType() != null) {
        Preconditions.checkState(
            TypeNode.isReferenceType(methodInvocationExpr.staticReferenceType()),
            "Static references can only be made on object types");
      }

      Preconditions.checkState(
          !methodInvocationExpr.type().equals(TypeNode.NULL),
          "Methods cannot be invoked on null types.");

      Preconditions.checkState(
          methodInvocationExpr.exprReferenceExpr() == null
              || methodInvocationExpr.staticReferenceType() == null,
          "Only the expression reference or the static reference can be set, not both");

      NodeValidator.checkNoNullElements(
          methodInvocationExpr.arguments(),
          "arguments",
          String.format("method invocation of %s", methodInvocationExpr.methodIdentifier().name()));

      NodeValidator.checkNoNullElements(
          methodInvocationExpr.generics(),
          "generics",
          String.format("method invocation of %s", methodInvocationExpr.methodIdentifier().name()));

      // TODO(v2): If type-checking is ever added for arguments, beware of lambdas and their type
      // workarounds.

      return methodInvocationExpr;
    }
  }
}
