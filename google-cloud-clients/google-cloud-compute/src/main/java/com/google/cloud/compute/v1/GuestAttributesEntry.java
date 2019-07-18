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
/** A guest attributes namespace/key/value entry. */
public final class GuestAttributesEntry implements ApiMessage {
  private final String key;
  private final String namespace;
  private final String value;

  private GuestAttributesEntry() {
    this.key = null;
    this.namespace = null;
    this.value = null;
  }

  private GuestAttributesEntry(String key, String namespace, String value) {
    this.key = key;
    this.namespace = namespace;
    this.value = value;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("key".equals(fieldName)) {
      return key;
    }
    if ("namespace".equals(fieldName)) {
      return namespace;
    }
    if ("value".equals(fieldName)) {
      return value;
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

  /** Key for the guest attribute entry. */
  public String getKey() {
    return key;
  }

  /** Namespace for the guest attribute entry. */
  public String getNamespace() {
    return namespace;
  }

  /** Value for the guest attribute entry. */
  public String getValue() {
    return value;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(GuestAttributesEntry prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static GuestAttributesEntry getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final GuestAttributesEntry DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new GuestAttributesEntry();
  }

  public static class Builder {
    private String key;
    private String namespace;
    private String value;

    Builder() {}

    public Builder mergeFrom(GuestAttributesEntry other) {
      if (other == GuestAttributesEntry.getDefaultInstance()) return this;
      if (other.getKey() != null) {
        this.key = other.key;
      }
      if (other.getNamespace() != null) {
        this.namespace = other.namespace;
      }
      if (other.getValue() != null) {
        this.value = other.value;
      }
      return this;
    }

    Builder(GuestAttributesEntry source) {
      this.key = source.key;
      this.namespace = source.namespace;
      this.value = source.value;
    }

    /** Key for the guest attribute entry. */
    public String getKey() {
      return key;
    }

    /** Key for the guest attribute entry. */
    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    /** Namespace for the guest attribute entry. */
    public String getNamespace() {
      return namespace;
    }

    /** Namespace for the guest attribute entry. */
    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    /** Value for the guest attribute entry. */
    public String getValue() {
      return value;
    }

    /** Value for the guest attribute entry. */
    public Builder setValue(String value) {
      this.value = value;
      return this;
    }

    public GuestAttributesEntry build() {

      return new GuestAttributesEntry(key, namespace, value);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKey(this.key);
      newBuilder.setNamespace(this.namespace);
      newBuilder.setValue(this.value);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "GuestAttributesEntry{"
        + "key="
        + key
        + ", "
        + "namespace="
        + namespace
        + ", "
        + "value="
        + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GuestAttributesEntry) {
      GuestAttributesEntry that = (GuestAttributesEntry) o;
      return Objects.equals(this.key, that.getKey())
          && Objects.equals(this.namespace, that.getNamespace())
          && Objects.equals(this.value, that.getValue());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, namespace, value);
  }
}
