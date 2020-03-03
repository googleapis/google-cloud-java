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
import java.util.Objects;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("by GAPIC")
@BetaApi
public final class PacketMirroringMirroredResourceInfo implements ApiMessage {
  private final List<PacketMirroringMirroredResourceInfoInstanceInfo> instances;
  private final List<PacketMirroringMirroredResourceInfoSubnetInfo> subnetworks;
  private final List<String> tags;

  private PacketMirroringMirroredResourceInfo() {
    this.instances = null;
    this.subnetworks = null;
    this.tags = null;
  }

  private PacketMirroringMirroredResourceInfo(
      List<PacketMirroringMirroredResourceInfoInstanceInfo> instances,
      List<PacketMirroringMirroredResourceInfoSubnetInfo> subnetworks,
      List<String> tags) {
    this.instances = instances;
    this.subnetworks = subnetworks;
    this.tags = tags;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("instances".equals(fieldName)) {
      return instances;
    }
    if ("subnetworks".equals(fieldName)) {
      return subnetworks;
    }
    if ("tags".equals(fieldName)) {
      return tags;
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
   * A set of virtual machine instances that are being mirrored. They must live in zones contained
   * in the same region as this packetMirroring.
   *
   * <p>Note that this config will apply only to those network interfaces of the Instances that
   * belong to the network specified in this packetMirroring.
   *
   * <p>You may specify a maximum of 50 Instances.
   */
  public List<PacketMirroringMirroredResourceInfoInstanceInfo> getInstancesList() {
    return instances;
  }

  /**
   * A set of subnetworks for which traffic from/to all VM instances will be mirrored. They must
   * live in the same region as this packetMirroring.
   *
   * <p>You may specify a maximum of 5 subnetworks.
   */
  public List<PacketMirroringMirroredResourceInfoSubnetInfo> getSubnetworksList() {
    return subnetworks;
  }

  /**
   * A set of mirrored tags. Traffic from/to all VM instances that have one or more of these tags
   * will be mirrored.
   */
  public List<String> getTagsList() {
    return tags;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(PacketMirroringMirroredResourceInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static PacketMirroringMirroredResourceInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final PacketMirroringMirroredResourceInfo DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new PacketMirroringMirroredResourceInfo();
  }

  public static class Builder {
    private List<PacketMirroringMirroredResourceInfoInstanceInfo> instances;
    private List<PacketMirroringMirroredResourceInfoSubnetInfo> subnetworks;
    private List<String> tags;

    Builder() {}

    public Builder mergeFrom(PacketMirroringMirroredResourceInfo other) {
      if (other == PacketMirroringMirroredResourceInfo.getDefaultInstance()) return this;
      if (other.getInstancesList() != null) {
        this.instances = other.instances;
      }
      if (other.getSubnetworksList() != null) {
        this.subnetworks = other.subnetworks;
      }
      if (other.getTagsList() != null) {
        this.tags = other.tags;
      }
      return this;
    }

    Builder(PacketMirroringMirroredResourceInfo source) {
      this.instances = source.instances;
      this.subnetworks = source.subnetworks;
      this.tags = source.tags;
    }

    /**
     * A set of virtual machine instances that are being mirrored. They must live in zones contained
     * in the same region as this packetMirroring.
     *
     * <p>Note that this config will apply only to those network interfaces of the Instances that
     * belong to the network specified in this packetMirroring.
     *
     * <p>You may specify a maximum of 50 Instances.
     */
    public List<PacketMirroringMirroredResourceInfoInstanceInfo> getInstancesList() {
      return instances;
    }

    /**
     * A set of virtual machine instances that are being mirrored. They must live in zones contained
     * in the same region as this packetMirroring.
     *
     * <p>Note that this config will apply only to those network interfaces of the Instances that
     * belong to the network specified in this packetMirroring.
     *
     * <p>You may specify a maximum of 50 Instances.
     */
    public Builder addAllInstances(
        List<PacketMirroringMirroredResourceInfoInstanceInfo> instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.addAll(instances);
      return this;
    }

    /**
     * A set of virtual machine instances that are being mirrored. They must live in zones contained
     * in the same region as this packetMirroring.
     *
     * <p>Note that this config will apply only to those network interfaces of the Instances that
     * belong to the network specified in this packetMirroring.
     *
     * <p>You may specify a maximum of 50 Instances.
     */
    public Builder addInstances(PacketMirroringMirroredResourceInfoInstanceInfo instances) {
      if (this.instances == null) {
        this.instances = new LinkedList<>();
      }
      this.instances.add(instances);
      return this;
    }

    /**
     * A set of subnetworks for which traffic from/to all VM instances will be mirrored. They must
     * live in the same region as this packetMirroring.
     *
     * <p>You may specify a maximum of 5 subnetworks.
     */
    public List<PacketMirroringMirroredResourceInfoSubnetInfo> getSubnetworksList() {
      return subnetworks;
    }

    /**
     * A set of subnetworks for which traffic from/to all VM instances will be mirrored. They must
     * live in the same region as this packetMirroring.
     *
     * <p>You may specify a maximum of 5 subnetworks.
     */
    public Builder addAllSubnetworks(
        List<PacketMirroringMirroredResourceInfoSubnetInfo> subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.addAll(subnetworks);
      return this;
    }

    /**
     * A set of subnetworks for which traffic from/to all VM instances will be mirrored. They must
     * live in the same region as this packetMirroring.
     *
     * <p>You may specify a maximum of 5 subnetworks.
     */
    public Builder addSubnetworks(PacketMirroringMirroredResourceInfoSubnetInfo subnetworks) {
      if (this.subnetworks == null) {
        this.subnetworks = new LinkedList<>();
      }
      this.subnetworks.add(subnetworks);
      return this;
    }

    /**
     * A set of mirrored tags. Traffic from/to all VM instances that have one or more of these tags
     * will be mirrored.
     */
    public List<String> getTagsList() {
      return tags;
    }

    /**
     * A set of mirrored tags. Traffic from/to all VM instances that have one or more of these tags
     * will be mirrored.
     */
    public Builder addAllTags(List<String> tags) {
      if (this.tags == null) {
        this.tags = new LinkedList<>();
      }
      this.tags.addAll(tags);
      return this;
    }

    /**
     * A set of mirrored tags. Traffic from/to all VM instances that have one or more of these tags
     * will be mirrored.
     */
    public Builder addTags(String tags) {
      if (this.tags == null) {
        this.tags = new LinkedList<>();
      }
      this.tags.add(tags);
      return this;
    }

    public PacketMirroringMirroredResourceInfo build() {

      return new PacketMirroringMirroredResourceInfo(instances, subnetworks, tags);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.addAllInstances(this.instances);
      newBuilder.addAllSubnetworks(this.subnetworks);
      newBuilder.addAllTags(this.tags);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "PacketMirroringMirroredResourceInfo{"
        + "instances="
        + instances
        + ", "
        + "subnetworks="
        + subnetworks
        + ", "
        + "tags="
        + tags
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PacketMirroringMirroredResourceInfo) {
      PacketMirroringMirroredResourceInfo that = (PacketMirroringMirroredResourceInfo) o;
      return Objects.equals(this.instances, that.getInstancesList())
          && Objects.equals(this.subnetworks, that.getSubnetworksList())
          && Objects.equals(this.tags, that.getTagsList());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(instances, subnetworks, tags);
  }
}
