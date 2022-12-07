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

package com.google.cloud.orgpolicy.v2;

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
public class ConstraintName implements ResourceName {
  private static final PathTemplate PROJECT_CONSTRAINT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/constraints/{constraint}");
  private static final PathTemplate FOLDER_CONSTRAINT =
      PathTemplate.createWithoutUrlEncoding("folders/{folder}/constraints/{constraint}");
  private static final PathTemplate ORGANIZATION_CONSTRAINT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/constraints/{constraint}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String constraint;
  private final String folder;
  private final String organization;

  @Deprecated
  protected ConstraintName() {
    project = null;
    constraint = null;
    folder = null;
    organization = null;
  }

  private ConstraintName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    constraint = Preconditions.checkNotNull(builder.getConstraint());
    folder = null;
    organization = null;
    pathTemplate = PROJECT_CONSTRAINT;
  }

  private ConstraintName(FolderConstraintBuilder builder) {
    folder = Preconditions.checkNotNull(builder.getFolder());
    constraint = Preconditions.checkNotNull(builder.getConstraint());
    project = null;
    organization = null;
    pathTemplate = FOLDER_CONSTRAINT;
  }

  private ConstraintName(OrganizationConstraintBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    constraint = Preconditions.checkNotNull(builder.getConstraint());
    project = null;
    folder = null;
    pathTemplate = ORGANIZATION_CONSTRAINT;
  }

  public String getProject() {
    return project;
  }

  public String getConstraint() {
    return constraint;
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
  public static Builder newProjectConstraintBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static FolderConstraintBuilder newFolderConstraintBuilder() {
    return new FolderConstraintBuilder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationConstraintBuilder newOrganizationConstraintBuilder() {
    return new OrganizationConstraintBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConstraintName of(String project, String constraint) {
    return newBuilder().setProject(project).setConstraint(constraint).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConstraintName ofProjectConstraintName(String project, String constraint) {
    return newBuilder().setProject(project).setConstraint(constraint).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConstraintName ofFolderConstraintName(String folder, String constraint) {
    return newFolderConstraintBuilder().setFolder(folder).setConstraint(constraint).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static ConstraintName ofOrganizationConstraintName(
      String organization, String constraint) {
    return newOrganizationConstraintBuilder()
        .setOrganization(organization)
        .setConstraint(constraint)
        .build();
  }

  public static String format(String project, String constraint) {
    return newBuilder().setProject(project).setConstraint(constraint).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectConstraintName(String project, String constraint) {
    return newBuilder().setProject(project).setConstraint(constraint).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatFolderConstraintName(String folder, String constraint) {
    return newFolderConstraintBuilder()
        .setFolder(folder)
        .setConstraint(constraint)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationConstraintName(String organization, String constraint) {
    return newOrganizationConstraintBuilder()
        .setOrganization(organization)
        .setConstraint(constraint)
        .build()
        .toString();
  }

  public static ConstraintName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_CONSTRAINT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_CONSTRAINT.match(formattedString);
      return ofProjectConstraintName(matchMap.get("project"), matchMap.get("constraint"));
    } else if (FOLDER_CONSTRAINT.matches(formattedString)) {
      Map<String, String> matchMap = FOLDER_CONSTRAINT.match(formattedString);
      return ofFolderConstraintName(matchMap.get("folder"), matchMap.get("constraint"));
    } else if (ORGANIZATION_CONSTRAINT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_CONSTRAINT.match(formattedString);
      return ofOrganizationConstraintName(matchMap.get("organization"), matchMap.get("constraint"));
    }
    throw new ValidationException("ConstraintName.parse: formattedString not in valid format");
  }

  public static List<ConstraintName> parseList(List<String> formattedStrings) {
    List<ConstraintName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConstraintName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConstraintName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_CONSTRAINT.matches(formattedString)
        || FOLDER_CONSTRAINT.matches(formattedString)
        || ORGANIZATION_CONSTRAINT.matches(formattedString);
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
          if (constraint != null) {
            fieldMapBuilder.put("constraint", constraint);
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
      ConstraintName that = ((ConstraintName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.constraint, that.constraint)
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
    h ^= Objects.hashCode(constraint);
    h *= 1000003;
    h ^= Objects.hashCode(folder);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for projects/{project}/constraints/{constraint}. */
  public static class Builder {
    private String project;
    private String constraint;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getConstraint() {
      return constraint;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setConstraint(String constraint) {
      this.constraint = constraint;
      return this;
    }

    private Builder(ConstraintName constraintName) {
      Preconditions.checkArgument(
          Objects.equals(constraintName.pathTemplate, PROJECT_CONSTRAINT),
          "toBuilder is only supported when ConstraintName has the pattern of projects/{project}/constraints/{constraint}");
      this.project = constraintName.project;
      this.constraint = constraintName.constraint;
    }

    public ConstraintName build() {
      return new ConstraintName(this);
    }
  }

  /** Builder for folders/{folder}/constraints/{constraint}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class FolderConstraintBuilder {
    private String folder;
    private String constraint;

    protected FolderConstraintBuilder() {}

    public String getFolder() {
      return folder;
    }

    public String getConstraint() {
      return constraint;
    }

    public FolderConstraintBuilder setFolder(String folder) {
      this.folder = folder;
      return this;
    }

    public FolderConstraintBuilder setConstraint(String constraint) {
      this.constraint = constraint;
      return this;
    }

    public ConstraintName build() {
      return new ConstraintName(this);
    }
  }

  /** Builder for organizations/{organization}/constraints/{constraint}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationConstraintBuilder {
    private String organization;
    private String constraint;

    protected OrganizationConstraintBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getConstraint() {
      return constraint;
    }

    public OrganizationConstraintBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationConstraintBuilder setConstraint(String constraint) {
      this.constraint = constraint;
      return this;
    }

    public ConstraintName build() {
      return new ConstraintName(this);
    }
  }
}
