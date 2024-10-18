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

package com.google.cloud.networkmanagement.v1;

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
public class ConnectivityTestName implements ResourceName {
  private static final PathTemplate PROJECT_TEST =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/global/connectivityTests/{test}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String test;

  @Deprecated
  protected ConnectivityTestName() {
    project = null;
    test = null;
  }

  private ConnectivityTestName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    test = Preconditions.checkNotNull(builder.getTest());
  }

  public String getProject() {
    return project;
  }

  public String getTest() {
    return test;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConnectivityTestName of(String project, String test) {
    return newBuilder().setProject(project).setTest(test).build();
  }

  public static String format(String project, String test) {
    return newBuilder().setProject(project).setTest(test).build().toString();
  }

  public static ConnectivityTestName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TEST.validatedMatch(
            formattedString, "ConnectivityTestName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("test"));
  }

  public static List<ConnectivityTestName> parseList(List<String> formattedStrings) {
    List<ConnectivityTestName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConnectivityTestName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConnectivityTestName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TEST.matches(formattedString);
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
          if (test != null) {
            fieldMapBuilder.put("test", test);
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
    return PROJECT_TEST.instantiate("project", project, "test", test);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ConnectivityTestName that = ((ConnectivityTestName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.test, that.test);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(test);
    return h;
  }

  /** Builder for projects/{project}/locations/global/connectivityTests/{test}. */
  public static class Builder {
    private String project;
    private String test;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTest() {
      return test;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTest(String test) {
      this.test = test;
      return this;
    }

    private Builder(ConnectivityTestName connectivityTestName) {
      this.project = connectivityTestName.project;
      this.test = connectivityTestName.test;
    }

    public ConnectivityTestName build() {
      return new ConnectivityTestName(this);
    }
  }
}
