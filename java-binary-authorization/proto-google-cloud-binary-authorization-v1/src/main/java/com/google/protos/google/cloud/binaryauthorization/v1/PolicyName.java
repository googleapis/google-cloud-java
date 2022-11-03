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

package com.google.protos.google.cloud.binaryauthorization.v1;

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
public class PolicyName implements ResourceName {
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/policy");
  private static final PathTemplate LOCATION =
      PathTemplate.createWithoutUrlEncoding("locations/{location}/policy");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;

  @Deprecated
  protected PolicyName() {
    project = null;
    location = null;
  }

  private PolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = null;
    pathTemplate = PROJECT;
  }

  private PolicyName(LocationBuilder builder) {
    location = Preconditions.checkNotNull(builder.getLocation());
    project = null;
    pathTemplate = LOCATION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static LocationBuilder newLocationBuilder() {
    return new LocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyName of(String project) {
    return newBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static PolicyName ofProjectName(String project) {
    return newBuilder().setProject(project).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static PolicyName ofLocationName(String location) {
    return newLocationBuilder().setLocation(location).build();
  }

  public static String format(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectName(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatLocationName(String location) {
    return newLocationBuilder().setLocation(location).build().toString();
  }

  public static PolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    } else if (LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = LOCATION.match(formattedString);
      return ofLocationName(matchMap.get("location"));
    }
    throw new ValidationException("PolicyName.parse: formattedString not in valid format");
  }

  public static List<PolicyName> parseList(List<String> formattedStrings) {
    List<PolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT.matches(formattedString) || LOCATION.matches(formattedString);
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
      PolicyName that = ((PolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location);
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
    return h;
  }

  /** Builder for projects/{project}/policy. */
  public static class Builder {
    private String project;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(PolicyName policyName) {
      Preconditions.checkArgument(
          Objects.equals(policyName.pathTemplate, PROJECT),
          "toBuilder is only supported when PolicyName has the pattern of projects/{project}/policy");
      this.project = policyName.project;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }

  /** Builder for locations/{location}/policy. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class LocationBuilder {
    private String location;

    protected LocationBuilder() {}

    public String getLocation() {
      return location;
    }

    public LocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }
}
