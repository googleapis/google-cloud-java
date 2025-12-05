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

/** The action to take. */
public class GenerateMemoriesResponseGeneratedMemoryAction {

  /** Enum representing the known values for GenerateMemoriesResponseGeneratedMemoryAction. */
  public enum Known {
    /** The action is unspecified. */
    ACTION_UNSPECIFIED,

    /** The memory was created. */
    CREATED,

    /**
     * The memory was updated.
     *
     * <p>The `fact` field may not be updated if the existing fact is still accurate.
     */
    UPDATED,

    /** The memory was deleted. */
    DELETED,

    GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED
  }

  private Known generateMemoriesResponseGeneratedMemoryActionEnum;
  private final String value;

  @JsonCreator
  public GenerateMemoriesResponseGeneratedMemoryAction(String value) {
    this.value = value;
    for (Known generateMemoriesResponseGeneratedMemoryActionEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(
          generateMemoriesResponseGeneratedMemoryActionEnum.toString(), value)) {
        this.generateMemoriesResponseGeneratedMemoryActionEnum =
            generateMemoriesResponseGeneratedMemoryActionEnum;
        break;
      }
    }
    if (this.generateMemoriesResponseGeneratedMemoryActionEnum == null) {
      this.generateMemoriesResponseGeneratedMemoryActionEnum =
          Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED;
    }
  }

  public GenerateMemoriesResponseGeneratedMemoryAction(Known knownValue) {
    this.generateMemoriesResponseGeneratedMemoryActionEnum = knownValue;
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

    if (!(o instanceof GenerateMemoriesResponseGeneratedMemoryAction)) {
      return false;
    }

    GenerateMemoriesResponseGeneratedMemoryAction other =
        (GenerateMemoriesResponseGeneratedMemoryAction) o;

    if (this.generateMemoriesResponseGeneratedMemoryActionEnum
            != Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED
        && other.generateMemoriesResponseGeneratedMemoryActionEnum
            != Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED) {
      return this.generateMemoriesResponseGeneratedMemoryActionEnum
          == other.generateMemoriesResponseGeneratedMemoryActionEnum;
    } else if (this.generateMemoriesResponseGeneratedMemoryActionEnum
            == Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED
        && other.generateMemoriesResponseGeneratedMemoryActionEnum
            == Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.generateMemoriesResponseGeneratedMemoryActionEnum
        != Known.GENERATE_MEMORIES_RESPONSE_GENERATED_MEMORY_ACTION_UNSPECIFIED) {
      return this.generateMemoriesResponseGeneratedMemoryActionEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.generateMemoriesResponseGeneratedMemoryActionEnum;
  }
}
