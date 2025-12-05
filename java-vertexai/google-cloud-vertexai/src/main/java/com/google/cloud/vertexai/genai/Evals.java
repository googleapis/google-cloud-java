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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.cloud.vertexai.genai.types.BleuInput;
import com.google.cloud.vertexai.genai.types.CreateEvaluationItemConfig;
import com.google.cloud.vertexai.genai.types.CreateEvaluationItemParameters;
import com.google.cloud.vertexai.genai.types.CreateEvaluationSetConfig;
import com.google.cloud.vertexai.genai.types.CreateEvaluationSetParameters;
import com.google.cloud.vertexai.genai.types.EvaluateInstancesConfig;
import com.google.cloud.vertexai.genai.types.EvaluateInstancesRequestParameters;
import com.google.cloud.vertexai.genai.types.EvaluateInstancesResponse;
import com.google.cloud.vertexai.genai.types.EvaluationInstance;
import com.google.cloud.vertexai.genai.types.EvaluationItem;
import com.google.cloud.vertexai.genai.types.EvaluationRun;
import com.google.cloud.vertexai.genai.types.EvaluationSet;
import com.google.cloud.vertexai.genai.types.ExactMatchInput;
import com.google.cloud.vertexai.genai.types.GenerateInstanceRubricsRequest;
import com.google.cloud.vertexai.genai.types.GenerateInstanceRubricsResponse;
import com.google.cloud.vertexai.genai.types.GetEvaluationItemConfig;
import com.google.cloud.vertexai.genai.types.GetEvaluationItemParameters;
import com.google.cloud.vertexai.genai.types.GetEvaluationRunConfig;
import com.google.cloud.vertexai.genai.types.GetEvaluationRunParameters;
import com.google.cloud.vertexai.genai.types.GetEvaluationSetConfig;
import com.google.cloud.vertexai.genai.types.GetEvaluationSetParameters;
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
import com.google.genai.Common;
import com.google.genai.Common.BuiltRequest;
import com.google.genai.JsonSerializable;
import com.google.genai.Transformers;
import com.google.genai.errors.GenAiIOException;
import com.google.genai.types.AutoraterConfig;
import com.google.genai.types.Content;
import com.google.genai.types.HttpOptions;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import okhttp3.ResponseBody;

public final class Evals {

  final ApiClient apiClient;

