// Copyright 2021 Google LLC
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

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LambdaExprTest {
  @Test
  void validLambdaExpr_noArguments() {
    LambdaExpr.builder()
        .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
        .build();
  }

  @Test
  void validLambdaExpr_inferTypeFromReturnExpr() {
    LambdaExpr lambdaExpr =
        LambdaExpr.builder()
            .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
            .build();
    assertEquals(TypeNode.STRING, lambdaExpr.type());
  }

  @Test
  void validLambdaExpr_severalArguments() {
    VariableExpr argOneVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .build();
    VariableExpr argTwoVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg2").setType(TypeNode.STRING).build())
            .setIsDecl(true)
            .build();
    VariableExpr argThreeVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg3").setType(TypeNode.BOOLEAN).build())
            .setIsDecl(true)
            .build();

    LambdaExpr.builder()
        .setArguments(argOneVarExpr, argTwoVarExpr, argThreeVarExpr)
        .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
        .build();
  }

  @Test
  void validLambdaExpr_withBody() {
    VariableExpr fooVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("foo").setType(TypeNode.INT).build())
            .build();

    ExprStatement statement =
        ExprStatement.withExpr(
            AssignmentExpr.builder()
                .setVariableExpr(fooVarExpr.toBuilder().setIsDecl(true).build())
                .setValueExpr(
                    ValueExpr.builder()
                        .setValue(
                            PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build())
                        .build())
                .build());
    LambdaExpr.builder()
        .setBody(Arrays.asList(statement))
        .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
        .build();
  }

  @Test
  void validLambdaExpr_returnsVoid() {
    LambdaExpr voidLambda =
        LambdaExpr.builder()
            .setReturnExpr(
                MethodInvocationExpr.builder()
                    .setMethodName("foo")
                    .setReturnType(TypeNode.VOID)
                    .build())
            .build();
    assertEquals(TypeNode.VOID, voidLambda.returnExpr().type());
  }

  @Test
  void invalidLambdaExpr_undeclaredArgVarExpr() {
    VariableExpr argVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .build();

    assertThrows(
        IllegalStateException.class,
        () ->
            LambdaExpr.builder()
                .setArguments(argVarExpr)
                .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
                .build());
  }

  @Test
  void invalidLambdaExpr_argVarExprWithModifiers() {
    VariableExpr argVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .setIsStatic(true)
            .build();

    assertThrows(
        IllegalStateException.class,
        () ->
            LambdaExpr.builder()
                .setArguments(argVarExpr)
                .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
                .build());
  }

  @Test
  void invalidLambdaExpr_argVarExprWithNonLocalScope() {
    VariableExpr argVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .setScope(ScopeNode.PUBLIC)
            .build();

    assertThrows(
        IllegalStateException.class,
        () ->
            LambdaExpr.builder()
                .setArguments(argVarExpr)
                .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
                .build());
  }

  @Test
  void invalidLambdaExpr_repeatedArgName() {
    VariableExpr argOneVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.INT).build())
            .setIsDecl(true)
            .build();
    VariableExpr argTwoVarExpr =
        VariableExpr.builder()
            .setVariable(Variable.builder().setName("arg").setType(TypeNode.STRING).build())
            .setIsDecl(true)
            .build();

    assertThrows(
        IllegalStateException.class,
        () ->
            LambdaExpr.builder()
                .setArguments(argOneVarExpr, argTwoVarExpr)
                .setReturnExpr(ValueExpr.withValue(StringObjectValue.withValue("foo")))
                .build());
  }
}
