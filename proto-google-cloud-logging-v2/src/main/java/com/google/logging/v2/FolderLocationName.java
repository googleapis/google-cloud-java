/*
 * Copyright 2024 Google LLC
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

package com.google.logging.v2;

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
public class FolderLocationName implements ResourceName {
  private static final PathTemplate FOLDER_LOCATION =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/locations/{location}");
  private volatile Map<String, String> fieldValuesMap;
  private final String folder;
  private final String location;

  @Deprecated
  protected FolderLocationName() {
    folder = null;
    location = null;
  }

  private FolderLocationName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
  }

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
        FOLDER_LOCATION.validatedMatch(
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
    List<String> list = new ArrayList<>(values.size());
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
    return FOLDER_LOCATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
    return FOLDER_LOCATION.instantiate("folder", folder, "location", location);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      FolderLocationName that = ((FolderLocationName) o);
      return Objects.equals(this.folder, that.folder)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for folders/{folder}/locations/{location}. */
  public static class Builder {
    private String folder;
    private String location;

    protected Builder() {}

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

    private Builder(FolderLocationName folderLocationName) {
      this.folder = folderLocationName.folder;
      this.location = folderLocationName.location;
    }

    public FolderLocationName build() {
      return new FolderLocationName(this);
    }
  }
}