  public Evals(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode createEvaluationItemParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"evaluationItemType"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"evaluationItemType"},
          Common.getValueByPath(fromObject, new String[] {"evaluationItemType"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"gcsUri"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"gcsUri"},
          Common.getValueByPath(fromObject, new String[] {"gcsUri"}));
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
  ObjectNode createEvaluationSetParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"evaluationItems"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"evaluationItems"},
          Common.getValueByPath(fromObject, new String[] {"evaluationItems"}));
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
  ObjectNode evaluateInstancesRequestParametersToVertex(
      JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"bleuInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"bleuInput"},
          Common.getValueByPath(fromObject, new String[] {"bleuInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"exactMatchInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"exactMatchInput"},
          Common.getValueByPath(fromObject, new String[] {"exactMatchInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rougeInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rougeInput"},
          Common.getValueByPath(fromObject, new String[] {"rougeInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pointwiseMetricInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"pointwiseMetricInput"},
          Common.getValueByPath(fromObject, new String[] {"pointwiseMetricInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"pairwiseMetricInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"pairwiseMetricInput"},
          Common.getValueByPath(fromObject, new String[] {"pairwiseMetricInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"toolCallValidInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"toolCallValidInput"},
          Common.getValueByPath(fromObject, new String[] {"toolCallValidInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"toolNameMatchInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"toolNameMatchInput"},
          Common.getValueByPath(fromObject, new String[] {"toolNameMatchInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"toolParameterKeyMatchInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"toolParameterKeyMatchInput"},
          Common.getValueByPath(fromObject, new String[] {"toolParameterKeyMatchInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"toolParameterKvMatchInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"toolParameterKvMatchInput"},
          Common.getValueByPath(fromObject, new String[] {"toolParameterKvMatchInput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricBasedMetricInput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricBasedMetricInput"},
          rubricBasedMetricInputToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"rubricBasedMetricInput"})),
              toObject));
    }

    if (Common.getValueByPath(fromObject, new String[] {"autoraterConfig"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"autoraterConfig"},
          Common.getValueByPath(fromObject, new String[] {"autoraterConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metrics"}) != null) {
      ArrayNode keyArray =
          (ArrayNode)
              Transformers.tMetrics(Common.getValueByPath(fromObject, new String[] {"metrics"}));
      ObjectMapper objectMapper = new ObjectMapper();
      ArrayNode result = objectMapper.createArrayNode();

      for (JsonNode item : keyArray) {
        result.add(metricToVertex(JsonSerializable.toJsonNode(item), toObject));
      }
      Common.setValueByPath(toObject, new String[] {"metrics"}, result);
    }

    if (Common.getValueByPath(fromObject, new String[] {"instance"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"instance"},
          Common.getValueByPath(fromObject, new String[] {"instance"}));
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
  ObjectNode evaluationRunFromVertex(JsonNode fromObject, ObjectNode parentObject) {
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

    if (Common.getValueByPath(fromObject, new String[] {"metadata"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metadata"},
          Common.getValueByPath(fromObject, new String[] {"metadata"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"createTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"createTime"},
          Common.getValueByPath(fromObject, new String[] {"createTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"completionTime"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"completionTime"},
          Common.getValueByPath(fromObject, new String[] {"completionTime"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"state"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"state"},
          Common.getValueByPath(fromObject, new String[] {"state"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"evaluationSetSnapshot"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"evaluationSetSnapshot"},
          Common.getValueByPath(fromObject, new String[] {"evaluationSetSnapshot"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"error"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"error"},
          Common.getValueByPath(fromObject, new String[] {"error"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"dataSource"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"dataSource"},
          Common.getValueByPath(fromObject, new String[] {"dataSource"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"evaluationResults"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"evaluationRunResults"},
          Common.getValueByPath(fromObject, new String[] {"evaluationResults"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"evaluationConfig"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"evaluationConfig"},
          Common.getValueByPath(fromObject, new String[] {"evaluationConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"inferenceConfigs"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"inferenceConfigs"},
          Common.getValueByPath(fromObject, new String[] {"inferenceConfigs"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"labels"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"labels"},
          Common.getValueByPath(fromObject, new String[] {"labels"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode generateInstanceRubricsRequestToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"contents"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"contents"},
          Common.getValueByPath(fromObject, new String[] {"contents"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"predefinedRubricGenerationSpec"})
        != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"predefinedRubricGenerationSpec"},
          Common.getValueByPath(fromObject, new String[] {"predefinedRubricGenerationSpec"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricGenerationSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricGenerationSpec"},
          rubricGenerationSpecToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"rubricGenerationSpec"})),
              toObject));
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
  ObjectNode getEvaluationItemParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode getEvaluationRunParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode getEvaluationSetParametersToVertex(JsonNode fromObject, ObjectNode parentObject) {
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
  ObjectNode metricToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();

    if (Common.getValueByPath(fromObject, new String[] {"promptTemplate"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"pointwise_metric_spec", "metric_prompt_template"},
          Common.getValueByPath(fromObject, new String[] {"promptTemplate"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"judgeModel"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"autorater_config", "autorater_model"},
          Common.getValueByPath(fromObject, new String[] {"judgeModel"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"judgeModelGenerationConfig"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"autorater_config", "generation_config"},
          Common.getValueByPath(fromObject, new String[] {"judgeModelGenerationConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"judgeModelSamplingCount"}) != null) {
      Common.setValueByPath(
          parentObject,
          new String[] {"autorater_config", "sampling_count"},
          Common.getValueByPath(fromObject, new String[] {"judgeModelSamplingCount"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"judgeModelSystemInstruction"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"pointwise_metric_spec", "system_instruction"},
          Common.getValueByPath(fromObject, new String[] {"judgeModelSystemInstruction"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"returnRawOutput"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {
            "pointwise_metric_spec", "custom_output_format_config", "return_raw_output"
          },
          Common.getValueByPath(fromObject, new String[] {"returnRawOutput"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricGroupName"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricGroupName"},
          Common.getValueByPath(fromObject, new String[] {"rubricGroupName"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"metricSpecParameters"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metricSpecParameters"},
          Common.getValueByPath(fromObject, new String[] {"metricSpecParameters"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode rubricBasedMetricInputToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"metricSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metricSpec"},
          rubricBasedMetricSpecToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"metricSpec"})),
              toObject));
    }

    if (Common.getValueByPath(fromObject, new String[] {"instance"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"instance"},
          Common.getValueByPath(fromObject, new String[] {"instance"}));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode rubricBasedMetricSpecToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"metricPromptTemplate"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"metricPromptTemplate"},
          Common.getValueByPath(fromObject, new String[] {"metricPromptTemplate"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"judgeAutoraterConfig"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"judgeAutoraterConfig"},
          Common.getValueByPath(fromObject, new String[] {"judgeAutoraterConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"inlineRubrics"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"inline_rubrics", "rubrics"},
          Common.getValueByPath(fromObject, new String[] {"inlineRubrics"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricGroupKey"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricGroupKey"},
          Common.getValueByPath(fromObject, new String[] {"rubricGroupKey"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricGenerationSpec"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricGenerationSpec"},
          rubricGenerationSpecToVertex(
              JsonSerializable.toJsonNode(
                  Common.getValueByPath(fromObject, new String[] {"rubricGenerationSpec"})),
              toObject));
    }

    return toObject;
  }

  @ExcludeFromGeneratedCoverageReport
  ObjectNode rubricGenerationSpecToVertex(JsonNode fromObject, ObjectNode parentObject) {
    ObjectNode toObject = JsonSerializable.objectMapper().createObjectNode();
    if (Common.getValueByPath(fromObject, new String[] {"promptTemplate"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"promptTemplate"},
          Common.getValueByPath(fromObject, new String[] {"promptTemplate"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"generatorModelConfig"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"model_config"},
          Common.getValueByPath(fromObject, new String[] {"generatorModelConfig"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricContentType"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricContentType"},
          Common.getValueByPath(fromObject, new String[] {"rubricContentType"}));
    }

    if (Common.getValueByPath(fromObject, new String[] {"rubricTypeOntology"}) != null) {
      Common.setValueByPath(
          toObject,
          new String[] {"rubricTypeOntology"},
          Common.getValueByPath(fromObject, new String[] {"rubricTypeOntology"}));
    }

    return toObject;
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreateEvaluationItem(
      String evaluationItemType,
      String gcsUri,
      String displayName,
      CreateEvaluationItemConfig config) {

    CreateEvaluationItemParameters.Builder parameterBuilder =
        CreateEvaluationItemParameters.builder();

    if (!Common.isZero(evaluationItemType)) {
      parameterBuilder.evaluationItemType(evaluationItemType);
    }
    if (!Common.isZero(gcsUri)) {
      parameterBuilder.gcsUri(gcsUri);
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
      body = createEvaluationItemParametersToVertex(parameterNode, null);
      path = Common.formatMap("evaluationItems", body.get("_url"));
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
  EvaluationItem processResponseForPrivateCreateEvaluationItem(
      ApiResponse response, CreateEvaluationItemConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, EvaluationItem.class);
  }

  EvaluationItem privateCreateEvaluationItem(
      String evaluationItemType,
      String gcsUri,
      String displayName,
      CreateEvaluationItemConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateCreateEvaluationItem(evaluationItemType, gcsUri, displayName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreateEvaluationItem(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateCreateEvaluationSet(
      List<String> evaluationItems, String displayName, CreateEvaluationSetConfig config) {

    CreateEvaluationSetParameters.Builder parameterBuilder =
        CreateEvaluationSetParameters.builder();

    if (!Common.isZero(evaluationItems)) {
      parameterBuilder.evaluationItems(evaluationItems);
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
      body = createEvaluationSetParametersToVertex(parameterNode, null);
      path = Common.formatMap("evaluationSets", body.get("_url"));
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
  EvaluationSet processResponseForPrivateCreateEvaluationSet(
      ApiResponse response, CreateEvaluationSetConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, EvaluationSet.class);
  }

  EvaluationSet privateCreateEvaluationSet(
      List<String> evaluationItems, String displayName, CreateEvaluationSetConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateCreateEvaluationSet(evaluationItems, displayName, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateCreateEvaluationSet(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForEvaluateInstances(
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

    EvaluateInstancesRequestParameters.Builder parameterBuilder =
        EvaluateInstancesRequestParameters.builder();

    if (!Common.isZero(bleuInput)) {
      parameterBuilder.bleuInput(bleuInput);
    }
    if (!Common.isZero(exactMatchInput)) {
      parameterBuilder.exactMatchInput(exactMatchInput);
    }
    if (!Common.isZero(rougeInput)) {
      parameterBuilder.rougeInput(rougeInput);
    }
    if (!Common.isZero(pointwiseMetricInput)) {
      parameterBuilder.pointwiseMetricInput(pointwiseMetricInput);
    }
    if (!Common.isZero(pairwiseMetricInput)) {
      parameterBuilder.pairwiseMetricInput(pairwiseMetricInput);
    }
    if (!Common.isZero(toolCallValidInput)) {
      parameterBuilder.toolCallValidInput(toolCallValidInput);
    }
    if (!Common.isZero(toolNameMatchInput)) {
      parameterBuilder.toolNameMatchInput(toolNameMatchInput);
    }
    if (!Common.isZero(toolParameterKeyMatchInput)) {
      parameterBuilder.toolParameterKeyMatchInput(toolParameterKeyMatchInput);
    }
    if (!Common.isZero(toolParameterKvMatchInput)) {
      parameterBuilder.toolParameterKvMatchInput(toolParameterKvMatchInput);
    }
    if (!Common.isZero(rubricBasedMetricInput)) {
      parameterBuilder.rubricBasedMetricInput(rubricBasedMetricInput);
    }
    if (!Common.isZero(autoraterConfig)) {
      parameterBuilder.autoraterConfig(autoraterConfig);
    }
    if (!Common.isZero(metrics)) {
      parameterBuilder.metrics(metrics);
    }
    if (!Common.isZero(instance)) {
      parameterBuilder.instance(instance);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = evaluateInstancesRequestParametersToVertex(parameterNode, null);
      path = Common.formatMap(":evaluateInstances", body.get("_url"));
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
  EvaluateInstancesResponse processResponseForEvaluateInstances(
      ApiResponse response, EvaluateInstancesConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, EvaluateInstancesResponse.class);
  }

  public EvaluateInstancesResponse EvaluateInstances(
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
        buildRequestForEvaluateInstances(
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

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForEvaluateInstances(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGenerateRubrics(
      List<Content> contents,
      PredefinedMetricSpec predefinedRubricGenerationSpec,
      RubricGenerationSpec rubricGenerationSpec,
      RubricGenerationConfig config) {

    GenerateInstanceRubricsRequest.Builder parameterBuilder =
        GenerateInstanceRubricsRequest.builder();

    if (!Common.isZero(contents)) {
      parameterBuilder.contents(contents);
    }
    if (!Common.isZero(predefinedRubricGenerationSpec)) {
      parameterBuilder.predefinedRubricGenerationSpec(predefinedRubricGenerationSpec);
    }
    if (!Common.isZero(rubricGenerationSpec)) {
      parameterBuilder.rubricGenerationSpec(rubricGenerationSpec);
    }
    if (!Common.isZero(config)) {
      parameterBuilder.config(config);
    }
    JsonNode parameterNode = JsonSerializable.toJsonNode(parameterBuilder.build());

    ObjectNode body;
    String path;
    if (this.apiClient.vertexAI()) {
      body = generateInstanceRubricsRequestToVertex(parameterNode, null);
      path = Common.formatMap(":generateInstanceRubrics", body.get("_url"));
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
  GenerateInstanceRubricsResponse processResponseForPrivateGenerateRubrics(
      ApiResponse response, RubricGenerationConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, GenerateInstanceRubricsResponse.class);
  }

  GenerateInstanceRubricsResponse privateGenerateRubrics(
      List<Content> contents,
      PredefinedMetricSpec predefinedRubricGenerationSpec,
      RubricGenerationSpec rubricGenerationSpec,
      RubricGenerationConfig config) {
    BuiltRequest builtRequest =
        buildRequestForPrivateGenerateRubrics(
            contents, predefinedRubricGenerationSpec, rubricGenerationSpec, config);

    try (ApiResponse response =
        this.apiClient.request(
            "post", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGenerateRubrics(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetEvaluationRun(String name, GetEvaluationRunConfig config) {

    GetEvaluationRunParameters.Builder parameterBuilder = GetEvaluationRunParameters.builder();

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
      body = getEvaluationRunParametersToVertex(parameterNode, null);
      path = Common.formatMap("evaluationRuns/{name}", body.get("_url"));
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
  EvaluationRun processResponseForPrivateGetEvaluationRun(
      ApiResponse response, GetEvaluationRunConfig config) {
    ResponseBody responseBody = response.getBody();
    String responseString;
    try {
      responseString = responseBody.string();
    } catch (IOException e) {
      throw new GenAiIOException("Failed to read HTTP response.", e);
    }

    JsonNode responseNode = JsonSerializable.stringToJsonNode(responseString);

    if (this.apiClient.vertexAI()) {
      responseNode = evaluationRunFromVertex(responseNode, null);
    }

    if (!this.apiClient.vertexAI()) {
      throw new UnsupportedOperationException(
          "This method is only supported in the Vertex AI client.");
    }

    return JsonSerializable.fromJsonNode(responseNode, EvaluationRun.class);
  }

  EvaluationRun privateGetEvaluationRun(String name, GetEvaluationRunConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetEvaluationRun(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetEvaluationRun(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetEvaluationSet(String name, GetEvaluationSetConfig config) {

    GetEvaluationSetParameters.Builder parameterBuilder = GetEvaluationSetParameters.builder();

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
      body = getEvaluationSetParametersToVertex(parameterNode, null);
      path = Common.formatMap("evaluationSets/{name}", body.get("_url"));
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
  EvaluationSet processResponseForPrivateGetEvaluationSet(
      ApiResponse response, GetEvaluationSetConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, EvaluationSet.class);
  }

  EvaluationSet privateGetEvaluationSet(String name, GetEvaluationSetConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetEvaluationSet(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetEvaluationSet(response, config);
    }
  }

  /** A shared buildRequest method for both sync and async methods. */
  BuiltRequest buildRequestForPrivateGetEvaluationItem(
      String name, GetEvaluationItemConfig config) {

    GetEvaluationItemParameters.Builder parameterBuilder = GetEvaluationItemParameters.builder();

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
      body = getEvaluationItemParametersToVertex(parameterNode, null);
      path = Common.formatMap("evaluationItems/{name}", body.get("_url"));
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
  EvaluationItem processResponseForPrivateGetEvaluationItem(
      ApiResponse response, GetEvaluationItemConfig config) {
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

    return JsonSerializable.fromJsonNode(responseNode, EvaluationItem.class);
  }

  EvaluationItem privateGetEvaluationItem(String name, GetEvaluationItemConfig config) {
    BuiltRequest builtRequest = buildRequestForPrivateGetEvaluationItem(name, config);

    try (ApiResponse response =
        this.apiClient.request(
            "get", builtRequest.path(), builtRequest.body(), builtRequest.httpOptions())) {
      return processResponseForPrivateGetEvaluationItem(response, config);
    }
  }

  private static final Logger logger = Logger.getLogger(Evals.class.getName());

  /**
   * Creates an evaluation item.
   *
   * @param evaluationItemType The type of the evaluation item.
   * @param gcsUri The GCS URI of the evaluation item.
   * @param displayName The display name of the evaluation item.
   * @param config The configuration for creating the evaluation item.
   * @return The created evaluation item.
   * @throws IOException If an error occurs during the request.
   */
  public EvaluationItem createEvaluationItem(
      String evaluationItemType,
      String gcsUri,
      String displayName,
      CreateEvaluationItemConfig config) {
    return privateCreateEvaluationItem(evaluationItemType, gcsUri, displayName, config);
  }
}
