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

class ArithmeticOperationExprTest {
  @Test
  void concatOperator_validBasic() {
    // valid type-checking for x + getSomeString()
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.INT).setName("x").build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setReturnType(TypeNode.STRING)
            .setMethodName("getSomeString")
            .build();
    ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void concatOperator_validWithNull() {
    // Type-checking for String variable x and null object value.
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.STRING).setName("x").build());
    ValueExpr rhsExpr = ValueExpr.createNullExpr();
    ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void concatOperator_validWithReferenceType() {
    // Type-checking for String variable x, Expr variable y.
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.STRING).setName("x").build());
    VariableExpr rhsExpr =
        VariableExpr.withVariable(
            Variable.builder()
                .setName("y")
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Expr.class)))
                .build());
    ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr);
    // No exception thrown, so we succeeded.
  }

  @Test
  void concatOperator_invalidVoidType() {
    // throw exception if one of expr is void-type
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.STRING).setName("x").build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setReturnType(TypeNode.VOID)
            .setMethodName("getNothing")
            .build();
    assertThrows(
        IllegalStateException.class,
        () -> ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr));
  }

  @Test
  void concatString_invalidNonStringType() {
    // throw exception for concat usage if none of exprs is String-type
    VariableExpr lhsExpr =
        VariableExpr.withVariable(Variable.builder().setType(TypeNode.INT).setName("x").build());
    MethodInvocationExpr rhsExpr =
        MethodInvocationExpr.builder()
            .setReturnType(TypeNode.DOUBLE)
            .setMethodName("getSomethingDouble")
            .build();
    assertThrows(
        IllegalStateException.class,
        () -> ArithmeticOperationExpr.concatWithExprs(lhsExpr, rhsExpr));
  }
}
