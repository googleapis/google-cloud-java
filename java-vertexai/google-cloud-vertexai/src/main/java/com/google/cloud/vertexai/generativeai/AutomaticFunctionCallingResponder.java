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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.FunctionCall;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** A responder that automatically calls functions when requested by the GenAI model. */
public final class AutomaticFunctionCallingResponder {
  private int maxFunctionCalls = 1;
  private int remainingFunctionCalls;
  private final Map<String, CallableFunction> callableFunctions = new HashMap<>();

  private static final Logger logger =
      Logger.getLogger(AutomaticFunctionCallingResponder.class.getName());

  /** Constructs an AutomaticFunctionCallingResponder instance. */
  public AutomaticFunctionCallingResponder() {
    this.remainingFunctionCalls = this.maxFunctionCalls;
  }

  /**
   * Constructs an AutomaticFunctionCallingResponder instance.
   *
   * @param maxFunctionCalls the maximum number of function calls to make in a row
   */
  public AutomaticFunctionCallingResponder(int maxFunctionCalls) {
    this.maxFunctionCalls = maxFunctionCalls;
    this.remainingFunctionCalls = maxFunctionCalls;
  }

  /** Sets the maximum number of function calls to make in a row. */
  public void setMaxFunctionCalls(int maxFunctionCalls) {
    this.maxFunctionCalls = maxFunctionCalls;
    this.remainingFunctionCalls = this.maxFunctionCalls;
  }

  /** Gets the maximum number of function calls to make in a row. */
  public int getMaxFunctionCalls() {
    return maxFunctionCalls;
  }

  /** Resets the remaining function calls to the maximum number of function calls. */
  void resetRemainingFunctionCalls() {
    this.remainingFunctionCalls = this.maxFunctionCalls;
  }

  /**
   * Adds a callable function to the AutomaticFunctionCallingResponder.
   *
   * <p><b>Note:</b>: If you don't want to manually provide parameter names, you can ignore
   * `orderedParameterNames` and compile your code with the "-parameters" flag. In this case, the
   * parameter names can be auto retrieved from reflection.
   *
   * @param functionName the name of the function
   * @param callableFunction the method to call when the functionName is requested
   * @param orderedParameterNames the names of the parameters in the order they are passed to the
   *     function
   * @throws IllegalArgumentException if the functionName is already in the responder
   * @throws IllegalStateException if the parameter names are not provided and cannot be retrieved
   *     from reflection
   */
  public void addCallableFunction(
      String functionName, Method callableFunction, String... orderedParameterNames) {
    if (callableFunctions.containsKey(functionName)) {
      throw new IllegalArgumentException("Duplicate function name: " + functionName);
    } else {
      callableFunctions.put(
          functionName, new CallableFunction(callableFunction, orderedParameterNames));
    }
  }

  /**
   * Automatically calls functions requested by the model and generates a Content that contains the
   * results.
   *
   * @param functionCalls a list of {@link com.google.cloud.vertexai.api.FunctionCall} requested by
   *     the model
   * @return a {@link com.google.cloud.vertexai.api.Content} that contains the results of the
   *     function calls
   * @throws IllegalStateException if the number of automatic calls exceeds the maximum number of
   *     function calls
   * @throws IllegalArgumentException if the model has asked to call a function that was not found
   *     in the responder
   */
  Content getContentFromFunctionCalls(List<FunctionCall> functionCalls) {
    checkNotNull(functionCalls, "functionCalls cannot be null.");

    List<Object> responseParts = new ArrayList<>();

    for (FunctionCall functionCall : functionCalls) {
      if (remainingFunctionCalls <= 0) {
        throw new IllegalStateException(
            "Exceeded the maximum number of continuous automatic function calls ("
                + maxFunctionCalls
                + "). If more automatic function calls are needed, please call"
                + " `setMaxFunctionCalls() to set a higher number. The last function call is:\n"
                + functionCall);
      }
      remainingFunctionCalls -= 1;
      String functionName = functionCall.getName();
      CallableFunction callableFunction = callableFunctions.get(functionName);
      if (callableFunction == null) {
        throw new IllegalArgumentException(
            "Model has asked to call function \"" + functionName + "\" which was not found.");
      }
      responseParts.add(
          PartMaker.fromFunctionResponse(
              functionName,
              Collections.singletonMap("result", callableFunction.call(functionCall.getArgs()))));
    }

    return ContentMaker.fromMultiModalData(responseParts.toArray());
  }

