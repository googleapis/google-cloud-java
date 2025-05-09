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
public class PhoneNumberName implements ResourceName {
  private static final PathTemplate PROJECT_PHONE_NUMBER =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/phoneNumbers/{phone_number}");
  private static final PathTemplate PROJECT_LOCATION_PHONE_NUMBER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/phoneNumbers/{phone_number}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String phoneNumber;
  private final String location;

  @Deprecated
  protected PhoneNumberName() {
    project = null;
    phoneNumber = null;
    location = null;
  }

  private PhoneNumberName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    phoneNumber = Preconditions.checkNotNull(builder.getPhoneNumber());
    location = null;
    pathTemplate = PROJECT_PHONE_NUMBER;
  }

  private PhoneNumberName(ProjectLocationPhoneNumberBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    phoneNumber = Preconditions.checkNotNull(builder.getPhoneNumber());
    pathTemplate = PROJECT_LOCATION_PHONE_NUMBER;
  }

  public String getProject() {
    return project;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectPhoneNumberBuilder() {
    return new Builder();
  }

  public static ProjectLocationPhoneNumberBuilder newProjectLocationPhoneNumberBuilder() {
    return new ProjectLocationPhoneNumberBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PhoneNumberName of(String project, String phoneNumber) {
    return newBuilder().setProject(project).setPhoneNumber(phoneNumber).build();
  }

  public static PhoneNumberName ofProjectPhoneNumberName(String project, String phoneNumber) {
    return newBuilder().setProject(project).setPhoneNumber(phoneNumber).build();
  }

  public static PhoneNumberName ofProjectLocationPhoneNumberName(
      String project, String location, String phoneNumber) {
    return newProjectLocationPhoneNumberBuilder()
        .setProject(project)
        .setLocation(location)
        .setPhoneNumber(phoneNumber)
        .build();
  }

  public static String format(String project, String phoneNumber) {
    return newBuilder().setProject(project).setPhoneNumber(phoneNumber).build().toString();
  }

  public static String formatProjectPhoneNumberName(String project, String phoneNumber) {
    return newBuilder().setProject(project).setPhoneNumber(phoneNumber).build().toString();
  }

  public static String formatProjectLocationPhoneNumberName(
      String project, String location, String phoneNumber) {
    return newProjectLocationPhoneNumberBuilder()
        .setProject(project)
        .setLocation(location)
        .setPhoneNumber(phoneNumber)
        .build()
        .toString();
  }

  public static PhoneNumberName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_PHONE_NUMBER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_PHONE_NUMBER.match(formattedString);
      return ofProjectPhoneNumberName(matchMap.get("project"), matchMap.get("phone_number"));
    } else if (PROJECT_LOCATION_PHONE_NUMBER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_PHONE_NUMBER.match(formattedString);
      return ofProjectLocationPhoneNumberName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("phone_number"));
    }
    throw new ValidationException("PhoneNumberName.parse: formattedString not in valid format");
  }

  public static List<PhoneNumberName> parseList(List<String> formattedStrings) {
    List<PhoneNumberName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PhoneNumberName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PhoneNumberName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_PHONE_NUMBER.matches(formattedString)
        || PROJECT_LOCATION_PHONE_NUMBER.matches(formattedString);
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
          if (phoneNumber != null) {
            fieldMapBuilder.put("phone_number", phoneNumber);
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
    if (o != null && getClass() == o.getClass()) {
      PhoneNumberName that = ((PhoneNumberName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.phoneNumber, that.phoneNumber)
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
    h ^= Objects.hashCode(phoneNumber);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/phoneNumbers/{phone_number}. */
  public static class Builder {
    private String project;
    private String phoneNumber;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    private Builder(PhoneNumberName phoneNumberName) {
      Preconditions.checkArgument(
          Objects.equals(phoneNumberName.pathTemplate, PROJECT_PHONE_NUMBER),
          "toBuilder is only supported when PhoneNumberName has the pattern of"
              + " projects/{project}/phoneNumbers/{phone_number}");
      this.project = phoneNumberName.project;
      this.phoneNumber = phoneNumberName.phoneNumber;
    }

    public PhoneNumberName build() {
      return new PhoneNumberName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/phoneNumbers/{phone_number}. */
  public static class ProjectLocationPhoneNumberBuilder {
    private String project;
    private String location;
    private String phoneNumber;

    protected ProjectLocationPhoneNumberBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getPhoneNumber() {
      return phoneNumber;
    }

    public ProjectLocationPhoneNumberBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationPhoneNumberBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationPhoneNumberBuilder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public PhoneNumberName build() {
      return new PhoneNumberName(this);
    }
  }
}
