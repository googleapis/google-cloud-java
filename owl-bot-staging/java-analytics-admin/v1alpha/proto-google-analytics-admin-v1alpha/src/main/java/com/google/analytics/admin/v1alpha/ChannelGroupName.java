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

package com.google.analytics.admin.v1alpha;

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
public class ChannelGroupName implements ResourceName {
  private static final PathTemplate PROPERTY_CHANNEL_GROUP =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/channelGroups/{channel_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String channelGroup;

  @Deprecated
  protected ChannelGroupName() {
    property = null;
    channelGroup = null;
  }

  private ChannelGroupName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    channelGroup = Preconditions.checkNotNull(builder.getChannelGroup());
  }

  public String getProperty() {
    return property;
  }

  public String getChannelGroup() {
    return channelGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ChannelGroupName of(String property, String channelGroup) {
    return newBuilder().setProperty(property).setChannelGroup(channelGroup).build();
  }

  public static String format(String property, String channelGroup) {
    return newBuilder().setProperty(property).setChannelGroup(channelGroup).build().toString();
  }

  public static ChannelGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_CHANNEL_GROUP.validatedMatch(
            formattedString, "ChannelGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("channel_group"));
  }

  public static List<ChannelGroupName> parseList(List<String> formattedStrings) {
    List<ChannelGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ChannelGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ChannelGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_CHANNEL_GROUP.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (channelGroup != null) {
            fieldMapBuilder.put("channel_group", channelGroup);
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
    return PROPERTY_CHANNEL_GROUP.instantiate("property", property, "channel_group", channelGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ChannelGroupName that = ((ChannelGroupName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.channelGroup, that.channelGroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(channelGroup);
    return h;
  }

  /** Builder for properties/{property}/channelGroups/{channel_group}. */
  public static class Builder {
    private String property;
    private String channelGroup;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getChannelGroup() {
      return channelGroup;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setChannelGroup(String channelGroup) {
      this.channelGroup = channelGroup;
      return this;
    }

    private Builder(ChannelGroupName channelGroupName) {
      this.property = channelGroupName.property;
      this.channelGroup = channelGroupName.channelGroup;
    }

    public ChannelGroupName build() {
      return new ChannelGroupName(this);
    }
  }
}
