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
/** A guest attributes entry. */
public final class GuestAttributes implements ApiMessage {
  private final String kind;
  private final String queryPath;
  private final GuestAttributesValue queryValue;
  private final String selfLink;
  private final String variableKey;
  private final String variableValue;

  private GuestAttributes() {
    this.kind = null;
    this.queryPath = null;
    this.queryValue = null;
    this.selfLink = null;
    this.variableKey = null;
    this.variableValue = null;
  }

  private GuestAttributes(
      String kind,
      String queryPath,
      GuestAttributesValue queryValue,
      String selfLink,
      String variableKey,
      String variableValue) {
    this.kind = kind;
    this.queryPath = queryPath;
    this.queryValue = queryValue;
    this.selfLink = selfLink;
    this.variableKey = variableKey;
    this.variableValue = variableValue;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("queryPath".equals(fieldName)) {
      return queryPath;
    }
    if ("queryValue".equals(fieldName)) {
      return queryValue;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("variableKey".equals(fieldName)) {
      return variableKey;
    }
    if ("variableValue".equals(fieldName)) {
      return variableValue;
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

  /**
   * [Output Only] Type of the resource. Always compute#guestAttributes for guest attributes entry.
   */
  public String getKind() {
    return kind;
  }

  /**
   * The path to be queried. This can be the default namespace ('/') or a nested namespace ('//') or
   * a specified key ('//')
   */
  public String getQueryPath() {
    return queryPath;
  }

  /** [Output Only] The value of the requested queried path. */
  public GuestAttributesValue getQueryValue() {
    return queryValue;
  }

  /** [Output Only] Server-defined URL for this resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** The key to search for. */
  public String getVariableKey() {
    return variableKey;
  }

  /** [Output Only] The value found for the requested key. */
  public String getVariableValue() {
    return variableValue;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GuestAttributes prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GuestAttributes getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GuestAttributes DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GuestAttributes();
  }

  public static class Builder {
    private String kind;
    private String queryPath;
    private GuestAttributesValue queryValue;
    private String selfLink;
    private String variableKey;
    private String variableValue;

    Builder() {}

    public Builder mergeFrom(GuestAttributes other) {
      if (other == GuestAttributes.getDefaultInstance()) return this;
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getQueryPath() != null) {
        this.queryPath = other.queryPath;
      }
      if (other.getQueryValue() != null) {
        this.queryValue = other.queryValue;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getVariableKey() != null) {
        this.variableKey = other.variableKey;
      }
      if (other.getVariableValue() != null) {
        this.variableValue = other.variableValue;
      }
      return this;
    }

    Builder(GuestAttributes source) {
      this.kind = source.kind;
      this.queryPath = source.queryPath;
      this.queryValue = source.queryValue;
      this.selfLink = source.selfLink;
      this.variableKey = source.variableKey;
      this.variableValue = source.variableValue;
    }

    /**
     * [Output Only] Type of the resource. Always compute#guestAttributes for guest attributes
     * entry.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#guestAttributes for guest attributes
     * entry.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The path to be queried. This can be the default namespace ('/') or a nested namespace ('//')
     * or a specified key ('//')
     */
    public String getQueryPath() {
      return queryPath;
    }

    /**
     * The path to be queried. This can be the default namespace ('/') or a nested namespace ('//')
     * or a specified key ('//')
     */
    public Builder setQueryPath(String queryPath) {
      this.queryPath = queryPath;
      return this;
    }

    /** [Output Only] The value of the requested queried path. */
    public GuestAttributesValue getQueryValue() {
      return queryValue;
    }

    /** [Output Only] The value of the requested queried path. */
    public Builder setQueryValue(GuestAttributesValue queryValue) {
      this.queryValue = queryValue;
      return this;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for this resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** The key to search for. */
    public String getVariableKey() {
      return variableKey;
    }

    /** The key to search for. */
    public Builder setVariableKey(String variableKey) {
      this.variableKey = variableKey;
      return this;
    }

    /** [Output Only] The value found for the requested key. */
    public String getVariableValue() {
      return variableValue;
    }

    /** [Output Only] The value found for the requested key. */
    public Builder setVariableValue(String variableValue) {
      this.variableValue = variableValue;
      return this;
    }

    public GuestAttributes build() {

      return new GuestAttributes(kind, queryPath, queryValue, selfLink, variableKey, variableValue);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKind(this.kind);
      newBuilder.setQueryPath(this.queryPath);
      newBuilder.setQueryValue(this.queryValue);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setVariableKey(this.variableKey);
      newBuilder.setVariableValue(this.variableValue);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GuestAttributes{"
        + "kind="
        + kind
        + ", "
        + "queryPath="
        + queryPath
        + ", "
        + "queryValue="
        + queryValue
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "variableKey="
        + variableKey
        + ", "
        + "variableValue="
        + variableValue
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GuestAttributes) {
      GuestAttributes that = (GuestAttributes) o;
      return Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.queryPath, that.getQueryPath())
          && Objects.equals(this.queryValue, that.getQueryValue())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.variableKey, that.getVariableKey())
          && Objects.equals(this.variableValue, that.getVariableValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, queryPath, queryValue, selfLink, variableKey, variableValue);
  }
}
