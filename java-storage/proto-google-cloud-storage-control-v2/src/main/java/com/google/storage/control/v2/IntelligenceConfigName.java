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

package com.google.storage.control.v2;

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
public class IntelligenceConfigName implements ResourceName {
  private static final PathTemplate FOLDER_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "folders/{folder}/locations/{location}/intelligenceConfig");
  private static final PathTemplate ORG_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{org}/locations/{location}/intelligenceConfig");
  private static final PathTemplate PROJECT_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/intelligenceConfig");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String folder;
  private final String location;
  private final String org;
  private final String project;

  @Deprecated
  protected IntelligenceConfigName() {
    folder = null;
    location = null;
    org = null;
    project = null;
  }

  private IntelligenceConfigName(Builder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    location = Preconditions.checkNotNull(builder.getLocation());
    org = null;
    project = null;
    pathTemplate = FOLDER_LOCATION;
  }

  private IntelligenceConfigName(OrgLocationBuilder builder) {
    org = Preconditions.checkNotNull(builder.getOrg());
    location = Preconditions.checkNotNull(builder.getLocation());
    folder = null;
    project = null;
    pathTemplate = ORG_LOCATION;
  }

  private IntelligenceConfigName(ProjectLocationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    folder = null;
    org = null;
    pathTemplate = PROJECT_LOCATION;
  }

  public String getFolder() {
    return folder;
  }

  public String getLocation() {
    return location;
  }

  public String getOrg() {
    return org;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newFolderLocationBuilder() {
    return new Builder();
  }

  public static OrgLocationBuilder newOrgLocationBuilder() {
    return new OrgLocationBuilder();
  }

  public static ProjectLocationBuilder newProjectLocationBuilder() {
    return new ProjectLocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IntelligenceConfigName of(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build();
  }

  public static IntelligenceConfigName ofFolderLocationName(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build();
  }

  public static IntelligenceConfigName ofOrgLocationName(String org, String location) {
    return newOrgLocationBuilder().setOrg(org).setLocation(location).build();
  }

  public static IntelligenceConfigName ofProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build();
  }

  public static String format(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  public static String formatFolderLocationName(String folder, String location) {
    return newBuilder().setFolder(folder).setLocation(location).build().toString();
  }

  public static String formatOrgLocationName(String org, String location) {
    return newOrgLocationBuilder().setOrg(org).setLocation(location).build().toString();
  }

  public static String formatProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build().toString();
  }

  public static IntelligenceConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (FOLDER_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_LOCATION.match(formattedString);
      return ofFolderLocationName(matchMap.get("folder"), matchMap.get("location"));
    } else if (ORG_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = ORG_LOCATION.match(formattedString);
      return ofOrgLocationName(matchMap.get("org"), matchMap.get("location"));
    } else if (PROJECT_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION.match(formattedString);
      return ofProjectLocationName(matchMap.get("project"), matchMap.get("location"));
    }
    throw new ValidationException(
        "IntelligenceConfigName.parse: formattedString not in valid format");
  }

  public static List<IntelligenceConfigName> parseList(List<String> formattedStrings) {
    List<IntelligenceConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IntelligenceConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IntelligenceConfigName value : values) {
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
        || ORG_LOCATION.matches(formattedString)
        || PROJECT_LOCATION.matches(formattedString);
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
          if (org != null) {
            fieldMapBuilder.put("org", org);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
      IntelligenceConfigName that = ((IntelligenceConfigName) o);
      return Objects.equals(this.folder, that.folder)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.org, that.org)
          && Objects.equals(this.project, that.project);
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
    h ^= Objects.hashCode(org);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for folders/{folder}/locations/{location}/intelligenceConfig. */
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

    private Builder(IntelligenceConfigName intelligenceConfigName) {
      Preconditions.checkArgument(
          Objects.equals(intelligenceConfigName.pathTemplate, FOLDER_LOCATION),
          "toBuilder is only supported when IntelligenceConfigName has the pattern of"
              + " folders/{folder}/locations/{location}/intelligenceConfig");
      this.folder = intelligenceConfigName.folder;
      this.location = intelligenceConfigName.location;
    }

    public IntelligenceConfigName build() {
      return new IntelligenceConfigName(this);
    }
  }

  /** Builder for organizations/{org}/locations/{location}/intelligenceConfig. */
  public static class OrgLocationBuilder {
    private String org;
    private String location;

    protected OrgLocationBuilder() {}

    public String getOrg() {
      return org;
    }

    public String getLocation() {
      return location;
    }

    public OrgLocationBuilder setOrg(String org) {
      this.org = org;
      return this;
    }

    public OrgLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public IntelligenceConfigName build() {
      return new IntelligenceConfigName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/intelligenceConfig. */
  public static class ProjectLocationBuilder {
    private String project;
    private String location;

    protected ProjectLocationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public ProjectLocationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public IntelligenceConfigName build() {
      return new IntelligenceConfigName(this);
    }
  }
}
