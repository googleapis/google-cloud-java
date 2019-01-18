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
  public List<String> getFieldMask() {
    return null;
  }

  public Boolean getChargesUseFee() {
    return chargesUseFee;
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

  public String getLicenseCode() {
    return licenseCode;
  }

  public String getName() {
    return name;
  }

  public LicenseResourceRequirements getResourceRequirements() {
    return resourceRequirements;
  }

  public String getSelfLink() {
    return selfLink;
  }

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

    public Boolean getChargesUseFee() {
      return chargesUseFee;
    }

    public Builder setChargesUseFee(Boolean chargesUseFee) {
      this.chargesUseFee = chargesUseFee;
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

    public String getLicenseCode() {
      return licenseCode;
    }

    public Builder setLicenseCode(String licenseCode) {
      this.licenseCode = licenseCode;
      return this;
    }

    public String getName() {
      return name;
    }

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

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public Boolean getTransferable() {
      return transferable;
    }

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
