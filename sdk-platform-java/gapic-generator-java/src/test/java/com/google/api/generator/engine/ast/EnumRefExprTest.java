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

class EnumRefExprTest {
  @Test
  void validEnumRefExpr_basic() {
    TypeNode enumType =
        TypeNode.withReference(ConcreteReference.withClazz(TypeNode.TypeKind.class));
    EnumRefExpr.builder().setName("VOID").setType(enumType).build();
  }

  @Test
  void invalidEnumRefExpr_primitiveType() {
    assertThrows(
        IllegalStateException.class,
        () -> EnumRefExpr.builder().setName("VOID").setType(TypeNode.INT).build());
  }

  @Test
  void invalidEnumRefExpr_nullType() {
    assertThrows(
        IllegalStateException.class,
        () -> EnumRefExpr.builder().setName("VOID").setType(TypeNode.NULL).build());
  }
}
