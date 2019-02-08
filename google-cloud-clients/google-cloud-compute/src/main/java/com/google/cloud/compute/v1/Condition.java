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
/** A condition to be met. */
public final class Condition implements ApiMessage {
  private final String iam;
  private final String op;
  private final String svc;
  private final String sys;
  private final String value;
  private final List<String> values;

  private Condition() {
    this.iam = null;
    this.op = null;
    this.svc = null;
    this.sys = null;
    this.value = null;
    this.values = null;
  }

  private Condition(
      String iam, String op, String svc, String sys, String value, List<String> values) {
    this.iam = iam;
    this.op = op;
    this.svc = svc;
    this.sys = sys;
    this.value = value;
    this.values = values;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("iam".equals(fieldName)) {
      return iam;
    }
    if ("op".equals(fieldName)) {
      return op;
    }
    if ("svc".equals(fieldName)) {
      return svc;
    }
    if ("sys".equals(fieldName)) {
      return sys;
    }
    if ("value".equals(fieldName)) {
      return value;
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
  public List<String> getFieldMask() {
    return null;
  }

  /** Trusted attributes supplied by the IAM system. */
  public String getIam() {
    return iam;
  }

  /** An operator to apply the subject with. */
  public String getOp() {
    return op;
  }

  /** Trusted attributes discharged by the service. */
  public String getSvc() {
    return svc;
  }

  /**
   * Trusted attributes supplied by any service that owns resources and uses the IAM system for
   * access control.
   */
  public String getSys() {
    return sys;
  }

  /** DEPRECATED. Use 'values' instead. */
  public String getValue() {
    return value;
  }

  /** The objects of the condition. This is mutually exclusive with 'value'. */
  public List<String> getValuesList() {
    return values;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Condition prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Condition getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Condition DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Condition();
  }

  public static class Builder {
    private String iam;
    private String op;
    private String svc;
    private String sys;
    private String value;
    private List<String> values;

    Builder() {}

    public Builder mergeFrom(Condition other) {
      if (other == Condition.getDefaultInstance()) return this;
      if (other.getIam() != null) {
        this.iam = other.iam;
      }
      if (other.getOp() != null) {
        this.op = other.op;
      }
      if (other.getSvc() != null) {
        this.svc = other.svc;
      }
      if (other.getSys() != null) {
        this.sys = other.sys;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      if (other.getValuesList() != null) {
        this.values = other.values;
      }
      return this;
    }

    Builder(Condition source) {
      this.iam = source.iam;
      this.op = source.op;
      this.svc = source.svc;
      this.sys = source.sys;
      this.value = source.value;
      this.values = source.values;
    }

    /** Trusted attributes supplied by the IAM system. */
    public String getIam() {
      return iam;
    }

    /** Trusted attributes supplied by the IAM system. */
    public Builder setIam(String iam) {
      this.iam = iam;
      return this;
    }

    /** An operator to apply the subject with. */
    public String getOp() {
      return op;
    }

    /** An operator to apply the subject with. */
    public Builder setOp(String op) {
      this.op = op;
      return this;
    }

    /** Trusted attributes discharged by the service. */
    public String getSvc() {
      return svc;
    }

    /** Trusted attributes discharged by the service. */
    public Builder setSvc(String svc) {
      this.svc = svc;
      return this;
    }

    /**
     * Trusted attributes supplied by any service that owns resources and uses the IAM system for
     * access control.
     */
    public String getSys() {
      return sys;
    }

    /**
     * Trusted attributes supplied by any service that owns resources and uses the IAM system for
     * access control.
     */
    public Builder setSys(String sys) {
      this.sys = sys;
      return this;
    }

    /** DEPRECATED. Use 'values' instead. */
    public String getValue() {
      return value;
    }

    /** DEPRECATED. Use 'values' instead. */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    /** The objects of the condition. This is mutually exclusive with 'value'. */
    public List<String> getValuesList() {
      return values;
    }

    /** The objects of the condition. This is mutually exclusive with 'value'. */
    public Builder addAllValues(List<String> values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.addAll(values);
      return this;
    }

    /** The objects of the condition. This is mutually exclusive with 'value'. */
    public Builder addValues(String values) {
      if (this.values == null) {
        this.values = new LinkedList<>();
      }
      this.values.add(values);
      return this;
    }

    public Condition build() {

      return new Condition(iam, op, svc, sys, value, values);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setIam(this.iam);
      newBuilder.setOp(this.op);
      newBuilder.setSvc(this.svc);
      newBuilder.setSys(this.sys);
      newBuilder.setValue(this.value);
      newBuilder.addAllValues(this.values);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Condition{"
        + "iam="
        + iam
        + ", "
        + "op="
        + op
        + ", "
        + "svc="
        + svc
        + ", "
        + "sys="
        + sys
        + ", "
        + "value="
        + value
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
    if (o instanceof Condition) {
      Condition that = (Condition) o;
      return Objects.equals(this.iam, that.getIam())
          && Objects.equals(this.op, that.getOp())
          && Objects.equals(this.svc, that.getSvc())
          && Objects.equals(this.sys, that.getSys())
          && Objects.equals(this.value, that.getValue())
          && Objects.equals(this.values, that.getValuesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(iam, op, svc, sys, value, values);
  }
}
