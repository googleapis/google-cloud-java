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
 * A SSL policy specifies the server-side support for SSL features. This can be attached to a
 * TargetHttpsProxy or a TargetSslProxy. This affects connections between clients and the HTTPS or
 * SSL proxy load balancer. They do not affect the connection between the load balancers and the
 * backends.
 */
public final class SslPolicy implements ApiMessage {
  private final String creationTimestamp;
  private final List<String> customFeatures;
  private final String description;
  private final List<String> enabledFeatures;
  private final String fingerprint;
  private final String id;
  private final String kind;
  private final String minTlsVersion;
  private final String name;
  private final String profile;
  private final String selfLink;
  private final List<Warnings> warnings;

  private SslPolicy() {
    this.creationTimestamp = null;
    this.customFeatures = null;
    this.description = null;
    this.enabledFeatures = null;
    this.fingerprint = null;
    this.id = null;
    this.kind = null;
    this.minTlsVersion = null;
    this.name = null;
    this.profile = null;
    this.selfLink = null;
    this.warnings = null;
  }

  private SslPolicy(
      String creationTimestamp,
      List<String> customFeatures,
      String description,
      List<String> enabledFeatures,
      String fingerprint,
      String id,
      String kind,
      String minTlsVersion,
      String name,
      String profile,
      String selfLink,
      List<Warnings> warnings) {
    this.creationTimestamp = creationTimestamp;
    this.customFeatures = customFeatures;
    this.description = description;
    this.enabledFeatures = enabledFeatures;
    this.fingerprint = fingerprint;
    this.id = id;
    this.kind = kind;
    this.minTlsVersion = minTlsVersion;
    this.name = name;
    this.profile = profile;
    this.selfLink = selfLink;
    this.warnings = warnings;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("customFeatures".equals(fieldName)) {
      return customFeatures;
    }
    if ("description".equals(fieldName)) {
      return description;
    }
    if ("enabledFeatures".equals(fieldName)) {
      return enabledFeatures;
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
    if ("minTlsVersion".equals(fieldName)) {
      return minTlsVersion;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("profile".equals(fieldName)) {
      return profile;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("warnings".equals(fieldName)) {
      return warnings;
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
   * A list of features enabled when the selected profile is CUSTOM. The - method returns the set of
   * features that can be specified in this list. This field must be empty if the profile is not
   * CUSTOM.
   */
  public List<String> getCustomFeaturesList() {
    return customFeatures;
  }

  /**
   * An optional description of this resource. Provide this property when you create the resource.
   */
  public String getDescription() {
    return description;
  }

  /** [Output Only] The list of features enabled in the SSL policy. */
  public List<String> getEnabledFeaturesList() {
    return enabledFeatures;
  }

  /**
   * Fingerprint of this resource. A hash of the contents stored in this object. This field is used
   * in optimistic locking. This field will be ignored when inserting a SslPolicy. An up-to-date
   * fingerprint must be provided in order to update the SslPolicy, otherwise the request will fail
   * with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve an SslPolicy.
   */
  public String getFingerprint() {
    return fingerprint;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output only] Type of the resource. Always compute#sslPolicyfor SSL policies. */
  public String getKind() {
    return kind;
  }

  /**
   * The minimum version of SSL protocol that can be used by the clients to establish a connection
   * with the load balancer. This can be one of TLS_1_0, TLS_1_1, TLS_1_2.
   */
  public String getMinTlsVersion() {
    return minTlsVersion;
  }

  /**
   * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
   * Specifically, the name must be 1-63 characters long and match the regular expression
   * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
   * and all following characters must be a dash, lowercase letter, or digit, except the last
   * character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * Profile specifies the set of SSL features that can be used by the load balancer when
   * negotiating SSL with clients. This can be one of COMPATIBLE, MODERN, RESTRICTED, or CUSTOM. If
   * using CUSTOM, the set of SSL features to enable must be specified in the customFeatures field.
   */
  public String getProfile() {
    return profile;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * [Output Only] If potential misconfigurations are detected for this SSL policy, this field will
   * be populated with warning messages.
   */
  public List<Warnings> getWarningsList() {
    return warnings;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(SslPolicy prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static SslPolicy getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final SslPolicy DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new SslPolicy();
  }

  public static class Builder {
    private String creationTimestamp;
    private List<String> customFeatures;
    private String description;
    private List<String> enabledFeatures;
    private String fingerprint;
    private String id;
    private String kind;
    private String minTlsVersion;
    private String name;
    private String profile;
    private String selfLink;
    private List<Warnings> warnings;

    Builder() {}

    public Builder mergeFrom(SslPolicy other) {
      if (other == SslPolicy.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getCustomFeaturesList() != null) {
        this.customFeatures = other.customFeatures;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getEnabledFeaturesList() != null) {
        this.enabledFeatures = other.enabledFeatures;
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
      if (other.getMinTlsVersion() != null) {
        this.minTlsVersion = other.minTlsVersion;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getProfile() != null) {
        this.profile = other.profile;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getWarningsList() != null) {
        this.warnings = other.warnings;
      }
      return this;
    }

    Builder(SslPolicy source) {
      this.creationTimestamp = source.creationTimestamp;
      this.customFeatures = source.customFeatures;
      this.description = source.description;
      this.enabledFeatures = source.enabledFeatures;
      this.fingerprint = source.fingerprint;
      this.id = source.id;
      this.kind = source.kind;
      this.minTlsVersion = source.minTlsVersion;
      this.name = source.name;
      this.profile = source.profile;
      this.selfLink = source.selfLink;
      this.warnings = source.warnings;
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
     * A list of features enabled when the selected profile is CUSTOM. The - method returns the set
     * of features that can be specified in this list. This field must be empty if the profile is
     * not CUSTOM.
     */
    public List<String> getCustomFeaturesList() {
      return customFeatures;
    }

    /**
     * A list of features enabled when the selected profile is CUSTOM. The - method returns the set
     * of features that can be specified in this list. This field must be empty if the profile is
     * not CUSTOM.
     */
    public Builder addAllCustomFeatures(List<String> customFeatures) {
      if (this.customFeatures == null) {
        this.customFeatures = new LinkedList<>();
      }
      this.customFeatures.addAll(customFeatures);
      return this;
    }

    /**
     * A list of features enabled when the selected profile is CUSTOM. The - method returns the set
     * of features that can be specified in this list. This field must be empty if the profile is
     * not CUSTOM.
     */
    public Builder addCustomFeatures(String customFeatures) {
      if (this.customFeatures == null) {
        this.customFeatures = new LinkedList<>();
      }
      this.customFeatures.add(customFeatures);
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

    /** [Output Only] The list of features enabled in the SSL policy. */
    public List<String> getEnabledFeaturesList() {
      return enabledFeatures;
    }

    /** [Output Only] The list of features enabled in the SSL policy. */
    public Builder addAllEnabledFeatures(List<String> enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.addAll(enabledFeatures);
      return this;
    }

    /** [Output Only] The list of features enabled in the SSL policy. */
    public Builder addEnabledFeatures(String enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new LinkedList<>();
      }
      this.enabledFeatures.add(enabledFeatures);
      return this;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a SslPolicy. An
     * up-to-date fingerprint must be provided in order to update the SslPolicy, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an SslPolicy.
     */
    public String getFingerprint() {
      return fingerprint;
    }

    /**
     * Fingerprint of this resource. A hash of the contents stored in this object. This field is
     * used in optimistic locking. This field will be ignored when inserting a SslPolicy. An
     * up-to-date fingerprint must be provided in order to update the SslPolicy, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an SslPolicy.
     */
    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
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

    /** [Output only] Type of the resource. Always compute#sslPolicyfor SSL policies. */
    public String getKind() {
      return kind;
    }

    /** [Output only] Type of the resource. Always compute#sslPolicyfor SSL policies. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * The minimum version of SSL protocol that can be used by the clients to establish a connection
     * with the load balancer. This can be one of TLS_1_0, TLS_1_1, TLS_1_2.
     */
    public String getMinTlsVersion() {
      return minTlsVersion;
    }

    /**
     * The minimum version of SSL protocol that can be used by the clients to establish a connection
     * with the load balancer. This can be one of TLS_1_0, TLS_1_1, TLS_1_2.
     */
    public Builder setMinTlsVersion(String minTlsVersion) {
      this.minTlsVersion = minTlsVersion;
      return this;
    }

    /**
     * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
     * Specifically, the name must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource. The name must be 1-63 characters long, and comply with RFC1035.
     * Specifically, the name must be 1-63 characters long and match the regular expression
     * `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first character must be a lowercase letter,
     * and all following characters must be a dash, lowercase letter, or digit, except the last
     * character, which cannot be a dash.
     */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * Profile specifies the set of SSL features that can be used by the load balancer when
     * negotiating SSL with clients. This can be one of COMPATIBLE, MODERN, RESTRICTED, or CUSTOM.
     * If using CUSTOM, the set of SSL features to enable must be specified in the customFeatures
     * field.
     */
    public String getProfile() {
      return profile;
    }

    /**
     * Profile specifies the set of SSL features that can be used by the load balancer when
     * negotiating SSL with clients. This can be one of COMPATIBLE, MODERN, RESTRICTED, or CUSTOM.
     * If using CUSTOM, the set of SSL features to enable must be specified in the customFeatures
     * field.
     */
    public Builder setProfile(String profile) {
      this.profile = profile;
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
     * [Output Only] If potential misconfigurations are detected for this SSL policy, this field
     * will be populated with warning messages.
     */
    public List<Warnings> getWarningsList() {
      return warnings;
    }

    /**
     * [Output Only] If potential misconfigurations are detected for this SSL policy, this field
     * will be populated with warning messages.
     */
    public Builder addAllWarnings(List<Warnings> warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.addAll(warnings);
      return this;
    }

    /**
     * [Output Only] If potential misconfigurations are detected for this SSL policy, this field
     * will be populated with warning messages.
     */
    public Builder addWarnings(Warnings warnings) {
      if (this.warnings == null) {
        this.warnings = new LinkedList<>();
      }
      this.warnings.add(warnings);
      return this;
    }

    public SslPolicy build() {

      return new SslPolicy(
          creationTimestamp,
          customFeatures,
          description,
          enabledFeatures,
          fingerprint,
          id,
          kind,
          minTlsVersion,
          name,
          profile,
          selfLink,
          warnings);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.addAllCustomFeatures(this.customFeatures);
      newBuilder.setDescription(this.description);
      newBuilder.addAllEnabledFeatures(this.enabledFeatures);
      newBuilder.setFingerprint(this.fingerprint);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setMinTlsVersion(this.minTlsVersion);
      newBuilder.setName(this.name);
      newBuilder.setProfile(this.profile);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.addAllWarnings(this.warnings);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "SslPolicy{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "customFeatures="
        + customFeatures
        + ", "
        + "description="
        + description
        + ", "
        + "enabledFeatures="
        + enabledFeatures
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
        + "minTlsVersion="
        + minTlsVersion
        + ", "
        + "name="
        + name
        + ", "
        + "profile="
        + profile
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "warnings="
        + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SslPolicy) {
      SslPolicy that = (SslPolicy) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.customFeatures, that.getCustomFeaturesList())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.enabledFeatures, that.getEnabledFeaturesList())
          && Objects.equals(this.fingerprint, that.getFingerprint())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.minTlsVersion, that.getMinTlsVersion())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.profile, that.getProfile())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.warnings, that.getWarningsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        customFeatures,
        description,
        enabledFeatures,
        fingerprint,
        id,
        kind,
        minTlsVersion,
        name,
        profile,
        selfLink,
        warnings);
  }
}
