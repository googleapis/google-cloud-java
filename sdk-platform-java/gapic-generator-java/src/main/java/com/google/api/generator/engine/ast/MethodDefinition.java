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
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

@AutoValue
public abstract class MethodDefinition implements AstNode {
  static final Reference RUNTIME_EXCEPTION_REFERENCE =
      ConcreteReference.withClazz(RuntimeException.class);

  // Required.
  public abstract ScopeNode scope();

  // Required.
  public abstract TypeNode returnType();

  // Required.
  public abstract IdentifierNode methodIdentifier();

  public abstract ImmutableList<CommentStatement> headerCommentStatements();

  public abstract ImmutableList<AnnotationNode> annotations();

  // Using a list helps with determinism in unit tests.
  public abstract ImmutableList<TypeNode> throwsExceptions();

  public abstract ImmutableList<VariableExpr> arguments();

  public abstract boolean isStatic();

  public abstract boolean isFinal();

  public abstract boolean isAbstract();

  public abstract boolean isConstructor();

  public abstract ImmutableList<Statement> body();

  // Please use VariableExpr for templating individual arguments.
  public abstract ImmutableList<IdentifierNode> templateIdentifiers();

  public abstract ImmutableList<IdentifierNode> returnTemplateIdentifiers();

  // Private accessors.
  abstract ImmutableList<String> templateNames();

  abstract ImmutableList<String> returnTemplateNames();

  @Nullable
  public abstract ReturnExpr returnExpr();

  abstract boolean isOverride();

  @Nullable
  abstract String name();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public abstract Builder toBuilder();

  public static Builder builder() {
    return new AutoValue_MethodDefinition.Builder()
        .setArguments(Collections.emptyList())
        .setIsAbstract(false)
        .setIsFinal(false)
        .setIsStatic(false)
        .setIsConstructor(false)
        .setHeaderCommentStatements(Collections.emptyList())
        .setAnnotations(Collections.emptyList())
        .setThrowsExceptions(Collections.emptyList())
        .setBody(Collections.emptyList())
        .setIsOverride(false)
        .setTemplateNames(ImmutableList.of())
        .setReturnTemplateNames(ImmutableList.of());
  }

  public static Builder constructorBuilder() {
    return new AutoValue_MethodDefinition.Builder()
        .setArguments(Collections.emptyList())
        .setIsAbstract(false)
        .setIsFinal(false)
        .setIsStatic(false)
        .setIsConstructor(true)
        .setHeaderCommentStatements(Collections.emptyList())
        .setAnnotations(Collections.emptyList())
        .setThrowsExceptions(Collections.emptyList())
        .setBody(Collections.emptyList())
        .setIsOverride(false)
        .setTemplateNames(ImmutableList.of())
        .setReturnTemplateNames(ImmutableList.of());
  }

  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setScope(ScopeNode scope);

    public abstract Builder setReturnType(TypeNode type);

    public abstract Builder setName(String name);

    public Builder setHeaderCommentStatements(CommentStatement... comments) {
      return setHeaderCommentStatements(Arrays.asList(comments));
    }

    public abstract Builder setHeaderCommentStatements(
        List<CommentStatement> headeCommentStatements);

    public abstract Builder setAnnotations(List<AnnotationNode> annotations);

    public abstract Builder setIsStatic(boolean isStatic);

    public abstract Builder setIsFinal(boolean isFinal);

    public abstract Builder setIsAbstract(boolean isAbstract);

    public abstract Builder setIsConstructor(boolean isConstructor);

    public abstract Builder setThrowsExceptions(List<TypeNode> exceptionTypes);

    public Builder setArguments(VariableExpr... arguments) {
      return setArguments(Arrays.asList(arguments));
    }

    public abstract Builder setArguments(List<VariableExpr> arguments);

    public abstract Builder setBody(List<Statement> body);

    public Builder setReturnExpr(Expr expr) {
      return setReturnExpr(ReturnExpr.withExpr(expr));
    }

    public abstract Builder setReturnExpr(ReturnExpr returnExpr);

