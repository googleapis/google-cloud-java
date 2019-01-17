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
public final class LogConfig implements ApiMessage {
  private final LogConfigCloudAuditOptions cloudAudit;
  private final LogConfigCounterOptions counter;
  private final LogConfigDataAccessOptions dataAccess;

  private LogConfig() {
    this.cloudAudit = null;
    this.counter = null;
    this.dataAccess = null;
  }

  private LogConfig(
      LogConfigCloudAuditOptions cloudAudit,
      LogConfigCounterOptions counter,
      LogConfigDataAccessOptions dataAccess) {
    this.cloudAudit = cloudAudit;
    this.counter = counter;
    this.dataAccess = dataAccess;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("cloudAudit".equals(fieldName)) {
      return cloudAudit;
    }
    if ("counter".equals(fieldName)) {
      return counter;
    }
    if ("dataAccess".equals(fieldName)) {
      return dataAccess;
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

  public LogConfigCloudAuditOptions getCloudAudit() {
    return cloudAudit;
  }

  public LogConfigCounterOptions getCounter() {
    return counter;
  }

  public LogConfigDataAccessOptions getDataAccess() {
    return dataAccess;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LogConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LogConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LogConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LogConfig();
  }

  public static class Builder {
    private LogConfigCloudAuditOptions cloudAudit;
    private LogConfigCounterOptions counter;
    private LogConfigDataAccessOptions dataAccess;

    Builder() {}

    public Builder mergeFrom(LogConfig other) {
      if (other == LogConfig.getDefaultInstance()) return this;
      if (other.getCloudAudit() != null) {
        this.cloudAudit = other.cloudAudit;
      }
      if (other.getCounter() != null) {
        this.counter = other.counter;
      }
      if (other.getDataAccess() != null) {
        this.dataAccess = other.dataAccess;
      }
      return this;
    }

    Builder(LogConfig source) {
      this.cloudAudit = source.cloudAudit;
      this.counter = source.counter;
      this.dataAccess = source.dataAccess;
    }

    public LogConfigCloudAuditOptions getCloudAudit() {
      return cloudAudit;
    }

    public Builder setCloudAudit(LogConfigCloudAuditOptions cloudAudit) {
      this.cloudAudit = cloudAudit;
      return this;
    }

    public LogConfigCounterOptions getCounter() {
      return counter;
    }

    public Builder setCounter(LogConfigCounterOptions counter) {
      this.counter = counter;
      return this;
    }

    public LogConfigDataAccessOptions getDataAccess() {
      return dataAccess;
    }

    public Builder setDataAccess(LogConfigDataAccessOptions dataAccess) {
      this.dataAccess = dataAccess;
      return this;
    }

    public LogConfig build() {

      return new LogConfig(cloudAudit, counter, dataAccess);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCloudAudit(this.cloudAudit);
      newBuilder.setCounter(this.counter);
      newBuilder.setDataAccess(this.dataAccess);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LogConfig{"
        + "cloudAudit="
        + cloudAudit
        + ", "
        + "counter="
        + counter
        + ", "
        + "dataAccess="
        + dataAccess
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfig) {
      LogConfig that = (LogConfig) o;
      return Objects.equals(this.cloudAudit, that.getCloudAudit())
          && Objects.equals(this.counter, that.getCounter())
          && Objects.equals(this.dataAccess, that.getDataAccess());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cloudAudit, counter, dataAccess);
  }
}
