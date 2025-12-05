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

/** This determines which type of scheduling strategy to use. */
public class Strategy {

  /** Enum representing the known values for Strategy. */
  public enum Known {
    /** Strategy will default to STANDARD. */
    STRATEGY_UNSPECIFIED,

    /** Deprecated. Regular on-demand provisioning strategy. */
    ON_DEMAND,

    /** Deprecated. Low cost by making potential use of spot resources. */
    LOW_COST,

    /** Standard provisioning strategy uses regular on-demand resources. */
    STANDARD,

    /** Spot provisioning strategy uses spot resources. */
    SPOT,

    /** Flex Start strategy uses DWS to queue for resources. */
    FLEX_START
  }

  private Known strategyEnum;
  private final String value;

  @JsonCreator
  public Strategy(String value) {
    this.value = value;
    for (Known strategyEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(strategyEnum.toString(), value)) {
        this.strategyEnum = strategyEnum;
        break;
      }
    }
    if (this.strategyEnum == null) {
      this.strategyEnum = Known.STRATEGY_UNSPECIFIED;
    }
  }

  public Strategy(Known knownValue) {
    this.strategyEnum = knownValue;
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

    if (!(o instanceof Strategy)) {
      return false;
    }

    Strategy other = (Strategy) o;

    if (this.strategyEnum != Known.STRATEGY_UNSPECIFIED
        && other.strategyEnum != Known.STRATEGY_UNSPECIFIED) {
      return this.strategyEnum == other.strategyEnum;
    } else if (this.strategyEnum == Known.STRATEGY_UNSPECIFIED
        && other.strategyEnum == Known.STRATEGY_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.strategyEnum != Known.STRATEGY_UNSPECIFIED) {
      return this.strategyEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.strategyEnum;
  }
}
