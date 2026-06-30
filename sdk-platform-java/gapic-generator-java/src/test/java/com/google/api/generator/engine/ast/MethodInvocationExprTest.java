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

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MethodInvocationExprTest {

  @Test
  void validBuildMethodInvocationExpr() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ArrayList.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());

    MethodInvocationExpr.builder().setMethodName("getSomeList").setReturnType(returnType).build();
    // No exception thrown, we're good.
  }

  @Test
  void validBuildMethodInvocationExpr_hasArguments() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ArrayList.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());

    MethodInvocationExpr.builder()
        .setMethodName("addNumbers")
        .setArguments(
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()),
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("2").build()))
        .setReturnType(returnType)
        .build();
    // No exception thrown, we're good.
  }

  @Test
  void validBuildMethodInvocationExpr_staticReference() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    MethodInvocationExpr.builder()
        .setMethodName("foobar")
        .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
        .setStaticReferenceType(someType)
        .setReturnType(TypeNode.STRING)
        .build();
  }

  @Test
  void invalidBuildMethodInvocationExpr_nullReturnType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          MethodInvocationExpr.builder()
              .setMethodName("invalid")
              .setReturnType(TypeNode.NULL)
              .build();
        });
  }

  @Test
  void invalidBuildMethodInvocationExpr_staticAndExprBoth() {
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    assertThrows(
        IllegalStateException.class,
        () -> {
          Variable variable = Variable.builder().setType(TypeNode.INT).setName("someVar").build();
          VariableExpr varExpr = VariableExpr.builder().setVariable(variable).build();
          MethodInvocationExpr.builder()
              .setMethodName("foobar")
              .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
              .setStaticReferenceType(someType)
              .setExprReferenceExpr(varExpr)
              .setReturnType(TypeNode.STRING)
              .build();
        });
  }

  @Test
  void invalidBuildMethodInvocationExpr_nullArgument() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode returnType =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(ArrayList.class)
                .setGenerics(Arrays.asList(stringRef))
                .build());

    assertThrows(
        IllegalStateException.class,
        () ->
            MethodInvocationExpr.builder()
                .setMethodName("addNumbers")
                .setArguments(
                    ValueExpr.withValue(
                        PrimitiveValue.builder().setType(TypeNode.INT).setValue("1").build()),
                    null)
                .setReturnType(returnType)
                .build());
  }
}
