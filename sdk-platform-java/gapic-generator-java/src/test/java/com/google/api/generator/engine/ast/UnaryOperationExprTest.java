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

class UnaryOperationExprTest {
  /** =============================== Logic Not Operation Expr =============================== */
  @Test
  void validLogicalNotOperationExpr_basic() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build());
    UnaryOperationExpr.logicalNotWithExpr(variableExpr);
    // No exception thrown, we're good.
  }

  @Test
  void validLogicalNot_boxedType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("x").setType(TypeNode.BOOLEAN_OBJECT).build());
    UnaryOperationExpr.logicalNotWithExpr(variableExpr);
    // No exception thrown, we're good.
  }

  @Test
  void invalidLogicalNot_numericType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(Variable.builder().setName("x").setType(TypeNode.INT).build());
    assertThrows(
        IllegalStateException.class, () -> UnaryOperationExpr.logicalNotWithExpr(variableExpr));
  }

  @Test
  void invalidLogicalNot_referenceType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(Variable.builder().setName("x").setType(TypeNode.STRING).build());
    assertThrows(
        IllegalStateException.class, () -> UnaryOperationExpr.logicalNotWithExpr(variableExpr));
  }

  /**
   * =============================== Post Increment Operation Expr ===============================
   */
  @Test
  void validPostIncrement_basic() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(Variable.builder().setName("x").setType(TypeNode.INT).build());
    UnaryOperationExpr.postfixIncrementWithExpr(variableExpr);
    // No exception thrown, we're good.
  }

  @Test
  void validPostIncrement_boxedType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("x").setType(TypeNode.FLOAT_OBJECT).build());
    UnaryOperationExpr.postfixIncrementWithExpr(variableExpr);
    // No exception thrown, we're good.
  }

  @Test
  void invalidPostIncrement_boxedBooleanType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("x").setType(TypeNode.BOOLEAN_OBJECT).build());
    assertThrows(
        IllegalStateException.class,
        () -> UnaryOperationExpr.postfixIncrementWithExpr(variableExpr));
  }

  @Test
  void invalidPostIncrement_referenceType() {
    VariableExpr variableExpr =
        VariableExpr.withVariable(Variable.builder().setName("x").setType(TypeNode.STRING).build());
    assertThrows(
        IllegalStateException.class,
        () -> UnaryOperationExpr.postfixIncrementWithExpr(variableExpr));
  }

  @Test
  void invalidPostIncrement_finalVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsFinal(true).setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> UnaryOperationExpr.postfixIncrementWithExpr(variableExpr));
  }

  @Test
  void invalidPostIncrement_declaredVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setIsDecl(true).setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> UnaryOperationExpr.postfixIncrementWithExpr(variableExpr));
  }
}
