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
public final class Policy implements ApiMessage {
  private final List<AuditConfig> auditConfigs;
  private final List<Binding> bindings;
  private final String etag;
  private final Boolean iamOwned;
  private final List<Rule> rules;
  private final Integer version;

  private Policy() {
    this.auditConfigs = null;
    this.bindings = null;
    this.etag = null;
    this.iamOwned = null;
    this.rules = null;
    this.version = null;
  }

  private Policy(
      List<AuditConfig> auditConfigs,
      List<Binding> bindings,
      String etag,
      Boolean iamOwned,
      List<Rule> rules,
      Integer version) {
    this.auditConfigs = auditConfigs;
    this.bindings = bindings;
    this.etag = etag;
    this.iamOwned = iamOwned;
    this.rules = rules;
    this.version = version;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("auditConfigs")) {
      return auditConfigs;
    }
    if (fieldName.equals("bindings")) {
      return bindings;
    }
    if (fieldName.equals("etag")) {
      return etag;
    }
    if (fieldName.equals("iamOwned")) {
      return iamOwned;
    }
    if (fieldName.equals("rules")) {
      return rules;
    }
    if (fieldName.equals("version")) {
      return version;
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

  public List<AuditConfig> getAuditConfigsList() {
    return auditConfigs;
  }

  public List<Binding> getBindingsList() {
    return bindings;
  }

  public String getEtag() {
    return etag;
  }

  public Boolean getIamOwned() {
    return iamOwned;
  }

  public List<Rule> getRulesList() {
    return rules;
  }

  public Integer getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Policy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Policy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Policy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Policy();
  }

  public static class Builder {
    private List<AuditConfig> auditConfigs;
    private List<Binding> bindings;
    private String etag;
    private Boolean iamOwned;
    private List<Rule> rules;
    private Integer version;

    Builder() {}

    public Builder mergeFrom(Policy other) {
      if (other == Policy.getDefaultInstance()) return this;
      if (other.getAuditConfigsList() != null) {
        this.auditConfigs = other.auditConfigs;
      }
      if (other.getBindingsList() != null) {
        this.bindings = other.bindings;
      }
      if (other.getEtag() != null) {
        this.etag = other.etag;
      }
      if (other.getIamOwned() != null) {
        this.iamOwned = other.iamOwned;
      }
      if (other.getRulesList() != null) {
        this.rules = other.rules;
      }
      if (other.getVersion() != null) {
        this.version = other.version;
      }
      return this;
    }

    Builder(Policy source) {
      this.auditConfigs = source.auditConfigs;
      this.bindings = source.bindings;
      this.etag = source.etag;
      this.iamOwned = source.iamOwned;
      this.rules = source.rules;
      this.version = source.version;
    }

    public List<AuditConfig> getAuditConfigsList() {
      return auditConfigs;
    }

    public Builder addAllAuditConfigs(List<AuditConfig> auditConfigs) {
      if (this.auditConfigs == null) {
        this.auditConfigs = new LinkedList<>();
      }
      this.auditConfigs.addAll(auditConfigs);
      return this;
    }

    public Builder addAuditConfigs(AuditConfig auditConfigs) {
      if (this.auditConfigs == null) {
        this.auditConfigs = new LinkedList<>();
      }
      this.auditConfigs.add(auditConfigs);
      return this;
    }

    public List<Binding> getBindingsList() {
      return bindings;
    }

    public Builder addAllBindings(List<Binding> bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.addAll(bindings);
      return this;
    }

    public Builder addBindings(Binding bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.add(bindings);
      return this;
    }

    public String getEtag() {
      return etag;
    }

    public Builder setEtag(String etag) {
      this.etag = etag;
      return this;
    }

    public Boolean getIamOwned() {
      return iamOwned;
    }

    public Builder setIamOwned(Boolean iamOwned) {
      this.iamOwned = iamOwned;
      return this;
    }

    public List<Rule> getRulesList() {
      return rules;
    }

    public Builder addAllRules(List<Rule> rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.addAll(rules);
      return this;
    }

    public Builder addRules(Rule rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.add(rules);
      return this;
    }

    public Integer getVersion() {
      return version;
    }

    public Builder setVersion(Integer version) {
      this.version = version;
      return this;
    }

    public Policy build() {

      return new Policy(auditConfigs, bindings, etag, iamOwned, rules, version);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllAuditConfigs(this.auditConfigs);
      newBuilder.addAllBindings(this.bindings);
      newBuilder.setEtag(this.etag);
      newBuilder.setIamOwned(this.iamOwned);
      newBuilder.addAllRules(this.rules);
      newBuilder.setVersion(this.version);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Policy{"
        + "auditConfigs="
        + auditConfigs
        + ", "
        + "bindings="
        + bindings
        + ", "
        + "etag="
        + etag
        + ", "
        + "iamOwned="
        + iamOwned
        + ", "
        + "rules="
        + rules
        + ", "
        + "version="
        + version
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Policy) {
      Policy that = (Policy) o;
      return Objects.equals(this.auditConfigs, that.getAuditConfigsList())
          && Objects.equals(this.bindings, that.getBindingsList())
          && Objects.equals(this.etag, that.getEtag())
          && Objects.equals(this.iamOwned, that.getIamOwned())
          && Objects.equals(this.rules, that.getRulesList())
          && Objects.equals(this.version, that.getVersion());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(auditConfigs, bindings, etag, iamOwned, rules, version);
  }
}
