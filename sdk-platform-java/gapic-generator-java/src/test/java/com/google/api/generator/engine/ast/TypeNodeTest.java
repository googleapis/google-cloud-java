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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.api.generator.engine.ast.TypeNode.TypeKind;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class TypeNodeTest {
  private static final TypeNode INT_ARRAY =
      TypeNode.builder().setTypeKind(TypeKind.INT).setIsArray(true).build();
  private static final TypeNode INTEGER_ARRAY =
      TypeNode.builder()
          .setIsArray(true)
          .setReference(ConcreteReference.withClazz(Integer.class))
          .setTypeKind(TypeKind.OBJECT)
          .build();
  private static final TypeNode BOOLEAN_ARRAY =
      TypeNode.builder().setTypeKind(TypeKind.BOOLEAN).setIsArray(true).build();

  @Test
  void strictEquals_basic() {
    assertFalse(TypeNode.INT.strictEquals(TypeNode.BOOLEAN));
    assertFalse(TypeNode.CHAR.strictEquals(TypeNode.NULL));
    assertFalse(TypeNode.INT.strictEquals(INT_ARRAY));
    assertTrue(TypeNode.BOOLEAN.strictEquals(TypeNode.BOOLEAN));
  }

  @Test
  void strictEquals_referenceType() {
    TypeNode list = TypeNode.withReference(ConcreteReference.withClazz(List.class));
    TypeNode intList =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(Integer.class)))
                .build());
    TypeNode charList =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(List.class)
                .setGenerics(Arrays.asList(ConcreteReference.withClazz(Character.class)))
                .build());
    assertFalse(intList.strictEquals(list));
    assertFalse(intList.strictEquals(charList));
  }

  @Test
  void isBoxedTypeEquals_basic() {
    assertTrue(TypeNode.INT.isBoxedTypeEquals(TypeNode.INT_OBJECT));
    assertTrue(TypeNode.DOUBLE_OBJECT.isBoxedTypeEquals(TypeNode.DOUBLE));
    assertFalse(TypeNode.BOOLEAN_OBJECT.isBoxedTypeEquals(TypeNode.SHORT));
    assertFalse(TypeNode.DOUBLE_OBJECT.isBoxedTypeEquals(TypeNode.BOOLEAN_OBJECT));
    assertFalse(TypeNode.DOUBLE.isBoxedTypeEquals(TypeNode.FLOAT));
  }

  @Test
  void isBoxedTypeEquals_arrayType() {
    assertFalse(TypeNode.INT.isBoxedTypeEquals(INT_ARRAY));
    assertFalse(INTEGER_ARRAY.isBoxedTypeEquals(INT_ARRAY));
    assertFalse(BOOLEAN_ARRAY.isBoxedTypeEquals(INT_ARRAY));
  }

  @Test
  void equals_basic() {
    assertTrue(TypeNode.INT.equals(TypeNode.INT_OBJECT));
    assertTrue(TypeNode.DOUBLE_OBJECT.equals(TypeNode.DOUBLE));
    assertTrue(TypeNode.BOOLEAN.equals(TypeNode.BOOLEAN));
    assertTrue(BOOLEAN_ARRAY.equals(BOOLEAN_ARRAY));
    assertFalse(TypeNode.DOUBLE.equals(TypeKind.DOUBLE));
    assertFalse(TypeNode.INT.equals(TypeNode.BOOLEAN));
    assertFalse(TypeNode.CHAR.equals(TypeNode.NULL));
    assertFalse(INTEGER_ARRAY.equals(INT_ARRAY));
  }

  @Test
  void type_wildcardGenerics() {
    // No exception thrown equates to success.
    TypeNode.withReference(
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.wildcard()))
            .build());
  }

  @Test
  void type_wildcardUpperBoundGenerics() {
    // No exception thrown equates to success.
    TypeNode.withReference(
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.wildcardWithUpperBound(TypeNode.STRING.reference())))
            .build());
  }

  @Test
  void compareTypes() {
    // Primitive and primitive.
    // Can't compare objects to themselves, so this test is omitted.
    assertThat(TypeNode.INT.compareTo(TypeNode.BOOLEAN)).isGreaterThan(0);
    assertThat(TypeNode.BOOLEAN.compareTo(TypeNode.INT)).isLessThan(0);

    // Primitive and null.
    assertThat(TypeNode.INT.compareTo(TypeNode.NULL)).isLessThan(0);
    assertThat(TypeNode.NULL.compareTo(TypeNode.INT)).isGreaterThan(0);

    // Primitive and reference.
    assertThat(TypeNode.INT.compareTo(TypeNode.INT_OBJECT)).isLessThan(0);
    assertThat(TypeNode.INT.compareTo(TypeNode.STRING)).isLessThan(0);
    assertThat(TypeNode.INT_OBJECT.compareTo(TypeNode.INT)).isGreaterThan(0);

    // Reference and null.
    // No test for null against null because we can't compare objects to themselves.
    assertThat(TypeNode.INT_OBJECT.compareTo(TypeNode.NULL)).isGreaterThan(0);
    assertThat(TypeNode.NULL.compareTo(TypeNode.BOOLEAN_OBJECT)).isLessThan(0);

    // Reference and reference. Sorted alphabetically by package.
    assertThat(TypeNode.BOOLEAN_OBJECT.compareTo(TypeNode.INT_OBJECT)).isLessThan(0);
    assertThat(TypeNode.BOOLEAN_OBJECT.compareTo(TypeNode.STRING)).isLessThan(0);
    assertThat(
            TypeNode.BOOLEAN_OBJECT.compareTo(
                TypeNode.withReference(ConcreteReference.withClazz(Arrays.class))))
        .isLessThan(0);
  }

  @Test
  void invalidType_topLevelWildcard() {
    assertThrows(
        IllegalStateException.class, () -> TypeNode.withReference(ConcreteReference.wildcard()));
  }

  @Test
  void isBoxedType_basic() {
    assertTrue(TypeNode.isBoxedType(TypeNode.INT_OBJECT));
    assertTrue(TypeNode.isBoxedType(TypeNode.BOOLEAN_OBJECT));
    assertTrue(TypeNode.isBoxedType(TypeNode.DOUBLE_OBJECT));
    assertTrue(
        TypeNode.isBoxedType(TypeNode.withReference(ConcreteReference.withClazz(Long.class))));

    assertFalse(TypeNode.isBoxedType(TypeNode.BOOLEAN));
    assertFalse(TypeNode.isBoxedType(TypeNode.INT));
    assertFalse(TypeNode.isBoxedType(TypeNode.FLOAT));

    assertFalse(TypeNode.isBoxedType(TypeNode.STRING));
    TypeNode someType =
        TypeNode.withReference(
            VaporReference.builder()
                .setName("SomeClass")
                .setPakkage("com.google.api.generator.engine")
                .build());
    assertFalse(TypeNode.isBoxedType(someType));
  }
}
