// Copyright 2022 Google LLC
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

import com.google.api.generator.test.utils.TestExprBuilder;
import org.junit.jupiter.api.Test;

class ArrayExprTest {

  @Test
  void validAnonymousArray_sametype() {
    ArrayExpr.Builder exprBuilder =
        ArrayExpr.builder()
            .setType(TypeNode.createArrayTypeOf(TypeNode.STRING))
            .addExpr(TestExprBuilder.generateStringValueExpr("test1"))
            .addExpr(TestExprBuilder.generateStringValueExpr("test2"))
            .addExpr(TestExprBuilder.generateStringValueExpr("test3"))
            .addExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setValue("1").setType(TypeNode.INT).build()));

    Exception thrown = assertThrows(IllegalStateException.class, () -> exprBuilder.build());
    assertThat(thrown)
        .hasMessageThat()
        .contains("All expressions must be of the type specified in this ArrayExpr");
  }

  @Test
  void validAnonymousArray_unsetTypeThrows() {
    ArrayExpr.Builder exprBuilder = ArrayExpr.builder();
    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> exprBuilder.build());
    assertThat(thrown).hasMessageThat().contains("Property \"type\" has not been set");
  }

  @Test
  void validAnonymousArray_onlyVariableAndValueExprs() {
    ArrayExpr.Builder exprBuilder =
        ArrayExpr.builder().setType(TypeNode.createArrayTypeOf(TypeNode.INT));
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr =
        VariableExpr.builder().setVariable(variable).setIsDecl(true).build();
    Value value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr valueExpr = ValueExpr.builder().setValue(value).build();
    AssignmentExpr assignExpr =
        AssignmentExpr.builder().setVariableExpr(variableExpr).setValueExpr(valueExpr).build();
    exprBuilder.addExpr(assignExpr);
    IllegalStateException thrown =
        assertThrows(IllegalStateException.class, () -> exprBuilder.build());
    assertThat(thrown)
        .hasMessageThat()
        .contains("Only VariableExpr and ValueExpr can be used as elements of ArrayExpr");
  }
}
