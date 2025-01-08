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
public class KeyEventName implements ResourceName {
  private static final PathTemplate PROPERTY_KEY_EVENT =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/keyEvents/{key_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String keyEvent;

  @Deprecated
  protected KeyEventName() {
    property = null;
    keyEvent = null;
  }

  private KeyEventName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    keyEvent = Preconditions.checkNotNull(builder.getKeyEvent());
  }

  public String getProperty() {
    return property;
  }

  public String getKeyEvent() {
    return keyEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static KeyEventName of(String property, String keyEvent) {
    return newBuilder().setProperty(property).setKeyEvent(keyEvent).build();
  }

  public static String format(String property, String keyEvent) {
    return newBuilder().setProperty(property).setKeyEvent(keyEvent).build().toString();
  }

  public static KeyEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_KEY_EVENT.validatedMatch(
            formattedString, "KeyEventName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("key_event"));
  }

  public static List<KeyEventName> parseList(List<String> formattedStrings) {
    List<KeyEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KeyEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (KeyEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_KEY_EVENT.matches(formattedString);
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
          if (keyEvent != null) {
            fieldMapBuilder.put("key_event", keyEvent);
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
    return PROPERTY_KEY_EVENT.instantiate("property", property, "key_event", keyEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      KeyEventName that = ((KeyEventName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.keyEvent, that.keyEvent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(keyEvent);
    return h;
  }

  /** Builder for properties/{property}/keyEvents/{key_event}. */
  public static class Builder {
    private String property;
    private String keyEvent;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getKeyEvent() {
      return keyEvent;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setKeyEvent(String keyEvent) {
      this.keyEvent = keyEvent;
      return this;
    }

    private Builder(KeyEventName keyEventName) {
      this.property = keyEventName.property;
      this.keyEvent = keyEventName.keyEvent;
    }

    public KeyEventName build() {
      return new KeyEventName(this);
    }
  }
}
