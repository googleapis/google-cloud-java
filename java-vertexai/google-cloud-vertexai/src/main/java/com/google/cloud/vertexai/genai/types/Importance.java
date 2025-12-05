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

/** Importance level of the rubric. */
public class Importance {

  /** Enum representing the known values for Importance. */
  public enum Known {
    /** Importance is not specified. */
    IMPORTANCE_UNSPECIFIED,

    /** High importance. */
    HIGH,

    /** Medium importance. */
    MEDIUM,

    /** Low importance. */
    LOW
  }

  private Known importanceEnum;
  private final String value;

  @JsonCreator
  public Importance(String value) {
    this.value = value;
    for (Known importanceEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(importanceEnum.toString(), value)) {
        this.importanceEnum = importanceEnum;
        break;
      }
    }
    if (this.importanceEnum == null) {
      this.importanceEnum = Known.IMPORTANCE_UNSPECIFIED;
    }
  }

  public Importance(Known knownValue) {
    this.importanceEnum = knownValue;
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

    if (!(o instanceof Importance)) {
      return false;
    }

    Importance other = (Importance) o;

    if (this.importanceEnum != Known.IMPORTANCE_UNSPECIFIED
        && other.importanceEnum != Known.IMPORTANCE_UNSPECIFIED) {
      return this.importanceEnum == other.importanceEnum;
    } else if (this.importanceEnum == Known.IMPORTANCE_UNSPECIFIED
        && other.importanceEnum == Known.IMPORTANCE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.importanceEnum != Known.IMPORTANCE_UNSPECIFIED) {
      return this.importanceEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.importanceEnum;
  }
}
