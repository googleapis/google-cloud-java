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

import com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/** A responder that automatically calls functions when requested by the GenAI model. */
public final class AutomaticFunctionCallingResponder {
  private int maxFunctionCalls = 1;
  private int remainingFunctionCalls;
  private final Map<String, CallableFunction> callableFunctions = new HashMap<>();

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

    /** Validates that the given method is a static method. */
    private void validateFunction(Method method) {
      if (!Modifier.isStatic(method.getModifiers())) {
        throw new IllegalArgumentException("Function calling only supports static methods.");
      }
    }
  }
}
