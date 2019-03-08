/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.datastore;

import static com.google.datastore.v1.Value.GEO_POINT_VALUE_FIELD_NUMBER;

public final class LatLngValue extends Value<LatLng> {

  private static final long serialVersionUID = 565308388087634597L;

  static final BaseMarshaller<LatLng, LatLngValue, Builder> MARSHALLER =
      new BaseMarshaller<LatLng, LatLngValue, Builder>() {

        private static final long serialVersionUID = -5226207069346124222L;

        @Override
        public int getProtoFieldId() {
          return GEO_POINT_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(LatLng value) {
          return LatLngValue.newBuilder(value);
        }

        @Override
        protected LatLng getValue(com.google.datastore.v1.Value from) {
          return new LatLng(
              from.getGeoPointValue().getLatitude(), from.getGeoPointValue().getLongitude());
        }

        @Override
        protected void setValue(LatLngValue from, com.google.datastore.v1.Value.Builder to) {
          to.setGeoPointValue(from.get().toPb());
        }
      };

  public static final class Builder extends Value.BaseBuilder<LatLng, LatLngValue, Builder> {

    private Builder() {
      super(ValueType.LAT_LNG);
    }

    @Override
    public LatLngValue build() {
      return new LatLngValue(this);
    }
  }

  public LatLngValue(LatLng value) {
    this(newBuilder(value));
  }

  private LatLngValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static LatLngValue of(LatLng value) {
    return new LatLngValue(value);
  }

  public static Builder newBuilder(LatLng value) {
    return new Builder().set(value);
  }
}
