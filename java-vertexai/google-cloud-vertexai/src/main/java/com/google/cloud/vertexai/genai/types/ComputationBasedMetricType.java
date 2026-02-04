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

/** Represents the type of the computation based metric. */
public class ComputationBasedMetricType {

  /** Enum representing the known values for ComputationBasedMetricType. */
  public enum Known {
    /** Computation based metric type is unspecified. */
    COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED,

    /** Exact match metric. */
    EXACT_MATCH,

    /** BLEU metric. */
    BLEU,

    /** ROUGE metric. */
    ROUGE
  }

  private Known computationBasedMetricTypeEnum;
  private final String value;

  @JsonCreator
  public ComputationBasedMetricType(String value) {
    this.value = value;
    for (Known computationBasedMetricTypeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(computationBasedMetricTypeEnum.toString(), value)) {
        this.computationBasedMetricTypeEnum = computationBasedMetricTypeEnum;
        break;
      }
    }
    if (this.computationBasedMetricTypeEnum == null) {
      this.computationBasedMetricTypeEnum = Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED;
    }
  }

  public ComputationBasedMetricType(Known knownValue) {
    this.computationBasedMetricTypeEnum = knownValue;
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

    if (!(o instanceof ComputationBasedMetricType)) {
      return false;
    }

    ComputationBasedMetricType other = (ComputationBasedMetricType) o;

    if (this.computationBasedMetricTypeEnum != Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED
        && other.computationBasedMetricTypeEnum
            != Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED) {
      return this.computationBasedMetricTypeEnum == other.computationBasedMetricTypeEnum;
    } else if (this.computationBasedMetricTypeEnum
            == Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED
        && other.computationBasedMetricTypeEnum
            == Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.computationBasedMetricTypeEnum != Known.COMPUTATION_BASED_METRIC_TYPE_UNSPECIFIED) {
      return this.computationBasedMetricTypeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.computationBasedMetricTypeEnum;
  }
}
