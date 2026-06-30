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

import org.junit.jupiter.api.Test;

class VaporReferenceTest {
  @Test
  void basic() {
    String pkg = "com.google.example.examples.library.v1";
    String name = "Babbage";
    Reference ref = VaporReference.builder().setName(name).setPakkage(pkg).build();
    assertEquals(name, ref.name());
    assertEquals(String.format("%s.%s", pkg, name), ref.fullName());
    assertFalse(ref.hasEnclosingClass());
    assertTrue(ref.isFromPackage(pkg));
    assertFalse(ref.isFromPackage("com.google.example.library"));
  }

  @Test
  void basic_isStaticImport() {
    String pkg = "com.google.example.examples.library.v1";
    String name = "Babbage";
    Reference ref =
        VaporReference.builder().setName(name).setPakkage(pkg).setIsStaticImport(true).build();
    assertEquals(name, ref.name());
    assertEquals(String.format("%s.%s", pkg, name), ref.fullName());
    assertFalse(ref.hasEnclosingClass());
    assertTrue(ref.isFromPackage(pkg));
    // isStaticImport is automatically false for non-nested classes.
    assertFalse(ref.isFromPackage("com.google.example.library"));
    assertFalse(ref.isStaticImport());
  }

  @Test
  void basic_nested() {
    String pkg = "com.google.example.examples.library.v1";
    String name = "Charles";
    Reference ref =
        VaporReference.builder()
            .setEnclosingClassNames("Babbage", "Ada")
            .setName(name)
            .setPakkage(pkg)
            .build();

    assertEquals("Babbage.Ada.Charles", ref.name());
    assertTrue(ref.hasEnclosingClass());
    assertEquals(String.format("%s.%s.%s.%s", pkg, "Babbage", "Ada", name), ref.fullName());
    assertTrue(ref.hasEnclosingClass());
    assertTrue(ref.isFromPackage(pkg));
    assertFalse(ref.isFromPackage("com.google.example.library"));
    assertFalse(ref.isStaticImport());
  }

  @Test
  void basic_nestedAndStaticImport() {
    String pkg = "com.google.example.examples.library.v1";
    String name = "Charles";
    String enclosingClassName = "Babbage";
    Reference ref =
        VaporReference.builder()
            .setEnclosingClassNames(enclosingClassName)
            .setName(name)
            .setPakkage(pkg)
            .setIsStaticImport(true)
            .build();
    assertEquals(name, ref.name());
    assertEquals(String.format("%s.%s.%s", pkg, enclosingClassName, name), ref.fullName());
    assertTrue(ref.hasEnclosingClass());
    assertTrue(ref.isFromPackage(pkg));
    assertFalse(ref.isFromPackage("com.google.example.library"));
    assertTrue(ref.isStaticImport());
  }

  @Test
  void concreteHierarchiesNotHandled() {
    String pkg = "java.io";
    String name = "IOException";
    Reference ref = VaporReference.builder().setName(name).setPakkage(pkg).build();

    Reference exceptionRef = ConcreteReference.withClazz(Exception.class);
    assertFalse(ref.isAssignableFrom(exceptionRef));
    assertFalse(exceptionRef.isAssignableFrom(ref));
    assertFalse(exceptionRef.isSupertypeOrEquals(ref));
  }

  @Test
  void enclosingClass() {
    String pkg = "java.util";
    String enclosingName = "Map";
    String name = "Entry";

    Reference ref =
        VaporReference.builder()
            .setName(name)
            .setPakkage(pkg)
            .setEnclosingClassNames(enclosingName)
            .build();
    assertTrue(ref.hasEnclosingClass());
    assertEquals(String.format("%s.%s.%s", pkg, enclosingName, name), ref.fullName());
  }
}
