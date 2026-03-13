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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class ReferenceTest {
  @Test
  void nestedGenerics_concreteReferenceOuter() {
    Reference mapReference =
        VaporReference.builder()
            .setName("HashMap")
            .setPakkage("java.util")
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
  void nestedGenerics_vaporReferenceOuter() {
    Reference mapReference =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    VaporReference.builder().setName("String").setPakkage("java.lang").build(),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    Reference outerMapReference =
        VaporReference.builder()
            .setName("HashMap")
            .setPakkage("java.util")
            .setGenerics(Arrays.asList(mapReference, mapReference))
            .build();
    Reference listReference =
        VaporReference.builder()
            .setName("List")
            .setPakkage("java.util")
            .setGenerics(Arrays.asList(outerMapReference))
            .build();
    assertEquals(
        "List<HashMap<HashMap<String, Integer>, HashMap<String, Integer>>>", listReference.name());
    assertEquals("java.util.List", listReference.fullName());
  }

  @Test
  void mixedConcreteVaporReferenceEquals() {
    Reference mapReferenceVaporOuter =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(
                Arrays.asList(
                    VaporReference.builder().setName("String").setPakkage("java.lang").build(),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    Reference outerMapReferenceVaporOuter =
        VaporReference.builder()
            .setName("HashMap")
            .setPakkage("java.util")
            .setGenerics(Arrays.asList(mapReferenceVaporOuter, mapReferenceVaporOuter))
            .build();
    Reference listReferenceVaporOuter =
        VaporReference.builder()
            .setName("List")
            .setPakkage("java.util")
            .setGenerics(Arrays.asList(outerMapReferenceVaporOuter))
            .build();

    Reference mapReferenceConcreteOuter =
        VaporReference.builder()
            .setName("HashMap")
            .setPakkage("java.util")
            .setGenerics(
                Arrays.asList(
                    ConcreteReference.withClazz(String.class),
                    ConcreteReference.withClazz(Integer.class)))
            .build();
    Reference outerMapReferenceConcreteOuter =
        ConcreteReference.builder()
            .setClazz(HashMap.class)
            .setGenerics(Arrays.asList(mapReferenceConcreteOuter, mapReferenceConcreteOuter))
            .build();
    Reference listReferenceConcreteOuter =
        ConcreteReference.builder()
            .setClazz(List.class)
            .setGenerics(Arrays.asList(outerMapReferenceConcreteOuter))
            .build();

    assertEquals(listReferenceConcreteOuter, listReferenceConcreteOuter);

    assertFalse(listReferenceConcreteOuter.equals(listReferenceVaporOuter));
    assertFalse(listReferenceVaporOuter.equals(listReferenceConcreteOuter));

    assertFalse(listReferenceConcreteOuter.isAssignableFrom(listReferenceVaporOuter));
    assertFalse(listReferenceVaporOuter.isAssignableFrom(listReferenceConcreteOuter));
  }
}
