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
 * The schema to use for the dataset. If not specified, the dataset schema will be inferred from the
 * first example in the dataset.
 */
public class DatasetSchema {

  /** Enum representing the known values for DatasetSchema. */
  public enum Known {
    GEMINI,

    FLATTEN,

    OPENAI,

    DATASET_SCHEMA_UNSPECIFIED
  }

  private Known datasetSchemaEnum;
  private final String value;

  @JsonCreator
  public DatasetSchema(String value) {
    this.value = value;
    for (Known datasetSchemaEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(datasetSchemaEnum.toString(), value)) {
        this.datasetSchemaEnum = datasetSchemaEnum;
        break;
      }
    }
    if (this.datasetSchemaEnum == null) {
      this.datasetSchemaEnum = Known.DATASET_SCHEMA_UNSPECIFIED;
    }
  }

  public DatasetSchema(Known knownValue) {
    this.datasetSchemaEnum = knownValue;
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

    if (!(o instanceof DatasetSchema)) {
      return false;
    }

    DatasetSchema other = (DatasetSchema) o;

    if (this.datasetSchemaEnum != Known.DATASET_SCHEMA_UNSPECIFIED
        && other.datasetSchemaEnum != Known.DATASET_SCHEMA_UNSPECIFIED) {
      return this.datasetSchemaEnum == other.datasetSchemaEnum;
    } else if (this.datasetSchemaEnum == Known.DATASET_SCHEMA_UNSPECIFIED
        && other.datasetSchemaEnum == Known.DATASET_SCHEMA_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.datasetSchemaEnum != Known.DATASET_SCHEMA_UNSPECIFIED) {
      return this.datasetSchemaEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.datasetSchemaEnum;
  }
}
