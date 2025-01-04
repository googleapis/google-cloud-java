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

package com.google.maps.fleetengine.v1.stub;

import static com.google.maps.fleetengine.v1.TripServiceClient.SearchTripsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.maps.fleetengine.v1.CreateTripRequest;
import com.google.maps.fleetengine.v1.GetTripRequest;
import com.google.maps.fleetengine.v1.ReportBillableTripRequest;
import com.google.maps.fleetengine.v1.SearchTripsRequest;
import com.google.maps.fleetengine.v1.SearchTripsResponse;
import com.google.maps.fleetengine.v1.Trip;
import com.google.maps.fleetengine.v1.UpdateTripRequest;
import com.google.protobuf.Empty;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the TripService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class TripServiceStub implements BackgroundResource {

  public UnaryCallable<CreateTripRequest, Trip> createTripCallable() {
    throw new UnsupportedOperationException("Not implemented: createTripCallable()");
  }

  public UnaryCallable<GetTripRequest, Trip> getTripCallable() {
    throw new UnsupportedOperationException("Not implemented: getTripCallable()");
  }

  public UnaryCallable<ReportBillableTripRequest, Empty> reportBillableTripCallable() {
    throw new UnsupportedOperationException("Not implemented: reportBillableTripCallable()");
  }

  public UnaryCallable<SearchTripsRequest, SearchTripsPagedResponse> searchTripsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: searchTripsPagedCallable()");
  }

  public UnaryCallable<SearchTripsRequest, SearchTripsResponse> searchTripsCallable() {
    throw new UnsupportedOperationException("Not implemented: searchTripsCallable()");
  }

  public UnaryCallable<UpdateTripRequest, Trip> updateTripCallable() {
    throw new UnsupportedOperationException("Not implemented: updateTripCallable()");
  }

  @Override
  public abstract void close();
}
