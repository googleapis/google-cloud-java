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
public class DeliveryVehicleName implements ResourceName {
  private static final PathTemplate PROVIDER_VEHICLE =
      PathTemplate.createWithoutUrlEncoding("providers/{provider}/deliveryVehicles/{vehicle}");
  private volatile Map<String, String> fieldValuesMap;
  private final String provider;
  private final String vehicle;

  @Deprecated
  protected DeliveryVehicleName() {
    provider = null;
    vehicle = null;
  }

  private DeliveryVehicleName(Builder builder) {
    provider = Preconditions.checkNotNull(builder.getProvider());
    vehicle = Preconditions.checkNotNull(builder.getVehicle());
  }

  public String getProvider() {
    return provider;
  }

  public String getVehicle() {
    return vehicle;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeliveryVehicleName of(String provider, String vehicle) {
    return newBuilder().setProvider(provider).setVehicle(vehicle).build();
  }

  public static String format(String provider, String vehicle) {
    return newBuilder().setProvider(provider).setVehicle(vehicle).build().toString();
  }

  public static DeliveryVehicleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROVIDER_VEHICLE.validatedMatch(
            formattedString, "DeliveryVehicleName.parse: formattedString not in valid format");
    return of(matchMap.get("provider"), matchMap.get("vehicle"));
  }

  public static List<DeliveryVehicleName> parseList(List<String> formattedStrings) {
    List<DeliveryVehicleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeliveryVehicleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeliveryVehicleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROVIDER_VEHICLE.matches(formattedString);
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
          if (vehicle != null) {
            fieldMapBuilder.put("vehicle", vehicle);
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
    return PROVIDER_VEHICLE.instantiate("provider", provider, "vehicle", vehicle);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DeliveryVehicleName that = ((DeliveryVehicleName) o);
      return Objects.equals(this.provider, that.provider)
          && Objects.equals(this.vehicle, that.vehicle);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(provider);
    h *= 1000003;
    h ^= Objects.hashCode(vehicle);
    return h;
  }

  /** Builder for providers/{provider}/deliveryVehicles/{vehicle}. */
  public static class Builder {
    private String provider;
    private String vehicle;

    protected Builder() {}

    public String getProvider() {
      return provider;
    }

    public String getVehicle() {
      return vehicle;
    }

    public Builder setProvider(String provider) {
      this.provider = provider;
      return this;
    }

    public Builder setVehicle(String vehicle) {
      this.vehicle = vehicle;
      return this;
    }

    private Builder(DeliveryVehicleName deliveryVehicleName) {
      this.provider = deliveryVehicleName.provider;
      this.vehicle = deliveryVehicleName.vehicle;
    }

    public DeliveryVehicleName build() {
      return new DeliveryVehicleName(this);
    }
  }
}
