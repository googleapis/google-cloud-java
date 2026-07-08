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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class DataPointName implements ResourceName {
  private static final PathTemplate USER_DATA_TYPE_DATA_POINT =
      PathTemplate.createWithoutUrlEncoding(
          "users/{user}/dataTypes/{data_type}/dataPoints/{data_point}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String dataType;
  private final String dataPoint;

  @Deprecated
  protected DataPointName() {
    user = null;
    dataType = null;
    dataPoint = null;
  }

  private DataPointName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    dataType = Preconditions.checkNotNull(builder.getDataType());
    dataPoint = Preconditions.checkNotNull(builder.getDataPoint());
  }

  public String getUser() {
    return user;
  }

  public String getDataType() {
    return dataType;
  }

  public String getDataPoint() {
    return dataPoint;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DataPointName of(String user, String dataType, String dataPoint) {
    return newBuilder().setUser(user).setDataType(dataType).setDataPoint(dataPoint).build();
  }

  public static String format(String user, String dataType, String dataPoint) {
    return newBuilder()
        .setUser(user)
        .setDataType(dataType)
        .setDataPoint(dataPoint)
        .build()
        .toString();
  }

  public static DataPointName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_DATA_TYPE_DATA_POINT.validatedMatch(
            formattedString, "DataPointName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("data_type"), matchMap.get("data_point"));
  }

  public static List<DataPointName> parseList(List<String> formattedStrings) {
    List<DataPointName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DataPointName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DataPointName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_DATA_TYPE_DATA_POINT.matches(formattedString);
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
          if (dataPoint != null) {
            fieldMapBuilder.put("data_point", dataPoint);
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
    return USER_DATA_TYPE_DATA_POINT.instantiate(
        "user", user, "data_type", dataType, "data_point", dataPoint);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DataPointName that = ((DataPointName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.dataType, that.dataType)
          && Objects.equals(this.dataPoint, that.dataPoint);
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
    h *= 1000003;
    h ^= Objects.hashCode(dataPoint);
    return h;
  }

  /** Builder for users/{user}/dataTypes/{data_type}/dataPoints/{data_point}. */
  public static class Builder {
    private String user;
    private String dataType;
    private String dataPoint;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getDataType() {
      return dataType;
    }

    public String getDataPoint() {
      return dataPoint;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setDataType(String dataType) {
      this.dataType = dataType;
      return this;
    }

    public Builder setDataPoint(String dataPoint) {
      this.dataPoint = dataPoint;
      return this;
    }

    private Builder(DataPointName dataPointName) {
      this.user = dataPointName.user;
      this.dataType = dataPointName.dataType;
      this.dataPoint = dataPointName.dataPoint;
    }

    public DataPointName build() {
      return new DataPointName(this);
    }
  }
}
