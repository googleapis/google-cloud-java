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

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ForStatementTest {

  @Test
  void validForStatement() {
    Variable variable = Variable.builder().setName("str").setType(TypeNode.STRING).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder().setMethodName("getSomeStrings").build();

    ForStatement forStatement =
        ForStatement.builder()
            .setLocalVariableExpr(variableExpr)
            .setCollectionExpr(methodExpr)
            .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
            .build();
    assertThat(forStatement.collectionExpr()).isEqualTo(methodExpr);
  }

  @Test
  void invalidForStatement() {
    Variable variable = Variable.builder().setName("str").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();

    MethodInvocationExpr methodExpr =
        MethodInvocationExpr.builder().setMethodName("getSomeStrings").build();
    assertThrows(
        IllegalStateException.class,
        () ->
            ForStatement.builder()
                .setLocalVariableExpr(variableExpr)
                .setCollectionExpr(methodExpr)
                .setBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .build());
  }

  private static AssignmentExpr createAssignmentExpr() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();

    Variable anotherVariable = Variable.builder().setName("y").setType(TypeNode.INT).build();
    Expr valueExpr = VariableExpr.builder().setVariable(anotherVariable).build();

    return AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
  }
}
