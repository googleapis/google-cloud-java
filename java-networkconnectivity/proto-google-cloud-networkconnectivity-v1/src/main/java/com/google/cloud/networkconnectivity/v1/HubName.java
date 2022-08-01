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

package com.google.cloud.networkconnectivity.v1;

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
public class HubName implements ResourceName {
  private static final PathTemplate PROJECT_HUB =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/global/hubs/{hub}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String hub;

  @Deprecated
  protected HubName() {
    project = null;
    hub = null;
  }

  private HubName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    hub = Preconditions.checkNotNull(builder.getHub());
  }

  public String getProject() {
    return project;
  }

  public String getHub() {
    return hub;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static HubName of(String project, String hub) {
    return newBuilder().setProject(project).setHub(hub).build();
  }

  public static String format(String project, String hub) {
    return newBuilder().setProject(project).setHub(hub).build().toString();
  }

  public static HubName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_HUB.validatedMatch(
            formattedString, "HubName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("hub"));
  }

  public static List<HubName> parseList(List<String> formattedStrings) {
    List<HubName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<HubName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (HubName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_HUB.matches(formattedString);
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
          if (hub != null) {
            fieldMapBuilder.put("hub", hub);
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
    return PROJECT_HUB.instantiate("project", project, "hub", hub);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      HubName that = ((HubName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.hub, that.hub);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(hub);
    return h;
  }

  /** Builder for projects/{project}/locations/global/hubs/{hub}. */
  public static class Builder {
    private String project;
    private String hub;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getHub() {
      return hub;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setHub(String hub) {
      this.hub = hub;
      return this;
    }

    private Builder(HubName hubName) {
      this.project = hubName.project;
      this.hub = hubName.hub;
    }

    public HubName build() {
      return new HubName(this);
    }
  }
}
