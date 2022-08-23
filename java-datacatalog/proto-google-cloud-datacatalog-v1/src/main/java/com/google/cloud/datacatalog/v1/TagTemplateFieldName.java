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

package com.google.cloud.datacatalog.v1;

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
public class TagTemplateFieldName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TAG_TEMPLATE_FIELD =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{field}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String tagTemplate;
  private final String field;

  @Deprecated
  protected TagTemplateFieldName() {
    project = null;
    location = null;
    tagTemplate = null;
    field = null;
  }

  private TagTemplateFieldName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tagTemplate = Preconditions.checkNotNull(builder.getTagTemplate());
    field = Preconditions.checkNotNull(builder.getField());
  }

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
        PROJECT_LOCATION_TAG_TEMPLATE_FIELD.validatedMatch(
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
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_LOCATION_TAG_TEMPLATE_FIELD.matches(formattedString);
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
          if (tagTemplate != null) {
            fieldMapBuilder.put("tag_template", tagTemplate);
          }
          if (field != null) {
            fieldMapBuilder.put("field", field);
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
    return PROJECT_LOCATION_TAG_TEMPLATE_FIELD.instantiate(
        "project", project, "location", location, "tag_template", tagTemplate, "field", field);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagTemplateFieldName that = ((TagTemplateFieldName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tagTemplate, that.tagTemplate)
          && Objects.equals(this.field, that.field);
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
    h ^= Objects.hashCode(tagTemplate);
    h *= 1000003;
    h ^= Objects.hashCode(field);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{field}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String tagTemplate;
    private String field;

    protected Builder() {}

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

    private Builder(TagTemplateFieldName tagTemplateFieldName) {
      this.project = tagTemplateFieldName.project;
      this.location = tagTemplateFieldName.location;
      this.tagTemplate = tagTemplateFieldName.tagTemplate;
      this.field = tagTemplateFieldName.field;
    }

    public TagTemplateFieldName build() {
      return new TagTemplateFieldName(this);
    }
  }
}
