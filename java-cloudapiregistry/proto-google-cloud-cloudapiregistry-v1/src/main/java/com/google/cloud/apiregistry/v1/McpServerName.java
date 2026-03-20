/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.apiregistry.v1;

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
public class McpServerName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}");
  private static final PathTemplate PROJECT_LOCATION_MCP_SERVER =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/mcpServers/{mcp_server}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String apiNamespace;
  private final String mcpServer;

  @Deprecated
  protected McpServerName() {
    project = null;
    location = null;
    apiNamespace = null;
    mcpServer = null;
  }

  private McpServerName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    apiNamespace = Preconditions.checkNotNull(builder.getApiNamespace());
    mcpServer = Preconditions.checkNotNull(builder.getMcpServer());
    pathTemplate = PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER;
  }

  private McpServerName(ProjectLocationMcpServerBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    mcpServer = Preconditions.checkNotNull(builder.getMcpServer());
    apiNamespace = null;
    pathTemplate = PROJECT_LOCATION_MCP_SERVER;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApiNamespace() {
    return apiNamespace;
  }

  public String getMcpServer() {
    return mcpServer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationApiNamespaceMcpServerBuilder() {
    return new Builder();
  }

  public static ProjectLocationMcpServerBuilder newProjectLocationMcpServerBuilder() {
    return new ProjectLocationMcpServerBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static McpServerName of(
      String project, String location, String apiNamespace, String mcpServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .build();
  }

  public static McpServerName ofProjectLocationApiNamespaceMcpServerName(
      String project, String location, String apiNamespace, String mcpServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .build();
  }

  public static McpServerName ofProjectLocationMcpServerName(
      String project, String location, String mcpServer) {
    return newProjectLocationMcpServerBuilder()
        .setProject(project)
        .setLocation(location)
        .setMcpServer(mcpServer)
        .build();
  }

  public static String format(
      String project, String location, String apiNamespace, String mcpServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .build()
        .toString();
  }

  public static String formatProjectLocationApiNamespaceMcpServerName(
      String project, String location, String apiNamespace, String mcpServer) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .build()
        .toString();
  }

  public static String formatProjectLocationMcpServerName(
      String project, String location, String mcpServer) {
    return newProjectLocationMcpServerBuilder()
        .setProject(project)
        .setLocation(location)
        .setMcpServer(mcpServer)
        .build()
        .toString();
  }

  public static McpServerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER.match(formattedString);
      return ofProjectLocationApiNamespaceMcpServerName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api_namespace"),
          matchMap.get("mcp_server"));
    } else if (PROJECT_LOCATION_MCP_SERVER.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_MCP_SERVER.match(formattedString);
      return ofProjectLocationMcpServerName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("mcp_server"));
    }
    throw new ValidationException("McpServerName.parse: formattedString not in valid format");
  }

  public static List<McpServerName> parseList(List<String> formattedStrings) {
    List<McpServerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<McpServerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (McpServerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER.matches(formattedString)
        || PROJECT_LOCATION_MCP_SERVER.matches(formattedString);
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
          if (apiNamespace != null) {
            fieldMapBuilder.put("api_namespace", apiNamespace);
          }
          if (mcpServer != null) {
            fieldMapBuilder.put("mcp_server", mcpServer);
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
      McpServerName that = ((McpServerName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.apiNamespace, that.apiNamespace)
          && Objects.equals(this.mcpServer, that.mcpServer);
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
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(apiNamespace);
    h *= 1000003;
    h ^= Objects.hashCode(mcpServer);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String apiNamespace;
    private String mcpServer;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApiNamespace() {
      return apiNamespace;
    }

    public String getMcpServer() {
      return mcpServer;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApiNamespace(String apiNamespace) {
      this.apiNamespace = apiNamespace;
      return this;
    }

    public Builder setMcpServer(String mcpServer) {
      this.mcpServer = mcpServer;
      return this;
    }

    private Builder(McpServerName mcpServerName) {
      Preconditions.checkArgument(
          Objects.equals(mcpServerName.pathTemplate, PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER),
          "toBuilder is only supported when McpServerName has the pattern of"
              + " projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}");
      this.project = mcpServerName.project;
      this.location = mcpServerName.location;
      this.apiNamespace = mcpServerName.apiNamespace;
      this.mcpServer = mcpServerName.mcpServer;
    }

    public McpServerName build() {
      return new McpServerName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/mcpServers/{mcp_server}. */
  public static class ProjectLocationMcpServerBuilder {
    private String project;
    private String location;
    private String mcpServer;

    protected ProjectLocationMcpServerBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMcpServer() {
      return mcpServer;
    }

    public ProjectLocationMcpServerBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationMcpServerBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationMcpServerBuilder setMcpServer(String mcpServer) {
      this.mcpServer = mcpServer;
      return this;
    }

    public McpServerName build() {
      return new McpServerName(this);
    }
  }
}
