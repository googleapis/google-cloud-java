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

import com.google.cloud.vertexai.genai.types.AssembleDatasetConfig;
import com.google.cloud.vertexai.genai.types.CreateMultimodalDatasetConfig;
import com.google.cloud.vertexai.genai.types.GeminiRequestReadConfig;
import com.google.cloud.vertexai.genai.types.GetMultimodalDatasetOperationConfig;
import com.google.cloud.vertexai.genai.types.ListMultimodalDatasetsConfig;
import com.google.cloud.vertexai.genai.types.ListMultimodalDatasetsResponse;
import com.google.cloud.vertexai.genai.types.MultimodalDataset;
import com.google.cloud.vertexai.genai.types.MultimodalDatasetOperation;
import com.google.cloud.vertexai.genai.types.SchemaTablesDatasetMetadata;
import com.google.cloud.vertexai.genai.types.UpdateMultimodalDatasetConfig;
import com.google.cloud.vertexai.genai.types.VertexBaseConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.types.EncryptionSpec;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Datasets} */
public final class AsyncDatasets {

  Datasets datasets;
  ApiClient apiClient;

  public AsyncDatasets(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.datasets = new Datasets(apiClient);
  }

  CompletableFuture<MultimodalDatasetOperation> privateAssembleMultimodalDataset(
      String name, GeminiRequestReadConfig geminiRequestReadConfig, AssembleDatasetConfig config) {
    BuiltRequest builtRequest =
        datasets.buildRequestForPrivateAssembleMultimodalDataset(
            name, geminiRequestReadConfig, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateAssembleMultimodalDataset(res, config);
              }
            });
  }

  CompletableFuture<MultimodalDatasetOperation> privateCreateMultimodalDataset(
      String name,
      String displayName,
      String metadataSchemaUri,
      SchemaTablesDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      CreateMultimodalDatasetConfig config) {
    BuiltRequest builtRequest =
        datasets.buildRequestForPrivateCreateMultimodalDataset(
            name, displayName, metadataSchemaUri, metadata, description, encryptionSpec, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateCreateMultimodalDataset(res, config);
              }
            });
  }

  CompletableFuture<MultimodalDatasetOperation> privateDeleteMultimodalDataset(
      String name, VertexBaseConfig config) {
    BuiltRequest builtRequest =
        datasets.buildRequestForPrivateDeleteMultimodalDataset(name, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateDeleteMultimodalDataset(res, config);
              }
            });
  }

  CompletableFuture<MultimodalDataset> privateGetMultimodalDataset(
      String name, VertexBaseConfig config) {
    BuiltRequest builtRequest = datasets.buildRequestForPrivateGetMultimodalDataset(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateGetMultimodalDataset(res, config);
              }
            });
  }

  CompletableFuture<MultimodalDatasetOperation> privateGetMultimodalDatasetOperation(
      String datasetId, String operationId, GetMultimodalDatasetOperationConfig config) {
    BuiltRequest builtRequest =
        datasets.buildRequestForPrivateGetMultimodalDatasetOperation(
            datasetId, operationId, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateGetMultimodalDatasetOperation(res, config);
              }
            });
  }

  CompletableFuture<ListMultimodalDatasetsResponse> privateListMultimodalDatasets(
      ListMultimodalDatasetsConfig config) {
    BuiltRequest builtRequest = datasets.buildRequestForPrivateListMultimodalDatasets(config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateListMultimodalDatasets(res, config);
              }
            });
  }

  CompletableFuture<MultimodalDataset> privateUpdateMultimodalDataset(
      String name,
      String displayName,
      SchemaTablesDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      UpdateMultimodalDatasetConfig config) {
    BuiltRequest builtRequest =
        datasets.buildRequestForPrivateUpdateMultimodalDataset(
            name, displayName, metadata, description, encryptionSpec, config);
    return this.apiClient
        .asyncRequest("patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return datasets.processResponseForPrivateUpdateMultimodalDataset(res, config);
              }
            });
  }
}
