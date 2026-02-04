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

/** Specifies the reservation affinity type. */
public class Type {

  /** Enum representing the known values for Type. */
  public enum Known {
    /** Default value. This should not be used. */
    TYPE_UNSPECIFIED,

    /** Do not consume from any reserved capacity, only use on-demand. */
    NO_RESERVATION,

    /** Consume any reservation available, falling back to on-demand. */
    ANY_RESERVATION,

    /**
     * Consume from a specific reservation. When chosen, the reservation must be identified via the
     * `key` and `values` fields.
     */
    SPECIFIC_RESERVATION
  }

  private Known typeEnum;
  private final String value;

  @JsonCreator
  public Type(String value) {
    this.value = value;
    for (Known typeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(typeEnum.toString(), value)) {
        this.typeEnum = typeEnum;
        break;
      }
    }
    if (this.typeEnum == null) {
      this.typeEnum = Known.TYPE_UNSPECIFIED;
    }
  }

  public Type(Known knownValue) {
    this.typeEnum = knownValue;
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

    if (!(o instanceof Type)) {
      return false;
    }

    Type other = (Type) o;

    if (this.typeEnum != Known.TYPE_UNSPECIFIED && other.typeEnum != Known.TYPE_UNSPECIFIED) {
      return this.typeEnum == other.typeEnum;
    } else if (this.typeEnum == Known.TYPE_UNSPECIFIED
        && other.typeEnum == Known.TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.typeEnum != Known.TYPE_UNSPECIFIED) {
      return this.typeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.typeEnum;
  }
}
