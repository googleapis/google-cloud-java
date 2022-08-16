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
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class NotificationChannelDescriptorName implements ResourceName {
  private static final PathTemplate PROJECT_CHANNEL_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/notificationChannelDescriptors/{channel_descriptor}");
  private static final PathTemplate ORGANIZATION_CHANNEL_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/notificationChannelDescriptors/{channel_descriptor}");
  private static final PathTemplate FOLDER_CHANNEL_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/notificationChannelDescriptors/{channel_descriptor}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String channelDescriptor;
  private final String organization;
  private final String folder;

  @Deprecated
  protected NotificationChannelDescriptorName() {
    project = null;
    channelDescriptor = null;
    organization = null;
    folder = null;
  }

  private NotificationChannelDescriptorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    channelDescriptor = Preconditions.checkNotNull(builder.getChannelDescriptor());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_CHANNEL_DESCRIPTOR;
  }

  private NotificationChannelDescriptorName(OrganizationChannelDescriptorBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    channelDescriptor = Preconditions.checkNotNull(builder.getChannelDescriptor());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_CHANNEL_DESCRIPTOR;
  }

  private NotificationChannelDescriptorName(FolderChannelDescriptorBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    channelDescriptor = Preconditions.checkNotNull(builder.getChannelDescriptor());
    project = null;
    organization = null;
    pathTemplate = FOLDER_CHANNEL_DESCRIPTOR;
  }

  public String getProject() {
    return project;
  }

  public String getChannelDescriptor() {
    return channelDescriptor;
  }

  public String getOrganization() {
    return organization;
  }

  public String getFolder() {
    return folder;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectChannelDescriptorBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationChannelDescriptorBuilder newOrganizationChannelDescriptorBuilder() {
    return new OrganizationChannelDescriptorBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderChannelDescriptorBuilder newFolderChannelDescriptorBuilder() {
    return new FolderChannelDescriptorBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationChannelDescriptorName of(String project, String channelDescriptor) {
    return newBuilder().setProject(project).setChannelDescriptor(channelDescriptor).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelDescriptorName ofProjectChannelDescriptorName(
      String project, String channelDescriptor) {
    return newBuilder().setProject(project).setChannelDescriptor(channelDescriptor).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelDescriptorName ofOrganizationChannelDescriptorName(
      String organization, String channelDescriptor) {
    return newOrganizationChannelDescriptorBuilder()
        .setOrganization(organization)
        .setChannelDescriptor(channelDescriptor)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationChannelDescriptorName ofFolderChannelDescriptorName(
      String folder, String channelDescriptor) {
    return newFolderChannelDescriptorBuilder()
        .setFolder(folder)
        .setChannelDescriptor(channelDescriptor)
        .build();
  }

  public static String format(String project, String channelDescriptor) {
    return newBuilder()
        .setProject(project)
        .setChannelDescriptor(channelDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectChannelDescriptorName(
      String project, String channelDescriptor) {
    return newBuilder()
        .setProject(project)
        .setChannelDescriptor(channelDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationChannelDescriptorName(
      String organization, String channelDescriptor) {
    return newOrganizationChannelDescriptorBuilder()
        .setOrganization(organization)
        .setChannelDescriptor(channelDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderChannelDescriptorName(String folder, String channelDescriptor) {
    return newFolderChannelDescriptorBuilder()
        .setFolder(folder)
        .setChannelDescriptor(channelDescriptor)
        .build()
        .toString();
  }

  public static NotificationChannelDescriptorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CHANNEL_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CHANNEL_DESCRIPTOR.match(formattedString);
      return ofProjectChannelDescriptorName(
          matchMap.get("project"), matchMap.get("channel_descriptor"));
    } else if (ORGANIZATION_CHANNEL_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CHANNEL_DESCRIPTOR.match(formattedString);
      return ofOrganizationChannelDescriptorName(
          matchMap.get("organization"), matchMap.get("channel_descriptor"));
    } else if (FOLDER_CHANNEL_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_CHANNEL_DESCRIPTOR.match(formattedString);
      return ofFolderChannelDescriptorName(
          matchMap.get("folder"), matchMap.get("channel_descriptor"));
    }
    throw new ValidationException(
        "NotificationChannelDescriptorName.parse: formattedString not in valid format");
  }

  public static List<NotificationChannelDescriptorName> parseList(List<String> formattedStrings) {
    List<NotificationChannelDescriptorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationChannelDescriptorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationChannelDescriptorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CHANNEL_DESCRIPTOR.matches(formattedString)
        || ORGANIZATION_CHANNEL_DESCRIPTOR.matches(formattedString)
        || FOLDER_CHANNEL_DESCRIPTOR.matches(formattedString);
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
          if (channelDescriptor != null) {
            fieldMapBuilder.put("channel_descriptor", channelDescriptor);
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

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      NotificationChannelDescriptorName that = ((NotificationChannelDescriptorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.channelDescriptor, that.channelDescriptor)
          && Objects.equals(this.organization, that.organization)
          && Objects.equals(this.folder, that.folder);
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
    h ^= Objects.hashCode(channelDescriptor);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/notificationChannelDescriptors/{channel_descriptor}. */
  public static class Builder {
    private String project;
    private String channelDescriptor;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getChannelDescriptor() {
      return channelDescriptor;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setChannelDescriptor(String channelDescriptor) {
      this.channelDescriptor = channelDescriptor;
      return this;
    }

    private Builder(NotificationChannelDescriptorName notificationChannelDescriptorName) {
      Preconditions.checkArgument(
          Objects.equals(
              notificationChannelDescriptorName.pathTemplate, PROJECT_CHANNEL_DESCRIPTOR),
          "toBuilder is only supported when NotificationChannelDescriptorName has the pattern of projects/{project}/notificationChannelDescriptors/{channel_descriptor}");
      this.project = notificationChannelDescriptorName.project;
      this.channelDescriptor = notificationChannelDescriptorName.channelDescriptor;
    }

    public NotificationChannelDescriptorName build() {
      return new NotificationChannelDescriptorName(this);
    }
  }

  /**
   * Builder for organizations/{organization}/notificationChannelDescriptors/{channel_descriptor}.
   */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationChannelDescriptorBuilder {
    private String organization;
    private String channelDescriptor;

    protected OrganizationChannelDescriptorBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getChannelDescriptor() {
      return channelDescriptor;
    }

    public OrganizationChannelDescriptorBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationChannelDescriptorBuilder setChannelDescriptor(String channelDescriptor) {
      this.channelDescriptor = channelDescriptor;
      return this;
    }

    public NotificationChannelDescriptorName build() {
      return new NotificationChannelDescriptorName(this);
    }
  }

  /** Builder for folders/{folder}/notificationChannelDescriptors/{channel_descriptor}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderChannelDescriptorBuilder {
    private String folder;
    private String channelDescriptor;

    protected FolderChannelDescriptorBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getChannelDescriptor() {
      return channelDescriptor;
    }

    public FolderChannelDescriptorBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderChannelDescriptorBuilder setChannelDescriptor(String channelDescriptor) {
      this.channelDescriptor = channelDescriptor;
      return this;
    }

    public NotificationChannelDescriptorName build() {
      return new NotificationChannelDescriptorName(this);
    }
  }
}
