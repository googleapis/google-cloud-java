// Copyright 2021 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.generator.engine.ast.TypeNode;
import com.google.api.generator.engine.ast.VaporReference;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class MessageTest {

  private static final String SUB_FIELD_NAME = "table";
  private static final String LEAF_FIELD_NAME = "size";
  private static final String SUB_FIELD_TYPE = "TableFieldType";
  private static final VaporReference FIELD_TYPE =
      VaporReference.builder().setPakkage("com.google").setName(SUB_FIELD_TYPE).build();
  private static final String MESSAGE_NAME = "TestMessage";
  private static final Message.Builder testMessageBuilder =
      Message.builder()
          .setName(MESSAGE_NAME)
          .setFullProtoName("com.google.test.TestMessage")
          .setType(TypeNode.OBJECT);

  @Test
  void validateField_shouldThrowExceptionIfFieldNameIsEmpty() {
    Message message = testMessageBuilder.build();
    IllegalStateException illegalStateException =
        assertThrows(
            IllegalStateException.class,
            () -> message.validateField("", ImmutableMap.of(), TypeNode.STRING));
    assertThat(illegalStateException)
        .hasMessageThat()
        .isEqualTo(String.format("Null or empty field name found for message %s", MESSAGE_NAME));
  }

  @Test
  void validateField_shouldThrowExceptionIfFieldDoesNotExist() {
    Message message = testMessageBuilder.build();
    String fieldName = "doesNotExist";
    NullPointerException nullPointerException =
        assertThrows(
            NullPointerException.class,
            () -> message.validateField(fieldName, ImmutableMap.of(), TypeNode.STRING));
    assertThat(nullPointerException)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "Expected message %s to contain field %s but none found", MESSAGE_NAME, fieldName));
  }

  @Test
  void validateField_shouldThrowExceptionIfMessageDoesNotExist() {
    Field subField =
        Field.builder()
            .setName(SUB_FIELD_NAME)
            .setType(
                TypeNode.withReference(
                    VaporReference.builder()
                        .setPakkage("com.google")
                        .setName(SUB_FIELD_TYPE)
                        .build()))
            .build();
    Message message =
        testMessageBuilder.setFieldMap(ImmutableMap.of(SUB_FIELD_NAME, subField)).build();
    String fieldName = SUB_FIELD_NAME + "." + LEAF_FIELD_NAME;
    NullPointerException nullPointerException =
        assertThrows(
            NullPointerException.class,
            () -> message.validateField(fieldName, ImmutableMap.of(), TypeNode.STRING));
    assertThat(nullPointerException)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "No containing message found for field %s with type %s",
                SUB_FIELD_NAME, SUB_FIELD_TYPE));
  }

  @Test
  void validateField_shouldThrowExceptionIfFieldIsRepeated() {
    Field leafField =
        Field.builder()
            .setType(TypeNode.STRING)
            .setIsRepeated(true)
            .setName(LEAF_FIELD_NAME)
            .build();
    testLeafField(leafField);
  }

  @Test
  void validateField_shouldThrowExceptionIfFieldIsOfWrongType() {
    Field leafField = Field.builder().setType(TypeNode.BOOLEAN).setName(LEAF_FIELD_NAME).build();
    testLeafField(leafField);
  }

  private void testLeafField(Field leafField) {
    Message subMessage = createSubMessage(leafField);
    Map<String, Message> messageTypes = ImmutableMap.of(FIELD_TYPE.fullName(), subMessage);
    IllegalStateException illegalStateException =
        assertThrows(
            IllegalStateException.class,
            () ->
                createdMessage()
                    .validateField(
                        SUB_FIELD_NAME + "." + LEAF_FIELD_NAME, messageTypes, TypeNode.STRING));
    assertThat(illegalStateException)
        .hasMessageThat()
        .isEqualTo(
            String.format(
                "The type of field %s must be String and not repeated.", LEAF_FIELD_NAME));
  }

  @Test
  void validateField_shouldNotThrowExceptionIfFieldExist() {
    Field leafField = Field.builder().setType(TypeNode.STRING).setName(LEAF_FIELD_NAME).build();
    Message subMessage = createSubMessage(leafField);
    Map<String, Message> messageTypes = ImmutableMap.of(FIELD_TYPE.fullName(), subMessage);
    createdMessage()
        .validateField(SUB_FIELD_NAME + "." + LEAF_FIELD_NAME, messageTypes, TypeNode.STRING);
  }

  private Message createdMessage() {
    Field subField =
        Field.builder().setName(SUB_FIELD_NAME).setType(TypeNode.withReference(FIELD_TYPE)).build();
    return testMessageBuilder.setFieldMap(ImmutableMap.of(SUB_FIELD_NAME, subField)).build();
  }

  private Message createSubMessage(Field leafField) {
    return Message.builder()
        .setName(SUB_FIELD_TYPE)
        .setFullProtoName("com.google." + SUB_FIELD_TYPE)
        .setType(TypeNode.OBJECT)
        .setFieldMap(ImmutableMap.of(LEAF_FIELD_NAME, leafField))
        .build();
  }
}
