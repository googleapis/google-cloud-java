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

package com.google.cloud.resourcesettings.v1;

import com.google.api.core.BetaApi;
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
public class SettingName implements ResourceName {
  private static final PathTemplate PROJECT_NUMBER_SETTING_NAME =
      PathTemplate.createWithoutUrlEncoding("projects/{project_number}/settings/{setting_name}");
  private static final PathTemplate FOLDER_SETTING_NAME =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/settings/{setting_name}");
  private static final PathTemplate ORGANIZATION_SETTING_NAME =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/settings/{setting_name}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String projectNumber;
  private final String settingName;
  private final String folder;
  private final String organization;

  @Deprecated
  protected SettingName() {
    projectNumber = null;
    settingName = null;
    folder = null;
    organization = null;
  }

  private SettingName(Builder builder) {
    projectNumber = Preconditions.checkNotNull(builder.getProjectNumber());
    settingName = Preconditions.checkNotNull(builder.getSettingName());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_NUMBER_SETTING_NAME;
  }

  private SettingName(FolderSettingNameBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    settingName = Preconditions.checkNotNull(builder.getSettingName());
    projectNumber = null;
    organization = null;
    pathTemplate = FOLDER_SETTING_NAME;
  }

  private SettingName(OrganizationSettingNameBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    settingName = Preconditions.checkNotNull(builder.getSettingName());
    projectNumber = null;
    folder = null;
    pathTemplate = ORGANIZATION_SETTING_NAME;
  }

  public String getProjectNumber() {
    return projectNumber;
  }

  public String getSettingName() {
    return settingName;
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

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectNumberSettingNameBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSettingNameBuilder newFolderSettingNameBuilder() {
    return new FolderSettingNameBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationSettingNameBuilder newOrganizationSettingNameBuilder() {
    return new OrganizationSettingNameBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SettingName of(String projectNumber, String settingName) {
    return newBuilder().setProjectNumber(projectNumber).setSettingName(settingName).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingName ofProjectNumberSettingNameName(
      String projectNumber, String settingName) {
    return newBuilder().setProjectNumber(projectNumber).setSettingName(settingName).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingName ofFolderSettingNameName(String folder, String settingName) {
    return newFolderSettingNameBuilder().setFolder(folder).setSettingName(settingName).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SettingName ofOrganizationSettingNameName(String organization, String settingName) {
    return newOrganizationSettingNameBuilder()
        .setOrganization(organization)
        .setSettingName(settingName)
        .build();
  }

  public static String format(String projectNumber, String settingName) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setSettingName(settingName)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectNumberSettingNameName(
      String projectNumber, String settingName) {
    return newBuilder()
        .setProjectNumber(projectNumber)
        .setSettingName(settingName)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSettingNameName(String folder, String settingName) {
    return newFolderSettingNameBuilder()
        .setFolder(folder)
        .setSettingName(settingName)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSettingNameName(String organization, String settingName) {
    return newOrganizationSettingNameBuilder()
        .setOrganization(organization)
        .setSettingName(settingName)
        .build()
        .toString();
  }

  public static SettingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_NUMBER_SETTING_NAME.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_NUMBER_SETTING_NAME.match(formattedString);
      return ofProjectNumberSettingNameName(
          matchMap.get("project_number"), matchMap.get("setting_name"));
    } else if (FOLDER_SETTING_NAME.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SETTING_NAME.match(formattedString);
      return ofFolderSettingNameName(matchMap.get("folder"), matchMap.get("setting_name"));
    } else if (ORGANIZATION_SETTING_NAME.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SETTING_NAME.match(formattedString);
      return ofOrganizationSettingNameName(
          matchMap.get("organization"), matchMap.get("setting_name"));
    }
    throw new ValidationException("SettingName.parse: formattedString not in valid format");
  }

  public static List<SettingName> parseList(List<String> formattedStrings) {
    List<SettingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SettingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SettingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NUMBER_SETTING_NAME.matches(formattedString)
        || FOLDER_SETTING_NAME.matches(formattedString)
        || ORGANIZATION_SETTING_NAME.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (projectNumber != null) {
            fieldMapBuilder.put("project_number", projectNumber);
          }
          if (settingName != null) {
            fieldMapBuilder.put("setting_name", settingName);
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
    if (o != null || getClass() == o.getClass()) {
      SettingName that = ((SettingName) o);
      return Objects.equals(this.projectNumber, that.projectNumber)
          && Objects.equals(this.settingName, that.settingName)
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
    h ^= Objects.hashCode(projectNumber);
    h *= 1000003;
    h ^= Objects.hashCode(settingName);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project_number}/settings/{setting_name}. */
  public static class Builder {
    private String projectNumber;
    private String settingName;

    protected Builder() {}

    public String getProjectNumber() {
      return projectNumber;
    }

    public String getSettingName() {
      return settingName;
    }

    public Builder setProjectNumber(String projectNumber) {
      this.projectNumber = projectNumber;
      return this;
    }

    public Builder setSettingName(String settingName) {
      this.settingName = settingName;
      return this;
    }

    private Builder(SettingName settingName) {
      Preconditions.checkArgument(
          Objects.equals(settingName.pathTemplate, PROJECT_NUMBER_SETTING_NAME),
          "toBuilder is only supported when SettingName has the pattern of projects/{project_number}/settings/{setting_name}");
      this.projectNumber = settingName.projectNumber;
      this.settingName = settingName.settingName;
    }

    public SettingName build() {
      return new SettingName(this);
    }
  }

  /** Builder for folders/{folder}/settings/{setting_name}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSettingNameBuilder {
    private String folder;
    private String settingName;

    protected FolderSettingNameBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSettingName() {
      return settingName;
    }

    public FolderSettingNameBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSettingNameBuilder setSettingName(String settingName) {
      this.settingName = settingName;
      return this;
    }

    public SettingName build() {
      return new SettingName(this);
    }
  }

  /** Builder for organizations/{organization}/settings/{setting_name}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationSettingNameBuilder {
    private String organization;
    private String settingName;

    protected OrganizationSettingNameBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSettingName() {
      return settingName;
    }

    public OrganizationSettingNameBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationSettingNameBuilder setSettingName(String settingName) {
      this.settingName = settingName;
      return this;
    }

    public SettingName build() {
      return new SettingName(this);
    }
  }
}
