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

/** The managed topic. */
public class ManagedTopicEnum {

  /** Enum representing the known values for ManagedTopicEnum. */
  public enum Known {
    /** Unspecified topic. This value should not be used. */
    MANAGED_TOPIC_ENUM_UNSPECIFIED,

    /**
     * Significant personal information about the User like first names, relationships, hobbies,
     * important dates.
     */
    USER_PERSONAL_INFO,

    /** Stated or implied likes, dislikes, preferred styles, or patterns. */
    USER_PREFERENCES,

    /** Important milestones or conclusions within the dialogue. */
    KEY_CONVERSATION_DETAILS,

    /** Information that the user explicitly requested to remember or forget. */
    EXPLICIT_INSTRUCTIONS
  }

  private Known managedTopicEnumEnum;
  private final String value;

  @JsonCreator
  public ManagedTopicEnum(String value) {
    this.value = value;
    for (Known managedTopicEnumEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(managedTopicEnumEnum.toString(), value)) {
        this.managedTopicEnumEnum = managedTopicEnumEnum;
        break;
      }
    }
    if (this.managedTopicEnumEnum == null) {
      this.managedTopicEnumEnum = Known.MANAGED_TOPIC_ENUM_UNSPECIFIED;
    }
  }

  public ManagedTopicEnum(Known knownValue) {
    this.managedTopicEnumEnum = knownValue;
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

    if (!(o instanceof ManagedTopicEnum)) {
      return false;
    }

    ManagedTopicEnum other = (ManagedTopicEnum) o;

    if (this.managedTopicEnumEnum != Known.MANAGED_TOPIC_ENUM_UNSPECIFIED
        && other.managedTopicEnumEnum != Known.MANAGED_TOPIC_ENUM_UNSPECIFIED) {
      return this.managedTopicEnumEnum == other.managedTopicEnumEnum;
    } else if (this.managedTopicEnumEnum == Known.MANAGED_TOPIC_ENUM_UNSPECIFIED
        && other.managedTopicEnumEnum == Known.MANAGED_TOPIC_ENUM_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.managedTopicEnumEnum != Known.MANAGED_TOPIC_ENUM_UNSPECIFIED) {
      return this.managedTopicEnumEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.managedTopicEnumEnum;
  }
}
