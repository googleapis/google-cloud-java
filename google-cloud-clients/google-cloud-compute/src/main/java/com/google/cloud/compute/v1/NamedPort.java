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
public final class NamedPort implements ApiMessage {
  private final String name;
  private final Integer port;

  private NamedPort() {
    this.name = null;
    this.port = null;
  }

  private NamedPort(String name, Integer port) {
    this.name = name;
    this.port = port;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("port")) {
      return port;
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

  public String getName() {
    return name;
  }

  public Integer getPort() {
    return port;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NamedPort prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NamedPort getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NamedPort DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NamedPort();
  }

  public static class Builder {
    private String name;
    private Integer port;

    Builder() {}

    public Builder mergeFrom(NamedPort other) {
      if (other == NamedPort.getDefaultInstance()) return this;
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPort() != null) {
        this.port = other.port;
      }
      return this;
    }

    Builder(NamedPort source) {
      this.name = source.name;
      this.port = source.port;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Integer getPort() {
      return port;
    }

    public Builder setPort(Integer port) {
      this.port = port;
      return this;
    }

    public NamedPort build() {

      return new NamedPort(name, port);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setName(this.name);
      newBuilder.setPort(this.port);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NamedPort{" + "name=" + name + ", " + "port=" + port + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NamedPort) {
      NamedPort that = (NamedPort) o;
      return Objects.equals(this.name, that.getName()) && Objects.equals(this.port, that.getPort());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, port);
  }
}
