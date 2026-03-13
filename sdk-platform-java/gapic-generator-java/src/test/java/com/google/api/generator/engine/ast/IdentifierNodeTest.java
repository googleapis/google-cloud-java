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

import com.google.api.generator.engine.ast.IdentifierNode.InvalidIdentifierException;
import org.junit.jupiter.api.Test;

class IdentifierNodeTest {
  @Test
  void createIdentifier_basic() {
    assertValidIdentifier("foobar");
    assertValidIdentifier("x");
    assertValidIdentifier("afalse");
    assertValidIdentifier("a123");
    assertValidIdentifier("False");
    assertValidIdentifier("Object");
    assertValidIdentifier("a_b_c");
    assertValidIdentifier("a_b_____");
  }

  @Test
  void createIdentifier_nameHasLiteral() {
    assertValidIdentifier("a123L");
    assertValidIdentifier("a10e3");
    assertValidIdentifier("anull");

    assertInvalidIdentifier("123L");
    assertInvalidIdentifier("1.f");
    assertInvalidIdentifier("12345");
    assertInvalidIdentifier("null");
    assertInvalidIdentifier("1e-2");
    assertInvalidIdentifier("1e2");
    assertInvalidIdentifier("false");
    assertInvalidIdentifier("1.00");
    assertInvalidIdentifier(".01");
  }

  @Test
  void createIdentifier_namdHasInvalidSymbols() {
    assertInvalidIdentifier("a.b");
    assertInvalidIdentifier("a,b");
    assertInvalidIdentifier("a-b");
    assertInvalidIdentifier("a+b");
    assertInvalidIdentifier("-ab");
    assertInvalidIdentifier("-ab");
    assertInvalidIdentifier("[ab]");
    assertInvalidIdentifier("ab)");
    assertInvalidIdentifier("ab=");
    assertInvalidIdentifier("ab%");
    assertInvalidIdentifier("a/b");
    assertInvalidIdentifier("}ab");
    assertInvalidIdentifier("ab|");
    assertInvalidIdentifier("a&b");
    assertInvalidIdentifier("a^b");
    assertInvalidIdentifier("a$b");
    assertInvalidIdentifier("a$b@");
    assertInvalidIdentifier("!abfoo");
    assertInvalidIdentifier("ab'foo");
    assertInvalidIdentifier("ab\"foo");
    assertInvalidIdentifier("abfoo;");
    assertInvalidIdentifier(">abfoo;");
    assertInvalidIdentifier("abfo<o");
    assertInvalidIdentifier("abf?oo");
    assertInvalidIdentifier("abfoo:");
    assertInvalidIdentifier("abfoo\\");
  }

  @Test
  void createIdentifier_nameHasKeyword() {
    assertValidIdentifier("aclass");

    // Random sampling of keywords.
    assertInvalidIdentifier("class");
    assertInvalidIdentifier("interface");
    assertInvalidIdentifier("abstract");
    assertInvalidIdentifier("float");
    assertInvalidIdentifier("boolean");
    assertInvalidIdentifier("int");
    assertInvalidIdentifier("switch");
    assertInvalidIdentifier("if");
    assertInvalidIdentifier("throws");
    assertInvalidIdentifier("catch");
    assertInvalidIdentifier("void");
    assertInvalidIdentifier("private");
    assertInvalidIdentifier("import");
    assertInvalidIdentifier("return");
    assertInvalidIdentifier("final");
    assertInvalidIdentifier("extends");
    assertInvalidIdentifier("implements");
  }

  private static void assertInvalidIdentifier(String idName) {
    assertThrows(
        InvalidIdentifierException.class,
        () -> {
          IdentifierNode.builder().setName(idName).build();
        });
  }

  private static void assertValidIdentifier(String idName) {
    assertEquals(idName, IdentifierNode.builder().setName(idName).build().name());
  }
}
