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

package com.google.api.generator.engine.lexicon;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class KeywordTest {
  @Test
  void keywordDetected() {
    // Modifiers.
    assertThat(Keyword.isKeyword("static")).isTrue();
    assertThat(Keyword.isKeyword("private")).isTrue();

    // Other semantic blocks..
    assertThat(Keyword.isKeyword("throws")).isTrue();
    assertThat(Keyword.isKeyword("try")).isTrue();
    assertThat(Keyword.isKeyword("for")).isTrue();

    // Primitive types.
    assertThat(Keyword.isKeyword("int")).isTrue();
    assertThat(Keyword.isKeyword("char")).isTrue();

    // Literal values.
    assertThat(Keyword.isKeyword("false")).isFalse();
    assertThat(Keyword.isKeyword("null")).isFalse();
    assertThat(Keyword.isKeyword("asdf")).isFalse();
    assertThat(Keyword.isKeyword("12345")).isFalse();

    // Keywords.
    assertThat(Keyword.isKeyword("while")).isTrue();
    assertThat(Keyword.isKeyword("class")).isTrue();
    assertThat(Keyword.isInvalidFieldName("class")).isFalse();
  }

  @Test
  void unescapedKeyword_shouldReturnItselfIfEmpty() {
    assertThat(Keyword.unescapeKeyword("")).isEqualTo("");
  }

  @Test
  void unescapedKeyword_shouldReturnItselfIfDoesNotEndWithEscapeChar() {
    assertThat(Keyword.unescapeKeyword("hello")).isEqualTo("hello");
  }

  @Test
  void unescapedKeyword_shouldReturnItselfIfEndsWithEscapeCharButNotAKeyword() {
    assertThat(Keyword.unescapeKeyword("important_")).isEqualTo("important_");
  }

  @Test
  void unescapedKeyword_shouldUnescapeIfEndsWithEscapeCharAndAKeyword() {
    assertThat(Keyword.unescapeKeyword("import_")).isEqualTo("import");
  }

  @Test
  void escapeKeyword_shouldEscapeIfIsAKeyword() {
    assertThat(Keyword.escapeKeyword("final")).isEqualTo("final_");
  }

  @Test
  void escapeKeyword_shouldNotEscapeIfIsNotAKeyword() {
    assertThat(Keyword.escapeKeyword("fantasy")).isEqualTo("fantasy");
  }
}
