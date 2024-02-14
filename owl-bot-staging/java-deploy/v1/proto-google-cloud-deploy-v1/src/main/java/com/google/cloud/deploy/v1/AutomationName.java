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

package com.google.cloud.deploy.v1;

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
public class AutomationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automations/{automation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String deliveryPipeline;
  private final String automation;

  @Deprecated
  protected AutomationName() {
    project = null;
    location = null;
    deliveryPipeline = null;
    automation = null;
  }

  private AutomationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deliveryPipeline = Preconditions.checkNotNull(builder.getDeliveryPipeline());
    automation = Preconditions.checkNotNull(builder.getAutomation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDeliveryPipeline() {
    return deliveryPipeline;
  }

  public String getAutomation() {
    return automation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutomationName of(
      String project, String location, String deliveryPipeline, String automation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setAutomation(automation)
        .build();
  }

  public static String format(
      String project, String location, String deliveryPipeline, String automation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setAutomation(automation)
        .build()
        .toString();
  }

  public static AutomationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION.validatedMatch(
            formattedString, "AutomationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("delivery_pipeline"),
        matchMap.get("automation"));
  }

  public static List<AutomationName> parseList(List<String> formattedStrings) {
    List<AutomationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutomationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutomationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION.matches(formattedString);
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
          if (deliveryPipeline != null) {
            fieldMapBuilder.put("delivery_pipeline", deliveryPipeline);
          }
          if (automation != null) {
            fieldMapBuilder.put("automation", automation);
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
    return PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION.instantiate(
        "project",
        project,
        "location",
        location,
        "delivery_pipeline",
        deliveryPipeline,
        "automation",
        automation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutomationName that = ((AutomationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.deliveryPipeline, that.deliveryPipeline)
          && Objects.equals(this.automation, that.automation);
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
    h ^= Objects.hashCode(deliveryPipeline);
    h *= 1000003;
    h ^= Objects.hashCode(automation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automations/{automation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String deliveryPipeline;
    private String automation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDeliveryPipeline() {
      return deliveryPipeline;
    }

    public String getAutomation() {
      return automation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDeliveryPipeline(String deliveryPipeline) {
      this.deliveryPipeline = deliveryPipeline;
      return this;
    }

    public Builder setAutomation(String automation) {
      this.automation = automation;
      return this;
    }

    private Builder(AutomationName automationName) {
      this.project = automationName.project;
      this.location = automationName.location;
      this.deliveryPipeline = automationName.deliveryPipeline;
      this.automation = automationName.automation;
    }

    public AutomationName build() {
      return new AutomationName(this);
    }
  }
}
