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

class TernaryExprTest {
  @Test
  void validTernaryExpr_primitiveType() {
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();

    Value value1 = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr thenExpr = ValueExpr.builder().setValue(value1).build();
    Value value2 = PrimitiveValue.builder().setType(TypeNode.INT).setValue("4").build();
    Expr elseExpr = ValueExpr.builder().setValue(value2).build();

    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(ternaryExpr.elseExpr().type(), ternaryExpr.thenExpr().type());
    assertEquals(TypeNode.INT, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_objectType() {
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();

    Value value1 = StringObjectValue.withValue("str1");
    Expr thenExpr = ValueExpr.builder().setValue(value1).build();
    Value value2 = StringObjectValue.withValue("str2");
    Expr elseExpr = ValueExpr.builder().setValue(value2).build();

    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(ternaryExpr.elseExpr().type(), ternaryExpr.thenExpr().type());
    assertEquals(TypeNode.STRING, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_primitiveAndBoxedType() {
    // [Constructing] `condition ? intValue : integerValue`
    // The type of whole expression should be Integer.
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();
    Variable intVariable = Variable.builder().setName("intValue").setType(TypeNode.INT).build();
    VariableExpr thenExpr = VariableExpr.builder().setVariable(intVariable).build();
    Variable integerVariable =
        Variable.builder().setName("integerValue").setType(TypeNode.INT_OBJECT).build();
    VariableExpr elseExpr = VariableExpr.builder().setVariable(integerVariable).build();
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(ternaryExpr.elseExpr().type(), ternaryExpr.thenExpr().type());
    assertEquals(TypeNode.INT_OBJECT, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_boxedAndPrimitiveType() {
    // [Constructing] `condition ? doubleObjectVariable : doubleVariable`
    // The type of whole expression should be Double.
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();
    Variable intVariable =
        Variable.builder().setName("doubleObjectVariable").setType(TypeNode.DOUBLE_OBJECT).build();
    VariableExpr thenExpr = VariableExpr.builder().setVariable(intVariable).build();
    Variable integerVariable =
        Variable.builder().setName("doubleVariable").setType(TypeNode.DOUBLE).build();
    VariableExpr elseExpr = VariableExpr.builder().setVariable(integerVariable).build();
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(conditionExpr)
            .setThenExpr(thenExpr)
            .setElseExpr(elseExpr)
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(ternaryExpr.elseExpr().type(), ternaryExpr.thenExpr().type());
    assertEquals(TypeNode.DOUBLE_OBJECT, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_objectAndNull() {
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build()))
            .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
            .setElseExpr(ValueExpr.createNullExpr())
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(TypeNode.STRING, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_nullAndObject() {
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build()))
            .setThenExpr(ValueExpr.createNullExpr())
            .setElseExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(TypeNode.STRING, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_superAndSubtype() {
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build()))
            .setThenExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("anObject").setType(TypeNode.OBJECT).build()))
            .setElseExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(TypeNode.OBJECT, ternaryExpr.type());
  }

  @Test
  void validTernaryExpr_subAndSupertype() {
    TernaryExpr ternaryExpr =
        TernaryExpr.builder()
            .setConditionExpr(
                ValueExpr.withValue(
                    PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build()))
            .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
            .setElseExpr(
                VariableExpr.withVariable(
                    Variable.builder().setName("anObject").setType(TypeNode.OBJECT).build()))
            .build();
    assertEquals(TypeNode.BOOLEAN, ternaryExpr.conditionExpr().type());
    assertEquals(TypeNode.OBJECT, ternaryExpr.type());
  }

  @Test
  void invalidTernaryExpr_mismatchedPrimitiveTypes() {
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();

    Value value1 = PrimitiveValue.builder().setType(TypeNode.INT).setValue("3").build();
    Expr thenExpr = ValueExpr.builder().setValue(value1).build();
    Value value2 = PrimitiveValue.builder().setType(TypeNode.BOOLEAN).setValue("false").build();
    Expr elseExpr = ValueExpr.builder().setValue(value2).build();
    assertThrows(
        IllegalStateException.class,
        () -> {
          TernaryExpr.builder()
              .setConditionExpr(conditionExpr)
              .setThenExpr(thenExpr)
              .setElseExpr(elseExpr)
              .build();
        });
  }

  @Test
  void invalidTernaryExpr_mismatchedBoxedAndPrimitiveTypes() {
    Variable conditionVariable =
        Variable.builder().setName("condition").setType(TypeNode.BOOLEAN).build();
    VariableExpr conditionExpr = VariableExpr.builder().setVariable(conditionVariable).build();

    Expr thenExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("intObjectVar").setType(TypeNode.INT_OBJECT).build());
    Expr elseExpr =
        VariableExpr.withVariable(
            Variable.builder().setName("doubleVar").setType(TypeNode.DOUBLE).build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          TernaryExpr.builder()
              .setConditionExpr(conditionExpr)
              .setThenExpr(thenExpr)
              .setElseExpr(elseExpr)
              .build();
        });
  }

  @Test
  void invalidTernaryExpr_incompatibleThenElsePrimitiveTypes() {
    assertThrows(
        IllegalStateException.class,
        () ->
            TernaryExpr.builder()
                .setConditionExpr(
                    ValueExpr.withValue(
                        PrimitiveValue.builder()
                            .setType(TypeNode.BOOLEAN)
                            .setValue("false")
                            .build()))
                .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
                .setElseExpr(
                    VariableExpr.withVariable(
                        Variable.builder()
                            .setName("anObject")
                            .setType(TypeNode.STRING_ARRAY)
                            .build()))
                .build());
  }

  @Test
  void invalidTernaryExpr_incompatibleThenElseObjectTypes() {
    assertThrows(
        IllegalStateException.class,
        () ->
            TernaryExpr.builder()
                .setConditionExpr(
                    ValueExpr.withValue(
                        PrimitiveValue.builder()
                            .setType(TypeNode.BOOLEAN)
                            .setValue("false")
                            .build()))
                .setThenExpr(ValueExpr.withValue(StringObjectValue.withValue("foobar")))
                .setElseExpr(
                    VariableExpr.withVariable(
                        Variable.builder()
                            .setName("anObject")
                            .setType(
                                TypeNode.withReference(
                                    ConcreteReference.withClazz(Exception.class)))
                            .build()))
                .build());
  }
}
