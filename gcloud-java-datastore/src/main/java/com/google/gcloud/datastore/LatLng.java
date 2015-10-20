/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.protobuf.InvalidProtocolBufferException;

import java.util.Objects;

/**
 * A Google Cloud Datastore LatLng (represented by latitude and longitude in degrees).
 * This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public final class LatLng extends Serializable<com.google.type.LatLng> {

  private static final long serialVersionUID = 9077060962655752073L;

  private final transient double latitude;
  private final transient double longitude;

  LatLng(double latitude, double longitude) {
    checkArgument(
        latitude >= -90.0 && latitude <= 90.0, "latitude must be in the range [-90, 90] degrees");
    checkArgument(
        longitude >= -180.0 && longitude <= 180.0,
        "latitude must be in the range [-180, 180] degrees");
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public double latitude() {
    return latitude;
  }

  public double longitude() {
    return longitude;
  }

  @Override
  public String toString() {
    return Double.toString(latitude) + ", " + Double.toString(longitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(latitude, longitude);
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || (obj instanceof LatLng && this.latitude == ((LatLng) obj).latitude
               && this.longitude == ((LatLng) obj).longitude);
  }

  public static LatLng of(double latitude, double longitude) {
    return new LatLng(latitude, longitude);
  }

  @Override
  protected com.google.type.LatLng toPb() {
    return com.google.type.LatLng.newBuilder()
        .setLatitude(latitude)
        .setLongitude(longitude)
        .build();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    com.google.type.LatLng parsedLatLng = com.google.type.LatLng.parseFrom(bytesPb);
    return new LatLng(parsedLatLng.getLatitude(), parsedLatLng.getLongitude());
  }
}
