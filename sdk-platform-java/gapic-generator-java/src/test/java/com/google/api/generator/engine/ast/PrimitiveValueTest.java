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

import com.google.api.generator.engine.ast.TypeNode.TypeKind;
import org.junit.jupiter.api.Test;

class PrimitiveValueTest {
  @Test
  void createPrimitiveValue_basic() {
    assertValidValue(TypeKind.INT, "3");
    assertValidValue(TypeKind.BOOLEAN, "false");
    assertValidValue(TypeKind.LONG, "123");
    assertValidValue(TypeKind.FLOAT, "123.f");
    assertValidValue(TypeKind.DOUBLE, "123e10");
  }

  @Test
  void createPrimitiveValue_invalid() {
    assertInvalidValue(TypeKind.INT, "123.f");
    assertInvalidValue(TypeKind.INT, "false");
    assertInvalidValue(TypeKind.BOOLEAN, "False");
    assertInvalidValue(TypeKind.FLOAT, "asdfg");
  }

  @Test
  void createPrimitiveValue_unsupported() {
    assertInvalidValue(TypeKind.BYTE, "0x2");
    assertInvalidValue(TypeKind.SHORT, "1");
    assertInvalidValue(TypeKind.CHAR, "a");
  }

  private static void assertValidValue(TypeKind typeKind, String value) {
    TypeNode type = TypeNode.builder().setTypeKind(typeKind).build();
    PrimitiveValue primitiveValue = PrimitiveValue.builder().setType(type).setValue(value).build();
    assertEquals(value, primitiveValue.value());
    assertThat(primitiveValue.type()).isEqualTo(type);
  }

  private void assertInvalidValue(TypeKind typeKind, String value) {
    TypeNode type = TypeNode.builder().setTypeKind(typeKind).build();
    assertThrows(
        TypeMismatchException.class,
        () -> {
          PrimitiveValue.builder().setType(type).setValue(value).build();
        });
  }
}
