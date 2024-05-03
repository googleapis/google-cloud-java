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
public class UserName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_USER =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/users/{user}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String user;

  @Deprecated
  protected UserName() {
    networkCode = null;
    user = null;
  }

  private UserName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    user = Preconditions.checkNotNull(builder.getUser());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getUser() {
    return user;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserName of(String networkCode, String user) {
    return newBuilder().setNetworkCode(networkCode).setUser(user).build();
  }

  public static String format(String networkCode, String user) {
    return newBuilder().setNetworkCode(networkCode).setUser(user).build().toString();
  }

  public static UserName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_USER.validatedMatch(
            formattedString, "UserName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("user"));
  }

  public static List<UserName> parseList(List<String> formattedStrings) {
    List<UserName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<UserName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_USER.matches(formattedString);
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
          if (user != null) {
            fieldMapBuilder.put("user", user);
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
    return NETWORK_CODE_USER.instantiate("network_code", networkCode, "user", user);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserName that = ((UserName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.user, that.user);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(user);
    return h;
  }

  /** Builder for networks/{network_code}/users/{user}. */
  public static class Builder {
    private String networkCode;
    private String user;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getUser() {
      return user;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    private Builder(UserName userName) {
      this.networkCode = userName.networkCode;
      this.user = userName.user;
    }

    public UserName build() {
      return new UserName(this);
    }
  }
}
