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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class TargetHttpsProxiesSetSslCertificatesRequest implements ApiMessage {
  private final List<String> sslCertificates;

  private TargetHttpsProxiesSetSslCertificatesRequest() {
    this.sslCertificates = null;
  }

  private TargetHttpsProxiesSetSslCertificatesRequest(List<String> sslCertificates) {
    this.sslCertificates = sslCertificates;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("sslCertificates".equals(fieldName)) {
      return sslCertificates;
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
   * New set of SslCertificate resources to associate with this TargetHttpsProxy resource. Currently
   * exactly one SslCertificate resource must be specified.
   */
  public List<String> getSslCertificatesList() {
    return sslCertificates;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetHttpsProxiesSetSslCertificatesRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpsProxiesSetSslCertificatesRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetHttpsProxiesSetSslCertificatesRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetHttpsProxiesSetSslCertificatesRequest();
  }

  public static class Builder {
    private List<String> sslCertificates;

    Builder() {}

    public Builder mergeFrom(TargetHttpsProxiesSetSslCertificatesRequest other) {
      if (other == TargetHttpsProxiesSetSslCertificatesRequest.getDefaultInstance()) return this;
      if (other.getSslCertificatesList() != null) {
        this.sslCertificates = other.sslCertificates;
      }
      return this;
    }

    Builder(TargetHttpsProxiesSetSslCertificatesRequest source) {
      this.sslCertificates = source.sslCertificates;
    }

    /**
     * New set of SslCertificate resources to associate with this TargetHttpsProxy resource.
     * Currently exactly one SslCertificate resource must be specified.
     */
    public List<String> getSslCertificatesList() {
      return sslCertificates;
    }

    /**
     * New set of SslCertificate resources to associate with this TargetHttpsProxy resource.
     * Currently exactly one SslCertificate resource must be specified.
     */
    public Builder addAllSslCertificates(List<String> sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.addAll(sslCertificates);
      return this;
    }

    /**
     * New set of SslCertificate resources to associate with this TargetHttpsProxy resource.
     * Currently exactly one SslCertificate resource must be specified.
     */
    public Builder addSslCertificates(String sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.add(sslCertificates);
      return this;
    }

    public TargetHttpsProxiesSetSslCertificatesRequest build() {
      return new TargetHttpsProxiesSetSslCertificatesRequest(sslCertificates);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllSslCertificates(this.sslCertificates);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpsProxiesSetSslCertificatesRequest{"
        + "sslCertificates="
        + sslCertificates
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetHttpsProxiesSetSslCertificatesRequest) {
      TargetHttpsProxiesSetSslCertificatesRequest that =
          (TargetHttpsProxiesSetSslCertificatesRequest) o;
      return Objects.equals(this.sslCertificates, that.getSslCertificatesList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sslCertificates);
  }
}
