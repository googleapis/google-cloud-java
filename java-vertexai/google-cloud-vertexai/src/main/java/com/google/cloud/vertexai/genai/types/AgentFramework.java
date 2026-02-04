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
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.Ascii;
import java.util.Objects;

/**
 * The agent framework to be used for the Agent Engine. The OSS agent framework used to develop the
 * agent. Currently supported values: "google-adk", "langchain", "langgraph", "ag2", "llama-index",
 * "custom". If not specified: - If `agent` is specified, the agent framework will be auto-detected.
 * - If `source_packages` is specified, the agent framework will default to "custom".
 */
public class AgentFramework {

  /** Enum representing the known values for AgentFramework. */
  public enum Known {
    GOOGLE_ADK("GOOGLE-ADK"),

    LANGCHAIN,

    LANGGRAPH,

    AG2,

    LLAMA_INDEX("LLAMA-INDEX"),

    CUSTOM,

    AGENT_FRAMEWORK_UNSPECIFIED;
    private final String value;

    Known() {
      this.value = this.name();
    }

    Known(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    public String toString() {
      return value;
    }
  }

  private Known agentFrameworkEnum;
  private final String value;

  @JsonCreator
  public AgentFramework(String value) {
    this.value = value;
    for (Known agentFrameworkEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(agentFrameworkEnum.toString(), value)) {
        this.agentFrameworkEnum = agentFrameworkEnum;
        break;
      }
    }
    if (this.agentFrameworkEnum == null) {
      this.agentFrameworkEnum = Known.AGENT_FRAMEWORK_UNSPECIFIED;
    }
  }

  public AgentFramework(Known knownValue) {
    this.agentFrameworkEnum = knownValue;
    this.value = knownValue.toString();
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  @JsonValue
  public String toString() {
    return this.value;
  }

  @ExcludeFromGeneratedCoverageReport
  @SuppressWarnings("PatternMatchingInstanceof")
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null) {
      return false;
    }

    if (!(o instanceof AgentFramework)) {
      return false;
    }

    AgentFramework other = (AgentFramework) o;

    if (this.agentFrameworkEnum != Known.AGENT_FRAMEWORK_UNSPECIFIED
        && other.agentFrameworkEnum != Known.AGENT_FRAMEWORK_UNSPECIFIED) {
      return this.agentFrameworkEnum == other.agentFrameworkEnum;
    } else if (this.agentFrameworkEnum == Known.AGENT_FRAMEWORK_UNSPECIFIED
        && other.agentFrameworkEnum == Known.AGENT_FRAMEWORK_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.agentFrameworkEnum != Known.AGENT_FRAMEWORK_UNSPECIFIED) {
      return this.agentFrameworkEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.agentFrameworkEnum;
  }
}
