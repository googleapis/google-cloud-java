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
public final class TargetHttpProxiesScopedList implements ApiMessage {
  private final List<TargetHttpProxy> targetHttpProxies;
  private final Warning warning;

  private TargetHttpProxiesScopedList() {
    this.targetHttpProxies = null;
    this.warning = null;
  }

  private TargetHttpProxiesScopedList(List<TargetHttpProxy> targetHttpProxies, Warning warning) {
    this.targetHttpProxies = targetHttpProxies;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("targetHttpProxies".equals(fieldName)) {
      return targetHttpProxies;
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

  /** A list of TargetHttpProxies contained in this scope. */
  public List<TargetHttpProxy> getTargetHttpProxiesList() {
    return targetHttpProxies;
  }

  /** Informational warning which replaces the list of backend services when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetHttpProxiesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpProxiesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetHttpProxiesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetHttpProxiesScopedList();
  }

  public static class Builder {
    private List<TargetHttpProxy> targetHttpProxies;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(TargetHttpProxiesScopedList other) {
      if (other == TargetHttpProxiesScopedList.getDefaultInstance()) return this;
      if (other.getTargetHttpProxiesList() != null) {
        this.targetHttpProxies = other.targetHttpProxies;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(TargetHttpProxiesScopedList source) {
      this.targetHttpProxies = source.targetHttpProxies;
      this.warning = source.warning;
    }

    /** A list of TargetHttpProxies contained in this scope. */
    public List<TargetHttpProxy> getTargetHttpProxiesList() {
      return targetHttpProxies;
    }

    /** A list of TargetHttpProxies contained in this scope. */
    public Builder addAllTargetHttpProxies(List<TargetHttpProxy> targetHttpProxies) {
      if (this.targetHttpProxies == null) {
        this.targetHttpProxies = new LinkedList<>();
      }
      this.targetHttpProxies.addAll(targetHttpProxies);
      return this;
    }

    /** A list of TargetHttpProxies contained in this scope. */
    public Builder addTargetHttpProxies(TargetHttpProxy targetHttpProxies) {
      if (this.targetHttpProxies == null) {
        this.targetHttpProxies = new LinkedList<>();
      }
      this.targetHttpProxies.add(targetHttpProxies);
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

    public TargetHttpProxiesScopedList build() {

      return new TargetHttpProxiesScopedList(targetHttpProxies, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllTargetHttpProxies(this.targetHttpProxies);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpProxiesScopedList{"
        + "targetHttpProxies="
        + targetHttpProxies
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
    if (o instanceof TargetHttpProxiesScopedList) {
      TargetHttpProxiesScopedList that = (TargetHttpProxiesScopedList) o;
      return Objects.equals(this.targetHttpProxies, that.getTargetHttpProxiesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(targetHttpProxies, warning);
  }
}
