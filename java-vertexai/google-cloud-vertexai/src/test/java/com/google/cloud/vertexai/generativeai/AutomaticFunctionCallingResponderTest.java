/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
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

import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.FunctionCall;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class AutomaticFunctionCallingResponderTest {
  private static final int MAX_FUNCTION_CALLS = 5;
  private static final int DEFAULT_MAX_FUNCTION_CALLS = 1;
  private static final String FUNCTION_NAME_1 = "getCurrentWeather";
  private static final String FUNCTION_NAME_2 = "getCurrentTemperature";
  private static final String STRING_PARAMETER_NAME = "location";
  private static final FunctionCall FUNCTION_CALL_1 =
      FunctionCall.newBuilder()
          .setName(FUNCTION_NAME_1)
          .setArgs(
              Struct.newBuilder()
                  .putFields(
                      STRING_PARAMETER_NAME, Value.newBuilder().setStringValue("Boston").build()))
          .build();
  private static final FunctionCall FUNCTION_CALL_2 =
      FunctionCall.newBuilder()
          .setName(FUNCTION_NAME_2)
          .setArgs(
              Struct.newBuilder()
                  .putFields(
                      STRING_PARAMETER_NAME,
                      Value.newBuilder().setStringValue("Vancouver").build()))
          .build();
  private static final FunctionCall FUNCTION_CALL_WITH_FALSE_FUNCTION_NAME =
      FunctionCall.newBuilder()
          .setName("nonExistFunction")
          .setArgs(
              Struct.newBuilder()
                  .putFields(
                      STRING_PARAMETER_NAME, Value.newBuilder().setStringValue("Boston").build()))
          .build();
  private static final FunctionCall FUNCTION_CALL_WITH_FALSE_PARAMETER_NAME =
      FunctionCall.newBuilder()
          .setName(FUNCTION_NAME_1)
          .setArgs(
              Struct.newBuilder()
                  .putFields(
                      "nonExistParameter", Value.newBuilder().setStringValue("Boston").build()))
          .build();
  private static final FunctionCall FUNCTION_CALL_WITH_FALSE_PARAMETER_VALUE =
      FunctionCall.newBuilder()
          .setName(FUNCTION_NAME_1)
          .setArgs(
              Struct.newBuilder()
                  .putFields(STRING_PARAMETER_NAME, Value.newBuilder().setBoolValue(false).build()))
          .build();

  public static String getCurrentWeather(String location) {
    if (location.equals("Boston")) {
      return "snowing";
    } else if (location.equals("Vancouver")) {
      return "raining";
    } else {
      return "sunny";
    }
  }

  public static int getCurrentTemperature(String location) {
    if (location.equals("Boston")) {
      return 32;
    } else if (location.equals("Vancouver")) {
      return 45;
    } else {
      return 75;
    }
  }

  public boolean nonStaticMethod() {
    return true;
  }

  @Test
  public void testInitAutomaticFunctionCallingResponder_containsRightFields() {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();

    assertThat(responder.getMaxFunctionCalls()).isEqualTo(DEFAULT_MAX_FUNCTION_CALLS);
  }

  @Test
  public void testInitAutomaticFunctionCallingResponderWithMaxFunctionCalls_containsRightFields() {
    AutomaticFunctionCallingResponder responder =
        new AutomaticFunctionCallingResponder(MAX_FUNCTION_CALLS);

    assertThat(responder.getMaxFunctionCalls()).isEqualTo(MAX_FUNCTION_CALLS);
  }

  @Test
  public void testSetMaxFunctionCalls_containsRightFields() {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    responder.setMaxFunctionCalls(MAX_FUNCTION_CALLS);

    assertThat(responder.getMaxFunctionCalls()).isEqualTo(MAX_FUNCTION_CALLS);
  }

  @Test
  public void testAddCallableFunctionWithoutOrderedParameterNames_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> responder.addCallableFunction(FUNCTION_NAME_1, callableFunction));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "Failed to retrieve the parameter name from reflection. Please compile your code with"
                + "  \"-parameters\" flag or use `addCallableFunction(String, Method, String...)`"
                + " to manually enter parameter names");
  }

  @Test
  public void testAddNonStaticCallableFunction_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method nonStaticMethod =
        AutomaticFunctionCallingResponderTest.class.getMethod("nonStaticMethod");

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                responder.addCallableFunction(
                    FUNCTION_NAME_1, nonStaticMethod, STRING_PARAMETER_NAME));
    assertThat(thrown).hasMessageThat().isEqualTo("Function calling only supports static methods.");
  }

  @Test
  public void testAddRepeatedCallableFunction_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction, STRING_PARAMETER_NAME);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                responder.addCallableFunction(
                    FUNCTION_NAME_1, callableFunction, STRING_PARAMETER_NAME));
    assertThat(thrown).hasMessageThat().isEqualTo("Duplicate function name: " + FUNCTION_NAME_1);
  }

  @Test
  public void testAddCallableFunctionWithWrongParameterNames_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                responder.addCallableFunction(
                    FUNCTION_NAME_1, callableFunction, STRING_PARAMETER_NAME, "anotherParameter"));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "The number of provided parameter names doesn't match the number of parameters in the"
                + " callable function.");
  }

  @Test
  public void testRespondToFunctionCall_returnsCorrectResponse() throws Exception {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder(2);
    Method callableFunction1 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    Method callableFunction2 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_2, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction1, STRING_PARAMETER_NAME);
    responder.addCallableFunction(FUNCTION_NAME_2, callableFunction2, STRING_PARAMETER_NAME);
    List<FunctionCall> functionCalls = Arrays.asList(FUNCTION_CALL_1, FUNCTION_CALL_2);

    Content response = responder.getContentFromFunctionCalls(functionCalls);

    Content expectedResponse =
        ContentMaker.fromMultiModalData(
            PartMaker.fromFunctionResponse(
                FUNCTION_NAME_1, Collections.singletonMap("result", "snowing")),
            PartMaker.fromFunctionResponse(
                FUNCTION_NAME_2, Collections.singletonMap("result", 45)));

    assertThat(response).isEqualTo(expectedResponse);
  }

  @Test
  public void testRespondToFunctionCallExceedsMaxFunctionCalls_throwsIllegalStateException()
      throws Exception {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction1 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    Method callableFunction2 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_2, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction1, STRING_PARAMETER_NAME);
    responder.addCallableFunction(FUNCTION_NAME_2, callableFunction2, STRING_PARAMETER_NAME);
    List<FunctionCall> functionCalls = Arrays.asList(FUNCTION_CALL_1, FUNCTION_CALL_2);

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> responder.getContentFromFunctionCalls(functionCalls));
    assertThat(thrown)
        .hasMessageThat()
        .contains("Exceeded the maximum number of continuous automatic function calls");
  }

  @Test
  public void testRespondToFunctionCallWithNonExistFunction_throwsIllegalArgumentException()
      throws Exception {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction1 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction1, STRING_PARAMETER_NAME);
    List<FunctionCall> functionCalls = Arrays.asList(FUNCTION_CALL_WITH_FALSE_FUNCTION_NAME);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> responder.getContentFromFunctionCalls(functionCalls));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo("Model has asked to call function \"nonExistFunction\" which was not found.");
  }

  @Test
  public void testRespondToFunctionCallWithNonExistParameter_throwsIllegalArgumentException()
      throws Exception {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction1 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction1, STRING_PARAMETER_NAME);
    List<FunctionCall> functionCalls = Arrays.asList(FUNCTION_CALL_WITH_FALSE_PARAMETER_NAME);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> responder.getContentFromFunctionCalls(functionCalls));
    assertThat(thrown)
        .hasMessageThat()
        .contains(
            "The parameter \""
                + STRING_PARAMETER_NAME
                + "\" was not found in the arguments requested by the"
                + " model.");
  }

  @Test
  public void testRespondToFunctionCallWithWrongParameterValue_throwsIllegalStateException()
      throws Exception {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction1 =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction1, STRING_PARAMETER_NAME);
    List<FunctionCall> functionCalls = Arrays.asList(FUNCTION_CALL_WITH_FALSE_PARAMETER_VALUE);

    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> responder.getContentFromFunctionCalls(functionCalls));
    assertThat(thrown)
        .hasMessageThat()
        .contains(
            "Error raised when calling function \""
                + FUNCTION_NAME_1
                + "\" as requested by the model. ");
  }
}
