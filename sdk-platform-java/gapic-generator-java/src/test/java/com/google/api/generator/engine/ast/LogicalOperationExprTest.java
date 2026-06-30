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

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class LogicalOperationExprTest {
  /** =============================== Logic And Operation Expr =============================== */
  @Test
  void logicalAnd_validBasic() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("isGood").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("isValid").build());
    LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void logicalAnd_validBoxedBoolean() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("isGood").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN_OBJECT).setName("isValid").build());
    LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void logicalAnd_invalidNumericType() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.INT).setName("x").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("isValid").build());
    assertThrows(
        IllegalStateException.class,
        () -> LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void logicalAnd_invalidStringType() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN_OBJECT).setName("x").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.STRING).setName("isValid").build());
    assertThrows(
        IllegalStateException.class,
        () -> LogicalOperationExpr.logicalAndWithExprs(lhsExpr, rhsExpr));
  }

  /** =============================== Logic Or Operation Expr =============================== */
  @Test
  void logicalOr_validBoxedBoolean() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN_OBJECT).setName("isGood").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN_OBJECT).setName("isValid").build());
    LogicalOperationExpr.logicalOrWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void logicalOr_invalidVoidType() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("x").build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder().setMethodName("doNothing").build();
    assertThrows(
        IllegalStateException.class,
        () -> LogicalOperationExpr.logicalOrWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void logicalOr_invalidNullType() {
    VariableExpr lhsExpr =
        VariableExpr.withVariable(
            Variable.builder().setType(TypeNode.BOOLEAN).setName("x").build());
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    assertThrows(
        IllegalStateException.class,
        () -> LogicalOperationExpr.logicalOrWithExprs(lhsExpr, rhsExpr));
  }
}
