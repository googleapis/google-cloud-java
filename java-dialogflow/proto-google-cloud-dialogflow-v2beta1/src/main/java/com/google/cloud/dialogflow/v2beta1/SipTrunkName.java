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

package com.google.cloud.dialogflow.v2beta1;

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
public class SipTrunkName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SIPTRUNK =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sipTrunks/{siptrunk}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String siptrunk;

  @Deprecated
  protected SipTrunkName() {
    project = null;
    location = null;
    siptrunk = null;
  }

  private SipTrunkName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    siptrunk = Preconditions.checkNotNull(builder.getSiptrunk());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSiptrunk() {
    return siptrunk;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SipTrunkName of(String project, String location, String siptrunk) {
    return newBuilder().setProject(project).setLocation(location).setSiptrunk(siptrunk).build();
  }

  public static String format(String project, String location, String siptrunk) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSiptrunk(siptrunk)
        .build()
        .toString();
  }

  public static SipTrunkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SIPTRUNK.validatedMatch(
            formattedString, "SipTrunkName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("siptrunk"));
  }

  public static List<SipTrunkName> parseList(List<String> formattedStrings) {
    List<SipTrunkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SipTrunkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SipTrunkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SIPTRUNK.matches(formattedString);
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
          if (siptrunk != null) {
            fieldMapBuilder.put("siptrunk", siptrunk);
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
    return PROJECT_LOCATION_SIPTRUNK.instantiate(
        "project", project, "location", location, "siptrunk", siptrunk);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SipTrunkName that = ((SipTrunkName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.siptrunk, that.siptrunk);
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
    h ^= Objects.hashCode(siptrunk);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sipTrunks/{siptrunk}. */
  public static class Builder {
    private String project;
    private String location;
    private String siptrunk;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSiptrunk() {
      return siptrunk;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSiptrunk(String siptrunk) {
      this.siptrunk = siptrunk;
      return this;
    }

    private Builder(SipTrunkName sipTrunkName) {
      this.project = sipTrunkName.project;
      this.location = sipTrunkName.location;
      this.siptrunk = sipTrunkName.siptrunk;
    }

    public SipTrunkName build() {
      return new SipTrunkName(this);
    }
  }
}
