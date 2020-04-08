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
public final class SecurityPoliciesWafConfig implements ApiMessage {
  private final PreconfiguredWafSet wafRules;

  private SecurityPoliciesWafConfig() {
    this.wafRules = null;
  }

  private SecurityPoliciesWafConfig(PreconfiguredWafSet wafRules) {
    this.wafRules = wafRules;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("wafRules".equals(fieldName)) {
      return wafRules;
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

  public PreconfiguredWafSet getWafRules() {
    return wafRules;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SecurityPoliciesWafConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SecurityPoliciesWafConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SecurityPoliciesWafConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SecurityPoliciesWafConfig();
  }

  public static class Builder {
    private PreconfiguredWafSet wafRules;

    Builder() {}

    public Builder mergeFrom(SecurityPoliciesWafConfig other) {
      if (other == SecurityPoliciesWafConfig.getDefaultInstance()) return this;
      if (other.getWafRules() != null) {
        this.wafRules = other.wafRules;
      }
      return this;
    }

    Builder(SecurityPoliciesWafConfig source) {
      this.wafRules = source.wafRules;
    }

    public PreconfiguredWafSet getWafRules() {
      return wafRules;
    }

    public Builder setWafRules(PreconfiguredWafSet wafRules) {
      this.wafRules = wafRules;
      return this;
    }

    public SecurityPoliciesWafConfig build() {
      return new SecurityPoliciesWafConfig(wafRules);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setWafRules(this.wafRules);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SecurityPoliciesWafConfig{" + "wafRules=" + wafRules + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecurityPoliciesWafConfig) {
      SecurityPoliciesWafConfig that = (SecurityPoliciesWafConfig) o;
      return Objects.equals(this.wafRules, that.getWafRules());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(wafRules);
  }
}
