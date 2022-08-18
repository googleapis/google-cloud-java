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

package com.google.cloud.binaryauthorization.v1beta1;

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
public class AttestorName implements ResourceName {
  private static final PathTemplate PROJECT_ATTESTOR =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/attestors/{attestor}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String attestor;

  @Deprecated
  protected AttestorName() {
    project = null;
    attestor = null;
  }

  private AttestorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    attestor = Preconditions.checkNotNull(builder.getAttestor());
  }

  public String getProject() {
    return project;
  }

  public String getAttestor() {
    return attestor;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AttestorName of(String project, String attestor) {
    return newBuilder().setProject(project).setAttestor(attestor).build();
  }

  public static String format(String project, String attestor) {
    return newBuilder().setProject(project).setAttestor(attestor).build().toString();
  }

  public static AttestorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_ATTESTOR.validatedMatch(
            formattedString, "AttestorName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("attestor"));
  }

  public static List<AttestorName> parseList(List<String> formattedStrings) {
    List<AttestorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AttestorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AttestorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_ATTESTOR.matches(formattedString);
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
          if (attestor != null) {
            fieldMapBuilder.put("attestor", attestor);
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
    return PROJECT_ATTESTOR.instantiate("project", project, "attestor", attestor);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AttestorName that = ((AttestorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.attestor, that.attestor);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(attestor);
    return h;
  }

  /** Builder for projects/{project}/attestors/{attestor}. */
  public static class Builder {
    private String project;
    private String attestor;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getAttestor() {
      return attestor;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setAttestor(String attestor) {
      this.attestor = attestor;
      return this;
    }

    private Builder(AttestorName attestorName) {
      this.project = attestorName.project;
      this.attestor = attestorName.attestor;
    }

    public AttestorName build() {
      return new AttestorName(this);
    }
  }
}
