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
import com.google.genai.types.GoogleRpcStatus;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/**
 * EvaluationItem is a single evaluation request or result.
 *
 * <p>The content of an EvaluationItem is immutable - it cannot be updated once created.
 * EvaluationItems can be deleted when no longer needed.
 */
@AutoValue
@JsonDeserialize(builder = EvaluationItem.Builder.class)
public abstract class EvaluationItem extends JsonSerializable {
  /** The resource name of the EvaluationItem. */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** The display name of the EvaluationItem. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /** Metadata for the EvaluationItem. */
  @JsonProperty("metadata")
  public abstract Optional<Map<String, Object>> metadata();

  /** Labels for the EvaluationItem. */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /** The type of the EvaluationItem. */
  @JsonProperty("evaluationItemType")
  public abstract Optional<EvaluationItemType> evaluationItemType();

  /** The request to evaluate. */
  @JsonProperty("evaluationRequest")
  public abstract Optional<EvaluationItemRequest> evaluationRequest();

  /** The response from evaluation. */
  @JsonProperty("evaluationResponse")
  public abstract Optional<EvaluationItemResult> evaluationResponse();

  /** The Cloud Storage object where the request or response is stored. */
  @JsonProperty("gcsUri")
  public abstract Optional<String> gcsUri();

  /** Timestamp when this item was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Error for the evaluation item. */
  @JsonProperty("error")
  public abstract Optional<GoogleRpcStatus> error();

  /** Instantiates a builder for EvaluationItem. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_EvaluationItem.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for EvaluationItem. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `EvaluationItem.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_EvaluationItem.Builder();
    }

    /**
     * Setter for name.
     *
     * <p>name: The resource name of the EvaluationItem.
     */
    @JsonProperty("name")
    public abstract Builder name(String name);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder name(Optional<String> name);

    /** Clears the value of name field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearName() {
      return name(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: The display name of the EvaluationItem.
     */
    @JsonProperty("displayName")
    public abstract Builder displayName(String displayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder displayName(Optional<String> displayName);

    /** Clears the value of displayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDisplayName() {
      return displayName(Optional.empty());
    }

    /**
     * Setter for metadata.
     *
     * <p>metadata: Metadata for the EvaluationItem.
     */
    @JsonProperty("metadata")
    public abstract Builder metadata(Map<String, Object> metadata);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder metadata(Optional<Map<String, Object>> metadata);

    /** Clears the value of metadata field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearMetadata() {
      return metadata(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: Labels for the EvaluationItem.
     */
    @JsonProperty("labels")
    public abstract Builder labels(Map<String, String> labels);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder labels(Optional<Map<String, String>> labels);

    /** Clears the value of labels field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearLabels() {
      return labels(Optional.empty());
    }

    /**
     * Setter for evaluationItemType.
     *
     * <p>evaluationItemType: The type of the EvaluationItem.
     */
    @JsonProperty("evaluationItemType")
    public abstract Builder evaluationItemType(EvaluationItemType evaluationItemType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationItemType(Optional<EvaluationItemType> evaluationItemType);

    /** Clears the value of evaluationItemType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationItemType() {
      return evaluationItemType(Optional.empty());
    }

    /**
     * Setter for evaluationItemType given a known enum.
     *
     * <p>evaluationItemType: The type of the EvaluationItem.
     */
    @CanIgnoreReturnValue
    public Builder evaluationItemType(EvaluationItemType.Known knownType) {
      return evaluationItemType(new EvaluationItemType(knownType));
    }

    /**
     * Setter for evaluationItemType given a string.
     *
     * <p>evaluationItemType: The type of the EvaluationItem.
     */
    @CanIgnoreReturnValue
    public Builder evaluationItemType(String evaluationItemType) {
      return evaluationItemType(new EvaluationItemType(evaluationItemType));
    }

    /**
     * Setter for evaluationRequest.
     *
     * <p>evaluationRequest: The request to evaluate.
     */
    @JsonProperty("evaluationRequest")
    public abstract Builder evaluationRequest(EvaluationItemRequest evaluationRequest);

    /**
     * Setter for evaluationRequest builder.
     *
     * <p>evaluationRequest: The request to evaluate.
     */
    @CanIgnoreReturnValue
    public Builder evaluationRequest(EvaluationItemRequest.Builder evaluationRequestBuilder) {
      return evaluationRequest(evaluationRequestBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationRequest(Optional<EvaluationItemRequest> evaluationRequest);

    /** Clears the value of evaluationRequest field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationRequest() {
      return evaluationRequest(Optional.empty());
    }

    /**
     * Setter for evaluationResponse.
     *
     * <p>evaluationResponse: The response from evaluation.
     */
    @JsonProperty("evaluationResponse")
    public abstract Builder evaluationResponse(EvaluationItemResult evaluationResponse);

    /**
     * Setter for evaluationResponse builder.
     *
     * <p>evaluationResponse: The response from evaluation.
     */
    @CanIgnoreReturnValue
    public Builder evaluationResponse(EvaluationItemResult.Builder evaluationResponseBuilder) {
      return evaluationResponse(evaluationResponseBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder evaluationResponse(Optional<EvaluationItemResult> evaluationResponse);

    /** Clears the value of evaluationResponse field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEvaluationResponse() {
      return evaluationResponse(Optional.empty());
    }

    /**
     * Setter for gcsUri.
     *
     * <p>gcsUri: The Cloud Storage object where the request or response is stored.
     */
    @JsonProperty("gcsUri")
    public abstract Builder gcsUri(String gcsUri);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder gcsUri(Optional<String> gcsUri);

    /** Clears the value of gcsUri field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearGcsUri() {
      return gcsUri(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Timestamp when this item was created.
     */
    @JsonProperty("createTime")
    public abstract Builder createTime(Instant createTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder createTime(Optional<Instant> createTime);

    /** Clears the value of createTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearCreateTime() {
      return createTime(Optional.empty());
    }

    /**
     * Setter for error.
     *
     * <p>error: Error for the evaluation item.
     */
    @JsonProperty("error")
    public abstract Builder error(GoogleRpcStatus error);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder error(Optional<GoogleRpcStatus> error);

    /** Clears the value of error field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearError() {
      return error(Optional.empty());
    }

    public abstract EvaluationItem build();
  }

  /** Deserializes a JSON string to a EvaluationItem object. */
  @ExcludeFromGeneratedCoverageReport
  public static EvaluationItem fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, EvaluationItem.class);
  }
}
