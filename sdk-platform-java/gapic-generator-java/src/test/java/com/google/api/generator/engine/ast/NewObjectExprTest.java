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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NewObjectExprTest {
  @Test
  void validNewObjectValue_basic() {
    // isGeneric() is true and generics() is not empty.
    // [Constructing] `new List<String>()`, no exception should be thrown.
    ConcreteReference ref =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .build();
    TypeNode type = TypeNode.withReference(ref);
    NewObjectExpr newObjectExpr = NewObjectExpr.builder().setIsGeneric(true).setType(type).build();
    assertEquals(newObjectExpr.type(), type);
    assertEquals(newObjectExpr.isGeneric(), true);
  }

  @Test
  void validNewObjectValue_hasArgument() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode type = TypeNode.withReference(ref);
    NewObjectExpr.builder()
        .setType(type)
        .setArguments(
            ValueExpr.withValue(StringObjectValue.withValue("Stu Dent")),
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("12345678").build()))
        .build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validNewObjectExpr_edgeCase() {
    // isGeneric() is false, but generics() is not empty.
    // The expression is still valid, we will set isGeneric() as true for the users.
    // [Constructing] `new List<String>()`, no exception should be thrown.
    ConcreteReference ref =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .build();
    TypeNode type = TypeNode.withReference(ref);
    NewObjectExpr newObjectExpr = NewObjectExpr.builder().setType(type).build();
    assertEquals(newObjectExpr.type(), type);
    assertEquals(newObjectExpr.isGeneric(), true);
  }

  @Test
  void validNewObjectExpr_noGenericWithArgs() {
    // isGeneric() is false, and generics() is empty.
    // [Constructing] `new Integer(123)` no exception should be thrown.
    ConcreteReference ref = ConcreteReference.builder().setClazz(Integer.class).build();
    TypeNode type = TypeNode.withReference(ref);
    PrimitiveValue value = PrimitiveValue.builder().setType(TypeNode.INT).setValue("123").build();
    ValueExpr valueExpr = ValueExpr.builder().setValue(value).build();
    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder().setType(type).setArguments(Arrays.asList(valueExpr)).build();
    assertEquals(newObjectExpr.type(), type);
    assertEquals(newObjectExpr.isGeneric(), false);
  }

  @Test
  void validNewObjectExpr_emptyGeneric() {
    // isGeneric() is true, but generics() is empty.
    // [Constructing] `new LinkedList<>()` no exception should be thrown.
    ConcreteReference ref = ConcreteReference.builder().setClazz(LinkedList.class).build();
    TypeNode type = TypeNode.withReference(ref);
    NewObjectExpr newObjectExpr = NewObjectExpr.builder().setType(type).setIsGeneric(true).build();
    assertEquals(newObjectExpr.type(), type);
    assertEquals(newObjectExpr.isGeneric(), true);
  }

  @Test
  void validNewObjectExpr_genericsAndArgs() {
    // isGeneric() is true, generics() is not empty, and argument list is also not empty.
    // [Constructing] `new HashMap<List<String>, Integer>>(initialCapacity, loadFactor)`.
    ConcreteReference listRef =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .build();
    ConcreteReference mapRef =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(listRef, ConcreteReference.withClazz(Integer.class)))
            .build();
    TypeNode type = TypeNode.withReference(mapRef);
    Variable initialCapacity =
        Variable.builder().setName("initialCapacity").setType(TypeNode.INT).build();
    VariableExpr initCapacityExpr = VariableExpr.builder().setVariable(initialCapacity).build();
    Variable loadFactor = Variable.builder().setName("loadFactor").setType(TypeNode.FLOAT).build();
    VariableExpr loadFactorExpr = VariableExpr.builder().setVariable(loadFactor).build();

    NewObjectExpr newObjectExpr =
        NewObjectExpr.builder()
            .setIsGeneric(true)
            .setType(type)
            .setArguments(Arrays.asList(initCapacityExpr, loadFactorExpr))
            .build();
    assertEquals(newObjectExpr.type(), type);
    assertEquals(newObjectExpr.isGeneric(), true);
  }

  @Test
  void invalidNewObjectExpr_primitiveType() {
    // New object expressions should be reference types.
    assertThrows(
        IllegalStateException.class,
        () -> {
          NewObjectExpr.builder().setIsGeneric(false).setType(TypeNode.INT).build();
        });
  }

  @Test
  void invalidNewObjectExpr_nullType() {
    // New object expressions cannot be null type.
    assertThrows(
        IllegalStateException.class,
        () -> {
          NewObjectExpr.builder().setIsGeneric(false).setType(TypeNode.NULL).build();
        });
  }

  @Test
  void invalidNewObjectValue_nullArgument() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode type = TypeNode.withReference(ref);
    assertThrows(
        NullPointerException.class,
        () ->
            NewObjectExpr.builder()
                .setType(type)
                .setArguments(ValueExpr.withValue(StringObjectValue.withValue("Stu Dent")), null)
                .build());
  }
}
