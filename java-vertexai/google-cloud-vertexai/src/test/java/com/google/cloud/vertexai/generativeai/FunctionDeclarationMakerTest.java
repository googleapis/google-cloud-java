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
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class FunctionDeclarationMakerTest {
  private static final String FUNCTION_NAME = "functionName";
  private static final String FUNCTION_DESCRIPTION = "functionDescription";
  private static final String STRING_PARAM_NAME = "stringParam";
  private static final String INTEGER_PARAM_NAME = "integerParam";
  private static final String DOUBLE_PARAM_NAME = "doubleParam";
  private static final String FLOAT_PARAM_NAME = "floatParam";
  private static final String BOOLEAN_PARAM_NAME = "booleanParam";
  private static final ImmutableList<String> REQUIRED_PARAM_NAMES =
      ImmutableList.of(
          STRING_PARAM_NAME,
          INTEGER_PARAM_NAME,
          DOUBLE_PARAM_NAME,
          FLOAT_PARAM_NAME,
          BOOLEAN_PARAM_NAME);

  private static final FunctionDeclaration EXPECTED_FUNCTION_DECLARATION =
      FunctionDeclaration.newBuilder()
          .setName(FUNCTION_NAME)
          .setDescription(FUNCTION_DESCRIPTION)
          .setParameters(
              Schema.newBuilder()
                  .setType(Type.OBJECT)
                  .putProperties(
                      STRING_PARAM_NAME,
                      Schema.newBuilder()
                          .setType(Type.STRING)
                          .setDescription(STRING_PARAM_NAME)
                          .build())
                  .putProperties(
                      INTEGER_PARAM_NAME,
                      Schema.newBuilder()
                          .setType(Type.INTEGER)
                          .setDescription(INTEGER_PARAM_NAME)
                          .build())
                  .putProperties(
                      DOUBLE_PARAM_NAME,
                      Schema.newBuilder()
                          .setType(Type.NUMBER)
                          .setDescription(DOUBLE_PARAM_NAME)
                          .build())
                  .putProperties(
                      FLOAT_PARAM_NAME,
                      Schema.newBuilder()
                          .setType(Type.NUMBER)
                          .setDescription(FLOAT_PARAM_NAME)
                          .build())
                  .putProperties(
                      BOOLEAN_PARAM_NAME,
                      Schema.newBuilder()
                          .setType(Type.BOOLEAN)
                          .setDescription(BOOLEAN_PARAM_NAME)
                          .build())
                  .addAllRequired(REQUIRED_PARAM_NAMES))
          .build();

  /** A function (static method) to test fromFunc functionalities. */
  public static int functionName(
      String stringParam,
      int integerParam,
      double doubleParam,
      float floatParam,
      boolean booleanParam) {
    return 0;
  }

  /** An instance method to test fromFunc. */
  public int instanceMethod(String stringParam) {
    return 1;
  }

  /** A function with invalid parameter type to test fromFunc. */
  public static int functionWithInvalidType(Object objectParam) {
    return 2;
  }

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
            + "   },\n"
            + "   \"required\": [\"stringParam\", \"integerParam\", \"doubleParam\","
            + " \"floatParam\", \"booleanParam\"]\n"
            + " }\n"
            + "}";

    FunctionDeclaration functionDeclaration = FunctionDeclarationMaker.fromJsonString(jsonString);

    assertThat(functionDeclaration).isEqualTo(EXPECTED_FUNCTION_DECLARATION);
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

    JsonObject parametersJsonObject = new JsonObject();
    parametersJsonObject.addProperty("type", "OBJECT");
    parametersJsonObject.add("properties", propertiesJsonObject);
    parametersJsonObject.add(
        "required", new Gson().toJsonTree(REQUIRED_PARAM_NAMES).getAsJsonArray());

    JsonObject jsonObject = new JsonObject();
    jsonObject.addProperty("name", FUNCTION_NAME);
    jsonObject.addProperty("description", FUNCTION_DESCRIPTION);
    jsonObject.add("parameters", parametersJsonObject);

    FunctionDeclaration functionDeclaration = FunctionDeclarationMaker.fromJsonObject(jsonObject);

    assertThat(functionDeclaration).isEqualTo(EXPECTED_FUNCTION_DECLARATION);
  }

  @Test
  public void fromFuncWithoutParameterNamesWithoutReflection_throwsIllegalStateException()
      throws NoSuchMethodException {
    Method function =
        FunctionDeclarationMakerTest.class.getMethod(
            FUNCTION_NAME, String.class, int.class, double.class, float.class, boolean.class);

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> FunctionDeclarationMaker.fromFunc(FUNCTION_DESCRIPTION, function));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "Failed to retrieve the parameter name from reflection. Please compile your"
                + " code with  \"-parameters\" flag or use `fromFunc(String, Method,"
                + " String...)` to manually enter parameter names");
  }

  @Test
  public void fromFuncWithParameterNames_returnsFunctionDeclaration() throws NoSuchMethodException {
    Method function =
        FunctionDeclarationMakerTest.class.getMethod(
            FUNCTION_NAME, String.class, int.class, double.class, float.class, boolean.class);

    FunctionDeclaration functionDeclaration =
        FunctionDeclarationMaker.fromFunc(
            FUNCTION_DESCRIPTION,
            function,
            STRING_PARAM_NAME,
            INTEGER_PARAM_NAME,
            DOUBLE_PARAM_NAME,
            FLOAT_PARAM_NAME,
            BOOLEAN_PARAM_NAME);

    assertThat(functionDeclaration).isEqualTo(EXPECTED_FUNCTION_DECLARATION);
  }

  @Test
  public void fromFuncWithInstanceMethod_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    Method function = FunctionDeclarationMakerTest.class.getMethod("instanceMethod", String.class);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                FunctionDeclarationMaker.fromFunc(
                    FUNCTION_DESCRIPTION, function, STRING_PARAM_NAME));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("Instance methods are not supported. Please use static methods.");
  }

  @Test
  public void fromFuncWithInvalidParameterType_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    Method function =
        FunctionDeclarationMakerTest.class.getMethod("functionWithInvalidType", Object.class);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> FunctionDeclarationMaker.fromFunc(FUNCTION_DESCRIPTION, function, "objectParam"));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "Unsupported parameter type " + Object.class.getName() + " for parameter objectParam");
  }

  @Test
  public void fromFuncWithUnmatchedParameterNames_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    Method function =
        FunctionDeclarationMakerTest.class.getMethod(
            FUNCTION_NAME, String.class, int.class, double.class, float.class, boolean.class);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                FunctionDeclarationMaker.fromFunc(
                    FUNCTION_DESCRIPTION, function, STRING_PARAM_NAME));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "The number of parameter names does not match the number of parameters in the method.");
  }
}
