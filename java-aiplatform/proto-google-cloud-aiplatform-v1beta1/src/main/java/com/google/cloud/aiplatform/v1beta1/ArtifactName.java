/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.aiplatform.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class ArtifactName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_METADATA_STORE_ARTIFACT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/metadataStores/{metadata_store}/artifacts/{artifact}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String metadataStore;
  private final String artifact;

  @Deprecated
  protected ArtifactName() {
    project = null;
    location = null;
    metadataStore = null;
    artifact = null;
  }

  private ArtifactName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    metadataStore = Preconditions.checkNotNull(builder.getMetadataStore());
    artifact = Preconditions.checkNotNull(builder.getArtifact());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMetadataStore() {
    return metadataStore;
  }

  public String getArtifact() {
    return artifact;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ArtifactName of(
      String project, String location, String metadataStore, String artifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .setArtifact(artifact)
        .build();
  }

  public static String format(
      String project, String location, String metadataStore, String artifact) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMetadataStore(metadataStore)
        .setArtifact(artifact)
        .build()
        .toString();
  }

  public static ArtifactName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_METADATA_STORE_ARTIFACT.validatedMatch(
            formattedString, "ArtifactName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("metadata_store"),
        matchMap.get("artifact"));
  }

  public static List<ArtifactName> parseList(List<String> formattedStrings) {
    List<ArtifactName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ArtifactName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ArtifactName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_METADATA_STORE_ARTIFACT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (metadataStore != null) {
            fieldMapBuilder.put("metadata_store", metadataStore);
          }
          if (artifact != null) {
            fieldMapBuilder.put("artifact", artifact);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return PROJECT_LOCATION_METADATA_STORE_ARTIFACT.instantiate(
        "project",
        project,
        "location",
        location,
        "metadata_store",
        metadataStore,
        "artifact",
        artifact);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ArtifactName that = ((ArtifactName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.metadataStore, that.metadataStore)
          && Objects.equals(this.artifact, that.artifact);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(metadataStore);
    h *= 1000003;
    h ^= Objects.hashCode(artifact);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/metadataStores/{metadata_store}/artifacts/{artifact}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String metadataStore;
    private String artifact;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMetadataStore() {
      return metadataStore;
    }

    public String getArtifact() {
      return artifact;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMetadataStore(String metadataStore) {
      this.metadataStore = metadataStore;
      return this;
    }

    public Builder setArtifact(String artifact) {
      this.artifact = artifact;
      return this;
    }

    private Builder(ArtifactName artifactName) {
      this.project = artifactName.project;
      this.location = artifactName.location;
      this.metadataStore = artifactName.metadataStore;
      this.artifact = artifactName.artifact;
    }

    public ArtifactName build() {
      return new ArtifactName(this);
    }
  }
}
