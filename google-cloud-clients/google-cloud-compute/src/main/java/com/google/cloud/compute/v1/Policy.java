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
 * Defines an Identity and Access Management (IAM) policy. It is used to specify access control
 * policies for Cloud Platform resources.
 *
 * <p>A `Policy` consists of a list of `bindings`. A `binding` binds a list of `members` to a
 * `role`, where the members can be user accounts, Google groups, Google domains, and service
 * accounts. A `role` is a named list of permissions defined by IAM.
 *
 * <p>&#42;&#42;JSON Example&#42;&#42;
 *
 * <p>{ "bindings": [ { "role": "roles/owner", "members": [ "user:mike{@literal @}example.com",
 * "group:admins{@literal @}example.com", "domain:google.com",
 * "serviceAccount:my-other-app{@literal @}appspot.gserviceaccount.com" ] }, { "role":
 * "roles/viewer", "members": ["user:sean{@literal @}example.com"] } ] }
 *
 * <p>&#42;&#42;YAML Example&#42;&#42;
 *
 * <p>bindings: - members: - user:mike{@literal @}example.com - group:admins{@literal @}example.com
 * - domain:google.com - serviceAccount:my-other-app{@literal @}appspot.gserviceaccount.com role:
 * roles/owner - members: - user:sean{@literal @}example.com role: roles/viewer
 *
 * <p>For a description of IAM and its features, see the [IAM developer's
 * guide](https://cloud.google.com/iam/docs).
 */
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
    if ("auditConfigs".equals(fieldName)) {
      return auditConfigs;
    }
    if ("bindings".equals(fieldName)) {
      return bindings;
    }
    if ("etag".equals(fieldName)) {
      return etag;
    }
    if ("iamOwned".equals(fieldName)) {
      return iamOwned;
    }
    if ("rules".equals(fieldName)) {
      return rules;
    }
    if ("version".equals(fieldName)) {
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

  /** Specifies cloud audit logging configuration for this policy. */
  public List<AuditConfig> getAuditConfigsList() {
    return auditConfigs;
  }

  /**
   * Associates a list of `members` to a `role`. `bindings` with no members will result in an error.
   */
  public List<Binding> getBindingsList() {
    return bindings;
  }

  /**
   * `etag` is used for optimistic concurrency control as a way to help prevent simultaneous updates
   * of a policy from overwriting each other. It is strongly suggested that systems make use of the
   * `etag` in the read-modify-write cycle to perform policy updates in order to avoid race
   * conditions: An `etag` is returned in the response to `getIamPolicy`, and systems are expected
   * to put that etag in the request to `setIamPolicy` to ensure that their change will be applied
   * to the same version of the policy.
   *
   * <p>If no `etag` is provided in the call to `setIamPolicy`, then the existing policy is
   * overwritten blindly.
   */
  public String getEtag() {
    return etag;
  }

  public Boolean getIamOwned() {
    return iamOwned;
  }

  /**
   * If more than one rule is specified, the rules are applied in the following manner: - All
   * matching LOG rules are always applied. - If any DENY/DENY_WITH_LOG rule matches, permission is
   * denied. Logging will be applied if one or more matching rule requires logging. - Otherwise, if
   * any ALLOW/ALLOW_WITH_LOG rule matches, permission is granted. Logging will be applied if one or
   * more matching rule requires logging. - Otherwise, if no rule applies, permission is denied.
   */
  public List<Rule> getRulesList() {
    return rules;
  }

  /** Deprecated. */
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

    /** Specifies cloud audit logging configuration for this policy. */
    public List<AuditConfig> getAuditConfigsList() {
      return auditConfigs;
    }

    /** Specifies cloud audit logging configuration for this policy. */
    public Builder addAllAuditConfigs(List<AuditConfig> auditConfigs) {
      if (this.auditConfigs == null) {
        this.auditConfigs = new LinkedList<>();
      }
      this.auditConfigs.addAll(auditConfigs);
      return this;
    }

    /** Specifies cloud audit logging configuration for this policy. */
    public Builder addAuditConfigs(AuditConfig auditConfigs) {
      if (this.auditConfigs == null) {
        this.auditConfigs = new LinkedList<>();
      }
      this.auditConfigs.add(auditConfigs);
      return this;
    }

    /**
     * Associates a list of `members` to a `role`. `bindings` with no members will result in an
     * error.
     */
    public List<Binding> getBindingsList() {
      return bindings;
    }

    /**
     * Associates a list of `members` to a `role`. `bindings` with no members will result in an
     * error.
     */
    public Builder addAllBindings(List<Binding> bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.addAll(bindings);
      return this;
    }

    /**
     * Associates a list of `members` to a `role`. `bindings` with no members will result in an
     * error.
     */
    public Builder addBindings(Binding bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.add(bindings);
      return this;
    }

    /**
     * `etag` is used for optimistic concurrency control as a way to help prevent simultaneous
     * updates of a policy from overwriting each other. It is strongly suggested that systems make
     * use of the `etag` in the read-modify-write cycle to perform policy updates in order to avoid
     * race conditions: An `etag` is returned in the response to `getIamPolicy`, and systems are
     * expected to put that etag in the request to `setIamPolicy` to ensure that their change will
     * be applied to the same version of the policy.
     *
     * <p>If no `etag` is provided in the call to `setIamPolicy`, then the existing policy is
     * overwritten blindly.
     */
    public String getEtag() {
      return etag;
    }

    /**
     * `etag` is used for optimistic concurrency control as a way to help prevent simultaneous
     * updates of a policy from overwriting each other. It is strongly suggested that systems make
     * use of the `etag` in the read-modify-write cycle to perform policy updates in order to avoid
     * race conditions: An `etag` is returned in the response to `getIamPolicy`, and systems are
     * expected to put that etag in the request to `setIamPolicy` to ensure that their change will
     * be applied to the same version of the policy.
     *
     * <p>If no `etag` is provided in the call to `setIamPolicy`, then the existing policy is
     * overwritten blindly.
     */
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

    /**
     * If more than one rule is specified, the rules are applied in the following manner: - All
     * matching LOG rules are always applied. - If any DENY/DENY_WITH_LOG rule matches, permission
     * is denied. Logging will be applied if one or more matching rule requires logging. -
     * Otherwise, if any ALLOW/ALLOW_WITH_LOG rule matches, permission is granted. Logging will be
     * applied if one or more matching rule requires logging. - Otherwise, if no rule applies,
     * permission is denied.
     */
    public List<Rule> getRulesList() {
      return rules;
    }

    /**
     * If more than one rule is specified, the rules are applied in the following manner: - All
     * matching LOG rules are always applied. - If any DENY/DENY_WITH_LOG rule matches, permission
     * is denied. Logging will be applied if one or more matching rule requires logging. -
     * Otherwise, if any ALLOW/ALLOW_WITH_LOG rule matches, permission is granted. Logging will be
     * applied if one or more matching rule requires logging. - Otherwise, if no rule applies,
     * permission is denied.
     */
    public Builder addAllRules(List<Rule> rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.addAll(rules);
      return this;
    }

    /**
     * If more than one rule is specified, the rules are applied in the following manner: - All
     * matching LOG rules are always applied. - If any DENY/DENY_WITH_LOG rule matches, permission
     * is denied. Logging will be applied if one or more matching rule requires logging. -
     * Otherwise, if any ALLOW/ALLOW_WITH_LOG rule matches, permission is granted. Logging will be
     * applied if one or more matching rule requires logging. - Otherwise, if no rule applies,
     * permission is denied.
     */
    public Builder addRules(Rule rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.add(rules);
      return this;
    }

    /** Deprecated. */
    public Integer getVersion() {
      return version;
    }

    /** Deprecated. */
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
