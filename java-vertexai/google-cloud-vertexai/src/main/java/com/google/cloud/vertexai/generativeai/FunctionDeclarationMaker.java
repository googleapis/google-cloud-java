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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.vertexai.api.FunctionDeclaration;
import com.google.cloud.vertexai.api.Schema;
import com.google.cloud.vertexai.api.Type;
import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/** Helper class to create {@link com.google.cloud.vertexai.api.FunctionDeclaration} */
public final class FunctionDeclarationMaker {

  /**
   * Creates a FunctionDeclaration from a JsonString
   *
   * @param jsonString A valid Json String that can be parsed to a FunctionDeclaration.
   * @return a {@link FunctionDeclaration} by parsing the input json String.
   * @throws InvalidProtocolBufferException if the String can't be parsed into a FunctionDeclaration
   *     proto.
   */
  public static FunctionDeclaration fromJsonString(String jsonString)
      throws InvalidProtocolBufferException {
    checkArgument(!Strings.isNullOrEmpty(jsonString), "Input String can't be null or empty.");
    FunctionDeclaration.Builder builder = FunctionDeclaration.newBuilder();
    JsonFormat.parser().merge(jsonString, builder);
    FunctionDeclaration declaration = builder.build();
    if (declaration.getName().isEmpty()) {
      throw new IllegalArgumentException("name field must be present.");
    }
    return declaration;
  }

  /**
   * Creates a FunctionDeclaration from a JsonObject
   *
   * @param jsonObject A valid Json Object that can be parsed to a FunctionDeclaration.
   * @return a {@link FunctionDeclaration} by parsing the input json Object.
   * @throws InvalidProtocolBufferException if the jsonObject can't be parsed into a
   *     FunctionDeclaration proto.
   */
  public static FunctionDeclaration fromJsonObject(JsonObject jsonObject)
      throws InvalidProtocolBufferException {
    checkNotNull(jsonObject, "JsonObject can't be null.");
    return fromJsonString(jsonObject.toString());
  }

  /**
   * Creates a FunctionDeclaration from a Java static method
   *
   * <p><b>Note:</b>: If you don't want to manually provide parameter names, you can ignore
   * `orderedParameterNames` and compile your code with the "-parameters" flag. In this case, the
   * parameter names can be auto retrieved from reflection.
   *
   * @param functionDescription A description of the method.
   * @param function A Java static method.
   * @param orderedParameterNames A list of parameter names in the order they are passed to the
   *     method.
   * @return a {@link com.google.cloud.vertexai.api.FunctionDeclaration} instance.
   * @throws IllegalArgumentException if the method is not a static method or the number of provided
   *     parameter names doesn't match the number of parameters in the callable function or
   *     parameter types in this method are not String, boolean, int, double, or float.
   * @throws IllegalStateException if the parameter names are not provided and cannot be retrieved
   *     from reflection
   */
  public static FunctionDeclaration fromFunc(
      String functionDescription, Method function, String... orderedParameterNames) {
    if (!Modifier.isStatic(function.getModifiers())) {
      throw new IllegalArgumentException(
          "Instance methods are not supported. Please use static methods.");
    }
    Schema.Builder parametersBuilder = Schema.newBuilder().setType(Type.OBJECT);

    Parameter[] parameters = function.getParameters();
    // If parameter names are provided, the number of parameter names should match the number of
    // parameters in the method.
    if (orderedParameterNames.length > 0 && orderedParameterNames.length != parameters.length) {
      throw new IllegalArgumentException(
          "The number of parameter names does not match the number of parameters in the method.");
    }

    for (int i = 0; i < parameters.length; i++) {
      if (orderedParameterNames.length == 0) {
        // If parameter names are not provided, try to retrieve them from reflection.
        if (!parameters[i].isNamePresent()) {
          throw new IllegalStateException(
              "Failed to retrieve the parameter name from reflection. Please compile your"
                  + " code with  \"-parameters\" flag or use `fromFunc(String, Method,"
                  + " String...)` to manually enter parameter names");
        }
        addParameterToParametersBuilder(
            parametersBuilder, parameters[i].getName(), parameters[i].getType());
      } else {
        addParameterToParametersBuilder(
            parametersBuilder, orderedParameterNames[i], parameters[i].getType());
      }
    }

    return FunctionDeclaration.newBuilder()
        .setName(function.getName())
        .setDescription(functionDescription)
        .setParameters(parametersBuilder)
        .build();
  }

  /** Adds a parameter to the parameters builder. */
  private static void addParameterToParametersBuilder(
      Schema.Builder parametersBuilder, String parameterName, Class<?> parameterType) {
    Schema.Builder parameterBuilder = Schema.newBuilder().setDescription(parameterName);
    switch (parameterType.getName()) {
      case "java.lang.String":
        parameterBuilder.setType(Type.STRING);
        break;
      case "boolean":
        parameterBuilder.setType(Type.BOOLEAN);
        break;
      case "int":
        parameterBuilder.setType(Type.INTEGER);
        break;
      case "double":
      case "float":
        parameterBuilder.setType(Type.NUMBER);
        break;
      default:
        throw new IllegalArgumentException(
            "Unsupported parameter type "
                + parameterType.getName()
                + " for parameter "
                + parameterName);
    }
    parametersBuilder
        .addRequired(parameterName)
        .putProperties(parameterName, parameterBuilder.build());
  }
}
