/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.asset.v1;

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
public class FeedName implements ResourceName {
  private static final PathTemplate PROJECT_FEED =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/feeds/{feed}");
  private static final PathTemplate FOLDER_FEED =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/feeds/{feed}");
  private static final PathTemplate ORGANIZATION_FEED =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/feeds/{feed}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String feed;
  private final String folder;
  private final String organization;

  @Deprecated
  protected FeedName() {
    project = null;
    feed = null;
    folder = null;
    organization = null;
  }

  private FeedName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    feed = Preconditions.checkNotNull(builder.getFeed());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_FEED;
  }

  private FeedName(FolderFeedBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    feed = Preconditions.checkNotNull(builder.getFeed());
    project = null;
    organization = null;
    pathTemplate = FOLDER_FEED;
  }

  private FeedName(OrganizationFeedBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    feed = Preconditions.checkNotNull(builder.getFeed());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_FEED;
  }

  public String getProject() {
    return project;
  }

  public String getFeed() {
    return feed;
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
  public static Builder newProjectFeedBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderFeedBuilder newFolderFeedBuilder() {
    return new FolderFeedBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationFeedBuilder newOrganizationFeedBuilder() {
    return new OrganizationFeedBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static FeedName of(String project, String feed) {
    return newBuilder().setProject(project).setFeed(feed).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FeedName ofProjectFeedName(String project, String feed) {
    return newBuilder().setProject(project).setFeed(feed).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FeedName ofFolderFeedName(String folder, String feed) {
    return newFolderFeedBuilder().setFolder(folder).setFeed(feed).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static FeedName ofOrganizationFeedName(String organization, String feed) {
    return newOrganizationFeedBuilder().setOrganization(organization).setFeed(feed).build();
  }

  public static String format(String project, String feed) {
    return newBuilder().setProject(project).setFeed(feed).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectFeedName(String project, String feed) {
    return newBuilder().setProject(project).setFeed(feed).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderFeedName(String folder, String feed) {
    return newFolderFeedBuilder().setFolder(folder).setFeed(feed).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationFeedName(String organization, String feed) {
    return newOrganizationFeedBuilder()
        .setOrganization(organization)
        .setFeed(feed)
        .build()
        .toString();
  }

  public static FeedName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_FEED.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_FEED.match(formattedString);
      return ofProjectFeedName(matchMap.get("project"), matchMap.get("feed"));
    } else if (FOLDER_FEED.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_FEED.match(formattedString);
      return ofFolderFeedName(matchMap.get("folder"), matchMap.get("feed"));
    } else if (ORGANIZATION_FEED.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_FEED.match(formattedString);
      return ofOrganizationFeedName(matchMap.get("organization"), matchMap.get("feed"));
    }
    throw new ValidationException("FeedName.parse: formattedString not in valid format");
  }

  public static List<FeedName> parseList(List<String> formattedStrings) {
    List<FeedName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FeedName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (FeedName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_FEED.matches(formattedString)
        || FOLDER_FEED.matches(formattedString)
        || ORGANIZATION_FEED.matches(formattedString);
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
          if (feed != null) {
            fieldMapBuilder.put("feed", feed);
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
      FeedName that = ((FeedName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.feed, that.feed)
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
    h ^= Objects.hashCode(feed);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/feeds/{feed}. */
  public static class Builder {
    private String project;
    private String feed;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getFeed() {
      return feed;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setFeed(String feed) {
      this.feed = feed;
      return this;
    }

    private Builder(FeedName feedName) {
      Preconditions.checkArgument(
          Objects.equals(feedName.pathTemplate, PROJECT_FEED),
          "toBuilder is only supported when FeedName has the pattern of projects/{project}/feeds/{feed}");
      project = feedName.project;
      feed = feedName.feed;
    }

    public FeedName build() {
      return new FeedName(this);
    }
  }

  /** Builder for folders/{folder}/feeds/{feed}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderFeedBuilder {
    private String folder;
    private String feed;

    protected FolderFeedBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getFeed() {
      return feed;
    }

    public FolderFeedBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderFeedBuilder setFeed(String feed) {
      this.feed = feed;
      return this;
    }

    public FeedName build() {
      return new FeedName(this);
    }
  }

  /** Builder for organizations/{organization}/feeds/{feed}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationFeedBuilder {
    private String organization;
    private String feed;

    protected OrganizationFeedBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getFeed() {
      return feed;
    }

    public OrganizationFeedBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationFeedBuilder setFeed(String feed) {
      this.feed = feed;
      return this;
    }

    public FeedName build() {
      return new FeedName(this);
    }
  }
}
