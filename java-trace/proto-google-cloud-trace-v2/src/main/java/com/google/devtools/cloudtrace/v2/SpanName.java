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

package com.google.devtools.cloudtrace.v2;

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
public class SpanName implements ResourceName {
  private static final PathTemplate PROJECT_TRACE_SPAN =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/traces/{trace}/spans/{span}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String trace;
  private final String span;

  @Deprecated
  protected SpanName() {
    project = null;
    trace = null;
    span = null;
  }

  private SpanName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    trace = Preconditions.checkNotNull(builder.getTrace());
    span = Preconditions.checkNotNull(builder.getSpan());
  }

  public String getProject() {
    return project;
  }

  public String getTrace() {
    return trace;
  }

  public String getSpan() {
    return span;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SpanName of(String project, String trace, String span) {
    return newBuilder().setProject(project).setTrace(trace).setSpan(span).build();
  }

  public static String format(String project, String trace, String span) {
    return newBuilder().setProject(project).setTrace(trace).setSpan(span).build().toString();
  }

  public static SpanName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TRACE_SPAN.validatedMatch(
            formattedString, "SpanName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("trace"), matchMap.get("span"));
  }

  public static List<SpanName> parseList(List<String> formattedStrings) {
    List<SpanName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SpanName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SpanName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TRACE_SPAN.matches(formattedString);
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
          if (trace != null) {
            fieldMapBuilder.put("trace", trace);
          }
          if (span != null) {
            fieldMapBuilder.put("span", span);
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
    return PROJECT_TRACE_SPAN.instantiate("project", project, "trace", trace, "span", span);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SpanName that = ((SpanName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.trace, that.trace)
          && Objects.equals(this.span, that.span);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(trace);
    h *= 1000003;
    h ^= Objects.hashCode(span);
    return h;
  }

  /** Builder for projects/{project}/traces/{trace}/spans/{span}. */
  public static class Builder {
    private String project;
    private String trace;
    private String span;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTrace() {
      return trace;
    }

    public String getSpan() {
      return span;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTrace(String trace) {
      this.trace = trace;
      return this;
    }

    public Builder setSpan(String span) {
      this.span = span;
      return this;
    }

    private Builder(SpanName spanName) {
      this.project = spanName.project;
      this.trace = spanName.trace;
      this.span = spanName.span;
    }

    public SpanName build() {
      return new SpanName(this);
    }
  }
}
