/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.vertexai.generativeai;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Type;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class SchemaMakerTest {
  private static final String STRING_PARAM_NAME = "stringParam";
  private static final String INTEGER_PARAM_NAME = "integerParam";
  private static final String DOUBLE_PARAM_NAME = "doubleParam";
  private static final String FLOAT_PARAM_NAME = "floatParam";
  private static final String BOOLEAN_PARAM_NAME = "booleanParam";

  private static final Schema EXPECTED_SCHEMA =
      Schema.newBuilder()
          .setType(Type.OBJECT)
          .putProperties(
              STRING_PARAM_NAME,
              Schema.newBuilder().setType(Type.STRING).setDescription(STRING_PARAM_NAME).build())
          .putProperties(
              INTEGER_PARAM_NAME,
              Schema.newBuilder().setType(Type.INTEGER).setDescription(INTEGER_PARAM_NAME).build())
          .putProperties(
              DOUBLE_PARAM_NAME,
              Schema.newBuilder().setType(Type.NUMBER).setDescription(DOUBLE_PARAM_NAME).build())
          .putProperties(
              FLOAT_PARAM_NAME,
              Schema.newBuilder().setType(Type.NUMBER).setDescription(FLOAT_PARAM_NAME).build())
          .putProperties(
              BOOLEAN_PARAM_NAME,
              Schema.newBuilder().setType(Type.BOOLEAN).setDescription(BOOLEAN_PARAM_NAME).build())
          .build();

  @Test
  public void fromJsonString_withValidJsonString_returnsSchema()
      throws InvalidProtocolBufferException {
    String jsonString =
        "{\n"
            + " \"type\": \"OBJECT\",\n"
            + "   \"properties\": {\n"
            + "     \"stringParam\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"stringParam\"\n"
            + "     },\n"
            + "     \"integerParam\": {\n"
            + "       \"type\": \"INTEGER\",\n"
            + "       \"description\": \"integerParam\"\n"
            + "     },\n"
            + "     \"doubleParam\": {\n"
            + "       \"type\": \"NUMBER\",\n"
            + "       \"description\": \"doubleParam\"\n"
            + "     },\n"
            + "     \"floatParam\": {\n"
            + "       \"type\": \"NUMBER\",\n"
            + "       \"description\": \"floatParam\"\n"
            + "     },\n"
            + "     \"booleanParam\": {\n"
            + "       \"type\": \"BOOLEAN\",\n"
            + "       \"description\": \"booleanParam\"\n"
            + "     }\n"
            + "   }\n"
            + "}";

    Schema schema = SchemaMaker.fromJsonString(jsonString);

    assertThat(schema).isEqualTo(EXPECTED_SCHEMA);
  }

  @Test
  public void fromJsonString_withInvalidJsonString_throwsInvalidProtocolBufferException()
      throws InvalidProtocolBufferException {
    // Here we use "property" (singular) instead of "properties"
    String jsonString =
        "{\n"
            + " \"type\": \"OBJECT\",\n"
            + "   \"property\": {\n"
            + "     \"stringParam\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"stringParam\"\n"
            + "     }\n"
            + "   }\n"
            + "}";
    assertThrows(
        InvalidProtocolBufferException.class, () -> SchemaMaker.fromJsonString(jsonString));
  }

  @Test
  public void fromJsonString_withEmptyString_throwsIllegalArgumentException()
      throws InvalidProtocolBufferException {
    String jsonString = "";
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> SchemaMaker.fromJsonString(jsonString));
    assertThat(thrown).hasMessageThat().isEqualTo("Input String can't be null or empty.");
  }

  @Test
  public void fromJsonObject_withValidJsonObject_returnsSchema()
      throws InvalidProtocolBufferException {
    JsonObject stringParamJsonObject = new JsonObject();
    stringParamJsonObject.addProperty("type", "STRING");
    stringParamJsonObject.addProperty("description", STRING_PARAM_NAME);

    JsonObject integerParamJsonObject = new JsonObject();
    integerParamJsonObject.addProperty("type", "INTEGER");
    integerParamJsonObject.addProperty("description", INTEGER_PARAM_NAME);

    JsonObject doubleParamJsonObject = new JsonObject();
    doubleParamJsonObject.addProperty("type", "NUMBER");
    doubleParamJsonObject.addProperty("description", DOUBLE_PARAM_NAME);

    JsonObject floatParamJsonObject = new JsonObject();
    floatParamJsonObject.addProperty("type", "NUMBER");
    floatParamJsonObject.addProperty("description", FLOAT_PARAM_NAME);

    JsonObject booleanParamJsonObject = new JsonObject();
    booleanParamJsonObject.addProperty("type", "BOOLEAN");
    booleanParamJsonObject.addProperty("description", BOOLEAN_PARAM_NAME);

    JsonObject propertiesJsonObject = new JsonObject();
    propertiesJsonObject.add(STRING_PARAM_NAME, stringParamJsonObject);
    propertiesJsonObject.add(INTEGER_PARAM_NAME, integerParamJsonObject);
    propertiesJsonObject.add(DOUBLE_PARAM_NAME, doubleParamJsonObject);
    propertiesJsonObject.add(FLOAT_PARAM_NAME, floatParamJsonObject);
    propertiesJsonObject.add(BOOLEAN_PARAM_NAME, booleanParamJsonObject);

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("type", "OBJECT");
    jsonObject.add("properties", propertiesJsonObject);

    Schema schema = SchemaMaker.fromJsonObject(jsonObject);

    assertThat(schema).isEqualTo(EXPECTED_SCHEMA);
  }

  @Test
  public void fromJsonObject_withInvalidJsonObject_throwsInvalidProtocolBufferException()
      throws InvalidProtocolBufferException {
    // Here we use "property" (singular) instead of "properties"
    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("type", "OBJECT");
    jsonObject.add("property", new JsonObject());

    assertThrows(
        InvalidProtocolBufferException.class, () -> SchemaMaker.fromJsonObject(jsonObject));
  }

  @Test
  public void fromJsonObject_withNullJsonObject_throwsNullPointerException()
      throws InvalidProtocolBufferException {
    JsonObject jsonObject = null;
    assertThrows(NullPointerException.class, () -> SchemaMaker.fromJsonObject(jsonObject));
  }
}
