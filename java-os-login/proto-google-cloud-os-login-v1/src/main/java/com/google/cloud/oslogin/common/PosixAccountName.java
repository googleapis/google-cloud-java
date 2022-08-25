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

package com.google.cloud.oslogin.common;

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
public class PosixAccountName implements ResourceName {
  private static final PathTemplate USER_PROJECT =
      PathTemplate.createWithoutUrlEncoding("users/{user}/projects/{project}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String project;

  @Deprecated
  protected PosixAccountName() {
    user = null;
    project = null;
  }

  private PosixAccountName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public String getUser() {
    return user;
  }

  public String getProject() {
    return project;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PosixAccountName of(String user, String project) {
    return newBuilder().setUser(user).setProject(project).build();
  }

  public static String format(String user, String project) {
    return newBuilder().setUser(user).setProject(project).build().toString();
  }

  public static PosixAccountName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_PROJECT.validatedMatch(
            formattedString, "PosixAccountName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("project"));
  }

  public static List<PosixAccountName> parseList(List<String> formattedStrings) {
    List<PosixAccountName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PosixAccountName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PosixAccountName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_PROJECT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (project != null) {
            fieldMapBuilder.put("project", project);
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
    return USER_PROJECT.instantiate("user", user, "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PosixAccountName that = ((PosixAccountName) o);
      return Objects.equals(this.user, that.user) && Objects.equals(this.project, that.project);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    return h;
  }

  /** Builder for users/{user}/projects/{project}. */
  public static class Builder {
    private String user;
    private String project;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getProject() {
      return project;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(PosixAccountName posixAccountName) {
      this.user = posixAccountName.user;
      this.project = posixAccountName.project;
    }

    public PosixAccountName build() {
      return new PosixAccountName(this);
    }
  }
}
