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
/**
 * A TargetHttpsProxy resource. This resource defines an HTTPS proxy. (== resource_for
 * beta.targetHttpsProxies ==) (== resource_for v1.targetHttpsProxies ==)
 */
public final class TargetHttpsProxy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String quicOverride;
  private final String selfLink;
  private final List<String> sslCertificates;
  private final String sslPolicy;
  private final String urlMap;

  private TargetHttpsProxy() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.quicOverride = null;
    this.selfLink = null;
    this.sslCertificates = null;
    this.sslPolicy = null;
    this.urlMap = null;
  }

  private TargetHttpsProxy(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String name,
      String quicOverride,
      String selfLink,
      List<String> sslCertificates,
      String sslPolicy,
      String urlMap) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.quicOverride = quicOverride;
    this.selfLink = selfLink;
    this.sslCertificates = sslCertificates;
    this.sslPolicy = sslPolicy;
    this.urlMap = urlMap;
  }

  @Override
  public Object getFieldValue(String fieldName) {
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
    if ("quicOverride".equals(fieldName)) {
      return quicOverride;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("sslCertificates".equals(fieldName)) {
      return sslCertificates;
    }
    if ("sslPolicy".equals(fieldName)) {
      return sslPolicy;
    }
    if ("urlMap".equals(fieldName)) {
      return urlMap;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of resource. Always compute#targetHttpsProxy for target HTTPS proxies. */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource. Provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * Specifies the QUIC override policy for this TargetHttpsProxy resource. This determines whether
   * the load balancer will attempt to negotiate QUIC with clients or not. Can specify one of NONE,
   * ENABLE, or DISABLE. Specify ENABLE to always enable QUIC, Enables QUIC when set to ENABLE, and
   * disables QUIC when set to DISABLE. If NONE is specified, uses the QUIC policy with no user
   * overrides, which is equivalent to DISABLE. Not specifying this field is equivalent to
   * specifying NONE.
   */
  public String getQuicOverride() {
    return quicOverride;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * URLs to SslCertificate resources that are used to authenticate connections between users and
   * the load balancer. At least one SSL certificate must be specified. Currently, you may specify
   * up to 15 SSL certificates.
   */
  public List<String> getSslCertificatesList() {
    return sslCertificates;
  }

  /**
   * URL of SslPolicy resource that will be associated with the TargetHttpsProxy resource. If not
   * set, the TargetHttpsProxy resource will not have any SSL policy configured.
   */
  public String getSslPolicy() {
    return sslPolicy;
  }

  /**
   * A fully-qualified or valid partial URL to the UrlMap resource that defines the mapping from URL
   * to the BackendService. For example, the following are all valid URLs for specifying a URL map:
   * - https://www.googleapis.compute/v1/projects/project/global/urlMaps/url-map -
   * projects/project/global/urlMaps/url-map - global/urlMaps/url-map
   */
  public String getUrlMap() {
    return urlMap;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetHttpsProxy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetHttpsProxy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetHttpsProxy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetHttpsProxy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String quicOverride;
    private String selfLink;
    private List<String> sslCertificates;
    private String sslPolicy;
    private String urlMap;

    Builder() {}

    public Builder mergeFrom(TargetHttpsProxy other) {
      if (other == TargetHttpsProxy.getDefaultInstance()) return this;
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
      if (other.getQuicOverride() != null) {
        this.quicOverride = other.quicOverride;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSslCertificatesList() != null) {
        this.sslCertificates = other.sslCertificates;
      }
      if (other.getSslPolicy() != null) {
        this.sslPolicy = other.sslPolicy;
      }
      if (other.getUrlMap() != null) {
        this.urlMap = other.urlMap;
      }
      return this;
    }

    Builder(TargetHttpsProxy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.quicOverride = source.quicOverride;
      this.selfLink = source.selfLink;
      this.sslCertificates = source.sslCertificates;
      this.sslPolicy = source.sslPolicy;
      this.urlMap = source.urlMap;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    /** [Output Only] Creation timestamp in RFC3339 text format. */
    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional description of this resource. Provide this property when you create the resource.
     */
    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource. This identifier is defined by the
     * server.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /** [Output Only] Type of resource. Always compute#targetHttpsProxy for target HTTPS proxies. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#targetHttpsProxy for target HTTPS proxies. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. Provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Specifies the QUIC override policy for this TargetHttpsProxy resource. This determines
     * whether the load balancer will attempt to negotiate QUIC with clients or not. Can specify one
     * of NONE, ENABLE, or DISABLE. Specify ENABLE to always enable QUIC, Enables QUIC when set to
     * ENABLE, and disables QUIC when set to DISABLE. If NONE is specified, uses the QUIC policy
     * with no user overrides, which is equivalent to DISABLE. Not specifying this field is
     * equivalent to specifying NONE.
     */
    public String getQuicOverride() {
      return quicOverride;
    }

    /**
     * Specifies the QUIC override policy for this TargetHttpsProxy resource. This determines
     * whether the load balancer will attempt to negotiate QUIC with clients or not. Can specify one
     * of NONE, ENABLE, or DISABLE. Specify ENABLE to always enable QUIC, Enables QUIC when set to
     * ENABLE, and disables QUIC when set to DISABLE. If NONE is specified, uses the QUIC policy
     * with no user overrides, which is equivalent to DISABLE. Not specifying this field is
     * equivalent to specifying NONE.
     */
    public Builder setQuicOverride(String quicOverride) {
      this.quicOverride = quicOverride;
      return this;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /**
     * URLs to SslCertificate resources that are used to authenticate connections between users and
     * the load balancer. At least one SSL certificate must be specified. Currently, you may specify
     * up to 15 SSL certificates.
     */
    public List<String> getSslCertificatesList() {
      return sslCertificates;
    }

    /**
     * URLs to SslCertificate resources that are used to authenticate connections between users and
     * the load balancer. At least one SSL certificate must be specified. Currently, you may specify
     * up to 15 SSL certificates.
     */
    public Builder addAllSslCertificates(List<String> sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.addAll(sslCertificates);
      return this;
    }

    /**
     * URLs to SslCertificate resources that are used to authenticate connections between users and
     * the load balancer. At least one SSL certificate must be specified. Currently, you may specify
     * up to 15 SSL certificates.
     */
    public Builder addSslCertificates(String sslCertificates) {
      if (this.sslCertificates == null) {
        this.sslCertificates = new LinkedList<>();
      }
      this.sslCertificates.add(sslCertificates);
      return this;
    }

    /**
     * URL of SslPolicy resource that will be associated with the TargetHttpsProxy resource. If not
     * set, the TargetHttpsProxy resource will not have any SSL policy configured.
     */
    public String getSslPolicy() {
      return sslPolicy;
    }

    /**
     * URL of SslPolicy resource that will be associated with the TargetHttpsProxy resource. If not
     * set, the TargetHttpsProxy resource will not have any SSL policy configured.
     */
    public Builder setSslPolicy(String sslPolicy) {
      this.sslPolicy = sslPolicy;
      return this;
    }

    /**
     * A fully-qualified or valid partial URL to the UrlMap resource that defines the mapping from
     * URL to the BackendService. For example, the following are all valid URLs for specifying a URL
     * map: - https://www.googleapis.compute/v1/projects/project/global/urlMaps/url-map -
     * projects/project/global/urlMaps/url-map - global/urlMaps/url-map
     */
    public String getUrlMap() {
      return urlMap;
    }

    /**
     * A fully-qualified or valid partial URL to the UrlMap resource that defines the mapping from
     * URL to the BackendService. For example, the following are all valid URLs for specifying a URL
     * map: - https://www.googleapis.compute/v1/projects/project/global/urlMaps/url-map -
     * projects/project/global/urlMaps/url-map - global/urlMaps/url-map
     */
    public Builder setUrlMap(String urlMap) {
      this.urlMap = urlMap;
      return this;
    }

    public TargetHttpsProxy build() {

      return new TargetHttpsProxy(
          creationTimestamp,
          description,
          id,
          kind,
          name,
          quicOverride,
          selfLink,
          sslCertificates,
          sslPolicy,
          urlMap);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setQuicOverride(this.quicOverride);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllSslCertificates(this.sslCertificates);
      newBuilder.setSslPolicy(this.sslPolicy);
      newBuilder.setUrlMap(this.urlMap);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetHttpsProxy{"
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
        + "quicOverride="
        + quicOverride
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "sslCertificates="
        + sslCertificates
        + ", "
        + "sslPolicy="
        + sslPolicy
        + ", "
        + "urlMap="
        + urlMap
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetHttpsProxy) {
      TargetHttpsProxy that = (TargetHttpsProxy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.quicOverride, that.getQuicOverride())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.sslCertificates, that.getSslCertificatesList())
          && Objects.equals(this.sslPolicy, that.getSslPolicy())
          && Objects.equals(this.urlMap, that.getUrlMap());
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
        quicOverride,
        selfLink,
        sslCertificates,
        sslPolicy,
        urlMap);
  }
}
