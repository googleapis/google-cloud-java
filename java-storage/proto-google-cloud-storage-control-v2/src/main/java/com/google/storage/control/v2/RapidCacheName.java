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

package com.google.storage.control.v2;

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
public class RapidCacheName implements ResourceName {
  private static final PathTemplate PROJECT_BUCKET_RAPID_CACHE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/buckets/{bucket}/rapidCaches/{rapid_cache}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String bucket;
  private final String rapidCache;

  @Deprecated
  protected RapidCacheName() {
    project = null;
    bucket = null;
    rapidCache = null;
  }

  private RapidCacheName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    rapidCache = Preconditions.checkNotNull(builder.getRapidCache());
  }

  public String getProject() {
    return project;
  }

  public String getBucket() {
    return bucket;
  }

  public String getRapidCache() {
    return rapidCache;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RapidCacheName of(String project, String bucket, String rapidCache) {
    return newBuilder().setProject(project).setBucket(bucket).setRapidCache(rapidCache).build();
  }

  public static String format(String project, String bucket, String rapidCache) {
    return newBuilder()
        .setProject(project)
        .setBucket(bucket)
        .setRapidCache(rapidCache)
        .build()
        .toString();
  }

  public static @Nullable RapidCacheName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_BUCKET_RAPID_CACHE.validatedMatch(
            formattedString, "RapidCacheName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("bucket"), matchMap.get("rapid_cache"));
  }

  public static List<RapidCacheName> parseList(List<String> formattedStrings) {
    List<RapidCacheName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable RapidCacheName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RapidCacheName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_BUCKET_RAPID_CACHE.matches(formattedString);
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
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (rapidCache != null) {
            fieldMapBuilder.put("rapid_cache", rapidCache);
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
    return PROJECT_BUCKET_RAPID_CACHE.instantiate(
        "project", project, "bucket", bucket, "rapid_cache", rapidCache);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RapidCacheName that = ((RapidCacheName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.rapidCache, that.rapidCache);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(rapidCache);
    return h;
  }

  /** Builder for projects/{project}/buckets/{bucket}/rapidCaches/{rapid_cache}. */
  public static class Builder {
    private String project;
    private String bucket;
    private String rapidCache;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getBucket() {
      return bucket;
    }

    public String getRapidCache() {
      return rapidCache;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder setRapidCache(String rapidCache) {
      this.rapidCache = rapidCache;
      return this;
    }

    private Builder(RapidCacheName rapidCacheName) {
      this.project = rapidCacheName.project;
      this.bucket = rapidCacheName.bucket;
      this.rapidCache = rapidCacheName.rapidCache;
    }

    public RapidCacheName build() {
      return new RapidCacheName(this);
    }
  }
}
