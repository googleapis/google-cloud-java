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

package com.google.cloud.oslogin.common;

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
public class SshPublicKeyName implements ResourceName {
  private static final PathTemplate USER_FINGERPRINT =
      PathTemplate.createWithoutUrlEncoding("users/{user}/sshPublicKeys/{fingerprint}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String fingerprint;

  @Deprecated
  protected SshPublicKeyName() {
    user = null;
    fingerprint = null;
  }

  private SshPublicKeyName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    fingerprint = Preconditions.checkNotNull(builder.getFingerprint());
  }

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

  public static SshPublicKeyName of(String user, String fingerprint) {
    return newBuilder().setUser(user).setFingerprint(fingerprint).build();
  }

  public static String format(String user, String fingerprint) {
    return newBuilder().setUser(user).setFingerprint(fingerprint).build().toString();
  }

  public static SshPublicKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_FINGERPRINT.validatedMatch(
            formattedString, "SshPublicKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("fingerprint"));
  }

  public static List<SshPublicKeyName> parseList(List<String> formattedStrings) {
    List<SshPublicKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SshPublicKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SshPublicKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_FINGERPRINT.matches(formattedString);
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
          if (fingerprint != null) {
            fieldMapBuilder.put("fingerprint", fingerprint);
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
    return USER_FINGERPRINT.instantiate("user", user, "fingerprint", fingerprint);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SshPublicKeyName that = ((SshPublicKeyName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.fingerprint, that.fingerprint);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(fingerprint);
    return h;
  }

  /** Builder for users/{user}/sshPublicKeys/{fingerprint}. */
  public static class Builder {
    private String user;
    private String fingerprint;

    protected Builder() {}

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

    private Builder(SshPublicKeyName sshPublicKeyName) {
      user = sshPublicKeyName.user;
      fingerprint = sshPublicKeyName.fingerprint;
    }

    public SshPublicKeyName build() {
      return new SshPublicKeyName(this);
    }
  }
}
