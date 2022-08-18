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

package com.google.containeranalysis.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OccurrenceName extends IamResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/occurrences/{occurrence}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String occurrence;

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

  private OccurrenceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    occurrence = Preconditions.checkNotNull(builder.getOccurrence());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("occurrence", occurrence);
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
    return PATH_TEMPLATE.instantiate("project", project, "occurrence", occurrence);
  }

  /** Builder for OccurrenceName. */
  public static class Builder {

    private String project;
    private String occurrence;

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

    private Builder() {}

    private Builder(OccurrenceName occurrenceName) {
      project = occurrenceName.project;
      occurrence = occurrenceName.occurrence;
    }

    public OccurrenceName build() {
      return new OccurrenceName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OccurrenceName) {
      OccurrenceName that = (OccurrenceName) o;
      return (this.project.equals(that.project)) && (this.occurrence.equals(that.occurrence));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= occurrence.hashCode();
    return h;
  }
}
