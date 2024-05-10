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

package com.google.cloud.kms.v1;

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
public class AutokeyConfigName implements ResourceName {
  private static final PathTemplate FOLDER =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/autokeyConfig");
  private volatile Map<String, String> fieldValuesMap;
  private final String folder;

  @Deprecated
  protected AutokeyConfigName() {
    folder = null;
  }

  private AutokeyConfigName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutokeyConfigName of(String folder) {
    return newBuilder().setFolder(folder).build();
  }

  public static String format(String folder) {
    return newBuilder().setFolder(folder).build().toString();
  }

  public static AutokeyConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        FOLDER.validatedMatch(
            formattedString, "AutokeyConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("folder"));
  }

  public static List<AutokeyConfigName> parseList(List<String> formattedStrings) {
    List<AutokeyConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutokeyConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutokeyConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return FOLDER.matches(formattedString);
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
    return FOLDER.instantiate("folder", folder);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutokeyConfigName that = ((AutokeyConfigName) o);
      return Objects.equals(this.folder, that.folder);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for folders/{folder}/autokeyConfig. */
  public static class Builder {
    private String folder;

    protected Builder() {}

    public String getFolder() {
      return folder;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    private Builder(AutokeyConfigName autokeyConfigName) {
      this.folder = autokeyConfigName.folder;
    }

    public AutokeyConfigName build() {
      return new AutokeyConfigName(this);
    }
  }
}
