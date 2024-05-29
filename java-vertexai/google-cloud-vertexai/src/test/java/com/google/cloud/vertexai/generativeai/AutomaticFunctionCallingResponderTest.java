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

import java.lang.reflect.Method;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class AutomaticFunctionCallingResponderTest {
  private static final int MAX_FUNCTION_CALLS = 5;
  private static final int DEFAULT_MAX_FUNCTION_CALLS = 1;
  private static final String FUNCTION_NAME_1 = "getCurrentWeather";
  private static final String FUNCTION_NAME_2 = "getCurrentTemperature";
  private static final String PARAMETER_NAME = "location";

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
            () -> responder.addCallableFunction(FUNCTION_NAME_1, nonStaticMethod, PARAMETER_NAME));
    assertThat(thrown).hasMessageThat().isEqualTo("Function calling only supports static methods.");
  }

  @Test
  public void testAddRepeatedCallableFunction_throwsIllegalArgumentException()
      throws NoSuchMethodException {
    AutomaticFunctionCallingResponder responder = new AutomaticFunctionCallingResponder();
    Method callableFunction =
        AutomaticFunctionCallingResponderTest.class.getMethod(FUNCTION_NAME_1, String.class);
    responder.addCallableFunction(FUNCTION_NAME_1, callableFunction, PARAMETER_NAME);

    IllegalArgumentException thrown =
        assertThrows(
            IllegalArgumentException.class,
            () -> responder.addCallableFunction(FUNCTION_NAME_1, callableFunction, PARAMETER_NAME));
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
                    FUNCTION_NAME_1, callableFunction, PARAMETER_NAME, "anotherParameter"));
    assertThat(thrown)
        .hasMessageThat()
        .isEqualTo(
            "The number of provided parameter names doesn't match the number of parameters in the"
                + " callable function.");
  }
}
