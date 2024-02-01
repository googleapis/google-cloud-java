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
public class AutomationRunName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION_RUN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String deliveryPipeline;
  private final String automationRun;

  @Deprecated
  protected AutomationRunName() {
    project = null;
    location = null;
    deliveryPipeline = null;
    automationRun = null;
  }

  private AutomationRunName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    deliveryPipeline = Preconditions.checkNotNull(builder.getDeliveryPipeline());
    automationRun = Preconditions.checkNotNull(builder.getAutomationRun());
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

  public String getAutomationRun() {
    return automationRun;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AutomationRunName of(
      String project, String location, String deliveryPipeline, String automationRun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setAutomationRun(automationRun)
        .build();
  }

  public static String format(
      String project, String location, String deliveryPipeline, String automationRun) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDeliveryPipeline(deliveryPipeline)
        .setAutomationRun(automationRun)
        .build()
        .toString();
  }

  public static AutomationRunName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION_RUN.validatedMatch(
            formattedString, "AutomationRunName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("delivery_pipeline"),
        matchMap.get("automation_run"));
  }

  public static List<AutomationRunName> parseList(List<String> formattedStrings) {
    List<AutomationRunName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AutomationRunName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AutomationRunName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION_RUN.matches(formattedString);
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
          if (automationRun != null) {
            fieldMapBuilder.put("automation_run", automationRun);
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
    return PROJECT_LOCATION_DELIVERY_PIPELINE_AUTOMATION_RUN.instantiate(
        "project",
        project,
        "location",
        location,
        "delivery_pipeline",
        deliveryPipeline,
        "automation_run",
        automationRun);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AutomationRunName that = ((AutomationRunName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.deliveryPipeline, that.deliveryPipeline)
          && Objects.equals(this.automationRun, that.automationRun);
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
    h ^= Objects.hashCode(automationRun);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/deliveryPipelines/{delivery_pipeline}/automationRuns/{automation_run}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String deliveryPipeline;
    private String automationRun;

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

    public String getAutomationRun() {
      return automationRun;
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

    public Builder setAutomationRun(String automationRun) {
      this.automationRun = automationRun;
      return this;
    }

    private Builder(AutomationRunName automationRunName) {
      this.project = automationRunName.project;
      this.location = automationRunName.location;
      this.deliveryPipeline = automationRunName.deliveryPipeline;
      this.automationRun = automationRunName.automationRun;
    }

    public AutomationRunName build() {
      return new AutomationRunName(this);
    }
  }
}
