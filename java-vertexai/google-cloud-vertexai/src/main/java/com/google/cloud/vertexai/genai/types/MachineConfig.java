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

/** The machine config of the code execution environment. */
public class MachineConfig {

  /** Enum representing the known values for MachineConfig. */
  public enum Known {
    /** The default value: milligcu 2000, memory 1.5Gib */
    MACHINE_CONFIG_UNSPECIFIED,

    /** The default value: milligcu 4000, memory 4 Gib */
    MACHINE_CONFIG_VCPU4_RAM4GIB
  }

  private Known machineConfigEnum;
  private final String value;

  @JsonCreator
  public MachineConfig(String value) {
    this.value = value;
    for (Known machineConfigEnum : Known.values()) {
      if (Ascii.equalsIgnoreCase(machineConfigEnum.toString(), value)) {
        this.machineConfigEnum = machineConfigEnum;
        break;
      }
    }
    if (this.machineConfigEnum == null) {
      this.machineConfigEnum = Known.MACHINE_CONFIG_UNSPECIFIED;
    }
  }

  public MachineConfig(Known knownValue) {
    this.machineConfigEnum = knownValue;
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

    if (!(o instanceof MachineConfig)) {
      return false;
    }

    MachineConfig other = (MachineConfig) o;

    if (this.machineConfigEnum != Known.MACHINE_CONFIG_UNSPECIFIED
        && other.machineConfigEnum != Known.MACHINE_CONFIG_UNSPECIFIED) {
      return this.machineConfigEnum == other.machineConfigEnum;
    } else if (this.machineConfigEnum == Known.MACHINE_CONFIG_UNSPECIFIED
        && other.machineConfigEnum == Known.MACHINE_CONFIG_UNSPECIFIED) {
      return this.value.equals(other.value);
    }
    return false;
  }

  @ExcludeFromGeneratedCoverageReport
  @Override
  public int hashCode() {
    if (this.machineConfigEnum != Known.MACHINE_CONFIG_UNSPECIFIED) {
      return this.machineConfigEnum.hashCode();
    } else {
      return Objects.hashCode(this.value);
    }
  }

  @ExcludeFromGeneratedCoverageReport
  public Known knownEnum() {
    return this.machineConfigEnum;
  }
}
