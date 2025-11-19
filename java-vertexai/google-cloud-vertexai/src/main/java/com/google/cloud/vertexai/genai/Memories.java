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
import com.google.cloud.vertexai.genai.types.AgentEngineGenerateMemoriesOperation;
import com.google.cloud.vertexai.genai.types.AgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.AgentEngineMemoryOperation;
import com.google.cloud.vertexai.genai.types.AgentEngineRollbackMemoryOperation;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineMemoryRequestParameters;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineMemoryOperation;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineMemoryRequestParameters;
import com.google.cloud.vertexai.genai.types.GenerateAgentEngineMemoriesConfig;
import com.google.cloud.vertexai.genai.types.GenerateAgentEngineMemoriesRequestParameters;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestDirectContentsSource;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestDirectMemoriesSource;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestVertexSessionSource;
import com.google.cloud.vertexai.genai.types.GetAgentEngineGenerateMemoriesOperationParameters;
import com.google.cloud.vertexai.genai.types.GetAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineMemoryOperationParameters;
import com.google.cloud.vertexai.genai.types.GetAgentEngineMemoryRequestParameters;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineMemoryRequestParameters;
import com.google.cloud.vertexai.genai.types.ListReasoningEnginesMemoriesResponse;
import com.google.cloud.vertexai.genai.types.Memory;
import com.google.cloud.vertexai.genai.types.RetrieveAgentEngineMemoriesConfig;
import com.google.cloud.vertexai.genai.types.RetrieveAgentEngineMemoriesRequestParameters;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesRequestSimilaritySearchParams;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesRequestSimpleRetrievalParams;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesResponse;
import com.google.cloud.vertexai.genai.types.RollbackAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.RollbackAgentEngineMemoryRequestParameters;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineMemoryRequestParameters;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.JsonSerializable;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import okhttp3.ResponseBody;

public final class Memories {

  final ApiClient apiClient;

