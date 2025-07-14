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

import com.google.cloud.vertexai.api.Schema;
import com.google.common.base.Strings;
import com.google.gson.JsonObject;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

/**
 * Helper class to create {@link com.google.cloud.vertexai.api.Schema}
 *
 * @deprecated This class and its package are deprecated. See the <a
 *     href="https://cloud.google.com/vertex-ai/generative-ai/docs/deprecations/genai-vertexai-sdk#java">
 *     migration guide</a> for more details.
 */
@Deprecated
public final class SchemaMaker {

  private SchemaMaker() {}

  /**
   * Creates a Schema from a JsonString
   *
   * @param jsonString A valid Json String that can be parsed to a Schema object.
   * @return a {@link com.google.cloud.vertexai.api.Schema} by parsing the input JSON string.
   * @throws InvalidProtocolBufferException if the String can't be parsed into a Schema proto.
   */
  public static Schema fromJsonString(String jsonString) throws InvalidProtocolBufferException {
    checkArgument(!Strings.isNullOrEmpty(jsonString), "Input String can't be null or empty.");
    Schema.Builder builder = Schema.newBuilder();
    JsonFormat.parser().merge(jsonString, builder);

    return builder.build();
  }

  /**
   * Creates a Schema from a JsonObject
   *
   * @param jsonObject A valid JSON object that can be parsed to a Schema object.
   * @return a {@link com.google.cloud.vertexai.api.Schema} by parsing the input JSON object.
   * @throws InvalidProtocolBufferException if the jsonObject can't be parsed into a Schema proto.
   */
  public static Schema fromJsonObject(JsonObject jsonObject) throws InvalidProtocolBufferException {
    checkNotNull(jsonObject, "JsonObject can't be null.");
    return fromJsonString(jsonObject.toString());
  }
}
