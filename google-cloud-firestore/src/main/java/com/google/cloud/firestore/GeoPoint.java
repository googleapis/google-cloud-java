/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.firestore;

import com.google.common.base.Preconditions;
import com.google.type.LatLng;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/** Immutable class representing a geographic location in Firestore */
public class GeoPoint implements Serializable {

  private static final long serialVersionUID = 7871890086202168339L;
  private final double latitude;
  private final double longitude;

  /**
   * Construct a new GeoPoint using the provided latitude and longitude values.
   *
   * @param latitude The latitude of this GeoPoint in the range [-90, 90].
   * @param longitude The longitude of this GeoPoint in the range [-180, 180].
   */
  public GeoPoint(double latitude, double longitude) {
    Preconditions.checkArgument(
        latitude >= -90 && latitude <= 90, "Latitude must be in the range of [-90, 90] degrees");
    Preconditions.checkArgument(
        longitude >= -180 && longitude <= 180,
        "Longitude must be in the range of [-180, 180] degrees");

    this.latitude = latitude;
    this.longitude = longitude;
  }

  /**
   * Returns the latitude.
   *
   * @return The latitude value of this GeoPoint.
   */
  public double getLatitude() {
    return this.latitude;
  }

  /**
   * Returns the longitude.
   *
   * @return The longitude value of this GeoPoint.
   */
  public double getLongitude() {
    return this.longitude;
  }

  LatLng toProto() {
    LatLng.Builder latLngBuilder = LatLng.newBuilder();
    latLngBuilder.setLatitude(latitude);
    latLngBuilder.setLongitude(longitude);
    return latLngBuilder.build();
  }

  @Nonnull
  @Override
  public String toString() {
    return "GeoPoint { latitude=" + this.latitude + ", longitude=" + this.longitude + " }";
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeoPoint geoPoint = (GeoPoint) o;
    return Double.compare(geoPoint.latitude, latitude) == 0
        && Double.compare(geoPoint.longitude, longitude) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }
}
