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
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
/**
 * Represents a collection of network endpoints.
 *
 * <p>A network endpoint group (NEG) defines how a set of endpoints should be reached, whether they
 * are reachable, and where they are located. For more information about using NEGs, see Setting up
 * internet NEGs, Setting up zonal NEGs, or Setting up serverless NEGs. (== resource_for
 * {$api_version}.networkEndpointGroups ==) (== resource_for
 * {$api_version}.globalNetworkEndpointGroups ==) (== resource_for
 * {$api_version}.regionNetworkEndpointGroups ==)
 */
public final class NetworkEndpointGroup implements ApiMessage {
  private final Map<String, String> annotations;
  private final NetworkEndpointGroupAppEngine appEngine;
  private final NetworkEndpointGroupCloudFunction cloudFunction;
  private final NetworkEndpointGroupCloudRun cloudRun;
  private final String creationTimestamp;
  private final Integer defaultPort;
  private final String description;
  private final String id;
  private final String kind;
  private final String name;
  private final String network;
  private final String networkEndpointType;
  private final String region;
  private final String selfLink;
  private final Integer size;
  private final String subnetwork;
  private final String zone;

  private NetworkEndpointGroup() {
    this.annotations = null;
    this.appEngine = null;
    this.cloudFunction = null;
    this.cloudRun = null;
    this.creationTimestamp = null;
    this.defaultPort = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.name = null;
    this.network = null;
    this.networkEndpointType = null;
    this.region = null;
    this.selfLink = null;
    this.size = null;
    this.subnetwork = null;
    this.zone = null;
  }

