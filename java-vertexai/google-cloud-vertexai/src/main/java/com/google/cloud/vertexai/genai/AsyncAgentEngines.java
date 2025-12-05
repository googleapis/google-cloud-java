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

import com.google.cloud.vertexai.genai.types.AgentEngineOperation;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineOperation;
import com.google.cloud.vertexai.genai.types.GetAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.ListReasoningEnginesResponse;
import com.google.cloud.vertexai.genai.types.QueryAgentEngineConfig;
import com.google.cloud.vertexai.genai.types.QueryReasoningEngineResponse;
import com.google.cloud.vertexai.genai.types.ReasoningEngine;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link AgentEngines} */
public final class AsyncAgentEngines {

  AgentEngines agentEngines;
  ApiClient apiClient;

  public AsyncAgentEngines(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.agentEngines = new AgentEngines(apiClient);
  }

  CompletableFuture<AgentEngineOperation> privateCreate(CreateAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateCreate(config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateCreate(res, config);
              }
            });
  }

  CompletableFuture<DeleteAgentEngineOperation> privateDelete(
      String name, boolean force, DeleteAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateDelete(name, force, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateDelete(res, config);
              }
            });
  }

  CompletableFuture<ReasoningEngine> privateGet(String name, GetAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateGet(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateGet(res, config);
              }
            });
  }

  CompletableFuture<ListReasoningEnginesResponse> privateList(ListAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateList(config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateList(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineOperation> privateGetAgentOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        agentEngines.buildRequestForPrivateGetAgentOperation(operationName, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateGetAgentOperation(res, config);
              }
            });
  }

  CompletableFuture<QueryReasoningEngineResponse> privateQuery(
      String name, QueryAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateQuery(name, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateQuery(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineOperation> privateUpdate(
      String name, UpdateAgentEngineConfig config) {
    BuiltRequest builtRequest = agentEngines.buildRequestForPrivateUpdate(name, config);
    return this.apiClient
        .asyncRequest("patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return agentEngines.processResponseForPrivateUpdate(res, config);
              }
            });
  }
}