  public Memories(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode agentEngineMemoryConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
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

    if (Common.getValueByPath(fromObject, new String[] {"ttl"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"ttl"},
          Common.getValueByPath(fromObject, new String[] {"ttl"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"expireTime"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"expireTime"},
          Common.getValueByPath(fromObject, new String[] {"expireTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionExpireTime"},
          Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionTtl"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionTtl"},
          Common.getValueByPath(fromObject, new String[] {"revisionTtl"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"disableMemoryRevisions"},
          Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"topics"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"topics"},
          Common.getValueByPath(fromObject, new String[] {"topics"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode createAgentEngineMemoryRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"fact"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"fact"},
          Common.getValueByPath(fromObject, new String[] {"fact"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"scope"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"scope"},
          Common.getValueByPath(fromObject, new String[] {"scope"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          agentEngineMemoryConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode deleteAgentEngineMemoryRequestParametersToVertex(
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
          Common.getValueByPath(fromObject, new String[] {"config"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode generateAgentEngineMemoriesConfigToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"disableConsolidation"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"disableConsolidation"},
          Common.getValueByPath(fromObject, new String[] {"disableConsolidation"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionLabels"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionLabels"},
          Common.getValueByPath(fromObject, new String[] {"revisionLabels"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionExpireTime"},
          Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionTtl"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionTtl"},
          Common.getValueByPath(fromObject, new String[] {"revisionTtl"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"disableMemoryRevisions"},
          Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode generateAgentEngineMemoriesRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"vertexSessionSource"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"vertexSessionSource"},
          Common.getValueByPath(fromObject, new String[] {"vertexSessionSource"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"directContentsSource"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"directContentsSource"},
          Common.getValueByPath(fromObject, new String[] {"directContentsSource"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"directMemoriesSource"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"directMemoriesSource"},
          Common.getValueByPath(fromObject, new String[] {"directMemoriesSource"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"scope"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"scope"},
          Common.getValueByPath(fromObject, new String[] {"scope"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          generateAgentEngineMemoriesConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode getAgentEngineGenerateMemoriesOperationParametersToVertex(
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
  ObjectNode getAgentEngineMemoryOperationParametersToVertex(
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
  ObjectNode getAgentEngineMemoryRequestParametersToVertex(
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
          Common.getValueByPath(fromObject, new String[] {"config"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode listAgentEngineMemoryConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
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

    if (Common.getValueByPath(fromObject, new String[] {"orderBy"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"_query", "orderBy"},
          Common.getValueByPath(fromObject, new String[] {"orderBy"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode listAgentEngineMemoryRequestParametersToVertex(
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
          listAgentEngineMemoryConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode retrieveAgentEngineMemoriesConfigToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"filter"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"filter"},
          Common.getValueByPath(fromObject, new String[] {"filter"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode retrieveAgentEngineMemoriesRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"scope"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"scope"},
          Common.getValueByPath(fromObject, new String[] {"scope"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"similaritySearchParams"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"similaritySearchParams"},
          Common.getValueByPath(fromObject, new String[] {"similaritySearchParams"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"simpleRetrievalParams"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"simpleRetrievalParams"},
          Common.getValueByPath(fromObject, new String[] {"simpleRetrievalParams"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          retrieveAgentEngineMemoriesConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode rollbackAgentEngineMemoryRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"targetRevisionId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"targetRevisionId"},
          Common.getValueByPath(fromObject, new String[] {"targetRevisionId"}));
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
  ObjectNode updateAgentEngineMemoryConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
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

    if (Common.getValueByPath(fromObject, new String[] {"ttl"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"ttl"},
          Common.getValueByPath(fromObject, new String[] {"ttl"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"expireTime"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"expireTime"},
          Common.getValueByPath(fromObject, new String[] {"expireTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionExpireTime"},
          Common.getValueByPath(fromObject, new String[] {"revisionExpireTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"revisionTtl"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"revisionTtl"},
          Common.getValueByPath(fromObject, new String[] {"revisionTtl"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"disableMemoryRevisions"},
          Common.getValueByPath(fromObject, new String[] {"disableMemoryRevisions"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"topics"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"topics"},
          Common.getValueByPath(fromObject, new String[] {"topics"}));
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
  ObjectNode updateAgentEngineMemoryRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"fact"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"fact"},
          Common.getValueByPath(fromObject, new String[] {"fact"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"scope"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"scope"},
          Common.getValueByPath(fromObject, new String[] {"scope"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          updateAgentEngineMemoryConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreate(
      String name, String fact, Map<String, String> scope, AgentEngineMemoryConfig config) {

    CreateAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        CreateAgentEngineMemoryRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(fact)) {
      parameterBuilder.fact(fact);
    }
    if (!Common.isZero(scope)) {
      parameterBuilder.scope(scope);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = createAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}/memories", body.get("_url"));
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
  AgentEngineMemoryOperation processResponseForPrivateCreate(
      ApiResponse response, AgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineMemoryOperation.class);
  }

  AgentEngineMemoryOperation privateCreate(
      String name, String fact, Map<String, String> scope, AgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateCreate(name, fact, scope, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreate(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForDelete(String name, DeleteAgentEngineMemoryConfig config) {

    DeleteAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        DeleteAgentEngineMemoryRequestParameters.builder();

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
      body = deleteAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
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
  DeleteAgentEngineMemoryOperation processResponseForDelete(
      ApiResponse response, DeleteAgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DeleteAgentEngineMemoryOperation.class);
  }

  public DeleteAgentEngineMemoryOperation delete(
      String name, DeleteAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForDelete(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForDelete(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGenerate(
      String name,
      GenerateMemoriesRequestVertexSessionSource vertexSessionSource,
      GenerateMemoriesRequestDirectContentsSource directContentsSource,
      GenerateMemoriesRequestDirectMemoriesSource directMemoriesSource,
      Map<String, String> scope,
      GenerateAgentEngineMemoriesConfig config) {

    GenerateAgentEngineMemoriesRequestParameters.Builder parameterBuilder =
        GenerateAgentEngineMemoriesRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(vertexSessionSource)) {
      parameterBuilder.vertexSessionSource(vertexSessionSource);
    }
    if (!Common.isZero(directContentsSource)) {
      parameterBuilder.directContentsSource(directContentsSource);
    }
    if (!Common.isZero(directMemoriesSource)) {
      parameterBuilder.directMemoriesSource(directMemoriesSource);
    }
    if (!Common.isZero(scope)) {
      parameterBuilder.scope(scope);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = generateAgentEngineMemoriesRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}/memories:generate", body.get("_url"));
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
  AgentEngineGenerateMemoriesOperation processResponseForPrivateGenerate(
      ApiResponse response, GenerateAgentEngineMemoriesConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineGenerateMemoriesOperation.class);
  }

  AgentEngineGenerateMemoriesOperation privateGenerate(
      String name,
      GenerateMemoriesRequestVertexSessionSource vertexSessionSource,
      GenerateMemoriesRequestDirectContentsSource directContentsSource,
      GenerateMemoriesRequestDirectMemoriesSource directMemoriesSource,
      Map<String, String> scope,
      GenerateAgentEngineMemoriesConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateGenerate(
            name, vertexSessionSource, directContentsSource, directMemoriesSource, scope, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGenerate(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForGet(String name, GetAgentEngineMemoryConfig config) {

    GetAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        GetAgentEngineMemoryRequestParameters.builder();

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
      body = getAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
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
  Memory processResponseForGet(ApiResponse response, GetAgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, Memory.class);
  }

  public Memory get(String name, GetAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForGet(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForGet(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateList(String name, ListAgentEngineMemoryConfig config) {

    ListAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        ListAgentEngineMemoryRequestParameters.builder();

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
      body = listAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}/memories", body.get("_url"));
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
  ListReasoningEnginesMemoriesResponse processResponseForPrivateList(
      ApiResponse response, ListAgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, ListReasoningEnginesMemoriesResponse.class);
  }

  ListReasoningEnginesMemoriesResponse privateList(
      String name, ListAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateList(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateList(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetMemoryOperation(
      String operationName, GetAgentEngineOperationConfig config) {

    GetAgentEngineMemoryOperationParameters.Builder parameterBuilder =
        GetAgentEngineMemoryOperationParameters.builder();

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
      body = getAgentEngineMemoryOperationParametersToVertex(parameterNode, null);
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
  AgentEngineMemoryOperation processResponseForPrivateGetMemoryOperation(
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineMemoryOperation.class);
  }

  AgentEngineMemoryOperation privateGetMemoryOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetMemoryOperation(operationName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetMemoryOperation(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetGenerateMemoriesOperation(
      String operationName, GetAgentEngineOperationConfig config) {

    GetAgentEngineGenerateMemoriesOperationParameters.Builder parameterBuilder =
        GetAgentEngineGenerateMemoriesOperationParameters.builder();

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
      body = getAgentEngineGenerateMemoriesOperationParametersToVertex(parameterNode, null);
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
  AgentEngineGenerateMemoriesOperation processResponseForPrivateGetGenerateMemoriesOperation(
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineGenerateMemoriesOperation.class);
  }

  AgentEngineGenerateMemoriesOperation privateGetGenerateMemoriesOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateGetGenerateMemoriesOperation(operationName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetGenerateMemoriesOperation(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateRetrieve(
      String name,
      Map<String, String> scope,
      RetrieveMemoriesRequestSimilaritySearchParams similaritySearchParams,
      RetrieveMemoriesRequestSimpleRetrievalParams simpleRetrievalParams,
      RetrieveAgentEngineMemoriesConfig config) {

    RetrieveAgentEngineMemoriesRequestParameters.Builder parameterBuilder =
        RetrieveAgentEngineMemoriesRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(scope)) {
      parameterBuilder.scope(scope);
    }
    if (!Common.isZero(similaritySearchParams)) {
      parameterBuilder.similaritySearchParams(similaritySearchParams);
    }
    if (!Common.isZero(simpleRetrievalParams)) {
      parameterBuilder.simpleRetrievalParams(simpleRetrievalParams);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = retrieveAgentEngineMemoriesRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}/memories:retrieve", body.get("_url"));
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
  RetrieveMemoriesResponse processResponseForPrivateRetrieve(
      ApiResponse response, RetrieveAgentEngineMemoriesConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, RetrieveMemoriesResponse.class);
  }

  RetrieveMemoriesResponse privateRetrieve(
      String name,
      Map<String, String> scope,
      RetrieveMemoriesRequestSimilaritySearchParams similaritySearchParams,
      RetrieveMemoriesRequestSimpleRetrievalParams simpleRetrievalParams,
      RetrieveAgentEngineMemoriesConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateRetrieve(
            name, scope, similaritySearchParams, simpleRetrievalParams, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateRetrieve(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateRollback(
      String name, String targetRevisionId, RollbackAgentEngineMemoryConfig config) {

    RollbackAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        RollbackAgentEngineMemoryRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(targetRevisionId)) {
      parameterBuilder.targetRevisionId(targetRevisionId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = rollbackAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("{name}:rollback", body.get("_url"));
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
  AgentEngineRollbackMemoryOperation processResponseForPrivateRollback(
      ApiResponse response, RollbackAgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineRollbackMemoryOperation.class);
  }

  AgentEngineRollbackMemoryOperation privateRollback(
      String name, String targetRevisionId, RollbackAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateRollback(name, targetRevisionId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateRollback(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateUpdate(
      String name, String fact, Map<String, String> scope, UpdateAgentEngineMemoryConfig config) {

    UpdateAgentEngineMemoryRequestParameters.Builder parameterBuilder =
        UpdateAgentEngineMemoryRequestParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(fact)) {
      parameterBuilder.fact(fact);
    }
    if (!Common.isZero(scope)) {
      parameterBuilder.scope(scope);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = updateAgentEngineMemoryRequestParametersToVertex(parameterNode, null);
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
  AgentEngineMemoryOperation processResponseForPrivateUpdate(
      ApiResponse response, UpdateAgentEngineMemoryConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, AgentEngineMemoryOperation.class);
  }

  AgentEngineMemoryOperation privateUpdate(
      String name, String fact, Map<String, String> scope, UpdateAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateUpdate(name, fact, scope, config);

    try (ApiResponse response =
        this.apiClient.request(
            "patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateUpdate(response, config);
    }
  }
}
