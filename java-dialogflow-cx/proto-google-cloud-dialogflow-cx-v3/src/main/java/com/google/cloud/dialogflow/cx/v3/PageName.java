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

package com.google.cloud.dialogflow.cx.v3;

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
public class PageName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AGENT_FLOW_PAGE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/pages/{page}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String agent;
  private final String flow;
  private final String page;

  @Deprecated
  protected PageName() {
    project = null;
    location = null;
    agent = null;
    flow = null;
    page = null;
  }

  private PageName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    agent = Preconditions.checkNotNull(builder.getAgent());
    flow = Preconditions.checkNotNull(builder.getFlow());
    page = Preconditions.checkNotNull(builder.getPage());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAgent() {
    return agent;
  }

  public String getFlow() {
    return flow;
  }

  public String getPage() {
    return page;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PageName of(
      String project, String location, String agent, String flow, String page) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setPage(page)
        .build();
  }

  public static String format(
      String project, String location, String agent, String flow, String page) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAgent(agent)
        .setFlow(flow)
        .setPage(page)
        .build()
        .toString();
  }

  public static PageName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AGENT_FLOW_PAGE.validatedMatch(
            formattedString, "PageName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("agent"),
        matchMap.get("flow"),
        matchMap.get("page"));
  }

  public static List<PageName> parseList(List<String> formattedStrings) {
    List<PageName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PageName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PageName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AGENT_FLOW_PAGE.matches(formattedString);
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
          if (agent != null) {
            fieldMapBuilder.put("agent", agent);
          }
          if (flow != null) {
            fieldMapBuilder.put("flow", flow);
          }
          if (page != null) {
            fieldMapBuilder.put("page", page);
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
    return PROJECT_LOCATION_AGENT_FLOW_PAGE.instantiate(
        "project", project, "location", location, "agent", agent, "flow", flow, "page", page);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PageName that = ((PageName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.agent, that.agent)
          && Objects.equals(this.flow, that.flow)
          && Objects.equals(this.page, that.page);
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
    h ^= Objects.hashCode(agent);
    h *= 1000003;
    h ^= Objects.hashCode(flow);
    h *= 1000003;
    h ^= Objects.hashCode(page);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/agents/{agent}/flows/{flow}/pages/{page}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String agent;
    private String flow;
    private String page;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAgent() {
      return agent;
    }

    public String getFlow() {
      return flow;
    }

    public String getPage() {
      return page;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAgent(String agent) {
      this.agent = agent;
      return this;
    }

    public Builder setFlow(String flow) {
      this.flow = flow;
      return this;
    }

    public Builder setPage(String page) {
      this.page = page;
      return this;
    }

    private Builder(PageName pageName) {
      project = pageName.project;
      location = pageName.location;
      agent = pageName.agent;
      flow = pageName.flow;
      page = pageName.page;
    }

    public PageName build() {
      return new PageName(this);
    }
  }
}
