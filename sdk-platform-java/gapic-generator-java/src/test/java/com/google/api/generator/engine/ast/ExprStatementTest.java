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

import org.junit.jupiter.api.Test;

class ExprStatementTest {

  @Test
  void validExprStatement_method() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setStaticReferenceType(someType)
            .build();
    assertValidExprStatement(methodExpr);
  }

  @Test
  void validExprStatement_variable() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    assertValidExprStatement(VariableExpr.builder().setVariable(variable).setIsDecl(true).build());
  }

  @Test
  void validExprStatement_assignment() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();

    AssignmentExpr assignmentExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
    assertValidExprStatement(assignmentExpr);
  }

  @Test
  void validExprStatement_throw() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    assertValidExprStatement(ThrowExpr.builder().setType(npeType).build());
  }

  @Test
  void validExprStatement_return() {
    assertValidExprStatement(
        ReturnExpr.withExpr(ValueExpr.withValue(StringObjectValue.withValue("asdf"))));
  }

  @Test
  void validExprStatement_unaryOperation() {
    assertValidExprStatement(
        UnaryOperationExpr.postfixIncrementWithExpr(
            VariableExpr.withVariable(
                Variable.builder().setType(TypeNode.INT).setName("i").build())));
  }

  @Test
  void validExprStatement_assignmentOperationExpr() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setName("i").setType(TypeNode.INT).build());
    ValueExpr rhsExpr =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("5").setType(TypeNode.INT).build());
    assertValidExprStatement(AssignmentOperationExpr.multiplyAssignmentWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void invalidExprStatement_variable() {
    Variable variable = Variable.builder().setType(TypeNode.INT).setName("libraryClient").build();
    VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();
    assertInvalidExprStatement(varExpr);
  }

  @Test
  void invalidExprStatement_value() {
    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    ValueExpr valueExpr = ValueExpr.builder().setValue(value).build();
    assertInvalidExprStatement(valueExpr);
  }

  @Test
  void invalidExprStatement_logicalNotUnaryOperator() {
    Expr logicalNotExpr =
        UnaryOperationExpr.logicalNotWithExpr(
            VariableExpr.withVariable(
                Variable.builder().setType(TypeNode.BOOLEAN).setName("foo").build()));
    assertInvalidExprStatement(logicalNotExpr);
  }

  private static void assertInvalidExprStatement(Expr expr) {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ExprStatement.withExpr(expr);
        });
  }

  private static void assertValidExprStatement(Expr expr) {
    assertThat(ExprStatement.withExpr(expr).expression()).isEqualTo(expr);
  }
}
