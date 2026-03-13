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

import com.google.api.generator.gapic.model.RegionTag;
import com.google.auto.value.AutoValue;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class ClassDefinition implements AstNode {
  // Optional.
  public abstract ImmutableList<CommentStatement> fileHeader();

  // Required for samples classes.
  @Nullable
  public abstract RegionTag regionTag();

  // Required.
  public abstract ScopeNode scope();

  // Required.
  public abstract IdentifierNode classIdentifier();

  // Required for outer classes.
  @Nullable
  public abstract String packageString();

  public abstract boolean isNested();

  // Optional.
  public abstract ImmutableList<CommentStatement> headerCommentStatements();

  public abstract ImmutableList<AnnotationNode> annotations();

  // Using a list helps with determinism in unit tests.
  public abstract ImmutableList<TypeNode> implementsTypes();

  @Nullable
  public abstract TypeNode extendsType();

  public abstract boolean isStatic();

  public abstract boolean isFinal();

  public abstract boolean isAbstract();

  public abstract ImmutableList<Statement> statements();

  public abstract ImmutableList<MethodDefinition> methods();

  public abstract ImmutableList<ClassDefinition> nestedClasses();

  // Private.
  abstract String name();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static Builder builder() {
    return new AutoValue_ClassDefinition.Builder()
        .setFileHeader(Collections.emptyList())
        .setHeaderCommentStatements(Collections.emptyList())
        .setIsNested(false)
        .setIsFinal(false)
        .setIsStatic(false)
        .setIsAbstract(false)
        .setAnnotations(Collections.emptyList())
        .setImplementsTypes(Collections.emptyList())
        .setStatements(Collections.emptyList())
        .setMethods(Collections.emptyList())
        .setNestedClasses(Collections.emptyList());
  }

  public abstract Builder toBuilder();

  @AutoValue.Builder
  public abstract static class Builder {
    public Builder setFileHeader(CommentStatement... headerComments) {
      return setFileHeader(Arrays.asList(headerComments));
    }

    public abstract Builder setFileHeader(List<CommentStatement> fileHeader);

    public abstract Builder setRegionTag(RegionTag regionTag);

    public Builder setHeaderCommentStatements(CommentStatement... comments) {
      return setHeaderCommentStatements(Arrays.asList(comments));
    }

    public abstract Builder setHeaderCommentStatements(
        List<CommentStatement> headerCommentStatements);

    public abstract Builder setScope(ScopeNode scope);

    public abstract Builder setPackageString(String pkg);

    public abstract Builder setName(String name);

    public abstract Builder setIsNested(boolean isNested);

    public abstract Builder setAnnotations(List<AnnotationNode> annotations);

    public abstract Builder setIsAbstract(boolean isAbstract);

    public abstract Builder setIsStatic(boolean isStatic);

    public abstract Builder setIsFinal(boolean isFinal);

    public abstract Builder setExtendsType(TypeNode type);

    public abstract Builder setImplementsTypes(List<TypeNode> types);

    public abstract Builder setStatements(List<Statement> body);

    public abstract Builder setMethods(List<MethodDefinition> methods);

    public abstract Builder setNestedClasses(List<ClassDefinition> nestedClasses);

    // Private accessors.
    abstract String name();

    abstract ClassDefinition autoBuild();

    abstract Builder setClassIdentifier(IdentifierNode methodIdentifier);

    public ClassDefinition build() {
      IdentifierNode classIdentifier = IdentifierNode.builder().setName(name()).build();
      setClassIdentifier(classIdentifier);

      ClassDefinition classDef = autoBuild();
      performNullChecks(classDef);

      // Only nested classes can forego having a package.
      if (!classDef.isNested()) {
        Preconditions.checkNotNull(
            classDef.packageString(), "Outer classes must have a package name defined");
        Preconditions.checkState(!classDef.isStatic(), "Outer classes cannot be static");
        Preconditions.checkState(
            !classDef.scope().equals(ScopeNode.PRIVATE), "Outer classes cannot be private");
      } else {
        Preconditions.checkState(
            classDef.fileHeader().isEmpty(), "Nested classes cannot have a file header");
      }

      // Abstract classes cannot be marked final.
      if (classDef.isAbstract()) {
        Preconditions.checkState(!classDef.isFinal(), "Abstract classes cannot be marked final");
      }

      // Check abstract extended type.
      if (classDef.extendsType() != null) {
        Preconditions.checkState(
            TypeNode.isReferenceType(classDef.extendsType()),
            "Classes cannot extend non-reference types");
        Preconditions.checkState(
            !classDef.implementsTypes().contains(classDef.extendsType()),
            "Classes cannot extend and implement the same type");
      }

      // Check implemented interface types.
      for (TypeNode implType : classDef.implementsTypes()) {
        Preconditions.checkState(
            TypeNode.isReferenceType(implType), "Classes cannot implement non-reference types");
      }

      for (Statement statement : classDef.statements()) {
        Preconditions.checkState(
            statement instanceof CommentStatement
                || statement instanceof EmptyLineStatement
                || statement instanceof ExprStatement
                || statement instanceof BlockStatement,
            "Class statement type must be either an expression, block, or comment statement");
        if (statement instanceof ExprStatement) {
          Expr expr = ((ExprStatement) statement).expression();
          if (expr instanceof VariableExpr) {
            VariableExpr variableExpr = (VariableExpr) expr;
            Preconditions.checkState(
                variableExpr.isDecl(), "Class expression variable statements must be declarations");
            Preconditions.checkState(
                !variableExpr.scope().equals(ScopeNode.LOCAL),
                "Class variable statement cannot have a local scope");
          } else {
            Preconditions.checkState(
                expr instanceof AssignmentExpr,
                "Class expression statement must be assignment or variable declaration");
            VariableExpr variableExpr = ((AssignmentExpr) expr).variableExpr();
            Preconditions.checkState(
                !variableExpr.scope().equals(ScopeNode.LOCAL),
                "Class variable in assignment statement cannot have a local scope");
          }
        }
      }

      return classDef;
    }

    void performNullChecks(ClassDefinition classDef) {
      String contextInfo = String.format("class  definition of %s", name());
      NodeValidator.checkNoNullElements(
          classDef.headerCommentStatements(), "header comments", contextInfo);
      NodeValidator.checkNoNullElements(classDef.annotations(), "annotations", contextInfo);

      NodeValidator.checkNoNullElements(
          classDef.implementsTypes(), "implemented types", contextInfo);
      NodeValidator.checkNoNullElements(classDef.statements(), "statements", contextInfo);

      NodeValidator.checkNoNullElements(classDef.methods(), "methods", contextInfo);
      NodeValidator.checkNoNullElements(classDef.nestedClasses(), "nested classes", contextInfo);
    }
  }
}
