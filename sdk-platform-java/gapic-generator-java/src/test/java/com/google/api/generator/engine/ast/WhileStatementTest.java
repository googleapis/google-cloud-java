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

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class WhileStatementTest {
  @Test
  void validWhileStatement_simple() {
    WhileStatement whileStatement =
        WhileStatement.builder()
            .setConditionExpr(createConditionExpr("condition"))
            .setBody(createAssignmentExprList())
            .build();
    assertEquals(TypeNode.BOOLEAN, whileStatement.conditionExpr().type());
  }

  @Test
  void validWhileStatement_booleanObjectCondition() {
    // The condition expression type can be boolean or its boxed type.
    VariableExpr condExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("condition").setType(TypeNode.BOOLEAN_OBJECT).build());
    WhileStatement whileStatement =
        WhileStatement.builder()
            .setConditionExpr(condExpr)
            .setBody(createAssignmentExprList())
            .build();
    assertEquals(TypeNode.BOOLEAN, whileStatement.conditionExpr().type());
  }

  @Test
  void validWhileStatement_nested() {
    WhileStatement nestedWhileStatement =
        WhileStatement.builder()
            .setConditionExpr(createConditionExpr("nestedCondition"))
            .setBody(createAssignmentExprList())
            .build();
    WhileStatement whileStatement =
        WhileStatement.builder()
            .setConditionExpr(createConditionExpr("condition"))
            .setBody(Arrays.asList(nestedWhileStatement))
            .build();
    assertEquals(TypeNode.BOOLEAN, whileStatement.conditionExpr().type());
  }

  @Test
  void invalidWhileStatement_emptyBody() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          WhileStatement.builder().setConditionExpr(createConditionExpr("condition")).build();
        });
  }

  private static List<Statement> createAssignmentExprList() {
    AssignmentExpr assignExpr =
        AssignmentExpr.builder()
            .setVariableExpr(
                VariableExpr.withVariable(
                    Variable.builder().setType(TypeNode.INT).setName("x").build()))
            .setValueExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setValue("3").setType(TypeNode.INT).build()))
            .build();
    return Arrays.asList(ExprStatement.withExpr(assignExpr));
  }

  private static VariableExpr createConditionExpr(String name) {
    return VariableExpr.withVariable(
        Variable.builder().setName(name).setType(TypeNode.BOOLEAN).build());
  }
}
