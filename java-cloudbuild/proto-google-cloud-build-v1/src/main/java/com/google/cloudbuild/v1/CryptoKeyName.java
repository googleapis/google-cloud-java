/*
 * Copyright 2021 Google LLC
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

package com.google.cloudbuild.v1;

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
public class CryptoKeyName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_KEYRING_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/keyRings/{keyring}/cryptoKeys/{key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String keyring;
  private final String key;

  @Deprecated
  protected CryptoKeyName() {
    project = null;
    location = null;
    keyring = null;
    key = null;
  }

  private CryptoKeyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    keyring = Preconditions.checkNotNull(builder.getKeyring());
    key = Preconditions.checkNotNull(builder.getKey());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKeyring() {
    return keyring;
  }

  public String getKey() {
    return key;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CryptoKeyName of(String project, String location, String keyring, String key) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyring(keyring)
        .setKey(key)
        .build();
  }

  public static String format(String project, String location, String keyring, String key) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyring(keyring)
        .setKey(key)
        .build()
        .toString();
  }

  public static CryptoKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_KEYRING_KEY.validatedMatch(
            formattedString, "CryptoKeyName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("keyring"),
        matchMap.get("key"));
  }

  public static List<CryptoKeyName> parseList(List<String> formattedStrings) {
    List<CryptoKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CryptoKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CryptoKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_KEYRING_KEY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (keyring != null) {
            fieldMapBuilder.put("keyring", keyring);
          }
          if (key != null) {
            fieldMapBuilder.put("key", key);
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
    return PROJECT_LOCATION_KEYRING_KEY.instantiate(
        "project", project, "location", location, "keyring", keyring, "key", key);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CryptoKeyName that = ((CryptoKeyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.keyring, that.keyring)
          && Objects.equals(this.key, that.key);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(keyring);
    h *= 1000003;
    h ^= Objects.hashCode(key);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/keyRings/{keyring}/cryptoKeys/{key}. */
  public static class Builder {
    private String project;
    private String location;
    private String keyring;
    private String key;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKeyring() {
      return keyring;
    }

    public String getKey() {
      return key;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setKeyring(String keyring) {
      this.keyring = keyring;
      return this;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    private Builder(CryptoKeyName cryptoKeyName) {
      project = cryptoKeyName.project;
      location = cryptoKeyName.location;
      keyring = cryptoKeyName.keyring;
      key = cryptoKeyName.key;
    }

    public CryptoKeyName build() {
      return new CryptoKeyName(this);
    }
  }
}
