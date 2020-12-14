/*
 * Copyright 2020 Google LLC
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

package io.grafeas.v1;

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
public class NoteName implements ResourceName {
  private static final PathTemplate PROJECT_NOTE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/notes/{note}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String note;

  @Deprecated
  protected NoteName() {
    project = null;
    note = null;
  }

  private NoteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    note = Preconditions.checkNotNull(builder.getNote());
  }

  public String getProject() {
    return project;
  }

  public String getNote() {
    return note;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NoteName of(String project, String note) {
    return newBuilder().setProject(project).setNote(note).build();
  }

  public static String format(String project, String note) {
    return newBuilder().setProject(project).setNote(note).build().toString();
  }

  public static NoteName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_NOTE.validatedMatch(
            formattedString, "NoteName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("note"));
  }

  public static List<NoteName> parseList(List<String> formattedStrings) {
    List<NoteName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NoteName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NoteName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_NOTE.matches(formattedString);
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
          if (note != null) {
            fieldMapBuilder.put("note", note);
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
    return PROJECT_NOTE.instantiate("project", project, "note", note);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      NoteName that = ((NoteName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.note, that.note);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(note);
    return h;
  }

  /** Builder for projects/{project}/notes/{note}. */
  public static class Builder {
    private String project;
    private String note;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getNote() {
      return note;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setNote(String note) {
      this.note = note;
      return this;
    }

    private Builder(NoteName noteName) {
      project = noteName.project;
      note = noteName.note;
    }

    public NoteName build() {
      return new NoteName(this);
    }
  }
}
