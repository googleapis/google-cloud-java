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

import com.google.cloud.vertexai.genai.types.AgentEngineSandboxOperation;
import com.google.cloud.vertexai.genai.types.Chunk;
import com.google.cloud.vertexai.genai.types.CreateAgentEngineSandboxConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineSandboxConfig;
import com.google.cloud.vertexai.genai.types.DeleteAgentEngineSandboxOperation;
import com.google.cloud.vertexai.genai.types.ExecuteCodeAgentEngineSandboxConfig;
import com.google.cloud.vertexai.genai.types.ExecuteSandboxEnvironmentResponse;
import com.google.cloud.vertexai.genai.types.GetAgentEngineOperationConfig;
import com.google.cloud.vertexai.genai.types.GetAgentEngineSandboxConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineSandboxesConfig;
import com.google.cloud.vertexai.genai.types.ListAgentEngineSandboxesResponse;
import com.google.cloud.vertexai.genai.types.SandboxEnvironment;
import com.google.cloud.vertexai.genai.types.SandboxEnvironmentSpec;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Sandboxes} */
public final class AsyncSandboxes {

  Sandboxes sandboxes;
  ApiClient apiClient;

  public AsyncSandboxes(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.sandboxes = new Sandboxes(apiClient);
  }

  CompletableFuture<AgentEngineSandboxOperation> privateCreate(
      String name, SandboxEnvironmentSpec spec, CreateAgentEngineSandboxConfig config) {
    BuiltRequest builtRequest = sandboxes.buildRequestForPrivateCreate(name, spec, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateCreate(res, config);
              }
            });
  }

  CompletableFuture<DeleteAgentEngineSandboxOperation> privateDelete(
      String name, DeleteAgentEngineSandboxConfig config) {
    BuiltRequest builtRequest = sandboxes.buildRequestForPrivateDelete(name, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateDelete(res, config);
              }
            });
  }

  CompletableFuture<ExecuteSandboxEnvironmentResponse> privateExecuteCode(
      String name, List<Chunk> inputs, ExecuteCodeAgentEngineSandboxConfig config) {
    BuiltRequest builtRequest = sandboxes.buildRequestForPrivateExecuteCode(name, inputs, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateExecuteCode(res, config);
              }
            });
  }

  CompletableFuture<SandboxEnvironment> privateGet(
      String name, GetAgentEngineSandboxConfig config) {
    BuiltRequest builtRequest = sandboxes.buildRequestForPrivateGet(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateGet(res, config);
              }
            });
  }

  CompletableFuture<ListAgentEngineSandboxesResponse> privateList(
      String name, ListAgentEngineSandboxesConfig config) {
    BuiltRequest builtRequest = sandboxes.buildRequestForPrivateList(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateList(res, config);
              }
            });
  }

  CompletableFuture<AgentEngineSandboxOperation> privateGetSandboxOperation(
      String operationName, GetAgentEngineOperationConfig config) {
    BuiltRequest builtRequest =
        sandboxes.buildRequestForPrivateGetSandboxOperation(operationName, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return sandboxes.processResponseForPrivateGetSandboxOperation(res, config);
              }
            });
  }
}
