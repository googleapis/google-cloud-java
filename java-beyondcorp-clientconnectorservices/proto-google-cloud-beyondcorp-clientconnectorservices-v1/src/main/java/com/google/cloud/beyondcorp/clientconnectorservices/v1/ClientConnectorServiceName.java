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

package com.google.cloud.beyondcorp.clientconnectorservices.v1;

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
public class ClientConnectorServiceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLIENT_CONNECTOR_SERVICE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clientConnectorServices/{client_connector_service}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String clientConnectorService;

  @Deprecated
  protected ClientConnectorServiceName() {
    project = null;
    location = null;
    clientConnectorService = null;
  }

  private ClientConnectorServiceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    clientConnectorService = Preconditions.checkNotNull(builder.getClientConnectorService());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getClientConnectorService() {
    return clientConnectorService;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ClientConnectorServiceName of(
      String project, String location, String clientConnectorService) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setClientConnectorService(clientConnectorService)
        .build();
  }

  public static String format(String project, String location, String clientConnectorService) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setClientConnectorService(clientConnectorService)
        .build()
        .toString();
  }

  public static ClientConnectorServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLIENT_CONNECTOR_SERVICE.validatedMatch(
            formattedString,
            "ClientConnectorServiceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("client_connector_service"));
  }

  public static List<ClientConnectorServiceName> parseList(List<String> formattedStrings) {
    List<ClientConnectorServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ClientConnectorServiceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ClientConnectorServiceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLIENT_CONNECTOR_SERVICE.matches(formattedString);
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
          if (clientConnectorService != null) {
            fieldMapBuilder.put("client_connector_service", clientConnectorService);
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
    return PROJECT_LOCATION_CLIENT_CONNECTOR_SERVICE.instantiate(
        "project",
        project,
        "location",
        location,
        "client_connector_service",
        clientConnectorService);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ClientConnectorServiceName that = ((ClientConnectorServiceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.clientConnectorService, that.clientConnectorService);
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
    h ^= Objects.hashCode(clientConnectorService);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/clientConnectorServices/{client_connector_service}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String clientConnectorService;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getClientConnectorService() {
      return clientConnectorService;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setClientConnectorService(String clientConnectorService) {
      this.clientConnectorService = clientConnectorService;
      return this;
    }

    private Builder(ClientConnectorServiceName clientConnectorServiceName) {
      this.project = clientConnectorServiceName.project;
      this.location = clientConnectorServiceName.location;
      this.clientConnectorService = clientConnectorServiceName.clientConnectorService;
    }

    public ClientConnectorServiceName build() {
      return new ClientConnectorServiceName(this);
    }
  }
}
