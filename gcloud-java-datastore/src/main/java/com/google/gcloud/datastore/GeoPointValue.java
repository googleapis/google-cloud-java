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

import static com.google.datastore.v1beta3.Value.GEO_POINT_VALUE_FIELD_NUMBER;

public final class GeoPointValue extends Value<GeoPoint> {

  private static final long serialVersionUID = -5810614280642405898L;

  static final BaseMarshaller<GeoPoint, GeoPointValue, Builder> MARSHALLER =
      new BaseMarshaller<GeoPoint, GeoPointValue, Builder>() {

        private static final long serialVersionUID = -3550567536035178649L;

        @Override
        public int getProtoFieldId() {
          return GEO_POINT_VALUE_FIELD_NUMBER;
        }

        @Override
        public Builder newBuilder(GeoPoint value) {
          return builder(value);
        }

        @Override
        protected GeoPoint getValue(com.google.datastore.v1beta3.Value from) {
          return new GeoPoint(
              from.getGeoPointValue().getLatitude(), from.getGeoPointValue().getLongitude());
        }

        @Override
        protected void setValue(GeoPointValue from, com.google.datastore.v1beta3.Value.Builder to) {
          to.setGeoPointValue(from.get().toPb());
        }
      };

  public static final class Builder extends Value.BaseBuilder<GeoPoint, GeoPointValue, Builder> {

    private Builder() {
      super(ValueType.GEO_POINT);
    }

    @Override
    public GeoPointValue build() {
      return new GeoPointValue(this);
    }
  }

  public GeoPointValue(GeoPoint value) {
    this(builder(value));
  }

  private GeoPointValue(Builder builder) {
    super(builder);
  }

  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  public static GeoPointValue of(GeoPoint value) {
    return new GeoPointValue(value);
  }

  public static Builder builder(GeoPoint value) {
    return new Builder().set(value);
  }
}
