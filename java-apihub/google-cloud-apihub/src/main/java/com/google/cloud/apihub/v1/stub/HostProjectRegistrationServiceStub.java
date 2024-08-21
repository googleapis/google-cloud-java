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

package com.google.cloud.apihub.v1.stub;

import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListHostProjectRegistrationsPagedResponse;
import static com.google.cloud.apihub.v1.HostProjectRegistrationServiceClient.ListLocationsPagedResponse;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.CreateHostProjectRegistrationRequest;
import com.google.cloud.apihub.v1.GetHostProjectRegistrationRequest;
import com.google.cloud.apihub.v1.HostProjectRegistration;
import com.google.cloud.apihub.v1.ListHostProjectRegistrationsRequest;
import com.google.cloud.apihub.v1.ListHostProjectRegistrationsResponse;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Base stub class for the HostProjectRegistrationService service API.
 *
 * <p>This class is for advanced usage and reflects the underlying API directly.
 */
@Generated("by gapic-generator-java")
public abstract class HostProjectRegistrationServiceStub implements BackgroundResource {

  public UnaryCallable<CreateHostProjectRegistrationRequest, HostProjectRegistration>
      createHostProjectRegistrationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: createHostProjectRegistrationCallable()");
  }

  public UnaryCallable<GetHostProjectRegistrationRequest, HostProjectRegistration>
      getHostProjectRegistrationCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: getHostProjectRegistrationCallable()");
  }

  public UnaryCallable<
          ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsPagedResponse>
      listHostProjectRegistrationsPagedCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHostProjectRegistrationsPagedCallable()");
  }

  public UnaryCallable<ListHostProjectRegistrationsRequest, ListHostProjectRegistrationsResponse>
      listHostProjectRegistrationsCallable() {
    throw new UnsupportedOperationException(
        "Not implemented: listHostProjectRegistrationsCallable()");
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
