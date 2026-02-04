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

/** VAPO Prompt Optimizer Config. */
@AutoValue
@JsonDeserialize(builder = PromptOptimizerConfig.Builder.class)
public abstract class PromptOptimizerConfig extends JsonSerializable {
  /** The gcs path to the config file, e.g. gs://bucket/config.json. */
  @JsonProperty("configPath")
  public abstract Optional<String> configPath();

  /**
   * The service account to use for the custom job. Cannot be provided at the same time as
   * service_account_project_number.
   */
  @JsonProperty("serviceAccount")
  public abstract Optional<String> serviceAccount();

  /**
   * The project number used to construct the default service
   * account:{service_account_project_number}-compute@developer.gserviceaccount.comCannot be
   * provided at the same time as "service_account".
   */
  @JsonProperty("serviceAccountProjectNumber")
  public abstract Optional<Integer> serviceAccountProjectNumber();

  /** Whether to wait for the job tocomplete. Ignored for async jobs. */
  @JsonProperty("waitForCompletion")
  public abstract Optional<Boolean> waitForCompletion();

  /**
   * The display name of the optimization job. If not provided, a display name in the format of
   * "vapo-optimizer-{timestamp}" will be used.
   */
  @JsonProperty("optimizerJobDisplayName")
  public abstract Optional<String> optimizerJobDisplayName();

  /** Instantiates a builder for PromptOptimizerConfig. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_PromptOptimizerConfig.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for PromptOptimizerConfig. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `PromptOptimizerConfig.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_PromptOptimizerConfig.Builder();
    }

    /**
     * Setter for configPath.
     *
     * <p>configPath: The gcs path to the config file, e.g. gs://bucket/config.json.
     */
    @JsonProperty("configPath")
    public abstract Builder configPath(String configPath);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder configPath(Optional<String> configPath);

    /** Clears the value of configPath field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearConfigPath() {
      return configPath(Optional.empty());
    }

    /**
     * Setter for serviceAccount.
     *
     * <p>serviceAccount: The service account to use for the custom job. Cannot be provided at the
     * same time as service_account_project_number.
     */
    @JsonProperty("serviceAccount")
    public abstract Builder serviceAccount(String serviceAccount);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder serviceAccount(Optional<String> serviceAccount);

    /** Clears the value of serviceAccount field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearServiceAccount() {
      return serviceAccount(Optional.empty());
    }

    /**
     * Setter for serviceAccountProjectNumber.
     *
     * <p>serviceAccountProjectNumber: The project number used to construct the default service
     * account:{service_account_project_number}-compute@developer.gserviceaccount.comCannot be
     * provided at the same time as "service_account".
     */
    @JsonProperty("serviceAccountProjectNumber")
    public abstract Builder serviceAccountProjectNumber(int serviceAccountProjectNumber);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder serviceAccountProjectNumber(Optional<Integer> serviceAccountProjectNumber);

    /** Clears the value of serviceAccountProjectNumber field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearServiceAccountProjectNumber() {
      return serviceAccountProjectNumber(Optional.empty());
    }

    /**
     * Setter for waitForCompletion.
     *
     * <p>waitForCompletion: Whether to wait for the job tocomplete. Ignored for async jobs.
     */
    @JsonProperty("waitForCompletion")
    public abstract Builder waitForCompletion(boolean waitForCompletion);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder waitForCompletion(Optional<Boolean> waitForCompletion);

    /** Clears the value of waitForCompletion field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearWaitForCompletion() {
      return waitForCompletion(Optional.empty());
    }

    /**
     * Setter for optimizerJobDisplayName.
     *
     * <p>optimizerJobDisplayName: The display name of the optimization job. If not provided, a
     * display name in the format of "vapo-optimizer-{timestamp}" will be used.
     */
    @JsonProperty("optimizerJobDisplayName")
    public abstract Builder optimizerJobDisplayName(String optimizerJobDisplayName);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder optimizerJobDisplayName(Optional<String> optimizerJobDisplayName);

    /** Clears the value of optimizerJobDisplayName field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearOptimizerJobDisplayName() {
      return optimizerJobDisplayName(Optional.empty());
    }

    public abstract PromptOptimizerConfig build();
  }

  /** Deserializes a JSON string to a PromptOptimizerConfig object. */
  @ExcludeFromGeneratedCoverageReport
  public static PromptOptimizerConfig fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, PromptOptimizerConfig.class);
  }
}
