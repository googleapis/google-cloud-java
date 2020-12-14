/*
 * Copyright 2020 Google LLC
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

package io.grafeas.v1;

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
public class OccurrenceName implements ResourceName {
  private static final PathTemplate PROJECT_OCCURRENCE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/occurrences/{occurrence}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String occurrence;

  @Deprecated
  protected OccurrenceName() {
    project = null;
    occurrence = null;
  }

  private OccurrenceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    occurrence = Preconditions.checkNotNull(builder.getOccurrence());
  }

  public String getProject() {
    return project;
  }

  public String getOccurrence() {
    return occurrence;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OccurrenceName of(String project, String occurrence) {
    return newBuilder().setProject(project).setOccurrence(occurrence).build();
  }

  public static String format(String project, String occurrence) {
    return newBuilder().setProject(project).setOccurrence(occurrence).build().toString();
  }

  public static OccurrenceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_OCCURRENCE.validatedMatch(
            formattedString, "OccurrenceName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("occurrence"));
  }

  public static List<OccurrenceName> parseList(List<String> formattedStrings) {
    List<OccurrenceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OccurrenceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OccurrenceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_OCCURRENCE.matches(formattedString);
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
          if (occurrence != null) {
            fieldMapBuilder.put("occurrence", occurrence);
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
    return PROJECT_OCCURRENCE.instantiate("project", project, "occurrence", occurrence);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      OccurrenceName that = ((OccurrenceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.occurrence, that.occurrence);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(occurrence);
    return h;
  }

  /** Builder for projects/{project}/occurrences/{occurrence}. */
  public static class Builder {
    private String project;
    private String occurrence;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getOccurrence() {
      return occurrence;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setOccurrence(String occurrence) {
      this.occurrence = occurrence;
      return this;
    }

    private Builder(OccurrenceName occurrenceName) {
      project = occurrenceName.project;
      occurrence = occurrenceName.occurrence;
    }

    public OccurrenceName build() {
      return new OccurrenceName(this);
    }
  }
}
