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

package com.google.cloud.oracledatabase.v1;

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
public class ExascaleDbStorageVaultName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_EXASCALE_DB_STORAGE_VAULT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String exascaleDbStorageVault;

  @Deprecated
  protected ExascaleDbStorageVaultName() {
    project = null;
    location = null;
    exascaleDbStorageVault = null;
  }

  private ExascaleDbStorageVaultName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    exascaleDbStorageVault = Preconditions.checkNotNull(builder.getExascaleDbStorageVault());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getExascaleDbStorageVault() {
    return exascaleDbStorageVault;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ExascaleDbStorageVaultName of(
      String project, String location, String exascaleDbStorageVault) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExascaleDbStorageVault(exascaleDbStorageVault)
        .build();
  }

  public static String format(String project, String location, String exascaleDbStorageVault) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setExascaleDbStorageVault(exascaleDbStorageVault)
        .build()
        .toString();
  }

  public static ExascaleDbStorageVaultName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_EXASCALE_DB_STORAGE_VAULT.validatedMatch(
            formattedString,
            "ExascaleDbStorageVaultName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("exascale_db_storage_vault"));
  }

  public static List<ExascaleDbStorageVaultName> parseList(List<String> formattedStrings) {
    List<ExascaleDbStorageVaultName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ExascaleDbStorageVaultName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ExascaleDbStorageVaultName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_EXASCALE_DB_STORAGE_VAULT.matches(formattedString);
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
          if (exascaleDbStorageVault != null) {
            fieldMapBuilder.put("exascale_db_storage_vault", exascaleDbStorageVault);
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
    return PROJECT_LOCATION_EXASCALE_DB_STORAGE_VAULT.instantiate(
        "project",
        project,
        "location",
        location,
        "exascale_db_storage_vault",
        exascaleDbStorageVault);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ExascaleDbStorageVaultName that = ((ExascaleDbStorageVaultName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.exascaleDbStorageVault, that.exascaleDbStorageVault);
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
    h ^= Objects.hashCode(exascaleDbStorageVault);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/exascaleDbStorageVaults/{exascale_db_storage_vault}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String exascaleDbStorageVault;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getExascaleDbStorageVault() {
      return exascaleDbStorageVault;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setExascaleDbStorageVault(String exascaleDbStorageVault) {
      this.exascaleDbStorageVault = exascaleDbStorageVault;
      return this;
    }

    private Builder(ExascaleDbStorageVaultName exascaleDbStorageVaultName) {
      this.project = exascaleDbStorageVaultName.project;
      this.location = exascaleDbStorageVaultName.location;
      this.exascaleDbStorageVault = exascaleDbStorageVaultName.exascaleDbStorageVault;
    }

    public ExascaleDbStorageVaultName build() {
      return new ExascaleDbStorageVaultName(this);
    }
  }
}
