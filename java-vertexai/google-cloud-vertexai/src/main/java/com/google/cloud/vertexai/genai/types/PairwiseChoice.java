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

/** Output only. Pairwise metric choice. */
public class PairwiseChoice {

  /** Enum representing the known values for PairwiseChoice. */
  public enum Known {
    /** Unspecified prediction choice. */
    PAIRWISE_CHOICE_UNSPECIFIED,

    /** Baseline prediction wins */
    BASELINE,

    /** Candidate prediction wins */
    CANDIDATE,

    /** Winner cannot be determined */
    TIE
  }

  private Known pairwiseChoiceEnum;
  private final String value;

  @JsonCreator
  public PairwiseChoice(String value) {
    this.value = value;
    for (Known pairwiseChoiceEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(pairwiseChoiceEnum.toString(), value)) {
        this.pairwiseChoiceEnum = pairwiseChoiceEnum;
        break;
      }
    }
    if (this.pairwiseChoiceEnum == null) {
      this.pairwiseChoiceEnum = Known.PAIRWISE_CHOICE_UNSPECIFIED;
    }
  }

  public PairwiseChoice(Known knownValue) {
    this.pairwiseChoiceEnum = knownValue;
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

    if (!(o instanceof PairwiseChoice)) {
      return false;
    }

    PairwiseChoice other = (PairwiseChoice) o;

    if (this.pairwiseChoiceEnum != Known.PAIRWISE_CHOICE_UNSPECIFIED
        && other.pairwiseChoiceEnum != Known.PAIRWISE_CHOICE_UNSPECIFIED) {
      return this.pairwiseChoiceEnum == other.pairwiseChoiceEnum;
    } else if (this.pairwiseChoiceEnum == Known.PAIRWISE_CHOICE_UNSPECIFIED
        && other.pairwiseChoiceEnum == Known.PAIRWISE_CHOICE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.pairwiseChoiceEnum != Known.PAIRWISE_CHOICE_UNSPECIFIED) {
      return this.pairwiseChoiceEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.pairwiseChoiceEnum;
  }
}
