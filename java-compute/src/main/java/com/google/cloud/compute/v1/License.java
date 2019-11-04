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
/** A license resource. */
public final class License implements ApiMessage {
  private final Boolean chargesUseFee;
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final String licenseCode;
  private final String name;
  private final LicenseResourceRequirements resourceRequirements;
  private final String selfLink;
  private final Boolean transferable;

  private License() {
    this.chargesUseFee = null;
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.licenseCode = null;
    this.name = null;
    this.resourceRequirements = null;
    this.selfLink = null;
    this.transferable = null;
  }

  private License(
      Boolean chargesUseFee,
      String creationTimestamp,
      String description,
      String id,
      String kind,
      String licenseCode,
      String name,
      LicenseResourceRequirements resourceRequirements,
      String selfLink,
      Boolean transferable) {
    this.chargesUseFee = chargesUseFee;
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.licenseCode = licenseCode;
    this.name = name;
    this.resourceRequirements = resourceRequirements;
    this.selfLink = selfLink;
    this.transferable = transferable;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("chargesUseFee".equals(fieldName)) {
      return chargesUseFee;
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
    if ("licenseCode".equals(fieldName)) {
      return licenseCode;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("resourceRequirements".equals(fieldName)) {
      return resourceRequirements;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("transferable".equals(fieldName)) {
      return transferable;
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
   * [Output Only] Deprecated. This field no longer reflects whether a license charges a usage fee.
   */
  public Boolean getChargesUseFee() {
    return chargesUseFee;
  }

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /**
   * An optional textual description of the resource; provided by the client when the resource is
   * created.
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

  /** [Output Only] Type of resource. Always compute#license for licenses. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] The unique code used to attach this license to images, snapshots, and disks. */
  public String getLicenseCode() {
    return licenseCode;
  }

  /** Name of the resource. The name must be 1-63 characters long and comply with RFC1035. */
  public String getName() {
    return name;
  }

  public LicenseResourceRequirements getResourceRequirements() {
    return resourceRequirements;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /**
   * If false, licenses will not be copied from the source resource when creating an image from a
   * disk, disk from snapshot, or snapshot from disk.
   */
  public Boolean getTransferable() {
    return transferable;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(License prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static License getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final License DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new License();
  }

  public static class Builder {
    private Boolean chargesUseFee;
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private String licenseCode;
    private String name;
    private LicenseResourceRequirements resourceRequirements;
    private String selfLink;
    private Boolean transferable;

    Builder() {}

    public Builder mergeFrom(License other) {
      if (other == License.getDefaultInstance()) return this;
      if (other.getChargesUseFee() != null) {
        this.chargesUseFee = other.chargesUseFee;
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
      if (other.getLicenseCode() != null) {
        this.licenseCode = other.licenseCode;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getResourceRequirements() != null) {
        this.resourceRequirements = other.resourceRequirements;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getTransferable() != null) {
        this.transferable = other.transferable;
      }
      return this;
    }

    Builder(License source) {
      this.chargesUseFee = source.chargesUseFee;
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.licenseCode = source.licenseCode;
      this.name = source.name;
      this.resourceRequirements = source.resourceRequirements;
      this.selfLink = source.selfLink;
      this.transferable = source.transferable;
    }

    /**
     * [Output Only] Deprecated. This field no longer reflects whether a license charges a usage
     * fee.
     */
    public Boolean getChargesUseFee() {
      return chargesUseFee;
    }

    /**
     * [Output Only] Deprecated. This field no longer reflects whether a license charges a usage
     * fee.
     */
    public Builder setChargesUseFee(Boolean chargesUseFee) {
      this.chargesUseFee = chargesUseFee;
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

    /**
     * An optional textual description of the resource; provided by the client when the resource is
     * created.
     */
    public String getDescription() {
      return description;
    }

    /**
     * An optional textual description of the resource; provided by the client when the resource is
     * created.
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

    /** [Output Only] Type of resource. Always compute#license for licenses. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#license for licenses. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /**
     * [Output Only] The unique code used to attach this license to images, snapshots, and disks.
     */
    public String getLicenseCode() {
      return licenseCode;
    }

    /**
     * [Output Only] The unique code used to attach this license to images, snapshots, and disks.
     */
    public Builder setLicenseCode(String licenseCode) {
      this.licenseCode = licenseCode;
      return this;
    }

    /** Name of the resource. The name must be 1-63 characters long and comply with RFC1035. */
    public String getName() {
      return name;
    }

    /** Name of the resource. The name must be 1-63 characters long and comply with RFC1035. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public LicenseResourceRequirements getResourceRequirements() {
      return resourceRequirements;
    }

    public Builder setResourceRequirements(LicenseResourceRequirements resourceRequirements) {
      this.resourceRequirements = resourceRequirements;
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
     * If false, licenses will not be copied from the source resource when creating an image from a
     * disk, disk from snapshot, or snapshot from disk.
     */
    public Boolean getTransferable() {
      return transferable;
    }

    /**
     * If false, licenses will not be copied from the source resource when creating an image from a
     * disk, disk from snapshot, or snapshot from disk.
     */
    public Builder setTransferable(Boolean transferable) {
      this.transferable = transferable;
      return this;
    }

    public License build() {

      return new License(
          chargesUseFee,
          creationTimestamp,
          description,
          id,
          kind,
          licenseCode,
          name,
          resourceRequirements,
          selfLink,
          transferable);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setChargesUseFee(this.chargesUseFee);
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.setLicenseCode(this.licenseCode);
      newBuilder.setName(this.name);
      newBuilder.setResourceRequirements(this.resourceRequirements);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setTransferable(this.transferable);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "License{"
        + "chargesUseFee="
        + chargesUseFee
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
        + "licenseCode="
        + licenseCode
        + ", "
        + "name="
        + name
        + ", "
        + "resourceRequirements="
        + resourceRequirements
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "transferable="
        + transferable
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof License) {
      License that = (License) o;
      return Objects.equals(this.chargesUseFee, that.getChargesUseFee())
          && Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.licenseCode, that.getLicenseCode())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.resourceRequirements, that.getResourceRequirements())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.transferable, that.getTransferable());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        chargesUseFee,
        creationTimestamp,
        description,
        id,
        kind,
        licenseCode,
        name,
        resourceRequirements,
        selfLink,
        transferable);
  }
}
