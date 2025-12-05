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
 * Immutable. The type of accelerator(s) that may be attached to the machine as per
 * accelerator_count.
 */
public class AcceleratorType {

  /** Enum representing the known values for AcceleratorType. */
  public enum Known {
    /** Unspecified accelerator type, which means no accelerator. */
    ACCELERATOR_TYPE_UNSPECIFIED,

    /**
     * Deprecated: Nvidia Tesla K80 GPU has reached end of support, see
     * https://cloud.google.com/compute/docs/eol/k80-eol.
     */
    NVIDIA_TESLA_K80,

    /** Nvidia Tesla P100 GPU. */
    NVIDIA_TESLA_P100,

    /** Nvidia Tesla V100 GPU. */
    NVIDIA_TESLA_V100,

    /** Nvidia Tesla P4 GPU. */
    NVIDIA_TESLA_P4,

    /** Nvidia Tesla T4 GPU. */
    NVIDIA_TESLA_T4,

    /** Nvidia Tesla A100 GPU. */
    NVIDIA_TESLA_A100,

    /** Nvidia A100 80GB GPU. */
    NVIDIA_A100_80GB,

    /** Nvidia L4 GPU. */
    NVIDIA_L4,

    /** Nvidia H100 80Gb GPU. */
    NVIDIA_H100_80GB,

    /** Nvidia H100 Mega 80Gb GPU. */
    NVIDIA_H100_MEGA_80GB,

    /** Nvidia H200 141Gb GPU. */
    NVIDIA_H200_141GB,

    /** Nvidia B200 GPU. */
    NVIDIA_B200,

    /** Nvidia GB200 GPU. */
    NVIDIA_GB200,

    /** Nvidia RTX Pro 6000 GPU. */
    NVIDIA_RTX_PRO_6000,

    /** TPU v2. */
    TPU_V2,

    /** TPU v3. */
    TPU_V3,

    /** TPU v4. */
    TPU_V4_POD,

    /** TPU v5. */
    TPU_V5_LITEPOD
  }

  private Known acceleratorTypeEnum;
  private final String value;

  @JsonCreator
  public AcceleratorType(String value) {
    this.value = value;
    for (Known acceleratorTypeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(acceleratorTypeEnum.toString(), value)) {
        this.acceleratorTypeEnum = acceleratorTypeEnum;
        break;
      }
    }
    if (this.acceleratorTypeEnum == null) {
      this.acceleratorTypeEnum = Known.ACCELERATOR_TYPE_UNSPECIFIED;
    }
  }

  public AcceleratorType(Known knownValue) {
    this.acceleratorTypeEnum = knownValue;
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

    if (!(o instanceof AcceleratorType)) {
      return false;
    }

    AcceleratorType other = (AcceleratorType) o;

    if (this.acceleratorTypeEnum != Known.ACCELERATOR_TYPE_UNSPECIFIED
        && other.acceleratorTypeEnum != Known.ACCELERATOR_TYPE_UNSPECIFIED) {
      return this.acceleratorTypeEnum == other.acceleratorTypeEnum;
    } else if (this.acceleratorTypeEnum == Known.ACCELERATOR_TYPE_UNSPECIFIED
        && other.acceleratorTypeEnum == Known.ACCELERATOR_TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.acceleratorTypeEnum != Known.ACCELERATOR_TYPE_UNSPECIFIED) {
      return this.acceleratorTypeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.acceleratorTypeEnum;
  }
}
