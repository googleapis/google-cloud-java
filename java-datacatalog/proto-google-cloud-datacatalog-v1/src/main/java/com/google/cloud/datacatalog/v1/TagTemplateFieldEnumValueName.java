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
public class TagTemplateFieldEnumValueName implements ResourceName {
  private static final PathTemplate
      PROJECT_LOCATION_TAG_TEMPLATE_TAG_TEMPLATE_FIELD_ID_ENUM_VALUE_DISPLAY_NAME =
          PathTemplate.createWithoutUrlEncoding(
              "projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{tag_template_field_id}/enumValues/{enum_value_display_name}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String tagTemplate;
  private final String tagTemplateFieldId;
  private final String enumValueDisplayName;

  @Deprecated
  protected TagTemplateFieldEnumValueName() {
    project = null;
    location = null;
    tagTemplate = null;
    tagTemplateFieldId = null;
    enumValueDisplayName = null;
  }

  private TagTemplateFieldEnumValueName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    tagTemplate = Preconditions.checkNotNull(builder.getTagTemplate());
    tagTemplateFieldId = Preconditions.checkNotNull(builder.getTagTemplateFieldId());
    enumValueDisplayName = Preconditions.checkNotNull(builder.getEnumValueDisplayName());
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

  public String getTagTemplateFieldId() {
    return tagTemplateFieldId;
  }

  public String getEnumValueDisplayName() {
    return enumValueDisplayName;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagTemplateFieldEnumValueName of(
      String project,
      String location,
      String tagTemplate,
      String tagTemplateFieldId,
      String enumValueDisplayName) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTagTemplate(tagTemplate)
        .setTagTemplateFieldId(tagTemplateFieldId)
        .setEnumValueDisplayName(enumValueDisplayName)
        .build();
  }

  public static String format(
      String project,
      String location,
      String tagTemplate,
      String tagTemplateFieldId,
      String enumValueDisplayName) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTagTemplate(tagTemplate)
        .setTagTemplateFieldId(tagTemplateFieldId)
        .setEnumValueDisplayName(enumValueDisplayName)
        .build()
        .toString();
  }

  public static TagTemplateFieldEnumValueName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TAG_TEMPLATE_TAG_TEMPLATE_FIELD_ID_ENUM_VALUE_DISPLAY_NAME.validatedMatch(
            formattedString,
            "TagTemplateFieldEnumValueName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("tag_template"),
        matchMap.get("tag_template_field_id"),
        matchMap.get("enum_value_display_name"));
  }

  public static List<TagTemplateFieldEnumValueName> parseList(List<String> formattedStrings) {
    List<TagTemplateFieldEnumValueName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagTemplateFieldEnumValueName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagTemplateFieldEnumValueName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TAG_TEMPLATE_TAG_TEMPLATE_FIELD_ID_ENUM_VALUE_DISPLAY_NAME.matches(
        formattedString);
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
          if (tagTemplateFieldId != null) {
            fieldMapBuilder.put("tag_template_field_id", tagTemplateFieldId);
          }
          if (enumValueDisplayName != null) {
            fieldMapBuilder.put("enum_value_display_name", enumValueDisplayName);
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
    return PROJECT_LOCATION_TAG_TEMPLATE_TAG_TEMPLATE_FIELD_ID_ENUM_VALUE_DISPLAY_NAME.instantiate(
        "project",
        project,
        "location",
        location,
        "tag_template",
        tagTemplate,
        "tag_template_field_id",
        tagTemplateFieldId,
        "enum_value_display_name",
        enumValueDisplayName);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagTemplateFieldEnumValueName that = ((TagTemplateFieldEnumValueName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.tagTemplate, that.tagTemplate)
          && Objects.equals(this.tagTemplateFieldId, that.tagTemplateFieldId)
          && Objects.equals(this.enumValueDisplayName, that.enumValueDisplayName);
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
    h ^= Objects.hashCode(tagTemplateFieldId);
    h *= 1000003;
    h ^= Objects.hashCode(enumValueDisplayName);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/tagTemplates/{tag_template}/fields/{tag_template_field_id}/enumValues/{enum_value_display_name}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String tagTemplate;
    private String tagTemplateFieldId;
    private String enumValueDisplayName;

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

    public String getTagTemplateFieldId() {
      return tagTemplateFieldId;
    }

    public String getEnumValueDisplayName() {
      return enumValueDisplayName;
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

    public Builder setTagTemplateFieldId(String tagTemplateFieldId) {
      this.tagTemplateFieldId = tagTemplateFieldId;
      return this;
    }

    public Builder setEnumValueDisplayName(String enumValueDisplayName) {
      this.enumValueDisplayName = enumValueDisplayName;
      return this;
    }

    private Builder(TagTemplateFieldEnumValueName tagTemplateFieldEnumValueName) {
      this.project = tagTemplateFieldEnumValueName.project;
      this.location = tagTemplateFieldEnumValueName.location;
      this.tagTemplate = tagTemplateFieldEnumValueName.tagTemplate;
      this.tagTemplateFieldId = tagTemplateFieldEnumValueName.tagTemplateFieldId;
      this.enumValueDisplayName = tagTemplateFieldEnumValueName.enumValueDisplayName;
    }

    public TagTemplateFieldEnumValueName build() {
      return new TagTemplateFieldEnumValueName(this);
    }
  }
}
