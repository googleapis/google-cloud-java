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

class ReferenceConstructorExprTest {

  @Test
  void validReferenceConstructorExpr_thisConstructorBasic() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode typeNode = TypeNode.withReference(ref);
    ReferenceConstructorExpr.thisBuilder().setType(typeNode).build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validReferenceConstructorExpr_hasArguments() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode typeNode = TypeNode.withReference(ref);
    ReferenceConstructorExpr.thisBuilder()
        .setType(typeNode)
        .setArguments(
            ValueExpr.withValue(StringObjectValue.withValue("Stu Dent")),
            ValueExpr.withValue(
                PrimitiveValue.builder().setType(TypeNode.INT).setValue("12345678").build()))
        .build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void validReferenceConstructorExpr_superConstructorBasic() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode typeNode = TypeNode.withReference(ref);
    ReferenceConstructorExpr.superBuilder().setType(typeNode).build();
    // No exception thrown, so we succeeded.
  }

  @Test
  void invalidReferenceConstructorExpr_nonReferenceType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ReferenceConstructorExpr.thisBuilder().setType(TypeNode.BOOLEAN).build();
        });
  }

  @Test
  void invalidReferenceConstructorExpr_nullType() {
    assertThrows(
        IllegalStateException.class,
        () -> {
          ReferenceConstructorExpr.superBuilder().setType(TypeNode.NULL).build();
        });
  }

  @Test
  void invalidReferenceConstructorExpr_nullArgument() {
    VaporReference ref =
        VaporReference.builder()
            .setName("Student")
            .setPakkage("com.google.example.examples.v1")
            .build();
    TypeNode typeNode = TypeNode.withReference(ref);
    assertThrows(
        NullPointerException.class,
        () ->
            ReferenceConstructorExpr.thisBuilder()
                .setType(typeNode)
                .setArguments(ValueExpr.withValue(StringObjectValue.withValue("Stu Dent")), null)
                .build());
  }
}
