/*
 * Copyright 2019 Google LLC
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

package com.google.cloud.oslogin.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class FingerprintName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("users/{user}/sshPublicKeys/{fingerprint}");

  private volatile Map<String, String> fieldValuesMap;

  private final String user;
  private final String fingerprint;

  public String getUser() {
    return user;
  }

  public String getFingerprint() {
    return fingerprint;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private FingerprintName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    fingerprint = Preconditions.checkNotNull(builder.getFingerprint());
  }

  public static FingerprintName of(String user, String fingerprint) {
    return newBuilder().setUser(user).setFingerprint(fingerprint).build();
  }

  public static String format(String user, String fingerprint) {
    return newBuilder().setUser(user).setFingerprint(fingerprint).build().toString();
  }

  public static FingerprintName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "FingerprintName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("fingerprint"));
  }

  public static List<FingerprintName> parseList(List<String> formattedStrings) {
    List<FingerprintName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<FingerprintName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (FingerprintName value : values) {
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
          fieldMapBuilder.put("user", user);
          fieldMapBuilder.put("fingerprint", fingerprint);
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
    return PATH_TEMPLATE.instantiate("user", user, "fingerprint", fingerprint);
  }

  /** Builder for FingerprintName. */
  public static class Builder {

    private String user;
    private String fingerprint;

    public String getUser() {
      return user;
    }

    public String getFingerprint() {
      return fingerprint;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setFingerprint(String fingerprint) {
      this.fingerprint = fingerprint;
      return this;
    }

    private Builder() {}

    private Builder(FingerprintName fingerprintName) {
      user = fingerprintName.user;
      fingerprint = fingerprintName.fingerprint;
    }

    public FingerprintName build() {
      return new FingerprintName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof FingerprintName) {
      FingerprintName that = (FingerprintName) o;
      return (this.user.equals(that.user)) && (this.fingerprint.equals(that.fingerprint));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= user.hashCode();
    h *= 1000003;
    h ^= fingerprint.hashCode();
    return h;
  }
}
