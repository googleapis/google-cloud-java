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
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/** Configuration and status of a self-managed SSL certificate. */
public final class SslCertificateSelfManagedSslCertificate implements ApiMessage {
  private final String certificate;
  private final String privateKey;

  private SslCertificateSelfManagedSslCertificate() {
    this.certificate = null;
    this.privateKey = null;
  }

  private SslCertificateSelfManagedSslCertificate(String certificate, String privateKey) {
    this.certificate = certificate;
    this.privateKey = privateKey;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("certificate".equals(fieldName)) {
      return certificate;
    }
    if ("privateKey".equals(fieldName)) {
      return privateKey;
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
   * A local certificate file. The certificate must be in PEM format. The certificate chain must be
   * no greater than 5 certs long. The chain must include at least one intermediate cert.
   */
  public String getCertificate() {
    return certificate;
  }

  /** A write-only private key in PEM format. Only insert requests will include this field. */
  public String getPrivateKey() {
    return privateKey;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslCertificateSelfManagedSslCertificate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslCertificateSelfManagedSslCertificate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslCertificateSelfManagedSslCertificate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslCertificateSelfManagedSslCertificate();
  }

  public static class Builder {
    private String certificate;
    private String privateKey;

    Builder() {}

    public Builder mergeFrom(SslCertificateSelfManagedSslCertificate other) {
      if (other == SslCertificateSelfManagedSslCertificate.getDefaultInstance()) return this;
      if (other.getCertificate() != null) {
        this.certificate = other.certificate;
      }
      if (other.getPrivateKey() != null) {
        this.privateKey = other.privateKey;
      }
      return this;
    }

    Builder(SslCertificateSelfManagedSslCertificate source) {
      this.certificate = source.certificate;
      this.privateKey = source.privateKey;
    }

    /**
     * A local certificate file. The certificate must be in PEM format. The certificate chain must
     * be no greater than 5 certs long. The chain must include at least one intermediate cert.
     */
    public String getCertificate() {
      return certificate;
    }

    /**
     * A local certificate file. The certificate must be in PEM format. The certificate chain must
     * be no greater than 5 certs long. The chain must include at least one intermediate cert.
     */
    public Builder setCertificate(String certificate) {
      this.certificate = certificate;
      return this;
    }

    /** A write-only private key in PEM format. Only insert requests will include this field. */
    public String getPrivateKey() {
      return privateKey;
    }

    /** A write-only private key in PEM format. Only insert requests will include this field. */
    public Builder setPrivateKey(String privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    public SslCertificateSelfManagedSslCertificate build() {

      return new SslCertificateSelfManagedSslCertificate(certificate, privateKey);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCertificate(this.certificate);
      newBuilder.setPrivateKey(this.privateKey);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslCertificateSelfManagedSslCertificate{"
        + "certificate="
        + certificate
        + ", "
        + "privateKey="
        + privateKey
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslCertificateSelfManagedSslCertificate) {
      SslCertificateSelfManagedSslCertificate that = (SslCertificateSelfManagedSslCertificate) o;
      return Objects.equals(this.certificate, that.getCertificate())
          && Objects.equals(this.privateKey, that.getPrivateKey());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(certificate, privateKey);
  }
}
