/*
 * Copyright 2020 Google LLC
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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Configuration and status of a managed SSL certificate. */
public final class SslCertificateManagedSslCertificate implements ApiMessage {
  private final Map<String, String> domainStatus;
  private final List<String> domains;
  private final String status;

  private SslCertificateManagedSslCertificate() {
    this.domainStatus = null;
    this.domains = null;
    this.status = null;
  }

  private SslCertificateManagedSslCertificate(
      Map<String, String> domainStatus, List<String> domains, String status) {
    this.domainStatus = domainStatus;
    this.domains = domains;
    this.status = status;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("domainStatus".equals(fieldName)) {
      return domainStatus;
    }
    if ("domains".equals(fieldName)) {
      return domains;
    }
    if ("status".equals(fieldName)) {
      return status;
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

  /** [Output only] Detailed statuses of the domains specified for managed certificate resource. */
  public Map<String, String> getDomainStatusMap() {
    return domainStatus;
  }

  /**
   * The domains for which a managed SSL certificate will be generated. Currently only single-domain
   * certs are supported.
   */
  public List<String> getDomainsList() {
    return domains;
  }

  /** [Output only] Status of the managed certificate resource. */
  public String getStatus() {
    return status;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslCertificateManagedSslCertificate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslCertificateManagedSslCertificate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslCertificateManagedSslCertificate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslCertificateManagedSslCertificate();
  }

  public static class Builder {
    private Map<String, String> domainStatus;
    private List<String> domains;
    private String status;

    Builder() {}

    public Builder mergeFrom(SslCertificateManagedSslCertificate other) {
      if (other == SslCertificateManagedSslCertificate.getDefaultInstance()) return this;
      if (other.getDomainStatusMap() != null) {
        this.domainStatus = other.domainStatus;
      }
      if (other.getDomainsList() != null) {
        this.domains = other.domains;
      }
      if (other.getStatus() != null) {
        this.status = other.status;
      }
      return this;
    }

    Builder(SslCertificateManagedSslCertificate source) {
      this.domainStatus = source.domainStatus;
      this.domains = source.domains;
      this.status = source.status;
    }

    /**
     * [Output only] Detailed statuses of the domains specified for managed certificate resource.
     */
    public Map<String, String> getDomainStatusMap() {
      return domainStatus;
    }

    /**
     * [Output only] Detailed statuses of the domains specified for managed certificate resource.
     */
    public Builder putAllDomainStatus(Map<String, String> domainStatus) {
      this.domainStatus = domainStatus;
      return this;
    }

    /**
     * The domains for which a managed SSL certificate will be generated. Currently only
     * single-domain certs are supported.
     */
    public List<String> getDomainsList() {
      return domains;
    }

    /**
     * The domains for which a managed SSL certificate will be generated. Currently only
     * single-domain certs are supported.
     */
    public Builder addAllDomains(List<String> domains) {
      if (this.domains == null) {
        this.domains = new LinkedList<>();
      }
      this.domains.addAll(domains);
      return this;
    }

    /**
     * The domains for which a managed SSL certificate will be generated. Currently only
     * single-domain certs are supported.
     */
    public Builder addDomains(String domains) {
      if (this.domains == null) {
        this.domains = new LinkedList<>();
      }
      this.domains.add(domains);
      return this;
    }

    /** [Output only] Status of the managed certificate resource. */
    public String getStatus() {
      return status;
    }

    /** [Output only] Status of the managed certificate resource. */
    public Builder setStatus(String status) {
      this.status = status;
      return this;
    }

    public SslCertificateManagedSslCertificate build() {

      return new SslCertificateManagedSslCertificate(domainStatus, domains, status);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.putAllDomainStatus(this.domainStatus);
      newBuilder.addAllDomains(this.domains);
      newBuilder.setStatus(this.status);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslCertificateManagedSslCertificate{"
        + "domainStatus="
        + domainStatus
        + ", "
        + "domains="
        + domains
        + ", "
        + "status="
        + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslCertificateManagedSslCertificate) {
      SslCertificateManagedSslCertificate that = (SslCertificateManagedSslCertificate) o;
      return Objects.equals(this.domainStatus, that.getDomainStatusMap())
          && Objects.equals(this.domains, that.getDomainsList())
          && Objects.equals(this.status, that.getStatus());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(domainStatus, domains, status);
  }
}
