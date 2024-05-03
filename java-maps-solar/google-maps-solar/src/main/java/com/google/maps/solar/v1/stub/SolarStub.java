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

package com.google.maps.solar.v1.stub;

import com.google.api.HttpBody;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.solar.v1.BuildingInsights;
import com.google.maps.solar.v1.DataLayers;
import com.google.maps.solar.v1.FindClosestBuildingInsightsRequest;
import com.google.maps.solar.v1.GetDataLayersRequest;
import com.google.maps.solar.v1.GetGeoTiffRequest;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Solar service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class SolarStub implements BackgroundResource {

  public UnaryCallable<FindClosestBuildingInsightsRequest, BuildingInsights>
      findClosestBuildingInsightsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: findClosestBuildingInsightsCallable()");
  }

  public UnaryCallable<GetDataLayersRequest, DataLayers> getDataLayersCallable() {
    throw new UnsupportedOperationException("Not implemented: getDataLayersCallable()");
  }

  public UnaryCallable<GetGeoTiffRequest, HttpBody> getGeoTiffCallable() {
    throw new UnsupportedOperationException("Not implemented: getGeoTiffCallable()");
  }

  @Override
  public abstract void close();
}
