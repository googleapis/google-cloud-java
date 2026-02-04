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

package com.google.cloud.vertexai.genai.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.genai.JsonSerializable;
import java.util.Optional;

/** Specificies a metric that is computed by running user-defined Python functions remotely. */
@AutoValue
@JsonDeserialize(builder = CustomCodeExecutionSpec.Builder.class)
public abstract class CustomCodeExecutionSpec extends JsonSerializable {
  /**
   * A string representing a user-defined function for evaluation. Expected user to define the
   * following function, e.g.: def evaluate(instance: dict[str, Any]) -> float: Please include this
   * function signature in the code snippet. Instance is the evaluation instance, any fields
   * populated in the instance are available to the function as instance[field_name].
   */
  @JsonProperty("remoteCustomFunction")
  public abstract Optional<String> remoteCustomFunction();

  /**
   * Required. Python function. Expected user to define the following function, e.g.: def
   * evaluate(instance: dict[str, Any]) -> float: Please include this function signature in the code
   * snippet. Instance is the evaluation instance, any fields populated in the instance are
   * available to the function as instance[field_name]. Example: Example input: ``` instance=
   * EvaluationInstance( response=EvaluationInstance.InstanceData(text="The answer is 4."),
   * reference=EvaluationInstance.InstanceData(text="4") ) ``` Example converted input: ``` {
   * 'response': {'text': 'The answer is 4.'}, 'reference': {'text': '4'} } ``` Example python
   * function: ``` def evaluate(instance: dict[str, Any]) -> float: if instance'response' ==
   * instance'reference': return 1.0 return 0.0 ``` CustomCodeExecutionSpec is also supported in
   * Batch Evaluation (EvalDataset RPC) and Tuning Evaluation. Each line in the input jsonl file
   * will be converted to dict[str, Any] and passed to the evaluation function.
   */
  @JsonProperty("evaluationFunction")
  public abstract Optional<String> evaluationFunction();

  /** Instantiates a builder for CustomCodeExecutionSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_CustomCodeExecutionSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for CustomCodeExecutionSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `CustomCodeExecutionSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_CustomCodeExecutionSpec.Builder();
    }

    /**
     * Setter for remoteCustomFunction.
     *
     * <p>remoteCustomFunction: A string representing a user-defined function for evaluation.
     * Expected user to define the following function, e.g.: def evaluate(instance: dict[str, Any])
     * -> float: Please include this function signature in the code snippet. Instance is the
     * evaluation instance, any fields populated in the instance are available to the function as
     * instance[field_name].
     */
    @JsonProperty("remoteCustomFunction")
    public abstract Builder remoteCustomFunction(String remoteCustomFunction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder remoteCustomFunction(Optional<String> remoteCustomFunction);

    /** Clears the value of remoteCustomFunction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearRemoteCustomFunction() {
      return remoteCustomFunction(Optional.empty());
    }

    /**
     * Setter for evaluationFunction.
     *
     * <p>evaluationFunction: Required. Python function. Expected user to define the following
     * function, e.g.: def evaluate(instance: dict[str, Any]) -> float: Please include this function
     * signature in the code snippet. Instance is the evaluation instance, any fields populated in
     * the instance are available to the function as instance[field_name]. Example: Example input:
     * ``` instance= EvaluationInstance( response=EvaluationInstance.InstanceData(text="The answer
     * is 4."), reference=EvaluationInstance.InstanceData(text="4") ) ``` Example converted input:
     * ``` { 'response': {'text': 'The answer is 4.'}, 'reference': {'text': '4'} } ``` Example
     * python function: ``` def evaluate(instance: dict[str, Any]) -> float: if instance'response'
     * == instance'reference': return 1.0 return 0.0 ``` CustomCodeExecutionSpec is also supported
     * in Batch Evaluation (EvalDataset RPC) and Tuning Evaluation. Each line in the input jsonl
     * file will be converted to dict[str, Any] and passed to the evaluation function.
     */
    @JsonProperty("evaluationFunction")
    public abstract Builder evaluationFunction(String evaluationFunction);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationFunction(Optional<String> evaluationFunction);

    /** Clears the value of evaluationFunction field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationFunction() {
      return evaluationFunction(Optional.empty());
    }

    public abstract CustomCodeExecutionSpec build();
  }

  /** Deserializes a JSON string to a CustomCodeExecutionSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static CustomCodeExecutionSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, CustomCodeExecutionSpec.class);
  }
}
