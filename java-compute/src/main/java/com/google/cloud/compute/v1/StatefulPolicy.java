/*
 * Copyright 2020 Google LLC
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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class StatefulPolicy implements ApiMessage {
  private final StatefulPolicyPreservedState preservedState;

  private StatefulPolicy() {
    this.preservedState = null;
  }

  private StatefulPolicy(StatefulPolicyPreservedState preservedState) {
    this.preservedState = preservedState;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("preservedState".equals(fieldName)) {
      return preservedState;
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

  public StatefulPolicyPreservedState getPreservedState() {
    return preservedState;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(StatefulPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static StatefulPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final StatefulPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new StatefulPolicy();
  }

  public static class Builder {
    private StatefulPolicyPreservedState preservedState;

    Builder() {}

    public Builder mergeFrom(StatefulPolicy other) {
      if (other == StatefulPolicy.getDefaultInstance()) return this;
      if (other.getPreservedState() != null) {
        this.preservedState = other.preservedState;
      }
      return this;
    }

    Builder(StatefulPolicy source) {
      this.preservedState = source.preservedState;
    }

    public StatefulPolicyPreservedState getPreservedState() {
      return preservedState;
    }

    public Builder setPreservedState(StatefulPolicyPreservedState preservedState) {
      this.preservedState = preservedState;
      return this;
    }

    public StatefulPolicy build() {
      return new StatefulPolicy(preservedState);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setPreservedState(this.preservedState);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "StatefulPolicy{" + "preservedState=" + preservedState + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof StatefulPolicy) {
      StatefulPolicy that = (StatefulPolicy) o;
      return Objects.equals(this.preservedState, that.getPreservedState());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(preservedState);
  }
}
