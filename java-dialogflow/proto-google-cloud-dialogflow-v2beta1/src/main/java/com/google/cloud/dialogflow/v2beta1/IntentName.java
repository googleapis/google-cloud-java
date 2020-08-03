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

package com.google.cloud.dialogflow.v2beta1;

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

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class IntentName implements ResourceName {

  @Deprecated
  protected IntentName() {}

  private static final PathTemplate PROJECT_INTENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/intents/{intent}");
  private static final PathTemplate PROJECT_LOCATION_INTENT_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/intents/{intent}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String intent;
  private String location;

  public String getProject() {
    return project;
  }

  public String getIntent() {
    return intent;
  }

  public String getLocation() {
    return location;
  }

  private IntentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    intent = Preconditions.checkNotNull(builder.getIntent());
    pathTemplate = PROJECT_INTENT_PATH_TEMPLATE;
  }

  private IntentName(ProjectLocationIntentBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    intent = Preconditions.checkNotNull(builder.getIntent());
    pathTemplate = PROJECT_LOCATION_INTENT_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectIntentBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationIntentBuilder newProjectLocationIntentBuilder() {
    return new ProjectLocationIntentBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static IntentName of(String project, String intent) {
    return newProjectIntentBuilder().setProject(project).setIntent(intent).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static IntentName ofProjectIntentName(String project, String intent) {
    return newProjectIntentBuilder().setProject(project).setIntent(intent).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static IntentName ofProjectLocationIntentName(
      String project, String location, String intent) {
    return newProjectLocationIntentBuilder()
        .setProject(project)
        .setLocation(location)
        .setIntent(intent)
        .build();
  }

  public static String format(String project, String intent) {
    return newBuilder().setProject(project).setIntent(intent).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectIntentName(String project, String intent) {
    return newBuilder().setProject(project).setIntent(intent).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationIntentName(
      String project, String location, String intent) {
    return newProjectLocationIntentBuilder()
        .setProject(project)
        .setLocation(location)
        .setIntent(intent)
        .build()
        .toString();
  }

  public static IntentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_INTENT_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_INTENT_PATH_TEMPLATE.match(formattedString);
      return ofProjectIntentName(matchMap.get("project"), matchMap.get("intent"));
    } else if (PROJECT_LOCATION_INTENT_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_INTENT_PATH_TEMPLATE.match(formattedString);
      return ofProjectLocationIntentName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("intent"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  public static List<IntentName> parseList(List<String> formattedStrings) {
    List<IntentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<IntentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (IntentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INTENT_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_LOCATION_INTENT_PATH_TEMPLATE.matches(formattedString);
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
          if (intent != null) {
            fieldMapBuilder.put("intent", intent);
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

  /** Builder for projects/{project}/agent/intents/{intent}. */
  public static class Builder {

    private String project;
    private String intent;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getIntent() {
      return intent;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setIntent(String intent) {
      this.intent = intent;
      return this;
    }

    private Builder(IntentName intentName) {
      Preconditions.checkArgument(
          intentName.pathTemplate == PROJECT_INTENT_PATH_TEMPLATE,
          "toBuilder is only supported when IntentName has the pattern of "
              + "projects/{project}/agent/intents/{intent}.");
      project = intentName.project;
      intent = intentName.intent;
    }

    public IntentName build() {
      return new IntentName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/agent/intents/{intent}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationIntentBuilder {

    private String project;
    private String location;
    private String intent;

    private ProjectLocationIntentBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getIntent() {
      return intent;
    }

    public ProjectLocationIntentBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationIntentBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationIntentBuilder setIntent(String intent) {
      this.intent = intent;
      return this;
    }

    public IntentName build() {
      return new IntentName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      IntentName that = (IntentName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.intent, that.intent))
          && (Objects.equals(this.location, that.location));
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
    h ^= Objects.hashCode(intent);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }
}
