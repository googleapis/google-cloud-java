/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.devicestreaming.v1;

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
public class DeviceSessionName implements ResourceName {
  private static final PathTemplate PROJECT_DEVICE_SESSION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/deviceSessions/{device_session}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String deviceSession;

  @Deprecated
  protected DeviceSessionName() {
    project = null;
    deviceSession = null;
  }

  private DeviceSessionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    deviceSession = Preconditions.checkNotNull(builder.getDeviceSession());
  }

  public String getProject() {
    return project;
  }

  public String getDeviceSession() {
    return deviceSession;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeviceSessionName of(String project, String deviceSession) {
    return newBuilder().setProject(project).setDeviceSession(deviceSession).build();
  }

  public static String format(String project, String deviceSession) {
    return newBuilder().setProject(project).setDeviceSession(deviceSession).build().toString();
  }

  public static DeviceSessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_DEVICE_SESSION.validatedMatch(
            formattedString, "DeviceSessionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("device_session"));
  }

  public static List<DeviceSessionName> parseList(List<String> formattedStrings) {
    List<DeviceSessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeviceSessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeviceSessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_DEVICE_SESSION.matches(formattedString);
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
          if (deviceSession != null) {
            fieldMapBuilder.put("device_session", deviceSession);
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
    return PROJECT_DEVICE_SESSION.instantiate("project", project, "device_session", deviceSession);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DeviceSessionName that = ((DeviceSessionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.deviceSession, that.deviceSession);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(deviceSession);
    return h;
  }

  /** Builder for projects/{project}/deviceSessions/{device_session}. */
  public static class Builder {
    private String project;
    private String deviceSession;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getDeviceSession() {
      return deviceSession;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setDeviceSession(String deviceSession) {
      this.deviceSession = deviceSession;
      return this;
    }

    private Builder(DeviceSessionName deviceSessionName) {
      this.project = deviceSessionName.project;
      this.deviceSession = deviceSessionName.deviceSession;
    }

    public DeviceSessionName build() {
      return new DeviceSessionName(this);
    }
  }
}
