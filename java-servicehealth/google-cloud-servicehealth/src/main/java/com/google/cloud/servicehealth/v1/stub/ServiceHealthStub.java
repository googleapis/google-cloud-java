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

package com.google.cloud.servicehealth.v1.stub;

import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListLocationsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationEventsPagedResponse;
import static com.google.cloud.servicehealth.v1.ServiceHealthClient.ListOrganizationImpactsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.servicehealth.v1.Event;
import com.google.cloud.servicehealth.v1.GetEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationEventRequest;
import com.google.cloud.servicehealth.v1.GetOrganizationImpactRequest;
import com.google.cloud.servicehealth.v1.ListEventsRequest;
import com.google.cloud.servicehealth.v1.ListEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationEventsResponse;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsRequest;
import com.google.cloud.servicehealth.v1.ListOrganizationImpactsResponse;
import com.google.cloud.servicehealth.v1.OrganizationEvent;
import com.google.cloud.servicehealth.v1.OrganizationImpact;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the ServiceHealth service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class ServiceHealthStub implements BackgroundResource {

  public UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsPagedCallable()");
  }

  public UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listEventsCallable()");
  }

  public UnaryCallable<GetEventRequest, Event> getEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getEventCallable()");
  }

  public UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsPagedResponse>
      listOrganizationEventsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrganizationEventsPagedCallable()");
  }

  public UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrganizationEventsCallable()");
  }

  public UnaryCallable<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationEventCallable()");
  }

  public UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listOrganizationImpactsPagedCallable()");
  }

  public UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsCallable() {
    throw new UnsupportedOperationException("Not implemented: listOrganizationImpactsCallable()");
  }

  public UnaryCallable<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactCallable() {
    throw new UnsupportedOperationException("Not implemented: getOrganizationImpactCallable()");
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
