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
/**
 * Represents a Target gRPC Proxy resource.
 *
 * <p>A target gRPC proxy is a component of load balancers intended for load balancing gRPC traffic.
 * Global forwarding rules reference a target gRPC proxy. The Target gRPC Proxy references a URL map
 * which specifies how traffic routes to gRPC backend services. (== resource_for
 * {$api_version}.targetGrpcProxies ==)
 */
public final class TargetGrpcProxy implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String fingerprint;
  private final String id;
  private final String kind;
  private final String name;
  private final String selfLink;
  private final String selfLinkWithId;
  private final String urlMap;
  private final Boolean validateForProxyless;

  private TargetGrpcProxy() {
    this.creationTimestamp = null;
    this.description = null;
    this.fingerprint = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.selfLink = null;
    this.selfLinkWithId = null;
    this.urlMap = null;
    this.validateForProxyless = null;
  }

  private TargetGrpcProxy(
      String creationTimestamp,
      String description,
      String fingerprint,
      String id,
      String kind,
      String name,
      String selfLink,
      String selfLinkWithId,
      String urlMap,
      Boolean validateForProxyless) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.fingerprint = fingerprint;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.selfLink = selfLink;
    this.selfLinkWithId = selfLinkWithId;
    this.urlMap = urlMap;
    this.validateForProxyless = validateForProxyless;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("fingerprint".equals(fieldName)) {
      return fingerprint;
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
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("selfLinkWithId".equals(fieldName)) {
      return selfLinkWithId;
    }
    if ("urlMap".equals(fieldName)) {
      return urlMap;
    }
    if ("validateForProxyless".equals(fieldName)) {
      return validateForProxyless;
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
   * Fingerprint of this resource. A hash of the contents stored in this object. This field is used
   * in optimistic locking. This field will be ignored when inserting a TargetGrpcProxy. An
   * up-to-date fingerprint must be provided in order to patch/update the TargetGrpcProxy;
   * otherwise, the request will fail with error 412 conditionNotMet. To see the latest fingerprint,
   * make a get() request to retrieve the TargetGrpcProxy.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * [Output Only] The unique identifier for the resource type. The server generates this
   * identifier.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of the resource. Always compute#targetGrpcProxy for target grpc proxies. */
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

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Server-defined URL with id for the resource. */
  public String getSelfLinkWithId() {
    return selfLinkWithId;
  }

  /**
   * URL to the UrlMap resource that defines the mapping from URL to the BackendService. The
   * protocol field in the BackendService must be set to GRPC.
   */
  public String getUrlMap() {
    return urlMap;
  }

  /**
   * If true, indicates that the BackendServices referenced by the urlMap may be accessed by gRPC
   * applications without using a sidecar proxy. This will enable configuration checks on urlMap and
   * its referenced BackendServices to not allow unsupported features. A gRPC application must use
   * "xds:///" scheme in the target URI of the service it is connecting to. If false, indicates that
   * the BackendServices referenced by the urlMap will be accessed by gRPC applications via a
   * sidecar proxy. In this case, a gRPC application must not use "xds:///" scheme in the target URI
   * of the service it is connecting to
   */
  public Boolean getValidateForProxyless() {
    return validateForProxyless;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(TargetGrpcProxy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static TargetGrpcProxy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final TargetGrpcProxy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new TargetGrpcProxy();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String fingerprint;
    private String id;
    private String kind;
    private String name;
    private String selfLink;
    private String selfLinkWithId;
    private String urlMap;
    private Boolean validateForProxyless;

    Builder() {}

    public Builder mergeFrom(TargetGrpcProxy other) {
      if (other == TargetGrpcProxy.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getFingerprint() != null) {
        this.fingerprint = other.fingerprint;
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
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSelfLinkWithId() != null) {
        this.selfLinkWithId = other.selfLinkWithId;
      }
      if (other.getUrlMap() != null) {
        this.urlMap = other.urlMap;
      }
      if (other.getValidateForProxyless() != null) {
        this.validateForProxyless = other.validateForProxyless;
      }
      return this;
    }

    Builder(TargetGrpcProxy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.fingerprint = source.fingerprint;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.selfLinkWithId = source.selfLinkWithId;
      this.urlMap = source.urlMap;
      this.validateForProxyless = source.validateForProxyless;
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
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a TargetGrpcProxy. An
     * up-to-date fingerprint must be provided in order to patch/update the TargetGrpcProxy;
     * otherwise, the request will fail with error 412 conditionNotMet. To see the latest
     * fingerprint, make a get() request to retrieve the TargetGrpcProxy.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a TargetGrpcProxy. An
     * up-to-date fingerprint must be provided in order to patch/update the TargetGrpcProxy;
     * otherwise, the request will fail with error 412 conditionNotMet. To see the latest
     * fingerprint, make a get() request to retrieve the TargetGrpcProxy.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    /**
     * [Output Only] The unique identifier for the resource type. The server generates this
     * identifier.
     */
    public String getId() {
      return id;
    }

    /**
     * [Output Only] The unique identifier for the resource type. The server generates this
     * identifier.
     */
    public Builder setId(String id) {
      this.id = id;
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#targetGrpcProxy for target grpc proxies.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#targetGrpcProxy for target grpc proxies.
     */
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

    /** [Output Only] Server-defined URL for the resource. */
    public String getSelfLink() {
      return selfLink;
    }

    /** [Output Only] Server-defined URL for the resource. */
    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    /** [Output Only] Server-defined URL with id for the resource. */
    public String getSelfLinkWithId() {
      return selfLinkWithId;
    }

    /** [Output Only] Server-defined URL with id for the resource. */
    public Builder setSelfLinkWithId(String selfLinkWithId) {
      this.selfLinkWithId = selfLinkWithId;
      return this;
    }

    /**
     * URL to the UrlMap resource that defines the mapping from URL to the BackendService. The
     * protocol field in the BackendService must be set to GRPC.
     */
    public String getUrlMap() {
      return urlMap;
    }

    /**
     * URL to the UrlMap resource that defines the mapping from URL to the BackendService. The
     * protocol field in the BackendService must be set to GRPC.
     */
    public Builder setUrlMap(String urlMap) {
      this.urlMap = urlMap;
      return this;
    }

    /**
     * If true, indicates that the BackendServices referenced by the urlMap may be accessed by gRPC
     * applications without using a sidecar proxy. This will enable configuration checks on urlMap
     * and its referenced BackendServices to not allow unsupported features. A gRPC application must
     * use "xds:///" scheme in the target URI of the service it is connecting to. If false,
     * indicates that the BackendServices referenced by the urlMap will be accessed by gRPC
     * applications via a sidecar proxy. In this case, a gRPC application must not use "xds:///"
     * scheme in the target URI of the service it is connecting to
     */
    public Boolean getValidateForProxyless() {
      return validateForProxyless;
    }

    /**
     * If true, indicates that the BackendServices referenced by the urlMap may be accessed by gRPC
     * applications without using a sidecar proxy. This will enable configuration checks on urlMap
     * and its referenced BackendServices to not allow unsupported features. A gRPC application must
     * use "xds:///" scheme in the target URI of the service it is connecting to. If false,
     * indicates that the BackendServices referenced by the urlMap will be accessed by gRPC
     * applications via a sidecar proxy. In this case, a gRPC application must not use "xds:///"
     * scheme in the target URI of the service it is connecting to
     */
    public Builder setValidateForProxyless(Boolean validateForProxyless) {
      this.validateForProxyless = validateForProxyless;
      return this;
    }

    public TargetGrpcProxy build() {

      return new TargetGrpcProxy(
          creationTimestamp,
          description,
          fingerprint,
          id,
          kind,
          name,
          selfLink,
          selfLinkWithId,
          urlMap,
          validateForProxyless);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSelfLinkWithId(this.selfLinkWithId);
      newBuilder.setUrlMap(this.urlMap);
      newBuilder.setValidateForProxyless(this.validateForProxyless);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "TargetGrpcProxy{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "fingerprint="
        + fingerprint
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
        + "selfLink="
        + selfLink
        + ", "
        + "selfLinkWithId="
        + selfLinkWithId
        + ", "
        + "urlMap="
        + urlMap
        + ", "
        + "validateForProxyless="
        + validateForProxyless
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetGrpcProxy) {
      TargetGrpcProxy that = (TargetGrpcProxy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.selfLinkWithId, that.getSelfLinkWithId())
          && Objects.equals(this.urlMap, that.getUrlMap())
          && Objects.equals(this.validateForProxyless, that.getValidateForProxyless());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        fingerprint,
        id,
        kind,
        name,
        selfLink,
        selfLinkWithId,
        urlMap,
        validateForProxyless);
  }
}
