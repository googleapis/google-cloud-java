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
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class FolderSinkName extends SinkName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/sinks/{sink}");

  private volatile Map<String, String> fieldValuesMap;

  private final String folder;
  private final String sink;

  public String getFolder() {
    return folder;
  }

  public String getSink() {
    return sink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private FolderSinkName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    sink = Preconditions.checkNotNull(builder.getSink());
  }

  public static FolderSinkName of(String folder, String sink) {
    return newBuilder()
      .setFolder(folder)
      .setSink(sink)
      .build();
  }

  public static String format(String folder, String sink) {
    return newBuilder()
      .setFolder(folder)
      .setSink(sink)
      .build()
      .toString();
  }

  public static FolderSinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "FolderSinkName.parse: formattedString not in valid format");
    return of(matchMap.get("folder"), matchMap.get("sink"));
  }

  public static List<FolderSinkName> parseList(List<String> formattedStrings) {
    List<FolderSinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FolderSinkName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (FolderSinkName value : values) {
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
          fieldMapBuilder.put("sink", sink);
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
    return PATH_TEMPLATE.instantiate("folder", folder, "sink", sink);
  }

  /** Builder for FolderSinkName. */
  public static class Builder {

    private String folder;
    private String sink;

    public String getFolder() {
      return folder;
    }

    public String getSink() {
      return sink;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public Builder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    private Builder() {
    }

    private Builder(FolderSinkName folderSinkName) {
      folder = folderSinkName.folder;
      sink = folderSinkName.sink;
    }

    public FolderSinkName build() {
      return new FolderSinkName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FolderSinkName) {
      FolderSinkName that = (FolderSinkName) o;
      return (this.folder.equals(that.folder))
          && (this.sink.equals(that.sink));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= folder.hashCode();
    h *= 1000003;
    h ^= sink.hashCode();
    return h;
  }
}

