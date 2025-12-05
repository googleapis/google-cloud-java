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
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The specification of an agent engine. */
@AutoValue
@JsonDeserialize(builder = ReasoningEngineSpec.Builder.class)
public abstract class ReasoningEngineSpec extends JsonSerializable {
  /**
   * Optional. The OSS agent framework used to develop the agent. Currently supported values:
   * "google-adk", "langchain", "langgraph", "ag2", "llama-index", "custom".
   */
  @JsonProperty("agentFramework")
  public abstract Optional<String> agentFramework();

  /** Optional. Declarations for object class methods in OpenAPI specification format. */
  @JsonProperty("classMethods")
  public abstract Optional<List<Map<String, Object>>> classMethods();

  /** Optional. The specification of a Reasoning Engine deployment. */
  @JsonProperty("deploymentSpec")
  public abstract Optional<ReasoningEngineSpecDeploymentSpec> deploymentSpec();

  /**
   * Output only. The identity to use for the Reasoning Engine. It can contain one of the following
   * values: * service-{project}@gcp-sa-aiplatform-re.googleapis.com (for SERVICE_AGENT identity
   * type) * {name}@{project}.gserviceaccount.com (for SERVICE_ACCOUNT identity type) *
   * agents.global.{org}.system.id.goog/resources/aiplatform/projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}
   * (for AGENT_IDENTITY identity type)
   */
  @JsonProperty("effectiveIdentity")
  public abstract Optional<String> effectiveIdentity();

  /**
   * Optional. The identity type to use for the Reasoning Engine. If not specified, the
   * `service_account` field will be used if set, otherwise the default Vertex AI Reasoning Engine
   * Service Agent in the project will be used.
   */
  @JsonProperty("identityType")
  public abstract Optional<IdentityType> identityType();

  /**
   * Optional. User provided package spec of the ReasoningEngine. Ignored when users directly
   * specify a deployment image through `deployment_spec.first_party_image_override`, but keeping
   * the field_behavior to avoid introducing breaking changes. The `deployment_source` field should
   * not be set if `package_spec` is specified.
   */
  @JsonProperty("packageSpec")
  public abstract Optional<ReasoningEngineSpecPackageSpec> packageSpec();

  /**
   * Optional. The service account that the Reasoning Engine artifact runs as. It should have
   * "roles/storage.objectViewer" for reading the user project's Cloud Storage and
   * "roles/aiplatform.user" for using Vertex extensions. If not specified, the Vertex AI Reasoning
   * Engine Service Agent in the project will be used.
   */
  @JsonProperty("serviceAccount")
  public abstract Optional<String> serviceAccount();

  /** Deploy from source code files with a defined entrypoint. */
  @JsonProperty("sourceCodeSpec")
  public abstract Optional<ReasoningEngineSpecSourceCodeSpec> sourceCodeSpec();

  /** Instantiates a builder for ReasoningEngineSpec. */
  @ExcludeFromGeneratedCoverageReport
  public static Builder builder() {
    return new AutoValue_ReasoningEngineSpec.Builder();
  }

  /** Creates a builder with the same values as this instance. */
  public abstract Builder toBuilder();

  /** Builder for ReasoningEngineSpec. */
  @AutoValue.Builder
  public abstract static class Builder {
    /** For internal usage. Please use `ReasoningEngineSpec.builder()` for instantiation. */
    @JsonCreator
    private static Builder create() {
      return new AutoValue_ReasoningEngineSpec.Builder();
    }

    /**
     * Setter for agentFramework.
     *
     * <p>agentFramework: Optional. The OSS agent framework used to develop the agent. Currently
     * supported values: "google-adk", "langchain", "langgraph", "ag2", "llama-index", "custom".
     */
    @JsonProperty("agentFramework")
    public abstract Builder agentFramework(String agentFramework);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder agentFramework(Optional<String> agentFramework);

    /** Clears the value of agentFramework field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearAgentFramework() {
      return agentFramework(Optional.empty());
    }

    /**
     * Setter for classMethods.
     *
     * <p>classMethods: Optional. Declarations for object class methods in OpenAPI specification
     * format.
     */
    @JsonProperty("classMethods")
    public abstract Builder classMethods(List<Map<String, Object>> classMethods);

