/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.advisorynotifications.v1;

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
public class NotificationName implements ResourceName {
  private static final PathTemplate ORGANIZATION_LOCATION_NOTIFICATION =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/locations/{location}/notifications/{notification}");
  private static final PathTemplate PROJECT_LOCATION_NOTIFICATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/notifications/{notification}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String organization;
  private final String location;
  private final String notification;
  private final String project;

  @Deprecated
  protected NotificationName() {
    organization = null;
    location = null;
    notification = null;
    project = null;
  }

  private NotificationName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    location = Preconditions.checkNotNull(builder.getLocation());
    notification = Preconditions.checkNotNull(builder.getNotification());
    project = null;
    pathTemplate = ORGANIZATION_LOCATION_NOTIFICATION;
  }

  private NotificationName(ProjectLocationNotificationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    notification = Preconditions.checkNotNull(builder.getNotification());
    organization = null;
    pathTemplate = PROJECT_LOCATION_NOTIFICATION;
  }

  public String getOrganization() {
    return organization;
  }

  public String getLocation() {
    return location;
  }

  public String getNotification() {
    return notification;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newOrganizationLocationNotificationBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationNotificationBuilder newProjectLocationNotificationBuilder() {
    return new ProjectLocationNotificationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationName of(String organization, String location, String notification) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotification(notification)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationName ofOrganizationLocationNotificationName(
      String organization, String location, String notification) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotification(notification)
        .build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static NotificationName ofProjectLocationNotificationName(
      String project, String location, String notification) {
    return newProjectLocationNotificationBuilder()
        .setProject(project)
        .setLocation(location)
        .setNotification(notification)
        .build();
  }

  public static String format(String organization, String location, String notification) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotification(notification)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationLocationNotificationName(
      String organization, String location, String notification) {
    return newBuilder()
        .setOrganization(organization)
        .setLocation(location)
        .setNotification(notification)
        .build()
        .toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationNotificationName(
      String project, String location, String notification) {
    return newProjectLocationNotificationBuilder()
        .setProject(project)
        .setLocation(location)
        .setNotification(notification)
        .build()
        .toString();
  }

  public static NotificationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (ORGANIZATION_LOCATION_NOTIFICATION.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_LOCATION_NOTIFICATION.match(formattedString);
      return ofOrganizationLocationNotificationName(
          matchMap.get("organization"), matchMap.get("location"), matchMap.get("notification"));
    } else if (PROJECT_LOCATION_NOTIFICATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_NOTIFICATION.match(formattedString);
      return ofProjectLocationNotificationName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("notification"));
    }
    throw new ValidationException("NotificationName.parse: formattedString not in valid format");
  }

  public static List<NotificationName> parseList(List<String> formattedStrings) {
    List<NotificationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_LOCATION_NOTIFICATION.matches(formattedString)
        || PROJECT_LOCATION_NOTIFICATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (notification != null) {
            fieldMapBuilder.put("notification", notification);
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
      NotificationName that = ((NotificationName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.notification, that.notification)
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
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(notification);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for organizations/{organization}/locations/{location}/notifications/{notification}. */
  public static class Builder {
    private String organization;
    private String location;
    private String notification;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getLocation() {
      return location;
    }

    public String getNotification() {
      return notification;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setNotification(String notification) {
      this.notification = notification;
      return this;
    }

    private Builder(NotificationName notificationName) {
      Preconditions.checkArgument(
          Objects.equals(notificationName.pathTemplate, ORGANIZATION_LOCATION_NOTIFICATION),
          "toBuilder is only supported when NotificationName has the pattern of organizations/{organization}/locations/{location}/notifications/{notification}");
      this.organization = notificationName.organization;
      this.location = notificationName.location;
      this.notification = notificationName.notification;
    }

    public NotificationName build() {
      return new NotificationName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/notifications/{notification}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationNotificationBuilder {
    private String project;
    private String location;
    private String notification;

    protected ProjectLocationNotificationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getNotification() {
      return notification;
    }

    public ProjectLocationNotificationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationNotificationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationNotificationBuilder setNotification(String notification) {
      this.notification = notification;
      return this;
    }

    public NotificationName build() {
      return new NotificationName(this);
    }
  }
}
