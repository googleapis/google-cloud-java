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
public final class SslCertificate implements ApiMessage {
  private final String certificate;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String privateKey;
  private final String selfLink;

  private SslCertificate() {
    this.certificate = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.privateKey = null;
    this.selfLink = null;
  }

  private SslCertificate(
      String certificate,
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String privateKey,
      String selfLink) {
    this.certificate = certificate;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.privateKey = privateKey;
    this.selfLink = selfLink;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("certificate".equals(fieldName)) {
      return certificate;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("id".equals(fieldName)) {
      return id;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("privateKey".equals(fieldName)) {
      return privateKey;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
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

  public String getCertificate() {
    return certificate;
  }

  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  public String getDescription() {
    return description;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getPrivateKey() {
    return privateKey;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslCertificate prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslCertificate getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslCertificate DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslCertificate();
  }

  public static class Builder {
    private String certificate;
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String privateKey;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(SslCertificate other) {
      if (other == SslCertificate.getDefaultInstance()) return this;
      if (other.getCertificate() != null) {
        this.certificate = other.certificate;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getPrivateKey() != null) {
        this.privateKey = other.privateKey;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(SslCertificate source) {
      this.certificate = source.certificate;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.privateKey = source.privateKey;
      this.selfLink = source.selfLink;
    }

    public String getCertificate() {
      return certificate;
    }

    public Builder setCertificate(String certificate) {
      this.certificate = certificate;
      return this;
    }

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public String getId() {
      return id;
    }

    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    public String getKind() {
      return kind;
    }

    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getPrivateKey() {
      return privateKey;
    }

    public Builder setPrivateKey(String privateKey) {
      this.privateKey = privateKey;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public SslCertificate build() {

      return new SslCertificate(
          certificate, creationTimestamp, description, id, kind, name, privateKey, selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCertificate(this.certificate);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setPrivateKey(this.privateKey);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslCertificate{"
        + "certificate="
        + certificate
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "privateKey="
        + privateKey
        + ", "
        + "selfLink="
        + selfLink
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslCertificate) {
      SslCertificate that = (SslCertificate) o;
      return Objects.equals(this.certificate, that.getCertificate())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.privateKey, that.getPrivateKey())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        certificate, creationTimestamp, description, id, kind, name, privateKey, selfLink);
  }
}
