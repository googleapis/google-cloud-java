/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.baremetalsolution.v2;

import com.google.api.pathtemplate.PathTemplate;
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
public class SshKeyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SSH_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sshKeys/{ssh_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String sshKey;

  @Deprecated
  protected SshKeyName() {
    project = null;
    location = null;
    sshKey = null;
  }

  private SshKeyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    sshKey = Preconditions.checkNotNull(builder.getSshKey());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSshKey() {
    return sshKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SshKeyName of(String project, String location, String sshKey) {
    return newBuilder().setProject(project).setLocation(location).setSshKey(sshKey).build();
  }

  public static String format(String project, String location, String sshKey) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSshKey(sshKey)
        .build()
        .toString();
  }

  public static SshKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SSH_KEY.validatedMatch(
            formattedString, "SshKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("ssh_key"));
  }

  public static List<SshKeyName> parseList(List<String> formattedStrings) {
    List<SshKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SshKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SshKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SSH_KEY.matches(formattedString);
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
          if (sshKey != null) {
            fieldMapBuilder.put("ssh_key", sshKey);
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
    return PROJECT_LOCATION_SSH_KEY.instantiate(
        "project", project, "location", location, "ssh_key", sshKey);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SshKeyName that = ((SshKeyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.sshKey, that.sshKey);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(sshKey);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sshKeys/{ssh_key}. */
  public static class Builder {
    private String project;
    private String location;
    private String sshKey;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSshKey() {
      return sshKey;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSshKey(String sshKey) {
      this.sshKey = sshKey;
      return this;
    }

    private Builder(SshKeyName sshKeyName) {
      this.project = sshKeyName.project;
      this.location = sshKeyName.location;
      this.sshKey = sshKeyName.sshKey;
    }

    public SshKeyName build() {
      return new SshKeyName(this);
    }
  }
}
