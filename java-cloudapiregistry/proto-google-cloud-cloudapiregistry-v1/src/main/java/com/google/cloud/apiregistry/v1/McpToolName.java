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
public class McpToolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}");
  private static final PathTemplate PROJECT_LOCATION_MCP_SERVER_MCP_TOOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String apiNamespace;
  private final String mcpServer;
  private final String mcpTool;

  @Deprecated
  protected McpToolName() {
    project = null;
    location = null;
    apiNamespace = null;
    mcpServer = null;
    mcpTool = null;
  }

  private McpToolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    apiNamespace = Preconditions.checkNotNull(builder.getApiNamespace());
    mcpServer = Preconditions.checkNotNull(builder.getMcpServer());
    mcpTool = Preconditions.checkNotNull(builder.getMcpTool());
    pathTemplate = PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL;
  }

  private McpToolName(ProjectLocationMcpServerMcpToolBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    mcpServer = Preconditions.checkNotNull(builder.getMcpServer());
    mcpTool = Preconditions.checkNotNull(builder.getMcpTool());
    apiNamespace = null;
    pathTemplate = PROJECT_LOCATION_MCP_SERVER_MCP_TOOL;
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

  public String getMcpTool() {
    return mcpTool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationApiNamespaceMcpServerMcpToolBuilder() {
    return new Builder();
  }

  public static ProjectLocationMcpServerMcpToolBuilder newProjectLocationMcpServerMcpToolBuilder() {
    return new ProjectLocationMcpServerMcpToolBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static McpToolName of(
      String project, String location, String apiNamespace, String mcpServer, String mcpTool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build();
  }

  public static McpToolName ofProjectLocationApiNamespaceMcpServerMcpToolName(
      String project, String location, String apiNamespace, String mcpServer, String mcpTool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build();
  }

  public static McpToolName ofProjectLocationMcpServerMcpToolName(
      String project, String location, String mcpServer, String mcpTool) {
    return newProjectLocationMcpServerMcpToolBuilder()
        .setProject(project)
        .setLocation(location)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build();
  }

  public static String format(
      String project, String location, String apiNamespace, String mcpServer, String mcpTool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build()
        .toString();
  }

  public static String formatProjectLocationApiNamespaceMcpServerMcpToolName(
      String project, String location, String apiNamespace, String mcpServer, String mcpTool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApiNamespace(apiNamespace)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build()
        .toString();
  }

  public static String formatProjectLocationMcpServerMcpToolName(
      String project, String location, String mcpServer, String mcpTool) {
    return newProjectLocationMcpServerMcpToolBuilder()
        .setProject(project)
        .setLocation(location)
        .setMcpServer(mcpServer)
        .setMcpTool(mcpTool)
        .build()
        .toString();
  }

  public static McpToolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL.match(formattedString);
      return ofProjectLocationApiNamespaceMcpServerMcpToolName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("api_namespace"),
          matchMap.get("mcp_server"),
          matchMap.get("mcp_tool"));
    } else if (PROJECT_LOCATION_MCP_SERVER_MCP_TOOL.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_MCP_SERVER_MCP_TOOL.match(formattedString);
      return ofProjectLocationMcpServerMcpToolName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("mcp_server"),
          matchMap.get("mcp_tool"));
    }
    throw new ValidationException("McpToolName.parse: formattedString not in valid format");
  }

  public static List<McpToolName> parseList(List<String> formattedStrings) {
    List<McpToolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<McpToolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (McpToolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL.matches(formattedString)
        || PROJECT_LOCATION_MCP_SERVER_MCP_TOOL.matches(formattedString);
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
          if (mcpTool != null) {
            fieldMapBuilder.put("mcp_tool", mcpTool);
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
      McpToolName that = ((McpToolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.apiNamespace, that.apiNamespace)
          && Objects.equals(this.mcpServer, that.mcpServer)
          && Objects.equals(this.mcpTool, that.mcpTool);
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
    h *= 1000003;
    h ^= Objects.hashCode(mcpTool);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String apiNamespace;
    private String mcpServer;
    private String mcpTool;

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

    public String getMcpTool() {
      return mcpTool;
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

    public Builder setMcpTool(String mcpTool) {
      this.mcpTool = mcpTool;
      return this;
    }

    private Builder(McpToolName mcpToolName) {
      Preconditions.checkArgument(
          Objects.equals(
              mcpToolName.pathTemplate, PROJECT_LOCATION_API_NAMESPACE_MCP_SERVER_MCP_TOOL),
          "toBuilder is only supported when McpToolName has the pattern of"
              + " projects/{project}/locations/{location}/apiNamespaces/{api_namespace}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}");
      this.project = mcpToolName.project;
      this.location = mcpToolName.location;
      this.apiNamespace = mcpToolName.apiNamespace;
      this.mcpServer = mcpToolName.mcpServer;
      this.mcpTool = mcpToolName.mcpTool;
    }

    public McpToolName build() {
      return new McpToolName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/mcpServers/{mcp_server}/mcpTools/{mcp_tool}.
   */
  public static class ProjectLocationMcpServerMcpToolBuilder {
    private String project;
    private String location;
    private String mcpServer;
    private String mcpTool;

    protected ProjectLocationMcpServerMcpToolBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMcpServer() {
      return mcpServer;
    }

    public String getMcpTool() {
      return mcpTool;
    }

    public ProjectLocationMcpServerMcpToolBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationMcpServerMcpToolBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationMcpServerMcpToolBuilder setMcpServer(String mcpServer) {
      this.mcpServer = mcpServer;
      return this;
    }

    public ProjectLocationMcpServerMcpToolBuilder setMcpTool(String mcpTool) {
      this.mcpTool = mcpTool;
      return this;
    }

    public McpToolName build() {
      return new McpToolName(this);
    }
  }
}
