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

package com.google.cloud.designcenter.v1;

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
public class ShareName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SPACE_CATALOG_SHARE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/spaces/{space}/catalogs/{catalog}/shares/{share}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String space;
  private final String catalog;
  private final String share;

  @Deprecated
  protected ShareName() {
    project = null;
    location = null;
    space = null;
    catalog = null;
    share = null;
  }

  private ShareName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    space = Preconditions.checkNotNull(builder.getSpace());
    catalog = Preconditions.checkNotNull(builder.getCatalog());
    share = Preconditions.checkNotNull(builder.getShare());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSpace() {
    return space;
  }

  public String getCatalog() {
    return catalog;
  }

  public String getShare() {
    return share;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ShareName of(
      String project, String location, String space, String catalog, String share) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setCatalog(catalog)
        .setShare(share)
        .build();
  }

  public static String format(
      String project, String location, String space, String catalog, String share) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSpace(space)
        .setCatalog(catalog)
        .setShare(share)
        .build()
        .toString();
  }

  public static @Nullable ShareName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SPACE_CATALOG_SHARE.validatedMatch(
            formattedString, "ShareName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("space"),
        matchMap.get("catalog"),
        matchMap.get("share"));
  }

  public static List<ShareName> parseList(List<String> formattedStrings) {
    List<ShareName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ShareName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ShareName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SPACE_CATALOG_SHARE.matches(formattedString);
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
          if (space != null) {
            fieldMapBuilder.put("space", space);
          }
          if (catalog != null) {
            fieldMapBuilder.put("catalog", catalog);
          }
          if (share != null) {
            fieldMapBuilder.put("share", share);
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
    return PROJECT_LOCATION_SPACE_CATALOG_SHARE.instantiate(
        "project",
        project,
        "location",
        location,
        "space",
        space,
        "catalog",
        catalog,
        "share",
        share);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ShareName that = ((ShareName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.space, that.space)
          && Objects.equals(this.catalog, that.catalog)
          && Objects.equals(this.share, that.share);
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
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(catalog);
    h *= 1000003;
    h ^= Objects.hashCode(share);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/spaces/{space}/catalogs/{catalog}/shares/{share}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String space;
    private String catalog;
    private String share;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSpace() {
      return space;
    }

    public String getCatalog() {
      return catalog;
    }

    public String getShare() {
      return share;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setCatalog(String catalog) {
      this.catalog = catalog;
      return this;
    }

    public Builder setShare(String share) {
      this.share = share;
      return this;
    }

    private Builder(ShareName shareName) {
      this.project = shareName.project;
      this.location = shareName.location;
      this.space = shareName.space;
      this.catalog = shareName.catalog;
      this.share = shareName.share;
    }

    public ShareName build() {
      return new ShareName(this);
    }
  }
}
