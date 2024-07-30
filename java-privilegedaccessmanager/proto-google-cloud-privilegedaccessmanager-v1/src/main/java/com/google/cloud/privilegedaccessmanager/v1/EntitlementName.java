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

package com.google.cloud.privilegedaccessmanager.v1;

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
public class EntitlementName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTITLEMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entitlements/{entitlement}");
  private static final PathTemplate FOLDER_LOCATION_ENTITLEMENT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/entitlements/{entitlement}");
  private static final PathTemplate ORGANIZATION_LOCATION_ENTITLEMENT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/entitlements/{entitlement}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String entitlement;
  private final String folder;
  private final String organization;

  @Deprecated
  protected EntitlementName() {
    project = null;
    location = null;
    entitlement = null;
    folder = null;
    organization = null;
  }

  private EntitlementName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_ENTITLEMENT;
  }

  private EntitlementName(FolderLocationEntitlementBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_ENTITLEMENT;
  }

  private EntitlementName(OrganizationLocationEntitlementBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_ENTITLEMENT;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getEntitlement() {
    return entitlement;
  }

  public String getFolder() {
    return folder;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationEntitlementBuilder() {
    return new Builder();
  }

  public static FolderLocationEntitlementBuilder newFolderLocationEntitlementBuilder() {
    return new FolderLocationEntitlementBuilder();
  }

  public static OrganizationLocationEntitlementBuilder newOrganizationLocationEntitlementBuilder() {
    return new OrganizationLocationEntitlementBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntitlementName of(String project, String location, String entitlement) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build();
  }

  public static EntitlementName ofProjectLocationEntitlementName(
      String project, String location, String entitlement) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build();
  }

  public static EntitlementName ofFolderLocationEntitlementName(
      String folder, String location, String entitlement) {
    return newFolderLocationEntitlementBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build();
  }

  public static EntitlementName ofOrganizationLocationEntitlementName(
      String organization, String location, String entitlement) {
    return newOrganizationLocationEntitlementBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build();
  }

  public static String format(String project, String location, String entitlement) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build()
        .toString();
  }

  public static String formatProjectLocationEntitlementName(
      String project, String location, String entitlement) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build()
        .toString();
  }

  public static String formatFolderLocationEntitlementName(
      String folder, String location, String entitlement) {
    return newFolderLocationEntitlementBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationEntitlementName(
      String organization, String location, String entitlement) {
    return newOrganizationLocationEntitlementBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEntitlement(entitlement)
        .build()
        .toString();
  }

  public static EntitlementName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_ENTITLEMENT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ENTITLEMENT.match(formattedString);
      return ofProjectLocationEntitlementName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("entitlement"));
    } else if (FOLDER_LOCATION_ENTITLEMENT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_ENTITLEMENT.match(formattedString);
      return ofFolderLocationEntitlementName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("entitlement"));
    } else if (ORGANIZATION_LOCATION_ENTITLEMENT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_ENTITLEMENT.match(formattedString);
      return ofOrganizationLocationEntitlementName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("entitlement"));
    }
    throw new ValidationException("EntitlementName.parse: formattedString not in valid format");
  }

  public static List<EntitlementName> parseList(List<String> formattedStrings) {
    List<EntitlementName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntitlementName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EntitlementName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTITLEMENT.matches(formattedString)
        || FOLDER_LOCATION_ENTITLEMENT.matches(formattedString)
        || ORGANIZATION_LOCATION_ENTITLEMENT.matches(formattedString);
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
          if (entitlement != null) {
            fieldMapBuilder.put("entitlement", entitlement);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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
      EntitlementName that = ((EntitlementName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entitlement, that.entitlement)
          && Objects.equals(this.folder, that.folder)
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
    h ^= Objects.hashCode(entitlement);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/entitlements/{entitlement}. */
  public static class Builder {
    private String project;
    private String location;
    private String entitlement;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    private Builder(EntitlementName entitlementName) {
      Preconditions.checkArgument(
          Objects.equals(entitlementName.pathTemplate, PROJECT_LOCATION_ENTITLEMENT),
          "toBuilder is only supported when EntitlementName has the pattern of projects/{project}/locations/{location}/entitlements/{entitlement}");
      this.project = entitlementName.project;
      this.location = entitlementName.location;
      this.entitlement = entitlementName.entitlement;
    }

    public EntitlementName build() {
      return new EntitlementName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/entitlements/{entitlement}. */
  public static class FolderLocationEntitlementBuilder {
    private String folder;
    private String location;
    private String entitlement;

    protected FolderLocationEntitlementBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public FolderLocationEntitlementBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationEntitlementBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationEntitlementBuilder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    public EntitlementName build() {
      return new EntitlementName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/entitlements/{entitlement}. */
  public static class OrganizationLocationEntitlementBuilder {
    private String organization;
    private String location;
    private String entitlement;

    protected OrganizationLocationEntitlementBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public OrganizationLocationEntitlementBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationEntitlementBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationEntitlementBuilder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    public EntitlementName build() {
      return new EntitlementName(this);
    }
  }
}
