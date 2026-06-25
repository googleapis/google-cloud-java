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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class IntelligenceFindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INTELLIGENCE_FINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/intelligenceFindings/{intelligence_finding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String intelligenceFinding;

  @Deprecated
  protected IntelligenceFindingName() {
    project = null;
    location = null;
    intelligenceFinding = null;
  }

  private IntelligenceFindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    intelligenceFinding = Preconditions.checkNotNull(builder.getIntelligenceFinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getIntelligenceFinding() {
    return intelligenceFinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IntelligenceFindingName of(
      String project, String location, String intelligenceFinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setIntelligenceFinding(intelligenceFinding)
        .build();
  }

  public static String format(String project, String location, String intelligenceFinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setIntelligenceFinding(intelligenceFinding)
        .build()
        .toString();
  }

  public static IntelligenceFindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INTELLIGENCE_FINDING.validatedMatch(
            formattedString, "IntelligenceFindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("intelligence_finding"));
  }

  public static List<IntelligenceFindingName> parseList(List<String> formattedStrings) {
    List<IntelligenceFindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IntelligenceFindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IntelligenceFindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INTELLIGENCE_FINDING.matches(formattedString);
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
          if (intelligenceFinding != null) {
            fieldMapBuilder.put("intelligence_finding", intelligenceFinding);
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
    return PROJECT_LOCATION_INTELLIGENCE_FINDING.instantiate(
        "project", project, "location", location, "intelligence_finding", intelligenceFinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      IntelligenceFindingName that = ((IntelligenceFindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.intelligenceFinding, that.intelligenceFinding);
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
    h ^= Objects.hashCode(intelligenceFinding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/intelligenceFindings/{intelligence_finding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String intelligenceFinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getIntelligenceFinding() {
      return intelligenceFinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setIntelligenceFinding(String intelligenceFinding) {
      this.intelligenceFinding = intelligenceFinding;
      return this;
    }

    private Builder(IntelligenceFindingName intelligenceFindingName) {
      this.project = intelligenceFindingName.project;
      this.location = intelligenceFindingName.location;
      this.intelligenceFinding = intelligenceFindingName.intelligenceFinding;
    }

    public IntelligenceFindingName build() {
      return new IntelligenceFindingName(this);
    }
  }
}
