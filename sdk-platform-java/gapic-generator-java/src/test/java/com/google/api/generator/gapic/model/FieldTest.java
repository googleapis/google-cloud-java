// Copyright 2024 Google LLC
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

package com.google.api.generator.gapic.model;

import static org.junit.Assert.assertEquals;

import com.google.api.FieldInfo.Format;
import com.google.api.generator.engine.ast.TypeNode;
import org.junit.jupiter.api.Test;

class FieldTest {

  @Test
  void shouldAutoPopulate() {
    Field FIELD =
        Field.builder()
            .setName("SampleField")
            .setIsRequired(false)
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();

    assertEquals(true, FIELD.canBeAutoPopulated());
  }

  @Test
  void isRequired_shouldNotAutoPopulate() {
    Field FIELD =
        Field.builder()
            .setName("SampleField")
            .setIsRequired(true)
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.STRING)
            .build();

    assertEquals(false, FIELD.canBeAutoPopulated());
  }

  @Test
  void fieldInfoFormatNotUUID4_shouldNotAutoPopulate() {
    Field FIELD =
        Field.builder()
            .setName("SampleField")
            .setIsRequired(true)
            .setFieldInfoFormat(Format.IPV6)
            .setType(TypeNode.STRING)
            .build();

    assertEquals(false, FIELD.canBeAutoPopulated());
  }

  @Test
  void typeNotString_shouldNotAutoPopulate() {
    Field FIELD =
        Field.builder()
            .setName("SampleField")
            .setIsRequired(true)
            .setFieldInfoFormat(Format.UUID4)
            .setType(TypeNode.BOOLEAN)
            .build();

    assertEquals(false, FIELD.canBeAutoPopulated());
  }
}
