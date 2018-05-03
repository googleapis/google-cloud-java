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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class AutoscalersScopedList implements ApiMessage {
  private final List<Autoscaler> autoscalers;
  private final Warning warning;

  private AutoscalersScopedList() {
    this.autoscalers = null;
    this.warning = null;
  }

  private AutoscalersScopedList(List<Autoscaler> autoscalers, Warning warning) {
    this.autoscalers = autoscalers;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("autoscalers")) {
      return autoscalers;
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

  public List<Autoscaler> getAutoscalersList() {
    return autoscalers;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AutoscalersScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AutoscalersScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AutoscalersScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AutoscalersScopedList();
  }

  public static class Builder {
    private List<Autoscaler> autoscalers;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(AutoscalersScopedList other) {
      if (other == AutoscalersScopedList.getDefaultInstance()) return this;
      if (other.getAutoscalersList() != null) {
        this.autoscalers = other.autoscalers;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(AutoscalersScopedList source) {
      this.autoscalers = source.autoscalers;
      this.warning = source.warning;
    }

    public List<Autoscaler> getAutoscalersList() {
      return autoscalers;
    }

    public Builder addAllAutoscalers(List<Autoscaler> autoscalers) {
      if (this.autoscalers == null) {
        this.autoscalers = new ArrayList<>(autoscalers.size());
      }
      this.autoscalers.addAll(autoscalers);
      return this;
    }

    public Builder addAutoscalers(Autoscaler autoscalers) {
      this.autoscalers.add(autoscalers);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public AutoscalersScopedList build() {

      return new AutoscalersScopedList(autoscalers, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAutoscalers(this.autoscalers);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AutoscalersScopedList{"
        + "autoscalers="
        + autoscalers
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
    if (o instanceof AutoscalersScopedList) {
      AutoscalersScopedList that = (AutoscalersScopedList) o;
      return Objects.equals(this.autoscalers, that.getAutoscalersList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoscalers, warning);
  }
}