    /**
     * Setter for classMethods.
     *
     * <p>classMethods: Optional. Declarations for object class methods in OpenAPI specification
     * format.
     */
    @CanIgnoreReturnValue
    public Builder classMethods(Map<String, Object>... classMethods) {
      return classMethods(Arrays.asList(classMethods));
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder classMethods(Optional<List<Map<String, Object>>> classMethods);

    /** Clears the value of classMethods field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearClassMethods() {
      return classMethods(Optional.empty());
    }

    /**
     * Setter for deploymentSpec.
     *
     * <p>deploymentSpec: Optional. The specification of a Reasoning Engine deployment.
     */
    @JsonProperty("deploymentSpec")
    public abstract Builder deploymentSpec(ReasoningEngineSpecDeploymentSpec deploymentSpec);

    /**
     * Setter for deploymentSpec builder.
     *
     * <p>deploymentSpec: Optional. The specification of a Reasoning Engine deployment.
     */
    @CanIgnoreReturnValue
    public Builder deploymentSpec(ReasoningEngineSpecDeploymentSpec.Builder deploymentSpecBuilder) {
      return deploymentSpec(deploymentSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder deploymentSpec(Optional<ReasoningEngineSpecDeploymentSpec> deploymentSpec);

    /** Clears the value of deploymentSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearDeploymentSpec() {
      return deploymentSpec(Optional.empty());
    }

    /**
     * Setter for effectiveIdentity.
     *
     * <p>effectiveIdentity: Output only. The identity to use for the Reasoning Engine. It can
     * contain one of the following values: * service-{project}@gcp-sa-aiplatform-re.googleapis.com
     * (for SERVICE_AGENT identity type) * {name}@{project}.gserviceaccount.com (for SERVICE_ACCOUNT
     * identity type) *
     * agents.global.{org}.system.id.goog/resources/aiplatform/projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}
     * (for AGENT_IDENTITY identity type)
     */
    @JsonProperty("effectiveIdentity")
    public abstract Builder effectiveIdentity(String effectiveIdentity);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder effectiveIdentity(Optional<String> effectiveIdentity);

    /** Clears the value of effectiveIdentity field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearEffectiveIdentity() {
      return effectiveIdentity(Optional.empty());
    }

    /**
     * Setter for identityType.
     *
     * <p>identityType: Optional. The identity type to use for the Reasoning Engine. If not
     * specified, the `service_account` field will be used if set, otherwise the default Vertex AI
     * Reasoning Engine Service Agent in the project will be used.
     */
    @JsonProperty("identityType")
    public abstract Builder identityType(IdentityType identityType);

    @ExcludeFromGeneratedCoverageReport
    abstract Builder identityType(Optional<IdentityType> identityType);

    /** Clears the value of identityType field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearIdentityType() {
      return identityType(Optional.empty());
    }

    /**
     * Setter for identityType given a known enum.
     *
     * <p>identityType: Optional. The identity type to use for the Reasoning Engine. If not
     * specified, the `service_account` field will be used if set, otherwise the default Vertex AI
     * Reasoning Engine Service Agent in the project will be used.
     */
    @CanIgnoreReturnValue
    public Builder identityType(IdentityType.Known knownType) {
      return identityType(new IdentityType(knownType));
    }

    /**
     * Setter for identityType given a string.
     *
     * <p>identityType: Optional. The identity type to use for the Reasoning Engine. If not
     * specified, the `service_account` field will be used if set, otherwise the default Vertex AI
     * Reasoning Engine Service Agent in the project will be used.
     */
    @CanIgnoreReturnValue
    public Builder identityType(String identityType) {
      return identityType(new IdentityType(identityType));
    }

    /**
     * Setter for packageSpec.
     *
     * <p>packageSpec: Optional. User provided package spec of the ReasoningEngine. Ignored when
     * users directly specify a deployment image through
     * `deployment_spec.first_party_image_override`, but keeping the field_behavior to avoid
     * introducing breaking changes. The `deployment_source` field should not be set if
     * `package_spec` is specified.
     */
    @JsonProperty("packageSpec")
    public abstract Builder packageSpec(ReasoningEngineSpecPackageSpec packageSpec);

    /**
     * Setter for packageSpec builder.
     *
     * <p>packageSpec: Optional. User provided package spec of the ReasoningEngine. Ignored when
     * users directly specify a deployment image through
     * `deployment_spec.first_party_image_override`, but keeping the field_behavior to avoid
     * introducing breaking changes. The `deployment_source` field should not be set if
     * `package_spec` is specified.
     */
    @CanIgnoreReturnValue
    public Builder packageSpec(ReasoningEngineSpecPackageSpec.Builder packageSpecBuilder) {
      return packageSpec(packageSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder packageSpec(Optional<ReasoningEngineSpecPackageSpec> packageSpec);

    /** Clears the value of packageSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearPackageSpec() {
      return packageSpec(Optional.empty());
    }

    /**
     * Setter for serviceAccount.
     *
     * <p>serviceAccount: Optional. The service account that the Reasoning Engine artifact runs as.
     * It should have "roles/storage.objectViewer" for reading the user project's Cloud Storage and
     * "roles/aiplatform.user" for using Vertex extensions. If not specified, the Vertex AI
     * Reasoning Engine Service Agent in the project will be used.
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
     * Setter for sourceCodeSpec.
     *
     * <p>sourceCodeSpec: Deploy from source code files with a defined entrypoint.
     */
    @JsonProperty("sourceCodeSpec")
    public abstract Builder sourceCodeSpec(ReasoningEngineSpecSourceCodeSpec sourceCodeSpec);

    /**
     * Setter for sourceCodeSpec builder.
     *
     * <p>sourceCodeSpec: Deploy from source code files with a defined entrypoint.
     */
    @CanIgnoreReturnValue
    public Builder sourceCodeSpec(ReasoningEngineSpecSourceCodeSpec.Builder sourceCodeSpecBuilder) {
      return sourceCodeSpec(sourceCodeSpecBuilder.build());
    }

    @ExcludeFromGeneratedCoverageReport
    abstract Builder sourceCodeSpec(Optional<ReasoningEngineSpecSourceCodeSpec> sourceCodeSpec);

    /** Clears the value of sourceCodeSpec field. */
    @ExcludeFromGeneratedCoverageReport
    @CanIgnoreReturnValue
    public Builder clearSourceCodeSpec() {
      return sourceCodeSpec(Optional.empty());
    }

    public abstract ReasoningEngineSpec build();
  }

  /** Deserializes a JSON string to a ReasoningEngineSpec object. */
  @ExcludeFromGeneratedCoverageReport
  public static ReasoningEngineSpec fromJson(String jsonString) {
    return JsonSerializable.fromJsonString(jsonString, ReasoningEngineSpec.class);
  }
}
