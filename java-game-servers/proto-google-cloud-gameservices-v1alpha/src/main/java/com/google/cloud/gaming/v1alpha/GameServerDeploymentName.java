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

package com.google.cloud.gaming.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class GameServerDeploymentName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/gameServerDeployments/{game_server_deployment}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String gameServerDeployment;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getGameServerDeployment() {
    return gameServerDeployment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private GameServerDeploymentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    gameServerDeployment = Preconditions.checkNotNull(builder.getGameServerDeployment());
  }

  public static GameServerDeploymentName of(
      String project, String location, String gameServerDeployment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGameServerDeployment(gameServerDeployment)
        .build();
  }

  public static String format(String project, String location, String gameServerDeployment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setGameServerDeployment(gameServerDeployment)
        .build()
        .toString();
  }

  public static GameServerDeploymentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "GameServerDeploymentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("location"), matchMap.get("game_server_deployment"));
  }

  public static List<GameServerDeploymentName> parseList(List<String> formattedStrings) {
    List<GameServerDeploymentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GameServerDeploymentName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (GameServerDeploymentName value : values) {
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
          fieldMapBuilder.put("location", location);
          fieldMapBuilder.put("gameServerDeployment", gameServerDeployment);
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
    return PATH_TEMPLATE.instantiate(
        "project", project, "location", location, "game_server_deployment", gameServerDeployment);
  }

  /** Builder for GameServerDeploymentName. */
  public static class Builder {

    private String project;
    private String location;
    private String gameServerDeployment;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getGameServerDeployment() {
      return gameServerDeployment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setGameServerDeployment(String gameServerDeployment) {
      this.gameServerDeployment = gameServerDeployment;
      return this;
    }

    private Builder() {}

    private Builder(GameServerDeploymentName gameServerDeploymentName) {
      project = gameServerDeploymentName.project;
      location = gameServerDeploymentName.location;
      gameServerDeployment = gameServerDeploymentName.gameServerDeployment;
    }

    public GameServerDeploymentName build() {
      return new GameServerDeploymentName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GameServerDeploymentName) {
      GameServerDeploymentName that = (GameServerDeploymentName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.gameServerDeployment.equals(that.gameServerDeployment));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= location.hashCode();
    h *= 1000003;
    h ^= gameServerDeployment.hashCode();
    return h;
  }
}
