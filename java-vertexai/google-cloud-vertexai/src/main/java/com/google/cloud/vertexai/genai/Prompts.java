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
import com.google.cloud.vertexai.genai.types.CreateDatasetConfig;
import com.google.cloud.vertexai.genai.types.CreateDatasetParameters;
import com.google.cloud.vertexai.genai.types.CreateDatasetVersionConfig;
import com.google.cloud.vertexai.genai.types.CreateDatasetVersionParameters;
import com.google.cloud.vertexai.genai.types.Dataset;
import com.google.cloud.vertexai.genai.types.DatasetOperation;
import com.google.cloud.vertexai.genai.types.DatasetVersion;
import com.google.cloud.vertexai.genai.types.DeleteDatasetRequestParameters;
import com.google.cloud.vertexai.genai.types.DeletePromptConfig;
import com.google.cloud.vertexai.genai.types.DeletePromptOperation;
import com.google.cloud.vertexai.genai.types.DeletePromptVersionOperation;
import com.google.cloud.vertexai.genai.types.DeletePromptVersionRequestParameters;
import com.google.cloud.vertexai.genai.types.GetDatasetOperationConfig;
import com.google.cloud.vertexai.genai.types.GetDatasetOperationParameters;
import com.google.cloud.vertexai.genai.types.GetDatasetParameters;
import com.google.cloud.vertexai.genai.types.GetDatasetVersionParameters;
import com.google.cloud.vertexai.genai.types.ListDatasetVersionsRequestParameters;
import com.google.cloud.vertexai.genai.types.ListDatasetVersionsResponse;
import com.google.cloud.vertexai.genai.types.ListDatasetsRequestParameters;
import com.google.cloud.vertexai.genai.types.ListDatasetsResponse;
import com.google.cloud.vertexai.genai.types.ListPromptsConfig;
import com.google.cloud.vertexai.genai.types.RestoreVersionConfig;
import com.google.cloud.vertexai.genai.types.RestoreVersionOperation;
import com.google.cloud.vertexai.genai.types.RestoreVersionRequestParameters;
import com.google.cloud.vertexai.genai.types.SchemaTextPromptDatasetMetadata;
import com.google.cloud.vertexai.genai.types.UpdateDatasetConfig;
import com.google.cloud.vertexai.genai.types.UpdateDatasetParameters;
import com.google.cloud.vertexai.genai.types.VertexBaseConfig;
import com.google.genai.ApiClient;
import com.google.genai.ApiResponse;
import com.google.genai.Common;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.JsonSerializable;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.EncryptionSpec;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.Optional;
import okhttp3.ResponseBody;

public final class Prompts {

  final ApiClient apiClient;

