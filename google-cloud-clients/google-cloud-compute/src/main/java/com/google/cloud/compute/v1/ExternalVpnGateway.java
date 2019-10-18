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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * External VPN gateway is the on-premises VPN gateway(s) or another cloud provider?s VPN gateway
 * that connects to your Google Cloud VPN gateway. To create a highly available VPN from Google
 * Cloud to your on-premises side or another Cloud provider's VPN gateway, you must create a
 * external VPN gateway resource in GCP, which provides the information to GCP about your external
 * VPN gateway.
 */
public final class ExternalVpnGateway implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final List<ExternalVpnGatewayInterface> interfaces;
  private final String kind;
  private final String labelFingerprint;
  private final Map<String, String> labels;
  private final String name;
  private final String redundancyType;
  private final String selfLink;

  private ExternalVpnGateway() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.interfaces = null;
    this.kind = null;
    this.labelFingerprint = null;
    this.labels = null;
    this.name = null;
    this.redundancyType = null;
    this.selfLink = null;
  }

  private ExternalVpnGateway(
      String creationTimestamp,
      String description,
      String id,
      List<ExternalVpnGatewayInterface> interfaces,
      String kind,
      String labelFingerprint,
      Map<String, String> labels,
      String name,
      String redundancyType,
      String selfLink) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.interfaces = interfaces;
    this.kind = kind;
    this.labelFingerprint = labelFingerprint;
    this.labels = labels;
    this.name = name;
    this.redundancyType = redundancyType;
    this.selfLink = selfLink;
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
    if ("interfaces".equals(fieldName)) {
      return interfaces;
    }
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("labelFingerprint".equals(fieldName)) {
      return labelFingerprint;
    }
    if ("labels".equals(fieldName)) {
      return labels;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("redundancyType".equals(fieldName)) {
      return redundancyType;
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
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** List of interfaces for this external VPN gateway. */
  public List<ExternalVpnGatewayInterface> getInterfacesList() {
    return interfaces;
  }

  /**
   * [Output Only] Type of the resource. Always compute#externalVpnGateway for externalVpnGateways.
   */
  public String getKind() {
    return kind;
  }

  /**
   * A fingerprint for the labels being applied to this ExternalVpnGateway, which is essentially a
   * hash of the labels set used for optimistic locking. The fingerprint is initially generated by
   * Compute Engine and changes after every request to modify or update labels. You must always
   * provide an up-to-date fingerprint hash in order to update or change labels, otherwise the
   * request will fail with error 412 conditionNotMet.
   *
   * <p>To see the latest fingerprint, make a get() request to retrieve an ExternalVpnGateway.
   */
  public String getLabelFingerprint() {
    return labelFingerprint;
  }

  /**
   * Labels to apply to this ExternalVpnGateway resource. These can be later modified by the
   * setLabels method. Each label key/value must comply with RFC1035. Label values may be empty.
   */
  public Map<String, String> getLabelsMap() {
    return labels;
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

  /** Indicates the user-supplied redundancy type of this external VPN gateway. */
  public String getRedundancyType() {
    return redundancyType;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(ExternalVpnGateway prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static ExternalVpnGateway getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final ExternalVpnGateway DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new ExternalVpnGateway();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private List<ExternalVpnGatewayInterface> interfaces;
    private String kind;
    private String labelFingerprint;
    private Map<String, String> labels;
    private String name;
    private String redundancyType;
    private String selfLink;

    Builder() {}

    public Builder mergeFrom(ExternalVpnGateway other) {
      if (other == ExternalVpnGateway.getDefaultInstance()) return this;
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDescription() != null) {
        this.description = other.description;
      }
      if (other.getId() != null) {
        this.id = other.id;
      }
      if (other.getInterfacesList() != null) {
        this.interfaces = other.interfaces;
      }
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getLabelFingerprint() != null) {
        this.labelFingerprint = other.labelFingerprint;
      }
      if (other.getLabelsMap() != null) {
        this.labels = other.labels;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getRedundancyType() != null) {
        this.redundancyType = other.redundancyType;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      return this;
    }

    Builder(ExternalVpnGateway source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.interfaces = source.interfaces;
      this.kind = source.kind;
      this.labelFingerprint = source.labelFingerprint;
      this.labels = source.labels;
      this.name = source.name;
      this.redundancyType = source.redundancyType;
      this.selfLink = source.selfLink;
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

    /** List of interfaces for this external VPN gateway. */
    public List<ExternalVpnGatewayInterface> getInterfacesList() {
      return interfaces;
    }

    /** List of interfaces for this external VPN gateway. */
    public Builder addAllInterfaces(List<ExternalVpnGatewayInterface> interfaces) {
      if (this.interfaces == null) {
        this.interfaces = new LinkedList<>();
      }
      this.interfaces.addAll(interfaces);
      return this;
    }

    /** List of interfaces for this external VPN gateway. */
    public Builder addInterfaces(ExternalVpnGatewayInterface interfaces) {
      if (this.interfaces == null) {
        this.interfaces = new LinkedList<>();
      }
      this.interfaces.add(interfaces);
      return this;
    }

    /**
     * [Output Only] Type of the resource. Always compute#externalVpnGateway for
     * externalVpnGateways.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#externalVpnGateway for
     * externalVpnGateways.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * A fingerprint for the labels being applied to this ExternalVpnGateway, which is essentially a
     * hash of the labels set used for optimistic locking. The fingerprint is initially generated by
     * Compute Engine and changes after every request to modify or update labels. You must always
     * provide an up-to-date fingerprint hash in order to update or change labels, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an ExternalVpnGateway.
     */
    public String getLabelFingerprint() {
      return labelFingerprint;
    }

    /**
     * A fingerprint for the labels being applied to this ExternalVpnGateway, which is essentially a
     * hash of the labels set used for optimistic locking. The fingerprint is initially generated by
     * Compute Engine and changes after every request to modify or update labels. You must always
     * provide an up-to-date fingerprint hash in order to update or change labels, otherwise the
     * request will fail with error 412 conditionNotMet.
     *
     * <p>To see the latest fingerprint, make a get() request to retrieve an ExternalVpnGateway.
     */
    public Builder setLabelFingerprint(String labelFingerprint) {
      this.labelFingerprint = labelFingerprint;
      return this;
    }

    /**
     * Labels to apply to this ExternalVpnGateway resource. These can be later modified by the
     * setLabels method. Each label key/value must comply with RFC1035. Label values may be empty.
     */
    public Map<String, String> getLabelsMap() {
      return labels;
    }

    /**
     * Labels to apply to this ExternalVpnGateway resource. These can be later modified by the
     * setLabels method. Each label key/value must comply with RFC1035. Label values may be empty.
     */
    public Builder putAllLabels(Map<String, String> labels) {
      this.labels = labels;
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

    /** Indicates the user-supplied redundancy type of this external VPN gateway. */
    public String getRedundancyType() {
      return redundancyType;
    }

    /** Indicates the user-supplied redundancy type of this external VPN gateway. */
    public Builder setRedundancyType(String redundancyType) {
      this.redundancyType = redundancyType;
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

    public ExternalVpnGateway build() {

      return new ExternalVpnGateway(
          creationTimestamp,
          description,
          id,
          interfaces,
          kind,
          labelFingerprint,
          labels,
          name,
          redundancyType,
          selfLink);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.addAllInterfaces(this.interfaces);
      newBuilder.setKind(this.kind);
      newBuilder.setLabelFingerprint(this.labelFingerprint);
      newBuilder.putAllLabels(this.labels);
      newBuilder.setName(this.name);
      newBuilder.setRedundancyType(this.redundancyType);
      newBuilder.setSelfLink(this.selfLink);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "ExternalVpnGateway{"
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "description="
        + description
        + ", "
        + "id="
        + id
        + ", "
        + "interfaces="
        + interfaces
        + ", "
        + "kind="
        + kind
        + ", "
        + "labelFingerprint="
        + labelFingerprint
        + ", "
        + "labels="
        + labels
        + ", "
        + "name="
        + name
        + ", "
        + "redundancyType="
        + redundancyType
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
    if (o instanceof ExternalVpnGateway) {
      ExternalVpnGateway that = (ExternalVpnGateway) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.interfaces, that.getInterfacesList())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.labelFingerprint, that.getLabelFingerprint())
          && Objects.equals(this.labels, that.getLabelsMap())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.redundancyType, that.getRedundancyType())
          && Objects.equals(this.selfLink, that.getSelfLink());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        creationTimestamp,
        description,
        id,
        interfaces,
        kind,
        labelFingerprint,
        labels,
        name,
        redundancyType,
        selfLink);
  }
}
