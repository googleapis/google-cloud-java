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
/**
 * Node Affinity: the configuration of desired nodes onto which this Instance could be scheduled.
 */
public final class SchedulingNodeAffinity implements ApiMessage {
  private final String key;
  private final String operator;
  private final List<String> values;

  private SchedulingNodeAffinity() {
    this.key = null;
    this.operator = null;
    this.values = null;
  }

  private SchedulingNodeAffinity(String key, String operator, List<String> values) {
    this.key = key;
    this.operator = operator;
    this.values = values;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("operator".equals(fieldName)) {
      return operator;
    }
    if ("values".equals(fieldName)) {
      return values;
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

  /** Corresponds to the label key of Node resource. */
  public String getKey() {
    return key;
  }

  /**
   * Defines the operation of node selection. Valid operators are IN for affinity and NOT_IN for
   * anti-affinity.
   */
  public String getOperator() {
    return operator;
  }

  /** Corresponds to the label values of Node resource. */
  public List<String> getValuesList() {
    return values;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SchedulingNodeAffinity prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SchedulingNodeAffinity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SchedulingNodeAffinity DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SchedulingNodeAffinity();
  }

  public static class Builder {
    private String key;
    private String operator;
    private List<String> values;

    Builder() {}

    public Builder mergeFrom(SchedulingNodeAffinity other) {
      if (other == SchedulingNodeAffinity.getDefaultInstance()) return this;
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getOperator() != null) {
        this.operator = other.operator;
      }
      if (other.getValuesList() != null) {
        this.values = other.values;
      }
      return this;
    }

    Builder(SchedulingNodeAffinity source) {
      this.key = source.key;
      this.operator = source.operator;
      this.values = source.values;
    }

    /** Corresponds to the label key of Node resource. */
    public String getKey() {
      return key;
    }

    /** Corresponds to the label key of Node resource. */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /**
     * Defines the operation of node selection. Valid operators are IN for affinity and NOT_IN for
     * anti-affinity.
     */
    public String getOperator() {
      return operator;
    }

    /**
     * Defines the operation of node selection. Valid operators are IN for affinity and NOT_IN for
     * anti-affinity.
     */
    public Builder setOperator(String operator) {
      this.operator = operator;
      return this;
    }

    /** Corresponds to the label values of Node resource. */
    public List<String> getValuesList() {
      return values;
    }

    /** Corresponds to the label values of Node resource. */
    public Builder addAllValues(List<String> values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.addAll(values);
      return this;
    }

    /** Corresponds to the label values of Node resource. */
    public Builder addValues(String values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.add(values);
      return this;
    }

    public SchedulingNodeAffinity build() {

      return new SchedulingNodeAffinity(key, operator, values);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKey(this.key);
      newBuilder.setOperator(this.operator);
      newBuilder.addAllValues(this.values);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SchedulingNodeAffinity{"
        + "key="
        + key
        + ", "
        + "operator="
        + operator
        + ", "
        + "values="
        + values
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SchedulingNodeAffinity) {
      SchedulingNodeAffinity that = (SchedulingNodeAffinity) o;
      return Objects.equals(this.key, that.getKey())
          && Objects.equals(this.operator, that.getOperator())
          && Objects.equals(this.values, that.getValuesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, operator, values);
  }
}
