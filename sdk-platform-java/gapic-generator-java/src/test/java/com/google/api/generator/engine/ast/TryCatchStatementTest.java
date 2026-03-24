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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class TryCatchStatementTest {

  @Test
  void validTryCatchStatement_simple() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).setIsDecl(true).build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
            .addCatch(variableExpr, Collections.emptyList())
            .build();
    assertEquals(1, tryCatch.catchVariableExprs().size());
    assertThat(tryCatch.catchVariableExprs().get(0)).isEqualTo(variableExpr);
  }

  @Test
  void validTryCatchStatement_simpleMultiBlock() {
    VariableExpr firstCatchVarExpr =
        VariableExpr.builder()
            .setVariable(
                createVariable("e", TypeNode.withExceptionClazz(IllegalArgumentException.class)))
            .setIsDecl(true)
            .build();
    VariableExpr secondCatchVarExpr =
        VariableExpr.builder()
            .setVariable(createVariable("e", TypeNode.withExceptionClazz(RuntimeException.class)))
            .setIsDecl(true)
            .build();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
            .addCatch(firstCatchVarExpr, Collections.emptyList())
            .addCatch(secondCatchVarExpr, Collections.emptyList())
            .build();

    assertEquals(2, tryCatch.catchVariableExprs().size());
    assertThat(tryCatch.catchVariableExprs().get(0)).isEqualTo(firstCatchVarExpr);
    assertThat(tryCatch.catchVariableExprs().get(1)).isEqualTo(secondCatchVarExpr);
  }

  @Test
  void validTryCatchStatement_withResources() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).setIsDecl(true).build();
    AssignmentExpr assignmentExpr = createAssignmentExpr();

    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryResourceExpr(assignmentExpr)
            .setTryBody(Arrays.asList(ExprStatement.withExpr(assignmentExpr)))
            .addCatch(variableExpr, Collections.emptyList())
            .build();
    assertThat(tryCatch.catchVariableExprs().get(0)).isEqualTo(variableExpr);
    assertThat(tryCatch.tryResourceExpr()).isEqualTo(assignmentExpr);
  }

  @Test
  void validTryCatchStatement_sampleCode() {
    TryCatchStatement tryCatch =
        TryCatchStatement.builder()
            .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
            .setIsSampleCode(true)
            .build();
    assertThat(tryCatch.catchVariableExprs()).isEmpty();
  }

  @Test
  void invalidTryCatchStatement_missingCatchVariable() {
    assertThrows(
        IllegalStateException.class,
        () ->
            TryCatchStatement.builder()
                .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .build());
  }

  @Test
  void invalidTryCatchStatement_catchVariableNotDecl() {
    Reference exceptionReference = ConcreteReference.withClazz(IllegalArgumentException.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            TryCatchStatement.builder()
                .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .addCatch(variableExpr, Collections.emptyList())
                .build());
  }

  @Test
  void invalidTryCatchStatement_nonExceptionReference() {
    Reference exceptionReference = ConcreteReference.withClazz(Integer.class);
    TypeNode type = TypeNode.withReference(exceptionReference);
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(createVariable("e", type)).build();

    assertThrows(
        IllegalStateException.class,
        () ->
            TryCatchStatement.builder()
                .setTryBody(Arrays.asList(ExprStatement.withExpr(createAssignmentExpr())))
                .addCatch(variableExpr, Collections.emptyList())
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

  private static Variable createVariable(String variableName, TypeNode type) {
    return Variable.builder().setName(variableName).setType(type).build();
  }
}
