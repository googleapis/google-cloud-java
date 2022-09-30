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

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OrganizationInspectTemplateName extends InspectTemplateName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/inspectTemplates/{inspect_template}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String inspectTemplate;

  public String getOrganization() {
    return organization;
  }

  public String getInspectTemplate() {
    return inspectTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OrganizationInspectTemplateName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    inspectTemplate = Preconditions.checkNotNull(builder.getInspectTemplate());
  }

  public static OrganizationInspectTemplateName of(String organization, String inspectTemplate) {
    return newBuilder().setOrganization(organization).setInspectTemplate(inspectTemplate).build();
  }

  public static String format(String organization, String inspectTemplate) {
    return newBuilder()
        .setOrganization(organization)
        .setInspectTemplate(inspectTemplate)
        .build()
        .toString();
  }

  public static OrganizationInspectTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "OrganizationInspectTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("inspect_template"));
  }

  public static List<OrganizationInspectTemplateName> parseList(List<String> formattedStrings) {
    List<OrganizationInspectTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationInspectTemplateName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OrganizationInspectTemplateName value : values) {
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
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("inspectTemplate", inspectTemplate);
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
        "organization", organization, "inspect_template", inspectTemplate);
  }

  /** Builder for OrganizationInspectTemplateName. */
  public static class Builder extends InspectTemplateName.Builder {

    private String organization;
    private String inspectTemplate;

    public String getOrganization() {
      return organization;
    }

    public String getInspectTemplate() {
      return inspectTemplate;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setInspectTemplate(String inspectTemplate) {
      this.inspectTemplate = inspectTemplate;
      return this;
    }

    private Builder() {}

    private Builder(OrganizationInspectTemplateName organizationInspectTemplateName) {
      organization = organizationInspectTemplateName.organization;
      inspectTemplate = organizationInspectTemplateName.inspectTemplate;
    }

    public OrganizationInspectTemplateName build() {
      return new OrganizationInspectTemplateName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrganizationInspectTemplateName) {
      OrganizationInspectTemplateName that = (OrganizationInspectTemplateName) o;
      return (this.organization.equals(that.organization))
          && (this.inspectTemplate.equals(that.inspectTemplate));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= inspectTemplate.hashCode();
    return h;
  }
}
