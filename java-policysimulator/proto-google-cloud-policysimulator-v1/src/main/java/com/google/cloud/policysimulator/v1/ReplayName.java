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

package com.google.cloud.policysimulator.v1;

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
public class ReplayName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPLAY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/replays/{replay}");
  private static final PathTemplate FOLDER_LOCATION_REPLAY =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/replays/{replay}");
  private static final PathTemplate ORGANIZATION_LOCATION_REPLAY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/replays/{replay}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String replay;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ReplayName() {
    project = null;
    location = null;
    replay = null;
    folder = null;
    organization = null;
  }

  private ReplayName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    replay = Preconditions.checkNotNull(builder.getReplay());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_LOCATION_REPLAY;
  }

  private ReplayName(FolderLocationReplayBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    replay = Preconditions.checkNotNull(builder.getReplay());
    project = null;
    organization = null;
    pathTemplate = FOLDER_LOCATION_REPLAY;
  }

  private ReplayName(OrganizationLocationReplayBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    replay = Preconditions.checkNotNull(builder.getReplay());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_LOCATION_REPLAY;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getReplay() {
    return replay;
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
  public static Builder newProjectLocationReplayBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderLocationReplayBuilder newFolderLocationReplayBuilder() {
    return new FolderLocationReplayBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationLocationReplayBuilder newOrganizationLocationReplayBuilder() {
    return new OrganizationLocationReplayBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ReplayName of(String project, String location, String replay) {
    return newBuilder().setProject(project).setLocation(location).setReplay(replay).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ReplayName ofProjectLocationReplayName(
      String project, String location, String replay) {
    return newBuilder().setProject(project).setLocation(location).setReplay(replay).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ReplayName ofFolderLocationReplayName(
      String folder, String location, String replay) {
    return newFolderLocationReplayBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setReplay(replay)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ReplayName ofOrganizationLocationReplayName(
      String organization, String location, String replay) {
    return newOrganizationLocationReplayBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setReplay(replay)
        .build();
  }

  public static String format(String project, String location, String replay) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReplay(replay)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationReplayName(
      String project, String location, String replay) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setReplay(replay)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderLocationReplayName(
      String folder, String location, String replay) {
    return newFolderLocationReplayBuilder()
        .setFolder(folder)
        .setLocation(location)
        .setReplay(replay)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationReplayName(
      String organization, String location, String replay) {
    return newOrganizationLocationReplayBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setReplay(replay)
        .build()
        .toString();
  }

  public static ReplayName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_REPLAY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_REPLAY.match(formattedString);
      return ofProjectLocationReplayName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("replay"));
    } else if (FOLDER_LOCATION_REPLAY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION_REPLAY.match(formattedString);
      return ofFolderLocationReplayName(
          matchMap.get("folder"), matchMap.get("location"), matchMap.get("replay"));
    } else if (ORGANIZATION_LOCATION_REPLAY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_REPLAY.match(formattedString);
      return ofOrganizationLocationReplayName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("replay"));
    }
    throw new ValidationException("ReplayName.parse: formattedString not in valid format");
  }

  public static List<ReplayName> parseList(List<String> formattedStrings) {
    List<ReplayName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ReplayName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ReplayName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPLAY.matches(formattedString)
        || FOLDER_LOCATION_REPLAY.matches(formattedString)
        || ORGANIZATION_LOCATION_REPLAY.matches(formattedString);
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
          if (replay != null) {
            fieldMapBuilder.put("replay", replay);
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
      ReplayName that = ((ReplayName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.replay, that.replay)
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
    h ^= Objects.hashCode(replay);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/replays/{replay}. */
  public static class Builder {
    private String project;
    private String location;
    private String replay;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getReplay() {
      return replay;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setReplay(String replay) {
      this.replay = replay;
      return this;
    }

    private Builder(ReplayName replayName) {
      Preconditions.checkArgument(
          Objects.equals(replayName.pathTemplate, PROJECT_LOCATION_REPLAY),
          "toBuilder is only supported when ReplayName has the pattern of projects/{project}/locations/{location}/replays/{replay}");
      this.project = replayName.project;
      this.location = replayName.location;
      this.replay = replayName.replay;
    }

    public ReplayName build() {
      return new ReplayName(this);
    }
  }

  /** Builder for folders/{folder}/locations/{location}/replays/{replay}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderLocationReplayBuilder {
    private String folder;
    private String location;
    private String replay;

    protected FolderLocationReplayBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getLocation() {
      return location;
    }

    public String getReplay() {
      return replay;
    }

    public FolderLocationReplayBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderLocationReplayBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public FolderLocationReplayBuilder setReplay(String replay) {
      this.replay = replay;
      return this;
    }

    public ReplayName build() {
      return new ReplayName(this);
    }
  }

  /** Builder for organizations/{organization}/locations/{location}/replays/{replay}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationLocationReplayBuilder {
    private String organization;
    private String location;
    private String replay;

    protected OrganizationLocationReplayBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getReplay() {
      return replay;
    }

    public OrganizationLocationReplayBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationLocationReplayBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public OrganizationLocationReplayBuilder setReplay(String replay) {
      this.replay = replay;
      return this;
    }

    public ReplayName build() {
      return new ReplayName(this);
    }
  }
}
