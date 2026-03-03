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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class ThrowExprTest {
  @Test
  void createThrowExpr_basic() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    ThrowExpr.builder().setType(npeType).build();
    // No exception thrown, we're good.
  }

  @Test
  void createThrowExpr_basicExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    VariableExpr throwVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("e")
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .build())
            .build();
    ThrowExpr throwExpr = ThrowExpr.builder().setThrowExpr(throwVarExpr).build();
    assertEquals(throwVarExpr.variable().type(), throwExpr.type());
    // Setting the type doesn't matter.
    throwExpr = ThrowExpr.builder().setThrowExpr(throwVarExpr).setType(npeType).build();
    assertEquals(throwVarExpr.variable().type(), throwExpr.type());
  }

  @Test
  void createThrowExpr_basicWithStringMessage() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    ThrowExpr.builder().setType(npeType).setMessageExpr("Some message").build();
    // No exception thrown, we're good.
  }

  @Test
  void createThrowExpr_messageExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr.builder().setType(npeType).setMessageExpr(messageExpr).build();
    // No exception thrown, we're good.
  }

  @Test
  void createThrowExpr_badExceptionType() {
    TypeNode nonExceptionType = TypeNode.STRING;
    assertThrows(
        IllegalStateException.class, () -> ThrowExpr.builder().setType(nonExceptionType).build());
  }

  @Test
  void createThrowExpr_badMessageExpr() {
    TypeNode npeType = TypeNode.withExceptionClazz(NullPointerException.class);
    Expr messageExpr =
        MethodInvocationExpr.builder().setMethodName("foobar").setReturnType(TypeNode.INT).build();
    assertThrows(
        IllegalStateException.class,
        () -> ThrowExpr.builder().setType(npeType).setMessageExpr(messageExpr).build());
  }

  @Test
  void createThrowExpr_causeExpr() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    ThrowExpr.builder()
        .setType(npeType)
        .setCauseExpr(
            NewObjectExpr.builder()
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                .build())
        .build();
    // Successfully created a ThrowExpr.
  }

  @Test
  void createThrowExpr_causeExpr_throwableSubtype() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    ThrowExpr.builder()
        .setType(npeType)
        .setCauseExpr(
            NewObjectExpr.builder()
                .setType(TypeNode.withExceptionClazz(IllegalStateException.class))
                .build())
        .build();
    // Successfully created a ThrowExpr.
  }

  @Test
  void createThrowExpr_causeExpr_onThrowableSubtype() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    assertThrows(
        IllegalStateException.class,
        () ->
            ThrowExpr.builder()
                .setType(npeType)
                .setCauseExpr(NewObjectExpr.builder().setType(TypeNode.STRING).build())
                .build());
  }

  @Test
  void createThrowExpr_messageAndCauseExpr() {
    TypeNode npeType =
        TypeNode.withReference(ConcreteReference.withClazz(NullPointerException.class));
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    ThrowExpr.builder()
        .setType(npeType)
        .setMessageExpr(messageExpr)
        .setCauseExpr(
            NewObjectExpr.builder()
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                .build())
        .build();
    // Successfully created a ThrowExpr.
  }

  @Test
  void createThrowExpr_cannotThrowVariableDeclaration() {
    VariableExpr throwVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("e")
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .build())
            .build();
    assertThrows(
        IllegalStateException.class,
        () ->
            ThrowExpr.builder()
                .setThrowExpr(throwVarExpr.toBuilder().setIsDecl(true).build())
                .build());
  }

  @Test
  void createThrowExpr_cannotThrowNonExceptionTypedExpr() {
    VariableExpr throwVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("str").setType(TypeNode.STRING).build())
            .build();
    assertThrows(
        IllegalStateException.class, () -> ThrowExpr.builder().setThrowExpr(throwVarExpr).build());
  }

  @Test
  void createThrowExpr_cannotHaveThrowVariableAndMessageExprPresent() {
    Expr messageExpr =
        MethodInvocationExpr.builder()
            .setMethodName("foobar")
            .setReturnType(TypeNode.STRING)
            .build();
    VariableExpr throwVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("e")
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .build())
            .build();
    assertThrows(
        IllegalStateException.class,
        () -> ThrowExpr.builder().setThrowExpr(throwVarExpr).setMessageExpr(messageExpr).build());
  }

  @Test
  void createThrowExpr_cannotHaveThrowVariableAndCauseExprPresent() {
    VariableExpr throwVarExpr =
        VariableExpr.builder()
            .setVariable(
                Variable.builder()
                    .setName("e")
                    .setType(TypeNode.withExceptionClazz(RuntimeException.class))
                    .build())
            .build();
    assertThrows(
        IllegalStateException.class,
        () ->
            ThrowExpr.builder()
                .setThrowExpr(throwVarExpr)
                .setCauseExpr(
                    NewObjectExpr.builder()
                        .setType(
                            TypeNode.withReference(ConcreteReference.withClazz(Throwable.class)))
                        .build())
                .build());
  }
}
