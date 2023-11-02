/*
 * Copyright 2023 Google LLC
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

package google.maps.fleetengine.v1;

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
public class TripName implements ResourceName {
  private static final PathTemplate PROVIDER_TRIP =
      PathTemplate.createWithoutUrlEncoding("providers/{provider}/trips/{trip}");
  private volatile Map<String, String> fieldValuesMap;
  private final String provider;
  private final String trip;

  @Deprecated
  protected TripName() {
    provider = null;
    trip = null;
  }

  private TripName(Builder builder) {
    provider = Preconditions.checkNotNull(builder.getProvider());
    trip = Preconditions.checkNotNull(builder.getTrip());
  }

  public String getProvider() {
    return provider;
  }

  public String getTrip() {
    return trip;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TripName of(String provider, String trip) {
    return newBuilder().setProvider(provider).setTrip(trip).build();
  }

  public static String format(String provider, String trip) {
    return newBuilder().setProvider(provider).setTrip(trip).build().toString();
  }

  public static TripName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROVIDER_TRIP.validatedMatch(
            formattedString, "TripName.parse: formattedString not in valid format");
    return of(matchMap.get("provider"), matchMap.get("trip"));
  }

  public static List<TripName> parseList(List<String> formattedStrings) {
    List<TripName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TripName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TripName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROVIDER_TRIP.matches(formattedString);
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
          if (trip != null) {
            fieldMapBuilder.put("trip", trip);
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
    return PROVIDER_TRIP.instantiate("provider", provider, "trip", trip);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TripName that = ((TripName) o);
      return Objects.equals(this.provider, that.provider) && Objects.equals(this.trip, that.trip);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(provider);
    h *= 1000003;
    h ^= Objects.hashCode(trip);
    return h;
  }

  /** Builder for providers/{provider}/trips/{trip}. */
  public static class Builder {
    private String provider;
    private String trip;

    protected Builder() {}

    public String getProvider() {
      return provider;
    }

    public String getTrip() {
      return trip;
    }

    public Builder setProvider(String provider) {
      this.provider = provider;
      return this;
    }

    public Builder setTrip(String trip) {
      this.trip = trip;
      return this;
    }

    private Builder(TripName tripName) {
      this.provider = tripName.provider;
      this.trip = tripName.trip;
    }

    public TripName build() {
      return new TripName(this);
    }
  }
}
