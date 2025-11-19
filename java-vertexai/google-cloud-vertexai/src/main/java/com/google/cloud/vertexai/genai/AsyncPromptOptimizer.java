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

import com.google.cloud.vertexai.genai.types.CustomJob;
import com.google.cloud.vertexai.genai.types.OptimizeConfig;
import com.google.cloud.vertexai.genai.types.OptimizeResponseEndpoint;
import com.google.cloud.vertexai.genai.types.VertexBaseConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.types.Content;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link PromptOptimizer} */
public final class AsyncPromptOptimizer {

  PromptOptimizer promptOptimizer;
  ApiClient apiClient;

  public AsyncPromptOptimizer(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.promptOptimizer = new PromptOptimizer(apiClient);
  }

  CompletableFuture<OptimizeResponseEndpoint> privateOptimizePrompt(
      Content content, OptimizeConfig config) {
    BuiltRequest builtRequest =
        promptOptimizer.buildRequestForPrivateOptimizePrompt(content, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return promptOptimizer.processResponseForPrivateOptimizePrompt(res, config);
              }
            });
  }

  CompletableFuture<CustomJob> privateCreateCustomJobResource(
      CustomJob customJob, VertexBaseConfig config) {
    BuiltRequest builtRequest =
        promptOptimizer.buildRequestForPrivateCreateCustomJobResource(customJob, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return promptOptimizer.processResponseForPrivateCreateCustomJobResource(
                    res, config);
              }
            });
  }

  CompletableFuture<CustomJob> privateGetCustomJob(String name, VertexBaseConfig config) {
    BuiltRequest builtRequest = promptOptimizer.buildRequestForPrivateGetCustomJob(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return promptOptimizer.processResponseForPrivateGetCustomJob(res, config);
              }
            });
  }
}
