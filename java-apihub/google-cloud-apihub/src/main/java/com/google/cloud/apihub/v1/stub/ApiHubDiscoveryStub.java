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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiObservationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListDiscoveredApiOperationsPagedResponse;
import static com.google.cloud.apihub.v1.ApiHubDiscoveryClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.DiscoveredApiObservation;
import com.google.cloud.apihub.v1.DiscoveredApiOperation;
import com.google.cloud.apihub.v1.GetDiscoveredApiObservationRequest;
import com.google.cloud.apihub.v1.GetDiscoveredApiOperationRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiObservationsResponse;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsRequest;
import com.google.cloud.apihub.v1.ListDiscoveredApiOperationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ApiHubDiscovery service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ApiHubDiscoveryStub implements BackgroundResource {

  public UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredApiObservationsPagedCallable()");
  }

  public UnaryCallable<ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
      listDiscoveredApiObservationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredApiObservationsCallable()");
  }

  public UnaryCallable<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getDiscoveredApiObservationCallable()");
  }

  public UnaryCallable<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredApiOperationsPagedCallable()");
  }

  public UnaryCallable<ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
      listDiscoveredApiOperationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listDiscoveredApiOperationsCallable()");
  }

  public UnaryCallable<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationCallable() {
    throw new UnsupportedOperationException("Not implemented: getDiscoveredApiOperationCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsPagedCallable()");
  }

  public UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    throw new UnsupportedOperationException("Not implemented: listLocationsCallable()");
  }

  public UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    throw new UnsupportedOperationException("Not implemented: getLocationCallable()");
  }

  @Override
  public abstract void close();
}
