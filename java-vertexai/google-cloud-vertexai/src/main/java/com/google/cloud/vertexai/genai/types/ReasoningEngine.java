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
import com.google.genai.types.EncryptionSpec;
import java.time.Instant;
import java.util.Map;
import java.util.Optional;

/** An agent engine. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngine.Builder.class)
public abstract class ReasoningEngine extends JsonSerializable {
  /**
   * Customer-managed encryption key spec for a ReasoningEngine. If set, this ReasoningEngine and
   * all sub-resources of this ReasoningEngine will be secured by this key.
   */
  @JsonProperty("encryptionSpec")
  public abstract Optional<EncryptionSpec> encryptionSpec();

  /** Optional. Configuration for how Agent Engine sub-resources should manage context. */
  @JsonProperty("contextSpec")
  public abstract Optional<ReasoningEngineContextSpec> contextSpec();

  /** Output only. Timestamp when this ReasoningEngine was created. */
  @JsonProperty("createTime")
  public abstract Optional<Instant> createTime();

  /** Optional. The description of the ReasoningEngine. */
  @JsonProperty("description")
  public abstract Optional<String> description();

  /** Required. The display name of the ReasoningEngine. */
  @JsonProperty("displayName")
  public abstract Optional<String> displayName();

  /**
   * Optional. Used to perform consistent read-modify-write updates. If not set, a blind "overwrite"
   * update happens.
   */
  @JsonProperty("etag")
  public abstract Optional<String> etag();

  /** Labels for the ReasoningEngine. */
  @JsonProperty("labels")
  public abstract Optional<Map<String, String>> labels();

  /**
   * Identifier. The resource name of the ReasoningEngine. Format:
   * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   */
  @JsonProperty("name")
  public abstract Optional<String> name();

  /** Optional. Configurations of the ReasoningEngine */
  @JsonProperty("spec")
  public abstract Optional<ReasoningEngineSpec> spec();

  /** Output only. Timestamp when this ReasoningEngine was most recently updated. */
  @JsonProperty("updateTime")
  public abstract Optional<Instant> updateTime();

  /** Instantiates a builder for ReasoningEngine. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngine.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngine. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ReasoningEngine.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngine.Builder();
    }

    /**
     * Setter for encryptionSpec.
     *
     * <p>encryptionSpec: Customer-managed encryption key spec for a ReasoningEngine. If set, this
     * ReasoningEngine and all sub-resources of this ReasoningEngine will be secured by this key.
     */
    @JsonProperty("encryptionSpec")
    public abstract Builder encryptionSpec(EncryptionSpec encryptionSpec);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder encryptionSpec(Optional<EncryptionSpec> encryptionSpec);

    /** Clears the value of encryptionSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEncryptionSpec() {
      return encryptionSpec(Optional.empty());
    }

    /**
     * Setter for contextSpec.
     *
     * <p>contextSpec: Optional. Configuration for how Agent Engine sub-resources should manage
     * context.
     */
    @JsonProperty("contextSpec")
    public abstract Builder contextSpec(ReasoningEngineContextSpec contextSpec);

    /**
     * Setter for contextSpec builder.
     *
     * <p>contextSpec: Optional. Configuration for how Agent Engine sub-resources should manage
     * context.
     */
    @CanIgnoreReturnValue
    public Builder contextSpec(ReasoningEngineContextSpec.Builder contextSpecBuilder) {
      return contextSpec(contextSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder contextSpec(Optional<ReasoningEngineContextSpec> contextSpec);

    /** Clears the value of contextSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearContextSpec() {
      return contextSpec(Optional.empty());
    }

    /**
     * Setter for createTime.
     *
     * <p>createTime: Output only. Timestamp when this ReasoningEngine was created.
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
     * Setter for description.
     *
     * <p>description: Optional. The description of the ReasoningEngine.
     */
    @JsonProperty("description")
    public abstract Builder description(String description);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder description(Optional<String> description);

    /** Clears the value of description field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDescription() {
      return description(Optional.empty());
    }

    /**
     * Setter for displayName.
     *
     * <p>displayName: Required. The display name of the ReasoningEngine.
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
     * Setter for etag.
     *
     * <p>etag: Optional. Used to perform consistent read-modify-write updates. If not set, a blind
     * "overwrite" update happens.
     */
    @JsonProperty("etag")
    public abstract Builder etag(String etag);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder etag(Optional<String> etag);

    /** Clears the value of etag field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEtag() {
      return etag(Optional.empty());
    }

    /**
     * Setter for labels.
     *
     * <p>labels: Labels for the ReasoningEngine.
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
     * Setter for name.
     *
     * <p>name: Identifier. The resource name of the ReasoningEngine. Format:
     * `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
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
     * Setter for spec.
     *
     * <p>spec: Optional. Configurations of the ReasoningEngine
     */
    @JsonProperty("spec")
    public abstract Builder spec(ReasoningEngineSpec spec);

    /**
     * Setter for spec builder.
     *
     * <p>spec: Optional. Configurations of the ReasoningEngine
     */
    @CanIgnoreReturnValue
    public Builder spec(ReasoningEngineSpec.Builder specBuilder) {
      return spec(specBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder spec(Optional<ReasoningEngineSpec> spec);

    /** Clears the value of spec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSpec() {
      return spec(Optional.empty());
    }

    /**
     * Setter for updateTime.
     *
     * <p>updateTime: Output only. Timestamp when this ReasoningEngine was most recently updated.
     */
    @JsonProperty("updateTime")
    public abstract Builder updateTime(Instant updateTime);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder updateTime(Optional<Instant> updateTime);

    /** Clears the value of updateTime field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearUpdateTime() {
      return updateTime(Optional.empty());
    }

    public abstract ReasoningEngine build();
  }

  /** Deserializes a JSON string to a ReasoningEngine object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngine fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngine.class);
  }
}
