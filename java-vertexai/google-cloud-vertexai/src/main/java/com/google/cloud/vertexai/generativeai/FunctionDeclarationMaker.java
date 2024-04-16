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
import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

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
}
