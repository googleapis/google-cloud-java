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

import com.google.cloud.vertexai.api.FunctionDeclaration;
import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Type;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class FunctionDeclarationMakerTest {

  @Test
  public void fromValidJsonStringTested_returnsFunctionDeclaration()
      throws InvalidProtocolBufferException {
    String jsonString =
        "{\n"
            + " \"name\": \"functionName\",\n"
            + " \"description\": \"functionDescription\",\n"
            + " \"parameters\": {\n"
            + "   \"type\": \"OBJECT\", \n"
            + "   \"properties\": {\n"
            + "     \"param1\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"param1Description\"\n"
            + "     }\n"
            + "   }\n"
            + " }\n"
            + "}";

    FunctionDeclaration functionDeclaration = FunctionDeclarationMaker.fromJsonString(jsonString);

    FunctionDeclaration expectedFunctionDeclaration =
        FunctionDeclaration.newBuilder()
            .setName("functionName")
            .setDescription("functionDescription")
            .setParameters(
                Schema.newBuilder()
                    .setType(Type.OBJECT)
                    .putProperties(
                        "param1",
                        Schema.newBuilder()
                            .setType(Type.STRING)
                            .setDescription("param1Description")
                            .build()))
            .build();
    assertThat(functionDeclaration).isEqualTo(expectedFunctionDeclaration);
  }

  @Test
  public void fromJsonStringWithInvalidType_throwsInvalidProtocolBufferException()
      throws InvalidProtocolBufferException {
    // Here we use "parameter" (singular) instead of "parameters"
    String jsonString =
        "{\n"
            + " \"name\": \"functionName\",\n"
            + " \"parameter\": {\n"
            + "   \"type\": \"OBJECT\", \n"
            + "   \"properties\": {\n"
            + "     \"param1\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"param1Description\"\n"
            + "     }\n"
            + "   }\n"
            + " }\n"
            + "}";
    assertThrows(
        InvalidProtocolBufferException.class,
        () -> FunctionDeclarationMaker.fromJsonString(jsonString));
  }

  @Test
  public void fromJsonStringNameMissing_throwsIllegalArgumentException()
      throws InvalidProtocolBufferException {
    String jsonString =
        "{\n"
            + " \"description\": \"functionDescription\",\n"
            + " \"parameters\": {\n"
            + "   \"type\": \"OBJECT\", \n"
            + "   \"properties\": {\n"
            + "     \"param1\": {\n"
            + "       \"type\": \"STRING\",\n"
            + "       \"description\": \"param1Description\"\n"
            + "     }\n"
            + "   }\n"
            + " }\n"
            + "}";

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> FunctionDeclarationMaker.fromJsonString(jsonString));
    assertThat(thrown).hasMessageThat().isEqualTo("name field must be present.");
  }

  @Test
  public void fromEmptyString_throwsIllegalArgumentException()
      throws InvalidProtocolBufferException {
    String jsonString = "";

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> FunctionDeclarationMaker.fromJsonString(jsonString));
    assertThat(thrown).hasMessageThat().isEqualTo("Input String can't be null or empty.");
  }

  @Test
  public void fromJsonStringStringIsNull_throwsIllegalArgumentException()
      throws InvalidProtocolBufferException {
    String jsonString = null;

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> FunctionDeclarationMaker.fromJsonString(jsonString));
    assertThat(thrown).hasMessageThat().isEqualTo("Input String can't be null or empty.");
  }

  @Test
  public void fromValidJsonObject_returnsFunctionDeclaration()
      throws InvalidProtocolBufferException {
    JsonObject param1JsonObject = new JsonObject();
    param1JsonObject.addProperty("type", "STRING");
    param1JsonObject.addProperty("description", "param1Description");

    JsonObject propertiesJsonObject = new JsonObject();
    propertiesJsonObject.add("param1", param1JsonObject);

    JsonObject parametersJsonObject = new JsonObject();
    parametersJsonObject.addProperty("type", "OBJECT");
    parametersJsonObject.add("properties", propertiesJsonObject);

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", "functionName");
    jsonObject.addProperty("description", "functionDescription");
    jsonObject.add("parameters", parametersJsonObject);

    FunctionDeclaration functionDeclaration = FunctionDeclarationMaker.fromJsonObject(jsonObject);

    FunctionDeclaration expectedFunctionDeclaration =
        FunctionDeclaration.newBuilder()
            .setName("functionName")
            .setDescription("functionDescription")
            .setParameters(
                Schema.newBuilder()
                    .setType(Type.OBJECT)
                    .putProperties(
                        "param1",
                        Schema.newBuilder()
                            .setType(Type.STRING)
                            .setDescription("param1Description")
                            .build()))
            .build();
    assertThat(functionDeclaration).isEqualTo(expectedFunctionDeclaration);
  }
}
