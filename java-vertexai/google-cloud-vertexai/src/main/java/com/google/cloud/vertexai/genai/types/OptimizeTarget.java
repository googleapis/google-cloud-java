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

/** None */
public class OptimizeTarget {

  /** Enum representing the known values for OptimizeTarget. */
  public enum Known {
    /** The data driven prompt optimizer designer for prompts from Android core API. */
    OPTIMIZATION_TARGET_GEMINI_NANO,

    OPTIMIZE_TARGET_UNSPECIFIED
  }

  private Known optimizeTargetEnum;
  private final String value;

  @JsonCreator
  public OptimizeTarget(String value) {
    this.value = value;
    for (Known optimizeTargetEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(optimizeTargetEnum.toString(), value)) {
        this.optimizeTargetEnum = optimizeTargetEnum;
        break;
      }
    }
    if (this.optimizeTargetEnum == null) {
      this.optimizeTargetEnum = Known.OPTIMIZE_TARGET_UNSPECIFIED;
    }
  }

  public OptimizeTarget(Known knownValue) {
    this.optimizeTargetEnum = knownValue;
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

    if (!(o instanceof OptimizeTarget)) {
      return false;
    }

    OptimizeTarget other = (OptimizeTarget) o;

    if (this.optimizeTargetEnum != Known.OPTIMIZE_TARGET_UNSPECIFIED
        && other.optimizeTargetEnum != Known.OPTIMIZE_TARGET_UNSPECIFIED) {
      return this.optimizeTargetEnum == other.optimizeTargetEnum;
    } else if (this.optimizeTargetEnum == Known.OPTIMIZE_TARGET_UNSPECIFIED
        && other.optimizeTargetEnum == Known.OPTIMIZE_TARGET_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.optimizeTargetEnum != Known.OPTIMIZE_TARGET_UNSPECIFIED) {
      return this.optimizeTargetEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.optimizeTargetEnum;
  }
}
