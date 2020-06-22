/*
 * Copyright 2020 Google LLC
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

package com.google.logging.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class FolderLocationName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/locations/{location}");

  private volatile Map<String, String> fieldValuesMap;

  private final String folder;
  private final String location;

  public String getFolder() {
    return folder;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private FolderLocationName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
  }

  public static FolderLocationName of(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build();
  }

  public static String format(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  public static FolderLocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "FolderLocationName.parse: formattedString not in valid format");
    return of(matchMap.get("folder"), matchMap.get("location"));
  }

  public static List<FolderLocationName> parseList(List<String> formattedStrings) {
    List<FolderLocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FolderLocationName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (FolderLocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("folder", folder);
          fieldMapBuilder.put("location", location);
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
    return PATH_TEMPLATE.instantiate("folder", folder, "location", location);
  }

  /** Builder for FolderLocationName. */
  public static class Builder {

    private String folder;
    private String location;

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder() {}

    private Builder(FolderLocationName folderLocationName) {
      folder = folderLocationName.folder;
      location = folderLocationName.location;
    }

    public FolderLocationName build() {
      return new FolderLocationName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FolderLocationName) {
      FolderLocationName that = (FolderLocationName) o;
      return (this.folder.equals(that.folder)) && (this.location.equals(that.location));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= folder.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    return h;
  }
}
