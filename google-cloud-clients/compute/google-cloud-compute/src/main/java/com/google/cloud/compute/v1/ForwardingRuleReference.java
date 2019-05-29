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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class ForwardingRuleReference implements ApiMessage {
  private final String forwardingRule;

  private ForwardingRuleReference() {
    this.forwardingRule = null;
  }

  private ForwardingRuleReference(String forwardingRule) {
    this.forwardingRule = forwardingRule;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("forwardingRule".equals(fieldName)) {
      return forwardingRule;
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

  public String getForwardingRule() {
    return forwardingRule;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ForwardingRuleReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ForwardingRuleReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ForwardingRuleReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ForwardingRuleReference();
  }

  public static class Builder {
    private String forwardingRule;

    Builder() {}

    public Builder mergeFrom(ForwardingRuleReference other) {
      if (other == ForwardingRuleReference.getDefaultInstance()) return this;
      if (other.getForwardingRule() != null) {
        this.forwardingRule = other.forwardingRule;
      }
      return this;
    }

    Builder(ForwardingRuleReference source) {
      this.forwardingRule = source.forwardingRule;
    }

    public String getForwardingRule() {
      return forwardingRule;
    }

    public Builder setForwardingRule(String forwardingRule) {
      this.forwardingRule = forwardingRule;
      return this;
    }

    public ForwardingRuleReference build() {
      return new ForwardingRuleReference(forwardingRule);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setForwardingRule(this.forwardingRule);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ForwardingRuleReference{" + "forwardingRule=" + forwardingRule + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ForwardingRuleReference) {
      ForwardingRuleReference that = (ForwardingRuleReference) o;
      return Objects.equals(this.forwardingRule, that.getForwardingRule());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(forwardingRule);
  }
}
