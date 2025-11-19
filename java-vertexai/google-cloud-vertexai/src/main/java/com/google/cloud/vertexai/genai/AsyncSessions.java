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

import com.google.cloud.vertexai.genai.types.AgentEngineSessionOperation;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineSessionConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineSessionConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineSessionOperation;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineSessionConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineSessionsConfig;
import com.google.cloud.vertexai.genai.types.ListReasoningEnginesSessionsResponse;
import com.google.cloud.vertexai.genai.types.Session;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineSessionConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Sessions} */
public final class AsyncSessions {

  Sessions sessions;
  ApiClient apiClient;

  public AsyncSessions(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.sessions = new Sessions(apiClient);
  }

  CompletableFuture<AgentEngineSessionOperation> privateCreate(
      String name, String userId, CreateAgentEngineSessionConfig config) {
    BuiltRequest builtRequest = sessions.buildRequestForPrivateCreate(name, userId, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForPrivateCreate(res, config);
              }
            });
  }

  public CompletableFuture<DeleteAgentEngineSessionOperation> delete(
      String name, DeleteAgentEngineSessionConfig config) {
    BuiltRequest builtRequest = sessions.buildRequestForDelete(name, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForDelete(res, config);
              }
            });
  }

  public CompletableFuture<Session> get(String name, GetAgentEngineSessionConfig config) {
    BuiltRequest builtRequest = sessions.buildRequestForGet(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForGet(res, config);
              }
            });
  }

  CompletableFuture<ListReasoningEnginesSessionsResponse> privateList(
      String name, ListAgentEngineSessionsConfig config) {
    BuiltRequest builtRequest = sessions.buildRequestForPrivateList(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForPrivateList(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineSessionOperation> privateGetSessionOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        sessions.buildRequestForPrivateGetSessionOperation(operationName, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForPrivateGetSessionOperation(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineSessionOperation> privateUpdate(
      String name, UpdateAgentEngineSessionConfig config) {
    BuiltRequest builtRequest = sessions.buildRequestForPrivateUpdate(name, config);
    return this.apiClient
        .asyncRequest("patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sessions.processResponseForPrivateUpdate(res, config);
              }
            });
  }
}
