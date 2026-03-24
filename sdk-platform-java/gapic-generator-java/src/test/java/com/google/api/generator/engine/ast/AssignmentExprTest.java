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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class AssignmentExprTest {
  @Test
  void assignMatchingValue() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    assertValidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void assignMismatchedValue() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    assertInvalidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void assignSubtypeValue() {
    Variable variable =
        Variable.builder()
            .setName("x")
            .setType(TypeNode.withReference(ConcreteReference.withClazz(List.class)))
            .build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    MethodInvocationExpr valueExpr =
        MethodInvocationExpr.builder()
            .setMethodName("getAList")
            .setReturnType(TypeNode.withReference(ConcreteReference.withClazz(ArrayList.class)))
            .build();

    assertValidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void assignMatchingVariable() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Variable anotherVariable = Variable.builder().setName("y").setType(TypeNode.INT).build();
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    assertValidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void assignNullObjectValue() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = NullObjectValue.create();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    assertValidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void writeAssignmentExpr_nullObjectValuePrimitiveType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = NullObjectValue.create();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    assertInvalidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void writeAssignmentExpr_primitiveToBoxedType() {
    // [Constructing] `Boolean x = (boolean) true`
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN_OBJECT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("true").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();
    assertValidAssignmentExpr(variableExpr, valueExpr);
  }

  @Test
  void writeAssignmentExpr_boxedToPrimitiveType() {
    // [Constructing] `double x = (Double) y`
    Variable lVariable = Variable.builder().setName("x").setType(TypeNode.DOUBLE).build();
    VariableExpr lVariableExpr =
        VariableExpr.builder().setVariable(lVariable).setIsDecl(true).build();

    Variable rVariable = Variable.builder().setName("y").setType(TypeNode.DOUBLE_OBJECT).build();
    VariableExpr rVariableExpr = VariableExpr.builder().setVariable(rVariable).build();
    assertValidAssignmentExpr(lVariableExpr, rVariableExpr);
  }

  @Test
  void writeAssignmentExpr_invalidBoxedPrimitiveType() {
    // [Constructing] `double x = (Integer) y`
    Variable lVariable = Variable.builder().setName("x").setType(TypeNode.DOUBLE).build();
    VariableExpr lVariableExpr =
        VariableExpr.builder().setVariable(lVariable).setIsDecl(true).build();

    Variable rVariable = Variable.builder().setName("y").setType(TypeNode.INT_OBJECT).build();
    VariableExpr rVariableExpr = VariableExpr.builder().setVariable(rVariable).build();
    assertInvalidAssignmentExpr(lVariableExpr, rVariableExpr);
  }

  @Test
  void writeAssignmentExpr_validIsDeclFinalVariableExpr() {
    Variable lVariable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr lVariableExpr =
        VariableExpr.builder().setVariable(lVariable).setIsDecl(true).setIsFinal(true).build();

    ValueExpr valueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build());
    assertValidAssignmentExpr(lVariableExpr, valueExpr);
  }

  @Test
  void writeAssignmentExpr_invalidIsNotDeclFinalVariableExpr() {
    Variable lVariable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr lVariableExpr =
        VariableExpr.builder().setVariable(lVariable).setIsDecl(false).setIsFinal(true).build();

    ValueExpr valueExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setType(TypeNode.INT).setValue("0").build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          AssignmentExpr.builder().setVariableExpr(lVariableExpr).setValueExpr(valueExpr).build();
        });
  }

  private static void assertInvalidAssignmentExpr(VariableExpr variableExpr, Expr valueExpr) {
    assertThrows(
        TypeMismatchException.class,
        () -> {
          AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
        });
  }

  private static void assertValidAssignmentExpr(VariableExpr variableExpr, Expr valueExpr) {
    AssignmentExpr assignMentExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
    // No exception, we succeeded.
    assertThat(assignMentExpr.variableExpr()).isEqualTo(variableExpr);
    assertThat(assignMentExpr.valueExpr()).isEqualTo(valueExpr);
  }
}
