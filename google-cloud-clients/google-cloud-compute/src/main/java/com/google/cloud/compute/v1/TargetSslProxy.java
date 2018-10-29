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
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class TargetSslProxy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String proxyHeader;
  private final String selfLink;
  private final String service;
  private final List<String> sslCertificates;
  private final String sslPolicy;

  private TargetSslProxy() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.proxyHeader = null;
    this.selfLink = null;
    this.service = null;
    this.sslCertificates = null;
    this.sslPolicy = null;
  }

  private TargetSslProxy(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String proxyHeader,
      String selfLink,
      String service,
      List<String> sslCertificates,
      String sslPolicy) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.proxyHeader = proxyHeader;
    this.selfLink = selfLink;
    this.service = service;
    this.sslCertificates = sslCertificates;
    this.sslPolicy = sslPolicy;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return creationTimestamp;
    }
    if (fieldName.equals("description")) {
      return description;
    }
    if (fieldName.equals("id")) {
      return id;
    }
    if (fieldName.equals("kind")) {
      return kind;
    }
    if (fieldName.equals("name")) {
      return name;
    }
    if (fieldName.equals("proxyHeader")) {
      return proxyHeader;
    }
    if (fieldName.equals("selfLink")) {
      return selfLink;
    }
    if (fieldName.equals("service")) {
      return service;
    }
    if (fieldName.equals("sslCertificates")) {
      return sslCertificates;
    }
    if (fieldName.equals("sslPolicy")) {
      return sslPolicy;
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

  public String getProxyHeader() {
    return proxyHeader;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getService() {
    return service;
  }

  public List<String> getSslCertificatesList() {
    return sslCertificates;
  }

  public String getSslPolicy() {
    return sslPolicy;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetSslProxy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetSslProxy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetSslProxy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetSslProxy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String proxyHeader;
    private String selfLink;
    private String service;
    private List<String> sslCertificates;
    private String sslPolicy;

    Builder() {}

    public Builder mergeFrom(TargetSslProxy other) {
      if (other == TargetSslProxy.getDefaultInstance()) return this;
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
      if (other.getProxyHeader() != null) {
        this.proxyHeader = other.proxyHeader;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getService() != null) {
        this.service = other.service;
      }
      if (other.getSslCertificatesList() != null) {
        this.sslCertificates = other.sslCertificates;
      }
      if (other.getSslPolicy() != null) {
        this.sslPolicy = other.sslPolicy;
      }
      return this;
    }

    Builder(TargetSslProxy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.proxyHeader = source.proxyHeader;
      this.selfLink = source.selfLink;
      this.service = source.service;
      this.sslCertificates = source.sslCertificates;
      this.sslPolicy = source.sslPolicy;
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

    public String getProxyHeader() {
      return proxyHeader;
    }

    public Builder setProxyHeader(String proxyHeader) {
      this.proxyHeader = proxyHeader;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getService() {
      return service;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    public List<String> getSslCertificatesList() {
      return sslCertificates;
    }

    public Builder addAllSslCertificates(List<String> sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.addAll(sslCertificates);
      return this;
    }

    public Builder addSslCertificates(String sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.add(sslCertificates);
      return this;
    }

    public String getSslPolicy() {
      return sslPolicy;
    }

    public Builder setSslPolicy(String sslPolicy) {
      this.sslPolicy = sslPolicy;
      return this;
    }

    public TargetSslProxy build() {

      return new TargetSslProxy(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          proxyHeader,
          selfLink,
          service,
          sslCertificates,
          sslPolicy);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setProxyHeader(this.proxyHeader);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setService(this.service);
      newBuilder.addAllSslCertificates(this.sslCertificates);
      newBuilder.setSslPolicy(this.sslPolicy);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetSslProxy{"
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
        + "proxyHeader="
        + proxyHeader
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "service="
        + service
        + ", "
        + "sslCertificates="
        + sslCertificates
        + ", "
        + "sslPolicy="
        + sslPolicy
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetSslProxy) {
      TargetSslProxy that = (TargetSslProxy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.proxyHeader, that.getProxyHeader())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.service, that.getService())
          && Objects.equals(this.sslCertificates, that.getSslCertificatesList())
          && Objects.equals(this.sslPolicy, that.getSslPolicy());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        id,
        kind,
        name,
        proxyHeader,
        selfLink,
        service,
        sslCertificates,
        sslPolicy);
  }
}
