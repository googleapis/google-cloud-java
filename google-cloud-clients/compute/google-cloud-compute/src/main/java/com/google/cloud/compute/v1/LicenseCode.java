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
public final class LicenseCode implements ApiMessage {
  private final String creationTimestamp;
  private final String description;
  private final String id;
  private final String kind;
  private final List<LicenseCodeLicenseAlias> licenseAlias;
  private final String name;
  private final String selfLink;
  private final String state;
  private final Boolean transferable;

  private LicenseCode() {
    this.creationTimestamp = null;
    this.description = null;
    this.id = null;
    this.kind = null;
    this.licenseAlias = null;
    this.name = null;
    this.selfLink = null;
    this.state = null;
    this.transferable = null;
  }

  private LicenseCode(
      String creationTimestamp,
      String description,
      String id,
      String kind,
      List<LicenseCodeLicenseAlias> licenseAlias,
      String name,
      String selfLink,
      String state,
      Boolean transferable) {
    this.creationTimestamp = creationTimestamp;
    this.description = description;
    this.id = id;
    this.kind = kind;
    this.licenseAlias = licenseAlias;
    this.name = name;
    this.selfLink = selfLink;
    this.state = state;
    this.transferable = transferable;
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
    if ("licenseAlias".equals(fieldName)) {
      return licenseAlias;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("selfLink".equals(fieldName)) {
      return selfLink;
    }
    if ("state".equals(fieldName)) {
      return state;
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

  /** [Output Only] Creation timestamp in RFC3339 text format. */
  public String getCreationTimestamp() {
    return creationTimestamp;
  }

  /** [Output Only] Description of this License Code. */
  public String getDescription() {
    return description;
  }

  /**
   * [Output Only] The unique identifier for the resource. This identifier is defined by the server.
   */
  public String getId() {
    return id;
  }

  /** [Output Only] Type of resource. Always compute#licenseCode for licenses. */
  public String getKind() {
    return kind;
  }

  /** [Output Only] URL and description aliases of Licenses with the same License Code. */
  public List<LicenseCodeLicenseAlias> getLicenseAliasList() {
    return licenseAlias;
  }

  /**
   * [Output Only] Name of the resource. The name is 1-20 characters long and must be a valid 64 bit
   * integer.
   */
  public String getName() {
    return name;
  }

  /** [Output Only] Server-defined URL for the resource. */
  public String getSelfLink() {
    return selfLink;
  }

  /** [Output Only] Current state of this License Code. */
  public String getState() {
    return state;
  }

  /**
   * [Output Only] If true, the license will remain attached when creating images or snapshots from
   * disks. Otherwise, the license is not transferred.
   */
  public Boolean getTransferable() {
    return transferable;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(LicenseCode prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static LicenseCode getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final LicenseCode DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new LicenseCode();
  }

  public static class Builder {
    private String creationTimestamp;
    private String description;
    private String id;
    private String kind;
    private List<LicenseCodeLicenseAlias> licenseAlias;
    private String name;
    private String selfLink;
    private String state;
    private Boolean transferable;

    Builder() {}

    public Builder mergeFrom(LicenseCode other) {
      if (other == LicenseCode.getDefaultInstance()) return this;
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
      if (other.getLicenseAliasList() != null) {
        this.licenseAlias = other.licenseAlias;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getSelfLink() != null) {
        this.selfLink = other.selfLink;
      }
      if (other.getState() != null) {
        this.state = other.state;
      }
      if (other.getTransferable() != null) {
        this.transferable = other.transferable;
      }
      return this;
    }

    Builder(LicenseCode source) {
      this.creationTimestamp = source.creationTimestamp;
      this.description = source.description;
      this.id = source.id;
      this.kind = source.kind;
      this.licenseAlias = source.licenseAlias;
      this.name = source.name;
      this.selfLink = source.selfLink;
      this.state = source.state;
      this.transferable = source.transferable;
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

    /** [Output Only] Description of this License Code. */
    public String getDescription() {
      return description;
    }

    /** [Output Only] Description of this License Code. */
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

    /** [Output Only] Type of resource. Always compute#licenseCode for licenses. */
    public String getKind() {
      return kind;
    }

    /** [Output Only] Type of resource. Always compute#licenseCode for licenses. */
    public Builder setKind(String kind) {
      this.kind = kind;
      return this;
    }

    /** [Output Only] URL and description aliases of Licenses with the same License Code. */
    public List<LicenseCodeLicenseAlias> getLicenseAliasList() {
      return licenseAlias;
    }

    /** [Output Only] URL and description aliases of Licenses with the same License Code. */
    public Builder addAllLicenseAlias(List<LicenseCodeLicenseAlias> licenseAlias) {
      if (this.licenseAlias == null) {
        this.licenseAlias = new LinkedList<>();
      }
      this.licenseAlias.addAll(licenseAlias);
      return this;
    }

    /** [Output Only] URL and description aliases of Licenses with the same License Code. */
    public Builder addLicenseAlias(LicenseCodeLicenseAlias licenseAlias) {
      if (this.licenseAlias == null) {
        this.licenseAlias = new LinkedList<>();
      }
      this.licenseAlias.add(licenseAlias);
      return this;
    }

    /**
     * [Output Only] Name of the resource. The name is 1-20 characters long and must be a valid 64
     * bit integer.
     */
    public String getName() {
      return name;
    }

    /**
     * [Output Only] Name of the resource. The name is 1-20 characters long and must be a valid 64
     * bit integer.
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

    /** [Output Only] Current state of this License Code. */
    public String getState() {
      return state;
    }

    /** [Output Only] Current state of this License Code. */
    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    /**
     * [Output Only] If true, the license will remain attached when creating images or snapshots
     * from disks. Otherwise, the license is not transferred.
     */
    public Boolean getTransferable() {
      return transferable;
    }

    /**
     * [Output Only] If true, the license will remain attached when creating images or snapshots
     * from disks. Otherwise, the license is not transferred.
     */
    public Builder setTransferable(Boolean transferable) {
      this.transferable = transferable;
      return this;
    }

    public LicenseCode build() {

      return new LicenseCode(
          creationTimestamp,
          description,
          id,
          kind,
          licenseAlias,
          name,
          selfLink,
          state,
          transferable);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setCreationTimestamp(this.creationTimestamp);
      newBuilder.setDescription(this.description);
      newBuilder.setId(this.id);
      newBuilder.setKind(this.kind);
      newBuilder.addAllLicenseAlias(this.licenseAlias);
      newBuilder.setName(this.name);
      newBuilder.setSelfLink(this.selfLink);
      newBuilder.setState(this.state);
      newBuilder.setTransferable(this.transferable);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "LicenseCode{"
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
        + "licenseAlias="
        + licenseAlias
        + ", "
        + "name="
        + name
        + ", "
        + "selfLink="
        + selfLink
        + ", "
        + "state="
        + state
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
    if (o instanceof LicenseCode) {
      LicenseCode that = (LicenseCode) o;
      return Objects.equals(this.creationTimestamp, that.getCreationTimestamp())
          && Objects.equals(this.description, that.getDescription())
          && Objects.equals(this.id, that.getId())
          && Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.licenseAlias, that.getLicenseAliasList())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.selfLink, that.getSelfLink())
          && Objects.equals(this.state, that.getState())
          && Objects.equals(this.transferable, that.getTransferable());
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
        licenseAlias,
        name,
        selfLink,
        state,
        transferable);
  }
}
