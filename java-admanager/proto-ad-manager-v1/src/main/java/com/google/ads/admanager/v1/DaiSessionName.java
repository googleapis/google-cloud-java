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

package com.google.ads.admanager.v1;

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
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class DaiSessionName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_DAI_SESSION =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/daiSessions/{dai_session}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String daiSession;

  @Deprecated
  protected DaiSessionName() {
    networkCode = null;
    daiSession = null;
  }

  private DaiSessionName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    daiSession = Preconditions.checkNotNull(builder.getDaiSession());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getDaiSession() {
    return daiSession;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DaiSessionName of(String networkCode, String daiSession) {
    return newBuilder().setNetworkCode(networkCode).setDaiSession(daiSession).build();
  }

  public static String format(String networkCode, String daiSession) {
    return newBuilder().setNetworkCode(networkCode).setDaiSession(daiSession).build().toString();
  }

  public static @Nullable DaiSessionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_DAI_SESSION.validatedMatch(
            formattedString, "DaiSessionName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("dai_session"));
  }

  public static List<DaiSessionName> parseList(List<String> formattedStrings) {
    List<DaiSessionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable DaiSessionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DaiSessionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_DAI_SESSION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (daiSession != null) {
            fieldMapBuilder.put("dai_session", daiSession);
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
    return NETWORK_CODE_DAI_SESSION.instantiate(
        "network_code", networkCode, "dai_session", daiSession);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DaiSessionName that = ((DaiSessionName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.daiSession, that.daiSession);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(daiSession);
    return h;
  }

  /** Builder for networks/{network_code}/daiSessions/{dai_session}. */
  public static class Builder {
    private String networkCode;
    private String daiSession;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getDaiSession() {
      return daiSession;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setDaiSession(String daiSession) {
      this.daiSession = daiSession;
      return this;
    }

    private Builder(DaiSessionName daiSessionName) {
      this.networkCode = daiSessionName.networkCode;
      this.daiSession = daiSessionName.daiSession;
    }

    public DaiSessionName build() {
      return new DaiSessionName(this);
    }
  }
}
