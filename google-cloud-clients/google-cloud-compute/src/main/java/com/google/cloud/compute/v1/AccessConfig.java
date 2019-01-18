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
public final class AccessConfig implements ApiMessage {
  private final String kind;
  private final String name;
  private final String natIP;
  private final String networkTier;
  private final String publicPtrDomainName;
  private final Boolean setPublicPtr;
  private final String type;

  private AccessConfig() {
    this.kind = null;
    this.name = null;
    this.natIP = null;
    this.networkTier = null;
    this.publicPtrDomainName = null;
    this.setPublicPtr = null;
    this.type = null;
  }

  private AccessConfig(
      String kind,
      String name,
      String natIP,
      String networkTier,
      String publicPtrDomainName,
      Boolean setPublicPtr,
      String type) {
    this.kind = kind;
    this.name = name;
    this.natIP = natIP;
    this.networkTier = networkTier;
    this.publicPtrDomainName = publicPtrDomainName;
    this.setPublicPtr = setPublicPtr;
    this.type = type;
  }

  @Override
  public Object getFieldValue(String fieldName) {
    if ("kind".equals(fieldName)) {
      return kind;
    }
    if ("name".equals(fieldName)) {
      return name;
    }
    if ("natIP".equals(fieldName)) {
      return natIP;
    }
    if ("networkTier".equals(fieldName)) {
      return networkTier;
    }
    if ("publicPtrDomainName".equals(fieldName)) {
      return publicPtrDomainName;
    }
    if ("setPublicPtr".equals(fieldName)) {
      return setPublicPtr;
    }
    if ("type".equals(fieldName)) {
      return type;
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

  public String getKind() {
    return kind;
  }

  public String getName() {
    return name;
  }

  public String getNatIP() {
    return natIP;
  }

  public String getNetworkTier() {
    return networkTier;
  }

  public String getPublicPtrDomainName() {
    return publicPtrDomainName;
  }

  public Boolean getSetPublicPtr() {
    return setPublicPtr;
  }

  public String getType() {
    return type;
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(AccessConfig prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  public static AccessConfig getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final AccessConfig DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new AccessConfig();
  }

  public static class Builder {
    private String kind;
    private String name;
    private String natIP;
    private String networkTier;
    private String publicPtrDomainName;
    private Boolean setPublicPtr;
    private String type;

    Builder() {}

    public Builder mergeFrom(AccessConfig other) {
      if (other == AccessConfig.getDefaultInstance()) return this;
      if (other.getKind() != null) {
        this.kind = other.kind;
      }
      if (other.getName() != null) {
        this.name = other.name;
      }
      if (other.getNatIP() != null) {
        this.natIP = other.natIP;
      }
      if (other.getNetworkTier() != null) {
        this.networkTier = other.networkTier;
      }
      if (other.getPublicPtrDomainName() != null) {
        this.publicPtrDomainName = other.publicPtrDomainName;
      }
      if (other.getSetPublicPtr() != null) {
        this.setPublicPtr = other.setPublicPtr;
      }
      if (other.getType() != null) {
        this.type = other.type;
      }
      return this;
    }

    Builder(AccessConfig source) {
      this.kind = source.kind;
      this.name = source.name;
      this.natIP = source.natIP;
      this.networkTier = source.networkTier;
      this.publicPtrDomainName = source.publicPtrDomainName;
      this.setPublicPtr = source.setPublicPtr;
      this.type = source.type;
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

    public String getNatIP() {
      return natIP;
    }

    public Builder setNatIP(String natIP) {
      this.natIP = natIP;
      return this;
    }

    public String getNetworkTier() {
      return networkTier;
    }

    public Builder setNetworkTier(String networkTier) {
      this.networkTier = networkTier;
      return this;
    }

    public String getPublicPtrDomainName() {
      return publicPtrDomainName;
    }

    public Builder setPublicPtrDomainName(String publicPtrDomainName) {
      this.publicPtrDomainName = publicPtrDomainName;
      return this;
    }

    public Boolean getSetPublicPtr() {
      return setPublicPtr;
    }

    public Builder setSetPublicPtr(Boolean setPublicPtr) {
      this.setPublicPtr = setPublicPtr;
      return this;
    }

    public String getType() {
      return type;
    }

    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public AccessConfig build() {

      return new AccessConfig(
          kind, name, natIP, networkTier, publicPtrDomainName, setPublicPtr, type);
    }

    public Builder clone() {
      Builder newBuilder = new Builder();
      newBuilder.setKind(this.kind);
      newBuilder.setName(this.name);
      newBuilder.setNatIP(this.natIP);
      newBuilder.setNetworkTier(this.networkTier);
      newBuilder.setPublicPtrDomainName(this.publicPtrDomainName);
      newBuilder.setSetPublicPtr(this.setPublicPtr);
      newBuilder.setType(this.type);
      return newBuilder;
    }
  }

  @Override
  public String toString() {
    return "AccessConfig{"
        + "kind="
        + kind
        + ", "
        + "name="
        + name
        + ", "
        + "natIP="
        + natIP
        + ", "
        + "networkTier="
        + networkTier
        + ", "
        + "publicPtrDomainName="
        + publicPtrDomainName
        + ", "
        + "setPublicPtr="
        + setPublicPtr
        + ", "
        + "type="
        + type
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AccessConfig) {
      AccessConfig that = (AccessConfig) o;
      return Objects.equals(this.kind, that.getKind())
          && Objects.equals(this.name, that.getName())
          && Objects.equals(this.natIP, that.getNatIP())
          && Objects.equals(this.networkTier, that.getNetworkTier())
          && Objects.equals(this.publicPtrDomainName, that.getPublicPtrDomainName())
          && Objects.equals(this.setPublicPtr, that.getSetPublicPtr())
          && Objects.equals(this.type, that.getType());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, name, natIP, networkTier, publicPtrDomainName, setPublicPtr, type);
  }
}
