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
public final class SecurityPolicyRule implements ApiMessage {
  private final String action;
  private final String description;
  private final String kind;
  private final SecurityPolicyRuleMatcher match;
  private final Boolean preview;
  private final Integer priority;

  private SecurityPolicyRule() {
    this.action = null;
    this.description = null;
    this.kind = null;
    this.match = null;
    this.preview = null;
    this.priority = null;
  }

  private SecurityPolicyRule(
      String action,
      String description,
      String kind,
      SecurityPolicyRuleMatcher match,
      Boolean preview,
      Integer priority) {
    this.action = action;
    this.description = description;
    this.kind = kind;
    this.match = match;
    this.preview = preview;
    this.priority = priority;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("action".equals(fieldName)) {
      return action;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("match".equals(fieldName)) {
      return match;
    }
    if ("preview".equals(fieldName)) {
      return preview;
    }
    if ("priority".equals(fieldName)) {
      return priority;
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

  public String getAction() {
    return action;
  }

  public String getDescription() {
    return description;
  }

  public String getKind() {
    return kind;
  }

  public SecurityPolicyRuleMatcher getMatch() {
    return match;
  }

  public Boolean getPreview() {
    return preview;
  }

  public Integer getPriority() {
    return priority;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SecurityPolicyRule prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SecurityPolicyRule getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SecurityPolicyRule DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SecurityPolicyRule();
  }

  public static class Builder {
    private String action;
    private String description;
    private String kind;
    private SecurityPolicyRuleMatcher match;
    private Boolean preview;
    private Integer priority;

    Builder() {}

    public Builder mergeFrom(SecurityPolicyRule other) {
      if (other == SecurityPolicyRule.getDefaultInstance()) return this;
      if (other.getAction() != null) {
        this.action = other.action;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getMatch() != null) {
        this.match = other.match;
      }
      if (other.getPreview() != null) {
        this.preview = other.preview;
      }
      if (other.getPriority() != null) {
        this.priority = other.priority;
      }
      return this;
    }

    Builder(SecurityPolicyRule source) {
      this.action = source.action;
      this.description = source.description;
      this.kind = source.kind;
      this.match = source.match;
      this.preview = source.preview;
      this.priority = source.priority;
    }

    public String getAction() {
      return action;
    }

    public Builder setAction(String action) {
      this.action = action;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public SecurityPolicyRuleMatcher getMatch() {
      return match;
    }

    public Builder setMatch(SecurityPolicyRuleMatcher match) {
      this.match = match;
      return this;
    }

    public Boolean getPreview() {
      return preview;
    }

    public Builder setPreview(Boolean preview) {
      this.preview = preview;
      return this;
    }

    public Integer getPriority() {
      return priority;
    }

    public Builder setPriority(Integer priority) {
      this.priority = priority;
      return this;
    }

    public SecurityPolicyRule build() {

      return new SecurityPolicyRule(action, description, kind, match, preview, priority);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setAction(this.action);
      newBuilder.setDescription(this.description);
      newBuilder.setKind(this.kind);
      newBuilder.setMatch(this.match);
      newBuilder.setPreview(this.preview);
      newBuilder.setPriority(this.priority);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SecurityPolicyRule{"
        + "action="
        + action
        + ", "
        + "description="
        + description
        + ", "
        + "kind="
        + kind
        + ", "
        + "match="
        + match
        + ", "
        + "preview="
        + preview
        + ", "
        + "priority="
        + priority
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecurityPolicyRule) {
      SecurityPolicyRule that = (SecurityPolicyRule) o;
      return Objects.equals(this.action, that.getAction())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.match, that.getMatch())
          && Objects.equals(this.preview, that.getPreview())
          && Objects.equals(this.priority, that.getPriority());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, description, kind, match, preview, priority);
  }
}
