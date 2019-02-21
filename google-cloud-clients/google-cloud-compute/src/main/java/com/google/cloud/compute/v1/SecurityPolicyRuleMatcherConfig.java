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
public final class SecurityPolicyRuleMatcherConfig implements ApiMessage {
  private final List<String> srcIpRanges;

  private SecurityPolicyRuleMatcherConfig() {
    this.srcIpRanges = null;
  }

  private SecurityPolicyRuleMatcherConfig(List<String> srcIpRanges) {
    this.srcIpRanges = srcIpRanges;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("srcIpRanges".equals(fieldName)) {
      return srcIpRanges;
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

  /** CIDR IP address range. */
  public List<String> getSrcIpRangesList() {
    return srcIpRanges;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SecurityPolicyRuleMatcherConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SecurityPolicyRuleMatcherConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SecurityPolicyRuleMatcherConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SecurityPolicyRuleMatcherConfig();
  }

  public static class Builder {
    private List<String> srcIpRanges;

    Builder() {}

    public Builder mergeFrom(SecurityPolicyRuleMatcherConfig other) {
      if (other == SecurityPolicyRuleMatcherConfig.getDefaultInstance()) return this;
      if (other.getSrcIpRangesList() != null) {
        this.srcIpRanges = other.srcIpRanges;
      }
      return this;
    }

    Builder(SecurityPolicyRuleMatcherConfig source) {
      this.srcIpRanges = source.srcIpRanges;
    }

    /** CIDR IP address range. */
    public List<String> getSrcIpRangesList() {
      return srcIpRanges;
    }

    /** CIDR IP address range. */
    public Builder addAllSrcIpRanges(List<String> srcIpRanges) {
      if (this.srcIpRanges == null) {
        this.srcIpRanges = new LinkedList<>();
      }
      this.srcIpRanges.addAll(srcIpRanges);
      return this;
    }

    /** CIDR IP address range. */
    public Builder addSrcIpRanges(String srcIpRanges) {
      if (this.srcIpRanges == null) {
        this.srcIpRanges = new LinkedList<>();
      }
      this.srcIpRanges.add(srcIpRanges);
      return this;
    }

    public SecurityPolicyRuleMatcherConfig build() {
      return new SecurityPolicyRuleMatcherConfig(srcIpRanges);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllSrcIpRanges(this.srcIpRanges);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SecurityPolicyRuleMatcherConfig{" + "srcIpRanges=" + srcIpRanges + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecurityPolicyRuleMatcherConfig) {
      SecurityPolicyRuleMatcherConfig that = (SecurityPolicyRuleMatcherConfig) o;
      return Objects.equals(this.srcIpRanges, that.getSrcIpRangesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(srcIpRanges);
  }
}
