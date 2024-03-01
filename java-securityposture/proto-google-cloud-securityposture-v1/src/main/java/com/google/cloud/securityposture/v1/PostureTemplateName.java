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

package com.google.cloud.securityposture.v1;

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
public class PostureTemplateName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_POSTURE_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/postureTemplates/{posture_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String location;
  private final String postureTemplate;

  @Deprecated
  protected PostureTemplateName() {
    organization = null;
    location = null;
    postureTemplate = null;
  }

  private PostureTemplateName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    postureTemplate = Preconditions.checkNotNull(builder.getPostureTemplate());
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getPostureTemplate() {
    return postureTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PostureTemplateName of(
      String organization, String location, String postureTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPostureTemplate(postureTemplate)
        .build();
  }

  public static String format(String organization, String location, String postureTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setPostureTemplate(postureTemplate)
        .build()
        .toString();
  }

  public static PostureTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_LOCATION_POSTURE_TEMPLATE.validatedMatch(
            formattedString, "PostureTemplateName.parse: formattedString not in valid format");
    return of(
        matchMap.get("organization"), matchMap.get("location"), matchMap.get("posture_template"));
  }

  public static List<PostureTemplateName> parseList(List<String> formattedStrings) {
    List<PostureTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PostureTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PostureTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_POSTURE_TEMPLATE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (postureTemplate != null) {
            fieldMapBuilder.put("posture_template", postureTemplate);
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
    return ORGANIZATION_LOCATION_POSTURE_TEMPLATE.instantiate(
        "organization", organization, "location", location, "posture_template", postureTemplate);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PostureTemplateName that = ((PostureTemplateName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.postureTemplate, that.postureTemplate);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(postureTemplate);
    return h;
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/postureTemplates/{posture_template}.
   */
  public static class Builder {
    private String organization;
    private String location;
    private String postureTemplate;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getPostureTemplate() {
      return postureTemplate;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setPostureTemplate(String postureTemplate) {
      this.postureTemplate = postureTemplate;
      return this;
    }

    private Builder(PostureTemplateName postureTemplateName) {
      this.organization = postureTemplateName.organization;
      this.location = postureTemplateName.location;
      this.postureTemplate = postureTemplateName.postureTemplate;
    }

    public PostureTemplateName build() {
      return new PostureTemplateName(this);
    }
  }
}
