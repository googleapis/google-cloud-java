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

/** Output only. The runtime state of the SandboxEnvironment. */
public class State {

  /** Enum representing the known values for State. */
  public enum Known {
    /** The default value. This value is unused. */
    STATE_UNSPECIFIED,

    /** Runtime resources are being allocated for the sandbox environment. */
    STATE_PROVISIONING,

    /** Sandbox runtime is ready for serving. */
    STATE_RUNNING,

    /** Sandbox runtime is halted, performing tear down tasks. */
    STATE_DEPROVISIONING,

    /** Sandbox has terminated with underlying runtime failure. */
    STATE_TERMINATED,

    /** Sandbox runtime has been deleted. */
    STATE_DELETED
  }

  private Known stateEnum;
  private final String value;

  @JsonCreator
  public State(String value) {
    this.value = value;
    for (Known stateEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(stateEnum.toString(), value)) {
        this.stateEnum = stateEnum;
        break;
      }
    }
    if (this.stateEnum == null) {
      this.stateEnum = Known.STATE_UNSPECIFIED;
    }
  }

  public State(Known knownValue) {
    this.stateEnum = knownValue;
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

    if (!(o instanceof State)) {
      return false;
    }

    State other = (State) o;

    if (this.stateEnum != Known.STATE_UNSPECIFIED && other.stateEnum != Known.STATE_UNSPECIFIED) {
      return this.stateEnum == other.stateEnum;
    } else if (this.stateEnum == Known.STATE_UNSPECIFIED
        && other.stateEnum == Known.STATE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.stateEnum != Known.STATE_UNSPECIFIED) {
      return this.stateEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.stateEnum;
  }
}
