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
public class GrantName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ENTITLEMENT_GRANT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/entitlements/{entitlement}/grants/{grant}");
  private static final PathTemplate FOLDER_LOCATION_ENTITLEMENT_GRANT =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/entitlements/{entitlement}/grants/{grant}");
  private static final PathTemplate ORGANIZATION_LOCATION_ENTITLEMENT_GRANT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/entitlements/{entitlement}/grants/{grant}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String entitlement;
  private final String grant;
  private final String folder;
  private final String organization;

  @Deprecated
  protected GrantName() {
    project = null;
    location = null;
    entitlement = null;
    grant = null;
    folder = null;
    organization = null;
  }

  private GrantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    grant = Preconditions.checkNotNull(builder.getGrant());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_ENTITLEMENT_GRANT;
  }

  private GrantName(FolderLocationEntitlementGrantBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    grant = Preconditions.checkNotNull(builder.getGrant());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_ENTITLEMENT_GRANT;
  }

  private GrantName(OrganizationLocationEntitlementGrantBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
    grant = Preconditions.checkNotNull(builder.getGrant());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_ENTITLEMENT_GRANT;
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

  public String getGrant() {
    return grant;
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

  public static Builder newProjectLocationEntitlementGrantBuilder() {
    return new Builder();
  }

  public static FolderLocationEntitlementGrantBuilder newFolderLocationEntitlementGrantBuilder() {
    return new FolderLocationEntitlementGrantBuilder();
  }

  public static OrganizationLocationEntitlementGrantBuilder
      newOrganizationLocationEntitlementGrantBuilder() {
    return new OrganizationLocationEntitlementGrantBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GrantName of(String project, String location, String entitlement, String grant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build();
  }

  public static GrantName ofProjectLocationEntitlementGrantName(
      String project, String location, String entitlement, String grant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build();
  }

  public static GrantName ofFolderLocationEntitlementGrantName(
      String folder, String location, String entitlement, String grant) {
    return newFolderLocationEntitlementGrantBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build();
  }

  public static GrantName ofOrganizationLocationEntitlementGrantName(
      String organization, String location, String entitlement, String grant) {
    return newOrganizationLocationEntitlementGrantBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build();
  }

  public static String format(String project, String location, String entitlement, String grant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build()
        .toString();
  }

  public static String formatProjectLocationEntitlementGrantName(
      String project, String location, String entitlement, String grant) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build()
        .toString();
  }

  public static String formatFolderLocationEntitlementGrantName(
      String folder, String location, String entitlement, String grant) {
    return newFolderLocationEntitlementGrantBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build()
        .toString();
  }

  public static String formatOrganizationLocationEntitlementGrantName(
      String organization, String location, String entitlement, String grant) {
    return newOrganizationLocationEntitlementGrantBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setEntitlement(entitlement)
        .setGrant(grant)
        .build()
        .toString();
  }

  public static GrantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_ENTITLEMENT_GRANT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ENTITLEMENT_GRANT.match(formattedString);
      return ofProjectLocationEntitlementGrantName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("entitlement"),
          matchMap.get("grant"));
    } else if (FOLDER_LOCATION_ENTITLEMENT_GRANT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_ENTITLEMENT_GRANT.match(formattedString);
      return ofFolderLocationEntitlementGrantName(
          matchMap.get("folder"),
          matchMap.get("location"),
          matchMap.get("entitlement"),
          matchMap.get("grant"));
    } else if (ORGANIZATION_LOCATION_ENTITLEMENT_GRANT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_ENTITLEMENT_GRANT.match(formattedString);
      return ofOrganizationLocationEntitlementGrantName(
          matchMap.get("organization"),
          matchMap.get("location"),
          matchMap.get("entitlement"),
          matchMap.get("grant"));
    }
    throw new ValidationException("GrantName.parse: formattedString not in valid format");
  }

  public static List<GrantName> parseList(List<String> formattedStrings) {
    List<GrantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GrantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GrantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ENTITLEMENT_GRANT.matches(formattedString)
        || FOLDER_LOCATION_ENTITLEMENT_GRANT.matches(formattedString)
        || ORGANIZATION_LOCATION_ENTITLEMENT_GRANT.matches(formattedString);
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
          if (grant != null) {
            fieldMapBuilder.put("grant", grant);
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
      GrantName that = ((GrantName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.entitlement, that.entitlement)
          && Objects.equals(this.grant, that.grant)
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
    h ^= Objects.hashCode(grant);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/entitlements/{entitlement}/grants/{grant}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String entitlement;
    private String grant;

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

    public String getGrant() {
      return grant;
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

    public Builder setGrant(String grant) {
      this.grant = grant;
      return this;
    }

    private Builder(GrantName grantName) {
      Preconditions.checkArgument(
          Objects.equals(grantName.pathTemplate, PROJECT_LOCATION_ENTITLEMENT_GRANT),
          "toBuilder is only supported when GrantName has the pattern of projects/{project}/locations/{location}/entitlements/{entitlement}/grants/{grant}");
      this.project = grantName.project;
      this.location = grantName.location;
      this.entitlement = grantName.entitlement;
      this.grant = grantName.grant;
    }

    public GrantName build() {
      return new GrantName(this);
    }
  }

  /**
   * Builder for folders/{folder}/locations/{location}/entitlements/{entitlement}/grants/{grant}.
   */
  public static class FolderLocationEntitlementGrantBuilder {
    private String folder;
    private String location;
    private String entitlement;
    private String grant;

    protected FolderLocationEntitlementGrantBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public String getGrant() {
      return grant;
    }

    public FolderLocationEntitlementGrantBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationEntitlementGrantBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationEntitlementGrantBuilder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    public FolderLocationEntitlementGrantBuilder setGrant(String grant) {
      this.grant = grant;
      return this;
    }

    public GrantName build() {
      return new GrantName(this);
    }
  }

  /**
   * Builder for
   * organizations/{organization}/locations/{location}/entitlements/{entitlement}/grants/{grant}.
   */
  public static class OrganizationLocationEntitlementGrantBuilder {
    private String organization;
    private String location;
    private String entitlement;
    private String grant;

    protected OrganizationLocationEntitlementGrantBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public String getGrant() {
      return grant;
    }

    public OrganizationLocationEntitlementGrantBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationEntitlementGrantBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationEntitlementGrantBuilder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    public OrganizationLocationEntitlementGrantBuilder setGrant(String grant) {
      this.grant = grant;
      return this;
    }

    public GrantName build() {
      return new GrantName(this);
    }
  }
}