    public abstract Builder setIsOverride(boolean isOverride);

    public abstract Builder setTemplateNames(List<String> names);

    public abstract Builder setReturnTemplateNames(List<String> names);

    // Private.
    abstract Builder setTemplateIdentifiers(List<IdentifierNode> identifiers);

    abstract Builder setReturnTemplateIdentifiers(List<IdentifierNode> identifiers);

    abstract Builder setMethodIdentifier(IdentifierNode methodIdentifier);

    // Private accessors.
    abstract String name();

    abstract ImmutableList<VariableExpr> arguments();

    abstract ImmutableList<CommentStatement> headerCommentStatements();

    abstract ImmutableList<AnnotationNode> annotations();

    abstract ImmutableList<TypeNode> throwsExceptions();

    abstract TypeNode returnType();

    abstract boolean isOverride();

    abstract boolean isAbstract();

    abstract boolean isFinal();

    abstract boolean isStatic();

    abstract ImmutableList<Statement> body();

    abstract boolean isConstructor();

    abstract ScopeNode scope();

    abstract MethodDefinition autoBuild();

    abstract ImmutableList<String> templateNames();

    abstract ImmutableList<String> returnTemplateNames();

    public MethodDefinition build() {
      performNullChecks();

      // Handle templates.
      setTemplateIdentifiers(
          templateNames().stream()
              .map(n -> IdentifierNode.withName(n))
              .collect(Collectors.toList()));

      if (!returnTemplateNames().isEmpty()) {
        Preconditions.checkState(
            TypeNode.isReferenceType(returnType()), "Primitive return types cannot be templated");
      }
      setReturnTemplateIdentifiers(
          returnTemplateNames().stream()
              .map(
                  n -> {
                    Preconditions.checkState(
                        templateNames().contains(n),
                        String.format(
                            "Return template name %s not found in method template names", n));
                    return IdentifierNode.withName(n);
                  })
              .collect(Collectors.toList()));

      // Constructor checks.
      if (isConstructor()) {
        Preconditions.checkState(
            TypeNode.isReferenceType(returnType()), "Constructor must return an object type.");
        setName(returnType().reference().name());
      } else {
        Preconditions.checkNotNull(name(), "Methods must have a name");
      }

      IdentifierNode methodIdentifier = IdentifierNode.builder().setName(name()).build();
      setMethodIdentifier(methodIdentifier);

      // Abstract and modifier checking.
      if (isAbstract()) {
        Preconditions.checkState(
            !isFinal() && !isStatic() && !scope().equals(ScopeNode.PRIVATE),
            "Abstract methods cannot be static, final, or private");
      }

      // If this method overrides another, ensure that the Override annotation is the last one.
      ImmutableList<AnnotationNode> processedAnnotations = annotations();
      if (isOverride()) {
        processedAnnotations =
            ImmutableList.<AnnotationNode>builder()
                .addAll(annotations())
                .add(AnnotationNode.OVERRIDE)
                .build();
      }
      // Remove duplicates while maintaining insertion order.
      setAnnotations(
          new LinkedHashSet<>(processedAnnotations).stream().collect(Collectors.toList()));

      MethodDefinition method = autoBuild();

      Preconditions.checkState(
          !method.scope().equals(ScopeNode.LOCAL),
          "Method scope must be either public, protected, or private");

      Preconditions.checkState(
          !method.returnType().equals(TypeNode.NULL), "Null is not a valid method return type");

      // Constructor checking.
      if (method.isConstructor()) {
        Preconditions.checkState(
            !method.isFinal() && !method.isStatic(), "Constructors cannot be static or final");
        Preconditions.checkState(!method.isOverride(), "A constructor cannot override another");
        Preconditions.checkState(
            method.returnExpr() == null, "A constructor cannot have a return expression");
        // Reference already checked at method name validation time.
        // TODO(unsupported): Constructors for templated types. This would require changing the
        // Reference API, which would be trivial. However, such constructors don't seem to be needed
        // yet.
        Preconditions.checkState(
            method.returnType().reference().generics().isEmpty(),
            "Constructors for templated classes are not yet supported");
      } else {
        // Return type validation and checking.
        boolean isLastStatementThrowExpr = false;
        Statement lastStatement;
        if (!body().isEmpty()
            && (lastStatement = body().get(body().size() - 1)) instanceof ExprStatement) {
          isLastStatementThrowExpr =
              ((ExprStatement) lastStatement).expression() instanceof ThrowExpr;
        }
        if (!method.returnType().equals(TypeNode.VOID) && !isLastStatementThrowExpr) {
          Preconditions.checkNotNull(
              method.returnExpr(),
              "Method with non-void return type must have a return expression");
        }

        if (!method.returnType().equals(TypeNode.VOID) && !isLastStatementThrowExpr) {
          Preconditions.checkNotNull(
              method.returnExpr(),
              "Method with non-void return type must have a return expression");
        }

        if (method.returnExpr() != null && !isLastStatementThrowExpr) {
          if (method.returnType().isPrimitiveType()
              || method.returnExpr().expr().type().isPrimitiveType()) {
            Preconditions.checkState(
                method.returnType().equals((method.returnExpr().expr().type())),
                "Method return type does not match the return expression type");
          } else {
            Preconditions.checkState(
                method.returnType().isSupertypeOrEquals(method.returnExpr().expr().type()),
                "Method reference return type is not a supertype of the return expression type");
          }
        }
      }

      performArgumentChecks();
      performThrownExceptionChecks();

      return method;
    }

