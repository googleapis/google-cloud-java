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

package com.google.cloud.secretmanager.v1;

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
public class SecretName implements ResourceName {
  private static final PathTemplate PROJECT_SECRET =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/secrets/{secret}");
  private static final PathTemplate PROJECT_LOCATION_SECRET =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/secrets/{secret}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String secret;
  private final String location;

  @Deprecated
  protected SecretName() {
    project = null;
    secret = null;
    location = null;
  }

  private SecretName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    secret = Preconditions.checkNotNull(builder.getSecret());
    location = null;
    pathTemplate = PROJECT_SECRET;
  }

  private SecretName(ProjectLocationSecretBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    secret = Preconditions.checkNotNull(builder.getSecret());
    pathTemplate = PROJECT_LOCATION_SECRET;
  }

  public String getProject() {
    return project;
  }

  public String getSecret() {
    return secret;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectSecretBuilder() {
    return new Builder();
  }

  public static ProjectLocationSecretBuilder newProjectLocationSecretBuilder() {
    return new ProjectLocationSecretBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecretName of(String project, String secret) {
    return newBuilder().setProject(project).setSecret(secret).build();
  }

  public static SecretName ofProjectSecretName(String project, String secret) {
    return newBuilder().setProject(project).setSecret(secret).build();
  }

  public static SecretName ofProjectLocationSecretName(
      String project, String location, String secret) {
    return newProjectLocationSecretBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecret(secret)
        .build();
  }

  public static String format(String project, String secret) {
    return newBuilder().setProject(project).setSecret(secret).build().toString();
  }

  public static String formatProjectSecretName(String project, String secret) {
    return newBuilder().setProject(project).setSecret(secret).build().toString();
  }

  public static String formatProjectLocationSecretName(
      String project, String location, String secret) {
    return newProjectLocationSecretBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecret(secret)
        .build()
        .toString();
  }

  public static SecretName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SECRET.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SECRET.match(formattedString);
      return ofProjectSecretName(matchMap.get("project"), matchMap.get("secret"));
    } else if (PROJECT_LOCATION_SECRET.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SECRET.match(formattedString);
      return ofProjectLocationSecretName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("secret"));
    }
    throw new ValidationException("SecretName.parse: formattedString not in valid format");
  }

  public static List<SecretName> parseList(List<String> formattedStrings) {
    List<SecretName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecretName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecretName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SECRET.matches(formattedString)
        || PROJECT_LOCATION_SECRET.matches(formattedString);
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
          if (secret != null) {
            fieldMapBuilder.put("secret", secret);
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
      SecretName that = ((SecretName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.secret, that.secret)
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
    h ^= Objects.hashCode(secret);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/secrets/{secret}. */
  public static class Builder {
    private String project;
    private String secret;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSecret() {
      return secret;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

    private Builder(SecretName secretName) {
      Preconditions.checkArgument(
          Objects.equals(secretName.pathTemplate, PROJECT_SECRET),
          "toBuilder is only supported when SecretName has the pattern of projects/{project}/secrets/{secret}");
      this.project = secretName.project;
      this.secret = secretName.secret;
    }

    public SecretName build() {
      return new SecretName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/secrets/{secret}. */
  public static class ProjectLocationSecretBuilder {
    private String project;
    private String location;
    private String secret;

    protected ProjectLocationSecretBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecret() {
      return secret;
    }

    public ProjectLocationSecretBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSecretBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSecretBuilder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

    public SecretName build() {
      return new SecretName(this);
    }
  }
}
