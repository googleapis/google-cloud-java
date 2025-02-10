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

package com.google.cloud.netapp.v1;

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
public class QuotaRuleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VOLUME_QUOTA_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/volumes/{volume}/quotaRules/{quota_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String volume;
  private final String quotaRule;

  @Deprecated
  protected QuotaRuleName() {
    project = null;
    location = null;
    volume = null;
    quotaRule = null;
  }

  private QuotaRuleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    volume = Preconditions.checkNotNull(builder.getVolume());
    quotaRule = Preconditions.checkNotNull(builder.getQuotaRule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getVolume() {
    return volume;
  }

  public String getQuotaRule() {
    return quotaRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static QuotaRuleName of(String project, String location, String volume, String quotaRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setQuotaRule(quotaRule)
        .build();
  }

  public static String format(String project, String location, String volume, String quotaRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVolume(volume)
        .setQuotaRule(quotaRule)
        .build()
        .toString();
  }

  public static QuotaRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VOLUME_QUOTA_RULE.validatedMatch(
            formattedString, "QuotaRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("volume"),
        matchMap.get("quota_rule"));
  }

  public static List<QuotaRuleName> parseList(List<String> formattedStrings) {
    List<QuotaRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<QuotaRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (QuotaRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VOLUME_QUOTA_RULE.matches(formattedString);
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
          if (volume != null) {
            fieldMapBuilder.put("volume", volume);
          }
          if (quotaRule != null) {
            fieldMapBuilder.put("quota_rule", quotaRule);
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
    return PROJECT_LOCATION_VOLUME_QUOTA_RULE.instantiate(
        "project", project, "location", location, "volume", volume, "quota_rule", quotaRule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      QuotaRuleName that = ((QuotaRuleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.volume, that.volume)
          && Objects.equals(this.quotaRule, that.quotaRule);
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
    h ^= Objects.hashCode(volume);
    h *= 1000003;
    h ^= Objects.hashCode(quotaRule);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/volumes/{volume}/quotaRules/{quota_rule}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String volume;
    private String quotaRule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getVolume() {
      return volume;
    }

    public String getQuotaRule() {
      return quotaRule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setVolume(String volume) {
      this.volume = volume;
      return this;
    }

    public Builder setQuotaRule(String quotaRule) {
      this.quotaRule = quotaRule;
      return this;
    }

    private Builder(QuotaRuleName quotaRuleName) {
      this.project = quotaRuleName.project;
      this.location = quotaRuleName.location;
      this.volume = quotaRuleName.volume;
      this.quotaRule = quotaRuleName.quotaRule;
    }

    public QuotaRuleName build() {
      return new QuotaRuleName(this);
    }
  }
}
