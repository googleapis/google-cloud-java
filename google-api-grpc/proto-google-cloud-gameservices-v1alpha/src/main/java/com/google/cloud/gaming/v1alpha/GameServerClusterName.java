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
public class GameServerClusterName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/realms/{realm}/gameServerClusters/{game_server_cluster}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String realm;
  private final String gameServerCluster;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRealm() {
    return realm;
  }

  public String getGameServerCluster() {
    return gameServerCluster;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private GameServerClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    realm = Preconditions.checkNotNull(builder.getRealm());
    gameServerCluster = Preconditions.checkNotNull(builder.getGameServerCluster());
  }

  public static GameServerClusterName of(
      String project, String location, String realm, String gameServerCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRealm(realm)
        .setGameServerCluster(gameServerCluster)
        .build();
  }

  public static String format(
      String project, String location, String realm, String gameServerCluster) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRealm(realm)
        .setGameServerCluster(gameServerCluster)
        .build()
        .toString();
  }

  public static GameServerClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "GameServerClusterName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("realm"),
        matchMap.get("game_server_cluster"));
  }

  public static List<GameServerClusterName> parseList(List<String> formattedStrings) {
    List<GameServerClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GameServerClusterName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (GameServerClusterName value : values) {
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
          fieldMapBuilder.put("realm", realm);
          fieldMapBuilder.put("gameServerCluster", gameServerCluster);
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
        "project",
        project,
        "location",
        location,
        "realm",
        realm,
        "game_server_cluster",
        gameServerCluster);
  }

  /** Builder for GameServerClusterName. */
  public static class Builder {

    private String project;
    private String location;
    private String realm;
    private String gameServerCluster;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRealm() {
      return realm;
    }

    public String getGameServerCluster() {
      return gameServerCluster;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRealm(String realm) {
      this.realm = realm;
      return this;
    }

    public Builder setGameServerCluster(String gameServerCluster) {
      this.gameServerCluster = gameServerCluster;
      return this;
    }

    private Builder() {}

    private Builder(GameServerClusterName gameServerClusterName) {
      project = gameServerClusterName.project;
      location = gameServerClusterName.location;
      realm = gameServerClusterName.realm;
      gameServerCluster = gameServerClusterName.gameServerCluster;
    }

    public GameServerClusterName build() {
      return new GameServerClusterName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GameServerClusterName) {
      GameServerClusterName that = (GameServerClusterName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.realm.equals(that.realm))
          && (this.gameServerCluster.equals(that.gameServerCluster));
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
    h ^= realm.hashCode();
    h *= 1000003;
    h ^= gameServerCluster.hashCode();
    return h;
  }
}
