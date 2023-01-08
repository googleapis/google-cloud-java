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
public class MetricDescriptorName implements ResourceName {
  private static final PathTemplate PROJECT_METRIC_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/metricDescriptors/{metric_descriptor=**}");
  private static final PathTemplate ORGANIZATION_METRIC_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/metricDescriptors/{metric_descriptor=**}");
  private static final PathTemplate FOLDER_METRIC_DESCRIPTOR =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/metricDescriptors/{metric_descriptor=**}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String metricDescriptor;
  private final String organization;
  private final String folder;

  @Deprecated
  protected MetricDescriptorName() {
    project = null;
    metricDescriptor = null;
    organization = null;
    folder = null;
  }

  private MetricDescriptorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    metricDescriptor = Preconditions.checkNotNull(builder.getMetricDescriptor());
    organization = null;
    folder = null;
    pathTemplate = PROJECT_METRIC_DESCRIPTOR;
  }

  private MetricDescriptorName(OrganizationMetricDescriptorBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    metricDescriptor = Preconditions.checkNotNull(builder.getMetricDescriptor());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_METRIC_DESCRIPTOR;
  }

  private MetricDescriptorName(FolderMetricDescriptorBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    metricDescriptor = Preconditions.checkNotNull(builder.getMetricDescriptor());
    project = null;
    organization = null;
    pathTemplate = FOLDER_METRIC_DESCRIPTOR;
  }

  public String getProject() {
    return project;
  }

  public String getMetricDescriptor() {
    return metricDescriptor;
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
  public static Builder newProjectMetricDescriptorBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationMetricDescriptorBuilder newOrganizationMetricDescriptorBuilder() {
    return new OrganizationMetricDescriptorBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderMetricDescriptorBuilder newFolderMetricDescriptorBuilder() {
    return new FolderMetricDescriptorBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MetricDescriptorName of(String project, String metricDescriptor) {
    return newBuilder().setProject(project).setMetricDescriptor(metricDescriptor).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MetricDescriptorName ofProjectMetricDescriptorName(
      String project, String metricDescriptor) {
    return newBuilder().setProject(project).setMetricDescriptor(metricDescriptor).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MetricDescriptorName ofOrganizationMetricDescriptorName(
      String organization, String metricDescriptor) {
    return newOrganizationMetricDescriptorBuilder()
        .setOrganization(organization)
        .setMetricDescriptor(metricDescriptor)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static MetricDescriptorName ofFolderMetricDescriptorName(
      String folder, String metricDescriptor) {
    return newFolderMetricDescriptorBuilder()
        .setFolder(folder)
        .setMetricDescriptor(metricDescriptor)
        .build();
  }

  public static String format(String project, String metricDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMetricDescriptor(metricDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectMetricDescriptorName(String project, String metricDescriptor) {
    return newBuilder()
        .setProject(project)
        .setMetricDescriptor(metricDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationMetricDescriptorName(
      String organization, String metricDescriptor) {
    return newOrganizationMetricDescriptorBuilder()
        .setOrganization(organization)
        .setMetricDescriptor(metricDescriptor)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderMetricDescriptorName(String folder, String metricDescriptor) {
    return newFolderMetricDescriptorBuilder()
        .setFolder(folder)
        .setMetricDescriptor(metricDescriptor)
        .build()
        .toString();
  }

  public static MetricDescriptorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_METRIC_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_METRIC_DESCRIPTOR.match(formattedString);
      return ofProjectMetricDescriptorName(
          matchMap.get("project"), matchMap.get("metric_descriptor"));
    } else if (ORGANIZATION_METRIC_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_METRIC_DESCRIPTOR.match(formattedString);
      return ofOrganizationMetricDescriptorName(
          matchMap.get("organization"), matchMap.get("metric_descriptor"));
    } else if (FOLDER_METRIC_DESCRIPTOR.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_METRIC_DESCRIPTOR.match(formattedString);
      return ofFolderMetricDescriptorName(
          matchMap.get("folder"), matchMap.get("metric_descriptor"));
    }
    throw new ValidationException(
        "MetricDescriptorName.parse: formattedString not in valid format");
  }

  public static List<MetricDescriptorName> parseList(List<String> formattedStrings) {
    List<MetricDescriptorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MetricDescriptorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MetricDescriptorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_METRIC_DESCRIPTOR.matches(formattedString)
        || ORGANIZATION_METRIC_DESCRIPTOR.matches(formattedString)
        || FOLDER_METRIC_DESCRIPTOR.matches(formattedString);
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
          if (metricDescriptor != null) {
            fieldMapBuilder.put("metric_descriptor", metricDescriptor);
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
      MetricDescriptorName that = ((MetricDescriptorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.metricDescriptor, that.metricDescriptor)
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
    h ^= Objects.hashCode(metricDescriptor);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    return h;
  }

  /** Builder for projects/{project}/metricDescriptors/{metric_descriptor=&#42;&#42;}. */
  public static class Builder {
    private String project;
    private String metricDescriptor;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getMetricDescriptor() {
      return metricDescriptor;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setMetricDescriptor(String metricDescriptor) {
      this.metricDescriptor = metricDescriptor;
      return this;
    }

    private Builder(MetricDescriptorName metricDescriptorName) {
      Preconditions.checkArgument(
          Objects.equals(metricDescriptorName.pathTemplate, PROJECT_METRIC_DESCRIPTOR),
          "toBuilder is only supported when MetricDescriptorName has the pattern of projects/{project}/metricDescriptors/{metric_descriptor=**}");
      this.project = metricDescriptorName.project;
      this.metricDescriptor = metricDescriptorName.metricDescriptor;
    }

    public MetricDescriptorName build() {
      return new MetricDescriptorName(this);
    }
  }

  /** Builder for organizations/{organization}/metricDescriptors/{metric_descriptor=&#42;&#42;}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationMetricDescriptorBuilder {
    private String organization;
    private String metricDescriptor;

    protected OrganizationMetricDescriptorBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getMetricDescriptor() {
      return metricDescriptor;
    }

    public OrganizationMetricDescriptorBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationMetricDescriptorBuilder setMetricDescriptor(String metricDescriptor) {
      this.metricDescriptor = metricDescriptor;
      return this;
    }

    public MetricDescriptorName build() {
      return new MetricDescriptorName(this);
    }
  }

  /** Builder for folders/{folder}/metricDescriptors/{metric_descriptor=&#42;&#42;}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderMetricDescriptorBuilder {
    private String folder;
    private String metricDescriptor;

    protected FolderMetricDescriptorBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getMetricDescriptor() {
      return metricDescriptor;
    }

    public FolderMetricDescriptorBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderMetricDescriptorBuilder setMetricDescriptor(String metricDescriptor) {
      this.metricDescriptor = metricDescriptor;
      return this;
    }

    public MetricDescriptorName build() {
      return new MetricDescriptorName(this);
    }
  }
}
