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
public final class UrlMapTest implements ApiMessage {
  private final String description;
  private final String host;
  private final String path;
  private final String service;

  private UrlMapTest() {
    this.description = null;
    this.host = null;
    this.path = null;
    this.service = null;
  }

  private UrlMapTest(String description, String host, String path, String service) {
    this.description = description;
    this.host = host;
    this.path = path;
    this.service = service;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("host".equals(fieldName)) {
      return host;
    }
    if ("path".equals(fieldName)) {
      return path;
    }
    if ("service".equals(fieldName)) {
      return service;
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

  public String getDescription() {
    return description;
  }

  public String getHost() {
    return host;
  }

  public String getPath() {
    return path;
  }

  public String getService() {
    return service;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(UrlMapTest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static UrlMapTest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final UrlMapTest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new UrlMapTest();
  }

  public static class Builder {
    private String description;
    private String host;
    private String path;
    private String service;

    Builder() {}

    public Builder mergeFrom(UrlMapTest other) {
      if (other == UrlMapTest.getDefaultInstance()) return this;
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getHost() != null) {
        this.host = other.host;
      }
      if (other.getPath() != null) {
        this.path = other.path;
      }
      if (other.getService() != null) {
        this.service = other.service;
      }
      return this;
    }

    Builder(UrlMapTest source) {
      this.description = source.description;
      this.host = source.host;
      this.path = source.path;
      this.service = source.service;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getHost() {
      return host;
    }

    public Builder setHost(String host) {
      this.host = host;
      return this;
    }

    public String getPath() {
      return path;
    }

    public Builder setPath(String path) {
      this.path = path;
      return this;
    }

    public String getService() {
      return service;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public UrlMapTest build() {

      return new UrlMapTest(description, host, path, service);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setDescription(this.description);
      newBuilder.setHost(this.host);
      newBuilder.setPath(this.path);
      newBuilder.setService(this.service);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "UrlMapTest{"
        + "description="
        + description
        + ", "
        + "host="
        + host
        + ", "
        + "path="
        + path
        + ", "
        + "service="
        + service
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UrlMapTest) {
      UrlMapTest that = (UrlMapTest) o;
      return Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.host, that.getHost())
          && Objects.equals(this.path, that.getPath())
          && Objects.equals(this.service, that.getService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, host, path, service);
  }
}
