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

package com.google.cloud.ces.v1;

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
public class GuardrailName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APP_GUARDRAIL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apps/{app}/guardrails/{guardrail}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String app;
  private final String guardrail;

  @Deprecated
  protected GuardrailName() {
    project = null;
    location = null;
    app = null;
    guardrail = null;
  }

  private GuardrailName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    app = Preconditions.checkNotNull(builder.getApp());
    guardrail = Preconditions.checkNotNull(builder.getGuardrail());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApp() {
    return app;
  }

  public String getGuardrail() {
    return guardrail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GuardrailName of(String project, String location, String app, String guardrail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setGuardrail(guardrail)
        .build();
  }

  public static String format(String project, String location, String app, String guardrail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApp(app)
        .setGuardrail(guardrail)
        .build()
        .toString();
  }

  public static GuardrailName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APP_GUARDRAIL.validatedMatch(
            formattedString, "GuardrailName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("app"),
        matchMap.get("guardrail"));
  }

  public static List<GuardrailName> parseList(List<String> formattedStrings) {
    List<GuardrailName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GuardrailName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GuardrailName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APP_GUARDRAIL.matches(formattedString);
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
          if (app != null) {
            fieldMapBuilder.put("app", app);
          }
          if (guardrail != null) {
            fieldMapBuilder.put("guardrail", guardrail);
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
    return PROJECT_LOCATION_APP_GUARDRAIL.instantiate(
        "project", project, "location", location, "app", app, "guardrail", guardrail);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GuardrailName that = ((GuardrailName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.app, that.app)
          && Objects.equals(this.guardrail, that.guardrail);
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
    h ^= Objects.hashCode(app);
    h *= 1000003;
    h ^= Objects.hashCode(guardrail);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/apps/{app}/guardrails/{guardrail}. */
  public static class Builder {
    private String project;
    private String location;
    private String app;
    private String guardrail;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApp() {
      return app;
    }

    public String getGuardrail() {
      return guardrail;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApp(String app) {
      this.app = app;
      return this;
    }

    public Builder setGuardrail(String guardrail) {
      this.guardrail = guardrail;
      return this;
    }

    private Builder(GuardrailName guardrailName) {
      this.project = guardrailName.project;
      this.location = guardrailName.location;
      this.app = guardrailName.app;
      this.guardrail = guardrailName.guardrail;
    }

    public GuardrailName build() {
      return new GuardrailName(this);
    }
  }
}
