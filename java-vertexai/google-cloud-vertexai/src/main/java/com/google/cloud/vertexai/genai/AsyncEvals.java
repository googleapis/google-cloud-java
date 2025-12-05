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

import com.google.cloud.vertexai.genai.types.BleuInput;
import com.google.cloud.vertexai.genai.types.CreateEvaluationItemConfig;
import com.google.cloud.vertexai.genai.types.CreateEvaluationSetConfig;
import com.google.cloud.vertexai.genai.types.EvaluateInstancesConfig;
import com.google.cloud.vertexai.genai.types.EvaluateInstancesResponse;
import com.google.cloud.vertexai.genai.types.EvaluationInstance;
import com.google.cloud.vertexai.genai.types.EvaluationItem;
import com.google.cloud.vertexai.genai.types.EvaluationRun;
import com.google.cloud.vertexai.genai.types.EvaluationSet;
import com.google.cloud.vertexai.genai.types.ExactMatchInput;
import com.google.cloud.vertexai.genai.types.GenerateInstanceRubricsResponse;
import com.google.cloud.vertexai.genai.types.GetEvaluationItemConfig;
import com.google.cloud.vertexai.genai.types.GetEvaluationRunConfig;
import com.google.cloud.vertexai.genai.types.GetEvaluationSetConfig;
import com.google.cloud.vertexai.genai.types.Metric;
import com.google.cloud.vertexai.genai.types.PairwiseMetricInput;
import com.google.cloud.vertexai.genai.types.PointwiseMetricInput;
import com.google.cloud.vertexai.genai.types.PredefinedMetricSpec;
import com.google.cloud.vertexai.genai.types.RougeInput;
import com.google.cloud.vertexai.genai.types.RubricBasedMetricInput;
import com.google.cloud.vertexai.genai.types.RubricGenerationConfig;
import com.google.cloud.vertexai.genai.types.RubricGenerationSpec;
import com.google.cloud.vertexai.genai.types.ToolCallValidInput;
import com.google.cloud.vertexai.genai.types.ToolNameMatchInput;
import com.google.cloud.vertexai.genai.types.ToolParameterKVMatchInput;
import com.google.cloud.vertexai.genai.types.ToolParameterKeyMatchInput;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.types.AutoraterConfig;
import com.google.genai.types.Content;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Evals} */
public final class AsyncEvals {

  Evals evals;
  ApiClient apiClient;

  public AsyncEvals(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.evals = new Evals(apiClient);
  }

  CompletableFuture<EvaluationItem> privateCreateEvaluationItem(
      String evaluationItemType,
      String gcsUri,
      String displayName,
      CreateEvaluationItemConfig config) {
    BuiltRequest builtRequest =
        evals.buildRequestForPrivateCreateEvaluationItem(
            evaluationItemType, gcsUri, displayName, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateCreateEvaluationItem(res, config);
              }
            });
  }

  CompletableFuture<EvaluationSet> privateCreateEvaluationSet(
      List<String> evaluationItems, String displayName, CreateEvaluationSetConfig config) {
    BuiltRequest builtRequest =
        evals.buildRequestForPrivateCreateEvaluationSet(evaluationItems, displayName, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateCreateEvaluationSet(res, config);
              }
            });
  }

  public CompletableFuture<EvaluateInstancesResponse> EvaluateInstances(
      BleuInput bleuInput,
      ExactMatchInput exactMatchInput,
      RougeInput rougeInput,
      PointwiseMetricInput pointwiseMetricInput,
      PairwiseMetricInput pairwiseMetricInput,
      ToolCallValidInput toolCallValidInput,
      ToolNameMatchInput toolNameMatchInput,
      ToolParameterKeyMatchInput toolParameterKeyMatchInput,
      ToolParameterKVMatchInput toolParameterKvMatchInput,
      RubricBasedMetricInput rubricBasedMetricInput,
      AutoraterConfig autoraterConfig,
      List<Metric> metrics,
      EvaluationInstance instance,
      EvaluateInstancesConfig config) {
    BuiltRequest builtRequest =
        evals.buildRequestForEvaluateInstances(
            bleuInput,
            exactMatchInput,
            rougeInput,
            pointwiseMetricInput,
            pairwiseMetricInput,
            toolCallValidInput,
            toolNameMatchInput,
            toolParameterKeyMatchInput,
            toolParameterKvMatchInput,
            rubricBasedMetricInput,
            autoraterConfig,
            metrics,
            instance,
            config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForEvaluateInstances(res, config);
              }
            });
  }

  CompletableFuture<GenerateInstanceRubricsResponse> privateGenerateRubrics(
      List<Content> contents,
      PredefinedMetricSpec predefinedRubricGenerationSpec,
      RubricGenerationSpec rubricGenerationSpec,
      RubricGenerationConfig config) {
    BuiltRequest builtRequest =
        evals.buildRequestForPrivateGenerateRubrics(
            contents, predefinedRubricGenerationSpec, rubricGenerationSpec, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateGenerateRubrics(res, config);
              }
            });
  }

  CompletableFuture<EvaluationRun> privateGetEvaluationRun(
      String name, GetEvaluationRunConfig config) {
    BuiltRequest builtRequest = evals.buildRequestForPrivateGetEvaluationRun(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateGetEvaluationRun(res, config);
              }
            });
  }

  CompletableFuture<EvaluationSet> privateGetEvaluationSet(
      String name, GetEvaluationSetConfig config) {
    BuiltRequest builtRequest = evals.buildRequestForPrivateGetEvaluationSet(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateGetEvaluationSet(res, config);
              }
            });
  }

  CompletableFuture<EvaluationItem> privateGetEvaluationItem(
      String name, GetEvaluationItemConfig config) {
    BuiltRequest builtRequest = evals.buildRequestForPrivateGetEvaluationItem(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return evals.processResponseForPrivateGetEvaluationItem(res, config);
              }
            });
  }
}
