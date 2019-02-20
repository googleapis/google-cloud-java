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
 * Specifies the audit configuration for a service. The configuration determines which permission
 * types are logged, and what identities, if any, are exempted from logging. An AuditConfig must
 * have one or more AuditLogConfigs.
 *
 * <p>If there are AuditConfigs for both `allServices` and a specific service, the union of the two
 * AuditConfigs is used for that service: the log_types specified in each AuditConfig are enabled,
 * and the exempted_members in each AuditLogConfig are exempted.
 *
 * <p>Example Policy with multiple AuditConfigs:
 *
 * <p>{ "audit_configs": [ { "service": "allServices" "audit_log_configs": [ { "log_type":
 * "DATA_READ", "exempted_members": [ "user:foo{@literal @}gmail.com" ] }, { "log_type":
 * "DATA_WRITE", }, { "log_type": "ADMIN_READ", } ] }, { "service": "fooservice.googleapis.com"
 * "audit_log_configs": [ { "log_type": "DATA_READ", }, { "log_type": "DATA_WRITE",
 * "exempted_members": [ "user:bar{@literal @}gmail.com" ] } ] } ] }
 *
 * <p>For fooservice, this policy enables DATA_READ, DATA_WRITE and ADMIN_READ logging. It also
 * exempts foo{@literal @}gmail.com from DATA_READ logging, and bar{@literal @}gmail.com from
 * DATA_WRITE logging.
 */
public final class AuditConfig implements ApiMessage {
  private final List<AuditLogConfig> auditLogConfigs;
  private final List<String> exemptedMembers;
  private final String service;

  private AuditConfig() {
    this.auditLogConfigs = null;
    this.exemptedMembers = null;
    this.service = null;
  }

  private AuditConfig(
      List<AuditLogConfig> auditLogConfigs, List<String> exemptedMembers, String service) {
    this.auditLogConfigs = auditLogConfigs;
    this.exemptedMembers = exemptedMembers;
    this.service = service;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("auditLogConfigs".equals(fieldName)) {
      return auditLogConfigs;
    }
    if ("exemptedMembers".equals(fieldName)) {
      return exemptedMembers;
    }
    if ("service".equals(fieldName)) {
      return service;
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

  /** The configuration for logging of each type of permission. */
  public List<AuditLogConfig> getAuditLogConfigsList() {
    return auditLogConfigs;
  }

  public List<String> getExemptedMembersList() {
    return exemptedMembers;
  }

  /**
   * Specifies a service that will be enabled for audit logging. For example,
   * `storage.googleapis.com`, `cloudsql.googleapis.com`. `allServices` is a special value that
   * covers all services.
   */
  public String getService() {
    return service;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AuditConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AuditConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AuditConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AuditConfig();
  }

  public static class Builder {
    private List<AuditLogConfig> auditLogConfigs;
    private List<String> exemptedMembers;
    private String service;

    Builder() {}

    public Builder mergeFrom(AuditConfig other) {
      if (other == AuditConfig.getDefaultInstance()) return this;
      if (other.getAuditLogConfigsList() != null) {
        this.auditLogConfigs = other.auditLogConfigs;
      }
      if (other.getExemptedMembersList() != null) {
        this.exemptedMembers = other.exemptedMembers;
      }
      if (other.getService() != null) {
        this.service = other.service;
      }
      return this;
    }

    Builder(AuditConfig source) {
      this.auditLogConfigs = source.auditLogConfigs;
      this.exemptedMembers = source.exemptedMembers;
      this.service = source.service;
    }

    /** The configuration for logging of each type of permission. */
    public List<AuditLogConfig> getAuditLogConfigsList() {
      return auditLogConfigs;
    }

    /** The configuration for logging of each type of permission. */
    public Builder addAllAuditLogConfigs(List<AuditLogConfig> auditLogConfigs) {
      if (this.auditLogConfigs == null) {
        this.auditLogConfigs = new LinkedList<>();
      }
      this.auditLogConfigs.addAll(auditLogConfigs);
      return this;
    }

    /** The configuration for logging of each type of permission. */
    public Builder addAuditLogConfigs(AuditLogConfig auditLogConfigs) {
      if (this.auditLogConfigs == null) {
        this.auditLogConfigs = new LinkedList<>();
      }
      this.auditLogConfigs.add(auditLogConfigs);
      return this;
    }

    public List<String> getExemptedMembersList() {
      return exemptedMembers;
    }

    public Builder addAllExemptedMembers(List<String> exemptedMembers) {
      if (this.exemptedMembers == null) {
        this.exemptedMembers = new LinkedList<>();
      }
      this.exemptedMembers.addAll(exemptedMembers);
      return this;
    }

    public Builder addExemptedMembers(String exemptedMembers) {
      if (this.exemptedMembers == null) {
        this.exemptedMembers = new LinkedList<>();
      }
      this.exemptedMembers.add(exemptedMembers);
      return this;
    }

    /**
     * Specifies a service that will be enabled for audit logging. For example,
     * `storage.googleapis.com`, `cloudsql.googleapis.com`. `allServices` is a special value that
     * covers all services.
     */
    public String getService() {
      return service;
    }

    /**
     * Specifies a service that will be enabled for audit logging. For example,
     * `storage.googleapis.com`, `cloudsql.googleapis.com`. `allServices` is a special value that
     * covers all services.
     */
    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public AuditConfig build() {

      return new AuditConfig(auditLogConfigs, exemptedMembers, service);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAuditLogConfigs(this.auditLogConfigs);
      newBuilder.addAllExemptedMembers(this.exemptedMembers);
      newBuilder.setService(this.service);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AuditConfig{"
        + "auditLogConfigs="
        + auditLogConfigs
        + ", "
        + "exemptedMembers="
        + exemptedMembers
        + ", "
        + "service="
        + service
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AuditConfig) {
      AuditConfig that = (AuditConfig) o;
      return Objects.equals(this.auditLogConfigs, that.getAuditLogConfigsList())
          && Objects.equals(this.exemptedMembers, that.getExemptedMembersList())
          && Objects.equals(this.service, that.getService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(auditLogConfigs, exemptedMembers, service);
  }
}
