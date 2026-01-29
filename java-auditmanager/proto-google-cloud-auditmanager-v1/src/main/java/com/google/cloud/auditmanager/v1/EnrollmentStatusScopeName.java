/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.auditmanager.v1;

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
public class EnrollmentStatusScopeName implements ResourceName {
  private static final PathTemplate FOLDER_LOCATION =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/locations/{location}");
  private static final PathTemplate ORGANIZATION_LOCATION =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/locations/{location}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String folder;
  private final String location;
  private final String organization;

  @Deprecated
  protected EnrollmentStatusScopeName() {
    folder = null;
    location = null;
    organization = null;
  }

  private EnrollmentStatusScopeName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    organization = null;
    pathTemplate = FOLDER_LOCATION;
  }

  private EnrollmentStatusScopeName(OrganizationLocationBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION;
  }

  public String getFolder() {
    return folder;
  }

  public String getLocation() {
    return location;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newFolderLocationBuilder() {
    return new Builder();
  }

  public static OrganizationLocationBuilder newOrganizationLocationBuilder() {
    return new OrganizationLocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EnrollmentStatusScopeName of(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build();
  }

  public static EnrollmentStatusScopeName ofFolderLocationName(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build();
  }

  public static EnrollmentStatusScopeName ofOrganizationLocationName(
      String organization, String location) {
    return newOrganizationLocationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .build();
  }

  public static String format(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  public static String formatFolderLocationName(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  public static String formatOrganizationLocationName(String organization, String location) {
    return newOrganizationLocationBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .build()
        .toString();
  }

  public static EnrollmentStatusScopeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (FOLDER_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION.match(formattedString);
      return ofFolderLocationName(matchMap.get("folder"), matchMap.get("location"));
    } else if (ORGANIZATION_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION.match(formattedString);
      return ofOrganizationLocationName(matchMap.get("organization"), matchMap.get("location"));
    }
    throw new ValidationException(
        "EnrollmentStatusScopeName.parse: formattedString not in valid format");
  }

  public static List<EnrollmentStatusScopeName> parseList(List<String> formattedStrings) {
    List<EnrollmentStatusScopeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EnrollmentStatusScopeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EnrollmentStatusScopeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return FOLDER_LOCATION.matches(formattedString)
        || ORGANIZATION_LOCATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
      EnrollmentStatusScopeName that = ((EnrollmentStatusScopeName) o);
      return Objects.equals(this.folder, that.folder)
          && Objects.equals(this.location, that.location)
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
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for folders/{folder}/locations/{location}. */
  public static class Builder {
    private String folder;
    private String location;

    protected Builder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public Builder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder(EnrollmentStatusScopeName enrollmentStatusScopeName) {
      Preconditions.checkArgument(
          Objects.equals(enrollmentStatusScopeName.pathTemplate, FOLDER_LOCATION),
          "toBuilder is only supported when EnrollmentStatusScopeName has the pattern of"
              + " folders/{folder}/locations/{location}");
      this.folder = enrollmentStatusScopeName.folder;
      this.location = enrollmentStatusScopeName.location;
    }

    public EnrollmentStatusScopeName build() {
      return new EnrollmentStatusScopeName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}. */
  public static class OrganizationLocationBuilder {
    private String organization;
    private String location;

    protected OrganizationLocationBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public OrganizationLocationBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public EnrollmentStatusScopeName build() {
      return new EnrollmentStatusScopeName(this);
    }
  }
}
