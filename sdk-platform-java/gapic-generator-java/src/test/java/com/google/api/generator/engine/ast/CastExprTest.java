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

class CastExprTest {
  @Test
  void validCastExpr_basic() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder()
        .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
        .setExpr(variableExpr)
        .build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validCastExpr_basicNull() {
    CastExpr.builder()
        .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
        .setExpr(ValueExpr.createNullExpr())
        .build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validCastExpr_basicPrimitiveSame() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.LONG).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.LONG).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validCastExpr_basicPrimitiveBoolean() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.BOOLEAN).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validCastExpr_basicPrimitiveNarrowing() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.LONG).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.INT).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.

    variable = Variable.builder().setName("x").setType(TypeNode.DOUBLE).build();
    variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.FLOAT).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.

  }

  @Test
  void validCastExpr_basicPrimitiveWidening() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.LONG).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.
    variable = Variable.builder().setName("x").setType(TypeNode.FLOAT).build();
    variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.DOUBLE).setExpr(variableExpr).build();
    // No exception thrown, so we succeeded.

  }

  @Test
  void validCastExpr_castPrimitiveToBoxedType() {
    PrimitiveValue intValue = PrimitiveValue.builder().setValue("3").setType(TypeNode.INT).build();
    ValueExpr valueExpr = ValueExpr.withValue(intValue);
    CastExpr.builder().setType(TypeNode.INT_OBJECT).setExpr(valueExpr).build();
  }

  @Test
  void validCastExpr_castBoxedTypeToPrimitive() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.DOUBLE_OBJECT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.DOUBLE).setExpr(variableExpr).build();
  }

  @Test
  void validCastExpr_booleanToBoxedType() {
    PrimitiveValue booleanValue =
        PrimitiveValue.builder().setValue("true").setType(TypeNode.BOOLEAN).build();
    ValueExpr valueExpr = ValueExpr.withValue(booleanValue);
    CastExpr.builder().setType(TypeNode.BOOLEAN_OBJECT).setExpr(valueExpr).build();
  }

  @Test
  void validCastExpr_castBooleanToPrimitive() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN_OBJECT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    CastExpr.builder().setType(TypeNode.BOOLEAN).setExpr(variableExpr).build();
  }

  @Test
  void invalidCastExpr_castBoxedPrimitiveArray() {
    TypeNode intArray =
        TypeNode.builder().setTypeKind(TypeNode.TypeKind.INT).setIsArray(true).build();
    TypeNode integerArray =
        TypeNode.builder()
            .setIsArray(true)
            .setReference(ConcreteReference.withClazz(Integer.class))
            .setTypeKind(TypeNode.TypeKind.OBJECT)
            .build();
    Variable variable = Variable.builder().setName("intArray").setType(intArray).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> CastExpr.builder().setType(integerArray).setExpr(variableExpr).build());
  }

  @Test
  void invalidCastExpr_castObjectToPrimitive() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.STRING).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> CastExpr.builder().setType(TypeNode.INT).setExpr(variableExpr).build());
  }

  @Test
  void invalidCastExpr_castPrimitiveToObject() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () ->
            CastExpr.builder()
                .setType(TypeNode.withReference(ConcreteReference.withClazz(Object.class)))
                .setExpr(variableExpr)
                .build());
  }

  @Test
  void invalidCastExpr_castBooleanToNumeric() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.BOOLEAN).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> CastExpr.builder().setType(TypeNode.INT).setExpr(variableExpr).build());
  }

  @Test
  void invalidCastExpr_castNumericToBoolean() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> CastExpr.builder().setType(TypeNode.BOOLEAN).setExpr(variableExpr).build());
  }

  @Test
  void invalidCastExpr_castToVoidType() {
    Variable variable = Variable.builder().setName("x").setType(TypeNode.INT).build();
    VariableExpr variableExpr = VariableExpr.builder().setVariable(variable).build();
    assertThrows(
        IllegalStateException.class,
        () -> CastExpr.builder().setType(TypeNode.VOID).setExpr(variableExpr).build());
  }
}
