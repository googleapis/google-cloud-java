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

import com.google.cloud.vertexai.genai.types.AgentEngineGenerateMemoriesOperation;
import com.google.cloud.vertexai.genai.types.AgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.AgentEngineMemoryOperation;
import com.google.cloud.vertexai.genai.types.AgentEngineRollbackMemoryOperation;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineMemoryOperation;
import com.google.cloud.vertexai.genai.types.GenerateAgentEngineMemoriesConfig;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestDirectContentsSource;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestDirectMemoriesSource;
import com.google.cloud.vertexai.genai.types.GenerateMemoriesRequestVertexSessionSource;
import com.google.cloud.vertexai.genai.types.GetAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.ListReasoningEnginesMemoriesResponse;
import com.google.cloud.vertexai.genai.types.Memory;
import com.google.cloud.vertexai.genai.types.RetrieveAgentEngineMemoriesConfig;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesRequestSimilaritySearchParams;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesRequestSimpleRetrievalParams;
import com.google.cloud.vertexai.genai.types.RetrieveMemoriesResponse;
import com.google.cloud.vertexai.genai.types.RollbackAgentEngineMemoryConfig;
import com.google.cloud.vertexai.genai.types.UpdateAgentEngineMemoryConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Memories} */
public final class AsyncMemories {

  Memories memories;
  ApiClient apiClient;

  public AsyncMemories(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.memories = new Memories(apiClient);
  }

  CompletableFuture<AgentEngineMemoryOperation> privateCreate(
      String name, String fact, Map<String, String> scope, AgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = memories.buildRequestForPrivateCreate(name, fact, scope, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateCreate(res, config);
              }
            });
  }

  public CompletableFuture<DeleteAgentEngineMemoryOperation> delete(
      String name, DeleteAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = memories.buildRequestForDelete(name, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForDelete(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineGenerateMemoriesOperation> privateGenerate(
      String name,
      GenerateMemoriesRequestVertexSessionSource vertexSessionSource,
      GenerateMemoriesRequestDirectContentsSource directContentsSource,
      GenerateMemoriesRequestDirectMemoriesSource directMemoriesSource,
      Map<String, String> scope,
      GenerateAgentEngineMemoriesConfig config) {
    BuiltRequest builtRequest =
        memories.buildRequestForPrivateGenerate(
            name, vertexSessionSource, directContentsSource, directMemoriesSource, scope, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateGenerate(res, config);
              }
            });
  }

  public CompletableFuture<Memory> get(String name, GetAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = memories.buildRequestForGet(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForGet(res, config);
              }
            });
  }

  CompletableFuture<ListReasoningEnginesMemoriesResponse> privateList(
      String name, ListAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = memories.buildRequestForPrivateList(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateList(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineMemoryOperation> privateGetMemoryOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        memories.buildRequestForPrivateGetMemoryOperation(operationName, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateGetMemoryOperation(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineGenerateMemoriesOperation> privateGetGenerateMemoriesOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        memories.buildRequestForPrivateGetGenerateMemoriesOperation(operationName, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateGetGenerateMemoriesOperation(res, config);
              }
            });
  }

  CompletableFuture<RetrieveMemoriesResponse> privateRetrieve(
      String name,
      Map<String, String> scope,
      RetrieveMemoriesRequestSimilaritySearchParams similaritySearchParams,
      RetrieveMemoriesRequestSimpleRetrievalParams simpleRetrievalParams,
      RetrieveAgentEngineMemoriesConfig config) {
    BuiltRequest builtRequest =
        memories.buildRequestForPrivateRetrieve(
            name, scope, similaritySearchParams, simpleRetrievalParams, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateRetrieve(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineRollbackMemoryOperation> privateRollback(
      String name, String targetRevisionId, RollbackAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest =
        memories.buildRequestForPrivateRollback(name, targetRevisionId, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateRollback(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineMemoryOperation> privateUpdate(
      String name, String fact, Map<String, String> scope, UpdateAgentEngineMemoryConfig config) {
    BuiltRequest builtRequest = memories.buildRequestForPrivateUpdate(name, fact, scope, config);
    return this.apiClient
        .asyncRequest("patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return memories.processResponseForPrivateUpdate(res, config);
              }
            });
  }
}
