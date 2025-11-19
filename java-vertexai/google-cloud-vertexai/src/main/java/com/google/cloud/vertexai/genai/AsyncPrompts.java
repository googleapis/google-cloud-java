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

import com.google.cloud.vertexai.genai.types.CreateDatasetConfig;
import com.google.cloud.vertexai.genai.types.CreateDatasetVersionConfig;
import com.google.cloud.vertexai.genai.types.Dataset;
import com.google.cloud.vertexai.genai.types.DatasetOperation;
import com.google.cloud.vertexai.genai.types.DatasetVersion;
import com.google.cloud.vertexai.genai.types.DeletePromptConfig;
import com.google.cloud.vertexai.genai.types.DeletePromptOperation;
import com.google.cloud.vertexai.genai.types.DeletePromptVersionOperation;
import com.google.cloud.vertexai.genai.types.GetDatasetOperationConfig;
import com.google.cloud.vertexai.genai.types.ListDatasetVersionsResponse;
import com.google.cloud.vertexai.genai.types.ListDatasetsResponse;
import com.google.cloud.vertexai.genai.types.ListPromptsConfig;
import com.google.cloud.vertexai.genai.types.RestoreVersionConfig;
import com.google.cloud.vertexai.genai.types.RestoreVersionOperation;
import com.google.cloud.vertexai.genai.types.SchemaTextPromptDatasetMetadata;
import com.google.cloud.vertexai.genai.types.UpdateDatasetConfig;
import com.google.cloud.vertexai.genai.types.VertexBaseConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.types.EncryptionSpec;
import java.util.concurrent.CompletableFuture;

/** Async module of {@link Prompts} */
public final class AsyncPrompts {

  Prompts prompts;
  ApiClient apiClient;

  public AsyncPrompts(ApiClient apiClient) {
    this.apiClient = apiClient;
    this.prompts = new Prompts(apiClient);
  }

  CompletableFuture<DatasetOperation> privateCreateDatasetResource(
      String name,
      String displayName,
      String metadataSchemaUri,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      CreateDatasetConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateCreateDatasetResource(
            name,
            displayName,
            metadataSchemaUri,
            metadata,
            description,
            encryptionSpec,
            modelReference,
            config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateCreateDatasetResource(res, config);
              }
            });
  }

  CompletableFuture<DatasetOperation> privateCreateDatasetVersionResource(
      String datasetName,
      SchemaTextPromptDatasetMetadata metadata,
      String modelReference,
      String parent,
      String displayName,
      CreateDatasetVersionConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateCreateDatasetVersionResource(
            datasetName, metadata, modelReference, parent, displayName, config);
    return this.apiClient
        .asyncRequest("post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateCreateDatasetVersionResource(res, config);
              }
            });
  }

  CompletableFuture<Dataset> privateGetDatasetResource(String name, VertexBaseConfig config) {
    BuiltRequest builtRequest = prompts.buildRequestForPrivateGetDatasetResource(name, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateGetDatasetResource(res, config);
              }
            });
  }

  CompletableFuture<DatasetVersion> privateGetDatasetVersionResource(
      String datasetId, String datasetVersionId, VertexBaseConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateGetDatasetVersionResource(
            datasetId, datasetVersionId, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateGetDatasetVersionResource(res, config);
              }
            });
  }

  CompletableFuture<DatasetOperation> privateGetDatasetOperation(
      String datasetId, String operationId, GetDatasetOperationConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateGetDatasetOperation(datasetId, operationId, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateGetDatasetOperation(res, config);
              }
            });
  }

  CompletableFuture<ListDatasetsResponse> privateListPrompts(ListPromptsConfig config) {
    BuiltRequest builtRequest = prompts.buildRequestForPrivateListPrompts(config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateListPrompts(res, config);
              }
            });
  }

  CompletableFuture<ListDatasetVersionsResponse> privateListVersions(
      String readMask, String datasetId, ListPromptsConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateListVersions(readMask, datasetId, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateListVersions(res, config);
              }
            });
  }

  CompletableFuture<DeletePromptOperation> privateDeleteDataset(
      String promptId, DeletePromptConfig config) {
    BuiltRequest builtRequest = prompts.buildRequestForPrivateDeleteDataset(promptId, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateDeleteDataset(res, config);
              }
            });
  }

  CompletableFuture<DeletePromptVersionOperation> privateDeleteDatasetVersion(
      String promptId, String versionId, DeletePromptConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateDeleteDatasetVersion(promptId, versionId, config);
    return this.apiClient
        .asyncRequest(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateDeleteDatasetVersion(res, config);
              }
            });
  }

  CompletableFuture<RestoreVersionOperation> privateRestoreVersion(
      String datasetId, String versionId, RestoreVersionConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateRestoreVersion(datasetId, versionId, config);
    return this.apiClient
        .asyncRequest("get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateRestoreVersion(res, config);
              }
            });
  }

  CompletableFuture<Dataset> privateUpdateDatasetResource(
      String name,
      String datasetId,
      String displayName,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      UpdateDatasetConfig config) {
    BuiltRequest builtRequest =
        prompts.buildRequestForPrivateUpdateDatasetResource(
            name,
            datasetId,
            displayName,
            metadata,
            description,
            encryptionSpec,
            modelReference,
            config);
    return this.apiClient
        .asyncRequest("patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())
        .thenApplyAsync(
            response -> {
              try (ApiResponse res = response) {
                return prompts.processResponseForPrivateUpdateDatasetResource(res, config);
              }
            });
  }
}
