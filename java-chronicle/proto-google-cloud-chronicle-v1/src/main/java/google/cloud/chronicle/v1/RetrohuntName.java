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

package google.cloud.chronicle.v1;

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
public class RetrohuntName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_INSTANCE_RULE_RETROHUNT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/retrohunts/{retrohunt}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String instance;
  private final String rule;
  private final String retrohunt;

  @Deprecated
  protected RetrohuntName() {
    project = null;
    location = null;
    instance = null;
    rule = null;
    retrohunt = null;
  }

  private RetrohuntName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    instance = Preconditions.checkNotNull(builder.getInstance());
    rule = Preconditions.checkNotNull(builder.getRule());
    retrohunt = Preconditions.checkNotNull(builder.getRetrohunt());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getInstance() {
    return instance;
  }

  public String getRule() {
    return rule;
  }

  public String getRetrohunt() {
    return retrohunt;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RetrohuntName of(
      String project, String location, String instance, String rule, String retrohunt) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setRule(rule)
        .setRetrohunt(retrohunt)
        .build();
  }

  public static String format(
      String project, String location, String instance, String rule, String retrohunt) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setInstance(instance)
        .setRule(rule)
        .setRetrohunt(retrohunt)
        .build()
        .toString();
  }

  public static RetrohuntName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_INSTANCE_RULE_RETROHUNT.validatedMatch(
            formattedString, "RetrohuntName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("instance"),
        matchMap.get("rule"),
        matchMap.get("retrohunt"));
  }

  public static List<RetrohuntName> parseList(List<String> formattedStrings) {
    List<RetrohuntName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RetrohuntName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RetrohuntName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_INSTANCE_RULE_RETROHUNT.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (rule != null) {
            fieldMapBuilder.put("rule", rule);
          }
          if (retrohunt != null) {
            fieldMapBuilder.put("retrohunt", retrohunt);
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
    return PROJECT_LOCATION_INSTANCE_RULE_RETROHUNT.instantiate(
        "project",
        project,
        "location",
        location,
        "instance",
        instance,
        "rule",
        rule,
        "retrohunt",
        retrohunt);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RetrohuntName that = ((RetrohuntName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.rule, that.rule)
          && Objects.equals(this.retrohunt, that.retrohunt);
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
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(rule);
    h *= 1000003;
    h ^= Objects.hashCode(retrohunt);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/instances/{instance}/rules/{rule}/retrohunts/{retrohunt}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String instance;
    private String rule;
    private String retrohunt;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getInstance() {
      return instance;
    }

    public String getRule() {
      return rule;
    }

    public String getRetrohunt() {
      return retrohunt;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setRule(String rule) {
      this.rule = rule;
      return this;
    }

    public Builder setRetrohunt(String retrohunt) {
      this.retrohunt = retrohunt;
      return this;
    }

    private Builder(RetrohuntName retrohuntName) {
      this.project = retrohuntName.project;
      this.location = retrohuntName.location;
      this.instance = retrohuntName.instance;
      this.rule = retrohuntName.rule;
      this.retrohunt = retrohuntName.retrohunt;
    }

    public RetrohuntName build() {
      return new RetrohuntName(this);
    }
  }
}
