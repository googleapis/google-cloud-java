/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.kms.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class CryptoKeyPathName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/keyRings/{key_ring}/cryptoKeys/{crypto_key_path=**}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String location;
  private final String keyRing;
  private final String cryptoKeyPath;

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKeyRing() {
    return keyRing;
  }

  public String getCryptoKeyPath() {
    return cryptoKeyPath;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private CryptoKeyPathName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    keyRing = Preconditions.checkNotNull(builder.getKeyRing());
    cryptoKeyPath = Preconditions.checkNotNull(builder.getCryptoKeyPath());
  }

  public static CryptoKeyPathName of(
      String project, String location, String keyRing, String cryptoKeyPath) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setCryptoKeyPath(cryptoKeyPath)
        .build();
  }

  public static String format(
      String project, String location, String keyRing, String cryptoKeyPath) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setCryptoKeyPath(cryptoKeyPath)
        .build()
        .toString();
  }

  public static CryptoKeyPathName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "CryptoKeyPathName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("key_ring"),
        matchMap.get("crypto_key_path"));
  }

  public static List<CryptoKeyPathName> parseList(List<String> formattedStrings) {
    List<CryptoKeyPathName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CryptoKeyPathName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (CryptoKeyPathName value : values) {
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
          fieldMapBuilder.put("cryptoKeyPath", cryptoKeyPath);
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
        "key_ring",
        keyRing,
        "crypto_key_path",
        cryptoKeyPath);
  }

  /** Builder for CryptoKeyPathName. */
  public static class Builder {

    private String project;
    private String location;
    private String keyRing;
    private String cryptoKeyPath;

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKeyRing() {
      return keyRing;
    }

    public String getCryptoKeyPath() {
      return cryptoKeyPath;
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

    public Builder setCryptoKeyPath(String cryptoKeyPath) {
      this.cryptoKeyPath = cryptoKeyPath;
      return this;
    }

    private Builder() {}

    private Builder(CryptoKeyPathName cryptoKeyPathName) {
      project = cryptoKeyPathName.project;
      location = cryptoKeyPathName.location;
      keyRing = cryptoKeyPathName.keyRing;
      cryptoKeyPath = cryptoKeyPathName.cryptoKeyPath;
    }

    public CryptoKeyPathName build() {
      return new CryptoKeyPathName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CryptoKeyPathName) {
      CryptoKeyPathName that = (CryptoKeyPathName) o;
      return (this.project.equals(that.project))
          && (this.location.equals(that.location))
          && (this.keyRing.equals(that.keyRing))
          && (this.cryptoKeyPath.equals(that.cryptoKeyPath));
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
    h *= 1000003;
    h ^= cryptoKeyPath.hashCode();
    return h;
  }
}
