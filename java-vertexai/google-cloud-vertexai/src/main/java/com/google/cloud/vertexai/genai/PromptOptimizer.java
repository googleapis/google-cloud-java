/*
 * Copyright 2025 Google LLC
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

// Auto-generated code. Do not edit.

package com.google.cloud.vertexai.genai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.cloud.vertexai.genai.types.CustomJob;
import com.google.cloud.vertexai.genai.types.CustomJobParameters;
import com.google.cloud.vertexai.genai.types.GetCustomJobParameters;
import com.google.cloud.vertexai.genai.types.OptimizeConfig;
import com.google.cloud.vertexai.genai.types.OptimizeRequestParameters;
import com.google.cloud.vertexai.genai.types.OptimizeResponseEndpoint;
import com.google.cloud.vertexai.genai.types.VertexBaseConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.JsonSerializable;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.Content;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Optional;
import okhttp3.ResponseBody;

public final class PromptOptimizer {

  final ApiClient apiClient;

  public PromptOptimizer(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode customJobFromVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(parentObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"displayName"},
          Common.getValueByPath(parentObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(parentObject, new String[] {"jobSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"jobSpec"},
          Common.getValueByPath(parentObject, new String[] {"jobSpec"}));
    }

    if (Common.getValueByPath(parentObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(parentObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"state"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"state"},
          Common.getValueByPath(fromObject, new String[] {"state"}));
    }

    if (Common.getValueByPath(parentObject, new String[] {"error"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"error"},
          Common.getValueByPath(parentObject, new String[] {"error"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"createTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"createTime"},
          Common.getValueByPath(fromObject, new String[] {"createTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"endTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"endTime"},
          Common.getValueByPath(fromObject, new String[] {"endTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"labels"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"labels"},
          Common.getValueByPath(fromObject, new String[] {"labels"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"satisfiesPzi"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"satisfiesPzi"},
          Common.getValueByPath(fromObject, new String[] {"satisfiesPzi"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"satisfiesPzs"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"satisfiesPzs"},
          Common.getValueByPath(fromObject, new String[] {"satisfiesPzs"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"startTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"startTime"},
          Common.getValueByPath(fromObject, new String[] {"startTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"updateTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"updateTime"},
          Common.getValueByPath(fromObject, new String[] {"updateTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"webAccessUris"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"webAccessUris"},
          Common.getValueByPath(fromObject, new String[] {"webAccessUris"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode customJobParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"customJob"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"customJob"},
          customJobToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"customJob"})),
              toObject));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          Common.getValueByPath(fromObject, new String[] {"config"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode customJobToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"jobSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"jobSpec"},
          Common.getValueByPath(fromObject, new String[] {"jobSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"state"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"state"},
          Common.getValueByPath(fromObject, new String[] {"state"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"error"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"error"},
          Common.getValueByPath(fromObject, new String[] {"error"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"createTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"createTime"},
          Common.getValueByPath(fromObject, new String[] {"createTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"endTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"endTime"},
          Common.getValueByPath(fromObject, new String[] {"endTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"labels"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"labels"},
          Common.getValueByPath(fromObject, new String[] {"labels"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"satisfiesPzi"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"satisfiesPzi"},
          Common.getValueByPath(fromObject, new String[] {"satisfiesPzi"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"satisfiesPzs"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"satisfiesPzs"},
          Common.getValueByPath(fromObject, new String[] {"satisfiesPzs"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"startTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"startTime"},
          Common.getValueByPath(fromObject, new String[] {"startTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"updateTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"updateTime"},
          Common.getValueByPath(fromObject, new String[] {"updateTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"webAccessUris"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"webAccessUris"},
          Common.getValueByPath(fromObject, new String[] {"webAccessUris"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode getCustomJobParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          Common.getValueByPath(fromObject, new String[] {"config"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode optimizeConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"optimizationTarget"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"optimizationTarget"},
          Common.getValueByPath(fromObject, new String[] {"optimizationTarget"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode optimizeRequestParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"content"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"content"},
          Common.getValueByPath(fromObject, new String[] {"content"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          optimizeConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateOptimizePrompt(Content content, OptimizeConfig config) {

    OptimizeRequestParameters.Builder parameterBuilder = OptimizeRequestParameters.builder();

    if (!Common.isZero(content)) {
      parameterBuilder.content(content);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = optimizeRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("tuningJobs:optimizePrompt", body.get("_url"));
    } else {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }
    body.remove("_url");

    JsonNode queryParams = body.get("_query");
    if (queryParams != null) {
      body.remove("_query");
      path = String.format("%s?%s", path, Common.urlEncode((ObjectNode) queryParams));
    }

    // TODO: Remove the hack that removes config.
    Optional<HttpOptions> requestHttpOptions = Optional.empty();
    if (config != null) {
      requestHttpOptions = config.httpOptions();
    }

    return new BuiltRequest(path, JsonSerializable.toJsonString(body), requestHttpOptions);
  }

  /** A shared processResponse function for both sync and async methods. */
  OptimizeResponseEndpoint processResponseForPrivateOptimizePrompt(
      ApiResponse response, OptimizeConfig config) {
    ResponseBody responseBody = response.getBody();
    String responseString;
    try {
      responseString = responseBody.string();
    } catch (IOException e) {
      throw new GenAiIOException("Failed to read HTTP response.", e);
    }

    JsonNode responseNode = JsonSerializable.stringToJsonNode(responseString);

    if (!this.apiClient.vertexAI()) {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }

    return JsonSerializable.fromJsonNode(responseNode, OptimizeResponseEndpoint.class);
  }

  OptimizeResponseEndpoint privateOptimizePrompt(Content content, OptimizeConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateOptimizePrompt(content, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateOptimizePrompt(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreateCustomJobResource(
      CustomJob customJob, VertexBaseConfig config) {

    CustomJobParameters.Builder parameterBuilder = CustomJobParameters.builder();

    if (!Common.isZero(customJob)) {
      parameterBuilder.customJob(customJob);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = customJobParametersToVertex(parameterNode, null);
      path = Common.formatMap("customJobs", body.get("_url"));
    } else {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }
    body.remove("_url");

    JsonNode queryParams = body.get("_query");
    if (queryParams != null) {
      body.remove("_query");
      path = String.format("%s?%s", path, Common.urlEncode((ObjectNode) queryParams));
    }

    // TODO: Remove the hack that removes config.
    Optional<HttpOptions> requestHttpOptions = Optional.empty();
    if (config != null) {
      requestHttpOptions = config.httpOptions();
    }

    return new BuiltRequest(path, JsonSerializable.toJsonString(body), requestHttpOptions);
  }

  /** A shared processResponse function for both sync and async methods. */
  CustomJob processResponseForPrivateCreateCustomJobResource(
      ApiResponse response, VertexBaseConfig config) {
    ResponseBody responseBody = response.getBody();
    String responseString;
    try {
      responseString = responseBody.string();
    } catch (IOException e) {
      throw new GenAiIOException("Failed to read HTTP response.", e);
    }

    JsonNode responseNode = JsonSerializable.stringToJsonNode(responseString);

    if (this.apiClient.vertexAI()) {
      responseNode = customJobFromVertex(responseNode, null);
    }

    if (!this.apiClient.vertexAI()) {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }

    return JsonSerializable.fromJsonNode(responseNode, CustomJob.class);
  }

  CustomJob privateCreateCustomJobResource(CustomJob customJob, VertexBaseConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateCreateCustomJobResource(customJob, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreateCustomJobResource(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetCustomJob(String name, VertexBaseConfig config) {

    GetCustomJobParameters.Builder parameterBuilder = GetCustomJobParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = getCustomJobParametersToVertex(parameterNode, null);
      path = Common.formatMap("customJobs/{name}", body.get("_url"));
    } else {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }
    body.remove("_url");

    JsonNode queryParams = body.get("_query");
    if (queryParams != null) {
      body.remove("_query");
      path = String.format("%s?%s", path, Common.urlEncode((ObjectNode) queryParams));
    }

    // TODO: Remove the hack that removes config.
    Optional<HttpOptions> requestHttpOptions = Optional.empty();
    if (config != null) {
      requestHttpOptions = config.httpOptions();
    }

    return new BuiltRequest(path, JsonSerializable.toJsonString(body), requestHttpOptions);
  }

  /** A shared processResponse function for both sync and async methods. */
  CustomJob processResponseForPrivateGetCustomJob(ApiResponse response, VertexBaseConfig config) {
    ResponseBody responseBody = response.getBody();
    String responseString;
    try {
      responseString = responseBody.string();
    } catch (IOException e) {
      throw new GenAiIOException("Failed to read HTTP response.", e);
    }

    JsonNode responseNode = JsonSerializable.stringToJsonNode(responseString);

    if (this.apiClient.vertexAI()) {
      responseNode = customJobFromVertex(responseNode, null);
    }

    if (!this.apiClient.vertexAI()) {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }

    return JsonSerializable.fromJsonNode(responseNode, CustomJob.class);
  }

  CustomJob privateGetCustomJob(String name, VertexBaseConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetCustomJob(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetCustomJob(response, config);
    }
  }
}
