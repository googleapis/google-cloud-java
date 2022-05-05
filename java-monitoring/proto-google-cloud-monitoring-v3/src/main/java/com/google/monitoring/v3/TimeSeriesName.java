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
public class TimeSeriesName implements ResourceName {
  private static final PathTemplate PROJECT_TIME_SERIES =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/timeSeries/{time_series}");
  private static final PathTemplate ORGANIZATION_TIME_SERIES =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/timeSeries/{time_series}");
  private static final PathTemplate FOLDER_TIME_SERIES =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/timeSeries/{time_series}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String timeSeries;
  private final String organization;
  private final String folder;

  @Deprecated
  protected TimeSeriesName() {
    project = null;
    timeSeries = null;
    organization = null;
    folder = null;
  }

  private TimeSeriesName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    timeSeries = Preconditions.checkNotNull(builder.getTimeSeries());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_TIME_SERIES;
  }

  private TimeSeriesName(OrganizationTimeSeriesBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    timeSeries = Preconditions.checkNotNull(builder.getTimeSeries());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_TIME_SERIES;
  }

  private TimeSeriesName(FolderTimeSeriesBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    timeSeries = Preconditions.checkNotNull(builder.getTimeSeries());
    project = null;
    organization = null;
    pathTemplate = FOLDER_TIME_SERIES;
  }

  public String getProject() {
    return project;
  }

  public String getTimeSeries() {
    return timeSeries;
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
  public static Builder newProjectTimeSeriesBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationTimeSeriesBuilder newOrganizationTimeSeriesBuilder() {
    return new OrganizationTimeSeriesBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderTimeSeriesBuilder newFolderTimeSeriesBuilder() {
    return new FolderTimeSeriesBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TimeSeriesName of(String project, String timeSeries) {
    return newBuilder().setProject(project).setTimeSeries(timeSeries).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TimeSeriesName ofProjectTimeSeriesName(String project, String timeSeries) {
    return newBuilder().setProject(project).setTimeSeries(timeSeries).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TimeSeriesName ofOrganizationTimeSeriesName(
      String organization, String timeSeries) {
    return newOrganizationTimeSeriesBuilder()
        .setOrganization(organization)
        .setTimeSeries(timeSeries)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static TimeSeriesName ofFolderTimeSeriesName(String folder, String timeSeries) {
    return newFolderTimeSeriesBuilder().setFolder(folder).setTimeSeries(timeSeries).build();
  }

  public static String format(String project, String timeSeries) {
    return newBuilder().setProject(project).setTimeSeries(timeSeries).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTimeSeriesName(String project, String timeSeries) {
    return newBuilder().setProject(project).setTimeSeries(timeSeries).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationTimeSeriesName(String organization, String timeSeries) {
    return newOrganizationTimeSeriesBuilder()
        .setOrganization(organization)
        .setTimeSeries(timeSeries)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderTimeSeriesName(String folder, String timeSeries) {
    return newFolderTimeSeriesBuilder()
        .setFolder(folder)
        .setTimeSeries(timeSeries)
        .build()
        .toString();
  }

  public static TimeSeriesName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_TIME_SERIES.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TIME_SERIES.match(formattedString);
      return ofProjectTimeSeriesName(matchMap.get("project"), matchMap.get("time_series"));
    } else if (ORGANIZATION_TIME_SERIES.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_TIME_SERIES.match(formattedString);
      return ofOrganizationTimeSeriesName(
          matchMap.get("organization"), matchMap.get("time_series"));
    } else if (FOLDER_TIME_SERIES.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_TIME_SERIES.match(formattedString);
      return ofFolderTimeSeriesName(matchMap.get("folder"), matchMap.get("time_series"));
    }
    throw new ValidationException("TimeSeriesName.parse: formattedString not in valid format");
  }

  public static List<TimeSeriesName> parseList(List<String> formattedStrings) {
    List<TimeSeriesName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TimeSeriesName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TimeSeriesName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TIME_SERIES.matches(formattedString)
        || ORGANIZATION_TIME_SERIES.matches(formattedString)
        || FOLDER_TIME_SERIES.matches(formattedString);
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
          if (timeSeries != null) {
            fieldMapBuilder.put("time_series", timeSeries);
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
      TimeSeriesName that = ((TimeSeriesName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.timeSeries, that.timeSeries)
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
    h ^= Objects.hashCode(timeSeries);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/timeSeries/{time_series}. */
  public static class Builder {
    private String project;
    private String timeSeries;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTimeSeries() {
      return timeSeries;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTimeSeries(String timeSeries) {
      this.timeSeries = timeSeries;
      return this;
    }

    private Builder(TimeSeriesName timeSeriesName) {
      Preconditions.checkArgument(
          Objects.equals(timeSeriesName.pathTemplate, PROJECT_TIME_SERIES),
          "toBuilder is only supported when TimeSeriesName has the pattern of projects/{project}/timeSeries/{time_series}");
      this.project = timeSeriesName.project;
      this.timeSeries = timeSeriesName.timeSeries;
    }

    public TimeSeriesName build() {
      return new TimeSeriesName(this);
    }
  }

  /** Builder for organizations/{organization}/timeSeries/{time_series}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationTimeSeriesBuilder {
    private String organization;
    private String timeSeries;

    protected OrganizationTimeSeriesBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getTimeSeries() {
      return timeSeries;
    }

    public OrganizationTimeSeriesBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationTimeSeriesBuilder setTimeSeries(String timeSeries) {
      this.timeSeries = timeSeries;
      return this;
    }

    public TimeSeriesName build() {
      return new TimeSeriesName(this);
    }
  }

  /** Builder for folders/{folder}/timeSeries/{time_series}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderTimeSeriesBuilder {
    private String folder;
    private String timeSeries;

    protected FolderTimeSeriesBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getTimeSeries() {
      return timeSeries;
    }

    public FolderTimeSeriesBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderTimeSeriesBuilder setTimeSeries(String timeSeries) {
      this.timeSeries = timeSeries;
      return this;
    }

    public TimeSeriesName build() {
      return new TimeSeriesName(this);
    }
  }
}
