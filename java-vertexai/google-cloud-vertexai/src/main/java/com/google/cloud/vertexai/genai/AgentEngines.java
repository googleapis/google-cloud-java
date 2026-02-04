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
import com.google.cloud.vertexai.genai.types.AgentEngineOperation;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineRequestParameters;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineOperation;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineRequestParameters;
import com.google.cloud.vertexai.genai.types.GetAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationParameters;
import com.google.cloud.vertexai.genai.types.GetAgentEngineRequestParameters;
import com.google.cloud.vertexai.genai.types.ListAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineRequestParameters;
import com.google.cloud.vertexai.genai.types.ListReasoningEnginesResponse;
import com.google.cloud.vertexai.genai.types.QueryAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.QueryAgentEngineRequestParameters;
import com.google.cloud.vertexai.genai.types.QueryReasoningEngineResponse;
import com.google.cloud.vertexai.genai.types.ReasoningEngine;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineRequestParameters;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.JsonSerializable;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Optional;
import okhttp3.ResponseBody;

public final class AgentEngines {

  final ApiClient apiClient;

  public AgentEngines(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode createAgentEngineConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"description"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"description"},
          Common.getValueByPath(fromObject, new String[] {"description"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"spec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"spec"},
          Common.getValueByPath(fromObject, new String[] {"spec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"contextSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"contextSpec"},
          Common.getValueByPath(fromObject, new String[] {"contextSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pscInterfaceConfig"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"pscInterfaceConfig"},
          Common.getValueByPath(fromObject, new String[] {"pscInterfaceConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"labels"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"labels"},
          Common.getValueByPath(fromObject, new String[] {"labels"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"sourcePackages"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"sourcePackages"},
          Common.getValueByPath(fromObject, new String[] {"sourcePackages"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"entrypointModule"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"entrypointModule"},
          Common.getValueByPath(fromObject, new String[] {"entrypointModule"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"entrypointObject"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"entrypointObject"},
          Common.getValueByPath(fromObject, new String[] {"entrypointObject"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"requirementsFile"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"requirementsFile"},
          Common.getValueByPath(fromObject, new String[] {"requirementsFile"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"agentFramework"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"agentFramework"},
          Common.getValueByPath(fromObject, new String[] {"agentFramework"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pythonVersion"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"pythonVersion"},
          Common.getValueByPath(fromObject, new String[] {"pythonVersion"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode createAgentEngineRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          createAgentEngineConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode deleteAgentEngineRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"force"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"force"},
          Common.getValueByPath(fromObject, new String[] {"force"}));
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
  ObjectNode getAgentEngineOperationParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"operationName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "operationName"},
          Common.getValueByPath(fromObject, new String[] {"operationName"}));
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
  ObjectNode getAgentEngineRequestParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode listAgentEngineConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"pageSize"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"_query", "pageSize"},
          Common.getValueByPath(fromObject, new String[] {"pageSize"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pageToken"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"_query", "pageToken"},
          Common.getValueByPath(fromObject, new String[] {"pageToken"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"filter"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"_query", "filter"},
          Common.getValueByPath(fromObject, new String[] {"filter"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode listAgentEngineRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          listAgentEngineConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode queryAgentEngineConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"classMethod"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"classMethod"},
          Common.getValueByPath(fromObject, new String[] {"classMethod"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"input"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"input"},
          Common.getValueByPath(fromObject, new String[] {"input"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"includeAllFields"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"includeAllFields"},
          Common.getValueByPath(fromObject, new String[] {"includeAllFields"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode queryAgentEngineRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
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
          queryAgentEngineConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode updateAgentEngineConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"description"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"description"},
          Common.getValueByPath(fromObject, new String[] {"description"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"spec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"spec"},
          Common.getValueByPath(fromObject, new String[] {"spec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"contextSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"contextSpec"},
          Common.getValueByPath(fromObject, new String[] {"contextSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pscInterfaceConfig"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"pscInterfaceConfig"},
          Common.getValueByPath(fromObject, new String[] {"pscInterfaceConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"labels"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"labels"},
          Common.getValueByPath(fromObject, new String[] {"labels"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"sourcePackages"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"sourcePackages"},
          Common.getValueByPath(fromObject, new String[] {"sourcePackages"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"entrypointModule"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"entrypointModule"},
          Common.getValueByPath(fromObject, new String[] {"entrypointModule"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"entrypointObject"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"entrypointObject"},
          Common.getValueByPath(fromObject, new String[] {"entrypointObject"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"requirementsFile"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"requirementsFile"},
          Common.getValueByPath(fromObject, new String[] {"requirementsFile"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"agentFramework"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"agentFramework"},
          Common.getValueByPath(fromObject, new String[] {"agentFramework"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pythonVersion"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"pythonVersion"},
          Common.getValueByPath(fromObject, new String[] {"pythonVersion"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"updateMask"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"_query", "updateMask"},
          Common.getValueByPath(fromObject, new String[] {"updateMask"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode updateAgentEngineRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
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
          updateAgentEngineConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreate(CreateAgentEngineConfig config) {

    CreateAgentEngineRequestParameters.Builder parameterBuilder =
        CreateAgentEngineRequestParameters.builder();

    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = createAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("reasoningEngines", body.get("_url"));
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
  AgentEngineOperation processResponseForPrivateCreate(
      ApiResponse response, CreateAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineOperation.class);
  }

  AgentEngineOperation privateCreate(CreateAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateCreate(config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreate(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateDelete(
      String name, boolean force, DeleteAgentEngineConfig config) {

    DeleteAgentEngineRequestParameters.Builder parameterBuilder =
        DeleteAgentEngineRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(force)) {
      parameterBuilder.force(force);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = deleteAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}", body.get("_url"));
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
  DeleteAgentEngineOperation processResponseForPrivateDelete(
      ApiResponse response, DeleteAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DeleteAgentEngineOperation.class);
  }

  DeleteAgentEngineOperation privateDelete(
      String name, boolean force, DeleteAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateDelete(name, force, config);

    try (ApiResponse response =
        this.apiClient.request(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateDelete(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGet(String name, GetAgentEngineConfig config) {

    GetAgentEngineRequestParameters.Builder parameterBuilder =
        GetAgentEngineRequestParameters.builder();

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
      body = getAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}", body.get("_url"));
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
  ReasoningEngine processResponseForPrivateGet(ApiResponse response, GetAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, ReasoningEngine.class);
  }

  ReasoningEngine privateGet(String name, GetAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGet(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGet(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateList(ListAgentEngineConfig config) {

    ListAgentEngineRequestParameters.Builder parameterBuilder =
        ListAgentEngineRequestParameters.builder();

    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = listAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("reasoningEngines", body.get("_url"));
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
  ListReasoningEnginesResponse processResponseForPrivateList(
      ApiResponse response, ListAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, ListReasoningEnginesResponse.class);
  }

  ListReasoningEnginesResponse privateList(ListAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateList(config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateList(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetAgentOperation(
      String operationName, GetAgentEngineOperationConfig config) {

    GetAgentEngineOperationParameters.Builder parameterBuilder =
        GetAgentEngineOperationParameters.builder();

    if (!Common.isZero(operationName)) {
      parameterBuilder.operationName(operationName);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = getAgentEngineOperationParametersToVertex(parameterNode, null);
      path = Common.formatMap("{operationName}", body.get("_url"));
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
  AgentEngineOperation processResponseForPrivateGetAgentOperation(
      ApiResponse response, GetAgentEngineOperationConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineOperation.class);
  }

  AgentEngineOperation privateGetAgentOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetAgentOperation(operationName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetAgentOperation(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateQuery(String name, QueryAgentEngineConfig config) {

    QueryAgentEngineRequestParameters.Builder parameterBuilder =
        QueryAgentEngineRequestParameters.builder();

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
      body = queryAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}:query", body.get("_url"));
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
  QueryReasoningEngineResponse processResponseForPrivateQuery(
      ApiResponse response, QueryAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, QueryReasoningEngineResponse.class);
  }

  QueryReasoningEngineResponse privateQuery(String name, QueryAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateQuery(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateQuery(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateUpdate(String name, UpdateAgentEngineConfig config) {

    UpdateAgentEngineRequestParameters.Builder parameterBuilder =
        UpdateAgentEngineRequestParameters.builder();

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
      body = updateAgentEngineRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}", body.get("_url"));
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
  AgentEngineOperation processResponseForPrivateUpdate(
      ApiResponse response, UpdateAgentEngineConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineOperation.class);
  }

  AgentEngineOperation privateUpdate(String name, UpdateAgentEngineConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateUpdate(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateUpdate(response, config);
    }
  }
}
