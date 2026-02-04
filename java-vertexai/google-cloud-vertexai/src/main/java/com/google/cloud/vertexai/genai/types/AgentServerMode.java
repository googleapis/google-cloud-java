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

/** The agent server mode. */
public class AgentServerMode {

  /** Enum representing the known values for AgentServerMode. */
  public enum Known {
    /** Unspecified agent server mode. Do not use. */
    AGENT_SERVER_MODE_UNSPECIFIED,

    /**
     * Stable agent server mode. This mode has everything stable and well-tested features agent
     * engine offers.
     */
    STABLE,

    /** Experimental agent server mode. This mode contains experimental features. */
    EXPERIMENTAL
  }

  private Known agentServerModeEnum;
  private final String value;

  @JsonCreator
  public AgentServerMode(String value) {
    this.value = value;
    for (Known agentServerModeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(agentServerModeEnum.toString(), value)) {
        this.agentServerModeEnum = agentServerModeEnum;
        break;
      }
    }
    if (this.agentServerModeEnum == null) {
      this.agentServerModeEnum = Known.AGENT_SERVER_MODE_UNSPECIFIED;
    }
  }

  public AgentServerMode(Known knownValue) {
    this.agentServerModeEnum = knownValue;
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

    if (!(o instanceof AgentServerMode)) {
      return false;
    }

    AgentServerMode other = (AgentServerMode) o;

    if (this.agentServerModeEnum != Known.AGENT_SERVER_MODE_UNSPECIFIED
        && other.agentServerModeEnum != Known.AGENT_SERVER_MODE_UNSPECIFIED) {
      return this.agentServerModeEnum == other.agentServerModeEnum;
    } else if (this.agentServerModeEnum == Known.AGENT_SERVER_MODE_UNSPECIFIED
        && other.agentServerModeEnum == Known.AGENT_SERVER_MODE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.agentServerModeEnum != Known.AGENT_SERVER_MODE_UNSPECIFIED) {
      return this.agentServerModeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.agentServerModeEnum;
  }
}
