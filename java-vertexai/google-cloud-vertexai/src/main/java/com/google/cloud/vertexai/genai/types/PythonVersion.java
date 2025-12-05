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
 * The Python version to be used for the Agent Engine. If not specified, it will use the current
 * Python version of the environment. Supported versions: "3.9", "3.10", "3.11", "3.12", "3.13".
 */
public class PythonVersion {

  /** Enum representing the known values for PythonVersion. */
  public enum Known {
    VALUE_3_9("3.9"),

    VALUE_3_10("3.10"),

    VALUE_3_11("3.11"),

    VALUE_3_12("3.12"),

    VALUE_3_13("3.13"),

    PYTHON_VERSION_UNSPECIFIED;
    private final String value;

    Known() {
      this.value = this.name();
    }

    Known(String value) {
      this.value = value;
    }

    public String value() {
      return value;
    }

    public String toString() {
      return value;
    }
  }

  private Known pythonVersionEnum;
  private final String value;

  @JsonCreator
  public PythonVersion(String value) {
    this.value = value;
    for (Known pythonVersionEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(pythonVersionEnum.toString(), value)) {
        this.pythonVersionEnum = pythonVersionEnum;
        break;
      }
    }
    if (this.pythonVersionEnum == null) {
      this.pythonVersionEnum = Known.PYTHON_VERSION_UNSPECIFIED;
    }
  }

  public PythonVersion(Known knownValue) {
    this.pythonVersionEnum = knownValue;
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

    if (!(o instanceof PythonVersion)) {
      return false;
    }

    PythonVersion other = (PythonVersion) o;

    if (this.pythonVersionEnum != Known.PYTHON_VERSION_UNSPECIFIED
        && other.pythonVersionEnum != Known.PYTHON_VERSION_UNSPECIFIED) {
      return this.pythonVersionEnum == other.pythonVersionEnum;
    } else if (this.pythonVersionEnum == Known.PYTHON_VERSION_UNSPECIFIED
        && other.pythonVersionEnum == Known.PYTHON_VERSION_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.pythonVersionEnum != Known.PYTHON_VERSION_UNSPECIFIED) {
      return this.pythonVersionEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.pythonVersionEnum;
  }
}
