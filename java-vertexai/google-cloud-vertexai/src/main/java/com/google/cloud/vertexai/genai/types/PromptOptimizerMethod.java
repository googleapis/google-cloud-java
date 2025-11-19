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

/** The method for data driven prompt optimization. */
public class PromptOptimizerMethod {

  /** Enum representing the known values for PromptOptimizerMethod. */
  public enum Known {
    /** The default data driven Vertex AI Prompt Optimizer. */
    VAPO,

    /** The data driven prompt optimizer designer for prompts from Android core API. */
    OPTIMIZATION_TARGET_GEMINI_NANO,

    PROMPT_OPTIMIZER_METHOD_UNSPECIFIED
  }

  private Known promptOptimizerMethodEnum;
  private final String value;

  @JsonCreator
  public PromptOptimizerMethod(String value) {
    this.value = value;
    for (Known promptOptimizerMethodEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(promptOptimizerMethodEnum.toString(), value)) {
        this.promptOptimizerMethodEnum = promptOptimizerMethodEnum;
        break;
      }
    }
    if (this.promptOptimizerMethodEnum == null) {
      this.promptOptimizerMethodEnum = Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED;
    }
  }

  public PromptOptimizerMethod(Known knownValue) {
    this.promptOptimizerMethodEnum = knownValue;
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

    if (!(o instanceof PromptOptimizerMethod)) {
      return false;
    }

    PromptOptimizerMethod other = (PromptOptimizerMethod) o;

    if (this.promptOptimizerMethodEnum != Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED
        && other.promptOptimizerMethodEnum != Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED) {
      return this.promptOptimizerMethodEnum == other.promptOptimizerMethodEnum;
    } else if (this.promptOptimizerMethodEnum == Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED
        && other.promptOptimizerMethodEnum == Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.promptOptimizerMethodEnum != Known.PROMPT_OPTIMIZER_METHOD_UNSPECIFIED) {
      return this.promptOptimizerMethodEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.promptOptimizerMethodEnum;
  }
}
