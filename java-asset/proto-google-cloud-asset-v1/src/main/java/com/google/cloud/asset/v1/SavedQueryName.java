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
public class SavedQueryName implements ResourceName {
  private static final PathTemplate PROJECT_SAVED_QUERY =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/savedQueries/{saved_query}");
  private static final PathTemplate FOLDER_SAVED_QUERY =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/savedQueries/{saved_query}");
  private static final PathTemplate ORGANIZATION_SAVED_QUERY =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/savedQueries/{saved_query}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String savedQuery;
  private final String folder;
  private final String organization;

  @Deprecated
  protected SavedQueryName() {
    project = null;
    savedQuery = null;
    folder = null;
    organization = null;
  }

  private SavedQueryName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    savedQuery = Preconditions.checkNotNull(builder.getSavedQuery());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_SAVED_QUERY;
  }

  private SavedQueryName(FolderSavedQueryBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    savedQuery = Preconditions.checkNotNull(builder.getSavedQuery());
    project = null;
    organization = null;
    pathTemplate = FOLDER_SAVED_QUERY;
  }

  private SavedQueryName(OrganizationSavedQueryBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    savedQuery = Preconditions.checkNotNull(builder.getSavedQuery());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_SAVED_QUERY;
  }

  public String getProject() {
    return project;
  }

  public String getSavedQuery() {
    return savedQuery;
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
  public static Builder newProjectSavedQueryBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderSavedQueryBuilder newFolderSavedQueryBuilder() {
    return new FolderSavedQueryBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationSavedQueryBuilder newOrganizationSavedQueryBuilder() {
    return new OrganizationSavedQueryBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SavedQueryName of(String project, String savedQuery) {
    return newBuilder().setProject(project).setSavedQuery(savedQuery).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SavedQueryName ofProjectSavedQueryName(String project, String savedQuery) {
    return newBuilder().setProject(project).setSavedQuery(savedQuery).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SavedQueryName ofFolderSavedQueryName(String folder, String savedQuery) {
    return newFolderSavedQueryBuilder().setFolder(folder).setSavedQuery(savedQuery).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static SavedQueryName ofOrganizationSavedQueryName(
      String organization, String savedQuery) {
    return newOrganizationSavedQueryBuilder()
        .setOrganization(organization)
        .setSavedQuery(savedQuery)
        .build();
  }

  public static String format(String project, String savedQuery) {
    return newBuilder().setProject(project).setSavedQuery(savedQuery).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectSavedQueryName(String project, String savedQuery) {
    return newBuilder().setProject(project).setSavedQuery(savedQuery).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderSavedQueryName(String folder, String savedQuery) {
    return newFolderSavedQueryBuilder()
        .setFolder(folder)
        .setSavedQuery(savedQuery)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationSavedQueryName(String organization, String savedQuery) {
    return newOrganizationSavedQueryBuilder()
        .setOrganization(organization)
        .setSavedQuery(savedQuery)
        .build()
        .toString();
  }

  public static SavedQueryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SAVED_QUERY.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SAVED_QUERY.match(formattedString);
      return ofProjectSavedQueryName(matchMap.get("project"), matchMap.get("saved_query"));
    } else if (FOLDER_SAVED_QUERY.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_SAVED_QUERY.match(formattedString);
      return ofFolderSavedQueryName(matchMap.get("folder"), matchMap.get("saved_query"));
    } else if (ORGANIZATION_SAVED_QUERY.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_SAVED_QUERY.match(formattedString);
      return ofOrganizationSavedQueryName(
          matchMap.get("organization"), matchMap.get("saved_query"));
    }
    throw new ValidationException("SavedQueryName.parse: formattedString not in valid format");
  }

  public static List<SavedQueryName> parseList(List<String> formattedStrings) {
    List<SavedQueryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SavedQueryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SavedQueryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SAVED_QUERY.matches(formattedString)
        || FOLDER_SAVED_QUERY.matches(formattedString)
        || ORGANIZATION_SAVED_QUERY.matches(formattedString);
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
          if (savedQuery != null) {
            fieldMapBuilder.put("saved_query", savedQuery);
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
      SavedQueryName that = ((SavedQueryName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.savedQuery, that.savedQuery)
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
    h ^= Objects.hashCode(savedQuery);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/savedQueries/{saved_query}. */
  public static class Builder {
    private String project;
    private String savedQuery;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSavedQuery() {
      return savedQuery;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSavedQuery(String savedQuery) {
      this.savedQuery = savedQuery;
      return this;
    }

    private Builder(SavedQueryName savedQueryName) {
      Preconditions.checkArgument(
          Objects.equals(savedQueryName.pathTemplate, PROJECT_SAVED_QUERY),
          "toBuilder is only supported when SavedQueryName has the pattern of projects/{project}/savedQueries/{saved_query}");
      this.project = savedQueryName.project;
      this.savedQuery = savedQueryName.savedQuery;
    }

    public SavedQueryName build() {
      return new SavedQueryName(this);
    }
  }

  /** Builder for folders/{folder}/savedQueries/{saved_query}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderSavedQueryBuilder {
    private String folder;
    private String savedQuery;

    protected FolderSavedQueryBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getSavedQuery() {
      return savedQuery;
    }

    public FolderSavedQueryBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderSavedQueryBuilder setSavedQuery(String savedQuery) {
      this.savedQuery = savedQuery;
      return this;
    }

    public SavedQueryName build() {
      return new SavedQueryName(this);
    }
  }

  /** Builder for organizations/{organization}/savedQueries/{saved_query}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationSavedQueryBuilder {
    private String organization;
    private String savedQuery;

    protected OrganizationSavedQueryBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSavedQuery() {
      return savedQuery;
    }

    public OrganizationSavedQueryBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationSavedQueryBuilder setSavedQuery(String savedQuery) {
      this.savedQuery = savedQuery;
      return this;
    }

    public SavedQueryName build() {
      return new SavedQueryName(this);
    }
  }
}
