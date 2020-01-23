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
 * counter /iam/policy/debug_access_count {iam_principal=[value of IAMContext.principal]}
 *
 * <p>TODO(b/141846426): Consider supporting "authority" and "iam_principal" fields in the same
 * counter.
 */
public final class LogConfigCounterOptions implements ApiMessage {
  private final List<LogConfigCounterOptionsCustomField> customFields;
  private final String field;
  private final String metric;

  private LogConfigCounterOptions() {
    this.customFields = null;
    this.field = null;
    this.metric = null;
  }

  private LogConfigCounterOptions(
      List<LogConfigCounterOptionsCustomField> customFields, String field, String metric) {
    this.customFields = customFields;
    this.field = field;
    this.metric = metric;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("customFields".equals(fieldName)) {
      return customFields;
    }
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

  /** Custom fields. */
  public List<LogConfigCounterOptionsCustomField> getCustomFieldsList() {
    return customFields;
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
    private List<LogConfigCounterOptionsCustomField> customFields;
    private String field;
    private String metric;

    Builder() {}

    public Builder mergeFrom(LogConfigCounterOptions other) {
      if (other == LogConfigCounterOptions.getDefaultInstance()) return this;
      if (other.getCustomFieldsList() != null) {
        this.customFields = other.customFields;
      }
      if (other.getField() != null) {
        this.field = other.field;
      }
      if (other.getMetric() != null) {
        this.metric = other.metric;
      }
      return this;
    }

    Builder(LogConfigCounterOptions source) {
      this.customFields = source.customFields;
      this.field = source.field;
      this.metric = source.metric;
    }

    /** Custom fields. */
    public List<LogConfigCounterOptionsCustomField> getCustomFieldsList() {
      return customFields;
    }

    /** Custom fields. */
    public Builder addAllCustomFields(List<LogConfigCounterOptionsCustomField> customFields) {
      if (this.customFields == null) {
        this.customFields = new LinkedList<>();
      }
      this.customFields.addAll(customFields);
      return this;
    }

    /** Custom fields. */
    public Builder addCustomFields(LogConfigCounterOptionsCustomField customFields) {
      if (this.customFields == null) {
        this.customFields = new LinkedList<>();
      }
      this.customFields.add(customFields);
      return this;
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

      return new LogConfigCounterOptions(customFields, field, metric);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllCustomFields(this.customFields);
      newBuilder.setField(this.field);
      newBuilder.setMetric(this.metric);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LogConfigCounterOptions{"
        + "customFields="
        + customFields
        + ", "
        + "field="
        + field
        + ", "
        + "metric="
        + metric
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfigCounterOptions) {
      LogConfigCounterOptions that = (LogConfigCounterOptions) o;
      return Objects.equals(this.customFields, that.getCustomFieldsList())
          && Objects.equals(this.field, that.getField())
          && Objects.equals(this.metric, that.getMetric());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(customFields, field, metric);
  }
}
