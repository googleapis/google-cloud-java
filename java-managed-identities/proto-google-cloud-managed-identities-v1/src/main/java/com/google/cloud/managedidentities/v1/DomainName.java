/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.managedidentities.v1;

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
public class DomainName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_DOMAIN =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/domains/{domain}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String domain;

  @Deprecated
  protected DomainName() {
    project = null;
    location = null;
    domain = null;
  }

  private DomainName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    domain = Preconditions.checkNotNull(builder.getDomain());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getDomain() {
    return domain;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DomainName of(String project, String location, String domain) {
    return newBuilder().setProject(project).setLocation(location).setDomain(domain).build();
  }

  public static String format(String project, String location, String domain) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setDomain(domain)
        .build()
        .toString();
  }

  public static DomainName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_DOMAIN.validatedMatch(
            formattedString, "DomainName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("domain"));
  }

  public static List<DomainName> parseList(List<String> formattedStrings) {
    List<DomainName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DomainName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DomainName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_DOMAIN.matches(formattedString);
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
          if (domain != null) {
            fieldMapBuilder.put("domain", domain);
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
    return PROJECT_LOCATION_DOMAIN.instantiate(
        "project", project, "location", location, "domain", domain);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      DomainName that = ((DomainName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.domain, that.domain);
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
    h ^= Objects.hashCode(domain);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/domains/{domain}. */
  public static class Builder {
    private String project;
    private String location;
    private String domain;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getDomain() {
      return domain;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setDomain(String domain) {
      this.domain = domain;
      return this;
    }

    private Builder(DomainName domainName) {
      this.project = domainName.project;
      this.location = domainName.location;
      this.domain = domainName.domain;
    }

    public DomainName build() {
      return new DomainName(this);
    }
  }
}
