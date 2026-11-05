/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.observability.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class LinkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_BUCKET_DATASET_LINK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/buckets/{bucket}/datasets/{dataset}/links/{link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String bucket;
  private final String dataset;
  private final String link;

  @Deprecated
  protected LinkName() {
    project = null;
    location = null;
    bucket = null;
    dataset = null;
    link = null;
  }

  private LinkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    dataset = Preconditions.checkNotNull(builder.getDataset());
    link = Preconditions.checkNotNull(builder.getLink());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getBucket() {
    return bucket;
  }

  public String getDataset() {
    return dataset;
  }

  public String getLink() {
    return link;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LinkName of(
      String project, String location, String bucket, String dataset, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setDataset(dataset)
        .setLink(link)
        .build();
  }

  public static String format(
      String project, String location, String bucket, String dataset, String link) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setBucket(bucket)
        .setDataset(dataset)
        .setLink(link)
        .build()
        .toString();
  }

  public static @Nullable LinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_BUCKET_DATASET_LINK.validatedMatch(
            formattedString, "LinkName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("bucket"),
        matchMap.get("dataset"),
        matchMap.get("link"));
  }

  public static List<LinkName> parseList(List<String> formattedStrings) {
    List<LinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable LinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_BUCKET_DATASET_LINK.matches(formattedString);
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
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (dataset != null) {
            fieldMapBuilder.put("dataset", dataset);
          }
          if (link != null) {
            fieldMapBuilder.put("link", link);
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
    return PROJECT_LOCATION_BUCKET_DATASET_LINK.instantiate(
        "project",
        project,
        "location",
        location,
        "bucket",
        bucket,
        "dataset",
        dataset,
        "link",
        link);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LinkName that = ((LinkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.dataset, that.dataset)
          && Objects.equals(this.link, that.link);
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
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(dataset);
    h *= 1000003;
    h ^= Objects.hashCode(link);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/buckets/{bucket}/datasets/{dataset}/links/{link}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String bucket;
    private String dataset;
    private String link;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getBucket() {
      return bucket;
    }

    public String getDataset() {
      return dataset;
    }

    public String getLink() {
      return link;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder setDataset(String dataset) {
      this.dataset = dataset;
      return this;
    }

    public Builder setLink(String link) {
      this.link = link;
      return this;
    }

    private Builder(LinkName linkName) {
      this.project = linkName.project;
      this.location = linkName.location;
      this.bucket = linkName.bucket;
      this.dataset = linkName.dataset;
      this.link = linkName.link;
    }

    public LinkName build() {
      return new LinkName(this);
    }
  }
}
