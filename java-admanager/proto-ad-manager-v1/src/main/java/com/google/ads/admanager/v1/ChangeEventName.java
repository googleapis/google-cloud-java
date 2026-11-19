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
public class ChangeEventName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CHANGE_EVENT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/changeEvents/{change_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String changeEvent;

  @Deprecated
  protected ChangeEventName() {
    networkCode = null;
    changeEvent = null;
  }

  private ChangeEventName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    changeEvent = Preconditions.checkNotNull(builder.getChangeEvent());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getChangeEvent() {
    return changeEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ChangeEventName of(String networkCode, String changeEvent) {
    return newBuilder().setNetworkCode(networkCode).setChangeEvent(changeEvent).build();
  }

  public static String format(String networkCode, String changeEvent) {
    return newBuilder().setNetworkCode(networkCode).setChangeEvent(changeEvent).build().toString();
  }

  public static @Nullable ChangeEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CHANGE_EVENT.validatedMatch(
            formattedString, "ChangeEventName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("change_event"));
  }

  public static List<ChangeEventName> parseList(List<String> formattedStrings) {
    List<ChangeEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable ChangeEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ChangeEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CHANGE_EVENT.matches(formattedString);
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
          if (changeEvent != null) {
            fieldMapBuilder.put("change_event", changeEvent);
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
    return NETWORK_CODE_CHANGE_EVENT.instantiate(
        "network_code", networkCode, "change_event", changeEvent);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ChangeEventName that = ((ChangeEventName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.changeEvent, that.changeEvent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(changeEvent);
    return h;
  }

  /** Builder for networks/{network_code}/changeEvents/{change_event}. */
  public static class Builder {
    private String networkCode;
    private String changeEvent;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getChangeEvent() {
      return changeEvent;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setChangeEvent(String changeEvent) {
      this.changeEvent = changeEvent;
      return this;
    }

    private Builder(ChangeEventName changeEventName) {
      this.networkCode = changeEventName.networkCode;
      this.changeEvent = changeEventName.changeEvent;
    }

    public ChangeEventName build() {
      return new ChangeEventName(this);
    }
  }
}