  private NetworkEndpointGroup(
      Map<String, String> annotations,
      NetworkEndpointGroupAppEngine appEngine,
      NetworkEndpointGroupCloudFunction cloudFunction,
      NetworkEndpointGroupCloudRun cloudRun,
      String creationTimestamp,
      Integer defaultPort,
      String description,
      String id,
      String kind,
      String name,
      String network,
      String networkEndpointType,
      String region,
      String selfLink,
      Integer size,
      String subnetwork,
      String zone) {
    this.annotations = annotations;
    this.appEngine = appEngine;
    this.cloudFunction = cloudFunction;
    this.cloudRun = cloudRun;
    this.creationTimestamp = creationTimestamp;
    this.defaultPort = defaultPort;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.name = name;
    this.network = network;
    this.networkEndpointType = networkEndpointType;
    this.region = region;
    this.selfLink = selfLink;
    this.size = size;
    this.subnetwork = subnetwork;
    this.zone = zone;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("annotations".equals(fieldName)) {
      return annotations;
    }
    if ("appEngine".equals(fieldName)) {
      return appEngine;
    }
    if ("cloudFunction".equals(fieldName)) {
      return cloudFunction;
    }
    if ("cloudRun".equals(fieldName)) {
      return cloudRun;
    }
    if ("creationTimestamp".equals(fieldName)) {
      return creationTimestamp;
    }
    if ("defaultPort".equals(fieldName)) {
      return defaultPort;
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
    if ("network".equals(fieldName)) {
      return network;
    }
    if ("networkEndpointType".equals(fieldName)) {
      return networkEndpointType;
    }
    if ("region".equals(fieldName)) {
      return region;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("size".equals(fieldName)) {
      return size;
    }
    if ("subnetwork".equals(fieldName)) {
      return subnetwork;
    }
    if ("zone".equals(fieldName)) {
      return zone;
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

  /** Metadata defined as annotations on the network endpoint group. */
  public Map<String, String> getAnnotationsMap() {
    return annotations;
  }

  /**
   * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
   * cloudFunction may be set.
   */
  public NetworkEndpointGroupAppEngine getAppEngine() {
    return appEngine;
  }

  /**
   * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
   * cloudFunction may be set.
   */
  public NetworkEndpointGroupCloudFunction getCloudFunction() {
    return cloudFunction;
  }

  /**
   * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
   * cloudFunction may be set.
   */
  public NetworkEndpointGroupCloudRun getCloudRun() {
    return cloudRun;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** The default port used if the port number is not specified in the network endpoint. */
  public Integer getDefaultPort() {
    return defaultPort;
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

  /**
   * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
   * group.
   */
  public String getKind() {
    return kind;
  }

  /**
   * Name of the resource; provided by the client when the resource is created. The name must be
   * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
   * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
   * character must be a lowercase letter, and all following characters must be a dash, lowercase
   * letter, or digit, except the last character, which cannot be a dash.
   */
  public String getName() {
    return name;
  }

  /**
   * The URL of the network to which all network endpoints in the NEG belong. Uses "default" project
   * network if unspecified.
   */
  public String getNetwork() {
    return network;
  }

  /**
   * Type of network endpoints in this network endpoint group. Can be one of GCE_VM_IP_PORT,
   * NON_GCP_PRIVATE_IP_PORT, INTERNET_FQDN_PORT, INTERNET_IP_PORT, or SERVERLESS.
   */
  public String getNetworkEndpointType() {
    return networkEndpointType;
  }

  /** [Output Only] The URL of the region where the network endpoint group is located. */
  public String getRegion() {
    return region;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output only] Number of network endpoints in the network endpoint group. */
  public Integer getSize() {
    return size;
  }

  /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
  public String getSubnetwork() {
    return subnetwork;
  }

  /** [Output Only] The URL of the zone where the network endpoint group is located. */
  public String getZone() {
    return zone;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(NetworkEndpointGroup prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static NetworkEndpointGroup getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final NetworkEndpointGroup DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new NetworkEndpointGroup();
  }

  public static class Builder {
    private Map<String, String> annotations;
    private NetworkEndpointGroupAppEngine appEngine;
    private NetworkEndpointGroupCloudFunction cloudFunction;
    private NetworkEndpointGroupCloudRun cloudRun;
    private String creationTimestamp;
    private Integer defaultPort;
    private String description;
    private String id;
    private String kind;
    private String name;
    private String network;
    private String networkEndpointType;
    private String region;
    private String selfLink;
    private Integer size;
    private String subnetwork;
    private String zone;

    Builder() {}

    public Builder mergeFrom(NetworkEndpointGroup other) {
      if (other == NetworkEndpointGroup.getDefaultInstance()) return this;
      if (other.getAnnotationsMap() != null) {
        this.annotations = other.annotations;
      }
      if (other.getAppEngine() != null) {
        this.appEngine = other.appEngine;
      }
      if (other.getCloudFunction() != null) {
        this.cloudFunction = other.cloudFunction;
      }
      if (other.getCloudRun() != null) {
        this.cloudRun = other.cloudRun;
      }
      if (other.getCreationTimestamp() != null) {
        this.creationTimestamp = other.creationTimestamp;
      }
      if (other.getDefaultPort() != null) {
        this.defaultPort = other.defaultPort;
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
      if (other.getNetwork() != null) {
        this.network = other.network;
      }
      if (other.getNetworkEndpointType() != null) {
        this.networkEndpointType = other.networkEndpointType;
      }
      if (other.getRegion() != null) {
        this.region = other.region;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getSize() != null) {
        this.size = other.size;
      }
      if (other.getSubnetwork() != null) {
        this.subnetwork = other.subnetwork;
      }
      if (other.getZone() != null) {
        this.zone = other.zone;
      }
      return this;
    }

    Builder(NetworkEndpointGroup source) {
      this.annotations = source.annotations;
      this.appEngine = source.appEngine;
      this.cloudFunction = source.cloudFunction;
      this.cloudRun = source.cloudRun;
      this.creationTimestamp = source.creationTimestamp;
      this.defaultPort = source.defaultPort;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.name = source.name;
      this.network = source.network;
      this.networkEndpointType = source.networkEndpointType;
      this.region = source.region;
      this.selfLink = source.selfLink;
      this.size = source.size;
      this.subnetwork = source.subnetwork;
      this.zone = source.zone;
    }

    /** Metadata defined as annotations on the network endpoint group. */
    public Map<String, String> getAnnotationsMap() {
      return annotations;
    }

    /** Metadata defined as annotations on the network endpoint group. */
    public Builder putAllAnnotations(Map<String, String> annotations) {
      this.annotations = annotations;
      return this;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public NetworkEndpointGroupAppEngine getAppEngine() {
      return appEngine;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public Builder setAppEngine(NetworkEndpointGroupAppEngine appEngine) {
      this.appEngine = appEngine;
      return this;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public NetworkEndpointGroupCloudFunction getCloudFunction() {
      return cloudFunction;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public Builder setCloudFunction(NetworkEndpointGroupCloudFunction cloudFunction) {
      this.cloudFunction = cloudFunction;
      return this;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public NetworkEndpointGroupCloudRun getCloudRun() {
      return cloudRun;
    }

    /**
     * Only valid when networkEndpointType is "SERVERLESS". Only one of cloudRun, appEngine or
     * cloudFunction may be set.
     */
    public Builder setCloudRun(NetworkEndpointGroupCloudRun cloudRun) {
      this.cloudRun = cloudRun;
      return this;
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

    /** The default port used if the port number is not specified in the network endpoint. */
    public Integer getDefaultPort() {
      return defaultPort;
    }

    /** The default port used if the port number is not specified in the network endpoint. */
    public Builder setDefaultPort(Integer defaultPort) {
      this.defaultPort = defaultPort;
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

    /**
     * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
     * group.
     */
    public String getKind() {
      return kind;
    }

    /**
     * [Output Only] Type of the resource. Always compute#networkEndpointGroup for network endpoint
     * group.
     */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
     * 1-63 characters long, and comply with RFC1035. Specifically, the name must be 1-63 characters
     * long and match the regular expression `[a-z]([-a-z0-9]&#42;[a-z0-9])?` which means the first
     * character must be a lowercase letter, and all following characters must be a dash, lowercase
     * letter, or digit, except the last character, which cannot be a dash.
     */
    public String getName() {
      return name;
    }

    /**
     * Name of the resource; provided by the client when the resource is created. The name must be
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
     * The URL of the network to which all network endpoints in the NEG belong. Uses "default"
     * project network if unspecified.
     */
    public String getNetwork() {
      return network;
    }

    /**
     * The URL of the network to which all network endpoints in the NEG belong. Uses "default"
     * project network if unspecified.
     */
    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    /**
     * Type of network endpoints in this network endpoint group. Can be one of GCE_VM_IP_PORT,
     * NON_GCP_PRIVATE_IP_PORT, INTERNET_FQDN_PORT, INTERNET_IP_PORT, or SERVERLESS.
     */
    public String getNetworkEndpointType() {
      return networkEndpointType;
    }

    /**
     * Type of network endpoints in this network endpoint group. Can be one of GCE_VM_IP_PORT,
     * NON_GCP_PRIVATE_IP_PORT, INTERNET_FQDN_PORT, INTERNET_IP_PORT, or SERVERLESS.
     */
    public Builder setNetworkEndpointType(String networkEndpointType) {
      this.networkEndpointType = networkEndpointType;
      return this;
    }

    /** [Output Only] The URL of the region where the network endpoint group is located. */
    public String getRegion() {
      return region;
    }

    /** [Output Only] The URL of the region where the network endpoint group is located. */
    public Builder setRegion(String region) {
      this.region = region;
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

    /** [Output only] Number of network endpoints in the network endpoint group. */
    public Integer getSize() {
      return size;
    }

    /** [Output only] Number of network endpoints in the network endpoint group. */
    public Builder setSize(Integer size) {
      this.size = size;
      return this;
    }

    /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
    public String getSubnetwork() {
      return subnetwork;
    }

    /** Optional URL of the subnetwork to which all network endpoints in the NEG belong. */
    public Builder setSubnetwork(String subnetwork) {
      this.subnetwork = subnetwork;
      return this;
    }

    /** [Output Only] The URL of the zone where the network endpoint group is located. */
    public String getZone() {
      return zone;
    }

    /** [Output Only] The URL of the zone where the network endpoint group is located. */
    public Builder setZone(String zone) {
      this.zone = zone;
      return this;
    }

    public NetworkEndpointGroup build() {

      return new NetworkEndpointGroup(
          annotations,
          appEngine,
          cloudFunction,
          cloudRun,
          creationTimestamp,
          defaultPort,
          description,
          id,
          kind,
          name,
          network,
          networkEndpointType,
          region,
          selfLink,
          size,
          subnetwork,
          zone);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.putAllAnnotations(this.annotations);
      newBuilder.setAppEngine(this.appEngine);
      newBuilder.setCloudFunction(this.cloudFunction);
      newBuilder.setCloudRun(this.cloudRun);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDefaultPort(this.defaultPort);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNetwork(this.network);
      newBuilder.setNetworkEndpointType(this.networkEndpointType);
      newBuilder.setRegion(this.region);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setSize(this.size);
      newBuilder.setSubnetwork(this.subnetwork);
      newBuilder.setZone(this.zone);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "NetworkEndpointGroup{"
        + "annotations="
        + annotations
        + ", "
        + "appEngine="
        + appEngine
        + ", "
        + "cloudFunction="
        + cloudFunction
        + ", "
        + "cloudRun="
        + cloudRun
        + ", "
        + "creationTimestamp="
        + creationTimestamp
        + ", "
        + "defaultPort="
        + defaultPort
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
        + "network="
        + network
        + ", "
        + "networkEndpointType="
        + networkEndpointType
        + ", "
        + "region="
        + region
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "size="
        + size
        + ", "
        + "subnetwork="
        + subnetwork
        + ", "
        + "zone="
        + zone
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkEndpointGroup) {
      NetworkEndpointGroup that = (NetworkEndpointGroup) o;
      return Objects.equals(this.annotations, that.getAnnotationsMap())
          && Objects.equals(this.appEngine, that.getAppEngine())
          && Objects.equals(this.cloudFunction, that.getCloudFunction())
          && Objects.equals(this.cloudRun, that.getCloudRun())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.defaultPort, that.getDefaultPort())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.networkEndpointType, that.getNetworkEndpointType())
          && Objects.equals(this.region, that.getRegion())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.size, that.getSize())
          && Objects.equals(this.subnetwork, that.getSubnetwork())
          && Objects.equals(this.zone, that.getZone());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        annotations,
        appEngine,
        cloudFunction,
        cloudRun,
        creationTimestamp,
        defaultPort,
        description,
        id,
        kind,
        name,
        network,
        networkEndpointType,
        region,
        selfLink,
        size,
        subnetwork,
        zone);
  }
}
