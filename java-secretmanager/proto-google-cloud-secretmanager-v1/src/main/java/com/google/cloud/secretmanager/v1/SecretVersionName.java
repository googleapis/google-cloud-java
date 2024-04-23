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
public class SecretVersionName implements ResourceName {
  private static final PathTemplate PROJECT_SECRET_SECRET_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/secrets/{secret}/versions/{secret_version}");
  private static final PathTemplate PROJECT_LOCATION_SECRET_SECRET_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/secrets/{secret}/versions/{secret_version}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String secret;
  private final String secretVersion;
  private final String location;

  @Deprecated
  protected SecretVersionName() {
    project = null;
    secret = null;
    secretVersion = null;
    location = null;
  }

  private SecretVersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    secret = Preconditions.checkNotNull(builder.getSecret());
    secretVersion = Preconditions.checkNotNull(builder.getSecretVersion());
    location = null;
    pathTemplate = PROJECT_SECRET_SECRET_VERSION;
  }

  private SecretVersionName(ProjectLocationSecretSecretVersionBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    secret = Preconditions.checkNotNull(builder.getSecret());
    secretVersion = Preconditions.checkNotNull(builder.getSecretVersion());
    pathTemplate = PROJECT_LOCATION_SECRET_SECRET_VERSION;
  }

  public String getProject() {
    return project;
  }

  public String getSecret() {
    return secret;
  }

  public String getSecretVersion() {
    return secretVersion;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectSecretSecretVersionBuilder() {
    return new Builder();
  }

  public static ProjectLocationSecretSecretVersionBuilder
      newProjectLocationSecretSecretVersionBuilder() {
    return new ProjectLocationSecretSecretVersionBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SecretVersionName of(String project, String secret, String secretVersion) {
    return newBuilder()
        .setProject(project)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build();
  }

  public static SecretVersionName ofProjectSecretSecretVersionName(
      String project, String secret, String secretVersion) {
    return newBuilder()
        .setProject(project)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build();
  }

  public static SecretVersionName ofProjectLocationSecretSecretVersionName(
      String project, String location, String secret, String secretVersion) {
    return newProjectLocationSecretSecretVersionBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build();
  }

  public static String format(String project, String secret, String secretVersion) {
    return newBuilder()
        .setProject(project)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build()
        .toString();
  }

  public static String formatProjectSecretSecretVersionName(
      String project, String secret, String secretVersion) {
    return newBuilder()
        .setProject(project)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build()
        .toString();
  }

  public static String formatProjectLocationSecretSecretVersionName(
      String project, String location, String secret, String secretVersion) {
    return newProjectLocationSecretSecretVersionBuilder()
        .setProject(project)
        .setLocation(location)
        .setSecret(secret)
        .setSecretVersion(secretVersion)
        .build()
        .toString();
  }

  public static SecretVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_SECRET_SECRET_VERSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_SECRET_SECRET_VERSION.match(formattedString);
      return ofProjectSecretSecretVersionName(
          matchMap.get("project"), matchMap.get("secret"), matchMap.get("secret_version"));
    } else if (PROJECT_LOCATION_SECRET_SECRET_VERSION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SECRET_SECRET_VERSION.match(formattedString);
      return ofProjectLocationSecretSecretVersionName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("secret"),
          matchMap.get("secret_version"));
    }
    throw new ValidationException("SecretVersionName.parse: formattedString not in valid format");
  }

  public static List<SecretVersionName> parseList(List<String> formattedStrings) {
    List<SecretVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SecretVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SecretVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SECRET_SECRET_VERSION.matches(formattedString)
        || PROJECT_LOCATION_SECRET_SECRET_VERSION.matches(formattedString);
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
          if (secretVersion != null) {
            fieldMapBuilder.put("secret_version", secretVersion);
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
      SecretVersionName that = ((SecretVersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.secret, that.secret)
          && Objects.equals(this.secretVersion, that.secretVersion)
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
    h ^= Objects.hashCode(secretVersion);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/secrets/{secret}/versions/{secret_version}. */
  public static class Builder {
    private String project;
    private String secret;
    private String secretVersion;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSecret() {
      return secret;
    }

    public String getSecretVersion() {
      return secretVersion;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

    public Builder setSecretVersion(String secretVersion) {
      this.secretVersion = secretVersion;
      return this;
    }

    private Builder(SecretVersionName secretVersionName) {
      Preconditions.checkArgument(
          Objects.equals(secretVersionName.pathTemplate, PROJECT_SECRET_SECRET_VERSION),
          "toBuilder is only supported when SecretVersionName has the pattern of projects/{project}/secrets/{secret}/versions/{secret_version}");
      this.project = secretVersionName.project;
      this.secret = secretVersionName.secret;
      this.secretVersion = secretVersionName.secretVersion;
    }

    public SecretVersionName build() {
      return new SecretVersionName(this);
    }
  }

  /**
   * Builder for projects/{project}/locations/{location}/secrets/{secret}/versions/{secret_version}.
   */
  public static class ProjectLocationSecretSecretVersionBuilder {
    private String project;
    private String location;
    private String secret;
    private String secretVersion;

    protected ProjectLocationSecretSecretVersionBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSecret() {
      return secret;
    }

    public String getSecretVersion() {
      return secretVersion;
    }

    public ProjectLocationSecretSecretVersionBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationSecretSecretVersionBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationSecretSecretVersionBuilder setSecret(String secret) {
      this.secret = secret;
      return this;
    }

    public ProjectLocationSecretSecretVersionBuilder setSecretVersion(String secretVersion) {
      this.secretVersion = secretVersion;
      return this;
    }

    public SecretVersionName build() {
      return new SecretVersionName(this);
    }
  }
}
