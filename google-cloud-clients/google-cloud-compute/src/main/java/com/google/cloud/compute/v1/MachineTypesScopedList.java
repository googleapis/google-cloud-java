/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.httpjson.ApiMessage;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class MachineTypesScopedList implements ApiMessage {
  private final List<MachineType> machineTypes;
  private final Warning warning;

  private MachineTypesScopedList() {
    this.machineTypes = null;
    this.warning = null;
  }

  private MachineTypesScopedList(List<MachineType> machineTypes, Warning warning) {
    this.machineTypes = machineTypes;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("machineTypes".equals(fieldName)) {
      return machineTypes;
    }
    if ("warning".equals(fieldName)) {
      return warning;
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
  }

  @Nullable
  @Override
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** [Output Only] A list of machine types contained in this scope. */
  public List<MachineType> getMachineTypesList() {
    return machineTypes;
  }

  /** [Output Only] An informational warning that appears when the machine types list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(MachineTypesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static MachineTypesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final MachineTypesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new MachineTypesScopedList();
  }

  public static class Builder {
    private List<MachineType> machineTypes;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(MachineTypesScopedList other) {
      if (other == MachineTypesScopedList.getDefaultInstance()) return this;
      if (other.getMachineTypesList() != null) {
        this.machineTypes = other.machineTypes;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(MachineTypesScopedList source) {
      this.machineTypes = source.machineTypes;
      this.warning = source.warning;
    }

    /** [Output Only] A list of machine types contained in this scope. */
    public List<MachineType> getMachineTypesList() {
      return machineTypes;
    }

    /** [Output Only] A list of machine types contained in this scope. */
    public Builder addAllMachineTypes(List<MachineType> machineTypes) {
      if (this.machineTypes == null) {
        this.machineTypes = new LinkedList<>();
      }
      this.machineTypes.addAll(machineTypes);
      return this;
    }

    /** [Output Only] A list of machine types contained in this scope. */
    public Builder addMachineTypes(MachineType machineTypes) {
      if (this.machineTypes == null) {
        this.machineTypes = new LinkedList<>();
      }
      this.machineTypes.add(machineTypes);
      return this;
    }

    /** [Output Only] An informational warning that appears when the machine types list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** [Output Only] An informational warning that appears when the machine types list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public MachineTypesScopedList build() {

      return new MachineTypesScopedList(machineTypes, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllMachineTypes(this.machineTypes);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "MachineTypesScopedList{"
        + "machineTypes="
        + machineTypes
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MachineTypesScopedList) {
      MachineTypesScopedList that = (MachineTypesScopedList) o;
      return Objects.equals(this.machineTypes, that.getMachineTypesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(machineTypes, warning);
  }
}