  /** A class that represents a function that can be called automatically. */
  static class CallableFunction {
    private final Method callableFunction;
    private final ImmutableList<String> orderedParameterNames;

    /**
     * Constructs a CallableFunction instance.
     *
     * <p><b>Note:</b>: If you don't want to manually provide parameter names, you can ignore
     * `orderedParameterNames` and compile your code with the "-parameters" flag. In this case, the
     * parameter names can be auto retrieved from reflection.
     *
     * @param callableFunction the method to call
     * @param orderedParameterNames the names of the parameters in the order they are passed to the
     *     function
     * @throws IllegalArgumentException if the given method is not a static method or the number of
     *     provided parameter names doesn't match the number of parameters in the callable function
     * @throws IllegalStateException if the parameter names are not provided and cannot be retrieved
     *     from reflection
     */
    CallableFunction(Method callableFunction, String... orderedParameterNames) {
      validateFunction(callableFunction);
      this.callableFunction = callableFunction;

      if (orderedParameterNames.length == 0) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        for (Parameter parameter : callableFunction.getParameters()) {
          if (parameter.isNamePresent()) {
            builder.add(parameter.getName());
          } else {
            throw new IllegalStateException(
                "Failed to retrieve the parameter name from reflection. Please compile your code"
                    + " with  \"-parameters\" flag or use `addCallableFunction(String, Method,"
                    + " String...)` to manually enter parameter names");
          }
        }
        this.orderedParameterNames = builder.build();
      } else if (orderedParameterNames.length == callableFunction.getParameters().length) {
        this.orderedParameterNames = ImmutableList.copyOf(orderedParameterNames);
      } else {
        throw new IllegalArgumentException(
            "The number of provided parameter names doesn't match the number of parameters in the"
                + " callable function.");
      }
    }

    /**
     * Calls the callable function with the given arguments.
     *
     * @param args the arguments to pass to the function
     * @return the result of the function call
     * @throws IllegalStateException if there are errors when invoking the function
     * @throws IllegalArgumentException if the args map doesn't contain all the parameters of the
     *     function or the value types in the args map are not supported
     */
    Object call(Struct args) {
      // Extract the arguments from the Struct
      Map<String, Value> argsMap = args.getFieldsMap();
      List<Object> argsList = new ArrayList<>();
      for (int i = 0; i < orderedParameterNames.size(); i++) {
        String parameterName = orderedParameterNames.get(i);
        if (!argsMap.containsKey(parameterName)) {
          throw new IllegalArgumentException(
              "The parameter \""
                  + parameterName
                  + "\" was not found in the arguments requested by the model. Args map: "
                  + argsMap);
        }
        Value value = argsMap.get(parameterName);
        switch (value.getKindCase()) {
          case NUMBER_VALUE:
            // Args map only returns double values, but the function may expect other types(int,
            // float). So we need to cast the value to the correct type.
            Class<?> parameterType = callableFunction.getParameters()[i].getType();
            if (parameterType.equals(int.class)) {
              argsList.add((int) value.getNumberValue());
            } else if (parameterType.equals(float.class)) {
              argsList.add((float) value.getNumberValue());
            } else {
              argsList.add(value.getNumberValue());
            }
            break;
          case STRING_VALUE:
            argsList.add(value.getStringValue());
            break;
          case BOOL_VALUE:
            argsList.add(value.getBoolValue());
            break;
          case NULL_VALUE:
            argsList.add(null);
            break;
          default:
            throw new IllegalArgumentException(
                "Unsupported value type "
                    + value.getKindCase()
                    + " for parameter "
                    + parameterName);
        }
      }

      // Invoke the function
      logger.info(
          "Automatically calling function: "
              + callableFunction.getName()
              + argsList.toString().replace('[', '(').replace(']', ')'));
      try {
        return callableFunction.invoke(null, argsList.toArray());
      } catch (Exception e) {
        throw new IllegalStateException(
            "Error raised when calling function \""
                + callableFunction.getName()
                + "\" as requested by the model. ",
            e);
      }
    }

    /** Validates that the given method is a static method. */
    private void validateFunction(Method method) {
      if (!Modifier.isStatic(method.getModifiers())) {
        throw new IllegalArgumentException("Function calling only supports static methods.");
      }
    }
  }
}
