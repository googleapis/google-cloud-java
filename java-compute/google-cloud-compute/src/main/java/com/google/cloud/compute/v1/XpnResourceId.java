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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class XpnResourceId implements ApiMessage {
  private final String id;
  private final String type;

  private XpnResourceId() {
    this.id = null;
    this.type = null;
  }

  private XpnResourceId(String id, String type) {
    this.id = id;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("type")) {
      return type;
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

  public String getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(XpnResourceId prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static XpnResourceId getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final XpnResourceId DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new XpnResourceId();
  }

  public static class Builder {
    private String id;
    private String type;

    Builder() {}

    public Builder mergeFrom(XpnResourceId other) {
      if (other == XpnResourceId.getDefaultInstance()) return this;
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(XpnResourceId source) {
      this.id = source.id;
      this.type = source.type;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public XpnResourceId build() {

      return new XpnResourceId(id, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setId(this.id);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "XpnResourceId{" + "id=" + id + ", " + "type=" + type + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof XpnResourceId) {
      XpnResourceId that = (XpnResourceId) o;
      return Objects.equals(this.id, that.getId()) && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }
}
