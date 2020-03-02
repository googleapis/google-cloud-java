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

package io.grafeas.v1beta1.source;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class NoteName extends IamResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/notes/{note}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String note;

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

  private NoteName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    note = Preconditions.checkNotNull(builder.getNote());
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
        PATH_TEMPLATE.validatedMatch(
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
    List<String> list = new ArrayList<String>(values.size());
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
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("note", note);
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
    return PATH_TEMPLATE.instantiate("project", project, "note", note);
  }

  /** Builder for NoteName. */
  public static class Builder {

    private String project;
    private String note;

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

    private Builder() {}

    private Builder(NoteName noteName) {
      project = noteName.project;
      note = noteName.note;
    }

    public NoteName build() {
      return new NoteName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NoteName) {
      NoteName that = (NoteName) o;
      return (this.project.equals(that.project)) && (this.note.equals(that.note));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= note.hashCode();
    return h;
  }
}
