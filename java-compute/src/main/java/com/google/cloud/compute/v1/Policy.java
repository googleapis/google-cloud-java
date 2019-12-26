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
 * An Identity and Access Management (IAM) policy, which specifies access controls for Google Cloud
 * resources.
 *
 * <p>A `Policy` is a collection of `bindings`. A `binding` binds one or more `members` to a single
 * `role`. Members can be user accounts, service accounts, Google groups, and domains (such as G
 * Suite). A `role` is a named list of permissions; each `role` can be an IAM predefined role or a
 * user-created custom role.
 *
 * <p>Optionally, a `binding` can specify a `condition`, which is a logical expression that allows
 * access to a resource only if the expression evaluates to `true`. A condition can add constraints
 * based on attributes of the request, the resource, or both.
 *
 * <p>&#42;&#42;JSON example:&#42;&#42;
 *
 * <p>{ "bindings": [ { "role": "roles/resourcemanager.organizationAdmin", "members": [
 * "user:mike{@literal @}example.com", "group:admins{@literal @}example.com", "domain:google.com",
 * "serviceAccount:my-project-id{@literal @}appspot.gserviceaccount.com" ] }, { "role":
 * "roles/resourcemanager.organizationViewer", "members": ["user:eve{@literal @}example.com"],
 * "condition": { "title": "expirable access", "description": "Does not grant access after Sep
 * 2020", "expression": "request.time &lt; timestamp('2020-10-01T00:00:00.000Z')", } } ], "etag":
 * "BwWWja0YfJA=", "version": 3 }
 *
 * <p>&#42;&#42;YAML example:&#42;&#42;
 *
 * <p>bindings: - members: - user:mike{@literal @}example.com - group:admins{@literal @}example.com
 * - domain:google.com - serviceAccount:my-project-id{@literal @}appspot.gserviceaccount.com role:
 * roles/resourcemanager.organizationAdmin - members: - user:eve{@literal @}example.com role:
 * roles/resourcemanager.organizationViewer condition: title: expirable access description: Does not
 * grant access after Sep 2020 expression: request.time &lt; timestamp('2020-10-01T00:00:00.000Z') -
 * etag: BwWWja0YfJA= - version: 3
 *
 * <p>For a description of IAM and its features, see the [IAM
 * documentation](https://cloud.google.com/iam/docs/).
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  /** Specifies cloud audit logging configuration for this policy. */
  public List<AuditConfig> getAuditConfigsList() {
    return auditConfigs;
  }

  /**
   * Associates a list of `members` to a `role`. Optionally, may specify a `condition` that
   * determines how and when the `bindings` are applied. Each of the `bindings` must contain at
   * least one member.
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
   * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag` field
   * whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to overwrite a
   * version `3` policy with a version `1` policy, and all of the conditions in the version `3`
   * policy are lost.
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

  /**
   * Specifies the format of the policy.
   *
   * <p>Valid values are `0`, `1`, and `3`. Requests that specify an invalid value are rejected.
   *
   * <p>Any operation that affects conditional role bindings must specify version `3`. This
   * requirement applies to the following operations:
   *
   * <p>&#42; Getting a policy that includes a conditional role binding &#42; Adding a conditional
   * role binding to a policy &#42; Changing a conditional role binding in a policy &#42; Removing
   * any role binding, with or without a condition, from a policy that includes conditions
   *
   * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag` field
   * whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to overwrite a
   * version `3` policy with a version `1` policy, and all of the conditions in the version `3`
   * policy are lost.
   *
   * <p>If a policy does not include any conditions, operations on that policy may specify any valid
   * version or leave the field unset.
   */
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
     * Associates a list of `members` to a `role`. Optionally, may specify a `condition` that
     * determines how and when the `bindings` are applied. Each of the `bindings` must contain at
     * least one member.
     */
    public List<Binding> getBindingsList() {
      return bindings;
    }

    /**
     * Associates a list of `members` to a `role`. Optionally, may specify a `condition` that
     * determines how and when the `bindings` are applied. Each of the `bindings` must contain at
     * least one member.
     */
    public Builder addAllBindings(List<Binding> bindings) {
      if (this.bindings == null) {
        this.bindings = new LinkedList<>();
      }
      this.bindings.addAll(bindings);
      return this;
    }

    /**
     * Associates a list of `members` to a `role`. Optionally, may specify a `condition` that
     * determines how and when the `bindings` are applied. Each of the `bindings` must contain at
     * least one member.
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
     * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag`
     * field whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to
     * overwrite a version `3` policy with a version `1` policy, and all of the conditions in the
     * version `3` policy are lost.
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
     * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag`
     * field whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to
     * overwrite a version `3` policy with a version `1` policy, and all of the conditions in the
     * version `3` policy are lost.
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

    /**
     * Specifies the format of the policy.
     *
     * <p>Valid values are `0`, `1`, and `3`. Requests that specify an invalid value are rejected.
     *
     * <p>Any operation that affects conditional role bindings must specify version `3`. This
     * requirement applies to the following operations:
     *
     * <p>&#42; Getting a policy that includes a conditional role binding &#42; Adding a conditional
     * role binding to a policy &#42; Changing a conditional role binding in a policy &#42; Removing
     * any role binding, with or without a condition, from a policy that includes conditions
     *
     * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag`
     * field whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to
     * overwrite a version `3` policy with a version `1` policy, and all of the conditions in the
     * version `3` policy are lost.
     *
     * <p>If a policy does not include any conditions, operations on that policy may specify any
     * valid version or leave the field unset.
     */
    public Integer getVersion() {
      return version;
    }

    /**
     * Specifies the format of the policy.
     *
     * <p>Valid values are `0`, `1`, and `3`. Requests that specify an invalid value are rejected.
     *
     * <p>Any operation that affects conditional role bindings must specify version `3`. This
     * requirement applies to the following operations:
     *
     * <p>&#42; Getting a policy that includes a conditional role binding &#42; Adding a conditional
     * role binding to a policy &#42; Changing a conditional role binding in a policy &#42; Removing
     * any role binding, with or without a condition, from a policy that includes conditions
     *
     * <p>&#42;&#42;Important:&#42;&#42; If you use IAM Conditions, you must include the `etag`
     * field whenever you call `setIamPolicy`. If you omit this field, then IAM allows you to
     * overwrite a version `3` policy with a version `1` policy, and all of the conditions in the
     * version `3` policy are lost.
     *
     * <p>If a policy does not include any conditions, operations on that policy may specify any
     * valid version or leave the field unset.
     */
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
