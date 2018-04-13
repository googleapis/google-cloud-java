/*
 * Copyright 2018 Google LLC
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
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put(
          "creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("licenseAlias") && licenseAlias != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (LicenseCodeLicenseAlias item : licenseAlias) {
        stringList.add(item.toString());
      }
      fieldMap.put("licenseAlias", stringList.build());
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("state") && state != null) {
      fieldMap.put("state", Collections.singletonList(String.valueOf(state)));
    }
    if (fieldNames.contains("transferable") && transferable != null) {
      fieldMap.put("transferable", Collections.singletonList(String.valueOf(transferable)));
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("licenseAlias")) {
      return String.valueOf(licenseAlias);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("state")) {
      return String.valueOf(state);
    }
    if (fieldName.equals("transferable")) {
      return String.valueOf(transferable);
    }
    return null;
  }

  @Nullable
  @Override
  public ApiMessage getApiMessageRequestBody() {
    return null;
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

  public List<LicenseCodeLicenseAlias> getLicenseAliasList() {
    return licenseAlias;
  }

  public String getName() {
    return name;
  }

  public String getSelfLink() {
    return selfLink;
  }

  public String getState() {
    return state;
  }

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

    public List<LicenseCodeLicenseAlias> getLicenseAliasList() {
      return licenseAlias;
    }

    public Builder addAllLicenseAlias(List<LicenseCodeLicenseAlias> licenseAlias) {
      if (this.licenseAlias == null) {
        this.licenseAlias = new ArrayList<>(licenseAlias.size());
      }
      this.licenseAlias.addAll(licenseAlias);
      return this;
    }

    public Builder addLicenseAlias(LicenseCodeLicenseAlias licenseAlias) {
      this.licenseAlias.add(licenseAlias);
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public String getState() {
      return state;
    }

    public Builder setState(String state) {
      this.state = state;
      return this;
    }

    public Boolean getTransferable() {
      return transferable;
    }

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
