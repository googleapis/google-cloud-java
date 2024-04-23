/*
 * Copyright 2024 Google LLC
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

package com.google.ads.admanager.v1;

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
public class TeamName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_TEAM =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/teams/{team}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String team;

  @Deprecated
  protected TeamName() {
    networkCode = null;
    team = null;
  }

  private TeamName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    team = Preconditions.checkNotNull(builder.getTeam());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getTeam() {
    return team;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TeamName of(String networkCode, String team) {
    return newBuilder().setNetworkCode(networkCode).setTeam(team).build();
  }

  public static String format(String networkCode, String team) {
    return newBuilder().setNetworkCode(networkCode).setTeam(team).build().toString();
  }

  public static TeamName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_TEAM.validatedMatch(
            formattedString, "TeamName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("team"));
  }

  public static List<TeamName> parseList(List<String> formattedStrings) {
    List<TeamName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TeamName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TeamName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_TEAM.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (team != null) {
            fieldMapBuilder.put("team", team);
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
    return NETWORK_CODE_TEAM.instantiate("network_code", networkCode, "team", team);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TeamName that = ((TeamName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.team, that.team);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(team);
    return h;
  }

  /** Builder for networks/{network_code}/teams/{team}. */
  public static class Builder {
    private String networkCode;
    private String team;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getTeam() {
      return team;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setTeam(String team) {
      this.team = team;
      return this;
    }

    private Builder(TeamName teamName) {
      this.networkCode = teamName.networkCode;
      this.team = teamName.team;
    }

    public TeamName build() {
      return new TeamName(this);
    }
  }
}
