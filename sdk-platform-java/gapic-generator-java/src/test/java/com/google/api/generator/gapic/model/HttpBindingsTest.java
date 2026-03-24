// Copyright 2022 Google LLC
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

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.gapic.model.HttpBindings.HttpBinding;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HttpBindingsTest {

  private Field.Builder fieldBuilder;
  private HttpBinding.Builder httpBindingBuilder;

  @BeforeEach
  void setUp() throws Exception {
    fieldBuilder = Field.builder().setName("doesNotMatter").setType(TypeNode.OBJECT);
    httpBindingBuilder = HttpBinding.builder().setName("doesNotMatter");
  }

  @Test
  void isOptional_shouldReturnFalseIfFieldIsNull() {
    HttpBinding httpBinding = httpBindingBuilder.build();
    Truth.assertThat(httpBinding.isOptional()).isFalse();
  }

  @Test
  void isOptional_shouldReturnFalseIfFieldExistsAndIsOptionalIsFalse() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsProto3Optional(false).build()).build();

    Truth.assertThat(httpBinding.isOptional()).isFalse();
  }

  @Test
  void isOptional_shouldReturnTrueIfFieldExistsAndIsOptionalIsTue() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsProto3Optional(true).build()).build();

    Truth.assertThat(httpBinding.isOptional()).isTrue();
  }

  @Test
  void isRepeated_shouldReturnFalseIfFieldIsNull() {
    HttpBinding httpBinding = httpBindingBuilder.build();
    Truth.assertThat(httpBinding.isRepeated()).isFalse();
  }

  @Test
  void isRepeated_shouldReturnFalseIfFieldExistsAndIsRepeatedIsFalse() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsRepeated(false).build()).build();

    Truth.assertThat(httpBinding.isRepeated()).isFalse();
  }

  @Test
  void isRepeated_shouldReturnTrueIfFieldExistsAndIsRepeatedIsTue() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsRepeated(true).build()).build();

    Truth.assertThat(httpBinding.isRepeated()).isTrue();
  }

  @Test
  void isEnum_shouldReturnFalseIfFieldIsNull() {
    HttpBinding httpBinding = httpBindingBuilder.build();
    Truth.assertThat(httpBinding.isEnum()).isFalse();
  }

  @Test
  void isEnum_shouldReturnFalseIfFieldExistsAndIsEnumIsFalse() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsEnum(false).build()).build();

    Truth.assertThat(httpBinding.isEnum()).isFalse();
  }

  @Test
  void isEnum_shouldReturnTrueIfFieldExistsAndIsEnumIsTue() {
    HttpBinding httpBinding =
        httpBindingBuilder.setField(fieldBuilder.setIsEnum(true).build()).build();

    Truth.assertThat(httpBinding.isEnum()).isTrue();
  }
}
