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
  public Map<String, List<String>> populateFieldsInMap(Set<String> fieldNames) {
    Map<String, List<String>> fieldMap = new HashMap<>();
    if (fieldNames.contains("creationTimestamp") && creationTimestamp != null) {
      fieldMap.put(
          "creationTimestamp", Collections.singletonList(String.valueOf(creationTimestamp)));
    }
    if (fieldNames.contains("customFeatures") && customFeatures != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : customFeatures) {
        stringList.add(item.toString());
      }
      fieldMap.put("customFeatures", stringList.build());
    }
    if (fieldNames.contains("description") && description != null) {
      fieldMap.put("description", Collections.singletonList(String.valueOf(description)));
    }
    if (fieldNames.contains("enabledFeatures") && enabledFeatures != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (String item : enabledFeatures) {
        stringList.add(item.toString());
      }
      fieldMap.put("enabledFeatures", stringList.build());
    }
    if (fieldNames.contains("fingerprint") && fingerprint != null) {
      fieldMap.put("fingerprint", Collections.singletonList(String.valueOf(fingerprint)));
    }
    if (fieldNames.contains("id") && id != null) {
      fieldMap.put("id", Collections.singletonList(String.valueOf(id)));
    }
    if (fieldNames.contains("kind") && kind != null) {
      fieldMap.put("kind", Collections.singletonList(String.valueOf(kind)));
    }
    if (fieldNames.contains("minTlsVersion") && minTlsVersion != null) {
      fieldMap.put("minTlsVersion", Collections.singletonList(String.valueOf(minTlsVersion)));
    }
    if (fieldNames.contains("name") && name != null) {
      fieldMap.put("name", Collections.singletonList(String.valueOf(name)));
    }
    if (fieldNames.contains("profile") && profile != null) {
      fieldMap.put("profile", Collections.singletonList(String.valueOf(profile)));
    }
    if (fieldNames.contains("selfLink") && selfLink != null) {
      fieldMap.put("selfLink", Collections.singletonList(String.valueOf(selfLink)));
    }
    if (fieldNames.contains("warnings") && warnings != null) {
      ImmutableList.Builder stringList = ImmutableList.builder();
      for (Warnings item : warnings) {
        stringList.add(item.toString());
      }
      fieldMap.put("warnings", stringList.build());
    }
    return fieldMap;
  }

  @Override
  public String getFieldStringValue(String fieldName) {
    if (fieldName.equals("creationTimestamp")) {
      return String.valueOf(creationTimestamp);
    }
    if (fieldName.equals("customFeatures")) {
      return String.valueOf(customFeatures);
    }
    if (fieldName.equals("description")) {
      return String.valueOf(description);
    }
    if (fieldName.equals("enabledFeatures")) {
      return String.valueOf(enabledFeatures);
    }
    if (fieldName.equals("fingerprint")) {
      return String.valueOf(fingerprint);
    }
    if (fieldName.equals("id")) {
      return String.valueOf(id);
    }
    if (fieldName.equals("kind")) {
      return String.valueOf(kind);
    }
    if (fieldName.equals("minTlsVersion")) {
      return String.valueOf(minTlsVersion);
    }
    if (fieldName.equals("name")) {
      return String.valueOf(name);
    }
    if (fieldName.equals("profile")) {
      return String.valueOf(profile);
    }
    if (fieldName.equals("selfLink")) {
      return String.valueOf(selfLink);
    }
    if (fieldName.equals("warnings")) {
      return String.valueOf(warnings);
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

  public List<String> getCustomFeaturesList() {
    return customFeatures;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getEnabledFeaturesList() {
    return enabledFeatures;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public String getId() {
    return id;
  }

  public String getKind() {
    return kind;
  }

  public String getMinTlsVersion() {
    return minTlsVersion;
  }

  public String getName() {
    return name;
  }

  public String getProfile() {
    return profile;
  }

  public String getSelfLink() {
    return selfLink;
  }

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

    public String getCreationTimestamp() {
      return creationTimestamp;
    }

    public Builder setCreationTimestamp(String creationTimestamp) {
      this.creationTimestamp = creationTimestamp;
      return this;
    }

    public List<String> getCustomFeaturesList() {
      return customFeatures;
    }

    public Builder addAllCustomFeatures(List<String> customFeatures) {
      if (this.customFeatures == null) {
        this.customFeatures = new ArrayList<>(customFeatures.size());
      }
      this.customFeatures.addAll(customFeatures);
      return this;
    }

    public Builder addCustomFeatures(String customFeatures) {
      this.customFeatures.add(customFeatures);
      return this;
    }

    public String getDescription() {
      return description;
    }

    public Builder setDescription(String description) {
      this.description = description;
      return this;
    }

    public List<String> getEnabledFeaturesList() {
      return enabledFeatures;
    }

    public Builder addAllEnabledFeatures(List<String> enabledFeatures) {
      if (this.enabledFeatures == null) {
        this.enabledFeatures = new ArrayList<>(enabledFeatures.size());
      }
      this.enabledFeatures.addAll(enabledFeatures);
      return this;
    }

    public Builder addEnabledFeatures(String enabledFeatures) {
      this.enabledFeatures.add(enabledFeatures);
      return this;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
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

    public String getMinTlsVersion() {
      return minTlsVersion;
    }

    public Builder setMinTlsVersion(String minTlsVersion) {
      this.minTlsVersion = minTlsVersion;
      return this;
    }

    public String getName() {
      return name;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public String getProfile() {
      return profile;
    }

    public Builder setProfile(String profile) {
      this.profile = profile;
      return this;
    }

    public String getSelfLink() {
      return selfLink;
    }

    public Builder setSelfLink(String selfLink) {
      this.selfLink = selfLink;
      return this;
    }

    public List<Warnings> getWarningsList() {
      return warnings;
    }

    public Builder addAllWarnings(List<Warnings> warnings) {
      if (this.warnings == null) {
        this.warnings = new ArrayList<>(warnings.size());
      }
      this.warnings.addAll(warnings);
      return this;
    }

    public Builder addWarnings(Warnings warnings) {
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
