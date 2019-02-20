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
/**
 * Increment a streamz counter with the specified metric and field names.
 *
 * <p>Metric names should start with a '/', generally be lowercase-only, and end in "_count". Field
 * names should not contain an initial slash. The actual exported metric names will have
 * "/iam/policy" prepended.
 *
 * <p>Field names correspond to IAM request parameters and field values are their respective values.
 *
 * <p>Supported field names: - "authority", which is "[token]" if IAMContext.token is present,
 * otherwise the value of IAMContext.authority_selector if present, and otherwise a representation
 * of IAMContext.principal; or - "iam_principal", a representation of IAMContext.principal even if a
 * token or authority selector is present; or - "" (empty string), resulting in a counter with no
 * fields.
 *
 * <p>Examples: counter { metric: "/debug_access_count" field: "iam_principal" } ==&gt; increment
 * counter /iam/policy/backend_debug_access_count {iam_principal=[value of IAMContext.principal]}
 *
 * <p>At this time we do not support multiple field names (though this may be supported in the
 * future).
 */
public final class LogConfigCounterOptions implements ApiMessage {
  private final String field;
  private final String metric;

  private LogConfigCounterOptions() {
    this.field = null;
    this.metric = null;
  }

  private LogConfigCounterOptions(String field, String metric) {
    this.field = field;
    this.metric = metric;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("field".equals(fieldName)) {
      return field;
    }
    if ("metric".equals(fieldName)) {
      return metric;
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

  /** The field value to attribute. */
  public String getField() {
    return field;
  }

  /** The metric to update. */
  public String getMetric() {
    return metric;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LogConfigCounterOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LogConfigCounterOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LogConfigCounterOptions DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LogConfigCounterOptions();
  }

  public static class Builder {
    private String field;
    private String metric;

    Builder() {}

    public Builder mergeFrom(LogConfigCounterOptions other) {
      if (other == LogConfigCounterOptions.getDefaultInstance()) return this;
      if (other.getField() != null) {
        this.field = other.field;
      }
      if (other.getMetric() != null) {
        this.metric = other.metric;
      }
      return this;
    }

    Builder(LogConfigCounterOptions source) {
      this.field = source.field;
      this.metric = source.metric;
    }

    /** The field value to attribute. */
    public String getField() {
      return field;
    }

    /** The field value to attribute. */
    public Builder setField(String field) {
      this.field = field;
      return this;
    }

    /** The metric to update. */
    public String getMetric() {
      return metric;
    }

    /** The metric to update. */
    public Builder setMetric(String metric) {
      this.metric = metric;
      return this;
    }

    public LogConfigCounterOptions build() {

      return new LogConfigCounterOptions(field, metric);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setField(this.field);
      newBuilder.setMetric(this.metric);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LogConfigCounterOptions{" + "field=" + field + ", " + "metric=" + metric + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfigCounterOptions) {
      LogConfigCounterOptions that = (LogConfigCounterOptions) o;
      return Objects.equals(this.field, that.getField())
          && Objects.equals(this.metric, that.getMetric());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, metric);
  }
}
