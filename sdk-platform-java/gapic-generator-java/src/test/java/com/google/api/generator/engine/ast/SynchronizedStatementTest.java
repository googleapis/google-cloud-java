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

class SynchronizedStatementTest {
  @Test
  void validSynchronizedStatement_basicThis() {
    SynchronizedStatement.builder()
        .setLock(
            ThisObjectValue.withType(
                TypeNode.withReference(ConcreteReference.withClazz(Expr.class))))
        .setBody(
            ExprStatement.withExpr(MethodInvocationExpr.builder().setMethodName("doStuff").build()))
        .build();
  }

  @Test
  void validSynchronizedStatement_basicVariableExpr() {
    SynchronizedStatement.builder()
        .setLock(
            VariableExpr.withVariable(
                Variable.builder().setName("str").setType(TypeNode.STRING).build()))
        .setBody(
            ExprStatement.withExpr(MethodInvocationExpr.builder().setMethodName("doStuff").build()))
        .build();
  }

  @Test
  void invalidSynchronizedStatement_primitiveLock() {
    assertThrows(
        IllegalStateException.class,
        () ->
            SynchronizedStatement.builder()
                .setLock(
                    VariableExpr.withVariable(
                        Variable.builder().setName("str").setType(TypeNode.INT).build()))
                .setBody(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder().setMethodName("doStuff").build()))
                .build());
  }

  @Test
  void invalidSynchronizedStatement_declaredVariableExpr() {
    VariableExpr strVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("str").setType(TypeNode.STRING).build())
            .setIsDecl(true)
            .build();
    assertThrows(
        IllegalStateException.class,
        () ->
            SynchronizedStatement.builder()
                .setLock(strVarExpr)
                .setBody(
                    ExprStatement.withExpr(
                        MethodInvocationExpr.builder().setMethodName("doStuff").build()))
                .build());
  }
}
