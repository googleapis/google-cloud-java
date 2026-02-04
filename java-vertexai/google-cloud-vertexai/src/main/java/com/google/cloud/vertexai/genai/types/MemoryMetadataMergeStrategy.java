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

/** The strategy to use when applying metadata to existing memories during consolidation. */
public class MemoryMetadataMergeStrategy {

  /** Enum representing the known values for MemoryMetadataMergeStrategy. */
  public enum Known {
    /** The metadata merge strategy is unspecified. */
    METADATA_MERGE_STRATEGY_UNSPECIFIED,

    /** Replace the metadata of the updated memories with the new metadata. */
    OVERWRITE,

    /**
     * Append new metadata to the existing metadata. If there are duplicate keys, the existing
     * values will be overwritten.
     */
    MERGE,

    /**
     * Restrict consolidation to memories that have exactly the same metadata as the request. If a
     * memory doesn't have the same metadata, it is not eligible for consolidation.
     */
    REQUIRE_EXACT_MATCH,

    MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED
  }

  private Known memoryMetadataMergeStrategyEnum;
  private final String value;

  @JsonCreator
  public MemoryMetadataMergeStrategy(String value) {
    this.value = value;
    for (Known memoryMetadataMergeStrategyEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(memoryMetadataMergeStrategyEnum.toString(), value)) {
        this.memoryMetadataMergeStrategyEnum = memoryMetadataMergeStrategyEnum;
        break;
      }
    }
    if (this.memoryMetadataMergeStrategyEnum == null) {
      this.memoryMetadataMergeStrategyEnum = Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED;
    }
  }

  public MemoryMetadataMergeStrategy(Known knownValue) {
    this.memoryMetadataMergeStrategyEnum = knownValue;
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

    if (!(o instanceof MemoryMetadataMergeStrategy)) {
      return false;
    }

    MemoryMetadataMergeStrategy other = (MemoryMetadataMergeStrategy) o;

    if (this.memoryMetadataMergeStrategyEnum != Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED
        && other.memoryMetadataMergeStrategyEnum
            != Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED) {
      return this.memoryMetadataMergeStrategyEnum == other.memoryMetadataMergeStrategyEnum;
    } else if (this.memoryMetadataMergeStrategyEnum
            == Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED
        && other.memoryMetadataMergeStrategyEnum
            == Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.memoryMetadataMergeStrategyEnum != Known.MEMORY_METADATA_MERGE_STRATEGY_UNSPECIFIED) {
      return this.memoryMetadataMergeStrategyEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.memoryMetadataMergeStrategyEnum;
  }
}
