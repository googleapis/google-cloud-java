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

package com.google.monitoring.v3;

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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class GroupName implements ResourceName {

  @Deprecated
  protected GroupName() {}

  private static final PathTemplate PROJECT_GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/groups/{group}");
  private static final PathTemplate ORGANIZATION_GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/groups/{group}");
  private static final PathTemplate FOLDER_GROUP_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/groups/{group}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String group;
  private String organization;
  private String folder;

  public String getProject() {
    return project;
  }

  public String getGroup() {
    return group;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  private GroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    group = Preconditions.checkNotNull(builder.getGroup());
    pathTemplate = PROJECT_GROUP_PATH_TEMPLATE;
  }

  private GroupName(OrganizationGroupBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    group = Preconditions.checkNotNull(builder.getGroup());
    pathTemplate = ORGANIZATION_GROUP_PATH_TEMPLATE;
  }

  private GroupName(FolderGroupBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    group = Preconditions.checkNotNull(builder.getGroup());
    pathTemplate = FOLDER_GROUP_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectGroupBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationGroupBuilder newOrganizationGroupBuilder() {
    return new OrganizationGroupBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderGroupBuilder newFolderGroupBuilder() {
    return new FolderGroupBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GroupName of(String project, String group) {
    return newProjectGroupBuilder().setProject(project).setGroup(group).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static GroupName ofProjectGroupName(String project, String group) {
    return newProjectGroupBuilder().setProject(project).setGroup(group).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static GroupName ofOrganizationGroupName(String organization, String group) {
    return newOrganizationGroupBuilder().setOrganization(organization).setGroup(group).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static GroupName ofFolderGroupName(String folder, String group) {
    return newFolderGroupBuilder().setFolder(folder).setGroup(group).build();
  }

  public static String format(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectGroupName(String project, String group) {
    return newBuilder().setProject(project).setGroup(group).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationGroupName(String organization, String group) {
    return newOrganizationGroupBuilder()
        .setOrganization(organization)
        .setGroup(group)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderGroupName(String folder, String group) {
    return newFolderGroupBuilder().setFolder(folder).setGroup(group).build().toString();
  }

  public static GroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_GROUP_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_GROUP_PATH_TEMPLATE.match(formattedString);
      return ofProjectGroupName(matchMap.get("project"), matchMap.get("group"));
    } else if (ORGANIZATION_GROUP_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_GROUP_PATH_TEMPLATE.match(formattedString);
      return ofOrganizationGroupName(matchMap.get("organization"), matchMap.get("group"));
    } else if (FOLDER_GROUP_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_GROUP_PATH_TEMPLATE.match(formattedString);
      return ofFolderGroupName(matchMap.get("folder"), matchMap.get("group"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<GroupName> parseList(List<String> formattedStrings) {
    List<GroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_GROUP_PATH_TEMPLATE.matches(formattedString)
        || ORGANIZATION_GROUP_PATH_TEMPLATE.matches(formattedString)
        || FOLDER_GROUP_PATH_TEMPLATE.matches(formattedString);
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
          if (group != null) {
            fieldMapBuilder.put("group", group);
          }
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (folder != null) {
            fieldMapBuilder.put("folder", folder);
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

  /** Builder for projects/{project}/groups/{group}. */
  public static class Builder {

    private String project;
    private String group;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getGroup() {
      return group;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setGroup(String group) {
      this.group = group;
      return this;
    }

    private Builder(GroupName groupName) {
      Preconditions.checkArgument(
          groupName.pathTemplate == PROJECT_GROUP_PATH_TEMPLATE,
          "toBuilder is only supported when GroupName has the pattern of "
              + "projects/{project}/groups/{group}.");
      project = groupName.project;
      group = groupName.group;
    }

    public GroupName build() {
      return new GroupName(this);
    }
  }

  /** Builder for organizations/{organization}/groups/{group}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationGroupBuilder {

    private String organization;
    private String group;

    private OrganizationGroupBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getGroup() {
      return group;
    }

    public OrganizationGroupBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationGroupBuilder setGroup(String group) {
      this.group = group;
      return this;
    }

    public GroupName build() {
      return new GroupName(this);
    }
  }

  /** Builder for folders/{folder}/groups/{group}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderGroupBuilder {

    private String folder;
    private String group;

    private FolderGroupBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getGroup() {
      return group;
    }

    public FolderGroupBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderGroupBuilder setGroup(String group) {
      this.group = group;
      return this;
    }

    public GroupName build() {
      return new GroupName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      GroupName that = (GroupName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.group, that.group))
          && (Objects.equals(this.organization, that.organization))
          && (Objects.equals(this.folder, that.folder));
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
    h ^= Objects.hashCode(group);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }
}
