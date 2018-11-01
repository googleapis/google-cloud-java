/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dialogflow.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ContextName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/sessions/{session}/contexts/{context}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String session;
  private final String context;

  public String getProject() {
    return project;
  }

  public String getSession() {
    return session;
  }

  public String getContext() {
    return context;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ContextName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    session = Preconditions.checkNotNull(builder.getSession());
    context = Preconditions.checkNotNull(builder.getContext());
  }

  public static ContextName of(String project, String session, String context) {
    return newBuilder()
      .setProject(project)
      .setSession(session)
      .setContext(context)
      .build();
  }

  public static String format(String project, String session, String context) {
    return newBuilder()
      .setProject(project)
      .setSession(session)
      .setContext(context)
      .build()
      .toString();
  }

  public static ContextName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ContextName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("session"), matchMap.get("context"));
  }

  public static List<ContextName> parseList(List<String> formattedStrings) {
    List<ContextName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ContextName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ContextName value : values) {
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
          fieldMapBuilder.put("session", session);
          fieldMapBuilder.put("context", context);
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
    return PATH_TEMPLATE.instantiate("project", project, "session", session, "context", context);
  }

  /** Builder for ContextName. */
  public static class Builder {

    private String project;
    private String session;
    private String context;

    public String getProject() {
      return project;
    }

    public String getSession() {
      return session;
    }

    public String getContext() {
      return context;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSession(String session) {
      this.session = session;
      return this;
    }

    public Builder setContext(String context) {
      this.context = context;
      return this;
    }

    private Builder() {
    }

    private Builder(ContextName contextName) {
      project = contextName.project;
      session = contextName.session;
      context = contextName.context;
    }

    public ContextName build() {
      return new ContextName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContextName) {
      ContextName that = (ContextName) o;
      return (this.project.equals(that.project))
          && (this.session.equals(that.session))
          && (this.context.equals(that.context));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= session.hashCode();
    h *= 1000003;
    h ^= context.hashCode();
    return h;
  }
}

