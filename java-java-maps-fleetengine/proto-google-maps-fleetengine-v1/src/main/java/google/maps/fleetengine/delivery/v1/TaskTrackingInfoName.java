/*
 * Copyright 2024 Google LLC
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

package google.maps.fleetengine.delivery.v1;

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
public class TaskTrackingInfoName implements ResourceName {
  private static final PathTemplate PROVIDER_TRACKING =
      PathTemplate.createWithoutUrlEncoding("providers/{provider}/taskTrackingInfo/{tracking}");
  private volatile Map<String, String> fieldValuesMap;
  private final String provider;
  private final String tracking;

  @Deprecated
  protected TaskTrackingInfoName() {
    provider = null;
    tracking = null;
  }

  private TaskTrackingInfoName(Builder builder) {
    provider = Preconditions.checkNotNull(builder.getProvider());
    tracking = Preconditions.checkNotNull(builder.getTracking());
  }

  public String getProvider() {
    return provider;
  }

  public String getTracking() {
    return tracking;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TaskTrackingInfoName of(String provider, String tracking) {
    return newBuilder().setProvider(provider).setTracking(tracking).build();
  }

  public static String format(String provider, String tracking) {
    return newBuilder().setProvider(provider).setTracking(tracking).build().toString();
  }

  public static TaskTrackingInfoName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROVIDER_TRACKING.validatedMatch(
            formattedString, "TaskTrackingInfoName.parse: formattedString not in valid format");
    return of(matchMap.get("provider"), matchMap.get("tracking"));
  }

  public static List<TaskTrackingInfoName> parseList(List<String> formattedStrings) {
    List<TaskTrackingInfoName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TaskTrackingInfoName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TaskTrackingInfoName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROVIDER_TRACKING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (provider != null) {
            fieldMapBuilder.put("provider", provider);
          }
          if (tracking != null) {
            fieldMapBuilder.put("tracking", tracking);
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
    return PROVIDER_TRACKING.instantiate("provider", provider, "tracking", tracking);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TaskTrackingInfoName that = ((TaskTrackingInfoName) o);
      return Objects.equals(this.provider, that.provider)
          && Objects.equals(this.tracking, that.tracking);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(provider);
    h *= 1000003;
    h ^= Objects.hashCode(tracking);
    return h;
  }

  /** Builder for providers/{provider}/taskTrackingInfo/{tracking}. */
  public static class Builder {
    private String provider;
    private String tracking;

    protected Builder() {}

    public String getProvider() {
      return provider;
    }

    public String getTracking() {
      return tracking;
    }

    public Builder setProvider(String provider) {
      this.provider = provider;
      return this;
    }

    public Builder setTracking(String tracking) {
      this.tracking = tracking;
      return this;
    }

    private Builder(TaskTrackingInfoName taskTrackingInfoName) {
      this.provider = taskTrackingInfoName.provider;
      this.tracking = taskTrackingInfoName.tracking;
    }

    public TaskTrackingInfoName build() {
      return new TaskTrackingInfoName(this);
    }
  }
}
