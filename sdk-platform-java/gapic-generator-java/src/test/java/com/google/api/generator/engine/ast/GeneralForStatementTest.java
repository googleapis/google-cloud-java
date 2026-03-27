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

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class GeneralForStatementTest {
  /** ============================== incrementWith ====================================== */
  @Test
  // validGeneralForStatement_basicIsDecl tests declare a variable inside in initialization expr.
  void validGeneralForStatement_basicIsDecl() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());

    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    GeneralForStatement.incrementWith(
        variableExpr, initValue, maxSizeExpr, Arrays.asList(createBodyStatement()));
  }

  @Test
  // validGeneralForStatement_basicIsNotDecl tests assigning a method-level local variable in
  // initialization expr.
  void validGeneralForStatement_basicIsNotDecl() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(false).build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());

    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    GeneralForStatement.incrementWith(
        variableExpr, initValue, maxSizeExpr, Arrays.asList(createBodyStatement()));
  }

  @Test
  // validGeneralForStatement_emptyBody tests set empty body in update expr.
  void validGeneralForStatement_emptyBody() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(false).build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());

    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    GeneralForStatement.incrementWith(
        variableExpr, initValue, maxSizeExpr, Collections.emptyList());
  }

  @Test
  // validForStatement_privateNotIsDeclVariable tests assigning an instance variable with private
  // scope.
  void validForStatement_privateNotIsDeclVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setIsDecl(false)
            .setVariable(variable)
            .setScope(ScopeNode.PRIVATE)
            .build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();
    GeneralForStatement.incrementWith(
        variableExpr, initValue, maxSizeExpr, Collections.emptyList());
  }

  @Test
  // validForStatement_instanceStaticVariable tests assigning an instance variable with scope
  // and static modifier.
  void validForStatement_instanceStaticVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setIsDecl(false)
            .setVariable(variable)
            .setScope(ScopeNode.PUBLIC)
            .setIsStatic(true)
            .build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();
    GeneralForStatement.incrementWith(
        variableExpr, initValue, maxSizeExpr, Collections.emptyList());
  }

  @Test
  // invalidForStatement_privateIsDeclVariable tests declaring a non-local variable inside of
  // for-loop.
  void invalidForStatement_privateIsDeclVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setIsDecl(true)
            .setVariable(variable)
            .setScope(ScopeNode.PRIVATE)
            .build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            GeneralForStatement.incrementWith(
                variableExpr, initValue, maxSizeExpr, Collections.emptyList()));
  }

  @Test
  // invalidForStatement_staticIsDeclVariable tests declare a static local variable in
  // initialization expr.
  void invalidForStatement_staticIsDeclVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).setIsStatic(true).build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            GeneralForStatement.incrementWith(
                variableExpr, initValue, maxSizeExpr, Collections.emptyList()));
  }

  @Test
  // invalidForStatement_finalIsNotDeclVariable tests invalid case of assigning the initial value to
  // a variable which is declared as a final instance variable.
  void invalidForStatement_finalIsNotDeclVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder()
            .setVariable(variable)
            .setIsDecl(false)
            .setScope(ScopeNode.PUBLIC)
            .setIsFinal(true)
            .build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            GeneralForStatement.incrementWith(
                variableExpr, initValue, maxSizeExpr, Collections.emptyList()));
  }

  @Test
  // invalidForStatement_localFinalVariable tests declare a final variable in initialization expr,
  // updateExpr should throw error.
  void invalidForStatement_localFinalVariable() {
    Variable variable = Variable.builder().setName("i").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).setIsFinal(true).build();
    ValueExpr initValue =
        ValueExpr.withValue(PrimitiveValue.builder().setValue("0").setType(TypeNode.INT).build());
    MethodInvocationExpr maxSizeExpr =
        MethodInvocationExpr.builder().setMethodName("maxSize").setReturnType(TypeNode.INT).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            GeneralForStatement.incrementWith(
                variableExpr, initValue, maxSizeExpr, Collections.emptyList()));
  }

  private static Statement createBodyStatement() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Variable anotherVariable = Variable.builder().setName("y").setType(TypeNode.INT).build();
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    return ExprStatement.withExpr(
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build());
  }
}
