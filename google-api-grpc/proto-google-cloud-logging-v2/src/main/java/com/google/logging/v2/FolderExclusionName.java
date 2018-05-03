/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.logging.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameType;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class FolderExclusionName extends ExclusionName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/exclusions/{exclusion}");

  private volatile Map<String, String> fieldValuesMap;

  private final String folder;
  private final String exclusion;

  public String getFolder() {
    return folder;
  }

  public String getExclusion() {
    return exclusion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private FolderExclusionName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
  }

  public static FolderExclusionName of(String folder, String exclusion) {
    return newBuilder()
      .setFolder(folder)
      .setExclusion(exclusion)
      .build();
  }

  public static String format(String folder, String exclusion) {
    return newBuilder()
      .setFolder(folder)
      .setExclusion(exclusion)
      .build()
      .toString();
  }

  public static FolderExclusionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "FolderExclusionName.parse: formattedString not in valid format");
    return of(matchMap.get("folder"), matchMap.get("exclusion"));
  }

  public static List<FolderExclusionName> parseList(List<String> formattedStrings) {
    List<FolderExclusionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FolderExclusionName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (FolderExclusionName value : values) {
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
          fieldMapBuilder.put("exclusion", exclusion);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  /**
   * @deprecated This method is only present to satisfy the ResourceName interface.
   */
  @Deprecated
  public ResourceNameType getType() {
    throw new UnsupportedOperationException("FolderExclusionName.getType() not supported");
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate("folder", folder, "exclusion", exclusion);
  }

  /** Builder for FolderExclusionName. */
  public static class Builder {

    private String folder;
    private String exclusion;

    public String getFolder() {
      return folder;
    }

    public String getExclusion() {
      return exclusion;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public Builder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    private Builder() {
    }

    private Builder(FolderExclusionName folderExclusionName) {
      folder = folderExclusionName.folder;
      exclusion = folderExclusionName.exclusion;
    }

    public FolderExclusionName build() {
      return new FolderExclusionName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FolderExclusionName) {
      FolderExclusionName that = (FolderExclusionName) o;
      return (this.folder.equals(that.folder))
          && (this.exclusion.equals(that.exclusion));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= folder.hashCode();
    h *= 1000003;
    h ^= exclusion.hashCode();
    return h;
  }
}

