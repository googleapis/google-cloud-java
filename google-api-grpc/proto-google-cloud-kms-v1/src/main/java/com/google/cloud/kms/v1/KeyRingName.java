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

package com.google.cloud.kms.v1;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class KeyRingName extends KeyName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/keyRings/{key_ring}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String keyRing;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKeyRing() {
    return keyRing;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private KeyRingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    keyRing = Preconditions.checkNotNull(builder.getKeyRing());
  }

  public static KeyRingName of(String project, String location, String keyRing) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setKeyRing(keyRing)
      .build();
  }

  public static String format(String project, String location, String keyRing) {
    return newBuilder()
      .setProject(project)
      .setLocation(location)
      .setKeyRing(keyRing)
      .build()
      .toString();
  }

  public static KeyRingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "KeyRingName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("key_ring"));
  }

  public static List<KeyRingName> parseList(List<String> formattedStrings) {
    List<KeyRingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KeyRingName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (KeyRingName value : values) {
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
          fieldMapBuilder.put("keyRing", keyRing);
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
    return PATH_TEMPLATE.instantiate("project", project, "location", location, "key_ring", keyRing);
  }

  /** Builder for KeyRingName. */
  public static class Builder {

    private String project;
    private String location;
    private String keyRing;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKeyRing() {
      return keyRing;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setKeyRing(String keyRing) {
      this.keyRing = keyRing;
      return this;
    }

    private Builder() {
    }

    private Builder(KeyRingName keyRingName) {
      project = keyRingName.project;
      location = keyRingName.location;
      keyRing = keyRingName.keyRing;
    }

    public KeyRingName build() {
      return new KeyRingName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof KeyRingName) {
      KeyRingName that = (KeyRingName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.keyRing.equals(that.keyRing));
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
    h ^= keyRing.hashCode();
    return h;
  }
}

