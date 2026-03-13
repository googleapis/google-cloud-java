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

import com.google.api.generator.engine.lexicon.Keyword;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class VariableExpr implements Expr {
  public abstract Variable variable();

  @Nullable
  public abstract Expr exprReferenceExpr();

  @Nullable
  public abstract TypeNode staticReferenceType();

  /** Variable declaration fields. */
  public abstract boolean isDecl();

  public abstract ScopeNode scope();

  public abstract boolean isStatic();

  public abstract boolean isFinal();

  public abstract boolean isVolatile();

  // Optional
  public abstract ImmutableList<AnnotationNode> annotations();

  // Please use this only in conjunction with methods.
  // Supports only parameterized types like Map<K, V>.
  // TODO(unsupported): Fully generic arguments, e.g. foobar(K key, V value).
  // This list can contain only IdentifierNode or TypeNode.
  public abstract ImmutableList<AstNode> templateNodes();

  // Private.
  // Can either contain String or TypeNode objects.
  abstract ImmutableList<Object> templateObjects();

  @Override
  public TypeNode type() {
    if (isDecl()) {
      return TypeNode.VOID;
    }
    return variable().type();
  }

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static VariableExpr withVariable(Variable variable) {
    return builder().setVariable(variable).build();
  }

  public static Builder builder() {
    return new AutoValue_VariableExpr.Builder()
        .setIsDecl(false)
        .setIsFinal(false)
        .setIsStatic(false)
        .setIsVolatile(false)
        .setScope(ScopeNode.LOCAL)
        .setTemplateObjects(ImmutableList.of())
        .setAnnotations(Collections.emptyList());
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setVariable(Variable variable);

    // Optional, but cannot co-exist with a variable declaration.
    public abstract Builder setExprReferenceExpr(Expr exprReference);

    // Optional, but cannot co-exist with an expression reference.
    public abstract Builder setStaticReferenceType(TypeNode type);

    public abstract Builder setIsDecl(boolean isDecl);

    public abstract Builder setScope(ScopeNode scope);

    public abstract Builder setIsStatic(boolean isStatic);

    public abstract Builder setIsFinal(boolean isFinal);

    public abstract Builder setIsVolatile(boolean isVolatile);

    public abstract Builder setAnnotations(List<AnnotationNode> annotations);

    abstract ImmutableList<AnnotationNode> annotations();

    // This should be used only for method arguments.
    public abstract Builder setTemplateObjects(List<Object> objects);

    // Private.
    abstract Builder setTemplateNodes(List<AstNode> nodes);

    abstract Variable variable();

    abstract ImmutableList<Object> templateObjects();

    abstract VariableExpr autoBuild();

    public VariableExpr build() {
      NodeValidator.checkNoNullElements(
          templateObjects(),
          "template objects",
          String.format("variable expr %s", variable().identifier().name()));
      setTemplateNodes(
          templateObjects().stream()
              .map(
                  o -> {
                    Preconditions.checkState(
                        o instanceof String || o instanceof TypeNode,
                        "Template objects can only be Strings or Typenodes");
                    if (o instanceof String) {
                      return (AstNode) IdentifierNode.withName((String) o);
                    }
                    return (AstNode) o;
                  })
              .collect(Collectors.toList()));

      // Remove duplicates while maintaining insertion order.
      ImmutableList<AnnotationNode> processedAnnotations = annotations();
      setAnnotations(
          new LinkedHashSet<>(processedAnnotations).stream().collect(Collectors.toList()));

      VariableExpr variableExpr = autoBuild();

      // TODO: should match on AnnotationNode @Target of ElementType.FIELD
      if (!variableExpr.isDecl()) {
        Preconditions.checkState(
            variableExpr.annotations().isEmpty(),
            "Annotation can only be added to variable declaration.");
      }

      if (variableExpr.isDecl() || variableExpr.exprReferenceExpr() != null) {
        Preconditions.checkState(
            variableExpr.isDecl() ^ (variableExpr.exprReferenceExpr() != null),
            "Variable references cannot be declared");
      }

      Preconditions.checkState(
          variableExpr.exprReferenceExpr() == null || variableExpr.staticReferenceType() == null,
          "Only the expression reference or the static reference can be set, not both");

      if (variableExpr.exprReferenceExpr() != null) {
        Preconditions.checkState(
            TypeNode.isReferenceType(variableExpr.exprReferenceExpr().type()),
            "Variables can only be referenced from object types");
      }
      if (variableExpr.staticReferenceType() != null) {
        Preconditions.checkState(
            TypeNode.isReferenceType(variableExpr.staticReferenceType()),
            String.format(
                "Static field references can only be done on static types, but instead found %s",
                variableExpr.staticReferenceType()));
      }

      // A variable name of "class" is valid only when it's a static reference.
      String varName = variableExpr.variable().identifier().name();
      if (Keyword.isKeyword(varName)) {
        Preconditions.checkState(
            variableExpr.staticReferenceType() != null
                || (variableExpr.exprReferenceExpr() != null
                    && TypeNode.isReferenceType(variableExpr.exprReferenceExpr().type())),
            String.format(
                "Variable field name %s is invalid on non-static or non-reference types", varName));
      }

      return variableExpr;
    }
  }
}
