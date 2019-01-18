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
public final class TargetSslProxiesSetProxyHeaderRequest implements ApiMessage {
  private final String proxyHeader;

  private TargetSslProxiesSetProxyHeaderRequest() {
    this.proxyHeader = null;
  }

  private TargetSslProxiesSetProxyHeaderRequest(String proxyHeader) {
    this.proxyHeader = proxyHeader;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("proxyHeader".equals(fieldName)) {
      return proxyHeader;
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

  public String getProxyHeader() {
    return proxyHeader;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetSslProxiesSetProxyHeaderRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetSslProxiesSetProxyHeaderRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetSslProxiesSetProxyHeaderRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetSslProxiesSetProxyHeaderRequest();
  }

  public static class Builder {
    private String proxyHeader;

    Builder() {}

    public Builder mergeFrom(TargetSslProxiesSetProxyHeaderRequest other) {
      if (other == TargetSslProxiesSetProxyHeaderRequest.getDefaultInstance()) return this;
      if (other.getProxyHeader() != null) {
        this.proxyHeader = other.proxyHeader;
      }
      return this;
    }

    Builder(TargetSslProxiesSetProxyHeaderRequest source) {
      this.proxyHeader = source.proxyHeader;
    }

    public String getProxyHeader() {
      return proxyHeader;
    }

    public Builder setProxyHeader(String proxyHeader) {
      this.proxyHeader = proxyHeader;
      return this;
    }

    public TargetSslProxiesSetProxyHeaderRequest build() {
      return new TargetSslProxiesSetProxyHeaderRequest(proxyHeader);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setProxyHeader(this.proxyHeader);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetSslProxiesSetProxyHeaderRequest{" + "proxyHeader=" + proxyHeader + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetSslProxiesSetProxyHeaderRequest) {
      TargetSslProxiesSetProxyHeaderRequest that = (TargetSslProxiesSetProxyHeaderRequest) o;
      return Objects.equals(this.proxyHeader, that.getProxyHeader());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(proxyHeader);
  }
}
