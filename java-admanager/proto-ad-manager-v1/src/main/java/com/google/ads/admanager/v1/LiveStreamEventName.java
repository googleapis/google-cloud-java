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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class LiveStreamEventName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_LIVE_STREAM_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/liveStreamEvents/{live_stream_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String liveStreamEvent;

  @Deprecated
  protected LiveStreamEventName() {
    networkCode = null;
    liveStreamEvent = null;
  }

  private LiveStreamEventName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    liveStreamEvent = Preconditions.checkNotNull(builder.getLiveStreamEvent());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getLiveStreamEvent() {
    return liveStreamEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LiveStreamEventName of(String networkCode, String liveStreamEvent) {
    return newBuilder().setNetworkCode(networkCode).setLiveStreamEvent(liveStreamEvent).build();
  }

  public static String format(String networkCode, String liveStreamEvent) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setLiveStreamEvent(liveStreamEvent)
        .build()
        .toString();
  }

  public static LiveStreamEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_LIVE_STREAM_EVENT.validatedMatch(
            formattedString, "LiveStreamEventName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("live_stream_event"));
  }

  public static List<LiveStreamEventName> parseList(List<String> formattedStrings) {
    List<LiveStreamEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LiveStreamEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LiveStreamEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_LIVE_STREAM_EVENT.matches(formattedString);
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
          if (liveStreamEvent != null) {
            fieldMapBuilder.put("live_stream_event", liveStreamEvent);
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
    return NETWORK_CODE_LIVE_STREAM_EVENT.instantiate(
        "network_code", networkCode, "live_stream_event", liveStreamEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LiveStreamEventName that = ((LiveStreamEventName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.liveStreamEvent, that.liveStreamEvent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(liveStreamEvent);
    return h;
  }

  /** Builder for networks/{network_code}/liveStreamEvents/{live_stream_event}. */
  public static class Builder {
    private String networkCode;
    private String liveStreamEvent;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getLiveStreamEvent() {
      return liveStreamEvent;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setLiveStreamEvent(String liveStreamEvent) {
      this.liveStreamEvent = liveStreamEvent;
      return this;
    }

    private Builder(LiveStreamEventName liveStreamEventName) {
      this.networkCode = liveStreamEventName.networkCode;
      this.liveStreamEvent = liveStreamEventName.liveStreamEvent;
    }

    public LiveStreamEventName build() {
      return new LiveStreamEventName(this);
    }
  }
}
