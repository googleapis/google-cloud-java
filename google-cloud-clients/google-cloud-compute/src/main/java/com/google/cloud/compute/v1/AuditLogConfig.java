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
 * Provides the configuration for logging a type of permissions. Example:
 *
 * <p>{ "audit_log_configs": [ { "log_type": "DATA_READ", "exempted_members": [
 * "user:foo{@literal @}gmail.com" ] }, { "log_type": "DATA_WRITE", } ] }
 *
 * <p>This enables 'DATA_READ' and 'DATA_WRITE' logging, while exempting foo{@literal @}gmail.com
 * from DATA_READ logging.
 */
public final class AuditLogConfig implements ApiMessage {
  private final List<String> exemptedMembers;
  private final String logType;

  private AuditLogConfig() {
    this.exemptedMembers = null;
    this.logType = null;
  }

  private AuditLogConfig(List<String> exemptedMembers, String logType) {
    this.exemptedMembers = exemptedMembers;
    this.logType = logType;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("exemptedMembers".equals(fieldName)) {
      return exemptedMembers;
    }
    if ("logType".equals(fieldName)) {
      return logType;
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

  /**
   * Specifies the identities that do not cause logging for this type of permission. Follows the
   * same format of [Binding.members][].
   */
  public List<String> getExemptedMembersList() {
    return exemptedMembers;
  }

  /** The log type that this config enables. */
  public String getLogType() {
    return logType;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AuditLogConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AuditLogConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AuditLogConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AuditLogConfig();
  }

  public static class Builder {
    private List<String> exemptedMembers;
    private String logType;

    Builder() {}

    public Builder mergeFrom(AuditLogConfig other) {
      if (other == AuditLogConfig.getDefaultInstance()) return this;
      if (other.getExemptedMembersList() != null) {
        this.exemptedMembers = other.exemptedMembers;
      }
      if (other.getLogType() != null) {
        this.logType = other.logType;
      }
      return this;
    }

    Builder(AuditLogConfig source) {
      this.exemptedMembers = source.exemptedMembers;
      this.logType = source.logType;
    }

    /**
     * Specifies the identities that do not cause logging for this type of permission. Follows the
     * same format of [Binding.members][].
     */
    public List<String> getExemptedMembersList() {
      return exemptedMembers;
    }

    /**
     * Specifies the identities that do not cause logging for this type of permission. Follows the
     * same format of [Binding.members][].
     */
    public Builder addAllExemptedMembers(List<String> exemptedMembers) {
      if (this.exemptedMembers == null) {
        this.exemptedMembers = new LinkedList<>();
      }
      this.exemptedMembers.addAll(exemptedMembers);
      return this;
    }

    /**
     * Specifies the identities that do not cause logging for this type of permission. Follows the
     * same format of [Binding.members][].
     */
    public Builder addExemptedMembers(String exemptedMembers) {
      if (this.exemptedMembers == null) {
        this.exemptedMembers = new LinkedList<>();
      }
      this.exemptedMembers.add(exemptedMembers);
      return this;
    }

    /** The log type that this config enables. */
    public String getLogType() {
      return logType;
    }

    /** The log type that this config enables. */
    public Builder setLogType(String logType) {
      this.logType = logType;
      return this;
    }

    public AuditLogConfig build() {

      return new AuditLogConfig(exemptedMembers, logType);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllExemptedMembers(this.exemptedMembers);
      newBuilder.setLogType(this.logType);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AuditLogConfig{"
        + "exemptedMembers="
        + exemptedMembers
        + ", "
        + "logType="
        + logType
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AuditLogConfig) {
      AuditLogConfig that = (AuditLogConfig) o;
      return Objects.equals(this.exemptedMembers, that.getExemptedMembersList())
          && Objects.equals(this.logType, that.getLogType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(exemptedMembers, logType);
  }
}
