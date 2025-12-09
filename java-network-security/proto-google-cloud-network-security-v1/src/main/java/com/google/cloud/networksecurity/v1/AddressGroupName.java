/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.networksecurity.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class AddressGroupName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ADDRESS_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/addressGroups/{address_group}");
  private static final PathTemplate ORGANIZATION_LOCATION_ADDRESS_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/addressGroups/{address_group}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String addressGroup;
  private final String organization;

  @Deprecated
  protected AddressGroupName() {
    project = null;
    location = null;
    addressGroup = null;
    organization = null;
  }

  private AddressGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    addressGroup = Preconditions.checkNotNull(builder.getAddressGroup());
    organization = null;
    pathTemplate = PROJECT_LOCATION_ADDRESS_GROUP;
  }

  private AddressGroupName(OrganizationLocationAddressGroupBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    addressGroup = Preconditions.checkNotNull(builder.getAddressGroup());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_ADDRESS_GROUP;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAddressGroup() {
    return addressGroup;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationAddressGroupBuilder() {
    return new Builder();
  }

  public static OrganizationLocationAddressGroupBuilder
      newOrganizationLocationAddressGroupBuilder() {
    return new OrganizationLocationAddressGroupBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AddressGroupName of(String project, String location, String addressGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build();
  }

  public static AddressGroupName ofProjectLocationAddressGroupName(
      String project, String location, String addressGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build();
  }

  public static AddressGroupName ofOrganizationLocationAddressGroupName(
      String organization, String location, String addressGroup) {
    return newOrganizationLocationAddressGroupBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build();
  }

  public static String format(String project, String location, String addressGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build()
        .toString();
  }

  public static String formatProjectLocationAddressGroupName(
      String project, String location, String addressGroup) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationAddressGroupName(
      String organization, String location, String addressGroup) {
    return newOrganizationLocationAddressGroupBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setAddressGroup(addressGroup)
        .build()
        .toString();
  }

  public static AddressGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_ADDRESS_GROUP.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ADDRESS_GROUP.match(formattedString);
      return ofProjectLocationAddressGroupName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("address_group"));
    } else if (ORGANIZATION_LOCATION_ADDRESS_GROUP.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_ADDRESS_GROUP.match(formattedString);
      return ofOrganizationLocationAddressGroupName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("address_group"));
    }
    throw new ValidationException("AddressGroupName.parse: formattedString not in valid format");
  }

  public static List<AddressGroupName> parseList(List<String> formattedStrings) {
    List<AddressGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AddressGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AddressGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ADDRESS_GROUP.matches(formattedString)
        || ORGANIZATION_LOCATION_ADDRESS_GROUP.matches(formattedString);
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
          if (addressGroup != null) {
            fieldMapBuilder.put("address_group", addressGroup);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AddressGroupName that = ((AddressGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.addressGroup, that.addressGroup)
          && Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(addressGroup);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/addressGroups/{address_group}. */
  public static class Builder {
    private String project;
    private String location;
    private String addressGroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAddressGroup() {
      return addressGroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAddressGroup(String addressGroup) {
      this.addressGroup = addressGroup;
      return this;
    }

    private Builder(AddressGroupName addressGroupName) {
      Preconditions.checkArgument(
          Objects.equals(addressGroupName.pathTemplate, PROJECT_LOCATION_ADDRESS_GROUP),
          "toBuilder is only supported when AddressGroupName has the pattern of"
              + " projects/{project}/locations/{location}/addressGroups/{address_group}");
      this.project = addressGroupName.project;
      this.location = addressGroupName.location;
      this.addressGroup = addressGroupName.addressGroup;
    }

    public AddressGroupName build() {
      return new AddressGroupName(this);
    }
  }

  /**
   * Builder for organizations/{organization}/locations/{location}/addressGroups/{address_group}.
   */
  public static class OrganizationLocationAddressGroupBuilder {
    private String organization;
    private String location;
    private String addressGroup;

    protected OrganizationLocationAddressGroupBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getAddressGroup() {
      return addressGroup;
    }

    public OrganizationLocationAddressGroupBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationAddressGroupBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationAddressGroupBuilder setAddressGroup(String addressGroup) {
      this.addressGroup = addressGroup;
      return this;
    }

    public AddressGroupName build() {
      return new AddressGroupName(this);
    }
  }
}
