/*
 * Copyright 2018 Google LLC
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
public final class AcceleratorTypesScopedList implements ApiMessage {
  private final List<AcceleratorType> acceleratorTypes;
  private final Warning warning;

  private AcceleratorTypesScopedList() {
    this.acceleratorTypes = null;
    this.warning = null;
  }

  private AcceleratorTypesScopedList(List<AcceleratorType> acceleratorTypes, Warning warning) {
    this.acceleratorTypes = acceleratorTypes;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("acceleratorTypes")) {
      return acceleratorTypes;
    }
    if (fieldName.equals("warning")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<AcceleratorType> getAcceleratorTypesList() {
    return acceleratorTypes;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AcceleratorTypesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AcceleratorTypesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AcceleratorTypesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AcceleratorTypesScopedList();
  }

  public static class Builder {
    private List<AcceleratorType> acceleratorTypes;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(AcceleratorTypesScopedList other) {
      if (other == AcceleratorTypesScopedList.getDefaultInstance()) return this;
      if (other.getAcceleratorTypesList() != null) {
        this.acceleratorTypes = other.acceleratorTypes;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(AcceleratorTypesScopedList source) {
      this.acceleratorTypes = source.acceleratorTypes;
      this.warning = source.warning;
    }

    public List<AcceleratorType> getAcceleratorTypesList() {
      return acceleratorTypes;
    }

    public Builder addAllAcceleratorTypes(List<AcceleratorType> acceleratorTypes) {
      if (this.acceleratorTypes == null) {
        this.acceleratorTypes = new LinkedList<>();
      }
      this.acceleratorTypes.addAll(acceleratorTypes);
      return this;
    }

    public Builder addAcceleratorTypes(AcceleratorType acceleratorTypes) {
      if (this.acceleratorTypes == null) {
        this.acceleratorTypes = new LinkedList<>();
      }
      this.acceleratorTypes.add(acceleratorTypes);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public AcceleratorTypesScopedList build() {

      return new AcceleratorTypesScopedList(acceleratorTypes, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAcceleratorTypes(this.acceleratorTypes);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AcceleratorTypesScopedList{"
        + "acceleratorTypes="
        + acceleratorTypes
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
    if (o instanceof AcceleratorTypesScopedList) {
      AcceleratorTypesScopedList that = (AcceleratorTypesScopedList) o;
      return Objects.equals(this.acceleratorTypes, that.getAcceleratorTypesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceleratorTypes, warning);
  }
}
