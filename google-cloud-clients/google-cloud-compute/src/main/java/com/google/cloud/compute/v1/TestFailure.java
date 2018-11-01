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
public final class TestFailure implements ApiMessage {
  private final String actualService;
  private final String expectedService;
  private final String host;
  private final String path;

  private TestFailure() {
    this.actualService = null;
    this.expectedService = null;
    this.host = null;
    this.path = null;
  }

  private TestFailure(String actualService, String expectedService, String host, String path) {
    this.actualService = actualService;
    this.expectedService = expectedService;
    this.host = host;
    this.path = path;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("actualService")) {
      return actualService;
    }
    if (fieldName.equals("expectedService")) {
      return expectedService;
    }
    if (fieldName.equals("host")) {
      return host;
    }
    if (fieldName.equals("path")) {
      return path;
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

  public String getActualService() {
    return actualService;
  }

  public String getExpectedService() {
    return expectedService;
  }

  public String getHost() {
    return host;
  }

  public String getPath() {
    return path;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TestFailure prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TestFailure getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TestFailure DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TestFailure();
  }

  public static class Builder {
    private String actualService;
    private String expectedService;
    private String host;
    private String path;

    Builder() {}

    public Builder mergeFrom(TestFailure other) {
      if (other == TestFailure.getDefaultInstance()) return this;
      if (other.getActualService() != null) {
        this.actualService = other.actualService;
      }
      if (other.getExpectedService() != null) {
        this.expectedService = other.expectedService;
      }
      if (other.getHost() != null) {
        this.host = other.host;
      }
      if (other.getPath() != null) {
        this.path = other.path;
      }
      return this;
    }

    Builder(TestFailure source) {
      this.actualService = source.actualService;
      this.expectedService = source.expectedService;
      this.host = source.host;
      this.path = source.path;
    }

    public String getActualService() {
      return actualService;
    }

    public Builder setActualService(String actualService) {
      this.actualService = actualService;
      return this;
    }

    public String getExpectedService() {
      return expectedService;
    }

    public Builder setExpectedService(String expectedService) {
      this.expectedService = expectedService;
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

    public TestFailure build() {

      return new TestFailure(actualService, expectedService, host, path);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setActualService(this.actualService);
      newBuilder.setExpectedService(this.expectedService);
      newBuilder.setHost(this.host);
      newBuilder.setPath(this.path);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TestFailure{"
        + "actualService="
        + actualService
        + ", "
        + "expectedService="
        + expectedService
        + ", "
        + "host="
        + host
        + ", "
        + "path="
        + path
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TestFailure) {
      TestFailure that = (TestFailure) o;
      return Objects.equals(this.actualService, that.getActualService())
          && Objects.equals(this.expectedService, that.getExpectedService())
          && Objects.equals(this.host, that.getHost())
          && Objects.equals(this.path, that.getPath());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(actualService, expectedService, host, path);
  }
}
