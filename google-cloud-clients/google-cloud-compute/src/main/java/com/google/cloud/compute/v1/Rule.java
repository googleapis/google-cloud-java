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
/** A rule to be applied in a Policy. */
public final class Rule implements ApiMessage {
  private final String action;
  private final List<Condition> conditions;
  private final String description;
  private final List<String> ins;
  private final List<LogConfig> logConfigs;
  private final List<String> notIns;
  private final List<String> permissions;

  private Rule() {
    this.action = null;
    this.conditions = null;
    this.description = null;
    this.ins = null;
    this.logConfigs = null;
    this.notIns = null;
    this.permissions = null;
  }

  private Rule(
      String action,
      List<Condition> conditions,
      String description,
      List<String> ins,
      List<LogConfig> logConfigs,
      List<String> notIns,
      List<String> permissions) {
    this.action = action;
    this.conditions = conditions;
    this.description = description;
    this.ins = ins;
    this.logConfigs = logConfigs;
    this.notIns = notIns;
    this.permissions = permissions;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("action".equals(fieldName)) {
      return action;
    }
    if ("conditions".equals(fieldName)) {
      return conditions;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("ins".equals(fieldName)) {
      return ins;
    }
    if ("logConfigs".equals(fieldName)) {
      return logConfigs;
    }
    if ("notIns".equals(fieldName)) {
      return notIns;
    }
    if ("permissions".equals(fieldName)) {
      return permissions;
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

  /** Required */
  public String getAction() {
    return action;
  }

  /** Additional restrictions that must be met. All conditions must pass for the rule to match. */
  public List<Condition> getConditionsList() {
    return conditions;
  }

  /** Human-readable description of the rule. */
  public String getDescription() {
    return description;
  }

  /**
   * If one or more 'in' clauses are specified, the rule matches if the PRINCIPAL/AUTHORITY_SELECTOR
   * is in at least one of these entries.
   */
  public List<String> getInsList() {
    return ins;
  }

  /**
   * The config returned to callers of tech.iam.IAM.CheckPolicy for any entries that match the LOG
   * action.
   */
  public List<LogConfig> getLogConfigsList() {
    return logConfigs;
  }

  /**
   * If one or more 'not_in' clauses are specified, the rule matches if the
   * PRINCIPAL/AUTHORITY_SELECTOR is in none of the entries.
   */
  public List<String> getNotInsList() {
    return notIns;
  }

  /**
   * A permission is a string of form '..' (e.g., 'storage.buckets.list'). A value of '&#42;'
   * matches all permissions, and a verb part of '&#42;' (e.g., 'storage.buckets.&#42;') matches all
   * verbs.
   */
  public List<String> getPermissionsList() {
    return permissions;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(Rule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static Rule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final Rule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new Rule();
  }

  public static class Builder {
    private String action;
    private List<Condition> conditions;
    private String description;
    private List<String> ins;
    private List<LogConfig> logConfigs;
    private List<String> notIns;
    private List<String> permissions;

    Builder() {}

    public Builder mergeFrom(Rule other) {
      if (other == Rule.getDefaultInstance()) return this;
      if (other.getAction() != null) {
        this.action = other.action;
      }
      if (other.getConditionsList() != null) {
        this.conditions = other.conditions;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getInsList() != null) {
        this.ins = other.ins;
      }
      if (other.getLogConfigsList() != null) {
        this.logConfigs = other.logConfigs;
      }
      if (other.getNotInsList() != null) {
        this.notIns = other.notIns;
      }
      if (other.getPermissionsList() != null) {
        this.permissions = other.permissions;
      }
      return this;
    }

    Builder(Rule source) {
      this.action = source.action;
      this.conditions = source.conditions;
      this.description = source.description;
      this.ins = source.ins;
      this.logConfigs = source.logConfigs;
      this.notIns = source.notIns;
      this.permissions = source.permissions;
    }

    /** Required */
    public String getAction() {
      return action;
    }

    /** Required */
    public Builder setAction(String action) {
      this.action = action;
      return this;
    }

    /** Additional restrictions that must be met. All conditions must pass for the rule to match. */
    public List<Condition> getConditionsList() {
      return conditions;
    }

    /** Additional restrictions that must be met. All conditions must pass for the rule to match. */
    public Builder addAllConditions(List<Condition> conditions) {
      if (this.conditions == null) {
        this.conditions = new LinkedList<>();
      }
      this.conditions.addAll(conditions);
      return this;
    }

    /** Additional restrictions that must be met. All conditions must pass for the rule to match. */
    public Builder addConditions(Condition conditions) {
      if (this.conditions == null) {
        this.conditions = new LinkedList<>();
      }
      this.conditions.add(conditions);
      return this;
    }

    /** Human-readable description of the rule. */
    public String getDescription() {
      return description;
    }

    /** Human-readable description of the rule. */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * If one or more 'in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in at least one of these entries.
     */
    public List<String> getInsList() {
      return ins;
    }

    /**
     * If one or more 'in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in at least one of these entries.
     */
    public Builder addAllIns(List<String> ins) {
      if (this.ins == null) {
        this.ins = new LinkedList<>();
      }
      this.ins.addAll(ins);
      return this;
    }

    /**
     * If one or more 'in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in at least one of these entries.
     */
    public Builder addIns(String ins) {
      if (this.ins == null) {
        this.ins = new LinkedList<>();
      }
      this.ins.add(ins);
      return this;
    }

    /**
     * The config returned to callers of tech.iam.IAM.CheckPolicy for any entries that match the LOG
     * action.
     */
    public List<LogConfig> getLogConfigsList() {
      return logConfigs;
    }

    /**
     * The config returned to callers of tech.iam.IAM.CheckPolicy for any entries that match the LOG
     * action.
     */
    public Builder addAllLogConfigs(List<LogConfig> logConfigs) {
      if (this.logConfigs == null) {
        this.logConfigs = new LinkedList<>();
      }
      this.logConfigs.addAll(logConfigs);
      return this;
    }

    /**
     * The config returned to callers of tech.iam.IAM.CheckPolicy for any entries that match the LOG
     * action.
     */
    public Builder addLogConfigs(LogConfig logConfigs) {
      if (this.logConfigs == null) {
        this.logConfigs = new LinkedList<>();
      }
      this.logConfigs.add(logConfigs);
      return this;
    }

    /**
     * If one or more 'not_in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in none of the entries.
     */
    public List<String> getNotInsList() {
      return notIns;
    }

    /**
     * If one or more 'not_in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in none of the entries.
     */
    public Builder addAllNotIns(List<String> notIns) {
      if (this.notIns == null) {
        this.notIns = new LinkedList<>();
      }
      this.notIns.addAll(notIns);
      return this;
    }

    /**
     * If one or more 'not_in' clauses are specified, the rule matches if the
     * PRINCIPAL/AUTHORITY_SELECTOR is in none of the entries.
     */
    public Builder addNotIns(String notIns) {
      if (this.notIns == null) {
        this.notIns = new LinkedList<>();
      }
      this.notIns.add(notIns);
      return this;
    }

    /**
     * A permission is a string of form '..' (e.g., 'storage.buckets.list'). A value of '&#42;'
     * matches all permissions, and a verb part of '&#42;' (e.g., 'storage.buckets.&#42;') matches
     * all verbs.
     */
    public List<String> getPermissionsList() {
      return permissions;
    }

    /**
     * A permission is a string of form '..' (e.g., 'storage.buckets.list'). A value of '&#42;'
     * matches all permissions, and a verb part of '&#42;' (e.g., 'storage.buckets.&#42;') matches
     * all verbs.
     */
    public Builder addAllPermissions(List<String> permissions) {
      if (this.permissions == null) {
        this.permissions = new LinkedList<>();
      }
      this.permissions.addAll(permissions);
      return this;
    }

    /**
     * A permission is a string of form '..' (e.g., 'storage.buckets.list'). A value of '&#42;'
     * matches all permissions, and a verb part of '&#42;' (e.g., 'storage.buckets.&#42;') matches
     * all verbs.
     */
    public Builder addPermissions(String permissions) {
      if (this.permissions == null) {
        this.permissions = new LinkedList<>();
      }
      this.permissions.add(permissions);
      return this;
    }

    public Rule build() {

      return new Rule(action, conditions, description, ins, logConfigs, notIns, permissions);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAction(this.action);
      newBuilder.addAllConditions(this.conditions);
      newBuilder.setDescription(this.description);
      newBuilder.addAllIns(this.ins);
      newBuilder.addAllLogConfigs(this.logConfigs);
      newBuilder.addAllNotIns(this.notIns);
      newBuilder.addAllPermissions(this.permissions);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "Rule{"
        + "action="
        + action
        + ", "
        + "conditions="
        + conditions
        + ", "
        + "description="
        + description
        + ", "
        + "ins="
        + ins
        + ", "
        + "logConfigs="
        + logConfigs
        + ", "
        + "notIns="
        + notIns
        + ", "
        + "permissions="
        + permissions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Rule) {
      Rule that = (Rule) o;
      return Objects.equals(this.action, that.getAction())
          && Objects.equals(this.conditions, that.getConditionsList())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.ins, that.getInsList())
          && Objects.equals(this.logConfigs, that.getLogConfigsList())
          && Objects.equals(this.notIns, that.getNotInsList())
          && Objects.equals(this.permissions, that.getPermissionsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, conditions, description, ins, logConfigs, notIns, permissions);
  }
}
