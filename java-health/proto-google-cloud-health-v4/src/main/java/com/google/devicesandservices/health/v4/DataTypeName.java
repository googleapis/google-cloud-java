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

package com.google.devicesandservices.health.v4;

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
public class DataTypeName implements ResourceName {
  private static final PathTemplate USER_DATA_TYPE =
      PathTemplate.createWithoutUrlEncoding("users/{user}/dataTypes/{data_type}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String dataType;

  @Deprecated
  protected DataTypeName() {
    user = null;
    dataType = null;
  }

  private DataTypeName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    dataType = Preconditions.checkNotNull(builder.getDataType());
  }

  public String getUser() {
    return user;
  }

  public String getDataType() {
    return dataType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataTypeName of(String user, String dataType) {
    return newBuilder().setUser(user).setDataType(dataType).build();
  }

  public static String format(String user, String dataType) {
    return newBuilder().setUser(user).setDataType(dataType).build().toString();
  }

  public static DataTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_DATA_TYPE.validatedMatch(
            formattedString, "DataTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("data_type"));
  }

  public static List<DataTypeName> parseList(List<String> formattedStrings) {
    List<DataTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataTypeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_DATA_TYPE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (dataType != null) {
            fieldMapBuilder.put("data_type", dataType);
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
    return USER_DATA_TYPE.instantiate("user", user, "data_type", dataType);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataTypeName that = ((DataTypeName) o);
      return Objects.equals(this.user, that.user) && Objects.equals(this.dataType, that.dataType);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(dataType);
    return h;
  }

  /** Builder for users/{user}/dataTypes/{data_type}. */
  public static class Builder {
    private String user;
    private String dataType;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getDataType() {
      return dataType;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setDataType(String dataType) {
      this.dataType = dataType;
      return this;
    }

    private Builder(DataTypeName dataTypeName) {
      this.user = dataTypeName.user;
      this.dataType = dataTypeName.dataType;
    }

    public DataTypeName build() {
      return new DataTypeName(this);
    }
  }
}
