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

package com.google.monitoring.v3;

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
public class SnoozeName implements ResourceName {
  private static final PathTemplate PROJECT_SNOOZE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/snoozes/{snooze}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String snooze;

  @Deprecated
  protected SnoozeName() {
    project = null;
    snooze = null;
  }

  private SnoozeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    snooze = Preconditions.checkNotNull(builder.getSnooze());
  }

  public String getProject() {
    return project;
  }

  public String getSnooze() {
    return snooze;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SnoozeName of(String project, String snooze) {
    return newBuilder().setProject(project).setSnooze(snooze).build();
  }

  public static String format(String project, String snooze) {
    return newBuilder().setProject(project).setSnooze(snooze).build().toString();
  }

  public static SnoozeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_SNOOZE.validatedMatch(
            formattedString, "SnoozeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("snooze"));
  }

  public static List<SnoozeName> parseList(List<String> formattedStrings) {
    List<SnoozeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SnoozeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SnoozeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SNOOZE.matches(formattedString);
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
          if (snooze != null) {
            fieldMapBuilder.put("snooze", snooze);
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
    return PROJECT_SNOOZE.instantiate("project", project, "snooze", snooze);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SnoozeName that = ((SnoozeName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.snooze, that.snooze);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(snooze);
    return h;
  }

  /** Builder for projects/{project}/snoozes/{snooze}. */
  public static class Builder {
    private String project;
    private String snooze;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSnooze() {
      return snooze;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSnooze(String snooze) {
      this.snooze = snooze;
      return this;
    }

    private Builder(SnoozeName snoozeName) {
      this.project = snoozeName.project;
      this.snooze = snoozeName.snooze;
    }

    public SnoozeName build() {
      return new SnoozeName(this);
    }
  }
}
