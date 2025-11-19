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
 * The identity type to use for the Reasoning Engine. If not specified, the `service_account` field
 * will be used if set, otherwise the default Vertex AI Reasoning Engine Service Agent in the
 * project will be used.
 */
public class IdentityType {

  /** Enum representing the known values for IdentityType. */
  public enum Known {
    /**
     * Default value. Use a custom service account if the `service_account` field is set, otherwise
     * use the default Vertex AI Reasoning Engine Service Agent in the project. Same behavior as
     * SERVICE_ACCOUNT.
     */
    IDENTITY_TYPE_UNSPECIFIED,

    /**
     * Use a custom service account if the `service_account` field is set, otherwise use the default
     * Vertex AI Reasoning Engine Service Agent in the project.
     */
    SERVICE_ACCOUNT,

    /** Use Agent Identity. The `service_account` field must not be set. */
    AGENT_IDENTITY
  }

  private Known identityTypeEnum;
  private final String value;

  @JsonCreator
  public IdentityType(String value) {
    this.value = value;
    for (Known identityTypeEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(identityTypeEnum.toString(), value)) {
        this.identityTypeEnum = identityTypeEnum;
        break;
      }
    }
    if (this.identityTypeEnum == null) {
      this.identityTypeEnum = Known.IDENTITY_TYPE_UNSPECIFIED;
    }
  }

  public IdentityType(Known knownValue) {
    this.identityTypeEnum = knownValue;
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

    if (!(o instanceof IdentityType)) {
      return false;
    }

    IdentityType other = (IdentityType) o;

    if (this.identityTypeEnum != Known.IDENTITY_TYPE_UNSPECIFIED
        && other.identityTypeEnum != Known.IDENTITY_TYPE_UNSPECIFIED) {
      return this.identityTypeEnum == other.identityTypeEnum;
    } else if (this.identityTypeEnum == Known.IDENTITY_TYPE_UNSPECIFIED
        && other.identityTypeEnum == Known.IDENTITY_TYPE_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.identityTypeEnum != Known.IDENTITY_TYPE_UNSPECIFIED) {
      return this.identityTypeEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.identityTypeEnum;
  }
}
