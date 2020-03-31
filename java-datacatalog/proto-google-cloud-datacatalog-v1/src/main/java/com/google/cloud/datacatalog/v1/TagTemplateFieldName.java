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

package com.google.cloud.datacatalog.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class TagTemplateFieldName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{field}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String tagTemplate;
  private final String field;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTagTemplate() {
    return tagTemplate;
  }

  public String getField() {
    return field;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TagTemplateFieldName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tagTemplate = Preconditions.checkNotNull(builder.getTagTemplate());
    field = Preconditions.checkNotNull(builder.getField());
  }

  public static TagTemplateFieldName of(
      String project, String location, String tagTemplate, String field) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTagTemplate(tagTemplate)
        .setField(field)
        .build();
  }

  public static String format(String project, String location, String tagTemplate, String field) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTagTemplate(tagTemplate)
        .setField(field)
        .build()
        .toString();
  }

  public static TagTemplateFieldName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "TagTemplateFieldName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("tag_template"),
        matchMap.get("field"));
  }

  public static List<TagTemplateFieldName> parseList(List<String> formattedStrings) {
    List<TagTemplateFieldName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagTemplateFieldName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (TagTemplateFieldName value : values) {
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
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("tagTemplate", tagTemplate);
          fieldMapBuilder.put("field", field);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "location", location, "tag_template", tagTemplate, "field", field);
  }

  /** Builder for TagTemplateFieldName. */
  public static class Builder {

    private String project;
    private String location;
    private String tagTemplate;
    private String field;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTagTemplate() {
      return tagTemplate;
    }

    public String getField() {
      return field;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTagTemplate(String tagTemplate) {
      this.tagTemplate = tagTemplate;
      return this;
    }

    public Builder setField(String field) {
      this.field = field;
      return this;
    }

    private Builder() {}

    private Builder(TagTemplateFieldName tagTemplateFieldName) {
      project = tagTemplateFieldName.project;
      location = tagTemplateFieldName.location;
      tagTemplate = tagTemplateFieldName.tagTemplate;
      field = tagTemplateFieldName.field;
    }

    public TagTemplateFieldName build() {
      return new TagTemplateFieldName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TagTemplateFieldName) {
      TagTemplateFieldName that = (TagTemplateFieldName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.tagTemplate.equals(that.tagTemplate))
          && (this.field.equals(that.field));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= tagTemplate.hashCode();
    h *= 1000003;
    h ^= field.hashCode();
    return h;
  }
}
