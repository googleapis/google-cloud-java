/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.monitoring.v3;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class AlertPolicyConditionName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/alertPolicies/{alert_policy}/conditions/{condition}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String alertPolicy;
  private final String condition;

  public String getProject() {
    return project;
  }

  public String getAlertPolicy() {
    return alertPolicy;
  }

  public String getCondition() {
    return condition;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private AlertPolicyConditionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    alertPolicy = Preconditions.checkNotNull(builder.getAlertPolicy());
    condition = Preconditions.checkNotNull(builder.getCondition());
  }

  public static AlertPolicyConditionName of(String project, String alertPolicy, String condition) {
    return newBuilder()
        .setProject(project)
        .setAlertPolicy(alertPolicy)
        .setCondition(condition)
        .build();
  }

  public static String format(String project, String alertPolicy, String condition) {
    return newBuilder()
        .setProject(project)
        .setAlertPolicy(alertPolicy)
        .setCondition(condition)
        .build()
        .toString();
  }

  public static AlertPolicyConditionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "AlertPolicyConditionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("alert_policy"), matchMap.get("condition"));
  }

  public static List<AlertPolicyConditionName> parseList(List<String> formattedStrings) {
    List<AlertPolicyConditionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AlertPolicyConditionName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (AlertPolicyConditionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("alertPolicy", alertPolicy);
          fieldMapBuilder.put("condition", condition);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "alert_policy", alertPolicy, "condition", condition);
  }

  /** Builder for AlertPolicyConditionName. */
  public static class Builder {

    private String project;
    private String alertPolicy;
    private String condition;

    public String getProject() {
      return project;
    }

    public String getAlertPolicy() {
      return alertPolicy;
    }

    public String getCondition() {
      return condition;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAlertPolicy(String alertPolicy) {
      this.alertPolicy = alertPolicy;
      return this;
    }

    public Builder setCondition(String condition) {
      this.condition = condition;
      return this;
    }

    private Builder() {}

    private Builder(AlertPolicyConditionName alertPolicyConditionName) {
      project = alertPolicyConditionName.project;
      alertPolicy = alertPolicyConditionName.alertPolicy;
      condition = alertPolicyConditionName.condition;
    }

    public AlertPolicyConditionName build() {
      return new AlertPolicyConditionName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof AlertPolicyConditionName) {
      AlertPolicyConditionName that = (AlertPolicyConditionName) o;
      return (this.project.equals(that.project))
          && (this.alertPolicy.equals(that.alertPolicy))
          && (this.condition.equals(that.condition));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= alertPolicy.hashCode();
    h *= 1000003;
    h ^= condition.hashCode();
    return h;
  }
}
