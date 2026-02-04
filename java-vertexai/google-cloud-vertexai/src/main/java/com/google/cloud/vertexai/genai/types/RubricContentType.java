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

/** Specifies the type of rubric content to generate. */
public class RubricContentType {

  /** Enum representing the known values for RubricContentType. */
  public enum Known {
    /** Generate rubrics based on properties. */
    PROPERTY,

    /** Generate rubrics in an NL question answer format. */
    NL_QUESTION_ANSWER,

    /** Generate rubrics in a unit test format. */
    PYTHON_CODE_ASSERTION,

    RUBRIC_CONTENT_TYPE_UNSPECIFIED
  }

  private Known rubricContentTypeEnum;
  private final String value;

  @JsonCreator
  public RubricContentType(String value) {
    this.value = value;
    for (Known rubricContentTypeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(rubricContentTypeEnum.toString(), value)) {
        this.rubricContentTypeEnum = rubricContentTypeEnum;
        break;
      }
    }
    if (this.rubricContentTypeEnum == null) {
      this.rubricContentTypeEnum = Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED;
    }
  }

  public RubricContentType(Known knownValue) {
    this.rubricContentTypeEnum = knownValue;
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

    if (!(o instanceof RubricContentType)) {
      return false;
    }

    RubricContentType other = (RubricContentType) o;

    if (this.rubricContentTypeEnum != Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED
        && other.rubricContentTypeEnum != Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED) {
      return this.rubricContentTypeEnum == other.rubricContentTypeEnum;
    } else if (this.rubricContentTypeEnum == Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED
        && other.rubricContentTypeEnum == Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.rubricContentTypeEnum != Known.RUBRIC_CONTENT_TYPE_UNSPECIFIED) {
      return this.rubricContentTypeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.rubricContentTypeEnum;
  }
}
