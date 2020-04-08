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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class PreconfiguredWafSet implements ApiMessage {
  private final List<WafExpressionSet> expressionSets;

  private PreconfiguredWafSet() {
    this.expressionSets = null;
  }

  private PreconfiguredWafSet(List<WafExpressionSet> expressionSets) {
    this.expressionSets = expressionSets;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("expressionSets".equals(fieldName)) {
      return expressionSets;
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

  /** List of entities that are currently supported for WAF rules. */
  public List<WafExpressionSet> getExpressionSetsList() {
    return expressionSets;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PreconfiguredWafSet prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PreconfiguredWafSet getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PreconfiguredWafSet DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PreconfiguredWafSet();
  }

  public static class Builder {
    private List<WafExpressionSet> expressionSets;

    Builder() {}

    public Builder mergeFrom(PreconfiguredWafSet other) {
      if (other == PreconfiguredWafSet.getDefaultInstance()) return this;
      if (other.getExpressionSetsList() != null) {
        this.expressionSets = other.expressionSets;
      }
      return this;
    }

    Builder(PreconfiguredWafSet source) {
      this.expressionSets = source.expressionSets;
    }

    /** List of entities that are currently supported for WAF rules. */
    public List<WafExpressionSet> getExpressionSetsList() {
      return expressionSets;
    }

    /** List of entities that are currently supported for WAF rules. */
    public Builder addAllExpressionSets(List<WafExpressionSet> expressionSets) {
      if (this.expressionSets == null) {
        this.expressionSets = new LinkedList<>();
      }
      this.expressionSets.addAll(expressionSets);
      return this;
    }

    /** List of entities that are currently supported for WAF rules. */
    public Builder addExpressionSets(WafExpressionSet expressionSets) {
      if (this.expressionSets == null) {
        this.expressionSets = new LinkedList<>();
      }
      this.expressionSets.add(expressionSets);
      return this;
    }

    public PreconfiguredWafSet build() {
      return new PreconfiguredWafSet(expressionSets);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllExpressionSets(this.expressionSets);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PreconfiguredWafSet{" + "expressionSets=" + expressionSets + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PreconfiguredWafSet) {
      PreconfiguredWafSet that = (PreconfiguredWafSet) o;
      return Objects.equals(this.expressionSets, that.getExpressionSetsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(expressionSets);
  }
}
