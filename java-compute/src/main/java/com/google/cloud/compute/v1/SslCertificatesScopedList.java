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
public final class SslCertificatesScopedList implements ApiMessage {
  private final List<SslCertificate> sslCertificates;
  private final Warning warning;

  private SslCertificatesScopedList() {
    this.sslCertificates = null;
    this.warning = null;
  }

  private SslCertificatesScopedList(List<SslCertificate> sslCertificates, Warning warning) {
    this.sslCertificates = sslCertificates;
    this.warning = warning;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("sslCertificates".equals(fieldName)) {
      return sslCertificates;
    }
    if ("warning".equals(fieldName)) {
      return warning;
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

  /** List of SslCertificates contained in this scope. */
  public List<SslCertificate> getSslCertificatesList() {
    return sslCertificates;
  }

  /** Informational warning which replaces the list of backend services when the list is empty. */
  public Warning getWarning() {
    return warning;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslCertificatesScopedList prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslCertificatesScopedList getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslCertificatesScopedList DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslCertificatesScopedList();
  }

  public static class Builder {
    private List<SslCertificate> sslCertificates;
    private Warning warning;

    Builder() {}

    public Builder mergeFrom(SslCertificatesScopedList other) {
      if (other == SslCertificatesScopedList.getDefaultInstance()) return this;
      if (other.getSslCertificatesList() != null) {
        this.sslCertificates = other.sslCertificates;
      }
      if (other.getWarning() != null) {
        this.warning = other.warning;
      }
      return this;
    }

    Builder(SslCertificatesScopedList source) {
      this.sslCertificates = source.sslCertificates;
      this.warning = source.warning;
    }

    /** List of SslCertificates contained in this scope. */
    public List<SslCertificate> getSslCertificatesList() {
      return sslCertificates;
    }

    /** List of SslCertificates contained in this scope. */
    public Builder addAllSslCertificates(List<SslCertificate> sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.addAll(sslCertificates);
      return this;
    }

    /** List of SslCertificates contained in this scope. */
    public Builder addSslCertificates(SslCertificate sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.add(sslCertificates);
      return this;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Warning getWarning() {
      return warning;
    }

    /** Informational warning which replaces the list of backend services when the list is empty. */
    public Builder setWarning(Warning warning) {
      this.warning = warning;
      return this;
    }

    public SslCertificatesScopedList build() {

      return new SslCertificatesScopedList(sslCertificates, warning);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllSslCertificates(this.sslCertificates);
      newBuilder.setWarning(this.warning);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslCertificatesScopedList{"
        + "sslCertificates="
        + sslCertificates
        + ", "
        + "warning="
        + warning
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslCertificatesScopedList) {
      SslCertificatesScopedList that = (SslCertificatesScopedList) o;
      return Objects.equals(this.sslCertificates, that.getSslCertificatesList())
          && Objects.equals(this.warning, that.getWarning());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sslCertificates, warning);
  }
}
