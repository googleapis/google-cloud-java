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

/** Framework used to build the application. */
public class Framework {

  /** Enum representing the known values for Framework. */
  public enum Known {
    /** Unspecified framework. */
    FRAMEWORK_UNSPECIFIED,

    /** React framework. */
    REACT,

    /** Angular framework. */
    ANGULAR
  }

  private Known frameworkEnum;
  private final String value;

  @JsonCreator
  public Framework(String value) {
    this.value = value;
    for (Known frameworkEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(frameworkEnum.toString(), value)) {
        this.frameworkEnum = frameworkEnum;
        break;
      }
    }
    if (this.frameworkEnum == null) {
      this.frameworkEnum = Known.FRAMEWORK_UNSPECIFIED;
    }
  }

  public Framework(Known knownValue) {
    this.frameworkEnum = knownValue;
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

    if (!(o instanceof Framework)) {
      return false;
    }

    Framework other = (Framework) o;

    if (this.frameworkEnum != Known.FRAMEWORK_UNSPECIFIED
        && other.frameworkEnum != Known.FRAMEWORK_UNSPECIFIED) {
      return this.frameworkEnum == other.frameworkEnum;
    } else if (this.frameworkEnum == Known.FRAMEWORK_UNSPECIFIED
        && other.frameworkEnum == Known.FRAMEWORK_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.frameworkEnum != Known.FRAMEWORK_UNSPECIFIED) {
      return this.frameworkEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.frameworkEnum;
  }
}
