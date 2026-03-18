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

package com.google.cloud.networkconnectivity.v1beta;

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
public class RemoteTransportProfileName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REMOTE_TRANSPORT_PROFILE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/remoteTransportProfiles/{remote_transport_profile}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String remoteTransportProfile;

  @Deprecated
  protected RemoteTransportProfileName() {
    project = null;
    location = null;
    remoteTransportProfile = null;
  }

  private RemoteTransportProfileName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    remoteTransportProfile = Preconditions.checkNotNull(builder.getRemoteTransportProfile());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRemoteTransportProfile() {
    return remoteTransportProfile;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RemoteTransportProfileName of(
      String project, String location, String remoteTransportProfile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRemoteTransportProfile(remoteTransportProfile)
        .build();
  }

  public static String format(String project, String location, String remoteTransportProfile) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRemoteTransportProfile(remoteTransportProfile)
        .build()
        .toString();
  }

  public static RemoteTransportProfileName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REMOTE_TRANSPORT_PROFILE.validatedMatch(
            formattedString,
            "RemoteTransportProfileName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("remote_transport_profile"));
  }

  public static List<RemoteTransportProfileName> parseList(List<String> formattedStrings) {
    List<RemoteTransportProfileName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RemoteTransportProfileName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RemoteTransportProfileName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REMOTE_TRANSPORT_PROFILE.matches(formattedString);
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
          if (remoteTransportProfile != null) {
            fieldMapBuilder.put("remote_transport_profile", remoteTransportProfile);
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
    return PROJECT_LOCATION_REMOTE_TRANSPORT_PROFILE.instantiate(
        "project",
        project,
        "location",
        location,
        "remote_transport_profile",
        remoteTransportProfile);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RemoteTransportProfileName that = ((RemoteTransportProfileName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.remoteTransportProfile, that.remoteTransportProfile);
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
    h ^= Objects.hashCode(remoteTransportProfile);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/remoteTransportProfiles/{remote_transport_profile}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String remoteTransportProfile;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRemoteTransportProfile() {
      return remoteTransportProfile;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRemoteTransportProfile(String remoteTransportProfile) {
      this.remoteTransportProfile = remoteTransportProfile;
      return this;
    }

    private Builder(RemoteTransportProfileName remoteTransportProfileName) {
      this.project = remoteTransportProfileName.project;
      this.location = remoteTransportProfileName.location;
      this.remoteTransportProfile = remoteTransportProfileName.remoteTransportProfile;
    }

    public RemoteTransportProfileName build() {
      return new RemoteTransportProfileName(this);
    }
  }
}
