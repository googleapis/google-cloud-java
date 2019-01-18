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
public final class SecurityPolicy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String fingerprint;
  private final String id;
  private final String kind;
  private final String name;
  private final List<SecurityPolicyRule> rules;
  private final String selfLink;

  private SecurityPolicy() {
    this.creationTimestamp = null;
    this.description = null;
    this.fingerprint = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.rules = null;
    this.selfLink = null;
  }

  private SecurityPolicy(
      String creationTimestamp,
      String description,
      String fingerprint,
      String id,
      String kind,
      String name,
      List<SecurityPolicyRule> rules,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.fingerprint = fingerprint;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.rules = rules;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("rules".equals(fieldName)) {
      return rules;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public List<SecurityPolicyRule> getRulesList() {
    return rules;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SecurityPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SecurityPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SecurityPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SecurityPolicy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String fingerprint;
    private String id;
    private String kind;
    private String name;
    private List<SecurityPolicyRule> rules;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(SecurityPolicy other) {
      if (other == SecurityPolicy.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getRulesList() != null) {
        this.rules = other.rules;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(SecurityPolicy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.fingerprint = source.fingerprint;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.rules = source.rules;
      this.selfLink = source.selfLink;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public List<SecurityPolicyRule> getRulesList() {
      return rules;
    }

    public Builder addAllRules(List<SecurityPolicyRule> rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.addAll(rules);
      return this;
    }

    public Builder addRules(SecurityPolicyRule rules) {
      if (this.rules == null) {
        this.rules = new LinkedList<>();
      }
      this.rules.add(rules);
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public SecurityPolicy build() {

      return new SecurityPolicy(
          creationTimestamp, description, fingerprint, id, kind, name, rules, selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.addAllRules(this.rules);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SecurityPolicy{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "fingerprint="
        + fingerprint
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "rules="
        + rules
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecurityPolicy) {
      SecurityPolicy that = (SecurityPolicy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.rules, that.getRulesList())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp, description, fingerprint, id, kind, name, rules, selfLink);
  }
}
