/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.chronicle.v1;

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
public class WatchlistName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSTANCE_WATCHLIST =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String instance;
  private final String watchlist;

  @Deprecated
  protected WatchlistName() {
    project = null;
    location = null;
    instance = null;
    watchlist = null;
  }

  private WatchlistName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    watchlist = Preconditions.checkNotNull(builder.getWatchlist());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInstance() {
    return instance;
  }

  public String getWatchlist() {
    return watchlist;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WatchlistName of(
      String project, String location, String instance, String watchlist) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setWatchlist(watchlist)
        .build();
  }

  public static String format(String project, String location, String instance, String watchlist) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setWatchlist(watchlist)
        .build()
        .toString();
  }

  public static WatchlistName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSTANCE_WATCHLIST.validatedMatch(
            formattedString, "WatchlistName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("watchlist"));
  }

  public static List<WatchlistName> parseList(List<String> formattedStrings) {
    List<WatchlistName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WatchlistName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WatchlistName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSTANCE_WATCHLIST.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (watchlist != null) {
            fieldMapBuilder.put("watchlist", watchlist);
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
    return PROJECT_LOCATION_INSTANCE_WATCHLIST.instantiate(
        "project", project, "location", location, "instance", instance, "watchlist", watchlist);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      WatchlistName that = ((WatchlistName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.watchlist, that.watchlist);
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
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(watchlist);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/instances/{instance}/watchlists/{watchlist}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String instance;
    private String watchlist;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInstance() {
      return instance;
    }

    public String getWatchlist() {
      return watchlist;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setWatchlist(String watchlist) {
      this.watchlist = watchlist;
      return this;
    }

    private Builder(WatchlistName watchlistName) {
      this.project = watchlistName.project;
      this.location = watchlistName.location;
      this.instance = watchlistName.instance;
      this.watchlist = watchlistName.watchlist;
    }

    public WatchlistName build() {
      return new WatchlistName(this);
    }
  }
}
