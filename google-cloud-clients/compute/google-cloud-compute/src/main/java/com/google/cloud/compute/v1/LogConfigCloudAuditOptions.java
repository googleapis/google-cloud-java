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
/** Write a Cloud Audit log */
public final class LogConfigCloudAuditOptions implements ApiMessage {
  private final AuthorizationLoggingOptions authorizationLoggingOptions;
  private final String logName;

  private LogConfigCloudAuditOptions() {
    this.authorizationLoggingOptions = null;
    this.logName = null;
  }

  private LogConfigCloudAuditOptions(
      AuthorizationLoggingOptions authorizationLoggingOptions, String logName) {
    this.authorizationLoggingOptions = authorizationLoggingOptions;
    this.logName = logName;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("authorizationLoggingOptions".equals(fieldName)) {
      return authorizationLoggingOptions;
    }
    if ("logName".equals(fieldName)) {
      return logName;
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

  /** Information used by the Cloud Audit Logging pipeline. */
  public AuthorizationLoggingOptions getAuthorizationLoggingOptions() {
    return authorizationLoggingOptions;
  }

  /** The log_name to populate in the Cloud Audit Record. */
  public String getLogName() {
    return logName;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LogConfigCloudAuditOptions prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LogConfigCloudAuditOptions getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LogConfigCloudAuditOptions DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LogConfigCloudAuditOptions();
  }

  public static class Builder {
    private AuthorizationLoggingOptions authorizationLoggingOptions;
    private String logName;

    Builder() {}

    public Builder mergeFrom(LogConfigCloudAuditOptions other) {
      if (other == LogConfigCloudAuditOptions.getDefaultInstance()) return this;
      if (other.getAuthorizationLoggingOptions() != null) {
        this.authorizationLoggingOptions = other.authorizationLoggingOptions;
      }
      if (other.getLogName() != null) {
        this.logName = other.logName;
      }
      return this;
    }

    Builder(LogConfigCloudAuditOptions source) {
      this.authorizationLoggingOptions = source.authorizationLoggingOptions;
      this.logName = source.logName;
    }

    /** Information used by the Cloud Audit Logging pipeline. */
    public AuthorizationLoggingOptions getAuthorizationLoggingOptions() {
      return authorizationLoggingOptions;
    }

    /** Information used by the Cloud Audit Logging pipeline. */
    public Builder setAuthorizationLoggingOptions(
        AuthorizationLoggingOptions authorizationLoggingOptions) {
      this.authorizationLoggingOptions = authorizationLoggingOptions;
      return this;
    }

    /** The log_name to populate in the Cloud Audit Record. */
    public String getLogName() {
      return logName;
    }

    /** The log_name to populate in the Cloud Audit Record. */
    public Builder setLogName(String logName) {
      this.logName = logName;
      return this;
    }

    public LogConfigCloudAuditOptions build() {

      return new LogConfigCloudAuditOptions(authorizationLoggingOptions, logName);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAuthorizationLoggingOptions(this.authorizationLoggingOptions);
      newBuilder.setLogName(this.logName);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LogConfigCloudAuditOptions{"
        + "authorizationLoggingOptions="
        + authorizationLoggingOptions
        + ", "
        + "logName="
        + logName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfigCloudAuditOptions) {
      LogConfigCloudAuditOptions that = (LogConfigCloudAuditOptions) o;
      return Objects.equals(this.authorizationLoggingOptions, that.getAuthorizationLoggingOptions())
          && Objects.equals(this.logName, that.getLogName());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(authorizationLoggingOptions, logName);
  }
}
