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
public final class TargetTcpProxiesSetBackendServiceRequest implements ApiMessage {
  private final String service;

  private TargetTcpProxiesSetBackendServiceRequest() {
    this.service = null;
  }

  private TargetTcpProxiesSetBackendServiceRequest(String service) {
    this.service = service;
  }

  @Override
  public Object getFieldValue(String fieldName) {
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

  /** The URL of the new BackendService resource for the targetTcpProxy. */
  public String getService() {
    return service;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetTcpProxiesSetBackendServiceRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetTcpProxiesSetBackendServiceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetTcpProxiesSetBackendServiceRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetTcpProxiesSetBackendServiceRequest();
  }

  public static class Builder {
    private String service;

    Builder() {}

    public Builder mergeFrom(TargetTcpProxiesSetBackendServiceRequest other) {
      if (other == TargetTcpProxiesSetBackendServiceRequest.getDefaultInstance()) return this;
      if (other.getService() != null) {
        this.service = other.service;
      }
      return this;
    }

    Builder(TargetTcpProxiesSetBackendServiceRequest source) {
      this.service = source.service;
    }

    /** The URL of the new BackendService resource for the targetTcpProxy. */
    public String getService() {
      return service;
    }

    /** The URL of the new BackendService resource for the targetTcpProxy. */
    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public TargetTcpProxiesSetBackendServiceRequest build() {
      return new TargetTcpProxiesSetBackendServiceRequest(service);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setService(this.service);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetTcpProxiesSetBackendServiceRequest{" + "service=" + service + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetTcpProxiesSetBackendServiceRequest) {
      TargetTcpProxiesSetBackendServiceRequest that = (TargetTcpProxiesSetBackendServiceRequest) o;
      return Objects.equals(this.service, that.getService());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(service);
  }
}
