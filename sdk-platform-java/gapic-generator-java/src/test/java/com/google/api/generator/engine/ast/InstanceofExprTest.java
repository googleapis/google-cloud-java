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

import org.junit.jupiter.api.Test;

class InstanceofExprTest {
  @Test
  void validInstanceofExpr_basicExprPrimitiveType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    InstanceofExpr expr =
        InstanceofExpr.builder().setCheckType(TypeNode.STRING).setExpr(variableExpr).build();
    // No exception thrown, we're good.
    assertThat(expr.type()).isEqualTo(TypeNode.BOOLEAN);
    assertThat(expr.checkType()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void validInstanceofExpr_basicExprObjectType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    InstanceofExpr.builder().setCheckType(TypeNode.STRING).setExpr(variableExpr).build();
    // No exception thrown, we're good.
  }

  @Test
  void invalidInstanceofExpr_primitiveObjectType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> InstanceofExpr.builder().setCheckType(TypeNode.INT).setExpr(variableExpr).build());
  }
}
