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

package com.google.cloud.datalabeling.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AnnotationSpecSetName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/annotationSpecSets/{annotation_spec_set}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String annotationSpecSet;

  public String getProject() {
    return project;
  }

  public String getAnnotationSpecSet() {
    return annotationSpecSet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AnnotationSpecSetName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    annotationSpecSet = Preconditions.checkNotNull(builder.getAnnotationSpecSet());
  }

  public static AnnotationSpecSetName of(String project, String annotationSpecSet) {
    return newBuilder().setProject(project).setAnnotationSpecSet(annotationSpecSet).build();
  }

  public static String format(String project, String annotationSpecSet) {
    return newBuilder()
        .setProject(project)
        .setAnnotationSpecSet(annotationSpecSet)
        .build()
        .toString();
  }

  public static AnnotationSpecSetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AnnotationSpecSetName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("annotation_spec_set"));
  }

  public static List<AnnotationSpecSetName> parseList(List<String> formattedStrings) {
    List<AnnotationSpecSetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AnnotationSpecSetName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AnnotationSpecSetName value : values) {
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
          fieldMapBuilder.put("annotationSpecSet", annotationSpecSet);
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
    return PATH_TEMPLATE.instantiate("project", project, "annotation_spec_set", annotationSpecSet);
  }

  /** Builder for AnnotationSpecSetName. */
  public static class Builder {

    private String project;
    private String annotationSpecSet;

    public String getProject() {
      return project;
    }

    public String getAnnotationSpecSet() {
      return annotationSpecSet;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAnnotationSpecSet(String annotationSpecSet) {
      this.annotationSpecSet = annotationSpecSet;
      return this;
    }

    private Builder() {}

    private Builder(AnnotationSpecSetName annotationSpecSetName) {
      project = annotationSpecSetName.project;
      annotationSpecSet = annotationSpecSetName.annotationSpecSet;
    }

    public AnnotationSpecSetName build() {
      return new AnnotationSpecSetName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AnnotationSpecSetName) {
      AnnotationSpecSetName that = (AnnotationSpecSetName) o;
      return (this.project.equals(that.project))
          && (this.annotationSpecSet.equals(that.annotationSpecSet));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= annotationSpecSet.hashCode();
    return h;
  }
}
