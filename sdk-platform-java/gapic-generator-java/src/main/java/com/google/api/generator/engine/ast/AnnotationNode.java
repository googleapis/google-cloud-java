// Copyright 2022 Google LLC
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

@AutoValue
public abstract class AnnotationNode implements AstNode {
  public static AnnotationNode OVERRIDE =
      AnnotationNode.builder().setType(annotationType(Override.class)).build();
  public static AnnotationNode DEPRECATED =
      AnnotationNode.builder().setType(annotationType(Deprecated.class)).build();

  private static TypeNode annotationType(Class<?> clazz) {
    return TypeNode.withReference(ConcreteReference.withClazz(clazz));
  }

  public abstract TypeNode type();

  @Nullable
  public abstract List<Expr> descriptionExprs();

  @Override
  public void accept(AstNodeVisitor visitor) {
    visitor.visit(this);
  }

  public static AnnotationNode withTypeAndDescription(TypeNode type, String description) {
    return AnnotationNode.builder().setType(type).setDescription(description).build();
  }

  public static AnnotationNode withTypeAndDescription(TypeNode type, List<Expr> exprList) {
    return AnnotationNode.builder().setType(type).setDescriptions(exprList).build();
  }

  public static AnnotationNode withSuppressWarnings(String description) {
    return withTypeAndDescription(annotationType(SuppressWarnings.class), description);
  }

  public static AnnotationNode withType(TypeNode type) {
    return builder().setType(type).build();
  }

  public static Builder builder() {
    return new AutoValue_AnnotationNode.Builder();
  }

  @AutoValue.Builder
  public abstract static class Builder {
    private static final String REPEAT_SINGLE_EXCEPTION_MESSAGE =
        "Single parameter with no name cannot be set multiple times";

    private static final String MULTIPLE_AFTER_SINGLE_EXCEPTION_MESSAGE =
        "Multiple parameters must have names";

    abstract List<Expr> descriptionExprs();

    public abstract Builder setType(TypeNode type);

    /**
     * To set single String as description.
     *
     * @param description
     * @return Builder
     */
    public Builder setDescription(String description) {
      Preconditions.checkState(descriptionExprs() == null, REPEAT_SINGLE_EXCEPTION_MESSAGE);
      return setDescriptionExprs(
          Arrays.asList(ValueExpr.withValue(StringObjectValue.withValue(description))));
    }

    /**
     * To set single ValueExpr as description.
     *
     * @param valueExpr
     * @return Builder
     */
    public Builder setDescription(ValueExpr valueExpr) {
      Preconditions.checkState(descriptionExprs() == null, REPEAT_SINGLE_EXCEPTION_MESSAGE);
      return setDescriptionExprs(Arrays.asList(valueExpr));
    }

    /**
     * To set single VariableExpr as description.
     *
     * @param variableExpr
     * @return Builder
     */
    public Builder setDescription(VariableExpr variableExpr) {
      Preconditions.checkState(descriptionExprs() == null, REPEAT_SINGLE_EXCEPTION_MESSAGE);
      return setDescriptionExprs(Arrays.asList(variableExpr));
    }

    /**
     * To set single ArrayExpr as description.
     *
     * @param arrayExpr
     * @return Builder
     */
    public Builder setDescription(ArrayExpr arrayExpr) {
      Preconditions.checkState(descriptionExprs() == null, REPEAT_SINGLE_EXCEPTION_MESSAGE);
      return setDescriptionExprs(Arrays.asList(arrayExpr));
    }

    /**
     * To add an AssignmentExpr as parameter. Can be used repeatedly to add multiple parameters.
     *
     * @param assignmentExpr
     * @return Builder
     */
    public Builder addDescription(AssignmentExpr assignmentExpr) {
      return addDescriptionToList(assignmentExpr);
    }

    private Builder setDescriptions(List<Expr> exprList) {
      return setDescriptionExprs(exprList);
    }

    // this method is private, and called only by addDescription(AssignmentExpr expr)
    private Builder addDescriptionToList(Expr expr) {
      List<Expr> exprList = descriptionExprs();
      // avoid when single parameter is already set.
      Preconditions.checkState(
          exprList == null || exprList instanceof ArrayList,
          MULTIPLE_AFTER_SINGLE_EXCEPTION_MESSAGE);
      if (exprList == null) {
        exprList = new ArrayList<>();
      }
      exprList.add(expr);
      return setDescriptions(exprList);
    }

    // this setter is private, and called only by setDescription() and setDescriptions() above.
    abstract Builder setDescriptionExprs(List<Expr> descriptionExprs);

    abstract AnnotationNode autoBuild();

    public AnnotationNode build() {
      AnnotationNode annotation = autoBuild();
      Reference ref = annotation.type().reference();
      Preconditions.checkNotNull(ref, "Annotations must be an Object type");
      return annotation;
    }
  }
}
