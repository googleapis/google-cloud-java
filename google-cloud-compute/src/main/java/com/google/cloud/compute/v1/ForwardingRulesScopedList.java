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
public final class ForwardingRulesScopedList implements ApiMessage {
  private final List<ForwardingRule> forwardingRules;
  private final Warning warning;

  private ForwardingRulesScopedList() {
    this.forwardingRules = null;
    this.warning = null;
  }

  private ForwardingRulesScopedList(List<ForwardingRule> forwardingRules, Warning warning) {
    this.forwardingRules = forwardingRules;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("forwardingRules")) {
      return forwardingRules;
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

  public List<ForwardingRule> getForwardingRulesList() {
    return forwardingRules;
  }

  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ForwardingRulesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ForwardingRulesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ForwardingRulesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ForwardingRulesScopedList();
  }

  public static class Builder {
    private List<ForwardingRule> forwardingRules;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(ForwardingRulesScopedList other) {
      if (other == ForwardingRulesScopedList.getDefaultInstance()) return this;
      if (other.getForwardingRulesList() != null) {
        this.forwardingRules = other.forwardingRules;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(ForwardingRulesScopedList source) {
      this.forwardingRules = source.forwardingRules;
      this.warning = source.warning;
    }

    public List<ForwardingRule> getForwardingRulesList() {
      return forwardingRules;
    }

    public Builder addAllForwardingRules(List<ForwardingRule> forwardingRules) {
      if (this.forwardingRules == null) {
        this.forwardingRules = new ArrayList<>(forwardingRules.size());
      }
      this.forwardingRules.addAll(forwardingRules);
      return this;
    }

    public Builder addForwardingRules(ForwardingRule forwardingRules) {
      this.forwardingRules.add(forwardingRules);
      return this;
    }

    public Warning getWarning() {
      return warning;
    }

    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public ForwardingRulesScopedList build() {

      return new ForwardingRulesScopedList(forwardingRules, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllForwardingRules(this.forwardingRules);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ForwardingRulesScopedList{"
        + "forwardingRules="
        + forwardingRules
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
    if (o instanceof ForwardingRulesScopedList) {
      ForwardingRulesScopedList that = (ForwardingRulesScopedList) o;
      return Objects.equals(this.forwardingRules, that.getForwardingRulesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(forwardingRules, warning);
  }
}
