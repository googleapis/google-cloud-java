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
public final class TargetHttpsProxiesScopedList implements ApiMessage {
  private final List<TargetHttpsProxy> targetHttpsProxies;
  private final Warning warning;

  private TargetHttpsProxiesScopedList() {
    this.targetHttpsProxies = null;
    this.warning = null;
  }

  private TargetHttpsProxiesScopedList(List<TargetHttpsProxy> targetHttpsProxies, Warning warning) {
    this.targetHttpsProxies = targetHttpsProxies;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("targetHttpsProxies".equals(fieldName)) {
      return targetHttpsProxies;
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

  /** A list of TargetHttpsProxies contained in this scope. */
  public List<TargetHttpsProxy> getTargetHttpsProxiesList() {
    return targetHttpsProxies;
  }

  /** Informational warning which replaces the list of backend services when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetHttpsProxiesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpsProxiesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetHttpsProxiesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetHttpsProxiesScopedList();
  }

  public static class Builder {
    private List<TargetHttpsProxy> targetHttpsProxies;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(TargetHttpsProxiesScopedList other) {
      if (other == TargetHttpsProxiesScopedList.getDefaultInstance()) return this;
      if (other.getTargetHttpsProxiesList() != null) {
        this.targetHttpsProxies = other.targetHttpsProxies;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(TargetHttpsProxiesScopedList source) {
      this.targetHttpsProxies = source.targetHttpsProxies;
      this.warning = source.warning;
    }

    /** A list of TargetHttpsProxies contained in this scope. */
    public List<TargetHttpsProxy> getTargetHttpsProxiesList() {
      return targetHttpsProxies;
    }

    /** A list of TargetHttpsProxies contained in this scope. */
    public Builder addAllTargetHttpsProxies(List<TargetHttpsProxy> targetHttpsProxies) {
      if (this.targetHttpsProxies == null) {
        this.targetHttpsProxies = new LinkedList<>();
      }
      this.targetHttpsProxies.addAll(targetHttpsProxies);
      return this;
    }

    /** A list of TargetHttpsProxies contained in this scope. */
    public Builder addTargetHttpsProxies(TargetHttpsProxy targetHttpsProxies) {
      if (this.targetHttpsProxies == null) {
        this.targetHttpsProxies = new LinkedList<>();
      }
      this.targetHttpsProxies.add(targetHttpsProxies);
      return this;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public TargetHttpsProxiesScopedList build() {

      return new TargetHttpsProxiesScopedList(targetHttpsProxies, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllTargetHttpsProxies(this.targetHttpsProxies);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpsProxiesScopedList{"
        + "targetHttpsProxies="
        + targetHttpsProxies
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
    if (o instanceof TargetHttpsProxiesScopedList) {
      TargetHttpsProxiesScopedList that = (TargetHttpsProxiesScopedList) o;
      return Objects.equals(this.targetHttpsProxies, that.getTargetHttpsProxiesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetHttpsProxies, warning);
  }
}
