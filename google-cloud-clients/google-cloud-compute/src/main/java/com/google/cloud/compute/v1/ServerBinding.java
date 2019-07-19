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
public final class ServerBinding implements ApiMessage {
  private final String type;

  private ServerBinding() {
    this.type = null;
  }

  private ServerBinding(String type) {
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("type".equals(fieldName)) {
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
  /**
   * The fields that should be serialized (even if they have empty values). If the containing
   * message object has a non-null fieldmask, then all the fields in the field mask (and only those
   * fields in the field mask) will be serialized. If the containing object does not have a
   * fieldmask, then only non-empty fields will be serialized.
   */
  public List<String> getFieldMask() {
    return null;
  }

  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ServerBinding prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ServerBinding getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ServerBinding DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ServerBinding();
  }

  public static class Builder {
    private String type;

    Builder() {}

    public Builder mergeFrom(ServerBinding other) {
      if (other == ServerBinding.getDefaultInstance()) return this;
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(ServerBinding source) {
      this.type = source.type;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public ServerBinding build() {
      return new ServerBinding(type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ServerBinding{" + "type=" + type + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServerBinding) {
      ServerBinding that = (ServerBinding) o;
      return Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(type);
  }
}
