/*
 * Copyright 2025 Google LLC
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
public class EventEditRuleName implements ResourceName {
  private static final PathTemplate PROPERTY_DATA_STREAM_EVENT_EDIT_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/dataStreams/{data_stream}/eventEditRules/{event_edit_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String dataStream;
  private final String eventEditRule;

  @Deprecated
  protected EventEditRuleName() {
    property = null;
    dataStream = null;
    eventEditRule = null;
  }

  private EventEditRuleName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    dataStream = Preconditions.checkNotNull(builder.getDataStream());
    eventEditRule = Preconditions.checkNotNull(builder.getEventEditRule());
  }

  public String getProperty() {
    return property;
  }

  public String getDataStream() {
    return dataStream;
  }

  public String getEventEditRule() {
    return eventEditRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EventEditRuleName of(String property, String dataStream, String eventEditRule) {
    return newBuilder()
        .setProperty(property)
        .setDataStream(dataStream)
        .setEventEditRule(eventEditRule)
        .build();
  }

  public static String format(String property, String dataStream, String eventEditRule) {
    return newBuilder()
        .setProperty(property)
        .setDataStream(dataStream)
        .setEventEditRule(eventEditRule)
        .build()
        .toString();
  }

  public static EventEditRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_DATA_STREAM_EVENT_EDIT_RULE.validatedMatch(
            formattedString, "EventEditRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("property"), matchMap.get("data_stream"), matchMap.get("event_edit_rule"));
  }

  public static List<EventEditRuleName> parseList(List<String> formattedStrings) {
    List<EventEditRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EventEditRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EventEditRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_DATA_STREAM_EVENT_EDIT_RULE.matches(formattedString);
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
          if (dataStream != null) {
            fieldMapBuilder.put("data_stream", dataStream);
          }
          if (eventEditRule != null) {
            fieldMapBuilder.put("event_edit_rule", eventEditRule);
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
    return PROPERTY_DATA_STREAM_EVENT_EDIT_RULE.instantiate(
        "property", property, "data_stream", dataStream, "event_edit_rule", eventEditRule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      EventEditRuleName that = ((EventEditRuleName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.dataStream, that.dataStream)
          && Objects.equals(this.eventEditRule, that.eventEditRule);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(dataStream);
    h *= 1000003;
    h ^= Objects.hashCode(eventEditRule);
    return h;
  }

  /**
   * Builder for properties/{property}/dataStreams/{data_stream}/eventEditRules/{event_edit_rule}.
   */
  public static class Builder {
    private String property;
    private String dataStream;
    private String eventEditRule;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getDataStream() {
      return dataStream;
    }

    public String getEventEditRule() {
      return eventEditRule;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setDataStream(String dataStream) {
      this.dataStream = dataStream;
      return this;
    }

    public Builder setEventEditRule(String eventEditRule) {
      this.eventEditRule = eventEditRule;
      return this;
    }

    private Builder(EventEditRuleName eventEditRuleName) {
      this.property = eventEditRuleName.property;
      this.dataStream = eventEditRuleName.dataStream;
      this.eventEditRule = eventEditRuleName.eventEditRule;
    }

    public EventEditRuleName build() {
      return new EventEditRuleName(this);
    }
  }
}
