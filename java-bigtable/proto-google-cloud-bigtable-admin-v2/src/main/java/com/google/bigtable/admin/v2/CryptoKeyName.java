/*
 * Copyright 2020 Google LLC
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

package com.google.bigtable.admin.v2;

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
  private static final PathTemplate PROJECT_LOCATION_KEY_RING_CRYPTO_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/keyRings/{key_ring}/cryptoKeys/{crypto_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String keyRing;
  private final String cryptoKey;

  @Deprecated
  protected CryptoKeyName() {
    project = null;
    location = null;
    keyRing = null;
    cryptoKey = null;
  }

  private CryptoKeyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    keyRing = Preconditions.checkNotNull(builder.getKeyRing());
    cryptoKey = Preconditions.checkNotNull(builder.getCryptoKey());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getKeyRing() {
    return keyRing;
  }

  public String getCryptoKey() {
    return cryptoKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CryptoKeyName of(
      String project, String location, String keyRing, String cryptoKey) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setCryptoKey(cryptoKey)
        .build();
  }

  public static String format(String project, String location, String keyRing, String cryptoKey) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setKeyRing(keyRing)
        .setCryptoKey(cryptoKey)
        .build()
        .toString();
  }

  public static CryptoKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_KEY_RING_CRYPTO_KEY.validatedMatch(
            formattedString, "CryptoKeyName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("key_ring"),
        matchMap.get("crypto_key"));
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
    return PROJECT_LOCATION_KEY_RING_CRYPTO_KEY.matches(formattedString);
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
          if (keyRing != null) {
            fieldMapBuilder.put("key_ring", keyRing);
          }
          if (cryptoKey != null) {
            fieldMapBuilder.put("crypto_key", cryptoKey);
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
    return PROJECT_LOCATION_KEY_RING_CRYPTO_KEY.instantiate(
        "project", project, "location", location, "key_ring", keyRing, "crypto_key", cryptoKey);
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
          && Objects.equals(this.keyRing, that.keyRing)
          && Objects.equals(this.cryptoKey, that.cryptoKey);
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
    h ^= Objects.hashCode(keyRing);
    h *= 1000003;
    h ^= Objects.hashCode(cryptoKey);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/keyRings/{key_ring}/cryptoKeys/{crypto_key}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String keyRing;
    private String cryptoKey;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getKeyRing() {
      return keyRing;
    }

    public String getCryptoKey() {
      return cryptoKey;
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

    public Builder setCryptoKey(String cryptoKey) {
      this.cryptoKey = cryptoKey;
      return this;
    }

    private Builder(CryptoKeyName cryptoKeyName) {
      project = cryptoKeyName.project;
      location = cryptoKeyName.location;
      keyRing = cryptoKeyName.keyRing;
      cryptoKey = cryptoKeyName.cryptoKey;
    }

    public CryptoKeyName build() {
      return new CryptoKeyName(this);
    }
  }
}
