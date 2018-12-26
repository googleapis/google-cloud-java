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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
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
    if (fieldName.equals("auditLogConfigs")) {
      return auditLogConfigs;
    }
    if (fieldName.equals("exemptedMembers")) {
      return exemptedMembers;
    }
    if (fieldName.equals("service")) {
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
  public List<String> getFieldMask() {
    return null;
  }

  public List<AuditLogConfig> getAuditLogConfigsList() {
    return auditLogConfigs;
  }

  public List<String> getExemptedMembersList() {
    return exemptedMembers;
  }

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

    public List<AuditLogConfig> getAuditLogConfigsList() {
      return auditLogConfigs;
    }

    public Builder addAllAuditLogConfigs(List<AuditLogConfig> auditLogConfigs) {
      if (this.auditLogConfigs == null) {
        this.auditLogConfigs = new LinkedList<>();
      }
      this.auditLogConfigs.addAll(auditLogConfigs);
      return this;
    }

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

    public String getService() {
      return service;
    }

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
