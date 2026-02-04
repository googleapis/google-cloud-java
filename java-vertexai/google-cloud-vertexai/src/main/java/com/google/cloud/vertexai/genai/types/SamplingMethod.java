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

/** Represents the sampling method for a BigQuery request set. */
public class SamplingMethod {

  /** Enum representing the known values for SamplingMethod. */
  public enum Known {
    /** Sampling method is unspecified. */
    UNSPECIFIED,

    /** Sampling method is random. */
    RANDOM,

    SAMPLING_METHOD_UNSPECIFIED
  }

  private Known samplingMethodEnum;
  private final String value;

  @JsonCreator
  public SamplingMethod(String value) {
    this.value = value;
    for (Known samplingMethodEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(samplingMethodEnum.toString(), value)) {
        this.samplingMethodEnum = samplingMethodEnum;
        break;
      }
    }
    if (this.samplingMethodEnum == null) {
      this.samplingMethodEnum = Known.SAMPLING_METHOD_UNSPECIFIED;
    }
  }

  public SamplingMethod(Known knownValue) {
    this.samplingMethodEnum = knownValue;
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

    if (!(o instanceof SamplingMethod)) {
      return false;
    }

    SamplingMethod other = (SamplingMethod) o;

    if (this.samplingMethodEnum != Known.SAMPLING_METHOD_UNSPECIFIED
        && other.samplingMethodEnum != Known.SAMPLING_METHOD_UNSPECIFIED) {
      return this.samplingMethodEnum == other.samplingMethodEnum;
    } else if (this.samplingMethodEnum == Known.SAMPLING_METHOD_UNSPECIFIED
        && other.samplingMethodEnum == Known.SAMPLING_METHOD_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.samplingMethodEnum != Known.SAMPLING_METHOD_UNSPECIFIED) {
      return this.samplingMethodEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.samplingMethodEnum;
  }
}
