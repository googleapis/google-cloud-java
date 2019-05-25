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
public final class BackendServiceReference implements ApiMessage {
  private final String backendService;

  private BackendServiceReference() {
    this.backendService = null;
  }

  private BackendServiceReference(String backendService) {
    this.backendService = backendService;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("backendService".equals(fieldName)) {
      return backendService;
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

  public String getBackendService() {
    return backendService;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(BackendServiceReference prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static BackendServiceReference getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final BackendServiceReference DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new BackendServiceReference();
  }

  public static class Builder {
    private String backendService;

    Builder() {}

    public Builder mergeFrom(BackendServiceReference other) {
      if (other == BackendServiceReference.getDefaultInstance()) return this;
      if (other.getBackendService() != null) {
        this.backendService = other.backendService;
      }
      return this;
    }

    Builder(BackendServiceReference source) {
      this.backendService = source.backendService;
    }

    public String getBackendService() {
      return backendService;
    }

    public Builder setBackendService(String backendService) {
      this.backendService = backendService;
      return this;
    }

    public BackendServiceReference build() {
      return new BackendServiceReference(backendService);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setBackendService(this.backendService);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "BackendServiceReference{" + "backendService=" + backendService + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BackendServiceReference) {
      BackendServiceReference that = (BackendServiceReference) o;
      return Objects.equals(this.backendService, that.getBackendService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendService);
  }
}
