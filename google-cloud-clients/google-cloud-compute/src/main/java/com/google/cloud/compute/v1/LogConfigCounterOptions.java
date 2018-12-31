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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    if (fieldName.equals("field")) {
      return field;
    }
    if (fieldName.equals("metric")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public String getField() {
    return field;
  }

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

    public String getField() {
      return field;
    }

    public Builder setField(String field) {
      this.field = field;
      return this;
    }

    public String getMetric() {
      return metric;
    }

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
