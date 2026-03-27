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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ConcreteReferenceTest {
  @Test
  void basicConcreteReference() {
    Reference reference = ConcreteReference.builder().setClazz(Integer.class).build();
    assertEquals(Integer.class.getSimpleName(), reference.name());
    assertFalse(reference.isStaticImport());
  }

  @Test
  void basicConcreteReference_setIsStaticImport() {
    Reference reference =
        ConcreteReference.builder().setClazz(Integer.class).setIsStaticImport(true).build();
    assertEquals(Integer.class.getSimpleName(), reference.name());
    assertFalse(reference.isStaticImport());
  }

  @Test
  void basicConcreteReference_nested() {
    Reference reference = ConcreteReference.builder().setClazz(Map.Entry.class).build();
    assertEquals("Map.Entry", reference.name());
    assertFalse(reference.isStaticImport());
  }

  @Test
  void basicConcreteReference_nestedAndStaticImport() {
    Reference reference =
        ConcreteReference.builder().setClazz(Map.Entry.class).setIsStaticImport(true).build();
    assertEquals(Map.Entry.class.getSimpleName(), reference.name());
    assertTrue(reference.isStaticImport());
  }

  @Test
  void parameterizedConcreteReference() {
    Reference reference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    assertEquals(reference.name(), "HashMap<String, Integer>");
    assertEquals("java.util.HashMap", reference.fullName());
  }

  @Test
  void nestedParameterizedConcreteReference() {
    Reference mapReference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    Reference outerMapReference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(mapReference, mapReference))
            .build();
    Reference listReference =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(outerMapReference))
            .build();
    assertEquals(
        "List<HashMap<HashMap<String, Integer>, HashMap<String, Integer>>>", listReference.name());
    assertEquals("java.util.List", listReference.fullName());
  }

  @Test
  void isSupertype_basic() {
    assertTrue(TypeNode.STRING.isSupertypeOrEquals(TypeNode.STRING));
    assertFalse(TypeNode.INT.isSupertypeOrEquals(TypeNode.STRING));
    assertFalse(TypeNode.STRING.isSupertypeOrEquals(TypeNode.INT));
    assertFalse(TypeNode.INT.isSupertypeOrEquals(TypeNode.INT));

    TypeNode mapType = TypeNode.withReference(ConcreteReference.withClazz(Map.class));
    TypeNode hashMapType = TypeNode.withReference(ConcreteReference.withClazz(HashMap.class));
    assertTrue(mapType.isSupertypeOrEquals(hashMapType));
    assertFalse(hashMapType.isSupertypeOrEquals(mapType));
  }

  @Test
  void isSupertype_nestedGenerics() {
    Reference stringRef = ConcreteReference.withClazz(String.class);
    TypeNode typeOne =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(Map.class)
                .setGenerics(
                    Arrays.asList(
                        stringRef,
                        ConcreteReference.builder()
                            .setClazz(List.class)
                            .setGenerics(Arrays.asList(ConcreteReference.withClazz(Expr.class)))
                            .build()))
                .build());
    TypeNode typeTwo =
        TypeNode.withReference(
            ConcreteReference.builder()
                .setClazz(HashMap.class)
                .setGenerics(
                    Arrays.asList(
                        stringRef,
                        ConcreteReference.builder()
                            .setClazz(ArrayList.class)
                            .setGenerics(
                                Arrays.asList(ConcreteReference.withClazz(ValueExpr.class)))
                            .build()))
                .build());
    assertTrue(typeOne.isSupertypeOrEquals(typeOne));
    assertTrue(typeOne.isSupertypeOrEquals(typeTwo));
    assertFalse(typeTwo.isSupertypeOrEquals(typeOne));
  }

  @Test
  void wildcards() {
    assertEquals(ConcreteReference.wildcard().name(), "?");
    assertEquals(
        "? extends String",
        ConcreteReference.wildcardWithUpperBound(TypeNode.STRING.reference()).name());
  }

  @Test
  void isAssignableFrom_concreteRef() {
    assertFalse(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(ConcreteReference.withClazz(Map.class)));

    assertTrue(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(ConcreteReference.withClazz(ArrayList.class)));
    assertFalse(
        ConcreteReference.withClazz(ArrayList.class)
            .isAssignableFrom(ConcreteReference.withClazz(List.class)));
    assertTrue(
        ConcreteReference.withClazz(ArrayList.class)
            .isAssignableFrom(ConcreteReference.withClazz(ArrayList.class)));

    assertTrue(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(
                ConcreteReference.builder()
                    .setClazz(ArrayList.class)
                    .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                    .build()));
    assertTrue(
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
            .build()
            .isAssignableFrom(
                ConcreteReference.builder()
                    .setClazz(ArrayList.class)
                    .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                    .build()));
    assertFalse(
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(ConcreteReference.withClazz(Integer.class)))
            .build()
            .isAssignableFrom(
                ConcreteReference.builder()
                    .setClazz(ArrayList.class)
                    .setGenerics(Arrays.asList(ConcreteReference.withClazz(String.class)))
                    .build()));
  }

  @Test
  void isAssignableFrom_vaporRef() {
    assertFalse(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(
                VaporReference.builder().setName("ArrayList").setPakkage("java.util").build()));
    assertFalse(
        ConcreteReference.withClazz(ArrayList.class)
            .isAssignableFrom(
                VaporReference.builder().setName("ArrayList").setPakkage("java.util").build()));
  }

  @Test
  void isAssignableFrom_vaporRefWithConcreteRefSupertype() {
    assertTrue(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(
                VaporReference.builder()
                    .setName("ArrayList")
                    .setPakkage("java.util")
                    .setSupertypeReference(ConcreteReference.withClazz(List.class))
                    .build()));
    assertTrue(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(
                VaporReference.builder()
                    .setName("SpecialArrayList")
                    .setPakkage("com.foo.bar")
                    .setSupertypeReference(ConcreteReference.withClazz(ArrayList.class))
                    .build()));
    assertFalse(
        ConcreteReference.withClazz(List.class)
            .isAssignableFrom(
                VaporReference.builder()
                    .setName("HashMap")
                    .setPakkage("java.util")
                    .setSupertypeReference(ConcreteReference.withClazz(Map.class))
                    .build()));
  }
}