  public Prompts(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode createDatasetParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metadataSchemaUri"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metadataSchemaUri"},
          Common.getValueByPath(fromObject, new String[] {"metadataSchemaUri"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metadata"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metadata"},
          Common.getValueByPath(fromObject, new String[] {"metadata"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"description"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"description"},
          Common.getValueByPath(fromObject, new String[] {"description"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"modelReference"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"modelReference"},
          Common.getValueByPath(fromObject, new String[] {"modelReference"}));
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
  ObjectNode createDatasetVersionParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"datasetName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "name"},
          Common.getValueByPath(fromObject, new String[] {"datasetName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metadata"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metadata"},
          Common.getValueByPath(fromObject, new String[] {"metadata"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"modelReference"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"modelReference"},
          Common.getValueByPath(fromObject, new String[] {"modelReference"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"parent"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"parent"},
          Common.getValueByPath(fromObject, new String[] {"parent"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
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
  ObjectNode deleteDatasetRequestParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"promptId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"promptId"}));
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
  ObjectNode deletePromptVersionRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"promptId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"promptId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"versionId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "version_id"},
          Common.getValueByPath(fromObject, new String[] {"versionId"}));
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
  ObjectNode getDatasetOperationParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"datasetId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"operationId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "operation_id"},
          Common.getValueByPath(fromObject, new String[] {"operationId"}));
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
  ObjectNode getDatasetParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode getDatasetVersionParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"datasetId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"datasetVersionId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_version_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetVersionId"}));
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
  ObjectNode listDatasetVersionsRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"readMask"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "read_mask"},
          Common.getValueByPath(fromObject, new String[] {"readMask"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"datasetId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          listPromptsConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode listDatasetsRequestParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          listPromptsConfigToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"config"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode listPromptsConfigToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode restoreVersionRequestParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"datasetId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"versionId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "version_id"},
          Common.getValueByPath(fromObject, new String[] {"versionId"}));
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
  ObjectNode updateDatasetParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"name"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"name"},
          Common.getValueByPath(fromObject, new String[] {"name"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"datasetId"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"_url", "dataset_id"},
          Common.getValueByPath(fromObject, new String[] {"datasetId"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"displayName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"displayName"},
          Common.getValueByPath(fromObject, new String[] {"displayName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metadata"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metadata"},
          Common.getValueByPath(fromObject, new String[] {"metadata"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"description"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"description"},
          Common.getValueByPath(fromObject, new String[] {"description"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"encryptionSpec"},
          Common.getValueByPath(fromObject, new String[] {"encryptionSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"modelReference"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"modelReference"},
          Common.getValueByPath(fromObject, new String[] {"modelReference"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"config"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"config"},
          Common.getValueByPath(fromObject, new String[] {"config"}));
    }

    return toObject;
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreateDatasetResource(
      String name,
      String displayName,
      String metadataSchemaUri,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      CreateDatasetConfig config) {

    CreateDatasetParameters.Builder parameterBuilder = CreateDatasetParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(displayName)) {
      parameterBuilder.displayName(displayName);
    }
    if (!Common.isZero(metadataSchemaUri)) {
      parameterBuilder.metadataSchemaUri(metadataSchemaUri);
    }
    if (!Common.isZero(metadata)) {
      parameterBuilder.metadata(metadata);
    }
    if (!Common.isZero(description)) {
      parameterBuilder.description(description);
    }
    if (!Common.isZero(encryptionSpec)) {
      parameterBuilder.encryptionSpec(encryptionSpec);
    }
    if (!Common.isZero(modelReference)) {
      parameterBuilder.modelReference(modelReference);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = createDatasetParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets", body.get("_url"));
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
  DatasetOperation processResponseForPrivateCreateDatasetResource(
      ApiResponse response, CreateDatasetConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DatasetOperation.class);
  }

  DatasetOperation privateCreateDatasetResource(
      String name,
      String displayName,
      String metadataSchemaUri,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      CreateDatasetConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateCreateDatasetResource(
            name,
            displayName,
            metadataSchemaUri,
            metadata,
            description,
            encryptionSpec,
            modelReference,
            config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreateDatasetResource(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreateDatasetVersionResource(
      String datasetName,
      SchemaTextPromptDatasetMetadata metadata,
      String modelReference,
      String parent,
      String displayName,
      CreateDatasetVersionConfig config) {

    CreateDatasetVersionParameters.Builder parameterBuilder =
        CreateDatasetVersionParameters.builder();

    if (!Common.isZero(datasetName)) {
      parameterBuilder.datasetName(datasetName);
    }
    if (!Common.isZero(metadata)) {
      parameterBuilder.metadata(metadata);
    }
    if (!Common.isZero(modelReference)) {
      parameterBuilder.modelReference(modelReference);
    }
    if (!Common.isZero(parent)) {
      parameterBuilder.parent(parent);
    }
    if (!Common.isZero(displayName)) {
      parameterBuilder.displayName(displayName);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = createDatasetVersionParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{name}/datasetVersions", body.get("_url"));
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
  DatasetOperation processResponseForPrivateCreateDatasetVersionResource(
      ApiResponse response, CreateDatasetVersionConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DatasetOperation.class);
  }

  DatasetOperation privateCreateDatasetVersionResource(
      String datasetName,
      SchemaTextPromptDatasetMetadata metadata,
      String modelReference,
      String parent,
      String displayName,
      CreateDatasetVersionConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateCreateDatasetVersionResource(
            datasetName, metadata, modelReference, parent, displayName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreateDatasetVersionResource(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetDatasetResource(String name, VertexBaseConfig config) {

    GetDatasetParameters.Builder parameterBuilder = GetDatasetParameters.builder();

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
      body = getDatasetParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{name}", body.get("_url"));
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
  Dataset processResponseForPrivateGetDatasetResource(
      ApiResponse response, VertexBaseConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, Dataset.class);
  }

  Dataset privateGetDatasetResource(String name, VertexBaseConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetDatasetResource(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetDatasetResource(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetDatasetVersionResource(
      String datasetId, String datasetVersionId, VertexBaseConfig config) {

    GetDatasetVersionParameters.Builder parameterBuilder = GetDatasetVersionParameters.builder();

    if (!Common.isZero(datasetId)) {
      parameterBuilder.datasetId(datasetId);
    }
    if (!Common.isZero(datasetVersionId)) {
      parameterBuilder.datasetVersionId(datasetVersionId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = getDatasetVersionParametersToVertex(parameterNode, null);
      path =
          Common.formatMap(
              "datasets/{dataset_id}/datasetVersions/{dataset_version_id}", body.get("_url"));
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
  DatasetVersion processResponseForPrivateGetDatasetVersionResource(
      ApiResponse response, VertexBaseConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DatasetVersion.class);
  }

  DatasetVersion privateGetDatasetVersionResource(
      String datasetId, String datasetVersionId, VertexBaseConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateGetDatasetVersionResource(datasetId, datasetVersionId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetDatasetVersionResource(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetDatasetOperation(
      String datasetId, String operationId, GetDatasetOperationConfig config) {

    GetDatasetOperationParameters.Builder parameterBuilder =
        GetDatasetOperationParameters.builder();

    if (!Common.isZero(datasetId)) {
      parameterBuilder.datasetId(datasetId);
    }
    if (!Common.isZero(operationId)) {
      parameterBuilder.operationId(operationId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = getDatasetOperationParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{dataset_id}/operations/{operation_id}", body.get("_url"));
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
  DatasetOperation processResponseForPrivateGetDatasetOperation(
      ApiResponse response, GetDatasetOperationConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DatasetOperation.class);
  }

  DatasetOperation privateGetDatasetOperation(
      String datasetId, String operationId, GetDatasetOperationConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateGetDatasetOperation(datasetId, operationId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetDatasetOperation(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateListPrompts(ListPromptsConfig config) {

    ListDatasetsRequestParameters.Builder parameterBuilder =
        ListDatasetsRequestParameters.builder();

    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = listDatasetsRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets", body.get("_url"));
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
  ListDatasetsResponse processResponseForPrivateListPrompts(
      ApiResponse response, ListPromptsConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, ListDatasetsResponse.class);
  }

  ListDatasetsResponse privateListPrompts(ListPromptsConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateListPrompts(config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateListPrompts(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateListVersions(
      String readMask, String datasetId, ListPromptsConfig config) {

    ListDatasetVersionsRequestParameters.Builder parameterBuilder =
        ListDatasetVersionsRequestParameters.builder();

    if (!Common.isZero(readMask)) {
      parameterBuilder.readMask(readMask);
    }
    if (!Common.isZero(datasetId)) {
      parameterBuilder.datasetId(datasetId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = listDatasetVersionsRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{dataset_id}/datasetVersions", body.get("_url"));
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
  ListDatasetVersionsResponse processResponseForPrivateListVersions(
      ApiResponse response, ListPromptsConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, ListDatasetVersionsResponse.class);
  }

  ListDatasetVersionsResponse privateListVersions(
      String readMask, String datasetId, ListPromptsConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateListVersions(readMask, datasetId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateListVersions(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateDeleteDataset(String promptId, DeletePromptConfig config) {

    DeleteDatasetRequestParameters.Builder parameterBuilder =
        DeleteDatasetRequestParameters.builder();

    if (!Common.isZero(promptId)) {
      parameterBuilder.promptId(promptId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = deleteDatasetRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{dataset_id}", body.get("_url"));
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
  DeletePromptOperation processResponseForPrivateDeleteDataset(
      ApiResponse response, DeletePromptConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DeletePromptOperation.class);
  }

  DeletePromptOperation privateDeleteDataset(String promptId, DeletePromptConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateDeleteDataset(promptId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateDeleteDataset(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateDeleteDatasetVersion(
      String promptId, String versionId, DeletePromptConfig config) {

    DeletePromptVersionRequestParameters.Builder parameterBuilder =
        DeletePromptVersionRequestParameters.builder();

    if (!Common.isZero(promptId)) {
      parameterBuilder.promptId(promptId);
    }
    if (!Common.isZero(versionId)) {
      parameterBuilder.versionId(versionId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = deletePromptVersionRequestParametersToVertex(parameterNode, null);
      path =
          Common.formatMap("datasets/{dataset_id}/datasetVersions/{version_id}", body.get("_url"));
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
  DeletePromptVersionOperation processResponseForPrivateDeleteDatasetVersion(
      ApiResponse response, DeletePromptConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, DeletePromptVersionOperation.class);
  }

  DeletePromptVersionOperation privateDeleteDatasetVersion(
      String promptId, String versionId, DeletePromptConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateDeleteDatasetVersion(promptId, versionId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "delete", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateDeleteDatasetVersion(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateRestoreVersion(
      String datasetId, String versionId, RestoreVersionConfig config) {

    RestoreVersionRequestParameters.Builder parameterBuilder =
        RestoreVersionRequestParameters.builder();

    if (!Common.isZero(datasetId)) {
      parameterBuilder.datasetId(datasetId);
    }
    if (!Common.isZero(versionId)) {
      parameterBuilder.versionId(versionId);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = restoreVersionRequestParametersToVertex(parameterNode, null);
      path =
          Common.formatMap(
              "datasets/{dataset_id}/datasetVersions/{version_id}:restore", body.get("_url"));
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
  RestoreVersionOperation processResponseForPrivateRestoreVersion(
      ApiResponse response, RestoreVersionConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, RestoreVersionOperation.class);
  }

  RestoreVersionOperation privateRestoreVersion(
      String datasetId, String versionId, RestoreVersionConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateRestoreVersion(datasetId, versionId, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateRestoreVersion(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateUpdateDatasetResource(
      String name,
      String datasetId,
      String displayName,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      UpdateDatasetConfig config) {

    UpdateDatasetParameters.Builder parameterBuilder = UpdateDatasetParameters.builder();

    if (!Common.isZero(name)) {
      parameterBuilder.name(name);
    }
    if (!Common.isZero(datasetId)) {
      parameterBuilder.datasetId(datasetId);
    }
    if (!Common.isZero(displayName)) {
      parameterBuilder.displayName(displayName);
    }
    if (!Common.isZero(metadata)) {
      parameterBuilder.metadata(metadata);
    }
    if (!Common.isZero(description)) {
      parameterBuilder.description(description);
    }
    if (!Common.isZero(encryptionSpec)) {
      parameterBuilder.encryptionSpec(encryptionSpec);
    }
    if (!Common.isZero(modelReference)) {
      parameterBuilder.modelReference(modelReference);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = updateDatasetParametersToVertex(parameterNode, null);
      path = Common.formatMap("datasets/{dataset_id}", body.get("_url"));
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
  Dataset processResponseForPrivateUpdateDatasetResource(
      ApiResponse response, UpdateDatasetConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, Dataset.class);
  }

  Dataset privateUpdateDatasetResource(
      String name,
      String datasetId,
      String displayName,
      SchemaTextPromptDatasetMetadata metadata,
      String description,
      EncryptionSpec encryptionSpec,
      String modelReference,
      UpdateDatasetConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateUpdateDatasetResource(
            name,
            datasetId,
            displayName,
            metadata,
            description,
            encryptionSpec,
            modelReference,
            config);

    try (ApiResponse response =
        this.apiClient.request(
            "patch", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateUpdateDatasetResource(response, config);
    }
  }
}
