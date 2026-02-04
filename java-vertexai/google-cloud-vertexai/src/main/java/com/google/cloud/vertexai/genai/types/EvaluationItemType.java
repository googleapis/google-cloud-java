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

/** The type of the EvaluationItem. */
public class EvaluationItemType {

  /** Enum representing the known values for EvaluationItemType. */
  public enum Known {
    /** The default value. This value is unused. */
    EVALUATION_ITEM_TYPE_UNSPECIFIED,

    /** The EvaluationItem is a request to evaluate. */
    REQUEST,

    /** The EvaluationItem is the result of evaluation. */
    RESULT
  }

  private Known evaluationItemTypeEnum;
  private final String value;

  @JsonCreator
  public EvaluationItemType(String value) {
    this.value = value;
    for (Known evaluationItemTypeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(evaluationItemTypeEnum.toString(), value)) {
        this.evaluationItemTypeEnum = evaluationItemTypeEnum;
        break;
      }
    }
    if (this.evaluationItemTypeEnum == null) {
      this.evaluationItemTypeEnum = Known.EVALUATION_ITEM_TYPE_UNSPECIFIED;
    }
  }

  public EvaluationItemType(Known knownValue) {
    this.evaluationItemTypeEnum = knownValue;
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

    if (!(o instanceof EvaluationItemType)) {
      return false;
    }

    EvaluationItemType other = (EvaluationItemType) o;

    if (this.evaluationItemTypeEnum != Known.EVALUATION_ITEM_TYPE_UNSPECIFIED
        && other.evaluationItemTypeEnum != Known.EVALUATION_ITEM_TYPE_UNSPECIFIED) {
      return this.evaluationItemTypeEnum == other.evaluationItemTypeEnum;
    } else if (this.evaluationItemTypeEnum == Known.EVALUATION_ITEM_TYPE_UNSPECIFIED
        && other.evaluationItemTypeEnum == Known.EVALUATION_ITEM_TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.evaluationItemTypeEnum != Known.EVALUATION_ITEM_TYPE_UNSPECIFIED) {
      return this.evaluationItemTypeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.evaluationItemTypeEnum;
  }
}