    private void performArgumentChecks() {
      // Must be a declaration.
      arguments().stream()
          .forEach(
              varExpr ->
                  Preconditions.checkState(
                      varExpr.isDecl(),
                      String.format(
                          "Argument %s must be a variable declaration",
                          varExpr.variable().identifier())));
      // No modifiers allowed.
      arguments().stream()
          .forEach(
              varExpr ->
                  Preconditions.checkState(
                      varExpr.scope().equals(ScopeNode.LOCAL)
                          && !varExpr.isStatic()
                          && !varExpr.isVolatile(),
                      String.format(
                          "Argument %s must have local scope, and cannot have \"static\" or"
                              + " \"volatile\" modifiers",
                          varExpr.variable().identifier())));

      // Check that there aren't any arguments with duplicate names.
      List<String> allArgNames =
          arguments().stream()
              .map(v -> v.variable().identifier().name())
              .collect(Collectors.toList());
      Set<String> duplicateArgNames =
          allArgNames.stream()
              .filter(n -> Collections.frequency(allArgNames, n) > 1)
              .collect(Collectors.toSet());
      Preconditions.checkState(
          duplicateArgNames.isEmpty(),
          String.format(
              "Lambda arguments cannot have duplicate names: %s", duplicateArgNames.toString()));
    }

    private void performThrownExceptionChecks() {
      throwsExceptions().stream()
          .forEach(
              exceptionType -> {
                Preconditions.checkState(
                    TypeNode.isExceptionType(exceptionType),
                    String.format("Type %s is not an exception type", exceptionType.reference()));
                Preconditions.checkState(
                    !RUNTIME_EXCEPTION_REFERENCE.isAssignableFrom(exceptionType.reference()),
                    String.format(
                        "RuntimeException type %s does not need to be thrown",
                        exceptionType.reference().name()));
              });
    }

    private void performNullChecks() {
      String contextInfo = String.format("method definition of %s", name());
      NodeValidator.checkNoNullElements(headerCommentStatements(), "header comments", contextInfo);
      NodeValidator.checkNoNullElements(annotations(), "annotations", contextInfo);
      NodeValidator.checkNoNullElements(throwsExceptions(), "declared exceptions", contextInfo);
      NodeValidator.checkNoNullElements(body(), "body", contextInfo);
      NodeValidator.checkNoNullElements(templateNames(), "template names", contextInfo);
      NodeValidator.checkNoNullElements(
          returnTemplateNames(), "return template names", contextInfo);
    }
  }
}
