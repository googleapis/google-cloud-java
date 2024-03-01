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

package com.google.maps.places.v1.stub;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.places.v1.AutocompletePlacesRequest;
import com.google.maps.places.v1.AutocompletePlacesResponse;
import com.google.maps.places.v1.GetPhotoMediaRequest;
import com.google.maps.places.v1.GetPlaceRequest;
import com.google.maps.places.v1.PhotoMedia;
import com.google.maps.places.v1.Place;
import com.google.maps.places.v1.SearchNearbyRequest;
import com.google.maps.places.v1.SearchNearbyResponse;
import com.google.maps.places.v1.SearchTextRequest;
import com.google.maps.places.v1.SearchTextResponse;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the Places service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class PlacesStub implements BackgroundResource {

  public UnaryCallable<SearchNearbyRequest, SearchNearbyResponse> searchNearbyCallable() {
    throw new UnsupportedOperationException("Not implemented: searchNearbyCallable()");
  }

  public UnaryCallable<SearchTextRequest, SearchTextResponse> searchTextCallable() {
    throw new UnsupportedOperationException("Not implemented: searchTextCallable()");
  }

  public UnaryCallable<GetPhotoMediaRequest, PhotoMedia> getPhotoMediaCallable() {
    throw new UnsupportedOperationException("Not implemented: getPhotoMediaCallable()");
  }

  public UnaryCallable<GetPlaceRequest, Place> getPlaceCallable() {
    throw new UnsupportedOperationException("Not implemented: getPlaceCallable()");
  }

  public UnaryCallable<AutocompletePlacesRequest, AutocompletePlacesResponse>
      autocompletePlacesCallable() {
    throw new UnsupportedOperationException("Not implemented: autocompletePlacesCallable()");
  }

  @Override
  public abstract void close();
}
