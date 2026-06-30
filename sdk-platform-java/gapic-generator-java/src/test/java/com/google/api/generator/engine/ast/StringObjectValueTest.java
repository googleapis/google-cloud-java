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

import org.junit.jupiter.api.Test;

class StringObjectValueTest {

  @Test
  void createStringObjectValue_basic() {
    StringObjectValue s = StringObjectValue.builder().setValue("test").build();
    assertThat(s.value()).isEqualTo("\"test\"");
    assertThat(s.type()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void createStringObjectValue_escapeCharacter() {
    StringObjectValue valueSpecialChar = StringObjectValue.withValue("\" \t \\ \b \r \f \n '");
    String expected = "\"\\\" \\t \\\\ \\b \\r \\f \\n '\"";
    assertThat(valueSpecialChar.value()).isEqualTo(expected);
    assertThat(valueSpecialChar.type()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void createStringObjectValue_specialCharacter() {
    StringObjectValue valueSpecialChar = StringObjectValue.withValue("Tom said: \"Hi!\"; \n");
    String expected = "\"Tom said: \\\"Hi!\\\"; \\n\"";
    assertThat(valueSpecialChar.value()).isEqualTo(expected);
    assertThat(valueSpecialChar.type()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void createStringObjectValue_specialCharacterComment() {
    StringObjectValue valueSpecialChar =
        StringObjectValue.withValue("Service comment may include special characters: <>&\"`'@");
    String expected = "\"Service comment may include special characters: <>&\\\"`'@\"";
    assertThat(valueSpecialChar.value()).isEqualTo(expected);
    assertThat(valueSpecialChar.type()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void createStringObjectValue_usPunctuation() {
    StringObjectValue valueSpecialChar =
        StringObjectValue.withValue("US Punctuation, one of !\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
    String expected = "\"US Punctuation, one of !\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~\"";
    assertThat(valueSpecialChar.value()).isEqualTo(expected);
    assertThat(valueSpecialChar.type()).isEqualTo(TypeNode.STRING);
  }

  @Test
  void createStringObjectValue_htmlCharacterComment() {
    StringObjectValue valueSpecialChar =
        StringObjectValue.withValue("&nbsp; &#40 &#91 &ndash; &gt;:&lt;");
    String expected = "\"&nbsp; &#40 &#91 &ndash; &gt;:&lt;\"";
    assertThat(valueSpecialChar.value()).isEqualTo(expected);
    assertThat(valueSpecialChar.type()).isEqualTo(TypeNode.STRING);
  }
}
